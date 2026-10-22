package com.larus.dora.impl.ota;

import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.network.http.y;
import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
public final class DoraOTARequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DoraOTARequest f337377a = null;

    static {
        f337377a = new DoraOTARequest();
    }

    public DoraOTARequest() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(String r110, String r111, String r210, String r211, String r212, String r213, String r214, String r215, Continuation<? super Result<e49.a>> r216) {
        if ((r216 instanceof DoraOTARequest$checkUpdate$1) == false) goto L7;
        DoraOTARequest$checkUpdate$1 r100 = (DoraOTARequest$checkUpdate$1) r216;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r112 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r113 = r100.label;
        if (r113 == 0) goto L15;
        if (r113 != 1) goto L14;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L32
    L22:
        com.larus.network.http.a r103 = (com.larus.network.http.a) r102;     // Catch: Throwable -> L32
        g49.d.d("DoraOTARequest", "checkUpdate: result=".concat(r103.getClass().getSimpleName()));     // Catch: Throwable -> L32
        if ((r103 instanceof y) == false) goto L30;
        Long r104 = ((y) r103).f360205g;     // Catch: Throwable -> L32
        if (r104 == null) goto L30;
        if (r104.longValue() != 0) goto L30;
        return Result.m9449constructorimpl(new e49.a((z39.a) ((y) r103).f360135b, false, false, 6));
    L30:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L32
        return Result.m9449constructorimpl(ResultKt.createFailure(new Exception("call is failed")));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r102);
        JSONObject r106 = new JSONObject();     // Catch: Throwable -> L32
        r106.put("product", r110);     // Catch: Throwable -> L32
        r106.put(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, r111);     // Catch: Throwable -> L32
        r106.put("udid", r210);     // Catch: Throwable -> L32
        r106.put("os_version", r211);     // Catch: Throwable -> L32
        r106.put("rom_version", r212);     // Catch: Throwable -> L32
        r106.put("buildtime", r213);     // Catch: Throwable -> L32
        r106.put("buildtype", r215);     // Catch: Throwable -> L32
        r106.put(ForwardDependency$ForwardLocation.FLAG, r214);     // Catch: Throwable -> L32
        JSONObject r114 = new JSONObject();     // Catch: Throwable -> L32
        r114.put("doubao_version", AppHost.f326268a.getVersionName());     // Catch: Throwable -> L32
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L32
        r106.put("extra_apps", r114);     // Catch: Throwable -> L32
        g49.d.d("DoraOTARequest", "checkUpdate: product=" + r110 + " model=" + r111 + " pkgType=" + r214 + " buildType=" + r215);     // Catch: Throwable -> L32
        DoraDevice r107 = kj4.a.g().c();     // Catch: Throwable -> L32
        if (r107 == null) goto L19;
        o59.a.p(r107);     // Catch: Throwable -> L32
    L19:
        com.larus.dora.api.network.a r108 = com.larus.dora.api.network.a.f331768a;     // Catch: Throwable -> L32
        r100.label = 1;     // Catch: Throwable -> L32
        r102 = com.larus.dora.api.network.a.c(r108, z39.a.class, "https://ocean-ota.obriccloud.com/open/v3/ota/check", r106, null, r100, 248);     // Catch: Throwable -> L32
        if (r102 != r112) goto L22;
        return r112;
    L32:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new DoraOTARequest$checkUpdate$1(this, r216);
        goto L8
    }
}
