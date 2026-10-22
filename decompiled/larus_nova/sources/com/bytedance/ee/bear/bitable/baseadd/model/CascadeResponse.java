package com.bytedance.ee.bear.bitable.baseadd.model;

import com.bytedance.ee.bear.bitable.common.model.field.OptionItem;
import com.bytedance.ee.bear.contract.Result;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\u0004\b\u0007\u0010\bR!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/baseadd/model/CascadeResponse;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", "list", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/common/model/field/OptionItem;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "getList", "()Ljava/util/ArrayList;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CascadeResponse extends Result<Serializable> {
    private final ArrayList<OptionItem> list;

    public final ArrayList<OptionItem> getList() {
        return this.list;
    }

    public CascadeResponse(ArrayList<OptionItem> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        this.list = r100;
    }
}
