package com.bytedance.locallife.photo.photopage.fragment;

import com.bytedance.locallife.photo.photopage.view.ScrollFlexViewPager;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScrollFlexViewPager f262204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f262205b;

    public g(ScrollFlexViewPager r100, int r101) {
        this.f262204a = r100;
        this.f262205b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f262204a.setCurrentItem(this.f262205b, false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
