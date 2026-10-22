package com.larus.xbridge.custom;

import com.ivy.ivykit.api.bridge.core.IvyBridgeMethod;
import com.larus.platform.service.AccountService;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class h0 implements com.larus.platform.api.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IvyBridgeMethod.a f379766a;

    public h0(ux7.d.C7943d r100) {
        this.f379766a = r100;
    }

    @Override // com.larus.platform.api.d
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "token");
        f4a.a r101 = new f4a.a();
        Intrinsics.checkNotNullParameter("douyin", "<set-?>");
        r101.f475573a = "douyin";
        String r102 = AccountService.f365697a.J();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f475574b = r102;
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r101.f475576d = r100;
        IvyBridgeMethod.a r103 = this.f379766a;
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put("code", 1);
        r104.put("data", f4a.a.C5858a.a(r101));
        r103.invoke(r104);
    }

    @Override // com.larus.platform.api.d
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "errorMsg");
        IvyBridgeMethod.a r101 = this.f379766a;
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("code", 0);
        r101.invoke(r102);
    }
}
