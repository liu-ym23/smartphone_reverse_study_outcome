package com.bytedance.locallife.groupon.struct.halfscreen;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J9\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/halfscreen/GrouponCommonHalfTTIPreProcessOptConfig;", "", "enable", "", "preRequest", "preLoad", "preRequestConfigs", "", "Lcom/bytedance/locallife/groupon/struct/halfscreen/GrouponCommonHalfPreRequestConfig;", "(ZZZLjava/util/List;)V", "getEnable", "()Z", "getPreLoad", "getPreRequest", "getPreRequestConfigs", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class GrouponCommonHalfTTIPreProcessOptConfig {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("pre_load")
    private final boolean preLoad;

    @SerializedName("pre_request")
    private final boolean preRequest;

    @SerializedName("pre_request_configs")
    private final List<GrouponCommonHalfPreRequestConfig> preRequestConfigs;

    public GrouponCommonHalfTTIPreProcessOptConfig() {
        this(false, false, false, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GrouponCommonHalfTTIPreProcessOptConfig copy$default(GrouponCommonHalfTTIPreProcessOptConfig r100, boolean r101, boolean r102, boolean r103, List r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.enable;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.preRequest;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.preLoad;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.preRequestConfigs;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final boolean component2() {
        return this.preRequest;
    }

    public final boolean component3() {
        return this.preLoad;
    }

    public final List<GrouponCommonHalfPreRequestConfig> component4() {
        return this.preRequestConfigs;
    }

    public final GrouponCommonHalfTTIPreProcessOptConfig copy(boolean r100, boolean r101, boolean r102, List<GrouponCommonHalfPreRequestConfig> r103) {
        return new GrouponCommonHalfTTIPreProcessOptConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GrouponCommonHalfTTIPreProcessOptConfig) == true) goto L8;
        return false;
    L8:
        GrouponCommonHalfTTIPreProcessOptConfig r101 = (GrouponCommonHalfTTIPreProcessOptConfig) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (this.preRequest == r101.preRequest) goto L15;
        return false;
    L15:
        if (this.preLoad == r101.preLoad) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.preRequestConfigs, r101.preRequestConfigs) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.enable == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.preRequest == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.preLoad == true) goto L14;
        r100 = 1237;
    L14:
        int r105 = (r104 + r100) * 31;
        List<GrouponCommonHalfPreRequestConfig> r106 = this.preRequestConfigs;
        if (r106 != null) goto L17;
        int r107 = 0;
    L19:
        return r105 + r107;
    L17:
        r107 = r106.hashCode();
        goto L19
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "GrouponCommonHalfTTIPreProcessOptConfig(enable=" + this.enable + ", preRequest=" + this.preRequest + ", preLoad=" + this.preLoad + ", preRequestConfigs=" + this.preRequestConfigs + ')';
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getPreLoad() {
        return this.preLoad;
    }

    public final boolean getPreRequest() {
        return this.preRequest;
    }

    public final List<GrouponCommonHalfPreRequestConfig> getPreRequestConfigs() {
        return this.preRequestConfigs;
    }

    public GrouponCommonHalfTTIPreProcessOptConfig(boolean r100, boolean r101, boolean r102, List<GrouponCommonHalfPreRequestConfig> r103) {
        this.enable = r100;
        this.preRequest = r101;
        this.preLoad = r102;
        this.preRequestConfigs = r103;
    }

    public /* synthetic */ GrouponCommonHalfTTIPreProcessOptConfig(boolean r100, boolean r101, boolean r102, List r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
