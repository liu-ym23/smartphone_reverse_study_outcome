package uc2;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.test.CarnivalAutoTestUtil;
import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.DanmakuType;
import com.bytedance.live.artist.render.RenderEntity;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes9.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<b> f549437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<Integer> f549438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public q72.a f549439c;

    public f(q72.a r100) {
        Intrinsics.checkNotNullParameter(r100, "initialConfig");
        this.f549437a = new ArrayList();
        this.f549438b = new ArrayList();
        this.f549439c = r100;
        int r101 = r100.f531916a;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        this.f549437a.add(new h(r102, true, false, null));
        r102 = r102 + 1;
        goto L3
    }

    public final ArrayList<Integer> a(Comparator<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "comparator");
        this.f549438b.clear();
        int r101 = this.f549439c.f531917b;
        int r102 = 0;
    L4:
        if (r102 >= this.f549439c.f531916a) goto L24;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r103 = c(r102);
        if (((b) ListProtector.get(this.f549437a, r102)).f549426f == true) goto L4;
        if (r103 != null) goto L9;
        this.f549438b.add(Integer.valueOf(r102));
    L23:
        r102 = r102 + 1;
        goto L4
    L9:
        float r104 = 0.0f;
        if (this.f549439c.f531922g == false) goto L17;
        float r105 = b(r102);
        float r106 = r103.f141639i;
        com.bytedance.android.livesdk.interactivity.zdanmaku.g r107 = r103.f141638h;
        if (r107 == null) goto L15;
        r104 = r107.a(r103);
    L15:
        if ((r105 - (r106 + r104)) <= 0) goto L23;
        this.f549438b.add(Integer.valueOf(r102));
        goto L23
    L17:
        float r108 = b(r102);
        float r109 = r103.f141639i;
        com.bytedance.android.livesdk.interactivity.zdanmaku.g r110 = r103.f141638h;
        if (r110 == null) goto L21;
        r104 = r110.a(r103);
    L21:
        if ((r108 + (r109 + r104)) >= r101) goto L23;
        this.f549438b.add(Integer.valueOf(r102));
        goto L23
    L24:
        Collections.sort(this.f549438b, r100);
        return this.f549438b;
    }

    public final float b(int r100) {
        if (r100 >= this.f549437a.size()) goto L7;
        if (r100 < 0) goto L7;
        boolean r101 = false;
    L9:
        if (r101 == false) goto L12;
        return 0.0f;
    L12:
        if (this.f549439c.f531922g == false) goto L16;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r102 = c(r100);
        if (r102 != null) goto L21;
        return 0.0f;
    L21:
        return r102.a();
    L16:
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r103 = c(r100);
        if (r103 != null) goto L19;
        return 0.0f;
    L19:
        return r103.c();
    L7:
        r101 = true;
        goto L9
    }

    public final com.bytedance.android.livesdk.interactivity.zdanmaku.i c(int r100) {
        if (r100 >= this.f549437a.size()) goto L7;
        if (r100 < 0) goto L7;
        boolean r101 = false;
    L8:
        if (r101 == false) goto L12;
        return null;
    L12:
        return ((b) ListProtector.get(this.f549437a, r100)).f549423c;
    L7:
        r101 = true;
        goto L8
    }

    public final void e(q72.a r100) {
        Intrinsics.checkNotNullParameter(r100, "newDanmakuConfig");
        int r101 = r100.f531916a;
        this.f549439c = r100;
        this.f549437a.clear();
        int r102 = 0;
    L4:
        if (r102 >= r101) goto L6;
        this.f549437a.add(new h(r102, true, false, null));
        r102 = r102 + 1;
        goto L4
    L6:
        this.f549437a.add(new h(r101 + 1, true, true, null));
        if (v.a() == true) goto L9;
        return;
    L9:
        if (CarnivalAutoTestUtil.f133551a == true) goto L11;
        return;
    L11:
        if (CarnivalAutoTestUtil.a() != null) goto L13;
        return;
    L13:
        if (this.f549439c.f531922g == false) goto L15;
        String r103 = "left";
    L16:
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        return;
    L15:
        r103 = "right";
        goto L16
    }

    public final void d(int r100, com.bytedance.android.livesdk.interactivity.zdanmaku.i r110) {
        Intrinsics.checkNotNullParameter(r110, "danmaku");
        tc2.f r101 = (tc2.f) r110.b().e(tc2.f.class);
        Boolean r102 = null;
        if (r101 == null) goto L5;
        Boolean r103 = r101.f545384c;
    L6:
        Boolean r104 = Boolean.TRUE;
        boolean r105 = Intrinsics.areEqual(r103, r104);
        float r106 = this.f549439c.f531919d;
        RenderEntity r107 = r110.f255835c;
        if (r107 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("renderEntity");
    L9:
        float r108 = (r106 - r107.f254828c.f254853b) / 2;
        int r109 = 0;
        if (r110.getType() != DanmakuType.CarnivalEgg) goto L17;
        tc2.f r111 = (tc2.f) r110.b().e(tc2.f.class);
        if (r111 == null) goto L15;
        r102 = r111.f545384c;
    L15:
        if (Intrinsics.areEqual(r102, r104) == false) goto L17;
        int r112 = 0;
    L24:
        if (r100 != 0) goto L27;
        r112 = Math.abs(r112);
    L27:
        if (r100 != (this.f549439c.f531916a - 1)) goto L29;
        r112 = -Math.abs(r112);
    L29:
        q72.a r113 = this.f549439c;
        float r114 = (r108 + ((r113.f531919d + r113.f531920e) * r100)) + r112;
        if (r113.f531922g == false) goto L37;
        if (r105 == false) goto L36;
        float r115 = -r110.b().f254828c.f254852a;
        float r116 = this.f549439c.f531918c / 2.0f;
        RenderEntity r117 = r110.f255835c;
        if (r117 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("renderEntity");
    L35:
        com.bytedance.live.artist.render.b r118 = r117.f254830e;
        r118.f254847a = r115;
        r118.f254848b = r116;
        com.bytedance.live.artist.render.f r119 = r117.f254828c;
        float r120 = r115 - (r119.f254852a / 2.0f);
        float r121 = r116 - (r119.f254853b / 2.0f);
        com.bytedance.live.artist.render.b r122 = r117.f254829d;
        r122.f254847a = r120;
        r122.f254848b = r121;
    L43:
        r110.f141636f = r100;
        r110.f141635e = (b) ListProtector.get(this.f549437a, r100);
        sk6.b r123 = (sk6.b) r110.b().e(sk6.b.class);
        if (r123 == null) goto L47;
        r109 = r123.f542421a;
    L47:
        if (r109 <= 80) goto L50;
        float r124 = 0.8f;
    L55:
        q72.a r125 = this.f549439c;
        r110.f141634d = (r125.f531917b / r125.f531921f) * r124;
        r110.f141637g = ((b) ListProtector.get(this.f549437a, r100)).a();
        f(r100, r110);
        if (v.a() == true) goto L58;
        return;
    L58:
        if (CarnivalAutoTestUtil.f133551a == false) goto L62;
        CarnivalAutoTestUtil.a();
        return;
    L62:
        return;
    L50:
        if (40 > r109) goto L54;
        if (80 < r109) goto L54;
        r124 = 1.0f;
    L54:
        r124 = 1.2f;
        goto L55
    L36:
        r110.e(-r110.b().f254828c.f254852a, r114);
        goto L43
    L37:
        if (r105 == false) goto L42;
        float r126 = r113.f531917b;
        float r127 = r113.f531918c / 2.0f;
        RenderEntity r128 = r110.f255835c;
        if (r128 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("renderEntity");
    L41:
        com.bytedance.live.artist.render.b r129 = r128.f254830e;
        r129.f254847a = r126;
        r129.f254848b = r127;
        com.bytedance.live.artist.render.f r130 = r128.f254828c;
        float r131 = r126 - (r130.f254852a / 2.0f);
        float r132 = r127 - (r130.f254853b / 2.0f);
        com.bytedance.live.artist.render.b r133 = r128.f254829d;
        r133.f254847a = r131;
        r133.f254848b = r132;
        goto L43
    L42:
        r110.e(r113.f531917b, r114);
    L17:
        tc2.f r134 = (tc2.f) r110.b().e(tc2.f.class);
        if (r134 == null) goto L22;
        Integer r135 = r134.f545383b;
        if (r135 == null) goto L22;
        int r136 = r135.intValue();
    L23:
        r112 = UtilityKotlinExtentionsKt.i(RangesKt.random(new IntRange(-r136, r136), Random.Default));
    L22:
        r136 = 0;
        goto L23
    L5:
        r103 = null;
        goto L6
    }

    public final void f(int r100, com.bytedance.android.livesdk.interactivity.zdanmaku.i r101) {
        Intrinsics.checkNotNullParameter(r101, "danmaku");
        if (r100 >= this.f549437a.size()) goto L7;
        if (r100 < 0) goto L7;
        boolean r102 = false;
    L8:
        if (r102 == false) goto L11;
        return;
    L11:
        if (this.f549439c.f531922g == false) goto L16;
        if (r101.a() >= b(r100)) goto L19;
        ((b) ListProtector.get(this.f549437a, r100)).f549423c = r101;
        return;
    L19:
        return;
    L16:
        if (r101.c() <= b(r100)) goto L21;
        ((b) ListProtector.get(this.f549437a, r100)).f549423c = r101;
        return;
    L21:
        return;
    L7:
        r102 = true;
        goto L8
    }
}
