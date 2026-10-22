package com.bytedance.ee.bear.middleground.feed.export.bean;

import com.bytedance.ee.util.io.NonProguard;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class AtBean extends AbsBaseBean implements NonProguard, d<AtBean> {
    private String atId;
    private String content;

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.MultiBean
    public Class getAdapterType() {
        return getClass();
    }

    public AtBean() {
    }

    public String getAtId() {
        return this.atId;
    }

    public String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: contentSame, reason: avoid collision after fix types in other method */
    public boolean contentSame2(AtBean r3) {
        if (Objects.equals(this.content, r3.content) == true) goto L5;
    L9:
        return false;
    L5:
        if (Objects.equals(this.avatarUrl, r3.avatarUrl) == false) goto L9;
        if (this.readStatus != r3.readStatus) goto L9;
        return true;
    }

    /* JADX INFO: renamed from: isSameItem, reason: avoid collision after fix types in other method */
    public boolean isSameItem2(AtBean r2) {
        return Objects.equals(this.messageId, r2.messageId);
    }

    public void setAtId(String r1) {
        this.atId = r1;
    }

    public void setContent(String r1) {
        this.content = r1;
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.d
    public /* bridge */ /* synthetic */ boolean contentSame(AtBean r1) {
        return contentSame2(r1);
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.d
    public /* bridge */ /* synthetic */ boolean isSameItem(AtBean r1) {
        return isSameItem2(r1);
    }
}
