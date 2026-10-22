package com.bytedance.assem.arch.service;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.assem.arch.extensions.k;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/bytedance/assem/arch/service/a;", "DATA", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "it", "Lcom/bytedance/assem/arch/extensions/k;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/assem/arch/service/a;)Lcom/bytedance/assem/arch/extensions/k;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class AssemServiceExtKt$selectSubscribeService$3 extends Lambda implements Function1<a, k<Object, Object>> {
    final /* synthetic */ KProperty1 $prop1;
    final /* synthetic */ KProperty1 $prop2;

    public AssemServiceExtKt$selectSubscribeService$3(KProperty1 r100, KProperty1 r101) {
        this.$prop1 = r100;
        this.$prop2 = r101;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ k<Object, Object> invoke(a r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final k<Object, Object> invoke2(a r100) {
        return new k(this.$prop1.get(r100), this.$prop2.get(r100));
    }
}
