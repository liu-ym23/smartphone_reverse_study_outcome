package com.ss.android.lark.feed.export.feedcard;

import com.bytedance.lark.pb.feed.v1.FeedEntityPreview;
import com.ss.android.lark.biz.im.api.FeedPreviewInfo;
import com.ss.android.lark.feed.app.entity.UIFeedCard;

/* JADX INFO: loaded from: classes35.dex */
public interface f {
    FeedPreviewInfo a(FeedEntityPreview r100);

    UIFeedCard b(FeedPreviewInfo r100);

    boolean c(FeedEntityPreview r100);
}
