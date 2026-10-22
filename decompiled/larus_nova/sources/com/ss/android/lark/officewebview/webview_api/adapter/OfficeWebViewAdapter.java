package com.ss.android.lark.officewebview.webview_api.adapter;

import android.view.View;
import android.webkit.WebSettings;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.ee.lark.component.AbstractNativeComponent;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeWebViewAdapter implements pxb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OfficeWebView f437564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f437565b;

    public static final class a implements pxb.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WebSettings f437566a;

        @Override // pxb.b
        public final boolean a() {
            return this.f437566a.getJavaScriptEnabled();
        }

        public a(WebSettings r100) {
            Intrinsics.checkNotNullParameter(r100, "webSettings");
            this.f437566a = r100;
        }
    }

    @Override // pxb.a
    public final void c() {
        Intrinsics.checkNotNullParameter("LarkNativeComponentConfig", "name");
        this.f437564a.removeJavascriptInterface("LarkNativeComponentConfig");
    }

    @Override // pxb.a
    public final qxb.b getBridge() {
        return new com.ss.android.lark.officewebview.webview_api.adapter.a(this.f437564a);
    }

    @Override // pxb.a
    public final txb.b getServiceManager() {
        return (txb.b) this.f437565b.getValue();
    }

    @Override // pxb.a
    public final pxb.b getSettings() {
        return new a(this.f437564a.getSettings());
    }

    public final int hashCode() {
        return System.identityHashCode(this.f437564a);
    }

    @Override // pxb.a
    public final View getView() {
        return this.f437564a;
    }

    public OfficeWebViewAdapter(OfficeWebView r100) {
        Intrinsics.checkNotNullParameter(r100, "officeWebView");
        this.f437564a = r100;
        this.f437565b = LazyKt.lazy(new OfficeWebViewAdapter$serviceManagerImpl$2(this));
    }

    @Override // pxb.a
    public final void b(Object r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        Intrinsics.checkNotNullParameter("LarkNativeComponentConfig", "name");
        this.f437564a.addJavascriptInterface(r100, "LarkNativeComponentConfig");
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        OfficeWebView r101 = null;
        if ((r100 instanceof OfficeWebViewAdapter) == false) goto L8;
        OfficeWebViewAdapter r102 = (OfficeWebViewAdapter) r100;
    L9:
        if (r102 == null) goto L12;
        r101 = r102.f437564a;
    L12:
        if (r101 == this.f437564a) goto L16;
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
        this.f437564a.evaluateJavascript(r100, r102);
    }
}
