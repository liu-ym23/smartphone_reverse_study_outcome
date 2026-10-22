package kv4;

import android.view.View;
import com.bytedance.ee.bear.bitable.websubpage.FullScreenWebSubPage;
import com.bytedance.ee.bear.browser.WebViewV2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ FullScreenWebSubPage a;

    public a(FullScreenWebSubPage r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        FullScreenWebSubPage r4 = this.a;
        WebViewV2 r0 = r4.h;
        if (r0 == null) goto L6;
        r0.evaluateJavascript("javascript:window.lark.biz.webSubPage.onBackPress()", new com.bytedance.ee.bear.bitable.websubpage.a(r4));
        return;
    }
}
