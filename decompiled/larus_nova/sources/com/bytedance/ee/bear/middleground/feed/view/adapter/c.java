package com.bytedance.ee.bear.middleground.feed.view.adapter;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FeedItemComment f232665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FeedItemComment.FeedCommentViewHolder f232666b;

    public c(FeedItemComment r100, FeedItemComment.FeedCommentViewHolder r101) {
        this.f232665a = r100;
        this.f232666b = r101;
    }

    public final void a() {
        FeedItemComment r100 = this.f232665a;
        BearLottieView r101 = this.f232666b.f232628c;
        r100.getClass();
        if (r101.getVisibility() == 0) goto L5;
        Object r102 = r101.getParent();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.view.View");
        ((View) r102).setTouchDelegate(null);
        return;
    L5:
        Rect r103 = new Rect();
        r101.getHitRect(r103);
        Object r104 = r101.getParent();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.view.View");
        ((View) r104).setTouchDelegate(new TouchDelegate(new Rect(r103.left - 200, r103.top - 30, r103.right + 200, r103.bottom + 200), r101));
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
