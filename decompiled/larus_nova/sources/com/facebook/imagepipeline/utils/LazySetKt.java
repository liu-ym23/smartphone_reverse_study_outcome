package com.facebook.imagepipeline.utils;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.keyframes.model.KFAnimation;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a4\u0010\u0005\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0086\n¢\u0006\u0002\u0010\n\u001a<\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\r\u001a\u0002H\u0002H\u0086\n¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"lazySet", "Lcom/facebook/imagepipeline/utils/LazySet;", ExifInterface.GPS_DIRECTION_TRUE, "initializer", "Lkotlin/Function0;", "getValue", "thisRef", "", KFAnimation.PROPERTY_TYPE_JSON_FIELD, "Lkotlin/reflect/KProperty;", "(Lcom/facebook/imagepipeline/utils/LazySet;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Lcom/facebook/imagepipeline/utils/LazySet;Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "imagepipeline_noasanRelease"}, k = 2, mv = {1, 1, 16})
public final class LazySetKt {
    public static final <T> LazySet<T> lazySet(Function0<? extends T> r100) {
        return new LazySetImpl(r100, null, 2, null);
    }

    public static final <T> T getValue(LazySet<T> r100, Object r101, KProperty<?> r102) {
        return r100.getValue();
    }

    public static final <T> void setValue(LazySet<T> r100, Object r101, KProperty<?> r102, T r103) {
        r100.setValue(r103);
    }
}
