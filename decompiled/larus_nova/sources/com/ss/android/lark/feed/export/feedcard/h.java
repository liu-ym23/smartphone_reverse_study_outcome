package com.ss.android.lark.feed.export.feedcard;

import android.view.View;
import com.ss.android.lark.feed.app.entity.UIFeedCard;

/* JADX INFO: loaded from: classes35.dex */
public interface h {
    a a(View r100);

    void b(View r100, UIFeedCard r101, c r102, d r103);

    void c();

    void onViewAttachedToWindow();

    void onViewDetachedFromWindow();

    void onViewRecycled();
}
