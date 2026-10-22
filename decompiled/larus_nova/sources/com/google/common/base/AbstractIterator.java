package com.google.common.base;

import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractIterator<T> implements Iterator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public State f274686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @CheckForNull
    public T f274687b;

    public static final enum State extends Enum<State> {
        public static final State DONE = null;
        public static final State FAILED = null;
        public static final State NOT_READY = null;
        public static final State READY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f274688a = null;

        static {
            State r100 = new State("READY", 0);
            READY = r100;
            State r101 = new State("NOT_READY", 1);
            NOT_READY = r101;
            State r102 = new State("DONE", 2);
            DONE = r102;
            State r103 = new State("FAILED", 3);
            FAILED = r103;
            f274688a = new State[]{r100, r101, r102, r103};
        }

        public static State[] values() {
            return (State[]) f274688a.clone();
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f274689a = null;

        static {
            int[] r100 = new int[State.values().length];
            f274689a = r100;
            r100[State.DONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f274689a[State.READY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    @CheckForNull
    public abstract T a();

    @Override // java.util.Iterator
    public final boolean hasNext() {
        State r100 = this.f274686a;
        State r101 = State.FAILED;
        if (r100 == r101) goto L5;
        boolean r102 = true;
    L6:
        m.o(r102);
        int r103 = a.f274689a[this.f274686a.ordinal()];
        if (r103 != 1) goto L9;
        return false;
    L9:
        if (r103 == 2) goto L14;
        this.f274686a = r101;
        this.f274687b = a();
        if (this.f274686a == State.DONE) goto L16;
        this.f274686a = State.READY;
        return true;
    L16:
        return false;
    L14:
        return true;
    L5:
        r102 = false;
        goto L6
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public AbstractIterator() {
        this.f274686a = State.NOT_READY;
    }

    @Override // java.util.Iterator
    @ParametricNullness
    public final T next() {
        if (hasNext() == false) goto L7;
        this.f274686a = State.NOT_READY;
        T r100 = this.f274687b;
        this.f274687b = null;
        return r100;
    L7:
        throw new NoSuchElementException();
    }
}
