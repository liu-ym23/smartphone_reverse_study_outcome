package com.bytedance.gamecenter.base.multicdn;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/gamecenter/base/multicdn/GDownloadMultiCDNHostConfig;", "", "mainHost", "", "supCDNList", "", "(Ljava/lang/String;Ljava/util/List;)V", "getMainHost", "()Ljava/lang/String;", "setMainHost", "(Ljava/lang/String;)V", "getSupCDNList", "()Ljava/util/List;", "setSupCDNList", "(Ljava/util/List;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "gamecenterbase_release"}, k = 1, mv = {1, 4, 3})
public final class GDownloadMultiCDNHostConfig {

    @SerializedName("main_host")
    private String mainHost;

    @SerializedName("cdn_list")
    private List<String> supCDNList;

    /* JADX WARN: Multi-variable type inference failed */
    public GDownloadMultiCDNHostConfig() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GDownloadMultiCDNHostConfig copy$default(GDownloadMultiCDNHostConfig r100, String r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.mainHost;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.supCDNList;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.mainHost;
    }

    public final List<String> component2() {
        return this.supCDNList;
    }

    public final GDownloadMultiCDNHostConfig copy(String r100, List<String> r101) {
        return new GDownloadMultiCDNHostConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof GDownloadMultiCDNHostConfig) == false) goto L10;
        GDownloadMultiCDNHostConfig r101 = (GDownloadMultiCDNHostConfig) r100;
        if (Intrinsics.areEqual(this.mainHost, r101.mainHost) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.supCDNList, r101.supCDNList) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r100 = this.mainHost;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.supCDNList;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "GDownloadMultiCDNHostConfig(mainHost=" + this.mainHost + ", supCDNList=" + this.supCDNList + ")";
    }

    public final String getMainHost() {
        return this.mainHost;
    }

    public final List<String> getSupCDNList() {
        return this.supCDNList;
    }

    public final void setMainHost(String r100) {
        this.mainHost = r100;
    }

    public final void setSupCDNList(List<String> r100) {
        this.supCDNList = r100;
    }

    public GDownloadMultiCDNHostConfig(String r100, List<String> r101) {
        this.mainHost = r100;
        this.supCDNList = r101;
    }

    public /* synthetic */ GDownloadMultiCDNHostConfig(String r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = new ArrayList();
    L8:
        this(r100, r101);
    }
}
