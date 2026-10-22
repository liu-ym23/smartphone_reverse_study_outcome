package com.ss.android.lark.chameleon.widget.titlebar;

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
import com.ss.android.lark.chameleon.util.UiUtils;

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

    public static DisplayMetrics INVOKEVIRTUAL_com_ss_android_lark_chameleon_widget_titlebar_ActionTitleBarHelper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static int dip2px(int r100) {
        return (int) ((r100 * INVOKEVIRTUAL_com_ss_android_lark_chameleon_widget_titlebar_ActionTitleBarHelper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()).density) + 0.5f);
    }

    public static void setDefaultTextStyle(TextView r100) {
        r100.setTextColor(r100.getResources().getColor(R.color.lkui_N900));
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
        int r105 = UiUtils.dp2px(r100, 10.0f);
        r102.setPadding(r105, r105, r105, r105);
        View r106 = r102;
    L24:
        if (r101.getBackground() == 0) goto L26;
        r106.setBackgroundResource(r101.getBackground());
    L26:
        return r106;
    L7:
        r102.setImageDrawable(AppCompatResources.getDrawable(r100, r101.getDrawableRes()));
        goto L8
    L13:
        if ((r101 instanceof IActionTitlebar.TextAction) == false) goto L20;
        IActionTitlebar.TextAction r107 = (IActionTitlebar.TextAction) r101;
        final TextView r108 = new TextView(r100);
        setDefaultTextStyle(r108);
        r108.setText(r101.getText());
        r108.setTextSize(r107.getTextSize());
        IActionTitlebar.TextAction r109 = (IActionTitlebar.TextAction) r101;
        if (r109.getColor() == (-1)) goto L17;
        r108.setTextColor(r100.getResources().getColorStateList(r107.getColor()));
    L18:
        r109.setOnTextColorChangedListener(new AnonymousClass2(r108));
        r109.setOnTextChangedListener(new AnonymousClass3(r108));
        r108.setPadding(getActionOutLeftPaddingInPixel(), 0, getActionOutPaddingInPixel(), 0);
        r106 = r108;
        goto L24
    L17:
        r108.setTextColor(r100.getResources().getColorStateList(R.color.chameleonv1_black_c2_c3_selector));
        goto L18
    L20:
        if ((r101 instanceof IActionTitlebar.ViewAction) == false) goto L22;
        View r110 = ((IActionTitlebar.ViewAction) r101).getView();
        r110.setPadding(getActionOutLeftPaddingInPixel(), 0, getActionOutPaddingInPixel(), 0);
        r106 = r110;
        goto L24
    L22:
        r106 = null;
        goto L24
    }
}
