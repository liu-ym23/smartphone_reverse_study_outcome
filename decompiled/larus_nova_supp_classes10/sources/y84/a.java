package y84;

import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.bytedance.bdnavigationsdk.network.route.RoutePath;
import com.bytedance.bdnavigationsdk.network.route.q;
import com.bytedance.bdnavigationsdk.pojo.ProjectionResult;
import com.bytedance.bdnavigationsdk.pojo.YawResult;
import com.bytedance.bdnavigationsdk.yaw.RouteProjector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class a implements h {
    public t84.c a;
    public Map<String, t84.b> b;
    public int c;
    public List<com.bytedance.bdnavigationsdk.pojo.d> d;
    public List<com.bytedance.bdnavigationsdk.pojo.b> e;
    public List<Integer> f;
    public List<ProjectionResult> g;
    public boolean h;
    public RouteProjector i;
    public int j;

    /* JADX INFO: renamed from: y84.a$a, reason: collision with other inner class name */
    public static final class C0190a {
    }

    static {
    }

    @Override // y84.h
    public final YawResult c() {
    L28:
        e = move-exception;
        r84.a.b("checkYaw error", e, 1);
        YawResult r4 = new YawResult(YawResult.ErrCode.SYSTEM_ERROR, null);
    L30:
        com.bytedance.bdnavigationsdk.e r0 = r84.a.a;
        r84.a.a("Result, idx " + (((ArrayList) this.e).size() - 1) + ", " + r4);
        return r4;
    L4:
        if (((ArrayList) this.g).size() >= 10) goto L6;
        YawResult.ErrCode r1 = YawResult.ErrCode.INSUFFICIENT_USABLE_LOCATION;     // Catch: Exception -> L28
    L8:
        if (((ArrayList) this.g).size() > 10) goto L10;
        int r2 = 0;
    L11:
        int r3 = ((ArrayList) this.g).size();     // Catch: Exception -> L28
        if (g() == false) goto L19;
        List<com.bytedance.bdnavigationsdk.pojo.b> r5 = this.e;     // Catch: Exception -> L28
        Integer r7 = h();     // Catch: Exception -> L28
        Intrinsics.checkNotNull(r7);     // Catch: Exception -> L28
        com.bytedance.bdnavigationsdk.pojo.a r8 = ((com.bytedance.bdnavigationsdk.pojo.b) ListProtector.get(r5, r7.intValue())).c;     // Catch: Exception -> L28
        if (((ArrayList) this.g).isEmpty() == false) goto L16;
        ProjectionResult r9 = null;
    L17:
        List<com.bytedance.bdnavigationsdk.pojo.b> r6 = this.e;     // Catch: Exception -> L28
        Integer r10 = h();     // Catch: Exception -> L28
        Intrinsics.checkNotNull(r10);     // Catch: Exception -> L28
        r4 = new YawResult(r1, new YawResult.c(true, r8, r9, (com.bytedance.bdnavigationsdk.pojo.b) ListProtector.get(r6, r10.intValue()), ((ArrayList) this.g).subList(r2, r3)));     // Catch: Exception -> L28
        goto L30
    L16:
        ArrayList r11 = (ArrayList) this.g;     // Catch: Exception -> L28
        r9 = (ProjectionResult) ListProtector.get(r11, r11.size() - 1);     // Catch: Exception -> L28
        goto L17
    L19:
        if (((ArrayList) this.g).isEmpty() == false) goto L21;
        ProjectionResult r12 = null;
    L23:
        if (h() != null) goto L25;
        com.bytedance.bdnavigationsdk.pojo.b r13 = null;
    L26:
        r4 = new YawResult(r1, new YawResult.c(false, null, r12, r13, ((ArrayList) this.g).subList(r2, r3)));     // Catch: Exception -> L28
        goto L30
    L25:
        List<com.bytedance.bdnavigationsdk.pojo.b> r14 = this.e;     // Catch: Exception -> L28
        Integer r15 = h();     // Catch: Exception -> L28
        Intrinsics.checkNotNull(r15);     // Catch: Exception -> L28
        r13 = (com.bytedance.bdnavigationsdk.pojo.b) ListProtector.get(r14, r15.intValue());     // Catch: Exception -> L28
        goto L26
    L21:
        ArrayList r16 = (ArrayList) this.g;     // Catch: Exception -> L28
        r12 = (ProjectionResult) ListProtector.get(r16, r16.size() - 1);     // Catch: Exception -> L28
        goto L23
    L10:
        r2 = ((ArrayList) this.g).size() - 10;     // Catch: Exception -> L28
        goto L11
    L6:
        r1 = YawResult.ErrCode.SUCCESS;     // Catch: Exception -> L28
        goto L8
    }

    @Override // y84.h
    public final void clear() {
        this.h = false;
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
        RouteProjector r1 = this.i;
        ((ArrayList) r1.f).clear();
        ((ArrayList) r1.e).clear();
        r1.d = 0;
        this.j = 0;
    }

    public final boolean g() {
        if (((ArrayList) this.f).size() >= 10) goto L5;
        return false;
    L5:
        int r1 = ((ArrayList) this.f).size() - 10;
        int r3 = ((ArrayList) this.f).size();
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
    L6:
        boolean r7 = true;
        if (r1 >= r3) goto L77;
        if (r1 > 0) goto L10;
        int r15 = r3;
    L75:
        r1 = r1 + 1;
        r3 = r15;
        goto L6
    L10:
        int r10 = r1 - 1;
        com.bytedance.bdnavigationsdk.pojo.b r8 = (com.bytedance.bdnavigationsdk.pojo.b) ListProtector.get(this.e, ((Number) ListProtector.get(this.f, r10)).intValue());
        com.bytedance.bdnavigationsdk.pojo.b r9 = (com.bytedance.bdnavigationsdk.pojo.b) ListProtector.get(this.e, ((Number) ListProtector.get(this.f, r1)).intValue());
        ProjectionResult r11 = (ProjectionResult) ListProtector.get(this.g, r10);
        ProjectionResult r12 = (ProjectionResult) ListProtector.get(this.g, r1);
        t84.b r13 = this.b.get("trusted_level_" + r9.e);
        if (this.c != 1) goto L16;
        if ((((com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(this.d, r12.e)).g + r12.h) > this.a.c) goto L16;
        r13 = this.b.get("dist_to_start");
    L16:
        if ((((com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(this.d, r12.e)).h - r12.h) > this.a.d) goto L18;
        r13 = this.b.get("dist_to_end");
    L18:
        float r14 = r12.g;
        Intrinsics.checkNotNull(r13);
        if (r14 <= r13.a) goto L24;
        if (r12.g <= r11.g) goto L24;
        r4 = r4 + 1;
    L24:
        if (r12.g <= this.a.g) goto L26;
        r5 = r5 + 1;
    L26:
        int r16 = w84.a.a;
        com.bytedance.bdnavigationsdk.pojo.a r17 = r8.c;
        Intrinsics.checkNotNull(r17);
        com.bytedance.bdnavigationsdk.pojo.a r18 = r9.c;
        Intrinsics.checkNotNull(r18);
        float r19 = w84.a.a(r17, r18);
        com.bytedance.bdnavigationsdk.pojo.a r110 = r11.d;
        Intrinsics.checkNotNull(r110);
        com.bytedance.bdnavigationsdk.pojo.a r111 = r12.d;
        Intrinsics.checkNotNull(r111);
        float r112 = w84.a.a(r110, r111);
        com.bytedance.bdnavigationsdk.pojo.a r113 = r11.d;
        Intrinsics.checkNotNull(r113);
        com.bytedance.bdnavigationsdk.pojo.a r114 = r12.d;
        Intrinsics.checkNotNull(r114);
        if (Intrinsics.areEqual(r113, r114) == false) goto L29;
        com.bytedance.bdnavigationsdk.pojo.a r115 = r12.b;
        Intrinsics.checkNotNull(r115);
        com.bytedance.bdnavigationsdk.pojo.a r116 = r12.c;
        Intrinsics.checkNotNull(r116);
        r112 = w84.a.a(r115, r116);
    L29:
        r15 = r3;
        if (((r9.f - r8.f) / 1000.0d) >= this.a.b) goto L75;
        float r2 = r13.b;
        if (r2 < 180.0f) goto L35;
    L73:
        if (r7 == true) goto L75;
        r6 = r6 + 1;
        goto L75
    L35:
        if (r2 >= 0.0f) goto L38;
    L72:
        r7 = false;
        goto L73
    L38:
        if (r19 >= 0.0f) goto L40;
        float r20 = 360;
        float r117 = (r19 % r20) + r20;
    L42:
        if (r112 >= 0.0f) goto L44;
        float r21 = 360;
        float r118 = (r112 % r21) + r21;
    L45:
        float r22 = r118 - r2;
        if (r22 < 0.0f) goto L48;
        float r119 = r118 + r2;
        if (r119 <= 360.0f) goto L68;
        if (r22 > r117) goto L63;
        if (r117 < 360.0f) goto L73;
    L63:
        if (0.0f > r117) goto L72;
        if (r117 > (r119 - 360)) goto L72;
    L68:
        if (r22 > r117) goto L72;
        if (r117 > r119) goto L72;
    L48:
        if ((r22 + 360) > r117) goto L52;
        if (r117 < 360.0f) goto L73;
    L52:
        if (0.0f > r117) goto L72;
        if (r117 > (r118 + r2)) goto L72;
    L44:
        r118 = r112 % 360;
        goto L45
    L40:
        r117 = r19 % 360;
        goto L42
    L77:
        if (r4 <= 6.0d) goto L79;
        boolean r23 = true;
    L81:
        if (r5 <= 3.0d) goto L83;
        boolean r24 = true;
    L85:
        if (r6 <= 6.0d) goto L87;
        boolean r25 = true;
    L88:
        com.bytedance.bdnavigationsdk.e r26 = r84.a.a;
        r84.a.a("Final Dynamic, idx " + (((ArrayList) this.e).size() - 1) + ", ProjectionDistYaw " + r23 + ", ProjectionDistExceed " + r24 + ", BearingYaw " + r25);
        if (r24 == false) goto L91;
        return true;
    L91:
        if (r23 == false) goto L93;
        return r25;
    L93:
        return false;
    L87:
        r25 = false;
        goto L88
    L83:
        r24 = false;
        goto L85
    L79:
        r23 = false;
        goto L81
    }

    public final Integer h() {
        if (this.f.isEmpty() == false) goto L5;
        return null;
    L5:
        List<Integer> r0 = this.f;
        return (Integer) ListProtector.get(r0, r0.size() - 1);
    }

    public a() {
        this.a = new t84.c(0);
        this.b = new HashMap();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.i = new RouteProjector(this.d, this.a, new ArrayList());
    }

    @Override // y84.h
    public final void a(List<com.bytedance.bdnavigationsdk.pojo.c> r2) throws Exception {
        Iterator<com.bytedance.bdnavigationsdk.pojo.c> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        e(r3.next());
        goto L4
    }

    @Override // y84.h
    public final void b(RoutePath r20) {
        Intrinsics.checkNotNullParameter(r20, "routePath");
        int r2 = this.c + 1;
        this.c = r2;
        com.bytedance.bdnavigationsdk.e r3 = r84.a.a;
        r84.a.d(null, "Start Init Yaw " + r2, 5);
        ArrayList r4 = new ArrayList();
        List<q> r5 = r20.d;
        Intrinsics.checkNotNull(r5);
        Iterator<q> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L10;
        List<com.bytedance.bdnavigationsdk.pojo.a> r7 = r6.next().g;
        Intrinsics.checkNotNull(r7);
        Iterator<com.bytedance.bdnavigationsdk.pojo.a> r8 = r7.iterator();
        String r9 = "";
    L7:
        if (r8.hasNext() == false) goto L9;
        com.bytedance.bdnavigationsdk.pojo.a r10 = r8.next();
        r9 = r9 + r10.b + "," + r10.a + ";";
        goto L7
    L9:
        com.bytedance.bdnavigationsdk.e r11 = r84.a.a;
        r84.a.a("Step polyline " + r9);
        goto L4
    L10:
        com.bytedance.bdnavigationsdk.e r12 = r84.a.a;
        r84.a.a("RoutePath distance " + r20.b);
        List<q> r13 = r20.d;
        Intrinsics.checkNotNull(r13);
        int r14 = r13.size();
        float r15 = 0.0f;
        int r16 = 0;
        int r17 = 0;
    L11:
        if (r17 >= r14) goto L19;
        List<q> r18 = r20.d;
        Intrinsics.checkNotNull(r18);
        q r19 = (q) ListProtector.get(r18, r17);
        List<com.bytedance.bdnavigationsdk.pojo.a> r21 = r19.g;
        Intrinsics.checkNotNull(r21);
        int r110 = r21.size() - 1;
        float r111 = r15;
        int r112 = r16;
        int r22 = 0;
    L13:
        if (r22 >= r110) goto L15;
        List<com.bytedance.bdnavigationsdk.pojo.a> r23 = r19.g;
        Intrinsics.checkNotNull(r23);
        com.bytedance.bdnavigationsdk.pojo.a r24 = (com.bytedance.bdnavigationsdk.pojo.a) ListProtector.get(r23, r22);
        List<com.bytedance.bdnavigationsdk.pojo.a> r25 = r19.g;
        Intrinsics.checkNotNull(r25);
        int r113 = r22 + 1;
        com.bytedance.bdnavigationsdk.pojo.d r114 = new com.bytedance.bdnavigationsdk.pojo.d(r24, (com.bytedance.bdnavigationsdk.pojo.a) ListProtector.get(r25, r113), r112, r17, 2032);
        r4.add(r114);
        r111 = r111 + r114.e;
        r112 = r112 + 1;
        r22 = r113;
        goto L13
    L15:
        List<q> r26 = r20.d;
        Intrinsics.checkNotNull(r26);
        if (r17 != (r26.size() - 1)) goto L18;
        List<com.bytedance.bdnavigationsdk.pojo.a> r27 = r19.g;
        Intrinsics.checkNotNull(r27);
        List<com.bytedance.bdnavigationsdk.pojo.a> r28 = r19.g;
        Intrinsics.checkNotNull(r28);
        r4.add(new com.bytedance.bdnavigationsdk.pojo.d((com.bytedance.bdnavigationsdk.pojo.a) ListProtector.get(r27, r28.size() - 1), null, r112, r17, 2032));
    L18:
        r17 = r17 + 1;
        r15 = r111;
        r16 = r112;
        goto L11
    L19:
        float r29 = com.bytedance.bdnavigationsdk.utils.b.b(r15, 2);
        com.bytedance.bdnavigationsdk.e r30 = r84.a.a;
        r84.a.a("Real path distance " + r29);
        int r31 = r4.size();
        int r32 = 0;
    L20:
        if (r32 >= r31) goto L44;
        if (r32 > 0) goto L23;
    L28:
        float r33 = 0.0f;
    L30:
        if (r32 >= (r4.size() - 2)) goto L35;
        com.bytedance.bdnavigationsdk.pojo.d.b r34 = com.bytedance.bdnavigationsdk.pojo.d.Companion;
        com.bytedance.bdnavigationsdk.pojo.d r115 = (com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r4, r32);
        com.bytedance.bdnavigationsdk.pojo.d r116 = (com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r4, r32 + 1);
        r34.getClass();
        if (r115 == null) goto L35;
        if (r116 == null) goto L35;
        float r35 = com.bytedance.bdnavigationsdk.utils.b.b(r116.i - r115.i, 2);
    L36:
        com.bytedance.bdnavigationsdk.pojo.d r117 = (com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r4, r32);
        float r36 = com.bytedance.bdnavigationsdk.utils.b.b(r33, 2);
        r117.getClass();
        r117.j = com.bytedance.bdnavigationsdk.utils.b.b(r36, 2);
        com.bytedance.bdnavigationsdk.pojo.d r37 = (com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r4, r32);
        float r38 = com.bytedance.bdnavigationsdk.utils.b.b(r35, 2);
        r37.getClass();
        r37.k = com.bytedance.bdnavigationsdk.utils.b.b(r38, 2);
        if (r32 != 0) goto L40;
        float r118 = r29;
        float r39 = 0.0f;
    L43:
        com.bytedance.bdnavigationsdk.pojo.d r40 = (com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r4, r32);
        float r41 = com.bytedance.bdnavigationsdk.utils.b.b(r39, 2);
        r40.getClass();
        r40.g = com.bytedance.bdnavigationsdk.utils.b.b(r41, 2);
        com.bytedance.bdnavigationsdk.pojo.d r42 = (com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r4, r32);
        float r43 = com.bytedance.bdnavigationsdk.utils.b.b(r118, 2);
        r42.getClass();
        r42.h = com.bytedance.bdnavigationsdk.utils.b.b(r43, 2);
        com.bytedance.bdnavigationsdk.e r44 = r84.a.a;
        r84.a.a("Segment " + ListProtector.get(r4, r32));
        r32 = r32 + 1;
        goto L20
    L40:
        if (r32 != (r4.size() - 1)) goto L42;
        r39 = r29;
        r118 = 0.0f;
        goto L43
    L42:
        int r45 = r32 - 1;
        r39 = ((com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r4, r45)).g + ((com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r4, r45)).e;
        r118 = ((com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r4, r45)).h - ((com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r4, r45)).e;
    L35:
        r35 = 0.0f;
        goto L36
    L23:
        if (r32 >= (r4.size() - 1)) goto L28;
        com.bytedance.bdnavigationsdk.pojo.d.b r46 = com.bytedance.bdnavigationsdk.pojo.d.Companion;
        com.bytedance.bdnavigationsdk.pojo.d r47 = (com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r4, r32 - 1);
        com.bytedance.bdnavigationsdk.pojo.d r119 = (com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r4, r32);
        r46.getClass();
        if (r47 == null) goto L28;
        if (r119 == null) goto L28;
        r33 = com.bytedance.bdnavigationsdk.utils.b.b(r119.i - r47.i, 2);
        goto L30
    L44:
        this.h = false;
        this.d = r4;
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.i = new RouteProjector(r4, this.a, r20.g);
        this.j = 0;
    }

    @Override // y84.h
    public final List<com.bytedance.bdnavigationsdk.pojo.b> d(int r4) {
        List<Integer> r0 = this.f;
        List<Integer> r5 = r0.subList(Math.max(0, r0.size() - r4), this.f.size());
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L7;
        int r2 = ((Number) r6.next()).intValue();
        r1.add((com.bytedance.bdnavigationsdk.pojo.b) ListProtector.get(this.e, r2));
        goto L4
    L7:
        return CollectionsKt.toMutableList(r1);
    }

    @Override // y84.h
    public final void e(com.bytedance.bdnavigationsdk.pojo.c r26) throws Exception {
        if (r26 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r26.b, LocationInfoConst.GCJ_O2) == false) goto L78;
        int r13 = ((ArrayList) this.e).size();
        com.bytedance.bdnavigationsdk.pojo.a r14 = r26.d;
        int r7 = r26.a;
        int r8 = r26.c;
        long r11 = r26.g;
        float r15 = r26.e;
        com.bytedance.bdnavigationsdk.pojo.b r2 = new com.bytedance.bdnavigationsdk.pojo.b(r13, true, r14, r7, r8, r11, r15, r26.f);
        if (((ArrayList) this.e).isEmpty() == false) goto L11;
        Intrinsics.checkNotNullParameter(r2, "userLocation");
        ((ArrayList) this.e).add(r2);
        com.bytedance.bdnavigationsdk.e r1 = r84.a.a;
        r84.a.a("Location " + r2);
        ProjectionResult r3 = i(r2);
        Intrinsics.checkNotNullParameter(r3, "projectionResult");
        ((ArrayList) this.g).add(r3);
        ((ArrayList) this.f).add(Integer.valueOf(r13));
        r84.a.a("CurrLocation " + r2);
        r84.a.a("CurrProjection, idx " + r13 + ", " + r3);
        return;
    L11:
        int r4 = r26.a;
        boolean r10 = true;
        if (r4 == 1) goto L14;
        return;
    L14:
        if (r4 == 1) goto L16;
    L18:
        boolean r5 = false;
    L19:
        r2.b = r5;
        Intrinsics.checkNotNullParameter(r2, "userLocation");
        ((ArrayList) this.e).add(r2);
        com.bytedance.bdnavigationsdk.e r6 = r84.a.a;
        r84.a.a("Location " + r2);
        if (this.h == false) goto L22;
        String r9 = "projectionResult";
        String r12 = ", ";
        String r16 = "CurrProjection, idx ";
    L54:
        if (((ArrayList) this.e).isEmpty() == false) goto L56;
    L72:
        r10 = false;
    L73:
        if (r10 == false) goto L80;
        ProjectionResult r17 = i(r2);
        Intrinsics.checkNotNullParameter(r17, r9);
        ((ArrayList) this.g).add(r17);
        ((ArrayList) this.f).add(Integer.valueOf(r13));
        r84.a.a("CurrLocation " + r2);
        r84.a.a(r16 + r13 + r12 + r17);
        return;
    L80:
        return;
    L56:
        if (((ArrayList) this.e).size() == 1) goto L72;
        if (r2.b == false) goto L72;
        ArrayList r18 = (ArrayList) this.e;
        com.bytedance.bdnavigationsdk.pojo.b r19 = (com.bytedance.bdnavigationsdk.pojo.b) ListProtector.get(r18, r18.size() - 2);
        if (r15 > this.a.a) goto L72;
        long r20 = r19.f;
        double r21 = (r11 - r20) / 1000.0d;
        if (r20 <= 0) goto L72;
        if (r11 <= 0) goto L72;
        if (r21 <= 0.0d) goto L72;
        int r22 = w84.b.a;
        com.bytedance.bdnavigationsdk.pojo.a r23 = r19.c;
        Intrinsics.checkNotNull(r23);
        Intrinsics.checkNotNull(r14);
        if (w84.b.a(r23, r14) <= (((double) this.a.h) * r21)) goto L73;
    L22:
        if (((ArrayList) this.e).isEmpty() == false) goto L24;
    L48:
        r9 = "projectionResult";
    L47:
        r12 = ", ";
        r16 = "CurrProjection, idx ";
    L49:
        boolean r24 = false;
    L50:
        if (r24 == true) goto L54;
        return;
    L24:
        if (((ArrayList) this.e).size() == 1) goto L48;
        if (r2.b == false) goto L48;
        ArrayList r25 = (ArrayList) this.e;
        com.bytedance.bdnavigationsdk.pojo.b r27 = (com.bytedance.bdnavigationsdk.pojo.b) ListProtector.get(r25, r25.size() - 2);
        if (r27.b == false) goto L48;
        float r28 = r27.g;
        float r29 = this.a.a;
        if (r28 > r29) goto L48;
        if (r15 > r29) goto L48;
        long r110 = r27.f;
        r9 = "projectionResult";
        double r30 = (r11 - r110) / 1000.0d;
        if (r110 <= 0) goto L47;
        if (r11 <= 0) goto L47;
        if (r30 <= 0.0d) goto L47;
        int r31 = w84.b.a;
        com.bytedance.bdnavigationsdk.pojo.a r32 = r27.c;
        Intrinsics.checkNotNull(r32);
        Intrinsics.checkNotNull(r14);
        r12 = ", ";
        r16 = "CurrProjection, idx ";
        if (w84.b.a(r32, r14) > (((double) this.a.h) * r30)) goto L49;
        this.h = true;
        r24 = true;
        goto L50
    L16:
        if (r26.c != 1) goto L18;
        r5 = true;
        goto L19
    }

    @Override // y84.h
    public final void f(int r1) {
        this.j = r1;
    }

    public final ProjectionResult i(com.bytedance.bdnavigationsdk.pojo.b r69) throws Exception {
        a r0 = this;
        if (r0.c > 1) goto L5;
    L12:
        List<com.bytedance.bdnavigationsdk.pojo.b> r6 = r0.d(4);
        r6.add(r69);
        int r7 = d.a;
        Intrinsics.checkNotNullParameter(r6, "history");
        List<com.bytedance.bdnavigationsdk.pojo.b> r8 = r6.subList(Math.max(0, r6.size() - 5), r6.size());
        double r10 = 0.5d;
        if (r8.size() >= 5) goto L15;
        e r9 = new e(0.0f, 0.0f);
    L51:
        RouteProjector r1 = r0.i;
        com.bytedance.bdnavigationsdk.pojo.a r3 = r69.c;
        Intrinsics.checkNotNull(r3);
        long r4 = r69.f;
        int r2 = r0.j;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "point");
        Intrinsics.checkNotNullParameter(r9, "directionResult");
        int r11 = r1.d;
        ProjectionResult r12 = r1.c();
        if (r2 >= 0) goto L54;
    L56:
        RouteProjector.b r5 = null;
    L57:
        if (r5 == null) goto L59;
        int r13 = r5.e;
    L60:
        int r14 = RangesKt.coerceIn(r13, 0, r1.a.size());
        if (r14 == 0) goto L63;
        if (r14 <= r11) goto L63;
    L64:
        if (r12 == null) goto L78;
        ProjectionResult.Position r15 = r12.i;
        if (r15 != ProjectionResult.Position.BEFORE) goto L69;
        r11 = r12.e;
        List<com.bytedance.bdnavigationsdk.pojo.d> r16 = r1.a.subList(r11, r14);
    L79:
        int r17 = r16.size();
        int r18 = 1;
        int r19 = 0;
    L80:
        if (r18 >= r17) goto L85;
        com.bytedance.bdnavigationsdk.pojo.a r110 = ((com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r16, r18)).a;
        Intrinsics.checkNotNull(r110);
        if (w84.b.a(r110, r3) > 2000.0f) goto L85;
        r19 = r18;
        r18 = r18 + 1;
    L85:
        List<com.bytedance.bdnavigationsdk.pojo.d> r20 = r16.subList(0, r19 + 1);
        int r111 = w84.d.a;
        Intrinsics.checkNotNullParameter(r3, "point");
        List<com.bytedance.bdnavigationsdk.pojo.d> r112 = r20;
        if (r112 != null) goto L88;
    L91:
        boolean r113 = true;
    L92:
        String r114 = "coords";
        String r115 = "lineString";
        if (r113 == false) goto L95;
        List<com.bytedance.bdnavigationsdk.pojo.d> r40 = r20;
        long r34 = r4;
        e r26 = r9;
        int r33 = r11;
        ProjectionResult r32 = r12;
        String r31 = "coords";
        String r25 = "lineString";
        ProjectionResult r21 = null;
    L198:
        if (r21 == null) goto L390;
        long r22 = r34;
        r21.l = r22;
        r21.f = ((com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r40, r21.e)).d;
        int r23 = r33 + r21.e;
        r21.e = r23;
        if (r32 == null) goto L205;
        ProjectionResult r24 = r32;
        if (r24.e != r23) goto L205;
        r21.h += r24.h;
    L205:
        if (r21.i != ProjectionResult.Position.AFTER) goto L209;
        int r27 = r23 + 1;
        RouteProjector r28 = r1;
        if (((com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r28.a, r27)).b == null) goto L210;
        r21.b = ((com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r28.a, r27)).a;
        r21.c = ((com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r28.a, r27)).b;
        r21.e = r27;
        r21.f = ((com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r28.a, r27)).d;
        r21.h = 0.0f;
        r21.i = ProjectionResult.Position.BEFORE;
    L210:
        ProjectionResult r29 = r28.c();
        if (r29 != null) goto L213;
        RouteProjector.Decision r30 = RouteProjector.Decision.NORMAL;
        r28.a(r21, r21);
    L369:
        if (r21.g <= this.a.e) goto L371;
        boolean r35 = true;
    L372:
        r21.j = r35;
        if (this.c == 1) goto L375;
    L388:
        return r21;
    L375:
        if (((ArrayList) this.g).size() >= 10) goto L388;
        if (r21.g > this.a.f) goto L379;
    L386:
        boolean r36 = false;
    L387:
        r21.k = r36;
        goto L388
    L379:
        if (r21.f != 0) goto L386;
        if (r21.h != 0.0f) goto L383;
        boolean r37 = true;
    L384:
        if (r37 == false) goto L386;
        r36 = true;
        goto L387
    L383:
        r37 = false;
        goto L384
    L371:
        r35 = false;
        goto L372
    L213:
        float r38 = RangesKt.coerceAtLeast(r22 - r29.l, 1) / 1000.0f;
        float r39 = r28.b(r21, r29);
        int r41 = r29.e;
        int r42 = r21.e;
        if (r41 > r42) goto L292;
        if (r41 != r42) goto L297;
        ProjectionResult.Position r43 = r29.i;
        if (r43 != null) goto L220;
        int r44 = -1;
    L222:
        if (r44 == (-1)) goto L296;
        if (r44 != 1) goto L226;
        ProjectionResult.Position r45 = r21.i;
        if (r45 != null) goto L280;
        int r46 = -1;
        int r116 = -1;
    L281:
        if (r116 == r46) goto L294;
        if (r116 == 1) goto L291;
        if (r116 == 2) goto L297;
        if (r116 == 3) goto L297;
        if (r116 == 4) goto L294;
        throw new NoWhenBranchMatchedException();
    L291:
        if (r21.g <= r29.g) goto L297;
    L294:
        throw new NotImplementedError(null, 1, null);
    L280:
        r116 = RouteProjector.c.a[r45.ordinal()];
        r46 = -1;
        goto L281
    L226:
        if (r44 == 2) goto L252;
        if (r44 != 3) goto L229;
        ProjectionResult.Position r47 = r21.i;
        if (r47 != null) goto L235;
        int r48 = -1;
    L237:
        if (r48 == (-1)) goto L251;
        if (r48 == 1) goto L292;
        if (r48 == 2) goto L292;
        if (r48 == 3) goto L248;
        if (r48 == 4) goto L251;
        throw new NoWhenBranchMatchedException();
    L248:
        if (r21.g <= r29.g) goto L297;
    L251:
        throw new NotImplementedError(null, 1, null);
    L235:
        r48 = RouteProjector.c.a[r47.ordinal()];
        goto L237
    L229:
        if (r44 == 4) goto L296;
        throw new NoWhenBranchMatchedException();
    L252:
        ProjectionResult.Position r49 = r21.i;
        if (r49 != null) goto L255;
        int r50 = -1;
    L257:
        if (r50 == (-1)) goto L276;
        if (r50 == 1) goto L292;
        if (r50 == 2) goto L266;
        if (r50 == 3) goto L297;
        if (r50 == 4) goto L276;
        throw new NoWhenBranchMatchedException();
    L266:
        float r51 = r21.h;
        float r52 = r29.h;
        if (r51 < r52) goto L292;
        if (r51 != r52) goto L270;
        boolean r53 = true;
    L271:
        if (r53 == false) goto L297;
        if (r21.g <= r29.g) goto L297;
    L270:
        r53 = false;
    L276:
        throw new NotImplementedError(null, 1, null);
    L255:
        r50 = RouteProjector.c.a[r49.ordinal()];
    L296:
        throw new NotImplementedError(null, 1, null);
    L220:
        r44 = RouteProjector.c.a[r43.ordinal()];
    L297:
        boolean r54 = false;
    L298:
        if (r54 == false) goto L300;
        RouteProjector.Decision r55 = RouteProjector.Decision.NORMAL;
        ProjectionResult r56 = RouteProjector.d(r21, r29);
        r28.a(r21, r56);
    L343:
        r21 = r56;
        goto L369
    L300:
        float r57 = r21.g;
        t84.c r58 = r28.b;
        if (r57 <= r58.g) goto L304;
        RouteProjector.Decision r59 = RouteProjector.Decision.NORMAL;
        r56 = RouteProjector.d(r21, r29);
        r28.a(r21, r56);
        goto L343
    L304:
        if (r39 > (r58.j * r38)) goto L307;
        RouteProjector.Decision r60 = RouteProjector.Decision.NORMAL;
        r28.a(r21, r21);
        goto L369
    L307:
        if (r39 > r58.i) goto L345;
        int r61 = r29.e;
        int r62 = r21.e;
        if (r61 > r62) goto L341;
    L310:
        com.bytedance.bdnavigationsdk.pojo.d r63 = (com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r28.a, r61);
        if (r61 != r29.e) goto L313;
        com.bytedance.bdnavigationsdk.pojo.a r64 = r29.d;
    L314:
        Intrinsics.checkNotNull(r64);
        if (r61 != r21.e) goto L317;
        com.bytedance.bdnavigationsdk.pojo.a r65 = r21.d;
    L318:
        Intrinsics.checkNotNull(r65);
        if (w84.b.a(r64, r65) > r28.b.k) goto L320;
        String r66 = r25;
        String r67 = r31;
        if (r61 == r62) goto L341;
        r61 = r61 + 1;
        r25 = r66;
        r31 = r67;
        goto L310
    L320:
        List r68 = CollectionsKt.listOf(new com.bytedance.bdnavigationsdk.pojo.a[]{r64, r65});
        int r70 = w84.d.a;
        float r71 = r28.b.k;
        Intrinsics.checkNotNullParameter(r68, r25);
        List r72 = r68;
        ArrayList r73 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r72, 10));
        Iterator r74 = r72.iterator();
    L322:
        if (r74.hasNext() == false) goto L324;
        com.bytedance.bdnavigationsdk.pojo.a r75 = (com.bytedance.bdnavigationsdk.pojo.a) r74.next();
        r73.add(new x84.f(r75.b, r75.a));
        goto L322
    L324:
        int r76 = x84.d.a;
        double r77 = r71;
        Intrinsics.checkNotNullParameter(r73, r31);
        Intrinsics.checkNotNullParameter("meters", "units");
        int r78 = r73.size() - 1;
        double r79 = 0.0d;
        int r117 = 0;
    L325:
        if (r117 >= r78) goto L336;
        x84.f r80 = (x84.f) ListProtector.get(r73, r117);
        r117 = r117 + 1;
        x84.f r118 = (x84.f) ListProtector.get(r73, r117);
        double r210 = x84.d.c(r80, r118, "meters") + r79;
        if (r210 >= r77) goto L328;
        r79 = r210;
        goto L325
    L328:
        double r81 = r77 - r79;
        if (r81 != 0.0d) goto L331;
        boolean r119 = true;
    L332:
        if (r119 == true) goto L337;
        r80 = x84.d.b(r80, r81, x84.d.a(r80, r118), "meters");
    L337:
        com.bytedance.bdnavigationsdk.pojo.a r82 = w84.d.a(r80);
        com.bytedance.bdnavigationsdk.pojo.a r83 = r63.a;
        com.bytedance.bdnavigationsdk.pojo.a r85 = r63.b;
        int r86 = r63.d;
        int r87 = w84.b.a;
        com.bytedance.bdnavigationsdk.pojo.a r88 = r21.a;
        Intrinsics.checkNotNull(r88);
        float r610 = w84.b.a(r88, r82);
        com.bytedance.bdnavigationsdk.pojo.a r89 = r63.a;
        Intrinsics.checkNotNull(r89);
        r56 = ProjectionResult.a(r21, r83, r85, r82, r61, r86, r610, w84.b.a(r89, r82), ProjectionResult.Position.ON, 0, 3585);
    L342:
        RouteProjector.Decision r90 = RouteProjector.Decision.NORMAL;
        r28.a(r21, r56);
        goto L343
    L331:
        r119 = false;
        goto L332
    L336:
        r80 = (x84.f) CollectionsKt.last(r73);
        goto L337
    L317:
        r65 = r63.b;
        goto L318
    L313:
        r64 = r63.a;
    L341:
        r56 = r21;
        goto L342
    L345:
        if (((ArrayList) r28.f).size() >= 3) goto L348;
        RouteProjector.Decision r91 = RouteProjector.Decision.NORMAL;
        r56 = RouteProjector.d(r21, r29);
        r28.a(r21, r56);
        goto L343
    L348:
        ArrayList r92 = (ArrayList) r28.f;
        List r93 = CollectionsKt.toMutableList(r92.subList(Math.max(0, r92.size() - 3), ((ArrayList) r28.f).size()));
        r93.add(r21);
        int r94 = r93.size() - 1;
        float r95 = 0.0f;
        int r96 = 0;
    L349:
        if (r96 >= r94) goto L352;
        ProjectionResult r97 = (ProjectionResult) ListProtector.get(r93, r96);
        r96 = r96 + 1;
        ProjectionResult r98 = (ProjectionResult) ListProtector.get(r93, r96);
        r95 = Math.max(r95, r28.b(r97, r98) / RangesKt.coerceAtLeast((r98.l - r97.l) / 1000.0f, 0.8f));
        goto L349
    L352:
        if (Float.valueOf(r95).floatValue() <= r28.b.j) goto L355;
        ProjectionResult r99 = RouteProjector.d(r21, r29);
        RouteProjector.Decision r100 = RouteProjector.Decision.NORMAL;
        r28.a(r21, r99);
    L354:
        r21 = r99;
        goto L369
    L355:
        e r101 = r26;
        if (r101.b >= 0.5d) goto L358;
        r99 = RouteProjector.d(r21, r29);
        RouteProjector.Decision r102 = RouteProjector.Decision.NORMAL;
        r28.a(r21, r99);
        goto L354
    L358:
        int r103 = w84.a.a;
        com.bytedance.bdnavigationsdk.pojo.a r104 = r21.b;
        Intrinsics.checkNotNull(r104);
        com.bytedance.bdnavigationsdk.pojo.a r105 = r21.c;
        Intrinsics.checkNotNull(r105);
        float r106 = r101.a - w84.a.a(r104, r105);
        float r107 = 360;
        float r108 = ((r106 % r107) + r107) % r107;
        if (r108 <= 180.0f) goto L362;
        r108 = r107 - r108;
    L362:
        if (r108 <= 60.0f) goto L364;
        r99 = RouteProjector.d(r21, r29);
        RouteProjector.Decision r109 = RouteProjector.Decision.NORMAL;
        r28.a(r21, r99);
        goto L354
    L364:
        ProjectionResult.Position r120 = r21.i;
        Intrinsics.checkNotNull(r120);
        if (r120 == ProjectionResult.Position.ON) goto L367;
        r99 = RouteProjector.d(r21, r29);
        RouteProjector.Decision r121 = RouteProjector.Decision.NORMAL;
        r28.a(r21, r99);
        goto L354
    L367:
        RouteProjector.Decision r122 = RouteProjector.Decision.NORMAL;
        r28.a(r21, r21);
    L292:
        r54 = true;
        goto L298
    L209:
        r28 = r1;
        goto L210
    L390:
        throw new NullPointerException("Cannot project to route");
    L95:
        x84.f r123 = new x84.f(r3.b, r3.a);
        ArrayList r124 = new ArrayList();
        Iterator<com.bytedance.bdnavigationsdk.pojo.d> r125 = r20.iterator();
        com.bytedance.bdnavigationsdk.pojo.a r126 = null;
    L97:
        if (r125.hasNext() == false) goto L112;
        com.bytedance.bdnavigationsdk.pojo.d r127 = r125.next();
        com.bytedance.bdnavigationsdk.pojo.a r128 = r127.a;
        if (r128 == null) goto L105;
        if (r126 != null) goto L102;
    L103:
        com.bytedance.bdnavigationsdk.pojo.a r129 = r127.a;
        Intrinsics.checkNotNull(r129);
        double r130 = r129.b;
        com.bytedance.bdnavigationsdk.pojo.a r131 = r127.a;
        Intrinsics.checkNotNull(r131);
        r124.add(new x84.f(r130, r131.a));
        r126 = r127.a;
        goto L105
    L102:
        if (Intrinsics.areEqual(r128, r126) == false) goto L103;
    L105:
        com.bytedance.bdnavigationsdk.pojo.a r132 = r127.b;
        if (r132 == null) goto L111;
        if (r126 != null) goto L109;
    L110:
        com.bytedance.bdnavigationsdk.pojo.a r133 = r127.b;
        Intrinsics.checkNotNull(r133);
        double r134 = r133.b;
        com.bytedance.bdnavigationsdk.pojo.a r135 = r127.b;
        Intrinsics.checkNotNull(r135);
        r124.add(new x84.f(r134, r135.a));
        r126 = r127.b;
        goto L111
    L109:
        if (Intrinsics.areEqual(r132, r126) == false) goto L110;
    L111:
        r123 = r123;
        r12 = r12;
        r11 = r11;
        goto L97
    L112:
        r33 = r11;
        r32 = r12;
        x84.f r136 = r123;
        Intrinsics.checkNotNullParameter(r136, "point");
        Intrinsics.checkNotNullParameter(r124, "lineString");
        int r137 = x84.e.a;
        String r138 = "meters";
        Intrinsics.checkNotNullParameter(r136, "pt");
        Intrinsics.checkNotNullParameter(r124, "coords");
        if (r124.size() < 2) goto L115;
        boolean r139 = true;
    L116:
        if (r139 == false) goto L394;
        x84.c r140 = new x84.c(new x84.f(Double.NaN, Double.NaN), Double.POSITIVE_INFINITY, -1);
        int r141 = r124.size() - 1;
        int r142 = 0;
    L118:
        if (r142 >= r141) goto L173;
        x84.f r143 = (x84.f) ListProtector.get(r124, r142);
        int r144 = r142 + 1;
        x84.f r145 = (x84.f) ListProtector.get(r124, r144);
        String r146 = r114;
        String r211 = r115;
        double r147 = x84.d.c(r136, r143, r138);
        long r310 = r4;
        double r148 = x84.d.c(r136, r145, r138);
        int r311 = r141;
        x84.c r149 = new x84.c(r143, r147, r142);
        x84.c r150 = new x84.c(r145, r148, r142);
        double r312 = Math.max(r147, r148);
        double r410 = x84.d.a(r143, r145);
        double r151 = 90;
        x84.f r212 = r136;
        String r313 = r138;
        x84.f r152 = x84.d.b(r212, r312, r410 + r151, r313);
        x84.f r153 = x84.d.b(r212, r312, r410 - r151, r313);
        e r213 = r9;
        double r154 = r152.a;
        double r155 = r152.b;
        x84.c r214 = r140;
        double r156 = r153.a;
        int r314 = r142;
        double r157 = r153.b;
        ArrayList r158 = r124;
        String r315 = r138;
        double r159 = r143.a;
        double r160 = r143.b;
        List<com.bytedance.bdnavigationsdk.pojo.d> r411 = r20;
        x84.f r412 = r136;
        double r161 = r145.a;
        double r162 = r145.b - r160;
        double r163 = r156 - r154;
        double r164 = r161 - r159;
        double r413 = r157 - r155;
        double r414 = (r162 * r163) - (r164 * r413);
        if (r414 != 0.0d) goto L122;
        boolean r165 = true;
    L123:
        if (r165 == true) goto L141;
        double r166 = r155 - r160;
        double r167 = r154 - r159;
        double r168 = ((r164 * r166) - (r162 * r167)) / r414;
        double r169 = ((r166 * r163) - (r167 * r413)) / r414;
        Double r170 = Double.valueOf(r154 + (r163 * r168));
        Double r171 = Double.valueOf(r155 + (r413 * r168));
        x84.a r172 = new x84.a(r170, r171, false, false);
        if (r168 < 0.0d) goto L131;
        if (r168 > 1.0d) goto L131;
        r172 = new x84.a(r170, r171, true, false);
    L131:
        if (r169 >= 0.0d) goto L133;
    L135:
        x84.a r173 = r172;
    L137:
        if (r173.c == false) goto L141;
        if (r173.d == false) goto L141;
    L142:
        if (r173 != null) goto L144;
    L146:
        boolean r174 = false;
    L147:
        if (r174 == true) goto L149;
    L159:
        String r175 = r315;
        x84.f r176 = r412;
        x84.c r177 = null;
    L161:
        if (r147 >= r214.b) goto L164;
        r214 = r149;
    L164:
        if (r148 >= r214.b) goto L166;
        x84.c r178 = r150;
    L167:
        if (r177 != null) goto L169;
    L171:
        r140 = r178;
    L172:
        r138 = r175;
        r124 = r158;
        r115 = r211;
        r9 = r213;
        r114 = r146;
        r4 = r310;
        r141 = r311;
        r142 = r144;
        r136 = r176;
        r20 = r411;
        goto L118
    L169:
        if (r177.b >= r178.b) goto L171;
        r140 = r177;
        goto L172
    L166:
        r178 = r214;
        goto L167
    L149:
        if (r173.d == false) goto L159;
        Double r179 = r173.a;
        if (r179 == null) goto L153;
        double r180 = r179.doubleValue();
    L154:
        Double r181 = r173.b;
        if (r181 == null) goto L157;
        double r182 = r181.doubleValue();
    L158:
        x84.f r183 = new x84.f(r180, r182);
        r175 = r315;
        r176 = r412;
        r177 = new x84.c(r183, x84.d.c(r176, r183, r175), r314);
        goto L161
    L157:
        r182 = Double.POSITIVE_INFINITY;
        goto L158
    L153:
        r180 = Double.POSITIVE_INFINITY;
        goto L154
    L144:
        if (r173.c != true) goto L146;
        r174 = true;
        goto L147
    L133:
        if (r169 > 1.0d) goto L135;
        r173 = new x84.a(r172.a, r172.b, r172.c, true);
    L141:
        r173 = null;
        goto L142
    L122:
        r165 = false;
        goto L123
    L173:
        r40 = r20;
        x84.f r184 = r136;
        r34 = r4;
        r26 = r9;
        r31 = r114;
        r25 = r115;
        ArrayList r185 = r124;
        x84.f r186 = r140.a;
        if (Double.isNaN(r186.a) == false) goto L176;
    L179:
        boolean r187 = true;
    L180:
        if (r187 == false) goto L182;
    L187:
        boolean r188 = true;
    L188:
        if (r188 == true) goto L392;
        double r189 = r140.b;
        int r190 = r140.c;
        x84.f r191 = r140.a;
        int r192 = x84.d.a;
        double r193 = x84.d.c((x84.f) ListProtector.get(r185, r190), r191, "meters");
        int r194 = r190 + 1;
        double r195 = x84.d.c((x84.f) ListProtector.get(r185, r190), (x84.f) ListProtector.get(r185, r194), "meters");
        if (r193 > 0.0d) goto L194;
        ProjectionResult.Position r196 = ProjectionResult.Position.BEFORE;
    L197:
        r21 = new ProjectionResult(w84.d.a(r184), w84.d.a((x84.f) ListProtector.get(r185, r190)), w84.d.a((x84.f) ListProtector.get(r185, r194)), w84.d.a(r191), r190, 0, (float) com.bytedance.bdnavigationsdk.utils.b.a(r189, 2), (float) com.bytedance.bdnavigationsdk.utils.b.a(r193, 2), r196, false, 0, 3104);
        goto L198
    L194:
        if (r193 < r195) goto L196;
        r196 = ProjectionResult.Position.AFTER;
        goto L197
    L196:
        r196 = ProjectionResult.Position.ON;
        goto L197
    L392:
        throw new NullPointerException("Turf nearestPointOnLine does not return legal result");
    L182:
        if (Double.isInfinite(r140.b) == true) goto L187;
        if (r140.c == (-1)) goto L187;
        r188 = false;
        goto L188
    L176:
        if (Double.isNaN(r186.b) == true) goto L179;
        r187 = false;
        goto L180
    L394:
        throw new IllegalArgumentException(new Exception("Turf nearestPointOnLine requires a List of Points made up of at least 2 coordinates.").toString());
    L115:
        r139 = false;
        goto L116
    L88:
        if (r112.isEmpty() == true) goto L91;
        r113 = false;
        goto L92
    L69:
        if (r15 != ProjectionResult.Position.ON) goto L74;
        ArrayList r197 = new ArrayList();
        int r198 = r12.e;
        com.bytedance.bdnavigationsdk.pojo.d r199 = (com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r1.a, r198);
        r197.add(new com.bytedance.bdnavigationsdk.pojo.d(r12.d, r199.b, r198, r199.d, 2032));
        if (r198 >= (r14 - 1)) goto L73;
        r197.addAll(r1.a.subList(r198 + 1, r14));
    L73:
        r16 = r197;
        r11 = r198;
        goto L79
    L74:
        int r1100 = r14 - 2;
        if (r11 >= r1100) goto L77;
        r11 = r12.e + 1;
        r16 = r1.a.subList(r11, r14);
        goto L79
    L77:
        r11 = r12.e;
        r16 = r1.a.subList(r1100, r14);
        goto L79
    L78:
        r16 = r1.a.subList(r11, r14);
    L63:
        r14 = r1.a.size();
        goto L64
    L59:
        r13 = r1.a.size();
        goto L60
    L54:
        if (r2 >= ((ArrayList) r1.c).size()) goto L56;
        r5 = (RouteProjector.b) ListProtector.get(r1.c, r2);
        goto L57
    L15:
        ArrayList r200 = new ArrayList();
        int r201 = r8.size();
        int r202 = 1;
    L16:
        if (r202 >= r201) goto L22;
        com.bytedance.bdnavigationsdk.pojo.b r203 = (com.bytedance.bdnavigationsdk.pojo.b) ListProtector.get(r8, r202 - 1);
        com.bytedance.bdnavigationsdk.pojo.b r204 = (com.bytedance.bdnavigationsdk.pojo.b) ListProtector.get(r8, r202);
        int r1101 = w84.b.a;
        com.bytedance.bdnavigationsdk.pojo.a r205 = r203.c;
        Intrinsics.checkNotNull(r205);
        com.bytedance.bdnavigationsdk.pojo.a r1102 = r204.c;
        Intrinsics.checkNotNull(r1102);
        float r206 = w84.b.a(r205, r1102);
        if (r206 < r10) goto L20;
        int r1103 = w84.a.a;
        com.bytedance.bdnavigationsdk.pojo.a r1104 = r203.c;
        Intrinsics.checkNotNull(r1104);
        com.bytedance.bdnavigationsdk.pojo.a r1105 = r204.c;
        Intrinsics.checkNotNull(r1105);
        r200.add(new c(w84.a.a(r1104, r1105), r206, r202, (r204.f - r203.f) * 0.001f));
    L20:
        r202 = r202 + 1;
        r10 = 0.5d;
        goto L16
    L22:
        if (r200.size() >= 2) goto L24;
        r9 = new e(0.0f, 0.0f);
        goto L51
    L24:
        int r207 = r200.size();
        Iterator r208 = r200.iterator();
        int r209 = 0;
        double r215 = 0.0d;
        double r216 = 0.0d;
        double r1106 = 0.0d;
        float r1107 = 0.0f;
        double r1108 = 0.0d;
    L26:
        if (r208.hasNext() == false) goto L29;
        c r1109 = (c) r208.next();
        int r217 = r207;
        double r218 = Math.pow(0.6d, (r207 - 1) - r209) * ((double) r1109.b);
        int r219 = w84.c.a;
        r216 = r216 + (((double) ((float) Math.sin((float) w84.c.c(r1109.a)))) * r218);
        r1106 = r1106 + (((double) ((float) Math.cos((float) w84.c.c(r1109.a)))) * r218);
        r215 = r215 + r218;
        r1108 = r1108 + ((double) r1109.b);
        r1107 = r1107 + r1109.d;
        r209 = r209 + 1;
        r208 = r208;
        r207 = r217;
        goto L26
    L29:
        if (r215 != 0.0d) goto L31;
        boolean r220 = true;
    L32:
        if (r220 == false) goto L34;
    L49:
        r9 = new e(0.0f, 0.0f);
    L50:
        r0 = this;
        goto L51
    L34:
        if (r216 != 0.0d) goto L36;
        boolean r221 = true;
    L37:
        if (r221 == true) goto L39;
    L44:
        int r222 = w84.c.a;
        double r223 = 360;
        double r224 = (((Math.atan2(r216, r1106) * 180.0d) / 3.141592653589793d) + r223) % r223;
        double r225 = RangesKt.coerceIn(Math.hypot(r216, r1106) / r215, 0.0d, 1.0d);
        if (r1107 <= 0.0f) goto L47;
        double r226 = r1108 / ((double) r1107);
    L48:
        r9 = new e((float) r224, (float) (r225 * RangesKt.coerceIn(r226 / 0.8d, 0.0d, 1.0d)));
        goto L50
    L47:
        r226 = 0.0d;
        goto L48
    L39:
        if (r1106 != 0.0d) goto L41;
        boolean r227 = true;
    L42:
        if (r227 == false) goto L44;
    L41:
        r227 = false;
        goto L42
    L36:
        r221 = false;
        goto L37
    L31:
        r220 = false;
        goto L32
    L5:
        if (r69.a >= 10) goto L12;
        com.bytedance.bdnavigationsdk.pojo.a r1110 = ((com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r0.d, 0)).a;
        int r228 = w84.b.a;
        com.bytedance.bdnavigationsdk.pojo.a r229 = r69.c;
        Intrinsics.checkNotNull(r229);
        Intrinsics.checkNotNull(r1110);
        if (w84.b.a(r229, r1110) <= r0.a.e) goto L9;
        boolean r1111 = true;
    L11:
        return new ProjectionResult(r69.c, ((com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r0.d, 0)).a, ((com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r0.d, 0)).b, r1110, ((com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r0.d, 0)).c, ((com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r0.d, 0)).d, 0.0f, 0.0f, ProjectionResult.Position.ON, r1111, r69.f, DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION);
    L9:
        r1111 = false;
        goto L11
    }

    public final void j(i r7) {
        Intrinsics.checkNotNullParameter(r7, "yawConfigure");
        j r8 = r7.b();     // Catch: Exception -> L5
        com.bytedance.bdnavigationsdk.e r3 = r84.a.a;     // Catch: Exception -> L5
        r84.a.d(null, "profile = " + r8.a, 5);     // Catch: Exception -> L5
        r84.a.d(null, "universalThreshold = " + r8.c, 5);     // Catch: Exception -> L5
        r84.a.d(null, "dynamicThreshold = " + r8.b, 5);     // Catch: Exception -> L5
        this.a = r8.c;     // Catch: Exception -> L5
        this.b = r8.b;     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        r84.a.b("设置偏航阈值失败", e, 1);
    }
}
