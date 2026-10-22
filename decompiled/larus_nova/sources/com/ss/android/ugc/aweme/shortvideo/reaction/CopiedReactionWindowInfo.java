package com.ss.android.ugc.aweme.shortvideo.reaction;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B-\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007¢\u0006\u0002\u0010\fJ\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\nHÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0007HÆ\u0001J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0018\u0010 \u001a\u00020!2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0007H\u0016R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u000b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006$"}, d2 = {"Lcom/ss/android/ugc/aweme/shortvideo/reaction/CopiedReactionWindowInfo;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "width", "", "height", "angle", "", "type", "(IIFI)V", "getAngle", "()F", "getHeight", "()I", "getType", "getWidth", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "flags", "CREATOR", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class CopiedReactionWindowInfo implements Parcelable, Serializable {
    public static final CREATOR CREATOR = null;

    @SerializedName("react_angle")
    private final float angle;

    @SerializedName("react_height")
    private final int height;

    @SerializedName("react_type")
    private final int type;

    @SerializedName("react_width")
    private final int width;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/shortvideo/reaction/CopiedReactionWindowInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/ss/android/ugc/aweme/shortvideo/reaction/CopiedReactionWindowInfo;", "<init>", "()V", "lib-api_release"}, k = 1, mv = {1, 4, 1})
    public static final class CREATOR implements Parcelable.Creator<CopiedReactionWindowInfo> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(int r100) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public final CopiedReactionWindowInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new CopiedReactionWindowInfo(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final CopiedReactionWindowInfo[] newArray(int r100) {
            return new CopiedReactionWindowInfo[r100];
        }
    }

    static {
        CREATOR = new CREATOR(0);
    }

    public CopiedReactionWindowInfo() {
        this(0, 0, 0.0f, 0, 15, null);
    }

    public static /* synthetic */ CopiedReactionWindowInfo copy$default(CopiedReactionWindowInfo r100, int r101, int r102, float r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.width;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.height;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.angle;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.type;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.width;
    }

    public final int component2() {
        return this.height;
    }

    public final float component3() {
        return this.angle;
    }

    public final int component4() {
        return this.type;
    }

    public final CopiedReactionWindowInfo copy(int r100, int r101, float r102, int r103) {
        return new CopiedReactionWindowInfo(r100, r101, r102, r103);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CopiedReactionWindowInfo) == false) goto L14;
        CopiedReactionWindowInfo r101 = (CopiedReactionWindowInfo) r100;
        if (this.width == r101.width) goto L8;
        return false;
    L8:
        if (this.height == r101.height) goto L10;
        return false;
    L10:
        if (Float.compare(this.angle, r101.angle) == 0) goto L12;
        return false;
    L12:
        if (this.type == r101.type) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        return (((((this.width * 31) + this.height) * 31) + Float.floatToIntBits(this.angle)) * 31) + this.type;
    }

    public String toString() {
        return "CopiedReactionWindowInfo(width=" + this.width + ", height=" + this.height + ", angle=" + this.angle + ", type=" + this.type + ")";
    }

    public final float getAngle() {
        return this.angle;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getType() {
        return this.type;
    }

    public final int getWidth() {
        return this.width;
    }

    public CopiedReactionWindowInfo(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this(r100.readInt(), r100.readInt(), r100.readFloat(), r100.readInt());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.width);
        r100.writeInt(this.height);
        r100.writeFloat(this.angle);
        r100.writeInt(this.type);
    }

    public CopiedReactionWindowInfo(int r100, int r101, float r102, int r103) {
        this.width = r100;
        this.height = r101;
        this.angle = r102;
        this.type = r103;
    }

    public /* synthetic */ CopiedReactionWindowInfo(int r100, int r101, float r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 0;
    L14:
        this(r100, r101, r102, r103);
    }
}
