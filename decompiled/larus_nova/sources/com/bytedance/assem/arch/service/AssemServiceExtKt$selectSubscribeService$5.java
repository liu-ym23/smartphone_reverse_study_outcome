package com.bytedance.assem.arch.service;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.assem.arch.extensions.l;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0004\b\u0003\u0010\u00042\u0006\u0010\u0005\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/bytedance/assem/arch/service/a;", "DATA", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "it", "Lcom/bytedance/assem/arch/extensions/l;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/assem/arch/service/a;)Lcom/bytedance/assem/arch/extensions/l;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class AssemServiceExtKt$selectSubscribeService$5 extends Lambda implements Function1<a, l<Object, Object, Object>> {
    final /* synthetic */ KProperty1 $prop1;
    final /* synthetic */ KProperty1 $prop2;
    final /* synthetic */ KProperty1 $prop3;

    public AssemServiceExtKt$selectSubscribeService$5(KProperty1 r100, KProperty1 r101, KProperty1 r102) {
        this.$prop1 = r100;
        this.$prop2 = r101;
        this.$prop3 = r102;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ l<Object, Object, Object> invoke(a r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final l<Object, Object, Object> invoke2(a r100) {
        return new l(this.$prop1.get(r100), this.$prop2.get(r100), this.$prop3.get(r100));
    }
}
