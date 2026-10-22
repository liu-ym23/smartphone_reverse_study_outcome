package okio;

import com.byted.cast.common.Constants;
import com.bytedance.pitaya.api.PTYSocketStateCallback;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public abstract class j implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f524067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f524068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReentrantLock f524069c;

    public static final class a implements Source {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j f524070a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f524071b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f524072c;

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.f524072c == false) goto L5;
            return;
        L5:
            this.f524072c = true;
            ReentrantLock r100 = this.f524070a.f524069c;
            r100.lock();
            j r101 = this.f524070a;     // Catch: Throwable -> L16
            int r102 = r101.f524068b - 1;     // Catch: Throwable -> L16
            r101.f524068b = r102;     // Catch: Throwable -> L16
            if (r102 == 0) goto L9;
        L14:
            r100.unlock();
            return;
        L9:
            if (r101.f524067a == false) goto L14;
            Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L16
            r100.unlock();
            this.f524070a.a();
            return;
        L16:
            th = move-exception;
            r100.unlock();
            throw th;
        }

        @Override // okio.Source
        public final j0 timeout() {
            return j0.f524073d;
        }

        public a(j r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "fileHandle");
            this.f524070a = r100;
            this.f524071b = r101;
        }

        @Override // okio.Source
        public final long read(Buffer r110, long r210) {
            Intrinsics.checkNotNullParameter(r110, Constants.ROLE_SINK);
            if ((!this.f524072c) == false) goto L29;
            j r100 = this.f524070a;
            long r111 = this.f524071b;
            r100.getClass();
            if (r210 < 0) goto L7;
            boolean r101 = true;
        L8:
            if (r101 == false) goto L27;
            long r102 = r210 + r111;
            long r112 = r111;
        L11:
            if (r112 >= r102) goto L21;
            g0 r113 = r110.writableSegment$okio(1);
            byte[] r103 = r113.f524017a;
            int r114 = r113.f524019c;
            long r211 = r102;
            int r104 = r100.b(r112, r103, r114, (int) Math.min(r102 - r112, 8192 - r114));
            if (r104 == (-1)) goto L15;
            r113.f524019c += r104;
            long r105 = r104;
            r112 = r112 + r105;
            r110.setSize$okio(r110.size() + r105);
            r102 = r211;
            goto L11
        L15:
            if (r113.f524018b != r113.f524019c) goto L18;
            r110.head = r113.a();
            h0.a(r113);
        L18:
            if (r111 != r112) goto L21;
            long r115 = -1;
        L23:
            if (r115 == (-1)) goto L25;
            this.f524071b += r115;
        L25:
            return r115;
        L21:
            r115 = r112 - r111;
            goto L23
        L27:
            throw new IllegalArgumentException(("byteCount < 0: " + r210).toString());
        L7:
            r101 = false;
            goto L8
        L29:
            throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());
        }
    }

    public abstract void a() throws IOException;

    public abstract int b(long r100, byte[] r101, int r102, int r103) throws IOException;

    public abstract long c() throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        ReentrantLock r100 = this.f524069c;
        r100.lock();
    L15:
        th = move-exception;
        r100.unlock();
        throw th;
    L4:
        if (this.f524067a == false) goto L8;
        r100.unlock();
        return;
    L8:
        this.f524067a = true;     // Catch: Throwable -> L15
        if (this.f524068b == 0) goto L12;
        r100.unlock();
        return;
    L12:
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r100.unlock();
        a();
    }

    public final long size() throws IOException {
        ReentrantLock r100 = this.f524069c;
        r100.lock();
    L10:
        th = move-exception;
        r100.unlock();
        throw th;
    L4:
        if ((!this.f524067a) == false) goto L9;
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L10
        r100.unlock();
        return c();
    L9:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());     // Catch: Throwable -> L10
    }

    public j() {
        this.f524069c = new ReentrantLock();
    }

    public final a d(long r100) throws IOException {
        ReentrantLock r101 = this.f524069c;
        r101.lock();
    L10:
        th = move-exception;
        r101.unlock();
        throw th;
    L4:
        if ((!this.f524067a) == false) goto L9;
        this.f524068b++;     // Catch: Throwable -> L10
        r101.unlock();
        return new a(this, r100);
    L9:
        throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());     // Catch: Throwable -> L10
    }
}
