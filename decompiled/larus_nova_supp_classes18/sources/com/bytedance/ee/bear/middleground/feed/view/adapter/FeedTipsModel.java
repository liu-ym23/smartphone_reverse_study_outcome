package com.bytedance.ee.bear.middleground.feed.view.adapter;

import com.bytedance.ee.bear.middleground.feed.export.bean.MultiBean;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0000H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/middleground/feed/view/adapter/FeedTipsModel;", "Lcom/bytedance/ee/bear/middleground/feed/export/bean/MultiBean;", "Lcom/bytedance/ee/bear/middleground/feed/export/bean/IDiff;", "ts", "", "<init>", "(J)V", "getTs", "()J", "getAdapterType", "Ljava/lang/Class;", "isSameItem", "", "t2", "contentSame", "middleground-feed_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedTipsModel implements MultiBean, com.bytedance.ee.bear.middleground.feed.export.bean.d<FeedTipsModel> {
    private final long ts;

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.MultiBean
    public Class<?> getAdapterType() {
        return FeedTipsModel.class;
    }

    public final long getTs() {
        return this.ts;
    }

    public FeedTipsModel(long r1) {
        this.ts = r1;
    }

    /* JADX INFO: renamed from: contentSame, reason: avoid collision after fix types in other method */
    public boolean contentSame2(FeedTipsModel r5) {
        if (r5 != null) goto L4;
    L6:
        return false;
    L4:
        if (r5.ts != this.ts) goto L6;
        return true;
    }

    /* JADX INFO: renamed from: isSameItem, reason: avoid collision after fix types in other method */
    public boolean isSameItem2(FeedTipsModel r5) {
        if (r5 != null) goto L4;
    L6:
        return false;
    L4:
        if (r5.ts != this.ts) goto L6;
        return true;
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.d
    public /* bridge */ /* synthetic */ boolean contentSame(FeedTipsModel r1) {
        return contentSame2(r1);
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.d
    public /* bridge */ /* synthetic */ boolean isSameItem(FeedTipsModel r1) {
        return isSameItem2(r1);
    }
}
