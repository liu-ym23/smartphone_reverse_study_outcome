package com.ss.android.lark.todo.impl.features.detail.assignee.display;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/assignee/display/UserBean;", "Ljava/io/Serializable;", "id", "", "name", "avatarKey", "showExternal", "", "department", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getAvatarKey", "getShowExternal", "()Z", "getDepartment", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserBean implements Serializable {
    private final String avatarKey;
    private final String department;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f442651id;
    private final String name;
    private final boolean showExternal;

    public static /* synthetic */ UserBean copy$default(UserBean r100, String r101, String r102, String r103, boolean r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.f442651id;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.name;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.avatarKey;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.showExternal;
    L14:
        boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.department;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.f442651id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.avatarKey;
    }

    public final boolean component4() {
        return this.showExternal;
    }

    public final String component5() {
        return this.department;
    }

    public final UserBean copy(String r100, String r101, String r110, boolean r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r110, "avatarKey");
        return new UserBean(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UserBean) == true) goto L8;
        return false;
    L8:
        UserBean r101 = (UserBean) r100;
        if (Intrinsics.areEqual(this.f442651id, r101.f442651id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.avatarKey, r101.avatarKey) == true) goto L18;
        return false;
    L18:
        if (this.showExternal == r101.showExternal) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.department, r101.department) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.f442651id.hashCode() * 31) + this.name.hashCode()) * 31) + this.avatarKey.hashCode()) * 31;
        if (this.showExternal == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        String r103 = this.department;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return r102 + r104;
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "UserBean(id=" + this.f442651id + ", name=" + this.name + ", avatarKey=" + this.avatarKey + ", showExternal=" + this.showExternal + ", department=" + this.department + ')';
    }

    public final String getAvatarKey() {
        return this.avatarKey;
    }

    public final String getDepartment() {
        return this.department;
    }

    public final String getId() {
        return this.f442651id;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getShowExternal() {
        return this.showExternal;
    }

    public UserBean(String r100, String r101, String r102, boolean r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "avatarKey");
        this.f442651id = r100;
        this.name = r101;
        this.avatarKey = r102;
        this.showExternal = r103;
        this.department = r104;
    }

    public /* synthetic */ UserBean(String r100, String r101, String r102, boolean r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 16) == 0) goto L5;
        r111 = null;
    L5:
        this(r100, r101, r102, r110, r111);
    }
}
