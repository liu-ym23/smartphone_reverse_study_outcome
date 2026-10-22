package com.bytedance.ee.bear.middleground.feed.view.adapter;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements Runnable {
    public final /* synthetic */ FeedItemComment a;
    public final /* synthetic */ FeedItemComment.FeedCommentViewHolder b;

    public c(FeedItemComment r1, FeedItemComment.FeedCommentViewHolder r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        FeedItemComment r0 = this.a;
        BearLottieView r1 = this.b.c;
        r0.getClass();
        if (r1.getVisibility() == 0) goto L5;
        Object r2 = r1.getParent();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.view.View");
        ((View) r2).setTouchDelegate(null);
        return;
    L5:
        Rect r3 = new Rect();
        r1.getHitRect(r3);
        Object r4 = r1.getParent();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.view.View");
        ((View) r4).setTouchDelegate(new TouchDelegate(new Rect(r3.left - 200, r3.top - 30, r3.right + 200, r3.bottom + 200), r1));
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
