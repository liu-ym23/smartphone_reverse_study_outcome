package com.bytedance.lynx.webview.internal;

import android.content.DialogInterface;
import android.webkit.ValueCallback;
import com.bytedance.lynx.webview.TTWebSdk;

/* JADX INFO: loaded from: classes21.dex */
public final class x0 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ValueCallback f265373a;

    public x0(z.a r100) {
        this.f265373a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f265373a.onReceiveValue(TTWebSdk.QuickAppHandler.QuickAppAction.QUICK_APP_ACTION_COMPLAIN);
    }
}
