package lu5;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Environment;
import com.bytedance.ee.util.io.FileUtils;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import du5.d;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final long b(VFSPath r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        BitmapFactory.Options r101 = new BitmapFactory.Options();
        r101.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r100.getRealPath(), r101);
        tt5.a.h("ImageUtils", "getBitmapSize(), height: " + r101.outHeight + ",width: " + r101.outWidth);
        return ((long) r101.outHeight) * ((long) r101.outWidth);
    }

    @JvmStatic
    public static final Rect a(VFSPath r100, float[] r101) {
        if (r100 != null) goto L6;
        return new Rect();
    L6:
        if (r101 != null) goto L11;
        float[] r102 = new float[4];
        int r103 = 0;
    L8:
        if (r103 >= 4) goto L10;
        r102[r103] = 1.0f;
        r103 = r103 + 1;
        goto L8
    L10:
        r101 = r102;
    L11:
        BitmapFactory.Options r104 = new BitmapFactory.Options();
        r104.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r100.getRealPath(), r104);
        Rect r105 = new Rect();
        int r106 = r104.outWidth;
        int r107 = (int) (r106 * r101[0]);
        int r108 = r104.outHeight;
        r105.set(r107, (int) (r108 * r101[1]), (int) (r106 * r101[2]), (int) (r108 * r101[3]));
        return r105;
    }

    public static boolean d(Bitmap r100, String r101, String r102) {
        if (Intrinsics.areEqual("mounted", Environment.getExternalStorageState()) == false) goto L44;
        VFSFiles r103 = VFSFiles.f444819b;
        VFSFile r104 = r103.i(r101);
        if (r104.exists() == true) goto L7;
        r104.mkdirs();
    L7:
        VFSFile r105 = r103.i(r104 + '/' + r102);
        if (r105.exists() == false) goto L52;
    L14:
        PolarisFileOutputStreamWrapper r106 = null;
        PolarisFileOutputStreamWrapper r107 = new PolarisFileOutputStreamWrapper(r105);     // Catch: Throwable -> L27 Exception -> L29
        r100.compress(Bitmap.CompressFormat.JPEG, 100, r107);     // Catch: Throwable -> L23 Exception -> L25
        r107.flush();     // Catch: Throwable -> L23 Exception -> L25
        r107.close();     // Catch: Exception -> L19
        return true;
    L19:
        e = move-exception;
        tt5.a.d("ImageUtils", "saveBitmapToSD close failed,exception:" + e.getMessage());
        return true;
    L25:
        e = e;
        r106 = r107;
    L30:
        tt5.a.d("ImageUtils", "saveBitmapToSD failed,exception:" + e.getMessage());     // Catch: Throwable -> L27
        if (r106 != null) goto L49;
    L36:
        return false;
    L49:
        r106.close();     // Catch: Exception -> L34
    L34:
        e = move-exception;
        tt5.a.d("ImageUtils", "saveBitmapToSD close failed,exception:" + e.getMessage());
    L23:
        th = th;
    L38:
        if (r107 != null) goto L54;
    L43:
        throw th;
    L54:
        r107.close();     // Catch: Exception -> L41
    L41:
        e = move-exception;
        tt5.a.d("ImageUtils", "saveBitmapToSD close failed,exception:" + e.getMessage());
    L29:
        e = e;
    L27:
        th = th;
        r107 = r106;
        goto L38
    L52:
        r105.createNewFile();     // Catch: Exception -> L11
    L11:
        e = move-exception;
        tt5.a.d("ImageUtils", "saveBitmapToSD createNewFile failed,exception:" + e.getMessage());
        return false;
    L44:
        return false;
    }

    @JvmStatic
    public static final VFSPath c(VFSPath r210, VFSPath r211, float[] r212, float r213) {
        Intrinsics.checkNotNullParameter(r210, "sourceFile");
        Intrinsics.checkNotNullParameter(r211, "targetPath");
        boolean r100 = false;
        if (r213 != 0.0f) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L33;
        if (r212 != null) goto L10;
    L31:
        tt5.a.h("ImageUtils", "getRoateAndCropBitmapFile，return the sourceFile");
        return r210;
    L10:
        if (r212.length != 4) goto L31;
        if (r212[0] != 0.0f) goto L14;
        boolean r102 = true;
    L15:
        if (r102 == false) goto L33;
        if (r212[1] != 0.0f) goto L19;
        boolean r103 = true;
    L20:
        if (r103 == false) goto L33;
        if (r212[2] != 1.0f) goto L24;
        boolean r104 = true;
    L25:
        if (r104 == false) goto L33;
        if (r212[3] != 1.0f) goto L29;
        boolean r105 = true;
    L30:
        if (r105 == false) goto L33;
    L29:
        r105 = false;
        goto L30
    L24:
        r104 = false;
        goto L25
    L19:
        r103 = false;
        goto L20
    L14:
        r102 = false;
    L33:
        Rect r106 = a(r210, r212);
        String r107 = r210.getRealPath();
        String r110 = FileUtils.s(r107);
        if (r212 != null) goto L36;
    L38:
        StringBuilder r108 = new StringBuilder();
        r108.append(d.a(r107 + r213));
        r108.append('.');
        r108.append(r110);
        String r109 = r108.toString();
    L39:
        VFSPath r111 = r211.subPath(r109);
        if (r111.toFile().exists() == false) goto L86;
        BitmapFactory.Options r112 = new BitmapFactory.Options();
        r112.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r111.getRealPath(), r112);
        if (r112.outWidth != r106.width()) goto L86;
        if (r112.outHeight != r106.height()) goto L86;
        tt5.a.h("ImageUtils", "getRoateAndCropBitmapFile，has Cahce");
        return r111;
    L86:
        Bitmap r113 = BitmapFactory.decodeFile(r210.getRealPath());     // Catch: Throwable -> L70
        if (r213 != 0.0f) goto L51;
        r100 = true;
    L51:
        if (r100 == false) goto L90;
        Matrix r114 = null;
    L56:
        Bitmap r115 = Bitmap.createBitmap(r113, r106.left, r106.top, r106.width(), r106.height(), r114, true);     // Catch: Throwable -> L53
    L67:
        th = th;
    L88:
        tt5.a.m("ImageUtils", th);     // Catch: Throwable -> L78
        if (r113 == null) goto L75;
        r113.recycle();
    L75:
        if (r115 == null) goto L77;
        r115.recycle();
    L77:
        return null;
    L78:
        th = move-exception;
        if (r113 == null) goto L82;
        r113.recycle();
    L82:
        if (r115 == null) goto L92;
        r115.recycle();
        throw th;
    L92:
        throw th;
    L58:
        if (d(r115, r211.getRealPath(), r109) == false) goto L60;
        tt5.a.k("ImageUtils", "getRoateAndCropBitmapFile... success");     // Catch: Throwable -> L67
    L62:
        if (r113 == null) goto L64;
        r113.recycle();
    L64:
        if (r115 == null) goto L66;
        r115.recycle();
    L66:
        return r111;
    L60:
        tt5.a.k("ImageUtils", "getRoateAndCropBitmapFile... saveBitmapToSD failed");     // Catch: Throwable -> L67
        r111 = null;
    L53:
        th = th;
        r115 = null;
        goto L88
    L90:
        Matrix r116 = new Matrix();     // Catch: Throwable -> L53
        r116.postRotate(r213);     // Catch: Throwable -> L53
        r114 = r116;
    L70:
        th = th;
        r115 = null;
        r113 = null;
        goto L88
    L36:
        if (r212.length != 4) goto L38;
        StringBuilder r117 = new StringBuilder();
        r117.append(d.a(r107 + r212[0] + r212[1] + r212[2] + r212[3] + r213));
        r117.append('.');
        r117.append(r110);
        r109 = r117.toString();
        goto L39
    L5:
        r101 = false;
        goto L7
    }
}
