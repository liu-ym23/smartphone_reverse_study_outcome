package com.bytedance.lark.molten_livequery_wrapper;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u0001H\u0001H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "R", ExifInterface.GPS_DIRECTION_TRUE, "position", "", "from", "Lkotlin/Function0;", "cached", AbsMethodDelegate.TAG_INVOKE, "(ILkotlin/jvm/functions/Function0;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ListWrapperFactory$map$1 extends Lambda implements Function3<Integer, Function0<Object>, Object, Object> {
    final /* synthetic */ Function2<Function0<Object>, Object, Object> $transform;

    /* JADX WARN: Multi-variable type inference failed */
    public ListWrapperFactory$map$1(Function2<? super Function0<Object>, Object, Object> r100) {
        this.$transform = r100;
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Integer r100, Function0<Object> r101, Object r102) {
        return invoke(r100.intValue(), r101, r102);
    }

    public final Object invoke(int r100, Function0<Object> r101, Object r102) {
        Intrinsics.checkNotNullParameter(r101, "from");
        return this.$transform.invoke(r101, r102);
    }
}
