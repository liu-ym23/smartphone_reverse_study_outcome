package com.ss.android.lark.dto.usergroup;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/dto/usergroup/UserGroupEntity;", "Ljava/io/Serializable;", "groupId", "", "groupName", "groupMemberCount", "groupMemberCountInChat", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getGroupId", "()Ljava/lang/String;", "setGroupId", "(Ljava/lang/String;)V", "getGroupName", "setGroupName", "getGroupMemberCount", "setGroupMemberCount", "getGroupMemberCountInChat", "setGroupMemberCountInChat", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserGroupEntity implements Serializable {
    private String groupId;
    private String groupMemberCount;
    private String groupMemberCountInChat;
    private String groupName;

    public static /* synthetic */ UserGroupEntity copy$default(UserGroupEntity r100, String r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.groupId;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.groupName;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.groupMemberCount;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.groupMemberCountInChat;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.groupId;
    }

    public final String component2() {
        return this.groupName;
    }

    public final String component3() {
        return this.groupMemberCount;
    }

    public final String component4() {
        return this.groupMemberCountInChat;
    }

    public final UserGroupEntity copy(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "groupId");
        Intrinsics.checkNotNullParameter(r101, "groupName");
        Intrinsics.checkNotNullParameter(r102, "groupMemberCount");
        Intrinsics.checkNotNullParameter(r103, "groupMemberCountInChat");
        return new UserGroupEntity(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UserGroupEntity) == true) goto L8;
        return false;
    L8:
        UserGroupEntity r101 = (UserGroupEntity) r100;
        if (Intrinsics.areEqual(this.groupId, r101.groupId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.groupName, r101.groupName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.groupMemberCount, r101.groupMemberCount) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.groupMemberCountInChat, r101.groupMemberCountInChat) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.groupId.hashCode() * 31) + this.groupName.hashCode()) * 31) + this.groupMemberCount.hashCode()) * 31) + this.groupMemberCountInChat.hashCode();
    }

    public String toString() {
        return "UserGroupEntity(groupId=" + this.groupId + ", groupName=" + this.groupName + ", groupMemberCount=" + this.groupMemberCount + ", groupMemberCountInChat=" + this.groupMemberCountInChat + ')';
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getGroupMemberCount() {
        return this.groupMemberCount;
    }

    public final String getGroupMemberCountInChat() {
        return this.groupMemberCountInChat;
    }

    public final String getGroupName() {
        return this.groupName;
    }

    public final void setGroupId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.groupId = r100;
    }

    public final void setGroupMemberCount(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.groupMemberCount = r100;
    }

    public final void setGroupMemberCountInChat(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.groupMemberCountInChat = r100;
    }

    public final void setGroupName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.groupName = r100;
    }

    public UserGroupEntity(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "groupId");
        Intrinsics.checkNotNullParameter(r101, "groupName");
        Intrinsics.checkNotNullParameter(r102, "groupMemberCount");
        Intrinsics.checkNotNullParameter(r103, "groupMemberCountInChat");
        this.groupId = r100;
        this.groupName = r101;
        this.groupMemberCount = r102;
        this.groupMemberCountInChat = r103;
    }
}
