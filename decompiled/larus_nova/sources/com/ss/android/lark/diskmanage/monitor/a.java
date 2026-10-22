package com.ss.android.lark.diskmanage.monitor;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.bytedance.apm.ApmAgent;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.diskmanage.monitor.settings.DiskMonitorConfig;
import com.ss.android.lark.diskmanage.monitor.settings.MonitorGlobalConfig;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.LarkKVStorage;
import com.suite.lark.component.protocol.Biz;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f420455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f420456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f420457c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f420458d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f420459e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f420460f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f420461g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f420462h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f420463i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f420464j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f420465k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f420466l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f420467m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f420468n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f420469o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<C4953a> f420470p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public b<C4953a> f420471q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public b<C4953a> f420472r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final com.ss.android.lark.storage.kv.repo.a f420473s;

    /* JADX INFO: renamed from: com.ss.android.lark.diskmanage.monitor.a$a, reason: collision with other inner class name */
    public class C4953a implements Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f420474a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f420475b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f420476c;

        @Override // java.lang.Comparable
        public final int compareTo(Object r100) {
            long r101 = this.f420475b;
            long r102 = ((C4953a) r100).f420475b;
            if (r101 != r102) goto L7;
            return 0;
        L7:
            if (r101 <= r102) goto L10;
            return 1;
        L10:
            return -1;
        }

        public C4953a(String r100, long r101, long r102) {
            this.f420474a = r100;
            this.f420475b = r101;
            this.f420476c = r102;
        }
    }

    public class b<E extends Comparable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PriorityQueue<E> f420477a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f420478b;

        public b(int r100) {
            if (r100 <= 0) goto L7;
            this.f420478b = r100;
            this.f420477a = new PriorityQueue(r100, new com.ss.android.lark.diskmanage.monitor.b());
            return;
        L7:
            throw new IllegalStateException();
        }

        public final void a(C4953a r100) {
            if (this.f420477a.size() >= this.f420478b) goto L6;
            this.f420477a.add(r100);
            return;
        L6:
            if (r100.compareTo(this.f420477a.peek()) <= 0) goto L10;
            this.f420477a.poll();
            this.f420477a.add(r100);
            return;
        }
    }

    public final void b() {
        Iterator r100 = ((ArrayList) this.f420470p).iterator();
    L4:
        if (r100.hasNext() == false) goto L14;
        C4953a r101 = (C4953a) r100.next();
        if (r101.f420476c == 2) goto L4;
        if (TextUtils.equals(r101.f420474a, this.f420462h) == true) goto L10;
        if (TextUtils.equals(r101.f420474a, this.f420464j) == false) goto L4;
        this.f420468n = r101.f420475b;
        goto L4
    L10:
        this.f420467m = r101.f420475b;
        goto L4
    }

    public a() {
        this.f420456b = true;
        this.f420457c = 629145600;
        this.f420458d = 20971520;
        this.f420459e = 52428800;
        this.f420460f = 50;
        this.f420470p = new ArrayList();
        this.f420473s = LarkKVStorage.j(Biz.Performance, false);
    }

    public final String d(String r100) {
        if (r100.contains(this.f420461g) == false) goto L6;
        return r100.replace(this.f420461g, "internal");
    L6:
        if (r100.contains(this.f420463i) == true) goto L8;
        return r100;
    L8:
        return r100.replace(this.f420463i, "external");
    }

    public final void f(Context r110) {
        if (this.f420455a == false) goto L6;
        Log.i("StorageMetricsHandler", "Storage metric have done within the current period");
        return;
    L6:
        long r100 = System.currentTimeMillis() - this.f420473s.getLong("lark_check_disk_last_time", 0);
        if (r100 < 86400000) goto L9;
    L11:
        String r101 = this.f420473s.getString("key_storage_monitor_setting", "");
        Log.i("StorageMetricsHandler", "settingJson = " + r101);
        DiskMonitorConfig r102 = (DiskMonitorConfig) JSON.parseObject(r101, DiskMonitorConfig.class);     // Catch: Exception -> L19
        if (r102 != null) goto L15;
        Log.i("StorageMetricsHandler", "parseConfig return null ");     // Catch: Exception -> L19
        this.f420455a = true;     // Catch: Exception -> L19
    L25:
        if (this.f420455a == false) goto L29;
        Log.i("StorageMetricsHandler", "Storage metric have done within the current period");
        return;
    L29:
        if (this.f420461g != null) goto L42;
        this.f420461g = r110.getFilesDir().getParent();     // Catch: Exception -> L39
        this.f420462h = r110.getCacheDir().getAbsolutePath();     // Catch: Exception -> L39
        File r103 = r110.getExternalFilesDir(null);     // Catch: Exception -> L39
        if (r103 == null) goto L34;
        this.f420463i = r103.getParent();     // Catch: Exception -> L39
    L34:
        File r104 = r110.getExternalCacheDir();     // Catch: Exception -> L39
        if (r104 == null) goto L37;
        this.f420464j = r104.getAbsolutePath();     // Catch: Exception -> L39
    L37:
        this.f420471q = new b(this.f420460f);     // Catch: Exception -> L39
        this.f420472r = new b(this.f420460f);     // Catch: Exception -> L39
    L39:
        e = move-exception;
        Log.e("StorageMetricsHandlerparseConfig return initPaths", e, true);
        this.f420469o = true;
    L42:
        if (this.f420469o == false) goto L51;
        Log.i("StorageMetricsHandler", "parseConfig return mInitException ");
        this.f420455a = true;
        return;
    L51:
        Log.i("StorageMetricsHandler", "CollectStorageMetrics start");     // Catch: Throwable -> L47
        PolarisFileWrapper r105 = new PolarisFileWrapper(this.f420461g);     // Catch: Throwable -> L47
        PolarisFileWrapper r106 = new PolarisFileWrapper(this.f420463i);     // Catch: Throwable -> L47
        this.f420465k = c(r105, 0);     // Catch: Throwable -> L47
        this.f420466l = c(r106, 0);     // Catch: Throwable -> L47
        b();     // Catch: Throwable -> L47
        e(this.f420466l + this.f420465k, this.f420468n + this.f420467m, Environment.getRootDirectory().getTotalSpace() + Environment.getDataDirectory().getTotalSpace(), Environment.getDataDirectory().getFreeSpace());     // Catch: Throwable -> L47
        this.f420473s.putLong("lark_check_disk_last_time", System.currentTimeMillis());     // Catch: Throwable -> L47
        Log.i("StorageMetricsHandler", "CollectStorageMetrics end");     // Catch: Throwable -> L47
    L49:
        this.f420455a = true;
        return;
    L47:
        th = move-exception;
        Log.e("StorageMetricsHandlerCollectStorageMetrics error!", th, true);
        goto L49
    L15:
        MonitorGlobalConfig r107 = r102.getGlobalConfig();     // Catch: Exception -> L19
        if (r107 == null) goto L22;
        this.f420456b = r107.getDumpSwitch();     // Catch: Exception -> L19
        this.f420457c = (r107.getDumpThreshold() * 1024) * 1024;     // Catch: Exception -> L19
        this.f420458d = (r107.getAbnormalFileSize() * 1024) * 1024;     // Catch: Exception -> L19
        this.f420459e = (r107.getAbnormalFolderSize() * 1024) * 1024;     // Catch: Exception -> L19
        this.f420460f = r107.getDumpTopCount();     // Catch: Exception -> L19
    L22:
        if (this.f420456b == true) goto L25;
        Log.i("StorageMetricsHandler", "parseConfig return mDiskSwitch ");
        this.f420455a = true;
    L19:
        e = move-exception;
        Log.e("StorageMetricsHandlerparse DiskMonitorConfig fail. ", e, true);
        goto L22
    L9:
        if (r100 <= 0) goto L11;
        this.f420455a = true;
        goto L25
    }

    public final long c(File r110, long r111) {
        if (r110.isFile() == true) goto L5;
        long r100 = 0;
        File[] r112 = r110.listFiles();     // Catch: Exception -> L20
        if (r112 != null) goto L10;
    L19:
        return 0;
    L10:
        if (r112.length == 0) goto L19;
        int r101 = r112.length;     // Catch: Exception -> L20
        int r102 = 0;
    L13:
        if (r102 >= r101) goto L22;
        File r103 = r112[r102];     // Catch: Exception -> L20
        if (r103.isDirectory() == false) goto L17;
        long r104 = r111 + 1;     // Catch: Exception -> L20
        long r105 = c(r103, r104);     // Catch: Exception -> L20
        r100 = r100 + r105;     // Catch: Exception -> L20
        a(r103, r105, r104);     // Catch: Exception -> L20
    L18:
        r102 = r102 + 1;
        goto L13
    L17:
        r100 = r100 + r103.length();     // Catch: Exception -> L20
        a(r103, r103.length(), r111 + 1);     // Catch: Exception -> L20
    L22:
        return r100;
    L20:
        e = move-exception;
        Log.e("StorageMetricsHandler", "getFileSize error!", e);
        goto L22
    L5:
        return r110.length();
    }

    public final void a(File r100, long r101, long r110) {
        C4953a r102 = new C4953a(r100.getAbsolutePath(), r101, r110);
        if (r110 > 2) goto L7;
        ((ArrayList) this.f420470p).add(r102);
        return;
    L7:
        if (r100.isFile() == false) goto L12;
        if (r101 < this.f420458d) goto L12;
        this.f420471q.a(r102);
        return;
    L12:
        if (r101 < this.f420459e) goto L16;
        this.f420472r.a(r102);
        return;
    }

    public final void e(long r100, long r101, long r110, long r111) {
        Log.i("StorageMetricsHandler", "disk: data: " + r100 + " , cache: " + r101 + " , total: " + r110 + " , free: " + r111);     // Catch: Exception -> L27
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L27
        r102.put("data", r100);     // Catch: Exception -> L27
        r102.put("cache", r101);     // Catch: Exception -> L27
        r102.put("total", r110);     // Catch: Exception -> L27
        r102.put("rom_free", r111);     // Catch: Exception -> L27
        Iterator r103 = ((ArrayList) this.f420470p).iterator();     // Catch: Exception -> L27
    L6:
        if (r103.hasNext() == false) goto L14;
        C4953a r112 = (C4953a) r103.next();     // Catch: Exception -> L27
        String r113 = d(r112.f420474a);     // Catch: Exception -> L27
        if (r112.f420475b <= 0) goto L10;
        Log.i("StorageMetricsHandler", "path: " + r113 + ", size: " + r112.f420475b);     // Catch: Exception -> L27
    L10:
        long r114 = r112.f420475b;     // Catch: Exception -> L27
        if (r114 < 1048576) goto L6;
        r102.put(r113, r114);     // Catch: Exception -> L27
        goto L6
    L14:
        b<C4953a> r104 = this.f420472r;     // Catch: Exception -> L27
        r104.getClass();     // Catch: Exception -> L27
        Iterator r105 = new ArrayList(r104.f420477a).iterator();     // Catch: Exception -> L27
    L16:
        if (r105.hasNext() == false) goto L18;
        C4953a r115 = (C4953a) r105.next();     // Catch: Exception -> L27
        String r116 = d(r115.f420474a);     // Catch: Exception -> L27
        Log.i("StorageMetricsHandler", "path: " + r116 + ", size: " + r115.f420475b);     // Catch: Exception -> L27
        r102.put(r116, r115.f420475b);     // Catch: Exception -> L27
        goto L16
    L18:
        b<C4953a> r106 = this.f420471q;     // Catch: Exception -> L27
        r106.getClass();     // Catch: Exception -> L27
        Iterator r107 = new ArrayList(r106.f420477a).iterator();     // Catch: Exception -> L27
    L20:
        if (r107.hasNext() == false) goto L23;
        C4953a r117 = (C4953a) r107.next();     // Catch: Exception -> L27
        String r118 = d(r117.f420474a);     // Catch: Exception -> L27
        Log.i("StorageMetricsHandler", "path: " + r118 + ", size: " + r117.f420475b);     // Catch: Exception -> L27
        r102.put(r118, r117.f420475b);     // Catch: Exception -> L27
        goto L20
    L23:
        if (r100 <= this.f420457c) goto L25;
        ApmAgent.monitorEvent("lark_storage_size_all", null, r102, null);     // Catch: Exception -> L27
    L25:
        ((ArrayList) this.f420470p).clear();     // Catch: Exception -> L27
        this.f420471q.f420477a.clear();     // Catch: Exception -> L27
        this.f420472r.f420477a.clear();     // Catch: Exception -> L27
        return;
    L27:
        e = move-exception;
        Log.e("StorageMetricsHandlergetFileSize error!", e, true);
    }
}
