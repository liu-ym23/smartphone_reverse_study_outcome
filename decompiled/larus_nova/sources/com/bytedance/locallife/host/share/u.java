package com.bytedance.locallife.host.share;

import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.google.gson.annotations.SerializedName;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/locallife/host/share/u;", "", "", ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, "Ljava/lang/String;", "getPlatformId", "()Ljava/lang/String;", "awemeId", "getAwemeId", "", "mode", "I", "getMode", "()I", "", "extra", "Ljava/util/Map;", "getExtra", "()Ljava/util/Map;", "locallife-host-api_release"}, k = 1, mv = {1, 4, 3})
public final class u {

    @SerializedName(SimilarProductParam.AWEME_ID)
    private final String awemeId;

    @SerializedName("extra")
    private final Map<String, Object> extra;

    @SerializedName("mode")
    private final int mode;

    @SerializedName("platform_id")
    private final String platformId;

    public u() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.platformId, r101.platformId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.awemeId, r101.awemeId) == true) goto L15;
        return false;
    L15:
        if (this.mode == r101.mode) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.platformId.hashCode() * 31;
        String r101 = this.awemeId;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.mode) * 31;
        Map<String, Object> r105 = this.extra;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "LocalWebShareMode(platformId=" + this.platformId + ", awemeId=" + this.awemeId + ", mode=" + this.mode + ", extra=" + this.extra + ')';
    }

    public u(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY);
        this.platformId = r100;
        this.awemeId = "";
        this.mode = r101;
        this.extra = null;
    }
}
