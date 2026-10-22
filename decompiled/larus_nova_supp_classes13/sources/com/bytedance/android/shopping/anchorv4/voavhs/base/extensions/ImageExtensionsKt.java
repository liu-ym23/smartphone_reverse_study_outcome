package com.bytedance.android.shopping.anchorv4.voavhs.base.extensions;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.ec.core.anchorv3.PdpMessageOpt;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.dto.base.Border;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.base.LocalImage;
import com.bytedance.android.shopping.anchorv4.monitor.ImageMonitorMeta;
import com.bytedance.android.shopping.widget.legacy.SquareImageView;
import com.bytedance.jedi.arch.IdentitySubscriber;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ImageExtensionsKt {

    public static final class a implements Runnable {
        public final /* synthetic */ LottieAnimationView a;

        public a(LottieAnimationView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.playAnimation();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final Integer c(String r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        switch(r3.hashCode()) {
            case -2144318483: goto L105;
            case -2131813601: goto L102;
            case -1751467858: goto L99;
            case -1630338283: goto L96;
            case -1585286106: goto L93;
            case -1580330359: goto L90;
            case -682479060: goto L87;
            case -600531641: goto L84;
            case -554116059: goto L81;
            case -319943923: goto L78;
            case -96784230: goto L75;
            case -13307706: goto L72;
            case 99915258: goto L69;
            case 179310290: goto L66;
            case 184943925: goto L63;
            case 210802440: goto L60;
            case 645312753: goto L57;
            case 671405355: goto L54;
            case 673723253: goto L51;
            case 681413316: goto L48;
            case 689620782: goto L45;
            case 718129537: goto L42;
            case 1014078981: goto L39;
            case 1202642214: goto L36;
            case 1228352566: goto L33;
            case 1294656266: goto L30;
            case 1301081916: goto L27;
            case 1329302390: goto L24;
            case 1464834741: goto L21;
            case 1605374478: goto L18;
            case 1933173199: goto L15;
            case 2137785367: goto L12;
            case 2140455738: goto L9;
            default: goto L173;
        };
    L173:
        return null;
    L9:
        if (r3.equals("resource_top_right_cart_icon") == true) goto L109;
        return null;
    L109:
        return 2131231294;
    L12:
        if (r3.equals("resource_top_right_share_icon") == true) goto L111;
        return null;
    L111:
        return 2131231306;
    L15:
        if (r3.equals("resource_top_right_collect_dark_icon") == true) goto L113;
        return null;
    L113:
        return 2131231297;
    L18:
        if (r3.equals("add_cart_success_toast_swoosh") == true) goto L115;
        return null;
    L115:
        return 2131231255;
    L21:
        if (r3.equals("resource_bottom_add_to_cart_icon") == true) goto L117;
        return null;
    L117:
        return 2131247971;
    L24:
        if (r3.equals("resource_top_right_more_dark_icon") == true) goto L119;
        return null;
    L119:
        return 2131231302;
    L27:
        if (r3.equals("base_info_share") == true) goto L121;
        return null;
    L121:
        return 2131231260;
    L30:
        if (r3.equals("base_info_liked") == true) goto L123;
        return null;
    L123:
        return 2131231259;
    L33:
        if (r3.equals("resource_top_right_im_icon") == true) goto L125;
        return null;
    L125:
        return 2131247467;
    L36:
        if (r3.equals("resource_top_right_report_icon") == true) goto L127;
        return null;
    L127:
        return 2131231304;
    L39:
        if (r3.equals("resource_top_right_im_dark_icon") == true) goto L129;
        return null;
    L129:
        return 2131247466;
    L42:
        if (r3.equals("resource_top_right_cart_dark_icon") == true) goto L131;
        return null;
    L131:
        return 2131231295;
    L45:
        if (r3.equals("add_cart_success_toast_icon") == true) goto L133;
        return null;
    L133:
        return 2131247461;
    L48:
        if (r3.equals("resource_top_right_share_dark_icon") == true) goto L135;
        return null;
    L135:
        return 2131231307;
    L51:
        if (r3.equals("resource_top_right_mall_dark_icon") == true) goto L137;
        return null;
    L137:
        return 2131231300;
    L54:
        if (r3.equals("nav_btn_collect") == true) goto L139;
        return null;
    L139:
        return 2131233529;
    L57:
        if (r3.equals("resource_bottom_im_icon") == true) goto L141;
        return null;
    L141:
        return 2131247463;
    L60:
        if (r3.equals("goods_detail_icon_replay") == true) goto L143;
        return null;
    L143:
        return 2131234420;
    L63:
        if (r3.equals("resource_bottom_cart_icon") == true) goto L145;
        return null;
    L145:
        return 2131247462;
    L66:
        if (r3.equals("resource_bottom_collected_icon") == true) goto L147;
        return null;
    L147:
        return 2131233530;
    L69:
        if (r3.equals("wire_frame_head_icon_block") == true) goto L149;
        return null;
    L149:
        return 2131256619;
    L72:
        if (r3.equals("resource_top_right_mall_icon") == true) goto L151;
        return null;
    L151:
        return 2131231299;
    L75:
        if (r3.equals("base_info_like") == true) goto L153;
        return null;
    L153:
        return 2131231258;
    L78:
        if (r3.equals("resource_bottom_shop_red_icon") == true) goto L155;
        return null;
    L155:
        return 2131247465;
    L81:
        if (r3.equals("resource_top_right_more_icon") == true) goto L157;
        return null;
    L157:
        return 2131231301;
    L84:
        if (r3.equals("base_info_collect") == true) goto L159;
        return null;
    L159:
        return 2131231256;
    L87:
        if (r3.equals("resource_top_right_collect_icon") == true) goto L161;
        return null;
    L161:
        return 2131231296;
    L90:
        if (r3.equals("resource_top_right_search_dark_icon") == true) goto L163;
        return null;
    L163:
        return 2131231305;
    L93:
        if (r3.equals("base_info_collected") == true) goto L165;
        return null;
    L165:
        return 2131231257;
    L96:
        if (r3.equals("resource_top_right_report_dark_icon") == true) goto L167;
        return null;
    L167:
        return 2131231303;
    L99:
        if (r3.equals("resource_top_right_collected_dark_icon") == true) goto L169;
        return null;
    L169:
        return 2131231298;
    L102:
        if (r3.equals("resource_bottom_shop_icon") == true) goto L171;
        return null;
    L171:
        return 2131247464;
    L105:
        if (r3.equals("resource_top_right_collected_icon") == true) goto L107;
        return null;
    L107:
        return 2131231298;
    }

    public static final Drawable b(LocalImage r1, Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (r1 != null) goto L5;
        return null;
    L5:
        Integer r3 = c(r1.getName());
        if (r3 == null) goto L9;
        int r4 = r3.intValue();
        return th.a.f(r2).getDrawable(r4);
    L9:
        return null;
    }

    public static final void e(LottieAnimationView r3, ImageModel r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$bindLottie");
        ExtensionsKt.i(r3, r4);
        StringBuilder r0 = new StringBuilder();
        Object r1 = null;
        if (r4 == null) goto L7;
        LocalImage r2 = r4.getLocal();
        if (r2 == null) goto L7;
        String r5 = r2.getName();
    L8:
        r0.append(r5);
        r0.append(".json");
        r3.setAnimation(r0.toString());
        r3.setRepeatMode(1);
        r3.setRepeatCount(-1);
        r3.post(new a(r3));
        if (r4 == null) goto L26;
        String r6 = r4.getTintColor();
        if (r6 == null) goto L27;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L14
        Object r8 = Result.constructor-impl(Integer.valueOf(Color.parseColor(r6)));     // Catch: Throwable -> L14
    L17:
        if (Result.isFailure-impl(r8) == true) goto L20;
        r1 = r8;
    L20:
        Integer r9 = (Integer) r1;
        if (r9 == null) goto L28;
        r3.setColorFilter(r9.intValue());
        return;
    L28:
        return;
    L14:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    L27:
        return;
    L26:
        return;
    L7:
        r5 = null;
        goto L8
    }

    public static final void d(SimpleDraweeView r3, ImageModel r4, Function1<? super DraweeController, Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "$this$bindImage");
        r3.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
        if (PdpPerfOpt.b().g() == false) goto L5;
        r3.getHierarchy().setFadeDuration(0);
    L5:
        ExtensionsKt.i(r3, r4);
        if (r4 == null) goto L8;
        ECUrlModel r1 = r4.getRemote();
    L9:
        if (r1 != null) goto L11;
        if (r4 == null) goto L16;
        LocalImage r6 = r4.getLocal();
    L17:
        if (r6 == null) goto L25;
        LocalImage r7 = r4.getLocal();
        Intrinsics.checkNotNullParameter(r3, "$this$setLocalImage");
        if (r7 == null) goto L25;
        String r8 = r7.getName();
        if (r8 == null) goto L25;
        Integer r9 = c(r8);
        if (r9 == null) goto L25;
        r3.setActualImageResource(r9.intValue());
    L25:
        if (r4 == null) goto L38;
        String r10 = r4.getTintColor();
        if (r10 == null) goto L38;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L30
        Object r11 = Result.constructor-impl(Integer.valueOf(Color.parseColor(r10)));     // Catch: Throwable -> L30
    L33:
        if (Result.isFailure-impl(r11) == false) goto L35;
        r11 = null;
    L35:
        Integer r12 = (Integer) r11;
        if (r12 == null) goto L38;
        r3.setColorFilter(r12.intValue());
    L30:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
    L38:
        if (r4 == null) goto L40;
        Float.valueOf(r4.getRoundCorner()).floatValue();
    L40:
        g(r3, r4, null);
        return;
    L16:
        r6 = null;
        goto L17
    L11:
        if (PdpPerfOpt.b().g() == false) goto L13;
        com.bytedance.android.ec.core.imagex.ImageExtensionsKt.v(r3, r4.getRemote(), r5, 7166);
        goto L25
    L13:
        ECLiveImageUtils.c(r3, r4.getRemote(), true, r5);
        goto L25
    L8:
        r1 = null;
        goto L9
    }

    public static final View f(final ImageModel r5, Context r6, final String r7) {
        Intrinsics.checkNotNullParameter(r5, "$this$obtainDisplayView");
        Intrinsics.checkNotNullParameter(r6, "context");
        LocalImage r0 = r5.getLocal();
        if (r0 == null) goto L5;
        String r1 = r0.getName();
    L6:
        final boolean r2 = true;
        if (r1 == null) goto L20;
        int r3 = r1.hashCode();
        if (r3 == 942176170) goto L18;
        if (r3 != 1721452496) goto L20;
        if (r1.equals("goods_detail_living_lottie") == false) goto L20;
    L19:
        boolean r4 = true;
    L21:
        if (r4 == false) goto L25;
        LottieAnimationView r8 = new LottieAnimationView(r6);
        e(r8, r5);
        return r8;
    L25:
        if (PdpMessageOpt.b() == true) goto L27;
    L29:
        r2 = false;
    L30:
        SimpleDraweeView r9 = new SimpleDraweeView(r6);
        ImageMonitorMeta r10 = r5.getImageMonitorMeta();
        if (r10 == null) goto L33;
        com.bytedance.android.ec.core.imagex.ImageExtensionsKt.D(r9, q73.b.a(r10));
    L33:
        d(r9, r5, new ImageExtensionsKt$obtainDisplayView$$inlined$apply$lambda$1(r5, r2, r7));
        return r9;
    L27:
        if (r5.getRemote() == null) goto L29;
    L18:
        if (r1.equals("goods_detail_living_lottie_white_BG") == true) goto L19;
    L20:
        r4 = false;
        goto L21
    L5:
        r1 = null;
        goto L6
    }

    public static final void g(SimpleDraweeView r4, ImageModel r5, Border r6) {
        Intrinsics.checkNotNullParameter(r4, "$this$setRounding");
        RoundingParams r0 = new RoundingParams();
        if (r5 == null) goto L5;
        float r1 = r5.getRoundCorner();
    L6:
        r0.setCornersRadius(com.bytedance.android.shopping.extensions.b.b(Float.valueOf(r1)));
        Integer r2 = null;
        if (r5 == null) goto L11;
        Border r3 = r5.getBorder();
        if (r3 == null) goto L11;
        String r7 = r3.getBorderColor();
    L12:
        if (r5 == null) goto L16;
        Border r8 = r5.getBorder();
        if (r8 == null) goto L16;
        Integer r9 = Integer.valueOf(com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r8.getBorderWidth())));
    L18:
        if (r7 == null) goto L21;
        if (r9 == null) goto L21;
        r0.setBorder(com.bytedance.android.shopping.extensions.a.a(r7, 0), r9.intValue());
    L21:
        if (r6 == null) goto L23;
        String r10 = r6.getBorderColor();
    L24:
        if (r6 == null) goto L26;
        r2 = Integer.valueOf(com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r6.getBorderWidth())));
    L26:
        if (r10 == null) goto L29;
        if (r2 == null) goto L29;
        r0.setBorder(com.bytedance.android.shopping.extensions.a.a(r10, 0), r2.intValue());
    L29:
        r4.getHierarchy().setRoundingParams(r0);
        return;
    L23:
        r10 = null;
    L16:
        r9 = null;
    L11:
        r7 = null;
        goto L12
    L5:
        r1 = 0.0f;
        goto L6
    }

    public static final void a(SquareImageView r1, String r2, Integer r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r1, "$this$addCache");
        if (r2 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == true) goto L27;
        if (r3 != null) goto L12;
        return;
    L12:
        if (r3.intValue() == 0) goto L29;
        if (r4 != null) goto L15;
        return;
    L15:
        if (r4.intValue() == 0) goto L32;
        ya3.a r6 = ya3.a.b;
        Context r7 = r1.getContext();
        LifecycleOwner r8 = null;
        if ((r7 instanceof IdentitySubscriber) == true) goto L20;
        r7 = null;
    L20:
        IdentitySubscriber r9 = (IdentitySubscriber) r7;
        if (r9 == null) goto L23;
        r8 = r9.getLifecycleOwner();
    L23:
        if (r8 == null) goto L25;
        ya3.a.C0244a r10 = (ya3.a.C0244a) ((LinkedHashMap) r6.a).get(r8);
        return;
    L25:
        r6.getClass();
        return;
    L32:
        return;
    L29:
        return;
    L27:
        return;
    L5:
        if (r2.length() == 0) goto L8;
        r5 = false;
        goto L9
    }
}
