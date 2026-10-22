package com.ss.android.lark.vote.message.content;

import com.ss.android.lark.chat.entity.tag.TagData;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003JC\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lcom/ss/android/lark/vote/message/content/VoteUser;", "Ljava/io/Serializable;", "userId", "", "name", "avatarKey", "tenantId", "tagData", "Lcom/ss/android/lark/chat/entity/tag/TagData;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/chat/entity/tag/TagData;)V", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "getName", "setName", "getAvatarKey", "setAvatarKey", "getTenantId", "setTenantId", "getTagData", "()Lcom/ss/android/lark/chat/entity/tag/TagData;", "setTagData", "(Lcom/ss/android/lark/chat/entity/tag/TagData;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "vote_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoteUser implements Serializable {
    private String avatarKey;
    private String name;
    private TagData tagData;
    private String tenantId;
    private String userId;

    public static /* synthetic */ VoteUser copy$default(VoteUser r100, String r101, String r102, String r103, String r104, TagData r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.userId;
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
        r104 = r100.tenantId;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.tagData;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.avatarKey;
    }

    public final String component4() {
        return this.tenantId;
    }

    public final TagData component5() {
        return this.tagData;
    }

    public final VoteUser copy(String r100, String r101, String r110, String r111, TagData r112) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        return new VoteUser(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof VoteUser) == true) goto L8;
        return false;
    L8:
        VoteUser r101 = (VoteUser) r100;
        if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.avatarKey, r101.avatarKey) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.tenantId, r101.tenantId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.tagData, r101.tagData) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = this.userId.hashCode() * 31;
        String r101 = this.name;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.avatarKey;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.tenantId;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        TagData r111 = this.tagData;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "VoteUser(userId=" + this.userId + ", name=" + this.name + ", avatarKey=" + this.avatarKey + ", tenantId=" + this.tenantId + ", tagData=" + this.tagData + ')';
    }

    public final String getAvatarKey() {
        return this.avatarKey;
    }

    public final String getName() {
        return this.name;
    }

    public final TagData getTagData() {
        return this.tagData;
    }

    public final String getTenantId() {
        return this.tenantId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setAvatarKey(String r100) {
        this.avatarKey = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setTagData(TagData r100) {
        this.tagData = r100;
    }

    public final void setTenantId(String r100) {
        this.tenantId = r100;
    }

    public final void setUserId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.userId = r100;
    }

    public VoteUser(String r100, String r101, String r102, String r103, TagData r104) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        this.userId = r100;
        this.name = r101;
        this.avatarKey = r102;
        this.tenantId = r103;
        this.tagData = r104;
    }
}
