package com.bytedance.assem.arch.service;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.assem.arch.extensions.n;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\f\u001a\u00020\t\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0004\b\u0003\u0010\u0004\"\u0004\b\u0004\u0010\u0005\"\u0004\b\u0005\u0010\u00062$\u0010\b\u001a \u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0007H\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lcom/bytedance/assem/arch/service/a;", "DATA", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "Lcom/bytedance/assem/arch/extensions/n;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/assem/arch/extensions/n;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class AssemServiceExtKt$selectSubscribeService$10 extends Lambda implements Function1<n<Object, Object, Object, Object, Object>, Unit> {
    final /* synthetic */ Ref.ObjectRef $lastValue;
    final /* synthetic */ Function5 $observer;

    public AssemServiceExtKt$selectSubscribeService$10(Ref.ObjectRef r100, Function5 r101) {
        this.$lastValue = r100;
        this.$observer = r101;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(n<Object, Object, Object, Object, Object> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(n<Object, Object, Object, Object, Object> r100) {
        if ((!Intrinsics.areEqual(r100, (n) this.$lastValue.element)) == false) goto L9;
        Function5 r101 = this.$observer;
        if (r101 == null) goto L7;
        Unit r102 = (Unit) r101.invoke(r100.f192940a, r100.f192941b, r100.f192942c, r100.f192943d, r100.f192944e);
    L7:
        this.$lastValue.element = r100;
        return;
    }
}
