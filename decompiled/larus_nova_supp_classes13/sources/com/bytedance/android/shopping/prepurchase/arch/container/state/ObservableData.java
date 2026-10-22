package com.bytedance.android.shopping.prepurchase.arch.container.state;

import androidx.lifecycle.InsMediatorLiveData;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MapToInsMediatorLiveDataKt;
import androidx.lifecycle.Observer;
import com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.Lifecycle;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public class ObservableData<T> implements e<T> {
    public final Map<com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e, LifecycleOwner> a;
    public final Map<g<? super T>, Observer<? super T>> b;
    public final LiveData<T> c;

    public static final class a implements com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.d {
        public final /* synthetic */ ObservableData a;
        public final /* synthetic */ com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e b;

        public a(ObservableData r1, com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.d
        public final void h0(com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e r2, Lifecycle.Event r3) {
            Intrinsics.checkNotNullParameter(r2, "source");
            Intrinsics.checkNotNullParameter(r3, "event");
            if (r2.getLifecycle().b() != Lifecycle.State.DESTROYED) goto L6;
            this.a.a.remove(this.b);
            return;
        }
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.c
    public final T a() {
        InsMediatorLiveData r0 = this.c;
        if ((r0 instanceof InsMediatorLiveData) == false) goto L7;
        return (T) r0.getValueImmediately();
    L7:
        return (T) r0.getValue();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.c
    @Deprecated(message = "改方法继承了 LiveData 的 bug，详见[getValueImmediately]", replaceWith = @ReplaceWith(expression = "getValueImmediately()", imports = {}))
    public final T getValue() {
        return (T) this.c.getValue();
    }

    public ObservableData(LiveData<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "target");
        this.c = r2;
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
    }

    public final LifecycleOwner c(com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e r4) {
        LinkedHashMap r0 = (LinkedHashMap) this.a;
        Object r1 = r0.get(r4);
        if (r1 != null) goto L6;
        r4.getLifecycle().a(new a(this, r4));
        r1 = f.a(r4);
        r0.put(r4, r1);
    L6:
        return (LifecycleOwner) r1;
    }

    public final ObservableData d(Function1 r3) {
        Intrinsics.checkNotNullParameter(r3, "transform");
        return new ObservableData(MapToInsMediatorLiveDataKt.mapToInsMediatorLiveData(this.c, r3));
    }

    public final void e(com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e r3, final g<? super T> r4) {
        Intrinsics.checkNotNullParameter(r3, "owner");
        Intrinsics.checkNotNullParameter(r4, "observer");
        LifecycleOwner r5 = c(r3);
        Observer<T> r0 = new ObservableData$observe$androidObserver$1(r4);
        this.b.put(r4, r0);
        this.c.observe(r5, r0);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.e
    public final void b(com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e r3, i<T> r4, final g<T> r5) {
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "config");
        Intrinsics.checkNotNullParameter(r5, "subscriber");
        LifecycleOwner r6 = c(r3);
        b r0 = new b(r4, r5);
        this.b.put(r5, r0);
        if (r4.c == false) goto L5;
        this.c.observeForever(r0);
        r6.getLifecycle().addObserver(new ObservableData$selectObserve$1(this, r5));
        return;
    L5:
        this.c.observe(r6, r0);
    }

    public final <A, B, C> ObservableData<m<A, B, C>> f(final KProperty1<T, ? extends A> r3, final KProperty1<T, ? extends B> r4, final KProperty1<T, ? extends C> r5) {
        Intrinsics.checkNotNullParameter(r3, "prop1");
        Intrinsics.checkNotNullParameter(r4, "prop2");
        Intrinsics.checkNotNullParameter(r5, "prop3");
        return new ObservableData(MapToInsMediatorLiveDataKt.mapToInsMediatorLiveData(this.c, new ObservableData$selectObserve$liveData$3(r3, r4, r5)));
    }
}
