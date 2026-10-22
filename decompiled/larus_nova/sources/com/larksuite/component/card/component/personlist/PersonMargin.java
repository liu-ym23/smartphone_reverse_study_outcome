package com.larksuite.component.card.component.personlist;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u0013\u001a\u00020\u0003J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006 "}, d2 = {"Lcom/larksuite/component/card/component/personlist/PersonMargin;", "Landroid/os/Parcelable;", "left", "", "right", "top", "bottom", "<init>", "(IIII)V", "getLeft", "()I", "getRight", "getTop", "getBottom", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PersonMargin implements Parcelable {
    public static final Parcelable.Creator<PersonMargin> CREATOR = null;
    private final int bottom;
    private final int left;
    private final int right;
    private final int top;

    public static final class a implements Parcelable.Creator<PersonMargin> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PersonMargin createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new PersonMargin(r100.readInt(), r100.readInt(), r100.readInt(), r100.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final PersonMargin[] newArray(int r100) {
            return new PersonMargin[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ PersonMargin copy$default(PersonMargin r100, int r101, int r102, int r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.left;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.right;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.top;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.bottom;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.left;
    }

    public final int component2() {
        return this.right;
    }

    public final int component3() {
        return this.top;
    }

    public final int component4() {
        return this.bottom;
    }

    public final PersonMargin copy(int r100, int r101, int r102, int r103) {
        return new PersonMargin(r100, r101, r102, r103);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PersonMargin) == true) goto L8;
        return false;
    L8:
        PersonMargin r101 = (PersonMargin) r100;
        if (this.left == r101.left) goto L12;
        return false;
    L12:
        if (this.right == r101.right) goto L15;
        return false;
    L15:
        if (this.top == r101.top) goto L18;
        return false;
    L18:
        if (this.bottom == r101.bottom) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.left * 31) + this.right) * 31) + this.top) * 31) + this.bottom;
    }

    public String toString() {
        return "PersonMargin(left=" + this.left + ", right=" + this.right + ", top=" + this.top + ", bottom=" + this.bottom + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.left);
        r100.writeInt(this.right);
        r100.writeInt(this.top);
        r100.writeInt(this.bottom);
    }

    public final int getBottom() {
        return this.bottom;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getRight() {
        return this.right;
    }

    public final int getTop() {
        return this.top;
    }

    public PersonMargin(int r100, int r101, int r102, int r103) {
        this.left = r100;
        this.right = r101;
        this.top = r102;
        this.bottom = r103;
    }
}
