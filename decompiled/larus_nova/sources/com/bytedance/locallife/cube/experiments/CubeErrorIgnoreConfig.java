package com.bytedance.locallife.cube.experiments;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\tJ\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003JJ\u0010\u0016\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/bytedance/locallife/cube/experiments/CubeErrorIgnoreConfig;", "", "channelList", "", "", "bundleList", "errorCode", "", "containErrorMsg", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;)V", "getBundleList", "()Ljava/util/List;", "getChannelList", "getContainErrorMsg", "()Ljava/lang/String;", "getErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/locallife/cube/experiments/CubeErrorIgnoreConfig;", "equals", "", "other", "hashCode", "toString", "cube-saas_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class CubeErrorIgnoreConfig {

    @SerializedName("bundleList")
    private final List<String> bundleList;

    @SerializedName("channelList")
    private final List<String> channelList;

    @SerializedName("containErrorMsg")
    private final String containErrorMsg;

    @SerializedName("errorCode")
    private final Integer errorCode;

    public CubeErrorIgnoreConfig() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CubeErrorIgnoreConfig copy$default(CubeErrorIgnoreConfig r100, List r101, List r102, Integer r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.channelList;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.bundleList;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.errorCode;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.containErrorMsg;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final List<String> component1() {
        return this.channelList;
    }

    public final List<String> component2() {
        return this.bundleList;
    }

    public final Integer component3() {
        return this.errorCode;
    }

    public final String component4() {
        return this.containErrorMsg;
    }

    public final CubeErrorIgnoreConfig copy(List<String> r100, List<String> r101, Integer r102, String r103) {
        return new CubeErrorIgnoreConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CubeErrorIgnoreConfig) == true) goto L8;
        return false;
    L8:
        CubeErrorIgnoreConfig r101 = (CubeErrorIgnoreConfig) r100;
        if (Intrinsics.areEqual(this.channelList, r101.channelList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bundleList, r101.bundleList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.errorCode, r101.errorCode) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.containErrorMsg, r101.containErrorMsg) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        List<String> r100 = this.channelList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.bundleList;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.errorCode;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.containErrorMsg;
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

    public String toString() {
        return "CubeErrorIgnoreConfig(channelList=" + this.channelList + ", bundleList=" + this.bundleList + ", errorCode=" + this.errorCode + ", containErrorMsg=" + this.containErrorMsg + ')';
    }

    public final List<String> getBundleList() {
        return this.bundleList;
    }

    public final List<String> getChannelList() {
        return this.channelList;
    }

    public final String getContainErrorMsg() {
        return this.containErrorMsg;
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public CubeErrorIgnoreConfig(List<String> r100, List<String> r101, Integer r102, String r103) {
        this.channelList = r100;
        this.bundleList = r101;
        this.errorCode = r102;
        this.containErrorMsg = r103;
    }

    public /* synthetic */ CubeErrorIgnoreConfig(List r100, List r101, Integer r102, String r103, int r104, DefaultConstructorMarker r105) {
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
