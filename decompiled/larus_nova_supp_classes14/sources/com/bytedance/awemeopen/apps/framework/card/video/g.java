package com.bytedance.awemeopen.apps.framework.card.video;

import android.view.View;
import com.bytedance.awemeopen.infra.base.log.AoLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g implements View.OnLayoutChangeListener {
    public final /* synthetic */ FeedVideoItemView a;
    public final /* synthetic */ r14.c b;
    public final /* synthetic */ int c;

    public g(FeedVideoItemView r1, r14.c r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        AoLogger.b("FeedViewItemView", new Object[]{this.a.f + " parentView onLayoutChange " + FeedVideoItemView.a(this.a)});
        if (FeedVideoItemView.a(this.a) == false) goto L6;
        this.a.b.removeOnLayoutChangeListener(this);
        FeedVideoItemView.b(this.a, this.b, this.c);
        return;
    }
}
