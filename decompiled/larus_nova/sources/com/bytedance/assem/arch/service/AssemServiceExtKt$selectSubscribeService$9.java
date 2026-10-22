package com.bytedance.assem.arch.service;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.assem.arch.extensions.n;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001a \u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\b\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0004\b\u0003\u0010\u0004\"\u0004\b\u0004\u0010\u0005\"\u0004\b\u0005\u0010\u00062\u0006\u0010\u0007\u001a\u00028\u0000H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lcom/bytedance/assem/arch/service/a;", "DATA", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "it", "Lcom/bytedance/assem/arch/extensions/n;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/assem/arch/service/a;)Lcom/bytedance/assem/arch/extensions/n;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class AssemServiceExtKt$selectSubscribeService$9 extends Lambda implements Function1<a, n<Object, Object, Object, Object, Object>> {
    final /* synthetic */ KProperty1 $prop1;
    final /* synthetic */ KProperty1 $prop2;
    final /* synthetic */ KProperty1 $prop3;
    final /* synthetic */ KProperty1 $prop4;
    final /* synthetic */ KProperty1 $prop5;

    public AssemServiceExtKt$selectSubscribeService$9(KProperty1 r100, KProperty1 r101, KProperty1 r102, KProperty1 r103, KProperty1 r104) {
        this.$prop1 = r100;
        this.$prop2 = r101;
        this.$prop3 = r102;
        this.$prop4 = r103;
        this.$prop5 = r104;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ n<Object, Object, Object, Object, Object> invoke(a r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final n<Object, Object, Object, Object, Object> invoke2(a r100) {
        return new n(this.$prop1.get(r100), this.$prop2.get(r100), this.$prop3.get(r100), this.$prop4.get(r100), this.$prop5.get(r100));
    }
}
