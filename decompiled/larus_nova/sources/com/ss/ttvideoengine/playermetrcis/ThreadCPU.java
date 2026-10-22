package com.ss.ttvideoengine.playermetrcis;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.ttvideoengine.NativeThreadInterface;
import com.ss.ttvideoengine.utils.EngineThreadPool;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes34.dex */
public class ThreadCPU {
    private static final int INDEX_S_TIME = 13;
    private static final int INDEX_U_TIME = 12;
    private static final String MEDIA_LOAD_TAG = "MediaLoad";
    private static final String PROC_PATH = "/proc/self/stat";
    private static final String TAG = "ThreadCPU";
    private static final String TASK_PATH_PREFIX = "/proc/self/task/";
    private static final String TASK_PATH_SUFFIX = "/stat";
    public static NativeThreadInterface gNativeThreadInterface = null;
    private static final int kClockTicksMs = 10;
    public static boolean sCpuRefreshFix;
    public static boolean sUseNativeThread;
    private final ConcurrentHashMap<String, Object> mCpuMap;
    private int mMdlCpuOverZero;
    private CopyOnWriteArrayList<Integer> mNativeTids;
    private CopyOnWriteArrayList<ThreadInfo> mSingleThreads;
    private CopyOnWriteArrayList<ThreadInfo> mStaticThreads;
    private ThreadInfo total;

    public static /* synthetic */ void a(ThreadCPU r100) {
        r100.lambda$refresh$0();
    }

    public static /* synthetic */ void b(ThreadCPU r100) {
        r100.lambda$refreshStaticThreads$2();
    }

    public static /* synthetic */ void c(ThreadCPU r100) {
        r100.lambda$refreshForVV$1();
    }

    private /* synthetic */ void lambda$refreshForVV$1() {
        int r100 = 0;
    L4:
        if (r100 >= this.mSingleThreads.size()) goto L6;
        refreshInternal(this.mSingleThreads.get(r100));
        r100 = r100 + 1;
        goto L4
    }

    private /* synthetic */ void lambda$refresh$0() {
        if (sUseNativeThread == false) goto L7;
        NativeThreadInterface r100 = gNativeThreadInterface;
        if (r100 == null) goto L7;
        r100.carethreadList(this.mNativeTids);
    L7:
        int r101 = 0;
        int r102 = 0;
    L9:
        if (r102 >= this.mStaticThreads.size()) goto L28;
        ThreadInfo r103 = this.mStaticThreads.get(r102);
        if (sCpuRefreshFix == false) goto L15;
        if (r102 != 0) goto L15;
    L26:
        r102 = r102 + 1;
    L15:
        if (r103.type != 2) goto L25;
        HashSet<String> r104 = r103.pids;
        if (r104 == null) goto L25;
        if (r104.size() <= 0) goto L25;
        String r105 = r103.pidName;
        if (r105 == null) goto L25;
        if (r105.contains(MEDIA_LOAD_TAG) == false) goto L25;
        float r106 = (float) (((double) this.mMdlCpuOverZero) / (((double) r103.pids.size()) * 1.0d));
        this.mCpuMap.put("mdl_cpu_rate", Float.valueOf(r106));
    L25:
        refreshInternal(r103);
    L28:
        if (r101 >= this.mSingleThreads.size()) goto L30;
        refreshInternal(this.mSingleThreads.get(r101));
        r101 = r101 + 1;
        goto L28
    L30:
        ThreadInfo r107 = this.total;
        if (r107 != null) goto L33;
        return;
    L33:
        if (sCpuRefreshFix == false) goto L41;
        getProcInfo(r107);
        return;
    }

    private /* synthetic */ void lambda$refreshStaticThreads$2() {
        PolarisFileWrapper r100 = new PolarisFileWrapper("/proc/" + Process.myPid() + "/task/");     // Catch: Throwable -> L15
        if (r100.isDirectory() == false) goto L13;
        File[] r101 = r100.listFiles();     // Catch: Throwable -> L15
        if (r101 == null) goto L23;
        int r102 = r101.length;     // Catch: Throwable -> L15
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L25;
        String r104 = readFile(r101[r103].getPath() + TASK_PATH_SUFFIX);     // Catch: Throwable -> L15
        if (r104.isEmpty() == true) goto L12;
        transStaticThread(parseStat(r104));     // Catch: Throwable -> L14
    L12:
        r103 = r103 + 1;
        goto L8
    L25:
        return;
    L23:
        return;
    L13:
        return;
    }

