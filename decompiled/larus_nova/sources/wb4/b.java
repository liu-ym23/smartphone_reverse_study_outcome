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

/* JADX INFO: loaded from: classes14.dex */
public final class b implements ImageReader.OnImageAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f558933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f558934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f558935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f558936d;

    public final void c() {
        c r100 = this.f558935c;
        if (r100 == null) goto L8;
        r100.f558938w = null;
        r100.f558940y.set(true);
        r100.f558939x.set(true);
        ArrayBlockingQueue<f> r101 = r100.f558937v;
        if (r101 == null) goto L7;
        r101.clear();
    L7:
        r100.interrupt();
        this.f558935c = null;
    L8:
        this.f558933a = null;
    }

    public static byte[] a(Image r110) {
        int r100 = r110.getFormat();
        int r101 = 1;
        if (r100 != 17) goto L5;
    L9:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L41;
        Rect r103 = r110.getCropRect();
        int r104 = r110.getFormat();
        int r105 = r103.width();
        int r106 = r103.height();
        Image.Plane[] r107 = r110.getPlanes();
        int r108 = r105 * r106;
        byte[] r109 = new byte[(ImageFormat.getBitsPerPixel(r104) * r108) / 8];
        byte[] r111 = new byte[r107[0].getRowStride()];
        int r112 = 0;
        int r113 = 0;
    L13:
        if (r112 >= r107.length) goto L39;
        if (r112 == 0) goto L21;
        if (r112 != r101) goto L17;
        r113 = r108;
    L22:
        ByteBuffer r114 = r107[r112].getBuffer();
        int r115 = r107[r112].getRowStride();
        int r116 = r107[r112].getPixelStride();
        if (r112 != 0) goto L25;
        int r117 = 0;
    L26:
        int r118 = r105 >> r117;
        int r119 = r106 >> r117;
        int r120 = r105;
        r114.position(((r103.top >> r117) * r115) + ((r103.left >> r117) * r116));
        int r121 = 0;
    L27:
        if (r121 >= r119) goto L38;
        if (r116 != 1) goto L31;
        r114.get(r109, r113, r118);
        r113 = r113 + r118;
        int r122 = r118;
    L35:
        if (r121 >= (r119 - 1)) goto L37;
        r114.position((r114.position() + r115) - r122);
    L37:
        r121 = r121 + 1;
        goto L27
    L31:
        r122 = ((r118 - 1) * r116) + 1;
        int r123 = 0;
        r114.get(r111, 0, r122);
    L32:
        if (r123 >= r118) goto L35;
        r109[r113] = r111[r123 * r116];
        r113 = r113 + 1;
        r123 = r123 + 1;
        goto L32
    L38:
        r112 = r112 + 1;
        r105 = r120;
        r101 = 1;
        goto L13
    L25:
        r117 = 1;
        goto L26
    L17:
        if (r112 != 2) goto L22;
        r113 = (int) (((double) r108) * 1.25d);
        goto L22
    L21:
        r113 = 0;
        goto L22
    L39:
        return r109;
    L41:
        throw new RuntimeException("can't convert Image to byte array, format " + r110.getFormat());
    L5:
        if (r100 == 35) goto L9;
        if (r100 == 842094169) goto L9;
        r102 = false;
        goto L10
    }

    public final void b(f r100) {
        c r101 = this.f558935c;
        if (r101 != null) goto L5;
        c r102 = new c(this.f558933a);
        this.f558935c = r102;
        r102.m(r100);
        ThreadMethodProxy.start(this.f558935c);
        return;
    L5:
        r101.m(r100);
    }

    @Override // android.media.ImageReader.OnImageAvailableListener
    public final void onImageAvailable(ImageReader r100) {
        Image r101 = null;
        r101 = r100.acquireNextImage();     // Catch: Exception -> L28 Throwable -> L37
        if (this.f558936d == true) goto L18;
        StringBuilder r102 = new StringBuilder("image_width:");     // Catch: Exception -> L28 Throwable -> L37
        if (r101 == null) goto L8;
        Object r103 = Integer.valueOf(r101.getWidth());     // Catch: Exception -> L28 Throwable -> L37
    L9:
        r102.append(r103);     // Catch: Exception -> L28 Throwable -> L37
        r102.append(";image_height:");     // Catch: Exception -> L28 Throwable -> L37
        if (r101 == null) goto L12;
        Object r104 = Integer.valueOf(r101.getHeight());     // Catch: Exception -> L28 Throwable -> L37
    L13:
        r102.append(r104);     // Catch: Exception -> L28 Throwable -> L37
        r102.append(";image_format:");     // Catch: Exception -> L28 Throwable -> L37
        if (r101 == null) goto L16;
        Object r105 = Integer.valueOf(r101.getFormat());     // Catch: Exception -> L28 Throwable -> L37
    L17:
        r102.append(r105);     // Catch: Exception -> L28 Throwable -> L37
        e.b().c("onImageAvailable", r102.toString());     // Catch: Exception -> L28 Throwable -> L37
        this.f558936d = true;     // Catch: Exception -> L28 Throwable -> L37
        goto L18
    L16:
        r105 = "0";
        goto L17
    L12:
        r104 = "0";
        goto L13
    L8:
        r103 = "0";
    L18:
        int r106 = r101.getWidth();     // Catch: Exception -> L28 Throwable -> L37
        int r107 = r101.getHeight();     // Catch: Exception -> L28 Throwable -> L37
        byte[] r108 = a(r101);     // Catch: Exception -> L28 Throwable -> L37
        if (r108.length <= 0) goto L40;
        g r109 = this.f558934b;     // Catch: Exception -> L28 Throwable -> L37
        monitor-enter(r109);     // Catch: Exception -> L28 Throwable -> L37
        int r110 = r109.f558954d;     // Catch: Throwable -> L25
        monitor-exit(r109);     // Catch: Exception -> L28 Throwable -> L37
        b(new f(r106, r107, r108, r110));     // Catch: Exception -> L28 Throwable -> L37
    L25:
        th = move-exception;
        throw th;     // Catch: Exception -> L28 Throwable -> L37
    L40:
        r101.close();
        return;
    L28:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L37
        a r111 = this.f558933a;     // Catch: Throwable -> L37
        if (r111 == null) goto L39;
        LiveDetectView r112 = (LiveDetectView) r111;     // Catch: Throwable -> L37
        if (r112.f201971f == null) goto L39;
        Handler r113 = r112.f201968c;     // Catch: Throwable -> L37
        if (r113 == null) goto L39;
        r113.post(new com.bytedance.bdturing.livedetect.view.b(r112, 40003, e));     // Catch: Throwable -> L37
    L39:
        if (0 != 0) goto L40;
        return;
    L37:
        th = move-exception;
        if (0 == 0) goto L44;
        r101.close();
    L44:
        throw th;
    }

    public b(a r100, g r101) {
        this.f558936d = false;
        this.f558933a = r100;
        this.f558934b = r101;
    }
}
