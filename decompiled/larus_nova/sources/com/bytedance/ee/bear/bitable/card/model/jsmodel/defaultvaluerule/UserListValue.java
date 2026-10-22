package com.bytedance.ee.bear.bitable.card.model.jsmodel.defaultvaluerule;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/defaultvaluerule/UserListValue;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "list", "", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/defaultvaluerule/UserDefaultValueRule;", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserListValue implements NonProguard {
    private List<UserDefaultValueRule> list;

    public UserListValue() {
    }

    public final List<UserDefaultValueRule> getList() {
        return this.list;
    }

    public final void setList(List<UserDefaultValueRule> r100) {
        this.list = r100;
    }
}
