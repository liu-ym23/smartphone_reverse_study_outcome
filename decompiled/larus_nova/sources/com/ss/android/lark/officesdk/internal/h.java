package com.ss.android.lark.officesdk.internal;

import com.bytedance.lark.sdk.refactor.n;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKCapacity;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import com.ss.android.lark.officesdk.container.OfficeSDKSPIKtxKt;
import com.ss.android.lark.officesdk.container.OfficeSDKUserComponent;
import com.ss.android.lark.officesdk.container.OfficeSDKUserComponentManager;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.cast.discovery.mdns.nsdhelper.NsdHelper;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@OfficeSDKUserScope
public final class h implements OfficeSDKUserApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f433365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OfficeSDKUserComponentManager f433366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f433367c;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi
    public final String getUserId() {
        return this.f433365a;
    }

    @Override // com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi
    public final <T extends IOfficeSDKCapacity> T getService(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceClass");
        Log.i("OfficeSDKUserApiImpl", "getService: " + r100.getSimpleName() + ", userId: " + this.f433365a);
        OfficeSDKUserComponent r101 = this.f433366b.findComponent();     // Catch: Exception -> L7
        if (r101 == null) goto L12;
        return (T) OfficeSDKSPIKtxKt.spiByDwarf(r101, r100);
    L12:
        return null;
    L7:
        e = move-exception;
        Log.w("OfficeSDKUserApiImpl", "getService failed: ".concat(r100.getSimpleName()), e);
        return null;
    }

    @Override // com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi
    public final <T extends IOfficeSDKProtocol> void setHostService(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, NsdHelper.serviceTypeKey);
        Intrinsics.checkNotNullParameter(r101, "service");
        Log.i("OfficeSDKUserApiImpl", "setHostService: " + r100.getSimpleName() + ", userId: " + this.f433365a);
        OfficeSDKManager.injectUserService$officesdk_core_release(this.f433365a, r100, r101);
    }

    @Inject
    public h(String r100, OfficeSDKUserComponentManager r101, n r102) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "componentManager");
        Intrinsics.checkNotNullParameter(r102, "rustSDK");
        this.f433365a = r100;
        this.f433366b = r101;
        this.f433367c = r102;
    }
}
