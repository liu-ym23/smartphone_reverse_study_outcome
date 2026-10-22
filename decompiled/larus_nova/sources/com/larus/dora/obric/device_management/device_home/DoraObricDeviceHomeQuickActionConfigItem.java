package com.larus.dora.obric.device_management.device_home;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ.\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeQuickActionConfigItem;", "", "key", "", "enabled", "", "order", "", "<init>", "(Ljava/lang/String;ZLjava/lang/Integer;)V", "getKey", "()Ljava/lang/String;", "getEnabled", "()Z", "getOrder", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;ZLjava/lang/Integer;)Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeQuickActionConfigItem;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricDeviceHomeQuickActionConfigItem {

    @SerializedName("enabled")
    private final boolean enabled;

    @SerializedName("key")
    private final String key;

    @SerializedName("order")
    private final Integer order;

    public DoraObricDeviceHomeQuickActionConfigItem() {
        this(null, false, null, 7, null);
    }

    public static /* synthetic */ DoraObricDeviceHomeQuickActionConfigItem copy$default(DoraObricDeviceHomeQuickActionConfigItem r100, String r101, boolean r102, Integer r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.key;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.enabled;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.order;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.key;
    }

    public final boolean component2() {
        return this.enabled;
    }

    public final Integer component3() {
        return this.order;
    }

    public final DoraObricDeviceHomeQuickActionConfigItem copy(String r100, boolean r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return new DoraObricDeviceHomeQuickActionConfigItem(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DoraObricDeviceHomeQuickActionConfigItem) == true) goto L8;
        return false;
    L8:
        DoraObricDeviceHomeQuickActionConfigItem r101 = (DoraObricDeviceHomeQuickActionConfigItem) r100;
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
        return false;
    L12:
        if (this.enabled == r101.enabled) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.order, r101.order) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.key.hashCode() * 31;
        if (this.enabled == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        Integer r103 = this.order;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return r102 + r104;
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "DoraObricDeviceHomeQuickActionConfigItem(key=" + this.key + ", enabled=" + this.enabled + ", order=" + this.order + ')';
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getKey() {
        return this.key;
    }

    public final Integer getOrder() {
        return this.order;
    }

    public DoraObricDeviceHomeQuickActionConfigItem(String r100, boolean r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.key = r100;
        this.enabled = r101;
        this.order = r102;
    }

    public /* synthetic */ DoraObricDeviceHomeQuickActionConfigItem(String r100, boolean r101, Integer r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = true;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
