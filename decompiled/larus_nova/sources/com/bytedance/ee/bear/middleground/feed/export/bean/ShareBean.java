package com.bytedance.ee.bear.middleground.feed.export.bean;

import com.bytedance.ee.util.io.NonProguard;
import java.util.Objects;

/* JADX INFO: loaded from: classes18.dex */
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
    public boolean contentSame2(ShareBean r100) {
        if (Objects.equals(this.content, r100.content) == true) goto L5;
    L9:
        return false;
    L5:
        if (Objects.equals(this.avatarUrl, r100.avatarUrl) == false) goto L9;
        if (this.readStatus != r100.readStatus) goto L9;
        return true;
    }

    /* JADX INFO: renamed from: isSameItem, reason: avoid collision after fix types in other method */
    public boolean isSameItem2(ShareBean r100) {
        return Objects.equals(this.messageId, r100.messageId);
    }

    public void setContent(String r100) {
        this.content = r100;
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.d
    public /* bridge */ /* synthetic */ boolean contentSame(ShareBean r100) {
        return contentSame2(r100);
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.d
    public /* bridge */ /* synthetic */ boolean isSameItem(ShareBean r100) {
        return isSameItem2(r100);
    }
}
