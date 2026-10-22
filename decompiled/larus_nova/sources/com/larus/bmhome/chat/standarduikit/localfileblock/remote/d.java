package com.larus.bmhome.chat.standarduikit.localfileblock.remote;

import androidx.lifecycle.Observer;
import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d {

    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f309464a;

        public a(c r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f309464a = r100;
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
            return this.f309464a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f309464a.invoke(r100);
        }
    }

    public static final boolean a(g r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        if (Intrinsics.areEqual(r100.f309467a, r101.f309467a) == true) goto L5;
    L9:
        return false;
    L5:
        if (r100.f309468b != r101.f309468b) goto L9;
        if (Intrinsics.areEqual(r100.f309469c, r101.f309469c) == false) goto L9;
        return true;
    }
}
