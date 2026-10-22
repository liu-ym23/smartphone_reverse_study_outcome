package com.larus.home.impl.main.tab.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/larus/home/impl/main/tab/config/TabBarConfig;", "", "middleIconUrl", "", "middleIconKey", "bottomTabConfigs", "Lcom/larus/home/impl/main/tab/config/BottomTabConfigs;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/home/impl/main/tab/config/BottomTabConfigs;)V", "getMiddleIconUrl", "()Ljava/lang/String;", "getMiddleIconKey", "getBottomTabConfigs", "()Lcom/larus/home/impl/main/tab/config/BottomTabConfigs;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TabBarConfig {

    @SerializedName("bottom_tab")
    private final BottomTabConfigs bottomTabConfigs;

    @SerializedName("middle_icon_key")
    private final String middleIconKey;

    @SerializedName("middle_icon_url")
    private final String middleIconUrl;

    public TabBarConfig() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ TabBarConfig copy$default(TabBarConfig r100, String r101, String r102, BottomTabConfigs r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.middleIconUrl;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.middleIconKey;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.bottomTabConfigs;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.middleIconUrl;
    }

    public final String component2() {
        return this.middleIconKey;
    }

    public final BottomTabConfigs component3() {
        return this.bottomTabConfigs;
    }

    public final TabBarConfig copy(String r100, String r101, BottomTabConfigs r102) {
        return new TabBarConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TabBarConfig) == true) goto L8;
        return false;
    L8:
        TabBarConfig r101 = (TabBarConfig) r100;
        if (Intrinsics.areEqual(this.middleIconUrl, r101.middleIconUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.middleIconKey, r101.middleIconKey) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bottomTabConfigs, r101.bottomTabConfigs) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.middleIconUrl;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.middleIconKey;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        BottomTabConfigs r107 = this.bottomTabConfigs;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "TabBarConfig(middleIconUrl=" + this.middleIconUrl + ", middleIconKey=" + this.middleIconKey + ", bottomTabConfigs=" + this.bottomTabConfigs + ')';
    }

    public final BottomTabConfigs getBottomTabConfigs() {
        return this.bottomTabConfigs;
    }

    public final String getMiddleIconKey() {
        return this.middleIconKey;
    }

    public final String getMiddleIconUrl() {
        return this.middleIconUrl;
    }

    public TabBarConfig(String r100, String r101, BottomTabConfigs r102) {
        this.middleIconUrl = r100;
        this.middleIconKey = r101;
        this.bottomTabConfigs = r102;
    }

    public /* synthetic */ TabBarConfig(String r100, String r101, BottomTabConfigs r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
