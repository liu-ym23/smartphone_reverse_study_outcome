package y84;

import androidx.camera.video.AudioStats;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.bdnavigationsdk.network.route.RoutePath;
import com.bytedance.bdnavigationsdk.network.route.q;
import com.bytedance.bdnavigationsdk.pojo.ProjectionResult;
import com.bytedance.bdnavigationsdk.pojo.YawResult;
import com.bytedance.bdnavigationsdk.yaw.RouteProjector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ttvideoengine.DataLoaderHelper;
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

/* JADX INFO: loaded from: classes10.dex */
public abstract class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t84.c f566881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, t84.b> f566882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f566883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<com.bytedance.bdnavigationsdk.pojo.d> f566884d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<com.bytedance.bdnavigationsdk.pojo.b> f566885e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<Integer> f566886f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<ProjectionResult> f566887g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f566888h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RouteProjector f566889i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f566890j;

    /* JADX INFO: renamed from: y84.a$a, reason: collision with other inner class name */
    public static final class C8313a {
    }

    static {
    }

    @Override // y84.h
    public final YawResult c() {
    L28:
        e = move-exception;
        r84.a.b("checkYaw error", e, 1);
        YawResult r100 = new YawResult(YawResult.ErrCode.SYSTEM_ERROR, null);
    L30:
        com.bytedance.bdnavigationsdk.e r101 = r84.a.f536505a;
        r84.a.a("Result, idx " + (((ArrayList) this.f566885e).size() - 1) + ", " + r100);
        return r100;
    L4:
        if (((ArrayList) this.f566887g).size() >= 10) goto L6;
        YawResult.ErrCode r102 = YawResult.ErrCode.INSUFFICIENT_USABLE_LOCATION;     // Catch: Exception -> L28
    L8:
        if (((ArrayList) this.f566887g).size() > 10) goto L10;
        int r103 = 0;
    L11:
        int r104 = ((ArrayList) this.f566887g).size();     // Catch: Exception -> L28
        if (g() == false) goto L19;
        List<com.bytedance.bdnavigationsdk.pojo.b> r105 = this.f566885e;     // Catch: Exception -> L28
        Integer r106 = h();     // Catch: Exception -> L28
        Intrinsics.checkNotNull(r106);     // Catch: Exception -> L28
        com.bytedance.bdnavigationsdk.pojo.a r107 = ((com.bytedance.bdnavigationsdk.pojo.b) ListProtector.get(r105, r106.intValue())).f200336c;     // Catch: Exception -> L28
        if (((ArrayList) this.f566887g).isEmpty() == false) goto L16;
        ProjectionResult r108 = null;
    L17:
        List<com.bytedance.bdnavigationsdk.pojo.b> r109 = this.f566885e;     // Catch: Exception -> L28
        Integer r110 = h();     // Catch: Exception -> L28
        Intrinsics.checkNotNull(r110);     // Catch: Exception -> L28
        r100 = new YawResult(r102, new YawResult.c(true, r107, r108, (com.bytedance.bdnavigationsdk.pojo.b) ListProtector.get(r109, r110.intValue()), ((ArrayList) this.f566887g).subList(r103, r104)));     // Catch: Exception -> L28
        goto L30
    L16:
        ArrayList r111 = (ArrayList) this.f566887g;     // Catch: Exception -> L28
        r108 = (ProjectionResult) ListProtector.get(r111, r111.size() - 1);     // Catch: Exception -> L28
        goto L17
    L19:
        if (((ArrayList) this.f566887g).isEmpty() == false) goto L21;
        ProjectionResult r112 = null;
    L23:
        if (h() != null) goto L25;
        com.bytedance.bdnavigationsdk.pojo.b r113 = null;
    L26:
        r100 = new YawResult(r102, new YawResult.c(false, null, r112, r113, ((ArrayList) this.f566887g).subList(r103, r104)));     // Catch: Exception -> L28
        goto L30
    L25:
        List<com.bytedance.bdnavigationsdk.pojo.b> r114 = this.f566885e;     // Catch: Exception -> L28
        Integer r115 = h();     // Catch: Exception -> L28
        Intrinsics.checkNotNull(r115);     // Catch: Exception -> L28
        r113 = (com.bytedance.bdnavigationsdk.pojo.b) ListProtector.get(r114, r115.intValue());     // Catch: Exception -> L28
        goto L26
    L21:
        ArrayList r116 = (ArrayList) this.f566887g;     // Catch: Exception -> L28
        r112 = (ProjectionResult) ListProtector.get(r116, r116.size() - 1);     // Catch: Exception -> L28
        goto L23
    L10:
        r103 = ((ArrayList) this.f566887g).size() - 10;     // Catch: Exception -> L28
        goto L11
    L6:
        r102 = YawResult.ErrCode.SUCCESS;     // Catch: Exception -> L28
        goto L8
    }

    @Override // y84.h
    public final void clear() {
        this.f566888h = false;
        this.f566884d = new ArrayList();
        this.f566885e = new ArrayList();
        this.f566886f = new ArrayList();
        this.f566887g = new ArrayList();
        RouteProjector r100 = this.f566889i;
        ((ArrayList) r100.f200391f).clear();
        ((ArrayList) r100.f200390e).clear();
        r100.f200389d = 0;
        this.f566890j = 0;
    }

    public final boolean g() {
        if (((ArrayList) this.f566886f).size() >= 10) goto L5;
        return false;
    L5:
        int r100 = ((ArrayList) this.f566886f).size() - 10;
        int r101 = ((ArrayList) this.f566886f).size();
        int r102 = 0;
        int r103 = 0;
        int r104 = 0;
    L6:
        boolean r105 = true;
        if (r100 >= r101) goto L77;
        if (r100 > 0) goto L10;
        int r110 = r101;
    L75:
        r100 = r100 + 1;
        r101 = r110;
        goto L6
    L10:
        int r111 = r100 - 1;
        com.bytedance.bdnavigationsdk.pojo.b r106 = (com.bytedance.bdnavigationsdk.pojo.b) ListProtector.get(this.f566885e, ((Number) ListProtector.get(this.f566886f, r111)).intValue());
        com.bytedance.bdnavigationsdk.pojo.b r107 = (com.bytedance.bdnavigationsdk.pojo.b) ListProtector.get(this.f566885e, ((Number) ListProtector.get(this.f566886f, r100)).intValue());
        ProjectionResult r112 = (ProjectionResult) ListProtector.get(this.f566887g, r111);
        ProjectionResult r113 = (ProjectionResult) ListProtector.get(this.f566887g, r100);
        t84.b r114 = this.f566882b.get("trusted_level_" + r107.f200338e);
        if (this.f566883c != 1) goto L16;
        if ((((com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(this.f566884d, r113.f200307e)).f200359g + r113.f200310h) > this.f566881a.f545026c) goto L16;
        r114 = this.f566882b.get("dist_to_start");
    L16:
        if ((((com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(this.f566884d, r113.f200307e)).f200360h - r113.f200310h) > this.f566881a.f545027d) goto L18;
        r114 = this.f566882b.get("dist_to_end");
    L18:
        float r115 = r113.f200309g;
        Intrinsics.checkNotNull(r114);
        if (r115 <= r114.f545020a) goto L24;
        if (r113.f200309g <= r112.f200309g) goto L24;
        r102 = r102 + 1;
    L24:
        if (r113.f200309g <= this.f566881a.f545030g) goto L26;
        r103 = r103 + 1;
    L26:
        int r116 = w84.a.f558622a;
        com.bytedance.bdnavigationsdk.pojo.a r117 = r106.f200336c;
        Intrinsics.checkNotNull(r117);
        com.bytedance.bdnavigationsdk.pojo.a r118 = r107.f200336c;
        Intrinsics.checkNotNull(r118);
        float r119 = w84.a.a(r117, r118);
        com.bytedance.bdnavigationsdk.pojo.a r120 = r112.f200306d;
        Intrinsics.checkNotNull(r120);
        com.bytedance.bdnavigationsdk.pojo.a r121 = r113.f200306d;
        Intrinsics.checkNotNull(r121);
        float r122 = w84.a.a(r120, r121);
        com.bytedance.bdnavigationsdk.pojo.a r123 = r112.f200306d;
        Intrinsics.checkNotNull(r123);
        com.bytedance.bdnavigationsdk.pojo.a r124 = r113.f200306d;
        Intrinsics.checkNotNull(r124);
        if (Intrinsics.areEqual(r123, r124) == false) goto L29;
        com.bytedance.bdnavigationsdk.pojo.a r125 = r113.f200304b;
        Intrinsics.checkNotNull(r125);
        com.bytedance.bdnavigationsdk.pojo.a r126 = r113.f200305c;
        Intrinsics.checkNotNull(r126);
        r122 = w84.a.a(r125, r126);
    L29:
        r110 = r101;
        if (((r107.f200339f - r106.f200339f) / 1000.0d) >= this.f566881a.f545025b) goto L75;
        float r108 = r114.f545021b;
        if (r108 < 180.0f) goto L35;
    L73:
        if (r105 == true) goto L75;
        r104 = r104 + 1;
        goto L75
    L35:
        if (r108 >= 0.0f) goto L38;
    L72:
        r105 = false;
        goto L73
    L38:
        if (r119 >= 0.0f) goto L40;
        float r109 = 360;
        float r127 = (r119 % r109) + r109;
    L42:
        if (r122 >= 0.0f) goto L44;
        float r128 = 360;
        float r129 = (r122 % r128) + r128;
    L45:
        float r130 = r129 - r108;
        if (r130 < 0.0f) goto L48;
        float r131 = r129 + r108;
        if (r131 <= 360.0f) goto L68;
        if (r130 > r127) goto L63;
        if (r127 < 360.0f) goto L73;
    L63:
        if (0.0f > r127) goto L72;
        if (r127 > (r131 - 360)) goto L72;
    L68:
        if (r130 > r127) goto L72;
        if (r127 > r131) goto L72;
    L48:
        if ((r130 + 360) > r127) goto L52;
        if (r127 < 360.0f) goto L73;
    L52:
        if (0.0f > r127) goto L72;
        if (r127 > (r129 + r108)) goto L72;
    L44:
        r129 = r122 % 360;
        goto L45
    L40:
        r127 = r119 % 360;
        goto L42
    L77:
        if (r102 <= 6.0d) goto L79;
        boolean r132 = true;
    L81:
        if (r103 <= 3.0d) goto L83;
        boolean r133 = true;
    L85:
        if (r104 <= 6.0d) goto L87;
        boolean r134 = true;
    L88:
        com.bytedance.bdnavigationsdk.e r135 = r84.a.f536505a;
        r84.a.a("Final Dynamic, idx " + (((ArrayList) this.f566885e).size() - 1) + ", ProjectionDistYaw " + r132 + ", ProjectionDistExceed " + r133 + ", BearingYaw " + r134);
        if (r133 == false) goto L91;
        return true;
    L91:
        if (r132 == false) goto L93;
        return r134;
    L93:
        return false;
    L87:
        r134 = false;
        goto L88
    L83:
        r133 = false;
        goto L85
    L79:
        r132 = false;
        goto L81
    }

    public final Integer h() {
        if (this.f566886f.isEmpty() == false) goto L5;
        return null;
    L5:
        List<Integer> r100 = this.f566886f;
        return (Integer) ListProtector.get(r100, r100.size() - 1);
    }

    public a() {
        this.f566881a = new t84.c(0);
        this.f566882b = new HashMap();
        this.f566884d = new ArrayList();
        this.f566885e = new ArrayList();
        this.f566886f = new ArrayList();
        this.f566887g = new ArrayList();
        this.f566889i = new RouteProjector(this.f566884d, this.f566881a, new ArrayList());
    }

    @Override // y84.h
    public final void a(List<com.bytedance.bdnavigationsdk.pojo.c> r100) throws Exception {
        Iterator<com.bytedance.bdnavigationsdk.pojo.c> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        e(r101.next());
        goto L4
    }

    @Override // y84.h
    public final void b(RoutePath r210) {
        Intrinsics.checkNotNullParameter(r210, "routePath");
        int r100 = this.f566883c + 1;
        this.f566883c = r100;
        com.bytedance.bdnavigationsdk.e r101 = r84.a.f536505a;
        r84.a.d(null, "Start Init Yaw " + r100, 5);
        ArrayList r102 = new ArrayList();
        List<q> r103 = r210.f200199d;
        Intrinsics.checkNotNull(r103);
        Iterator<q> r104 = r103.iterator();
    L4:
        if (r104.hasNext() == false) goto L10;
        List<com.bytedance.bdnavigationsdk.pojo.a> r105 = r104.next().f200270g;
        Intrinsics.checkNotNull(r105);
        Iterator<com.bytedance.bdnavigationsdk.pojo.a> r106 = r105.iterator();
        String r107 = "";
    L7:
        if (r106.hasNext() == false) goto L9;
        com.bytedance.bdnavigationsdk.pojo.a r108 = r106.next();
        r107 = r107 + r108.f200331b + "," + r108.f200330a + com.alipay.sdk.m.u.i.f25853b;
        goto L7
    L9:
        com.bytedance.bdnavigationsdk.e r109 = r84.a.f536505a;
        r84.a.a("Step polyline " + r107);
        goto L4
    L10:
        com.bytedance.bdnavigationsdk.e r110 = r84.a.f536505a;
        r84.a.a("RoutePath distance " + r210.f200197b);
        List<q> r111 = r210.f200199d;
        Intrinsics.checkNotNull(r111);
        int r112 = r111.size();
        float r113 = 0.0f;
        int r114 = 0;
        int r115 = 0;
    L11:
        if (r115 >= r112) goto L19;
        List<q> r116 = r210.f200199d;
        Intrinsics.checkNotNull(r116);
        q r117 = (q) ListProtector.get(r116, r115);
        List<com.bytedance.bdnavigationsdk.pojo.a> r118 = r117.f200270g;
        Intrinsics.checkNotNull(r118);
        int r119 = r118.size() - 1;
        float r120 = r113;
        int r121 = r114;
        int r122 = 0;
    L13:
        if (r122 >= r119) goto L15;
        List<com.bytedance.bdnavigationsdk.pojo.a> r123 = r117.f200270g;
        Intrinsics.checkNotNull(r123);
        com.bytedance.bdnavigationsdk.pojo.a r124 = (com.bytedance.bdnavigationsdk.pojo.a) ListProtector.get(r123, r122);
        List<com.bytedance.bdnavigationsdk.pojo.a> r125 = r117.f200270g;
        Intrinsics.checkNotNull(r125);
        int r126 = r122 + 1;
        com.bytedance.bdnavigationsdk.pojo.d r127 = new com.bytedance.bdnavigationsdk.pojo.d(r124, (com.bytedance.bdnavigationsdk.pojo.a) ListProtector.get(r125, r126), r121, r115, DataLoaderHelper.DATALOADER_KEY_INT_PRELOAD_INFO_RECORD_MAX_COUNT);
        r102.add(r127);
        r120 = r120 + r127.f200357e;
        r121 = r121 + 1;
        r122 = r126;
        goto L13
    L15:
        List<q> r128 = r210.f200199d;
        Intrinsics.checkNotNull(r128);
        if (r115 != (r128.size() - 1)) goto L18;
        List<com.bytedance.bdnavigationsdk.pojo.a> r129 = r117.f200270g;
        Intrinsics.checkNotNull(r129);
        List<com.bytedance.bdnavigationsdk.pojo.a> r130 = r117.f200270g;
        Intrinsics.checkNotNull(r130);
        r102.add(new com.bytedance.bdnavigationsdk.pojo.d((com.bytedance.bdnavigationsdk.pojo.a) ListProtector.get(r129, r130.size() - 1), null, r121, r115, DataLoaderHelper.DATALOADER_KEY_INT_PRELOAD_INFO_RECORD_MAX_COUNT));
    L18:
        r115 = r115 + 1;
        r113 = r120;
        r114 = r121;
        goto L11
    L19:
        float r131 = com.bytedance.bdnavigationsdk.utils.b.b(r113, 2);
        com.bytedance.bdnavigationsdk.e r132 = r84.a.f536505a;
        r84.a.a("Real path distance " + r131);
        int r133 = r102.size();
        int r134 = 0;
    L20:
        if (r134 >= r133) goto L44;
        if (r134 > 0) goto L23;
    L28:
        float r135 = 0.0f;
    L30:
        if (r134 >= (r102.size() - 2)) goto L35;
        com.bytedance.bdnavigationsdk.pojo.d.b r136 = com.bytedance.bdnavigationsdk.pojo.d.Companion;
        com.bytedance.bdnavigationsdk.pojo.d r137 = (com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r102, r134);
        com.bytedance.bdnavigationsdk.pojo.d r138 = (com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r102, r134 + 1);
        r136.getClass();
        if (r137 == null) goto L35;
        if (r138 == null) goto L35;
        float r139 = com.bytedance.bdnavigationsdk.utils.b.b(r138.f200361i - r137.f200361i, 2);
    L36:
        com.bytedance.bdnavigationsdk.pojo.d r140 = (com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r102, r134);
        float r141 = com.bytedance.bdnavigationsdk.utils.b.b(r135, 2);
        r140.getClass();
        r140.f200362j = com.bytedance.bdnavigationsdk.utils.b.b(r141, 2);
        com.bytedance.bdnavigationsdk.pojo.d r142 = (com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r102, r134);
        float r143 = com.bytedance.bdnavigationsdk.utils.b.b(r139, 2);
        r142.getClass();
        r142.f200363k = com.bytedance.bdnavigationsdk.utils.b.b(r143, 2);
        if (r134 != 0) goto L40;
        float r144 = r131;
        float r145 = 0.0f;
    L43:
        com.bytedance.bdnavigationsdk.pojo.d r146 = (com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r102, r134);
        float r147 = com.bytedance.bdnavigationsdk.utils.b.b(r145, 2);
        r146.getClass();
        r146.f200359g = com.bytedance.bdnavigationsdk.utils.b.b(r147, 2);
        com.bytedance.bdnavigationsdk.pojo.d r148 = (com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r102, r134);
        float r149 = com.bytedance.bdnavigationsdk.utils.b.b(r144, 2);
        r148.getClass();
        r148.f200360h = com.bytedance.bdnavigationsdk.utils.b.b(r149, 2);
        com.bytedance.bdnavigationsdk.e r150 = r84.a.f536505a;
        r84.a.a("Segment " + ListProtector.get(r102, r134));
        r134 = r134 + 1;
        goto L20
    L40:
        if (r134 != (r102.size() - 1)) goto L42;
        r145 = r131;
        r144 = 0.0f;
        goto L43
    L42:
        int r151 = r134 - 1;
        r145 = ((com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r102, r151)).f200359g + ((com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r102, r151)).f200357e;
        r144 = ((com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r102, r151)).f200360h - ((com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r102, r151)).f200357e;
    L35:
        r139 = 0.0f;
        goto L36
    L23:
        if (r134 >= (r102.size() - 1)) goto L28;
        com.bytedance.bdnavigationsdk.pojo.d.b r152 = com.bytedance.bdnavigationsdk.pojo.d.Companion;
        com.bytedance.bdnavigationsdk.pojo.d r153 = (com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r102, r134 - 1);
        com.bytedance.bdnavigationsdk.pojo.d r154 = (com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r102, r134);
        r152.getClass();
        if (r153 == null) goto L28;
        if (r154 == null) goto L28;
        r135 = com.bytedance.bdnavigationsdk.utils.b.b(r154.f200361i - r153.f200361i, 2);
        goto L30
    L44:
        this.f566888h = false;
        this.f566884d = r102;
        this.f566885e = new ArrayList();
        this.f566886f = new ArrayList();
        this.f566887g = new ArrayList();
        this.f566889i = new RouteProjector(r102, this.f566881a, r210.f200202g);
        this.f566890j = 0;
    }

    @Override // y84.h
    public final List<com.bytedance.bdnavigationsdk.pojo.b> d(int r100) {
        List<Integer> r101 = this.f566886f;
        List<Integer> r102 = r101.subList(Math.max(0, r101.size() - r100), this.f566886f.size());
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L7;
        int r105 = ((Number) r104.next()).intValue();
        r103.add((com.bytedance.bdnavigationsdk.pojo.b) ListProtector.get(this.f566885e, r105));
        goto L4
    L7:
        return CollectionsKt.toMutableList(r103);
    }

    @Override // y84.h
    public final void e(com.bytedance.bdnavigationsdk.pojo.c r210) throws Exception {
        if (r210 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r210.f200345b, "gcj02") == false) goto L78;
        int r110 = ((ArrayList) this.f566885e).size();
        com.bytedance.bdnavigationsdk.pojo.a r111 = r210.f200347d;
        int r100 = r210.f200344a;
        int r101 = r210.f200346c;
        long r112 = r210.f200350g;
        float r113 = r210.f200348e;
        com.bytedance.bdnavigationsdk.pojo.b r102 = new com.bytedance.bdnavigationsdk.pojo.b(r110, true, r111, r100, r101, r112, r113, r210.f200349f);
        if (((ArrayList) this.f566885e).isEmpty() == false) goto L11;
        Intrinsics.checkNotNullParameter(r102, "userLocation");
        ((ArrayList) this.f566885e).add(r102);
        com.bytedance.bdnavigationsdk.e r103 = r84.a.f536505a;
        r84.a.a("Location " + r102);
        ProjectionResult r104 = i(r102);
        Intrinsics.checkNotNullParameter(r104, "projectionResult");
        ((ArrayList) this.f566887g).add(r104);
        ((ArrayList) this.f566886f).add(Integer.valueOf(r110));
        r84.a.a("CurrLocation " + r102);
        r84.a.a("CurrProjection, idx " + r110 + ", " + r104);
        return;
    L11:
        int r105 = r210.f200344a;
        boolean r114 = true;
        if (r105 == 1) goto L14;
        return;
    L14:
        if (r105 == 1) goto L16;
    L18:
        boolean r106 = false;
    L19:
        r102.f200335b = r106;
        Intrinsics.checkNotNullParameter(r102, "userLocation");
        ((ArrayList) this.f566885e).add(r102);
        com.bytedance.bdnavigationsdk.e r107 = r84.a.f536505a;
        r84.a.a("Location " + r102);
        if (this.f566888h == false) goto L22;
        String r108 = "projectionResult";
        String r109 = ", ";
        String r115 = "CurrProjection, idx ";
    L54:
        if (((ArrayList) this.f566885e).isEmpty() == false) goto L56;
    L72:
        r114 = false;
    L73:
        if (r114 == false) goto L80;
        ProjectionResult r116 = i(r102);
        Intrinsics.checkNotNullParameter(r116, r108);
        ((ArrayList) this.f566887g).add(r116);
        ((ArrayList) this.f566886f).add(Integer.valueOf(r110));
        r84.a.a("CurrLocation " + r102);
        r84.a.a(r115 + r110 + r109 + r116);
        return;
    L80:
        return;
    L56:
        if (((ArrayList) this.f566885e).size() == 1) goto L72;
        if (r102.f200335b == false) goto L72;
        ArrayList r117 = (ArrayList) this.f566885e;
        com.bytedance.bdnavigationsdk.pojo.b r118 = (com.bytedance.bdnavigationsdk.pojo.b) ListProtector.get(r117, r117.size() - 2);
        if (r113 > this.f566881a.f545024a) goto L72;
        long r119 = r118.f200339f;
        double r120 = (r112 - r119) / 1000.0d;
        if (r119 <= 0) goto L72;
        if (r112 <= 0) goto L72;
        if (r120 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L72;
        int r121 = w84.b.f558623a;
        com.bytedance.bdnavigationsdk.pojo.a r122 = r118.f200336c;
        Intrinsics.checkNotNull(r122);
        Intrinsics.checkNotNull(r111);
        if (w84.b.a(r122, r111) <= (((double) this.f566881a.f545031h) * r120)) goto L73;
    L22:
        if (((ArrayList) this.f566885e).isEmpty() == false) goto L24;
    L48:
        r108 = "projectionResult";
    L47:
        r109 = ", ";
        r115 = "CurrProjection, idx ";
    L49:
        boolean r123 = false;
    L50:
        if (r123 == true) goto L54;
        return;
    L24:
        if (((ArrayList) this.f566885e).size() == 1) goto L48;
        if (r102.f200335b == false) goto L48;
        ArrayList r124 = (ArrayList) this.f566885e;
        com.bytedance.bdnavigationsdk.pojo.b r125 = (com.bytedance.bdnavigationsdk.pojo.b) ListProtector.get(r124, r124.size() - 2);
        if (r125.f200335b == false) goto L48;
        float r126 = r125.f200340g;
        float r127 = this.f566881a.f545024a;
        if (r126 > r127) goto L48;
        if (r113 > r127) goto L48;
        long r128 = r125.f200339f;
        r108 = "projectionResult";
        double r129 = (r112 - r128) / 1000.0d;
        if (r128 <= 0) goto L47;
        if (r112 <= 0) goto L47;
        if (r129 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L47;
        int r130 = w84.b.f558623a;
        com.bytedance.bdnavigationsdk.pojo.a r131 = r125.f200336c;
        Intrinsics.checkNotNull(r131);
        Intrinsics.checkNotNull(r111);
        r109 = ", ";
        r115 = "CurrProjection, idx ";
        if (w84.b.a(r131, r111) > (((double) this.f566881a.f545031h) * r129)) goto L49;
        this.f566888h = true;
        r123 = true;
        goto L50
    L16:
        if (r210.f200346c != 1) goto L18;
        r106 = true;
        goto L19
    }

    @Override // y84.h
    public final void f(int r100) {
        this.f566890j = r100;
    }

    public final ProjectionResult i(com.bytedance.bdnavigationsdk.pojo.b r610) throws Exception {
        a r100 = this;
        if (r100.f566883c > 1) goto L5;
    L12:
        List<com.bytedance.bdnavigationsdk.pojo.b> r101 = r100.d(4);
        r101.add(r610);
        int r102 = d.f566895a;
        Intrinsics.checkNotNullParameter(r101, "history");
        List<com.bytedance.bdnavigationsdk.pojo.b> r103 = r101.subList(Math.max(0, r101.size() - 5), r101.size());
        double r110 = 0.5d;
        if (r103.size() >= 5) goto L15;
        e r104 = new e(0.0f, 0.0f);
    L51:
        RouteProjector r105 = r100.f566889i;
        com.bytedance.bdnavigationsdk.pojo.a r106 = r610.f200336c;
        Intrinsics.checkNotNull(r106);
        long r107 = r610.f200339f;
        int r108 = r100.f566890j;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "point");
        Intrinsics.checkNotNullParameter(r104, "directionResult");
        int r109 = r105.f200389d;
        ProjectionResult r111 = r105.c();
        if (r108 >= 0) goto L54;
    L56:
        RouteProjector.b r112 = null;
    L57:
        if (r112 == null) goto L59;
        int r113 = r112.f200396e;
    L60:
        int r114 = RangesKt.coerceIn(r113, 0, r105.f200386a.size());
        if (r114 == 0) goto L63;
        if (r114 <= r109) goto L63;
    L64:
        if (r111 == null) goto L78;
        ProjectionResult.Position r115 = r111.f200311i;
        if (r115 != ProjectionResult.Position.BEFORE) goto L69;
        r109 = r111.f200307e;
        List<com.bytedance.bdnavigationsdk.pojo.d> r116 = r105.f200386a.subList(r109, r114);
    L79:
        int r117 = r116.size();
        int r118 = 1;
        int r119 = 0;
    L80:
        if (r118 >= r117) goto L85;
        com.bytedance.bdnavigationsdk.pojo.a r120 = ((com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r116, r118)).f200353a;
        Intrinsics.checkNotNull(r120);
        if (w84.b.a(r120, r106) > 2000.0f) goto L85;
        r119 = r118;
        r118 = r118 + 1;
    L85:
        List<com.bytedance.bdnavigationsdk.pojo.d> r121 = r116.subList(0, r119 + 1);
        int r122 = w84.d.f558625a;
        Intrinsics.checkNotNullParameter(r106, "point");
        List<com.bytedance.bdnavigationsdk.pojo.d> r123 = r121;
        if (r123 != null) goto L88;
    L91:
        boolean r124 = true;
    L92:
        String r125 = "coords";
        String r126 = "lineString";
        if (r124 == false) goto L95;
        List<com.bytedance.bdnavigationsdk.pojo.d> r410 = r121;
        long r310 = r107;
        e r210 = r104;
        int r311 = r109;
        ProjectionResult r312 = r111;
        String r313 = "coords";
        String r211 = "lineString";
        ProjectionResult r127 = null;
    L198:
        if (r127 == null) goto L390;
        long r128 = r310;
        r127.f200314l = r128;
        r127.f200308f = ((com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r410, r127.f200307e)).f200356d;
        int r129 = r311 + r127.f200307e;
        r127.f200307e = r129;
        if (r312 == null) goto L205;
        ProjectionResult r130 = r312;
        if (r130.f200307e != r129) goto L205;
        r127.f200310h += r130.f200310h;
    L205:
        if (r127.f200311i != ProjectionResult.Position.AFTER) goto L209;
        int r131 = r129 + 1;
        RouteProjector r132 = r105;
        if (((com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r132.f200386a, r131)).f200354b == null) goto L210;
        r127.f200304b = ((com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r132.f200386a, r131)).f200353a;
        r127.f200305c = ((com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r132.f200386a, r131)).f200354b;
        r127.f200307e = r131;
        r127.f200308f = ((com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r132.f200386a, r131)).f200356d;
        r127.f200310h = 0.0f;
        r127.f200311i = ProjectionResult.Position.BEFORE;
    L210:
        ProjectionResult r133 = r132.c();
        if (r133 != null) goto L213;
        RouteProjector.Decision r134 = RouteProjector.Decision.NORMAL;
        r132.a(r127, r127);
    L369:
        if (r127.f200309g <= this.f566881a.f545028e) goto L371;
        boolean r135 = true;
    L372:
        r127.f200312j = r135;
        if (this.f566883c == 1) goto L375;
    L388:
        return r127;
    L375:
        if (((ArrayList) this.f566887g).size() >= 10) goto L388;
        if (r127.f200309g > this.f566881a.f545029f) goto L379;
    L386:
        boolean r136 = false;
    L387:
        r127.f200313k = r136;
        goto L388
    L379:
        if (r127.f200308f != 0) goto L386;
        if (r127.f200310h != 0.0f) goto L383;
        boolean r137 = true;
    L384:
        if (r137 == false) goto L386;
        r136 = true;
        goto L387
    L383:
        r137 = false;
        goto L384
    L371:
        r135 = false;
        goto L372
    L213:
        float r138 = RangesKt.coerceAtLeast(r128 - r133.f200314l, 1) / 1000.0f;
        float r139 = r132.b(r127, r133);
        int r140 = r133.f200307e;
        int r141 = r127.f200307e;
        if (r140 > r141) goto L292;
        if (r140 != r141) goto L297;
        ProjectionResult.Position r142 = r133.f200311i;
        if (r142 != null) goto L220;
        int r143 = -1;
    L222:
        if (r143 == (-1)) goto L296;
        if (r143 != 1) goto L226;
        ProjectionResult.Position r144 = r127.f200311i;
        if (r144 != null) goto L280;
        int r145 = -1;
        int r146 = -1;
    L281:
        if (r146 == r145) goto L294;
        if (r146 == 1) goto L291;
        if (r146 == 2) goto L297;
        if (r146 == 3) goto L297;
        if (r146 == 4) goto L294;
        throw new NoWhenBranchMatchedException();
    L291:
        if (r127.f200309g <= r133.f200309g) goto L297;
    L294:
        throw new NotImplementedError(null, 1, null);
    L280:
        r146 = RouteProjector.c.f200397a[r144.ordinal()];
        r145 = -1;
        goto L281
    L226:
        if (r143 == 2) goto L252;
        if (r143 != 3) goto L229;
        ProjectionResult.Position r147 = r127.f200311i;
        if (r147 != null) goto L235;
        int r148 = -1;
    L237:
        if (r148 == (-1)) goto L251;
        if (r148 == 1) goto L292;
        if (r148 == 2) goto L292;
        if (r148 == 3) goto L248;
        if (r148 == 4) goto L251;
        throw new NoWhenBranchMatchedException();
    L248:
        if (r127.f200309g <= r133.f200309g) goto L297;
    L251:
        throw new NotImplementedError(null, 1, null);
    L235:
        r148 = RouteProjector.c.f200397a[r147.ordinal()];
        goto L237
    L229:
        if (r143 == 4) goto L296;
        throw new NoWhenBranchMatchedException();
    L252:
        ProjectionResult.Position r149 = r127.f200311i;
        if (r149 != null) goto L255;
        int r150 = -1;
    L257:
        if (r150 == (-1)) goto L276;
        if (r150 == 1) goto L292;
        if (r150 == 2) goto L266;
        if (r150 == 3) goto L297;
        if (r150 == 4) goto L276;
        throw new NoWhenBranchMatchedException();
    L266:
        float r151 = r127.f200310h;
        float r152 = r133.f200310h;
        if (r151 < r152) goto L292;
        if (r151 != r152) goto L270;
        boolean r153 = true;
    L271:
        if (r153 == false) goto L297;
        if (r127.f200309g <= r133.f200309g) goto L297;
    L270:
        r153 = false;
    L276:
        throw new NotImplementedError(null, 1, null);
    L255:
        r150 = RouteProjector.c.f200397a[r149.ordinal()];
    L296:
        throw new NotImplementedError(null, 1, null);
    L220:
        r143 = RouteProjector.c.f200397a[r142.ordinal()];
    L297:
        boolean r154 = false;
    L298:
        if (r154 == false) goto L300;
        RouteProjector.Decision r155 = RouteProjector.Decision.NORMAL;
        ProjectionResult r156 = RouteProjector.d(r127, r133);
        r132.a(r127, r156);
    L343:
        r127 = r156;
        goto L369
    L300:
        float r157 = r127.f200309g;
        t84.c r158 = r132.f200387b;
        if (r157 <= r158.f545030g) goto L304;
        RouteProjector.Decision r159 = RouteProjector.Decision.NORMAL;
        r156 = RouteProjector.d(r127, r133);
        r132.a(r127, r156);
        goto L343
    L304:
        if (r139 > (r158.f545033j * r138)) goto L307;
        RouteProjector.Decision r160 = RouteProjector.Decision.NORMAL;
        r132.a(r127, r127);
        goto L369
    L307:
        if (r139 > r158.f545032i) goto L345;
        int r161 = r133.f200307e;
        int r162 = r127.f200307e;
        if (r161 > r162) goto L341;
    L310:
        com.bytedance.bdnavigationsdk.pojo.d r163 = (com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r132.f200386a, r161);
        if (r161 != r133.f200307e) goto L313;
        com.bytedance.bdnavigationsdk.pojo.a r164 = r133.f200306d;
    L314:
        Intrinsics.checkNotNull(r164);
        if (r161 != r127.f200307e) goto L317;
        com.bytedance.bdnavigationsdk.pojo.a r165 = r127.f200306d;
    L318:
        Intrinsics.checkNotNull(r165);
        if (w84.b.a(r164, r165) > r132.f200387b.f545034k) goto L320;
        String r166 = r211;
        String r167 = r313;
        if (r161 == r162) goto L341;
        r161 = r161 + 1;
        r211 = r166;
        r313 = r167;
        goto L310
    L320:
        List r168 = CollectionsKt.listOf(new com.bytedance.bdnavigationsdk.pojo.a[]{r164, r165});
        int r169 = w84.d.f558625a;
        float r170 = r132.f200387b.f545034k;
        Intrinsics.checkNotNullParameter(r168, r211);
        List r171 = r168;
        ArrayList r172 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r171, 10));
        Iterator r173 = r171.iterator();
    L322:
        if (r173.hasNext() == false) goto L324;
        com.bytedance.bdnavigationsdk.pojo.a r174 = (com.bytedance.bdnavigationsdk.pojo.a) r173.next();
        r172.add(new x84.f(r174.f200331b, r174.f200330a));
        goto L322
    L324:
        int r175 = x84.d.f562906a;
        double r176 = r170;
        Intrinsics.checkNotNullParameter(r172, r313);
        Intrinsics.checkNotNullParameter("meters", "units");
        int r177 = r172.size() - 1;
        double r178 = AudioStats.AUDIO_AMPLITUDE_NONE;
        int r179 = 0;
    L325:
        if (r179 >= r177) goto L336;
        x84.f r180 = (x84.f) ListProtector.get(r172, r179);
        r179 = r179 + 1;
        x84.f r181 = (x84.f) ListProtector.get(r172, r179);
        double r212 = x84.d.c(r180, r181, "meters") + r178;
        if (r212 >= r176) goto L328;
        r178 = r212;
        goto L325
    L328:
        double r182 = r176 - r178;
        if (r182 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L331;
        boolean r183 = true;
    L332:
        if (r183 == true) goto L337;
        r180 = x84.d.b(r180, r182, x84.d.a(r180, r181), "meters");
    L337:
        com.bytedance.bdnavigationsdk.pojo.a r184 = w84.d.a(r180);
        com.bytedance.bdnavigationsdk.pojo.a r185 = r163.f200353a;
        com.bytedance.bdnavigationsdk.pojo.a r186 = r163.f200354b;
        int r187 = r163.f200356d;
        int r188 = w84.b.f558623a;
        com.bytedance.bdnavigationsdk.pojo.a r189 = r127.f200303a;
        Intrinsics.checkNotNull(r189);
        float r611 = w84.b.a(r189, r184);
        com.bytedance.bdnavigationsdk.pojo.a r190 = r163.f200353a;
        Intrinsics.checkNotNull(r190);
        r156 = ProjectionResult.a(r127, r185, r186, r184, r161, r187, r611, w84.b.a(r190, r184), ProjectionResult.Position.ON, 0, 3585);
    L342:
        RouteProjector.Decision r191 = RouteProjector.Decision.NORMAL;
        r132.a(r127, r156);
        goto L343
    L331:
        r183 = false;
        goto L332
    L336:
        r180 = (x84.f) CollectionsKt.last(r172);
        goto L337
    L317:
        r165 = r163.f200354b;
        goto L318
    L313:
        r164 = r163.f200353a;
    L341:
        r156 = r127;
        goto L342
    L345:
        if (((ArrayList) r132.f200391f).size() >= 3) goto L348;
        RouteProjector.Decision r192 = RouteProjector.Decision.NORMAL;
        r156 = RouteProjector.d(r127, r133);
        r132.a(r127, r156);
        goto L343
    L348:
        ArrayList r193 = (ArrayList) r132.f200391f;
        List r194 = CollectionsKt.toMutableList(r193.subList(Math.max(0, r193.size() - 3), ((ArrayList) r132.f200391f).size()));
        r194.add(r127);
        int r195 = r194.size() - 1;
        float r196 = 0.0f;
        int r197 = 0;
    L349:
        if (r197 >= r195) goto L352;
        ProjectionResult r198 = (ProjectionResult) ListProtector.get(r194, r197);
        r197 = r197 + 1;
        ProjectionResult r199 = (ProjectionResult) ListProtector.get(r194, r197);
        r196 = Math.max(r196, r132.b(r198, r199) / RangesKt.coerceAtLeast((r199.f200314l - r198.f200314l) / 1000.0f, 0.8f));
        goto L349
    L352:
        if (Float.valueOf(r196).floatValue() <= r132.f200387b.f545033j) goto L355;
        ProjectionResult r200 = RouteProjector.d(r127, r133);
        RouteProjector.Decision r201 = RouteProjector.Decision.NORMAL;
        r132.a(r127, r200);
    L354:
        r127 = r200;
        goto L369
    L355:
        e r202 = r210;
        if (r202.f566897b >= 0.5d) goto L358;
        r200 = RouteProjector.d(r127, r133);
        RouteProjector.Decision r203 = RouteProjector.Decision.NORMAL;
        r132.a(r127, r200);
        goto L354
    L358:
        int r204 = w84.a.f558622a;
        com.bytedance.bdnavigationsdk.pojo.a r205 = r127.f200304b;
        Intrinsics.checkNotNull(r205);
        com.bytedance.bdnavigationsdk.pojo.a r206 = r127.f200305c;
        Intrinsics.checkNotNull(r206);
        float r207 = r202.f566896a - w84.a.a(r205, r206);
        float r208 = 360;
        float r209 = ((r207 % r208) + r208) % r208;
        if (r209 <= 180.0f) goto L362;
        r209 = r208 - r209;
    L362:
        if (r209 <= 60.0f) goto L364;
        r200 = RouteProjector.d(r127, r133);
        RouteProjector.Decision r213 = RouteProjector.Decision.NORMAL;
        r132.a(r127, r200);
        goto L354
    L364:
        ProjectionResult.Position r214 = r127.f200311i;
        Intrinsics.checkNotNull(r214);
        if (r214 == ProjectionResult.Position.ON) goto L367;
        r200 = RouteProjector.d(r127, r133);
        RouteProjector.Decision r215 = RouteProjector.Decision.NORMAL;
        r132.a(r127, r200);
        goto L354
    L367:
        RouteProjector.Decision r216 = RouteProjector.Decision.NORMAL;
        r132.a(r127, r127);
    L292:
        r154 = true;
        goto L298
    L209:
        r132 = r105;
        goto L210
    L390:
        throw new NullPointerException("Cannot project to route");
    L95:
        x84.f r1100 = new x84.f(r106.f200331b, r106.f200330a);
        ArrayList r217 = new ArrayList();
        Iterator<com.bytedance.bdnavigationsdk.pojo.d> r218 = r121.iterator();
        com.bytedance.bdnavigationsdk.pojo.a r219 = null;
    L97:
        if (r218.hasNext() == false) goto L112;
        com.bytedance.bdnavigationsdk.pojo.d r1101 = r218.next();
        com.bytedance.bdnavigationsdk.pojo.a r1102 = r1101.f200353a;
        if (r1102 == null) goto L105;
        if (r219 != null) goto L102;
    L103:
        com.bytedance.bdnavigationsdk.pojo.a r1103 = r1101.f200353a;
        Intrinsics.checkNotNull(r1103);
        double r1104 = r1103.f200331b;
        com.bytedance.bdnavigationsdk.pojo.a r1105 = r1101.f200353a;
        Intrinsics.checkNotNull(r1105);
        r217.add(new x84.f(r1104, r1105.f200330a));
        r219 = r1101.f200353a;
        goto L105
    L102:
        if (Intrinsics.areEqual(r1102, r219) == false) goto L103;
    L105:
        com.bytedance.bdnavigationsdk.pojo.a r220 = r1101.f200354b;
        if (r220 == null) goto L111;
        if (r219 != null) goto L109;
    L110:
        com.bytedance.bdnavigationsdk.pojo.a r221 = r1101.f200354b;
        Intrinsics.checkNotNull(r221);
        double r222 = r221.f200331b;
        com.bytedance.bdnavigationsdk.pojo.a r1106 = r1101.f200354b;
        Intrinsics.checkNotNull(r1106);
        r217.add(new x84.f(r222, r1106.f200330a));
        r219 = r1101.f200354b;
        goto L111
    L109:
        if (Intrinsics.areEqual(r220, r219) == false) goto L110;
    L111:
        r1100 = r1100;
        r111 = r111;
        r109 = r109;
        goto L97
    L112:
        r311 = r109;
        r312 = r111;
        x84.f r223 = r1100;
        Intrinsics.checkNotNullParameter(r223, "point");
        Intrinsics.checkNotNullParameter(r217, "lineString");
        int r224 = x84.e.f562907a;
        String r225 = "meters";
        Intrinsics.checkNotNullParameter(r223, GXTemplateKey.GAIAX_PT);
        Intrinsics.checkNotNullParameter(r217, "coords");
        if (r217.size() < 2) goto L115;
        boolean r226 = true;
    L116:
        if (r226 == false) goto L394;
        x84.c r227 = new x84.c(new x84.f(Double.NaN, Double.NaN), Double.POSITIVE_INFINITY, -1);
        int r228 = r217.size() - 1;
        int r1107 = 0;
    L118:
        if (r1107 >= r228) goto L173;
        x84.f r1108 = (x84.f) ListProtector.get(r217, r1107);
        int r1109 = r1107 + 1;
        x84.f r229 = (x84.f) ListProtector.get(r217, r1109);
        String r1110 = r125;
        String r230 = r126;
        double r1111 = x84.d.c(r223, r1108, r225);
        long r314 = r107;
        double r231 = x84.d.c(r223, r229, r225);
        int r315 = r228;
        x84.c r232 = new x84.c(r1108, r1111, r1107);
        x84.c r233 = new x84.c(r229, r231, r1107);
        double r316 = Math.max(r1111, r231);
        double r411 = x84.d.a(r1108, r229);
        double r234 = 90;
        x84.f r235 = r223;
        String r317 = r225;
        x84.f r236 = x84.d.b(r235, r316, r411 + r234, r317);
        x84.f r237 = x84.d.b(r235, r316, r411 - r234, r317);
        e r238 = r104;
        double r239 = r236.f562908a;
        double r1112 = r236.f562909b;
        x84.c r240 = r227;
        double r241 = r237.f562908a;
        int r318 = r1107;
        double r1113 = r237.f562909b;
        ArrayList r242 = r217;
        String r319 = r225;
        double r243 = r1108.f562908a;
        double r1114 = r1108.f562909b;
        List<com.bytedance.bdnavigationsdk.pojo.d> r412 = r121;
        x84.f r413 = r223;
        double r244 = r229.f562908a;
        double r245 = r229.f562909b - r1114;
        double r246 = r241 - r239;
        double r247 = r244 - r243;
        double r414 = r1113 - r1112;
        double r415 = (r245 * r246) - (r247 * r414);
        if (r415 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L122;
        boolean r1115 = true;
    L123:
        if (r1115 == true) goto L141;
        double r1116 = r1112 - r1114;
        double r248 = r239 - r243;
        double r249 = ((r247 * r1116) - (r245 * r248)) / r415;
        double r1117 = ((r1116 * r246) - (r248 * r414)) / r415;
        Double r250 = Double.valueOf(r239 + (r246 * r249));
        Double r251 = Double.valueOf(r1112 + (r414 * r249));
        x84.a r252 = new x84.a(r250, r251, false, false);
        if (r249 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L131;
        if (r249 > 1.0d) goto L131;
        r252 = new x84.a(r250, r251, true, false);
    L131:
        if (r1117 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L133;
    L135:
        x84.a r253 = r252;
    L137:
        if (r253.f562900c == false) goto L141;
        if (r253.f562901d == false) goto L141;
    L142:
        if (r253 != null) goto L144;
    L146:
        boolean r254 = false;
    L147:
        if (r254 == true) goto L149;
    L159:
        String r255 = r319;
        x84.f r256 = r413;
        x84.c r257 = null;
    L161:
        if (r1111 >= r240.f562904b) goto L164;
        r240 = r232;
    L164:
        if (r231 >= r240.f562904b) goto L166;
        x84.c r258 = r233;
    L167:
        if (r257 != null) goto L169;
    L171:
        r227 = r258;
    L172:
        r225 = r255;
        r217 = r242;
        r126 = r230;
        r104 = r238;
        r125 = r1110;
        r107 = r314;
        r228 = r315;
        r1107 = r1109;
        r223 = r256;
        r121 = r412;
        goto L118
    L169:
        if (r257.f562904b >= r258.f562904b) goto L171;
        r227 = r257;
        goto L172
    L166:
        r258 = r240;
        goto L167
    L149:
        if (r253.f562901d == false) goto L159;
        Double r259 = r253.f562898a;
        if (r259 == null) goto L153;
        double r260 = r259.doubleValue();
    L154:
        Double r261 = r253.f562899b;
        if (r261 == null) goto L157;
        double r262 = r261.doubleValue();
    L158:
        x84.f r263 = new x84.f(r260, r262);
        r255 = r319;
        r256 = r413;
        r257 = new x84.c(r263, x84.d.c(r256, r263, r255), r318);
        goto L161
    L157:
        r262 = Double.POSITIVE_INFINITY;
        goto L158
    L153:
        r260 = Double.POSITIVE_INFINITY;
        goto L154
    L144:
        if (r253.f562900c != true) goto L146;
        r254 = true;
        goto L147
    L133:
        if (r1117 > 1.0d) goto L135;
        r253 = new x84.a(r252.f562898a, r252.f562899b, r252.f562900c, true);
    L141:
        r253 = null;
        goto L142
    L122:
        r1115 = false;
        goto L123
    L173:
        r410 = r121;
        x84.f r264 = r223;
        r310 = r107;
        r210 = r104;
        r313 = r125;
        r211 = r126;
        ArrayList r265 = r217;
        x84.f r266 = r227.f562903a;
        if (Double.isNaN(r266.f562908a) == false) goto L176;
    L179:
        boolean r267 = true;
    L180:
        if (r267 == false) goto L182;
    L187:
        boolean r268 = true;
    L188:
        if (r268 == true) goto L392;
        double r269 = r227.f562904b;
        int r270 = r227.f562905c;
        x84.f r271 = r227.f562903a;
        int r272 = x84.d.f562906a;
        double r273 = x84.d.c((x84.f) ListProtector.get(r265, r270), r271, "meters");
        int r1118 = r270 + 1;
        double r274 = x84.d.c((x84.f) ListProtector.get(r265, r270), (x84.f) ListProtector.get(r265, r1118), "meters");
        if (r273 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L194;
        ProjectionResult.Position r275 = ProjectionResult.Position.BEFORE;
    L197:
        r127 = new ProjectionResult(w84.d.a(r264), w84.d.a((x84.f) ListProtector.get(r265, r270)), w84.d.a((x84.f) ListProtector.get(r265, r1118)), w84.d.a(r271), r270, 0, (float) com.bytedance.bdnavigationsdk.utils.b.a(r269, 2), (float) com.bytedance.bdnavigationsdk.utils.b.a(r273, 2), r275, false, 0, NewToolbarButtonConstants.TOOLBAR_ANCHOR_MORE_FUNCTION_SETTING);
        goto L198
    L194:
        if (r273 < r274) goto L196;
        r275 = ProjectionResult.Position.AFTER;
        goto L197
    L196:
        r275 = ProjectionResult.Position.ON;
        goto L197
    L392:
        throw new NullPointerException("Turf nearestPointOnLine does not return legal result");
    L182:
        if (Double.isInfinite(r227.f562904b) == true) goto L187;
        if (r227.f562905c == (-1)) goto L187;
        r268 = false;
        goto L188
    L176:
        if (Double.isNaN(r266.f562909b) == true) goto L179;
        r267 = false;
        goto L180
    L394:
        throw new IllegalArgumentException(new Exception("Turf nearestPointOnLine requires a List of Points made up of at least 2 coordinates.").toString());
    L115:
        r226 = false;
        goto L116
    L88:
        if (r123.isEmpty() == true) goto L91;
        r124 = false;
        goto L92
    L69:
        if (r115 != ProjectionResult.Position.ON) goto L74;
        ArrayList r276 = new ArrayList();
        int r1119 = r111.f200307e;
        com.bytedance.bdnavigationsdk.pojo.d r1120 = (com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r105.f200386a, r1119);
        r276.add(new com.bytedance.bdnavigationsdk.pojo.d(r111.f200306d, r1120.f200354b, r1119, r1120.f200356d, DataLoaderHelper.DATALOADER_KEY_INT_PRELOAD_INFO_RECORD_MAX_COUNT));
        if (r1119 >= (r114 - 1)) goto L73;
        r276.addAll(r105.f200386a.subList(r1119 + 1, r114));
    L73:
        r116 = r276;
        r109 = r1119;
        goto L79
    L74:
        int r1121 = r114 - 2;
        if (r109 >= r1121) goto L77;
        r109 = r111.f200307e + 1;
        r116 = r105.f200386a.subList(r109, r114);
        goto L79
    L77:
        r109 = r111.f200307e;
        r116 = r105.f200386a.subList(r1121, r114);
        goto L79
    L78:
        r116 = r105.f200386a.subList(r109, r114);
    L63:
        r114 = r105.f200386a.size();
        goto L64
    L59:
        r113 = r105.f200386a.size();
        goto L60
    L54:
        if (r108 >= ((ArrayList) r105.f200388c).size()) goto L56;
        r112 = (RouteProjector.b) ListProtector.get(r105.f200388c, r108);
        goto L57
    L15:
        ArrayList r277 = new ArrayList();
        int r278 = r103.size();
        int r279 = 1;
    L16:
        if (r279 >= r278) goto L22;
        com.bytedance.bdnavigationsdk.pojo.b r280 = (com.bytedance.bdnavigationsdk.pojo.b) ListProtector.get(r103, r279 - 1);
        com.bytedance.bdnavigationsdk.pojo.b r281 = (com.bytedance.bdnavigationsdk.pojo.b) ListProtector.get(r103, r279);
        int r1122 = w84.b.f558623a;
        com.bytedance.bdnavigationsdk.pojo.a r282 = r280.f200336c;
        Intrinsics.checkNotNull(r282);
        com.bytedance.bdnavigationsdk.pojo.a r1123 = r281.f200336c;
        Intrinsics.checkNotNull(r1123);
        float r283 = w84.b.a(r282, r1123);
        if (r283 < r110) goto L20;
        int r1124 = w84.a.f558622a;
        com.bytedance.bdnavigationsdk.pojo.a r1125 = r280.f200336c;
        Intrinsics.checkNotNull(r1125);
        com.bytedance.bdnavigationsdk.pojo.a r1126 = r281.f200336c;
        Intrinsics.checkNotNull(r1126);
        r277.add(new c(w84.a.a(r1125, r1126), r283, r279, (r281.f200339f - r280.f200339f) * 0.001f));
    L20:
        r279 = r279 + 1;
        r110 = 0.5d;
        goto L16
    L22:
        if (r277.size() >= 2) goto L24;
        r104 = new e(0.0f, 0.0f);
        goto L51
    L24:
        int r284 = r277.size();
        Iterator r285 = r277.iterator();
        int r286 = 0;
        double r287 = AudioStats.AUDIO_AMPLITUDE_NONE;
        double r288 = AudioStats.AUDIO_AMPLITUDE_NONE;
        double r1127 = AudioStats.AUDIO_AMPLITUDE_NONE;
        float r1128 = 0.0f;
        double r1129 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L26:
        if (r285.hasNext() == false) goto L29;
        c r1130 = (c) r285.next();
        int r289 = r284;
        double r290 = Math.pow(0.6d, (r284 - 1) - r286) * ((double) r1130.f566892b);
        int r291 = w84.c.f558624a;
        r288 = r288 + (((double) ((float) Math.sin((float) w84.c.c(r1130.f566891a)))) * r290);
        r1127 = r1127 + (((double) ((float) Math.cos((float) w84.c.c(r1130.f566891a)))) * r290);
        r287 = r287 + r290;
        r1129 = r1129 + ((double) r1130.f566892b);
        r1128 = r1128 + r1130.f566894d;
        r286 = r286 + 1;
        r285 = r285;
        r284 = r289;
        goto L26
    L29:
        if (r287 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L31;
        boolean r292 = true;
    L32:
        if (r292 == false) goto L34;
    L49:
        r104 = new e(0.0f, 0.0f);
    L50:
        r100 = this;
        goto L51
    L34:
        if (r288 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L36;
        boolean r293 = true;
    L37:
        if (r293 == true) goto L39;
    L44:
        int r294 = w84.c.f558624a;
        double r295 = 360;
        double r296 = (((Math.atan2(r288, r1127) * 180.0d) / 3.141592653589793d) + r295) % r295;
        double r297 = RangesKt.coerceIn(Math.hypot(r288, r1127) / r287, AudioStats.AUDIO_AMPLITUDE_NONE, 1.0d);
        if (r1128 <= 0.0f) goto L47;
        double r298 = r1129 / ((double) r1128);
    L48:
        r104 = new e((float) r296, (float) (r297 * RangesKt.coerceIn(r298 / 0.8d, AudioStats.AUDIO_AMPLITUDE_NONE, 1.0d)));
        goto L50
    L47:
        r298 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L48
    L39:
        if (r1127 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L41;
        boolean r299 = true;
    L42:
        if (r299 == false) goto L44;
    L41:
        r299 = false;
        goto L42
    L36:
        r293 = false;
        goto L37
    L31:
        r292 = false;
        goto L32
    L5:
        if (r610.f200334a >= 10) goto L12;
        com.bytedance.bdnavigationsdk.pojo.a r1131 = ((com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r100.f566884d, 0)).f200353a;
        int r300 = w84.b.f558623a;
        com.bytedance.bdnavigationsdk.pojo.a r301 = r610.f200336c;
        Intrinsics.checkNotNull(r301);
        Intrinsics.checkNotNull(r1131);
        if (w84.b.a(r301, r1131) <= r100.f566881a.f545028e) goto L9;
        boolean r1132 = true;
    L11:
        return new ProjectionResult(r610.f200336c, ((com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r100.f566884d, 0)).f200353a, ((com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r100.f566884d, 0)).f200354b, r1131, ((com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r100.f566884d, 0)).f200355c, ((com.bytedance.bdnavigationsdk.pojo.d) ListProtector.get(r100.f566884d, 0)).f200356d, 0.0f, 0.0f, ProjectionResult.Position.ON, r1132, r610.f200339f, 1024);
    L9:
        r1132 = false;
        goto L11
    }

    public final void j(i r100) {
        Intrinsics.checkNotNullParameter(r100, "yawConfigure");
        j r101 = r100.b();     // Catch: Exception -> L5
        com.bytedance.bdnavigationsdk.e r102 = r84.a.f536505a;     // Catch: Exception -> L5
        r84.a.d(null, "profile = " + r101.f566899a, 5);     // Catch: Exception -> L5
        r84.a.d(null, "universalThreshold = " + r101.f566901c, 5);     // Catch: Exception -> L5
        r84.a.d(null, "dynamicThreshold = " + r101.f566900b, 5);     // Catch: Exception -> L5
        this.f566881a = r101.f566901c;     // Catch: Exception -> L5
        this.f566882b = r101.f566900b;     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        r84.a.b("设置偏航阈值失败", e, 1);
    }
}
