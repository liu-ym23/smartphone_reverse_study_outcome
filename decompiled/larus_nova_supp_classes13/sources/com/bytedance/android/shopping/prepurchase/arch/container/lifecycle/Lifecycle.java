package com.bytedance.android.shopping.prepurchase.arch.container.lifecycle;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class Lifecycle {
    public final AtomicReference<CoroutineScope> a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/arch/container/lifecycle/Lifecycle$Event;", "", "ON_CREATE", "ON_START", "ON_RESUME", "ON_PAUSE", "ON_STOP", "ON_DESTROY", "ON_ANY", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Event extends Enum<Event> {
        public static final Event ON_ANY = null;
        public static final Event ON_CREATE = null;
        public static final Event ON_DESTROY = null;
        public static final Event ON_PAUSE = null;
        public static final Event ON_RESUME = null;
        public static final Event ON_START = null;
        public static final Event ON_STOP = null;
        public static final /* synthetic */ Event[] a = null;

        static {
            Event r1 = new Event("ON_CREATE", 0);
            ON_CREATE = r1;
            Event r2 = new Event("ON_START", 1);
            ON_START = r2;
            Event r3 = new Event("ON_RESUME", 2);
            ON_RESUME = r3;
            Event r4 = new Event("ON_PAUSE", 3);
            ON_PAUSE = r4;
            Event r5 = new Event("ON_STOP", 4);
            ON_STOP = r5;
            Event r6 = new Event("ON_DESTROY", 5);
            ON_DESTROY = r6;
            Event r7 = new Event("ON_ANY", 6);
            ON_ANY = r7;
            a = new Event[]{r1, r2, r3, r4, r5, r6, r7};
        }

        public static Event valueOf(String r1) {
            return (Event) r27.a.a(Event.class, r1);
        }

        public static Event[] values() {
            return (Event[]) a.clone();
        }

        public Event(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/arch/container/lifecycle/Lifecycle$State;", "", "state", "", "isAtLeast", "DESTROYED", "INITIALIZED", "CREATED", "STARTED", "RESUMED", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum State extends Enum<State> {
        public static final State CREATED = null;
        public static final State DESTROYED = null;
        public static final State INITIALIZED = null;
        public static final State RESUMED = null;
        public static final State STARTED = null;
        public static final /* synthetic */ State[] a = null;

        static {
            State r1 = new State("DESTROYED", 0);
            DESTROYED = r1;
            State r2 = new State("INITIALIZED", 1);
            INITIALIZED = r2;
            State r3 = new State("CREATED", 2);
            CREATED = r3;
            State r4 = new State("STARTED", 3);
            STARTED = r4;
            State r5 = new State("RESUMED", 4);
            RESUMED = r5;
            a = new State[]{r1, r2, r3, r4, r5};
        }

        public static State valueOf(String r1) {
            return (State) r27.a.a(State.class, r1);
        }

        public static State[] values() {
            return (State[]) a.clone();
        }

        public final boolean isAtLeast(State r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
            if (compareTo(r2) < 0) goto L5;
            return true;
        L5:
            return false;
        }

        public State(String r1, int r2) {
            super(r1, r2);
        }
    }

    public abstract void a(d r1);

    public abstract State b();

    public abstract void c(d r1);

    public Lifecycle() {
        this.a = new AtomicReference();
    }
}
