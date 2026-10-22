package ib;

import android.webkit.WebView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public interface f {

    public static class a implements f {
        public a() {
        }

        public void a(String r100, WebView r101) {
        }

        public void b(String r100, WebView r101, String r102) {
        }

        @Override // ib.f
        public void onLoadFail(String r100, WebView r101, Throwable r102) {
            Intrinsics.checkNotNullParameter(r102, "e");
        }

        @Override // ib.f
        public void onLoadStart(String r100, WebView r101) {
        }

        @Override // ib.f
        public void onLoadUriSuccess(String r100, WebView r101) {
        }
    }

    void onLoadFail(String r100, WebView r101, Throwable r102);

    void onLoadStart(String r100, WebView r101);

    void onLoadUriSuccess(String r100, WebView r101);
}
