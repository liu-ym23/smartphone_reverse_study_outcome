package com.bytedance.android.shopping.prepurchase.arch.container.state;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001a%\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\b¢\u0006\u0002\b\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003\"\u0004\b\u0004\u0010\u0004\"\u0004\b\u0005\u0010\u00052\u000b\u0010\u0007\u001a\u00078\u0005¢\u0006\u0002\b\u0006H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"A", "B", "C", "D", "E", "T", "Lkotlin/jvm/JvmSuppressWildcards;", "it", "Lcom/bytedance/android/shopping/prepurchase/arch/container/state/o;", "invoke", "(Ljava/lang/Object;)Lcom/bytedance/android/shopping/prepurchase/arch/container/state/o;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class ObservableData$selectObserve$liveData$5 extends Lambda implements Function1<Object, o<Object, Object, Object, Object, Object>> {
    final /* synthetic */ KProperty1 $prop1;
    final /* synthetic */ KProperty1 $prop2;
    final /* synthetic */ KProperty1 $prop3;
    final /* synthetic */ KProperty1 $prop4;
    final /* synthetic */ KProperty1 $prop5;

    public ObservableData$selectObserve$liveData$5(KProperty1 r1, KProperty1 r2, KProperty1 r3, KProperty1 r4, KProperty1 r5) {
        this.$prop1 = r1;
        this.$prop2 = r2;
        this.$prop3 = r3;
        this.$prop4 = r4;
        this.$prop5 = r5;
        super(1);
    }

    public final o<Object, Object, Object, Object, Object> invoke(Object r8) {
        return new o(this.$prop1.get(r8), this.$prop2.get(r8), this.$prop3.get(r8), this.$prop4.get(r8), this.$prop5.get(r8));
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m2505invoke(Object r1) {
        return invoke(r1);
    }
}
