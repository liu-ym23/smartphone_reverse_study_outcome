package com.lynx.xelement.webview;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes32.dex */
public class LynxUIWebView$$PropsSetter extends UISimpleView$$PropsSetter {
    public LynxUIWebView$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI r100, String r101, x0 r102) {
        LynxUIWebView r103 = (LynxUIWebView) r100;
        r101.getClass();
        byte r104 = -1;
        switch(r101.hashCode()) {
            case -995427962: goto L22;
            case 114148: goto L18;
            case 3213227: goto L14;
            case 1504731529: goto L10;
            case 1969817742: goto L6;
            default: goto L25;
        };
    L25:
        switch(r104) {
            case 0: goto L36;
            case 1: goto L34;
            case 2: goto L32;
            case 3: goto L30;
            case 4: goto L28;
            default: goto L26;
        };
    L26:
        super.setProperty(r100, r101, r102);
        return;
    L28:
        r103.setWebViewType(r102.h(r101));
        return;
    L30:
        r103.setDebug(r102.b(r101, false));
        return;
    L32:
        r103.setHtmlString(r102.h(r101));
        return;
    L34:
        r103.setSrc(r102.h(r101));
        return;
    L36:
        r103.setParams(r102.g(r101));
        return;
    L6:
        if (r101.equals("webview-type") == false) goto L25;
        r104 = 4;
        goto L25
    L10:
        if (r101.equals("enable-debug") == false) goto L25;
        r104 = 3;
        goto L25
    L14:
        if (r101.equals("html") == false) goto L25;
        r104 = 2;
        goto L25
    L18:
        if (r101.equals("src") == false) goto L25;
        r104 = 1;
        goto L25
    L22:
        if (r101.equals("params") == false) goto L25;
        r104 = 0;
        goto L25
    }
}
