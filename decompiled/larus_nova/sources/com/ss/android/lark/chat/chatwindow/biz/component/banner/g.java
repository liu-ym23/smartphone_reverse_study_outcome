package com.ss.android.lark.chat.chatwindow.biz.component.banner;

import android.view.ViewTreeObserver;
import com.ss.android.lark.flow.chat.page.flow.plugin.FlowRelationshipBanner;

/* JADX INFO: loaded from: classes35.dex */
public final class g implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseBannerComponent f411985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f411986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ wya.c f411987c;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.f411985a.E0().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        a r100 = this.f411985a.f411966n;
        if (r100 == null) goto L6;
        r100.b(this.f411986b, this.f411987c);
        return;
    }

    public g(BaseBannerComponent r100, FlowRelationshipBanner.d r101) {
        this.f411985a = r100;
        this.f411986b = 2048;
        this.f411987c = r101;
    }
}
