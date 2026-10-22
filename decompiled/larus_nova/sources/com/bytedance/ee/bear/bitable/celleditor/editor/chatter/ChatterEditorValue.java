package com.bytedance.ee.bear.bitable.celleditor.editor.chatter;

import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.GroupEntity;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.UserEntity;
import com.bytedance.ee.util.io.NonProguard;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/editor/chatter/ChatterEditorValue;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "users", "", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/UserEntity;", "getUsers", "()Ljava/util/List;", "setUsers", "(Ljava/util/List;)V", "groups", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/GroupEntity;", "getGroups", "setGroups", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatterEditorValue implements NonProguard {
    private List<? extends GroupEntity> groups;
    private List<? extends UserEntity> users;

    public ChatterEditorValue() {
    }

    public final List<GroupEntity> getGroups() {
        return this.groups;
    }

    public final List<UserEntity> getUsers() {
        return this.users;
    }

    public final void setGroups(List<? extends GroupEntity> r100) {
        this.groups = r100;
    }

    public final void setUsers(List<? extends UserEntity> r100) {
        this.users = r100;
    }
}
