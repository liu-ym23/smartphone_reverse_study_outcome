package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.web;

import android.graphics.Bitmap;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes37.dex */
public final class m extends com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MmSummaryWebHelper f435391b;

    public m(MmSummaryWebHelper r100, com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web.e r101) {
        this.f435391b = r100;
        super(r101);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r100, String r101) {
        super.onPageFinished(r100, r101);
        lvb.a.e(this.f435391b.f435368d, "[onPageFinished]");
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView r100, String r101, Bitmap r102) {
        MmSummaryWebHelper r103 = this.f435391b;
        if (r103.f435371g == false) goto L6;
        lvb.a.h(r103.f435368d, "[onPageStarted] ignored after webReady, url=" + r101);
        return;
    L6:
        lvb.a.e(r103.f435368d, "[onPageStarted]");
        MmSummaryWebHelper r104 = this.f435391b;
        r104.f435371g = false;
        r104.f435372h = false;
        r104.f435366b.d();
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView r100, WebResourceRequest r101, WebResourceError r102) {
        super.onReceivedError(r100, r101, r102);
        String r103 = this.f435391b.f435368d;
        StringBuilder r104 = new StringBuilder("[onReceivedError] error=");
        r104.append(r102);
        r104.append(", isForMainFrame=");
        if (r101 == null) goto L5;
        Boolean r105 = Boolean.valueOf(r101.isForMainFrame());
    L6:
        r104.append(r105);
        lvb.a.b(r103, r104.toString());
        boolean r106 = false;
        if (r101 != null) goto L9;
    L11:
        if (r106 == false) goto L14;
        lvb.a.b(this.f435391b.f435368d, "[onReceivedError] onWebLoadFailed");
        MmSummaryWebHelper r107 = this.f435391b;
        r107.f435372h = true;
        r107.f435366b.f();
        return;
    L14:
        return;
    L9:
        if (r101.isForMainFrame() != true) goto L11;
        r106 = true;
        goto L11
    L5:
        r105 = null;
        goto L6
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView r100, WebResourceRequest r101, WebResourceResponse r102) {
        super.onReceivedHttpError(r100, r101, r102);
        String r103 = this.f435391b.f435368d;
        StringBuilder r104 = new StringBuilder("[onReceivedHttpError] error=");
        Integer r105 = null;
        if (r102 == null) goto L5;
        String r106 = r102.getReasonPhrase();
    L6:
        r104.append(r106);
        r104.append(", isForMainFrame=");
        if (r101 == null) goto L9;
        Boolean r107 = Boolean.valueOf(r101.isForMainFrame());
    L10:
        r104.append(r107);
        lvb.a.b(r103, r104.toString());
        boolean r108 = false;
        if (r101 != null) goto L13;
    L15:
        if (r108 == false) goto L23;
        if (r102 == null) goto L18;
        r105 = Integer.valueOf(r102.getStatusCode());
    L18:
        if (r105 != null) goto L20;
        return;
    L20:
        if (r105.intValue() < 400) goto L25;
        lvb.a.b(this.f435391b.f435368d, "[onReceivedHttpError] statusCode=" + r105 + ", onWebLoadFailed");
        MmSummaryWebHelper r109 = this.f435391b;
        r109.f435372h = true;
        r109.f435366b.f();
        return;
    L25:
        return;
    L23:
        return;
    L13:
        if (r101.isForMainFrame() != true) goto L15;
        r108 = true;
        goto L15
    L9:
        r107 = null;
        goto L10
    L5:
        r106 = null;
        goto L6
    }
}
