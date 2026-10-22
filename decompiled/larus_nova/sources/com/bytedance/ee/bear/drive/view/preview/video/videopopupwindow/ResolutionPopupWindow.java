package com.bytedance.ee.bear.drive.view.preview.video.videopopupwindow;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;

/* JADX INFO: loaded from: classes16.dex */
public class ResolutionPopupWindow extends PopupWindow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f225598a;

    @Override // android.widget.PopupWindow
    public final void dismiss() {
        Context r100 = this.f225598a;
        if (r100 != null) goto L5;
    L9:
        boolean r101 = true;
    L11:
        if (r101 == false) goto L13;
        tt5.a.h("DRIVE_VideoPlayer", "popupWindow dismiss successed! ");
        PopupWindowLancet.handleDismissBeforeOrigin(this);
        super.dismiss();
        return;
    L13:
        tt5.a.d("DRIVE_VideoPlayer", "popupWindow dismiss fail! Activity not running");
        return;
    L5:
        if ((r100 instanceof Activity) == false) goto L9;
        if (com.bytedance.ee.util.ui.b.a((Activity) r100) == true) goto L9;
        r101 = false;
        goto L11
    }

    public ResolutionPopupWindow() {
    }

    public static boolean a(View r100) {
        if (r100 != null) goto L5;
    L24:
        return false;
    L5:
        if (r100.getWindowToken() == null) goto L24;
        Context r101 = r100.getContext();
        if (r101 != null) goto L11;
        return false;
    L11:
        if ((r101 instanceof Activity) == true) goto L19;
        View r102 = r100.findViewById(R.id.content);
        if (r102 != null) goto L15;
        return true;
    L15:
        r101 = r102.getContext();
        if (r101 != null) goto L19;
        return false;
    L19:
        if ((r101 instanceof Activity) == true) goto L21;
    L23:
        return true;
    L21:
        if (com.bytedance.ee.util.ui.b.a((Activity) r101) == true) goto L23;
        return false;
    }

    @Override // android.widget.PopupWindow
    public final void setContentView(View r100) {
        super.setContentView(r100);
        if (r100 == null) goto L6;
        this.f225598a = r100.getContext();
        return;
    }

    @Override // android.widget.PopupWindow
    public final void showAsDropDown(View r100) {
        if (a(r100) == false) goto L9;
        OverlaySource r101 = PopupWindowLancet.resolveSource(r100);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(this, r100, r101) == true) goto L10;
        super.showAsDropDown(r100);
        PopupWindowLancet.trackAfterShow(this, r101, r100);
        return;
    L10:
        return;
    }

    public ResolutionPopupWindow(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f225598a = r100;
    }

    public ResolutionPopupWindow(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f225598a = r100;
    }

    @Override // android.widget.PopupWindow
    public final void showAsDropDown(View r100, int r101, int r102) {
        if (a(r100) == false) goto L9;
        OverlaySource r103 = PopupWindowLancet.resolveSource(r100);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(this, r100, r103) == true) goto L10;
        super.showAsDropDown(r100, r101, r102);
        PopupWindowLancet.trackAfterShow(this, r103, r100);
        return;
    L10:
        return;
    }

    @Override // android.widget.PopupWindow
    public final void showAsDropDown(View r100, int r101, int r102, int r103) {
        if (a(r100) == false) goto L9;
        OverlaySource r104 = PopupWindowLancet.resolveSource(r100);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(this, r100, r104) == true) goto L10;
        super.showAsDropDown(r100, r101, r102, r103);
        PopupWindowLancet.trackAfterShow(this, r104, r100);
        return;
    L10:
        return;
    }

    @Override // android.widget.PopupWindow
    public final void showAtLocation(View r100, int r101, int r110, int r111) {
        if (a(r100) == true) goto L5;
        return;
    L5:
        if (PopupWindowLancet.hasSubWindowToken(r100) == false) goto L8;
        return;
    L8:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(this) == false) goto L10;
        super.showAtLocation(r100, r101, r110, r111);
        return;
    L10:
        OverlaySource r102 = PopupWindowLancet.resolveSource(r100);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(this, r100, r102, r101, r110, r111) == true) goto L18;
        super.showAtLocation(r100, r101, r110, r111);
        PopupWindowLancet.trackAfterShow(this, r102, r100);
        return;
    }
}
