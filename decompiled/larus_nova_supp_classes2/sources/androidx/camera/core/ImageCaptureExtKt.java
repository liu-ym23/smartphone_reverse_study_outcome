package androidx.camera.core;

import android.graphics.Bitmap;
import androidx.camera.core.imagecapture.RequestWithCallback;
import androidx.camera.core.imagecapture.TakePictureRequest;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0001\u001aT\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tH\u0086@¢\u0006\u0002\u0010\r\u001a\\\u0010\u0003\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tH\u0086@¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"getTakePictureRequest", "Landroidx/camera/core/imagecapture/TakePictureRequest;", "Landroidx/camera/core/ImageCapture;", "takePicture", "Landroidx/camera/core/ImageProxy;", "onCaptureStarted", "Lkotlin/Function0;", "", "onCaptureProcessProgressed", "Lkotlin/Function1;", "", "onPostviewBitmapAvailable", "Landroid/graphics/Bitmap;", "(Landroidx/camera/core/ImageCapture;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/camera/core/ImageCapture$OutputFileResults;", "outputFileOptions", "Landroidx/camera/core/ImageCapture$OutputFileOptions;", "(Landroidx/camera/core/ImageCapture;Landroidx/camera/core/ImageCapture$OutputFileOptions;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "camera-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ImageCaptureExtKt {
    public static final TakePictureRequest getTakePictureRequest(ImageCapture r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        RequestWithCallback r2 = r1.getTakePictureManager().getCapturingRequest();
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getTakePictureRequest();
    }

    public static final Object takePicture(ImageCapture r12, final Function0<Unit> r13, final Function1<? super Integer, Unit> r14, final Function1<? super Bitmap, Unit> r15, Continuation<? super ImageProxy> r16) {
        CoroutineDispatcher r0 = r16.getContext().get(ContinuationInterceptor.Key);
        DelegatingImageCapturedCallback r2 = null;
        if ((r0 instanceof CoroutineDispatcher) == false) goto L5;
        CoroutineDispatcher r1 = r0;
    L6:
        if (r1 == null) goto L9;
        Executor r3 = ExecutorsKt.asExecutor(r1);
        if (r3 == null) goto L9;
    L10:
        final kotlinx.coroutines.j r4 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r16), 1);
        r4.C();
        final Ref.ObjectRef r9 = new Ref.ObjectRef();
        r9.element = new DelegatingImageCapturedCallback(new ImageCaptureExtKt$takePicture$2$1(r13, r14, r15, r9, r4));
        r4.i(new ImageCaptureExtKt$takePicture$2$2(r9));
        Object r5 = r9.element;
        if (r5 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("delegatingCallback");
    L14:
        r12.takePicture(r3, r2);
        Object r6 = r4.B();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        DebugProbesKt.probeCoroutineSuspended(r16);
    L17:
        return r6;
    L13:
        r2 = (DelegatingImageCapturedCallback) r5;
    L9:
        r3 = CameraXExecutors.directExecutor();
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public static final Object takePicture(ImageCapture r12, ImageCapture.OutputFileOptions r13, final Function0<Unit> r14, final Function1<? super Integer, Unit> r15, final Function1<? super Bitmap, Unit> r16, Continuation<? super ImageCapture.OutputFileResults> r17) {
        CoroutineDispatcher r0 = r17.getContext().get(ContinuationInterceptor.Key);
        DelegatingImageSavedCallback r2 = null;
        if ((r0 instanceof CoroutineDispatcher) == false) goto L5;
        CoroutineDispatcher r1 = r0;
    L6:
        if (r1 == null) goto L9;
        Executor r3 = ExecutorsKt.asExecutor(r1);
        if (r3 == null) goto L9;
    L10:
        final kotlinx.coroutines.j r4 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r17), 1);
        r4.C();
        final Ref.ObjectRef r9 = new Ref.ObjectRef();
        r9.element = new DelegatingImageSavedCallback(new ImageCaptureExtKt$takePicture$4$1(r14, r15, r16, r9, r4));
        r4.i(new ImageCaptureExtKt$takePicture$4$2(r9));
        Object r5 = r9.element;
        if (r5 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("delegatingCallback");
    L14:
        r12.takePicture(r13, r3, r2);
        Object r6 = r4.B();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        DebugProbesKt.probeCoroutineSuspended(r17);
    L17:
        return r6;
    L13:
        r2 = (DelegatingImageSavedCallback) r5;
    L9:
        r3 = CameraXExecutors.directExecutor();
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public static /* synthetic */ Object takePicture$default(ImageCapture r1, Function0 r2, Function1 r3, Function1 r4, Continuation r5, int r6, Object r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        return takePicture(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Object takePicture$default(ImageCapture r7, ImageCapture.OutputFileOptions r8, Function0 r9, Function1 r10, Function1 r11, Continuation r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        Function0 r3 = null;
    L7:
        if ((r13 & 4) == 0) goto L9;
        Function1 r4 = null;
    L11:
        if ((r13 & 8) == 0) goto L13;
        Function1 r5 = null;
    L15:
        return takePicture(r7, r8, r3, r4, r5, r12);
    L13:
        r5 = r11;
        goto L15
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }
}
