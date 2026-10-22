package com.bytedance.android.window.shop.home.presenter;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowCroppedStyleBackGroundPresenter extends AbsECWindowPresenter {
    public static final /* synthetic */ int o = 0;
    public final Lazy m;
    public final Lazy n;

    public static final class a {
    }

    static {
    }

    public final FrameLayout b0() {
        return (FrameLayout) this.m.getValue();
    }

    public ECWindowCroppedStyleBackGroundPresenter() {
        this.m = LazyKt.lazy(new ECWindowCroppedStyleBackGroundPresenter$container$2(this));
        this.n = LazyKt.lazy(new ECWindowCroppedStyleBackGroundPresenter$croppedContainer$2(this));
    }

    public final void A(QModel r4) {
        b0().setVisibility(8);
        O().getHeaderResponse().a(U(), new q(this), false);
        O().getHeaderResponse().a(U(), new p(this), false);
    }

    public static final View a0(ECWindowCroppedStyleBackGroundPresenter r6, uq3.a r7) {
        r6.getClass();
        boolean r2 = true;
        if (yq3.a.f() == 1) goto L7;
        r2 = false;
    L7:
        if (r2 == false) goto L9;
        View r8 = LayoutInflater.from(r6.u().c()).inflate(2131561012, null);
    L10:
        View r0 = r8.findViewById(2131371291);
        SimpleDraweeView r3 = r8.findViewById(2131371256);
        if (r2 == false) goto L13;
        dm.a.a("window_first_frame_opt").i("window_big_image_decode");
        ImageRequest r4 = ImageRequestBuilder.newBuilderWithResourceId(2131234882).build();
        r3.setController(Fresco.newDraweeControllerBuilder().setOldController(r3.getController()).setImageRequest(r4).build());
    L13:
        uq3.o r9 = r7.c;
        if (r9 == null) goto L18;
        String r10 = r9.i;
        if (r10 == null) goto L18;
        int[] r11 = j2.a(r10);
        GradientDrawable r5 = new GradientDrawable();
        com.bytedance.android.ec.window.base.utils.c.e(r5, (int[]) r11.clone());
        Unit r12 = Unit.INSTANCE;
        com.bytedance.android.ec.window.base.utils.c.d(r0, r5);
        r0.setVisibility(0);
        r3.setVisibility(0);
    L18:
        return r8;
    L9:
        r8 = LayoutInflater.from(r6.u().c()).inflate(2131561011, null);
        goto L10
    }

    public static final View Z(ECWindowCroppedStyleBackGroundPresenter r11, ECUrlModel r12, int r13) {
        View r0 = LayoutInflater.from(r11.u().c()).inflate(2131561007, null);
        ECDraweeView r2 = (ECDraweeView) r0.findViewById(2131371293);
        View r1 = r0.findViewById(2131371295);
        View r10 = r0.findViewById(2131371298);
        com.bytedance.android.ec.core.imagex.h0.d(r2, r12, r11.O().getImageCallerContext(), null, null, null, null, 120);
        r1.setBackgroundColor(r13);
        r10.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.argb((int) 71.4d, Color.red(r13), Color.green(r13), Color.blue(r13)), r13}));
        return r0;
    }
}
