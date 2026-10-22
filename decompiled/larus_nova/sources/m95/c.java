package m95;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.decode.DecodeFormat;
import com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.decode.ImageHeaderParser;
import com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.decode.RecyclableBufferedInputStream;
import com.bytedance.ee.bear.drive.view.preview.image.progressloader.decode.ImageWrapper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import k95.g;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* JADX INFO: loaded from: classes16.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f512641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f512642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f512643c;

    public c() {
        this.f512642b = 0;
        this.f512643c = 0;
        this.f512641a = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r14v0, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r1v0, types: [m95.c] */
    /* JADX WARN: Type inference failed for: r5v1, types: [q95.d] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a(ByteArrayOutputStream r210, boolean r211, d r212) {
        byte[] r100 = this;
        int r101 = r100.f512643c;
        r100.f512643c = r101 + 1;
        if (r211 == true) goto L5;
        if (r101 > 0) goto L5;
        return;
    L5:
        byte[] r102 = r210.toByteArray();
        if (r211 == true) goto L8;
        int r103 = r102.length;
        byte[] r104 = new byte[r103];
        int r105 = r103 - 2;
        System.arraycopy(r102, 0, r104, 0, r105);
        System.arraycopy(new byte[]{-1, -39}, 0, r104, r105, 2);
        r102 = r104;
    L8:
        ((g.a) r212.f512644a).a(new ImageWrapper(null, new o95.b(r102), ImageWrapper.Type.ENCODED, r211));
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.decode.a.C3235a r106 = r212.f512647d.f512648a;
        ByteArrayInputStream r107 = new ByteArrayInputStream(r102);
        e r108 = r212.f512647d;
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.b r109 = r108.f512649b;
        int r110 = r212.f512645b;
        int r111 = r212.f512646c;
        DecodeFormat r112 = r108.f512650c;
        r106.getClass();
        q95.a r113 = q95.a.f532098b;
        r100 = r113.a();
        byte[] r114 = r113.a();
        monitor-enter(com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.decode.a.class);
        Queue<BitmapFactory.Options> r115 = com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.decode.a.f224974b;     // Catch: Throwable -> L106
        monitor-enter(r115);     // Catch: Throwable -> L106
        BitmapFactory.Options r116 = (BitmapFactory.Options) ((ArrayDeque) r115).poll();     // Catch: Throwable -> L103
        monitor-exit(r115);     // Catch: Throwable -> L103
    L15:
        if (r116 != null) goto L17;
        r116 = new BitmapFactory.Options();     // Catch: Throwable -> L106
        r116.inTempStorage = null;     // Catch: Throwable -> L106
        r116.inDither = false;     // Catch: Throwable -> L106
        r116.inScaled = false;     // Catch: Throwable -> L106
        r116.inSampleSize = 1;     // Catch: Throwable -> L106
        r116.inPreferredConfig = null;     // Catch: Throwable -> L106
        r116.inJustDecodeBounds = false;     // Catch: Throwable -> L106
        r116.outWidth = 0;     // Catch: Throwable -> L106
        r116.outHeight = 0;     // Catch: Throwable -> L106
        r116.outMimeType = null;     // Catch: Throwable -> L106
        r116.inBitmap = null;     // Catch: Throwable -> L106
        r116.inMutable = true;     // Catch: Throwable -> L106
    L17:
        BitmapFactory.Options r117 = r116;
        monitor-exit(com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.decode.a.class);
        RecyclableBufferedInputStream r118 = new RecyclableBufferedInputStream(r107, r114);
        q95.c r119 = q95.c.a(r118);
        r114 = new q95.d(r119);
        r119.mark(5242880);     // Catch: Throwable -> L34
        int r120 = new ImageHeaderParser(r119).a();     // Catch: Throwable -> L28 IOException -> L30
        r119.reset();     // Catch: IOException -> L24 Throwable -> L34
    L27:
        int r121 = r120;
    L40:
        r117.inTempStorage = r100;     // Catch: Throwable -> L34
        r117.inJustDecodeBounds = true;     // Catch: Throwable -> L34
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.decode.a.a(r114, r118, r117);     // Catch: Throwable -> L34
        r117.inJustDecodeBounds = false;     // Catch: Throwable -> L34
        int r122 = r117.outWidth;     // Catch: Throwable -> L34
        int r123 = r117.outHeight;     // Catch: Throwable -> L34
        switch(r121) {
            case 3: goto L46;
            case 4: goto L46;
            case 5: goto L45;
            case 6: goto L45;
            case 7: goto L44;
            case 8: goto L44;
            default: goto L43;
        };
    L43:
        char r124 = 0;
    L48:
        if (r111 != Integer.MIN_VALUE) goto L50;
        r111 = r123;
    L50:
        if (r110 != Integer.MIN_VALUE) goto L117;
        r110 = r122;
    L117:
        if (r124 != 'Z') goto L55;
    L58:
        int r125 = Math.min(r122 / r111, r123 / r110);     // Catch: Throwable -> L89
    L59:
        if (r125 != 0) goto L61;
        int r126 = 0;
    L62:
        r114 = r114;
        Bitmap r127 = com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.decode.a.b(r114, r118, r117, r109, r122, r123, Math.max(1, r126), r112);     // Catch: Throwable -> L87
        IOException r128 = r119.f532104b;     // Catch: Throwable -> L87
        if (r128 != null) goto L86;
        if (r127 == null) goto L73;
        Bitmap r129 = l95.a.a(r127, r109, r121);     // Catch: Throwable -> L87
        if (r127.equals(r129) == false) goto L70;
    L74:
        r113.b(r100);
        r113.b(r114);
        r119.b();
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.decode.a.c(r117);
        if (r129 != null) goto L77;
        tt5.a.h("ProgressiveImageLoader", "progressive decode bitmap is null");
    L78:
        a r130 = r212.f512644a;
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.b r131 = r212.f512647d.f512649b;
        if (r129 != null) goto L81;
        o95.a r132 = null;
    L82:
        ((g.a) r130).a(new ImageWrapper(r132, null, ImageWrapper.Type.DECODED, r211));
        return;
    L81:
        r132 = new o95.a(r129, r131);
        goto L82
    L77:
        tt5.a.h("ProgressiveImageLoader", String.format("progressive decode success, bitmap = %s, isLast = %s", new Object[]{r129.toString(), String.valueOf(r211)}));
        goto L78
    L70:
        if (r109.put(r127) == true) goto L74;
        r127.recycle();     // Catch: Throwable -> L87
        goto L74
    L73:
        r129 = null;
        goto L74
    L86:
        throw new RuntimeException(r128);     // Catch: Throwable -> L95
    L87:
        th = th;
        r100 = r100;
    L101:
        r113.b(r100);
        r113.b(r114);
        r119.b();
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.decode.a.c(r117);
        throw th;
    L61:
        r126 = Integer.highestOneBit(r125);     // Catch: Throwable -> L89
        goto L62
    L55:
        if (r124 == 270) goto L58;
        r125 = Math.min(r123 / r111, r122 / r110);     // Catch: Throwable -> L89
    L89:
        th = th;
        r114 = r114;
        r100 = r100;
        goto L101
    L44:
        r124 = 270;
        goto L48
    L45:
        r124 = Matrix.MATRIX_TYPE_ZERO;
        goto L48
    L46:
        r124 = 180;
        goto L48
    L24:
        e = move-exception;
        tt5.a.l("Downsampler", "Cannot reset the input stream", e);     // Catch: Throwable -> L34
        goto L27
    L30:
        e = move-exception;
        tt5.a.l("Downsampler", "Cannot determine the image orientation from header", e);     // Catch: Throwable -> L91
        r119.reset();     // Catch: Throwable -> L34 IOException -> L36
    L39:
        r121 = 0;
        goto L40
    L36:
        e = move-exception;
        tt5.a.l("Downsampler", "Cannot reset the input stream", e);     // Catch: Throwable -> L34
    L91:
        th = move-exception;
        Throwable r133 = th;
    L109:
        r119.reset();     // Catch: Throwable -> L95 IOException -> L97
    L129:
        throw r133;     // Catch: Throwable -> L95
    L97:
        e = move-exception;
        tt5.a.l("Downsampler", "Cannot reset the input stream", e);     // Catch: Throwable -> L95
        throw r133;     // Catch: Throwable -> L95
    L28:
        th = move-exception;
        r133 = th;
    L95:
        th = th;
    L34:
        th = th;
        r114 = r114;
        r100 = r100;
    L103:
        th = move-exception;
        throw th;     // Catch: Throwable -> L106
    L106:
        th = move-exception;
        throw th;
    }
}
