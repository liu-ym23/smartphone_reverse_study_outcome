package com.bytedance.common.util;

import android.app.AlertDialog;
import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes15.dex */
public class HoneyCombV11Compat {

    public static class HoneyCombImpl {
        public static Context getContext(AlertDialog.Builder r100) {
            return r100.getContext();
        }

        public static void pauseWebView(WebView r100) {
            r100.onPause();
        }

        public static void resumeWebView(WebView r100) {
            r100.onResume();
        }

        public static void setDisplayZoomControl(WebSettings r100, boolean r101) {
            r100.setDisplayZoomControls(r101);
        }
    }

    public static void pauseWebView(WebView r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        HoneyCombImpl.pauseWebView(r100);
    }

    public static void resumeWebView(WebView r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        HoneyCombImpl.resumeWebView(r100);
    }

    public static Context getContext(Context r100, AlertDialog.Builder r101) {
        return HoneyCombImpl.getContext(r101);
    }

    public static void setDisplayZoomControl(WebSettings r100, boolean r101) {
        HoneyCombImpl.setDisplayZoomControl(r100, r101);
    }
}
