package io.ktor.utils.io.internal;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuffer f492082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f492083b;

    public static final class a extends h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f492084c = null;

        static {
            f492084c = new a();
        }

        public final String toString() {
            return "IDLE(empty)";
        }

        public a() {
            super(i.f492096a, i.f492097b);
        }
    }

    public static final class b extends h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c f492085c;

        @Override // io.ktor.utils.io.internal.h
        public final boolean a() {
            return true;
        }

        public final String toString() {
            return "IDLE(with buffer)";
        }

        @Override // io.ktor.utils.io.internal.h
        public final h d() {
            return this.f492085c.f492089f;
        }

        @Override // io.ktor.utils.io.internal.h
        public final h e() {
            return this.f492085c.f492090g;
        }

        public b(c r100) {
            Intrinsics.checkNotNullParameter(r100, "initial");
            super(r100.f492082a, r100.f492083b);
            this.f492085c = r100;
        }
    }

    public static final class c extends h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ByteBuffer f492086c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ByteBuffer f492087d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final b f492088e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final d f492089f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final g f492090g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final e f492091h;

        public final String toString() {
            return "Initial";
        }

        @Override // io.ktor.utils.io.internal.h
        public final boolean a() {
            throw new IllegalStateException("Not available for initial state".toString());
        }

        @Override // io.ktor.utils.io.internal.h
        public final ByteBuffer b() {
            return this.f492087d;
        }

        @Override // io.ktor.utils.io.internal.h
        public final ByteBuffer c() {
            return this.f492086c;
        }

        @Override // io.ktor.utils.io.internal.h
        public final h d() {
            return this.f492089f;
        }

        @Override // io.ktor.utils.io.internal.h
        public final h e() {
            return this.f492090g;
        }

        public /* synthetic */ c(ByteBuffer r100) {
            this(r100, 8);
        }

        public c(ByteBuffer r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "backingBuffer");
            super(r100, new j(r100.capacity() - r101));
            boolean r102 = false;
            if (r100.position() != 0) goto L5;
            boolean r103 = true;
        L7:
            if (r103 == false) goto L17;
            if (r100.limit() != r100.capacity()) goto L11;
            r102 = true;
        L11:
            if (r102 == false) goto L15;
            this.f492086c = r100.duplicate();
            this.f492087d = r100.duplicate();
            this.f492088e = new b(this);
            this.f492089f = new d(this);
            this.f492090g = new g(this);
            this.f492091h = new e(this);
            return;
        L15:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L17:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L5:
            r103 = false;
            goto L7
        }
    }

    public static final class d extends h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c f492092c;

        public final String toString() {
            return "Reading";
        }

        @Override // io.ktor.utils.io.internal.h
        public final ByteBuffer b() {
            return this.f492092c.f492087d;
        }

        @Override // io.ktor.utils.io.internal.h
        public final h e() {
            return this.f492092c.f492091h;
        }

        @Override // io.ktor.utils.io.internal.h
        public final h f() {
            return this.f492092c.f492088e;
        }

        public d(c r100) {
            Intrinsics.checkNotNullParameter(r100, "initial");
            super(r100.f492082a, r100.f492083b);
            this.f492092c = r100;
        }
    }

    public static final class e extends h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c f492093c;

        public final String toString() {
            return "Reading+Writing";
        }

        @Override // io.ktor.utils.io.internal.h
        public final ByteBuffer b() {
            return this.f492093c.f492087d;
        }

        @Override // io.ktor.utils.io.internal.h
        public final ByteBuffer c() {
            return this.f492093c.f492086c;
        }

        @Override // io.ktor.utils.io.internal.h
        public final h f() {
            return this.f492093c.f492090g;
        }

        @Override // io.ktor.utils.io.internal.h
        public final h g() {
            return this.f492093c.f492089f;
        }

        public e(c r100) {
            Intrinsics.checkNotNullParameter(r100, "initial");
            super(r100.f492082a, r100.f492083b);
            this.f492093c = r100;
        }
    }

    public static final class f extends h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final f f492094c = null;

        static {
            f492094c = new f();
        }

        public final String toString() {
            return "Terminated";
        }

        public f() {
            super(i.f492096a, i.f492097b);
        }
    }

    public static final class g extends h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c f492095c;

        public final String toString() {
            return "Writing";
        }

        @Override // io.ktor.utils.io.internal.h
        public final ByteBuffer c() {
            return this.f492095c.f492086c;
        }

        @Override // io.ktor.utils.io.internal.h
        public final h d() {
            return this.f492095c.f492091h;
        }

        @Override // io.ktor.utils.io.internal.h
        public final h g() {
            return this.f492095c.f492088e;
        }

        public g(c r100) {
            Intrinsics.checkNotNullParameter(r100, "initial");
            super(r100.f492082a, r100.f492083b);
            this.f492095c = r100;
        }
    }

    public boolean a() {
        return this instanceof a;
    }

    public ByteBuffer b() {
        throw new IllegalStateException(("read buffer is not available in state " + this).toString());
    }

    public ByteBuffer c() {
        throw new IllegalStateException(("write buffer is not available in state " + this).toString());
    }

    public h d() {
        throw new IllegalStateException(("ByteChannel[state: " + this + "] Concurrent reading is not supported").toString());
    }

    public h e() {
        throw new IllegalStateException(("ByteChannel[state: " + this + "] Concurrent writing is not supported").toString());
    }

    public h f() {
        throw new IllegalStateException(("Unable to stop reading in state " + this).toString());
    }

    public h g() {
        throw new IllegalStateException(("Unable to stop writing in state " + this).toString());
    }

    public h(ByteBuffer r100, j r101) {
        this.f492082a = r100;
        this.f492083b = r101;
    }
}
