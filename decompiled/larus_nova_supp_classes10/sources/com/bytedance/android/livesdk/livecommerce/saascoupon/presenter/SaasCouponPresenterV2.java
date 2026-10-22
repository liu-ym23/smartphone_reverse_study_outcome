package com.bytedance.android.livesdk.livecommerce.saascoupon.presenter;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import bl2.h;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.SaasCouponViewModel;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.GenericDraweeView;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class SaasCouponPresenterV2 extends QFragmentPresenter {
    public SaasCouponViewModel f;
    public final Lazy g;

    public SaasCouponPresenterV2(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.g = LazyKt.lazy(new SaasCouponPresenterV2$uiConfig$2(this));
    }

    public final void b0(QModel r13) {
        SaasCouponViewModel r14 = Y().g(SaasCouponViewModel.class);
        this.f = r14;
        if (r14 == null) goto L5;
        com.bytedance.android.ec.core.arch.event.c.d(r14, com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a.f.a);
    L5:
        h r15 = (h) this.g.getValue();
        boolean r0 = true;
        String r2 = null;
        if (r15 == null) goto L18;
        String r16 = r15.a();
        if (r16 == null) goto L18;
        if (r16.length() <= 0) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == true) goto L16;
        r16 = null;
    L16:
        if (r16 == null) goto L18;
        GenericDraweeView r5 = Z().b(2131385041).f();
        ECUrlModel r6 = new ECUrlModel();
        r6.setUrlList(CollectionsKt.listOf(r16));
        Unit r17 = Unit.INSTANCE;
        h0.d(r5, r6, null, null, null, null, null, 120);
    L19:
        h r18 = (h) this.g.getValue();
        if (r18 == null) goto L48;
        String r19 = r18.b();
        if (r19 == null) goto L48;
        if (r19.length() > 0) goto L27;
        r0 = false;
    L27:
        if (r0 == true) goto L30;
        r19 = null;
    L30:
        if (r19 == null) goto L48;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L33
        Object r110 = Result.constructor-impl(Integer.valueOf(Color.parseColor(r19)));     // Catch: Throwable -> L33
    L36:
        if (Result.isFailure-impl(r110) == false) goto L38;
        r110 = null;
    L38:
        Integer r111 = (Integer) r110;
        if (r111 == null) goto L56;
        int r112 = r111.intValue();
        Drawable r3 = Z().b(2131385042).f().getBackground();
        if ((r3 instanceof BackgroundDrawable) == true) goto L43;
        r3 = null;
    L43:
        BackgroundDrawable r7 = (BackgroundDrawable) r3;
        if (r7 == null) goto L46;
        r7.setBgColor(r112);
    L46:
        if (r7 == null) goto L56;
        r7.invalidate();
    L56:
        Drawable r113 = Z().b(2131385053).f().getBackground();
        if ((r113 instanceof BackgroundDrawable) == true) goto L59;
        r113 = null;
    L59:
        BackgroundDrawable r114 = (BackgroundDrawable) r113;
        if (r114 == null) goto L62;
        r114.setBgColor(ColorProtector.parseColor("#FFFFFF"));
    L62:
        if (r114 == null) goto L64;
        r114.invalidate();
    L64:
        ImageView r115 = (ImageView) Z().b(2131385051).f();
        SaasCouponViewModel r116 = this.f;
        if (r116 == null) goto L68;
        r2 = r116.getStartAuthType();
    L68:
        if (Intrinsics.areEqual(r2, "login_auth") == false) goto L70;
        Z().b(2131385051).c();
    L71:
        SaasCouponViewModel r117 = this.f;
        if (r117 == null) goto L74;
        com.bytedance.android.ec.core.arch.state.c.a(r117, Y().e(), SaasCouponPresenterV2$setAllContent$3.INSTANCE, new SaasCouponPresenterV2$setAllContent$4(this));
    L74:
        SaasCouponViewModel r118 = this.f;
        if (r118 == null) goto L77;
        com.bytedance.android.ec.core.arch.state.c.a(r118, Y().e(), SaasCouponPresenterV2$setAllContent$5.INSTANCE, new SaasCouponPresenterV2$setAllContent$6(this));
    L77:
        ((ImageView) Z().b(2131385044).f()).setOnClickListener(new e(this));
        Z().b(2131385042).f().setOnClickListener(new f(this));
        return;
    L70:
        Z().b(2131385051).g(0);
    L33:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r110 = Result.constructor-impl(ResultKt.createFailure(th));
    L48:
        Drawable r119 = Z().b(2131385042).f().getBackground();
        if ((r119 instanceof BackgroundDrawable) == true) goto L51;
        r119 = null;
    L51:
        BackgroundDrawable r120 = (BackgroundDrawable) r119;
        if (r120 == null) goto L54;
        r120.setBgColor(ag4.a.b(2131105699));
    L54:
        if (r120 == null) goto L56;
        r120.invalidate();
        goto L56
    L12:
        r4 = false;
    L18:
        Z().b(2131385041).f().setPlaceholderImage(2131247494, ScalingUtils.ScaleType.FIT_XY);
        goto L19
    }
}
