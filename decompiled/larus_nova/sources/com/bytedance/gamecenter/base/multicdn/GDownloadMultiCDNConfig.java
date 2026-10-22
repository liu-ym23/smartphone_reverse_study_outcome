package com.bytedance.gamecenter.base.multicdn;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J%\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/gamecenter/base/multicdn/GDownloadMultiCDNConfig;", "", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "", "cdnHostList", "", "Lcom/bytedance/gamecenter/base/multicdn/GDownloadMultiCDNHostConfig;", "(ILjava/util/List;)V", "getCdnHostList", "()Ljava/util/List;", "setCdnHostList", "(Ljava/util/List;)V", "getStrategy", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "gamecenterbase_release"}, k = 1, mv = {1, 4, 3})
public final class GDownloadMultiCDNConfig {

    @SerializedName("cdn_array")
    private List<GDownloadMultiCDNHostConfig> cdnHostList;

    @SerializedName(BdpAppEventConstant.PARAMS_STRATEGY_NAME)
    private final int strategy;

    /* JADX WARN: Multi-variable type inference failed */
    public GDownloadMultiCDNConfig() {
        int r100 = 0;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GDownloadMultiCDNConfig copy$default(GDownloadMultiCDNConfig r100, int r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.strategy;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.cdnHostList;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.strategy;
    }

    public final List<GDownloadMultiCDNHostConfig> component2() {
        return this.cdnHostList;
    }

    public final GDownloadMultiCDNConfig copy(int r100, List<GDownloadMultiCDNHostConfig> r101) {
        return new GDownloadMultiCDNConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof GDownloadMultiCDNConfig) == false) goto L10;
        GDownloadMultiCDNConfig r101 = (GDownloadMultiCDNConfig) r100;
        if (this.strategy == r101.strategy) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.cdnHostList, r101.cdnHostList) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        int r100 = this.strategy * 31;
        List<GDownloadMultiCDNHostConfig> r101 = this.cdnHostList;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public String toString() {
        return "GDownloadMultiCDNConfig(strategy=" + this.strategy + ", cdnHostList=" + this.cdnHostList + ")";
    }

    public final List<GDownloadMultiCDNHostConfig> getCdnHostList() {
        return this.cdnHostList;
    }

    public final int getStrategy() {
        return this.strategy;
    }

    public final void setCdnHostList(List<GDownloadMultiCDNHostConfig> r100) {
        this.cdnHostList = r100;
    }

    public GDownloadMultiCDNConfig(int r100, List<GDownloadMultiCDNHostConfig> r101) {
        this.strategy = r100;
        this.cdnHostList = r101;
    }

    public /* synthetic */ GDownloadMultiCDNConfig(int r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = new ArrayList();
    L8:
        this(r100, r101);
    }
}
