package com.larus.bmhome.chat.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/larus/bmhome/chat/bean/PopWindowMediaSize;", "Landroid/os/Parcelable;", "width", "", "height", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;)V", "getWidth", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getHeight", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/Long;)Lcom/larus/bmhome/chat/bean/PopWindowMediaSize;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PopWindowMediaSize implements Parcelable {
    public static final Parcelable.Creator<PopWindowMediaSize> CREATOR = null;

    @SerializedName("height")
    private final Long height;

    @SerializedName("width")
    private final Long width;

    public static final class a implements Parcelable.Creator<PopWindowMediaSize> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PopWindowMediaSize createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Long r101 = null;
            if (r100.readInt() != 0) goto L5;
            Long r102 = null;
        L7:
            if (r100.readInt() == 0) goto L11;
            r101 = Long.valueOf(r100.readLong());
        L11:
            return new PopWindowMediaSize(r102, r101);
        L5:
            r102 = Long.valueOf(r100.readLong());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final PopWindowMediaSize[] newArray(int r100) {
            return new PopWindowMediaSize[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PopWindowMediaSize() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PopWindowMediaSize copy$default(PopWindowMediaSize r100, Long r101, Long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.width;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.height;
    L9:
        return r100.copy(r101, r102);
    }

    public final Long component1() {
        return this.width;
    }

    public final Long component2() {
        return this.height;
    }

    public final PopWindowMediaSize copy(Long r100, Long r101) {
        return new PopWindowMediaSize(r100, r101);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PopWindowMediaSize) == true) goto L8;
        return false;
    L8:
        PopWindowMediaSize r101 = (PopWindowMediaSize) r100;
        if (Intrinsics.areEqual(this.width, r101.width) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Long r100 = this.width;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.height;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "PopWindowMediaSize(width=" + this.width + ", height=" + this.height + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        Long r102 = this.width;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Long r103 = this.height;
        if (r103 != null) goto L9;
        r100.writeInt(0);
        return;
    L9:
        r100.writeInt(1);
        r100.writeLong(r103.longValue());
        return;
    L5:
        r100.writeInt(1);
        r100.writeLong(r102.longValue());
        goto L6
    }

    public final Long getHeight() {
        return this.height;
    }

    public final Long getWidth() {
        return this.width;
    }

    public PopWindowMediaSize(Long r100, Long r101) {
        this.width = r100;
        this.height = r101;
    }

    public /* synthetic */ PopWindowMediaSize(Long r100, Long r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
