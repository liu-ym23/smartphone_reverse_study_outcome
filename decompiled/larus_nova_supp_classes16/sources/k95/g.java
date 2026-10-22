package k95;

import com.bytedance.ee.bear.drive.view.preview.image.progressloader.decode.ImageWrapper;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements FlowableOnSubscribe<ImageWrapper<Object, Object>> {
    public final /* synthetic */ h a;

    public class a implements m95.a<Object, Object> {
        public final /* synthetic */ FlowableEmitter a;

        public a(FlowableEmitter r1) {
            this.a = r1;
        }

        public final void a(ImageWrapper<Object, Object> r3) {
            if (this.a.isCancelled() == true) goto L10;
            this.a.onNext(r3);
            if (r3.getType() == ImageWrapper.Type.DECODED) goto L7;
            return;
        L7:
            if (r3.a == false) goto L12;
            this.a.onComplete();
            return;
        L12:
            return;
        }
    }

    public g(h r1) {
        this.a = r1;
    }

    public final void subscribe(FlowableEmitter<ImageWrapper<Object, Object>> r17) throws Exception {
        InputStream r0 = this.a.a.b();     // Catch: Exception -> L89
        h r3 = this.a;
        Object r4 = r3.b;
        int r5 = r3.d;
        int r6 = r3.e;
        a r7 = new a(r17);
        m95.e r8 = (m95.e) r4;
        m95.c r9 = r8.d;
        m95.d r10 = new m95.d(r8, r7, r5, r6);
        r9.getClass();
        ByteArrayOutputStream r11 = new ByteArrayOutputStream(16384);
        BufferedInputStream r12 = new BufferedInputStream(r0);
    L98:
        boolean r13 = true;
        if (r9.a == 6) goto L74;
        int r1 = r12.read();     // Catch: Throwable -> L42 IOException -> L44
        if (r1 == (-1)) goto L74;
        r11.write(r1);     // Catch: Throwable -> L42 IOException -> L44
        int r14 = r9.a;     // Catch: Throwable -> L42 IOException -> L44
        if (r14 != 0) goto L12;
        if (r1 != 255) goto L71;
        r9.a = 1;     // Catch: Throwable -> L42 IOException -> L44
    L72:
        r9.b = r1;     // Catch: Throwable -> L42 IOException -> L44
        goto L98
    L71:
        r9.a = 6;     // Catch: Throwable -> L42 IOException -> L44
        goto L72
    L12:
        if (r14 == 1) goto L66;
        if (r14 != 2) goto L16;
        if (r1 != 255) goto L72;
        r9.a = 3;     // Catch: Throwable -> L42 IOException -> L44
        goto L72
    L16:
        if (r14 != 3) goto L18;
        if (r1 != 255) goto L37;
        r9.a = 3;     // Catch: Throwable -> L42 IOException -> L44
        goto L72
    L37:
        if (r1 != 0) goto L40;
        r9.a = 2;     // Catch: Throwable -> L42 IOException -> L44
        goto L72
    L40:
        if (r1 != 218) goto L46;
        r9.a(r11, false, r10);     // Catch: Throwable -> L42 IOException -> L44
    L48:
        if (r1 != 1) goto L51;
    L59:
        r13 = false;
    L60:
        if (r13 == false) goto L62;
        r9.a = 4;     // Catch: Throwable -> L42 IOException -> L44
        goto L72
    L62:
        r9.a = 2;     // Catch: Throwable -> L42 IOException -> L44
        goto L72
    L51:
        if (r1 >= 208) goto L53;
    L55:
        if (r1 == 217) goto L59;
        if (r1 == 216) goto L59;
    L53:
        if (r1 > 215) goto L55;
    L46:
        if (r1 != 217) goto L48;
        r9.a(r11, true, r10);     // Catch: Throwable -> L42 IOException -> L44
        goto L48
    L18:
        if (r14 == 4) goto L34;
        if (r14 != 5) goto L72;
        int r16 = ((r9.b << 8) + r1) - 2;     // Catch: Throwable -> L42 IOException -> L44
        byte[] r18 = new byte[16384];     // Catch: Throwable -> L42 IOException -> L44
        int r19 = 0;
    L23:
        if ((r16 - r19) <= 16384) goto L28;
        int r110 = r12.read(r18, 0, 16384);     // Catch: Throwable -> L42 IOException -> L44
        if (r110 == (-1)) goto L33;
        r11.write(r18, 0, r110);     // Catch: Throwable -> L42 IOException -> L44
        r19 = r19 + r110;     // Catch: Throwable -> L42 IOException -> L44
    L33:
        r9.a = 2;     // Catch: Throwable -> L42 IOException -> L44
    L28:
        if (r19 >= r16) goto L33;
        int r111 = r12.read(r18, 0, r16 - r19);     // Catch: Throwable -> L42 IOException -> L44
        if (r111 == (-1)) goto L33;
        r11.write(r18, 0, r111);     // Catch: Throwable -> L42 IOException -> L44
        r19 = r19 + r111;     // Catch: Throwable -> L42 IOException -> L44
        goto L28
    L34:
        r9.a = 5;     // Catch: Throwable -> L42 IOException -> L44
        goto L72
    L66:
        if (r1 != 216) goto L68;
        r9.a = 2;     // Catch: Throwable -> L42 IOException -> L44
        goto L72
    L68:
        r9.a = 6;     // Catch: Throwable -> L42 IOException -> L44
    L74:
        if (r9.a != 6) goto L103;
        byte[] r2 = new byte[16384];     // Catch: Throwable -> L42 IOException -> L44
    L76:
        int r112 = r12.read(r2, 0, 16384);     // Catch: Throwable -> L42 IOException -> L44
        if (r112 == (-1)) goto L79;
        r11.write(r2, 0, r112);     // Catch: Throwable -> L42 IOException -> L44
        goto L76
    L79:
        r9.a(r11, true, r10);     // Catch: Throwable -> L42 IOException -> L44
    L103:
        r12.close();     // Catch: IOException -> L94
        r11.close();     // Catch: IOException -> L94
    L85:
        r17.setCancellable(new f(this));
        return;
    L44:
        e = move-exception;
        tt5.a.h("ProgressiveImageLoader", "progressive decode error, e = " + e.getMessage());     // Catch: Throwable -> L42
        a r20 = (a) r10.a;     // Catch: Throwable -> L42
        if (r20.a.isCancelled() == true) goto L103;
        r20.a.onError(e);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        r12.close();     // Catch: IOException -> L95
        r11.close();     // Catch: IOException -> L95
    L88:
        throw th;
    L89:
        e = move-exception;
        if (r17.isCancelled() == true) goto L125;
        r17.onError(e);
        return;
    }
}
