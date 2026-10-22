package com.bytedance.ee.bear.bitable.common.widgets.item.extend.userlist;

import com.bytedance.ee.bear.bitable.panel.ExtendItemData;
import com.bytedance.ee.bear.bitable.panel.ExtendItemEnum;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016R.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/widgets/item/extend/userlist/UserListData;", "Lcom/bytedance/ee/bear/bitable/panel/ExtendItemData;", "<init>", "()V", "userList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/common/widgets/item/extend/userlist/User;", "Lkotlin/collections/ArrayList;", "getUserList", "()Ljava/util/ArrayList;", "setUserList", "(Ljava/util/ArrayList;)V", "getExtendItem", "Lcom/bytedance/ee/bear/bitable/panel/ExtendItemEnum;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserListData implements ExtendItemData {
    private ArrayList<User> userList;

    public UserListData() {
    }

    @Override // com.bytedance.ee.bear.bitable.panel.ExtendItemData
    public ExtendItemEnum getExtendItem() {
        return ExtendItemEnum.ITEM_DOC_USER_LIST;
    }

    public final ArrayList<User> getUserList() {
        return this.userList;
    }

    public final void setUserList(ArrayList<User> r100) {
        this.userList = r100;
    }
}
