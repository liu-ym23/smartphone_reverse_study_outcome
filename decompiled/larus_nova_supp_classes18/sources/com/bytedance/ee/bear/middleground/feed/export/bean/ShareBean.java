package com.bytedance.ee.bear.middleground.feed.export.bean;

import com.bytedance.ee.util.io.NonProguard;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ShareBean extends AbsBaseBean implements NonProguard, d<ShareBean> {
    private String content;

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.MultiBean
    public Class getAdapterType() {
        return getClass();
    }

    public ShareBean() {
    }

    public String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: contentSame, reason: avoid collision after fix types in other method */
    public boolean contentSame2(ShareBean r3) {
        if (Objects.equals(this.content, r3.content) == true) goto L5;
    L9:
        return false;
    L5:
        if (Objects.equals(this.avatarUrl, r3.avatarUrl) == false) goto L9;
        if (this.readStatus != r3.readStatus) goto L9;
        return true;
    }

    /* JADX INFO: renamed from: isSameItem, reason: avoid collision after fix types in other method */
    public boolean isSameItem2(ShareBean r2) {
        return Objects.equals(this.messageId, r2.messageId);
    }

    public void setContent(String r1) {
        this.content = r1;
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.d
    public /* bridge */ /* synthetic */ boolean contentSame(ShareBean r1) {
        return contentSame2(r1);
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.d
    public /* bridge */ /* synthetic */ boolean isSameItem(ShareBean r1) {
        return isSameItem2(r1);
    }
}
