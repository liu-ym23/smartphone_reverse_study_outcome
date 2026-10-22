package com.bytedance.upc.cache;

import android.content.ContentValues;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.upc.common.ICommonBusinessService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f272451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f272452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f272453c = null;

    public b() {
    }

    static {
        f272453c = new b();
    }

    public final String a() {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        return "";
    L5:
        Context r100 = getContext();
        if (r100 != null) goto L8;
        return "";
    L8:
        if (ContextCompat.checkSelfPermission(r100, "android.permission.READ_PHONE_STATE") == 0) goto L10;
        return "";
    L10:
        return null;
    }

    private final Context getContext() {
        return ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getContext();
    L4:
        return null;
    }

    public final String b(String r100) {
        if (Intrinsics.areEqual(r100, "upc_cache_imei") == false) goto L9;
        if (TextUtils.isEmpty(f272451a) == true) goto L9;
        return f272451a;
    L9:
        if (Intrinsics.areEqual(r100, "upc_cache_deviceid") == false) goto L32;
        if (TextUtils.isEmpty(f272452b) == false) goto L32;
        return f272452b;
    L32:
        Context r101 = getContext();     // Catch: Throwable -> L26
        String r102 = ApiMultiProcessSharedProvider.f272438e;     // Catch: Throwable -> L26
        monitor-enter(ApiMultiProcessSharedProvider.class);     // Catch: Throwable -> L26
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L18:
        if (ApiMultiProcessSharedProvider.f272441h != null) goto L20;
        ApiMultiProcessSharedProvider.f272441h = new ApiMultiProcessSharedProvider.b(r101);     // Catch: Throwable -> L23
    L20:
        ApiMultiProcessSharedProvider.b r103 = ApiMultiProcessSharedProvider.f272441h;     // Catch: Throwable -> L23
        monitor-exit(ApiMultiProcessSharedProvider.class);     // Catch: Throwable -> L26
    L27:
        if (r103 != null) goto L29;
        return null;
    L29:
        return r103.c(r100);
    L26:
        r103 = null;
        goto L27
    }

    public final void c(String r100, String r101) {
        if (Intrinsics.areEqual(r100, "upc_cache_imei") == false) goto L8;
        if (TextUtils.isEmpty(r101) == true) goto L8;
        f272451a = r101;
    L37:
        Context r102 = getContext();     // Catch: Throwable -> L23
        String r103 = ApiMultiProcessSharedProvider.f272438e;     // Catch: Throwable -> L23
        monitor-enter(ApiMultiProcessSharedProvider.class);     // Catch: Throwable -> L23
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L15:
        if (ApiMultiProcessSharedProvider.f272441h != null) goto L17;
        ApiMultiProcessSharedProvider.f272441h = new ApiMultiProcessSharedProvider.b(r102);     // Catch: Throwable -> L20
    L17:
        ApiMultiProcessSharedProvider.b r104 = ApiMultiProcessSharedProvider.f272441h;     // Catch: Throwable -> L20
        monitor-exit(ApiMultiProcessSharedProvider.class);     // Catch: Throwable -> L23
    L24:
        if (r104 == null) goto L31;
        Context r105 = r104.f272448a;
        ContentValues r106 = new ContentValues();
        Context r107 = r105.getApplicationContext();
        r107.getApplicationContext().getSharedPreferences("upc_sdk_multi_process_sp", 4);
        r106.put(r100, r101);
        String r108 = ApiMultiProcessSharedProvider.f272438e;     // Catch: Throwable -> L29
        ApiMultiProcessSharedProvider.a.b(r107.getContentResolver(), ApiMultiProcessSharedProvider.b(r107, "key", "type"), r106);     // Catch: Throwable -> L32
        return;
    L41:
        return;
    L29:
        th = move-exception;
        throw th;
    L31:
        return;
    L23:
        r104 = null;
    L8:
        if (Intrinsics.areEqual(r100, "upc_cache_deviceid") == false) goto L37;
        if (TextUtils.isEmpty(r101) == true) goto L37;
        f272452b = r101;
        goto L37
    }
}
