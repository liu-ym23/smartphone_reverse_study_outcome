package com.bytedance.locallife.dito.common.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010#\u001a\u00020\u000bHÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003Jr\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\u000bHÖ\u0001J\t\u0010,\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001b¨\u0006-"}, d2 = {"Lcom/bytedance/locallife/dito/common/data/DitoPageStatusData;", "Ljava/io/Serializable;", "hasBackground", "", "errorTitle", "", "errorSubTitle", "emptyTitle", "emptySubTitle", "forceNight", "poiLoadingMode", "", "poiSkinMode", "needMob", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;IIZ)V", "getEmptySubTitle", "()Ljava/lang/String;", "getEmptyTitle", "getErrorSubTitle", "getErrorTitle", "getForceNight", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getHasBackground", "()Z", "getNeedMob", "getPoiLoadingMode", "()I", "getPoiSkinMode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;IIZ)Lcom/bytedance/locallife/dito/common/data/DitoPageStatusData;", "equals", "other", "", "hashCode", "toString", "dito-common-saas_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class DitoPageStatusData implements Serializable {

    @SerializedName("emptySubTitle")
    private final String emptySubTitle;

    @SerializedName("emptyTitle")
    private final String emptyTitle;

    @SerializedName("errorSubTitle")
    private final String errorSubTitle;

    @SerializedName("errorTitle")
    private final String errorTitle;

    @SerializedName("forceNight")
    private final Boolean forceNight;

    @SerializedName("hasBackground")
    private final boolean hasBackground;

    @SerializedName("needMob")
    private final boolean needMob;

    @SerializedName("poiLoadingMode")
    private final int poiLoadingMode;

    @SerializedName("poiSkinMode")
    private final int poiSkinMode;

    public DitoPageStatusData() {
        this(false, null, null, null, null, null, 0, 0, false, 511, null);
    }

    public static /* synthetic */ DitoPageStatusData copy$default(DitoPageStatusData r110, boolean r111, String r112, String r113, String r114, String r115, Boolean r116, int r117, int r118, boolean r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        boolean r100 = r110.hasBackground;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.errorTitle;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r102 = r110.errorSubTitle;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r103 = r110.emptyTitle;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r104 = r110.emptySubTitle;
    L23:
        if ((r210 & 32) == 0) goto L25;
        Boolean r105 = r110.forceNight;
    L27:
        if ((r210 & 64) == 0) goto L29;
        int r106 = r110.poiLoadingMode;
    L31:
        if ((r210 & 128) == 0) goto L33;
        int r107 = r110.poiSkinMode;
    L35:
        if ((r210 & 256) == 0) goto L37;
        boolean r108 = r110.needMob;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final boolean component1() {
        return this.hasBackground;
    }

    public final String component2() {
        return this.errorTitle;
    }

    public final String component3() {
        return this.errorSubTitle;
    }

    public final String component4() {
        return this.emptyTitle;
    }

    public final String component5() {
        return this.emptySubTitle;
    }

    public final Boolean component6() {
        return this.forceNight;
    }

    public final int component7() {
        return this.poiLoadingMode;
    }

    public final int component8() {
        return this.poiSkinMode;
    }

    public final boolean component9() {
        return this.needMob;
    }

    public final DitoPageStatusData copy(boolean r110, String r111, String r112, String r113, String r114, Boolean r115, int r116, int r117, boolean r210) {
        return new DitoPageStatusData(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DitoPageStatusData) == true) goto L8;
        return false;
    L8:
        DitoPageStatusData r101 = (DitoPageStatusData) r100;
        if (this.hasBackground == r101.hasBackground) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.errorTitle, r101.errorTitle) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.errorSubTitle, r101.errorSubTitle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.emptyTitle, r101.emptyTitle) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.emptySubTitle, r101.emptySubTitle) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.forceNight, r101.forceNight) == true) goto L27;
        return false;
    L27:
        if (this.poiLoadingMode == r101.poiLoadingMode) goto L30;
        return false;
    L30:
        if (this.poiSkinMode == r101.poiSkinMode) goto L33;
        return false;
    L33:
        if (this.needMob == r101.needMob) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.hasBackground == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        String r103 = this.errorTitle;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        String r107 = this.errorSubTitle;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.emptyTitle;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.emptySubTitle;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.forceNight;
        if (r116 == null) goto L26;
        r104 = r116.hashCode();
    L26:
        int r117 = (((((r115 + r104) * 31) + this.poiLoadingMode) * 31) + this.poiSkinMode) * 31;
        if (this.needMob == true) goto L31;
        r100 = 1237;
    L31:
        return r117 + r100;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "DitoPageStatusData(hasBackground=" + this.hasBackground + ", errorTitle=" + this.errorTitle + ", errorSubTitle=" + this.errorSubTitle + ", emptyTitle=" + this.emptyTitle + ", emptySubTitle=" + this.emptySubTitle + ", forceNight=" + this.forceNight + ", poiLoadingMode=" + this.poiLoadingMode + ", poiSkinMode=" + this.poiSkinMode + ", needMob=" + this.needMob + ')';
    }

    public final String getEmptySubTitle() {
        return this.emptySubTitle;
    }

    public final String getEmptyTitle() {
        return this.emptyTitle;
    }

    public final String getErrorSubTitle() {
        return this.errorSubTitle;
    }

    public final String getErrorTitle() {
        return this.errorTitle;
    }

    public final Boolean getForceNight() {
        return this.forceNight;
    }

    public final boolean getHasBackground() {
        return this.hasBackground;
    }

    public final boolean getNeedMob() {
        return this.needMob;
    }

    public final int getPoiLoadingMode() {
        return this.poiLoadingMode;
    }

    public final int getPoiSkinMode() {
        return this.poiSkinMode;
    }

    public DitoPageStatusData(boolean r100, String r101, String r102, String r103, String r104, Boolean r105, int r106, int r107, boolean r108) {
        this.hasBackground = r100;
        this.errorTitle = r101;
        this.errorSubTitle = r102;
        this.emptyTitle = r103;
        this.emptySubTitle = r104;
        this.forceNight = r105;
        this.poiLoadingMode = r106;
        this.poiSkinMode = r107;
        this.needMob = r108;
    }

    public /* synthetic */ DitoPageStatusData(boolean r110, String r111, String r112, String r113, String r114, Boolean r115, int r116, int r117, boolean r210, int r211, DefaultConstructorMarker r212) {
        boolean r100 = true;
        if ((r211 & 1) == 0) goto L5;
        boolean r101 = true;
    L6:
        String r102 = "";
        if ((r211 & 2) == 0) goto L9;
        String r103 = "";
    L11:
        if ((r211 & 4) == 0) goto L13;
        String r104 = "";
    L15:
        if ((r211 & 8) == 0) goto L17;
        String r105 = "";
    L19:
        if ((r211 & 16) != 0) goto L23;
        r102 = r114;
    L23:
        if ((r211 & 32) == 0) goto L25;
        Boolean r106 = null;
    L26:
        int r107 = 0;
        if ((r211 & 64) == 0) goto L29;
        int r108 = 0;
    L31:
        if ((r211 & 128) != 0) goto L35;
        r107 = r117;
    L35:
        if ((r211 & 256) != 0) goto L38;
        r100 = r210;
    L38:
        this(r101, r103, r104, r105, r102, r106, r108, r107, r100);
        return;
    L29:
        r108 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L26
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}
