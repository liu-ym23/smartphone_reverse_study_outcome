package com.obric.assistant.interaction.impl.window.helpers;

import android.os.IBinder;
import android.view.View;
import android.widget.PopupWindow;
import androidx.fragment.app.FragmentActivity;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.obric.assistant.spi.window.ChatWindowServiceDelegate;
import me.ele.lancet.base.Origin;
import me.ele.lancet.base.This;

/* JADX INFO: loaded from: classes33.dex */
public class PopupWindowLancet {
    public PopupWindowLancet() {
    }

    public void dismiss() {
        handleDismissBeforeOrigin(This.get());
        Origin.callVoid();
    }

    public void update() {
        Origin.callVoid();
    }

    public static void handleDismissBeforeOrigin(Object r100) {
        if ((r100 instanceof PopupWindow) == false) goto L6;
        PopupWindow r101 = (PopupWindow) r100;
        PopupOrDialogVisibilityTracker.onPopupDismiss(r101);
        LandscapeChildPopupWindowBoundsAdapter.clearDirectCenterManaged(r101);
        return;
    }

    public static boolean hasSubWindowToken(View r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return hasSubWindowToken(r100.getWindowToken(), r100.getApplicationWindowToken());
    }

    public static OverlaySource resolveSource(View r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        boolean r101 = ChatWindowServiceDelegate.f392926b.d(r100.getContext());
        if (r101 == false) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r101 == true) goto L13;
        if (r102 == true) goto L16;
        return null;
    L16:
        return OverlaySource.ACTIVITY;
    L13:
        return OverlaySource.WINDOW;
    L8:
        if (WindowUtils.INSTANCE.isChatActivityPopup(r100) == false) goto L10;
        r102 = true;
        goto L11
    }

    public void showAsDropDown(View r100) {
        Object r101 = This.get();
        OverlaySource r102 = resolveSource(r100);
        if (rewriteShowAsDropDownIfNeeded(r101, r100, r102) == false) goto L5;
        return;
    L5:
        Origin.callVoid();
        trackAfterShow(r101, r102, r100);
    }

    public static boolean hasSubWindowToken(IBinder r100, IBinder r101) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L7;
        if (r100.equals(r101) == true) goto L7;
        return true;
    L7:
        return false;
    }

    public void update(int r100, int r101) {
        Origin.callVoid();
    }

    public static boolean rewriteShowAsDropDownIfNeeded(Object r100, View r101, OverlaySource r102) {
        if ((r100 instanceof PopupWindow) == true) goto L5;
        return false;
    L5:
        PopupWindow r103 = (PopupWindow) r100;
        LandscapeChildPopupWindowBoundsAdapter.RewriteDecision r104 = LandscapeChildPopupWindowBoundsAdapter.resolveRewriteDecision(r103, r101, r102);
        if (r104 != null) goto L8;
        return false;
    L8:
        LandscapeChildPopupWindowBoundsAdapter.beginShowAtLocationBypass(r103);
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAtLocation(r103, r104.getParent(), r104.getGravity(), r104.getX(), r104.getY());     // Catch: Throwable -> L15
        LandscapeChildPopupWindowBoundsAdapter.endShowAtLocationBypass(r103);
        if (r103.isShowing() == false) goto L20;
        LandscapeChildPopupWindowBoundsAdapter.markRewriteSucceeded(r103);
        PopupOrDialogVisibilityTracker.onPopupShow(r103, OverlaySource.WINDOW, null);
        return true;
    L20:
        return true;
    L15:
        th = move-exception;
        LandscapeChildPopupWindowBoundsAdapter.endShowAtLocationBypass(r103);
        throw th;
    }

    public static void trackAfterShow(Object r100, OverlaySource r101, View r102) {
        if ((r100 instanceof PopupWindow) == false) goto L12;
        if (r101 == null) goto L13;
        PopupWindow r103 = (PopupWindow) r100;
        if (r101 != OverlaySource.ACTIVITY) goto L9;
        FragmentActivity r104 = WindowUtils.INSTANCE.resolveChatActivityPopup(r102);
    L10:
        PopupOrDialogVisibilityTracker.onPopupShow(r103, r101, r104);
        return;
    L9:
        r104 = null;
        goto L10
    L13:
        return;
    }

    public void showAsDropDown(View r100, int r101, int r102) {
        Object r103 = This.get();
        OverlaySource r104 = resolveSource(r100);
        if (rewriteShowAsDropDownIfNeeded(r103, r100, r104) == false) goto L5;
        return;
    L5:
        Origin.callVoid();
        trackAfterShow(r103, r104, r100);
    }

    public void update(View r100, int r101, int r102) {
        Object r103 = This.get();
        if ((r103 instanceof PopupWindow) == false) goto L9;
        if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget((PopupWindow) r103) == false) goto L9;
        Origin.callVoid();
        return;
    L9:
        if (rewriteDirectUpdateIfNeeded(r103, r100, r101, r102) == false) goto L11;
        return;
    L11:
        Origin.callVoid();
    }

    public static boolean rewriteDirectUpdateIfNeeded(Object r100, View r101, int r102, int r103) {
        if ((r100 instanceof PopupWindow) == true) goto L5;
        return false;
    L5:
        PopupWindow r104 = (PopupWindow) r100;
        if (LandscapeChildPopupWindowBoundsAdapter.shouldRewriteDirectCenteredUpdate(r104) == true) goto L8;
        return false;
    L8:
        LandscapeChildPopupWindowBoundsAdapter.beginDirectUpdateBypass(r104);
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_update(r104, 0, 0, r102, r103);     // Catch: Throwable -> L12
        LandscapeChildPopupWindowBoundsAdapter.endDirectUpdateBypass(r104);
        return true;
    L12:
        th = move-exception;
        LandscapeChildPopupWindowBoundsAdapter.endDirectUpdateBypass(r104);
        throw th;
    }

    public void showAsDropDown(View r100, int r101, int r102, int r103) {
        Object r104 = This.get();
        OverlaySource r105 = resolveSource(r100);
        if (rewriteShowAsDropDownIfNeeded(r104, r100, r105) == false) goto L5;
        return;
    L5:
        Origin.callVoid();
        trackAfterShow(r104, r105, r100);
    }

    public void showAtLocation(View r100, int r110, int r111, int r112) {
        if (hasSubWindowToken(r100) == false) goto L5;
        return;
    L5:
        Object r101 = This.get();
        if ((r101 instanceof PopupWindow) == true) goto L8;
    L11:
        OverlaySource r102 = resolveSource(r100);
        if (rewriteDirectShowAtLocationIfNeeded(r101, r100, r102, r110, r111, r112) == false) goto L14;
        return;
    L14:
        Origin.callVoid();
        trackAfterShow(r101, r102, r100);
        return;
    L8:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget((PopupWindow) r101) == false) goto L11;
        Origin.callVoid();
    }

    public void update(int r100, int r101, int r102, int r103) {
        Object r104 = This.get();
        if ((r104 instanceof PopupWindow) == false) goto L9;
        if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget((PopupWindow) r104) == false) goto L9;
        Origin.callVoid();
        return;
    L9:
        if (rewriteDirectUpdateIfNeeded(r104, r100, r101, r102, r103) == false) goto L11;
        return;
    L11:
        Origin.callVoid();
    }

    public static void INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAtLocation(PopupWindow r100, View r101, int r102, int r110, int r111) {
        if (hasSubWindowToken(r101) == false) goto L6;
        return;
    L6:
        if ((r100 instanceof PopupWindow) == true) goto L8;
    L11:
        OverlaySource r103 = resolveSource(r101);
        if (rewriteDirectShowAtLocationIfNeeded(r100, r101, r103, r102, r110, r111) == false) goto L14;
        return;
    L14:
        r100.showAtLocation(r101, r102, r110, r111);
        trackAfterShow(r100, r103, r101);
        return;
    L8:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r100) == false) goto L11;
        r100.showAtLocation(r101, r102, r110, r111);
    }

    public static void INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_update(PopupWindow r100, int r101, int r102, int r103, int r104) {
        if ((r100 instanceof PopupWindow) == false) goto L9;
        if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r100) == false) goto L9;
        r100.update(r101, r102, r103, r104);
        return;
    L9:
        if (rewriteDirectUpdateIfNeeded(r100, r101, r102, r103, r104) == false) goto L11;
        return;
    L11:
        r100.update(r101, r102, r103, r104);
    }

    public static boolean rewriteDirectUpdateIfNeeded(Object r100, int r101, int r102, int r103, int r104) {
        if ((r100 instanceof PopupWindow) == true) goto L5;
        return false;
    L5:
        PopupWindow r105 = (PopupWindow) r100;
        if (LandscapeChildPopupWindowBoundsAdapter.shouldRewriteDirectCenteredUpdate(r105) == true) goto L8;
        return false;
    L8:
        LandscapeChildPopupWindowBoundsAdapter.beginDirectUpdateBypass(r105);
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_update(r105, 0, 0, r103, r104);     // Catch: Throwable -> L12
        LandscapeChildPopupWindowBoundsAdapter.endDirectUpdateBypass(r105);
        return true;
    L12:
        th = move-exception;
        LandscapeChildPopupWindowBoundsAdapter.endDirectUpdateBypass(r105);
        throw th;
    }

    public void update(int r100, int r101, int r102, int r110, boolean r111) {
        Object r103 = This.get();
        if ((r103 instanceof PopupWindow) == false) goto L9;
        if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget((PopupWindow) r103) == false) goto L9;
        Origin.callVoid();
        return;
    L9:
        if (rewriteDirectUpdateIfNeeded(r103, r100, r101, r102, r110, r111) == false) goto L11;
        return;
    L11:
        Origin.callVoid();
    }

    public void update(View r100, int r101, int r102, int r110, int r111) {
        Object r103 = This.get();
        if ((r103 instanceof PopupWindow) == false) goto L9;
        if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget((PopupWindow) r103) == false) goto L9;
        Origin.callVoid();
        return;
    L9:
        if (rewriteDirectUpdateIfNeeded(r103, r100, r101, r102, r110, r111) == false) goto L11;
        return;
    L11:
        Origin.callVoid();
    }

    public static void INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_update(PopupWindow r100, int r101, int r102, int r103, int r104, boolean r105) {
        if ((r100 instanceof PopupWindow) == false) goto L9;
        if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r100) == false) goto L9;
        r100.update(r101, r102, r103, r104, r105);
        return;
    L9:
        if (rewriteDirectUpdateIfNeeded(r100, r101, r102, r103, r104, r105) == false) goto L11;
        return;
    L11:
        r100.update(r101, r102, r103, r104, r105);
    }

    public static boolean rewriteDirectShowAtLocationIfNeeded(Object r100, View r101, OverlaySource r102, int r103, int r104, int r105) {
        if ((r100 instanceof PopupWindow) == true) goto L5;
        return false;
    L5:
        PopupWindow r106 = (PopupWindow) r100;
        LandscapeChildPopupWindowBoundsAdapter.RewriteDecision r107 = LandscapeChildPopupWindowBoundsAdapter.resolveDirectShowAtLocationDecision(r106, r101, r102);
        if (r107 != null) goto L8;
        return false;
    L8:
        LandscapeChildPopupWindowBoundsAdapter.beginShowAtLocationBypass(r106);
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAtLocation(r106, r107.getParent(), 17, 0, 0);     // Catch: Throwable -> L15
        LandscapeChildPopupWindowBoundsAdapter.endShowAtLocationBypass(r106);
        if (r106.isShowing() == false) goto L20;
        LandscapeChildPopupWindowBoundsAdapter.markDirectCenterManaged(r106);
        PopupOrDialogVisibilityTracker.onPopupShow(r106, OverlaySource.WINDOW, null);
        return true;
    L20:
        return true;
    L15:
        th = move-exception;
        LandscapeChildPopupWindowBoundsAdapter.endShowAtLocationBypass(r106);
        throw th;
    }

    public static boolean rewriteDirectUpdateIfNeeded(Object r100, int r101, int r102, int r103, int r110, boolean r111) {
        if ((r100 instanceof PopupWindow) == true) goto L5;
        return false;
    L5:
        PopupWindow r104 = (PopupWindow) r100;
        if (LandscapeChildPopupWindowBoundsAdapter.shouldRewriteDirectCenteredUpdate(r104) == true) goto L8;
        return false;
    L8:
        LandscapeChildPopupWindowBoundsAdapter.beginDirectUpdateBypass(r104);
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_update(r104, 0, 0, r103, r110, r111);     // Catch: Throwable -> L12
        LandscapeChildPopupWindowBoundsAdapter.endDirectUpdateBypass(r104);
        return true;
    L12:
        th = move-exception;
        LandscapeChildPopupWindowBoundsAdapter.endDirectUpdateBypass(r104);
        throw th;
    }

    public static boolean rewriteDirectUpdateIfNeeded(Object r100, View r101, int r102, int r103, int r104, int r105) {
        if ((r100 instanceof PopupWindow) == true) goto L5;
        return false;
    L5:
        PopupWindow r106 = (PopupWindow) r100;
        if (LandscapeChildPopupWindowBoundsAdapter.shouldRewriteDirectCenteredUpdate(r106) == true) goto L8;
        return false;
    L8:
        LandscapeChildPopupWindowBoundsAdapter.beginDirectUpdateBypass(r106);
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_update(r106, 0, 0, r104, r105);     // Catch: Throwable -> L12
        LandscapeChildPopupWindowBoundsAdapter.endDirectUpdateBypass(r106);
        return true;
    L12:
        th = move-exception;
        LandscapeChildPopupWindowBoundsAdapter.endDirectUpdateBypass(r106);
        throw th;
    }
}
