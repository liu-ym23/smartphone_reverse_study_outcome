package com.bytedance.common.util;

import android.content.Context;
import android.webkit.WebSettings;

/* JADX INFO: loaded from: classes15.dex */
public class JellyBeanMR1V17Compat {
    private static BaseImpl mImpl;

    /* JADX INFO: renamed from: com.bytedance.common.util.JellyBeanMR1V17Compat$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class BaseImpl {
        private BaseImpl() {
        }

        public String getWebViewDefaultUserAgent(Context r100) {
            throw null;
        }

        public void setMediaPlaybackRequiresUserGesture(WebSettings r100, boolean r101) {
            throw null;
        }

        public /* synthetic */ BaseImpl(AnonymousClass1 r100) {
            this();
        }
    }

    public static class V17Impl extends BaseImpl {
        private V17Impl() {
            super(null);
        }

        public /* synthetic */ V17Impl(AnonymousClass1 r100) {
            this();
        }

        @Override // com.bytedance.common.util.JellyBeanMR1V17Compat.BaseImpl
        public String getWebViewDefaultUserAgent(Context r100) {
            return WebSettings.getDefaultUserAgent(r100);
        L4:
            th = move-exception;
            th.printStackTrace();
            return null;
        }

        @Override // com.bytedance.common.util.JellyBeanMR1V17Compat.BaseImpl
        public void setMediaPlaybackRequiresUserGesture(WebSettings r100, boolean r101) {
            r100.setMediaPlaybackRequiresUserGesture(r101);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }
    }

    static {
        mImpl = new V17Impl(null);
    }

    public static String getWebViewDefaultUserAgent(Context r100) {
        return mImpl.getWebViewDefaultUserAgent(r100);
    }

    public static void setMediaPlaybackRequiresUserGesture(WebSettings r100, boolean r101) {
        mImpl.setMediaPlaybackRequiresUserGesture(r100, r101);
    }
}
