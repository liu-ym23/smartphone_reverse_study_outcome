package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0006\"\u0004\b\u0007\u0010\u0005¨\u0006\u0017"}, d2 = {"Lcom/larus/bmhome/auth/BotCellAbConf;", "Landroid/os/Parcelable;", "isHit", "", "<init>", "(Z)V", "()Z", "setHit", "component1", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotCellAbConf implements Parcelable {
    public static final Parcelable.Creator<BotCellAbConf> CREATOR = null;

    @SerializedName("is_hit")
    private boolean isHit;

    /* JADX INFO: loaded from: classes25.dex */
    public static final class a implements Parcelable.Creator<BotCellAbConf> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BotCellAbConf createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            if (r100.readInt() == 0) goto L5;
            boolean r101 = true;
        L7:
            return new BotCellAbConf(r101);
        L5:
            r101 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final BotCellAbConf[] newArray(int r100) {
            return new BotCellAbConf[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public BotCellAbConf() {
        this(false);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BotCellAbConf) == true) goto L9;
        return false;
    L9:
        if (this.isHit == ((BotCellAbConf) r100).isHit) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.isHit == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "BotCellAbConf(isHit=" + this.isHit + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.isHit ? 1 : 0);
    }

    public final boolean a() {
        return this.isHit;
    }

    public BotCellAbConf(boolean r100) {
        this.isHit = r100;
    }
}
