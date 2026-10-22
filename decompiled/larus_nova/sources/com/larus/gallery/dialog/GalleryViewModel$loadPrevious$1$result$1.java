package com.larus.gallery.dialog;

import androidx.exifinterface.media.ExifInterface;
import com.larus.gallery.api.IGalleryDataSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/larus/gallery/api/LoadingState;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.gallery.dialog.GalleryViewModel$loadPrevious$1$result$1", f = "GalleryViewModel.kt", i = {}, l = {231}, m = "invokeSuspend", n = {}, s = {})
public final class GalleryViewModel$loadPrevious$1$result$1<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.gallery.api.b0<? extends List<? extends T>>>, Object> {
    final /* synthetic */ com.larus.gallery.api.g<T> $currentConfig;
    final /* synthetic */ Ref.ObjectRef<T> $loadCursor;
    int label;

    public GalleryViewModel$loadPrevious$1$result$1(com.larus.gallery.api.g<T> r100, Ref.ObjectRef<T> r101, Continuation<? super GalleryViewModel$loadPrevious$1$result$1> r102) {
        this.$currentConfig = r100;
        this.$loadCursor = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new GalleryViewModel$loadPrevious$1$result$1(this.$currentConfig, this.$loadCursor, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Object r101) {
        return invoke(r100, (Continuation) r101);
    }

    public final Object invoke(CoroutineScope r100, Continuation<? super com.larus.gallery.api.b0<? extends List<? extends T>>> r101) {
        return ((GalleryViewModel$loadPrevious$1$result$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        IGalleryDataSource<T> r103 = this.$currentConfig.f343846a;
        T r104 = this.$loadCursor.element;
        this.label = 1;
        r100 = r103.g(r104, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
