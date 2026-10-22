package com.bytedance.assem.arch.extensions;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.assem.arch.core.Assem;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, AbsMethodDelegate.TAG_INVOKE, "()Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
final class DataStoreExtKt$getProducerFactory$1 extends Lambda implements Function0<Object> {
    final /* synthetic */ Class $clazz;
    final /* synthetic */ String $identify;
    final /* synthetic */ Assem $this_getProducerFactory;

    public DataStoreExtKt$getProducerFactory$1(Assem r100, Class r101, String r102) {
        this.$this_getProducerFactory = r100;
        this.$clazz = r101;
        this.$identify = r102;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return this.$this_getProducerFactory.j().f192878i.a(this.$clazz, this.$identify);
    }
}
