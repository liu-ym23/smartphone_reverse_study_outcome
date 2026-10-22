package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u0010\u001a\u00020\u0003J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0003R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/larus/bmhome/auth/FeedItemConfig;", "Landroid/os/Parcelable;", "mode", "", "count", "prefetchCount", "<init>", "(III)V", "getMode", "()I", "getCount", "getPrefetchCount", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedItemConfig implements Parcelable {
    public static final Parcelable.Creator<FeedItemConfig> CREATOR = null;

    @SerializedName("count")
    private final int count;

    @SerializedName("mode")
    private final int mode;

    @SerializedName("prefetch_count")
    private final int prefetchCount;

    /* JADX INFO: loaded from: classes25.dex */
    public static final class a implements Parcelable.Creator<FeedItemConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FeedItemConfig createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new FeedItemConfig(r100.readInt(), r100.readInt(), r100.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final FeedItemConfig[] newArray(int r100) {
            return new FeedItemConfig[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public FeedItemConfig() {
        this(0, 8, 6);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FeedItemConfig) == true) goto L8;
        return false;
    L8:
        FeedItemConfig r101 = (FeedItemConfig) r100;
        if (this.mode == r101.mode) goto L12;
        return false;
    L12:
        if (this.count == r101.count) goto L15;
        return false;
    L15:
        if (this.prefetchCount == r101.prefetchCount) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.mode * 31) + this.count) * 31) + this.prefetchCount;
    }

    public final String toString() {
        return "FeedItemConfig(mode=" + this.mode + ", count=" + this.count + ", prefetchCount=" + this.prefetchCount + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.mode);
        r100.writeInt(this.count);
        r100.writeInt(this.prefetchCount);
    }

    public final int a() {
        return this.count;
    }

    public final int b() {
        return this.mode;
    }

    public final int c() {
        return this.prefetchCount;
    }

    public FeedItemConfig(int r100, int r101, int r102) {
        this.mode = r100;
        this.count = r101;
        this.prefetchCount = r102;
    }
}
