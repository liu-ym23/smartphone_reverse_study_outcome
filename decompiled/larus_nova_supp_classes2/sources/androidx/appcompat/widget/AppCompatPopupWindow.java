package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.widget.PopupWindowCompat;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class AppCompatPopupWindow extends PopupWindow {
    private static final boolean COMPAT_OVERLAP_ANCHOR = false;
    private boolean mOverlapAnchor;

    static {
        COMPAT_OVERLAP_ANCHOR = false;
    }

    public static /* synthetic */ void access$000(PopupWindow r0, View r1, int r2, int r3) {
        super.showAsDropDown(r1, r2, r3);
    }

    public static /* synthetic */ void access$001(PopupWindow r0, View r1, int r2, int r3, int r4) {
        super.showAsDropDown(r1, r2, r3, r4);
    }

    public static /* synthetic */ void access$002(PopupWindow r0, View r1, int r2, int r3, int r4, int r5) {
        super.update(r1, r2, r3, r4, r5);
    }

    private void setSupportOverlapAnchor(boolean r2) {
        if (COMPAT_OVERLAP_ANCHOR == false) goto L5;
        this.mOverlapAnchor = r2;
        return;
    L5:
        PopupWindowCompat.setOverlapAnchor(this, r2);
    }

    public AppCompatPopupWindow(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        init(r2, r3, r4, 0);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View r2, int r3, int r4) {
        if (COMPAT_OVERLAP_ANCHOR == true) goto L5;
    L7:
        INVOKESPECIAL_androidx_appcompat_widget_AppCompatPopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAsDropDown(this, r2, r3, r4);
        return;
    L5:
        if (this.mOverlapAnchor == false) goto L7;
        r4 = r4 - r2.getHeight();
        goto L7
    }

    public AppCompatPopupWindow(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        init(r1, r2, r3, r4);
    }

    public static void INVOKESPECIAL_androidx_appcompat_widget_AppCompatPopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAsDropDown(PopupWindow r2, View r3, int r4, int r5) {
        OverlaySource r0 = PopupWindowLancet.resolveSource(r3);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r2, r3, r0) == false) goto L5;
        return;
    L5:
        access$000(r2, r3, r4, r5);
        PopupWindowLancet.trackAfterShow(r2, r0, r3);
    }

    private void init(Context r2, AttributeSet r3, int r4, int r5) {
        TintTypedArray r6 = TintTypedArray.obtainStyledAttributes(r2, r3, new int[]{R.attr.popupBackground, R.attr.popupAnimationStyle, 2130973422}, r4, r5);
        if (r6.hasValue(2) == false) goto L5;
        setSupportOverlapAnchor(r6.getBoolean(2, false));
    L5:
        setBackgroundDrawable(r6.getDrawable(0));
        r6.recycle();
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View r2, int r3, int r4, int r5) {
        if (COMPAT_OVERLAP_ANCHOR == true) goto L5;
    L7:
        INVOKESPECIAL_androidx_appcompat_widget_AppCompatPopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAsDropDown(this, r2, r3, r4, r5);
        return;
    L5:
        if (this.mOverlapAnchor == false) goto L7;
        r4 = r4 - r2.getHeight();
        goto L7
    }

    public static void INVOKESPECIAL_androidx_appcompat_widget_AppCompatPopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAsDropDown(PopupWindow r2, View r3, int r4, int r5, int r6) {
        OverlaySource r0 = PopupWindowLancet.resolveSource(r3);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r2, r3, r0) == false) goto L5;
        return;
    L5:
        access$001(r2, r3, r4, r5, r6);
        PopupWindowLancet.trackAfterShow(r2, r0, r3);
    }

    @Override // android.widget.PopupWindow
    public void update(View r7, int r8, int r9, int r10, int r11) {
        if (COMPAT_OVERLAP_ANCHOR == true) goto L5;
    L7:
        INVOKESPECIAL_androidx_appcompat_widget_AppCompatPopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_update(this, r7, r8, r9, r10, r11);
        return;
    L5:
        if (this.mOverlapAnchor == false) goto L7;
        r9 = r9 - r7.getHeight();
        goto L7
    }

    public static void INVOKESPECIAL_androidx_appcompat_widget_AppCompatPopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_update(PopupWindow r1, View r2, int r3, int r4, int r5, int r6) {
        if ((r1 instanceof PopupWindow) == false) goto L9;
        if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r1) == false) goto L9;
        access$002(r1, r2, r3, r4, r5, r6);
        return;
    L9:
        if (PopupWindowLancet.rewriteDirectUpdateIfNeeded(r1, r2, r3, r4, r5, r6) == false) goto L11;
        return;
    L11:
        access$002(r1, r2, r3, r4, r5, r6);
    }
}
