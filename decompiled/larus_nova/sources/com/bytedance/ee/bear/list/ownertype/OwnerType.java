package com.bytedance.ee.bear.list.ownertype;

import com.bytedance.ee.bear.contract.Result;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/list/ownertype/OwnerType;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", "ownerType", "", "<init>", "(I)V", "getOwnerType", "()I", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OwnerType extends Result<Serializable> {
    private final int ownerType;

    public final int getOwnerType() {
        return this.ownerType;
    }

    public OwnerType(int r100) {
        this.ownerType = r100;
    }
}
