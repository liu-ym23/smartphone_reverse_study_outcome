package com.bytedance.android.window.shop.home.tabcard;

import com.bytedance.android.ec.core.arch.viewmodel.BaseViewModel;
import com.bytedance.android.ec.hybrid.list.entity.i;
import com.bytedance.android.ec.hybrid.list.entity.k;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\t\u001a\u00020\u00042\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0006j\u0002`\u0007J\u001e\u0010\n\u001a\u00020\u00042\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0006j\u0002`\u0007J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\f\u001a\u00020\u0004H\u0014R0\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f`\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012RD\u0010\u0015\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0006j\u0002`\u00070\u0013j\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0006j\u0002`\u0007`\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/window/shop/home/tabcard/ECWindowHybridTabCardViewModel;", "Lcom/bytedance/android/ec/core/arch/viewmodel/BaseViewModel;", "Lcom/bytedance/android/ec/hybrid/list/entity/k;", "vo", "", "notifyChanged", "Lkotlin/Function1;", "Lcom/bytedance/android/window/shop/home/tabcard/HybridChangedReceiver;", "receiver", "registerReceiver", "unregisterReceiver", "provide", "onCleared", "Ljava/util/LinkedHashMap;", "", "Lcom/bytedance/android/ec/hybrid/list/entity/i;", "Lkotlin/collections/LinkedHashMap;", "attachedObjects", "Ljava/util/LinkedHashMap;", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "receivers", "Ljava/util/LinkedHashSet;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowHybridTabCardViewModel extends BaseViewModel {
    private final LinkedHashMap<String, i> attachedObjects;
    private final LinkedHashSet<Function1<k, Unit>> receivers;

    public ECWindowHybridTabCardViewModel() {
        super(null, null, 3, null);
        this.attachedObjects = new LinkedHashMap();
        this.receivers = new LinkedHashSet();
    }

    public void onCleared() {
        super.onCleared();
        this.receivers.clear();
    }

    private final void notifyChanged(k r3) {
        Iterator<T> r0 = this.receivers.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Function1) r0.next()).invoke(r3);
        goto L4
    }

    public final void provide(k r2) {
        Intrinsics.checkNotNullParameter(r2, "vo");
        notifyChanged(r2);
    }

    public final void registerReceiver(Function1<? super k, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "receiver");
        this.receivers.add(r2);
    }

    public final void unregisterReceiver(Function1<? super k, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "receiver");
        this.receivers.remove(r2);
    }
}
