package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.widget.ECLottieAnimationView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.store.home.entity.StoreUITheme;
import com.bytedance.android.shopping.store.live.event.ShopLiveState;
import com.bytedance.android.shopping.store.repository.vo.ShopHeaderVideoVO;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.android.shopping.store.viewmodel.ShopStatus;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class v3 extends ECShopBasePresenter {
    public boolean A;
    public boolean B;
    public Boolean C;
    public Boolean D;
    public int E;
    public SimpleDraweeView u;
    public ImageView v;
    public ImageView w;
    public TextView x;
    public ECLottieAnimationView y;
    public Boolean z;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ v3 a;

        public a(v3 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            v3 r6 = this.a;
            r6.B = true;
            if (r6.F() == true) goto L5;
            return;
        L5:
            if (r6.Z() < 1.0f) goto L10;
            r6.T().getChangeStateEvent().setValue(new ui3.c(4, ShopStatus.PREVIEW_EXPANDED, 2));
            return;
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ v3 a;

        public b(v3 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Integer r2 = (Integer) r1;
            v3.q0(this.a);
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ v3 a;

        public c(v3 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r18) {
            Float r0 = (Float) r18;
            v3 r1 = this.a;
            float r2 = r1.Z();
            if (r1.p0() == false) goto L9;
            SimpleDraweeView r3 = r1.u;
            if (r3 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("promotionBackground");
        L7:
            r3.setVisibility(4);
        L9:
            if (r1.F() == true) goto L12;
            return;
        L12:
            if (r2 != 0.0f) goto L14;
            boolean r4 = true;
        L15:
            Boolean r7 = r1.D;
            if (r7 == null) goto L29;
            if (r4 == false) goto L29;
            r1.D = Boolean.valueOf(r4);
            if (Intrinsics.areEqual(r1.C, Boolean.TRUE) == false) goto L32;
            if (r1.A == false) goto L28;
            ECStoreViewModel r5 = r1.T();
            Pair<String, String>[] r8 = new Pair[6];
            r8[0] = TuplesKt.to("author_id", r1.T().getStoreParam().getStoreAccountParam().getUserId());
            r8[1] = TuplesKt.to("shop_id", r1.T().getStoreParam().getShopId());
            r8[2] = TuplesKt.to("follow_status", String.valueOf(r1.T().getStoreParam().getFollowStatus()));
            r8[3] = TuplesKt.to("enter_from", "store_page");
            r8[4] = TuplesKt.to("enter_from_merge", "store_page");
            if (r1.B == false) goto L26;
            String r6 = "button";
        L27:
            r8[5] = TuplesKt.to("click_area", r6);
            r5.doEventAction("livesdk_live_tips_click", r8);
            r1.B = false;
            goto L28
        L26:
            r6 = "other";
        L28:
            r1.C = Boolean.FALSE;
        L32:
            if (r2 != 1.0f) goto L34;
            boolean r9 = true;
        L35:
            Boolean r10 = r1.C;
            if (r10 == null) goto L41;
            if (r9 == false) goto L41;
            r1.C = Boolean.valueOf(r9);
            if (Intrinsics.areEqual(r1.D, Boolean.TRUE) == false) goto L43;
            r1.T().doEventAction("livesdk_live_tips_show", new Pair[]{TuplesKt.to("author_id", r1.T().getStoreParam().getStoreAccountParam().getUserId()), TuplesKt.to("shop_id", r1.T().getStoreParam().getShopId()), TuplesKt.to("follow_status", String.valueOf(r1.T().getStoreParam().getFollowStatus())), TuplesKt.to("enter_from", "store_page"), TuplesKt.to("enter_from_merge", "store_page")});
            r1.A = true;
            r1.D = Boolean.FALSE;
        L43:
            r1.y().setBackgroundColor(0);
            r1.y().setAlpha(r2);
            return;
        L41:
            if (r10 != null) goto L43;
            r1.C = Boolean.valueOf(r9);
            goto L43
        L34:
            r9 = false;
        L29:
            if (r7 != null) goto L32;
            r1.D = Boolean.valueOf(r4);
            goto L32
        L14:
            r4 = false;
            goto L15
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ v3 a;

        public d(v3 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (((ShopLiveState) r2).a != ShopLiveState.PlayState.ERROR) goto L6;
            this.a.y().setVisibility(8);
            return;
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ v3 a;

        public e(v3 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            com.bytedance.android.shopping.store.home.entity.n r2 = (com.bytedance.android.shopping.store.home.entity.n) r1;
            v3.r0(this.a);
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ v3 a;

        public f(v3 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            ShopHeaderVideoVO r2 = (ShopHeaderVideoVO) r1;
            this.a.s0();
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ v3 a;

        public g(v3 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Pair r2 = (Pair) r1;
            if (this.a.F() == false) goto L7;
            v3.q0(this.a);
            v3.r0(this.a);
            return;
        }
    }

    public final void s0() {
        TextView r0 = this.x;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
    L6:
        if (I() == false) goto L8;
        String r1 = ag4.a.d(2131896860);
    L9:
        r0.setText(r1);
        return;
    L8:
        r1 = ag4.a.d(2131896856);
        goto L9
    }

    public v3(Fragment r1) {
        super(r1);
    }

    public static final void q0(v3 r3) {
        int r0 = r3.n0();
        if (r0 == r3.E) goto L19;
        r3.E = r0;
        SimpleDraweeView r1 = r3.u;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("promotionBackground");
    L8:
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if (r2 == null) goto L11;
        r2.height = r3.E;
    L11:
        ViewGroup.LayoutParams r4 = r1.getLayoutParams();
        if ((r4 instanceof ViewGroup.MarginLayoutParams) == true) goto L14;
        r4 = null;
    L14:
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
        if (r5 == null) goto L17;
        r5.topMargin = -r3.f0();
    L17:
        r1.requestLayout();
        return;
    }

    public static final void r0(final v3 r7) {
        if (r7.T().getStoreParam().getStoreUITheme() == null) goto L16;
        Integer r0 = r7.T().getStoreParam().getStoreUITheme();
        int r3 = StoreUITheme.OLD.ordinal();
        if (r0 != null) goto L8;
    L9:
        Integer r1 = r7.T().getStoreParam().getStoreUITheme();
        int r4 = StoreUITheme.DefaultDark.ordinal();
        if (r1 != null) goto L13;
    L15:
        boolean r2 = false;
    L18:
        if ((true ^ Intrinsics.areEqual(r7.z, Boolean.valueOf(r2))) == false) goto L76;
        ImageView r5 = r7.v;
        if (r5 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("line");
    L22:
        if (r2 == false) goto L25;
        int r6 = 2131234760;
    L28:
        r5.setImageResource(r6);
        ImageView r8 = r7.w;
        if (r8 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("status");
    L31:
        r8.setVisibility(8);
        r7.s0();
        TextView r9 = r7.x;
        if (r9 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
    L34:
        if (r2 == false) goto L37;
        long r10 = 3439329279L;
    L40:
        r9.setTextColor((int) r10);
        ECLottieAnimationView r11 = r7.y;
        if (r11 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("arrow");
    L43:
        ECLottieAnimationView r12 = r7.y;
        if (r12 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("arrow");
    L46:
        wg.a.i(r12, com.bytedance.android.shopping.store.utils.o.a(16));
        ECLottieAnimationView r13 = r7.y;
        if (r13 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("arrow");
    L49:
        wg.a.d(r13, com.bytedance.android.shopping.store.utils.o.a(16));
        if (r2 == false) goto L53;
        String r14 = "ec_store_lottie_slide_down_arrow_light.json";
    L56:
        r11.setAnimation(r14);
        r11.setRepeatCount(-1);
        r11.playAnimation();
        com.bytedance.android.ec.core.arch.event.c.a(r7.T(), Reflection.getOrCreateKotlinClass(kj3.d.class), Dispatchers.getMain(), new ECShopTopTipsPresenter$updateStyle$2(r7));
        r7.y().setBackgroundColor(0);
        if (r2 == false) goto L70;
        ECUrlModel r15 = r7.c0();
        if (r15 != null) goto L61;
    L74:
        r7.z = Boolean.valueOf(r2);
        return;
    L61:
        if (r7.Z() >= 1.0f) goto L66;
        SimpleDraweeView r16 = r7.u;
        if (r16 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("promotionBackground");
    L65:
        r16.setVisibility(0);
    L66:
        SimpleDraweeView r17 = r7.u;
        if (r17 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("promotionBackground");
    L69:
        ECShopBasePresenter.Y(r7, r17, r15);
        goto L74
    L70:
        SimpleDraweeView r18 = r7.u;
        if (r18 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("promotionBackground");
    L73:
        r18.setVisibility(4);
        goto L74
    L53:
        if (Intrinsics.areEqual(r7.T().isFlagShip(), Boolean.TRUE) == false) goto L55;
        r14 = "ec_store_lottie_slide_down_arrow_yellow.json";
        goto L56
    L55:
        r14 = "ec_store_lottie_slide_down_arrow_pink.json";
        goto L56
    L37:
        if (Intrinsics.areEqual(r7.T().isFlagShip(), Boolean.TRUE) == false) goto L39;
        r10 = 4290807365L;
        goto L40
    L39:
        r10 = 3439209557L;
        goto L40
    L25:
        if (Intrinsics.areEqual(r7.T().isFlagShip(), Boolean.TRUE) == false) goto L27;
        r6 = 2131234759;
        goto L28
    L27:
        r6 = 2131234762;
        goto L28
    L76:
        return;
    L13:
        if (r1.intValue() != r4) goto L15;
        r2 = true;
        goto L18
    L8:
        if (r0.intValue() != r3) goto L9;
    L16:
        r2 = r7.p0();
        goto L18
    }

    public final void A(QModel r4) {
        this.u = w().b(2131371182).f();
        this.v = (ImageView) w().b(2131371181).f();
        this.w = (ImageView) w().b(2131371184).f();
        TextView r5 = (TextView) w().b(2131371185).f();
        this.x = r5;
        r5.setTextSize(2, 12.0f);
        this.y = w().b(2131371180).f();
        View r6 = y();
        ViewGroup.LayoutParams r0 = r6.getLayoutParams();
        if (r0 == null) goto L5;
        r0.height = d0();
    L5:
        r6.requestLayout();
        y().setOnClickListener(new a(this));
        T().getTopBarHeight().a(W(), new b(this), false);
        T().getCollapseFactor().a(W(), new c(this), false);
        T().getLiveState().a(W(), new d(this), false);
        T().getHeaderArea().a(W(), new e(this), false);
        T().getVideoInfo().a(W(), new f(this), false);
        T().getSelectedTabLocation().d(W(), new g(this));
    }
}
