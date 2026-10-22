package com.ss.android.lark.chameleon.widgetv2.titlebar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import swb.p;

/* JADX INFO: loaded from: classes35.dex */
public class ActionTitleBarHelper {
    public ActionTitleBarHelper() {
    }

    public static int getActionOutLeftPaddingInPixel() {
        return dip2px(9);
    }

    public static int getActionOutPaddingInPixel() {
        return dip2px(8);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_ss_android_lark_chameleon_widgetv2_titlebar_ActionTitleBarHelper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static int dip2px(int r100) {
        return (int) ((r100 * INVOKEVIRTUAL_com_ss_android_lark_chameleon_widgetv2_titlebar_ActionTitleBarHelper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()).density) + 0.5f);
    }

    public static void setDefaultTextStyle(TextView r100) {
        r100.setTextColor(r100.getResources().getColor(R.color.cml_v2_lkui_N900));
        r100.setSingleLine();
        r100.setGravity(16);
        r100.setEllipsize(TextUtils.TruncateAt.END);
    }

    public static View inflateAction(Context r100, IActionTitlebar.Action r101) {
        if ((r101 instanceof IActionTitlebar.ImageAction) == false) goto L13;
        final ImageView r102 = new ImageView(r100);
        IActionTitlebar.ImageAction r103 = (IActionTitlebar.ImageAction) r101;
        if (r103.getDrawable() == null) goto L7;
        r102.setImageDrawable(r103.getDrawable());
    L8:
        int r104 = r103.getTintRes();
        if (r104 == 0) goto L11;
        r102.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(r100, r104)));
    L11:
        r103.setOnDrawableUpdateListener(new AnonymousClass1(r102));
        p.a r105 = p.f543779a;
        int r106 = p.a.a(r100, 10.0f);
        r102.setPadding(r106, r106, r106, r106);
        View r107 = r102;
    L24:
        if (r101.getBackground() == 0) goto L26;
        r107.setBackgroundResource(r101.getBackground());
    L26:
        return r107;
    L7:
        r102.setImageDrawable(AppCompatResources.getDrawable(r100, r101.getDrawableRes()));
        goto L8
    L13:
        if ((r101 instanceof IActionTitlebar.TextAction) == false) goto L20;
        IActionTitlebar.TextAction r108 = (IActionTitlebar.TextAction) r101;
        final TextView r109 = new TextView(r100);
        setDefaultTextStyle(r109);
        r109.setText(r101.getText());
        r109.setTextSize(r108.getTextSize());
        IActionTitlebar.TextAction r110 = (IActionTitlebar.TextAction) r101;
        if (r110.getColor() == (-1)) goto L17;
        r109.setTextColor(r100.getResources().getColorStateList(r108.getColor()));
    L18:
        r110.setOnTextColorChangedListener(new AnonymousClass2(r109));
        r110.setOnTextChangedListener(new AnonymousClass3(r109));
        r109.setPadding(getActionOutLeftPaddingInPixel(), 0, getActionOutPaddingInPixel(), 0);
        r107 = r109;
        goto L24
    L17:
        r109.setTextColor(r100.getResources().getColorStateList(R.color.cml_black_c2_c3_selector));
        goto L18
    L20:
        if ((r101 instanceof IActionTitlebar.ViewAction) == false) goto L22;
        View r111 = ((IActionTitlebar.ViewAction) r101).getView();
        r111.setPadding(getActionOutLeftPaddingInPixel(), 0, getActionOutPaddingInPixel(), 0);
        r107 = r111;
        goto L24
    L22:
        r107 = null;
        goto L24
    }
}
