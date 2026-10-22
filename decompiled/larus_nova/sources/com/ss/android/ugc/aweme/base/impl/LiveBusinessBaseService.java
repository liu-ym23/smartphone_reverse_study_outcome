package com.ss.android.ugc.aweme.base.impl;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.ugc.aweme.base.api.ILiveBusinessBaseService;
import com.ss.android.ugc.aweme.base.api.ILiveSDKHostService;
import com.ss.android.ugc.aweme.base.common.ServiceCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import om0.b;
import om0.c;
import tm0.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J)\u0010\r\u001a\u00028\u0000\"\b\b\u0000\u0010\t*\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¨\u0006\u0017"}, d2 = {"Lcom/ss/android/ugc/aweme/base/impl/LiveBusinessBaseService;", "Lcom/ss/android/ugc/aweme/base/api/ILiveBusinessBaseService;", "Lpm0/a;", "getALogService", "Lqm0/a;", "getLiveAppLogService", "Lwm0/b;", "getLiveMonitorService", "", ExifInterface.GPS_DIRECTION_TRUE, "", "key", "defaultValue", "getLiveSettingValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "Lvm0/a;", "getLiveSettingService", "Lum0/b;", "getNetworkService", "Ltm0/a;", "getImageLoaderService", "<init>", "()V", "livebusiness_base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveBusinessBaseService implements ILiveBusinessBaseService {
    public LiveBusinessBaseService() {
    }

    public a getImageLoaderService() {
        b r100 = c.f524232a;
        if (c.a() == false) goto L10;
        om0.a r101 = c.f524234c;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mHostMiddleLayer");
    L7:
        r101.getClass();
        return null;
    L10:
        return null;
    }

    public vm0.a getLiveSettingService() {
        ServiceCache.f449998c.getClass();
        ((ILiveSDKHostService) ServiceCache.b(ILiveSDKHostService.class)).a();
        return c.k();
    }

    public um0.b getNetworkService() {
        b r100 = c.f524232a;
        if (c.a() == false) goto L8;
        om0.a r101 = c.f524234c;
        if (r101 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mHostMiddleLayer");
    L10:
        return r101.f524226e;
    L8:
        return null;
    }

    @Override // com.ss.android.ugc.aweme.base.api.ILiveBusinessBaseService
    public pm0.a getALogService() {
        return c.c();
    }

    public qm0.a getLiveAppLogService() {
        return c.d();
    }

    @Override // com.ss.android.ugc.aweme.base.api.ILiveBusinessBaseService
    public wm0.b getLiveMonitorService() {
        return c.j();
    }

    @Override // com.ss.android.ugc.aweme.base.api.ILiveBusinessBaseService
    public <T> T getLiveSettingValue(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        ServiceCache.f449998c.getClass();
        ((ILiveSDKHostService) ServiceCache.b(ILiveSDKHostService.class)).a();
        vm0.a r102 = c.k();
        if (r102 == null) goto L9;
        T r103 = (T) r102.getValue(new vm0.b(r100, r101, r101, r101.getClass()));
        if (r103 != null) goto L8;
        return r101;
    L8:
        return r103;
    L9:
        return r101;
    }
}
