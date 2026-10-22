package com.bytedance.locallife.pdp.settings;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/locallife/pdp/settings/d0;", "", "", "routerReqSimpleInfo", "Ljava/lang/Boolean;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Boolean;", "c", "(Ljava/lang/Boolean;)V", "", "routerReqTimeoutMills", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "setRouterReqTimeoutMills", "(Ljava/lang/Long;)V", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f261725a;

    @SerializedName("router_req_simple_info")
    private Boolean routerReqSimpleInfo;

    @SerializedName("router_req_timeout_mills")
    private Long routerReqTimeoutMills;

    public d0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f261725a, ((d0) r100).f261725a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f261725a.hashCode();
    }

    public final String toString() {
        return "LifeServiceBizCode(bizCode=" + this.f261725a + ')';
    }

    public final Boolean a() {
        return this.routerReqSimpleInfo;
    }

    public final Long b() {
        return this.routerReqTimeoutMills;
    }

    public d0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bizCode");
        this.f261725a = r100;
        this.routerReqSimpleInfo = Boolean.FALSE;
        this.routerReqTimeoutMills = 500L;
    }

    public final void c(Boolean r100) {
        this.routerReqSimpleInfo = r100;
    }

    public /* synthetic */ d0(int r100) {
        this("");
    }
}
