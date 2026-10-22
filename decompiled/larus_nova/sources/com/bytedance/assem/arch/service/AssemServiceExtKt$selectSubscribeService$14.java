package com.bytedance.assem.arch.service;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.assem.arch.extensions.j;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\b\b\u0002\u0010\u0004*\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/bytedance/assem/arch/service/a;", "DATA", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/bytedance/assem/arch/viewModel/h;", ExifInterface.LATITUDE_SOUTH, "Lcom/bytedance/assem/arch/extensions/j;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/assem/arch/extensions/j;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class AssemServiceExtKt$selectSubscribeService$14 extends Lambda implements Function1<j<Object>, Unit> {
    final /* synthetic */ Ref.ObjectRef $lastValue;
    final /* synthetic */ Function1 $observer;

    public AssemServiceExtKt$selectSubscribeService$14(Ref.ObjectRef r100, Function1 r101) {
        this.$lastValue = r100;
        this.$observer = r101;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(j<Object> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(j<Object> r100) {
        if ((!Intrinsics.areEqual(r100, (j) this.$lastValue.element)) == false) goto L9;
        Function1 r101 = this.$observer;
        if (r101 == null) goto L7;
        Unit r102 = (Unit) r101.invoke(r100.f192930a);
    L7:
        this.$lastValue.element = r100;
        return;
    }
}
