package com.larus.livetutor.impl.tutor.controller;

import androidx.lifecycle.Observer;
import com.larus.livetutor.impl.rtc.adpter.LiveTutorConnectedStatus;
import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class m0 {

    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f356509a;

        public a(k0 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f356509a = r100;
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
            return this.f356509a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f356509a.invoke(r100);
        }
    }

    public static final boolean a(ij9.a r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof LiveTutorConnectedStatus.Speaking) == false) goto L5;
    L10:
        return true;
    L5:
        if ((r100 instanceof LiveTutorConnectedStatus.Waiting) == true) goto L10;
        if ((r100 instanceof LiveTutorConnectedStatus.RoundEnd) == true) goto L10;
        return false;
    }
}
