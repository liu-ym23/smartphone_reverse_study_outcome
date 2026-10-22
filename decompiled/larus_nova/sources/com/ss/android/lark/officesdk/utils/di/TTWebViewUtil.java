package com.ss.android.lark.officesdk.utils.di;

import android.webkit.WebSettings;
import android.webkit.WebView;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class TTWebViewUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<otb.n> f437209a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<otb.l> f437210b = null;

    public static final class a {
        @JvmStatic
        public static otb.f b() {
            DependencyContainer r100 = DependencyContainer.f433166a;
            otb.f r101 = (otb.f) DependencyContainer.a(otb.f.class, null);
            if (r101 == null) goto L5;
            return r101;
        L5:
            return TTWebViewUtil.f437209a.getValue();
        }

        @JvmStatic
        public static otb.e a(WebView r100) {
            Intrinsics.checkNotNullParameter(r100, "webview");
            DependencyContainer r101 = DependencyContainer.f433166a;
            otb.l r102 = (otb.d) DependencyContainer.a(otb.d.class, null);
            if (r102 != null) goto L6;
            r102 = TTWebViewUtil.f437210b.getValue();
        L6:
            return r102.o(r100);
        }

        @JvmStatic
        public static boolean c(WebView r100) {
            Intrinsics.checkNotNullParameter(r100, "webview");
            b().b0(r100);
            return false;
        }

        @JvmStatic
        public static boolean d(WebView r100) {
            b().isTTWebView();
            return false;
        }

        @JvmStatic
        public static void e(WebView r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "webview");
            Intrinsics.checkNotNullParameter(r101, "bizType");
            b().q(r100, r101);
        }
    }

    static {
        f437209a = LazyKt.lazy(TTWebViewUtil$Companion$defaultWebViewDependency$2.INSTANCE);
        f437210b = LazyKt.lazy(TTWebViewUtil$Companion$defaultExtensionDependency$2.INSTANCE);
    }

    @JvmStatic
    public static final void a(WebSettings r100, int r101, WebView r102) {
        Intrinsics.checkNotNullParameter(r100, "settings");
        Intrinsics.checkNotNullParameter(r102, "webview");
        a.b().K(r100, r102);
    }

    @JvmStatic
    public static final void b(WebSettings r100, int r101, WebView r102) {
        Intrinsics.checkNotNullParameter(r100, "settings");
        Intrinsics.checkNotNullParameter(r102, "webview");
        a.b().W(r100, r102);
    }
}
