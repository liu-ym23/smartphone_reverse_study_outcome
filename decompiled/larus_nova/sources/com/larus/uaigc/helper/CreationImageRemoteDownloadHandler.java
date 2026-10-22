package com.larus.uaigc.helper;

import android.graphics.Bitmap;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.larus.bmhome.bigimg.ImageSave;
import com.larus.bmhome.resource.access.ResourceMediaType;
import com.larus.bmhome.resource.access.ResourceNodeHandler;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.uaigc.createpage.utils.BitmapHelperKt;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import java.util.Locale;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u0010J\"\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0082@¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u0016J\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0018\u001a\u00020\u000b*\u0004\u0018\u00010\u0005H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/larus/uaigc/helper/CreationImageRemoteDownloadHandler;", "Lcom/larus/bmhome/resource/access/ResourceNodeHandler;", "<init>", "()V", "key", "", "getKey", "()Ljava/lang/String;", "nodeKey", "getNodeKey", "supports", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/larus/bmhome/resource/access/ResourceContext;", "execute", "Lcom/larus/bmhome/resource/access/NodeResult;", "(Lcom/larus/bmhome/resource/access/ResourceContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveRemoteFallbackLocalPath", "url", "fallbackLocalPath", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadByImageSave", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "decodeRemoteImageToLocalPath", "isUploadableImagePath", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationImageRemoteDownloadHandler implements ResourceNodeHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f372941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f372942b;

    @Override // com.larus.bmhome.resource.access.ResourceNodeHandler
    public final void getPriority() {
    }

    public CreationImageRemoteDownloadHandler() {
        this.f372941a = "creation_image_remote_download";
        this.f372942b = "remote_download";
    }

    @Override // com.larus.bmhome.resource.access.ResourceNodeHandler
    public final String a() {
        return this.f372942b;
    }

    @Override // com.larus.bmhome.resource.access.ResourceNodeHandler
    public final String getKey() {
        return this.f372941a;
    }

    public static boolean e(String r100) {
        if (r100 == null) goto L22;
        boolean r101 = true;
        String r102 = null;
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 != null) goto L11;
        return false;
    L11:
        if (new PolarisFileWrapper(r100).exists() == true) goto L13;
        return false;
    L13:
        String r103 = StringsKt.substringAfterLast(r100, '.', "").toLowerCase(Locale.ROOT);
        if (r103.length() > 0) goto L17;
        r101 = false;
    L17:
        if (r101 == false) goto L19;
        r102 = r103;
    L19:
        if (r102 != null) goto L21;
        return false;
    L21:
        return i.f373022a.contains(r102);
    L22:
        return false;
    }

    @Override // com.larus.bmhome.resource.access.ResourceNodeHandler
    public final boolean b(com.larus.bmhome.resource.access.h0 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (a0.b(r100) == false) goto L13;
        com.larus.bmhome.resource.access.w r101 = r100.f313671a;
        if (r101.f313764c != ResourceMediaType.IMAGE) goto L13;
        if (r101.f313765d.f313664k.f313760e == false) goto L13;
        if (r100.f313678h != null) goto L13;
        if ((r100.f313673c instanceof com.larus.bmhome.resource.access.j0.c) == false) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // com.larus.bmhome.resource.access.ResourceNodeHandler
    public final Object c(com.larus.bmhome.resource.access.h0 r210, Continuation<? super com.larus.bmhome.resource.access.g> r211) {
        if ((r211 instanceof CreationImageRemoteDownloadHandler$execute$1) == false) goto L7;
        CreationImageRemoteDownloadHandler$execute$1 r100 = (CreationImageRemoteDownloadHandler$execute$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        com.larus.bmhome.resource.access.j0.c r105 = (com.larus.bmhome.resource.access.j0.c) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L25:
        String r106 = (String) r102;
        if (r106 != null) goto L28;
    L31:
        boolean r107 = true;
    L32:
        if (r107 == true) goto L34;
        PolarisFileWrapper r108 = new PolarisFileWrapper(r106);
        String r110 = r105.f313695b;
        Boolean r111 = Boxing.boxBoolean(false);
        if (r108.exists() == false) goto L38;
        PolarisFileWrapper r109 = r108;
    L39:
        if (r109 == null) goto L41;
        Long r112 = Boxing.boxLong(r109.length());
    L42:
        com.larus.bmhome.resource.access.j0.b r113 = new com.larus.bmhome.resource.access.j0.b(r106, r110, r111, r112, 16);
        if (r108.exists() == true) goto L46;
        r108 = null;
    L46:
        if (r108 == null) goto L48;
        Long r114 = Boxing.boxLong(r108.length());
    L49:
        String r115 = StringsKt.substringAfterLast(r106, '.', "");
        if (r115.length() <= 0) goto L52;
        boolean r116 = true;
    L53:
        if (r116 == false) goto L55;
        String r117 = r115;
    L57:
        return new com.larus.bmhome.resource.access.g.a(new com.larus.bmhome.resource.access.i0(r113, null, r114, null, r117, null, MapsKt.mapOf(new Pair[]{TuplesKt.to("remote_fallback", CreationRemoteFallbackState.DOWNLOAD.getValue()), TuplesKt.to("remote_fallback_path", r106)}), 42));
    L55:
        r117 = null;
        goto L57
    L52:
        r116 = false;
        goto L53
    L48:
        r114 = null;
        goto L49
    L41:
        r112 = null;
        goto L42
    L38:
        r109 = null;
        goto L39
    L34:
        return new com.larus.bmhome.resource.access.g.b(new com.larus.bmhome.resource.access.r(this.f372942b, "remote_download_failed", "remote image download failed", null));
    L28:
        if (StringsKt.isBlank(r106) == true) goto L31;
        r107 = false;
        goto L32
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        com.larus.bmhome.resource.access.j0 r118 = r210.f313673c;
        if ((r118 instanceof com.larus.bmhome.resource.access.j0.c) == false) goto L17;
        com.larus.bmhome.resource.access.j0.c r119 = (com.larus.bmhome.resource.access.j0.c) r118;
    L18:
        if (r119 == null) goto L20;
        String r120 = r119.f313695b;
        String r121 = r210.f313671a.f313765d.f313667n.get("remote_detect_local_path");
        r100.L$0 = r119;
        r100.label = 1;
        Object r122 = f(r120, r121, r100);
        if (r122 != r103) goto L24;
        return r103;
    L24:
        com.larus.bmhome.resource.access.j0.c r212 = r119;
        r102 = r122;
        r105 = r212;
        goto L25
    L20:
        return com.larus.bmhome.resource.access.g.e.f313653a;
    L17:
        r119 = null;
    L7:
        r100 = new CreationImageRemoteDownloadHandler$execute$1(this, r211);
        goto L8
    }

    public final Object d(String r100, Continuation<? super String> r110) {
        if ((r110 instanceof CreationImageRemoteDownloadHandler$decodeRemoteImageToLocalPath$1) == false) goto L7;
        CreationImageRemoteDownloadHandler$decodeRemoteImageToLocalPath$1 r101 = (CreationImageRemoteDownloadHandler$decodeRemoteImageToLocalPath$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        String r105 = null;
        if (r104 == 0) goto L20;
        if (r104 == 1) goto L19;
        if (r104 != 2) goto L18;
        CloseableReference r106 = (CloseableReference) r101.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L15
    L38:
        File r112 = (File) r111;     // Catch: Throwable -> L15
        if (r112 != null) goto L41;
    L46:
        CloseableReference.closeSafely(r106);
        return r105;
    L41:
        if (r112.exists() == true) goto L44;
        r112 = null;
    L44:
        if (r112 == null) goto L46;
        r105 = r112.getAbsolutePath();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableReference r113 = r106;
        th = th;
    L52:
        CloseableReference.closeSafely(r113);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ResultKt.throwOnFailure(r111);
    L23:
        r113 = (CloseableReference) r111;
        if (r113 != null) goto L54;
        return null;
    L54:
        Object r107 = r113.get();     // Catch: Throwable -> L51
        if ((r107 instanceof CloseableStaticBitmap) == false) goto L29;
        CloseableStaticBitmap r108 = (CloseableStaticBitmap) r107;     // Catch: Throwable -> L51
    L30:
        if (r108 == null) goto L49;
        Bitmap r109 = r108.getUnderlyingBitmap();     // Catch: Throwable -> L51
        if (r109 == null) goto L49;
        String r114 = "remote_fallback_" + UUID.randomUUID() + ".jpeg";     // Catch: Throwable -> L51
        r101.L$0 = r113;     // Catch: Throwable -> L51
        r101.label = 2;     // Catch: Throwable -> L51
        Object r115 = BitmapHelperKt.f(r109, r114, r101);     // Catch: Throwable -> L51
        if (r115 != r103) goto L37;
        return r103;
    L37:
        r111 = r115;
        r106 = r113;
    L49:
        CloseableReference.closeSafely(r113);
        return null;
    L29:
        r108 = null;
    L51:
        th = th;
        goto L52
    L20:
        ResultKt.throwOnFailure(r111);
        Function1 r116 = new o();
        r101.label = 1;
        r111 = ImageLoaderKt.i(r100, "creation_remote_fallback", r116, r101, 28);
        if (r111 != r103) goto L23;
        return r103;
    L7:
        r101 = new CreationImageRemoteDownloadHandler$decodeRemoteImageToLocalPath$1(this, r110);
        goto L8
    }

    public final Object f(String r100, String r101, Continuation<? super String> r110) {
        if ((r110 instanceof CreationImageRemoteDownloadHandler$resolveRemoteFallbackLocalPath$1) == false) goto L7;
        CreationImageRemoteDownloadHandler$resolveRemoteFallbackLocalPath$1 r102 = (CreationImageRemoteDownloadHandler$resolveRemoteFallbackLocalPath$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r111 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        ResultKt.throwOnFailure(r111);
    L42:
        return r111;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r101 = (String) r102.L$1;
        r100 = (String) r102.L$0;
        ResultKt.throwOnFailure(r111);
    L21:
        String r112 = (String) r111;
        if (e(r112) == false) goto L25;
        return r112;
    L25:
        if (r112 == null) goto L33;
        if ((true ^ StringsKt.isBlank(r112)) == true) goto L30;
        r112 = null;
    L30:
        if (r112 == null) goto L33;
        FLogger.f375446a.i("CreationImageNodeHandlers", "[remoteDownload] image cache path cannot preprocess, path=".concat(r112));
    L33:
        if (e(r101) == true) goto L36;
        r101 = null;
    L36:
        if (r101 == null) goto L39;
        FLogger.f375446a.i("CreationImageNodeHandlers", "[remoteDownload] use fallback local path, path=".concat(r101));
        return r101;
    L39:
        r102.L$0 = null;
        r102.L$1 = null;
        r102.label = 2;
        r111 = d(r100, r102);
        if (r111 != r104) goto L42;
        return r104;
    L16:
        ResultKt.throwOnFailure(r111);
        r102.L$0 = r100;
        r102.L$1 = r101;
        r102.label = 1;
        kotlinx.coroutines.j r113 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r102), 1);
        r113.C();
        ImageSave r106 = ImageSave.f295932a;
        p r107 = new p(r113);
        r106.getClass();
        ImageSave.m(r100, r107);
        r111 = r113.B();
        if (r111 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        DebugProbesKt.probeCoroutineSuspended(r102);
    L19:
        if (r111 != r104) goto L21;
        return r104;
    L7:
        r102 = new CreationImageRemoteDownloadHandler$resolveRemoteFallbackLocalPath$1(this, r110);
        goto L8
    }
}
