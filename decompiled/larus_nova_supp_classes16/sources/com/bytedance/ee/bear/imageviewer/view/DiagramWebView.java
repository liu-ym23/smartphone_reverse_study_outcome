package com.bytedance.ee.bear.imageviewer.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.bytedance.ee.bear.widgets.RotateLoadingView;
import com.bytedance.ee.util.ui.j;
import com.bytedance.ee.util.ui.n;
import gb5.c;
import gb5.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DiagramWebView extends WebView {
    public static final /* synthetic */ int e = 0;
    public View.OnClickListener a;
    public GestureDetector b;
    public e c;
    public boolean d;

    public DiagramWebView(Context r2) {
        this(r2, null);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent r2) {
        this.b.onTouchEvent(r2);
        if (this.d == true) goto L5;
        return true;
    L5:
        return super.onTouchEvent(r2);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r1) {
        this.a = r1;
    }

    public DiagramWebView(Context r2, AttributeSet r3) {
        this(r2, null, 0);
    }

    public DiagramWebView(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        this.d = false;
        getSettings().setJavaScriptEnabled(true);
        getSettings().setSupportZoom(true);
        getSettings().setBuiltInZoomControls(true);
        getSettings().setDisplayZoomControls(false);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().setUseWideViewPort(true);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setWebChromeClient(new WebChromeClient());
        setBackgroundColor(getResources().getColor(2131103451));
        RelativeLayout r6 = new RelativeLayout(getContext());
        View r7 = new RotateLoadingView(getContext());
        RelativeLayout.LayoutParams r8 = new RelativeLayout.LayoutParams(n.d(42), n.d(42));
        r8.addRule(13);
        r6.addView(r7, r8);
        addView(r6, new ViewGroup.LayoutParams(-1, -1));
        e r9 = new e(r6);
        this.c = r9;
        tt5.a.h("LazyLoadingHelper", "showLoading");
        j.e(r9.b);
        j.e(r9.c);
        j.d(r9.b, 250);
        this.b = new GestureDetector(getContext(), new c(this));
    }
}
