package k95;

import com.bytedance.ee.bear.drive.view.preview.image.progressloader.decode.ImageWrapper;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes16.dex */
public final class g implements FlowableOnSubscribe<ImageWrapper<Object, Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f502146a;

    public class a implements m95.a<Object, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowableEmitter f502147a;

        public a(FlowableEmitter r100) {
            this.f502147a = r100;
        }

        public final void a(ImageWrapper<Object, Object> r100) {
            if (this.f502147a.isCancelled() == true) goto L10;
            this.f502147a.onNext(r100);
            if (r100.getType() == ImageWrapper.Type.DECODED) goto L7;
            return;
        L7:
            if (r100.f224976a == false) goto L12;
            this.f502147a.onComplete();
            return;
        L12:
            return;
        }
    }

    public g(h r100) {
        this.f502146a = r100;
    }

    @Override // io.reactivex.FlowableOnSubscribe
    public final void subscribe(FlowableEmitter<ImageWrapper<Object, Object>> r110) throws Exception {
        InputStream r100 = this.f502146a.f502148a.b();     // Catch: Exception -> L89
        h r101 = this.f502146a;
        Object r102 = r101.f502149b;
        int r103 = r101.f502151d;
        int r104 = r101.f502152e;
        a r105 = new a(r110);
        m95.e r106 = (m95.e) r102;
        m95.c r107 = r106.f512651d;
        m95.d r108 = new m95.d(r106, r105, r103, r104);
        r107.getClass();
        ByteArrayOutputStream r109 = new ByteArrayOutputStream(16384);
        BufferedInputStream r111 = new BufferedInputStream(r100);
    L98:
        boolean r112 = true;
        if (r107.f512641a == 6) goto L74;
        int r113 = r111.read();     // Catch: Throwable -> L42 IOException -> L44
        if (r113 == (-1)) goto L74;
        r109.write(r113);     // Catch: Throwable -> L42 IOException -> L44
        int r114 = r107.f512641a;     // Catch: Throwable -> L42 IOException -> L44
        if (r114 != 0) goto L12;
        if (r113 != 255) goto L71;
        r107.f512641a = 1;     // Catch: Throwable -> L42 IOException -> L44
    L72:
        r107.f512642b = r113;     // Catch: Throwable -> L42 IOException -> L44
        goto L98
    L71:
        r107.f512641a = 6;     // Catch: Throwable -> L42 IOException -> L44
        goto L72
    L12:
        if (r114 == 1) goto L66;
        if (r114 != 2) goto L16;
        if (r113 != 255) goto L72;
        r107.f512641a = 3;     // Catch: Throwable -> L42 IOException -> L44
        goto L72
    L16:
        if (r114 != 3) goto L18;
        if (r113 != 255) goto L37;
        r107.f512641a = 3;     // Catch: Throwable -> L42 IOException -> L44
        goto L72
    L37:
        if (r113 != 0) goto L40;
        r107.f512641a = 2;     // Catch: Throwable -> L42 IOException -> L44
        goto L72
    L40:
        if (r113 != 218) goto L46;
        r107.a(r109, false, r108);     // Catch: Throwable -> L42 IOException -> L44
    L48:
        if (r113 != 1) goto L51;
    L59:
        r112 = false;
    L60:
        if (r112 == false) goto L62;
        r107.f512641a = 4;     // Catch: Throwable -> L42 IOException -> L44
        goto L72
    L62:
        r107.f512641a = 2;     // Catch: Throwable -> L42 IOException -> L44
        goto L72
    L51:
        if (r113 >= 208) goto L53;
    L55:
        if (r113 == 217) goto L59;
        if (r113 == 216) goto L59;
    L53:
        if (r113 > 215) goto L55;
    L46:
        if (r113 != 217) goto L48;
        r107.a(r109, true, r108);     // Catch: Throwable -> L42 IOException -> L44
        goto L48
    L18:
        if (r114 == 4) goto L34;
        if (r114 != 5) goto L72;
        int r115 = ((r107.f512642b << 8) + r113) - 2;     // Catch: Throwable -> L42 IOException -> L44
        byte[] r116 = new byte[16384];     // Catch: Throwable -> L42 IOException -> L44
        int r117 = 0;
    L23:
        if ((r115 - r117) <= 16384) goto L28;
        int r118 = r111.read(r116, 0, 16384);     // Catch: Throwable -> L42 IOException -> L44
        if (r118 == (-1)) goto L33;
        r109.write(r116, 0, r118);     // Catch: Throwable -> L42 IOException -> L44
        r117 = r117 + r118;     // Catch: Throwable -> L42 IOException -> L44
    L33:
        r107.f512641a = 2;     // Catch: Throwable -> L42 IOException -> L44
    L28:
        if (r117 >= r115) goto L33;
        int r119 = r111.read(r116, 0, r115 - r117);     // Catch: Throwable -> L42 IOException -> L44
        if (r119 == (-1)) goto L33;
        r109.write(r116, 0, r119);     // Catch: Throwable -> L42 IOException -> L44
        r117 = r117 + r119;     // Catch: Throwable -> L42 IOException -> L44
        goto L28
    L34:
        r107.f512641a = 5;     // Catch: Throwable -> L42 IOException -> L44
        goto L72
    L66:
        if (r113 != 216) goto L68;
        r107.f512641a = 2;     // Catch: Throwable -> L42 IOException -> L44
        goto L72
    L68:
        r107.f512641a = 6;     // Catch: Throwable -> L42 IOException -> L44
    L74:
        if (r107.f512641a != 6) goto L103;
        byte[] r120 = new byte[16384];     // Catch: Throwable -> L42 IOException -> L44
    L76:
        int r121 = r111.read(r120, 0, 16384);     // Catch: Throwable -> L42 IOException -> L44
        if (r121 == (-1)) goto L79;
        r109.write(r120, 0, r121);     // Catch: Throwable -> L42 IOException -> L44
        goto L76
    L79:
        r107.a(r109, true, r108);     // Catch: Throwable -> L42 IOException -> L44
    L103:
        r111.close();     // Catch: IOException -> L94
        r109.close();     // Catch: IOException -> L94
    L85:
        r110.setCancellable(new f(this));
        return;
    L44:
        e = move-exception;
        tt5.a.h("ProgressiveImageLoader", "progressive decode error, e = " + e.getMessage());     // Catch: Throwable -> L42
        a r122 = (a) r108.f512644a;     // Catch: Throwable -> L42
        if (r122.f502147a.isCancelled() == true) goto L103;
        r122.f502147a.onError(e);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        r111.close();     // Catch: IOException -> L95
        r109.close();     // Catch: IOException -> L95
    L88:
        throw th;
    L89:
        e = move-exception;
        if (r110.isCancelled() == true) goto L125;
        r110.onError(e);
        return;
    }
}
