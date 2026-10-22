package com.bytedance.ee.bear.bitable.pro.accessconfig;

import com.bytedance.ee.util.io.NonProguard;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\u0006H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/accessconfig/DefaultMemberExtraInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "<init>", "()V", "extraMemberNumber", "", "getExtraMemberNumber", "()I", "setExtraMemberNumber", "(I)V", "getItemType", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultMemberExtraInfo implements NonProguard, MultiItemEntity {
    private int extraMemberNumber;

    public DefaultMemberExtraInfo() {
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return 2;
    }

    public final int getExtraMemberNumber() {
        return this.extraMemberNumber;
    }

    public final void setExtraMemberNumber(int r100) {
        this.extraMemberNumber = r100;
    }
}
