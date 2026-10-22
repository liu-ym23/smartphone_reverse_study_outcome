package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0017\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u000bHÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\tHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\bHÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/CommonProp;", "Ljava/io/Serializable;", "clickAction", "Lcom/ss/android/ugc/aweme/discover/model/ClickAction;", "backgroundConfig", "Lcom/ss/android/ugc/aweme/discover/model/BackgroundConfig;", "logInfo", "", "", "", "regionInfo", "Lcom/ss/android/ugc/aweme/discover/model/RegionInfo;", "(Lcom/ss/android/ugc/aweme/discover/model/ClickAction;Lcom/ss/android/ugc/aweme/discover/model/BackgroundConfig;Ljava/util/Map;Lcom/ss/android/ugc/aweme/discover/model/RegionInfo;)V", "getBackgroundConfig", "()Lcom/ss/android/ugc/aweme/discover/model/BackgroundConfig;", "getClickAction", "()Lcom/ss/android/ugc/aweme/discover/model/ClickAction;", "getLogInfo", "()Ljava/util/Map;", "getRegionInfo", "()Lcom/ss/android/ugc/aweme/discover/model/RegionInfo;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonProp implements Serializable {

    @SerializedName("bg_config")
    private final BackgroundConfig backgroundConfig;

    @SerializedName("click_action")
    private final ClickAction clickAction;

    @SerializedName("log_info")
    private final Map<String, Object> logInfo;

    @SerializedName("region_info")
    private final RegionInfo regionInfo;

    public CommonProp() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CommonProp copy$default(CommonProp r100, ClickAction r101, BackgroundConfig r102, Map r103, RegionInfo r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.clickAction;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.backgroundConfig;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.logInfo;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.regionInfo;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final ClickAction component1() {
        return this.clickAction;
    }

    public final BackgroundConfig component2() {
        return this.backgroundConfig;
    }

    public final Map<String, Object> component3() {
        return this.logInfo;
    }

    public final RegionInfo component4() {
        return this.regionInfo;
    }

    public final CommonProp copy(ClickAction r100, BackgroundConfig r101, Map<String, ? extends Object> r102, RegionInfo r103) {
        return new CommonProp(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CommonProp) == false) goto L14;
        CommonProp r101 = (CommonProp) r100;
        if (Intrinsics.areEqual(this.clickAction, r101.clickAction) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.backgroundConfig, r101.backgroundConfig) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.logInfo, r101.logInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.regionInfo, r101.regionInfo) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        ClickAction r100 = this.clickAction;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        BackgroundConfig r104 = this.backgroundConfig;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, Object> r107 = this.logInfo;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        RegionInfo r110 = this.regionInfo;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "CommonProp(clickAction=" + this.clickAction + ", backgroundConfig=" + this.backgroundConfig + ", logInfo=" + this.logInfo + ", regionInfo=" + this.regionInfo + ")";
    }

    public final BackgroundConfig getBackgroundConfig() {
        return this.backgroundConfig;
    }

    public final ClickAction getClickAction() {
        return this.clickAction;
    }

    public final Map<String, Object> getLogInfo() {
        return this.logInfo;
    }

    public final RegionInfo getRegionInfo() {
        return this.regionInfo;
    }

    public CommonProp(ClickAction r100, BackgroundConfig r101, Map<String, ? extends Object> r102, RegionInfo r103) {
        this.clickAction = r100;
        this.backgroundConfig = r101;
        this.logInfo = r102;
        this.regionInfo = r103;
    }

    public /* synthetic */ CommonProp(ClickAction r100, BackgroundConfig r101, Map r102, RegionInfo r103, int r104, DefaultConstructorMarker r105) {
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
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
