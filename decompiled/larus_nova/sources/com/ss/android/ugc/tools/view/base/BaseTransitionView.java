package com.ss.android.ugc.tools.view.base;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.ugc.aweme.transition.EmptyTransition;
import com.ss.android.ugc.aweme.transition.InitiativeTransition;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
public final class BaseTransitionView implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InitiativeTransition f454863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public State f454864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Action f454865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PublishSubject f454866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f454867e;

    /* JADX INFO: renamed from: com.ss.android.ugc.tools.view.base.BaseTransitionView$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "Lcom/ss/android/ugc/tools/view/base/d;", AbsMethodDelegate.TAG_INVOKE, "(Landroid/view/View;)Lcom/ss/android/ugc/tools/view/base/d;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    final class AnonymousClass1 extends Lambda implements Function1<View, d> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final d invoke2(View r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            return new d(r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ d invoke(View r100) {
            return invoke2(r100);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/tools/view/base/BaseTransitionView$Action;", "", UserProfileEvent.POSITION_NONE, "SHOW", "HIDE", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
    public static final enum Action extends Enum<Action> {
        public static final Action HIDE = null;
        public static final Action NONE = null;
        public static final Action SHOW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Action[] f454868a = null;

        static {
            Action r100 = new Action(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            Action r101 = new Action("SHOW", 1);
            SHOW = r101;
            Action r102 = new Action("HIDE", 2);
            HIDE = r102;
            f454868a = new Action[]{r100, r101, r102};
        }

        public static Action valueOf(String r100) {
            return (Action) r27.a.a(Action.class, r100);
        }

        public static Action[] values() {
            return (Action[]) f454868a.clone();
        }

        public Action(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/tools/view/base/BaseTransitionView$State;", "", "UNKNOWN", "SHOWING", "SHOWN", "HIDING", "HIDE", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
    public static final enum State extends Enum<State> {
        public static final State HIDE = null;
        public static final State HIDING = null;
        public static final State SHOWING = null;
        public static final State SHOWN = null;
        public static final State UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f454869a = null;

        static {
            State r100 = new State("UNKNOWN", 0);
            UNKNOWN = r100;
            State r101 = new State("SHOWING", 1);
            SHOWING = r101;
            State r102 = new State("SHOWN", 2);
            SHOWN = r102;
            State r103 = new State("HIDING", 3);
            HIDING = r103;
            State r104 = new State("HIDE", 4);
            HIDE = r104;
            f454869a = new State[]{r100, r101, r102, r103, r104};
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public static State[] values() {
            return (State[]) f454869a.clone();
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a<T> implements Predicate<TransitionViewState> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f454870a = null;

        static {
            f454870a = new a();
        }

        public a() {
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(TransitionViewState r100) {
            TransitionViewState r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            if (r101 != TransitionViewState.PRE_SHOW) goto L5;
        L8:
            return true;
        L5:
            if (r101 == TransitionViewState.PRE_HIDE) goto L8;
            return false;
        }
    }

    public static final class b<T, R> implements Function<TransitionViewState, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f454871a = null;

        static {
            f454871a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Function
        public final Boolean apply(TransitionViewState r100) {
            TransitionViewState r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            if (r101 != TransitionViewState.PRE_SHOW) goto L5;
            boolean r102 = true;
        L7:
            return Boolean.valueOf(r102);
        L5:
            r102 = false;
            goto L7
        }
    }

    @Override // com.ss.android.ugc.tools.view.base.c
    public final void a() {
        this.f454864b = State.HIDE;
        this.f454867e.setVisibility(8);
        this.f454866d.onNext(TransitionViewState.PRE_HIDE);
        this.f454866d.onNext(TransitionViewState.HIDDEN);
    }

    @Override // com.ss.android.ugc.tools.view.base.c
    public final Observable<TransitionViewState> b() {
        return this.f454866d.hide();
    }

    @Override // com.ss.android.ugc.tools.view.base.c
    public final void c() {
        this.f454864b = State.UNKNOWN;
        this.f454867e.setVisibility(0);
        this.f454866d.onNext(TransitionViewState.PRE_SHOW);
        this.f454866d.onNext(TransitionViewState.SHOWN);
    }

    public final boolean d() {
        State r100 = this.f454864b;
        if (r100 != State.SHOWING) goto L5;
    L8:
        return true;
    L5:
        if (r100 == State.SHOWN) goto L8;
        return false;
    }

    @Override // com.ss.android.ugc.tools.view.base.c
    public final void hide() {
        if (this.f454863a == null) goto L13;
        State r100 = this.f454864b;
        int r101 = com.ss.android.ugc.tools.view.base.b.f454876b[r100.ordinal()];
        if (r101 != 1) goto L7;
    L12:
        this.f454865c = Action.NONE;
        return;
    L7:
        if (r101 == 2) goto L12;
        if (r101 == 3) goto L11;
        this.f454864b = State.HIDING;
        this.f454863a.g(new EmptyTransition());
        return;
    L11:
        this.f454865c = Action.HIDE;
        return;
    L13:
        a();
    }

    @Override // com.ss.android.ugc.tools.view.base.c
    public final void show() {
        if (this.f454863a == null) goto L13;
        State r100 = this.f454864b;
        int r101 = com.ss.android.ugc.tools.view.base.b.f454875a[r100.ordinal()];
        if (r101 != 1) goto L7;
    L12:
        this.f454865c = Action.NONE;
        return;
    L7:
        if (r101 == 2) goto L12;
        if (r101 == 3) goto L11;
        this.f454864b = State.SHOWING;
        this.f454863a.d(new EmptyTransition());
        return;
    L11:
        this.f454865c = Action.SHOW;
        return;
    L13:
        c();
    }

    public final Observable<Boolean> e() {
        return b().filter(a.f454870a).map(b.f454871a);
    }

    public BaseTransitionView(View r100, View r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r102, "transitionProvider");
        this.f454867e = r100;
        if (r101 == null) goto L5;
        InitiativeTransition r103 = (InitiativeTransition) r102.invoke(r101);
    L6:
        this.f454863a = r103;
        this.f454864b = State.UNKNOWN;
        this.f454865c = Action.NONE;
        this.f454866d = PublishSubject.create();
        if (r103 == null) goto L10;
        r103.a(new com.ss.android.ugc.tools.view.base.a(this, null));
        return;
    L10:
        return;
    L5:
        r103 = null;
        goto L6
    }
}
