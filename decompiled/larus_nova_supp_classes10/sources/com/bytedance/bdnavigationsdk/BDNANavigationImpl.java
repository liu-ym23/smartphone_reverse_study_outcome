package com.bytedance.bdnavigationsdk;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdnavigationsdk.navigation.NavigationService;
import com.bytedance.bdnavigationsdk.navigation.NavigationTransport;
import com.bytedance.bdnavigationsdk.network.route.PoiType;
import com.bytedance.bdnavigationsdk.network.route.RoutePath;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class BDNANavigationImpl implements f, com.bytedance.bdnavigationsdk.navigation.a {
    public final com.bytedance.bdnavigationsdk.utils.a b;
    public final Object c;
    public NavigationService d;
    public NavigationTransport.TransportType e;
    public w f;
    public com.bytedance.bdnavigationsdk.network.route.j g;
    public List<com.bytedance.bdnavigationsdk.network.route.v> h;
    public com.bytedance.bdnavigationsdk.network.route.o i;
    public b j;
    public com.bytedance.bdnavigationsdk.pojo.c k;
    public long l;
    public boolean m;
    public final int n;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final int b;
        public final com.bytedance.bdnavigationsdk.network.route.j c;

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
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "PendingRouteUpdate(routeUpdateId=" + this.a + ", reason=" + this.b + ", routePlanParam=" + this.c + ")";
        }

        public b(String r2, int r3, com.bytedance.bdnavigationsdk.network.route.j r4) {
            Intrinsics.checkNotNullParameter(r2, "routeUpdateId");
            Intrinsics.checkNotNullParameter(r4, "routePlanParam");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    static {
    }

    @Override // com.bytedance.bdnavigationsdk.navigation.a
    public final void b() {
        n(new l());
    }

    public final void m() {
        Object r0 = this.c;
        monitor-enter(r0);
        this.g = null;     // Catch: Throwable -> L18
        this.h = CollectionsKt.emptyList();     // Catch: Throwable -> L18
        this.j = null;     // Catch: Throwable -> L18
        this.k = null;     // Catch: Throwable -> L18
        this.m = true;     // Catch: Throwable -> L18
        this.e = null;     // Catch: Throwable -> L18
        NavigationService r3 = this.d;     // Catch: Throwable -> L18
        if (r3 == null) goto L8;
        Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L18
        r3.G = null;     // Catch: Throwable -> L18
        NavigationService r4 = this.d;     // Catch: Throwable -> L18
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L18
        r4.F();     // Catch: Throwable -> L18
        this.d = null;     // Catch: Throwable -> L18
    L8:
        com.bytedance.bdnavigationsdk.network.route.o r5 = this.i;     // Catch: Throwable -> L18
        if (r5 == null) goto L14;
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L18
        JobKt.cancel$default(r5.c.getCoroutineContext(), null, 1, null);     // Catch: Throwable -> L18
        c r6 = r5.a;     // Catch: Throwable -> L18
        if (r6 == null) goto L13;
        r6.close();     // Catch: Throwable -> L18
    L13:
        this.i = null;     // Catch: Throwable -> L18
    L14:
        this.f = null;     // Catch: Throwable -> L18
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r0);
        com.bytedance.bdnavigationsdk.utils.a r1 = this.b;
        r1.b.cancel(null);
        CoroutineScopeKt.cancel$default(r1.a, null, 1, null);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public final String t() {
        Object r0 = this.c;
        monitor-enter(r0);
        NavigationService r1 = this.d;     // Catch: Throwable -> L19
        if (r1 != null) goto L7;
    L9:
        boolean r2 = false;
    L11:
        if (r2 == false) goto L14;
        if (r1 == null) goto L14;
        n84.d r3 = r1.l();     // Catch: Throwable -> L19
    L15:
        n84.f r4 = new n84.f(r2, r3);     // Catch: Throwable -> L19
        monitor-exit(r0);
        return r4.a();
    L14:
        r3 = null;
        goto L15
    L7:
        if (r1.n() == 0) goto L9;
        r2 = true;
    L19:
        th = move-exception;
        throw th;
    }

    public final void y() {
        Object r0 = this.c;
        monitor-enter(r0);
        NavigationService r1 = this.d;     // Catch: Throwable -> L11 Exception -> L13
        if (r1 != null) goto L9;
        monitor-exit(r0);
        return;
    L9:
        this.j = null;     // Catch: Throwable -> L11 Exception -> L13
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L11 Exception -> L13
        r1.F();     // Catch: Throwable -> L11 Exception -> L13
        NavigationService r2 = this.d;     // Catch: Throwable -> L11 Exception -> L13
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L11 Exception -> L13
        r2.G = null;     // Catch: Throwable -> L11 Exception -> L13
        this.d = null;     // Catch: Throwable -> L11 Exception -> L13
    L15:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r0);
        return;
    L13:
        e = move-exception;
        v(e);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public BDNANavigationImpl() {
        this.b = new com.bytedance.bdnavigationsdk.utils.a();
        this.c = new Object();
        this.h = CollectionsKt.emptyList();
        this.m = true;
        this.n = 1;
        this.i = new com.bytedance.bdnavigationsdk.network.route.o();
    }

    public static List l(List r6) {
        if (r6 == null) goto L8;
        List r7 = r6;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r8 = r7.iterator();
    L5:
        if (r8.hasNext() == false) goto L10;
        com.bytedance.bdnavigationsdk.network.route.v r1 = (com.bytedance.bdnavigationsdk.network.route.v) r8.next();
        r0.add(new com.bytedance.bdnavigationsdk.network.route.v(com.bytedance.bdnavigationsdk.pojo.a.a(r1.a), r1.b, r1.c, r1.d));
        goto L5
    L10:
        return r0;
    L8:
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedance.bdnavigationsdk.navigation.a
    public final void a(final com.bytedance.bdnavigationsdk.navigation.j r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.LOCATION);
        n(new q(r2));
    }

    @Override // com.bytedance.bdnavigationsdk.navigation.a
    public final void c(final com.bytedance.bdnavigationsdk.navigation.g r2) {
        Intrinsics.checkNotNullParameter(r2, "navigationInformation");
        n(new t(r2));
    }

    @Override // com.bytedance.bdnavigationsdk.navigation.a
    public final void e(final n84.b r2) {
        Intrinsics.checkNotNullParameter(r2, "navigationAgentEndInfo");
        n(new m(r2));
    }

    @Override // com.bytedance.bdnavigationsdk.navigation.a
    public final void h(final int r4) {
        e r0 = r84.a.a;
        r84.a.d(null, "导航引擎状态: " + r4, 5);
        n(new o(r4));
    }

    @Override // com.bytedance.bdnavigationsdk.navigation.a
    public final void i(final n84.g r2) {
        Intrinsics.checkNotNullParameter(r2, "navigationAgentStartInfo");
        n(new k(r2));
    }

    @Override // com.bytedance.bdnavigationsdk.navigation.a
    public final void j(final com.bytedance.bdnavigationsdk.navigation.j r20) {
        Intrinsics.checkNotNullParameter(r20, LocationMonitorConst.LOCATION);
        Object r2 = this.c;
        monitor-enter(r2);
        NavigationService r3 = this.d;     // Catch: Throwable -> L37
        if (r3 != null) goto L9;
        monitor-exit(r2);
        return;
    L9:
        if (this.i != null) goto L14;
        v(new Exception("规划服务未初始化"));     // Catch: Throwable -> L37
        monitor-exit(r2);
        return;
    L14:
        if (this.m == true) goto L16;
    L34:
        n(new r(r20));     // Catch: Throwable -> L37
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L37
        monitor-exit(r2);
        return;
    L16:
        if (this.j == null) goto L19;
        monitor-exit(r2);
        return;
    L19:
        Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L37
        com.bytedance.bdnavigationsdk.navigation.k r4 = r3.m();     // Catch: Throwable -> L37
        List r6 = null;
        if ((!this.h.isEmpty()) == false) goto L33;
        List<com.bytedance.bdnavigationsdk.navigation.m> r5 = r4.g;     // Catch: Throwable -> L37
        ArrayList r7 = new ArrayList();     // Catch: Throwable -> L37
        Iterator<T> r8 = r5.iterator();     // Catch: Throwable -> L37
    L23:
        if (r8.hasNext() == false) goto L28;
        com.bytedance.bdnavigationsdk.network.route.v r9 = (com.bytedance.bdnavigationsdk.network.route.v) CollectionsKt.getOrNull(this.h, ((com.bytedance.bdnavigationsdk.navigation.m) r8.next()).a);     // Catch: Throwable -> L37
        if (r9 == null) goto L23;
        r7.add(r9);     // Catch: Throwable -> L37
        goto L23
    L28:
        if ((!r7.isEmpty()) == true) goto L31;
        r7 = null;
    L31:
        if (r7 == null) goto L33;
        r6 = l(r7);     // Catch: Throwable -> L37
    L33:
        List r18 = r6;
        long r10 = this.l + 1;     // Catch: Throwable -> L37
        this.l = r10;     // Catch: Throwable -> L37
        String r11 = "route_update_" + r10;     // Catch: Throwable -> L37
        com.bytedance.bdnavigationsdk.network.route.j r12 = this.g;     // Catch: Throwable -> L37
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L37
        String r13 = r12.a;     // Catch: Throwable -> L37
        com.bytedance.bdnavigationsdk.network.route.j r14 = this.g;     // Catch: Throwable -> L37
        Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L37
        String r15 = r14.b;     // Catch: Throwable -> L37
        com.bytedance.bdnavigationsdk.network.route.j r16 = this.g;     // Catch: Throwable -> L37
        Intrinsics.checkNotNull(r16);     // Catch: Throwable -> L37
        String r17 = r16.c;     // Catch: Throwable -> L37
        com.bytedance.bdnavigationsdk.pojo.b r19 = r20.a;     // Catch: Throwable -> L37
        Intrinsics.checkNotNull(r19);     // Catch: Throwable -> L37
        com.bytedance.bdnavigationsdk.pojo.a r110 = r19.c;     // Catch: Throwable -> L37
        Intrinsics.checkNotNull(r110);     // Catch: Throwable -> L37
        com.bytedance.bdnavigationsdk.network.route.j r21 = this.g;     // Catch: Throwable -> L37
        Intrinsics.checkNotNull(r21);     // Catch: Throwable -> L37
        com.bytedance.bdnavigationsdk.pojo.a r111 = r21.e;     // Catch: Throwable -> L37
        com.bytedance.bdnavigationsdk.network.route.j r22 = this.g;     // Catch: Throwable -> L37
        Intrinsics.checkNotNull(r22);     // Catch: Throwable -> L37
        String r112 = r22.g;     // Catch: Throwable -> L37
        int r113 = this.n;     // Catch: Throwable -> L37
        com.bytedance.bdnavigationsdk.network.route.j r23 = this.g;     // Catch: Throwable -> L37
        Intrinsics.checkNotNull(r23);     // Catch: Throwable -> L37
        com.bytedance.bdnavigationsdk.network.route.j r24 = new com.bytedance.bdnavigationsdk.network.route.j(r13, r15, r17, r110, r111, null, r112, r113, null, r23.j, r18);     // Catch: Throwable -> L37
        this.j = new b(r11, 1, r24);     // Catch: Throwable -> L37
        com.bytedance.bdnavigationsdk.network.route.o r25 = this.i;     // Catch: Throwable -> L37
        Intrinsics.checkNotNull(r25);     // Catch: Throwable -> L37
        r25.e(r24, r11, new BDNANavigationImpl$onNavigationYaw$1$1(this), new BDNANavigationImpl$onNavigationYaw$1$2(this));     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.bdnavigationsdk.f
    public final com.bytedance.bdnavigationsdk.navigation.w k(List<com.bytedance.bdnavigationsdk.network.route.v> r22) {
        Intrinsics.checkNotNullParameter(r22, "wayPoints");
        Object r2 = this.c;
        monitor-enter(r2);
        NavigationService r6 = this.d;     // Catch: Throwable -> L20 Exception -> L22
        Intrinsics.checkNotNull(r6);     // Catch: Throwable -> L20 Exception -> L22
        com.bytedance.bdnavigationsdk.pojo.c r7 = this.k;     // Catch: Throwable -> L20 Exception -> L22
        if (r7 == null) goto L24;
        com.bytedance.bdnavigationsdk.pojo.a r8 = r7.d;     // Catch: Throwable -> L20 Exception -> L22
        if (r8 == null) goto L24;
        List r3 = l(r22);     // Catch: Throwable -> L20 Exception -> L22
        if (r6.c() == true) goto L15;
        com.bytedance.bdnavigationsdk.navigation.w r0 = s(2, "Navigation status is not running", Integer.valueOf(r6.n()));     // Catch: Throwable -> L20 Exception -> L22
        monitor-exit(r2);
        return r0;
    L15:
        long r10 = this.l + 1;     // Catch: Throwable -> L20 Exception -> L22
        this.l = r10;     // Catch: Throwable -> L20 Exception -> L22
        String r9 = "route_update_" + r10;     // Catch: Throwable -> L20 Exception -> L22
        com.bytedance.bdnavigationsdk.network.route.j r11 = this.g;     // Catch: Throwable -> L20 Exception -> L22
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L20 Exception -> L22
        String r12 = r11.a;     // Catch: Throwable -> L20 Exception -> L22
        com.bytedance.bdnavigationsdk.network.route.j r13 = this.g;     // Catch: Throwable -> L20 Exception -> L22
        Intrinsics.checkNotNull(r13);     // Catch: Throwable -> L20 Exception -> L22
        String r14 = r13.b;     // Catch: Throwable -> L20 Exception -> L22
        com.bytedance.bdnavigationsdk.network.route.j r15 = this.g;     // Catch: Throwable -> L20 Exception -> L22
        Intrinsics.checkNotNull(r15);     // Catch: Throwable -> L20 Exception -> L22
        String r16 = r15.c;     // Catch: Throwable -> L20 Exception -> L22
        com.bytedance.bdnavigationsdk.pojo.a r17 = com.bytedance.bdnavigationsdk.pojo.a.a(r8);     // Catch: Throwable -> L20 Exception -> L22
        com.bytedance.bdnavigationsdk.network.route.j r18 = this.g;     // Catch: Throwable -> L20 Exception -> L22
        Intrinsics.checkNotNull(r18);     // Catch: Throwable -> L20 Exception -> L22
        com.bytedance.bdnavigationsdk.pojo.a r19 = r18.e;     // Catch: Throwable -> L20 Exception -> L22
        com.bytedance.bdnavigationsdk.network.route.j r20 = this.g;     // Catch: Throwable -> L20 Exception -> L22
        Intrinsics.checkNotNull(r20);     // Catch: Throwable -> L20 Exception -> L22
        String r21 = r20.g;     // Catch: Throwable -> L20 Exception -> L22
        com.bytedance.bdnavigationsdk.network.route.j r23 = this.g;     // Catch: Throwable -> L20 Exception -> L22
        Intrinsics.checkNotNull(r23);     // Catch: Throwable -> L20 Exception -> L22
        int r24 = r23.h;     // Catch: Throwable -> L20 Exception -> L22
        com.bytedance.bdnavigationsdk.network.route.j r110 = this.g;     // Catch: Throwable -> L20 Exception -> L22
        Intrinsics.checkNotNull(r110);     // Catch: Throwable -> L20 Exception -> L22
        PoiType r111 = r110.j;     // Catch: Throwable -> L20 Exception -> L22
        if ((!r3.isEmpty()) == false) goto L18;
        List r112 = r3;
    L19:
        com.bytedance.bdnavigationsdk.network.route.j r5 = new com.bytedance.bdnavigationsdk.network.route.j(r12, r14, r16, r17, r19, r21, r24, r111, r112, 288);     // Catch: Throwable -> L20 Exception -> L22
        this.j = new b(r9, 2, r5);     // Catch: Throwable -> L20 Exception -> L22
        com.bytedance.bdnavigationsdk.network.route.o r25 = this.i;     // Catch: Throwable -> L20 Exception -> L22
        Intrinsics.checkNotNull(r25);     // Catch: Throwable -> L20 Exception -> L22
        r25.e(r5, r9, new BDNANavigationImpl$updateWaypoints$1$1(this), new BDNANavigationImpl$updateWaypoints$1$2(this));     // Catch: Throwable -> L20 Exception -> L22
        e r26 = r84.a.a;     // Catch: Throwable -> L20 Exception -> L22
        r84.a.d(null, "updateWaypoints accepted: routeUpdateId=" + r9 + ", targetWayPointsCount=" + r3.size(), 5);     // Catch: Throwable -> L20 Exception -> L22
        com.bytedance.bdnavigationsdk.navigation.w r1 = new com.bytedance.bdnavigationsdk.navigation.w(r9, 0, null, 4);     // Catch: Throwable -> L20 Exception -> L22
    L31:
        monitor-exit(r2);
        return r1;
    L18:
        r112 = null;
    L24:
        com.bytedance.bdnavigationsdk.navigation.w r4 = s(1, "Current location is unavailable", Integer.valueOf(r6.n()));     // Catch: Throwable -> L20 Exception -> L22
        monitor-exit(r2);
        return r4;
    L20:
        th = move-exception;
        throw th;
    L22:
        e = move-exception;
        r84.a.b("Failed to update waypoints", e, 1);     // Catch: Throwable -> L20
        this.j = null;     // Catch: Throwable -> L20
        NavigationService r27 = this.d;     // Catch: Throwable -> L20
        if (r27 == null) goto L30;
        r27.g();     // Catch: Throwable -> L20
    L30:
        r1 = s(1, "Failed to update waypoints", null);     // Catch: Throwable -> L20
        goto L31
    }

    public final void n(final Function1<? super w, Unit> r4) {
        Object r0 = this.c;
        monitor-enter(r0);
        final w r1 = this.f;     // Catch: Throwable -> L10
        monitor-exit(r0);
        if (r1 != null) goto L8;
        return;
    L8:
        com.bytedance.bdnavigationsdk.utils.a r2 = this.b;
        Function0 r3 = new i(r4, r1);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "callback");
        Object r5 = r2.b.trySend-JP2dKIU(r3);
        kotlinx.coroutines.channels.g.c r6 = kotlinx.coroutines.channels.g.b;
        boolean r7 = r5 instanceof kotlinx.coroutines.channels.g.c;
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void r(com.bytedance.bdnavigationsdk.pojo.c r3) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            java.lang.String r0 = "locationInfo"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.Object r0 = r2.c
            monitor-enter(r0)
            com.bytedance.bdnavigationsdk.navigation.NavigationService r1 = r2.d     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            if (r1 != 0) goto Le
            monitor-exit(r0)
            return
        Le:
            com.bytedance.bdnavigationsdk.pojo.c r1 = com.bytedance.bdnavigationsdk.pojo.c.a(r3)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            r2.k = r1     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            com.bytedance.bdnavigationsdk.navigation.NavigationService r1 = r2.d     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            int r1 = r1.n()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            if (r1 != 0) goto L21
            monitor-exit(r0)
            return
        L21:
            com.bytedance.bdnavigationsdk.navigation.NavigationService r1 = r2.d     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            r1.x(r3)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            goto L30
        L2a:
            r3 = move-exception
            goto L34
        L2c:
            r3 = move-exception
            r2.v(r3)     // Catch: java.lang.Throwable -> L2a
        L30:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L2a
            monitor-exit(r0)
            return
        L34:
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdnavigationsdk.BDNANavigationImpl.r(com.bytedance.bdnavigationsdk.pojo.c):void");
    }

    public final void u(com.bytedance.bdnavigationsdk.network.route.j r17) {
        NavigationService r2 = this.d;
        if (r2 == null) goto L5;
        Intrinsics.checkNotNull(r2);
        r2.G = null;
        NavigationService r3 = this.d;
        Intrinsics.checkNotNull(r3);
        r3.F();
        this.d = null;
    L5:
        String r5 = r17.a;
        String r6 = r17.b;
        String r7 = r17.c;
        com.bytedance.bdnavigationsdk.pojo.a r8 = com.bytedance.bdnavigationsdk.pojo.a.a(r17.d);
        com.bytedance.bdnavigationsdk.pojo.a r9 = com.bytedance.bdnavigationsdk.pojo.a.a(r17.e);
        String r10 = r17.f;
        String r11 = r17.g;
        int r12 = r17.h;
        PoiType r13 = r17.i;
        PoiType r14 = r17.j;
        List r1 = l(r17.k);
        if ((!r1.isEmpty()) == true) goto L9;
        r1 = null;
    L9:
        com.bytedance.bdnavigationsdk.network.route.j r4 = new com.bytedance.bdnavigationsdk.network.route.j(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r1);
        this.g = r4;
        Intrinsics.checkNotNull(r4);
        this.h = l(r4.k);
        int r15 = NavigationTransport.a;
        com.bytedance.bdnavigationsdk.network.route.j r16 = this.g;
        Intrinsics.checkNotNull(r16);
        String r18 = r16.c;
        Intrinsics.checkNotNullParameter(r18, "code");
        NavigationTransport.TransportType.Companion.getClass();
        Intrinsics.checkNotNullParameter(r18, "code");
        NavigationTransport.TransportType r19 = (NavigationTransport.TransportType) NavigationTransport.TransportType.access$getCodeMap$cp().get(r18);
        if (r19 != null) goto L12;
        r19 = NavigationTransport.TransportType.Walking;
    L12:
        this.e = r19;
        int r20 = com.bytedance.bdnavigationsdk.navigation.f.a;
        com.bytedance.bdnavigationsdk.network.route.j r21 = this.g;
        Intrinsics.checkNotNull(r21);
        String r22 = r21.a;
        com.bytedance.bdnavigationsdk.network.route.j r23 = this.g;
        Intrinsics.checkNotNull(r23);
        String r24 = r23.b;
        NavigationTransport.TransportType r25 = this.e;
        Intrinsics.checkNotNullParameter(r22, "sessionId");
        Intrinsics.checkNotNullParameter(r24, "businessId");
        if (r25 != null) goto L15;
        int r26 = -1;
    L16:
        if (r26 == (-1)) goto L31;
        if (r26 != 1) goto L19;
        NavigationService r27 = new com.bytedance.bdnavigationsdk.navigation.q(r22, r24);
    L32:
        this.d = r27;
        return;
    L19:
        if (r26 != 2) goto L21;
        r27 = new com.bytedance.bdnavigationsdk.navigation.d(r22, r24);
        goto L32
    L21:
        if (r26 != 3) goto L23;
        r27 = new com.bytedance.bdnavigationsdk.navigation.e(r22, r24);
        goto L32
    L23:
        if (r26 == 4) goto L27;
        throw new NoWhenBranchMatchedException();
    L27:
        throw new NotImplementedError("An operation is not implemented: Driving");
    L31:
        r27 = null;
        goto L32
    L15:
        r26 = com.bytedance.bdnavigationsdk.navigation.f.a.a[r25.ordinal()];
        goto L16
    }

    public final void v(final Exception r3) {
        r84.a.b("导航引擎错误", r3, 1);
        n(new j(r3));
    }

    public final void w(w r2) {
        Object r0 = this.c;
        monitor-enter(r0);
        this.f = r2;     // Catch: Throwable -> L7
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static com.bytedance.bdnavigationsdk.network.route.j q(com.bytedance.bdnavigationsdk.network.route.j r25, com.bytedance.bdnavigationsdk.network.route.d r26) {
        List r2 = l(r25.k);
        List<com.bytedance.bdnavigationsdk.network.route.v> r3 = r26.e;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r5 = r3.iterator();
        int r6 = 0;
    L3:
        List r7 = null;
        String r8 = null;
        if (r5.hasNext() == false) goto L24;
        Object r9 = r5.next();
        int r10 = r6 + 1;
        if (r6 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        com.bytedance.bdnavigationsdk.network.route.v r11 = (com.bytedance.bdnavigationsdk.network.route.v) r9;
        com.bytedance.bdnavigationsdk.network.route.v r12 = (com.bytedance.bdnavigationsdk.network.route.v) CollectionsKt.getOrNull(r2, r6);
        com.bytedance.bdnavigationsdk.pojo.a r13 = com.bytedance.bdnavigationsdk.pojo.a.a(r11.a);
        PoiType r14 = r11.b;
        if (r14 != null) goto L13;
        if (r12 == null) goto L12;
        r14 = r12.b;
        goto L13
    L12:
        r14 = null;
    L13:
        String r15 = r11.c;
        if (r15 != null) goto L18;
        if (r12 == null) goto L17;
        r15 = r12.c;
        goto L18
    L17:
        r15 = null;
    L18:
        String r16 = r11.d;
        if (r16 != null) goto L22;
        if (r12 == null) goto L23;
        r8 = r12.d;
    L23:
        r4.add(new com.bytedance.bdnavigationsdk.network.route.v(r13, r14, r15, r8));
        r6 = r10;
        goto L3
    L22:
        r8 = r16;
        goto L23
    L24:
        String r17 = r25.a;
        String r18 = r25.b;
        String r19 = r25.c;
        com.bytedance.bdnavigationsdk.pojo.a r20 = r26.a;
        if (r20 != null) goto L27;
        r20 = r25.d;
    L27:
        com.bytedance.bdnavigationsdk.pojo.a r110 = com.bytedance.bdnavigationsdk.pojo.a.a(r20);
        com.bytedance.bdnavigationsdk.pojo.a r1 = r26.b;
        if (r1 != null) goto L30;
        r1 = r25.e;
    L30:
        com.bytedance.bdnavigationsdk.pojo.a r111 = com.bytedance.bdnavigationsdk.pojo.a.a(r1);
        String r21 = r25.f;
        String r22 = r25.g;
        int r23 = r25.h;
        PoiType r24 = r25.i;
        PoiType r0 = r25.j;
        if (r4.isEmpty() == true) goto L35;
        r2 = r4;
    L35:
        if ((!r2.isEmpty()) == false) goto L38;
        r7 = r2;
    L38:
        return new com.bytedance.bdnavigationsdk.network.route.j(r17, r18, r19, r110, r111, r21, r22, r23, r24, r0, r7);
    }

    @Override // com.bytedance.bdnavigationsdk.navigation.a
    public final void d(final com.bytedance.bdnavigationsdk.navigation.j r2, final com.bytedance.bdnavigationsdk.navigation.v r3) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.LOCATION);
        Intrinsics.checkNotNullParameter(r3, "notificationInstruction");
        n(new s(r2, r3));
    }

    @Override // com.bytedance.bdnavigationsdk.navigation.a
    public final void f(final com.bytedance.bdnavigationsdk.navigation.j r2, final com.bytedance.bdnavigationsdk.navigation.h r3) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.LOCATION);
        Intrinsics.checkNotNullParameter(r3, "navigationInstruction");
        n(new p(r2, r3));
    }

    @Override // com.bytedance.bdnavigationsdk.navigation.a
    public final void g(final com.bytedance.bdnavigationsdk.navigation.j r2, final com.bytedance.bdnavigationsdk.navigation.k r3) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.LOCATION);
        Intrinsics.checkNotNullParameter(r3, "navigationProgress");
        n(new u(r2, r3));
    }

    public final b o(String r4, int r5) {
        b r0 = this.j;
        if (r0 != null) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r0.a, r4) == true) goto L8;
    L11:
        return null;
    L8:
        if (r0.b != r5) goto L11;
        return r0;
    }

    public final void x(com.bytedance.bdnavigationsdk.network.route.j r3, RoutePath r4) {
        Object r0 = this.c;
        monitor-enter(r0);
        com.bytedance.bdnavigationsdk.b r1 = d.a;     // Catch: Throwable -> L19 Exception -> L21
        if (d.c == false) goto L18;
        if (r3 == null) goto L16;
        if (r4 == null) goto L14;
        this.j = null;     // Catch: Throwable -> L19 Exception -> L21
        this.k = null;     // Catch: Throwable -> L19 Exception -> L21
        u(r3);     // Catch: Throwable -> L19 Exception -> L21
        NavigationService r5 = this.d;     // Catch: Throwable -> L19 Exception -> L21
        if (r5 == null) goto L12;
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L19 Exception -> L21
        r5.G = this;     // Catch: Throwable -> L19 Exception -> L21
        NavigationService r6 = this.d;     // Catch: Throwable -> L19 Exception -> L21
        Intrinsics.checkNotNull(r6);     // Catch: Throwable -> L19 Exception -> L21
        com.bytedance.bdnavigationsdk.network.route.j r2 = this.g;     // Catch: Throwable -> L19 Exception -> L21
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L19 Exception -> L21
        r6.E(r2, r4);     // Catch: Throwable -> L19 Exception -> L21
    L23:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r0);
        return;
    L12:
        throw new Exception("导航服务未初始化");     // Catch: Throwable -> L19 Exception -> L21
    L14:
        throw new Exception("规划路线为空");     // Catch: Throwable -> L19 Exception -> L21
    L16:
        throw new Exception("路径规划参数为空");     // Catch: Throwable -> L19 Exception -> L21
    L18:
        throw new Exception("BDNAInit尚未初始化");     // Catch: Throwable -> L19 Exception -> L21
    L21:
        e = move-exception;
        v(e);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public final com.bytedance.bdnavigationsdk.navigation.w s(int r7, String r8, Integer r9) {
        e r0 = r84.a.a;
        boolean r1 = false;
        if (this.j == null) goto L5;
        boolean r2 = true;
    L6:
        com.bytedance.bdnavigationsdk.pojo.c r3 = this.k;
        if (r3 == null) goto L9;
        com.bytedance.bdnavigationsdk.pojo.a r4 = r3.d;
    L10:
        if (r4 == null) goto L12;
        r1 = true;
    L12:
        r84.a.d(null, "updateWaypoints rejected: code=" + r7 + ", message=" + r8 + ", navigationStatus=" + r9 + ", hasPendingRouteUpdate=" + r2 + ", hasLatestLocation=" + r1, 5);
        return new com.bytedance.bdnavigationsdk.navigation.w(null, r7, r8, 1);
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    public static void p(String r3, b r4, RoutePath r5, int r6) {
        e r0 = r84.a.a;
        r84.a.d(null, "route update success: routeUpdateId=" + r3 + ", reason=" + r4.b + ", wayPointsCount=" + r6 + ", guidePointsCount=" + r5.e.size() + ", legsCount=" + r5.g.size(), 5);
    }
}
