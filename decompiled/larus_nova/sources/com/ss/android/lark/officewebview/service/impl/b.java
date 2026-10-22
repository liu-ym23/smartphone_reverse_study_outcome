package com.ss.android.lark.officewebview.service.impl;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officewebview.base.OfficeWebView;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements oxb.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f437515a;

    public b() {
    }

    @Override // oxb.g
    public final Bitmap C() {
        j.e("UrlQueryParameterHandleServiceImpl", "mHideVideoPoster = " + this.f437515a);
        if (this.f437515a == true) goto L5;
        return null;
    L5:
        return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
    }

    public final void P(Uri r100) {
        String r101 = UriProtector.getQueryParameter(r100, "lark_remove_video_overlay_icon");
        if (TextUtils.isEmpty(r101) == true) goto L5;
        j.e("UrlQueryParameterHandleServiceImpl", "hideVideoOverlayIcon = " + r101);
        this.f437515a = Boolean.parseBoolean(r101);
        return;
    L5:
        j.e("UrlQueryParameterHandleServiceImpl", "hideVideoOverlayIcon is empty");
        this.f437515a = false;
    }

    public static void O(Uri r100, OfficeWebView r101) {
        String r102 = UriProtector.getQueryParameter(r100, "lark_media_auto_play");
        if (TextUtils.isEmpty(r102) == true) goto L5;
        j.e("UrlQueryParameterHandleServiceImpl", "autoValue = " + r102);
        r101.getSettings().setMediaPlaybackRequiresUserGesture(Boolean.parseBoolean(r102) ^ true);
        return;
    L5:
        int r103 = com.ss.android.lark.officesdk.utils.di.g.f437223a;
        boolean r104 = com.ss.android.lark.officesdk.utils.di.g.a.a("openplatform.webbrowser.autoplaynew");
        j.e("UrlQueryParameterHandleServiceImpl", "autoState = " + r101.getSettings().getMediaPlaybackRequiresUserGesture() + " ， autoPlayFg = " + r104);
        if (r104 == false) goto L9;
        j.e("UrlQueryParameterHandleServiceImpl", "new autoPlay and flag is null ,so do nothing ");
        return;
    L9:
        j.e("UrlQueryParameterHandleServiceImpl", "autoValue is empty");
        r101.getSettings().setMediaPlaybackRequiresUserGesture(true);
    }

    @Override // oxb.g
    public final void F(String r100, OfficeWebView r101) {
        if (TextUtils.isEmpty(r100) == true) goto L15;
        if (r101 == null) goto L15;
        Uri r102 = UriProtector.parse(r100);     // Catch: Exception -> L12
        if (r102 != null) goto L10;
        j.e("UrlQueryParameterHandleServiceImpl", "url is null");     // Catch: Exception -> L12
        return;
    L10:
        O(r102, r101);     // Catch: Exception -> L12
        P(r102);     // Catch: Exception -> L12
        String r103 = UriProtector.getQueryParameter(r102, "lark_web_title_bar_show");     // Catch: Exception -> L12
        j.e("UrlQueryParameterHandleServiceImpl", "titleBarShowValue = " + r103 + " , mTitleBarShowListener = null");     // Catch: Exception -> L12
        TextUtils.isEmpty(r103);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        j.c("UrlQueryParameterHandleServiceImpl", "handle url error", e);
        return;
    L15:
        j.e("UrlQueryParameterHandleServiceImpl", "url is " + r100 + ", webview is " + r101);
    }
}
