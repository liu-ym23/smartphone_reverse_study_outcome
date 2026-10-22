package com.ss.android.lark.officesdk.minutes.ui.style.provider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class o extends e {
    public o() {
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = jwb.a.f500742a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = zvb.a.f573774b;
        return zvb.a.C8496a.c(r100, Integer.valueOf(R.color.flow_ud_bg_base_3_overlay), Integer.valueOf(jwb.a.a(r100)), null, null, 52);
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable b(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r100 = jwb.a.f500742a;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        StateListDrawable r101 = new StateListDrawable();
        int r102 = zvb.a.f573774b;
        GradientDrawable r103 = zvb.a.C8496a.c(r110, Integer.valueOf(R.color.flow_ud_neutral_30), null, null, null, 60);
        Intrinsics.checkNotNullParameter(r103, "drawable");
        r101.addState(new int[]{android.R.attr.state_pressed}, r103);
        GradientDrawable r111 = zvb.a.C8496a.c(r110, Integer.valueOf(R.color.flow_ud_bg_base_4), null, null, null, 60);
        Intrinsics.checkNotNullParameter(r111, "drawable");
        r101.addState(new int[0], r111);
        return r101;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = jwb.a.f500742a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{UIUtils.getColor(r100, R.color.transparent), UIUtils.getColor(r100, R.color.flow_ud_bg_base_1)});
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = jwb.a.f500742a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = zvb.a.f573774b;
        GradientDrawable r103 = zvb.a.C8496a.c(r100, Integer.valueOf(R.color.bg_float), 8, null, null, 52);
        if ((r103 instanceof GradientDrawable) == false) goto L5;
        GradientDrawable r104 = r103;
    L6:
        if (r104 == null) goto L8;
        r104.setStroke(UIUtils.dp2px(r100, 1.0f), UIUtils.getColor(r100, R.color.line_border_card));
    L8:
        return r103;
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = jwb.a.f500742a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{UIUtils.getColor(r100, R.color.ud_N00_00), UIUtils.getColor(r100, R.color.bg_float)});
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = jwb.a.f500742a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        zvb.a r102 = new zvb.a();
        r102.f573775a.setShape(1);
        r102.c(r100, R.color.flow_ud_neutral_50, null);
        r102.b(Integer.valueOf(UIUtils.dp2px(r100, 3.0f)), Integer.valueOf(UIUtils.dp2px(r100, 3.0f)));
        return r102.f573775a;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = jwb.a.f500742a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{UIUtils.getColor(r100, R.color.bg_float), UIUtils.getColor(r100, R.color.ud_N00_00)});
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable h(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r100 = jwb.a.f500742a;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = jwb.a.a(r110);
        int r102 = zvb.a.f573774b;
        return zvb.a.C8496a.d(r110, Integer.valueOf(R.color.flow_ud_bg_base_2), Integer.valueOf(r101), Integer.valueOf(r101), null, null, 240);
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable i(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r100 = jwb.a.f500742a;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        StateListDrawable r101 = new StateListDrawable();
        int r102 = zvb.a.f573774b;
        GradientDrawable r103 = zvb.a.C8496a.c(r110, Integer.valueOf(R.color.flow_ud_bg_press), 100, null, null, 52);
        Intrinsics.checkNotNullParameter(r103, "drawable");
        r101.addState(new int[]{android.R.attr.state_pressed}, r103);
        GradientDrawable r111 = zvb.a.C8496a.c(r110, Integer.valueOf(android.R.color.transparent), 100, null, null, 52);
        Intrinsics.checkNotNullParameter(r111, "drawable");
        r101.addState(new int[0], r111);
        return r101;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable j(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = jwb.a.f500742a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = zvb.a.f573774b;
        GradientDrawable r103 = zvb.a.C8496a.c(r100, Integer.valueOf(R.color.flow_ud_bg_base_2), 8, null, null, 52);
        if ((r103 instanceof GradientDrawable) == false) goto L5;
        GradientDrawable r104 = r103;
    L6:
        if (r104 == null) goto L8;
        r104.setStroke(UIUtils.dp2px(r100, 0.5f), UIUtils.getColor(r100, R.color.line_border_card));
    L8:
        return r103;
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable k(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = jwb.a.f500742a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = jwb.a.a(r100);
        int r103 = zvb.a.f573774b;
        return zvb.a.C8496a.c(r100, Integer.valueOf(R.color.flow_ud_bg_base_4), Integer.valueOf(r102), null, null, 52);
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable l(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = jwb.a.f500742a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        zvb.a r102 = new zvb.a();
        r102.c(r100, R.color.flow_ud_neutral_transparent_1, null);
        int r103 = UIUtils.dp2px(r100, 6.0f);
        r102.a(r103, r103, r103, r103);
        return r102.f573775a;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable m(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r100 = jwb.a.f500742a;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = jwb.a.a(r110);
        StateListDrawable r102 = new StateListDrawable();
        int r103 = zvb.a.f573774b;
        GradientDrawable r104 = zvb.a.C8496a.c(r110, Integer.valueOf(R.color.flow_ud_neutral_30), Integer.valueOf(r101), null, null, 52);
        Intrinsics.checkNotNullParameter(r104, "drawable");
        r102.addState(new int[]{android.R.attr.state_pressed}, r104);
        GradientDrawable r111 = zvb.a.C8496a.c(r110, Integer.valueOf(R.color.flow_ud_bg_base_4), Integer.valueOf(r101), null, null, 52);
        Intrinsics.checkNotNullParameter(r111, "drawable");
        r102.addState(new int[0], r111);
        return r102;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable n(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r100 = jwb.a.f500742a;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = jwb.a.a(r110);
        StateListDrawable r102 = new StateListDrawable();
        int r103 = zvb.a.f573774b;
        GradientDrawable r104 = zvb.a.C8496a.d(r110, Integer.valueOf(R.color.flow_ud_neutral_30), null, null, Integer.valueOf(r101), Integer.valueOf(r101), 204);
        Intrinsics.checkNotNullParameter(r104, "drawable");
        r102.addState(new int[]{android.R.attr.state_pressed}, r104);
        GradientDrawable r111 = zvb.a.C8496a.d(r110, Integer.valueOf(R.color.flow_ud_bg_base_4), null, null, Integer.valueOf(r101), Integer.valueOf(r101), 204);
        Intrinsics.checkNotNullParameter(r111, "drawable");
        r102.addState(new int[0], r111);
        return r102;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable o(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = jwb.a.f500742a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{UIUtils.getColor(r100, R.color.flow_ud_bg_base_1), UIUtils.getColor(r100, R.color.transparent)});
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable p(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = jwb.a.f500742a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = zvb.a.f573774b;
        return zvb.a.C8496a.a(r100, Integer.valueOf(R.color.flow_ud_primary_transparent_1), null, null, 60);
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable q(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = jwb.a.f500742a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = UIUtils.dp2px(r100, 4.0f);
        zvb.a r103 = new zvb.a();
        r103.f573775a.setColor(-1);
        r103.a(r102, r102, r102, r102);
        GradientDrawable r104 = r103.f573775a;
        zvb.a r105 = new zvb.a();
        int[] r106 = {ColorProtector.parseColor("#26B791FA"), ColorProtector.parseColor("#265B65F5")};
        Intrinsics.checkNotNullParameter(r106, "colors");
        r105.f573775a.setColors(r106);
        GradientDrawable.Orientation r107 = GradientDrawable.Orientation.TL_BR;
        Intrinsics.checkNotNullParameter(r107, "orientation");
        r105.f573775a.setOrientation(r107);
        r105.a(r102, r102, r102, r102);
        return new LayerDrawable(new GradientDrawable[]{r104, r105.f573775a});
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable r(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r100 = jwb.a.f500742a;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = jwb.a.a(r110);
        StateListDrawable r102 = new StateListDrawable();
        int r103 = zvb.a.f573774b;
        GradientDrawable r104 = zvb.a.C8496a.d(r110, Integer.valueOf(R.color.flow_ud_neutral_30), Integer.valueOf(r101), Integer.valueOf(r101), null, null, 240);
        Intrinsics.checkNotNullParameter(r104, "drawable");
        r102.addState(new int[]{android.R.attr.state_pressed}, r104);
        GradientDrawable r111 = zvb.a.C8496a.d(r110, Integer.valueOf(R.color.flow_ud_bg_base_4), Integer.valueOf(r101), Integer.valueOf(r101), null, null, 240);
        Intrinsics.checkNotNullParameter(r111, "drawable");
        r102.addState(new int[0], r111);
        return r102;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable s(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r100 = jwb.a.f500742a;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        StateListDrawable r101 = new StateListDrawable();
        int r102 = zvb.a.f573774b;
        GradientDrawable r103 = zvb.a.C8496a.c(r110, Integer.valueOf(R.color.flow_ud_bg_press), 100, null, null, 52);
        Intrinsics.checkNotNullParameter(r103, "drawable");
        r101.addState(new int[]{android.R.attr.state_pressed}, r103);
        GradientDrawable r111 = zvb.a.C8496a.c(r110, Integer.valueOf(R.color.flow_ud_bg_base_5), 100, null, null, 52);
        Intrinsics.checkNotNullParameter(r111, "drawable");
        r101.addState(new int[0], r111);
        return r101;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable t(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = jwb.a.f500742a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        zvb.a r102 = new zvb.a();
        r102.c(r100, R.color.flow_ud_primary_50, null);
        r102.b(Integer.valueOf(UIUtils.dp2px(r100, 2.0f)), null);
        return r102.f573775a;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable u(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r100 = jwb.a.f500742a;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        StateListDrawable r101 = new StateListDrawable();
        int r102 = zvb.a.f573774b;
        GradientDrawable r103 = zvb.a.C8496a.c(r110, Integer.valueOf(R.color.flow_ud_bg_press), 8, null, null, 52);
        Intrinsics.checkNotNullParameter(r103, "drawable");
        r101.addState(new int[]{android.R.attr.state_pressed}, r103);
        GradientDrawable r111 = zvb.a.C8496a.c(r110, Integer.valueOf(android.R.color.transparent), 8, null, null, 52);
        Intrinsics.checkNotNullParameter(r111, "drawable");
        r101.addState(new int[0], r111);
        return r101;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable v(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = jwb.a.f500742a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = zvb.a.f573774b;
        return zvb.a.C8496a.c(r100, Integer.valueOf(R.color.flow_ud_bg_base_1), 24, Integer.valueOf(R.color.flow_ud_neutral_transparent_1), 1, 4);
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable w(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = jwb.a.f500742a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = zvb.a.f573774b;
        return zvb.a.C8496a.a(r100, Integer.valueOf(R.color.office_sdk_mm_color_end_window_top_action_btn_bg_doubao), Float.valueOf(0.6f), 40, 48);
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable x(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r100 = jwb.a.f500742a;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        StateListDrawable r101 = new StateListDrawable();
        int r102 = zvb.a.f573774b;
        GradientDrawable r103 = zvb.a.C8496a.c(r110, Integer.valueOf(R.color.flow_ud_bg_press), 100, null, null, 52);
        Intrinsics.checkNotNullParameter(r103, "drawable");
        r101.addState(new int[]{android.R.attr.state_pressed}, r103);
        GradientDrawable r111 = zvb.a.C8496a.c(r110, Integer.valueOf(R.color.flow_ud_bg_base_2_overlay), 100, null, null, 52);
        Intrinsics.checkNotNullParameter(r111, "drawable");
        r101.addState(new int[0], r111);
        return r101;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable y(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = jwb.a.f500742a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = zvb.a.f573774b;
        return zvb.a.C8496a.c(r100, Integer.valueOf(R.color.flow_ud_neutral_transparent_1), 100, null, null, 52);
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.provider.e, com.ss.android.lark.officesdk.minutes.ui.style.contract.g
    public final Drawable z(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = jwb.a.f500742a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = zvb.a.f573774b;
        return zvb.a.C8496a.c(r100, Integer.valueOf(R.color.flow_ud_bg_base_2_overlay), 100, null, null, 52);
    }
}
