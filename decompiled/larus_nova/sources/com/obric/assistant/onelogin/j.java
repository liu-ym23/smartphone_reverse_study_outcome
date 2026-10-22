package com.obric.assistant.onelogin;

import androidx.lifecycle.Observer;
import java.lang.ref.WeakReference;
import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class j {

    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f390939a;

        public a(f r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f390939a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f390939a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f390939a.invoke(r100);
        }
    }

    public static final ObricOneLoginActivity a(WeakReference r100) {
        ObricOneLoginActivity r101 = (ObricOneLoginActivity) r100.get();
        if (r101 != null) goto L6;
        return null;
    L6:
        if (r101.isFinishing() == false) goto L8;
    L9:
        r101 = null;
    L11:
        return r101;
    L8:
        if (r101.isDestroyed() == false) goto L11;
        goto L9
    }
}