    private void refreshForVV() {
        CopyOnWriteArrayList<ThreadInfo> r100 = this.mSingleThreads;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.size() != 0) goto L9;
        return;
    L9:
        if (this.mSingleThreads.size() > 0) goto L11;
    L13:
        EngineThreadPool.addExecuteTask(new c(this));
        return;
    L11:
        if (this.mSingleThreads.get(0).cpuTime != (-1)) goto L13;
    }

    public Map<String, Object> getPlayerThreads() {
        return new HashMap(this.mCpuMap);
    }

    public void refresh() {
        EngineThreadPool.addExecuteTask(new b(this));
    }

    public void refreshStaticThreads() {
        EngineThreadPool.addExecuteTask(new a(this));
    }

    public ThreadCPU() {
        this.mCpuMap = new ConcurrentHashMap();
        this.mStaticThreads = null;
        this.mSingleThreads = null;
        this.mNativeTids = null;
        this.total = null;
        this.mMdlCpuOverZero = 0;
    }

    public void refreshWhenBegin() {
        refreshForVV();
    }

    public void refreshWhenEnd() {
        refreshForVV();
    }

    private ThreadInfo refreshCpu(ThreadInfo r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ThreadInfo r101 = this.total;
        if (r101 != null) goto L8;
    L10:
        int r102 = r100.type;
        if (r102 != 1) goto L14;
        getSingleThreadInfoByID(r100.pid, r100);
    L25:
        return r100;
    L14:
        if (r102 != 2) goto L25;
        if (r100.pids != null) goto L18;
        return r100;
    L18:
        r100.cpuTime = 0;
        if (r100.currentTime != 0) goto L21;
        r100.currentTime = System.currentTimeMillis();
    L21:
        getMultiThreadInfoByID(r100.pids, r100);
        long r103 = r100.cpuTimeStart;
        if (r103 != 0) goto L24;
        r100.cpuTimeStart = r100.cpuTime;
        goto L25
    L24:
        r100.cpuUsage = (r100.cpuTime - r103) / (System.currentTimeMillis() - r100.currentTime);
        goto L25
    L8:
        if (sCpuRefreshFix == true) goto L10;
        getProcInfo(r101);
        goto L10
    }

    private void refreshInternal(ThreadInfo r100) {
        refreshCpu(r100);
        if (r100 == null) goto L23;
        String r101 = r100.pidName;
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.contains("-") == false) goto L14;
        int r102 = r100.pidName.indexOf("-");
        if (r102 <= 0) goto L13;
        String r103 = r100.pidName.substring(0, r102);
        if (r103 == null) goto L15;
        r103 = r103.toLowerCase(Locale.ROOT);
    L15:
        if (r103 != null) goto L17;
        return;
    L17:
        if (sCpuRefreshFix == false) goto L21;
        float r104 = r100.cpuUsage;
        if (r104 == (-1.0f)) goto L26;
        this.mCpuMap.put(r103, Float.valueOf(r104));
        return;
    L26:
        return;
    L21:
        this.mCpuMap.put(r103, Float.valueOf(r100.cpuUsage));
        return;
    L13:
        r103 = null;
        goto L15
    L14:
        r103 = r100.pidName.toLowerCase(Locale.ROOT);
        goto L15
    }

    public ThreadInfo getProcInfo(ThreadInfo r100) {
        if (sUseNativeThread == true) goto L5;
    L7:
        getSingleCpuTime(readFile(PROC_PATH), r100);
    L8:
        float r101 = r100.cpuUsage;
        if (r101 <= 0.0f) goto L11;
        this.mCpuMap.put("proc", Float.valueOf(r101));
    L11:
        return r100;
    L5:
        if (gNativeThreadInterface == null) goto L7;
        getSingleCpuTime(null, r100);
        goto L8
    }

    public boolean initThreadMonitor(ArrayList<String> r100) {
        int r101 = 0;
        if (r100 != null) goto L5;
        return false;
    L5:
        this.mStaticThreads = new CopyOnWriteArrayList();
        this.mSingleThreads = new CopyOnWriteArrayList();
        this.mNativeTids = new CopyOnWriteArrayList();
        ThreadInfo r102 = new ThreadInfo();
        r102.pidName = "proc";
        r102.type = 1;
        this.total = r102;
        ThreadInfo r103 = new ThreadInfo();
        r103.pidName = "self";
        r103.pid = Process.myPid() + "";
        r103.type = 1;
        this.mStaticThreads.add(r103);
    L7:
        if (r101 >= r100.size()) goto L9;
        String r104 = (String) ListProtector.get(r100, r101);
        r101 = r101 + 1;
        initProc(r104, r101);
        goto L7
    L9:
        return true;
    }

    public String[] parseStat(String r100) {
        String[] r101 = new String[2];
        char[] r102 = r100.toCharArray();
        String r103 = null;
        String r104 = null;
        int r105 = 0;
        int r106 = 0;
    L4:
        if (r105 >= r102.length) goto L16;
        char r107 = r102[r105];
        if (r107 != ' ') goto L10;
        if (r104 != null) goto L10;
        r104 = new String(r102, 0, r105);
    L10:
        if (r107 != '(') goto L13;
        r106 = r105 + 1;
    L13:
        if (r107 == ')') goto L14;
        r105 = r105 + 1;
        goto L4
    L14:
        r103 = new String(r102, r106, r105 - r106);
    L16:
        r101[0] = r104;
        r101[1] = r103;
        return r101;
    }

    public long parseTime(String r110) {
        if (r110 != null) goto L5;
        return -1;
    L5:
        if (r110.isEmpty() == true) goto L39;
        char[] r111 = r110.toCharArray();
        String r100 = null;
        int r101 = 0;
        String r102 = null;
        int r103 = 0;
        int r104 = 0;
        boolean r105 = false;
    L9:
        if (r101 >= r111.length) goto L24;
        char r106 = r111[r101];
        if (r106 != ' ') goto L21;
        if (r103 != 12) goto L16;
        r102 = new String(r111, r104, r101 - r104);
    L18:
        if (r105 == false) goto L21;
        r103 = r103 + 1;
        r104 = r101 + 1;
        goto L21
    L16:
        if (r103 != 13) goto L18;
        r100 = new String(r111, r104, r101 - r104);
    L21:
        if (r106 != ')') goto L23;
        r105 = true;
    L23:
        r101 = r101 + 1;
    L24:
        if (r102 == null) goto L38;
        if (r100 == null) goto L40;
        return (CastIntegerProtector.parseInt(r102) + CastIntegerProtector.parseInt(r100)) * 10;
    L41:
        return -1;
    L40:
        return -1;
    L38:
        return -1;
    L39:
        return -1;
    }

    public String readFile(String r100) {
        BufferedInputStream r101 = null;
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L22 Exception -> L24
        BufferedInputStream r103 = new BufferedInputStream(r102);     // Catch: Exception -> L50 Throwable -> L37
        StringBuilder r104 = new StringBuilder();     // Catch: Throwable -> L19 Exception -> L21
        byte[] r105 = new byte[1024];     // Catch: Throwable -> L19 Exception -> L21
    L6:
        int r106 = r103.read(r105);     // Catch: Throwable -> L19 Exception -> L21
        if (r106 == (-1)) goto L9;
        r104.append(new String(r105, 0, r106));     // Catch: Throwable -> L19 Exception -> L21
        goto L6
    L9:
        String r107 = r104.toString();     // Catch: Throwable -> L19 Exception -> L21
        r103.close();     // Catch: IOException -> L12
    L53:
        r102.close();     // Catch: IOException -> L16
    L18:
        return r107;
    L16:
        e = move-exception;
        e.printStackTrace();
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L53
    L21:
        r101 = r103;
    L19:
        Throwable th10 = th;
    L39:
        if (r103 != null) goto L51;
    L44:
        if (r102 == null) goto L70;
        r102.close();     // Catch: IOException -> L47
        throw th10;
    L47:
        e = move-exception;
        e.printStackTrace();
        throw th10;
    L70:
        throw th10;
    L51:
        r103.close();     // Catch: IOException -> L42
    L42:
        e = move-exception;
        e.printStackTrace();
        goto L44
    L37:
        th = move-exception;
        th10 = th;
        r103 = null;
    L26:
        if (r101 != null) goto L61;
    L31:
        if (r102 != null) goto L55;
    L36:
        return "";
    L55:
        r102.close();     // Catch: IOException -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
        goto L36
    L61:
        r101.close();     // Catch: IOException -> L29
    L29:
        e = move-exception;
        e.printStackTrace();
        goto L31
    L24:
        r102 = null;
    L22:
        th = move-exception;
        r102 = null;
        th10 = th;
        r103 = null;
        goto L39
    }

    public void refreshSingleThreads(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return;
    L6:
        if (this.mSingleThreads != null) goto L8;
        return;
    L8:
        String[] r101 = r100.split("=|;");
        this.mSingleThreads.clear();
        this.mNativeTids.clear();
        int r102 = 0;
    L10:
        if (r102 >= (r101.length - 1)) goto L15;
        ThreadInfo r103 = new ThreadInfo();
        r103.type = 1;
        r103.pidName = r101[r102];
        int r104 = r102 + 1;
        r103.pid = r101[r104];
        this.mSingleThreads.add(r103);
        if (sUseNativeThread == false) goto L14;
        this.mNativeTids.add(Integer.valueOf(CastIntegerProtector.parseInt(r101[r104])));     // Catch: Exception -> L16
    L14:
        r102 = r102 + 2;
        goto L10
    }

    public void transStaticThread(String[] r100) {
        int r101 = 1;
    L4:
        if (r101 >= (this.mStaticThreads.size() + 1)) goto L20;
        if (r100.length != 2) goto L13;
        if (r100[1].startsWith(this.mStaticThreads.get(r101).pidName) == false) goto L13;
        if (this.mStaticThreads.get(r101).type != 2) goto L12;
        transMulti(r100, r101);
        return;
    L12:
        ThreadInfo r102 = this.mStaticThreads.get(r101);
        r102.reset();
        r102.pid = r100[0];
        r102.currentTime = System.currentTimeMillis();
        return;
    L13:
        r101 = r101 + 1;
        goto L4
    }

    private ThreadInfo getSingleCpuTime(String r110, ThreadInfo r111) {
        if (r111 != null) goto L5;
        r111 = new ThreadInfo();
    L5:
        if (sUseNativeThread == false) goto L10;
        NativeThreadInterface r100 = gNativeThreadInterface;
        if (r100 == null) goto L10;
        r111.cpuUsage = r100.getThreadCpuUsage(CastIntegerProtector.parseInt(r111.pid));     // Catch: Exception -> L19
    L18:
        return r111;
    L10:
        long r101 = parseTime(r110);
        long r102 = System.currentTimeMillis();
        long r103 = r111.currentTime;
        if (r103 != 0) goto L13;
        r111.cpuUsage = -1.0f;
    L17:
        r111.cpuTime = r101;
        r111.currentTime = r102;
        goto L18
    L13:
        if (r101 != (-1)) goto L15;
        r111.cpuUsage = -1.0f;
        goto L17
    L15:
        r111.cpuUsage = (r101 - r111.cpuTime) / (r102 - r103);
        goto L17
    }

    public ThreadInfo getMultiThreadInfoByID(HashSet<String> r100, ThreadInfo r101) {
        if (r101 != null) goto L4;
        r101 = new ThreadInfo();
    L4:
        this.mMdlCpuOverZero = 0;
        Iterator<String> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L14;
        String r103 = r102.next();
        String r104 = readFile(TASK_PATH_PREFIX + r103 + TASK_PATH_SUFFIX);
        if (r104 == null) goto L13;
        if (r104.isEmpty() == true) goto L13;
        getMultiCpuTime(r104, r101, r103);
    L13:
        r102.remove();
        goto L6
    L14:
        return r101;
    }

    public ThreadInfo getSingleThreadInfoByID(String r100, ThreadInfo r101) {
        if (r101 != null) goto L4;
        r101 = new ThreadInfo();
    L4:
        if (r100 != null) goto L6;
        return r101;
    L6:
        getSingleCpuTime(readFile(TASK_PATH_PREFIX + r100 + TASK_PATH_SUFFIX), r101);
        return r101;
    }

    public void initProc(String r100, int r101) {
        ThreadInfo r102 = new ThreadInfo();
        r102.pidName = r100;
        if (r100 != null) goto L5;
    L7:
        r102.type = 1;
    L8:
        this.mStaticThreads.add(r102);
        return;
    L5:
        if (r100.equals(MEDIA_LOAD_TAG) == false) goto L7;
        r102.type = 2;
        goto L8
    }

    public boolean transMulti(String[] r100, int r101) {
        if (this.mStaticThreads.get(r101).pids != null) goto L6;
        ThreadInfo r102 = this.mStaticThreads.get(r101);
        r102.pids = new HashSet();
    L6:
        if (this.mStaticThreads.get(r101).mMutiThreadUsage != null) goto L9;
        ThreadInfo r103 = this.mStaticThreads.get(r101);
        r103.mMutiThreadUsage = new HashMap();
    L9:
        if (this.mStaticThreads.get(r101).pids == null) goto L17;
        HashSet<String> r104 = this.mStaticThreads.get(r101).pids;
        if (r104 != null) goto L13;
        return true;
    L13:
        if (r104.contains(r100[0]) == true) goto L19;
        r104.add(r100[0]);
        return true;
    L19:
        return true;
    L17:
        return true;
    }

    private ThreadInfo getMultiCpuTime(String r100, ThreadInfo r101, String r102) {
        if (r101 != null) goto L4;
        r101 = new ThreadInfo();
    L4:
        long r103 = parseTime(r100);
        if (r103 == (-1)) goto L17;
        HashMap<String, Object> r104 = r101.mMutiThreadUsage;
        if (r104 != null) goto L9;
    L16:
        r101.cpuTime += r103;
        goto L17
    L9:
        if (r104.containsKey(r102) == false) goto L15;
        Object r105 = r101.mMutiThreadUsage.get(r102);
        if (r105 == null) goto L15;
        if ((r103 - ((Long) r105).longValue()) <= 0) goto L15;
        this.mMdlCpuOverZero++;
    L15:
        r101.mMutiThreadUsage.put(r102, Long.valueOf(r103));
    L17:
        return r101;
    }
}
