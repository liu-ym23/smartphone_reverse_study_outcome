package com.larus.im.internal.network.link.impl.rtc;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\nHÆ\u0003J=\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\bHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/larus/im/internal/network/link/impl/rtc/RTCInnerMessageBody;", "", "rtcAgentConfig", "Lcom/larus/im/internal/network/link/impl/rtc/RtcAgentConfig;", "customConfig", "Lcom/larus/im/internal/network/link/impl/rtc/CustomConfig;", "bizSignals", "", "", "isSignalsBase64", "", "<init>", "(Lcom/larus/im/internal/network/link/impl/rtc/RtcAgentConfig;Lcom/larus/im/internal/network/link/impl/rtc/CustomConfig;Ljava/util/List;Z)V", "getRtcAgentConfig", "()Lcom/larus/im/internal/network/link/impl/rtc/RtcAgentConfig;", "getCustomConfig", "()Lcom/larus/im/internal/network/link/impl/rtc/CustomConfig;", "getBizSignals", "()Ljava/util/List;", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "OApp.flowSDK.baseSDK.common.avsdk-flow-impl"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class i {

    @SerializedName("BizSignals")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> bizSignals;

    @SerializedName("CustomConfig")
    private final b customConfig;

    @SerializedName("IsSignalsBase64")
    private final boolean isSignalsBase64;

    @SerializedName("RtcAgentConfig")
    private final s rtcAgentConfig;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.rtcAgentConfig, r101.rtcAgentConfig) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.customConfig, r101.customConfig) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bizSignals, r101.bizSignals) == true) goto L18;
        return false;
    L18:
        if (this.isSignalsBase64 == r101.isSignalsBase64) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        s r100 = this.rtcAgentConfig;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        b r104 = this.customConfig;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.bizSignals;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        int r108 = (r106 + r101) * 31;
        if (this.isSignalsBase64 == false) goto L17;
        int r109 = 1231;
    L19:
        return r108 + r109;
    L17:
        r109 = 1237;
        goto L19
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "RTCInnerMessageBody(rtcAgentConfig=" + this.rtcAgentConfig + ", customConfig=" + this.customConfig + ", bizSignals=" + this.bizSignals + ", isSignalsBase64=" + this.isSignalsBase64 + ')';
    }

    public i() {
        this(new s(null, null, null, 15), new b(0), CollectionsKt.emptyList(), false);
    }

    public i(s r100, b r101, List<String> r102, boolean r103) {
        this.rtcAgentConfig = r100;
        this.customConfig = r101;
        this.bizSignals = r102;
        this.isSignalsBase64 = r103;
    }
}
