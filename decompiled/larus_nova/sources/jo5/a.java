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

/* JADX INFO: loaded from: classes18.dex */
public abstract class a implements g {
    public a() {
    }

    public InputStream b(e r110) throws IOException {
        Response r100 = r110.f499898b;
        int r101 = r100.code();
        ThumbGlideUrl r102 = r110.f499897a;
        byte[] r103 = null;
        if ((r101 / 100) != 3) goto L17;
        tt5.a.h("AbsDefaultImgFileProvider", "statusCode=" + r101 + ", use cache， need not decrypt");
        String r111 = r102.getEncryptCacheKey();
        if (TextUtils.isEmpty(r111) == true) goto L10;
        aw4.a r104 = (aw4.a) org.koin.java.a.a(aw4.a.class);
        if (r104 == null) goto L10;
        r103 = (byte[]) r104.get(r111);
    L10:
        if (r103 != null) goto L12;
    L13:
        ho5.c.d().h(r102.getUrl(), r102.getVersion());
    L15:
        return new ByteArrayInputStream(r103);
    L12:
        if (r103.length != 0) goto L15;
    L17:
        if (r100.body() != null) goto L20;
        tt5.a.d("AbsDefaultImgFileProvider", "response.body() == null");
        return null;
    L20:
        byte[] r105 = r100.body().bytes();
        boolean r106 = true;
        if (r110.f499903g == false) goto L33;
        int r107 = r102.getDecodeType();
        String r108 = r102.getDecodeKey();
        String r109 = r102.getDecodeNonce();
        if (r107 != 1) goto L25;
        io5.c r112 = new io5.b();
    L30:
        if (r112 == null) goto L33;
        byte[] r113 = r112.a(r108, r109, r105);
    L35:
        if (r113 != null) goto L42;
        StringBuilder r114 = new StringBuilder("decodeData == null, origin data is null = ");
        if (r105 == null) goto L40;
        r106 = false;
    L40:
        r114.append(r106);
        tt5.a.d("AbsDefaultImgFileProvider", r114.toString());
        return null;
    L42:
        Bitmap r115 = BitmapFactory.decodeByteArray(r113, 0, r113.length);
        if (r115 != null) goto L46;
        tt5.a.d("AbsDefaultImgFileProvider", "decodeByteArray failed");
        return null;
    L46:
        ImageView r116 = r102.getImageView();
        if (r116 != null) goto L49;
        tt5.a.k("AbsDefaultImgFileProvider", "view == null");
    L59:
        int r117 = 0;
    L60:
        ImageView r118 = r102.getImageView();
        if (r118 != null) goto L63;
        tt5.a.k("AbsDefaultImgFileProvider", "view == null");
    L72:
        int r119 = 0;
    L73:
        if (r117 <= 0) goto L90;
        if (r119 <= 0) goto L90;
        Bitmap r120 = Bitmap.createBitmap(r117, r119, Bitmap.Config.ARGB_8888);
        if (r110.f499904h == false) goto L79;
        r120.eraseColor(0);
    L80:
        Rect r121 = new Rect(0, 0, r115.getWidth(), r115.getHeight());
        RectF r122 = new RectF();
        float r123 = Math.min((((r117 - (r110.f499899c * 2)) - r110.f499901e) * 1.0f) / r115.getWidth(), (((r119 - (r110.f499900d * 2)) - r110.f499902f) * 1.0f) / r115.getHeight());
        float r124 = r115.getWidth() * r123;
        float r125 = r115.getHeight() * r123;
        float r126 = ((r117 - r110.f499901e) - r124) / 2.0f;
        float r127 = ((r119 - r110.f499902f) - r125) / 2.0f;
        if (r126 > 0.0f) goto L84;
        r126 = 0.0f;
    L84:
        r122.left = r126;
        if (r127 > 0.0f) goto L88;
        r127 = 0.0f;
    L88:
        r122.top = r127;
        r122.right = r126 + r124;
        r122.bottom = r127 + r125;
        new Canvas(r120).drawBitmap(r115, r121, r122, new Paint(6));
        r115.recycle();
        ByteArrayOutputStream r128 = new ByteArrayOutputStream();
        r120.compress(Bitmap.CompressFormat.PNG, 100, r128);
        return new ByteArrayInputStream(r128.toByteArray());
    L79:
        r120.eraseColor(-1);
    L90:
        tt5.a.d("AbsDefaultImgFileProvider", "width = " + r117 + ", height = " + r119);
        return null;
    L63:
        ViewGroup.LayoutParams r129 = r118.getLayoutParams();
        int r130 = r118.getHeight();
        if (r130 > 0) goto L68;
        if (r130 == (-2)) goto L68;
        r106 = false;
    L68:
        if (r106 == false) goto L70;
        r119 = r118.getHeight();
        goto L73
    L70:
        if (r129 == null) goto L72;
        r119 = r129.height;
        goto L73
    L49:
        ViewGroup.LayoutParams r131 = r116.getLayoutParams();
        int r132 = r116.getWidth();
        if (r132 > 0) goto L54;
        if (r132 == (-2)) goto L54;
        boolean r133 = false;
    L55:
        if (r133 == false) goto L57;
        r117 = r116.getWidth();
        goto L60
    L57:
        if (r131 == null) goto L59;
        r117 = r131.width;
    L54:
        r133 = true;
        goto L55
    L25:
        if (r107 != 2) goto L27;
        r112 = new io5.a();
        goto L30
    L27:
        if (r107 != 3) goto L29;
        r112 = new io5.d();
        goto L30
    L29:
        r112 = null;
    L33:
        r113 = r105;
        goto L35
    }
}
