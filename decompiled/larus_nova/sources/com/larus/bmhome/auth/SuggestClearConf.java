package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/larus/bmhome/auth/SuggestClearConf;", "Landroid/os/Parcelable;", "needClearRS", "", "clearRSIntervalSec", "", "<init>", "(ZJ)V", "getNeedClearRS", "()Z", "getClearRSIntervalSec", "()J", "setClearRSIntervalSec", "(J)V", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SuggestClearConf implements Parcelable {
    public static final Parcelable.Creator<SuggestClearConf> CREATOR = null;

    @SerializedName("clear_rs_interval_sec")
    private long clearRSIntervalSec;

    @SerializedName("need_clear_rs")
    private final boolean needClearRS;

    public static final class a implements Parcelable.Creator<SuggestClearConf> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SuggestClearConf createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            if (r100.readInt() == 0) goto L5;
            boolean r101 = true;
        L7:
            return new SuggestClearConf(r101, r100.readLong());
        L5:
            r101 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final SuggestClearConf[] newArray(int r100) {
            return new SuggestClearConf[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SuggestClearConf) == true) goto L8;
        return false;
    L8:
        SuggestClearConf r101 = (SuggestClearConf) r100;
        if (this.needClearRS == r101.needClearRS) goto L12;
        return false;
    L12:
        if (this.clearRSIntervalSec == r101.clearRSIntervalSec) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.needClearRS == false) goto L5;
        int r100 = 1231;
    L6:
        long r101 = this.clearRSIntervalSec;
        return (r100 * 31) + ((int) (r101 ^ (r101 >>> 32)));
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "SuggestClearConf(needClearRS=" + this.needClearRS + ", clearRSIntervalSec=" + this.clearRSIntervalSec + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.needClearRS ? 1 : 0);
        r100.writeLong(this.clearRSIntervalSec);
    }

    public SuggestClearConf() {
        this(false, 0);
    }

    public final long a() {
        return this.clearRSIntervalSec;
    }

    public final boolean b() {
        return this.needClearRS;
    }

    public SuggestClearConf(boolean r100, long r101) {
        this.needClearRS = r100;
        this.clearRSIntervalSec = r101;
    }
}
