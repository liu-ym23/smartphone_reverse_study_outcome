package com.bytedance.live.datacontext;

import androidx.lifecycle.ViewModel;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "M", "it", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 4, 3}, xi = 48)
final class DataContextKt$makeDefaultFinalizer$1 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ Function1<Object, Object> $valueGetter;

    public DataContextKt$makeDefaultFinalizer$1(Function1<Object, ? extends Object> r100) {
        this.$valueGetter = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Object r100) {
        Object r101 = this.$valueGetter.invoke(r100);
        if ((r101 instanceof ViewModel) == false) goto L6;
        Function1 r102 = (Function1) DataContext_androidKt.f255062a.getValue();
        r102.invoke((ViewModel) r101);
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
