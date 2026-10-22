package com.bytedance.android.shopping.api.mall.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003JD\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\bHÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/HomepageExtra;", "", "grayEnable", "", "preloadGeckoConfigList", "", "Lcom/bytedance/android/shopping/api/mall/model/PreloadGeckoConfig;", "addressInfo", "", "sceneCode", "(Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getAddressInfo", "()Ljava/lang/String;", "getGrayEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPreloadGeckoConfigList", "()Ljava/util/List;", "getSceneCode", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/model/HomepageExtra;", "equals", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HomepageExtra {

    @SerializedName("address_info")
    private final String addressInfo;

    @SerializedName("gray_enable")
    private final Boolean grayEnable;

    @SerializedName("preload_gecko_config_list")
    private final List<PreloadGeckoConfig> preloadGeckoConfigList;

    @SerializedName("scene_code")
    private final String sceneCode;

    public HomepageExtra() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HomepageExtra copy$default(HomepageExtra r0, Boolean r1, List r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.grayEnable;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.preloadGeckoConfigList;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.addressInfo;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.sceneCode;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final Boolean component1() {
        return this.grayEnable;
    }

    public final List<PreloadGeckoConfig> component2() {
        return this.preloadGeckoConfigList;
    }

    public final String component3() {
        return this.addressInfo;
    }

    public final String component4() {
        return this.sceneCode;
    }

    public final HomepageExtra copy(Boolean r2, List<PreloadGeckoConfig> r3, String r4, String r5) {
        return new HomepageExtra(r2, r3, r4, r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof HomepageExtra) == false) goto L14;
        HomepageExtra r4 = (HomepageExtra) r3;
        if (Intrinsics.areEqual(this.grayEnable, r4.grayEnable) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.preloadGeckoConfigList, r4.preloadGeckoConfigList) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.addressInfo, r4.addressInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sceneCode, r4.sceneCode) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        Boolean r0 = this.grayEnable;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<PreloadGeckoConfig> r4 = this.preloadGeckoConfigList;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.addressInfo;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.sceneCode;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "HomepageExtra(grayEnable=" + this.grayEnable + ", preloadGeckoConfigList=" + this.preloadGeckoConfigList + ", addressInfo=" + this.addressInfo + ", sceneCode=" + this.sceneCode + ")";
    }

    public final String getAddressInfo() {
        return this.addressInfo;
    }

    public final Boolean getGrayEnable() {
        return this.grayEnable;
    }

    public final List<PreloadGeckoConfig> getPreloadGeckoConfigList() {
        return this.preloadGeckoConfigList;
    }

    public final String getSceneCode() {
        return this.sceneCode;
    }

    public HomepageExtra(Boolean r1, List<PreloadGeckoConfig> r2, String r3, String r4) {
        this.grayEnable = r1;
        this.preloadGeckoConfigList = r2;
        this.addressInfo = r3;
        this.sceneCode = r4;
    }

    public /* synthetic */ HomepageExtra(Boolean r2, List r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = Boolean.FALSE;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
