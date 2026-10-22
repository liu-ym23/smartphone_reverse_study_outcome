package com.larus.commercecredit.impl.page;

import android.webkit.WebView;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes26.dex */
public final class t implements zt8.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommerceCreditWebFragment f325787a;

    public t(CommerceCreditWebFragment r100) {
        this.f325787a = r100;
    }

    @Override // zt8.c
    public final void c(WebView r100) {
        this.f325787a.f325736g = r100;
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("onViewCreated webView=");
        if (r100 == null) goto L5;
        boolean r103 = true;
    L6:
        r102.append(r103);
        r101.d("CommerceCreditWebFragment", r102.toString());
        return;
    L5:
        r103 = false;
        goto L6
    }

    @Override // zt8.c
    public final void a(int r100, int r101, boolean r102, boolean r103) {
        FLogger.f375446a.d("CommerceCreditWebFragment", "onOverScrolled scrollX=" + r100 + " scrollY=" + r101 + " clampedX=" + r102 + " clampedY=" + r103);
    }

    @Override // zt8.c
    public final void onScrollChanged(int r100, int r101, int r102, int r103) {
        FLogger.f375446a.d("CommerceCreditWebFragment", "onScrollChanged l=" + r100 + " t=" + r101 + " oldl=" + r102 + " oldt=" + r103);
    }

    @Override // zt8.c
    public final void b(int r100, int r101, int r102, int r103, int r104, int r105, int r110, int r111) {
        if (r100 != 0) goto L7;
        if (r101 >= 0) goto L7;
        WebView r106 = this.f325787a.f325736g;
        if (r106 == null) goto L7;
        r106.setTag(R.id.tag_web_view_scroll_top, Boolean.TRUE);
    L7:
        FLogger.f375446a.d("CommerceCreditWebFragment", "overScrollBy deltaX=" + r100 + " deltaY=" + r101 + " scrollX=" + r102 + " scrollY=" + r103 + " scrollRangeX=" + r104 + " scrollRangeY=" + r105 + " maxOverScrollX=" + r110 + " maxOverScrollY=" + r111);
    }
}
