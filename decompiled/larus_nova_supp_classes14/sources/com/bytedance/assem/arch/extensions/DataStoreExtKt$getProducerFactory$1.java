package com.bytedance.assem.arch.extensions;

import com.bytedance.assem.arch.core.Assem;
import com.bytedance.awemeopen.apps.framework.comment.write.model.TextExtraStruct;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "T", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 1, TextExtraStruct.TYPE_GROUP_CHAT})
final class DataStoreExtKt$getProducerFactory$1 extends Lambda implements Function0<Object> {
    final /* synthetic */ Class $clazz;
    final /* synthetic */ String $identify;
    final /* synthetic */ Assem $this_getProducerFactory;

    public DataStoreExtKt$getProducerFactory$1(Assem r1, Class r2, String r3) {
        this.$this_getProducerFactory = r1;
        this.$clazz = r2;
        this.$identify = r3;
        super(0);
    }

    public final Object invoke() {
        return this.$this_getProducerFactory.j().i.a(this.$clazz, this.$identify);
    }
}
