package com.larus.im.internal.network.link.impl.rtc;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/larus/im/internal/network/link/impl/rtc/RTCInnerMessageBodyWithoutAgent;", "", "customConfig", "Lcom/larus/im/internal/network/link/impl/rtc/CustomConfig;", "bizSignals", "", "", "isSignalsBase64", "", "<init>", "(Lcom/larus/im/internal/network/link/impl/rtc/CustomConfig;Ljava/util/List;Z)V", "getCustomConfig", "()Lcom/larus/im/internal/network/link/impl/rtc/CustomConfig;", "getBizSignals", "()Ljava/util/List;", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "OApp.flowSDK.baseSDK.common.avsdk-flow-impl"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class j {

    @SerializedName("BizSignals")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> bizSignals;

    @SerializedName("CustomConfig")
    private final b customConfig;

    @SerializedName("IsSignalsBase64")
    private final boolean isSignalsBase64;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.customConfig, r101.customConfig) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bizSignals, r101.bizSignals) == true) goto L15;
        return false;
    L15:
        if (this.isSignalsBase64 == r101.isSignalsBase64) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        b r100 = this.customConfig;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.bizSignals;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (r103 + r101) * 31;
        if (this.isSignalsBase64 == false) goto L13;
        int r106 = 1231;
    L15:
        return r105 + r106;
    L13:
        r106 = 1237;
        goto L15
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "RTCInnerMessageBodyWithoutAgent(customConfig=" + this.customConfig + ", bizSignals=" + this.bizSignals + ", isSignalsBase64=" + this.isSignalsBase64 + ')';
    }

    public j() {
        this(new b(0), CollectionsKt.emptyList(), false);
    }

    public j(b r100, List<String> r101, boolean r102) {
        this.customConfig = r100;
        this.bizSignals = r101;
        this.isSignalsBase64 = r102;
    }
}
