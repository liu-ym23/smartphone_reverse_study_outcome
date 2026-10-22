package ev7;

import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.videosend.tools.VideoTools;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes23.dex */
public abstract class a<In, P> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<P> f474458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f474459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExecutorService f474460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Queue<InterfaceC5824a<P>> f474461d;

    /* JADX INFO: renamed from: ev7.a$a, reason: collision with other inner class name */
    public interface InterfaceC5824a<T> {
        T a();

        jv7.b b() throws IOException;

        void destroy();

        long getLength();

        InputStream openStream() throws IOException;
    }

    public static abstract class b<In, P> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final In f474462a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f474463b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f474464c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public File f474465d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final P f474466e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final CountDownLatch f474467f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public byte[] f474468g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Throwable f474469h;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0071 -> B:54:0x0063). Please report as a decompilation issue!!! */
        public final void a() {
        L33:
            th = move-exception;
            OutputStream r100 = null;
            Throwable th10 = th;
        L50:
            this.f474469h = th10;     // Catch: Throwable -> L41
            if (r100 != null) goto L54;
        L39:
            iv7.b.a(r100);
            this.f474467f.countDown();
            return;
        L54:
            r100.flush();     // Catch: IOException -> L29
        L31:
            th10 = th;
        L29:
            e = move-exception;
            e.printStackTrace();
        L41:
            th = move-exception;
            if (r100 != null) goto L52;
        L47:
            iv7.b.a(r100);
            this.f474467f.countDown();
            throw th;
        L52:
            r100.flush();     // Catch: IOException -> L45
        L45:
            e = move-exception;
            e.printStackTrace();
            goto L47
        L4:
            if (this.f474463b == false) goto L56;
            if (this.f474464c <= 0) goto L8;
            r100 = new ByteArrayOutputStream(this.f474464c);     // Catch: Throwable -> L33
        L58:
            b(this.f474466e, this.f474462a, r100);     // Catch: Throwable -> L31
            if ((r100 instanceof ByteArrayOutputStream) == false) goto L22;
            this.f474468g = ((ByteArrayOutputStream) r100).toByteArray();     // Catch: Throwable -> L31
            goto L54
        L22:
            if ((r100 instanceof h) == false) goto L54;
            h r101 = (h) r100;     // Catch: Throwable -> L31
            monitor-enter(r101);     // Catch: Throwable -> L31
            monitor-exit(r101);     // Catch: Throwable -> L31
            this.f474468g = null;     // Catch: Throwable -> L31
            goto L54
        L8:
            r100 = new ByteArrayOutputStream(1024);     // Catch: Throwable -> L33
            goto L58
        L56:
            if (iv7.g.f495954a == null) goto L16;
            File r102 = File.createTempFile(VideoTools.ERROR_TYPE_COMPRESS, "tmp", jgc.d.c());     // Catch: Throwable -> L49
            r102.deleteOnExit();     // Catch: Throwable -> L49
            if (r102.exists() == true) goto L17;
            r102.getPath();     // Catch: Throwable -> L49
        L17:
            r100 = new PolarisFileOutputStreamWrapper(r102);     // Catch: Throwable -> L33
            this.f474465d = r102;     // Catch: Throwable -> L33
        L16:
            r102 = File.createTempFile(VideoTools.ERROR_TYPE_COMPRESS, "tmp", null);     // Catch: Throwable -> L33
            goto L17
        }

        public abstract void b(P r100, In r101, OutputStream r102);

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(P r100, In r101, boolean r102, int r103) throws IOException {
            this.f474466e = r100;
            this.f474462a = r101;
            this.f474464c = r103;
            this.f474463b = r102;
            this.f474467f = new CountDownLatch(1);
        }
    }

    public static void a(InputStream r100, @Nonnull OutputStream r101) throws IOException {
        BufferedOutputStream r102 = new BufferedOutputStream(r101);
        byte[] r103 = new byte[32768];     // Catch: Throwable -> L10
    L4:
        int r104 = r100.read(r103);     // Catch: Throwable -> L10
        if (r104 == (-1)) goto L8;
        r102.write(r103, 0, r104);     // Catch: Throwable -> L10
        goto L4
    L8:
        r102.flush();
        return;
    L10:
        th = move-exception;
        r102.flush();
        throw th;
    }

    public a(List<P> r100, long r101, ExecutorService r102) {
        this.f474458a = r100;
        this.f474459b = r101;
        this.f474460c = r102;
        this.f474461d = new LinkedList();
        if (r102 == null) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("ExecutorService is null!");
    }
}
