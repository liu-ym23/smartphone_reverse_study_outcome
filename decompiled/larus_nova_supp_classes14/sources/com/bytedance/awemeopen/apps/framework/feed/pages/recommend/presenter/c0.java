package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter;

import android.app.Activity;
import android.app.Application;
import android.view.ViewTreeObserver;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c0 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final int a;
    public final /* synthetic */ VideoFeedPlayerPresenter b;
    public final /* synthetic */ Ref.BooleanRef c;
    public final /* synthetic */ Runnable d;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int r0 = this.b.j.getWidth();
        if (r0 != this.a) goto L9;
        if (r0 > 0) goto L6;
        return;
    L6:
        if (this.c.element == true) goto L11;
        this.d.run();
        this.b.j.getVideoViewWrapper().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        return;
    L11:
        return;
    }

    public c0(VideoFeedPlayerPresenter r1, Ref.BooleanRef r2, a0 r3) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        Activity r4 = r1.e.getActivity();
        if (r4 == null) goto L5;
        Application r5 = r4.getApplication();
    L6:
        this.a = com.bytedance.awemeopen.apps.framework.utils.d0.d(r5);
        return;
    L5:
        r5 = null;
        goto L6
    }
}
