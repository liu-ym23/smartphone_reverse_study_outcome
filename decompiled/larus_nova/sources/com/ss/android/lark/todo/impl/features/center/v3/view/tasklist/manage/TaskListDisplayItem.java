package com.ss.android.lark.todo.impl.features.center.v3.view.tasklist.manage;

import com.bytedance.lark.pb.todo.v1.IconInfo;
import com.bytedance.lark.pb.todo.v1.TaskContainerSection;
import com.bytedance.lark.pb.todo.v1.TodoUser;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.io.Serializable;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002BU\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010+\u001a\u00020,H\u0016J\u0013\u0010-\u001a\u00020\u00072\b\u0010.\u001a\u0004\u0018\u00010/H\u0096\u0002J\b\u00100\u001a\u00020,H\u0016J\t\u00101\u001a\u00020\u0004HÆ\u0003J\t\u00102\u001a\u00020\u0004HÆ\u0003J\t\u00103\u001a\u00020\u0007HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u00107\u001a\u00020\u0007HÆ\u0003J\t\u00108\u001a\u00020\u0007HÆ\u0003Jc\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u0007HÆ\u0001J\t\u0010:\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u001a\"\u0004\b)\u0010\u001cR\u001a\u0010\u0010\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u001a\"\u0004\b*\u0010\u001c¨\u0006;"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/view/tasklist/manage/TaskListDisplayItem;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "Ljava/io/Serializable;", "taskListGuid", "", "taskListName", "taskListArchived", "", "taskListOwner", "Lcom/bytedance/lark/pb/todo/v1/TodoUser;", "taskListSections", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/lark/pb/todo/v1/TaskContainerSection;", "taskListIconInfo", "Lcom/bytedance/lark/pb/todo/v1/IconInfo;", "isFirstItem", "isLastItem", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLcom/bytedance/lark/pb/todo/v1/TodoUser;Ljava/util/concurrent/CopyOnWriteArrayList;Lcom/bytedance/lark/pb/todo/v1/IconInfo;ZZ)V", "getTaskListGuid", "()Ljava/lang/String;", "setTaskListGuid", "(Ljava/lang/String;)V", "getTaskListName", "setTaskListName", "getTaskListArchived", "()Z", "setTaskListArchived", "(Z)V", "getTaskListOwner", "()Lcom/bytedance/lark/pb/todo/v1/TodoUser;", "setTaskListOwner", "(Lcom/bytedance/lark/pb/todo/v1/TodoUser;)V", "getTaskListSections", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "setTaskListSections", "(Ljava/util/concurrent/CopyOnWriteArrayList;)V", "getTaskListIconInfo", "()Lcom/bytedance/lark/pb/todo/v1/IconInfo;", "setTaskListIconInfo", "(Lcom/bytedance/lark/pb/todo/v1/IconInfo;)V", "setFirstItem", "setLastItem", "getItemType", "", "equals", "other", "", "hashCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "toString", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskListDisplayItem implements MultiItemEntity, Serializable {
    private boolean isFirstItem;
    private boolean isLastItem;
    private boolean taskListArchived;
    private String taskListGuid;
    private IconInfo taskListIconInfo;
    private String taskListName;
    private TodoUser taskListOwner;
    private CopyOnWriteArrayList<TaskContainerSection> taskListSections;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TaskListDisplayItem copy$default(TaskListDisplayItem r100, String r110, String r111, boolean r112, TodoUser r113, CopyOnWriteArrayList r114, IconInfo r115, boolean r116, boolean r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.taskListGuid;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.taskListName;
    L11:
        if ((r118 & 4) == 0) goto L13;
        boolean r103 = r100.taskListArchived;
    L15:
        if ((r118 & 8) == 0) goto L17;
        TodoUser r104 = r100.taskListOwner;
    L19:
        if ((r118 & 16) == 0) goto L21;
        CopyOnWriteArrayList r105 = r100.taskListSections;
    L23:
        if ((r118 & 32) == 0) goto L25;
        IconInfo r106 = r100.taskListIconInfo;
    L27:
        if ((r118 & 64) == 0) goto L29;
        boolean r107 = r100.isFirstItem;
    L31:
        if ((r118 & 128) == 0) goto L33;
        boolean r108 = r100.isLastItem;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final String component1() {
        return this.taskListGuid;
    }

    public final String component2() {
        return this.taskListName;
    }

    public final boolean component3() {
        return this.taskListArchived;
    }

    public final TodoUser component4() {
        return this.taskListOwner;
    }

    public final CopyOnWriteArrayList<TaskContainerSection> component5() {
        return this.taskListSections;
    }

    public final IconInfo component6() {
        return this.taskListIconInfo;
    }

    public final boolean component7() {
        return this.isFirstItem;
    }

    public final boolean component8() {
        return this.isLastItem;
    }

    public final TaskListDisplayItem copy(String r110, String r111, boolean r112, TodoUser r113, CopyOnWriteArrayList<TaskContainerSection> r114, IconInfo r115, boolean r116, boolean r117) {
        Intrinsics.checkNotNullParameter(r110, "taskListGuid");
        Intrinsics.checkNotNullParameter(r111, "taskListName");
        Intrinsics.checkNotNullParameter(r114, "taskListSections");
        return new TaskListDisplayItem(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return 4;
    }

    public String toString() {
        return "TaskListDisplayItem(taskListGuid=" + this.taskListGuid + ", taskListName=" + this.taskListName + ", taskListArchived=" + this.taskListArchived + ", taskListOwner=" + this.taskListOwner + ", taskListSections=" + this.taskListSections + ", taskListIconInfo=" + this.taskListIconInfo + ", isFirstItem=" + this.isFirstItem + ", isLastItem=" + this.isLastItem + ')';
    }

    public int hashCode() {
        int r100 = ((this.taskListGuid.hashCode() * 31) + this.taskListName.hashCode()) * 31;
        int r101 = 1231;
        if (this.taskListArchived == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        TodoUser r104 = this.taskListOwner;
        int r105 = 0;
        if (r104 == null) goto L9;
        int r106 = r104.hashCode();
    L10:
        int r107 = (((r103 + r106) * 31) + this.taskListSections.hashCode()) * 31;
        IconInfo r108 = this.taskListIconInfo;
        if (r108 == null) goto L13;
        r105 = r108.hashCode();
    L13:
        int r109 = (r107 + r105) * 31;
        if (this.isFirstItem == false) goto L16;
        int r110 = 1231;
    L17:
        int r111 = (r109 + r110) * 31;
        if (this.isLastItem == true) goto L22;
        r101 = 1237;
    L22:
        return r111 + r101;
    L16:
        r110 = 1237;
        goto L17
    L9:
        r106 = 0;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final boolean getTaskListArchived() {
        return this.taskListArchived;
    }

    public final String getTaskListGuid() {
        return this.taskListGuid;
    }

    public final IconInfo getTaskListIconInfo() {
        return this.taskListIconInfo;
    }

    public final String getTaskListName() {
        return this.taskListName;
    }

    public final TodoUser getTaskListOwner() {
        return this.taskListOwner;
    }

    public final CopyOnWriteArrayList<TaskContainerSection> getTaskListSections() {
        return this.taskListSections;
    }

    public final boolean isFirstItem() {
        return this.isFirstItem;
    }

    public final boolean isLastItem() {
        return this.isLastItem;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TaskListDisplayItem) == true) goto L8;
        return false;
    L8:
        TaskListDisplayItem r101 = (TaskListDisplayItem) r100;
        if (Intrinsics.areEqual(this.taskListGuid, r101.taskListGuid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.taskListName, r101.taskListName) == true) goto L15;
        return false;
    L15:
        if (this.taskListArchived == r101.taskListArchived) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.taskListOwner, r101.taskListOwner) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.taskListSections, r101.taskListSections) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.taskListIconInfo, r101.taskListIconInfo) == true) goto L27;
        return false;
    L27:
        if (this.isFirstItem == r101.isFirstItem) goto L30;
        return false;
    L30:
        if (this.isLastItem == r101.isLastItem) goto L32;
        return false;
    L32:
        return true;
    }

    public final void setFirstItem(boolean r100) {
        this.isFirstItem = r100;
    }

    public final void setLastItem(boolean r100) {
        this.isLastItem = r100;
    }

    public final void setTaskListArchived(boolean r100) {
        this.taskListArchived = r100;
    }

    public final void setTaskListGuid(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.taskListGuid = r100;
    }

    public final void setTaskListIconInfo(IconInfo r100) {
        this.taskListIconInfo = r100;
    }

    public final void setTaskListName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.taskListName = r100;
    }

    public final void setTaskListOwner(TodoUser r100) {
        this.taskListOwner = r100;
    }

    public final void setTaskListSections(CopyOnWriteArrayList<TaskContainerSection> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.taskListSections = r100;
    }

    public TaskListDisplayItem(String r100, String r101, boolean r102, TodoUser r103, CopyOnWriteArrayList<TaskContainerSection> r104, IconInfo r105, boolean r106, boolean r107) {
        Intrinsics.checkNotNullParameter(r100, "taskListGuid");
        Intrinsics.checkNotNullParameter(r101, "taskListName");
        Intrinsics.checkNotNullParameter(r104, "taskListSections");
        this.taskListGuid = r100;
        this.taskListName = r101;
        this.taskListArchived = r102;
        this.taskListOwner = r103;
        this.taskListSections = r104;
        this.taskListIconInfo = r105;
        this.isFirstItem = r106;
        this.isLastItem = r107;
    }

    public /* synthetic */ TaskListDisplayItem(String r110, String r111, boolean r112, TodoUser r113, CopyOnWriteArrayList r114, IconInfo r115, boolean r116, boolean r210, int r211, DefaultConstructorMarker r212) {
        if ((r211 & 64) == 0) goto L5;
        boolean r117 = false;
    L7:
        if ((r211 & 128) == 0) goto L9;
        boolean r118 = false;
    L10:
        this(r110, r111, r112, r113, r114, r115, r117, r118);
        return;
    L9:
        r118 = r210;
        goto L10
    L5:
        r117 = r116;
        goto L7
    }
}
