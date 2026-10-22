package com.ss.android.lark.officesdk.internal;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.api.api.OfficeSDKGlobalApi;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKCapacity;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import com.ss.android.lark.officesdk.container.OfficeSDKGlobalComponent;
import com.ss.android.lark.officesdk.container.OfficeSDKGlobalScope;
import com.ss.android.lark.officesdk.container.OfficeSDKSPIKtxKt;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.cast.discovery.mdns.nsdhelper.NsdHelper;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@OfficeSDKGlobalScope
public final class e implements OfficeSDKGlobalApi {

    public static final class a {
    }

    static {
    }

    @Inject
    public e() {
    }

    @Override // com.ss.android.lark.officesdk.api.api.OfficeSDKGlobalApi
    public final <T extends IOfficeSDKCapacity> T getService(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceClass");
        Log.i("OfficeSDKGlobalApiImpl", "getService: ".concat(r100.getSimpleName()));
        OfficeSDKGlobalComponent r101 = OfficeSDKManager.getOfficeSDKGlobalComponent();     // Catch: Exception -> L7
        if (r101 == null) goto L12;
        return (T) OfficeSDKSPIKtxKt.spiByDwarf(r101, r100);
    L12:
        return null;
    L7:
        e = move-exception;
        Log.w("OfficeSDKGlobalApiImpl", "getService failed: ".concat(r100.getSimpleName()), e);
        return null;
    }

    @Override // com.ss.android.lark.officesdk.api.api.OfficeSDKGlobalApi
    public final <T extends IOfficeSDKProtocol> void setHostService(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, NsdHelper.serviceTypeKey);
        Intrinsics.checkNotNullParameter(r101, "service");
        Log.i("OfficeSDKGlobalApiImpl", "setHostService: ".concat(r100.getSimpleName()));
        OfficeSDKManager.injectGlobalService$officesdk_core_release(r100, r101);
    }
}
