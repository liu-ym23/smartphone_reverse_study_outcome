package com.larus.platform.model.comment;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ&\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0005J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/larus/platform/model/comment/LikeInfo;", "Landroid/os/Parcelable;", "likeCount", "", "likeStatus", "", "<init>", "(Ljava/lang/Long;Ljava/lang/Integer;)V", "getLikeCount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLikeStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/Integer;)Lcom/larus/platform/model/comment/LikeInfo;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LikeInfo implements Parcelable {
    public static final Parcelable.Creator<LikeInfo> CREATOR = null;

    @SerializedName("like_count")
    private final Long likeCount;

    @SerializedName("like_status")
    private final Integer likeStatus;

    public static final class a implements Parcelable.Creator<LikeInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LikeInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Integer r101 = null;
            if (r100.readInt() != 0) goto L5;
            Long r102 = null;
        L7:
            if (r100.readInt() == 0) goto L11;
            r101 = Integer.valueOf(r100.readInt());
        L11:
            return new LikeInfo(r102, r101);
        L5:
            r102 = Long.valueOf(r100.readLong());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final LikeInfo[] newArray(int r100) {
            return new LikeInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public LikeInfo() {
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
        if ((r100 instanceof LikeInfo) == true) goto L8;
        return false;
    L8:
        LikeInfo r101 = (LikeInfo) r100;
        if (Intrinsics.areEqual(this.likeCount, r101.likeCount) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.likeStatus, r101.likeStatus) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.likeCount;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.likeStatus;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LikeInfo(likeCount=" + this.likeCount + ", likeStatus=" + this.likeStatus + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        Long r102 = this.likeCount;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Integer r103 = this.likeStatus;
        if (r103 != null) goto L9;
        r100.writeInt(0);
        return;
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.intValue());
        return;
    L5:
        r100.writeInt(1);
        r100.writeLong(r102.longValue());
        goto L6
    }

    public final Long a() {
        return this.likeCount;
    }

    public final Integer b() {
        return this.likeStatus;
    }

    public /* synthetic */ LikeInfo(int r100) {
        this(0L, 0);
    }

    public LikeInfo(Long r100, Integer r101) {
        this.likeCount = r100;
        this.likeStatus = r101;
    }
}
