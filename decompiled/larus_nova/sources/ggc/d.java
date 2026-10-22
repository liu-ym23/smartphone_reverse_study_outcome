package ggc;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.ss.android.ttapkdiffpatch.applier.DiffType;
import com.ss.android.ttapkdiffpatch.applier.decoder.TTPatchParseException;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import jgc.e;

/* JADX INFO: loaded from: classes38.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f481230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f481231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f481232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DiffType f481233d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f481234e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f481235f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f481236g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f481237h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f481238i;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f481239a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f481240b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f481241c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f481242d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public File f481243e;

        public final void a(File r110) throws IOException, TTPatchParseException {
            if (this.f481243e == null) goto L5;
            return;
        L5:
            BufferedOutputStream r100 = null;
            PolarisFileInputStreamWrapper r101 = new PolarisFileInputStreamWrapper(this.f481239a);     // Catch: Throwable -> L40
            r101.skip(this.f481240b);     // Catch: Throwable -> L38
            jgc.b r102 = new jgc.b(r101);     // Catch: Throwable -> L38
            long r103 = this.f481241c;     // Catch: Throwable -> L36
            BufferedOutputStream r104 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r110));     // Catch: Throwable -> L32
            if (PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID < r103) goto L13;
            byte[] r105 = new byte[(int) r103];     // Catch: Throwable -> L30
        L16:
            if (r103 <= 0) goto L25;
            int r111 = r102.read(r105, 0, r105.length);     // Catch: Throwable -> L30
            if (r111 == (-1)) goto L25;
            r104.write(r105, 0, r111);     // Catch: Throwable -> L30
            r103 = r103 - ((long) r111);     // Catch: Throwable -> L30
            if (r103 > PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID) goto L16;
            if (r103 <= 0) goto L16;
            r105 = new byte[(int) r103];     // Catch: Throwable -> L30
        L25:
            r104.flush();     // Catch: Throwable -> L36
            e.a(r104);     // Catch: Throwable -> L36
            long r106 = r102.f499060b.getValue();     // Catch: Throwable -> L36
            if (r106 != this.f481242d) goto L29;
        L43:
            e.a(r102);
            e.a(r101);
            this.f481243e = r110;
            return;
        L29:
            throw new TTPatchParseException(1009, "except crc32 is " + this.f481242d + " but actual crc32 is " + r106);     // Catch: Throwable -> L36
        L13:
            r105 = new byte[32768];     // Catch: Throwable -> L30
        L30:
            th = move-exception;
            th = th;
            r100 = r104;
        L33:
            if (r100 == null) goto L35;
            r100.flush();     // Catch: Throwable -> L36
            e.a(r100);     // Catch: Throwable -> L36
        L35:
            throw th;     // Catch: Throwable -> L36
        L32:
            th = th;
        L36:
            Throwable th10 = th;
        L55:
            th10.printStackTrace();     // Catch: Throwable -> L45
        L45:
            th = move-exception;
            e.a(r102);
            e.a(r101);
            throw th;
        L38:
            th = move-exception;
            r102 = null;
            th10 = th;
        L40:
            th = move-exception;
            r102 = null;
            th10 = th;
            r101 = null;
            goto L55
        }

        public a(String r100, long r101, long r102, long r103) {
            this.f481239a = r100;
            this.f481240b = r101;
            this.f481241c = r102;
            this.f481242d = r103;
        }
    }

    public final String toString() {
        return "TTPatch{mMagicString='APKD', mMajorVersion=" + this.f481230a + ", mMinorVersion=" + this.f481231b + ", mExtendedInfoLength=" + this.f481232c + ", mDiffType=" + this.f481233d + ", mOldApkMd5='" + this.f481234e + "', mNewApkMd5='" + this.f481235f + "', mDiffFileLength=" + this.f481236g + ", mDiffFileOffset=0, mDiffFileCrc32='" + this.f481238i + "'}";
    }

    public d(int r100, int r101, int r102, DiffType r103, String r104, String r105, long r106, a r107, long r110) {
        this.f481230a = r100;
        this.f481231b = r101;
        this.f481232c = r102;
        this.f481233d = r103;
        this.f481234e = r104;
        this.f481235f = r105;
        this.f481236g = r106;
        this.f481237h = r107;
        this.f481238i = r110;
    }
}
