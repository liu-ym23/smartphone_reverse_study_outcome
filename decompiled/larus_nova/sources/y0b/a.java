package y0b;

import android.net.Uri;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, c> f565605a;

    public a(WebView r100, ChameleonConfig r101) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(r101, "chameleonConfig");
        DependencyContainer r102 = DependencyContainer.f433166a;
        com.ss.android.lark.officesdk.di.core.b r103 = null;
        com.ss.android.lark.officesdk.di.core.b r104 = DependencyContainer.a(x0b.a.class, null);
        if ((r104 instanceof x0b.a) == false) goto L6;
        r103 = r104;
    L6:
        x0b.a r105 = (x0b.a) r103;
        if (r105 == null) goto L11;
        Map<String, c> r106 = r105.h0(r100, r101);
        if (r106 == null) goto L11;
    L12:
        this.f565605a = r106;
        return;
    L11:
        r106 = MapsKt.emptyMap();
        goto L12
    }

    @Override // y0b.b
    public final WebResourceResponse shouldInterceptRequest(Uri r100, String r101, Map<String, String> r102) {
        if (r100 == null) goto L16;
        String r103 = r100.getPath();
        if (r103 == null) goto L17;
        List r104 = StringsKt.split$default(r103, new String[]{HTTP.URL_DEFAULT}, false, 0, 6, null);
        if (Intrinsics.areEqual(CollectionsKt.getOrNull(r104, 1), "cache-resource") == false) goto L18;
        String r105 = (String) CollectionsKt.getOrNull(r104, 2);
        if (r105 != null) goto L11;
        return null;
    L11:
        if (this.f565605a.containsKey(r105) == false) goto L20;
        c r106 = this.f565605a.get(r105);
        if (r106 != null) goto L15;
        return null;
    L15:
        return r106.a(r100);
    L20:
        return null;
    L18:
        return null;
    L17:
        return null;
    L16:
        return null;
    }
}
