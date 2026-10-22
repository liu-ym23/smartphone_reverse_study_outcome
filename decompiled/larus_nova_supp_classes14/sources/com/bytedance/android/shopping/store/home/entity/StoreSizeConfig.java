package com.bytedance.android.shopping.store.home.entity;

import android.app.Application;
import com.bytedance.android.ec.core.utils.y0;
import com.bytedance.android.ec.store.common.headlive.StoreV3LiveRoomVO;
import com.bytedance.android.shopping.store.repository.vo.ShopHeaderVideoInfoVO;
import com.bytedance.android.shopping.store.repository.vo.ShopHeaderVideoVO;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class StoreSizeConfig {
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public final Lazy D;
    public final ECStoreViewModel E;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public final Lazy y;
    public final Lazy z;

    public final int a() {
        return ((Number) this.n.getValue()).intValue();
    }

    public final int b() {
        return ((Number) this.o.getValue()).intValue();
    }

    public final int c() {
        return ((Number) this.g.getValue()).intValue();
    }

    public final int d() {
        return ((Number) this.e.getValue()).intValue();
    }

    public final int e() {
        return ((Number) this.h.getValue()).intValue();
    }

    public final Application getContext() {
        return (Application) this.a.getValue();
    }

    public final boolean f() {
        return this.E.isCroppedStyle();
    }

    public StoreSizeConfig(ECStoreViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        this.E = r2;
        this.a = LazyKt.lazy(StoreSizeConfig$context$2.INSTANCE);
        this.b = LazyKt.lazy(StoreSizeConfig$paddingInfoAreaVerticalOnCropped$2.INSTANCE);
        this.c = LazyKt.lazy(StoreSizeConfig$paddingInfoAreaVertical$2.INSTANCE);
        this.d = LazyKt.lazy(StoreSizeConfig$marginInfoAreaMask$2.INSTANCE);
        this.e = LazyKt.lazy(StoreSizeConfig$infoGroupOutsideTopMargin$2.INSTANCE);
        this.f = LazyKt.lazy(StoreSizeConfig$infoGroupInsideBottomMargin$2.INSTANCE);
        this.g = LazyKt.lazy(StoreSizeConfig$infoGroupOutsideBottomMargin$2.INSTANCE);
        this.h = LazyKt.lazy(new StoreSizeConfig$topBarHeightWithoutTips$2(this));
        this.i = LazyKt.lazy(StoreSizeConfig$liveTipsHeight$2.INSTANCE);
        this.j = LazyKt.lazy(new StoreSizeConfig$liveHeight$2(this));
        this.k = LazyKt.lazy(StoreSizeConfig$videoContainerHeight$2.INSTANCE);
        this.l = LazyKt.lazy(StoreSizeConfig$videoHeight$2.INSTANCE);
        this.m = LazyKt.lazy(StoreSizeConfig$floatLiveBottomMargin$2.INSTANCE);
        this.n = LazyKt.lazy(new StoreSizeConfig$croppedHeight$2(this));
        this.o = LazyKt.lazy(StoreSizeConfig$infoAreaHeight$2.INSTANCE);
        this.p = LazyKt.lazy(StoreSizeConfig$valueInfoHeight$2.INSTANCE);
        this.q = LazyKt.lazy(StoreSizeConfig$subTabBarHeight$2.INSTANCE);
        this.r = LazyKt.lazy(new StoreSizeConfig$rootTabBarHeight$2(this));
        this.s = LazyKt.lazy(new StoreSizeConfig$topBarHeight$2(this));
        this.y = LazyKt.lazy(new StoreSizeConfig$infoGroupMaskTransitionDiffHCropped$2(this));
        this.z = LazyKt.lazy(new StoreSizeConfig$statusBarHeight$2(this));
        this.A = LazyKt.lazy(new StoreSizeConfig$screenSize$2(this));
        this.B = LazyKt.lazy(new StoreSizeConfig$navigationOrGestureBarHeight$2(this));
        this.C = LazyKt.lazy(new StoreSizeConfig$screenHeight$2(this));
        this.D = LazyKt.lazy(new StoreSizeConfig$screenHWRatio$2(this));
    }

    public final void g(n r8) {
        Intrinsics.checkNotNullParameter(r8, "headerArea");
        e r1 = r8.b;
        List<ShopHeaderVideoInfoVO> r2 = null;
        if (r1 == null) goto L5;
        Integer r3 = r1.k;
    L6:
        boolean r4 = true;
        if (r3 != null) goto L10;
    L12:
        int r5 = 24;
    L13:
        this.t = com.bytedance.android.shopping.extensions.b.b(r5);
        int r6 = com.bytedance.android.shopping.extensions.b.b(8);
        e r7 = r8.b;
        if (r7 == null) goto L16;
        Integer r9 = r7.k;
    L17:
        if (r9 != null) goto L20;
    L22:
        int r10 = 0;
    L23:
        this.u = r6 + r10;
        d r11 = r8.c;
        if (r11 == null) goto L26;
        boolean r12 = r11.d;
    L27:
        boolean r13 = !r12;
        e r14 = r8.b;
        if (r14 == null) goto L30;
        boolean r15 = r14.e;
    L31:
        if (r13 == false) goto L34;
        if (r15 == false) goto L34;
        boolean r16 = true;
    L35:
        if (r16 == true) goto L37;
        int r17 = com.bytedance.android.shopping.extensions.b.b(8);
    L38:
        this.v = r17;
        d r18 = r8.c;
        if (r18 == null) goto L41;
        boolean r19 = r18.d;
    L42:
        boolean r20 = !r19;
        e r21 = r8.b;
        if (r21 == null) goto L45;
        boolean r22 = r21.e;
    L46:
        if (r20 == false) goto L49;
        if (r22 == false) goto L49;
        boolean r23 = true;
    L50:
        if (r23 == false) goto L52;
        int r24 = ((Number) this.p.getValue()).intValue();
    L53:
        this.x = r24;
        if (r8.d == null) goto L56;
        boolean r25 = true;
    L57:
        if (r25 == false) goto L59;
        int r26 = this.t;
    L60:
        this.w = r26;
        if (f() == false) goto L63;
        Math.abs(((Number) this.b.getValue()).intValue() - d());
    L63:
        b();
        d();
        if (r8.d == null) goto L66;
        boolean r27 = true;
    L67:
        if (r27 == false) goto L70;
        ((Number) this.f.getValue()).intValue();
    L70:
        c();
        Intrinsics.checkNotNullParameter(r8, "headerArea");
        Intrinsics.checkNotNullParameter(r8, "headerArea");
        i r28 = r8.g;
        if (r28 == null) goto L73;
        StoreV3LiveRoomVO r29 = r28.a;
    L74:
        if (r29 != null) goto L76;
    L78:
        boolean r30 = false;
    L79:
        if (r30 == true) goto L91;
        Intrinsics.checkNotNullParameter(r8, "headerArea");
        i r31 = r8.g;
        if (r31 == null) goto L85;
        ShopHeaderVideoVO r32 = r31.b;
        if (r32 == null) goto L85;
        List<ShopHeaderVideoInfoVO> r33 = r32.getFeedData();
    L86:
        if (r33 == null) goto L88;
        boolean r34 = true;
    L89:
        if (r34 == true) goto L91;
    L93:
        boolean r35 = false;
    L94:
        if (r35 == true) goto L96;
    L98:
        boolean r36 = false;
    L99:
        if (r36 == false) goto L101;
        ((Number) this.i.getValue()).intValue();
    L101:
        b();
        e();
        if (r8.d == null) goto L104;
        boolean r37 = true;
    L105:
        if (r37 == false) goto L108;
        d();
        c();
    L108:
        b();
        if (f() == false) goto L111;
        a();
        e();
    L144:
        if (f() == false) goto L146;
        a();
    L178:
        e();
        return;
    L146:
        Intrinsics.checkNotNullParameter(r8, "headerArea");
        i r38 = r8.g;
        if (r38 == null) goto L149;
        StoreV3LiveRoomVO r39 = r38.a;
    L150:
        if (r39 != null) goto L152;
    L154:
        boolean r40 = false;
    L155:
        if (r40 == true) goto L157;
    L159:
        boolean r41 = false;
    L160:
        if (r41 == false) goto L162;
        ((Number) this.j.getValue()).intValue();
        goto L178
    L162:
        Intrinsics.checkNotNullParameter(r8, "headerArea");
        Intrinsics.checkNotNullParameter(r8, "headerArea");
        i r42 = r8.g;
        if (r42 == null) goto L167;
        ShopHeaderVideoVO r43 = r42.b;
        if (r43 == null) goto L167;
        r2 = r43.getFeedData();
    L167:
        if (r2 == null) goto L169;
        boolean r44 = true;
    L170:
        if (r44 == true) goto L172;
    L174:
        r4 = false;
    L175:
        if (r4 == false) goto L177;
        ((Number) this.k.getValue()).intValue();
        goto L178
    L177:
        e();
        goto L178
    L172:
        if (f() == true) goto L174;
    L169:
        r44 = false;
        goto L170
    L157:
        if (f() == true) goto L159;
        r41 = true;
        goto L160
    L152:
        if (y0.a() == false) goto L154;
        r40 = true;
        goto L155
    L149:
        r39 = null;
        goto L150
    L111:
        Intrinsics.checkNotNullParameter(r8, "headerArea");
        i r45 = r8.g;
        if (r45 == null) goto L114;
        StoreV3LiveRoomVO r46 = r45.a;
    L115:
        if (r46 != null) goto L117;
    L119:
        boolean r47 = false;
    L120:
        if (r47 == true) goto L122;
    L124:
        boolean r48 = false;
    L125:
        if (r48 == false) goto L127;
        ((Number) this.j.getValue()).intValue();
        ((Number) this.s.getValue()).intValue();
        goto L144
    L127:
        Intrinsics.checkNotNullParameter(r8, "headerArea");
        Intrinsics.checkNotNullParameter(r8, "headerArea");
        i r49 = r8.g;
        if (r49 == null) goto L132;
        ShopHeaderVideoVO r50 = r49.b;
        if (r50 == null) goto L132;
        List<ShopHeaderVideoInfoVO> r51 = r50.getFeedData();
    L133:
        if (r51 == null) goto L135;
        boolean r52 = true;
    L136:
        if (r52 == true) goto L138;
    L140:
        boolean r53 = false;
    L141:
        if (r53 == false) goto L144;
        ((Number) this.k.getValue()).intValue();
        ((Number) this.s.getValue()).intValue();
        goto L144
    L138:
        if (f() == true) goto L140;
        r53 = true;
        goto L141
    L135:
        r52 = false;
    L132:
        r51 = null;
        goto L133
    L122:
        if (f() == true) goto L124;
        r48 = true;
        goto L125
    L117:
        if (y0.a() == false) goto L119;
        r47 = true;
        goto L120
    L114:
        r46 = null;
        goto L115
    L104:
        r37 = false;
        goto L105
    L96:
        if (f() == true) goto L98;
        r36 = true;
        goto L99
    L88:
        r34 = false;
    L85:
        r33 = null;
    L91:
        if (f() == true) goto L93;
        r35 = true;
        goto L94
    L76:
        if (y0.a() == false) goto L78;
        r30 = true;
        goto L79
    L73:
        r29 = null;
        goto L74
    L66:
        r27 = false;
        goto L67
    L59:
        r26 = 0;
        goto L60
    L56:
        r25 = false;
        goto L57
    L52:
        r24 = 0;
    L49:
        r23 = false;
        goto L50
    L45:
        r22 = true;
        goto L46
    L41:
        r19 = false;
        goto L42
    L37:
        r17 = 0;
    L34:
        r16 = false;
        goto L35
    L30:
        r15 = true;
        goto L31
    L26:
        r12 = false;
        goto L27
    L20:
        if (r9.intValue() != 1) goto L22;
        r10 = com.bytedance.android.shopping.extensions.b.b(24);
        goto L23
    L16:
        r9 = null;
        goto L17
    L10:
        if (r3.intValue() != 1) goto L12;
        r5 = 31;
        goto L13
    L5:
        r3 = null;
        goto L6
    }
}
