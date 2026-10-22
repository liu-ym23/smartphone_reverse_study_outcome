package ld9;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.im.internal.audio.proto.RTCToken;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/larus/im/internal/audio/proto/BatchGetToken;", "", "rtcTokenList", "", "Lcom/larus/im/internal/audio/proto/RTCToken;", "engineToken", "<init>", "(Ljava/util/List;Lcom/larus/im/internal/audio/proto/RTCToken;)V", "getRtcTokenList", "()Ljava/util/List;", "getEngineToken", "()Lcom/larus/im/internal/audio/proto/RTCToken;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "OApp.flowSDK.baseSDK.common.avsdk-flow-impl"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("login_token")
    private final RTCToken engineToken;

    @SerializedName("token_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<RTCToken> rtcTokenList;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.rtcTokenList, r101.rtcTokenList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.engineToken, r101.engineToken) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        List<RTCToken> r100 = this.rtcTokenList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        RTCToken r104 = this.engineToken;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BatchGetToken(rtcTokenList=" + this.rtcTokenList + ", engineToken=" + this.engineToken + ')';
    }

    public a() {
        this.rtcTokenList = null;
        this.engineToken = null;
    }

    public final RTCToken a() {
        return this.engineToken;
    }

    public final List<RTCToken> b() {
        return this.rtcTokenList;
    }
}
