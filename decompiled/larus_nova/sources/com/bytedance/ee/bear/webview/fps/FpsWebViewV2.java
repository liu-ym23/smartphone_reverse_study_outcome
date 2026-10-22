package com.bytedance.ee.bear.webview.fps;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ee.larkwebview.base.LarkWebView;
import et3.c;

/* JADX INFO: loaded from: classes18.dex */
public class FpsWebViewV2 extends LarkWebView {
    public String A;
    public c B;
    public boolean C;

    public String getSceneTag() {
        String r100 = this.A;
        if (r100 == null) goto L22;
        return r100;
    L22:
        String r101 = getResources().getResourceEntryName(((ViewGroup) getParent()).getId());     // Catch: Exception -> L7
    L24:
        String r102 = getResources().getResourceEntryName(getId());     // Catch: Exception -> L10
    L12:
        if (TextUtils.isEmpty(r101) == true) goto L17;
        if (TextUtils.isEmpty(r102) == true) goto L17;
        this.A = r101 + HTTP.URL_DEFAULT + r102;
    L21:
        return this.A;
    L17:
        if (TextUtils.isEmpty(r101) == false) goto L19;
        r101 = r102;
    L19:
        this.A = r101;
    L10:
        r102 = getClass().getSimpleName();
    L7:
        r101 = null;
        goto L24
    }

    @Override // com.bytedance.ee.larkwebview.base.LarkWebView, android.webkit.WebView
    public void destroy() {
        super.destroy();
        c r100 = this.B;
        if (r100 == null) goto L7;
        r100.f();
        this.B = null;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c r100 = this.B;
        if (r100 == null) goto L7;
        r100.f();
        this.B = null;
        return;
    }

    public FpsWebViewV2(Context r100) {
        super(r100);
        this.A = null;
        this.B = null;
        this.C = false;
    }

    public FpsWebViewV2(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.A = null;
        this.B = null;
        this.C = false;
    }

    @Override // com.bytedance.ee.larkwebview.base.LarkWebView, android.webkit.WebView, android.view.View
    public void onScrollChanged(int r100, int r101, int r102, int r103) {
        if (this.C == true) goto L14;
        this.C = true;
        if (this.B != null) goto L11;
        String r104 = "docs_" + getSceneTag();
        if (TextUtils.isEmpty(r104) == false) goto L10;
        r104 = "FpsWebViewV2";
    L10:
        this.B = new c(r104);
    L11:
        c r105 = this.B;
        if (r105 == null) goto L14;
        r105.d();
    L14:
        super.onScrollChanged(r100, r101, r102, r103);
    }
}
