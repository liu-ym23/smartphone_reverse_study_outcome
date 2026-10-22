package com.ss.android.lark.passportc.impl.v2.state;

import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public class StateModel<State> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public State f438285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Function2<State, State, Unit>> f438286b;

    public final State a() {
        return (State) b(StateModel$getState$1.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StateModel(AllUserState r100) {
        Intrinsics.checkNotNullParameter(r100, "initState");
        this.f438285a = r100;
        this.f438286b = new ArrayList();
    }

    public final <T> T b(Function1<? super State, ? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "mapper");
        monitor-enter(this);
        T r101 = r100.invoke(this.f438285a);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }
}
