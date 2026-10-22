package n45;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bytedance.ee.bear.document.loading.LoadingLayout;
import com.bytedance.ee.bear.document.web.CommonWebActivity;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonWebActivity f517052a;

    public b(CommonWebActivity r100) {
        this.f517052a = r100;
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView r100, int r101) {
        LoadingLayout r102 = null;
        if (r101 != 100) goto L9;
        LoadingLayout r103 = this.f517052a.f222474h;
        if (r103 == null) goto L7;
        r102 = r103;
    L8:
        r102.setVisibility(8);
    L18:
        super.onProgressChanged(r100, r101);
        return;
    L7:
        Intrinsics.throwUninitializedPropertyAccessException("mLoadingView");
        goto L8
    L9:
        LoadingLayout r104 = this.f517052a.f222474h;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mLoadingView");
        r104 = null;
    L13:
        r104.setVisibility(0);
        LoadingLayout r105 = this.f517052a.f222474h;
        if (r105 == null) goto L16;
        r102 = r105;
    L17:
        r102.e();
        goto L18
    L16:
        Intrinsics.throwUninitializedPropertyAccessException("mLoadingView");
        goto L17
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedTitle(WebView r100, String r101) {
        super.onReceivedTitle(r100, r101);
        BaseTitleBar r102 = this.f517052a.f222471e;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mTitle");
        r102 = null;
    L6:
        if (r101 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == false) goto L14;
        r101 = this.f517052a.getString(R.string.Doc_Facade_DefaultTitle);
    L14:
        r102.setTitle(r101);
        return;
    L8:
        if (r101.length() == 0) goto L11;
        r103 = false;
        goto L12
    }
}
