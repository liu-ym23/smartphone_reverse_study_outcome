package com.larus.gallery.dialog;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.gallery.api.IGalleryDataSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lcom/larus/gallery/dialog/MappedGalleryItem;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.gallery.dialog.GalleryViewModel$mapVisibleItems$mappedItems$1", f = "GalleryViewModel.kt", i = {0}, l = {325}, m = "invokeSuspend", n = {"destination$iv$iv"}, s = {"L$2"})
public final class GalleryViewModel$mapVisibleItems$mappedItems$1<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends f0<T>>>, Object> {
    final /* synthetic */ List<Integer> $candidatePositions;
    final /* synthetic */ com.larus.gallery.api.g<T> $currentConfig;
    final /* synthetic */ List<T> $data;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public GalleryViewModel$mapVisibleItems$mappedItems$1(List<Integer> r100, List<? extends T> r101, com.larus.gallery.api.g<T> r102, Continuation<? super GalleryViewModel$mapVisibleItems$mappedItems$1> r103) {
        this.$candidatePositions = r100;
        this.$data = r101;
        this.$currentConfig = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new GalleryViewModel$mapVisibleItems$mappedItems$1(this.$candidatePositions, this.$data, this.$currentConfig, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Object r101) {
        return invoke(r100, (Continuation) r101);
    }

    public final Object invoke(CoroutineScope r100, Continuation<? super List<f0<T>>> r101) {
        return ((GalleryViewModel$mapVisibleItems$mappedItems$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0084 -> B:15:0x008e). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        int r102 = this.I$0;
        Collection r103 = (Collection) this.L$5;
        Object r104 = this.L$4;
        Iterator<T> r105 = (Iterator) this.L$3;
        Collection r106 = (Collection) this.L$2;
        com.larus.gallery.api.g<T> r107 = (com.larus.gallery.api.g) this.L$1;
        List<T> r108 = (List) this.L$0;
        ResultKt.throwOnFailure(r110);
        List<T> r109 = r108;
        com.larus.gallery.api.g<T> r111 = r107;
        Iterator<T> r112 = r105;
        Object r113 = r104;
        Collection r114 = r103;
        int r115 = r102;
        Object r116 = r100;
        GalleryViewModel$mapVisibleItems$mappedItems$1<T> r117 = this;
    L15:
        r114.add(new f0(r115, r113, (com.larus.gallery.api.k) r110));
        GalleryViewModel$mapVisibleItems$mappedItems$1<T> r118 = r117;
        r100 = r116;
        Collection r119 = r106;
        Iterator<T> r120 = r112;
        com.larus.gallery.api.g<T> r121 = r111;
        List<T> r122 = r109;
    L10:
        if (r120.hasNext() == false) goto L17;
        int r123 = ((Number) r120.next()).intValue();
        Object r124 = ListProtector.get(r122, r123);
        IGalleryDataSource<T> r125 = r121.f343846a;
        r118.L$0 = r122;
        r118.L$1 = r121;
        r118.L$2 = r119;
        r118.L$3 = r120;
        r118.L$4 = r124;
        r118.L$5 = r119;
        r118.I$0 = r123;
        r118.label = 1;
        Object r126 = r125.i((T) r124, r118);
        if (r126 != r100) goto L14;
        return r100;
    L14:
        r109 = r122;
        r111 = r121;
        r112 = r120;
        r113 = r124;
        r114 = r119;
        r115 = r123;
        r116 = r100;
        r117 = r118;
        r110 = r126;
        r106 = r114;
        goto L15
    L17:
        return (List) r119;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        List<Integer> r127 = this.$candidatePositions;
        List<T> r128 = this.$data;
        com.larus.gallery.api.g<T> r129 = this.$currentConfig;
        ArrayList r130 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r127, 10));
        r120 = r127.iterator();
        r122 = r128;
        r121 = r129;
        r119 = r130;
        r118 = this;
        goto L10
    }
}
