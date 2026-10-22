package com.bytedance.monitor.collector;

import android.util.Log;
import android.util.Pair;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class BinderMonitor extends AbsMonitor {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final List<a> f265563e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f265564f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile int f265565g;

    /* JADX INFO: loaded from: classes21.dex */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f265566a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f265567b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f265568c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public StackTraceElement[] f265569d;

        public a() {
        }

        public final String toString() {
            StringBuilder r100 = new StringBuilder("{\"start\":");
            r100.append(this.f265566a);
            r100.append(",\"end\":");
            r100.append(this.f265567b);
            r100.append(",\"parcel_size\":");
            r100.append(this.f265568c);
            r100.append(",\"cost_millis\":");
            r100.append(this.f265567b - this.f265566a);
            r100.append(",\"java_stack\":\"");
            StackTraceElement[] r101 = this.f265569d;
            List<a> r102 = BinderMonitor.f265563e;
            int r103 = 0;
            if (r101 != null) goto L5;
        L18:
            if (r101 != null) goto L20;
            String r104 = "Invalid Stack\n";
        L27:
            r100.append(r104);
            r100.append("\"}");
            return r100.toString();
        L20:
            StringBuilder r105 = new StringBuilder();
            int r106 = r101.length;
            int r107 = 0;
        L21:
            if (r103 >= r106) goto L26;
            StackTraceElement r108 = r101[r103];
            r107 = r107 + 1;
            r105.append("\\tat " + r108.getClassName());
            r105.append(".");
            r105.append(r108.getMethodName());
            r105.append("(");
            r105.append(r108.getFileName());
            r105.append(":");
            r105.append(r108.getLineNumber());
            r105.append(")\\n");
            if (r107 > 40) goto L26;
            r103 = r103 + 1;
        L26:
            r104 = r105.toString();
            goto L27
        L5:
            if (r101.length == 0) goto L18;
            int r109 = 0;
        L9:
            if (r109 >= r101.length) goto L14;
            if ("saveBinderInfo".equals(r101[r109].getMethodName()) == true) goto L15;
            r109 = r109 + 1;
        L15:
            int r110 = r109 + 1;
            if (r110 > r101.length) goto L18;
            r101 = (StackTraceElement[]) Arrays.copyOfRange(r101, r110, r101.length);
            goto L18
        L14:
            r109 = 0;
            goto L15
        }
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public final void d(int r100) {
    }

    static {
        f265563e = new ArrayList(200);
        f265564f = new Object();
        f265565g = 0;
    }

    private static String getStacktrace() {
        return Log.getStackTraceString(new Exception());
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public final Pair<String, String> a() {
        return new Pair(this.f265559a, f265563e.toString());
    L4:
        return null;
    }

    public BinderMonitor(int r100) {
        super(r100, MonitorType.BINDER_MONITOR);
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public final Pair<String, String> b(long r110, long r111) {
        String r100 = this.f265559a;     // Catch: Throwable -> L26
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L26
        Object r102 = f265564f;     // Catch: Throwable -> L26
        monitor-enter(r102);     // Catch: Throwable -> L26
        int r103 = 0;
    L6:
        if (r103 >= 200) goto L10;
        int r104 = ((f265565g - 1) + r103) % 200;     // Catch: Throwable -> L23
        List<a> r105 = f265563e;     // Catch: Throwable -> L23
        if (r104 >= ((ArrayList) r105).size()) goto L10;
        r101.add(((ArrayList) r105).get(((f265565g - 1) + r103) % 200));     // Catch: Throwable -> L23
        r103 = r103 + 1;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L10:
        monitor-exit(r102);     // Catch: Throwable -> L23
        ArrayList r106 = new ArrayList();     // Catch: Throwable -> L26
        int r107 = r101.size();     // Catch: Throwable -> L26
    L12:
        r107 = r107 - 1;     // Catch: Throwable -> L26
        if (r107 < 0) goto L22;
        a r108 = (a) ListProtector.get(r101, r107);     // Catch: Throwable -> L26
        if (r108.f265566a <= r111) goto L17;
    L18:
        r106.add(r108);     // Catch: Throwable -> L26
    L20:
        if (r108.f265567b >= r110) goto L12;
    L17:
        if (r108.f265567b <= r110) goto L20;
    L22:
        return new Pair(r100, r106.toString());
    L26:
        return null;
    }

    public static void saveBinderInfo(long r100, long r101, long r102) {
        StackTraceElement[] r103 = ThreadMethodProxy.currentThread().getStackTrace();
        Object r104 = f265564f;
        monitor-enter(r104);
        List<a> r105 = f265563e;     // Catch: Throwable -> L11
        if (((ArrayList) r105).size() != 200) goto L7;
        a r106 = (a) ((ArrayList) r105).get(f265565g % 200);     // Catch: Throwable -> L11
        r106.f265566a = r100;     // Catch: Throwable -> L11
        r106.f265567b = r101;     // Catch: Throwable -> L11
        r106.f265568c = r102;     // Catch: Throwable -> L11
        r106.f265569d = r103;     // Catch: Throwable -> L11
    L8:
        f265565g++;     // Catch: Throwable -> L11
        monitor-exit(r104);     // Catch: Throwable -> L11
        return;
    L7:
        a r107 = new a();     // Catch: Throwable -> L11
        r107.f265566a = r100;     // Catch: Throwable -> L11
        r107.f265567b = r101;     // Catch: Throwable -> L11
        r107.f265568c = r102;     // Catch: Throwable -> L11
        r107.f265569d = r103;     // Catch: Throwable -> L11
        ((ArrayList) r105).add(r107);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
