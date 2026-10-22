package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.holder;

import android.view.MotionEvent;
import nz3.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements g {
    public final /* synthetic */ PhotoFeedViewHolder a;

    public d(PhotoFeedViewHolder r1) {
        this.a = r1;
    }

    @Override // nz3.g
    public final boolean onTouchEvent(MotionEvent r2) {
        return this.a.m.f.dispatchTouchEvent(r2);
    }
}
