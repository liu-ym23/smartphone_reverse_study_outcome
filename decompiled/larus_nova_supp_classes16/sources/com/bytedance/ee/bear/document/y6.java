package com.bytedance.ee.bear.document;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class y6 extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ a7 a;

    public y6(a7 r1) {
        this.a = r1;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent r4) {
        Fragment r0 = this.a.a.getActivity().getSupportFragmentManager().findFragmentById(2131369388);
        if ((r0 instanceof WebViewFragment) == false) goto L9;
        b5 r1 = ((WebViewFragment) r0).k;
        if (r1 == null) goto L11;
        WebView r2 = r1.getWebView();
        if (r2 == null) goto L11;
        r2.flingScroll(0, 0);
        r2.scrollTo(0, 0);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).v("document_scroll_to_top", new HashMap());
    L11:
        return super.onDoubleTap(r4);
    L9:
        tt5.a.k("SimpleTitleBar", "scrollToTop FAIL");
        goto L11
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent r1) {
        return super.onSingleTapConfirmed(r1);
    }
}
