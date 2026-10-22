package io.ktor.websocket;

import io.ktor.utils.io.core.t;
import io.ktor.utils.io.core.v;
import java.nio.ByteBuffer;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.m0;

/* JADX INFO: loaded from: classes41.dex */
public abstract class c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte[] f492167h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f492168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameType f492169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f492170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m0 f492171d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f492172e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f492173f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f492174g;

    public static final class a extends c {
        public a(boolean r110, byte[] r111, boolean r112, boolean r113, boolean r114) {
            Intrinsics.checkNotNullParameter(r111, "data");
            super(r110, FrameType.BINARY, r111, io.ktor.websocket.e.f492176a, r112, r113, r114);
        }
    }

    public static final class b extends c {
        public b() {
            this(c.f492167h);
        }

        public b(CloseReason r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            io.ktor.utils.io.core.j r101 = new io.ktor.utils.io.core.j(null);
            t.a(r101, r100.f492138a);     // Catch: Throwable -> L6
            v.d(r101, r100.f492139b);     // Catch: Throwable -> L6
            io.ktor.utils.io.core.k r102 = r101.m();     // Catch: Throwable -> L6
            Intrinsics.checkNotNullParameter(r102, "packet");
            this(v.b(r102));
            return;
        L6:
            th = move-exception;
            r101.close();
            throw th;
        }

        public b(byte[] r110) {
            Intrinsics.checkNotNullParameter(r110, "data");
            super(true, FrameType.CLOSE, r110, io.ktor.websocket.e.f492176a, false, false, false);
        }
    }

    /* JADX INFO: renamed from: io.ktor.websocket.c$c, reason: collision with other inner class name */
    public static final class C6315c {

        /* JADX INFO: renamed from: io.ktor.websocket.c$c$a */
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f492175a = null;

            static {
                int[] r100 = new int[FrameType.values().length];
                r100[FrameType.BINARY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r100[FrameType.TEXT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r100[FrameType.CLOSE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r100[FrameType.PING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r100[FrameType.PONG.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                f492175a = r100;
            }
        }

        public static c a(boolean r100, FrameType r101, byte[] r102, boolean r103, boolean r110, boolean r111) {
            Intrinsics.checkNotNullParameter(r101, "frameType");
            Intrinsics.checkNotNullParameter(r102, "data");
            int r104 = a.f492175a[r101.ordinal()];
            if (r104 != 1) goto L5;
            c r105 = new a(r100, r102, r103, r110, r111);
        L20:
            return r105;
        L5:
            if (r104 != 2) goto L7;
            r105 = new f(r100, r102, r103, r110, r111);
            goto L20
        L7:
            if (r104 == 3) goto L23;
            if (r104 == 4) goto L22;
            if (r104 != 5) goto L14;
            return new e(r102, io.ktor.websocket.e.f492176a);
        L14:
            throw new NoWhenBranchMatchedException();
        L22:
            return new d(r102);
        L23:
            return new b(r102);
        }
    }

    public static final class d extends c {
        public d(byte[] r110) {
            Intrinsics.checkNotNullParameter(r110, "data");
            super(true, FrameType.PING, r110, io.ktor.websocket.e.f492176a, false, false, false);
        }
    }

    public static final class e extends c {
        public e(byte[] r110, m0 r111) {
            Intrinsics.checkNotNullParameter(r110, "data");
            Intrinsics.checkNotNullParameter(r111, "disposableHandle");
            super(true, FrameType.PONG, r110, r111, false, false, false);
        }
    }

    public static final class f extends c {
        public f(boolean r110, byte[] r111, boolean r112, boolean r113, boolean r114) {
            Intrinsics.checkNotNullParameter(r111, "data");
            super(r110, FrameType.TEXT, r111, io.ktor.websocket.e.f492176a, r112, r113, r114);
        }
    }

    static {
        f492167h = new byte[0];
    }

    public final String toString() {
        return "Frame " + this.f492169b + " (fin=" + this.f492168a + ", buffer len = " + this.f492170c.length + ')';
    }

    public c(boolean r100, FrameType r101, byte[] r102, m0 r103, boolean r104, boolean r105, boolean r106) {
        this.f492168a = r100;
        this.f492169b = r101;
        this.f492170c = r102;
        this.f492171d = r103;
        this.f492172e = r104;
        this.f492173f = r105;
        this.f492174g = r106;
        ByteBuffer.wrap(r102);
    }
}
