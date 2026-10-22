package com.bytedance.live.kmp.statemachine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes19.dex */
public final class StateMachine<STATE, EVENT, SIDE_EFFECT> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f255141c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<STATE> f255142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b<STATE, EVENT, SIDE_EFFECT> f255143b;

    public static final class GraphBuilder<STATE, EVENT, SIDE_EFFECT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public STATE f255144a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LinkedHashMap<Matcher<STATE, STATE>, b.a<STATE, EVENT, SIDE_EFFECT>> f255145b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList<Function1<c<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> f255146c;

        public final class StateDefinitionBuilder<S extends STATE> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final b.a<STATE, EVENT, SIDE_EFFECT> f255147a;

            public StateDefinitionBuilder() {
                this.f255147a = new b.a();
            }

            public final <E extends EVENT> void a(Matcher<EVENT, ? extends E> r100, final Function2<? super S, ? super E, ? extends b.a.C3628a<? extends STATE, ? extends SIDE_EFFECT>> r101) {
                Intrinsics.checkNotNullParameter(r100, "eventMatcher");
                Intrinsics.checkNotNullParameter(r101, "createTransitionTo");
                this.f255147a.f255156c.put((Matcher<EVENT, EVENT>) r100, (Function2<STATE, EVENT, b.a.C3628a<STATE, SIDE_EFFECT>>) new StateMachine$GraphBuilder$StateDefinitionBuilder$on$1(r101));
            }

            public static b.a.C3628a b(Object r100, Object r101, Object r102) {
                Intrinsics.checkNotNullParameter(r100, "$this$transitionTo");
                Intrinsics.checkNotNullParameter(r101, "state");
                return new b.a.C3628a(r101, r102);
            }
        }

        public GraphBuilder() {
            this(null);
        }

        public GraphBuilder(b<STATE, EVENT, SIDE_EFFECT> r100) {
            if (r100 == null) goto L5;
            STATE r101 = r100.f255151a;
        L6:
            this.f255144a = r101;
            if (r100 == null) goto L10;
            Map<Matcher<STATE, STATE>, b.a<STATE, EVENT, SIDE_EFFECT>> r102 = r100.f255152b;
            if (r102 == null) goto L10;
        L11:
            this.f255145b = new LinkedHashMap(r102);
            if (r100 == null) goto L16;
            List<Function1<c<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> r103 = r100.f255153c;
            if (r103 == null) goto L16;
        L17:
            this.f255146c = new ArrayList(r103);
            return;
        L16:
            r103 = CollectionsKt.emptyList();
        L10:
            r102 = MapsKt.emptyMap();
            goto L11
        L5:
            r101 = null;
            goto L6
        }

        public final void a(Function1<? super c<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            this.f255146c.add(r100);
        }

        public final <S extends STATE> void b(Matcher<STATE, ? extends S> r100, Function1<? super GraphBuilder<STATE, EVENT, SIDE_EFFECT>.StateDefinitionBuilder<S>, Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, "stateMatcher");
            Intrinsics.checkNotNullParameter(r101, "init");
            LinkedHashMap<Matcher<STATE, STATE>, b.a<STATE, EVENT, SIDE_EFFECT>> r102 = this.f255145b;
            StateDefinitionBuilder r103 = new StateDefinitionBuilder();
            r101.invoke(r103);
            r102.put(r100, r103.f255147a);
        }
    }

    public static final class Matcher<T, R extends T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f255148c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Function1<T, Boolean>> f255149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final KClass<R> f255150b;

        public static final class a {
            public static Matcher a(KClass r100) {
                Intrinsics.checkNotNullParameter(r100, "clazz");
                return new Matcher(r100);
            }
        }

        static {
        }

        public Matcher() {
            throw null;
        }

        public Matcher(KClass r100) {
            this.f255150b = r100;
            this.f255149a = CollectionsKt.mutableListOf(new Function1[]{new StateMachine$Matcher$predicates$1(this)});
        }

        public final boolean a(T r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            List<Function1<T, Boolean>> r101 = this.f255149a;
            if ((r101 instanceof Collection) == true) goto L5;
        L7:
            Iterator<T> r102 = r101.iterator();
        L9:
            if (r102.hasNext() == false) goto L18;
            if (((Boolean) ((Function1) r102.next()).invoke(r100)).booleanValue() == true) goto L9;
            return false;
        L18:
            return true;
        L5:
            if (r101.isEmpty() == false) goto L7;
            return true;
        }

        public final void b(final Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "predicate");
            this.f255149a.add((Function1<T, Boolean>) new StateMachine$Matcher$where$$inlined$apply$lambda$1(r100));
        }
    }

    public static final class a {
        public a() {
        }

        public static StateMachine a(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "init");
            GraphBuilder r101 = new GraphBuilder(null);
            r100.invoke(r101);
            STATE r102 = r101.f255144a;
            if (r102 == null) goto L7;
            return new StateMachine(new b(r102, MapsKt.toMap(r101.f255145b), CollectionsKt.toList(r101.f255146c)));
        L7:
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    public static final class b<STATE, EVENT, SIDE_EFFECT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final STATE f255151a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<Matcher<STATE, STATE>, a<STATE, EVENT, SIDE_EFFECT>> f255152b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<Function1<c<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> f255153c;

        public static final class a<STATE, EVENT, SIDE_EFFECT> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final List<Function2<STATE, EVENT, Unit>> f255154a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final List<Function2<STATE, EVENT, Unit>> f255155b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final LinkedHashMap<Matcher<EVENT, EVENT>, Function2<STATE, EVENT, C3628a<STATE, SIDE_EFFECT>>> f255156c;

            /* JADX INFO: renamed from: com.bytedance.live.kmp.statemachine.StateMachine$b$a$a, reason: collision with other inner class name */
            public static final class C3628a<STATE, SIDE_EFFECT> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final STATE f255157a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final SIDE_EFFECT f255158b;

                public final boolean equals(Object r100) {
                    if (this != r100) goto L4;
                    return true;
                L4:
                    if ((r100 instanceof C3628a) == false) goto L10;
                    C3628a r101 = (C3628a) r100;
                    if (Intrinsics.areEqual(this.f255157a, r101.f255157a) == true) goto L8;
                    return false;
                L8:
                    if (Intrinsics.areEqual(this.f255158b, r101.f255158b) == true) goto L16;
                    return false;
                L16:
                    return true;
                L10:
                    return false;
                }

                public final int hashCode() {
                    STATE r100 = this.f255157a;
                    int r101 = 0;
                    if (r100 == null) goto L5;
                    int r102 = r100.hashCode();
                L6:
                    int r103 = r102 * 31;
                    SIDE_EFFECT r104 = this.f255158b;
                    if (r104 == null) goto L10;
                    r101 = r104.hashCode();
                L10:
                    return r103 + r101;
                L5:
                    r102 = 0;
                    goto L6
                }

                public final String toString() {
                    return "TransitionTo(toState=" + this.f255157a + ", sideEffect=" + this.f255158b + ")";
                }

                public C3628a(STATE r100, SIDE_EFFECT r101) {
                    Intrinsics.checkNotNullParameter(r100, "toState");
                    this.f255157a = r100;
                    this.f255158b = r101;
                }
            }

            public a() {
                this.f255154a = new ArrayList();
                this.f255155b = new ArrayList();
                this.f255156c = new LinkedHashMap();
            }
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L12;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f255151a, r101.f255151a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f255152b, r101.f255152b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f255153c, r101.f255153c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            STATE r100 = this.f255151a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Map<Matcher<STATE, STATE>, a<STATE, EVENT, SIDE_EFFECT>> r104 = this.f255152b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            List<Function1<c<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> r107 = this.f255153c;
            if (r107 == null) goto L14;
            r101 = r107.hashCode();
        L14:
            return r106 + r101;
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Graph(initialState=" + this.f255151a + ", stateDefinitions=" + this.f255152b + ", onTransitionListeners=" + this.f255153c + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(STATE r100, Map<Matcher<STATE, STATE>, a<STATE, EVENT, SIDE_EFFECT>> r101, List<? extends Function1<? super c<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> r102) {
            Intrinsics.checkNotNullParameter(r100, "initialState");
            Intrinsics.checkNotNullParameter(r101, "stateDefinitions");
            Intrinsics.checkNotNullParameter(r102, "onTransitionListeners");
            this.f255151a = r100;
            this.f255152b = r101;
            this.f255153c = r102;
        }
    }

    public static abstract class c<STATE, EVENT, SIDE_EFFECT> {

        public static final class a<STATE, EVENT, SIDE_EFFECT> extends c<STATE, EVENT, SIDE_EFFECT> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final STATE f255159a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final EVENT f255160b;

            public final int hashCode() {
                STATE r100 = this.f255159a;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                EVENT r104 = this.f255160b;
                if (r104 == null) goto L10;
                r101 = r104.hashCode();
            L10:
                return r103 + r101;
            L5:
                r102 = 0;
                goto L6
            }

            public final String toString() {
                return "Invalid(fromState=" + this.f255159a + ", event=" + this.f255160b + ")";
            }

            @Override // com.bytedance.live.kmp.statemachine.StateMachine.c
            public final EVENT a() {
                return this.f255160b;
            }

            @Override // com.bytedance.live.kmp.statemachine.StateMachine.c
            public final STATE b() {
                return this.f255159a;
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof a) == false) goto L10;
                a r101 = (a) r100;
                if (Intrinsics.areEqual(this.f255159a, r101.f255159a) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.f255160b, r101.f255160b) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public a(STATE r100, EVENT r101) {
                Intrinsics.checkNotNullParameter(r100, "fromState");
                Intrinsics.checkNotNullParameter(r101, "event");
                this.f255159a = r100;
                this.f255160b = r101;
            }
        }

        public static final class b<STATE, EVENT, SIDE_EFFECT> extends c<STATE, EVENT, SIDE_EFFECT> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final STATE f255161a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final EVENT f255162b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final STATE f255163c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final SIDE_EFFECT f255164d;

            public final int hashCode() {
                STATE r100 = this.f255161a;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                EVENT r104 = this.f255162b;
                if (r104 == null) goto L9;
                int r105 = r104.hashCode();
            L10:
                int r106 = (r103 + r105) * 31;
                STATE r107 = this.f255163c;
                if (r107 == null) goto L13;
                int r108 = r107.hashCode();
            L14:
                int r109 = (r106 + r108) * 31;
                SIDE_EFFECT r110 = this.f255164d;
                if (r110 == null) goto L18;
                r101 = r110.hashCode();
            L18:
                return r109 + r101;
            L13:
                r108 = 0;
                goto L14
            L9:
                r105 = 0;
                goto L10
            L5:
                r102 = 0;
                goto L6
            }

            public final String toString() {
                return "Valid(fromState=" + this.f255161a + ", event=" + this.f255162b + ", toState=" + this.f255163c + ", sideEffect=" + this.f255164d + ")";
            }

            @Override // com.bytedance.live.kmp.statemachine.StateMachine.c
            public final EVENT a() {
                return this.f255162b;
            }

            @Override // com.bytedance.live.kmp.statemachine.StateMachine.c
            public final STATE b() {
                return this.f255161a;
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof b) == false) goto L14;
                b r101 = (b) r100;
                if (Intrinsics.areEqual(this.f255161a, r101.f255161a) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.f255162b, r101.f255162b) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.f255163c, r101.f255163c) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f255164d, r101.f255164d) == true) goto L22;
                return false;
            L22:
                return true;
            L14:
                return false;
            }

            public b(STATE r100, EVENT r101, STATE r102, SIDE_EFFECT r103) {
                Intrinsics.checkNotNullParameter(r100, "fromState");
                Intrinsics.checkNotNullParameter(r101, "event");
                Intrinsics.checkNotNullParameter(r102, "toState");
                this.f255161a = r100;
                this.f255162b = r101;
                this.f255163c = r102;
                this.f255164d = r103;
            }
        }

        public c() {
        }

        public abstract EVENT a();

        public abstract STATE b();
    }

    static {
        f255141c = new a();
    }

    public StateMachine(b r100) {
        this.f255143b = r100;
        this.f255142a = new AtomicReference(r100.f255151a);
    }

    public final b.a<STATE, EVENT, SIDE_EFFECT> a(STATE r100) {
        Map<Matcher<STATE, STATE>, b.a<STATE, EVENT, SIDE_EFFECT>> r101 = this.f255143b.f255152b;
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator<Map.Entry<Matcher<STATE, STATE>, b.a<STATE, EVENT, SIDE_EFFECT>>> r103 = r101.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Map.Entry<Matcher<STATE, STATE>, b.a<STATE, EVENT, SIDE_EFFECT>> r104 = r103.next();
        if (r104.getKey().a(r100) == false) goto L4;
        r102.put(r104.getKey(), r104.getValue());
        goto L4
    L8:
        ArrayList r105 = new ArrayList(r102.size());
        Iterator r106 = r102.entrySet().iterator();
    L10:
        if (r106.hasNext() == false) goto L12;
        r105.add((b.a) ((Map.Entry) r106.next()).getValue());
        goto L10
    L12:
        b.a<STATE, EVENT, SIDE_EFFECT> r107 = (b.a) CollectionsKt.firstOrNull(r105);
        if (r107 == null) goto L16;
        return r107;
    L16:
        throw new IllegalStateException(("Missing definition for state " + Reflection.getOrCreateKotlinClass(r100.getClass()).getSimpleName() + '!').toString());
    }

    public static c c(StateMachine r100, Object r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "event");
        monitor-enter(r100);
        c<STATE, EVENT, SIDE_EFFECT> r102 = r100.b(r100.f255142a.get(), r101);     // Catch: Throwable -> L29
        if ((r102 instanceof c.b) == false) goto L7;
        r100.f255142a.set(((c.b) r102).f255163c);     // Catch: Throwable -> L29
    L7:
        monitor-exit(r100);
        Iterator<T> r103 = r100.f255143b.f255153c.iterator();     // Catch: Throwable -> L13
    L10:
        if (r103.hasNext() == false) goto L15;
        ((Function1) r103.next()).invoke(r102);     // Catch: Throwable -> L13
    L15:
        if ((r102 instanceof c.b) == false) goto L28;
        c.b r104 = (c.b) r102;
        STATE r105 = r104.f255161a;
        Iterator r106 = ((ArrayList) r100.a(r105).f255155b).iterator();     // Catch: Throwable -> L32
    L19:
        if (r106.hasNext() == false) goto L22;
        ((Function2) r106.next()).invoke(r105, r101);     // Catch: Throwable -> L32
    L22:
        STATE r107 = r104.f255163c;
        Iterator r108 = ((ArrayList) r100.a(r107).f255154a).iterator();     // Catch: Throwable -> L33
    L25:
        if (r108.hasNext() == false) goto L28;
        ((Function2) r108.next()).invoke(r107, r101);     // Catch: Throwable -> L33
    L28:
        return r102;
    L29:
        th = move-exception;
        throw th;
    }

    public final c<STATE, EVENT, SIDE_EFFECT> b(STATE r100, EVENT r101) {
        Iterator<Map.Entry<Matcher<EVENT, EVENT>, Function2<STATE, EVENT, b.a.C3628a<STATE, SIDE_EFFECT>>>> r102 = a(r100).f255156c.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        Map.Entry<Matcher<EVENT, EVENT>, Function2<STATE, EVENT, b.a.C3628a<STATE, SIDE_EFFECT>>> r103 = r102.next();
        Matcher<EVENT, EVENT> r104 = r103.getKey();
        Function2<STATE, EVENT, b.a.C3628a<STATE, SIDE_EFFECT>> r105 = r103.getValue();
        if (r104.a(r101) == false) goto L4;
        b.a.C3628a<STATE, SIDE_EFFECT> r106 = r105.invoke(r100, r101);
        return new c.b(r100, r101, r106.f255157a, r106.f255158b);
    L10:
        return new c.a(r100, r101);
    }
}
