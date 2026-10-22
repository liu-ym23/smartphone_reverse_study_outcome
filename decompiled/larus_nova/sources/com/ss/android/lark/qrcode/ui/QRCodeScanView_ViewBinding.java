package com.ss.android.lark.qrcode.ui;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larus.nova.R;
import com.ss.android.lark.ui.CommonTitleBar;

/* JADX INFO: loaded from: classes37.dex */
public class QRCodeScanView_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public QRCodeScanView f439029a;

    @Override // butterknife.Unbinder
    public final void unbind() {
        QRCodeScanView r100 = this.f439029a;
        if (r100 == null) goto L7;
        this.f439029a = null;
        r100.mMyTitleBar = null;
        r100.mCustomViewContainer = null;
        r100.mFlashLight = null;
        r100.mFlashLightTips = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public QRCodeScanView_ViewBinding(QRCodeScanView r100, View r101) {
        this.f439029a = r100;
        r100.mMyTitleBar = (CommonTitleBar) Utils.findRequiredViewAsType(r101, R.id.titlebar, "field 'mMyTitleBar'", CommonTitleBar.class);
        r100.mCustomViewContainer = (FrameLayout) Utils.findRequiredViewAsType(r101, R.id.custom_view_container, "field 'mCustomViewContainer'", FrameLayout.class);
        r100.mFlashLight = (ImageView) Utils.findRequiredViewAsType(r101, R.id.flashlight, "field 'mFlashLight'", ImageView.class);
        r100.mFlashLightTips = (TextView) Utils.findRequiredViewAsType(r101, R.id.flashlight_tips, "field 'mFlashLightTips'", TextView.class);
    }
}
