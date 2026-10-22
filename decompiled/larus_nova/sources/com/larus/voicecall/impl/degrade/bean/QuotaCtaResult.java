package com.larus.voicecall.impl.degrade.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003JC\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0006\u0010\u0018\u001a\u00020\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0019R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006%"}, d2 = {"Lcom/larus/voicecall/impl/degrade/bean/QuotaCtaResult;", "Landroid/os/Parcelable;", "ctaGuideTitle", "", "guideContent", "imageUrl", "actionUrl", "displayDurationMSec", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getCtaGuideTitle", "()Ljava/lang/String;", "getGuideContent", "getImageUrl", "getActionUrl", "getDisplayDurationMSec", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QuotaCtaResult implements Parcelable {
    public static final Parcelable.Creator<QuotaCtaResult> CREATOR = null;

    @SerializedName("action_url")
    private final String actionUrl;

    @SerializedName("cta_guide_title")
    private final String ctaGuideTitle;

    @SerializedName("display_duration_msec")
    private final long displayDurationMSec;

    @SerializedName("guide_content")
    private final String guideContent;

    @SerializedName("image_url")
    private final String imageUrl;

    public static final class a implements Parcelable.Creator<QuotaCtaResult> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final QuotaCtaResult createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new QuotaCtaResult(r100.readString(), r100.readString(), r100.readString(), r100.readString(), r100.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public final QuotaCtaResult[] newArray(int r100) {
            return new QuotaCtaResult[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public QuotaCtaResult() {
        this(null, null, null, null, 0, 31, null);
    }

    public static /* synthetic */ QuotaCtaResult copy$default(QuotaCtaResult r100, String r101, String r102, String r103, String r104, long r105, int r110, Object r111) {
        if ((r110 & 1) == 0) goto L6;
        r101 = r100.ctaGuideTitle;
    L6:
        if ((r110 & 2) == 0) goto L8;
        r102 = r100.guideContent;
    L8:
        String r112 = r102;
        if ((r110 & 4) == 0) goto L11;
        r103 = r100.imageUrl;
    L11:
        String r106 = r103;
        if ((r110 & 8) == 0) goto L14;
        r104 = r100.actionUrl;
    L14:
        String r107 = r104;
        if ((r110 & 16) == 0) goto L17;
        r105 = r100.displayDurationMSec;
    L17:
        String r108 = r101;
        return r100.copy(r108, r112, r106, r107, r105);
    }

    public final String component1() {
        return this.ctaGuideTitle;
    }

    public final String component2() {
        return this.guideContent;
    }

    public final String component3() {
        return this.imageUrl;
    }

    public final String component4() {
        return this.actionUrl;
    }

    public final long component5() {
        return this.displayDurationMSec;
    }

    public final QuotaCtaResult copy(String r100, String r110, String r111, String r112, long r113) {
        return new QuotaCtaResult(r100, r110, r111, r112, r113);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof QuotaCtaResult) == true) goto L8;
        return false;
    L8:
        QuotaCtaResult r101 = (QuotaCtaResult) r100;
        if (Intrinsics.areEqual(this.ctaGuideTitle, r101.ctaGuideTitle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.guideContent, r101.guideContent) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.imageUrl, r101.imageUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.actionUrl, r101.actionUrl) == true) goto L21;
        return false;
    L21:
        if (this.displayDurationMSec == r101.displayDurationMSec) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.ctaGuideTitle;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.guideContent;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.imageUrl;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.actionUrl;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        int r111 = (r109 + r101) * 31;
        long r112 = this.displayDurationMSec;
        return r111 + ((int) (r112 ^ (r112 >>> 32)));
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "QuotaCtaResult(ctaGuideTitle=" + this.ctaGuideTitle + ", guideContent=" + this.guideContent + ", imageUrl=" + this.imageUrl + ", actionUrl=" + this.actionUrl + ", displayDurationMSec=" + this.displayDurationMSec + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.ctaGuideTitle);
        r100.writeString(this.guideContent);
        r100.writeString(this.imageUrl);
        r100.writeString(this.actionUrl);
        r100.writeLong(this.displayDurationMSec);
    }

    public final String getActionUrl() {
        return this.actionUrl;
    }

    public final String getCtaGuideTitle() {
        return this.ctaGuideTitle;
    }

    public final long getDisplayDurationMSec() {
        return this.displayDurationMSec;
    }

    public final String getGuideContent() {
        return this.guideContent;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public QuotaCtaResult(String r100, String r101, String r102, String r103, long r104) {
        this.ctaGuideTitle = r100;
        this.guideContent = r101;
        this.imageUrl = r102;
        this.actionUrl = r103;
        this.displayDurationMSec = r104;
    }

    public /* synthetic */ QuotaCtaResult(String r100, String r101, String r102, String r103, long r104, int r110, DefaultConstructorMarker r111) {
        String r105 = null;
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r106 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r107 = null;
    L15:
        if ((r110 & 8) != 0) goto L19;
        r105 = r103;
    L19:
        if ((r110 & 16) == 0) goto L21;
        r104 = 3000;
    L21:
        this(r112, r106, r107, r105, r104);
        return;
    L13:
        r107 = r102;
        goto L15
    L9:
        r106 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
