package com.bytedance.ee.bear.document.titlebar;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.webkit.WebView;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b0 extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ d0 a;

    public b0(d0 r1) {
        this.a = r1;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent r4) {
        WebView r0 = this.a.a.getWebView();
        if (r0 == null) goto L6;
        r0.flingScroll(0, 0);
        r0.scrollTo(0, 0);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).v("document_scroll_to_top", new HashMap());
    L6:
        return super.onDoubleTap(r4);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent r1) {
        return super.onSingleTapConfirmed(r1);
    }
}
