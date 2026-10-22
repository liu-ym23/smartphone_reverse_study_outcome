package com.ss.android.ugc.aweme.sticker.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bHÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/ss/android/ugc/aweme/sticker/model/BackgroundVideoTimeInfo;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", DyPayConstant.KEY_START_TIME, "", "endTime", "(JJ)V", "getEndTime", "()J", "getStartTime", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class BackgroundVideoTimeInfo implements Serializable, Parcelable {
    public static final Parcelable.Creator<BackgroundVideoTimeInfo> CREATOR = null;

    @SerializedName("bgv_end_time")
    private final long endTime;

    @SerializedName("bgv_start_time")
    private final long startTime;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public static class Creator implements Parcelable.Creator<BackgroundVideoTimeInfo> {
        public Creator() {
        }

        @Override // android.os.Parcelable.Creator
        public final BackgroundVideoTimeInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            return new BackgroundVideoTimeInfo(r100.readLong(), r100.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public final BackgroundVideoTimeInfo[] newArray(int r100) {
            return new BackgroundVideoTimeInfo[r100];
        }
    }

    static {
        CREATOR = new Creator();
    }

    public BackgroundVideoTimeInfo() {
        this(0, 0, 3, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeLong(this.startTime);
        r100.writeLong(this.endTime);
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public BackgroundVideoTimeInfo(long r100, long r101) {
        this.startTime = r100;
        this.endTime = r101;
    }

    public /* synthetic */ BackgroundVideoTimeInfo(long r100, long r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101);
    }
}
