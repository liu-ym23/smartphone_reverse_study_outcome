package com.f.android.quality.impl;

import com.f.android.quality.base.QualityLogger;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.network.http.ServiceType;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes22.dex */
public final class Scene implements rt7.c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f274068i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.f.android.quality.impl.b f274069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f274070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, f> f274071c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f274072d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f274073e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile String f274074f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile String f274075g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile String f274076h;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f274077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f274078b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f274079c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L12;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f274077a, r101.f274077a) == true) goto L8;
            return false;
        L8:
            if (this.f274078b == r101.f274078b) goto L10;
            return false;
        L10:
            if (this.f274079c == r101.f274079c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v5 */
        public final int hashCode() {
            String r100 = this.f274077a;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L6:
            long r102 = this.f274078b;
            int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
            boolean r104 = this.f274079c;
            ?? r105 = r104;
            if (r104 == false) goto L10;
            r105 = 1;
        L10:
            return r103 + r105;
        L5:
            r101 = 0;
            goto L6
        }

        public final String toString() {
            return "TimeTagBean(id=" + this.f274077a + ", time=" + this.f274078b + ", isStart=" + this.f274079c + ")";
        }

        public b(String r100, long r101, boolean r102) {
            this.f274077a = r100;
            this.f274078b = r101;
            this.f274079c = r102;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Scene f274080a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f274081b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map f274082c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function1 f274083d;

        public c(Scene r100, String r101, Map r102, Function1 r103) {
            this.f274080a = r100;
            this.f274081b = r101;
            this.f274082c = r102;
            this.f274083d = r103;
        }

        public final void a() {
            Scene r100 = this.f274080a;
            String r101 = this.f274081b;
            r100.getClass();
            int r102 = d.f274091g;
            String r103 = r100.f274074f;
            String r104 = r100.f274075g;
            String r105 = r100.f274076h;
            if (r104 != null) goto L6;
            r104 = "unknown";
        L6:
            if (r105 != null) goto L9;
            r105 = "unknown";
        L9:
            d r106 = new d(r101, r103, r104, r105);
            Map<String, Object> r107 = this.f274080a.f274072d;
            boolean r108 = false;
            if (r107 != null) goto L12;
        L15:
            boolean r109 = true;
        L16:
            if (r109 == true) goto L19;
            r106.f274092a.putAll(r107);
        L19:
            Map<? extends String, ? extends Object> r110 = this.f274082c;
            if (r110 != null) goto L22;
        L23:
            r108 = true;
        L24:
            if (r108 == true) goto L27;
            r106.f274092a.putAll(r110);
        L27:
            Function1 r111 = this.f274083d;
            if (r111 == null) goto L30;
            Unit r112 = (Unit) r111.invoke(r106);
        L30:
            int r113 = com.f.android.quality.base.c.f274065a;
            rt7.a r114 = com.f.android.quality.base.a.f274060a;
            Lazy r115 = QualityLogger.f274059a;
            rt7.b r116 = com.f.android.quality.base.a.f274061b;
            if (r116 != null) goto L34;
            r116 = (rt7.b) QualityLogger.f274059a.getValue();
        L34:
            r116.d("ReporterWrapper doReport, reportEnable: true");
            com.f.android.quality.base.b r117 = new com.f.android.quality.base.b(r106);
            com.f.android.quality.base.d.f274066a.execute(r117);
            return;
        L22:
            if (r110.isEmpty() == false) goto L24;
        L12:
            if (((ConcurrentHashMap) r107).isEmpty() == true) goto L15;
            r109 = false;
            goto L16
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final String toString() {
        return "Scene(" + this.f274074f + ',' + this.f274075g + ',' + this.f274076h + ')';
    }

    public Scene(String r100, String r101) {
        this.f274074f = ServiceType.AUDIO;
        this.f274075g = r100;
        this.f274076h = r101;
        this.f274069a = new com.f.android.quality.impl.b();
        this.f274070b = new LinkedHashSet();
        this.f274071c = new ConcurrentHashMap();
        this.f274072d = new ConcurrentHashMap();
    }

    public static String a(String r100, String r101) {
        StringBuilder r102 = new StringBuilder();
        r102.append(r100);
        r102.append("_");
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        r101 = "NULL";
    L11:
        r102.append(r101);
        return r102.toString();
    L5:
        if (StringsKt.isBlank(r101) == true) goto L8;
        r103 = false;
        goto L9
    }

    public final void c(final String r100, Map<String, ? extends Object> r101) {
        b("fh_dev_event", r101, new Scene$onEvent$1(r100));
    }

    public final void h(Map<String, ? extends Object> r100, long r101) {
        e(true, null, null, r100, r101);
    }

    public final void b(String r100, Map<String, ? extends Object> r101, Function1<? super d, Unit> r102) {
        rt7.a r103 = com.f.android.quality.base.a.f274060a;
        c r104 = new c(this, r100, r101, r102);
        com.f.android.quality.base.d.f274067b.execute(r104);
    }

    public final void g(final String r100, String r101, Map<String, ? extends Object> r102) {
        String r103 = a(r100, r101);
        f r104 = new f(r100, r101);
        monitor-enter(r104);
        r104.f274098a = false;     // Catch: Throwable -> L9
        r104.f274099b.b();     // Catch: Throwable -> L9
        monitor-exit(r104);
        ((ConcurrentHashMap) this.f274071c).put(r103, r104);
        b("fh_dev_step_start", r102, new Scene$onStepStart$1(r100));
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void d(int r100, String r101, Map<String, ? extends Object> r110, long r111) {
        e(false, Integer.valueOf(r100), r101, r110, r111);
    }

    @Override // rt7.c
    public synchronized void update(String r100, String r101, String r102, Collection<String> r103) {
        monitor-enter(this);
        if (r100 != null) goto L17;
    L5:
        if (r101 == null) goto L7;
        this.f274075g = r101;     // Catch: Throwable -> L14
    L7:
        if (r102 == null) goto L9;
        this.f274076h = r102;     // Catch: Throwable -> L14
    L9:
        if (r103 != null) goto L11;
        this.f274070b.clear();     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return;
    L11:
        this.f274070b.clear();     // Catch: Throwable -> L14
        this.f274070b.addAll(r103);     // Catch: Throwable -> L14
        goto L12
    L17:
        this.f274074f = r100;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public final void e(final boolean r110, final Integer r111, final String r112, Map<String, ? extends Object> r113, final long r114) {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (this.f274073e == false) goto L13;
        Lazy r115 = QualityLogger.f274059a;     // Catch: Throwable -> L20
        String r116 = this + " already finished";     // Catch: Throwable -> L20
        rt7.a r117 = com.f.android.quality.base.a.f274060a;     // Catch: Throwable -> L20
        rt7.b r118 = com.f.android.quality.base.a.f274061b;     // Catch: Throwable -> L20
        if (r118 != null) goto L9;
        r118 = (rt7.b) QualityLogger.f274059a.getValue();     // Catch: Throwable -> L20
    L9:
        r118.w(r116);     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L13:
        this.f274073e = true;     // Catch: Throwable -> L20
        this.f274069a.a();     // Catch: Throwable -> L20
        Unit r100 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(this);
        if (r110 == false) goto L17;
        String r101 = "fh_dev_scene_success";
    L18:
        b(r101, r113, new Scene$onSceneFinish$2(this, r114, r110, r111, r112));
        return;
    L17:
        r101 = "fh_dev_scene_failure";
        goto L18
    }

    public final void f(final String r110, final String r111, final boolean r112, final Integer r113, final String r114, Map<String, ? extends Object> r115) {
        final f r100 = (f) ((ConcurrentHashMap) this.f274071c).get(a(r110, r111));
        if (r100 == null) goto L25;
        monitor-enter(r100);
    L22:
        th = move-exception;
        throw th;
    L6:
        if (r100.f274098a == false) goto L14;
        Lazy r116 = QualityLogger.f274059a;     // Catch: Throwable -> L22
        String r117 = r100 + " already finished";     // Catch: Throwable -> L22
        rt7.a r118 = com.f.android.quality.base.a.f274060a;     // Catch: Throwable -> L22
        rt7.b r119 = com.f.android.quality.base.a.f274061b;     // Catch: Throwable -> L22
        if (r119 != null) goto L11;
        r119 = (rt7.b) QualityLogger.f274059a.getValue();     // Catch: Throwable -> L22
    L11:
        r119.w(r117);     // Catch: Throwable -> L22
        monitor-exit(r100);
        return;
    L14:
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r100);
        r100.a();
        if (r112 == false) goto L19;
        String r102 = "fh_dev_step_success";
    L20:
        b(r102, r115, new Scene$onStepFinish$2(r100, r110, r111, r112, r113, r114));
        return;
    L19:
        r102 = "fh_dev_step_failure";
        goto L20
    }
}
