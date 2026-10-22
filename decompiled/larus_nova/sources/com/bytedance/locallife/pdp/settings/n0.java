package com.bytedance.locallife.pdp.settings;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/locallife/pdp/settings/n0;", "", "", "minVersion", "J", "getMinVersion", "()J", "", "channel", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "bundle", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class n0 {

    @SerializedName("bundle")
    private final String bundle;

    @SerializedName("channel")
    private final String channel;

    @SerializedName("min_version")
    private final long minVersion;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n0) == true) goto L8;
        return false;
    L8:
        n0 r101 = (n0) r100;
        if (this.minVersion == r101.minVersion) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.channel, r101.channel) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bundle, r101.bundle) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r100 = this.minVersion;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.channel;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.bundle;
        if (r106 == null) goto L11;
        r103 = r106.hashCode();
    L11:
        return r105 + r103;
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public final String toString() {
        return "PrefetchRenderNode(minVersion=" + this.minVersion + ", channel=" + this.channel + ", bundle=" + this.bundle + ')';
    }

    public n0() {
        this.minVersion = Long.MAX_VALUE;
        this.channel = null;
        this.bundle = null;
    }

    public final String a() {
        return this.bundle;
    }

    public final String b() {
        return this.channel;
    }
}
