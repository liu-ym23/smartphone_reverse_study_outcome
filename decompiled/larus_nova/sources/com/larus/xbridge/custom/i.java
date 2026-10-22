package com.larus.xbridge.custom;

import com.ivy.ivykit.api.bridge.core.IvyBridgeMethod;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: classes32.dex */
public final class i implements n38.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IvyBridgeMethod.a f379770a;

    public i(ux7.d.C7943d r100) {
        this.f379770a = r100;
    }

    @Override // n38.m
    public final void onSuccess(String r100) {
        IvyBridgeMethod.a r101 = this.f379770a;
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("code", 1);
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("success", 1);
        Unit r104 = Unit.INSTANCE;
        r102.put("data", r103);
        r101.invoke(r102);
    }

    @Override // n38.m
    public final void a(int r100, String r101, String r102, String r103) {
        FLogger.f375446a.i("AppBindPlatformMethod", "bindPlatform onFailed, errorCode = " + r100 + ", errorMsg = " + r101);
        IvyBridgeMethod.a r104 = this.f379770a;
        LinkedHashMap r105 = new LinkedHashMap();
        r105.put("code", 1);
        LinkedHashMap r106 = new LinkedHashMap();
        r106.put("success", 0);
        r106.put("errorCode", Integer.valueOf(r100));
        if (r101 == null) goto L5;
        r106.put("errorMsg", r101);
    L5:
        Unit r107 = Unit.INSTANCE;
        r105.put("data", r106);
        r104.invoke(r105);
    }
}
