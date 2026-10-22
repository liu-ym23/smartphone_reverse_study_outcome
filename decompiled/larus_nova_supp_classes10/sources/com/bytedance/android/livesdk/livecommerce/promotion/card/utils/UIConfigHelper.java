package com.bytedance.android.livesdk.livecommerce.promotion.card.utils;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.core.utils.c0;
import com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.view.ECRoundedLinearLayout;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class UIConfigHelper {
    public static final /* synthetic */ int a = 0;

    public static final class a implements View.OnLayoutChangeListener {
        public final /* synthetic */ float a;
        public final /* synthetic */ View b;

        public a(float r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener(this);
            ImageView.ScaleType r10 = ((ImageView) this.b).getScaleType();
            ImageView.ScaleType r11 = ImageView.ScaleType.MATRIX;
            if (r10 == r11) goto L5;
            ((ImageView) this.b).setScaleType(r11);
        L5:
            Matrix r12 = new Matrix();
            float r13 = this.a;
            r12.setScale(r13, r13);
            float r14 = ((ImageView) this.b).getWidth();
            Drawable r15 = ((ImageView) this.b).getDrawable();
            int r16 = 0;
            if (r15 == null) goto L8;
            int r17 = r15.getIntrinsicWidth();
        L9:
            float r18 = r14 - (r17 * this.a);
            float r19 = 2;
            float r20 = r18 / r19;
            float r21 = ((ImageView) this.b).getHeight();
            Drawable r22 = ((ImageView) this.b).getDrawable();
            if (r22 == null) goto L12;
            r16 = r22.getIntrinsicHeight();
        L12:
            r12.postTranslate(r20, (r21 - (r16 * this.a)) / r19);
            ((ImageView) this.b).setImageMatrix(r12);
            return;
        L8:
            r17 = 0;
            goto L9
        }
    }

    static {
    }

    public static int b(int r1) {
        if (r1 != (-1)) goto L6;
        return -1;
    L6:
        if (r1 != (-2)) goto L8;
        return -2;
    L8:
        if (r1 > 0) goto L12;
        return 0;
    L12:
        return UtilityKotlinExtentionsKt.d(Integer.valueOf(r1));
    }

    public static void c(View r9, IPromotionUIConfig.b r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        Intrinsics.checkNotNullParameter(r10, "design");
        float[] r0 = r10.i();
        boolean r2 = true;
        Float r3 = null;
        int r4 = 0;
        if (r0 == null) goto L21;
        if (r0.length != 4) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L21;
        float r6 = r0[0];
        float r7 = r0[1];
        float r8 = r0[2];
        float r1 = r0[3];
        if ((r9 instanceof ECRoundedLinearLayout) == true) goto L15;
        View r11 = null;
    L16:
        ECRoundedLinearLayout r12 = (ECRoundedLinearLayout) r11;
        if (r12 == null) goto L19;
        r12.setRadius(UtilityKotlinExtentionsKt.c(Float.valueOf(r6)));
    L28:
        String r13 = r10.b();
        if (r13 == null) goto L33;
        Integer r14 = com.bytedance.android.ec.core.utils.s.b(r13);
        if (r14 == null) goto L33;
        r9.setBackgroundColor(r14.intValue());
    L35:
        if ((r9 instanceof TextView) == false) goto L74;
        Float r15 = Float.valueOf(r10.e());
        float r16 = 0;
        if (r15.floatValue() <= r16) goto L39;
        boolean r17 = true;
    L40:
        if (r17 == true) goto L43;
        r15 = null;
    L43:
        if (r15 == null) goto L48;
        float r18 = r15.floatValue();
        if (r10.f() == false) goto L47;
        ((TextView) r9).setTextSize(2, r18);
        goto L48
    L47:
        ((TextView) r9).setTextSize(1, r18);
    L48:
        Integer r19 = Integer.valueOf(r10.g());
        int r20 = r19.intValue();
        if (r20 > 0) goto L51;
    L53:
        boolean r21 = false;
    L54:
        if (r21 == true) goto L57;
        r19 = null;
    L57:
        if (r19 == null) goto L59;
        int r22 = r19.intValue();
        int r23 = c0.a;
        c0.b((TextView) r9, r22);
    L59:
        String r24 = r10.d();
        if (r24 == null) goto L64;
        Integer r25 = com.bytedance.android.ec.core.utils.s.b(r24);
        if (r25 == null) goto L64;
        ((TextView) r9).setTextColor(r25.intValue());
    L64:
        Float r26 = Float.valueOf(r10.h());
        if (r26.floatValue() <= r16) goto L67;
        boolean r27 = true;
    L68:
        if (r27 == true) goto L71;
        r26 = null;
    L71:
        if (r26 == null) goto L74;
        ((TextView) r9).setLineSpacing(UtilityKotlinExtentionsKt.c(Float.valueOf(r26.floatValue())), 1.0f);
        goto L74
    L67:
        r27 = false;
        goto L68
    L51:
        if ((r20 % 100) != 0) goto L53;
        r21 = true;
        goto L54
    L39:
        r17 = false;
    L74:
        if ((r9 instanceof ImageView) == false) goto L101;
        Float r110 = Float.valueOf(r10.c());
        float r28 = r110.floatValue();
        if (r28 >= 0) goto L78;
    L80:
        r2 = false;
    L81:
        if (r2 == false) goto L83;
        r3 = r110;
    L83:
        if (r3 == null) goto L102;
        float r111 = r3.floatValue();
        if (ViewCompat.isLaidOut(r9) == true) goto L87;
    L99:
        r9.addOnLayoutChangeListener(new a(r111, r9));
        return;
    L87:
        if (r9.isLayoutRequested() == true) goto L99;
        ImageView r29 = (ImageView) r9;
        ImageView.ScaleType r30 = r29.getScaleType();
        ImageView.ScaleType r31 = ImageView.ScaleType.MATRIX;
        if (r30 == r31) goto L91;
        r29.setScaleType(r31);
    L91:
        Matrix r32 = new Matrix();
        r32.setScale(r111, r111);
        float r33 = r29.getWidth();
        Drawable r34 = r29.getDrawable();
        if (r34 == null) goto L94;
        int r35 = r34.getIntrinsicWidth();
    L95:
        float r36 = 2;
        float r37 = (r33 - (r35 * r111)) / r36;
        float r38 = r29.getHeight();
        Drawable r39 = r29.getDrawable();
        if (r39 == null) goto L98;
        r4 = r39.getIntrinsicHeight();
    L98:
        r32.postTranslate(r37, (r38 - (r4 * r111)) / r36);
        r29.setImageMatrix(r32);
        return;
    L94:
        r35 = 0;
        goto L95
    L102:
        return;
    L78:
        if (r28 == 1.0f) goto L80;
    L101:
        return;
    L33:
        r9.setBackgroundColor(th.a.a(r9.getContext(), 2131106784));
        Unit r40 = Unit.INSTANCE;
        goto L35
    L19:
        ViewExtensionsKt.g(r9, r6, r7, r8, r1);
        Unit r41 = Unit.INSTANCE;
        goto L28
    L15:
        r11 = r9;
        goto L16
    L7:
        r5 = false;
    L21:
        if ((r9 instanceof ECRoundedLinearLayout) == true) goto L23;
        View r42 = null;
    L24:
        ECRoundedLinearLayout r43 = (ECRoundedLinearLayout) r42;
        if (r43 == null) goto L27;
        r43.setRadius(0.0f);
        goto L28
    L27:
        ViewExtensionsKt.g(r9, 0.0f, 0.0f, 0.0f, 0.0f);
        Unit r44 = Unit.INSTANCE;
        goto L28
    L23:
        r42 = r9;
        goto L24
    }

    public static void d(View r6, IPromotionUIConfig.d r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        Intrinsics.checkNotNullParameter(r7, "style");
        Integer r0 = Integer.valueOf(r7.c());
        int r1 = r0.intValue();
        int r2 = 0;
        boolean r3 = true;
        if (r1 == 0) goto L7;
        if (r1 == 1) goto L7;
        r3 = false;
    L7:
        if (r3 == true) goto L10;
        r0 = null;
    L10:
        if (r0 != null) goto L12;
    L15:
        IPromotionUIConfig.c r4 = r7.b();
        if (r4 == null) goto L49;
        ViewGroup.LayoutParams r5 = r6.getLayoutParams();
        r5.width = b(r4.r());
        r5.height = b(r4.c());
        r6.setLayoutParams(r5);
        Integer r8 = r4.k();
        if (r8 == null) goto L20;
        int r9 = UtilityKotlinExtentionsKt.d(r8);
    L21:
        Integer r10 = r4.m();
        if (r10 == null) goto L24;
        int r11 = UtilityKotlinExtentionsKt.d(r10);
    L25:
        Integer r12 = r4.l();
        if (r12 == null) goto L28;
        int r13 = UtilityKotlinExtentionsKt.d(r12);
    L29:
        Integer r14 = r4.j();
        if (r14 == null) goto L32;
        int r15 = UtilityKotlinExtentionsKt.d(r14);
    L33:
        r6.setPadding(r9, r11, r13, r15);
        Integer r16 = r4.g();
        if (r16 == null) goto L36;
        int r17 = UtilityKotlinExtentionsKt.d(r16);
    L37:
        Integer r18 = r4.i();
        if (r18 == null) goto L40;
        int r19 = UtilityKotlinExtentionsKt.d(r18);
    L41:
        Integer r20 = r4.h();
        if (r20 == null) goto L44;
        int r21 = UtilityKotlinExtentionsKt.d(r20);
    L45:
        Integer r22 = r4.f();
        if (r22 == null) goto L48;
        r2 = UtilityKotlinExtentionsKt.d(r22);
    L48:
        wg.a.f(r6, r17, r19, r21, r2);
        goto L49
    L44:
        r21 = 0;
        goto L45
    L40:
        r19 = 0;
        goto L41
    L36:
        r17 = 0;
        goto L37
    L32:
        r15 = 0;
        goto L33
    L28:
        r13 = 0;
        goto L29
    L24:
        r11 = 0;
        goto L25
    L20:
        r9 = 0;
    L49:
        IPromotionUIConfig.b r23 = r7.a();
        if (r23 == null) goto L53;
        c(r6, r23);
        return;
    L53:
        return;
    L12:
        if (r0.intValue() != 0) goto L14;
        r6.setVisibility(0);
        goto L15
    L14:
        r6.setVisibility(8);
        goto L15
    }

    @JvmStatic
    public static final void a(View r3, View r4, Runnable r5) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r4 != null) goto L6;
        return;
    L6:
        r4.setVisibility(8);
        r3.setVisibility(0);
        r3.setAlpha(1.0f);
        r3.animate().alpha(0.0f).setDuration(300).setListener(new a0(r3, r4, r5)).start();
    }

    public static void e(ConstraintLayout r17, Map r18, com.bytedance.android.livesdk.livecommerce.promotion.card.k r19) {
        Intrinsics.checkNotNullParameter(r17, "parent");
        Intrinsics.checkNotNullParameter(r18, "moduleIdMap");
        Intrinsics.checkNotNullParameter(r19, "config");
        ConstraintSet r2 = new ConstraintSet();
        r2.clone(r17);
        Iterator<Map.Entry<? extends PromotionCardModuleName, ? extends IPromotionUIConfig.d>> r3 = r19.iterator();
    L4:
        if (r3.hasNext() == false) goto L136;
        Map.Entry<? extends PromotionCardModuleName, ? extends IPromotionUIConfig.d> r4 = r3.next();
        PromotionCardModuleName r5 = r4.getKey();
        IPromotionUIConfig.d r6 = r4.getValue();
        PromotionCardModuleName r7 = PromotionCardModuleName.Parent;
        if (r5 == r7) goto L4;
        Integer r8 = (Integer) r18.get(r5);
        if (r8 == null) goto L4;
        int r9 = r8.intValue();
        Integer r10 = Integer.valueOf(r6.c());
        int r11 = r10.intValue();
        if (r11 == 0) goto L15;
        if (r11 == 1) goto L15;
        boolean r12 = false;
    L16:
        if (r12 == true) goto L19;
        r10 = null;
    L19:
        if (r10 == null) goto L26;
        int r13 = r10.intValue();
        if (r5 == r7) goto L26;
        if (r13 != 0) goto L24;
        int r14 = 0;
    L25:
        r2.setVisibility(r9, r14);
        goto L26
    L24:
        r14 = 8;
    L26:
        IPromotionUIConfig.c r15 = r6.b();
        if (r15 != null) goto L29;
    L31:
        IPromotionUIConfig.c r16 = r6.b();
        if (r16 == null) goto L38;
        PromotionCardModuleName r20 = r16.d();
        if (r20 == null) goto L38;
        Integer r21 = (Integer) r18.get(r20);
        if (r21 == null) goto L38;
        r2.connect(r9, 6, r21.intValue(), 6);
    L45:
        IPromotionUIConfig.c r22 = r6.b();
        if (r22 == null) goto L52;
        PromotionCardModuleName r23 = r22.n();
        if (r23 == null) goto L52;
        Integer r24 = (Integer) r18.get(r23);
        if (r24 == null) goto L52;
        r2.connect(r9, 7, r24.intValue(), 6);
    L59:
        IPromotionUIConfig.c r25 = r6.b();
        if (r25 == null) goto L66;
        PromotionCardModuleName r26 = r25.q();
        if (r26 == null) goto L66;
        Integer r27 = (Integer) r18.get(r26);
        if (r27 == null) goto L66;
        r2.connect(r9, 3, r27.intValue(), 3);
    L73:
        IPromotionUIConfig.c r28 = r6.b();
        if (r28 == null) goto L80;
        PromotionCardModuleName r29 = r28.b();
        if (r29 == null) goto L80;
        Integer r30 = (Integer) r18.get(r29);
        if (r30 == null) goto L80;
        r2.connect(r9, 4, r30.intValue(), 3);
    L87:
        IPromotionUIConfig.c r31 = r6.b();
        if (r31 == null) goto L4;
        r2.constrainWidth(r9, b(r31.r()));
        r2.constrainHeight(r9, b(r31.c()));
        if (r9 != 0) goto L92;
        ConstraintLayout r32 = r17;
    L93:
        if (r32 == null) goto L111;
        Integer r110 = r31.k();
        if (r110 == null) goto L97;
        int r111 = UtilityKotlinExtentionsKt.d(r110);
    L98:
        Integer r112 = r31.m();
        if (r112 == null) goto L101;
        int r113 = UtilityKotlinExtentionsKt.d(r112);
    L102:
        Integer r114 = r31.l();
        if (r114 == null) goto L105;
        int r115 = UtilityKotlinExtentionsKt.d(r114);
    L106:
        Integer r116 = r31.j();
        if (r116 == null) goto L109;
        int r117 = UtilityKotlinExtentionsKt.d(r116);
    L110:
        r32.setPadding(r111, r113, r115, r117);
        goto L111
    L109:
        r117 = 0;
        goto L110
    L105:
        r115 = 0;
        goto L106
    L101:
        r113 = 0;
        goto L102
    L97:
        r111 = 0;
    L111:
        Integer r33 = r31.i();
        if (r33 == null) goto L114;
        int r34 = UtilityKotlinExtentionsKt.d(r33);
    L115:
        r2.setMargin(r9, 3, r34);
        Integer r35 = r31.h();
        if (r35 == null) goto L118;
        int r36 = UtilityKotlinExtentionsKt.d(r35);
    L119:
        r2.setMargin(r9, 7, r36);
        Integer r37 = r31.h();
        if (r37 == null) goto L122;
        int r38 = UtilityKotlinExtentionsKt.d(r37);
    L123:
        r2.setMargin(r9, 2, r38);
        Integer r39 = r31.f();
        if (r39 == null) goto L126;
        int r40 = UtilityKotlinExtentionsKt.d(r39);
    L127:
        r2.setMargin(r9, 4, r40);
        Integer r41 = r31.g();
        if (r41 == null) goto L130;
        int r42 = UtilityKotlinExtentionsKt.d(r41);
    L131:
        r2.setMargin(r9, 6, r42);
        Integer r43 = r31.g();
        if (r43 == null) goto L134;
        int r118 = UtilityKotlinExtentionsKt.d(r43);
    L135:
        r2.setMargin(r9, 1, r118);
        goto L4
    L134:
        r118 = 0;
        goto L135
    L130:
        r42 = 0;
        goto L131
    L126:
        r40 = 0;
        goto L127
    L122:
        r38 = 0;
        goto L123
    L118:
        r36 = 0;
        goto L119
    L114:
        r34 = 0;
        goto L115
    L92:
        r32 = r17.findViewById(r9);
    L80:
        IPromotionUIConfig.c r44 = r6.b();
        if (r44 == null) goto L87;
        PromotionCardModuleName r45 = r44.a();
        if (r45 == null) goto L87;
        Integer r46 = (Integer) r18.get(r45);
        if (r46 == null) goto L87;
        r2.connect(r9, 4, r46.intValue(), 4);
    L66:
        IPromotionUIConfig.c r47 = r6.b();
        if (r47 == null) goto L73;
        PromotionCardModuleName r48 = r47.p();
        if (r48 == null) goto L73;
        Integer r49 = (Integer) r18.get(r48);
        if (r49 == null) goto L73;
        r2.connect(r9, 3, r49.intValue(), 4);
    L52:
        IPromotionUIConfig.c r50 = r6.b();
        if (r50 == null) goto L59;
        PromotionCardModuleName r51 = r50.o();
        if (r51 == null) goto L59;
        Integer r52 = (Integer) r18.get(r51);
        if (r52 == null) goto L59;
        r2.connect(r9, 7, r52.intValue(), 7);
    L38:
        IPromotionUIConfig.c r53 = r6.b();
        if (r53 == null) goto L45;
        PromotionCardModuleName r54 = r53.e();
        if (r54 == null) goto L45;
        Integer r55 = (Integer) r18.get(r54);
        if (r55 == null) goto L45;
        r2.connect(r9, 6, r55.intValue(), 7);
        goto L45
    L29:
        if (r15.s(r18) != true) goto L31;
        r2.clear(r9, 3);
        r2.clear(r9, 4);
        r2.clear(r9, 6);
        r2.clear(r9, 7);
    L15:
        r12 = true;
        goto L16
    L136:
        r2.applyTo(r17);
        com.bytedance.android.ec.sdk.helper.l.a(new UIConfigHelper$updateUIByLayout$2(r18, r2));
    }
}
