package com.obric.oui.sheet.v2;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.common.oea.foundation.animation.token.AnimationProperty$FloatProperty;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.color.h0;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.p;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes34.dex */
public interface OSheetBase extends k {

    public static final class DefaultImpls {
        public static void b(OSheetBase r100) {
            Intrinsics.checkNotNullParameter(r100, "this");
            r100.getScaffoldController().a();
        }

        public static View d(OSheetBase r100) {
            Intrinsics.checkNotNullParameter(r100, "this");
            return r100.getHeaderContainer().findViewById(R.id.btn_end_action);
        }

        public static void e(OSheetBase r100) {
            Intrinsics.checkNotNullParameter(r100, "this");
            if ((r100.getRootContainer().getBackground() instanceof ColorDrawable) == false) goto L10;
            Drawable r101 = r100.getRootContainer().getBackground();
            if (r101 == null) goto L8;
            r100.setBgColor(((ColorDrawable) r101).getColor());
            return;
        L8:
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
        L10:
            if ((r100.getRootContainer().getBackground() instanceof GradientDrawable) == false) goto L21;
            Drawable r102 = r100.getRootContainer().getBackground();
            if (r102 == null) goto L19;
            ColorStateList r103 = ((GradientDrawable) r102).getColor();
            if (r103 != null) goto L16;
            int r104 = -1;
        L17:
            r100.setBgColor(r104);
            return;
        L16:
            r104 = r103.getDefaultColor();
            goto L17
        L19:
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        }

        public static boolean f(OSheetBase r100) {
            Intrinsics.checkNotNullParameter(r100, "this");
            if (r100.getBgColor() != 0) goto L7;
            return vma.i.a(r100.getRootContainer());
        L7:
            return h0.b(r100.getBgColor());
        }

        public static void h(OSheetBase r100) {
            Intrinsics.checkNotNullParameter(r100, "this");
            r100.m();
            int r101 = 0;
            View r102 = r100.getBodyContainer().getChildAt(0);
            if ((r102 instanceof ViewGroup) == false) goto L5;
            ViewGroup r103 = (ViewGroup) r102;
        L6:
            boolean r104 = true;
            if ((r100.getScaffoldContainer() instanceof LinearLayout) == false) goto L18;
            r100.getBodyContainer().setPadding(0, 0, 0, 0);
            if (r103 == null) goto L12;
            r103.setClipToPadding(true);
        L12:
            if (r103 == null) goto L15;
            r103.setPadding(r103.getPaddingLeft(), r100.getBodyContentPaddingTop(), r103.getPaddingRight(), r100.getBodyContentPaddingBottom());
        L15:
            if (r103 == null) goto L45;
            r103.requestLayout();
            return;
        L45:
            return;
        L18:
            FrameLayout r105 = r100.getBodyContainer();
            if (r100.getFooterContainer().getVisibility() != 0) goto L21;
            boolean r106 = true;
        L22:
            if (r106 == false) goto L24;
            int r107 = r100.getFooterContainer().getMeasuredHeight();
        L25:
            r105.setPadding(0, 0, 0, r107);
            if (r103 == null) goto L29;
            r103.setClipToPadding(false);
        L29:
            if (r103 != null) goto L32;
        L40:
            if (r103 == null) goto L46;
            r103.requestLayout();
            return;
        L46:
            return;
        L32:
            if (r100.getAutoAddBodyPaddingTopWhenOverlay() == true) goto L34;
        L39:
            r103.setPadding(r103.getPaddingLeft(), r100.getBodyContentPaddingTop() + r101, r103.getPaddingRight(), r100.getBodyContentPaddingBottom());
            goto L40
        L34:
            if (r100.getHeaderContainer().getVisibility() == 0) goto L37;
            r104 = false;
        L37:
            if (r104 == false) goto L39;
            r101 = r100.getHeaderContainer().getMeasuredHeight();
            goto L39
        L24:
            r107 = 0;
            goto L25
        L21:
            r106 = false;
            goto L22
        L5:
            r103 = null;
            goto L6
        }

