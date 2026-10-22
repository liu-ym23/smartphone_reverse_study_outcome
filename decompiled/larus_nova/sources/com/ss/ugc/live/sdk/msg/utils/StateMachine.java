package com.ss.ugc.live.sdk.msg.utils;

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

/* JADX INFO: loaded from: classes36.dex */
public final class StateMachine<STATE, EVENT, SIDE_EFFECT> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f458449c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<STATE> f458450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b<STATE, EVENT, SIDE_EFFECT> f458451b;

    public static final class GraphBuilder<STATE, EVENT, SIDE_EFFECT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public STATE f458452a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LinkedHashMap<Matcher<STATE, STATE>, b.a<STATE, EVENT, SIDE_EFFECT>> f458453b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList<Function1<c<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> f458454c;

        public final class StateDefinitionBuilder<S extends STATE> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final b.a<STATE, EVENT, SIDE_EFFECT> f458455a;

            public StateDefinitionBuilder() {
                this.f458455a = new b.a();
            }

            public final <E extends EVENT> void a(Matcher<EVENT, ? extends E> r100, final Function2<? super S, ? super E, ? extends b.a.C5504a<? extends STATE, ? extends SIDE_EFFECT>> r101) {
                Intrinsics.checkNotNullParameter(r100, "eventMatcher");
                Intrinsics.checkNotNullParameter(r101, "createTransitionTo");
                this.f458455a.f458464c.put((Matcher<EVENT, EVENT>) r100, (Function2<STATE, EVENT, b.a.C5504a<STATE, SIDE_EFFECT>>) new StateMachine$GraphBuilder$StateDefinitionBuilder$on$1(r101));
            }

            public static b.a.C5504a b(Object r100, Object r101, Object r102) {
                Intrinsics.checkNotNullParameter(r100, "$this$transitionTo");
                Intrinsics.checkNotNullParameter(r101, "state");
                return new b.a.C5504a(r101, r102);
            }
        }

        public GraphBuilder() {
            this(null);
        }

        public GraphBuilder(b<STATE, EVENT, SIDE_EFFECT> r100) {
            if (r100 == null) goto L5;
            STATE r101 = r100.f458459a;
        L6:
            this.f458452a = r101;
            if (r100 == null) goto L11;
            Map<Matcher<STATE, STATE>, b.a<STATE, EVENT, SIDE_EFFECT>> r102 = r100.f458460b;
            if (r102 == null) goto L11;
        L12:
            this.f458453b = new LinkedHashMap(r102);
            if (r100 == null) goto L17;
            List<Function1<c<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> r103 = r100.f458461c;
            if (r103 == null) goto L17;
        L18:
            this.f458454c = new ArrayList(r103);
            return;
        L17:
            r103 = CollectionsKt.emptyList();
        L11:
            r102 = MapsKt.emptyMap();
            goto L12
        L5:
            r101 = null;
            goto L6
        }

        public final void a(STATE r100) {
            Intrinsics.checkNotNullParameter(r100, "initialState");
            this.f458452a = r100;
        }

        public final void b(Function1<? super c<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            this.f458454c.add(r100);
        }

        public final <S extends STATE> void c(Matcher<STATE, ? extends S> r100, Function1<? super GraphBuilder<STATE, EVENT, SIDE_EFFECT>.StateDefinitionBuilder<S>, Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, "stateMatcher");
            Intrinsics.checkNotNullParameter(r101, "init");
            LinkedHashMap<Matcher<STATE, STATE>, b.a<STATE, EVENT, SIDE_EFFECT>> r102 = this.f458453b;
            StateDefinitionBuilder r103 = new StateDefinitionBuilder();
            r101.invoke(r103);
            r102.put(r100, r103.f458455a);
        }
    }

    public static final class Matcher<T, R extends T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f458456c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Function1<T, Boolean>> f458457a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class<R> f458458b;

        public static final class a {
            public static Matcher a(Class r100) {
                Intrinsics.checkNotNullParameter(r100, "clazz");
                return new Matcher(r100);
            }
        }

        static {
        }

        public Matcher() {
            throw null;
        }

        public Matcher(Class r100) {
            this.f458458b = r100;
            this.f458457a = CollectionsKt.mutableListOf(new Function1[]{new StateMachine$Matcher$predicates$1(this)});
        }

        public final boolean a(T r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            List<Function1<T, Boolean>> r101 = this.f458457a;
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
    }

    public static final class a {
        public a() {
        }

        public static StateMachine a(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "init");
            GraphBuilder r101 = new GraphBuilder(null);
            r100.invoke(r101);
            STATE r102 = r101.f458452a;
            if (r102 == null) goto L7;
            return new StateMachine(new b(r102, MapsKt.toMap(r101.f458453b), CollectionsKt.toList(r101.f458454c)));
        L7:
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    public static final class b<STATE, EVENT, SIDE_EFFECT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final STATE f458459a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<Matcher<STATE, STATE>, a<STATE, EVENT, SIDE_EFFECT>> f458460b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<Function1<c<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> f458461c;

        public static final class a<STATE, EVENT, SIDE_EFFECT> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final List<Function2<STATE, EVENT, Unit>> f458462a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final List<Function2<STATE, EVENT, Unit>> f458463b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final LinkedHashMap<Matcher<EVENT, EVENT>, Function2<STATE, EVENT, C5504a<STATE, SIDE_EFFECT>>> f458464c;

            /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.utils.StateMachine$b$a$a, reason: collision with other inner class name */
            public static final class C5504a<STATE, SIDE_EFFECT> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final STATE f458465a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final SIDE_EFFECT f458466b;

                public final boolean equals(Object r100) {
                    if (this != r100) goto L4;
                    return true;
                L4:
                    if ((r100 instanceof C5504a) == false) goto L10;
                    C5504a r101 = (C5504a) r100;
                    if (Intrinsics.areEqual(this.f458465a, r101.f458465a) == true) goto L8;
                    return false;
                L8:
                    if (Intrinsics.areEqual(this.f458466b, r101.f458466b) == true) goto L16;
                    return false;
                L16:
                    return true;
                L10:
                    return false;
                }

                public final int hashCode() {
                    STATE r100 = this.f458465a;
                    int r101 = 0;
                    if (r100 == null) goto L5;
                    int r102 = r100.hashCode();
                L6:
                    int r103 = r102 * 31;
                    SIDE_EFFECT r104 = this.f458466b;
                    if (r104 == null) goto L10;
                    r101 = r104.hashCode();
                L10:
                    return r103 + r101;
                L5:
                    r102 = 0;
                    goto L6
                }

                public final String toString() {
                    return "TransitionTo(toState=" + this.f458465a + ", sideEffect=" + this.f458466b + ")";
                }

                public C5504a(STATE r100, SIDE_EFFECT r101) {
                    Intrinsics.checkNotNullParameter(r100, "toState");
                    this.f458465a = r100;
                    this.f458466b = r101;
                }
            }

            public a() {
                this.f458462a = new ArrayList();
                this.f458463b = new ArrayList();
                this.f458464c = new LinkedHashMap();
            }
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L12;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f458459a, r101.f458459a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f458460b, r101.f458460b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f458461c, r101.f458461c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            STATE r100 = this.f458459a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Map<Matcher<STATE, STATE>, a<STATE, EVENT, SIDE_EFFECT>> r104 = this.f458460b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            List<Function1<c<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> r107 = this.f458461c;
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
            return "Graph(initialState=" + this.f458459a + ", stateDefinitions=" + this.f458460b + ", onTransitionListeners=" + this.f458461c + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(STATE r100, Map<Matcher<STATE, STATE>, a<STATE, EVENT, SIDE_EFFECT>> r101, List<? extends Function1<? super c<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> r102) {
            Intrinsics.checkNotNullParameter(r100, "initialState");
            Intrinsics.checkNotNullParameter(r101, "stateDefinitions");
            Intrinsics.checkNotNullParameter(r102, "onTransitionListeners");
            this.f458459a = r100;
            this.f458460b = r101;
            this.f458461c = r102;
        }
    }

    public static abstract class c<STATE, EVENT, SIDE_EFFECT> {

        public static final class a<STATE, EVENT, SIDE_EFFECT> extends c<STATE, EVENT, SIDE_EFFECT> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final STATE f458467a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final EVENT f458468b;

            public final int hashCode() {
                STATE r100 = this.f458467a;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                EVENT r104 = this.f458468b;
                if (r104 == null) goto L10;
                r101 = r104.hashCode();
            L10:
                return r103 + r101;
            L5:
                r102 = 0;
                goto L6
            }

            public final String toString() {
                return "Invalid(fromState=" + this.f458467a + ", event=" + this.f458468b + ")";
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof a) == false) goto L10;
                a r101 = (a) r100;
                if (Intrinsics.areEqual(this.f458467a, r101.f458467a) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.f458468b, r101.f458468b) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public a(STATE r100, EVENT r101) {
                Intrinsics.checkNotNullParameter(r100, "fromState");
                Intrinsics.checkNotNullParameter(r101, "event");
                this.f458467a = r100;
                this.f458468b = r101;
            }
        }

        public static final class b<STATE, EVENT, SIDE_EFFECT> extends c<STATE, EVENT, SIDE_EFFECT> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final STATE f458469a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final EVENT f458470b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final STATE f458471c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final SIDE_EFFECT f458472d;

            public final int hashCode() {
                STATE r100 = this.f458469a;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                EVENT r104 = this.f458470b;
                if (r104 == null) goto L9;
                int r105 = r104.hashCode();
            L10:
                int r106 = (r103 + r105) * 31;
                STATE r107 = this.f458471c;
                if (r107 == null) goto L13;
                int r108 = r107.hashCode();
            L14:
                int r109 = (r106 + r108) * 31;
                SIDE_EFFECT r110 = this.f458472d;
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
                return "Valid(fromState=" + this.f458469a + ", event=" + this.f458470b + ", toState=" + this.f458471c + ", sideEffect=" + this.f458472d + ")";
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof b) == false) goto L14;
                b r101 = (b) r100;
                if (Intrinsics.areEqual(this.f458469a, r101.f458469a) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.f458470b, r101.f458470b) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.f458471c, r101.f458471c) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f458472d, r101.f458472d) == true) goto L22;
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
                this.f458469a = r100;
                this.f458470b = r101;
                this.f458471c = r102;
                this.f458472d = r103;
            }
        }

        public c() {
        }
    }

    static {
        f458449c = new a();
    }

    public final STATE b() {
        return this.f458450a.get();
    }

    public StateMachine(b r100) {
        this.f458451b = r100;
        this.f458450a = new AtomicReference(r100.f458459a);
    }

    public final b.a<STATE, EVENT, SIDE_EFFECT> a(STATE r100) {
        Map<Matcher<STATE, STATE>, b.a<STATE, EVENT, SIDE_EFFECT>> r101 = this.f458451b.f458460b;
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
        throw new IllegalStateException(("Missing definition for state " + r100.getClass().getSimpleName() + '!').toString());
    }

    public final void d(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        monitor-enter(this);
        c<STATE, EVENT, SIDE_EFFECT> r101 = c(this.f458450a.get(), r100);     // Catch: Throwable -> L23
        if ((r101 instanceof c.b) == false) goto L7;
        this.f458450a.set(((c.b) r101).f458471c);     // Catch: Throwable -> L23
    L7:
        monitor-exit(this);
        Iterator<T> r102 = this.f458451b.f458461c.iterator();
    L10:
        if (r102.hasNext() == false) goto L13;
        ((Function1) r102.next()).invoke(r101);
        goto L10
    L13:
        if ((r101 instanceof c.b) == false) goto L22;
        c.b r103 = (c.b) r101;
        STATE r104 = r103.f458469a;
        Iterator r105 = ((ArrayList) a(r104).f458463b).iterator();
    L16:
        if (r105.hasNext() == false) goto L18;
        ((Function2) r105.next()).invoke(r104, r100);
        goto L16
    L18:
        STATE r106 = r103.f458471c;
        Iterator r107 = ((ArrayList) a(r106).f458462a).iterator();
    L20:
        if (r107.hasNext() == false) goto L31;
        ((Function2) r107.next()).invoke(r106, r100);
        goto L20
    L31:
        return;
    L22:
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public final c<STATE, EVENT, SIDE_EFFECT> c(STATE r100, EVENT r101) {
        Iterator<Map.Entry<Matcher<EVENT, EVENT>, Function2<STATE, EVENT, b.a.C5504a<STATE, SIDE_EFFECT>>>> r102 = a(r100).f458464c.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        Map.Entry<Matcher<EVENT, EVENT>, Function2<STATE, EVENT, b.a.C5504a<STATE, SIDE_EFFECT>>> r103 = r102.next();
        Matcher<EVENT, EVENT> r104 = r103.getKey();
        Function2<STATE, EVENT, b.a.C5504a<STATE, SIDE_EFFECT>> r105 = r103.getValue();
        if (r104.a(r101) == false) goto L4;
        b.a.C5504a<STATE, SIDE_EFFECT> r106 = r105.invoke(r100, r101);
        return new c.b(r100, r101, r106.f458465a, r106.f458466b);
    L10:
        return new c.a(r100, r101);
    }
}
