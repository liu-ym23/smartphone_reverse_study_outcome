package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u0012\u001a\u00020\u0005J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0005R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/larus/bmhome/auth/ConvRecommendBotConf;", "Landroid/os/Parcelable;", "enable", "", "mode", "", "loopSeconds", "<init>", "(ZII)V", "getEnable", "()Z", "getMode", "()I", "getLoopSeconds", "component1", "component2", "component3", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConvRecommendBotConf implements Parcelable {
    public static final Parcelable.Creator<ConvRecommendBotConf> CREATOR = null;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("loop_seconds")
    private final int loopSeconds;

    @SerializedName("mode")
    private final int mode;

    /* JADX INFO: loaded from: classes25.dex */
    public static final class a implements Parcelable.Creator<ConvRecommendBotConf> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ConvRecommendBotConf createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            if (r100.readInt() == 0) goto L5;
            boolean r101 = true;
        L7:
            return new ConvRecommendBotConf(r101, r100.readInt(), r100.readInt());
        L5:
            r101 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ConvRecommendBotConf[] newArray(int r100) {
            return new ConvRecommendBotConf[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ConvRecommendBotConf() {
        this(false, 0, 0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ConvRecommendBotConf) == true) goto L8;
        return false;
    L8:
        ConvRecommendBotConf r101 = (ConvRecommendBotConf) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (this.mode == r101.mode) goto L15;
        return false;
    L15:
        if (this.loopSeconds == r101.loopSeconds) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.enable == false) goto L5;
        int r100 = 1231;
    L7:
        return (((r100 * 31) + this.mode) * 31) + this.loopSeconds;
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "ConvRecommendBotConf(enable=" + this.enable + ", mode=" + this.mode + ", loopSeconds=" + this.loopSeconds + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.enable ? 1 : 0);
        r100.writeInt(this.mode);
        r100.writeInt(this.loopSeconds);
    }

    public final boolean a() {
        return this.enable;
    }

    public final int b() {
        return this.loopSeconds;
    }

    public final int c() {
        return this.mode;
    }

    public ConvRecommendBotConf(boolean r100, int r101, int r102) {
        this.enable = r100;
        this.mode = r101;
        this.loopSeconds = r102;
    }
}
