package com.ss.android.ugc.aweme.shortvideo;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006$"}, d2 = {"Lcom/ss/android/ugc/aweme/shortvideo/DuetLayoutInfo;", "Landroid/os/Parcelable;", "type", "", "x1", "", "y1", "x2", "y2", "(IFFFF)V", "getType", "()I", "getX1", "()F", "getX2", "getY1", "getY2", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public final class DuetLayoutInfo implements Parcelable {
    public static final Parcelable.Creator<DuetLayoutInfo> CREATOR = null;
    private final int type;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    private final float f454165x1;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    private final float f454166x2;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    private final float f454167y1;

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    private final float f454168y2;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public static class Creator implements Parcelable.Creator<DuetLayoutInfo> {
        public Creator() {
        }

        @Override // android.os.Parcelable.Creator
        public final DuetLayoutInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            return new DuetLayoutInfo(r100.readInt(), r100.readFloat(), r100.readFloat(), r100.readFloat(), r100.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        public final DuetLayoutInfo[] newArray(int r100) {
            return new DuetLayoutInfo[r100];
        }
    }

    static {
        CREATOR = new Creator();
    }

    public DuetLayoutInfo() {
        this(0, 0.0f, 0.0f, 0.0f, 0.0f, 31, null);
    }

    public static /* synthetic */ DuetLayoutInfo copy$default(DuetLayoutInfo r100, int r101, float r102, float r103, float r104, float r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.f454165x1;
    L8:
        float r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.f454167y1;
    L11:
        float r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.f454166x2;
    L14:
        float r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.f454168y2;
    L17:
        int r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final int component1() {
        return this.type;
    }

    public final float component2() {
        return this.f454165x1;
    }

    public final float component3() {
        return this.f454167y1;
    }

    public final float component4() {
        return this.f454166x2;
    }

    public final float component5() {
        return this.f454168y2;
    }

    public final DuetLayoutInfo copy(int r100, float r101, float r110, float r111, float r112) {
        return new DuetLayoutInfo(r100, r101, r110, r111, r112);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof DuetLayoutInfo) == false) goto L16;
        DuetLayoutInfo r101 = (DuetLayoutInfo) r100;
        if (this.type == r101.type) goto L8;
        return false;
    L8:
        if (Float.compare(this.f454165x1, r101.f454165x1) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f454167y1, r101.f454167y1) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f454166x2, r101.f454166x2) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.f454168y2, r101.f454168y2) == 0) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        return (((((((this.type * 31) + Float.floatToIntBits(this.f454165x1)) * 31) + Float.floatToIntBits(this.f454167y1)) * 31) + Float.floatToIntBits(this.f454166x2)) * 31) + Float.floatToIntBits(this.f454168y2);
    }

    public String toString() {
        return "DuetLayoutInfo(type=" + this.type + ", x1=" + this.f454165x1 + ", y1=" + this.f454167y1 + ", x2=" + this.f454166x2 + ", y2=" + this.f454168y2 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.type);
        r100.writeFloat(this.f454165x1);
        r100.writeFloat(this.f454167y1);
        r100.writeFloat(this.f454166x2);
        r100.writeFloat(this.f454168y2);
    }

    public final int getType() {
        return this.type;
    }

    public final float getX1() {
        return this.f454165x1;
    }

    public final float getX2() {
        return this.f454166x2;
    }

    public final float getY1() {
        return this.f454167y1;
    }

    public final float getY2() {
        return this.f454168y2;
    }

    public DuetLayoutInfo(int r100, float r101, float r102, float r103, float r104) {
        this.type = r100;
        this.f454165x1 = r101;
        this.f454167y1 = r102;
        this.f454166x2 = r103;
        this.f454168y2 = r104;
    }

    public /* synthetic */ DuetLayoutInfo(int r100, float r101, float r102, float r103, float r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L5;
        r100 = -1;
    L5:
        float r106 = 0.0f;
        if ((r105 & 2) == 0) goto L8;
        float r111 = 0.0f;
    L10:
        if ((r105 & 4) == 0) goto L12;
        float r107 = 0.0f;
    L14:
        if ((r105 & 8) == 0) goto L16;
        float r108 = 0.0f;
    L18:
        if ((r105 & 16) != 0) goto L21;
        r106 = r104;
    L21:
        this(r100, r111, r107, r108, r106);
        return;
    L16:
        r108 = r103;
        goto L18
    L12:
        r107 = r102;
        goto L14
    L8:
        r111 = r101;
        goto L10
    }
}
