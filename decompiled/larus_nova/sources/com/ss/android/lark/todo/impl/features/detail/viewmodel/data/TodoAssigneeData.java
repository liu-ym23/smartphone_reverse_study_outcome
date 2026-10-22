package com.ss.android.lark.todo.impl.features.detail.viewmodel.data;

import com.bytedance.lark.pb.todo.v1.TodoAssignee;
import com.bytedance.lark.pb.todo.v1.TodoItemMemberType;
import com.bytedance.lark.pb.todo.v1.TodoUser;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0011\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\u000bJ\b\u0010$\u001a\u00020\u0002H\u0016R\u001a\u0010\u0004\u001a\u00020\u0002X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0006R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\u001e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0011\u0010 \u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0011\u0010\"\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001b¨\u0006%"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/TodoAssigneeData;", "Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/BaseData;", "Lcom/bytedance/lark/pb/todo/v1/TodoAssignee;", "Ljava/io/Serializable;", "pbData", "<init>", "(Lcom/bytedance/lark/pb/todo/v1/TodoAssignee;)V", "userId", "", "(Ljava/lang/String;)V", "avatar", "(Ljava/lang/String;Ljava/lang/String;)V", "getPbData", "()Lcom/bytedance/lark/pb/todo/v1/TodoAssignee;", "setPbData", "userData", "Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/TodoUserData;", "getUserData", "()Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/TodoUserData;", "completedMilliTime", "", "getCompletedMilliTime", "()J", "setCompletedMilliTime", "(J)V", "assigneeId", "getAssigneeId", "()Ljava/lang/String;", "assignerId", "getAssignerId", "avatarKey", "getAvatarKey", "name", "getName", "tenantId", "getTenantId", "parseToPb", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TodoAssigneeData implements a<TodoAssignee>, Serializable {
    private final String assigneeId;
    private final String assignerId;
    private final String avatarKey;
    private long completedMilliTime;
    private final String name;
    private TodoAssignee pbData;
    private final String tenantId;
    private final TodoUserData userData;

    @Override // com.ss.android.lark.todo.impl.features.detail.viewmodel.data.a
    public boolean isValid() {
        return true;
    }

    public void setValid(boolean r100) {
    }

    /* JADX INFO: renamed from: getPbData, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8684getPbData() {
        return getPbData();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ss.android.lark.todo.impl.features.detail.viewmodel.data.a
    public TodoAssignee parseToPb() {
        return getPbData().newBuilder().user(getPbData().user.newBuilder().completed_milli_time(Long.valueOf(this.completedMilliTime)).build()).build();
    }

    public final String getAssigneeId() {
        return this.assigneeId;
    }

    public final String getAssignerId() {
        return this.assignerId;
    }

    public final String getAvatarKey() {
        return this.avatarKey;
    }

    public final long getCompletedMilliTime() {
        return this.completedMilliTime;
    }

    public final String getName() {
        return this.name;
    }

    public final String getTenantId() {
        return this.tenantId;
    }

    public final TodoUserData getUserData() {
        return this.userData;
    }

    public TodoAssignee getPbData() {
        return this.pbData;
    }

    @Override // com.ss.android.lark.todo.impl.features.detail.viewmodel.data.a
    public /* bridge */ /* synthetic */ TodoAssignee parseToPb() {
        return parseToPb();
    }

    public TodoAssigneeData(TodoAssignee r100) {
        Intrinsics.checkNotNullParameter(r100, "pbData");
        this.pbData = r100;
        TodoUser r101 = getPbData().user.user;
        if (r101 == null) goto L5;
        TodoUserData r102 = new TodoUserData(r101);
    L6:
        this.userData = r102;
        Long r103 = getPbData().user.completed_milli_time;
        if (r103 == null) goto L9;
        long r104 = r103.longValue();
    L10:
        this.completedMilliTime = r104;
        String r105 = getPbData().assignee_id;
        String r106 = "";
        if (r105 != null) goto L13;
        r105 = "";
    L13:
        this.assigneeId = r105;
        String r107 = getPbData().assigner_id;
        if (r107 != null) goto L16;
        r107 = "";
    L16:
        this.assignerId = r107;
        if (r102 == null) goto L20;
        String r108 = r102.getAvatarKey();
        if (r108 == null) goto L20;
    L21:
        this.avatarKey = r108;
        if (r102 == null) goto L25;
        String r109 = r102.getUserName();
        if (r109 == null) goto L25;
    L26:
        this.name = r109;
        if (r102 == null) goto L32;
        String r110 = r102.getTenantId();
        if (r110 == null) goto L32;
        r106 = r110;
    L32:
        this.tenantId = r106;
        return;
    L25:
        r109 = "";
    L20:
        r108 = "";
        goto L21
    L9:
        r104 = 0;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public final void setCompletedMilliTime(long r100) {
        this.completedMilliTime = r100;
    }

    public void setPbData(TodoAssignee r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.pbData = r100;
    }

    public TodoAssigneeData(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        this(new TodoAssignee.Builder().assignee_id(r100).type(TodoItemMemberType.USER).user(new TodoAssignee.User.Builder().completed_milli_time(0L).user(new TodoUser.Builder().user_id(r100).build()).build()).assigner_id(TodoDependencyHolder.a().loginDependency().getUserId()).build());
    }

    public /* bridge */ /* synthetic */ void setPbData(Object r100) {
        setPbData((TodoAssignee) r100);
    }

    public TodoAssigneeData(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "avatar");
        this(new TodoAssignee.Builder().assignee_id(r100).type(TodoItemMemberType.USER).assigner_id(TodoDependencyHolder.a().loginDependency().getUserId()).user(new TodoAssignee.User.Builder().completed_milli_time(0L).user(new TodoUser.Builder().user_id(r100).avatar_key(r101).build()).build()).build());
    }
}
