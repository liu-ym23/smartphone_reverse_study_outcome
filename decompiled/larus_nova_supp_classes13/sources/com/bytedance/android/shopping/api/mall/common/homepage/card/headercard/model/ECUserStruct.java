package com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l93.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jb\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\b\u0010 \u001a\u0004\u0018\u00010\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0006\u0010\u0010R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\b\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006$"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECUserStruct;", "", "id", "", "name", "avatar", "isFollowed", "", "isLive", "roomId", "secId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/Object;", "getId", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getName", "getRoomId", "getSecId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECUserStruct;", "equals", "other", "getAvatarUrl", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECUserStruct {

    @SerializedName("avatar")
    private final Object avatar;

    @SerializedName("id")
    private final String id;

    @SerializedName("is_followed")
    private final Boolean isFollowed;

    @SerializedName("is_live")
    private final Boolean isLive;

    @SerializedName("name")
    private final String name;

    @SerializedName("room_id")
    private final String roomId;

    @SerializedName("sec_id")
    private final String secId;

    public ECUserStruct() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ ECUserStruct copy$default(ECUserStruct r5, String r6, String r7, Object r8, Boolean r9, Boolean r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.id;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.name;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.avatar;
    L11:
        Object r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.isFollowed;
    L14:
        Boolean r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.isLive;
    L17:
        Boolean r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.roomId;
    L20:
        String r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.secId;
    L23:
        String r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final Object component3() {
        return this.avatar;
    }

    public final Boolean component4() {
        return this.isFollowed;
    }

    public final Boolean component5() {
        return this.isLive;
    }

    public final String component6() {
        return this.roomId;
    }

    public final String component7() {
        return this.secId;
    }

    public final ECUserStruct copy(String r10, String r11, Object r12, Boolean r13, Boolean r14, String r15, String r16) {
        return new ECUserStruct(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ECUserStruct) == false) goto L20;
        ECUserStruct r4 = (ECUserStruct) r3;
        if (Intrinsics.areEqual(this.id, r4.id) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.name, r4.name) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.avatar, r4.avatar) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isFollowed, r4.isFollowed) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.isLive, r4.isLive) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.roomId, r4.roomId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.secId, r4.secId) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.name;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Object r7 = this.avatar;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.isFollowed;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.isLive;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.roomId;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.secId;
        if (r19 == null) goto L30;
        r1 = r19.hashCode();
    L30:
        return r18 + r1;
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "ECUserStruct(id=" + this.id + ", name=" + this.name + ", avatar=" + this.avatar + ", isFollowed=" + this.isFollowed + ", isLive=" + this.isLive + ", roomId=" + this.roomId + ", secId=" + this.secId + ")";
    }

    public final String getAvatarUrl() {
        return b.a(this.avatar);
    }

    public final Object getAvatar() {
        return this.avatar;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getSecId() {
        return this.secId;
    }

    public final Boolean isFollowed() {
        return this.isFollowed;
    }

    public final Boolean isLive() {
        return this.isLive;
    }

    public ECUserStruct(String r1, String r2, Object r3, Boolean r4, Boolean r5, String r6, String r7) {
        this.id = r1;
        this.name = r2;
        this.avatar = r3;
        this.isFollowed = r4;
        this.isLive = r5;
        this.roomId = r6;
        this.secId = r7;
    }

    public /* synthetic */ ECUserStruct(String r7, String r8, Object r9, Boolean r10, Boolean r11, String r12, String r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L5;
        String r16 = null;
    L7:
        if ((r14 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r14 & 4) == 0) goto L13;
        Object r2 = null;
    L15:
        if ((r14 & 8) == 0) goto L17;
        Boolean r3 = null;
    L19:
        if ((r14 & 16) == 0) goto L21;
        Boolean r4 = null;
    L23:
        if ((r14 & 32) == 0) goto L25;
        String r5 = null;
    L27:
        if ((r14 & 64) == 0) goto L29;
        String r17 = null;
    L30:
        this(r16, r1, r2, r3, r4, r5, r17);
        return;
    L29:
        r17 = r13;
        goto L30
    L25:
        r5 = r12;
        goto L27
    L21:
        r4 = r11;
        goto L23
    L17:
        r3 = r10;
        goto L19
    L13:
        r2 = r9;
        goto L15
    L9:
        r1 = r8;
        goto L11
    L5:
        r16 = r7;
        goto L7
    }
}
