package com.larus.gallery.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes29.dex */
public interface IGalleryDataSource<T> {

    public static final class DefaultImpls {
        public static b0.b a() {
            return new b0.b(CollectionsKt.emptyList(), false, false, 6);
        }

        public static b0.b b() {
            return new b0.b(CollectionsKt.emptyList(), false, false, 6);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00ad -> B:27:0x00b3). Please report as a decompilation issue!!! */
        public static <T> Object c(IGalleryDataSource<T> r100, List<? extends T> r101, Continuation<? super List<? extends Pair<? extends T, k>>> r110) {
            if ((r110 instanceof IGalleryDataSource$refreshDisplayItems$1) == false) goto L7;
            IGalleryDataSource$refreshDisplayItems$1 r102 = (IGalleryDataSource$refreshDisplayItems$1) r110;
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
            Collection r106 = (Collection) r102.L$4;
            Object r107 = r102.L$3;
            Iterator<T> r108 = (Iterator) r102.L$2;
            Collection r109 = (Collection) r102.L$1;
            IGalleryDataSource r112 = (IGalleryDataSource) r102.L$0;
            ResultKt.throwOnFailure(r111);
            IGalleryDataSource$refreshDisplayItems$1 r113 = r102;
            Collection r114 = r109;
            IGalleryDataSource r115 = r112;
            Object r116 = r104;
        L27:
            r106.add(TuplesKt.to(r107, r111));
            Collection r117 = r114;
            r102 = r113;
            Iterator<T> r118 = r108;
            r100 = (IGalleryDataSource<T>) r115;
            r104 = r116;
        L18:
            if (r118.hasNext() == false) goto L29;
            T r119 = r118.next();
            r102.L$0 = r100;
            r102.L$1 = r117;
            r102.L$2 = r118;
            r102.L$3 = r117;
            r102.L$4 = null;
            r102.label = 1;
            Object r120 = r100.f(r119, r102);
            if (r120 != r104) goto L22;
            return r104;
        L22:
            IGalleryDataSource r121 = r100;
            r106 = r117;
            r111 = r120;
            r108 = r118;
            Collection r122 = r106;
        L23:
            r102.L$0 = r121;
            r102.L$1 = r122;
            r102.L$2 = r108;
            r102.L$3 = r111;
            r102.L$4 = r106;
            r102.label = 2;
            Object r123 = r121.i(r111, r102);
            if (r123 != r104) goto L26;
            return r104;
        L26:
            IGalleryDataSource$refreshDisplayItems$1 r124 = r102;
            r114 = r122;
            r107 = r111;
            r111 = r123;
            r116 = r104;
            r113 = r124;
            r115 = r121;
            goto L27
        L29:
            return (List) r117;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            r106 = (Collection) r102.L$3;
            Iterator<T> r125 = (Iterator) r102.L$2;
            Collection r126 = (Collection) r102.L$1;
            IGalleryDataSource r127 = (IGalleryDataSource) r102.L$0;
            ResultKt.throwOnFailure(r111);
            r108 = r125;
            r122 = r126;
            r121 = r127;
            goto L23
        L16:
            ResultKt.throwOnFailure(r111);
            List<? extends T> r128 = r101;
            r117 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r128, 10));
            r118 = r128.iterator();
        L7:
            r102 = new IGalleryDataSource$refreshDisplayItems$1(r110);
            goto L8
        }
    }

    boolean b();

    Object c(Continuation<? super b0<? extends List<? extends T>>> r100);

    Object d(T r100, Continuation<? super b0<? extends List<? extends T>>> r101);

    Object e(List<? extends T> r100, Continuation<? super List<? extends Pair<? extends T, k>>> r101);

    Object f(T r100, Continuation<? super T> r101);

    Object g(T r100, Continuation<? super b0<? extends List<? extends T>>> r101);

    boolean h();

    Object i(T r100, Continuation<? super k> r101);

    boolean j(T r100, T r101);

    int k();
}
