package com.bytedance.ee.bear.webview.fps;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.bytedance.ee.larkwebview.base.LarkWebView;
import et3.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class FpsWebViewV2 extends LarkWebView {
    public String A;
    public c B;
    public boolean C;

    /* JADX WARN: Multi-variable type inference failed */
    public String getSceneTag() {
        String r0 = this.A;
        if (r0 == null) goto L22;
        return r0;
    L22:
        String r1 = getResources().getResourceEntryName(((ViewGroup) getParent()).getId());     // Catch: Exception -> L7
    L24:
        String r2 = getResources().getResourceEntryName(getId());     // Catch: Exception -> L10
    L12:
        if (TextUtils.isEmpty(r1) == true) goto L17;
        if (TextUtils.isEmpty(r2) == true) goto L17;
        this.A = r1 + "/" + r2;
    L21:
        return this.A;
    L17:
        if (TextUtils.isEmpty(r1) == false) goto L19;
        r1 = r2;
    L19:
        this.A = r1;
    L10:
        r2 = getClass().getSimpleName();
    L7:
        r1 = null;
        goto L24
    }

    public void destroy() {
        super.destroy();
        c r0 = this.B;
        if (r0 == null) goto L7;
        r0.f();
        this.B = null;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachedFromWindow() {
        super/*android.webkit.WebView*/.onDetachedFromWindow();
        c r0 = this.B;
        if (r0 == null) goto L7;
        r0.f();
        this.B = null;
        return;
    }

    public FpsWebViewV2(Context r1) {
        super(r1);
        this.A = null;
        this.B = null;
        this.C = false;
    }

    public FpsWebViewV2(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.A = null;
        this.B = null;
        this.C = false;
    }

    public void onScrollChanged(int r3, int r4, int r5, int r6) {
        if (this.C == true) goto L14;
        this.C = true;
        if (this.B != null) goto L11;
        String r0 = "docs_" + getSceneTag();
        if (TextUtils.isEmpty(r0) == false) goto L10;
        r0 = "FpsWebViewV2";
    L10:
        this.B = new c(r0);
    L11:
        c r1 = this.B;
        if (r1 == null) goto L14;
        r1.d();
    L14:
        super.onScrollChanged(r3, r4, r5, r6);
    }
}
