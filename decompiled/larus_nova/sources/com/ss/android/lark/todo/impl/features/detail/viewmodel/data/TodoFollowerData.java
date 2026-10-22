package com.ss.android.lark.todo.impl.features.detail.viewmodel.data;

import com.bytedance.lark.pb.todo.v1.TodoFollower;
import com.bytedance.lark.pb.todo.v1.TodoUser;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0018\u001a\u00020\u0002H\u0016R\u001a\u0010\u0004\u001a\u00020\u0002X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\u0016\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/TodoFollowerData;", "Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/BaseData;", "Lcom/bytedance/lark/pb/todo/v1/TodoFollower;", "Ljava/io/Serializable;", "pbData", "<init>", "(Lcom/bytedance/lark/pb/todo/v1/TodoFollower;)V", "getPbData", "()Lcom/bytedance/lark/pb/todo/v1/TodoFollower;", "setPbData", "userData", "Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/TodoUserData;", "getUserData", "()Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/TodoUserData;", "followerId", "", "getFollowerId", "()Ljava/lang/String;", "tenantId", "getTenantId", "name", "getName", "avatarKey", "getAvatarKey", "parseToPb", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TodoFollowerData implements a<TodoFollower>, Serializable {
    private final String avatarKey;
    private final String followerId;
    private final String name;
    private TodoFollower pbData;
    private final String tenantId;
    private final TodoUserData userData;

    @Override // com.ss.android.lark.todo.impl.features.detail.viewmodel.data.a
    public boolean isValid() {
        return true;
    }

    public void setValid(boolean r100) {
    }

    /* JADX INFO: renamed from: getPbData, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8687getPbData() {
        return getPbData();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ss.android.lark.todo.impl.features.detail.viewmodel.data.a
    public TodoFollower parseToPb() {
        return getPbData().newBuilder().build();
    }

    public final String getAvatarKey() {
        return this.avatarKey;
    }

    public final String getFollowerId() {
        return this.followerId;
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

    public TodoFollower getPbData() {
        return this.pbData;
    }

    @Override // com.ss.android.lark.todo.impl.features.detail.viewmodel.data.a
    public /* bridge */ /* synthetic */ TodoFollower parseToPb() {
        return parseToPb();
    }

    public TodoFollowerData(TodoFollower r100) {
        Intrinsics.checkNotNullParameter(r100, "pbData");
        this.pbData = r100;
        TodoUser r101 = getPbData().user.user;
        if (r101 == null) goto L5;
        TodoUserData r102 = new TodoUserData(r101);
    L6:
        this.userData = r102;
        this.followerId = getPbData().follower_id;
        String r103 = "";
        if (r102 == null) goto L10;
        String r104 = r102.getTenantId();
        if (r104 == null) goto L10;
    L11:
        this.tenantId = r104;
        if (r102 == null) goto L15;
        String r105 = r102.getUserName();
        if (r105 == null) goto L15;
    L16:
        this.name = r105;
        if (r102 == null) goto L22;
        String r106 = r102.getAvatarKey();
        if (r106 == null) goto L22;
        r103 = r106;
    L22:
        this.avatarKey = r103;
        return;
    L15:
        r105 = "";
    L10:
        r104 = "";
        goto L11
    L5:
        r102 = null;
        goto L6
    }

    public void setPbData(TodoFollower r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.pbData = r100;
    }

    public /* bridge */ /* synthetic */ void setPbData(Object r100) {
        setPbData((TodoFollower) r100);
    }
}
