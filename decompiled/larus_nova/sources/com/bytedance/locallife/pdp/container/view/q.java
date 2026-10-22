package com.bytedance.locallife.pdp.container.view;

import android.view.ViewTreeObserver;
import com.bytedance.locallife.dito.core.BaseDitoView;

/* JADX INFO: loaded from: classes21.dex */
public final class q implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseDitoView<?> f261350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f261351b;

    public q(BaseDitoView<?> r100, o r101) {
        this.f261350a = r100;
        this.f261351b = r101;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int[] r100 = new int[2];
        this.f261350a.getLocationOnScreen(r100);
        int r101 = r100[0];
        int r102 = r100[1];
        o r103 = this.f261351b;
        r103.f261342g = r101;
        r103.f261343h = r102;
    }
}
