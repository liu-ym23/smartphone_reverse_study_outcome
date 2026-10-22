package com.ss.android.lark.location.utils;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@AppConfig(key = "lark_map_key")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JH\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\bHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006 "}, d2 = {"Lcom/ss/android/lark/location/utils/MapKeyData;", "", "bing", "", "useSystemLocationWhenAmapFailed", "", "larkLocationBingDowngradeToSystem", "systemLocationTimeout", "", "amapKeyForFSSW", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;ILjava/lang/String;)V", "getBing", "()Ljava/lang/String;", "getUseSystemLocationWhenAmapFailed", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLarkLocationBingDowngradeToSystem", "getSystemLocationTimeout", "()I", "getAmapKeyForFSSW", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;ILjava/lang/String;)Lcom/ss/android/lark/location/utils/MapKeyData;", "equals", "other", "hashCode", "toString", "location_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MapKeyData {

    @SerializedName("amap_key_for_fssw")
    private final String amapKeyForFSSW;

    @SerializedName("bing")
    private final String bing;

    @SerializedName("lark_location_bing_downgrade_to_system")
    private final Boolean larkLocationBingDowngradeToSystem;

    @SerializedName("system_location_timeout_second")
    private final int systemLocationTimeout;

    @SerializedName("use_system_location_when_amap_failed")
    private final Boolean useSystemLocationWhenAmapFailed;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MapKeyData) == true) goto L8;
        return false;
    L8:
        MapKeyData r101 = (MapKeyData) r100;
        if (Intrinsics.areEqual(this.bing, r101.bing) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.useSystemLocationWhenAmapFailed, r101.useSystemLocationWhenAmapFailed) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.larkLocationBingDowngradeToSystem, r101.larkLocationBingDowngradeToSystem) == true) goto L18;
        return false;
    L18:
        if (this.systemLocationTimeout == r101.systemLocationTimeout) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.amapKeyForFSSW, r101.amapKeyForFSSW) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.bing;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.useSystemLocationWhenAmapFailed;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.larkLocationBingDowngradeToSystem;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r106 + r108) * 31) + this.systemLocationTimeout) * 31;
        String r110 = this.amapKeyForFSSW;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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

    public final String toString() {
        return "MapKeyData(bing=" + this.bing + ", useSystemLocationWhenAmapFailed=" + this.useSystemLocationWhenAmapFailed + ", larkLocationBingDowngradeToSystem=" + this.larkLocationBingDowngradeToSystem + ", systemLocationTimeout=" + this.systemLocationTimeout + ", amapKeyForFSSW=" + this.amapKeyForFSSW + ')';
    }

    public MapKeyData() {
        this.bing = null;
        this.useSystemLocationWhenAmapFailed = null;
        this.larkLocationBingDowngradeToSystem = null;
        this.systemLocationTimeout = 10;
        this.amapKeyForFSSW = null;
    }
}
