package com.larus.bmhome.chat.referenceicon;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.referenceicon.ImageViewBitmapLoader$load$2", f = "ImageViewBitmapLoader.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
public final class ImageViewBitmapLoader$load$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ boolean $acceptDrawable;
    final /* synthetic */ Context $context;
    final /* synthetic */ Function1<ImageView, Unit> $request;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;

    public static final class a implements Function1<Throwable, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageViewBitmapLoader.a f308516a;

        public a(ImageViewBitmapLoader.a r100) {
            this.f308516a = r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable r100) {
            this.f308516a.f308515b = null;
            return Unit.INSTANCE;
        }
    }

    public static final class b implements Function1<Bitmap, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i<Bitmap> f308517a;

        public b(j r100) {
            this.f308517a = r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Bitmap r100) {
            Bitmap r101 = r100;
            Intrinsics.checkNotNullParameter(r101, SimplayerImageStrategy.RESULT_BITMAP);
            if (this.f308517a.isActive() == false) goto L6;
            this.f308517a.resumeWith(Result.m9449constructorimpl(r101));
        L6:
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImageViewBitmapLoader$load$2(Context r100, boolean r101, Function1<? super ImageView, Unit> r102, Continuation<? super ImageViewBitmapLoader$load$2> r103) {
        this.$context = r100;
        this.$acceptDrawable = r101;
        this.$request = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ImageViewBitmapLoader$load$2(this.$context, this.$acceptDrawable, this.$request, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Bitmap> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Bitmap> r101) {
        return ((ImageViewBitmapLoader$load$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        Function1 r103 = (Function1) this.L$1;
        Context r104 = (Context) this.L$0;
        ResultKt.throwOnFailure(r100);
    L20:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        Context r105 = this.$context;
        boolean r106 = this.$acceptDrawable;
        Function1<ImageView, Unit> r107 = this.$request;
        this.L$0 = r105;
        this.L$1 = r107;
        this.Z$0 = r106;
        this.label = 1;
        j r108 = new j(IntrinsicsKt.intercepted(this), 1);
        r108.C();
        ImageViewBitmapLoader.a r109 = new ImageViewBitmapLoader.a(r105.getApplicationContext(), r106, new b(r108));
        r108.i(new a(r109));
        r107.invoke(r109);     // Catch: Throwable -> L11
    L15:
        r100 = r108.B();
        if (r100 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
        DebugProbesKt.probeCoroutineSuspended(this);
    L18:
        if (r100 != r101) goto L20;
        return r101;
    L11:
        th = move-exception;
        r109.f308515b = null;
        if (r108.isActive() == false) goto L15;
        Result.Companion r110 = Result.Companion;
        r108.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        goto L15
    }
}
