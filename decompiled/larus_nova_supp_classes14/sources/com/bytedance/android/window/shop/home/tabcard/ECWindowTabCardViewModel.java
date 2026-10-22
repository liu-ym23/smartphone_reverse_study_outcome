package com.bytedance.android.window.shop.home.tabcard;

import com.bytedance.android.ec.core.arch.viewmodel.BaseViewModel;
import com.bytedance.android.window.shop.repository.tab.entity.f;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J*\u0010\n\u001a\u00020\u00022\"\u0010\t\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0004\u0012\u00020\u00020\u0004j\u0002`\bJ*\u0010\u000b\u001a\u00020\u00022\"\u0010\t\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0004\u0012\u00020\u00020\u0004j\u0002`\bJ\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0007J\b\u0010\u000e\u001a\u00020\u0002H\u0014R0\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u000fj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\\\u0010\u0015\u001aJ\u0012 \u0012\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0004\u0012\u00020\u00020\u0004j\u0002`\b0\u0013j$\u0012 \u0012\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0004\u0012\u00020\u00020\u0004j\u0002`\b`\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/window/shop/home/tabcard/ECWindowTabCardViewModel;", "Lcom/bytedance/android/ec/core/arch/viewmodel/BaseViewModel;", "", "notifyChanged", "Lkotlin/Function1;", "", "", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "Lcom/bytedance/android/window/shop/home/tabcard/ChangedReceiver;", "receiver", "registerReceiver", "unregisterReceiver", "vo", "provide", "onCleared", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "attachedObjects", "Ljava/util/LinkedHashMap;", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "receivers", "Ljava/util/LinkedHashSet;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowTabCardViewModel extends BaseViewModel {
    private final LinkedHashMap<Integer, f> attachedObjects;
    private final LinkedHashSet<Function1<Map<Integer, ? extends f>, Unit>> receivers;

    public ECWindowTabCardViewModel() {
        super(null, null, 3, null);
        this.attachedObjects = new LinkedHashMap();
        this.receivers = new LinkedHashSet();
    }

    private final void notifyChanged() {
        Iterator<T> r0 = this.receivers.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Function1) r0.next()).invoke(this.attachedObjects);
        goto L4
    }

    public void onCleared() {
        super.onCleared();
        this.receivers.clear();
    }

    public final void provide(f r3) {
        Intrinsics.checkNotNullParameter(r3, "vo");
        f r0 = this.attachedObjects.get(Integer.valueOf(r3.i));
        if (r0 != null) goto L5;
    L7:
        this.attachedObjects.put(Integer.valueOf(r3.i), r3);
        notifyChanged();
        return;
    L5:
        if (Intrinsics.areEqual(r0, r3) == false) goto L7;
    }

    public final void registerReceiver(Function1<? super Map<Integer, ? extends f>, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "receiver");
        this.receivers.add(r2);
        notifyChanged();
    }

    public final void unregisterReceiver(Function1<? super Map<Integer, ? extends f>, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "receiver");
        this.receivers.remove(r2);
    }
}
