package com.bytedance.ee.bear.document.titlebar;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.webkit.WebView;
import java.util.HashMap;

/* JADX INFO: loaded from: classes16.dex */
public final class b0 extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f222198a;

    public b0(d0 r100) {
        this.f222198a = r100;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent r100) {
        WebView r101 = this.f222198a.f222207a.getWebView();
        if (r101 == null) goto L6;
        r101.flingScroll(0, 0);
        r101.scrollTo(0, 0);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).v("document_scroll_to_top", new HashMap());
    L6:
        return super.onDoubleTap(r100);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent r100) {
        return super.onSingleTapConfirmed(r100);
    }
}
