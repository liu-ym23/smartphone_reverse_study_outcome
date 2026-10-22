package com.ss.android.ugc.aweme.poi.coi;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J7\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/coi/ADInfoData;", "Ljava/io/Serializable;", "adExtra", "", "logExtra", "creativeId", "adSourceType", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAdExtra", "()Ljava/lang/String;", "getAdSourceType", "()I", "getCreativeId", "getLogExtra", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class ADInfoData implements Serializable {
    public static final Companion Companion = null;
    public static final int SOURCE_TYPE_DEFAULT = 1;
    public static final int SOURCE_TYPE_HARD_AD = 1;
    public static final int SOURCE_TYPE_SOFT_AD = 2;

    @SerializedName("ad_extra")
    private final String adExtra;

    @SerializedName("ad_source_type")
    private final int adSourceType;

    @SerializedName("creative_id")
    private final String creativeId;

    @SerializedName("log_extra")
    private final String logExtra;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/coi/ADInfoData$Companion;", "", "()V", "SOURCE_TYPE_DEFAULT", "", "SOURCE_TYPE_HARD_AD", "SOURCE_TYPE_SOFT_AD", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        Companion = new Companion(0);
    }

    public ADInfoData() {
        this(null, null, null, 0, 15, null);
    }

    public static /* synthetic */ ADInfoData copy$default(ADInfoData r100, String r101, String r102, String r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.adExtra;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.logExtra;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.creativeId;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.adSourceType;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.adExtra;
    }

    public final String component2() {
        return this.logExtra;
    }

    public final String component3() {
        return this.creativeId;
    }

    public final int component4() {
        return this.adSourceType;
    }

    public final ADInfoData copy(String r100, String r101, String r102, int r103) {
        return new ADInfoData(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ADInfoData) == true) goto L8;
        return false;
    L8:
        ADInfoData r101 = (ADInfoData) r100;
        if (Intrinsics.areEqual(this.adExtra, r101.adExtra) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.logExtra, r101.logExtra) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.creativeId, r101.creativeId) == true) goto L18;
        return false;
    L18:
        if (this.adSourceType == r101.adSourceType) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.adExtra;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.logExtra;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.creativeId;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return ((r106 + r101) * 31) + this.adSourceType;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ADInfoData(adExtra=" + this.adExtra + ", logExtra=" + this.logExtra + ", creativeId=" + this.creativeId + ", adSourceType=" + this.adSourceType + ')';
    }

    public final String getAdExtra() {
        return this.adExtra;
    }

    public final int getAdSourceType() {
        return this.adSourceType;
    }

    public final String getCreativeId() {
        return this.creativeId;
    }

    public final String getLogExtra() {
        return this.logExtra;
    }

    public ADInfoData(String r100, String r101, String r102, int r103) {
        this.adExtra = r100;
        this.logExtra = r101;
        this.creativeId = r102;
        this.adSourceType = r103;
    }

    public /* synthetic */ ADInfoData(String r100, String r101, String r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 0;
    L14:
        this(r100, r101, r102, r103);
    }
}
