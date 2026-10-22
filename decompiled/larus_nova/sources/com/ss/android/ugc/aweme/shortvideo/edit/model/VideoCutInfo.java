package com.ss.android.ugc.aweme.shortvideo.edit.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.ugc.aweme.creative.CreativeSuppressCheck;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J1\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\t\u0010\u001e\u001a\u00020\tHÖ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\tHÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001J\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\tHÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e¨\u0006+"}, d2 = {"Lcom/ss/android/ugc/aweme/shortvideo/edit/model/VideoCutInfo;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "start", "", "end", "speed", "", "rotate", "", "(JJFI)V", "getEnd", "()J", "setEnd", "(J)V", "getRotate", "()I", "setRotate", "(I)V", "getSpeed", "()F", "setSpeed", "(F)V", "getStart", "setStart", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "lib-api_release"}, k = 1, mv = {1, 4, 1})
@CreativeSuppressCheck
public final class VideoCutInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<VideoCutInfo> CREATOR = null;
    private long end;
    private int rotate;
    private float speed;
    private long start;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public static class Creator implements Parcelable.Creator<VideoCutInfo> {
        public Creator() {
        }

        @Override // android.os.Parcelable.Creator
        public final VideoCutInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            return new VideoCutInfo(r100.readLong(), r100.readLong(), r100.readFloat(), r100.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final VideoCutInfo[] newArray(int r100) {
            return new VideoCutInfo[r100];
        }
    }

    static {
        CREATOR = new Creator();
    }

    public static /* synthetic */ VideoCutInfo copy$default(VideoCutInfo r100, long r101, long r110, float r111, int r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L5;
        r101 = r100.start;
    L5:
        long r102 = r101;
        if ((r113 & 2) == 0) goto L8;
        r110 = r100.end;
    L8:
        long r103 = r110;
        if ((r113 & 4) == 0) goto L11;
        r111 = r100.speed;
    L11:
        float r104 = r111;
        if ((r113 & 8) == 0) goto L15;
        r112 = r100.rotate;
    L15:
        return r100.copy(r102, r103, r104, r112);
    }

    public final long component1() {
        return this.start;
    }

    public final long component2() {
        return this.end;
    }

    public final float component3() {
        return this.speed;
    }

    public final int component4() {
        return this.rotate;
    }

    public final VideoCutInfo copy(long r100, long r110, float r111, int r112) {
        return new VideoCutInfo(r100, r110, r111, r112);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof VideoCutInfo) == false) goto L14;
        VideoCutInfo r101 = (VideoCutInfo) r100;
        if (this.start == r101.start) goto L8;
        return false;
    L8:
        if (this.end == r101.end) goto L10;
        return false;
    L10:
        if (Float.compare(this.speed, r101.speed) == 0) goto L12;
        return false;
    L12:
        if (this.rotate == r101.rotate) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        long r100 = this.start;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.end;
        return ((((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + Float.floatToIntBits(this.speed)) * 31) + this.rotate;
    }

    public String toString() {
        return "VideoCutInfo(start=" + this.start + ", end=" + this.end + ", speed=" + this.speed + ", rotate=" + this.rotate + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeLong(this.start);
        r100.writeLong(this.end);
        r100.writeFloat(this.speed);
        r100.writeInt(this.rotate);
    }

    public final long getEnd() {
        return this.end;
    }

    public final int getRotate() {
        return this.rotate;
    }

    public final float getSpeed() {
        return this.speed;
    }

    public final long getStart() {
        return this.start;
    }

    public final void setEnd(long r100) {
        this.end = r100;
    }

    public final void setRotate(int r100) {
        this.rotate = r100;
    }

    public final void setSpeed(float r100) {
        this.speed = r100;
    }

    public final void setStart(long r100) {
        this.start = r100;
    }

    public VideoCutInfo(long r100, long r101, float r102, int r103) {
        this.start = r100;
        this.end = r101;
        this.speed = r102;
        this.rotate = r103;
    }
}
