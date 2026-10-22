package com.bytedance.android.shopping.slice.elements.lottieview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.widget.ECLottieAnimationView;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.shopping.anchorv4.voavhs.e;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.drawable.ScalingUtils;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends com.bytedance.android.ecom.arch.slice.render.elements.b<d> {
    public d H3;
    public final SlcTemplateContext I3;

    public b(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "slcContext");
        super(r2);
        this.I3 = r2;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [android.widget.FrameLayout, com.bytedance.android.shopping.slice.elements.lottieview.d] */
    public final void H0(Map<String, ? extends Object> r23) {
        Intrinsics.checkNotNullParameter(r23, "props");
        Object r1 = r23.get("lottie_config");
        Object r3 = null;
        if ((r1 instanceof Map) == true) goto L5;
        r1 = null;
    L5:
        Map r2 = (Map) r1;
        if (r2 == null) goto L56;
        Object r4 = r2.get("source");
        if ((r4 instanceof String) == true) goto L10;
        r4 = null;
    L10:
        String r5 = (String) r4;
        if (r5 == null) goto L56;
        Object r6 = r2.get("loop_enable");
        if ((r6 instanceof Boolean) == true) goto L15;
        r6 = null;
    L15:
        Boolean r7 = (Boolean) r6;
        if (r7 == null) goto L18;
        boolean r8 = r7.booleanValue();
    L19:
        Object r9 = r2.get("type");
        if ((r9 instanceof Integer) == true) goto L22;
        r9 = null;
    L22:
        Integer r10 = (Integer) r9;
        if (r10 == null) goto L25;
        int r11 = r10.intValue();
    L26:
        Object r12 = r23.get("animating");
        if ((r12 instanceof Boolean) == true) goto L29;
        r12 = null;
    L29:
        Boolean r13 = (Boolean) r12;
        if (r13 == null) goto L32;
        boolean r14 = r13.booleanValue();
    L33:
        Object r0 = r23.get("static_img_url");
        if ((r0 instanceof String) == false) goto L37;
        r3 = r0;
    L37:
        final String r15 = (String) r3;
        final ?? r16 = this.H3;
        if (r16 == 0) goto L57;
        a r17 = new a(r8, r11, r5);
        Intrinsics.checkNotNullParameter(r17, "config");
        if (r16.getChildCount() != 0) goto L48;
        ECLottieAnimationView r18 = new ECLottieAnimationView(r16.getContext());
        r16.c = r18;
        r18.setAnimation(r17.c);
        r18.setImageAssetsFolder("images");
        if (r17.a == false) goto L44;
        int r19 = -1;
    L45:
        r18.setRepeatCount(r19);
        r18.addAnimatorListener(new c(r16));
        r18.setVisibility(4);
        Unit r20 = Unit.INSTANCE;
        r16.addView(r18, -1, -1);
        if (r15 == null) goto L48;
        ECDraweeView r21 = new ECDraweeView(r16.getContext(), null, 0, 6, null);
        r16.d = r21;
        r21.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
        ImageExtensionsKt.w(r21, r15, null, null, null, null, null, null, null, false, null, new SlcPdpLottieView$createStaticView$$inlined$apply$lambda$1(r16, r15), 3070);
        r16.addView(r21, -1, -1);
        goto L48
    L44:
        r19 = 0;
    L48:
        if (r14 == false) goto L58;
        ECLottieAnimationView r22 = r16.c;
        if (r22 == null) goto L52;
        r22.setVisibility(0);
    L52:
        ECLottieAnimationView r24 = r16.c;
        if (r24 == null) goto L59;
        r24.playAnimation();
        return;
    L59:
        return;
    L58:
        return;
    L57:
        return;
    L32:
        r14 = false;
        goto L33
    L25:
        r11 = 0;
        goto L26
    L18:
        r8 = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m1(View r2) {
        d r3 = (d) r2;
        Intrinsics.checkNotNullParameter(r3, "contentView");
        this.H3 = r3;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View, android.widget.FrameLayout, com.bytedance.android.shopping.slice.elements.lottieview.d] */
    public final View n1(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        ?? r0 = new d(r3);
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        Object r4 = this.I3.w.g("pdp_service_for_slice");
        if ((r4 instanceof e) == true) goto L5;
        r4 = null;
    L5:
        r0.setPdpService((e) r4);
        return r0;
    }
}
