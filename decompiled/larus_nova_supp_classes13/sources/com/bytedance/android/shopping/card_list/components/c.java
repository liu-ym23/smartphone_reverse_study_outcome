package com.bytedance.android.shopping.card_list.components;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public class c {
    public final LifecycleOwner a;

    public final class a implements Observer {
        public final /* synthetic */ Function1 a;

        public a(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ Ref.IntRef a;
        public final /* synthetic */ Function1 b;

        public b(Ref.IntRef r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(T r3) {
            if (this.a.element < 1) goto L5;
            this.b.invoke(r3);
        L5:
            this.a.element++;
        }
    }

    public LifecycleOwner a() {
        return this.a;
    }

    public c(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        this.a = r2;
    }

    public final <T> void b(MutableLiveData<T> r3, Function1<? super T, Unit> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "liveData");
        Intrinsics.checkNotNullParameter(r4, "callback");
        if (r5 == false) goto L5;
    L8:
        r3.observe(a(), new a(r4));
        return;
    L5:
        if (r3.getValue() == null) goto L8;
        Ref.IntRef r6 = new Ref.IntRef();
        r6.element = 0;
        r3.observe(a(), new b(r6, r4));
    }
}
