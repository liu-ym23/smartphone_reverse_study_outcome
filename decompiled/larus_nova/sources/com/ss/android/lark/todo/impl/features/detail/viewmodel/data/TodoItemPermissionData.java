package com.ss.android.lark.todo.impl.features.detail.viewmodel.data;

import com.bytedance.lark.pb.todo.v1.Commit;
import com.bytedance.lark.pb.todo.v1.TodoItemPermission;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u001b\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u0003B\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0002H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0002X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006R&\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R&\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u0011\u0010\u001e\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0017R\u0011\u0010 \u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b!\u0010\u0017R\u0011\u0010\"\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b#\u0010\u0017R\u0011\u0010$\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b%\u0010\u0017R\u0011\u0010&\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b'\u0010\u0017¨\u0006("}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/TodoItemPermissionData;", "Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/BaseData;", "Lcom/bytedance/lark/pb/todo/v1/TodoItemPermission;", "Ljava/io/Serializable;", "pbData", "<init>", "(Lcom/bytedance/lark/pb/todo/v1/TodoItemPermission;)V", "getPbData", "()Lcom/bytedance/lark/pb/todo/v1/TodoItemPermission;", "setPbData", "editMap", "", "", "", "getEditMap", "()Ljava/util/Map;", "setEditMap", "(Ljava/util/Map;)V", "readMap", "getReadMap", "setReadMap", "canRead", "getCanRead", "()Z", "setCanRead", "(Z)V", "canEdit", "getCanEdit", "setCanEdit", "parseToPb", "subTaskEditable", "getSubTaskEditable", "repeatEditable", "getRepeatEditable", "repeatReadable", "getRepeatReadable", "completeAllEditable", "getCompleteAllEditable", "completeSelfEditable", "getCompleteSelfEditable", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TodoItemPermissionData implements a<TodoItemPermission>, Serializable {
    private boolean canEdit;
    private boolean canRead;
    private Map<Integer, Boolean> editMap;
    private TodoItemPermission pbData;
    private Map<Integer, Boolean> readMap;

    @Override // com.ss.android.lark.todo.impl.features.detail.viewmodel.data.a
    public boolean isValid() {
        return true;
    }

    public void setValid(boolean r100) {
    }

    public final boolean getCompleteAllEditable() {
        Boolean r100 = this.editMap.get(Integer.valueOf(Commit.Key.TODO_COMPLETED_MILLI_TIME.getValue()));
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.booleanValue();
    }

    public final boolean getCompleteSelfEditable() {
        Boolean r100 = this.editMap.get(Integer.valueOf(Commit.Key.TODO_USERS_COMPLETED_MILLI_TIME.getValue()));
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.booleanValue();
    }

    public final boolean getRepeatEditable() {
        Boolean r100 = this.editMap.get(Integer.valueOf(Commit.Key.TODO_RRULE.getValue()));
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.booleanValue();
    }

    public final boolean getRepeatReadable() {
        Boolean r100 = this.readMap.get(Integer.valueOf(Commit.Key.TODO_RRULE.getValue()));
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.booleanValue();
    }

    public final boolean getSubTaskEditable() {
        Boolean r100 = this.editMap.get(Integer.valueOf(Commit.Key.TODO_SUB_TASK.getValue()));
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.booleanValue();
    }

    /* JADX INFO: renamed from: getPbData, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8688getPbData() {
        return getPbData();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ss.android.lark.todo.impl.features.detail.viewmodel.data.a
    public TodoItemPermission parseToPb() {
        return getPbData();
    }

    public final boolean getCanEdit() {
        return this.canEdit;
    }

    public final boolean getCanRead() {
        return this.canRead;
    }

    public final Map<Integer, Boolean> getEditMap() {
        return this.editMap;
    }

    public final Map<Integer, Boolean> getReadMap() {
        return this.readMap;
    }

    public TodoItemPermission getPbData() {
        return this.pbData;
    }

    @Override // com.ss.android.lark.todo.impl.features.detail.viewmodel.data.a
    public /* bridge */ /* synthetic */ TodoItemPermission parseToPb() {
        return parseToPb();
    }

    public TodoItemPermissionData(TodoItemPermission r100) {
        this.pbData = r100;
        TodoItemPermission r101 = getPbData();
        if (r101 == null) goto L7;
        Map<Integer, Boolean> r102 = r101.can_edit_commit_keys;
        if (r102 == null) goto L7;
    L8:
        this.editMap = r102;
        TodoItemPermission r103 = getPbData();
        if (r103 == null) goto L13;
        Map<Integer, Boolean> r104 = r103.can_read_commit_keys;
        if (r104 == null) goto L13;
    L14:
        this.readMap = r104;
        TodoItemPermission r105 = getPbData();
        boolean r106 = true;
        if (r105 == null) goto L21;
        Boolean r107 = r105.is_readable;
        if (r107 == null) goto L21;
        if (r107.booleanValue() != true) goto L21;
        boolean r108 = true;
    L22:
        this.canRead = r108;
        TodoItemPermission r109 = getPbData();
        if (r109 == null) goto L29;
        Boolean r110 = r109.is_editable;
        if (r110 == null) goto L29;
        if (r110.booleanValue() != true) goto L29;
    L30:
        this.canEdit = r106;
        return;
    L29:
        r106 = false;
    L21:
        r108 = false;
    L13:
        r104 = new HashMap();
    L7:
        r102 = new HashMap();
        goto L8
    }

    public final void setCanEdit(boolean r100) {
        this.canEdit = r100;
    }

    public final void setCanRead(boolean r100) {
        this.canRead = r100;
    }

    public final void setEditMap(Map<Integer, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.editMap = r100;
    }

    public /* bridge */ /* synthetic */ void setPbData(Object r100) {
        setPbData((TodoItemPermission) r100);
    }

    public final void setReadMap(Map<Integer, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.readMap = r100;
    }

    public void setPbData(TodoItemPermission r100) {
        this.pbData = r100;
    }
}
