package com.larus.bmhome.upload.sdk;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.rc.PrepareUploadResult;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.upload.sdk.api.model.AuthMode;
import com.larus.platform.model.upload.FlowResourceType;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import mr9.j;
import mr9.m;

/* JADX INFO: loaded from: classes26.dex */
public final class ResourceCenterTokenCredentialProvider implements hs8.f {
    public ResourceCenterTokenCredentialProvider() {
    }

    @Override // hs8.f
    public final boolean b(AuthMode r100) {
        Intrinsics.checkNotNullParameter(r100, "authMode");
        if (r100 != AuthMode.ResourceCenterPrepareUpload) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // hs8.f
    public final Object a(is8.g r210, is8.a r211, Continuation<? super hs8.e> r212) {
        if ((r212 instanceof ResourceCenterTokenCredentialProvider$fetch$1) == false) goto L7;
        ResourceCenterTokenCredentialProvider$fetch$1 r100 = (ResourceCenterTokenCredentialProvider$fetch$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        String r110 = "";
        if (r104 == 0) goto L20;
        if (r104 != 1) goto L19;
        FlowResourceScene r105 = (FlowResourceScene) r100.L$4;
        FlowResourceType r106 = (FlowResourceType) r100.L$3;
        j r107 = (j) r100.L$2;
        is8.a r111 = (is8.a) r100.L$1;
        is8.g r108 = (is8.g) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L14 ResourceUploadError -> L16
    L29:
        PrepareUploadResult r109 = (PrepareUploadResult) r102;     // Catch: Throwable -> L14 ResourceUploadError -> L16
        m r112 = r109.getResourceUploadToken();     // Catch: Throwable -> L14 ResourceUploadError -> L16
        if (r112 != null) goto L36;
        String r113 = r109.getFailReason();     // Catch: Throwable -> L14 ResourceUploadError -> L16
        if (r113 != null) goto L35;
        r113 = "";
    L35:
        throw new ResourceUploadError(ResourceUploadError.AUTH_TOKEN, r113);     // Catch: Throwable -> L14 ResourceUploadError -> L16
    L36:
        r107.f515006h = r112;     // Catch: Throwable -> L14 ResourceUploadError -> L16
        ms8.b.c(ms8.b.f515490a, r107, "prepare_upload", "success", null, MapsKt.mapOf(new Pair[]{TuplesKt.to("auth_mode", r111.f495636a.name()), TuplesKt.to("resource_type", r106.name()), TuplesKt.to("resource_scene", r105.name())}), 8);     // Catch: Throwable -> L14 ResourceUploadError -> L16
        FLogger.f375446a.i("ResourceUploadSdk", "[fetchResourceCenterToken] identifier=" + r108.f495672c.f495650f + ", scene=" + r105 + ", resourceType=" + r106);     // Catch: Throwable -> L14 ResourceUploadError -> L16
        return new hs8.e(r111.f495636a, MapsKt.mapOf(new Pair[]{TuplesKt.to("credential_source", "resource_center_prepare_upload"), TuplesKt.to("resource_scene", r105.name())}));
    L16:
        e = e;
    L54:
        ms8.b r114 = ms8.b.f515490a;
        Map r115 = MapsKt.mapOf(TuplesKt.to("auth_mode", r111.f495636a.name()));
        r114.getClass();
        ms8.b.b(r107, "prepare_upload", "fail", e, r115);
        throw e;
    L14:
        th = th;
    L47:
        String r116 = th.getMessage();
        if (r116 == null) goto L51;
        r110 = r116;
    L51:
        ResourceUploadError r117 = new ResourceUploadError(ResourceUploadError.AUTH_TOKEN, r110);
        ms8.b r118 = ms8.b.f515490a;
        Map r119 = MapsKt.mapOf(TuplesKt.to("auth_mode", r111.f495636a.name()));
        r118.getClass();
        ms8.b.b(r107, "prepare_upload", "fail", r117, r119);
        throw r117;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r102);
        ConcurrentHashMap<String, j> r120 = g.f314834a;
        Intrinsics.checkNotNullParameter(r210, "request");
        String r121 = r210.f495672c.f495650f;
        Intrinsics.checkNotNullParameter(r121, LocationMonitorConst.IDENTIFIER);
        r107 = g.f314834a.get(r121);
        if (r107 == null) goto L57;
        ms8.b.f515490a.getClass();
        ms8.b.i(r107, "prepare_upload");
        FlowResourceType r122 = com.larus.bmhome.upload.a.a(r107);     // Catch: Throwable -> L42 ResourceUploadError -> L44
        FlowResourceScene r123 = e.a(r210, r107.f515010l);     // Catch: Throwable -> L42 ResourceUploadError -> L44
        ResourceCenter r124 = ResourceCenter.f313541a;     // Catch: Throwable -> L42 ResourceUploadError -> L44
        FlowResourceScene.Companion.getClass();     // Catch: Throwable -> L42 ResourceUploadError -> L44
        String r125 = FlowResourceScene.a.b(r123);     // Catch: Throwable -> L42 ResourceUploadError -> L44
        r100.L$0 = r210;     // Catch: Throwable -> L42 ResourceUploadError -> L44
        is8.a r126 = r211;
        r100.L$1 = r126;     // Catch: Throwable -> L38 ResourceUploadError -> L40
        r100.L$2 = r107;     // Catch: Throwable -> L38 ResourceUploadError -> L40
        r100.L$3 = r122;     // Catch: Throwable -> L38 ResourceUploadError -> L40
        r100.L$4 = r123;     // Catch: Throwable -> L38 ResourceUploadError -> L40
        r100.label = 1;     // Catch: Throwable -> L38 ResourceUploadError -> L40
        Object r127 = r124.j(r122, r125, r100);     // Catch: Throwable -> L38 ResourceUploadError -> L40
        if (r127 != r103) goto L28;
        return r103;
    L28:
        r108 = r210;
        r106 = r122;
        r102 = r127;
        r105 = r123;
        r111 = r126;
        goto L29
    L40:
        e = e;
    L53:
        r111 = r126;
    L38:
        th = th;
    L46:
        r111 = r126;
        goto L47
    L44:
        e = e;
        r126 = r211;
    L42:
        th = th;
        r126 = r211;
        goto L46
    L57:
        throw new ResourceUploadError(ResourceUploadError.AUTH_TOKEN, "origin param missing");
    L7:
        r100 = new ResourceCenterTokenCredentialProvider$fetch$1(this, r212);
        goto L8
    }
}
