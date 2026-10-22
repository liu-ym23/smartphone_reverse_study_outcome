package com.bytedance.bdnavigationsdk.navigation;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdnavigationsdk.c0;
import com.bytedance.bdnavigationsdk.contants.Constants;
import com.bytedance.bdnavigationsdk.network.route.RoutePath;
import com.bytedance.bdnavigationsdk.pojo.ProjectionResult;
import com.bytedance.bdnavigationsdk.pojo.YawResult;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class NavigationService {
    public long A;
    public final com.bytedance.bdnavigationsdk.network.report.c B;
    public final List<NavigationTurn$DirectionModifier> C;
    public NavigationStatus D;
    public y84.h E;
    public final Object F;
    public com.bytedance.bdnavigationsdk.navigation.a G;
    public b H;
    public n84.h I;
    public final String a;
    public final String b;
    public final NavigationTransport.TransportType c;
    public RoutePath d;
    public com.bytedance.bdnavigationsdk.pojo.a e;
    public List<RoutePath> f;
    public List<List<com.bytedance.bdnavigationsdk.pojo.d>> g;
    public float h;
    public float i;
    public List<com.bytedance.bdnavigationsdk.pojo.d> j;
    public float k;
    public float l;
    public List<com.bytedance.bdnavigationsdk.pojo.d> m;
    public List<m> n;
    public Map<Long, com.bytedance.bdnavigationsdk.pojo.c> o;
    public List<com.bytedance.bdnavigationsdk.pojo.c> p;
    public final y q;
    public boolean r;
    public Integer s;
    public int t;
    public boolean u;
    public boolean v;
    public boolean w;
    public long x;
    public long y;
    public long z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/bdnavigationsdk/navigation/NavigationService$NavigationEvent;", "", "<init>", "(Ljava/lang/String;I)V", "Start", "Stop", "YawDetected", "BeginRouteUpdate", "ApplyRouteUpdate", "CancelRouteUpdate", "ApplyYawRoute", "BDNavigationSDK_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum NavigationEvent extends Enum<NavigationEvent> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ NavigationEvent[] $VALUES = null;
        public static final NavigationEvent ApplyRouteUpdate = null;
        public static final NavigationEvent ApplyYawRoute = null;
        public static final NavigationEvent BeginRouteUpdate = null;
        public static final NavigationEvent CancelRouteUpdate = null;
        public static final NavigationEvent Start = null;
        public static final NavigationEvent Stop = null;
        public static final NavigationEvent YawDetected = null;

        public static EnumEntries<NavigationEvent> getEntries() {
            return $ENTRIES;
        }

        static {
            NavigationEvent r0 = new NavigationEvent("Start", 0);
            Start = r0;
            NavigationEvent r1 = new NavigationEvent("Stop", 1);
            Stop = r1;
            NavigationEvent r3 = new NavigationEvent("YawDetected", 2);
            YawDetected = r3;
            NavigationEvent r5 = new NavigationEvent("BeginRouteUpdate", 3);
            BeginRouteUpdate = r5;
            NavigationEvent r7 = new NavigationEvent("ApplyRouteUpdate", 4);
            ApplyRouteUpdate = r7;
            NavigationEvent r9 = new NavigationEvent("CancelRouteUpdate", 5);
            CancelRouteUpdate = r9;
            NavigationEvent r11 = new NavigationEvent("ApplyYawRoute", 6);
            ApplyYawRoute = r11;
            NavigationEvent[] r13 = {r0, r1, r3, r5, r7, r9, r11};
            $VALUES = r13;
            $ENTRIES = EnumEntriesKt.enumEntries(r13);
        }

        public static NavigationEvent[] values() {
            return (NavigationEvent[]) $VALUES.clone();
        }

        public static NavigationEvent valueOf(String r1) {
            return (NavigationEvent) r27.a.a(NavigationEvent.class, r1);
        }

        public NavigationEvent(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/bdnavigationsdk/navigation/NavigationService$NavigationStatus;", "", "statusCode", "", "<init>", "(Ljava/lang/String;II)V", "getStatusCode", "()I", "Stopped", "Running", "Yaw", "RouteUpdating", "BDNavigationSDK_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum NavigationStatus extends Enum<NavigationStatus> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ NavigationStatus[] $VALUES = null;
        public static final NavigationStatus RouteUpdating = null;
        public static final NavigationStatus Running = null;
        public static final NavigationStatus Stopped = null;
        public static final NavigationStatus Yaw = null;
        private final int statusCode;

        public static EnumEntries<NavigationStatus> getEntries() {
            return $ENTRIES;
        }

        static {
            NavigationStatus r0 = new NavigationStatus("Stopped", 0, 0);
            Stopped = r0;
            NavigationStatus r1 = new NavigationStatus("Running", 1, 1);
            Running = r1;
            NavigationStatus r3 = new NavigationStatus("Yaw", 2, 2);
            Yaw = r3;
            NavigationStatus r5 = new NavigationStatus("RouteUpdating", 3, 3);
            RouteUpdating = r5;
            NavigationStatus[] r7 = {r0, r1, r3, r5};
            $VALUES = r7;
            $ENTRIES = EnumEntriesKt.enumEntries(r7);
        }

        public static NavigationStatus[] values() {
            return (NavigationStatus[]) $VALUES.clone();
        }

        public final int getStatusCode() {
            return this.statusCode;
        }

        public static NavigationStatus valueOf(String r1) {
            return (NavigationStatus) r27.a.a(NavigationStatus.class, r1);
        }

        public NavigationStatus(String r1, int r2, int r3) {
            super(r1, r2);
            this.statusCode = r3;
        }
    }

    public static final class a {
    }

    public static final class b {
        public final n84.c a;
        public final n84.c b;
        public final List<n84.c> c;
        public final String d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "NavigationAgentRouteContext(origin=" + this.a + ", destination=" + this.b + ", waypoints=" + this.c + ", planType=" + this.d + ")";
        }

        public b(n84.c r2, n84.c r3, List<n84.c> r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "origin");
            Intrinsics.checkNotNullParameter(r3, "destination");
            Intrinsics.checkNotNullParameter(r4, "waypoints");
            Intrinsics.checkNotNullParameter(r5, "planType");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[NavigationEvent.values().length];
            r0[NavigationEvent.Start.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L56:
            r0[NavigationEvent.Stop.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L64:
            r0[NavigationEvent.YawDetected.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L42:
            r0[NavigationEvent.BeginRouteUpdate.ordinal()] = 4;     // Catch: NoSuchFieldError -> L27
        L44:
            r0[NavigationEvent.ApplyYawRoute.ordinal()] = 5;     // Catch: NoSuchFieldError -> L28
        L52:
            r0[NavigationEvent.ApplyRouteUpdate.ordinal()] = 6;     // Catch: NoSuchFieldError -> L29
        L58:
            r0[NavigationEvent.CancelRouteUpdate.ordinal()] = 7;     // Catch: NoSuchFieldError -> L30
        L13:
            a = r0;
            int[] r1 = new int[NavigationStatus.values().length];
            r1[NavigationStatus.Stopped.ordinal()] = 1;     // Catch: NoSuchFieldError -> L31
        L54:
            r1[NavigationStatus.Running.ordinal()] = 2;     // Catch: NoSuchFieldError -> L32
        L60:
            r1[NavigationStatus.Yaw.ordinal()] = 3;     // Catch: NoSuchFieldError -> L33
        L38:
            r1[NavigationStatus.RouteUpdating.ordinal()] = 4;     // Catch: NoSuchFieldError -> L34
        L18:
            b = r1;
            int[] r2 = new int[NavigationTransport.TransportType.values().length];
            r2[NavigationTransport.TransportType.Walking.ordinal()] = 1;     // Catch: NoSuchFieldError -> L35
        L40:
            r2[NavigationTransport.TransportType.Bicycling.ordinal()] = 2;     // Catch: NoSuchFieldError -> L36
        L48:
            r2[NavigationTransport.TransportType.EBicycling.ordinal()] = 3;     // Catch: NoSuchFieldError -> L37
        L22:
            c = r2;
        }
    }

    static {
    }

    public abstract void C(RoutePath r1, com.bytedance.bdnavigationsdk.pojo.a r2);

    public final void A() {
        com.bytedance.bdnavigationsdk.network.report.c r0 = this.B;     // Catch: Exception -> L13
        r0.getClass();     // Catch: Exception -> L13
        String r1 = ouc.w.a(new com.bytedance.bdnavigationsdk.network.report.b()).a(com.bytedance.bdnavigationsdk.network.report.c.Companion.serializer(), r0);     // Catch: Exception -> L6
    L8:
        if (r1 != null) goto L11;
        r84.a.b("导航结束日志上报失败：上报内容序列化失败", null, 5);     // Catch: Exception -> L13
        return;
    L11:
        com.bytedance.bdnavigationsdk.network.report.a r2 = com.bytedance.bdnavigationsdk.network.report.d.c();     // Catch: Exception -> L13
        int r3 = o84.a.a;     // Catch: Exception -> L13
        String r10 = new o84.b().a(r1, r2.b);     // Catch: Exception -> L13
        com.bytedance.bdnavigationsdk.b r4 = com.bytedance.bdnavigationsdk.d.a();     // Catch: Exception -> L13
        String r5 = r4.a;     // Catch: Exception -> L13
        String r6 = r4.e.a;     // Catch: Exception -> L13
        String r7 = r4.b;     // Catch: Exception -> L13
        String r8 = this.b;     // Catch: Exception -> L13
        String r9 = this.c.getCode();     // Catch: Exception -> L13
        String r11 = this.a;     // Catch: Exception -> L13
        int r12 = com.bytedance.bdnavigationsdk.utils.e.a;     // Catch: Exception -> L13
        com.bytedance.bdnavigationsdk.network.report.d.d(new com.bytedance.bdnavigationsdk.network.report.f(r5, r6, r7, r8, r9, r11, r10, System.currentTimeMillis()));     // Catch: Exception -> L13
        return;
    L6:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L13
        r1 = null;
    L13:
        e = move-exception;
        r84.a.b("导航结束日志上报失败", e, 1);
    }

    public final void F() {
        Object r0 = this.F;
        monitor-enter(r0);
        NavigationStatus r1 = w(this.D, NavigationEvent.Stop);     // Catch: Throwable -> L28
        if (r1 != null) goto L8;
        monitor-exit(r0);
        return;
    L8:
        boolean r2 = this.u;     // Catch: Throwable -> L28
        this.u = false;     // Catch: Throwable -> L28
        List<RoutePath> r4 = this.f;     // Catch: Throwable -> L28
        if (r4 == null) goto L14;
        Iterator<T> r5 = r4.iterator();     // Catch: Throwable -> L28
    L12:
        if (r5.hasNext() == false) goto L14;
        this.B.a.f.add(((RoutePath) r5.next()).a);     // Catch: Throwable -> L28
    L14:
        com.bytedance.bdnavigationsdk.network.report.e r6 = this.B.a;     // Catch: Throwable -> L28
        if (r2 == false) goto L17;
        List<String> r3 = CollectionsKt.mutableListOf(new String[]{Constants.Auto.getValue(), String.valueOf(this.k)});     // Catch: Throwable -> L28
    L18:
        r6.getClass();     // Catch: Throwable -> L28
        Intrinsics.checkNotNullParameter(r3, "<set-?>");     // Catch: Throwable -> L28
        r6.h = r3;     // Catch: Throwable -> L28
        int r7 = com.bytedance.bdnavigationsdk.utils.e.a;     // Catch: Throwable -> L28
        this.y = System.currentTimeMillis();     // Catch: Throwable -> L28
        n84.b r8 = d();     // Catch: Throwable -> L28
        com.bytedance.bdnavigationsdk.network.report.e r9 = this.B.a;     // Catch: Throwable -> L28
        r9.b = this.x;     // Catch: Throwable -> L28
        r9.c = this.y;     // Catch: Throwable -> L28
        r9.d = this.z;     // Catch: Throwable -> L28
        r9.e = this.A;     // Catch: Throwable -> L28
        i(r1);     // Catch: Throwable -> L28
        if (r8 == null) goto L23;
        com.bytedance.bdnavigationsdk.navigation.a r10 = this.G;     // Catch: Throwable -> L28
        if (r10 == null) goto L23;
        r10.e(r8);     // Catch: Throwable -> L28
    L23:
        this.I = null;     // Catch: Throwable -> L28
        this.H = null;     // Catch: Throwable -> L28
        A();     // Catch: Throwable -> L28
        com.bytedance.bdnavigationsdk.navigation.a r11 = this.G;     // Catch: Throwable -> L28
        if (r11 == null) goto L26;
        r11.b();     // Catch: Throwable -> L28
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L28
    L26:
        monitor-exit(r0);
        return;
    L17:
        r3 = CollectionsKt.mutableListOf(new String[]{Constants.Manual.getValue(), String.valueOf(this.k)});     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    }

    public final boolean c() {
        Object r0 = this.F;
        monitor-enter(r0);
        NavigationStatus r1 = w(this.D, NavigationEvent.BeginRouteUpdate);     // Catch: Throwable -> L13
        if (r1 != null) goto L9;
        monitor-exit(r0);
        return false;
    L9:
        i(r1);     // Catch: Throwable -> L13
        monitor-exit(r0);
        return true;
    L13:
        th = move-exception;
        throw th;
    }

    public final n84.b d() {
        b r0 = this.H;
        if (r0 != null) goto L5;
        return null;
    L5:
        k r2 = m();
        List r7 = (List) y(r2).component1();
        List<com.bytedance.bdnavigationsdk.pojo.d> r3 = this.j;
        if (r3 != null) goto L8;
        r3 = CollectionsKt.emptyList();
    L8:
        List<com.bytedance.bdnavigationsdk.pojo.d> r4 = r3;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r6 = r4.iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        r5.add(Integer.valueOf(((com.bytedance.bdnavigationsdk.pojo.d) r6.next()).d));
        goto L10
    L12:
        List r8 = CollectionsKt.distinct(r5);
        RoutePath r9 = this.d;
        if (r9 == null) goto L15;
        List<com.bytedance.bdnavigationsdk.network.route.q> r10 = r9.d;
    L16:
        if (r10 != null) goto L18;
        r10 = CollectionsKt.emptyList();
    L18:
        ArrayList r14 = new ArrayList();
        Iterator r11 = r8.iterator();
    L20:
        if (r11.hasNext() == false) goto L32;
        com.bytedance.bdnavigationsdk.network.route.q r12 = (com.bytedance.bdnavigationsdk.network.route.q) CollectionsKt.getOrNull(r10, ((Number) r11.next()).intValue());
        if (r12 == null) goto L28;
        String r13 = r12.b;
        if (r13 == null) goto L28;
        if ((!StringsKt.isBlank(r13)) == false) goto L28;
    L29:
        if (r13 == null) goto L20;
        r14.add(r13);
    L28:
        r13 = null;
        goto L29
    L32:
        return new n84.b(r2.c, r2.b, r7, r0.a, r0.b, this.x, this.y, r14);
    L15:
        r10 = null;
        goto L16
    }

    public final boolean g() {
        Object r0 = this.F;
        monitor-enter(r0);
        NavigationStatus r1 = w(this.D, NavigationEvent.CancelRouteUpdate);     // Catch: Throwable -> L13
        if (r1 != null) goto L9;
        monitor-exit(r0);
        return false;
    L9:
        i(r1);     // Catch: Throwable -> L13
        monitor-exit(r0);
        return true;
    L13:
        th = move-exception;
        throw th;
    }

    public final com.bytedance.bdnavigationsdk.pojo.d j() {
        List<com.bytedance.bdnavigationsdk.pojo.d> r0 = this.j;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L10;
        return null;
    L10:
        List<com.bytedance.bdnavigationsdk.pojo.d> r2 = this.j;
        Intrinsics.checkNotNull(r2);
        List<com.bytedance.bdnavigationsdk.pojo.d> r3 = this.j;
        Intrinsics.checkNotNull(r3);
        return (com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r2, r3.size() - 1);
    L5:
        if (r0.isEmpty() != true) goto L7;
        r1 = true;
        goto L7
    }

    public final n84.d l() {
        Object r0 = this.F;
        monitor-enter(r0);
        n84.h r1 = this.I;     // Catch: Throwable -> L11
        if (r1 == null) goto L8;
        n84.d r2 = r1.a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);
        return r2;
    L8:
        r2 = null;
    L11:
        th = move-exception;
        throw th;
    }

    public final k m() {
        Object r0 = this.F;
        monitor-enter(r0);
        int r1 = p.a;     // Catch: Throwable -> L7
        k r9 = new k(p.a(this.j), this.h, this.i, p.a(this.m), this.k, this.l, CollectionsKt.toList(this.n));     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r9;
    L7:
        th = move-exception;
        throw th;
    }

    public final int n() {
        Object r0 = this.F;
        monitor-enter(r0);
        int r1 = this.D.getStatusCode();     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public final List<com.bytedance.bdnavigationsdk.pojo.c> o() {
        ArrayList r0 = new ArrayList();
        List<com.bytedance.bdnavigationsdk.pojo.c> r1 = this.p;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return r0;
    L11:
        com.bytedance.bdnavigationsdk.e r3 = r84.a.a;
        List<com.bytedance.bdnavigationsdk.pojo.c> r4 = this.p;
        Intrinsics.checkNotNull(r4);
        r84.a.a("onRouteNavigation PendingLocations, " + r4.size());
        List<com.bytedance.bdnavigationsdk.pojo.c> r5 = this.p;
        Intrinsics.checkNotNull(r5);
        r0.addAll(r5);
        List<com.bytedance.bdnavigationsdk.pojo.c> r6 = this.p;
        if (r6 == null) goto L14;
        r6.clear();
    L14:
        return r0;
    L5:
        if (r1.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }

    public final n84.g f(RoutePath r14) {
        b r0 = this.H;
        Long r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        com.bytedance.bdnavigationsdk.network.route.e r2 = r14.c;
        if (r2 == null) goto L8;
        Float r8 = Float.valueOf(r2.a);
    L9:
        n84.c r4 = r0.a;
        n84.c r5 = r0.b;
        List<n84.c> r6 = r0.c;
        String r7 = r0.d;
        float r9 = r14.b;
        long r10 = this.x;
        if (r8 == null) goto L13;
        r1 = Long.valueOf(this.x + ((long) (r8.floatValue() * 1000.0f)));
    L13:
        return new n84.g(r4, r5, r6, r7, r8, r9, r10, r1);
    L8:
        r8 = null;
        goto L9
    }

    public final void h(ProjectionResult r15) {
        Intrinsics.checkNotNullParameter(r15, "nearest");
        int r0 = r15.e;
        int r7 = r15.f;
        com.bytedance.bdnavigationsdk.pojo.a r2 = r15.b;
        com.bytedance.bdnavigationsdk.pojo.a r16 = r15.d;
        new com.bytedance.bdnavigationsdk.pojo.d(r2, r16, r0, r7, 2032);
    L3:
        List<com.bytedance.bdnavigationsdk.pojo.d> r1 = this.m;
        Intrinsics.checkNotNull(r1);
        if (r1.size() <= 0) goto L34;
        List<com.bytedance.bdnavigationsdk.pojo.d> r3 = this.m;
        Intrinsics.checkNotNull(r3);
        com.bytedance.bdnavigationsdk.pojo.d r4 = (com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r3, 0);
        int r5 = r4.c;
        if (r5 > r0) goto L35;
        if (r5 < r0) goto L9;
        int r6 = r4.d;
        if (r6 > r7) goto L36;
        if (r6 >= r7) goto L16;
        List<com.bytedance.bdnavigationsdk.pojo.d> r8 = this.j;
        Intrinsics.checkNotNull(r8);
        r8.add(r4);
        this.h += r4.e;
        this.i += r4.f;
        List<com.bytedance.bdnavigationsdk.pojo.d> r9 = this.m;
        Intrinsics.checkNotNull(r9);
        ListProtector.remove(r9, 0);
        this.k -= r4.e;
        this.l -= r4.f;
        goto L3
    L16:
        if (Intrinsics.areEqual(r4.a, r16) == false) goto L19;
        return;
    L19:
        if (Intrinsics.areEqual(r4.b, r16) == false) goto L21;
        List<com.bytedance.bdnavigationsdk.pojo.d> r17 = this.j;
        Intrinsics.checkNotNull(r17);
        r17.add(r4);
        this.h += r4.e;
        this.i += r4.f;
        List<com.bytedance.bdnavigationsdk.pojo.d> r18 = this.m;
        Intrinsics.checkNotNull(r18);
        ListProtector.remove(r18, 0);
        this.k -= r4.e;
        this.l -= r4.f;
        return;
    L21:
        com.bytedance.bdnavigationsdk.pojo.d r10 = new com.bytedance.bdnavigationsdk.pojo.d(r4.a, r16, r4.c, r4.d, 2032);
        com.bytedance.bdnavigationsdk.pojo.d r11 = new com.bytedance.bdnavigationsdk.pojo.d(r16, r4.b, r4.c, r4.d, 2032);
        float r19 = r10.e;
        float r12 = r4.e;
        r10.f = (r19 / r12) * r4.f;
        r11.f = (r11.e / r12) * r4.f;
        List<com.bytedance.bdnavigationsdk.pojo.d> r110 = this.j;
        Intrinsics.checkNotNull(r110);
        r110.add(r10);
        this.h += r10.e;
        this.i += r10.f;
        List<com.bytedance.bdnavigationsdk.pojo.d> r111 = this.m;
        Intrinsics.checkNotNull(r111);
        ListProtector.set(r111, 0, r11);
        this.k -= r10.e;
        this.l -= r10.f;
        return;
    L36:
        return;
    L9:
        List<com.bytedance.bdnavigationsdk.pojo.d> r13 = this.j;
        Intrinsics.checkNotNull(r13);
        r13.add(r4);
        this.h += r4.e;
        this.i += r4.f;
        List<com.bytedance.bdnavigationsdk.pojo.d> r14 = this.m;
        Intrinsics.checkNotNull(r14);
        ListProtector.remove(r14, 0);
        this.k -= r4.e;
        this.l -= r4.f;
        goto L3
    L35:
        return;
    }

    public final void i(NavigationStatus r5) {
        NavigationStatus r0 = this.D;
        this.D = r5;
        com.bytedance.bdnavigationsdk.e r1 = r84.a.a;
        r84.a.d(null, "Navigation status transition: " + r0.name() + " -> " + r5.name(), 5);
        com.bytedance.bdnavigationsdk.navigation.a r2 = this.G;
        if (r2 == null) goto L6;
        r2.h(r5.getStatusCode());
        return;
    }

    public final ProjectionResult k(com.bytedance.bdnavigationsdk.pojo.a r18) {
        Intrinsics.checkNotNullParameter(r18, LocationMonitorConst.LOCATION);
        com.bytedance.bdnavigationsdk.pojo.d r1 = j();
        List<com.bytedance.bdnavigationsdk.pojo.d> r3 = this.m;
        if (r3 == null) goto L7;
        boolean r5 = true;
        if (r3.isEmpty() != true) goto L7;
    L9:
        if (r5 == false) goto L11;
        com.bytedance.bdnavigationsdk.pojo.d r4 = null;
    L12:
        if (r1 != null) goto L15;
        if (r4 != null) goto L15;
        return null;
    L15:
        if (r1 == null) goto L18;
        com.bytedance.bdnavigationsdk.pojo.a r6 = r1.a;
        com.bytedance.bdnavigationsdk.pojo.a r7 = r1.b;
        int r8 = r1.c;
        int r9 = r1.d;
        int r10 = w84.c.a;
        Intrinsics.checkNotNull(r7);
        return new ProjectionResult(r18, r6, r7, r7, r8, r9, (float) w84.c.b(r18, r7), r1.e, ProjectionResult.Position.AFTER, true, 0, 3072);
    L18:
        Intrinsics.checkNotNull(r4);
        com.bytedance.bdnavigationsdk.pojo.a r11 = r4.a;
        com.bytedance.bdnavigationsdk.pojo.a r12 = r4.b;
        int r13 = r4.c;
        int r14 = r4.d;
        int r2 = w84.c.a;
        Intrinsics.checkNotNull(r11);
        return new ProjectionResult(r18, r11, r12, r11, r13, r14, (float) w84.c.b(r18, r11), 0.0f, ProjectionResult.Position.BEFORE, true, 0, 2048);
    L11:
        List<com.bytedance.bdnavigationsdk.pojo.d> r15 = this.m;
        Intrinsics.checkNotNull(r15);
        r4 = (com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r15, 0);
    L7:
        r5 = false;
        goto L9
    }

    public final int p(int r6) {
        RoutePath r0 = this.d;
        if (r0 == null) goto L5;
        List<com.bytedance.bdnavigationsdk.network.route.i> r1 = r0.g;
    L6:
        List<com.bytedance.bdnavigationsdk.network.route.i> r2 = r1;
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
        return 0;
    L15:
        RoutePath r4 = this.d;
        Intrinsics.checkNotNull(r4);
        int r5 = r4.g.size();
        int r7 = 0;
    L16:
        if (r7 >= r5) goto L28;
        RoutePath r8 = this.d;
        Intrinsics.checkNotNull(r8);
        com.bytedance.bdnavigationsdk.network.route.i r9 = (com.bytedance.bdnavigationsdk.network.route.i) ListProtector.get(r8.g, r7);
        if (r9.a > r6) goto L22;
        if (r6 >= r9.b) goto L22;
        return r7;
    L22:
        r7 = r7 + 1;
        goto L16
    L28:
        return 0;
    L9:
        if (r2.isEmpty() == true) goto L12;
        r3 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final float q(int r6) {
        List<com.bytedance.bdnavigationsdk.pojo.d> r0 = this.m;
        Intrinsics.checkNotNull(r0);
        int r1 = r0.size();
        float r2 = 0.0f;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L8;
        List<com.bytedance.bdnavigationsdk.pojo.d> r4 = this.m;
        Intrinsics.checkNotNull(r4);
        com.bytedance.bdnavigationsdk.pojo.d r5 = (com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r4, r3);
        if (r5.d > r6) goto L8;
        r2 = r2 + r5.e;
        r3 = r3 + 1;
    L8:
        return r2;
    }

    public final v t(j r11) {
        v r0 = u(3);
        if (r0 == null) goto L39;
        String r1 = r0.a;
        RoutePath r3 = this.d;
        if (r3 == null) goto L13;
        List<com.bytedance.bdnavigationsdk.network.route.h> r4 = r3.e;
        if (r4 == null) goto L13;
        com.bytedance.bdnavigationsdk.network.route.h r5 = (com.bytedance.bdnavigationsdk.network.route.h) CollectionsKt.lastOrNull(r4);
        if (r5 == null) goto L13;
        com.bytedance.bdnavigationsdk.pojo.a r6 = r5.a;
        if (r6 == null) goto L13;
    L16:
        com.bytedance.bdnavigationsdk.pojo.b r7 = r11.a;
        if (r7 != null) goto L19;
    L37:
        String r12 = "附近";
    L38:
        String r13 = StringsKt.replace$default(r1, "${destination_direction}", r12, false, 4, null);
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r0.a = r13;
        return r0;
    L19:
        if (r7.c == null) goto L37;
        com.bytedance.bdnavigationsdk.pojo.a r8 = r11.b;
        if (r8 == null) goto L37;
        if (w84.c.b(r8, r6) < 5.0d) goto L37;
        double r9 = ((w84.c.a(r8, r6) - ((double) r11.c)) + 360.0d) % 360.0d;
        if (r9 <= 210.0d) goto L33;
        if (r9 >= 330.0d) goto L33;
        r12 = "左侧";
    L33:
        if (r9 <= 30.0d) goto L37;
        if (r9 >= 150.0d) goto L37;
        r12 = "右侧";
    L13:
        r6 = this.e;
        if (r6 != null) goto L16;
    L39:
        return null;
    }

    public final v u(int r6) {
        RoutePath r0 = this.d;
        if (r0 == null) goto L27;
        List<com.bytedance.bdnavigationsdk.network.route.g> r1 = r0.f;
        if (r1 == null) goto L27;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L15;
        Object r3 = r2.next();
        if (((com.bytedance.bdnavigationsdk.network.route.g) r3).getType() != r6) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == false) goto L8;
    L16:
        com.bytedance.bdnavigationsdk.network.route.g r5 = (com.bytedance.bdnavigationsdk.network.route.g) r3;
        if (r5 == null) goto L27;
        String r7 = r5.b;
        if (r7 == null) goto L27;
        if ((!StringsKt.isBlank(r7)) == true) goto L24;
        r7 = null;
    L24:
        if (r7 == null) goto L27;
        return new v(r7);
    L12:
        r4 = false;
        goto L13
    L15:
        r3 = null;
    L27:
        return null;
    }

    public final com.bytedance.bdnavigationsdk.pojo.b v(com.bytedance.bdnavigationsdk.pojo.c r13) {
        Intrinsics.checkNotNullParameter(r13, LocationMonitorConst.LOCATION);
        if (r13.a == 1) goto L5;
    L7:
        boolean r4 = false;
    L8:
        Map<Long, com.bytedance.bdnavigationsdk.pojo.c> r1 = this.o;
        Intrinsics.checkNotNull(r1);
        int r2 = r1.size();
        com.bytedance.bdnavigationsdk.pojo.a r5 = r13.d;
        Intrinsics.checkNotNull(r5);
        com.bytedance.bdnavigationsdk.pojo.b r0 = new com.bytedance.bdnavigationsdk.pojo.b(r2, r4, r5, r13.a, r13.c, r13.g, r13.e, r13.f);
        Map<Long, com.bytedance.bdnavigationsdk.pojo.c> r3 = this.o;
        Intrinsics.checkNotNull(r3);
        r3.put(Long.valueOf(r13.g), r13);
        if (this.z != 0) goto L11;
        this.z = r13.g;
    L11:
        this.A = r13.g;
        com.bytedance.bdnavigationsdk.e r14 = r84.a.a;
        r84.a.a("BDLocation newLocation, idx " + r2 + ", " + r0);
        return r0;
    L5:
        if (r13.c != 1) goto L7;
        r4 = true;
        goto L8
    }

    public final void x(com.bytedance.bdnavigationsdk.pojo.c r23) {
        Intrinsics.checkNotNullParameter(r23, "locationInfo");
        Object r8 = this.F;
        monitor-enter(r8);
        com.bytedance.bdnavigationsdk.pojo.b r2 = v(r23);     // Catch: Throwable -> L227
        if (this.D == NavigationStatus.Running) goto L11;
        r84.a.b("onRouteNavigation error: status is not running", null, 5);     // Catch: Throwable -> L227
        Intrinsics.checkNotNullParameter(r23, LocationMonitorConst.LOCATION);     // Catch: Throwable -> L227
        List<com.bytedance.bdnavigationsdk.pojo.c> r1 = this.p;     // Catch: Throwable -> L227
        if (r1 == null) goto L9;
        r1.add(r23);     // Catch: Throwable -> L227
    L9:
        monitor-exit(r8);
        return;
    L11:
        YawResult.ErrCode r3 = YawResult.ErrCode.SUCCESS;     // Catch: Throwable -> L227
        com.bytedance.bdnavigationsdk.pojo.a r4 = r2.c;     // Catch: Throwable -> L227
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L227
        ProjectionResult r5 = k(r4);     // Catch: Throwable -> L227
        if (r5 != null) goto L14;
    L224:
        r84.a.b("onRouteNavigation error: nearest or routePath is null", null, 5);     // Catch: Throwable -> L227
        monitor-exit(r8);
        return;
    L14:
        if (this.d == null) goto L224;
        int r6 = 0;
        j r7 = new j(0);     // Catch: Throwable -> L227
        r7.a = r2;     // Catch: Exception -> L30 Throwable -> L227
        r7.b = r5.d;     // Catch: Exception -> L30 Throwable -> L227
        r7.e = r5.e;     // Catch: Exception -> L30 Throwable -> L227
        r7.d = r5.j;     // Catch: Exception -> L30 Throwable -> L227
        y84.h r9 = this.E;     // Catch: Exception -> L30 Throwable -> L227
        Intrinsics.checkNotNull(r9);     // Catch: Exception -> L30 Throwable -> L227
        r9.a(o());     // Catch: Exception -> L30 Throwable -> L227
        y84.h r10 = this.E;     // Catch: Exception -> L30 Throwable -> L227
        Intrinsics.checkNotNull(r10);     // Catch: Exception -> L30 Throwable -> L227
        r10.e(r23);     // Catch: Exception -> L30 Throwable -> L227
        y84.h r0 = this.E;     // Catch: Exception -> L30 Throwable -> L227
        Intrinsics.checkNotNull(r0);     // Catch: Exception -> L30 Throwable -> L227
        YawResult r11 = r0.c();     // Catch: Exception -> L30 Throwable -> L227
        r3 = r11.a;     // Catch: Exception -> L30 Throwable -> L227
        YawResult.c r12 = r11.b;     // Catch: Exception -> L30 Throwable -> L227
        if (r3 == YawResult.ErrCode.SYSTEM_ERROR) goto L32;
        if (r12 == null) goto L32;
        ProjectionResult r13 = r12.c;     // Catch: Exception -> L30 Throwable -> L227
        if (r13 == null) goto L32;
        if (r12.a == false) goto L233;
        boolean r14 = true;
    L33:
        com.bytedance.bdnavigationsdk.pojo.a r15 = r5.b;     // Catch: Throwable -> L227
        com.bytedance.bdnavigationsdk.pojo.a r16 = r5.c;     // Catch: Throwable -> L227
        if (r15 == null) goto L37;
        if (r16 == null) goto L37;
        r7.c = (float) w84.c.a(r15, r16);     // Catch: Throwable -> L227
    L37:
        com.bytedance.bdnavigationsdk.e r17 = r84.a.a;     // Catch: Throwable -> L227
        r84.a.a("NavigationLocation location = " + r7.a());     // Catch: Throwable -> L227
        com.bytedance.bdnavigationsdk.pojo.d r18 = j();     // Catch: Throwable -> L227
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L227
        int r19 = r5.f;     // Catch: Throwable -> L227
        RoutePath r110 = this.d;     // Catch: Throwable -> L227
        Intrinsics.checkNotNull(r110);     // Catch: Throwable -> L227
        List<com.bytedance.bdnavigationsdk.network.route.q> r111 = r110.d;     // Catch: Throwable -> L227
        Intrinsics.checkNotNull(r111);     // Catch: Throwable -> L227
        com.bytedance.bdnavigationsdk.network.route.q r112 = (com.bytedance.bdnavigationsdk.network.route.q) ListProtector.get(r111, r19);     // Catch: Throwable -> L227
        h(r5);     // Catch: Throwable -> L227
        float r113 = r112.c;     // Catch: Throwable -> L227
        com.bytedance.bdnavigationsdk.network.route.e r114 = r112.d;     // Catch: Throwable -> L227
        Intrinsics.checkNotNull(r114);     // Catch: Throwable -> L227
        float r115 = r114.a;     // Catch: Throwable -> L227
        float r116 = q(r19);     // Catch: Throwable -> L227
        List<com.bytedance.bdnavigationsdk.pojo.d> r20 = this.m;     // Catch: Throwable -> L227
        Intrinsics.checkNotNull(r20);     // Catch: Throwable -> L227
        int r21 = r20.size();     // Catch: Throwable -> L227
        float r117 = 0.0f;
    L38:
        if (r6 >= r21) goto L43;
        List<com.bytedance.bdnavigationsdk.pojo.d> r118 = this.m;     // Catch: Throwable -> L227
        Intrinsics.checkNotNull(r118);     // Catch: Throwable -> L227
        com.bytedance.bdnavigationsdk.pojo.d r119 = (com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r118, r6);     // Catch: Throwable -> L227
        if (r119.d > r19) goto L43;
        r117 = r117 + r119.f;     // Catch: Throwable -> L227
        r6 = r6 + 1;     // Catch: Throwable -> L227
    L43:
        RangesKt.coerceAtLeast(r113 - r116, 0.0f);     // Catch: Throwable -> L227
        RangesKt.coerceAtLeast(r115 - r117, 0.0f);     // Catch: Throwable -> L227
        k r22 = m();     // Catch: Throwable -> L227
        float r24 = r22.e;     // Catch: Throwable -> L227
        int r120 = z.a;     // Catch: Throwable -> L227
        h r121 = z.b(r112.e, r116);     // Catch: Throwable -> L227
        if (r121 != null) goto L47;
        r121 = new h(0, 0, null, 63);     // Catch: Throwable -> L227
    L47:
        if (c.c[this.c.ordinal()] == 1) goto L49;
        float r122 = 20.0f;
    L51:
        if (r24 > r122) goto L53;
        boolean r123 = true;
    L65:
        if (r123 == false) goto L94;
        RoutePath r124 = this.d;     // Catch: Throwable -> L227
        if (r124 == null) goto L73;
        List<com.bytedance.bdnavigationsdk.network.route.q> r125 = r124.d;     // Catch: Throwable -> L227
        if (r125 == null) goto L73;
        com.bytedance.bdnavigationsdk.network.route.q r126 = (com.bytedance.bdnavigationsdk.network.route.q) CollectionsKt.lastOrNull(r125);     // Catch: Throwable -> L227
        if (r126 == null) goto L73;
        List<com.bytedance.bdnavigationsdk.network.route.t> r127 = r126.e;     // Catch: Throwable -> L227
    L74:
        if (r127 == null) goto L90;
        Iterator<T> r128 = r127.iterator();     // Catch: Throwable -> L227
    L77:
        if (r128.hasNext() == false) goto L86;
        Object r129 = r128.next();     // Catch: Throwable -> L227
        com.bytedance.bdnavigationsdk.network.route.t r130 = (com.bytedance.bdnavigationsdk.network.route.t) r129;     // Catch: Throwable -> L227
        if (r130.b == 3) goto L81;
    L83:
        boolean r25 = false;
    L84:
        if (r25 == false) goto L77;
    L87:
        com.bytedance.bdnavigationsdk.network.route.t r131 = (com.bytedance.bdnavigationsdk.network.route.t) r129;     // Catch: Throwable -> L227
        if (r131 == null) goto L90;
        r121 = z.a(r131, null);     // Catch: Throwable -> L227
    L91:
        if (r121 != null) goto L94;
        r121 = new h(2, 5, InstructionAction.ActionType.Arrived.getDescription(), 52);     // Catch: Throwable -> L227
        goto L94
    L81:
        if (r130.a != 0) goto L83;
        r25 = true;
        goto L84
    L86:
        r129 = null;
    L90:
        r121 = null;
    L73:
        r127 = null;
    L94:
        if (s(r19, r116) == false) goto L96;
        final Integer r26 = Integer.valueOf(p(r19));     // Catch: Throwable -> L227
    L97:
        if (r18 == null) goto L99;
    L104:
        v r27 = null;
    L106:
        if (r14 == false) goto L108;
        r27 = u(4);     // Catch: Throwable -> L227
    L134:
        v r132 = r27;
        Integer r133 = null;
        boolean r28 = false;
    L136:
        if (this.w == false) goto L138;
        r132 = z(r132, r19);     // Catch: Throwable -> L227
        this.w = false;     // Catch: Throwable -> L227
    L138:
        v r29 = r132;
        if (r26 == null) goto L145;
        CollectionsKt.removeAll(this.n, new l(r26));     // Catch: Throwable -> L227
        List<m> r30 = CollectionsKt.toList(this.n);     // Catch: Throwable -> L227
        Intrinsics.checkNotNullParameter(r30, "<set-?>");     // Catch: Throwable -> L227
        r22.g = r30;     // Catch: Throwable -> L227
        if ((!this.n.isEmpty()) == false) goto L143;
        y84.h r31 = this.E;     // Catch: Throwable -> L227
        Intrinsics.checkNotNull(r31);     // Catch: Throwable -> L227
        r31.f(this.n.get(0).a);     // Catch: Throwable -> L227
        goto L145
    L143:
        y84.h r32 = this.E;     // Catch: Throwable -> L227
        Intrinsics.checkNotNull(r32);     // Catch: Throwable -> L227
        RoutePath r134 = this.d;     // Catch: Throwable -> L227
        Intrinsics.checkNotNull(r134);     // Catch: Throwable -> L227
        r32.f(CollectionsKt.getLastIndex(r134.g));     // Catch: Throwable -> L227
    L145:
        String r135 = this.a;     // Catch: Throwable -> L227
        RoutePath r136 = this.d;     // Catch: Throwable -> L227
        Intrinsics.checkNotNull(r136);     // Catch: Throwable -> L227
        Integer r210 = r133;
        g r33 = new g(r135, r136.a, r7, r22, r121, r29);     // Catch: Throwable -> L227
        if (r123 == false) goto L148;
        this.u = true;     // Catch: Throwable -> L227
        r33.c = 9;     // Catch: Throwable -> L227
    L150:
        int r34 = 3;
    L162:
        com.bytedance.bdnavigationsdk.e r35 = r84.a.a;     // Catch: Throwable -> L227
        r84.a.d(null, "navigationCode = " + r33.c, 5);     // Catch: Throwable -> L227
        k r36 = r33.e;     // Catch: Throwable -> L227
        if (r36 != null) goto L165;
    L164:
        v r137 = r29;
    L177:
        com.bytedance.bdnavigationsdk.navigation.a r37 = this.G;     // Catch: Throwable -> L227
        if (r37 == null) goto L180;
        r37.c(r33);     // Catch: Throwable -> L227
    L180:
        Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.LOCATION);     // Catch: Throwable -> L227
        com.bytedance.bdnavigationsdk.navigation.a r38 = this.G;     // Catch: Throwable -> L227
        if (r38 == null) goto L183;
        r38.g(r7, r22);     // Catch: Throwable -> L227
    L183:
        if (r137 == null) goto L200;
        Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.LOCATION);     // Catch: Throwable -> L227
        com.bytedance.bdnavigationsdk.navigation.a r39 = this.G;     // Catch: Throwable -> L227
        if (r39 != null) goto L187;
        boolean r40 = false;
    L188:
        if (r40 == false) goto L191;
        if (r28 == false) goto L191;
        this.r = true;     // Catch: Throwable -> L227
    L191:
        if (r40 == true) goto L193;
    L195:
        r84.a.a("NotificationInstruction location = " + r7.a() + ", instruction = " + r137.a);     // Catch: Throwable -> L227
        com.bytedance.bdnavigationsdk.pojo.b r41 = r7.a;     // Catch: Throwable -> L227
        if (r41 == null) goto L198;
        Integer r42 = Integer.valueOf(r41.a);     // Catch: Throwable -> L227
    L199:
        r84.a.d(null, "NotificationInstruction location idx = " + r42 + ", instruction = " + r137.a, 5);     // Catch: Throwable -> L227
        goto L200
    L198:
        r42 = null;
        goto L199
    L193:
        if (r210 == null) goto L195;
        this.s = r210;     // Catch: Throwable -> L227
        goto L195
    L187:
        r39.d(r7, r137);     // Catch: Throwable -> L227
        r40 = true;
    L200:
        Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.LOCATION);     // Catch: Throwable -> L227
        com.bytedance.bdnavigationsdk.navigation.a r43 = this.G;     // Catch: Throwable -> L227
        if (r43 == null) goto L203;
        r43.f(r7, r121);     // Catch: Throwable -> L227
    L203:
        r84.a.a("NavigationInstruction location = " + r7.a() + ", instruction = " + r121.a());     // Catch: Throwable -> L227
        com.bytedance.bdnavigationsdk.pojo.b r44 = r7.a;     // Catch: Throwable -> L227
        if (r44 == null) goto L206;
        Integer r45 = Integer.valueOf(r44.a);     // Catch: Throwable -> L227
    L207:
        r84.a.d(null, "NavigationInstruction location idx = " + r45 + ", instruction = " + r121.a(), 5);     // Catch: Throwable -> L227
        if (r14 == false) goto L216;
        Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.LOCATION);     // Catch: Throwable -> L227
        NavigationStatus r46 = w(this.D, NavigationEvent.YawDetected);     // Catch: Throwable -> L227
        if (r46 == null) goto L215;
        this.v = false;     // Catch: Throwable -> L227
        i(r46);     // Catch: Throwable -> L227
        com.bytedance.bdnavigationsdk.navigation.a r47 = this.G;     // Catch: Throwable -> L227
        if (r47 == null) goto L215;
        r47.j(r7);     // Catch: Throwable -> L227
    L215:
        r84.a.a("NavigationYaw location = " + r7.a());     // Catch: Throwable -> L227
    L216:
        if (r123 == false) goto L221;
        Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.LOCATION);     // Catch: Throwable -> L227
        com.bytedance.bdnavigationsdk.navigation.a r48 = this.G;     // Catch: Throwable -> L227
        if (r48 == null) goto L220;
        r48.a(r7);     // Catch: Throwable -> L227
    L220:
        r84.a.a("NavigationArrive location = " + r7.a());     // Catch: Throwable -> L227
    L221:
        Unit r49 = Unit.INSTANCE;     // Catch: Throwable -> L227
        monitor-exit(r8);
        return;
    L206:
        r45 = null;
        goto L207
    L165:
        h r138 = r33.f;     // Catch: Throwable -> L227
        if (r138 == null) goto L164;
        Pair<List<n84.c>, List<n84.c>> r139 = y(r36);     // Catch: Throwable -> L227
        List<n84.c> r140 = (List) r139.component1();     // Catch: Throwable -> L227
        List<n84.c> r141 = (List) r139.component2();     // Catch: Throwable -> L227
        n84.h r142 = this.I;     // Catch: Throwable -> L227
        if (r142 == null) goto L164;
        int r50 = r33.c;     // Catch: Throwable -> L227
        if (r50 == r34) goto L175;
        if (r50 == 6) goto L175;
        boolean r143 = false;
    L176:
        r137 = r29;
        r142.update(e(r36, r138, r143, r140, r141));     // Catch: Throwable -> L227
    L175:
        r143 = true;
        goto L176
    L148:
        if (r14 == false) goto L152;
        r33.c = 4;     // Catch: Throwable -> L227
        goto L150
    L152:
        if (r7.d == true) goto L154;
    L158:
        r34 = 3;
    L160:
        if (r5.k == false) goto L162;
        r33.c = 6;     // Catch: Throwable -> L227
        goto L162
    L154:
        if (r3 != YawResult.ErrCode.SUCCESS) goto L158;
        if (r5.k == true) goto L158;
        r34 = 3;
        r33.c = 3;     // Catch: Throwable -> L227
        goto L160
    L108:
        if (r27 != null) goto L134;
        if (r123 == true) goto L111;
        if (r26 == null) goto L122;
        v r144 = u(2);     // Catch: Throwable -> L227
        if (r144 == null) goto L120;
        Integer r145 = r26;
    L121:
        Integer r146 = r145;
        r132 = r144;
        boolean r147 = false;
    L133:
        r28 = r147;
        r133 = r146;
        goto L136
    L120:
        r145 = null;
        goto L121
    L122:
        Integer r148 = this.s;     // Catch: Throwable -> L227
        int r149 = p(r19);     // Catch: Throwable -> L227
        if (r148 != null) goto L126;
    L128:
        boolean r150 = false;
    L129:
        if (r150 == false) goto L132;
    L130:
        r147 = false;
        r132 = null;
    L131:
        r146 = null;
        goto L133
    L132:
        r132 = this.q.a(r19, r112, r116);     // Catch: Throwable -> L227
        r147 = false;
        goto L131
    L126:
        if (r148.intValue() != r149) goto L128;
        r150 = true;
        goto L129
    L111:
        if (this.r == true) goto L130;
        v r151 = t(r7);     // Catch: Throwable -> L227
        if (r151 == null) goto L130;
        r132 = r151;
        r147 = true;
        goto L131
    L99:
        if (this.v == false) goto L104;
        this.v = false;     // Catch: Throwable -> L227
        r84.a.d(null, "Enter new reroute", 5);     // Catch: Throwable -> L227
        v r51 = u(5);     // Catch: Throwable -> L227
        if (r51 == null) goto L103;
        String r152 = r7.a();     // Catch: Throwable -> L227
        String r153 = r51.a;     // Catch: Throwable -> L227
        StringBuilder r154 = new StringBuilder();     // Catch: Throwable -> L227
        r27 = r51;
        r154.append("RerouteNotification location = ");     // Catch: Throwable -> L227
        r154.append(r152);     // Catch: Throwable -> L227
        r154.append(", instruction = ");     // Catch: Throwable -> L227
        r154.append(r153);     // Catch: Throwable -> L227
        r84.a.a(r154.toString());     // Catch: Throwable -> L227
        goto L106
    L103:
        r27 = r51;
        goto L106
    L96:
        r26 = null;
        goto L97
    L53:
        RoutePath r52 = this.d;     // Catch: Throwable -> L227
        Intrinsics.checkNotNull(r52);     // Catch: Throwable -> L227
        List<com.bytedance.bdnavigationsdk.network.route.q> r53 = r52.d;     // Catch: Throwable -> L227
        Intrinsics.checkNotNull(r53);     // Catch: Throwable -> L227
        if (r19 != (r53.size() - 1)) goto L56;
        boolean r54 = true;
    L57:
        if (r54 == true) goto L60;
        r123 = false;
        goto L65
    L60:
        if (r116 > r122) goto L62;
        boolean r55 = true;
    L63:
        r123 = r55;
        goto L65
    L62:
        r55 = false;
        goto L63
    L56:
        r54 = false;
        goto L57
    L49:
        r122 = 15.0f;
        goto L51
    L233:
        r7.b = r13.d;     // Catch: Exception -> L28 Throwable -> L227
        r7.e = r13.e;     // Catch: Exception -> L28 Throwable -> L227
        r7.d = r13.j;     // Catch: Exception -> L28 Throwable -> L227
        r5 = r13;
    L28:
        e = e;
        r5 = r13;
    L31:
        List<String> r56 = this.B.a.g;     // Catch: Throwable -> L227
        String r155 = e.getMessage();     // Catch: Throwable -> L227
        Intrinsics.checkNotNull(r155);     // Catch: Throwable -> L227
        r56.add(r155);     // Catch: Throwable -> L227
        r84.a.b("onRouteNavigation error", e, 1);     // Catch: Throwable -> L227
    L32:
        r14 = false;
    L30:
        e = e;
    L227:
        th = move-exception;
        throw th;
    }

    public final Pair<List<n84.c>, List<n84.c>> y(k r9) {
        b r0 = this.H;
        if (r0 == null) goto L5;
        List<n84.c> r1 = r0.c;
    L6:
        if (r1 != null) goto L8;
        r1 = CollectionsKt.emptyList();
    L8:
        List<m> r10 = r9.g;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r11 = r10.iterator();
    L10:
        if (r11.hasNext() == false) goto L12;
        r2.add(Integer.valueOf(((m) r11.next()).a));
        goto L10
    L12:
        Set r12 = CollectionsKt.toSet(r2);
        List<n84.c> r3 = r1;
        ArrayList r4 = new ArrayList();
        Iterator<T> r5 = r3.iterator();
        int r6 = 0;
        int r7 = 0;
    L14:
        if (r5.hasNext() == false) goto L22;
        Object r8 = r5.next();
        int r13 = r7 + 1;
        if (r7 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        n84.c r14 = (n84.c) r8;
        if ((!r12.contains(Integer.valueOf(r7))) == false) goto L21;
        r4.add(r8);
    L21:
        r7 = r13;
        goto L14
    L22:
        ArrayList r15 = new ArrayList();
        Iterator<T> r16 = r3.iterator();
    L24:
        if (r16.hasNext() == false) goto L33;
        Object r17 = r16.next();
        int r18 = r6 + 1;
        if (r6 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        n84.c r19 = (n84.c) r17;
        if (r12.contains(Integer.valueOf(r6)) == false) goto L31;
        r15.add(r17);
    L31:
        r6 = r18;
        goto L24
    L33:
        return TuplesKt.to(r4, r15);
    L5:
        r1 = null;
        goto L6
    }

    public static NavigationStatus w(NavigationStatus r3, NavigationEvent r4) {
        int r5 = c.b[r3.ordinal()];
        if (r5 == 1) goto L35;
        if (r5 == 2) goto L26;
        if (r5 == 3) goto L19;
        if (r5 != 4) goto L18;
        int r6 = c.a[r4.ordinal()];
        if (r6 == 2) goto L40;
        if (r6 == 6) goto L39;
        if (r6 == 7) goto L39;
    L37:
        return null;
    L39:
        return NavigationStatus.Running;
    L40:
        return NavigationStatus.Stopped;
    L18:
        throw new NoWhenBranchMatchedException();
    L19:
        int r7 = c.a[r4.ordinal()];
        if (r7 == 2) goto L42;
        if (r7 != 5) goto L37;
        return NavigationStatus.Running;
    L42:
        return NavigationStatus.Stopped;
    L26:
        int r8 = c.a[r4.ordinal()];
        if (r8 == 2) goto L45;
        if (r8 == 3) goto L44;
        if (r8 != 4) goto L37;
        return NavigationStatus.RouteUpdating;
    L44:
        return NavigationStatus.Yaw;
    L45:
        return NavigationStatus.Stopped;
    L35:
        if (c.a[r4.ordinal()] != 1) goto L37;
        return NavigationStatus.Running;
    }

    public final void B(RoutePath r4, com.bytedance.bdnavigationsdk.pojo.a r5) {
        int r0 = this.t + 1;
        this.t = r0;
        com.bytedance.bdnavigationsdk.e r1 = r84.a.a;
        r84.a.d(null, "Start Navigation " + r0, 5);
        C(r4, r5);
    }

    public final void D(RoutePath r7, com.bytedance.bdnavigationsdk.pojo.a r8) {
        y84.h r0 = this.E;
        Intrinsics.checkNotNull(r0);
        List<com.bytedance.bdnavigationsdk.pojo.b> r1 = r0.d(10);
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        com.bytedance.bdnavigationsdk.pojo.b r4 = (com.bytedance.bdnavigationsdk.pojo.b) r3.next();
        Map<Long, com.bytedance.bdnavigationsdk.pojo.c> r5 = this.o;
        Intrinsics.checkNotNull(r5);
        com.bytedance.bdnavigationsdk.pojo.c r6 = r5.get(Long.valueOf(r4.f));
        if (r6 == null) goto L8;
        com.bytedance.bdnavigationsdk.pojo.c r9 = com.bytedance.bdnavigationsdk.pojo.c.a(r6);
    L9:
        if (r9 == null) goto L4;
        r2.add(r9);
        goto L4
    L8:
        r9 = null;
        goto L9
    L11:
        B(r7, r8);
        List<com.bytedance.bdnavigationsdk.pojo.c> r10 = this.p;
        Intrinsics.checkNotNull(r10);
        r10.clear();
        List<com.bytedance.bdnavigationsdk.pojo.c> r11 = this.p;
        Intrinsics.checkNotNull(r11);
        r11.addAll(r2);
    }

    public final void E(com.bytedance.bdnavigationsdk.network.route.j r5, RoutePath r6) {
        Intrinsics.checkNotNullParameter(r5, "routePlanParam");
        Intrinsics.checkNotNullParameter(r6, "routePath");
        Object r0 = this.F;
        monitor-enter(r0);
        NavigationStatus r1 = w(this.D, NavigationEvent.Start);     // Catch: Throwable -> L17
        if (r1 == null) goto L16;
        this.u = false;     // Catch: Throwable -> L17
        this.w = true;     // Catch: Throwable -> L17
        this.r = false;     // Catch: Throwable -> L17
        this.s = null;     // Catch: Throwable -> L17
        int r2 = com.bytedance.bdnavigationsdk.utils.e.a;     // Catch: Throwable -> L17
        this.x = System.currentTimeMillis();     // Catch: Throwable -> L17
        B(r6, r5.e);     // Catch: Throwable -> L17
        r(r5, r6);     // Catch: Throwable -> L17
        i(r1);     // Catch: Throwable -> L17
        n84.g r7 = f(r6);     // Catch: Throwable -> L17
        if (r7 == null) goto L14;
        com.bytedance.bdnavigationsdk.navigation.a r8 = this.G;     // Catch: Throwable -> L17
        if (r8 == null) goto L11;
        r8.i(r7);     // Catch: Throwable -> L17
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L17
    L11:
        monitor-exit(r0);
        return;
    L14:
        throw new Exception("导航状态错误");     // Catch: Throwable -> L17
    L16:
        throw new Exception("导航状态错误");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public final boolean a(com.bytedance.bdnavigationsdk.network.route.j r4, RoutePath r5) {
        Intrinsics.checkNotNullParameter(r4, "routePlanParam");
        Intrinsics.checkNotNullParameter(r5, "routePath");
        Object r0 = this.F;
        monitor-enter(r0);
        NavigationStatus r1 = w(this.D, NavigationEvent.ApplyRouteUpdate);     // Catch: Throwable -> L12
        if (r1 != null) goto L9;
        monitor-exit(r0);
        return false;
    L9:
        D(r5, r4.e);     // Catch: Throwable -> L12
        r(r4, r5);     // Catch: Throwable -> L12
        this.v = true;     // Catch: Throwable -> L12
        i(r1);     // Catch: Throwable -> L12
        monitor-exit(r0);
        return true;
    L12:
        th = move-exception;
        throw th;
    }

    public final boolean b(com.bytedance.bdnavigationsdk.network.route.j r4, RoutePath r5) {
        Intrinsics.checkNotNullParameter(r4, "routePlanParam");
        Intrinsics.checkNotNullParameter(r5, "routePath");
        Object r0 = this.F;
        monitor-enter(r0);
        NavigationStatus r1 = w(this.D, NavigationEvent.ApplyYawRoute);     // Catch: Throwable -> L12
        if (r1 != null) goto L9;
        monitor-exit(r0);
        return false;
    L9:
        D(r5, r4.e);     // Catch: Throwable -> L12
        r(r4, r5);     // Catch: Throwable -> L12
        this.v = true;     // Catch: Throwable -> L12
        i(r1);     // Catch: Throwable -> L12
        monitor-exit(r0);
        return true;
    L12:
        th = move-exception;
        throw th;
    }

    public final void r(com.bytedance.bdnavigationsdk.network.route.j r12, RoutePath r13) {
        n84.c r0 = new n84.c(com.bytedance.bdnavigationsdk.pojo.a.a(r12.d), r12.f, r12.i, null);
        n84.c r1 = new n84.c(com.bytedance.bdnavigationsdk.pojo.a.a(r12.e), r12.g, r12.j, null);
        List<com.bytedance.bdnavigationsdk.network.route.v> r2 = r12.k;
        if (r2 != null) goto L5;
        r2 = CollectionsKt.emptyList();
    L5:
        List<com.bytedance.bdnavigationsdk.network.route.v> r3 = r2;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r5 = r3.iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        com.bytedance.bdnavigationsdk.network.route.v r6 = (com.bytedance.bdnavigationsdk.network.route.v) r5.next();
        r4.add(new n84.c(com.bytedance.bdnavigationsdk.pojo.a.a(r6.a), r6.c, r6.b, r6.d));
        goto L7
    L9:
        b r7 = new b(r0, r1, r4, r12.c);
        this.H = r7;
        k r8 = m();
        List<com.bytedance.bdnavigationsdk.network.route.q> r14 = r13.d;
        if (r14 == null) goto L12;
        com.bytedance.bdnavigationsdk.network.route.q r15 = (com.bytedance.bdnavigationsdk.network.route.q) CollectionsKt.firstOrNull(r14);
    L14:
        if (r15 == null) goto L17;
        int r9 = z.a;
        h r16 = z.b(r15.e, q(0));
        if (r16 == null) goto L17;
    L18:
        this.I = new n84.h(e(r8, r16, false, CollectionsKt.emptyList(), r7.c));
        return;
    L17:
        r16 = new h(0, 0, null, 63);
        goto L18
    L12:
        r15 = null;
        goto L14
    }

    public final boolean s(int r5, float r6) {
        RoutePath r0 = this.d;
        if (r0 == null) goto L5;
        List<com.bytedance.bdnavigationsdk.network.route.i> r1 = r0.g;
    L6:
        List<com.bytedance.bdnavigationsdk.network.route.i> r2 = r1;
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == true) goto L18;
        int r4 = p(r5);
        RoutePath r7 = this.d;
        Intrinsics.checkNotNull(r7);
        if (r5 != (((com.bytedance.bdnavigationsdk.network.route.i) ListProtector.get(r7.g, r4)).b - 1)) goto L18;
        boolean r8 = true;
    L19:
        if (r8 == true) goto L21;
        return false;
    L21:
        NavigationTransport.TransportType r9 = this.c;
        if (c.c[r9.ordinal()] == 1) goto L24;
        float r10 = 30.0f;
    L26:
        if (r6 <= r10) goto L28;
        return false;
    L28:
        int r11 = p(r5);
        List<m> r12 = this.n;
        if ((r12 instanceof Collection) == true) goto L31;
    L33:
        Iterator<T> r13 = r12.iterator();
    L35:
        if (r13.hasNext() == false) goto L32;
        if (((m) r13.next()).a != r11) goto L39;
        boolean r14 = true;
    L40:
        if (r14 == false) goto L35;
        return true;
    L39:
        r14 = false;
    L32:
        return false;
    L31:
        if (r12.isEmpty() == false) goto L33;
    L24:
        r10 = 20.0f;
    L18:
        r8 = false;
        goto L19
    L9:
        if (r2.isEmpty() == true) goto L12;
        r3 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final v z(v r18, int r19) {
        v r4 = u(1);
        String r6 = null;
        boolean r7 = false;
        if (r4 == null) goto L12;
        if (r19 != 0) goto L6;
        boolean r8 = true;
    L7:
        if (r8 == true) goto L10;
        r4 = null;
    L10:
        if (r4 == null) goto L12;
    L13:
        String[] r2 = new String[2];
        String r5 = r4.a;
        if (r5.length() <= 0) goto L16;
        boolean r9 = true;
    L17:
        if (r9 == true) goto L20;
        r5 = null;
    L20:
        r2[0] = r5;
        if (r18 == null) goto L29;
        String r10 = r18.a;
        if (r10 == null) goto L29;
        if (r10.length() <= 0) goto L27;
        r7 = true;
    L27:
        if (r7 == false) goto L29;
        r6 = r10;
    L29:
        r2[1] = r6;
        List r3 = CollectionsKt.listOfNotNull(r2);
        if (r3.isEmpty() == false) goto L33;
        return r18;
    L33:
        return new v(CollectionsKt.joinToString$default(r3, ",", null, null, 0, null, null, 62, null));
    L16:
        r9 = false;
        goto L17
    L6:
        r8 = false;
    L12:
        InstructionAction.ActionMode r11 = InstructionAction.ActionMode.FromContentToType;
        String r12 = new InstructionAction(r11, InstructionAction.ActionType.Start, this.c.getDescription()).a();
        InstructionAction.ActionType r13 = InstructionAction.ActionType.Depart;
        InstructionAction.ActionMode r14 = InstructionAction.ActionMode.FromTypeToContent;
        InstructionAction.ActionType r15 = InstructionAction.ActionType.Toward;
        RoutePath r16 = this.d;
        Intrinsics.checkNotNull(r16);
        List<com.bytedance.bdnavigationsdk.network.route.q> r17 = r16.d;
        Intrinsics.checkNotNull(r17);
        String r20 = ((com.bytedance.bdnavigationsdk.network.route.q) ListProtector.get(r17, r19)).a;
        Intrinsics.checkNotNull(r20);
        r4 = new v(CollectionsKt.joinToString$default(CollectionsKt.listOf(new String[]{r12, new InstructionAction(r11, r13, new InstructionAction(r14, r15, r20).a()).a()}), ",", null, null, 0, null, null, 62, null));
        goto L13
    }

    public NavigationService(String r16, String r17, NavigationTransport.TransportType r18) {
        Intrinsics.checkNotNullParameter(r16, "navigationSessionId");
        Intrinsics.checkNotNullParameter(r17, "navigationBusinessId");
        Intrinsics.checkNotNullParameter(r18, "navigationTransport");
        this.a = r16;
        this.b = r17;
        this.c = r18;
        this.n = new ArrayList();
        this.q = new y();
        com.bytedance.bdnavigationsdk.network.report.e r12 = new com.bytedance.bdnavigationsdk.network.report.e(new com.bytedance.bdnavigationsdk.network.config.b(null), new ArrayList(), new ArrayList(), new ArrayList());
        String r5 = com.bytedance.bdnavigationsdk.d.a().a;
        String r6 = com.bytedance.bdnavigationsdk.d.a().b;
        String r7 = com.bytedance.bdnavigationsdk.d.a().e.a;
        String r8 = com.bytedance.bdnavigationsdk.d.a().e.b;
        String r9 = com.bytedance.bdnavigationsdk.d.a().e.c;
        String r10 = com.bytedance.bdnavigationsdk.d.a().e.d;
        String r11 = com.bytedance.bdnavigationsdk.d.a().e.e;
        Integer r2 = com.bytedance.bdnavigationsdk.d.a().e.f;
        if (r2 == null) goto L5;
        String r14 = r2.toString();
    L6:
        int r3 = c0.a;
        Intrinsics.areEqual("0.0.1-rc.44", Constants.Unspecified.getValue());
        com.bytedance.bdnavigationsdk.network.report.c r0 = new com.bytedance.bdnavigationsdk.network.report.c(r12, new com.bytedance.bdnavigationsdk.network.report.k(r5, r17, r6, r7, r8, r9, r10, r11, r14));
        this.B = r0;
        this.C = CollectionsKt.mutableListOf(new NavigationTurn$DirectionModifier[]{NavigationTurn$DirectionModifier.UTurn, NavigationTurn$DirectionModifier.SharpRight, NavigationTurn$DirectionModifier.Right, NavigationTurn$DirectionModifier.Left, NavigationTurn$DirectionModifier.SharpLeft});
        this.F = new Object();
        this.u = false;
        this.v = false;
        this.w = true;
        this.D = NavigationStatus.Stopped;
        r0.a.a.a = com.bytedance.bdnavigationsdk.network.report.d.c();
        com.bytedance.bdnavigationsdk.network.config.b r1 = r0.a.a;
        Object r4 = y84.o.a;
        monitor-enter(r4);
        ArrayList r13 = new ArrayList();     // Catch: Throwable -> L16
        Iterator r15 = ((LinkedHashMap) y84.o.b).entrySet().iterator();     // Catch: Throwable -> L16
    L10:
        if (r15.hasNext() == false) goto L13;
        r13.add(((y84.i) ((Map.Entry) r15.next()).getValue()).b());     // Catch: Throwable -> L16
        goto L10
    L13:
        monitor-exit(r4);
        r1.b = r13;
        return;
    L16:
        th = move-exception;
        throw th;
    L5:
        r14 = null;
        goto L6
    }

    public final n84.d e(k r33, h r34, boolean r35, List<n84.c> r36, List<n84.c> r37) {
        b r3 = this.H;
        if (r3 == null) goto L29;
        RoutePath r5 = this.d;
        if (r5 == null) goto L27;
        int r4 = com.bytedance.bdnavigationsdk.utils.e.a;
        long r7 = System.currentTimeMillis();
        n84.c r10 = r3.a;
        n84.c r11 = r3.b;
        String r12 = r3.d;
        List<n84.c> r13 = r3.c;
        float r14 = r5.b;
        com.bytedance.bdnavigationsdk.network.route.e r6 = r5.c;
        if (r6 == null) goto L9;
        float r8 = r6.a;
    L10:
        float r15 = r8;
        List<com.bytedance.bdnavigationsdk.network.route.q> r9 = r5.d;
        if (r9 != null) goto L13;
        r9 = CollectionsKt.emptyList();
    L13:
        ArrayList r16 = new ArrayList();
        Iterator<T> r17 = r9.iterator();
    L15:
        if (r17.hasNext() == false) goto L25;
        String r18 = ((com.bytedance.bdnavigationsdk.network.route.q) r17.next()).b;
        if (r18 != null) goto L19;
    L21:
        r18 = null;
    L22:
        if (r18 == null) goto L15;
        r16.add(r18);
        goto L15
    L19:
        if ((!StringsKt.isBlank(r18)) == false) goto L21;
    L25:
        return new n84.d(r7, r35, r10, r11, r12, r13, r14, r15, r16, r33.b, r33.c, r33.e, r33.f, r36, r37, new n84.a(r34.a, r34.b, r34.c, r34.d, r34.e, r34.f, r34.a()));
    L9:
        r8 = r33.c + r33.f;
        goto L10
    L27:
        throw new IllegalStateException("Required value was null.".toString());
    L29:
        throw new IllegalStateException("Required value was null.".toString());
    }
}
