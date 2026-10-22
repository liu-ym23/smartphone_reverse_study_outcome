package com.larus.bmhome.taskskill;

import androidx.lifecycle.Observer;
import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class x1 {

    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f314666a;

        public a(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f314666a = r100;
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
            return this.f314666a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f314666a.invoke(r100);
        }
    }

    public static final be8.e a(bs8.a r100) {
        String r101 = r100.f20297b;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L17;
        String r104 = r100.f20299d;
        if (r104 != null) goto L13;
    L14:
        r102 = true;
    L15:
        if (r102 == false) goto L17;
        return null;
    L13:
        if (StringsKt.isBlank(r104) == false) goto L15;
    L17:
        String r105 = r100.f20297b;
        String r106 = "";
        if (r105 != null) goto L20;
        r105 = "";
    L20:
        String r107 = r100.f20299d;
        if (r107 == null) goto L25;
        r106 = r107;
    L25:
        return new be8.e(r105, r106);
    L5:
        if (StringsKt.isBlank(r101) == true) goto L8;
        r103 = false;
        goto L9
    }
}
