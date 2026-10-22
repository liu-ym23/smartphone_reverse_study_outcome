package com.larus.chat.search.impl.chat;

import androidx.lifecycle.Observer;
import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class s {

    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f325537a;

        public a(n r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f325537a = r100;
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
            return this.f325537a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f325537a.invoke(r100);
        }
    }

    public static String a(String r110) {
        if (r110 != null) goto L4;
        r110 = "";
    L4:
        String r111 = StringsKt.replace$default(StringsKt.replace$default(r110, "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
        if (r111.length() > 32) goto L8;
        return r111;
    L8:
        return StringsKt.take(r111, 32) + "...";
    }
}
