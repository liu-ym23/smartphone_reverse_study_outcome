package com.bytedance.ies.argus.bean;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0080\b\u0018\u00002\u00020\u0001:\u0001\u0005R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/argus/bean/f;", "", "", "enable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "", "maxDomCacheMB", FaceService.girlLabel, "b", "()F", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("max_dom_cache_mb")
    private final float maxDomCacheMB;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (Float.compare(this.maxDomCacheMB, r101.maxDomCacheMB) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.enable == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + Float.floatToIntBits(this.maxDomCacheMB);
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "ArgusSwitchesWebDomMonitor(enable=" + this.enable + ", maxDomCacheMB=" + this.maxDomCacheMB + ')';
    }

    public f() {
        this.enable = false;
        this.maxDomCacheMB = 2.0f;
    }

    public final boolean a() {
        return this.enable;
    }

    public final float b() {
        return this.maxDomCacheMB;
    }
}
