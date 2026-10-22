package com.ss.android.lark.passportc.impl.v2.state;

import com.ss.android.lark.passportc.internal.p;
import f0c.c;
import f0c.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class UserStateModel extends StateModel<AllUserState> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f438287f = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f438288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<Function1<f0c.b, Unit>> f438289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function1<? super f0c.b, Unit> f438290e;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function1<d, Boolean> f438291a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function1<d, d> f438292b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f438291a, r101.f438291a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f438292b, r101.f438292b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f438291a.hashCode() * 31) + this.f438292b.hashCode();
        }

        public final String toString() {
            return "UpdateReducer(find=" + this.f438291a + ", action=" + this.f438292b + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function1<? super d, Boolean> r100, Function1<? super d, d> r101) {
            Intrinsics.checkNotNullParameter(r100, "find");
            Intrinsics.checkNotNullParameter(r101, "action");
            this.f438291a = r100;
            this.f438292b = r101;
        }
    }

    static {
    }

    public final void c(Function1<? super f0c.b, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        f0c.b r101 = (f0c.b) b(UserStateModel$addGlobalStateObserver$1.INSTANCE);
        if ((r101 instanceof f0c.a) == false) goto L5;
        r100.invoke(c.f475025a);
    L6:
        Set<Function1<f0c.b, Unit>> r102 = this.f438289d;
        monitor-enter(r102);
        this.f438289d.add(r100);     // Catch: Throwable -> L11
        monitor-exit(r102);
        return;
    L11:
        th = move-exception;
        throw th;
    L5:
        r100.invoke(r101);
        goto L6
    }

    public final void d(Function1<? super f0c.b, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        Set<Function1<f0c.b, Unit>> r101 = this.f438289d;
        monitor-enter(r101);
        this.f438289d.remove(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [State, java.lang.Object] */
    public final void e(final b... r100) {
        Intrinsics.checkNotNullParameter(r100, "updates");
        Function1<AllUserState, AllUserState> r101 = new UserStateModel$updateMultiItem$1(r100);
        Intrinsics.checkNotNullParameter(r101, "reducer");
        monitor-enter(this);
        State r102 = this.f438285a;     // Catch: Throwable -> L11
        this.f438285a = r101.invoke(r102);     // Catch: Throwable -> L11
        Iterator r103 = ((ArrayList) this.f438286b).iterator();     // Catch: Throwable -> L11
    L6:
        if (r103.hasNext() == false) goto L8;
        ((Function2) r103.next()).invoke(r102, this.f438285a);     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public UserStateModel(p r100, Executor r101) {
        Intrinsics.checkNotNullParameter(r100, "userDataSource");
        Intrinsics.checkNotNullParameter(r101, "globalStateNotifyExecutor");
        super(new AllUserState(CollectionsKt.emptyList(), r100));
        this.f438288c = r101;
        this.f438289d = Collections.synchronizedSet(new LinkedHashSet());
        Function2<AllUserState, AllUserState, Unit> r102 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r102, "subscriber");
        Collection r103 = this.f438286b;
        monitor-enter(r103);
        ((ArrayList) this.f438286b).add(r102);     // Catch: Throwable -> L8
        monitor-exit(r103);
        Intrinsics.checkNotNullParameter(this.f438286b, "subscriberList");
        Intrinsics.checkNotNullParameter(r102, "subscriber");
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
