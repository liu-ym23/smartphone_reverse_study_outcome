package com.bytedance.ee.larkwebview.webview_api.adapter;

import android.view.View;
import android.webkit.WebSettings;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.ee.lark.component.AbstractNativeComponent;
import com.bytedance.ee.larkwebview.base.LarkWebView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class LarkWebViewAdapter implements pxb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarkWebView f242990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f242991b;

    public static final class a implements pxb.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WebSettings f242992a;

        @Override // pxb.b
        public final boolean a() {
            return this.f242992a.getJavaScriptEnabled();
        }

        public a(WebSettings r100) {
            Intrinsics.checkNotNullParameter(r100, "webSettings");
            this.f242992a = r100;
        }
    }

    @Override // pxb.a
    public final void c() {
        Intrinsics.checkNotNullParameter("LarkNativeComponentConfig", "name");
        this.f242990a.removeJavascriptInterface("LarkNativeComponentConfig");
    }

    @Override // pxb.a
    public final qxb.b getBridge() {
        return new com.bytedance.ee.larkwebview.webview_api.adapter.a(this.f242990a);
    }

    @Override // pxb.a
    public final txb.b getServiceManager() {
        return (txb.b) this.f242991b.getValue();
    }

    @Override // pxb.a
    public final pxb.b getSettings() {
        return new a(this.f242990a.getSettings());
    }

    public final int hashCode() {
        return System.identityHashCode(this.f242990a);
    }

    @Override // pxb.a
    public final View getView() {
        return this.f242990a;
    }

    public LarkWebViewAdapter(LarkWebView r100) {
        Intrinsics.checkNotNullParameter(r100, "larkWebView");
        this.f242990a = r100;
        this.f242991b = LazyKt.lazy(new LarkWebViewAdapter$serviceManagerImpl$2(this));
    }

    @Override // pxb.a
    public final void b(Object r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        Intrinsics.checkNotNullParameter("LarkNativeComponentConfig", "name");
        this.f242990a.addJavascriptInterface(r100, "LarkNativeComponentConfig");
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        LarkWebView r101 = null;
        if ((r100 instanceof LarkWebViewAdapter) == false) goto L8;
        LarkWebViewAdapter r102 = (LarkWebViewAdapter) r100;
    L9:
        if (r102 == null) goto L12;
        r101 = r102.f242990a;
    L12:
        if (r101 == this.f242990a) goto L16;
        return false;
    L16:
        return true;
    L8:
        r102 = null;
        goto L9
    }

    @Override // pxb.a
    public final void a(String r100, AbstractNativeComponent.a.C3474a r101) {
        Intrinsics.checkNotNullParameter(r100, "script");
        c r102 = new c(r101);
        this.f242990a.evaluateJavascript(r100, r102);
    }
}
