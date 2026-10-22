package com.bytedance.lynx.webview.internal;

import android.content.DialogInterface;
import android.webkit.ValueCallback;
import com.bytedance.lynx.webview.TTWebSdk;

/* JADX INFO: loaded from: classes21.dex */
public final class y0 implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ValueCallback f265383a;

    public y0(z.a r100) {
        this.f265383a = r100;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        this.f265383a.onReceiveValue(TTWebSdk.QuickAppHandler.QuickAppAction.QUICK_APP_ACTION_PROCEED);
    }
}
