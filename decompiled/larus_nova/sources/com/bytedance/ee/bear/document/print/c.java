package com.bytedance.ee.bear.document.print;

import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.Disposables;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes16.dex */
public final class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f221153d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f221154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f221155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f221156c;

    public static final class a {
        public static void b(PolarisFileWrapper r100) {
            if (r100.isFile() == false) goto L21;
            long r101 = r100.length();
            byte[] r102 = c.f221153d;
            if (r101 <= 5) goto L21;
            byte[] r103 = new byte[5];
            PolarisFileInputStreamWrapper r104 = new PolarisFileInputStreamWrapper(r100);
            int r105 = r104.read(r103);     // Catch: Throwable -> L15
            CloseableKt.closeFinally(r104, null);
            if (r105 != 5) goto L14;
            if (Arrays.equals(r103, r102) == false) goto L14;
            return;
        L14:
            throw new IOException("invalid print artifact type");
        L15:
            th = move-exception;
            throw th;     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            CloseableKt.closeFinally(r104, th);
            throw th;
        L21:
            throw new IOException("invalid print artifact");
        }

        public static c a(Uri r100, String r101) throws IOException {
            Intrinsics.checkNotNullParameter(r100, "uri");
            Intrinsics.checkNotNullParameter(r101, CommonConstant.KEY_DISPLAY_NAME);
            if (Intrinsics.areEqual(r100.getScheme(), "file") == false) goto L32;
            String r102 = r100.getPath();
            if (r102 == null) goto L30;
            PolarisFileWrapper r103 = new PolarisFileWrapper(r102);
            Intrinsics.checkNotNullParameter(r103, "file");
            Intrinsics.checkNotNullParameter(r101, CommonConstant.KEY_DISPLAY_NAME);
            b(r103);     // Catch: Throwable -> L22
            String r104 = StringsKt.trim(r101).toString();     // Catch: Throwable -> L22
            if (r104.length() <= 0) goto L10;
            boolean r105 = true;
        L11:
            if (r105 == true) goto L14;
            r104 = null;
        L14:
            if (r104 != null) goto L17;
            r104 = "document.pdf";
        L17:
            if (StringsKt.endsWith(r104, ".pdf", true) == true) goto L20;
            r104 = r104.concat(".pdf");     // Catch: Throwable -> L22
        L20:
            return new c(r103, r104);
        L10:
            r105 = false;
        L22:
            th = move-exception;
            if (r103.exists() == true) goto L26;
        L28:
            throw th;
        L26:
            if (r103.delete() == true) goto L28;
            tt5.a.k("PrintArtifact", "cleanup invalid print artifact failed");
            goto L28
        L30:
            throw new IOException("print artifact path missing");
        L32:
            throw new IOException("unsupported print artifact uri");
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f221157a;

        public b(c r100) {
            this.f221157a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c r100 = this.f221157a;     // Catch: Throwable -> L11
            if (r100.f221156c.compareAndSet(false, true) == true) goto L6;
            return;
        L6:
            if (r100.f221154a.exists() == true) goto L8;
            return;
        L8:
            if (r100.f221154a.delete() == true) goto L19;
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
        f221153d = new byte[]{37, 80, 68, 70, 45};
    }

    public final void a() {
        b r100 = new b(this);
    L7:
        th = move-exception;
        tt5.a.e("PrintArtifact", "schedule print artifact cleanup failed", th, false);
        r100.run();
        return;
    L4:
        if (fo5.d.b().scheduleDirect(r100) != Disposables.disposed()) goto L12;
        tt5.a.k("PrintArtifact", "schedule print artifact cleanup was rejected");     // Catch: Throwable -> L7
        r100.run();     // Catch: Throwable -> L7
        return;
    }

    public final PolarisFileInputStreamWrapper b() throws IOException {
        if (this.f221156c.get() == true) goto L11;
        if (this.f221154a.isFile() == false) goto L9;
        return new PolarisFileInputStreamWrapper(this.f221154a);
    L9:
        throw new IOException("print artifact missing");
    L11:
        throw new IOException("print artifact already cleaned");
    }

    public c(PolarisFileWrapper r100, String r101) {
        this.f221154a = r100;
        this.f221155b = r101;
        this.f221156c = new AtomicBoolean(false);
    }
}
