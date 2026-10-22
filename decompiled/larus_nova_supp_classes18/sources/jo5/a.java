package jo5;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Response;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class a implements g {
    public a() {
    }

    public InputStream b(e r13) throws IOException {
        Response r0 = r13.b;
        int r1 = r0.code();
        ThumbGlideUrl r2 = r13.a;
        byte[] r4 = null;
        if ((r1 / 100) != 3) goto L17;
        tt5.a.h("AbsDefaultImgFileProvider", "statusCode=" + r1 + ", use cache， need not decrypt");
        String r14 = r2.getEncryptCacheKey();
        if (TextUtils.isEmpty(r14) == true) goto L10;
        aw4.a r3 = (aw4.a) org.koin.java.a.a(aw4.a.class);
        if (r3 == null) goto L10;
        r4 = (byte[]) r3.get(r14);
    L10:
        if (r4 != null) goto L12;
    L13:
        ho5.c.d().h(r2.getUrl(), r2.getVersion());
    L15:
        return new ByteArrayInputStream(r4);
    L12:
        if (r4.length != 0) goto L15;
    L17:
        if (r0.body() != null) goto L20;
        tt5.a.d("AbsDefaultImgFileProvider", "response.body() == null");
        return null;
    L20:
        byte[] r5 = r0.body().bytes();
        boolean r7 = true;
        if (r13.g == false) goto L33;
        int r6 = r2.getDecodeType();
        String r8 = r2.getDecodeKey();
        String r9 = r2.getDecodeNonce();
        if (r6 != 1) goto L25;
        io5.c r10 = new io5.b();
    L30:
        if (r10 == null) goto L33;
        byte[] r11 = r10.a(r8, r9, r5);
    L35:
        if (r11 != null) goto L42;
        StringBuilder r15 = new StringBuilder("decodeData == null, origin data is null = ");
        if (r5 == null) goto L40;
        r7 = false;
    L40:
        r15.append(r7);
        tt5.a.d("AbsDefaultImgFileProvider", r15.toString());
        return null;
    L42:
        Bitmap r12 = BitmapFactory.decodeByteArray(r11, 0, r11.length);
        if (r12 != null) goto L46;
        tt5.a.d("AbsDefaultImgFileProvider", "decodeByteArray failed");
        return null;
    L46:
        ImageView r16 = r2.getImageView();
        if (r16 != null) goto L49;
        tt5.a.k("AbsDefaultImgFileProvider", "view == null");
    L59:
        int r17 = 0;
    L60:
        ImageView r18 = r2.getImageView();
        if (r18 != null) goto L63;
        tt5.a.k("AbsDefaultImgFileProvider", "view == null");
    L72:
        int r19 = 0;
    L73:
        if (r17 <= 0) goto L90;
        if (r19 <= 0) goto L90;
        Bitmap r20 = Bitmap.createBitmap(r17, r19, Bitmap.Config.ARGB_8888);
        if (r13.h == false) goto L79;
        r20.eraseColor(0);
    L80:
        Rect r21 = new Rect(0, 0, r12.getWidth(), r12.getHeight());
        RectF r22 = new RectF();
        float r23 = Math.min((((r17 - (r13.c * 2)) - r13.e) * 1.0f) / r12.getWidth(), (((r19 - (r13.d * 2)) - r13.f) * 1.0f) / r12.getHeight());
        float r24 = r12.getWidth() * r23;
        float r25 = r12.getHeight() * r23;
        float r26 = ((r17 - r13.e) - r24) / 2.0f;
        float r110 = ((r19 - r13.f) - r25) / 2.0f;
        if (r26 > 0.0f) goto L84;
        r26 = 0.0f;
    L84:
        r22.left = r26;
        if (r110 > 0.0f) goto L88;
        r110 = 0.0f;
    L88:
        r22.top = r110;
        r22.right = r26 + r24;
        r22.bottom = r110 + r25;
        new Canvas(r20).drawBitmap(r12, r21, r22, new Paint(6));
        r12.recycle();
        ByteArrayOutputStream r111 = new ByteArrayOutputStream();
        r20.compress(Bitmap.CompressFormat.PNG, 100, r111);
        return new ByteArrayInputStream(r111.toByteArray());
    L79:
        r20.eraseColor(-1);
    L90:
        tt5.a.d("AbsDefaultImgFileProvider", "width = " + r17 + ", height = " + r19);
        return null;
    L63:
        ViewGroup.LayoutParams r27 = r18.getLayoutParams();
        int r112 = r18.getHeight();
        if (r112 > 0) goto L68;
        if (r112 == (-2)) goto L68;
        r7 = false;
    L68:
        if (r7 == false) goto L70;
        r19 = r18.getHeight();
        goto L73
    L70:
        if (r27 == null) goto L72;
        r19 = r27.height;
        goto L73
    L49:
        ViewGroup.LayoutParams r113 = r16.getLayoutParams();
        int r114 = r16.getWidth();
        if (r114 > 0) goto L54;
        if (r114 == (-2)) goto L54;
        boolean r115 = false;
    L55:
        if (r115 == false) goto L57;
        r17 = r16.getWidth();
        goto L60
    L57:
        if (r113 == null) goto L59;
        r17 = r113.width;
    L54:
        r115 = true;
        goto L55
    L25:
        if (r6 != 2) goto L27;
        r10 = new io5.a();
        goto L30
    L27:
        if (r6 != 3) goto L29;
        r10 = new io5.d();
        goto L30
    L29:
        r10 = null;
    L33:
        r11 = r5;
        goto L35
    }
}
