package com.bytedance.ee.bear.document.print;

import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.Disposables;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public static final byte[] d = null;
    public final File a;
    public final String b;
    public final AtomicBoolean c;

    public static final class a {
        public static void b(PolarisFileWrapper r7) {
            if (r7.isFile() == false) goto L21;
            long r0 = r7.length();
            byte[] r2 = c.d;
            if (r0 <= 5) goto L21;
            byte[] r1 = new byte[5];
            PolarisFileInputStreamWrapper r3 = new PolarisFileInputStreamWrapper(r7);
            int r8 = r3.read(r1);     // Catch: Throwable -> L15
            CloseableKt.closeFinally(r3, null);
            if (r8 != 5) goto L14;
            if (Arrays.equals(r1, r2) == false) goto L14;
            return;
        L14:
            throw new IOException("invalid print artifact type");
        L15:
            th = move-exception;
            throw th;     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            CloseableKt.closeFinally(r3, th);
            throw th;
        L21:
            throw new IOException("invalid print artifact");
        }

        public static c a(Uri r3, String r4) throws IOException {
            Intrinsics.checkNotNullParameter(r3, "uri");
            Intrinsics.checkNotNullParameter(r4, "displayName");
            if (Intrinsics.areEqual(r3.getScheme(), "file") == false) goto L32;
            String r5 = r3.getPath();
            if (r5 == null) goto L30;
            PolarisFileWrapper r1 = new PolarisFileWrapper(r5);
            Intrinsics.checkNotNullParameter(r1, "file");
            Intrinsics.checkNotNullParameter(r4, "displayName");
            b(r1);     // Catch: Throwable -> L22
            String r6 = StringsKt.trim(r4).toString();     // Catch: Throwable -> L22
            if (r6.length() <= 0) goto L10;
            boolean r0 = true;
        L11:
            if (r0 == true) goto L14;
            r6 = null;
        L14:
            if (r6 != null) goto L17;
            r6 = "document.pdf";
        L17:
            if (StringsKt.endsWith(r6, ".pdf", true) == true) goto L20;
            r6 = r6.concat(".pdf");     // Catch: Throwable -> L22
        L20:
            return new c(r1, r6);
        L10:
            r0 = false;
        L22:
            th = move-exception;
            if (r1.exists() == true) goto L26;
        L28:
            throw th;
        L26:
            if (r1.delete() == true) goto L28;
            tt5.a.k("PrintArtifact", "cleanup invalid print artifact failed");
            goto L28
        L30:
            throw new IOException("print artifact path missing");
        L32:
            throw new IOException("unsupported print artifact uri");
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c r0 = this.a;     // Catch: Throwable -> L11
            if (r0.c.compareAndSet(false, true) == true) goto L6;
            return;
        L6:
            if (r0.a.exists() == true) goto L8;
            return;
        L8:
            if (r0.a.delete() == true) goto L19;
            tt5.a.k("PrintArtifact", "cleanup print artifact failed");     // Catch: Throwable -> L11
            return;
        L19:
            return;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L20;
            throw th;
        }
    }

    static {
        d = new byte[]{37, 80, 68, 70, 45};
    }

    public final void a() {
        b r1 = new b(this);
    L7:
        th = move-exception;
        tt5.a.e("PrintArtifact", "schedule print artifact cleanup failed", th, false);
        r1.run();
        return;
    L4:
        if (fo5.d.b().scheduleDirect(r1) != Disposables.disposed()) goto L12;
        tt5.a.k("PrintArtifact", "schedule print artifact cleanup was rejected");     // Catch: Throwable -> L7
        r1.run();     // Catch: Throwable -> L7
        return;
    }

    public final PolarisFileInputStreamWrapper b() throws IOException {
        if (this.c.get() == true) goto L11;
        if (this.a.isFile() == false) goto L9;
        return new PolarisFileInputStreamWrapper(this.a);
    L9:
        throw new IOException("print artifact missing");
    L11:
        throw new IOException("print artifact already cleaned");
    }

    public c(PolarisFileWrapper r1, String r2) {
        this.a = r1;
        this.b = r2;
        this.c = new AtomicBoolean(false);
    }
}
