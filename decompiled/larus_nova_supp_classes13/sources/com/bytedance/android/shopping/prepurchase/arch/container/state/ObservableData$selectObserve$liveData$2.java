package com.bytedance.android.shopping.prepurchase.arch.container.state;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\b\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\u000b\u0010\u0004\u001a\u00078\u0002¢\u0006\u0002\b\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"A", "B", "T", "Lkotlin/jvm/JvmSuppressWildcards;", "it", "Lcom/bytedance/android/shopping/prepurchase/arch/container/state/l;", "invoke", "(Ljava/lang/Object;)Lcom/bytedance/android/shopping/prepurchase/arch/container/state/l;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class ObservableData$selectObserve$liveData$2 extends Lambda implements Function1<Object, l<Object, Object>> {
    final /* synthetic */ KProperty1 $prop1;
    final /* synthetic */ KProperty1 $prop2;

    public ObservableData$selectObserve$liveData$2(KProperty1 r1, KProperty1 r2) {
        this.$prop1 = r1;
        this.$prop2 = r2;
        super(1);
    }

    public final l<Object, Object> invoke(Object r4) {
        return new l(this.$prop1.get(r4), this.$prop2.get(r4));
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m2502invoke(Object r1) {
        return invoke(r1);
    }
}
