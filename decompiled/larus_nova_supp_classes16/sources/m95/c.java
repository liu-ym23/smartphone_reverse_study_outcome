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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public int a;
    public int b;
    public int c;

    public c() {
        this.b = 0;
        this.c = 0;
        this.a = 0;
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
    public final void a(ByteArrayOutputStream r20, boolean r21, d r22) {
        byte[] r1 = this;
        int r0 = r1.c;
        r1.c = r0 + 1;
        if (r21 == true) goto L5;
        if (r0 > 0) goto L5;
        return;
    L5:
        byte[] r2 = r20.toByteArray();
        if (r21 == true) goto L8;
        int r7 = r2.length;
        byte[] r8 = new byte[r7];
        int r9 = r7 - 2;
        System.arraycopy(r2, 0, r8, 0, r9);
        System.arraycopy(new byte[]{-1, -39}, 0, r8, r9, 2);
        r2 = r8;
    L8:
        ((g.a) r22.a).a(new ImageWrapper(null, new o95.b(r2), ImageWrapper.Type.ENCODED, r21));
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.decode.a.C0179a r6 = r22.d.a;
        ByteArrayInputStream r10 = new ByteArrayInputStream(r2);
        e r3 = r22.d;
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.b r11 = r3.b;
        int r12 = r22.b;
        int r13 = r22.c;
        DecodeFormat r16 = r3.c;
        r6.getClass();
        q95.a r14 = q95.a.b;
        r1 = r14.a();
        byte[] r17 = r14.a();
        monitor-enter(com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.decode.a.class);
        Queue<BitmapFactory.Options> r18 = com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.decode.a.b;     // Catch: Throwable -> L106
        monitor-enter(r18);     // Catch: Throwable -> L106
        BitmapFactory.Options r4 = (BitmapFactory.Options) ((ArrayDeque) r18).poll();     // Catch: Throwable -> L103
        monitor-exit(r18);     // Catch: Throwable -> L103
    L15:
        if (r4 != null) goto L17;
        r4 = new BitmapFactory.Options();     // Catch: Throwable -> L106
        r4.inTempStorage = null;     // Catch: Throwable -> L106
        r4.inDither = false;     // Catch: Throwable -> L106
        r4.inScaled = false;     // Catch: Throwable -> L106
        r4.inSampleSize = 1;     // Catch: Throwable -> L106
        r4.inPreferredConfig = null;     // Catch: Throwable -> L106
        r4.inJustDecodeBounds = false;     // Catch: Throwable -> L106
        r4.outWidth = 0;     // Catch: Throwable -> L106
        r4.outHeight = 0;     // Catch: Throwable -> L106
        r4.outMimeType = null;     // Catch: Throwable -> L106
        r4.inBitmap = null;     // Catch: Throwable -> L106
        r4.inMutable = true;     // Catch: Throwable -> L106
    L17:
        BitmapFactory.Options r19 = r4;
        monitor-exit(com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.decode.a.class);
        RecyclableBufferedInputStream r110 = new RecyclableBufferedInputStream(r10, r17);
        q95.c r23 = q95.c.a(r110);
        r17 = new q95.d(r23);
        r23.mark(5242880);     // Catch: Throwable -> L34
        int r111 = new ImageHeaderParser(r23).a();     // Catch: Throwable -> L28 IOException -> L30
        r23.reset();     // Catch: IOException -> L24 Throwable -> L34
    L27:
        int r5 = r111;
    L40:
        r19.inTempStorage = r1;     // Catch: Throwable -> L34
        r19.inJustDecodeBounds = true;     // Catch: Throwable -> L34
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.decode.a.a(r17, r110, r19);     // Catch: Throwable -> L34
        r19.inJustDecodeBounds = false;     // Catch: Throwable -> L34
        int r24 = r19.outWidth;     // Catch: Throwable -> L34
        int r26 = r19.outHeight;     // Catch: Throwable -> L34
        switch(r5) {
            case 3: goto L46;
            case 4: goto L46;
            case 5: goto L45;
            case 6: goto L45;
            case 7: goto L44;
            case 8: goto L44;
            default: goto L43;
        };
    L43:
        char r112 = 0;
    L48:
        if (r13 != Integer.MIN_VALUE) goto L50;
        r13 = r26;
    L50:
        if (r12 != Integer.MIN_VALUE) goto L117;
        r12 = r24;
    L117:
        if (r112 != 'Z') goto L55;
    L58:
        int r27 = Math.min(r24 / r13, r26 / r12);     // Catch: Throwable -> L89
    L59:
        if (r27 != 0) goto L61;
        int r28 = 0;
    L62:
        r17 = r17;
        Bitmap r29 = com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.decode.a.b(r17, r110, r19, r11, r24, r26, Math.max(1, r28), r16);     // Catch: Throwable -> L87
        IOException r30 = r23.b;     // Catch: Throwable -> L87
        if (r30 != null) goto L86;
        if (r29 == null) goto L73;
        Bitmap r31 = l95.a.a(r29, r11, r5);     // Catch: Throwable -> L87
        if (r29.equals(r31) == false) goto L70;
    L74:
        r14.b(r1);
        r14.b(r17);
        r23.b();
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.decode.a.c(r19);
        if (r31 != null) goto L77;
        tt5.a.h("ProgressiveImageLoader", "progressive decode bitmap is null");
    L78:
        a r32 = r22.a;
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.b r33 = r22.d.b;
        if (r31 != null) goto L81;
        o95.a r34 = null;
    L82:
        ((g.a) r32).a(new ImageWrapper(r34, null, ImageWrapper.Type.DECODED, r21));
        return;
    L81:
        r34 = new o95.a(r31, r33);
        goto L82
    L77:
        tt5.a.h("ProgressiveImageLoader", String.format("progressive decode success, bitmap = %s, isLast = %s", new Object[]{r31.toString(), String.valueOf(r21)}));
        goto L78
    L70:
        if (r11.put(r29) == true) goto L74;
        r29.recycle();     // Catch: Throwable -> L87
        goto L74
    L73:
        r31 = null;
        goto L74
    L86:
        throw new RuntimeException(r30);     // Catch: Throwable -> L95
    L87:
        th = th;
        r1 = r1;
    L101:
        r14.b(r1);
        r14.b(r17);
        r23.b();
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.decode.a.c(r19);
        throw th;
    L61:
        r28 = Integer.highestOneBit(r27);     // Catch: Throwable -> L89
        goto L62
    L55:
        if (r112 == 270) goto L58;
        r27 = Math.min(r26 / r13, r24 / r12);     // Catch: Throwable -> L89
    L89:
        th = th;
        r17 = r17;
        r1 = r1;
        goto L101
    L44:
        r112 = 270;
        goto L48
    L45:
        r112 = 'Z';
        goto L48
    L46:
        r112 = 180;
        goto L48
    L24:
        e = move-exception;
        tt5.a.l("Downsampler", "Cannot reset the input stream", e);     // Catch: Throwable -> L34
        goto L27
    L30:
        e = move-exception;
        tt5.a.l("Downsampler", "Cannot determine the image orientation from header", e);     // Catch: Throwable -> L91
        r23.reset();     // Catch: Throwable -> L34 IOException -> L36
    L39:
        r5 = 0;
        goto L40
    L36:
        e = move-exception;
        tt5.a.l("Downsampler", "Cannot reset the input stream", e);     // Catch: Throwable -> L34
    L91:
        th = move-exception;
        Throwable r36 = th;
    L109:
        r23.reset();     // Catch: Throwable -> L95 IOException -> L97
    L129:
        throw r36;     // Catch: Throwable -> L95
    L97:
        e = move-exception;
        tt5.a.l("Downsampler", "Cannot reset the input stream", e);     // Catch: Throwable -> L95
        throw r36;     // Catch: Throwable -> L95
    L28:
        th = move-exception;
        r36 = th;
    L95:
        th = th;
    L34:
        th = th;
        r17 = r17;
        r1 = r1;
    L103:
        th = move-exception;
        throw th;     // Catch: Throwable -> L106
    L106:
        th = move-exception;
        throw th;
    }
}
