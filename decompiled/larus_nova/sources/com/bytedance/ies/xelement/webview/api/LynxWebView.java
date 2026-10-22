package com.bytedance.ies.xelement.webview.api;

import android.content.Context;
import com.lynx.tasm.behavior.LynxBehavior;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxGeneratorName;
import com.lynx.xelement.webview.LynxUIWebView;
import t8a.b;
import u8a.c;
import v86.a;

/* JADX INFO: loaded from: classes19.dex */
@LynxBehavior(isCreateAsync = false, tagName = {"x-webview"})
@LynxGeneratorName(packageName = "com.bytedance.ies.xelement.webview.api")
public class LynxWebView extends LynxUIWebView<a> {
    public static final String DEFAULT = "default";

    @Override // com.lynx.xelement.webview.LynxUIWebView
    public w86.a getProvider() {
        c r100 = super.getProvider();
        if ((r100 instanceof w86.a) == true) goto L7;
        return null;
    L7:
        return (w86.a) r100;
    }

    @Override // com.lynx.xelement.webview.LynxUIWebView
    public /* bridge */ /* synthetic */ c getProvider() {
        return getProvider();
    }

    public LynxWebView(LynxContext r100) {
        this(r100, null);
    }

    @Override // com.lynx.xelement.webview.LynxUIWebView
    public a createWebViewContainer(Context r100) {
        return new a(r100);
    }

    @Override // com.lynx.xelement.webview.LynxUIWebView
    public void setProvider(c r100) {
        super.setProvider(r100);
    }

    @Override // com.lynx.xelement.webview.LynxUIWebView
    public /* bridge */ /* synthetic */ b createWebViewContainer(Context r100) {
        return createWebViewContainer(r100);
    }

    public void setProvider(w86.a r100) {
        super.setProvider(r100);
    }

    public LynxWebView(LynxContext r100, Object r101) {
        super(r100, r101);
    }
}
