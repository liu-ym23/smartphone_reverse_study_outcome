package com.bytedance.android.livesdk.ktvimpl.base.frame;

import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class RecycleWidgetHelper {
    public static final /* synthetic */ int a = 0;

    public static final class Builder {
        public c a;
        public DataCenter b;
        public String c;
        public Integer d;
        public Function1<? super Boolean, Unit> e;
        public Function0<Unit> f;
        public final LifecycleOwner g;
        public final ViewGroup h;

        public Builder(ViewGroup r2) {
            Intrinsics.checkNotNullParameter(r2, "container");
            this.g = null;
            this.h = r2;
        }

        public final <T extends AbsRecycleViewKWidget<?>> T a(Function3<? super LifecycleOwner, ? super ViewGroup, ? super c, ? extends T> r6) {
            Intrinsics.checkNotNullParameter(r6, "newInstanceFactory");
            String r0 = this.c;
            final long r1 = System.currentTimeMillis();
            final Function1<T, Unit> r3 = new RecycleWidgetHelper$Builder$recycleOrCreate$notifyReLoadComplete$1(this, r1);
            if (r0 != null) goto L5;
        L20:
            T r7 = (T) r6.invoke(this.g, this.h, this.a);
            r7.g(null);
            r7.g = this.d;
            Function1<? super Boolean, Unit> r2 = this.e;
            if (r2 == null) goto L23;
            Unit r4 = (Unit) r2.invoke(Boolean.FALSE);
        L23:
            return r7;
        L5:
            if (r0.length() <= 0) goto L7;
            boolean r5 = true;
        L8:
            if (r5 == false) goto L20;
            DataCenter r8 = this.b;
            if (r8 == null) goto L12;
            final T r9 = (T) r8.get(r0, null);
        L13:
            if (r9 == null) goto L20;
            if (r9.i() == true) goto L20;
            r9.k(this.g, this.h, this.a, new RecycleWidgetHelper$Builder$recycleOrCreate$1(r3, r9));
            r9.g = this.d;
            Function1<? super Boolean, Unit> r10 = this.e;
            if (r10 == null) goto L19;
            Unit r11 = (Unit) r10.invoke(Boolean.TRUE);
        L19:
            return r9;
        L12:
            r9 = null;
            goto L13
        L7:
            r5 = false;
            goto L8
        }
    }

    public static final class a {
    }

    static {
    }
}
