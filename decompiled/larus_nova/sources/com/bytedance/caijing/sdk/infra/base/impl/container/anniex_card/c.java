package com.bytedance.caijing.sdk.infra.base.impl.container.anniex_card;

import android.webkit.WebView;
import ed4.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements ib.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f202481a;

    public c(l r100) {
        this.f202481a = r100;
    }

    @Override // ib.f
    public final void onLoadStart(String r100, WebView r101) {
        l r102 = this.f202481a;
        if (r102 == null) goto L6;
        r102.onLoadStart(r100, r101);
        return;
    }

    @Override // ib.f
    public final void onLoadUriSuccess(String r100, WebView r101) {
        l r102 = this.f202481a;
        if (r102 == null) goto L6;
        r102.onLoadUriSuccess(r100, r101);
        return;
    }

    @Override // ib.f
    public final void onLoadFail(String r100, WebView r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r102, "e");
        l r103 = this.f202481a;
        if (r103 == null) goto L6;
        r103.onLoadFail(r100, r101, r102);
        return;
    }
}
