package n45;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bytedance.ee.bear.document.loading.LoadingLayout;
import com.bytedance.ee.bear.document.web.CommonWebActivity;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends WebChromeClient {
    public final /* synthetic */ CommonWebActivity a;

    public b(CommonWebActivity r1) {
        this.a = r1;
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView r5, int r6) {
        LoadingLayout r1 = null;
        if (r6 != 100) goto L9;
        LoadingLayout r0 = this.a.h;
        if (r0 == null) goto L7;
        r1 = r0;
    L8:
        r1.setVisibility(8);
    L18:
        super.onProgressChanged(r5, r6);
        return;
    L7:
        Intrinsics.throwUninitializedPropertyAccessException("mLoadingView");
        goto L8
    L9:
        LoadingLayout r2 = this.a.h;
        if (r2 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mLoadingView");
        r2 = null;
    L13:
        r2.setVisibility(0);
        LoadingLayout r3 = this.a.h;
        if (r3 == null) goto L16;
        r1 = r3;
    L17:
        r1.e();
        goto L18
    L16:
        Intrinsics.throwUninitializedPropertyAccessException("mLoadingView");
        goto L17
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedTitle(WebView r2, String r3) {
        super.onReceivedTitle(r2, r3);
        BaseTitleBar r4 = this.a.e;
        if (r4 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mTitle");
        r4 = null;
    L6:
        if (r3 != null) goto L8;
    L11:
        boolean r0 = true;
    L12:
        if (r0 == false) goto L14;
        r3 = this.a.getString(2131887735);
    L14:
        r4.setTitle(r3);
        return;
    L8:
        if (r3.length() == 0) goto L11;
        r0 = false;
        goto L12
    }
}
