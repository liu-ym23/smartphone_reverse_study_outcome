package e26;

import android.webkit.WebSettings;
import android.webkit.WebView;
import c26.c;
import com.bytedance.ies.bullet.core.s;
import com.bytedance.ies.bullet.kit.web.d;
import com.bytedance.ies.bullet.kit.web.e;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import t36.f;

/* JADX INFO: loaded from: classes19.dex */
public class a extends s26.a implements b {
    @Override // k16.c
    public final s D(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        return null;
    }

    @Override // com.bytedance.ies.bullet.service.base.g
    public final List<Class<? extends f>> F() {
        return null;
    }

    @Override // e26.b
    public final d N(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        return null;
    }

    public c26.d X(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        return null;
    }

    public e Z(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        return null;
    }

    public c e0(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        return null;
    }

    @Override // e26.b
    public final boolean l() {
        return true;
    }

    @Override // e26.b
    public final com.bytedance.ies.bullet.kit.web.c p0(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        return null;
    }

    public com.bytedance.ies.bullet.kit.web.jsbridge.e s0(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        return null;
    }

    public a() {
    }

    @Override // com.bytedance.ies.bullet.service.base.g
    public final Class<? extends f> getModelType() {
        return v36.e.class;
    }

    @Override // e26.b
    public final com.bytedance.ies.bullet.kit.web.a f(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        return new com.bytedance.ies.bullet.kit.web.a(Boolean.TRUE);
    }

    public Map<String, Object> j0(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        return null;
    }

    public void h0(WebSettings r100, WebView r101, m16.b r102) {
        Intrinsics.checkNotNullParameter(r100, "settings");
        Intrinsics.checkNotNullParameter(r101, "webView");
        Intrinsics.checkNotNullParameter(r102, "providerFactory");
        r100.setJavaScriptEnabled(true);
        r100.setLoadWithOverviewMode(true);
        r100.setSupportZoom(true);
        r100.setBuiltInZoomControls(true);
        r100.setUseWideViewPort(true);
        r100.setDomStorageEnabled(true);
        r100.setAllowFileAccess(true);
        r100.setBlockNetworkImage(false);
    }
}
