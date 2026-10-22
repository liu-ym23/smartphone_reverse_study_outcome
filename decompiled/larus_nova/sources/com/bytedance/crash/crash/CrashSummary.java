package com.bytedance.crash.crash;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.dumper.MemoryInfo;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.crash.dumper.k;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.general.AppInfo;
import com.bytedance.crash.general.HardwareInfo;
import com.bytedance.crash.general.RomInfo;
import com.bytedance.crash.i;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.m;
import com.bytedance.crash.m0;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.n;
import com.bytedance.crash.util.h;
import com.bytedance.crash.util.j;
import com.bytedance.crash.util.p;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.services.apm.api.IApmAgent;
import com.ss.android.lark.inv.export.router.InvRouter;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public abstract class CrashSummary implements Comparable {
    protected static final String SUFFIX = ".summary";
    private static final String UPLOAD_STATE = "upload_state.inf";
    protected final long mCrashTime;
    protected final CrashType mCrashType;
    protected final File mDirectory;
    protected final int mPid;
    protected final String mProcessName;
    protected String mStackTrace;
    protected final long mStartTime;
    protected final String mThreadName;
    protected final int mTid;
    protected final long sAppStartUpTime;

    /* JADX INFO: loaded from: classes15.dex */
    public static class a implements FilenameFilter {
        public a() {
        }

        @Override // java.io.FilenameFilter
        public final boolean accept(File r100, String r101) {
            return r101.endsWith(CrashSummary.SUFFIX);
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static class b implements Comparator<CrashSummary> {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(CrashSummary r100, CrashSummary r101) {
            CrashSummary r102 = r101;
            return r102.compareTo(r100);
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static class c implements FilenameFilter {
        public c() {
        }

        @Override // java.io.FilenameFilter
        public final boolean accept(File r100, String r101) {
            return r101.endsWith(CrashSummary.SUFFIX);
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static class d implements Comparator<CrashSummary> {
        public d() {
        }

        @Override // java.util.Comparator
        public final int compare(CrashSummary r100, CrashSummary r101) {
            CrashSummary r102 = r101;
            return r102.compareTo(r100);
        }
    }

    public abstract void appendSpecialFilter(JSONObject r100);

    public abstract void assemblySpecialCrashBody(eh4.a r100, Header r101);

    public JSONObject getOriginalBody(JSONObject r100) {
        return r100;
    }

    public abstract String loadStackTrace();

    private void deleteDirectory() {
        p.d("delete directory=" + this.mDirectory.getAbsolutePath());
        com.bytedance.crash.util.g.e(this.mDirectory);
        if (this.mDirectory.exists() == false) goto L6;
        com.bytedance.crash.util.g.d(this.mDirectory, UPLOAD_STATE);
        return;
    }

    public boolean checkIfNeedUpload() {
        PolarisFileWrapper r100 = new PolarisFileWrapper(this.mDirectory, UPLOAD_STATE);
        int r101 = 0;
        if (r100.exists() == true) goto L24;
    L22:
        PolarisFileOutputStreamWrapper r102 = new PolarisFileOutputStreamWrapper(r100);     // Catch: Exception -> L19
        r102.write(r101);     // Catch: Exception -> L19
        r102.close();     // Catch: Exception -> L19
    L18:
        return true;
    L24:
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(r100);     // Catch: Exception -> L8
        int r104 = r103.read();     // Catch: Exception -> L8
        r103.close();     // Catch: Exception -> L7
    L10:
        if (r104 < 0) goto L14;
        if (r104 >= 2) goto L14;
        r101 = r104 + 1;
    L14:
        if (r104 < 2) goto L16;
        ch4.c.b("upload failed, retry count is" + r104 + ".", new Exception());
    L16:
        return false;
    L8:
        r104 = 0;
        goto L10
    }

    public List<File> getAttachmentFileList() {
        ArrayList r100 = new ArrayList();
        File[] r101 = this.mDirectory.listFiles();
        if (r101 == null) goto L15;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L15;
        File r104 = r101[r103];
        String r105 = r104.getName();
        if (r105.endsWith(SUFFIX) == true) goto L14;
        if (r105.endsWith(InvRouter.FLOW_SUFFIX) == true) goto L14;
        if (r105.endsWith(".inf") == true) goto L14;
        r100.add(r104);
    L14:
        r103 = r103 + 1;
    L15:
        return r100;
    }

    public long getCrashTime() {
        return this.mCrashTime;
    }

    public CrashType getCrashType() {
        return this.mCrashType;
    }

    public int getPid() {
        return this.mPid;
    }

    public String getProcessName() {
        return this.mProcessName;
    }

    public String getStackTrace() {
        return this.mStackTrace;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public String getThreadName() {
        return this.mThreadName;
    }

    public int getTid() {
        return this.mTid;
    }

    public static CrashSummary loadFromDirectory(File r100) {
        File[] r101 = r100.listFiles(new c());
        if (r101 != null) goto L5;
        return null;
    L5:
        ArrayList r102 = new ArrayList();
        int r103 = r101.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L15;
        File r105 = r101[r104];
        NativeCrashSummary r106 = NativeCrashSummary.load(r105);
        if (r106 == null) goto L10;
        r102.add(r106);
    L10:
        e r107 = e.a(r105);
        if (r107 == null) goto L13;
        r102.add(r107);
    L13:
        r104 = r104 + 1;
        goto L6
    L15:
        if (r102.isEmpty() == false) goto L17;
        return null;
    L17:
        Collections.sort(r102, new d());
        return (CrashSummary) ListProtector.get(r102, 0);
    }

    private void setInnerAid(JSONObject r100) {
        JSONObject r101 = r100.optJSONObject("header");
        JSONObject r102 = r100.optJSONObject("filters");
        if (r101 == null) goto L5;
        String r103 = String.valueOf(r101.opt("aid"));
    L6:
        j.h(r102, "aid", r103);
        j.h(r101, "aid", 2010);
        return;
    L5:
        r103 = "";
        goto L6
    }

    public eh4.a assemblyCrashBody(com.bytedance.crash.monitor.a r110) {
        Header r111 = Header.a(r110, this.mStartTime, this.mCrashTime, this.mCrashType, this.mPid, this.mDirectory);
        eh4.a r100 = new eh4.a();
        r100.a("pid", Integer.valueOf(this.mPid));     // Catch: Throwable -> L11
        r100.a("tid", Integer.valueOf(this.mTid));     // Catch: Throwable -> L11
        r100.a("crash_time", Long.valueOf(this.mCrashTime));     // Catch: Throwable -> L11
        r100.a("crash_thread_name", this.mThreadName);     // Catch: Throwable -> L11
        r100.a("process_name", this.mProcessName);     // Catch: Throwable -> L11
        r100.a("app_start_time", Long.valueOf(this.mStartTime));     // Catch: Throwable -> L11
        r100.a("app_start_up_time", Long.valueOf(this.sAppStartUpTime));     // Catch: Throwable -> L11
        r100.a("jiffy", Long.valueOf(r111.f203196b));     // Catch: Throwable -> L11
        r100.a("has_dump", "true");     // Catch: Throwable -> L11
        j.h(r100.f472653a, "business", i.f203218h);     // Catch: Throwable -> L11
        r100.a("data", this.mStackTrace);     // Catch: Throwable -> L11
        r100.a("crash_md5", com.bytedance.crash.util.d.a(this.mStackTrace));     // Catch: Throwable -> L11
        int r101 = bi4.a.f19101j;     // Catch: Throwable -> L11
        if (r101 == 1) goto L6;
    L9:
        r100.a(AppbrandHostConstants.Schema_RESERVED_FIELD.LAUNCH_MOD, Integer.valueOf(r101));     // Catch: Throwable -> L11
        r100.a("launch_time", Long.valueOf(bi4.a.f19102k));     // Catch: Throwable -> L11
        r100.a("session_id", r111.f203195a.opt("session_id"));     // Catch: Throwable -> L11
        loadCrashInfo(r100.f472653a, r111.f203195a, this.mDirectory);     // Catch: Throwable -> L11
        eh4.b.a(r111.f203195a, r100.f472653a, this.mDirectory);     // Catch: Throwable -> L11
        assemblyCrashBodyAfterFilter(r100.f472653a, this.mDirectory);     // Catch: Throwable -> L11
        assemblySpecialCrashBody(r100, r111);     // Catch: Throwable -> L11
        appendSpecialFilter(r100.f472653a);     // Catch: Throwable -> L11
    L13:
        r100.a("header", r111.f203195a);
        r100.f472654b = r111;
        return r100;
    L6:
        if (bi4.a.f19105n == false) goto L8;
        r101 = 2;
        goto L9
    L8:
        r101 = 1;
    L11:
        th = move-exception;
        p.d(th);
        ch4.c.c(th);
        goto L13
    }

    public Header assemblyCrashHeader(com.bytedance.crash.monitor.a r100) {
        return Header.a(r100, this.mStartTime, this.mCrashTime, this.mCrashType, this.mPid, this.mDirectory);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object r100) {
        long r101 = this.mCrashTime - ((CrashSummary) r100).mCrashTime;
        if (r101 <= 0) goto L5;
        return -1;
    L5:
        if (r101 >= 0) goto L7;
        return 1;
    L7:
        return 0;
    }

    private static void assemblyCrashBodyAfterFilter(JSONObject r110, File r111) {
        NativeBridge.M(r111.getAbsolutePath());
        PolarisFileWrapper r100 = new PolarisFileWrapper(r111, "maps_size.txt");
        if (r100.exists() == true) goto L25;
    L22:
        j.h(r110, "leak_so_list", rh4.a.b.l(new PolarisFileWrapper(r111, "ht_so_list.txt")));
        return;
    L25:
        BufferedReader r101 = new BufferedReader(new PolarisFileReaderWrapper(r100));     // Catch: Throwable -> L24
        String r102 = r101.readLine();     // Catch: Throwable -> L24
        if (r102 == null) goto L22;
        String[] r103 = r102.trim().split(" ");     // Catch: Throwable -> L24
        if (r103.length < 2) goto L22;
        JSONArray r104 = new JSONArray();     // Catch: Throwable -> L24
    L11:
        String r105 = r101.readLine();     // Catch: Throwable -> L24
        if (r105 == null) goto L20;
        String[] r106 = r105.trim().split(" ");     // Catch: Throwable -> L24
        if (r106.length != r103.length) goto L11;
        JSONObject r107 = new JSONObject();     // Catch: Throwable -> L24
        int r108 = 0;
    L17:
        if (r108 >= r103.length) goto L19;
        r107.put(r103[r108], r106[r108]);     // Catch: Throwable -> L24
        r108 = r108 + 1;     // Catch: Throwable -> L24
        goto L17
    L19:
        r104.put(r107);     // Catch: Throwable -> L24
        goto L11
    L20:
        r101.close();     // Catch: Throwable -> L24
        r110.put("tagged_maps_size", r104);     // Catch: Throwable -> L24
    L21:
        h.b(r100);
        goto L22
    }

    private boolean beforeUpload(com.bytedance.crash.monitor.a r110, JSONObject r111) {
        m0 r100 = r110.f203291c;
        CrashType r101 = this.mCrashType;
        r100.getClass();
        if (r100.h(r101, r111) == false) goto L7;
        boolean r102 = true;
    L15:
        if (r102 == false) goto L17;
        return true;
    L17:
        JSONObject r103 = getOriginalBody(r111);
        CrashType r104 = this.mCrashType;
        long r105 = this.mCrashTime;
        CrashType r112 = CrashType.ANR;
        if (r104 != r112) goto L20;
        boolean r113 = !TextUtils.isEmpty(r103.optString("anr_info"));
    L21:
        boolean r114 = bi4.a.f19100i;
        JSONObject r115 = r103.optJSONObject("activity_trace");
        if (r115 == null) goto L26;
        JSONObject r116 = r115.optJSONObject(bi4.a.f19106o[2]);
        if (r116 == null) goto L26;
        String r117 = r116.optString("name");
    L143:
        IApmAgent r118 = (IApmAgent) ServiceManager.getService(IApmAgent.class);     // Catch: Exception -> L37
        if (r118 == null) goto L38;
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L37
        r106.put("app_exit_metrics", r104.getName());     // Catch: Exception -> L37
        if (TextUtils.isEmpty(r117) == true) goto L33;
        r106.put("scene", r117);     // Catch: Exception -> L37
    L33:
        if (r104 != r112) goto L35;
        r106.put("has_anr_info", r113);     // Catch: Exception -> L37
    L35:
        r106.put("crash_time", r105);     // Catch: Exception -> L37
        r118.monitorEvent("hmd_app_exit_reason", r106, null, null);     // Catch: Exception -> L37
    L38:
        JSONObject r107 = r111.optJSONObject("header");
        CrashType r108 = this.mCrashType;
        File r109 = this.mDirectory;
        JSONObject r119 = new JSONObject();
        j.h(r119, "crash_type", r108.getName());
        if (r109 != null) goto L42;
    L113:
        g.b(r103.opt("miniapp_info"), "miniapp_info", r119);
        g.b(r103.opt("plugin_info"), "plugin_info", r119);
        g.b(r103.opt("process_name"), "process_name", r119);
        g.b(r103.opt(Scraps.BATTERY), Scraps.BATTERY, r119);
        g.b(r103.opt("logcat"), "logcat", r119);
        g.b(r103.opt("crash_time"), "crash_time", r119);
        g.b(r103.opt("storage"), "storage", r119);
        g.b(r103.opt("filters"), "filters", r119);
        g.b(r103.opt("patch_info"), "patch_info", r119);
        g.b(r103.opt("pid"), "pid", r119);
        g.b(r103.opt(LocationMonitorConst.IS_BACKGROUND), LocationMonitorConst.IS_BACKGROUND, r119);
        g.b(r103.opt("activity_trace"), "activity_trace", r119);
        g.b(r103.opt("custom_long"), "custom_long", r119);
        g.b(r103.opt("custom"), "custom", r119);
        if (r103.optJSONObject("custom_long") == null) goto L117;
        g.b(r103.optJSONObject("custom_long").opt("activity_track"), "activity_track", r119);
    L117:
        if (r103.opt("filters") == null) goto L119;
        g.b(r103.optJSONObject("filters").opt("sdk_version"), "filters:sdk_version", r119);
        g.b(r103.optJSONObject("filters").opt(AppInfo.KEY_NPTH_VERSION_NAME), "filters:sdk_version_name", r119);
        g.b(r103.optJSONObject("filters").opt("is_root"), "filters:is_root", r119);
        g.b(r103.optJSONObject("filters").opt("is_x86_devices"), "filters:is_x86_devices", r119);
        g.b(r103.optJSONObject("filters").opt("is_64_runtime"), "filters:is_64_runtime", r119);
        g.b(r103.optJSONObject("filters").opt(RomInfo.KEY_ROM_KERNEL_VERSION), "filters:kernel_version", r119);
    L119:
        if (r107 == null) goto L128;
        g.a(r107.optString(AppInfo.KEY_NPTH_VERSION_NAME), AppInfo.KEY_NPTH_VERSION_NAME, r119);
        g.a(r107.optString("sdk_version"), "sdk_version", r119);
        String r120 = r107.optString("os");
        if ("Android" != r120) goto L124;
    L127:
        g.a(r107.optString("os_version"), "os_version", r119);
        g.a(r107.optString("os_api"), "os_api", r119);
        g.a(r107.optString("device_model"), "device_model", r119);
        g.a(r107.optString("device_brand"), "device_brand", r119);
        g.a(r107.optString("device_manufacturer"), "device_manufacturer", r119);
        g.a(r107.optString(HardwareInfo.KEY_HW_CPU_ABI), HardwareInfo.KEY_HW_CPU_ABI, r119);
        g.a(r107.optString("unique_key"), "unique_key", r119);
        goto L128
    L124:
        if ("Android".equals(r120) == true) goto L127;
        r119.put("err_os_not_Android", 1);     // Catch: JSONException -> L130
    L128:
        new ch4.c.b(r119).a();
        return false;
    L42:
        if (new PolarisFileWrapper(r109, "logcat.txt").exists() == true) goto L48;
        r119.put("has_logcat_file_false", 1);     // Catch: JSONException -> L46
    L48:
        if (new PolarisFileWrapper(r109, "maps.txt").exists() == true) goto L54;
        r119.put("has_maps_file_false", 1);     // Catch: JSONException -> L52
    L54:
        if (new PolarisFileWrapper(r109, "threads.txt").exists() == true) goto L60;
        r119.put("has_threads_file_false", 1);     // Catch: JSONException -> L58
    L60:
        if (new PolarisFileWrapper(r109, "fds.txt").exists() == true) goto L66;
        r119.put("has_fds_file_false", 1);     // Catch: JSONException -> L64
    L66:
        if (new PolarisFileWrapper(r109, "meminfo.txt").exists() == true) goto L72;
        r119.put("has_meminfo_file_false", 1);     // Catch: JSONException -> L70
    L72:
        if (new PolarisFileWrapper(r109, "viewTree.txt").exists() == true) goto L78;
        r119.put("has_view_tree_false", 1);     // Catch: JSONException -> L76
    L78:
        if (new PolarisFileWrapper(r109, "pthread_key_info.txt").exists() == true) goto L84;
        r119.put("has_pthread_key_file_false", 1);     // Catch: JSONException -> L82
    L84:
        if (new PolarisFileWrapper(r109, "pthread_key_map.txt").exists() == true) goto L90;
        r119.put("has_pthread_key_map_file_false", 1);     // Catch: JSONException -> L88
    L90:
        if (new PolarisFileWrapper(r109, "malloc.txt").exists() == true) goto L96;
        r119.put("has_malloc_file_false", 1);     // Catch: JSONException -> L94
    L96:
        if (new PolarisFileWrapper(r109, "pthreads.txt").exists() == true) goto L102;
        r119.put("has_pthreads_file_false", 1);     // Catch: JSONException -> L100
    L102:
        if (new PolarisFileWrapper(r109, "setpriority.txt").exists() == true) goto L108;
        r119.put("has_setpriority_file_false", 1);     // Catch: JSONException -> L106
    L108:
        if (new PolarisFileWrapper(r109, "leak_heap.txt").exists() == true) goto L113;
        r119.put("has_heaptrack_file_false", 1);     // Catch: JSONException -> L112
    L26:
        r117 = null;
        goto L143
    L20:
        r113 = false;
        goto L21
    L7:
        if (r101 != CrashType.ANR) goto L14;
        r111.optLong("app_start_time");     // Catch: Throwable -> L13
        r111.optLong("crash_time");     // Catch: Throwable -> L13
        r111.optString("process_name");     // Catch: Throwable -> L13
        Iterator r121 = ((CopyOnWriteArrayList) r100.f203250m).iterator();     // Catch: Throwable -> L13
    L10:
        if (r121.hasNext() == false) goto L14;
        ((m) r121.next()).a();     // Catch: Throwable -> L13
    L14:
        r102 = false;
        goto L15
    }

    public static CrashSummary loadFromDirectory(File r100, boolean r101) {
        File[] r102 = r100.listFiles(new a());
        if (r102 != null) goto L5;
        return null;
    L5:
        ArrayList r103 = new ArrayList();
        int r104 = r102.length;
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L17;
        File r106 = r102[r105];
        if (r101 == false) goto L12;
        NativeCrashSummary r107 = NativeCrashSummary.load(r106);
        if (r107 == null) goto L15;
        r103.add(r107);
    L15:
        r105 = r105 + 1;
        goto L6
    L12:
        e r108 = e.a(r106);
        if (r108 == null) goto L15;
        r103.add(r108);
        goto L15
    L17:
        if (r103.isEmpty() == false) goto L19;
        return null;
    L19:
        Collections.sort(r103, new b());
        return (CrashSummary) ListProtector.get(r103, 0);
    }

    public boolean upload(com.bytedance.crash.monitor.a r100, JSONObject r110) {
        boolean r101 = false;
        if (checkIfNeedUpload() == true) goto L6;
        deleteDirectory();
        return false;
    L6:
        PolarisFileWrapper r102 = new PolarisFileWrapper(this.mDirectory, "upload.json");
        String r103 = com.bytedance.crash.util.g.f(r102);
        JSONObject r104 = null;
        if (r103 != null) goto L42;
        JSONObject r105 = null;
    L14:
        if (r104 == null) goto L40;
        if (r105 == null) goto L40;
        boolean r111 = false;
    L22:
        boolean r106 = beforeUpload(r100, r104);     // Catch: Throwable -> L31
        if (r106 == false) goto L46;
    L34:
        afterUpload(r104, r101, r106);
        p.d("uploadOne:" + this.mDirectory.getAbsolutePath() + ", success=" + r101);
        return r101;
    L46:
        String r107 = r104.toString();     // Catch: Throwable -> L29
        if (r111 == true) goto L38;
    L27:
        String r112 = n.f(this.mCrashType, r105);     // Catch: Throwable -> L29
        p.d("uploadOne: " + this.mCrashType + HTTP.HEADER_LINE_DELIM + r112);     // Catch: Throwable -> L29
        r101 = CrashUploader.g(this.mCrashType.getName(), r112, r107, getAttachmentFileList()).a();     // Catch: Throwable -> L29
        goto L34
    L38:
        h.h(r102, r107, false);     // Catch: Exception -> L37 Throwable -> L29
    L29:
        th = move-exception;
        boolean r113 = r106;
        th = th;
    L33:
        boolean r108 = zg4.i.f572087c;
        ch4.c.b("upload exception", th);
        r106 = r113;
    L31:
        th = th;
        r113 = false;
    L40:
        r104 = assemblyCrashBody(r100).f472653a;     // Catch: Throwable -> L31
        r105 = r104.optJSONObject("header");     // Catch: Throwable -> L31
        JSONObject r109 = j.e(r104, "filters");     // Catch: Throwable -> L31
        if (r110 == null) goto L21;
        j.d(r109, r110);     // Catch: Throwable -> L31
    L21:
        r111 = true;
        goto L22
    L42:
        JSONObject r114 = new JSONObject(r103);     // Catch: JSONException -> L11
        r104 = r114.optJSONObject("header");     // Catch: JSONException -> L36
    L12:
        r105 = r104;
        r104 = r114;
    L11:
        r114 = null;
        goto L12
    }

    private void afterUpload(JSONObject r100, boolean r101, boolean r102) {
        if (r101 == true) goto L19;
    L11:
        if (r101 == true) goto L13;
        if (r102 == true) goto L13;
        return;
    L13:
        deleteDirectory();     // Catch: Throwable -> L18
        PolarisFileWrapper r103 = ah4.b.f3423i;     // Catch: Throwable -> L18
        if (r103 == null) goto L27;
        h.b(r103);     // Catch: Throwable -> L18
        return;
    L28:
        return;
    L27:
        return;
    L19:
        wg4.a.b(this.mProcessName, this.mStartTime, this.mCrashTime, this.mCrashType);     // Catch: Throwable -> L18
        com.bytedance.crash.upload.a.C2955a r104 = new com.bytedance.crash.upload.a.C2955a();     // Catch: Throwable -> L18
        com.bytedance.crash.upload.a.f203350b.add(r104);     // Catch: Throwable -> L18
        ConcurrentLinkedQueue<com.bytedance.crash.upload.a> r105 = com.bytedance.crash.upload.a.f203349a;     // Catch: Throwable -> L18
        if (r105.isEmpty() == true) goto L11;
        Iterator<com.bytedance.crash.upload.a> r106 = r105.iterator();     // Catch: Throwable -> L18
    L7:
        if (r106.hasNext() == false) goto L11;
        r106.next().a();     // Catch: Throwable -> L17
        goto L7
    }

    public void loadCrashInfo(JSONObject r100, JSONObject r101, File r102) {
        MemoryInfo.b(r100, r102);
        ih4.c.d(r100, r102);
        mh4.d.f(r100, r102);
        String r103 = com.bytedance.crash.util.g.f(new PolarisFileWrapper(r102, "sdk_info.json"));
        if (r103 != null) goto L26;
    L8:
        k.h(r100, r102);
        bi4.a.g(r100, r102);
        String r104 = com.bytedance.crash.util.g.f(new PolarisFileWrapper(r102, "all_thread_stacks.json"));
        if (r104 != null) goto L28;
    L13:
        Scraps.pushTo(r100, r102);
        com.bytedance.crash.monitor.a r105 = com.bytedance.crash.monitor.j.f203315a;
        if (r105 == null) goto L19;
        yh4.a r106 = r105.f203300l;
        if (r106 == null) goto L19;
        ((com.bytedance.crash.dumper.j) r106).d(r100, r101, r102);
    L19:
        String r107 = com.bytedance.crash.util.g.f(new PolarisFileWrapper(r102, "custom.json"));
        if (r107 == null) goto L30;
        j.d(r100, new JSONObject(r107));     // Catch: Throwable -> L23
        return;
    L31:
        return;
    L30:
        return;
    L28:
        j.d(r100, new JSONObject(r104));     // Catch: Throwable -> L12
        goto L13
    L26:
        j.d(r100, new JSONObject(r103));     // Catch: JSONException -> L6
    L6:
        e = move-exception;
        p.d(e);
        goto L8
    }

    public CrashSummary(File r100, CrashType r101, long r102, long r103, long r104, String r105, String r110, int r111, int r112) {
        this.mDirectory = r100;
        this.mCrashType = r101;
        this.mStartTime = r102;
        this.sAppStartUpTime = r103;
        this.mCrashTime = r104;
        this.mProcessName = r105;
        this.mThreadName = r110;
        this.mPid = r111;
        this.mTid = r112;
    }
}
