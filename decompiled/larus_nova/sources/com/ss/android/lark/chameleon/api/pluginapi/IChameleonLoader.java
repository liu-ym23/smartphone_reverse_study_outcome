package com.ss.android.lark.chameleon.api.pluginapi;

import android.webkit.WebView;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0001\u0015J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J(\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0003H&J\b\u0010\u0013\u001a\u00020\u0003H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/chameleon/api/pluginapi/IChameleonLoader;", "", "addLoadCallback", "", "cb", "Lcom/ss/android/lark/chameleon/api/pluginapi/IChameleonLoader$LoadingCallback;", "getVisible", "", "load", "url", "", "onLoadFailed", "code", "", "message", "e", "", "onLoadSuccess", "release", "reload", "removeLoadCallback", "LoadingCallback", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IChameleonLoader {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void onLoadFailed$default(IChameleonLoader r100, int r101, String r102, Throwable r103, int r104, Object r105) {
            if (r105 != null) goto L12;
            if ((r104 & 2) == 0) goto L7;
            r102 = null;
        L7:
            if ((r104 & 4) == 0) goto L9;
            r103 = null;
        L9:
            r100.onLoadFailed(r101, r102, r103);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onLoadFailed");
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0017J\b\u0010\n\u001a\u00020\u0003H\u0017J\b\u0010\u000b\u001a\u00020\u0003H\u0017J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0017J\u001c\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0017J\b\u0010\u0012\u001a\u00020\u0003H\u0017¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/chameleon/api/pluginapi/IChameleonLoader$LoadingCallback;", "", "onLoadFail", "", "code", "", "message", "", "e", "", "onLoadStart", "onLoadSuccess", "onPageStarted", "url", "onReceivedTitle", "view", "Landroid/webkit/WebView;", "title", "onRenderProcessGone", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface LoadingCallback {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class DefaultImpls {
            public static void onLoadFail(LoadingCallback r100, int r101, String r102, Throwable r103) {
            }

            public static void onLoadStart(LoadingCallback r100) {
            }

            public static void onLoadSuccess(LoadingCallback r100) {
            }

            public static void onPageStarted(LoadingCallback r100, String r101) {
            }

            public static void onReceivedTitle(LoadingCallback r100, WebView r101, String r102) {
            }

            public static void onRenderProcessGone(LoadingCallback r100) {
            }
        }

        void onLoadFail(int r100, String r101, Throwable r102);

        void onLoadStart();

        void onLoadSuccess();

        void onPageStarted(String r100);

        void onReceivedTitle(WebView r100, String r101);

        void onRenderProcessGone();
    }

    void addLoadCallback(LoadingCallback r100);

    boolean getVisible();

    void load(String r100);

    void onLoadFailed(int r100, String r101, Throwable r102);

    void onLoadSuccess();

    void release();

    void reload();

    void removeLoadCallback(LoadingCallback r100);
}
