package okio;

import com.byted.cast.common.Constants;
import com.bytedance.pitaya.api.PTYSocketStateCallback;
import java.io.IOException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f523991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Buffer f523992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f523993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f523994d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ReentrantLock f523995e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Condition f523996f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f523997g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f523998h;

    public static final class a implements Sink {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j0 f523999a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d0 f524000b;

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            d0 r100 = this.f524000b;
            ReentrantLock r101 = r100.f523995e;
            r101.lock();
        L17:
            th = move-exception;
            r101.unlock();
            throw th;
        L4:
            if (r100.f523993c == false) goto L8;
            r101.unlock();
            return;
        L8:
            if (r100.f523994d == true) goto L10;
        L14:
            r100.f523993c = true;     // Catch: Throwable -> L17
            r100.f523996f.signalAll();     // Catch: Throwable -> L17
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L17
            r101.unlock();
            return;
        L10:
            if (r100.f523992b.size() <= 0) goto L14;
            throw new IOException("source is closed");     // Catch: Throwable -> L17
        }

        @Override // okio.Sink, java.io.Flushable
        public final void flush() {
            d0 r100 = this.f524000b;
            ReentrantLock r101 = r100.f523995e;
            r101.lock();
        L17:
            th = move-exception;
            r101.unlock();
            throw th;
        L4:
            if ((!r100.f523993c) == false) goto L16;
            if (r100.f523994d == true) goto L8;
        L12:
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L17
            r101.unlock();
            return;
        L8:
            if (r100.f523992b.size() <= 0) goto L12;
            throw new IOException("source is closed");     // Catch: Throwable -> L17
        L16:
            throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());     // Catch: Throwable -> L17
        }

        @Override // okio.Sink
        public final j0 timeout() {
            return this.f523999a;
        }

        public a(d0 r100) {
            this.f524000b = r100;
            this.f523999a = new j0();
        }

        @Override // okio.Sink
        public final void write(Buffer r100, long r110) {
            Intrinsics.checkNotNullParameter(r100, "source");
            d0 r101 = this.f524000b;
            ReentrantLock r102 = r101.f523995e;
            r102.lock();
        L20:
            th = move-exception;
            r102.unlock();
            throw th;
        L4:
            if ((!r101.f523993c) == false) goto L19;
        L6:
            if (r110 <= 0) goto L15;
            if (r101.f523994d == true) goto L14;
            long r103 = r101.f523991a - r101.f523992b.size();     // Catch: Throwable -> L20
            if (r103 == 0) goto L11;
            long r104 = Math.min(r103, r110);     // Catch: Throwable -> L20
            r101.f523992b.write(r100, r104);     // Catch: Throwable -> L20
            r110 = r110 - r104;     // Catch: Throwable -> L20
            r101.f523996f.signalAll();     // Catch: Throwable -> L20
            goto L6
        L11:
            this.f523999a.a(r101.f523996f);     // Catch: Throwable -> L20
            goto L6
        L14:
            throw new IOException("source is closed");     // Catch: Throwable -> L20
        L15:
            Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L20
            r102.unlock();
            return;
        L19:
            throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());     // Catch: Throwable -> L20
        }
    }

    public static final class b implements Source {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j0 f524001a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d0 f524002b;

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            d0 r100 = this.f524002b;
            ReentrantLock r101 = r100.f523995e;
            r101.lock();
            r100.f523994d = true;     // Catch: Throwable -> L6
            r100.f523996f.signalAll();     // Catch: Throwable -> L6
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L6
            r101.unlock();
            return;
        L6:
            th = move-exception;
            r101.unlock();
            throw th;
        }

        @Override // okio.Source
        public final j0 timeout() {
            return this.f524001a;
        }

        public b(d0 r100) {
            this.f524002b = r100;
            this.f524001a = new j0();
        }

        @Override // okio.Source
        public final long read(Buffer r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, Constants.ROLE_SINK);
            d0 r102 = this.f524002b;
            ReentrantLock r103 = r102.f523995e;
            r103.lock();
        L17:
            th = move-exception;
            r103.unlock();
            throw th;
        L4:
            if ((!r102.f523994d) == false) goto L16;
        L6:
            if (r102.f523992b.size() != 0) goto L12;
            if (r102.f523993c == true) goto L9;
            this.f524001a.a(r102.f523996f);     // Catch: Throwable -> L17
            goto L6
        L9:
            r103.unlock();
            return -1;
        L12:
            long r104 = r102.f523992b.read(r100, r101);     // Catch: Throwable -> L17
            r102.f523996f.signalAll();     // Catch: Throwable -> L17
            r103.unlock();
            return r104;
        L16:
            throw new IllegalStateException(PTYSocketStateCallback.CLOSED.toString());     // Catch: Throwable -> L17
        }
    }

    public d0(long r100) {
        this.f523991a = r100;
        this.f523992b = new Buffer();
        ReentrantLock r101 = new ReentrantLock();
        this.f523995e = r101;
        this.f523996f = r101.newCondition();
        if (r100 < 1) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L10;
        this.f523997g = new a(this);
        this.f523998h = new b(this);
        return;
    L10:
        throw new IllegalArgumentException(("maxBufferSize < 1: " + r100).toString());
    L5:
        r102 = false;
        goto L6
    }
}
