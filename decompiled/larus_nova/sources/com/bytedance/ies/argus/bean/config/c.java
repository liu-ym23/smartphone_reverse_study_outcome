package com.bytedance.ies.argus.bean.config;

import com.bytedance.ies.argus.bean.feStrategy.ArgusFeRouteSourceVerifyConfig;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/argus/bean/config/c;", "", "Lcom/bytedance/ies/argus/bean/feStrategy/a;", "schemaVerify", "Lcom/bytedance/ies/argus/bean/feStrategy/a;", "b", "()Lcom/bytedance/ies/argus/bean/feStrategy/a;", "Lcom/bytedance/ies/argus/bean/feStrategy/ArgusFeRouteSourceVerifyConfig;", "routeSourceVerify", "Lcom/bytedance/ies/argus/bean/feStrategy/ArgusFeRouteSourceVerifyConfig;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/ies/argus/bean/feStrategy/ArgusFeRouteSourceVerifyConfig;", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("route_source_verify")
    private final ArgusFeRouteSourceVerifyConfig routeSourceVerify;

    @SerializedName("schema_verify")
    private final com.bytedance.ies.argus.bean.feStrategy.a schemaVerify;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.schemaVerify, r101.schemaVerify) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.routeSourceVerify, r101.routeSourceVerify) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        com.bytedance.ies.argus.bean.feStrategy.a r100 = this.schemaVerify;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        ArgusFeRouteSourceVerifyConfig r104 = this.routeSourceVerify;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ArgusFeStrategyConfig(schemaVerify=" + this.schemaVerify + ", routeSourceVerify=" + this.routeSourceVerify + ')';
    }

    public c() {
        this.schemaVerify = null;
        this.routeSourceVerify = null;
    }

    public final ArgusFeRouteSourceVerifyConfig a() {
        return this.routeSourceVerify;
    }

    public final com.bytedance.ies.argus.bean.feStrategy.a b() {
        return this.schemaVerify;
    }
}
