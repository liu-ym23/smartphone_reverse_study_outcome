package com.ss.android.lark.todo.impl.rustadapter.push.entity;

import com.bytedance.lark.pb.todo.v1.ChangedTodoCollection;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/todo/impl/rustadapter/push/entity/TodoChangeNotificationUnit;", "Ljava/io/Serializable;", "changedTodoCollection", "Lcom/bytedance/lark/pb/todo/v1/ChangedTodoCollection;", "isRefreshAll", "", "<init>", "(Lcom/bytedance/lark/pb/todo/v1/ChangedTodoCollection;Z)V", "getChangedTodoCollection", "()Lcom/bytedance/lark/pb/todo/v1/ChangedTodoCollection;", "setChangedTodoCollection", "(Lcom/bytedance/lark/pb/todo/v1/ChangedTodoCollection;)V", "()Z", "setRefreshAll", "(Z)V", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TodoChangeNotificationUnit implements Serializable {
    private ChangedTodoCollection changedTodoCollection;
    private boolean isRefreshAll;

    public static /* synthetic */ TodoChangeNotificationUnit copy$default(TodoChangeNotificationUnit r100, ChangedTodoCollection r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.changedTodoCollection;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.isRefreshAll;
    L9:
        return r100.copy(r101, r102);
    }

    public final ChangedTodoCollection component1() {
        return this.changedTodoCollection;
    }

    public final boolean component2() {
        return this.isRefreshAll;
    }

    public final TodoChangeNotificationUnit copy(ChangedTodoCollection r100, boolean r101) {
        return new TodoChangeNotificationUnit(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TodoChangeNotificationUnit) == true) goto L8;
        return false;
    L8:
        TodoChangeNotificationUnit r101 = (TodoChangeNotificationUnit) r100;
        if (Intrinsics.areEqual(this.changedTodoCollection, r101.changedTodoCollection) == true) goto L12;
        return false;
    L12:
        if (this.isRefreshAll == r101.isRefreshAll) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        ChangedTodoCollection r100 = this.changedTodoCollection;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        if (this.isRefreshAll == false) goto L9;
        int r103 = 1231;
    L11:
        return r102 + r103;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "TodoChangeNotificationUnit(changedTodoCollection=" + this.changedTodoCollection + ", isRefreshAll=" + this.isRefreshAll + ')';
    }

    public final ChangedTodoCollection getChangedTodoCollection() {
        return this.changedTodoCollection;
    }

    public final boolean isRefreshAll() {
        return this.isRefreshAll;
    }

    public final void setChangedTodoCollection(ChangedTodoCollection r100) {
        this.changedTodoCollection = r100;
    }

    public final void setRefreshAll(boolean r100) {
        this.isRefreshAll = r100;
    }

    public TodoChangeNotificationUnit(ChangedTodoCollection r100, boolean r101) {
        this.changedTodoCollection = r100;
        this.isRefreshAll = r101;
    }
}
