package com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine;

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

/* JADX INFO: loaded from: classes37.dex */
public final class StateMachine<STATE, EVENT, SIDE_EFFECT> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f434603c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b<STATE, EVENT, SIDE_EFFECT> f434604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<STATE> f434605b;

    public static final class GraphBuilder<STATE, EVENT, SIDE_EFFECT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public STATE f434606a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LinkedHashMap<Matcher<STATE, STATE>, b.a<STATE, EVENT, SIDE_EFFECT>> f434607b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList<Function1<c<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> f434608c;

        public final class StateDefinitionBuilder<S extends STATE> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final b.a<STATE, EVENT, SIDE_EFFECT> f434609a;

            public StateDefinitionBuilder() {
                this.f434609a = new b.a();
            }

            public final <E extends EVENT> void a(Matcher<EVENT, ? extends E> r100, final Function2<? super S, ? super E, ? extends b.a.C5179a<? extends STATE, ? extends SIDE_EFFECT>> r101) {
                Intrinsics.checkNotNullParameter(r100, "eventMatcher");
                Intrinsics.checkNotNullParameter(r101, "createTransitionTo");
                this.f434609a.f434618c.put((Matcher<EVENT, EVENT>) r100, (Function2<STATE, EVENT, b.a.C5179a<STATE, SIDE_EFFECT>>) new StateMachine$GraphBuilder$StateDefinitionBuilder$on$1(r101));
            }

            public static b.a.C5179a b(Object r100, Object r101, Object r102) {
                Intrinsics.checkNotNullParameter(r100, "<this>");
                Intrinsics.checkNotNullParameter(r101, "state");
                return new b.a.C5179a(r101, r102);
            }
        }

        public GraphBuilder() {
            this(null);
        }

        public GraphBuilder(b<STATE, EVENT, SIDE_EFFECT> r100) {
            if (r100 == null) goto L5;
            STATE r101 = r100.f434613a;
        L6:
            this.f434606a = r101;
            if (r100 == null) goto L10;
            Map<Matcher<STATE, STATE>, b.a<STATE, EVENT, SIDE_EFFECT>> r102 = r100.f434614b;
            if (r102 == null) goto L10;
        L11:
            this.f434607b = new LinkedHashMap(r102);
            if (r100 == null) goto L16;
            List<Function1<c<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> r103 = r100.f434615c;
            if (r103 == null) goto L16;
        L17:
            this.f434608c = new ArrayList(r103);
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

        public final <S extends STATE> void a(Matcher<STATE, ? extends S> r100, Function1<? super GraphBuilder<STATE, EVENT, SIDE_EFFECT>.StateDefinitionBuilder<S>, Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, "stateMatcher");
            Intrinsics.checkNotNullParameter(r101, "init");
            LinkedHashMap<Matcher<STATE, STATE>, b.a<STATE, EVENT, SIDE_EFFECT>> r102 = this.f434607b;
            StateDefinitionBuilder r103 = new StateDefinitionBuilder();
            r101.invoke(r103);
            r102.put(r100, r103.f434609a);
        }
    }

    public static final class Matcher<T, R extends T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f434610c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<R> f434611a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<Function1<T, Boolean>> f434612b;

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
            this.f434611a = r100;
            this.f434612b = CollectionsKt.mutableListOf(new Function1[]{new StateMachine$Matcher$predicates$1(this)});
        }

        public final boolean a(T r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            List<Function1<T, Boolean>> r101 = this.f434612b;
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
    }

    public static final class b<STATE, EVENT, SIDE_EFFECT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final STATE f434613a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<Matcher<STATE, STATE>, a<STATE, EVENT, SIDE_EFFECT>> f434614b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<Function1<c<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> f434615c;

        public static final class a<STATE, EVENT, SIDE_EFFECT> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final List<Function2<STATE, EVENT, Unit>> f434616a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final List<Function2<STATE, EVENT, Unit>> f434617b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final LinkedHashMap<Matcher<EVENT, EVENT>, Function2<STATE, EVENT, C5179a<STATE, SIDE_EFFECT>>> f434618c;

            /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.StateMachine$b$a$a, reason: collision with other inner class name */
            public static final class C5179a<STATE, SIDE_EFFECT> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final STATE f434619a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final SIDE_EFFECT f434620b;

                public final boolean equals(Object r100) {
                    if (this != r100) goto L6;
                    return true;
                L6:
                    if ((r100 instanceof C5179a) == true) goto L8;
                    return false;
                L8:
                    C5179a r101 = (C5179a) r100;
                    if (Intrinsics.areEqual(this.f434619a, r101.f434619a) == true) goto L12;
                    return false;
                L12:
                    if (Intrinsics.areEqual(this.f434620b, r101.f434620b) == true) goto L14;
                    return false;
                L14:
                    return true;
                }

                public final int hashCode() {
                    int r100 = this.f434619a.hashCode() * 31;
                    SIDE_EFFECT r101 = this.f434620b;
                    if (r101 != null) goto L5;
                    int r102 = 0;
                L7:
                    return r100 + r102;
                L5:
                    r102 = r101.hashCode();
                    goto L7
                }

                public final String toString() {
                    return "TransitionTo(toState=" + this.f434619a + ", sideEffect=" + this.f434620b + ')';
                }

                public C5179a(STATE r100, SIDE_EFFECT r101) {
                    Intrinsics.checkNotNullParameter(r100, "toState");
                    this.f434619a = r100;
                    this.f434620b = r101;
                }
            }

            public a() {
                this.f434616a = new ArrayList();
                this.f434617b = new ArrayList();
                this.f434618c = new LinkedHashMap();
            }
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f434613a, r101.f434613a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f434614b, r101.f434614b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f434615c, r101.f434615c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f434613a.hashCode() * 31) + this.f434614b.hashCode()) * 31) + this.f434615c.hashCode();
        }

        public final String toString() {
            return "Graph(initialState=" + this.f434613a + ", stateDefinitions=" + this.f434614b + ", onTransitionListeners=" + this.f434615c + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(STATE r100, Map<Matcher<STATE, STATE>, a<STATE, EVENT, SIDE_EFFECT>> r101, List<? extends Function1<? super c<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> r102) {
            Intrinsics.checkNotNullParameter(r100, "initialState");
            Intrinsics.checkNotNullParameter(r101, "stateDefinitions");
            Intrinsics.checkNotNullParameter(r102, "onTransitionListeners");
            this.f434613a = r100;
            this.f434614b = r101;
            this.f434615c = r102;
        }
    }

    public static abstract class c<STATE, EVENT, SIDE_EFFECT> {

        public static final class a<STATE, EVENT, SIDE_EFFECT> extends c<STATE, EVENT, SIDE_EFFECT> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final STATE f434621a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final EVENT f434622b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof a) == true) goto L8;
                return false;
            L8:
                a r101 = (a) r100;
                if (Intrinsics.areEqual(this.f434621a, r101.f434621a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f434622b, r101.f434622b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.f434621a.hashCode() * 31) + this.f434622b.hashCode();
            }

            public final String toString() {
                return "Invalid(fromState=" + this.f434621a + ", event=" + this.f434622b + ')';
            }

            public a(STATE r100, EVENT r101) {
                Intrinsics.checkNotNullParameter(r100, "fromState");
                Intrinsics.checkNotNullParameter(r101, "event");
                this.f434621a = r100;
                this.f434622b = r101;
            }
        }

        public static final class b<STATE, EVENT, SIDE_EFFECT> extends c<STATE, EVENT, SIDE_EFFECT> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final STATE f434623a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final EVENT f434624b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final STATE f434625c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final SIDE_EFFECT f434626d;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof b) == true) goto L8;
                return false;
            L8:
                b r101 = (b) r100;
                if (Intrinsics.areEqual(this.f434623a, r101.f434623a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f434624b, r101.f434624b) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.f434625c, r101.f434625c) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.f434626d, r101.f434626d) == true) goto L20;
                return false;
            L20:
                return true;
            }

            public final int hashCode() {
                int r100 = ((((this.f434623a.hashCode() * 31) + this.f434624b.hashCode()) * 31) + this.f434625c.hashCode()) * 31;
                SIDE_EFFECT r101 = this.f434626d;
                if (r101 != null) goto L5;
                int r102 = 0;
            L7:
                return r100 + r102;
            L5:
                r102 = r101.hashCode();
                goto L7
            }

            public final String toString() {
                return "Valid(fromState=" + this.f434623a + ", event=" + this.f434624b + ", toState=" + this.f434625c + ", sideEffect=" + this.f434626d + ')';
            }

            public b(STATE r100, EVENT r101, STATE r102, SIDE_EFFECT r103) {
                Intrinsics.checkNotNullParameter(r100, "fromState");
                Intrinsics.checkNotNullParameter(r101, "event");
                Intrinsics.checkNotNullParameter(r102, "toState");
                this.f434623a = r100;
                this.f434624b = r101;
                this.f434625c = r102;
                this.f434626d = r103;
            }
        }

        public c() {
        }
    }

    static {
    }

    public StateMachine(b r100) {
        this.f434604a = r100;
        this.f434605b = new AtomicReference(r100.f434613a);
    }

    public final b.a<STATE, EVENT, SIDE_EFFECT> a(STATE r100) {
        Map<Matcher<STATE, STATE>, b.a<STATE, EVENT, SIDE_EFFECT>> r101 = this.f434604a.f434614b;
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

    public final c<STATE, EVENT, SIDE_EFFECT> b(STATE r100, EVENT r101) {
        Iterator<Map.Entry<Matcher<EVENT, EVENT>, Function2<STATE, EVENT, b.a.C5179a<STATE, SIDE_EFFECT>>>> r102 = a(r100).f434618c.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        Map.Entry<Matcher<EVENT, EVENT>, Function2<STATE, EVENT, b.a.C5179a<STATE, SIDE_EFFECT>>> r103 = r102.next();
        Matcher<EVENT, EVENT> r104 = r103.getKey();
        Function2<STATE, EVENT, b.a.C5179a<STATE, SIDE_EFFECT>> r105 = r103.getValue();
        if (r104.a(r101) == false) goto L4;
        b.a.C5179a<STATE, SIDE_EFFECT> r106 = r105.invoke(r100, r101);
        return new c.b(r100, r101, r106.f434619a, r106.f434620b);
    L10:
        return new c.a(r100, r101);
    }
}
