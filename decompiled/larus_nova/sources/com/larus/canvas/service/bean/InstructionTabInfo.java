package com.larus.canvas.service.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J2\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\u0003J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/canvas/service/bean/InstructionTabInfo;", "Landroid/os/Parcelable;", "aiBeautifyId", "", "tabLabel", "", "optionId", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "Ljava/lang/Integer;", "component1", "()Ljava/lang/Integer;", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/canvas/service/bean/InstructionTabInfo;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InstructionTabInfo implements Parcelable {
    public static final Parcelable.Creator<InstructionTabInfo> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f323813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f323814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f323815c;

    public static final class a implements Parcelable.Creator<InstructionTabInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final InstructionTabInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            if (r100.readInt() != 0) goto L5;
            Integer r101 = null;
        L7:
            return new InstructionTabInfo(r101, r100.readString(), r100.readString());
        L5:
            r101 = Integer.valueOf(r100.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final InstructionTabInfo[] newArray(int r100) {
            return new InstructionTabInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public InstructionTabInfo() {
        this(null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof InstructionTabInfo) == true) goto L8;
        return false;
    L8:
        InstructionTabInfo r101 = (InstructionTabInfo) r100;
        if (Intrinsics.areEqual(this.f323813a, r101.f323813a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f323814b, r101.f323814b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f323815c, r101.f323815c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f323813a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f323814b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f323815c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "InstructionTabInfo(aiBeautifyId=" + this.f323813a + ", tabLabel=" + this.f323814b + ", optionId=" + this.f323815c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        Integer r102 = this.f323813a;
        if (r102 != null) goto L5;
        int r103 = 0;
    L6:
        r100.writeInt(r103);
        r100.writeString(this.f323814b);
        r100.writeString(this.f323815c);
        return;
    L5:
        r100.writeInt(1);
        r103 = r102.intValue();
        goto L6
    }

    public InstructionTabInfo(Integer r100, String r101, String r102) {
        this.f323813a = r100;
        this.f323814b = r101;
        this.f323815c = r102;
    }
}
