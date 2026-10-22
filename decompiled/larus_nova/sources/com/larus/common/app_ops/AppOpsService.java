package com.larus.common.app_ops;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import com.larus.common.mssdk.api.IAppOpsService;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\\\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r`\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\tH\u0017J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0016\u0010\u0017\u001a\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u0019H\u0016J\u0016\u0010\u001a\u001a\u00020\u00052\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u0019H\u0016J\b\u0010\u001c\u001a\u00020\tH\u0016J\b\u0010\u001d\u001a\u00020\tH\u0016¨\u0006\u001e"}, d2 = {"Lcom/larus/common/app_ops/AppOpsService;", "Lcom/larus/common/mssdk/api/IAppOpsService;", "<init>", "()V", "init", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "enable", "", "mockApi2OpsMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "blackListMode", "needStack", "maxCacheSize", "useNewTag", "createAttributionService", "serviceName", "createAttributionAdapter", "Landroid/bluetooth/BluetoothAdapter;", "setServiceBlackSet", "blackSet", "", "setServiceWhiteSet", "whiteSet", "isLocalTest", "isEnable", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppOpsService implements IAppOpsService {
    public AppOpsService() {
    }

    @Override // com.larus.common.mssdk.api.IAppOpsService
    public final boolean isEnable() {
        a r100 = a.f326236a;
        return a.b();
    }

    @Override // com.larus.common.mssdk.api.IAppOpsService
    public final void a(Set<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "whiteSet");
        a r101 = a.f326236a;
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        a.f326238c = r100;
    }

    @Override // com.larus.common.mssdk.api.IAppOpsService
    public final void c(Set<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "blackSet");
        a r101 = a.f326236a;
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        a.f326237b = r100;
    }

    @Override // com.larus.common.mssdk.api.IAppOpsService
    public final void b(Context r100, boolean r101, HashMap r102, final boolean r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "mockApi2OpsMap");
        a r105 = a.f326236a;
        monitor-enter(r105);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L21
        Intrinsics.checkNotNullParameter(r102, "mockApi2OpsMap");     // Catch: Throwable -> L21
        if (a.f326239d == false) goto L8;
        monitor-exit(r105);
        return;
    L8:
        a.f326240e = r102;     // Catch: Throwable -> L21
        a.f326241f = r103;     // Catch: Throwable -> L21
        a.f326242g = r104;     // Catch: Throwable -> L21
        a.i();     // Catch: Throwable -> L21
        a.f326261z = (AppOpsManager) r100.getApplicationContext().getSystemService(AppOpsManager.class);     // Catch: Throwable -> L21
        if (r101 == true) goto L13;
        monitor-exit(r105);
        return;
    L13:
        if (Build.VERSION.SDK_INT < 30) goto L18;
        AppOpsManager.OnOpNotedCallback r106 = new AppOpsUtil$init$callback$1(r103);     // Catch: Throwable -> L21
        r105.h();     // Catch: Throwable -> L21
        AppOpsManager r107 = a.f326261z;     // Catch: Throwable -> L21
        if (r107 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("appOpsManager");     // Catch: Throwable -> L21
        r107 = null;
    L17:
        r107.setOnOpNotedCallback(r100.getApplicationContext().getMainExecutor(), r106);     // Catch: Throwable -> L21
        FLogger.f375446a.i("AppOpsUtil", "init success");     // Catch: Throwable -> L21
    L18:
        a.f326239d = true;     // Catch: Throwable -> L21
        monitor-exit(r105);
        return;
    L21:
        th = move-exception;
        throw th;
    }
}