        public static void t(OSheetBase r100) {
            Intrinsics.checkNotNullParameter(r100, "this");
            r100.setFullWindowSize(zma.a.c(r100.getSheetContext()));
            if (r100.getUserWindowWidth() <= 0) goto L8;
            if (r100.getUserWindowWidth() >= r100.getFullWindowSize().getWidth()) goto L8;
            r100.setFullWindowSize(new Size(r100.getUserWindowWidth(), r100.getFullWindowSize().getHeight()));
        L8:
            if (r100.getUserWindowHeight() > 0) goto L10;
            return;
        L10:
            if (r100.getUserWindowHeight() >= r100.getFullWindowSize().getHeight()) goto L14;
            r100.setFullWindowSize(new Size(r100.getFullWindowSize().getWidth(), r100.getUserWindowHeight()));
            return;
        }

        public static void a(OSheetBase r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "this");
            if (r100.getEnableMaterial() == false) goto L9;
            r100.getRootContainer().getContext();
            com.obric.oui.material.c[] r102 = MaterialToken.OUI_Bg_Modal.invoke(Boolean.valueOf(!r100.r()));
            r100.getRootContainer().setBackgroundColor(0);
            if (r101 == false) goto L7;
            p.e(r100.getRootContainer(), r102, false, null);
            return;
        L7:
            p.d(r100.getRootContainer(), r102, false, 0, 14);
            return;
        }

        public static void c(final OSheetBase r210, float r211) {
            Intrinsics.checkNotNullParameter(r210, "this");
            int r100 = SheetAnimStyle.f402960a;
            RadiusLayout r101 = r210.getRootContainer();
            Intrinsics.checkNotNullParameter(r101, "view");
            if ((r101.getTranslationY() / r101.getHeight()) > 0.333333f) goto L11;
            float r102 = r101.getTranslationY();
            Ref.DoubleRef r103 = new Ref.DoubleRef();
            r103.element = RangesKt.coerceAtLeast(1.0E-7d, Math.abs(0.1d));
            double r104 = RangesKt.coerceAtLeast(1.0E-4d, 0.5d) * (-4.2d);
            double r105 = Math.abs(r211);
            double r110 = r103.element;
            if (r105 <= r110) goto L10;
            double r106 = r211;
            double r111 = 1000;
            double r112 = (Math.log(Math.abs(r110 / r106)) / r104) * r111;
            double r107 = r106 / r104;
            r102 = (float) ((((double) r102) - r107) + (r107 * Math.exp((r104 * r112) / r111)));
        L10:
            if ((r102 / r101.getHeight()) > 0.333333f) goto L11;
            boolean r108 = false;
        L13:
            if (r108 == false) goto L15;
            r210.j(r211);
            return;
        L15:
            fja.d r109 = r210.getRunningAnim();
            if (r109 == null) goto L19;
            int r113 = fja.d.f477533d;
            r109.a(false);
        L19:
            RadiusLayout r114 = r210.getRootContainer();
            final Window r115 = r210.d();
            final View r116 = r210.getDimView();
            final boolean r117 = r210.i();
            final boolean r118 = r210.h();
            final float r119 = f.a(r210.getSheetContext());
            Intrinsics.checkNotNullParameter(r114, "<this>");
            Resources r120 = Resources.getSystem();
            int r121 = WindowDisplayMetricsOverride.apply(r120, r120.getDisplayMetrics()).heightPixels;
            r114.setAlpha(1.0f);
            if (r118 == false) goto L27;
            if (r115 == null) goto L28;
            WindowManager.LayoutParams r122 = r115.getAttributes();
            if (r122 == null) goto L28;
            float r123 = r122.dimAmount;
        L30:
            final float r124 = r123;
        L31:
            Pair r125 = SheetAnimStyle.d(r114.getHeight() / r121, true);
            float r126 = ((Number) r125.component1()).floatValue();
            float r127 = ((Number) r125.component2()).floatValue();
            if (r117 == false) goto L40;
            if (r118 == false) goto L40;
            if (r115 == null) goto L40;
            r115.addFlags(2);     // Catch: Exception -> L38
        L38:
            e = move-exception;
            Intrinsics.stringPlus("dialogBottomShow, can't show dim anim: ", e.getMessage());
        L40:
            final float r128 = r114.getTranslationY();
            com.obric.common.oea.foundation.animation.builder.b.a r129 = SheetAnimStyle.e(r114, R.id.o_dialog_anim_in);
            AnimationProperty$FloatProperty r130 = AnimationProperty$FloatProperty.TRANSLATION_Y;
            float r131 = r114.getTranslationY();
            com.obric.common.oea.foundation.animation.spec.spring.b r132 = gja.b.b(r126, r127);
            r132.f396390b = 1.0f;
            r129.b(r130, Float.valueOf(r131), 0.0f, r132, Float.valueOf(r211));
            final float r133 = 0.0f;
            Function3<String, Object, Object, Unit> r134 = new SheetAnimStyle$sheetPositionSmoothReset$2(r117, r118, r115, r128, r133, r124, r119, r116);
            Intrinsics.checkNotNullParameter(r134, "callback");
            r129.f396371d = r134;
            Function2<Boolean, Throwable, Unit> r135 = new OSheetBase$fling$1(r210);
            Intrinsics.checkNotNullParameter(r135, "callback");
            r129.f396372e = r135;
            r210.setRunningAnim(com.obric.common.oea.foundation.animation.builder.b.a(r129.a()));
            return;
        L28:
            r124 = 0.0f;
            goto L31
        L27:
            if (r116 == null) goto L28;
            r123 = r116.getAlpha();
        L11:
            r108 = true;
            goto L13
        }

