package com.larus.bmhome.chat.resp;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u000bHÆ\u0003JG\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u000bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/larus/bmhome/chat/resp/NotificationList;", "", "hasMore", "", "nextCursor", "", "noticeList", "", "Lcom/larus/bmhome/chat/resp/Notice;", "readTime", "contentModifyVersion", "", "<init>", "(ZJLjava/util/List;JLjava/lang/String;)V", "getHasMore", "()Z", "getNextCursor", "()J", "getNoticeList", "()Ljava/util/List;", "getReadTime", "getContentModifyVersion", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotificationList {

    @SerializedName("content_modify_version")
    private final String contentModifyVersion;

    @SerializedName("has_more")
    private final boolean hasMore;

    @SerializedName("next_cursor")
    private final long nextCursor;

    @SerializedName("notice_list")
    private final List<Notice> noticeList;

    @SerializedName("read_time")
    private final long readTime;

    public NotificationList() {
        this(false, 0, null, 0, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NotificationList copy$default(NotificationList r100, boolean r101, long r102, List r103, long r110, String r111, int r112, Object r113) {
        if ((r112 & 1) == 0) goto L6;
        r101 = r100.hasMore;
    L6:
        if ((r112 & 2) == 0) goto L8;
        r102 = r100.nextCursor;
    L8:
        long r104 = r102;
        if ((r112 & 4) == 0) goto L11;
        r103 = r100.noticeList;
    L11:
        List r114 = r103;
        if ((r112 & 8) == 0) goto L14;
        r110 = r100.readTime;
    L14:
        long r105 = r110;
        if ((r112 & 16) == 0) goto L17;
        r111 = r100.contentModifyVersion;
    L17:
        boolean r106 = r101;
        return r100.copy(r106, r104, r114, r105, r111);
    }

    public final boolean component1() {
        return this.hasMore;
    }

    public final long component2() {
        return this.nextCursor;
    }

    public final List<Notice> component3() {
        return this.noticeList;
    }

    public final long component4() {
        return this.readTime;
    }

    public final String component5() {
        return this.contentModifyVersion;
    }

    public final NotificationList copy(boolean r110, long r111, List<Notice> r112, long r113, String r114) {
        return new NotificationList(r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NotificationList) == true) goto L8;
        return false;
    L8:
        NotificationList r101 = (NotificationList) r100;
        if (this.hasMore == r101.hasMore) goto L12;
        return false;
    L12:
        if (this.nextCursor == r101.nextCursor) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.noticeList, r101.noticeList) == true) goto L18;
        return false;
    L18:
        if (this.readTime == r101.readTime) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.contentModifyVersion, r101.contentModifyVersion) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        if (this.hasMore == false) goto L5;
        int r100 = 1231;
    L6:
        long r101 = this.nextCursor;
        int r102 = ((r100 * 31) + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        List<Notice> r103 = this.noticeList;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        long r106 = this.readTime;
        int r107 = (((r102 + r105) * 31) + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        String r108 = this.contentModifyVersion;
        if (r108 == null) goto L15;
        r104 = r108.hashCode();
    L15:
        return r107 + r104;
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "NotificationList(hasMore=" + this.hasMore + ", nextCursor=" + this.nextCursor + ", noticeList=" + this.noticeList + ", readTime=" + this.readTime + ", contentModifyVersion=" + this.contentModifyVersion + ')';
    }

    public final String getContentModifyVersion() {
        return this.contentModifyVersion;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final long getNextCursor() {
        return this.nextCursor;
    }

    public final List<Notice> getNoticeList() {
        return this.noticeList;
    }

    public final long getReadTime() {
        return this.readTime;
    }

    public NotificationList(boolean r100, long r101, List<Notice> r102, long r103, String r104) {
        this.hasMore = r100;
        this.nextCursor = r101;
        this.noticeList = r102;
        this.readTime = r103;
        this.contentModifyVersion = r104;
    }

    public /* synthetic */ NotificationList(boolean r100, long r101, List r102, long r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        r100 = false;
    L5:
        long r103 = -1;
        if ((r112 & 2) == 0) goto L8;
        long r104 = -1;
    L10:
        if ((r112 & 4) == 0) goto L12;
        r102 = null;
    L12:
        List r114 = r102;
        if ((r112 & 8) != 0) goto L17;
        r103 = r110;
    L17:
        if ((r112 & 16) == 0) goto L19;
        r111 = "";
    L19:
        this(r100, r104, r114, r103, r111);
        return;
    L8:
        r104 = r101;
        goto L10
    }
}
