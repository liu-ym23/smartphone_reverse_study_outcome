package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.graphics.Bitmap;
import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.logger.FLogger;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class ImageSelectorUploadPreviewHelper {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f371936d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageSelectorView f371937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f371938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Boolean> f371939c;

    public static final class a {
    }

    static {
    }

    public final void c(Bitmap r100) {
        this.f371937a.V5(new sy9.b.C7670b(r100, this.f371939c.invoke().booleanValue()));
    }

    public final Object a(String r100, Continuation<? super Bitmap> r101) {
        if ((r101 instanceof ImageSelectorUploadPreviewHelper$fetchPreviewBitmap$1) == false) goto L7;
        ImageSelectorUploadPreviewHelper$fetchPreviewBitmap$1 r102 = (ImageSelectorUploadPreviewHelper$fetchPreviewBitmap$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L16;
        if (r106 != 1) goto L15;
        r100 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L31
    L20:
        CloseableReference<CloseableImage> r107 = (CloseableReference) r104;     // Catch: Throwable -> L31
        if (r107 == null) goto L28;
        this.f371938b.a(r100, r107);     // Catch: Throwable -> L31
        CloseableImage r108 = r107.get();     // Catch: Throwable -> L31
        if ((r108 instanceof CloseableStaticBitmap) == false) goto L25;
        CloseableStaticBitmap r109 = (CloseableStaticBitmap) r108;     // Catch: Throwable -> L31
    L26:
        if (r109 == null) goto L28;
        Bitmap r110 = r109.getUnderlyingBitmap();     // Catch: Throwable -> L31
    L29:
        Object r111 = Result.m9449constructorimpl(r110);     // Catch: Throwable -> L31
    L33:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
        if (r112 == null) goto L37;
        FLogger.f375446a.e("ImageSelectorUploadPreviewHelper", "[fetchPreviewBitmap] failed, imageUri=" + r100, r112);
    L37:
        if (Result.m9455isFailureimpl(r111) == false) goto L40;
        return null;
    L40:
        return r111;
    L25:
        r109 = null;
    L28:
        r110 = null;
        goto L29
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r104);
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L31
        Function1 r114 = new e1();     // Catch: Throwable -> L31
        r102.L$0 = r100;     // Catch: Throwable -> L31
        r102.label = 1;     // Catch: Throwable -> L31
        r104 = ImageLoaderKt.i(r100, "instruction_image_selector", r114, r102, 28);     // Catch: Throwable -> L31
        if (r104 != r105) goto L20;
        return r105;
    L31:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r102 = new ImageSelectorUploadPreviewHelper$fetchPreviewBitmap$1(this, r101);
        goto L8
    }

    public final Object b(String r100, Continuation<? super Bitmap> r101) {
        Intrinsics.checkNotNullParameter(r100, "localPath");
        if (com.larus.uaigc.helper.g.b(r100) == true) goto L9;
        r100 = com.larus.utils.y0.k(Uri.fromFile(new PolarisFileWrapper(r100)));
        if (r100 != null) goto L9;
        r100 = "";
    L9:
        return a(r100, r101);
    }

    public final void d(Bitmap r100, Pair<Integer, Integer> r101) {
        this.f371937a.V5(new sy9.b.e(r100, this.f371939c.invoke().booleanValue(), r101, 8));
    }

    public ImageSelectorUploadPreviewHelper(ImageSelectorView r100, c r101, Function0<Boolean> r102) {
        Intrinsics.checkNotNullParameter(r100, "imageSelectorView");
        Intrinsics.checkNotNullParameter(r101, "frescoCloseableHolder");
        Intrinsics.checkNotNullParameter(r102, "showFullProvider");
        this.f371937a = r100;
        this.f371938b = r101;
        this.f371939c = r102;
    }
}