        public static void i(final OSheetBase r210, float r211) {
            Intrinsics.checkNotNullParameter(r210, "this");
            fja.d r100 = r210.getRunningAnim();
            if (r100 == null) goto L6;
            int r101 = fja.d.f477533d;
            r100.a(false);
        L6:
            int r102 = SheetAnimStyle.f402960a;
            final RadiusLayout r110 = r210.getRootContainer();
            final Window r103 = r210.d();
            final View r111 = r210.getDimView();
            final boolean r104 = r210.i();
            final boolean r105 = r210.h();
            final Runnable r112 = new d(r210);
            Intrinsics.checkNotNullParameter(r110, "<this>");
            Resources r106 = Resources.getSystem();
            int r107 = WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics()).heightPixels;
            if (r104 == false) goto L15;
            if (r105 == false) goto L15;
            if (r103 == null) goto L15;
            r103.addFlags(2);     // Catch: Exception -> L13
        L13:
            e = move-exception;
            Intrinsics.stringPlus("dialogBottomHide, can't show dim anim: ", e.getMessage());
        L15:
            int r108 = r110.getHeight() + pla.d.n(r110, 32);
            Pair r109 = SheetAnimStyle.d(r110.getHeight() / r107, false);
            float r113 = ((Number) r109.component1()).floatValue();
            float r114 = ((Number) r109.component2()).floatValue();
            final float r115 = r110.getTranslationY();
            final float r116 = r108;
            if (r105 == false) goto L23;
            if (r103 == null) goto L24;
            WindowManager.LayoutParams r117 = r103.getAttributes();
            if (r117 == null) goto L24;
            float r118 = r117.dimAmount;
        L26:
            final float r119 = r118;
        L27:
            com.obric.common.oea.foundation.animation.builder.b.a r120 = SheetAnimStyle.e(r110, R.id.o_dialog_anim_out);
            AnimationProperty$FloatProperty r121 = AnimationProperty$FloatProperty.TRANSLATION_Y;
            float r122 = r110.getTranslationY();
            com.obric.common.oea.foundation.animation.spec.spring.b r123 = gja.b.b(r113, r114);
            r123.f396390b = 1.0f;
            r120.b(r121, Float.valueOf(r122), r116, r123, Float.valueOf(r211));
            final float r124 = 0.0f;
            Function3<String, Object, Object, Unit> r125 = new SheetAnimStyle$sheetHide$animBuilder$2(r104, r105, r103, r115, r116, r119, r124, r111, r110, r112);
            Intrinsics.checkNotNullParameter(r125, "callback");
            r120.f396371d = r125;
            com.obric.oui.animation.style.a.b(r110);
            Function2<Boolean, Throwable, Unit> r126 = new OSheetBase$performExitAnimation$2(r210);
            Intrinsics.checkNotNullParameter(r126, "callback");
            r120.f396372e = r126;
            r210.setRunningAnim(com.obric.common.oea.foundation.animation.builder.b.a(r120.a()));
            r210.l();
            return;
        L24:
            r119 = 0.0f;
            goto L27
        L23:
            if (r111 == null) goto L24;
            r118 = r111.getAlpha();
            goto L26
        }

        public static void j(OSheetBase r100, View r101) {
            Intrinsics.checkNotNullParameter(r100, "this");
            i.c(r100.getScaffoldController().f402973e, r101);
            if (r101 == null) goto L5;
            r100.setBodyContentPaddingTop(r101.getPaddingTop());
            r100.setBodyContentPaddingBottom(r101.getPaddingBottom());
            return;
        L5:
            r100.setBodyContentPaddingTop(0);
            r100.setBodyContentPaddingBottom(0);
        }

        public static void m(OSheetBase r100, View r101) {
            Intrinsics.checkNotNullParameter(r100, "this");
            i.c(r100.getScaffoldController().f402974f, r101);
        }

        public static void p(OSheetBase r100, View r101) {
            Intrinsics.checkNotNullParameter(r100, "this");
            i r102 = r100.getScaffoldController();
            r102.getClass();
            if ((r101 instanceof OSheetTitleBar) == false) goto L5;
            r102.f402982n = (OSheetTitleBar) r101;
        L6:
            i.c(r102.f402972d, r101);
            return;
        L5:
            r102.f402982n = null;
            goto L6
        }

        public static void q(OSheetBase r100, OSheet.HeightMode r101) {
            Intrinsics.checkNotNullParameter(r100, "this");
            Intrinsics.checkNotNullParameter(r101, "height");
            r100.setHeightStyle(r101);
            i r102 = r100.getScaffoldController();
            r102.getClass();
            Intrinsics.checkNotNullParameter(r101, "<set-?>");
            r102.f402979k = r101;
            r100.getScaffoldController().e();
        }

        public static void r(OSheetBase r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "this");
            if (r100.getBgColor() == r101) goto L19;
            boolean r102 = r100.r();
            r100.setBgColor(r101);
            boolean r103 = r100.r();
            if (r100.getEnableMaterial() == true) goto L7;
            r100.getRootContainer().setBackgroundColor(r101);
        L8:
            if (r102 == r103) goto L20;
            View r104 = r100.getScaffoldController().f402972d.getChildAt(0);
            if ((r104 instanceof OSheetTitleBar) == false) goto L21;
            OSheetTitleBar r105 = (OSheetTitleBar) r104;
            if (r103 == false) goto L14;
            int r106 = 2;
        L16:
            if (r105.f402951t == r106) goto L22;
            r105.f402951t = r106;
            r105.i();
            return;
        L22:
            return;
        L14:
            r106 = 1;
            goto L16
        L21:
            return;
        L20:
            return;
        L7:
            r100.s();
            goto L8
        }

        public static void s(OSheetBase r110, Context r111) {
            Intrinsics.checkNotNullParameter(r110, "this");
            Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
            r110.setRootContainer((RadiusLayout) r110.c(R.id.root_constraint));
            r110.setupDimView(r111);
            r110.setHeaderContainer((FrameLayout) r110.c(R.id.header_container));
            r110.setBodyContainer((FrameLayout) r110.c(R.id.body_container));
            r110.setFooterContainer((FrameLayout) r110.c(R.id.footer_container));
            r110.setScaffoldContainer((ViewGroup) r110.c(R.id.scaffold_container));
            r110.f();
            r110.setScaffoldController(new i(r111, r110, r110.getRootContainer(), r110.getHeaderContainer(), r110.getBodyContainer(), r110.getFooterContainer(), r110.getScaffoldContainer(), r110.getDimView()));
            i r112 = r110.getScaffoldController();
            OSheet.HeightMode r100 = r110.getHeightStyle();
            r112.getClass();
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            r112.f402979k = r100;
            i r113 = r110.getScaffoldController();
            r113.f402980l = r110.getIgnoreInsetBottom();
            i r114 = r110.getScaffoldController();
            Size r101 = r110.getFullWindowSize();
            r114.getClass();
            Intrinsics.checkNotNullParameter(r101, "fullWindowSize");
            r114.f402971c.setOnClickListener(new dg5.d());
            r114.f402975g.setClipChildren(false);
            r114.f402976h.setBackgroundColor(-16777216);
            r114.f402976h.setAlpha(0.0f);
            pla.j.e(r114.f402976h);
            r114.d(r101);
            r114.f();
            int r102 = SheetAnimStyle.f402960a;
            SheetAnimStyle.c(r114.f402971c);
            r114.a();
            r110.b();
        }

        public static void l(OSheet r100, String r101, View.OnClickListener r102) {
            k(r100, null, false, null, r101, true, r102);
        }

        public static void g(OSheetBase r100, float r101, float r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r100, "this");
            if (r103 == false) goto L9;
            r100.setRootTransMoveStartX(r100.getRootContainer().getTranslationX());
            r100.setRootTransMoveStartY(r100.getRootContainer().getTranslationY());
            fja.d r104 = r100.getRunningAnim();
            if (r104 == null) goto L11;
            r104.a(true);
            return;
        L11:
            return;
        L9:
            r100.getRootContainer().setTranslationX(r100.getRootTransMoveStartX() + r101);
            r100.getRootContainer().setTranslationY(r100.getRootTransMoveStartY() + r102);
        }

        public static void k(OSheetBase r100, String r101, boolean r110, View.OnClickListener r111, String r112, boolean r113, View.OnClickListener r114) {
            Intrinsics.checkNotNullParameter(r100, "this");
            i r102 = r100.getScaffoldController();
            r102.getClass();
            OSheetFooterBtnContainer r103 = new OSheetFooterBtnContainer(r102.f402969a, null);
            r103.b(r101, r110, r111, r112, r113, r114);
            i.c(r102.f402974f, r103);
        }

        public static void o(OSheet r110, OSheet.Header r111, Integer r112, String r210, String r211, boolean r212, View.OnClickListener r213, View.OnClickListener r214, int r215) {
            if ((r215 & 2) == 0) goto L5;
            Integer r100 = null;
        L7:
            if ((r215 & 8) == 0) goto L9;
            String r101 = null;
        L11:
            if ((r215 & 16) == 0) goto L13;
            String r102 = null;
        L15:
            if ((r215 & 32) == 0) goto L17;
            boolean r103 = false;
        L18:
            r110.getClass();
            n(r110, r111, r100, null, r101, r102, r103, r213, r214, null, null, null, null, null, null);
            return;
        L17:
            r103 = r212;
            goto L18
        L13:
            r102 = r211;
            goto L15
        L9:
            r101 = r210;
            goto L11
        L5:
            r100 = r112;
            goto L7
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static void n(final OSheetBase r210, OSheet.Header r211, Integer r212, Integer r213, String r214, String r215, boolean r216, View.OnClickListener r217, View.OnClickListener r310, Integer r311, Integer r312, String r313, String r314, Integer r315, Integer r316) {
            Intrinsics.checkNotNullParameter(r210, "this");
            Intrinsics.checkNotNullParameter(r211, "style");
            i r100 = r210.getScaffoldController();
            r100.getClass();
            Intrinsics.checkNotNullParameter(r211, "style");
            if (r212 == null) goto L5;
            String r101 = r100.f402969a.getString(r212.intValue());
        L6:
            if (r213 == null) goto L8;
            String r102 = r100.f402969a.getString(r213.intValue());
        L9:
            if (r311 == null) goto L11;
            String r103 = r100.f402969a.getString(r311.intValue());
        L12:
            if (r312 == null) goto L14;
            String r104 = r100.f402969a.getString(r312.intValue());
        L15:
            int r105 = i.a.f402984b[r211.ordinal()];
            int r106 = 6;
            ImageView r110 = null;
            Object[] r111 = 0;
            Object[] r112 = 0;
            Object[] r113 = 0;
            Object[] r114 = 0;
            Object[] r115 = 0;
            int r116 = 0;
            if (r105 != 1) goto L18;
            final OSheetTitleBar r107 = new OSheetTitleBar(r100.f402969a, r111 == true ? 1 : 0, r106, r116);
            r107.setTitleText(r101);
            r107.setSubTitleText(r102);
            if (r217 == null) goto L73;
            r107.findViewById(R.id.left_action_back).setOnClickListener(r217);
        L73:
            if (r107 == null) goto L86;
            r107.setClipChildren(false);
            if (r216 == false) goto L84;
            Context r108 = r100.f402969a;
            Intrinsics.checkNotNullParameter(r108, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r210, DocumentType.SHEET_NAME);
            ImageView r109 = (ImageView) FrameLayout.inflate(r108, R.layout.o_widget_titlebar_handler, r107).findViewById(R.id.title_handler);
            r107.f402936e = r109;
            if (r109 != null) goto L80;
            Intrinsics.throwUninitializedPropertyAccessException("mHandleView");
        L81:
            r110.setOnTouchListener(new j(r107, r210));
            if (r107.f402936e != null) goto L84;
            Intrinsics.throwUninitializedPropertyAccessException("mHandleView");
            goto L84
        L80:
            r110 = r109;
        L84:
            r100.f402982n = r107;
            i.c(r100.f402972d, r107);
            r107.b(r100.f402970b.q());
            r100.f402972d.setClipChildren(false);
            return;
        L86:
            return;
        L18:
            if (r105 != 2) goto L20;
            r107 = new OSheetTitleBar(r100.f402969a, r112 == true ? 1 : 0, r106, r116);
            r107.setShowLeftBack(false);
            r107.setTitleText(r101);
            r107.setSubTitleText(r102);
            Context r117 = r107.getContext();
            LinearLayout r118 = r107.getMLeftContainer();
            if (r315 != null) goto L56;
            int r119 = R.drawable.oui_ic_title_bar_close;
        L57:
            OIconButtonFloating r120 = r107.d(r117, r118, r119, r107.getContext().getColorStateList(R.color.oui_text_1), Integer.valueOf(R.string.oui_iv_close_desc));
            r120.setId(R.id.btn_start_action);
            r120.setContentDescription(r103);
            if (r217 == null) goto L61;
            r120.setOnClickListener(r217);
        L61:
            Context r121 = r107.getContext();
            LinearLayout r122 = r107.getMRightContainer();
            if (r316 != null) goto L64;
            int r123 = R.drawable.oui_ic_title_bar_confirm;
        L65:
            OIconButtonFloating r124 = r107.e(r121, r122, r123, r107.getContext().getColorStateList(R.color.oui_on_accent_default), Integer.valueOf(R.string.oui_confirm));
            r124.setId(R.id.btn_end_action);
            r124.setContentDescription(r104);
            if (r310 == null) goto L73;
            r124.setOnClickListener(r310);
            goto L73
        L64:
            r123 = r316.intValue();
            goto L65
        L56:
            r119 = r315.intValue();
            goto L57
        L20:
            if (r105 != 3) goto L22;
            r107 = new OSheetTitleBar(r100.f402969a, r113 == true ? 1 : 0, r106, r116);
            r107.setShowLeftBack(false);
            r107.setTitleText(r101);
            r107.setSubTitleText(r102);
            Context r125 = r107.getContext();
            LinearLayout r126 = r107.getMRightContainer();
            if (r316 != null) goto L48;
            int r127 = R.drawable.oui_ic_title_bar_close;
        L49:
            OIconButtonFloating r128 = r107.d(r125, r126, r127, r107.getContext().getColorStateList(R.color.oui_text_1), Integer.valueOf(R.string.oui_iv_close_desc));
            r128.setId(R.id.btn_end_action);
            r128.setContentDescription(r104);
            if (r310 == null) goto L73;
            r128.setOnClickListener(r310);
            goto L73
        L48:
            r127 = r316.intValue();
            goto L49
        L22:
            if (r105 != 4) goto L24;
            r107 = new OSheetTitleBar(r100.f402969a, r114 == true ? 1 : 0, r106, r116);
            r107.setShowLeftBack(false);
            r107.setTitleText(r101);
            r107.setSubTitleText(r102);
            goto L73
        L24:
            if (r105 == 5) goto L26;
            r107 = null;
            goto L73
        L26:
            r107 = new OSheetTitleBar(r100.f402969a, r115 == true ? 1 : 0, r106, r116);
            r107.setTitleText(r101);
            r107.setSubTitleText(r102);
            if (r217 == null) goto L33;
            View r129 = r107.findViewById(R.id.left_action_back);
            if (r129 == null) goto L33;
            r129.setOnClickListener(r217);
        L33:
            Context r130 = r107.getContext();
            LinearLayout r131 = r107.getMRightContainer();
            if (r316 != null) goto L36;
            int r132 = R.drawable.oui_ic_title_bar_close;
        L37:
            OIconButtonFloating r133 = r107.d(r130, r131, r132, r107.getContext().getColorStateList(R.color.oui_text_1), Integer.valueOf(R.string.oui_iv_close_desc));
            r133.setId(R.id.btn_end_action);
            if (r104 == null) goto L41;
            r133.setContentDescription(r104);
        L41:
            if (r310 == null) goto L73;
            r133.setOnClickListener(r310);
            goto L73
        L36:
            r132 = r316.intValue();
            goto L37
        L14:
            r104 = r314;
            goto L15
        L11:
            r103 = r313;
            goto L12
        L8:
            r102 = r215;
            goto L9
        L5:
            r101 = r214;
            goto L6
        }
    }

    void a();

    void b();

    <T extends View> T c(int r100);

    Window d();

    void e();

    void f();

    void g();

    boolean getAutoAddBodyPaddingTopWhenOverlay();

    int getBgColor();

    FrameLayout getBodyContainer();

    int getBodyContentPaddingBottom();

    int getBodyContentPaddingTop();

    ComponentCallbacks getConfigurationCallback();

    boolean getConfigurationCallbackRegistered();

    View getDimView();

    boolean getEnableMaterial();

    FrameLayout getFooterContainer();

    Size getFullWindowSize();

    FrameLayout getHeaderContainer();

    OSheet.HeightMode getHeightStyle();

    boolean getIgnoreInsetBottom();

    RadiusLayout getRootContainer();

    float getRootTransMoveStartX();

    float getRootTransMoveStartY();

    fja.d getRunningAnim();

    ViewGroup getScaffoldContainer();

    i getScaffoldController();

    Context getSheetContext();

    boolean getShowing();

    int getUserWindowHeight();

    int getUserWindowWidth();

    boolean h();

    boolean i();

    void j(float r100);

    void k();

    void l();

    void m();

    void o();

    boolean q();

    boolean r();

    void s();

    void setAutoAddBodyPaddingTopWhenOverlay(boolean r100);

    void setBgColor(int r100);

    void setBodyContainer(FrameLayout r100);

    void setBodyContentPaddingBottom(int r100);

    void setBodyContentPaddingTop(int r100);

    void setConfigurationCallbackRegistered(boolean r100);

    void setFooterContainer(FrameLayout r100);

    void setFullWindowSize(Size r100);

    void setHeaderContainer(FrameLayout r100);

    void setHeightStyle(OSheet.HeightMode r100);

    void setMCancelable(boolean r100);

    void setRootContainer(RadiusLayout r100);

    void setRootTransMoveStartX(float r100);

    void setRootTransMoveStartY(float r100);

    void setRunningAnim(fja.d r100);

    void setScaffoldContainer(ViewGroup r100);

    void setScaffoldController(i r100);

    void setupDimView(Context r100);
}
