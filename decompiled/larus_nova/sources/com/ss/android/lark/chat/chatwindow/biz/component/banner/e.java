package com.ss.android.lark.chat.chatwindow.biz.component.banner;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes35.dex */
public final class e implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseBannerComponent f411980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f411981b;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.f411980a.E0().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        a r100 = this.f411980a.f411966n;
        if (r100 == null) goto L6;
        r100.a(this.f411981b);
        return;
    }

    public e(BaseBannerComponent r100) {
        this.f411980a = r100;
        this.f411981b = 2048;
    }
}
