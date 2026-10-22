package com.larus.platform.model.comment;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b.\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 P2\u00020\u0001:\u0001PBÁ\u0001\u0012 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u0001`\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0011\u0012\u0012\b\u0002\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0017¢\u0006\u0004\b\u0018\u0010\u0019J!\u00105\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u0001`\u0004HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010<\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010>\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010+J\u0013\u0010A\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0017HÆ\u0003JÈ\u0001\u0010B\u001a\u00020\u00002 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u0001`\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00112\u0012\b\u0002\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0017HÆ\u0001¢\u0006\u0002\u0010CJ\u0006\u0010D\u001a\u00020\rJ\u0013\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010HHÖ\u0003J\t\u0010I\u001a\u00020\rHÖ\u0001J\t\u0010J\u001a\u00020\u0006HÖ\u0001J\u0016\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\rR.\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u0001`\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010 R \u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b2\u0010+R \u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104¨\u0006Q"}, d2 = {"Lcom/larus/platform/model/comment/CommentInfo;", "Landroid/os/Parcelable;", "childrenList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "parentId", "", "replyToId", "repliedCommentUserInfo", "Lcom/larus/platform/model/comment/UserInfo;", "commentId", "clientCommentId", "status", "", "content", "Lcom/larus/platform/model/comment/CommentContent;", "createTime", "", "creatorUserInfo", "likeInfo", "Lcom/larus/platform/model/comment/LikeInfo;", "replyCount", "tagList", "", "<init>", "(Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/model/comment/UserInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/platform/model/comment/CommentContent;Ljava/lang/Long;Lcom/larus/platform/model/comment/UserInfo;Lcom/larus/platform/model/comment/LikeInfo;Ljava/lang/Long;Ljava/util/List;)V", "getChildrenList", "()Ljava/util/ArrayList;", "getParentId", "()Ljava/lang/String;", "getReplyToId", "getRepliedCommentUserInfo", "()Lcom/larus/platform/model/comment/UserInfo;", "getCommentId", "getClientCommentId", "getStatus", "()Ljava/lang/Integer;", "setStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getContent", "()Lcom/larus/platform/model/comment/CommentContent;", "getCreateTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCreatorUserInfo", "getLikeInfo", "()Lcom/larus/platform/model/comment/LikeInfo;", "setLikeInfo", "(Lcom/larus/platform/model/comment/LikeInfo;)V", "getReplyCount", "getTagList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/model/comment/UserInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/platform/model/comment/CommentContent;Ljava/lang/Long;Lcom/larus/platform/model/comment/UserInfo;Lcom/larus/platform/model/comment/LikeInfo;Ljava/lang/Long;Ljava/util/List;)Lcom/larus/platform/model/comment/CommentInfo;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentInfo implements Parcelable {
    public static final Parcelable.Creator<CommentInfo> CREATOR = null;

    @SerializedName("reply_list")
    private final ArrayList<CommentInfo> childrenList;

    @SerializedName("client_comment_id")
    private final String clientCommentId;

    @SerializedName("comment_id")
    private final String commentId;

    @SerializedName("content")
    private final CommentContent content;

    @SerializedName("create_time")
    private final Long createTime;

    @SerializedName("creator_info")
    private final UserInfo creatorUserInfo;

    @SerializedName("like_info")
    private LikeInfo likeInfo;

    @SerializedName("parent_id")
    private final String parentId;

    @SerializedName("reply_to_user_info")
    private final UserInfo repliedCommentUserInfo;

    @SerializedName("reply_count")
    private final Long replyCount;

    @SerializedName("reply_to_id")
    private final String replyToId;

    @SerializedName("status")
    private Integer status;

    @SerializedName("tag_list")
    private final List<Integer> tagList;

    public static final class a {
    }

    public static final class b implements Parcelable.Creator<CommentInfo> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final CommentInfo createFromParcel(Parcel r210) {
            Intrinsics.checkNotNullParameter(r210, "parcel");
            int r100 = 0;
            if (r210.readInt() != 0) goto L5;
            ArrayList r101 = null;
        L13:
            String r102 = r210.readString();
            String r103 = r210.readString();
            if (r210.readInt() != 0) goto L16;
            UserInfo r104 = null;
        L17:
            UserInfo r110 = r104;
            String r111 = r210.readString();
            String r112 = r210.readString();
            if (r210.readInt() != 0) goto L20;
            Integer r113 = null;
        L22:
            if (r210.readInt() != 0) goto L24;
            CommentContent r105 = null;
        L25:
            CommentContent r114 = r105;
            if (r210.readInt() != 0) goto L28;
            Long r115 = null;
        L30:
            if (r210.readInt() != 0) goto L32;
            UserInfo r106 = null;
        L33:
            UserInfo r116 = r106;
            if (r210.readInt() != 0) goto L36;
            LikeInfo r107 = null;
        L37:
            LikeInfo r117 = r107;
            if (r210.readInt() != 0) goto L40;
            Long r118 = null;
        L42:
            if (r210.readInt() != 0) goto L44;
            ArrayList r119 = null;
        L53:
            return new CommentInfo(r101, r102, r103, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119);
        L44:
            int r108 = r210.readInt();
            ArrayList r109 = new ArrayList(r108);
        L45:
            if (r100 == r108) goto L51;
            if (r210.readInt() != 0) goto L49;
            Integer r120 = null;
        L50:
            r109.add(r120);
            r100 = r100 + 1;
            goto L45
        L49:
            r120 = Integer.valueOf(r210.readInt());
            goto L50
        L51:
            r119 = r109;
            goto L53
        L40:
            r118 = Long.valueOf(r210.readLong());
            goto L42
        L36:
            r107 = LikeInfo.CREATOR.createFromParcel(r210);
            goto L37
        L32:
            r106 = UserInfo.CREATOR.createFromParcel(r210);
            goto L33
        L28:
            r115 = Long.valueOf(r210.readLong());
            goto L30
        L24:
            r105 = CommentContent.CREATOR.createFromParcel(r210);
            goto L25
        L20:
            r113 = Integer.valueOf(r210.readInt());
            goto L22
        L16:
            r104 = UserInfo.CREATOR.createFromParcel(r210);
            goto L17
        L5:
            int r121 = r210.readInt();
            ArrayList r122 = new ArrayList(r121);
            int r123 = 0;
        L6:
            if (r123 == r121) goto L12;
            if (r210.readInt() != 0) goto L10;
            CommentInfo r124 = null;
        L11:
            r122.add(r124);
            r123 = r123 + 1;
            goto L6
        L10:
            r124 = CommentInfo.CREATOR.createFromParcel(r210);
            goto L11
        L12:
            r101 = r122;
            goto L13
        }

        @Override // android.os.Parcelable.Creator
        public final CommentInfo[] newArray(int r100) {
            return new CommentInfo[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    public CommentInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, 8191);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CommentInfo) == true) goto L8;
        return false;
    L8:
        CommentInfo r101 = (CommentInfo) r100;
        if (Intrinsics.areEqual(this.childrenList, r101.childrenList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.parentId, r101.parentId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.replyToId, r101.replyToId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.repliedCommentUserInfo, r101.repliedCommentUserInfo) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.commentId, r101.commentId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.clientCommentId, r101.clientCommentId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.createTime, r101.createTime) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.creatorUserInfo, r101.creatorUserInfo) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.likeInfo, r101.likeInfo) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.replyCount, r101.replyCount) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.tagList, r101.tagList) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        ArrayList<CommentInfo> r100 = this.childrenList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.parentId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.replyToId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        UserInfo r110 = this.repliedCommentUserInfo;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.commentId;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.clientCommentId;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.status;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        CommentContent r122 = this.content;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Long r125 = this.createTime;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        UserInfo r128 = this.creatorUserInfo;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        LikeInfo r131 = this.likeInfo;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Long r134 = this.replyCount;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        List<Integer> r137 = this.tagList;
        if (r137 == null) goto L55;
        r101 = r137.hashCode();
    L55:
        return r136 + r101;
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
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

    public final String toString() {
        return "CommentInfo(childrenList=" + this.childrenList + ", parentId=" + this.parentId + ", replyToId=" + this.replyToId + ", repliedCommentUserInfo=" + this.repliedCommentUserInfo + ", commentId=" + this.commentId + ", clientCommentId=" + this.clientCommentId + ", status=" + this.status + ", content=" + this.content + ", createTime=" + this.createTime + ", creatorUserInfo=" + this.creatorUserInfo + ", likeInfo=" + this.likeInfo + ", replyCount=" + this.replyCount + ", tagList=" + this.tagList + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        ArrayList<CommentInfo> r102 = this.childrenList;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L12:
        r100.writeString(this.parentId);
        r100.writeString(this.replyToId);
        UserInfo r103 = this.repliedCommentUserInfo;
        if (r103 != null) goto L15;
        r100.writeInt(0);
    L16:
        r100.writeString(this.commentId);
        r100.writeString(this.clientCommentId);
        Integer r104 = this.status;
        if (r104 != null) goto L19;
        r100.writeInt(0);
    L20:
        CommentContent r105 = this.content;
        if (r105 != null) goto L23;
        r100.writeInt(0);
    L24:
        Long r106 = this.createTime;
        if (r106 != null) goto L27;
        r100.writeInt(0);
    L28:
        UserInfo r107 = this.creatorUserInfo;
        if (r107 != null) goto L31;
        r100.writeInt(0);
    L32:
        LikeInfo r108 = this.likeInfo;
        if (r108 != null) goto L35;
        r100.writeInt(0);
    L36:
        Long r109 = this.replyCount;
        if (r109 != null) goto L39;
        r100.writeInt(0);
    L40:
        List<Integer> r110 = this.tagList;
        if (r110 != null) goto L43;
        r100.writeInt(0);
        return;
    L43:
        r100.writeInt(1);
        r100.writeInt(r110.size());
        Iterator<Integer> r111 = r110.iterator();
    L45:
        if (r111.hasNext() == false) goto L63;
        Integer r112 = r111.next();
        if (r112 == null) goto L48;
        r100.writeInt(1);
        r100.writeInt(r112.intValue());
        goto L45
    L48:
        r100.writeInt(0);
        goto L45
    L63:
        return;
    L39:
        r100.writeInt(1);
        r100.writeLong(r109.longValue());
        goto L40
    L35:
        r100.writeInt(1);
        r108.writeToParcel(r100, r101);
        goto L36
    L31:
        r100.writeInt(1);
        r107.writeToParcel(r100, r101);
        goto L32
    L27:
        r100.writeInt(1);
        r100.writeLong(r106.longValue());
        goto L28
    L23:
        r100.writeInt(1);
        r105.writeToParcel(r100, r101);
        goto L24
    L19:
        r100.writeInt(1);
        r100.writeInt(r104.intValue());
        goto L20
    L15:
        r100.writeInt(1);
        r103.writeToParcel(r100, r101);
        goto L16
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<CommentInfo> r113 = r102.iterator();
    L7:
        if (r113.hasNext() == false) goto L12;
        CommentInfo r114 = r113.next();
        if (r114 == null) goto L10;
        r100.writeInt(1);
        r114.writeToParcel(r100, r101);
        goto L7
    L10:
        r100.writeInt(0);
        goto L7
    }

    public final ArrayList<CommentInfo> b() {
        return this.childrenList;
    }

    public final String c() {
        return this.clientCommentId;
    }

    public final String d() {
        return this.commentId;
    }

    public final CommentContent e() {
        return this.content;
    }

    public final Long g() {
        return this.createTime;
    }

    public final UserInfo h() {
        return this.creatorUserInfo;
    }

    public final LikeInfo i() {
        return this.likeInfo;
    }

    public final String j() {
        return this.parentId;
    }

    public final UserInfo k() {
        return this.repliedCommentUserInfo;
    }

    public final Long o() {
        return this.replyCount;
    }

    public final String q() {
        return this.replyToId;
    }

    public final List<Integer> r() {
        return this.tagList;
    }

    public final void s(LikeInfo r100) {
        this.likeInfo = r100;
    }

    public static CommentInfo a(CommentInfo r110, String r111) {
        return new CommentInfo(r110.childrenList, r110.parentId, r110.replyToId, r110.repliedCommentUserInfo, r111, r110.clientCommentId, r110.status, r110.content, r110.createTime, r110.creatorUserInfo, r110.likeInfo, r110.replyCount, r110.tagList);
    }

    public /* synthetic */ CommentInfo(String r110, String r111, UserInfo r112, String r210, String r211, CommentContent r212, Long r213, UserInfo r214, LikeInfo r215, Long r216, List r217, int r218) {
        String r100 = "";
        if ((r218 & 2) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r218 & 4) != 0) goto L11;
        r100 = r111;
    L11:
        if ((r218 & 8) == 0) goto L13;
        UserInfo r102 = null;
    L15:
        if ((r218 & 16) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r218 & 32) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r218 & 64) == 0) goto L25;
        Integer r105 = 0;
    L27:
        if ((r218 & 128) == 0) goto L29;
        CommentContent r106 = null;
    L31:
        if ((r218 & 256) == 0) goto L33;
        Long r113 = 0L;
    L35:
        if ((r218 & 512) == 0) goto L37;
        UserInfo r114 = null;
    L39:
        if ((r218 & 1024) == 0) goto L41;
        LikeInfo r115 = null;
    L43:
        if ((r218 & 2048) == 0) goto L45;
        Long r116 = 0L;
    L47:
        if ((r218 & 4096) == 0) goto L49;
        List r117 = CollectionsKt.emptyList();
    L50:
        this(null, r101, r100, r102, r103, r104, r105, r106, r113, r114, r115, r116, r117);
        return;
    L49:
        r117 = r217;
        goto L50
    L45:
        r116 = r216;
        goto L47
    L41:
        r115 = r215;
        goto L43
    L37:
        r114 = r214;
        goto L39
    L33:
        r113 = r213;
        goto L35
    L29:
        r106 = r212;
        goto L31
    L25:
        r105 = null;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L5:
        r101 = r110;
        goto L7
    }

    public CommentInfo(ArrayList<CommentInfo> r100, String r101, String r102, UserInfo r103, String r104, String r105, @CommentStatus Integer r106, CommentContent r107, Long r108, UserInfo r110, LikeInfo r111, Long r112, List<Integer> r113) {
        this.childrenList = r100;
        this.parentId = r101;
        this.replyToId = r102;
        this.repliedCommentUserInfo = r103;
        this.commentId = r104;
        this.clientCommentId = r105;
        this.status = r106;
        this.content = r107;
        this.createTime = r108;
        this.creatorUserInfo = r110;
        this.likeInfo = r111;
        this.replyCount = r112;
        this.tagList = r113;
    }
}
