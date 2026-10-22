package com.larus.platform.model.comment.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.larus.platform.model.comment.CommentInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bi\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u001f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001cJp\u0010%\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010&J\u0006\u0010'\u001a\u00020(J\u0013\u0010)\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020(HÖ\u0001J\t\u0010-\u001a\u00020\tHÖ\u0001J\u0016\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020(R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001c¨\u00063"}, d2 = {"Lcom/larus/platform/model/comment/api/CommentHttpApi$GetCommentListData;", "Landroid/os/Parcelable;", "replies", "", "Lcom/larus/platform/model/comment/CommentInfo;", "comments", "hasMore", "", "nextOffsetToken", "", "additionalToast", "totalCount", "", "fromCache", "<init>", "(Ljava/util/List;Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;)V", "getReplies", "()Ljava/util/List;", "getComments", "getHasMore", "()Z", "getNextOffsetToken", "()Ljava/lang/String;", "getAdditionalToast", "getTotalCount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFromCache", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/util/List;Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;)Lcom/larus/platform/model/comment/api/CommentHttpApi$GetCommentListData;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentHttpApi$GetCommentListData implements Parcelable {
    public static final Parcelable.Creator<CommentHttpApi$GetCommentListData> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient Boolean f365619a;

    @SerializedName("toast")
    private final String additionalToast;

    @SerializedName("comments")
    private final List<CommentInfo> comments;

    @SerializedName("has_more")
    private final boolean hasMore;

    @SerializedName("next_offset_token")
    private final String nextOffsetToken;

    @SerializedName("replies")
    private final List<CommentInfo> replies;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TOTAL_COUNT)
    private final Long totalCount;

    public static final class a implements Parcelable.Creator<CommentHttpApi$GetCommentListData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CommentHttpApi$GetCommentListData createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            boolean r100 = false;
            Boolean r101 = null;
            if (r110.readInt() != 0) goto L5;
            ArrayList r102 = null;
        L14:
            if (r110.readInt() != 0) goto L16;
            ArrayList r103 = null;
        L25:
            if (r110.readInt() == 0) goto L27;
            boolean r104 = true;
        L28:
            String r105 = r110.readString();
            String r111 = r110.readString();
            if (r110.readInt() != 0) goto L31;
            Long r112 = null;
        L33:
            if (r110.readInt() != 0) goto L36;
        L40:
            return new CommentHttpApi$GetCommentListData(r102, r103, r104, r105, r111, r112, r101);
        L36:
            if (r110.readInt() == 0) goto L38;
            r100 = true;
        L38:
            r101 = Boolean.valueOf(r100);
            goto L40
        L31:
            r112 = Long.valueOf(r110.readLong());
            goto L33
        L27:
            r104 = false;
            goto L28
        L16:
            int r106 = r110.readInt();
            ArrayList r107 = new ArrayList(r106);
            int r108 = 0;
        L17:
            if (r108 == r106) goto L23;
            if (r110.readInt() != 0) goto L21;
            CommentInfo r109 = null;
        L22:
            r107.add(r109);
            r108 = r108 + 1;
            goto L17
        L21:
            r109 = CommentInfo.CREATOR.createFromParcel(r110);
            goto L22
        L23:
            r103 = r107;
            goto L25
        L5:
            int r113 = r110.readInt();
            ArrayList r114 = new ArrayList(r113);
            int r115 = 0;
        L6:
            if (r115 == r113) goto L12;
            if (r110.readInt() != 0) goto L10;
            CommentInfo r116 = null;
        L11:
            r114.add(r116);
            r115 = r115 + 1;
            goto L6
        L10:
            r116 = CommentInfo.CREATOR.createFromParcel(r110);
            goto L11
        L12:
            r102 = r114;
            goto L14
        }

        @Override // android.os.Parcelable.Creator
        public final CommentHttpApi$GetCommentListData[] newArray(int r100) {
            return new CommentHttpApi$GetCommentListData[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public CommentHttpApi$GetCommentListData() {
        this(0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CommentHttpApi$GetCommentListData) == true) goto L8;
        return false;
    L8:
        CommentHttpApi$GetCommentListData r101 = (CommentHttpApi$GetCommentListData) r100;
        if (Intrinsics.areEqual(this.replies, r101.replies) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.comments, r101.comments) == true) goto L15;
        return false;
    L15:
        if (this.hasMore == r101.hasMore) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.nextOffsetToken, r101.nextOffsetToken) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.additionalToast, r101.additionalToast) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.totalCount, r101.totalCount) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f365619a, r101.f365619a) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        List<CommentInfo> r100 = this.replies;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<CommentInfo> r104 = this.comments;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.hasMore == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        String r109 = this.nextOffsetToken;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        String r112 = this.additionalToast;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        Long r115 = this.totalCount;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        Boolean r118 = this.f365619a;
        if (r118 == null) goto L31;
        r101 = r118.hashCode();
    L31:
        return r117 + r101;
    L25:
        r116 = r115.hashCode();
        goto L26
    L21:
        r113 = r112.hashCode();
        goto L22
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "GetCommentListData(replies=" + this.replies + ", comments=" + this.comments + ", hasMore=" + this.hasMore + ", nextOffsetToken=" + this.nextOffsetToken + ", additionalToast=" + this.additionalToast + ", totalCount=" + this.totalCount + ", fromCache=" + this.f365619a + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        List<CommentInfo> r102 = this.replies;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L12:
        List<CommentInfo> r103 = this.comments;
        if (r103 != null) goto L15;
        r100.writeInt(0);
    L22:
        r100.writeInt(this.hasMore ? 1 : 0);
        r100.writeString(this.nextOffsetToken);
        r100.writeString(this.additionalToast);
        Long r104 = this.totalCount;
        if (r104 != null) goto L25;
        r100.writeInt(0);
    L26:
        Boolean r105 = this.f365619a;
        if (r105 != null) goto L29;
        r100.writeInt(0);
        return;
    L29:
        r100.writeInt(1);
        r100.writeInt(r105.booleanValue() ? 1 : 0);
        return;
    L25:
        r100.writeInt(1);
        r100.writeLong(r104.longValue());
        goto L26
    L15:
        r100.writeInt(1);
        r100.writeInt(r103.size());
        Iterator<CommentInfo> r106 = r103.iterator();
    L17:
        if (r106.hasNext() == false) goto L22;
        CommentInfo r107 = r106.next();
        if (r107 == null) goto L20;
        r100.writeInt(1);
        r107.writeToParcel(r100, r101);
        goto L17
    L20:
        r100.writeInt(0);
        goto L17
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<CommentInfo> r108 = r102.iterator();
    L7:
        if (r108.hasNext() == false) goto L12;
        CommentInfo r109 = r108.next();
        if (r109 == null) goto L10;
        r100.writeInt(1);
        r109.writeToParcel(r100, r101);
        goto L7
    L10:
        r100.writeInt(0);
        goto L7
    }

    public final String a() {
        return this.additionalToast;
    }

    public final List<CommentInfo> b() {
        return this.comments;
    }

    public final boolean c() {
        return this.hasMore;
    }

    public final String d() {
        return this.nextOffsetToken;
    }

    public final List<CommentInfo> e() {
        return this.replies;
    }

    public final Long g() {
        return this.totalCount;
    }

    public /* synthetic */ CommentHttpApi$GetCommentListData(int r100) {
        this(CollectionsKt.emptyList(), CollectionsKt.emptyList(), false, "", "", 0L, Boolean.FALSE);
    }

    public CommentHttpApi$GetCommentListData(List<CommentInfo> r100, List<CommentInfo> r101, boolean r102, String r103, String r104, Long r105, Boolean r106) {
        this.replies = r100;
        this.comments = r101;
        this.hasMore = r102;
        this.nextOffsetToken = r103;
        this.additionalToast = r104;
        this.totalCount = r105;
        this.f365619a = r106;
    }
}
