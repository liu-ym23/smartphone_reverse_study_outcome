package com.larus.browsertakeover.cdp;

import iv8.c1;
import java.util.ArrayDeque;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f319464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f319465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f319466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayDeque<AbstractC4136b<T>> f319467d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f319468e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f319469f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f319470g;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.browsertakeover.cdp.b$b, reason: collision with other inner class name */
    public static abstract class AbstractC4136b<T> {

        /* JADX INFO: renamed from: com.larus.browsertakeover.cdp.b$b$a */
        public static final class a<T> extends AbstractC4136b<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final T f319471a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Function0<Unit> f319472b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Function0<Unit> f319473c;

            @Override // com.larus.browsertakeover.cdp.b.AbstractC4136b
            public final T a() {
                return this.f319471a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public a(BrowserCdpClient.m r100, Function0 r101, Function0 r102) {
                Intrinsics.checkNotNullParameter(r101, "action");
                this.f319471a = r100;
                this.f319472b = r101;
                this.f319473c = r102;
            }
        }

        /* JADX INFO: renamed from: com.larus.browsertakeover.cdp.b$b$b, reason: collision with other inner class name */
        public static final class C4137b<T> extends AbstractC4136b<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final T f319474a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final RemoteInputCommand.Key f319475b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f319476c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public RemoteInputCommand.Phase f319477d;

            public C4137b() {
                throw null;
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C4137b) == true) goto L8;
                return false;
            L8:
                C4137b r101 = (C4137b) r100;
                if (Intrinsics.areEqual(this.f319474a, r101.f319474a) == true) goto L12;
                return false;
            L12:
                if (this.f319475b == r101.f319475b) goto L15;
                return false;
            L15:
                if (this.f319476c == r101.f319476c) goto L18;
                return false;
            L18:
                if (this.f319477d == r101.f319477d) goto L20;
                return false;
            L20:
                return true;
            }

            public final int hashCode() {
                T r100 = this.f319474a;
                if (r100 != null) goto L5;
                int r101 = 0;
            L7:
                return (((((r101 * 31) + this.f319475b.hashCode()) * 31) + this.f319476c) * 31) + this.f319477d.hashCode();
            L5:
                r101 = r100.hashCode();
                goto L7
            }

            public final String toString() {
                return "KeyRun(token=" + this.f319474a + ", key=" + this.f319475b + ", remainingPresses=" + this.f319476c + ", nextPhase=" + this.f319477d + ')';
            }

            @Override // com.larus.browsertakeover.cdp.b.AbstractC4136b
            public final T a() {
                return this.f319474a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public C4137b(Object r100, RemoteInputCommand.Key r101, int r102) {
                RemoteInputCommand.Phase r103 = RemoteInputCommand.Phase.DOWN;
                Intrinsics.checkNotNullParameter(r101, "key");
                Intrinsics.checkNotNullParameter(r103, "nextPhase");
                this.f319474a = r100;
                this.f319475b = r101;
                this.f319476c = r102;
                this.f319477d = r103;
            }
        }

        /* JADX INFO: renamed from: com.larus.browsertakeover.cdp.b$b$c */
        public static final class c<T> extends AbstractC4136b<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final T f319478a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f319479b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof c) == true) goto L8;
                return false;
            L8:
                c r101 = (c) r100;
                if (Intrinsics.areEqual(this.f319478a, r101.f319478a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f319479b, r101.f319479b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                T r100 = this.f319478a;
                if (r100 != null) goto L5;
                int r101 = 0;
            L7:
                return (r101 * 31) + this.f319479b.hashCode();
            L5:
                r101 = r100.hashCode();
                goto L7
            }

            public final String toString() {
                return "Text(token=" + this.f319478a + ", text=" + this.f319479b + ')';
            }

            @Override // com.larus.browsertakeover.cdp.b.AbstractC4136b
            public final T a() {
                return this.f319478a;
            }

            public c(T r100, String r101) {
                Intrinsics.checkNotNullParameter(r101, "text");
                this.f319478a = r100;
                this.f319479b = r101;
            }
        }

        public AbstractC4136b() {
        }

        public abstract T a();
    }

    static {
    }

    public final synchronized int b() {
        monitor-enter(this);
        int r100 = this.f319468e;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized c1<T> c() {
        monitor-enter(this);
        AbstractC4136b<T> r100 = this.f319467d.peekFirst();     // Catch: Throwable -> L32
        if (r100 != null) goto L9;
        monitor-exit(this);
        return null;
    L9:
        if ((r100 instanceof AbstractC4136b.c) == false) goto L12;
        this.f319467d.removeFirst();     // Catch: Throwable -> L32
        RemoteInputCommand r101 = new RemoteInputCommand.b(((AbstractC4136b.c) r100).f319479b);     // Catch: Throwable -> L32
    L27:
        this.f319468e--;     // Catch: Throwable -> L32
        c1<T> r102 = new c1(r100.a(), r101);     // Catch: Throwable -> L32
        monitor-exit(this);
        return r102;
    L12:
        if ((r100 instanceof AbstractC4136b.C4137b) == false) goto L22;
        RemoteInputCommand.Phase r103 = ((AbstractC4136b.C4137b) r100).f319477d;     // Catch: Throwable -> L32
        RemoteInputCommand.Phase r104 = RemoteInputCommand.Phase.DOWN;     // Catch: Throwable -> L32
        if (r103 != r104) goto L16;
        RemoteInputCommand.Phase r105 = RemoteInputCommand.Phase.UP;     // Catch: Throwable -> L32
        Intrinsics.checkNotNullParameter(r105, "<set-?>");     // Catch: Throwable -> L32
        ((AbstractC4136b.C4137b) r100).f319477d = r105;     // Catch: Throwable -> L32
    L20:
        r101 = new RemoteInputCommand.c(((AbstractC4136b.C4137b) r100).f319475b, r103);     // Catch: Throwable -> L32
        goto L27
    L16:
        ((AbstractC4136b.C4137b) r100).f319476c--;     // Catch: Throwable -> L32
        if (((AbstractC4136b.C4137b) r100).f319476c != 0) goto L19;
        this.f319467d.removeFirst();     // Catch: Throwable -> L32
        goto L20
    L19:
        Intrinsics.checkNotNullParameter(r104, "<set-?>");     // Catch: Throwable -> L32
        ((AbstractC4136b.C4137b) r100).f319477d = r104;     // Catch: Throwable -> L32
        goto L20
    L22:
        if ((r100 instanceof AbstractC4136b.a) == false) goto L31;
        this.f319467d.removeFirst();     // Catch: Throwable -> L32
        this.f319469f--;     // Catch: Throwable -> L32
        if (((AbstractC4136b.a) r100).f319473c == null) goto L26;
        this.f319470g--;     // Catch: Throwable -> L32
    L26:
        r101 = new RemoteInputCommand.a(((AbstractC4136b.a) r100).f319472b, ((AbstractC4136b.a) r100).f319473c);     // Catch: Throwable -> L32
        goto L27
    L31:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    }

    public b() {
        this.f319464a = 320;
        this.f319465b = 16;
        this.f319466c = 64;
        this.f319467d = new ArrayDeque();
    }

    public final void a(T r100, RemoteInputCommand.Key r101, int r102) {
        if (r102 > 0) goto L4;
        return;
    L4:
        AbstractC4136b<T> r103 = this.f319467d.peekLast();
        if ((r103 instanceof AbstractC4136b.C4137b) == false) goto L11;
        AbstractC4136b.C4137b r104 = (AbstractC4136b.C4137b) r103;
        if (Intrinsics.areEqual(r104.f319474a, r100) == false) goto L11;
        if (r104.f319475b != r101) goto L11;
        r104.f319476c += r102;
        return;
    L11:
        this.f319467d.addLast(new AbstractC4136b.C4137b(r100, r101, r102));
    }
}
