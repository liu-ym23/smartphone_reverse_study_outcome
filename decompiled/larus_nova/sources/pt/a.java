package pt;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f530616a = 0;

    /* JADX INFO: renamed from: pt.a$a, reason: collision with other inner class name */
    public static final class C7243a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f530617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f530618b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C7243a) == false) goto L10;
            C7243a r101 = (C7243a) r100;
            if (this.f530617a == r101.f530617a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f530618b, r101.f530618b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public final int hashCode() {
            boolean r100 = this.f530617a;
            ?? r101 = r100;
            if (r100 == false) goto L5;
            r101 = 1;
        L5:
            int r102 = r101 * 31;
            String r103 = this.f530618b;
            if (r103 == null) goto L8;
            int r104 = r103.hashCode();
        L10:
            return r102 + r104;
        L8:
            r104 = 0;
            goto L10
        }

        public final String toString() {
            return "CompressResponse(isSucceed=" + this.f530617a + ", message=" + this.f530618b + ")";
        }

        public C7243a(boolean r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "message");
            this.f530617a = r100;
            this.f530618b = r101;
        }
    }

    static {
    }

    public static C7243a a(Context r110, String r111, long r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "filePath");
        PolarisFileWrapper r100 = new PolarisFileWrapper(r111);
        if (r100.exists() == false) goto L5;
        long r101 = r100.length();
        long r102 = 1024;
        if ((r101 / r102) <= r112) goto L9;
        Bitmap r113 = null;
        PolarisFileOutputStreamWrapper r114 = null;
        PolarisFileOutputStreamWrapper r115 = null;
        r113 = null;
        float r116 = (r112 / (r101 / r102)) * 100;     // Catch: Throwable -> L38 Exception -> L40
        File r103 = r110.getExternalCacheDir();     // Catch: Throwable -> L38 Exception -> L40
        if (r103 == null) goto L14;
        String r117 = r103.getAbsolutePath();     // Catch: Throwable -> L38 Exception -> L40
    L18:
        if (r117 == null) goto L37;
        if (r117.length() != 0) goto L22;
        boolean r104 = true;
    L23:
        if (r104 == true) goto L37;
        Bitmap r105 = BitmapFactory.decodeFile(r100.getAbsolutePath());     // Catch: Throwable -> L38 Exception -> L40
        String r118 = r117 + "/game_comment_" + System.currentTimeMillis() + ".jpeg";     // Catch: Throwable -> L33 Exception -> L54
        PolarisFileOutputStreamWrapper r106 = new PolarisFileOutputStreamWrapper(r118);     // Catch: Throwable -> L33 Exception -> L54
        r105.compress(Bitmap.CompressFormat.JPEG, (int) r116, r106);     // Catch: Throwable -> L30 Exception -> L32
        C7243a r119 = new C7243a(true, r118);     // Catch: Throwable -> L30 Exception -> L32
        r105.recycle();
        r106.close();
        return r119;
    L32:
        r114 = r106;
    L30:
        th = th;
        r115 = r106;
    L34:
        PolarisFileOutputStreamWrapper r120 = r115;
        r113 = r105;
    L49:
        if (r113 == null) goto L51;
        r113.recycle();
    L51:
        if (r120 == null) goto L62;
        r120.close();
        throw th;
    L62:
        throw th;
    L33:
        th = th;
    L35:
        PolarisFileOutputStreamWrapper r121 = r114;
        r113 = r105;
    L55:
        C7243a r122 = new C7243a(false, "compress failed");     // Catch: Throwable -> L47
        if (r113 == null) goto L44;
        r113.recycle();
    L44:
        if (r121 == null) goto L46;
        r121.close();
    L46:
        return r122;
    L47:
        th = move-exception;
        r120 = r121;
        th = th;
        goto L49
    L22:
        r104 = false;
    L37:
        return new C7243a(false, "compress failed, compress file path is null");
    L14:
        File r123 = r110.getExternalFilesDir("");     // Catch: Throwable -> L38 Exception -> L40
        if (r123 == null) goto L17;
        r117 = r123.getAbsolutePath();     // Catch: Throwable -> L38 Exception -> L40
        goto L18
    L17:
        r117 = "";
    L40:
        r121 = null;
    L38:
        th = th;
        r120 = null;
        goto L49
    L9:
        return new C7243a(true, r100.getAbsolutePath());
    L5:
        return new C7243a(false, "file not exists");
    }
}
