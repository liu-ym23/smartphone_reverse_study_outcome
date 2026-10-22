package com.larus.bmhome.upload.sdk;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larus.bmhome.upload.sdk.api.model.AuthMode;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import mr9.j;
import mr9.m;

/* JADX INFO: loaded from: classes26.dex */
public final class UploadAuthTokenCredentialProvider implements hs8.f {
    public UploadAuthTokenCredentialProvider() {
    }

    @Override // hs8.f
    public final boolean b(AuthMode r100) {
        Intrinsics.checkNotNullParameter(r100, "authMode");
        if (r100 != AuthMode.UploadAuthToken) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // hs8.f
    public final Object a(is8.g r210, is8.a r211, Continuation<? super hs8.e> r212) {
        is8.g r100 = r210;
        if ((r212 instanceof UploadAuthTokenCredentialProvider$fetch$1) == false) goto L7;
        UploadAuthTokenCredentialProvider$fetch$1 r101 = (UploadAuthTokenCredentialProvider$fetch$1) r212;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L20;
        if (r105 != 1) goto L19;
        j r106 = (j) r101.L$2;
        is8.a r107 = (is8.a) r101.L$1;
        r100 = (is8.g) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L14 ResourceUploadError -> L16
        is8.a r110 = r107;
    L58:
        r106.f515006h = (m) r103;     // Catch: Throwable -> L31 ResourceUploadError -> L33
        ms8.b.c(ms8.b.f515490a, r106, "prepare_upload", "success", null, MapsKt.mapOf(TuplesKt.to("auth_mode", r110.f495636a.name())), 8);     // Catch: Throwable -> L31 ResourceUploadError -> L33
        FLogger.f375446a.i("ResourceUploadSdk", "[fetchUploadAuthToken] identifier=" + r100.f495672c.f495650f + ", scene=" + r106.f515000b + ", dataType=" + r106.f515001c);     // Catch: Throwable -> L31 ResourceUploadError -> L33
        return new hs8.e(r110.f495636a, MapsKt.mapOf(TuplesKt.to("credential_source", "upload_auth_token")));
    L33:
        e = e;
    L50:
        ms8.b r108 = ms8.b.f515490a;
        Map r109 = MapsKt.mapOf(TuplesKt.to("auth_mode", r110.f495636a.name()));
        r108.getClass();
        ms8.b.b(r106, "prepare_upload", "fail", e, r109);
        throw e;
    L31:
        th = th;
    L42:
        String r111 = th.getMessage();
        if (r111 != null) goto L45;
        r111 = "";
    L45:
        ResourceUploadError r112 = new ResourceUploadError(ResourceUploadError.AUTH_TOKEN, r111);
        ms8.b r113 = ms8.b.f515490a;
        Map r114 = MapsKt.mapOf(TuplesKt.to("auth_mode", r110.f495636a.name()));
        r113.getClass();
        ms8.b.b(r106, "prepare_upload", "fail", r112, r114);
        throw r112;
    L16:
        e = e;
        r110 = r107;
    L14:
        th = th;
        r110 = r107;
        goto L42
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r103);
        ConcurrentHashMap<String, j> r115 = g.f314834a;
        Intrinsics.checkNotNullParameter(r100, "request");
        String r116 = r100.f495672c.f495650f;
        Intrinsics.checkNotNullParameter(r116, LocationMonitorConst.IDENTIFIER);
        j r117 = g.f314834a.get(r116);
        if (r117 == null) goto L53;
        ms8.b.f515490a.getClass();
        ms8.b.i(r117, "prepare_upload");
        int r118 = h.f314839a;     // Catch: Throwable -> L39 ResourceUploadError -> L47
        String r119 = r117.f515000b;     // Catch: Throwable -> L39 ResourceUploadError -> L47
        String r120 = r117.f515001c.getType();     // Catch: Throwable -> L39 ResourceUploadError -> L47
        r101.L$0 = r100;     // Catch: Throwable -> L39 ResourceUploadError -> L47
        r110 = r211;
        r101.L$1 = r110;     // Catch: Throwable -> L35 ResourceUploadError -> L37
        r101.L$2 = r117;     // Catch: Throwable -> L35 ResourceUploadError -> L37
        r101.label = 1;     // Catch: Throwable -> L35 ResourceUploadError -> L37
        Object r121 = h.a(r119, r120, r101);     // Catch: Throwable -> L35 ResourceUploadError -> L37
        if (r121 != r104) goto L28;
        return r104;
    L28:
        r106 = r117;
        r103 = r121;
        goto L58
    L37:
        e = e;
    L49:
        r106 = r117;
    L35:
        th = th;
    L41:
        r106 = r117;
        goto L42
    L47:
        e = e;
        r110 = r211;
    L39:
        th = th;
        r110 = r211;
        goto L41
    L53:
        throw new ResourceUploadError(ResourceUploadError.AUTH_TOKEN, "origin param missing");
    L7:
        r101 = new UploadAuthTokenCredentialProvider$fetch$1(this, r212);
        goto L8
    }
}
