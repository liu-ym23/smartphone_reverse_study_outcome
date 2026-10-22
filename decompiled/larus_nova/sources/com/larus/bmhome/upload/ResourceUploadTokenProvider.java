package com.larus.bmhome.upload;

import com.bytedance.keva.Keva;
import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.platform.model.upload.FlowResourceType;
import com.larus.platform.model.upload.UploadDataType;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import mr9.m;

/* JADX INFO: loaded from: classes26.dex */
public final class ResourceUploadTokenProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ResourceUploadTokenProvider f314735a = null;

    static {
        f314735a = new ResourceUploadTokenProvider();
    }

    public ResourceUploadTokenProvider() {
    }

    public static void b(mr9.j r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        UploadDataType r101 = r100.f515001c;
        Intrinsics.checkNotNullParameter(r101, "dataType");
        Keva r102 = fs8.a.f478664a;
        String r103 = r101.getType();
        Intrinsics.checkNotNullParameter(r103, "dataType");
        UploadDataType.Companion.getClass();
        String r104 = "";
        if (UploadDataType.a.a(r103) == false) goto L5;
        FLogger.f375446a.d("UploaderCacheStrategy", "clear cache token");
        fs8.a.f478664a.storeString("image_token_data" + r103 + fs8.a.a(), "");
    L5:
        ResourceCenter r105 = ResourceCenter.f313541a;
        String r106 = r100.f515010l;
        if (r106 == null) goto L9;
        r104 = r106;
    L9:
        r105.getClass();
        FlowResourceScene r107 = ResourceCenter.g(r104);
        FlowResourceType r108 = a.a(r100);
        Intrinsics.checkNotNullParameter(r107, "scene");
        Intrinsics.checkNotNullParameter(r108, "resourceType");
        if (ResourceCenter.f().a() == false) goto L14;
        com.larus.bmhome.rc.g.a r109 = new com.larus.bmhome.rc.g.a(r107, r108);
        com.larus.bmhome.rc.g.f313560a.getClass();
        com.larus.bmhome.rc.g.b(r109);
        return;
    }

    public static boolean c(Long r100) {
        if (r100 != null) goto L5;
    L6:
        if (r100 != null) goto L9;
    L11:
        return false;
    L9:
        if (r100.longValue() != (-39982)) goto L11;
    L12:
        return true;
    L5:
        if (r100.longValue() == 100028) goto L12;
        goto L6
    }

    public final Object a(String r100, UploadDataType r101, Continuation<? super m> r102) {
        if ((r102 instanceof ResourceUploadTokenProvider$getToken$1) == false) goto L7;
        ResourceUploadTokenProvider$getToken$1 r103 = (ResourceUploadTokenProvider$getToken$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L15;
        if (r107 != 1) goto L14;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L21
    L19:
        Object r108 = Result.m9449constructorimpl((m) r105);     // Catch: Throwable -> L21
    L24:
        if (Result.m9455isFailureimpl(r108) == false) goto L29;
        return null;
    L29:
        return r108;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r105);
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L21
        int r110 = com.larus.bmhome.upload.sdk.h.f314839a;     // Catch: Throwable -> L21
        String r111 = r101.getType();     // Catch: Throwable -> L21
        r103.label = 1;     // Catch: Throwable -> L21
        r105 = com.larus.bmhome.upload.sdk.h.a(r100, r111, r103);     // Catch: Throwable -> L21
        if (r105 != r106) goto L19;
        return r106;
    L21:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r103 = new ResourceUploadTokenProvider$getToken$1(this, r102);
        goto L8
    }
}
