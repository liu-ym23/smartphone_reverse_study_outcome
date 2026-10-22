package com.bytedance.android.livesdk.livecommerce.largemode;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.c0;
import com.bytedance.android.livesdk.livecommerce.largemode.model.ComponentLargeModeConfig;
import com.bytedance.android.livesdk.livecommerce.largemode.model.LayoutLargeModeConfig;
import com.bytedance.android.livesdk.livecommerce.largemode.model.LayoutSizeLargeModeConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotion.card.j;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.o0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LargeModeConfigHelper {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Integer c(LayoutSizeLargeModeConfig r4) {
        if (r4 == null) goto L5;
        String r1 = r4.getType();
    L6:
        if (r1 == null) goto L25;
        int r2 = r1.hashCode();
        if (r2 == (-1019779949)) goto L15;
        if (r2 != (-921832806)) goto L25;
        r1.equals(LayoutSizeLargeModeConfig.TYPE_PERCENTAGE);
        goto L25
    L15:
        if (r1.equals(LayoutSizeLargeModeConfig.TYPE_SIZE_DP) == false) goto L25;
        Float r5 = Float.valueOf(r4.getValue());
        boolean r3 = false;
        if (r5.floatValue() < 0) goto L19;
        r3 = true;
    L19:
        if (r3 == true) goto L22;
        r5 = null;
    L22:
        if (r5 == null) goto L25;
        return Integer.valueOf(UtilityKotlinExtentionsKt.d(Float.valueOf(r5.floatValue())));
    L25:
        return null;
    L5:
        r1 = null;
        goto L6
    }

    public static void a(ComponentLargeModeConfig r8, View r9) {
        Intrinsics.checkNotNullParameter(r8, "$this$applyConfigToView");
        if (r9 == null) goto L116;
        hi2.a r0 = r8.getTextConfig();
        int r1 = 0;
        ViewGroup.LayoutParams r2 = null;
        if (r0 != null) goto L7;
    L45:
        LayoutLargeModeConfig r10 = r8.getLayoutConfig();
        if (r10 == null) goto L117;
        Integer r3 = c(r10.getWidthConfig());
        Integer r4 = c(r10.getHeightConfig());
        ViewGroup.LayoutParams r5 = r9.getLayoutParams();
        if (r3 == null) goto L50;
        r5.width = r3.intValue();
    L50:
        if (r4 == null) goto L52;
        r5.height = r4.intValue();
    L52:
        r9.setLayoutParams(r5);
        if (r10.getLeftPadding() == null) goto L55;
    L60:
        Integer r6 = r10.getLeftPadding();
        if (r6 == null) goto L63;
        int r7 = UtilityKotlinExtentionsKt.d(r6);
    L64:
        Integer r11 = r10.getTopPadding();
        if (r11 == null) goto L67;
        int r12 = UtilityKotlinExtentionsKt.d(r11);
    L68:
        Integer r13 = r10.getRightPadding();
        if (r13 == null) goto L71;
        int r14 = UtilityKotlinExtentionsKt.d(r13);
    L72:
        Integer r15 = r10.getBottomPadding();
        if (r15 == null) goto L75;
        int r16 = UtilityKotlinExtentionsKt.d(r15);
    L76:
        r9.setPadding(r7, r12, r14, r16);
    L78:
        if (r10.getLeftMargin() == null) goto L80;
    L85:
        Integer r17 = r10.getLeftMargin();
        if (r17 == null) goto L88;
        int r18 = UtilityKotlinExtentionsKt.d(r17);
    L89:
        Integer r19 = r10.getTopMargin();
        if (r19 == null) goto L92;
        int r20 = UtilityKotlinExtentionsKt.d(r19);
    L99:
        Integer r21 = r10.getRightPadding();
        if (r21 == null) goto L102;
        int r22 = UtilityKotlinExtentionsKt.d(r21);
    L103:
        Integer r23 = r10.getBottomMargin();
        if (r23 == null) goto L106;
        int r24 = UtilityKotlinExtentionsKt.d(r23);
    L114:
        wg.a.f(r9, r18, r20, r22, r24);
        return;
    L106:
        Intrinsics.checkNotNullParameter(r9, "$this$layoutMarginBottom");
        ViewGroup.LayoutParams r25 = r9.getLayoutParams();
        if ((r25 instanceof ViewGroup.MarginLayoutParams) == false) goto L110;
        r2 = r25;
    L110:
        ViewGroup.MarginLayoutParams r26 = (ViewGroup.MarginLayoutParams) r2;
        if (r26 == null) goto L113;
        r1 = r26.bottomMargin;
    L113:
        r24 = r1;
        goto L114
    L102:
        r22 = o0.b(r9);
        goto L103
    L92:
        Intrinsics.checkNotNullParameter(r9, "$this$layoutMarginTop");
        ViewGroup.LayoutParams r27 = r9.getLayoutParams();
        if ((r27 instanceof ViewGroup.MarginLayoutParams) == true) goto L95;
        r27 = null;
    L95:
        ViewGroup.MarginLayoutParams r28 = (ViewGroup.MarginLayoutParams) r27;
        if (r28 == null) goto L98;
        r20 = r28.topMargin;
        goto L99
    L98:
        r20 = 0;
        goto L99
    L88:
        r18 = o0.a(r9);
        goto L89
    L80:
        if (r10.getRightMargin() != null) goto L85;
        if (r10.getTopMargin() != null) goto L85;
        if (r10.getBottomMargin() != null) goto L85;
        return;
    L75:
        r16 = r9.getPaddingBottom();
        goto L76
    L71:
        r14 = r9.getPaddingRight();
        goto L72
    L67:
        r12 = r9.getPaddingTop();
        goto L68
    L63:
        r7 = r9.getPaddingLeft();
        goto L64
    L55:
        if (r10.getRightPadding() != null) goto L60;
        if (r10.getTopPadding() != null) goto L60;
        if (r10.getBottomPadding() == null) goto L78;
    L117:
        return;
    L7:
        if ((r9 instanceof TextView) == true) goto L9;
        View r29 = null;
    L10:
        TextView r30 = (TextView) r29;
        if (r30 == null) goto L45;
        Integer r31 = r0.a();
        boolean r32 = true;
        if (r31 == null) goto L23;
        Float r33 = Float.valueOf(r31.intValue());
        if (r33.floatValue() <= 0.0f) goto L17;
        boolean r34 = true;
    L18:
        if (r34 == true) goto L21;
        r33 = null;
    L21:
        if (r33 == null) goto L23;
        r30.setTextSize(1, r33.floatValue());
        goto L23
    L17:
        r34 = false;
    L23:
        Integer r35 = r0.b();
        if (r35 != null) goto L26;
    L34:
        Float r36 = r0.c();
        if (r36 == null) goto L45;
        if (r36.floatValue() > 0) goto L40;
        r32 = false;
    L40:
        if (r32 == true) goto L43;
        r36 = null;
    L43:
        if (r36 == null) goto L45;
        r30.setLineSpacing(UtilityKotlinExtentionsKt.c(Float.valueOf(r36.floatValue())), 1.0f);
        goto L45
    L26:
        if (r35.intValue() <= 0) goto L28;
        boolean r37 = true;
    L29:
        if (r37 == true) goto L32;
        r35 = null;
    L32:
        if (r35 == null) goto L34;
        c0.b(r30, r35.intValue());
        goto L34
    L28:
        r37 = false;
        goto L29
    L9:
        r29 = r9;
        goto L10
    }

    public static void b(ComponentLargeModeConfig r5, j r6, PromotionCardModuleName r7) {
        Intrinsics.checkNotNullParameter(r5, "$this$applyToFactory");
        Intrinsics.checkNotNullParameter(r6, "factory");
        Intrinsics.checkNotNullParameter(r7, "moduleName");
        final LayoutLargeModeConfig r0 = r5.getLayoutConfig();
        if (r0 == null) goto L5;
        r6.a(r7, new LargeModeConfigHelper$applyToFactory$1$1(r0));
    L5:
        final hi2.a r1 = r5.getTextConfig();
        if (r1 == null) goto L8;
        r6.a(r7, new LargeModeConfigHelper$applyToFactory$2$1(r1));
    L8:
        LayoutLargeModeConfig r2 = r5.getLayoutConfig();
        boolean r3 = true;
        Float r4 = null;
        if (r2 == null) goto L21;
        Integer r8 = r2.getRadius();
        if (r8 == null) goto L21;
        if (r8.intValue() < 0) goto L15;
        boolean r9 = true;
    L16:
        if (r9 == true) goto L19;
        r8 = null;
    L19:
        if (r8 == null) goto L21;
        final int r10 = r8.intValue();
        r6.a(r7, new LargeModeConfigHelper$applyToFactory$4$1(r10));
        goto L21
    L15:
        r9 = false;
    L21:
        LayoutLargeModeConfig r11 = r5.getLayoutConfig();
        if (r11 == null) goto L36;
        Float r12 = r11.getDrawableScale();
        if (r12 == null) goto L37;
        float r13 = r12.floatValue();
        if (r13 > 0) goto L28;
    L30:
        r3 = false;
    L31:
        if (r3 == false) goto L33;
        r4 = r12;
    L33:
        if (r4 == null) goto L38;
        final float r14 = r4.floatValue();
        r6.a(r7, new LargeModeConfigHelper$applyToFactory$6$1(r14));
        return;
    L38:
        return;
    L28:
        if (r13 == 1.0f) goto L30;
    L37:
        return;
    }
}
