package com.bytedance.ee.bear.bizwidget.diagram;

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
import sv4.a;
import sv4.b;

/* JADX INFO: loaded from: classes16.dex */
public class OfficeDiagramWebView extends WebView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View.OnClickListener f216375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public GestureDetector f216376b;

    public OfficeDiagramWebView(Context r100) {
        this(r100, null);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        this.f216376b.onTouchEvent(r100);
        return true;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r100) {
        this.f216375a = r100;
    }

    public OfficeDiagramWebView(Context r100, AttributeSet r101) {
        this(r100, null, 0);
    }

    public OfficeDiagramWebView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
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
        a r106 = new a(r103);
        tt5.a.h("LazyLoadingHelper", DyPayConstant.KEY_SHOW_LOADING);
        j.e(r106.f543661b);
        j.e(r106.f543662c);
        j.d(r106.f543661b, 250);
        this.f216376b = new GestureDetector(getContext(), new b(this));
    }
}
