package wb4;

import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import com.bytedance.bdturing.livedetect.view.LiveDetectView;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.nio.ByteBuffer;
import java.util.concurrent.ArrayBlockingQueue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements ImageReader.OnImageAvailableListener {
    public a a;
    public final g b;
    public c c;
    public boolean d;

    public final void c() {
        c r0 = this.c;
        if (r0 == null) goto L8;
        r0.w = null;
        r0.y.set(true);
        r0.x.set(true);
        ArrayBlockingQueue<f> r2 = r0.v;
        if (r2 == null) goto L7;
        r2.clear();
    L7:
        r0.interrupt();
        this.c = null;
    L8:
        this.a = null;
    }

    public static byte[] a(Image r18) {
        int r0 = r18.getFormat();
        int r3 = 1;
        if (r0 != 17) goto L5;
    L9:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L41;
        Rect r2 = r18.getCropRect();
        int r4 = r18.getFormat();
        int r5 = r2.width();
        int r6 = r2.height();
        Image.Plane[] r7 = r18.getPlanes();
        int r8 = r5 * r6;
        byte[] r9 = new byte[(ImageFormat.getBitsPerPixel(r4) * r8) / 8];
        byte[] r10 = new byte[r7[0].getRowStride()];
        int r11 = 0;
        int r12 = 0;
    L13:
        if (r11 >= r7.length) goto L39;
        if (r11 == 0) goto L21;
        if (r11 != r3) goto L17;
        r12 = r8;
    L22:
        ByteBuffer r13 = r7[r11].getBuffer();
        int r14 = r7[r11].getRowStride();
        int r15 = r7[r11].getPixelStride();
        if (r11 != 0) goto L25;
        int r16 = 0;
    L26:
        int r17 = r5 >> r16;
        int r19 = r6 >> r16;
        int r110 = r5;
        r13.position(((r2.top >> r16) * r14) + ((r2.left >> r16) * r15));
        int r20 = 0;
    L27:
        if (r20 >= r19) goto L38;
        if (r15 != 1) goto L31;
        r13.get(r9, r12, r17);
        r12 = r12 + r17;
        int r111 = r17;
    L35:
        if (r20 >= (r19 - 1)) goto L37;
        r13.position((r13.position() + r14) - r111);
    L37:
        r20 = r20 + 1;
        goto L27
    L31:
        r111 = ((r17 - 1) * r15) + 1;
        int r21 = 0;
        r13.get(r10, 0, r111);
    L32:
        if (r21 >= r17) goto L35;
        r9[r12] = r10[r21 * r15];
        r12 = r12 + 1;
        r21 = r21 + 1;
        goto L32
    L38:
        r11 = r11 + 1;
        r5 = r110;
        r3 = 1;
        goto L13
    L25:
        r16 = 1;
        goto L26
    L17:
        if (r11 != 2) goto L22;
        r12 = (int) (((double) r8) * 1.25d);
        goto L22
    L21:
        r12 = 0;
        goto L22
    L39:
        return r9;
    L41:
        throw new RuntimeException("can't convert Image to byte array, format " + r18.getFormat());
    L5:
        if (r0 == 35) goto L9;
        if (r0 == 842094169) goto L9;
        r1 = false;
        goto L10
    }

    public final void b(f r3) {
        c r0 = this.c;
        if (r0 != null) goto L5;
        c r1 = new c(this.a);
        this.c = r1;
        r1.m(r3);
        ThreadMethodProxy.start(this.c);
        return;
    L5:
        r0.m(r3);
    }

    @Override // android.media.ImageReader.OnImageAvailableListener
    public final void onImageAvailable(ImageReader r7) {
        Image r1 = null;
        r1 = r7.acquireNextImage();     // Catch: Exception -> L28 Throwable -> L37
        if (this.d == true) goto L18;
        StringBuilder r8 = new StringBuilder("image_width:");     // Catch: Exception -> L28 Throwable -> L37
        if (r1 == null) goto L8;
        Object r0 = Integer.valueOf(r1.getWidth());     // Catch: Exception -> L28 Throwable -> L37
    L9:
        r8.append(r0);     // Catch: Exception -> L28 Throwable -> L37
        r8.append(";image_height:");     // Catch: Exception -> L28 Throwable -> L37
        if (r1 == null) goto L12;
        Object r2 = Integer.valueOf(r1.getHeight());     // Catch: Exception -> L28 Throwable -> L37
    L13:
        r8.append(r2);     // Catch: Exception -> L28 Throwable -> L37
        r8.append(";image_format:");     // Catch: Exception -> L28 Throwable -> L37
        if (r1 == null) goto L16;
        Object r3 = Integer.valueOf(r1.getFormat());     // Catch: Exception -> L28 Throwable -> L37
    L17:
        r8.append(r3);     // Catch: Exception -> L28 Throwable -> L37
        e.b().c("onImageAvailable", r8.toString());     // Catch: Exception -> L28 Throwable -> L37
        this.d = true;     // Catch: Exception -> L28 Throwable -> L37
        goto L18
    L16:
        r3 = "0";
        goto L17
    L12:
        r2 = "0";
        goto L13
    L8:
        r0 = "0";
    L18:
        int r9 = r1.getWidth();     // Catch: Exception -> L28 Throwable -> L37
        int r4 = r1.getHeight();     // Catch: Exception -> L28 Throwable -> L37
        byte[] r5 = a(r1);     // Catch: Exception -> L28 Throwable -> L37
        if (r5.length <= 0) goto L40;
        g r6 = this.b;     // Catch: Exception -> L28 Throwable -> L37
        monitor-enter(r6);     // Catch: Exception -> L28 Throwable -> L37
        int r10 = r6.d;     // Catch: Throwable -> L25
        monitor-exit(r6);     // Catch: Exception -> L28 Throwable -> L37
        b(new f(r9, r4, r5, r10));     // Catch: Exception -> L28 Throwable -> L37
    L25:
        th = move-exception;
        throw th;     // Catch: Exception -> L28 Throwable -> L37
    L40:
        r1.close();
        return;
    L28:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L37
        a r11 = this.a;     // Catch: Throwable -> L37
        if (r11 == null) goto L39;
        LiveDetectView r12 = (LiveDetectView) r11;     // Catch: Throwable -> L37
        if (r12.f == null) goto L39;
        Handler r13 = r12.c;     // Catch: Throwable -> L37
        if (r13 == null) goto L39;
        r13.post(new com.bytedance.bdturing.livedetect.view.b(r12, 40003, e));     // Catch: Throwable -> L37
    L39:
        if (0 != 0) goto L40;
        return;
    L37:
        th = move-exception;
        if (0 == 0) goto L44;
        r1.close();
    L44:
        throw th;
    }

    public b(a r2, g r3) {
        this.d = false;
        this.a = r2;
        this.b = r3;
    }
}
