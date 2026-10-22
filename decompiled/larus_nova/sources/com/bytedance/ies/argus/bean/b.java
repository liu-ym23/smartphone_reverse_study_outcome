package com.bytedance.ies.argus.bean;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0080\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/argus/bean/b;", "", "", "geckoCdnRetryTime", "I", "b", "()I", "", "forceSkipInvalidGecko", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("force_skip_invalid_gecko")
    private final boolean forceSkipInvalidGecko;

    @SerializedName("gecko_cdn_retry_time")
    private final int geckoCdnRetryTime;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.geckoCdnRetryTime == r101.geckoCdnRetryTime) goto L12;
        return false;
    L12:
        if (this.forceSkipInvalidGecko == r101.forceSkipInvalidGecko) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.geckoCdnRetryTime * 31;
        if (this.forceSkipInvalidGecko == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "ArgusInitSetting(geckoCdnRetryTime=" + this.geckoCdnRetryTime + ", forceSkipInvalidGecko=" + this.forceSkipInvalidGecko + ')';
    }

    public b() {
        this.geckoCdnRetryTime = 0;
        this.forceSkipInvalidGecko = false;
    }

    public final boolean a() {
        return this.forceSkipInvalidGecko;
    }

    public final int b() {
        return this.geckoCdnRetryTime;
    }
}
