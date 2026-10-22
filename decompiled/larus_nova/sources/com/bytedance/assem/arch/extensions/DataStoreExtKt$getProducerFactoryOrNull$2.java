package com.bytedance.assem.arch.extensions;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.assem.arch.viewModel.AssemViewModel;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0005\u001a\u0004\u0018\u00018\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/assem/arch/viewModel/h;", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, AbsMethodDelegate.TAG_INVOKE, "()Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class DataStoreExtKt$getProducerFactoryOrNull$2 extends Lambda implements Function0<Object> {
    final /* synthetic */ Class $clazz;
    final /* synthetic */ String $identify;
    final /* synthetic */ AssemViewModel $this_getProducerFactoryOrNull;

    public DataStoreExtKt$getProducerFactoryOrNull$2(AssemViewModel r100, Class r101, String r102) {
        this.$this_getProducerFactoryOrNull = r100;
        this.$clazz = r101;
        this.$identify = r102;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        com.bytedance.assem.arch.core.b r100 = this.$this_getProducerFactoryOrNull.getHierarchyDataStore();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.b(this.$clazz, this.$identify);
    }
}
