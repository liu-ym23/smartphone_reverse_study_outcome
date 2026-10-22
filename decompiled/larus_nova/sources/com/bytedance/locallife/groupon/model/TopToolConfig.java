package com.bytedance.locallife.groupon.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/locallife/groupon/model/TopToolConfig;", "", "topTools", "", "moveCityEntrance", "pageGrouponEnable", "(ZZZ)V", "getMoveCityEntrance", "()Z", "getPageGrouponEnable", "getTopTools", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class TopToolConfig {

    @SerializedName("move_city_entrance")
    private final boolean moveCityEntrance;

    @SerializedName("page_group_enable")
    private final boolean pageGrouponEnable;

    @SerializedName("top_tools")
    private final boolean topTools;

    public TopToolConfig() {
        this(false, false, false, 7, null);
    }

    public static /* synthetic */ TopToolConfig copy$default(TopToolConfig r100, boolean r101, boolean r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.topTools;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.moveCityEntrance;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.pageGrouponEnable;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final boolean component1() {
        return this.topTools;
    }

    public final boolean component2() {
        return this.moveCityEntrance;
    }

    public final boolean component3() {
        return this.pageGrouponEnable;
    }

    public final TopToolConfig copy(boolean r100, boolean r101, boolean r102) {
        return new TopToolConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TopToolConfig) == true) goto L8;
        return false;
    L8:
        TopToolConfig r101 = (TopToolConfig) r100;
        if (this.topTools == r101.topTools) goto L12;
        return false;
    L12:
        if (this.moveCityEntrance == r101.moveCityEntrance) goto L15;
        return false;
    L15:
        if (this.pageGrouponEnable == r101.pageGrouponEnable) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.topTools == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.moveCityEntrance == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.pageGrouponEnable == true) goto L15;
        r100 = 1237;
    L15:
        return r104 + r100;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "TopToolConfig(topTools=" + this.topTools + ", moveCityEntrance=" + this.moveCityEntrance + ", pageGrouponEnable=" + this.pageGrouponEnable + ')';
    }

    public final boolean getMoveCityEntrance() {
        return this.moveCityEntrance;
    }

    public final boolean getPageGrouponEnable() {
        return this.pageGrouponEnable;
    }

    public final boolean getTopTools() {
        return this.topTools;
    }

    public TopToolConfig(boolean r100, boolean r101, boolean r102) {
        this.topTools = r100;
        this.moveCityEntrance = r101;
        this.pageGrouponEnable = r102;
    }

    public /* synthetic */ TopToolConfig(boolean r100, boolean r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = true;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = false;
    L11:
        this(r100, r101, r102);
    }
}
