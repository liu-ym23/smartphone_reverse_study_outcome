package com.ss.android.lark.todo.impl.features.detail.viewmodel.data;

import com.bytedance.lark.pb.todo.v1.TodoAssignee;
import com.bytedance.lark.pb.todo.v1.TodoFollower;
import com.bytedance.lark.pb.todo.v1.TodoItemMemberType;
import com.bytedance.lark.pb.todo.v1.TodoUser;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import g7c.m;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001dB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001cR\u001a\u0010\u0004\u001a\u00020\u0002X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0012\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/TodoUserData;", "Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/BaseData;", "Lcom/bytedance/lark/pb/todo/v1/TodoUser;", "Ljava/io/Serializable;", "pbData", "<init>", "(Lcom/bytedance/lark/pb/todo/v1/TodoUser;)V", "getPbData", "()Lcom/bytedance/lark/pb/todo/v1/TodoUser;", "setPbData", "userId", "", "getUserId", "()Ljava/lang/String;", "userName", "getUserName", "avatarKey", "getAvatarKey", "tenantId", "getTenantId", "parseToPb", "parseTodoAssigneePb", "Lcom/bytedance/lark/pb/todo/v1/TodoAssignee;", "parseTodoFollowerPb", "Lcom/bytedance/lark/pb/todo/v1/TodoFollower;", "parseTodoAssigneeData", "Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/TodoAssigneeData;", "parseTodoFollowerData", "Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/TodoFollowerData;", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TodoUserData implements com.ss.android.lark.todo.impl.features.detail.viewmodel.data.a<TodoUser>, Serializable {
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f443851a = null;
    private final String avatarKey;
    private TodoUser pbData;
    private final String tenantId;
    private final String userId;
    private final String userName;

    public static final class a {
        public a() {
        }
    }

    @Override // com.ss.android.lark.todo.impl.features.detail.viewmodel.data.a
    public boolean isValid() {
        return true;
    }

    public void setValid(boolean r100) {
    }

    static {
        Companion = new a();
        f443851a = TodoDependencyHolder.a().loginDependency();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ss.android.lark.todo.impl.features.detail.viewmodel.data.a
    public TodoUser parseToPb() {
        return new TodoUser.Builder().build();
    }

    public final TodoAssigneeData parseTodoAssigneeData() {
        return new TodoAssigneeData(parseTodoAssigneePb());
    }

    public final TodoAssignee parseTodoAssigneePb() {
        return new TodoAssignee.Builder().assignee_id(this.userId).assigner_id(f443851a.getUserId()).type(TodoItemMemberType.USER).user(new TodoAssignee.User.Builder().completed_milli_time(0L).user(getPbData()).build()).build();
    }

    public final TodoFollowerData parseTodoFollowerData() {
        return new TodoFollowerData(new TodoFollower.Builder().follower_id(this.userId).inviter_id(f443851a.getUserId()).type(TodoItemMemberType.USER).user(new TodoFollower.User.Builder().user(getPbData()).build()).build());
    }

    /* JADX INFO: renamed from: getPbData, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8690getPbData() {
        return getPbData();
    }

    public final String getAvatarKey() {
        return this.avatarKey;
    }

    public final String getTenantId() {
        return this.tenantId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public TodoUser getPbData() {
        return this.pbData;
    }

    @Override // com.ss.android.lark.todo.impl.features.detail.viewmodel.data.a
    public /* bridge */ /* synthetic */ TodoUser parseToPb() {
        return parseToPb();
    }

    public TodoUserData(TodoUser r100) {
        Intrinsics.checkNotNullParameter(r100, "pbData");
        this.pbData = r100;
        String r101 = getPbData().user_id;
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        this.userId = r101;
        String r103 = getPbData().name;
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        this.userName = r103;
        String r104 = getPbData().avatar_key;
        if (r104 != null) goto L11;
        r104 = "";
    L11:
        this.avatarKey = r104;
        String r105 = getPbData().tenant_id;
        if (r105 == null) goto L15;
        r102 = r105;
    L15:
        this.tenantId = r102;
    }

    public void setPbData(TodoUser r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.pbData = r100;
    }

    public /* bridge */ /* synthetic */ void setPbData(Object r100) {
        setPbData((TodoUser) r100);
    }
}
