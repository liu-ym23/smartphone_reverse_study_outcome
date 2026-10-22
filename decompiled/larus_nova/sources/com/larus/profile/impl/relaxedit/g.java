package com.larus.profile.impl.relaxedit;

import androidx.lifecycle.Observer;
import com.lynx.react.bridge.JavaOnlyMap;
import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class g {

    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f366831a;

        public a(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f366831a = r100;
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
            return this.f366831a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f366831a.invoke(r100);
        }
    }

    public static final JavaOnlyMap a(String r100, boolean r101, String r102, String r103) {
        JavaOnlyMap r104 = new JavaOnlyMap();
        r104.putString("requestId", r100);
        r104.putBoolean("success", r101);
        r104.putString("code", r102);
        r104.putString("message", r103);
        return r104;
    }

    public static final JavaOnlyMap b(String r100, String r101, boolean r102, String r103, String r104) {
        JavaOnlyMap r105 = new JavaOnlyMap();
        r105.putString("requestId", r100);
        r105.putString("userName", r101);
        r105.putBoolean("isUnique", r102);
        r105.putString("code", r103);
        r105.putString("message", r104);
        return r105;
    }

    public static /* synthetic */ JavaOnlyMap c(String r100, String r101, boolean r102, String r103, int r104) {
        String r105 = "";
        if ((r104 & 8) == 0) goto L6;
        r103 = "";
    L6:
        if ((r104 & 16) != 0) goto L10;
        r105 = null;
    L10:
        return b(r100, r101, r102, r103, r105);
    }
}
