package com.larus.bmhome.video;

import com.google.gson.annotations.SerializedName;
import com.larus.im.bean.conversation.IconImage;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003Jb\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\bHÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006'"}, d2 = {"Lcom/larus/bmhome/video/AuthorInfo;", "", "id", "", "openId", "nickName", "shortId", "source", "", "status", "avatar", "Lcom/larus/im/bean/conversation/IconImage;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/im/bean/conversation/IconImage;)V", "getId", "()Ljava/lang/String;", "getOpenId", "getNickName", "getShortId", "getSource", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStatus", "getAvatar", "()Lcom/larus/im/bean/conversation/IconImage;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/im/bean/conversation/IconImage;)Lcom/larus/bmhome/video/AuthorInfo;", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthorInfo {

    @SerializedName("avatar")
    private final IconImage avatar;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f315163id;

    @SerializedName("nick_name")
    private final String nickName;

    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    private final String openId;

    @SerializedName("short_id")
    private final String shortId;

    @SerializedName("source")
    private final Integer source;

    @SerializedName("status")
    private final Integer status;

    public AuthorInfo() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ AuthorInfo copy$default(AuthorInfo r100, String r101, String r102, String r103, String r104, Integer r110, Integer r111, IconImage r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.f315163id;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.openId;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.nickName;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.shortId;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.source;
    L17:
        Integer r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.status;
    L20:
        Integer r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.avatar;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.f315163id;
    }

    public final String component2() {
        return this.openId;
    }

    public final String component3() {
        return this.nickName;
    }

    public final String component4() {
        return this.shortId;
    }

    public final Integer component5() {
        return this.source;
    }

    public final Integer component6() {
        return this.status;
    }

    public final IconImage component7() {
        return this.avatar;
    }

    public final AuthorInfo copy(String r110, String r111, String r112, String r113, Integer r114, Integer r115, IconImage r116) {
        return new AuthorInfo(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AuthorInfo) == true) goto L8;
        return false;
    L8:
        AuthorInfo r101 = (AuthorInfo) r100;
        if (Intrinsics.areEqual(this.f315163id, r101.f315163id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.openId, r101.openId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.nickName, r101.nickName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.shortId, r101.shortId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.source, r101.source) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.avatar, r101.avatar) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r100 = this.f315163id;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.openId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.nickName;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.shortId;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.source;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.status;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        IconImage r119 = this.avatar;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "AuthorInfo(id=" + this.f315163id + ", openId=" + this.openId + ", nickName=" + this.nickName + ", shortId=" + this.shortId + ", source=" + this.source + ", status=" + this.status + ", avatar=" + this.avatar + ')';
    }

    public final IconImage getAvatar() {
        return this.avatar;
    }

    public final String getId() {
        return this.f315163id;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final String getOpenId() {
        return this.openId;
    }

    public final String getShortId() {
        return this.shortId;
    }

    public final Integer getSource() {
        return this.source;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public AuthorInfo(String r100, String r101, String r102, String r103, Integer r104, Integer r105, IconImage r106) {
        this.f315163id = r100;
        this.openId = r101;
        this.nickName = r102;
        this.shortId = r103;
        this.source = r104;
        this.status = r105;
        this.avatar = r106;
    }

    public /* synthetic */ AuthorInfo(String r100, String r101, String r102, String r110, Integer r111, Integer r112, IconImage r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        String r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        String r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        Integer r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        Integer r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        IconImage r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
