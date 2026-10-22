package com.bytedance.android.shopping.store.home.presenter.preview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.widget.ECLottieAnimationView;
import com.bytedance.android.ec.store.common.headlive.StoreV3LiveRoomVO;
import com.bytedance.android.ec.store.view.ECHeaderSlideIndicator;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopPreviewBottomInfoPresenter extends com.bytedance.android.shopping.store.home.frame.presenter.a<StoreV3LiveRoomVO> implements q {
    public ViewGroup j;
    public View k;
    public View l;
    public TextView m;
    public ECHeaderSlideIndicator n;
    public ti.l o;
    public StoreV3LiveRoomVO p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;

    @Override // com.bytedance.android.shopping.store.home.frame.presenter.a
    public final void j0() {
        p r0 = (p) this.s.getValue();
        if (r0 == null) goto L6;
        r0.k();
        return;
    }

    public ECShopPreviewBottomInfoPresenter(final Fragment r2) {
        Intrinsics.checkNotNull(r2);
        super(r2);
        this.q = LazyKt.lazy(new ECShopPreviewBottomInfoPresenter$viewModel$2(this, r2));
        this.r = LazyKt.lazy(ECShopPreviewBottomInfoPresenter$lynxCallback$2.INSTANCE);
        this.s = LazyKt.lazy(new ECShopPreviewBottomInfoPresenter$modelAdapter$2(this));
    }

    @Override // com.bytedance.android.shopping.store.home.frame.presenter.a
    public final void i0(StoreV3LiveRoomVO r19) {
        this.p = r19;
        p r1 = (p) this.s.getValue();
        if (r1 != null) goto L5;
    L74:
        com.bytedance.android.ec.core.arch.event.c.a((ECStoreViewModel) this.q.getValue(), Reflection.getOrCreateKotlinClass(kj3.d.class), Dispatchers.getMain(), new ECShopPreviewBottomInfoPresenter$onElementBind$2(this));
        return;
    L5:
        if (r1.j() != true) goto L74;
        this.k = a0().findViewById(2131370745);
        this.l = a0().findViewById(2131370746);
        this.j = (ViewGroup) a0().findViewById(2131370750);
        this.m = (TextView) a0().findViewById(2131387445);
        this.n = a0().findViewById(2131370749);
        StoreV3LiveRoomVO r2 = this.p;
        if (r2 == null) goto L56;
        im.r r4 = r2.getLiveGift();
        ti.l r5 = null;
        if (r4 == null) goto L11;
        String r6 = r4.b;
    L12:
        if (r6 != null) goto L14;
    L17:
        boolean r7 = true;
    L18:
        if (r7 == false) goto L21;
        ShoppingAsyncInflater.a r3 = ShoppingAsyncInflater.e;
        Context r8 = th.a.e(Y().c(), true);
        r3.getClass();
        ShoppingAsyncInflater.a.a(r8).aU(2131560941, this.j, true);
        goto L56
    L21:
        if (r2.getLiveGift() == null) goto L56;
        if (this.j == null) goto L56;
        ti.l r9 = this.o;
        if (r9 == null) goto L28;
        r9.release();
    L28:
        ti.k r10 = (ti.k) this.r.getValue();
        im.r r11 = r2.getLiveGift();
        LinkedHashMap r12 = new LinkedHashMap();
        if (r11 == null) goto L31;
        String r13 = r11.b;
    L32:
        r12.put("data", r13);
        Pair[] r14 = new Pair[3];
        p r15 = (p) this.s.getValue();
        if (r15 == null) goto L37;
        StoreV3LiveRoomVO r16 = r15.h();
        if (r16 == null) goto L37;
        String r17 = r16.getAnchorId();
    L38:
        String r18 = "";
        if (r17 != null) goto L41;
        r17 = "";
    L41:
        r14[0] = TuplesKt.to("anchor_id", r17);
        r14[1] = TuplesKt.to("store_type", "shop");
        p r20 = (p) this.s.getValue();
        if (r20 == null) goto L46;
        StoreV3LiveRoomVO r21 = r20.h();
        if (r21 == null) goto L46;
        String r22 = r21.getRoomId();
    L47:
        if (r22 == null) goto L50;
        r18 = r22;
    L50:
        r14[2] = TuplesKt.to("room_id", r18);
        r12.put("metaInfo", MapsKt.mutableMapOf(r14));
        im.r r23 = r2.getLiveGift();
        if (r23 == null) goto L55;
        String r24 = r23.a;
        if (r24 == null) goto L55;
        r5 = ECLiveHybridUtil.b(Y().c(), r24, r12, this.j, r10, null, null, false, null, null, false, 4064);
    L55:
        this.o = r5;
    L46:
        r22 = null;
    L37:
        r17 = null;
        goto L38
    L31:
        r13 = null;
        goto L32
    L14:
        if (r6.length() == 0) goto L17;
        r7 = false;
        goto L18
    L11:
        r6 = null;
    L56:
        View r25 = this.k;
        if (r25 == null) goto L59;
        r25.setVisibility(0);
    L59:
        StoreV3LiveRoomVO r26 = this.p;
        if (r26 == null) goto L66;
        String r27 = r26.getTitle();
        if (r27 == null) goto L66;
        TextView r28 = this.m;
        if (r28 == null) goto L66;
        r28.setText(r27);
    L66:
        ECHeaderSlideIndicator r29 = this.n;
        if (r29 == null) goto L69;
        int r30 = (int) 2164260863L;
        r29.a.setBackgroundColor(r30);
        r29.c.setTextColor((int) 3221225471L);
        ECLottieAnimationView r31 = r29.b;
        r31.setAnimation("ec_store_lottie_slide_down_arrow_light.json");
        r31.setRepeatCount(-1);
        r31.playAnimation();
        r29.d.setBackgroundColor(r30);
    L69:
        p r32 = (p) this.s.getValue();
        if (r32 == null) goto L74;
        jm.b<Pair<String, Boolean>> r33 = r32.d();
        if (r33 == null) goto L74;
        r33.a(Y().e(), new k(this), false);
        goto L74
    }

    public final void k0(String r2, boolean r3) {
        if (r2 == null) goto L8;
        ECHeaderSlideIndicator r0 = this.n;
        if (r0 == null) goto L8;
        TextView r1 = r0.getTextView();
        if (r1 == null) goto L8;
        r1.setText(r2);
    L8:
        if (r3 == false) goto L10;
        int r4 = 0;
    L11:
        ECHeaderSlideIndicator r5 = this.n;
        if (r5 != null) goto L14;
    L15:
        ECHeaderSlideIndicator r6 = this.n;
        if (r6 == null) goto L20;
        r6.setVisibility(r4);
        return;
    L20:
        return;
    L14:
        if (r4 != r5.getVisibility()) goto L15;
        return;
    L10:
        r4 = 8;
        goto L11
    }

    @Override // com.bytedance.android.shopping.store.home.presenter.preview.q
    public final void O(float r1, int r2, boolean r3, int r4, boolean r5) {
        View r6 = this.l;
        if (r6 != null) goto L6;
        return;
    L6:
        if (r1 != 0.0f) goto L8;
        int r7 = 0;
    L10:
        if (r7 == r6.getVisibility()) goto L14;
        View r8 = this.l;
        if (r8 == null) goto L14;
        r8.setVisibility(r7);
    L14:
        if (r1 != 0.0f) goto L16;
    L17:
        k0(null, true);
        return;
    L16:
        if (r1 == 1.0f) goto L17;
        return;
    L8:
        r7 = 8;
        goto L10
    }
}
