package com.larus.home.impl.main.browser;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u001a"}, d2 = {"Lcom/larus/home/impl/main/browser/BrowserWhiteModel;", "Landroid/os/Parcelable;", "needVerifyCode", "", "<init>", "(Ljava/lang/Boolean;)V", "getNeedVerifyCode", "()Ljava/lang/Boolean;", "setNeedVerifyCode", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/larus/home/impl/main/browser/BrowserWhiteModel;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BrowserWhiteModel implements Parcelable {
    public static final Parcelable.Creator<BrowserWhiteModel> CREATOR = null;

    @SerializedName("need_verify_code")
    private Boolean needVerifyCode;

    public static final class a implements Parcelable.Creator<BrowserWhiteModel> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BrowserWhiteModel createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            if (r100.readInt() != 0) goto L6;
            Boolean r101 = null;
        L11:
            return new BrowserWhiteModel(r101);
        L6:
            if (r100.readInt() == 0) goto L8;
            boolean r102 = true;
        L9:
            r101 = Boolean.valueOf(r102);
            goto L11
        L8:
            r102 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final BrowserWhiteModel[] newArray(int r100) {
            return new BrowserWhiteModel[r100];
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
        if ((r100 instanceof BrowserWhiteModel) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.needVerifyCode, ((BrowserWhiteModel) r100).needVerifyCode) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.needVerifyCode;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "BrowserWhiteModel(needVerifyCode=" + this.needVerifyCode + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.Parcel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        Boolean r102 = this.needVerifyCode;
        if (r102 != null) goto L6;
        ?? r103 = 0;
    L5:
        r100.writeInt(r103);
        return;
    L6:
        r100.writeInt(1);
        r103 = r102.booleanValue();
        goto L5
    }

    public BrowserWhiteModel() {
        this(Boolean.TRUE);
    }

    public final Boolean a() {
        return this.needVerifyCode;
    }

    public BrowserWhiteModel(Boolean r100) {
        this.needVerifyCode = r100;
    }
}
