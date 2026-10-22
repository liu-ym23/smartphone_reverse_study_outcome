package com.bytedance.common.util;

import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes15.dex */
public class LollipopV21Compat {
    private static BaseImpl mImpl;

    /* JADX INFO: renamed from: com.bytedance.common.util.LollipopV21Compat$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class BaseImpl {
        private BaseImpl() {
        }

        public void setAcceptThirdPartyCookies(WebView r100, boolean r101) {
            throw null;
        }

        public void setMixedContentMode(WebSettings r100, int r101) {
            throw null;
        }

        public /* synthetic */ BaseImpl(AnonymousClass1 r100) {
            this();
        }
    }

    public static class LollipopImpl extends BaseImpl {
        private LollipopImpl() {
            super(null);
        }

        public /* synthetic */ LollipopImpl(AnonymousClass1 r100) {
            this();
        }

        @Override // com.bytedance.common.util.LollipopV21Compat.BaseImpl
        public void setAcceptThirdPartyCookies(WebView r100, boolean r101) {
            if (r100 == null) goto L10;
            CookieManager.getInstance().setAcceptThirdPartyCookies(r100, r101);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        @Override // com.bytedance.common.util.LollipopV21Compat.BaseImpl
        public void setMixedContentMode(WebSettings r100, int r101) {
            if (r100 == null) goto L10;
            r100.setMixedContentMode(r101);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
            return;
        }
    }

    static {
        mImpl = new LollipopImpl(null);
    }

    public static void setAcceptThirdPartyCookies(WebView r100, boolean r101) {
        mImpl.setAcceptThirdPartyCookies(r100, r101);
    }

    public static void setMixedContentMode(WebSettings r100, int r101) {
        mImpl.setMixedContentMode(r100, r101);
    }
}
