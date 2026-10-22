package com.ss.android.lark.feed.export.feedcard;

import android.content.Context;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.cardcomponent.bottomaction.FeedCardButtonsComponent;
import com.ss.android.lark.feed.shared.data.preview.ChatFeedPreview;
import com.ss.android.lark.feed.shared.data.preview.FeedPreview;

/* JADX INFO: loaded from: classes35.dex */
public interface c {
    xdb.a.b a(UIFeedCard r100);

    FeedCardButtonsComponent.c b(ChatFeedPreview r100, d r101);

    com.ss.android.lark.feed.cardcomponent.preview.c c(FeedPreview r100);

    com.ss.android.lark.feed.cardcomponent.preview.a.b d(Context r100, UIFeedCard r101);

    com.ss.android.lark.feed.cardcomponent.preview.e.b e(UIFeedCard r100);
}
