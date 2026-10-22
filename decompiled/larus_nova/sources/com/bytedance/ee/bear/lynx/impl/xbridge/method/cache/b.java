package com.bytedance.ee.bear.lynx.impl.xbridge.method.cache;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CCMLynxCacheManager f229946a;

    public b(CCMLynxCacheManager r100) {
        this.f229946a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        i r101 = (i) r100;
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        this.f229946a.getClass();
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        LynxCacheDatabase r102 = CCMLynxCacheManager.a();     // Catch: Exception -> L9
        Intrinsics.checkNotNull(r102);     // Catch: Exception -> L9
        h r103 = (h) r102.c();     // Catch: Exception -> L9
        r103.f229953a.assertNotSuspendingTransaction();     // Catch: Exception -> L9
        r103.f229953a.beginTransaction();     // Catch: Exception -> L9
        long r104 = r103.f229954b.insertAndReturnId(r101);     // Catch: Throwable -> L6
        r103.f229953a.setTransactionSuccessful();     // Catch: Throwable -> L6
        Long r105 = Long.valueOf(r104);     // Catch: Throwable -> L6
        r103.f229953a.endTransaction();     // Catch: Exception -> L9
        Intrinsics.checkNotNull(r105);     // Catch: Exception -> L9
        long r106 = r105.longValue();     // Catch: Exception -> L9
    L12:
        return Long.valueOf(r106);
    L6:
        th = move-exception;
        r103.f229953a.endTransaction();     // Catch: Exception -> L9
        throw th;     // Catch: Exception -> L9
    L9:
        e = move-exception;
        iu5.d.c(e);
        r106 = -1;
        goto L12
    }
}
