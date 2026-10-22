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
import com.larus.nova.R;
import com.ss.android.dypay.api.DyPayConstant;
import gb5.c;
import gb5.e;

/* JADX INFO: loaded from: classes16.dex */
public class DiagramWebView extends WebView {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f227033e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View.OnClickListener f227034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public GestureDetector f227035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f227036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f227037d;

    public DiagramWebView(Context r100) {
        this(r100, null);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        this.f227035b.onTouchEvent(r100);
        if (this.f227037d == true) goto L5;
        return true;
    L5:
        return super.onTouchEvent(r100);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r100) {
        this.f227034a = r100;
    }

    public DiagramWebView(Context r100, AttributeSet r101) {
        this(r100, null, 0);
    }

    public DiagramWebView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f227037d = false;
        getSettings().setJavaScriptEnabled(true);
        getSettings().setSupportZoom(true);
        getSettings().setBuiltInZoomControls(true);
        getSettings().setDisplayZoomControls(false);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().setUseWideViewPort(true);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setWebChromeClient(new WebChromeClient());
        setBackgroundColor(getResources().getColor(R.color.lkui_N1000));
        RelativeLayout r103 = new RelativeLayout(getContext());
        RotateLoadingView r104 = new RotateLoadingView(getContext());
        RelativeLayout.LayoutParams r105 = new RelativeLayout.LayoutParams(n.d(42), n.d(42));
        r105.addRule(13);
        r103.addView(r104, r105);
        addView(r103, new ViewGroup.LayoutParams(-1, -1));
        e r106 = new e(r103);
        this.f227036c = r106;
        tt5.a.h("LazyLoadingHelper", DyPayConstant.KEY_SHOW_LOADING);
        j.e(r106.f480730b);
        j.e(r106.f480731c);
        j.d(r106.f480730b, 250);
        this.f227035b = new GestureDetector(getContext(), new c(this));
    }
}
