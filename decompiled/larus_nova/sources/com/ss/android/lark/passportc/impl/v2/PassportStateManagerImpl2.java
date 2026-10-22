package com.ss.android.lark.passportc.impl.v2;

import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.Scene;
import com.ss.android.lark.passportc.api.i;
import com.ss.android.lark.passportc.api.k;
import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.passportc.impl.v2.entity.UpdateUserRequest;
import com.ss.android.lark.passportc.impl.v2.state.AllUserState;
import com.ss.android.lark.passportc.impl.v2.state.UserStateModel;
import com.ss.android.lark.passportc.internal.p;
import com.ss.android.lark.passportc.internal.t;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class PassportStateManagerImpl2 implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f438169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.passportc.api.f f438170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.passportc.impl.v2.state.a f438171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.impl.v2.d f438172d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final UserStateModel f438173e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f438174f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f438175g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f438176h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Executor f438177i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Executor f438178j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function1<? super f0c.b, Unit> f438179k;

    public static final class a {
    }

    public static final class b implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PassportStateManagerImpl2 f438180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.passportc.api.d f438181b;

        public b(PassportStateManagerImpl2 r100, com.ss.android.lark.passportc.api.d r101) {
            this.f438180a = r100;
            this.f438181b = r101;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            final PassportStateManagerImpl2 r100 = this.f438180a;
            if (this.f438181b.f438115d != Scene.CREATE_USER_COMPONENT) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L10;
            r100.getClass();
            LarkAppContext.Companion.getClass();
            if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == false) goto L10;
            Executor r102 = com.ss.android.lark.passportc.impl.v2.b.f438236a;
        L11:
            r102.execute(new PassportStateManagerImpl2$enqueueUpdateUser$1(r100));
            return;
        L10:
            r102 = r100.f438177i;
            goto L11
        L5:
            r101 = false;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PassportStateManagerImpl2 f438182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ UpdateUserRequest f438183b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.passportc.api.d f438184c;

        public c(PassportStateManagerImpl2 r100, UpdateUserRequest r101, com.ss.android.lark.passportc.api.d r102) {
            this.f438182a = r100;
            this.f438183b = r101;
            this.f438184c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.ss.android.lark.passportc.impl.v2.entity.c r101 = (com.ss.android.lark.passportc.impl.v2.entity.c) r100;
            com.ss.android.lark.passportc.impl.v2.d r102 = this.f438182a.f438172d;
            if (r102 == null) goto L6;
            UpdateUserRequest r103 = this.f438183b;
            com.ss.android.lark.passportc.api.d r104 = this.f438184c;
            Intrinsics.checkNotNull(r101);
            r102.h(r103, r104, r101);
            return;
        }
    }

    public static final class d implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PassportStateManagerImpl2 f438185a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ UpdateUserRequest f438186b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.passportc.api.d f438187c;

        public d(PassportStateManagerImpl2 r100, UpdateUserRequest r101, com.ss.android.lark.passportc.api.d r102) {
            this.f438185a = r100;
            this.f438186b = r101;
            this.f438187c = r102;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            com.ss.android.lark.passportc.impl.v2.d r100 = this.f438185a.f438172d;
            if (r100 == null) goto L6;
            r100.c(this.f438186b, this.f438187c);
            return;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PassportStateManagerImpl2 f438188a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ UpdateUserRequest f438189b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.passportc.api.d f438190c;

        public e(PassportStateManagerImpl2 r100, UpdateUserRequest r101, com.ss.android.lark.passportc.api.d r102) {
            this.f438188a = r100;
            this.f438189b = r101;
            this.f438190c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            com.ss.android.lark.passportc.impl.v2.d r102 = this.f438188a.f438172d;
            if (r102 == null) goto L6;
            UpdateUserRequest r103 = this.f438189b;
            com.ss.android.lark.passportc.api.d r104 = this.f438190c;
            Intrinsics.checkNotNull(r101);
            r102.j(r103, r104, r101);
            return;
        }
    }

    public static final class f implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PassportStateManagerImpl2 f438207a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ UpdateUserRequest f438208b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.passportc.api.d f438209c;

        public f(PassportStateManagerImpl2 r100, UpdateUserRequest r101, com.ss.android.lark.passportc.api.d r102) {
            this.f438207a = r100;
            this.f438208b = r101;
            this.f438209c = r102;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            com.ss.android.lark.passportc.impl.v2.d r100 = this.f438207a.f438172d;
            if (r100 == null) goto L6;
            r100.r(this.f438208b, this.f438209c);
            return;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.e
    public final List<f0c.b> a() {
        return (List) this.f438173e.b(PassportStateManagerImpl2$allStates$1.INSTANCE);
    }

    @Override // com.ss.android.lark.passportc.api.e
    public final void d(Function1<? super f0c.b, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f438173e.c(r100);
    }

    public static final j0c.a e(PassportStateManagerImpl2 r100, List r101) {
        r100.getClass();
        j0c.a r102 = com.ss.android.lark.passportc.task.i.f438529a;
        if (r101 == null) goto L8;
        Iterator r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        r102 = r102.a((j0c.a) r103.next());
    L8:
        return r102;
    }

    @Override // com.ss.android.lark.passportc.api.k
    public final Observable<com.ss.android.lark.passportc.impl.v2.entity.c> c(UpdateUserRequest r110, com.ss.android.lark.passportc.api.d r111, lzb.a r112) {
        Intrinsics.checkNotNullParameter(r110, "updateRequest");
        Intrinsics.checkNotNullParameter(r111, "executeMode");
        Intrinsics.checkNotNullParameter(r112, "actionContext");
        if (this.f438169a.c() == false) goto L17;
        com.ss.android.lark.passportc.impl.v2.d r100 = this.f438172d;
        if (r100 == null) goto L7;
        r100.i(r110, r111);
    L7:
        com.ss.android.lark.passportc.impl.v2.c r101 = (com.ss.android.lark.passportc.impl.v2.c) this.f438176h.getValue();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r110, "request");
        Intrinsics.checkNotNullParameter(r111, "executeMode");
        Intrinsics.checkNotNullParameter(r112, "actionContext");
        BehaviorSubject r102 = BehaviorSubject.create();
        LinkedList<com.ss.android.lark.passportc.impl.v2.c.b> r103 = r101.f438238b;
        monitor-enter(r103);
        r101.f438238b.add(new com.ss.android.lark.passportc.impl.v2.c.b(r110, r102, r111, r112, CollectionsKt.emptyList()));     // Catch: Throwable -> L13
        monitor-exit(r103);
        return r102.hide().lift(new com.ss.android.lark.utils.rxjava.c(new Throwable().getStackTrace())).mergeWith(Completable.fromAction(new b(this, r111))).doOnNext(new c(this, r110, r111)).doOnDispose(new d(this, r110, r111)).doOnError(new e(this, r110, r111)).doOnComplete(new f(this, r110, r111));
    L13:
        th = move-exception;
        throw th;
    L17:
        throw new IllegalArgumentException("user online refactor is disable, updateUser V2 not allowed");
    }

    public static final void f(PassportStateManagerImpl2 r100, String r101, UserState r102, UserState r103) {
        r100.getClass();
        if (r102 == r103) goto L6;
        Log.w("UserUpdateVisitor", "state match expect:" + r102 + ", actual:" + r103 + ", userId:" + r101);
        return;
    }

    @Inject
    public PassportStateManagerImpl2(p r100, t r101, i r102, com.ss.android.lark.passportc.api.f r103, com.ss.android.lark.passportc.impl.v2.state.a r104, com.ss.android.lark.passportc.impl.v2.d r105) {
        Intrinsics.checkNotNullParameter(r100, "userDataSource");
        Intrinsics.checkNotNullParameter(r101, "executors");
        Intrinsics.checkNotNullParameter(r102, "multiOnlineFG");
        Intrinsics.checkNotNullParameter(r103, "backgroundUserService");
        Intrinsics.checkNotNullParameter(r104, "stateMachineFactory");
        this.f438169a = r102;
        this.f438170b = r103;
        this.f438171c = r104;
        this.f438172d = r105;
        UserStateModel r106 = new UserStateModel(r100, r101.h());
        this.f438173e = r106;
        this.f438174f = LazyKt.lazy(new PassportStateManagerImpl2$foregroundStateMachine$2(this));
        this.f438175g = LazyKt.lazy(new PassportStateManagerImpl2$backgroundStateMachine$2(this));
        this.f438176h = LazyKt.lazy(new PassportStateManagerImpl2$stateDiffer$2(this));
        this.f438177i = r101.h();
        this.f438178j = r101.f();
        Function2<AllUserState, AllUserState, Unit> r107 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r107, "subscriber");
        Collection r108 = r106.f438286b;
        monitor-enter(r108);
        ((ArrayList) r106.f438286b).add(r107);     // Catch: Throwable -> L8
        monitor-exit(r108);
        Intrinsics.checkNotNullParameter(r106.f438286b, "subscriberList");
        Intrinsics.checkNotNullParameter(r107, "subscriber");
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
