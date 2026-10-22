package qe;

import android.webkit.WebView;
import com.bytedance.android.livesdkapi.jsb.IExternalLiveWebCallback;
import kotlin.jvm.internal.Intrinsics;
import pd.i;

/* JADX INFO: loaded from: classes43.dex */
public final class d implements IExternalLiveWebCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f532610a;

    public d(i r100) {
        this.f532610a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalLiveWebCallback
    public final void onPageFinished(WebView r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        i r102 = this.f532610a;
        if (r102 == null) goto L6;
        r102.onPageFinished(r100, r101);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalLiveWebCallback
    public final void onPageStarted(WebView r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        i r102 = this.f532610a;
        if (r102 == null) goto L6;
        r102.onPageStarted(r100, r101);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalLiveWebCallback
    public final void onReceivedError(WebView r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        i r103 = this.f532610a;
        if (r103 == null) goto L6;
        r103.onReceivedError(r100, r101, r102);
        return;
    }
}
