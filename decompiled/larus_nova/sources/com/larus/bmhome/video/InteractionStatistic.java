package com.larus.bmhome.video;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/video/InteractionStatistic;", "", "likedCount", "", "formattedLikedCount", "", "<init>", "(JLjava/lang/String;)V", "getLikedCount", "()J", "getFormattedLikedCount", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InteractionStatistic {

    @SerializedName("formatted_liked_count")
    private final String formattedLikedCount;

    @SerializedName("liked_count")
    private final long likedCount;

    public InteractionStatistic() {
        this(0, null, 3, null);
    }

    public static /* synthetic */ InteractionStatistic copy$default(InteractionStatistic r100, long r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.likedCount;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.formattedLikedCount;
    L9:
        return r100.copy(r101, r102);
    }

    public final long component1() {
        return this.likedCount;
    }

    public final String component2() {
        return this.formattedLikedCount;
    }

    public final InteractionStatistic copy(long r100, String r101) {
        return new InteractionStatistic(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof InteractionStatistic) == true) goto L8;
        return false;
    L8:
        InteractionStatistic r101 = (InteractionStatistic) r100;
        if (this.likedCount == r101.likedCount) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.formattedLikedCount, r101.formattedLikedCount) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        long r100 = this.likedCount;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.formattedLikedCount;
        if (r102 != null) goto L5;
        int r103 = 0;
    L7:
        return r101 + r103;
    L5:
        r103 = r102.hashCode();
        goto L7
    }

    public String toString() {
        return "InteractionStatistic(likedCount=" + this.likedCount + ", formattedLikedCount=" + this.formattedLikedCount + ')';
    }

    public final String getFormattedLikedCount() {
        return this.formattedLikedCount;
    }

    public final long getLikedCount() {
        return this.likedCount;
    }

    public InteractionStatistic(long r100, String r101) {
        this.likedCount = r100;
        this.formattedLikedCount = r101;
    }

    public /* synthetic */ InteractionStatistic(long r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
