package kv4;

import android.view.View;
import com.bytedance.ee.bear.bitable.websubpage.FullScreenWebSubPage;
import com.bytedance.ee.bear.browser.WebViewV2;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FullScreenWebSubPage f506264a;

    public a(FullScreenWebSubPage r100) {
        this.f506264a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        FullScreenWebSubPage r101 = this.f506264a;
        WebViewV2 r102 = r101.f216281h;
        if (r102 == null) goto L6;
        r102.evaluateJavascript("javascript:window.lark.biz.webSubPage.onBackPress()", new com.bytedance.ee.bear.bitable.websubpage.a(r101));
        return;
    }
}
