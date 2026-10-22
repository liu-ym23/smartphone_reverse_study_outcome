package f1b;

import android.net.Uri;
import android.util.LruCache;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;
import swb.j;

/* JADX INFO: loaded from: classes35.dex */
public final class e extends y0b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebView f475095a;

    public e(WebView r100) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        this.f475095a = r100;
    }

    @Override // y0b.c
    public final WebResourceResponse a(Uri r100) {
        if (r100 == null) goto L5;
        String r101 = UriProtector.getQueryParameter(r100, "path");
    L6:
        if (r101 == null) goto L11;
        LruCache<String, String> r102 = l0b.a.f506906a;
        Intrinsics.checkNotNullParameter(r101, "key");
        String r103 = l0b.a.f506906a.get(r101);
        if (r103 == null) goto L11;
        return new WebResourceResponse(j.i(r103), Charset.defaultCharset().name(), ContentResolverWrapper.openInputStream(this.f475095a.getContext().getContentResolver(), UriProtector.parse(r103)));
    L11:
        return null;
    L5:
        r101 = null;
        goto L6
    }
}
