package com.larus.voicecall.impl.degrade.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0003J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/larus/voicecall/impl/degrade/bean/Strategy;", "Landroid/os/Parcelable;", "level", "", "extra", "Lcom/larus/voicecall/impl/degrade/bean/Extra;", "<init>", "(ILcom/larus/voicecall/impl/degrade/bean/Extra;)V", "getLevel", "()I", "getExtra", "()Lcom/larus/voicecall/impl/degrade/bean/Extra;", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Strategy implements Parcelable {
    public static final Parcelable.Creator<Strategy> CREATOR = null;

    @SerializedName("extra")
    private final Extra extra;

    @SerializedName("level")
    private final int level;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a implements Parcelable.Creator<Strategy> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Strategy createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            int r101 = r100.readInt();
            if (r100.readInt() != 0) goto L5;
            Extra r102 = null;
        L7:
            return new Strategy(r101, r102);
        L5:
            r102 = Extra.CREATOR.createFromParcel(r100);
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final Strategy[] newArray(int r100) {
            return new Strategy[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Strategy() {
        int r100 = 0;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ Strategy copy$default(Strategy r100, int r101, Extra r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.level;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.extra;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.level;
    }

    public final Extra component2() {
        return this.extra;
    }

    public final Strategy copy(int r100, Extra r101) {
        return new Strategy(r100, r101);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Strategy) == true) goto L8;
        return false;
    L8:
        Strategy r101 = (Strategy) r100;
        if (this.level == r101.level) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.level * 31;
        Extra r101 = this.extra;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "Strategy(level=" + this.level + ", extra=" + this.extra + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.level);
        Extra r102 = this.extra;
        if (r102 != null) goto L5;
        r100.writeInt(0);
        return;
    L5:
        r100.writeInt(1);
        r102.writeToParcel(r100, r101);
    }

    public final Extra getExtra() {
        return this.extra;
    }

    public final int getLevel() {
        return this.level;
    }

    public Strategy(int r100, Extra r101) {
        this.level = r100;
        this.extra = r101;
    }

    public /* synthetic */ Strategy(int r100, Extra r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
