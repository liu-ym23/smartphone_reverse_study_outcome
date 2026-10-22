package com.larus.voicecall.impl.degrade.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0006\u0010\u0016\u001a\u00020\u0017J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0017R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\""}, d2 = {"Lcom/larus/voicecall/impl/degrade/bean/QuotaInfo;", "Landroid/os/Parcelable;", "isOverQuota", "", "ctaResult", "Lcom/larus/voicecall/impl/degrade/bean/QuotaCtaResult;", "switchModalCtaToast", "", "limitType", "<init>", "(ZLcom/larus/voicecall/impl/degrade/bean/QuotaCtaResult;Ljava/lang/String;Ljava/lang/String;)V", "()Z", "getCtaResult", "()Lcom/larus/voicecall/impl/degrade/bean/QuotaCtaResult;", "getSwitchModalCtaToast", "()Ljava/lang/String;", "getLimitType", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QuotaInfo implements Parcelable {
    public static final Parcelable.Creator<QuotaInfo> CREATOR = null;

    @SerializedName("cta_result")
    private final QuotaCtaResult ctaResult;

    @SerializedName("is_over_quota")
    private final boolean isOverQuota;

    @SerializedName("limit_type")
    private final String limitType;

    @SerializedName("switch_modal_cta_toast")
    private final String switchModalCtaToast;

    public static final class a implements Parcelable.Creator<QuotaInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final QuotaInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            if (r100.readInt() == 0) goto L5;
            boolean r101 = true;
        L7:
            if (r100.readInt() != 0) goto L9;
            QuotaCtaResult r102 = null;
        L11:
            return new QuotaInfo(r101, r102, r100.readString(), r100.readString());
        L9:
            r102 = QuotaCtaResult.CREATOR.createFromParcel(r100);
            goto L11
        L5:
            r101 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final QuotaInfo[] newArray(int r100) {
            return new QuotaInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public QuotaInfo() {
        this(false, null, null, null, 15, null);
    }

    public static /* synthetic */ QuotaInfo copy$default(QuotaInfo r100, boolean r101, QuotaCtaResult r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.isOverQuota;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.ctaResult;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.switchModalCtaToast;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.limitType;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final boolean component1() {
        return this.isOverQuota;
    }

    public final QuotaCtaResult component2() {
        return this.ctaResult;
    }

    public final String component3() {
        return this.switchModalCtaToast;
    }

    public final String component4() {
        return this.limitType;
    }

    public final QuotaInfo copy(boolean r100, QuotaCtaResult r101, String r102, String r103) {
        return new QuotaInfo(r100, r101, r102, r103);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof QuotaInfo) == true) goto L8;
        return false;
    L8:
        QuotaInfo r101 = (QuotaInfo) r100;
        if (this.isOverQuota == r101.isOverQuota) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ctaResult, r101.ctaResult) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.switchModalCtaToast, r101.switchModalCtaToast) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.limitType, r101.limitType) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        if (this.isOverQuota == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        QuotaCtaResult r102 = this.ctaResult;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.switchModalCtaToast;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        String r109 = this.limitType;
        if (r109 == null) goto L19;
        r103 = r109.hashCode();
    L19:
        return r108 + r103;
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "QuotaInfo(isOverQuota=" + this.isOverQuota + ", ctaResult=" + this.ctaResult + ", switchModalCtaToast=" + this.switchModalCtaToast + ", limitType=" + this.limitType + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.isOverQuota ? 1 : 0);
        QuotaCtaResult r102 = this.ctaResult;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        r100.writeString(this.switchModalCtaToast);
        r100.writeString(this.limitType);
        return;
    L5:
        r100.writeInt(1);
        r102.writeToParcel(r100, r101);
        goto L6
    }

    public final QuotaCtaResult getCtaResult() {
        return this.ctaResult;
    }

    public final String getLimitType() {
        return this.limitType;
    }

    public final String getSwitchModalCtaToast() {
        return this.switchModalCtaToast;
    }

    public final boolean isOverQuota() {
        return this.isOverQuota;
    }

    public QuotaInfo(boolean r100, QuotaCtaResult r101, String r102, String r103) {
        this.isOverQuota = r100;
        this.ctaResult = r101;
        this.switchModalCtaToast = r102;
        this.limitType = r103;
    }

    public /* synthetic */ QuotaInfo(boolean r100, QuotaCtaResult r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
