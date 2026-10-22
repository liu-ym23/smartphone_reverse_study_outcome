package l0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.airbnb.lottie.d;
import com.airbnb.lottie.h;
import com.airbnb.lottie.i;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import r0.c;
import u0.f;

/* JADX INFO: loaded from: classes28.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f506838e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f506839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f506840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f506841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, h> f506842d;

    static {
        f506838e = new Object();
    }

    public final Bitmap a(String r100) {
        h r101 = this.f506842d.get(r100);
        Bitmap r102 = null;
        if (r101 != null) goto L5;
        return null;
    L5:
        Bitmap r103 = r101.f24784g;
        if (r103 == null) goto L8;
        return r103;
    L8:
        d r104 = this.f506841c;
        if (r104 == null) goto L14;
        Bitmap r105 = r104.q(r101);
        if (r105 == null) goto L13;
        b(r100, r105);
    L13:
        return r105;
    L14:
        String r106 = r101.f24781d;
        BitmapFactory.Options r107 = new BitmapFactory.Options();
        r107.inScaled = true;
        r107.inDensity = 160;
        if (r106.startsWith(fyb.a.KEY_DATA) == true) goto L17;
    L54:
        if (TextUtils.isEmpty(this.f506840b) == false) goto L27;
        i r108 = i.a();     // Catch: IOException -> L53
        new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");     // Catch: IOException -> L53
        r108.getClass();     // Catch: IOException -> L53
        return null;
    L27:
        Context r109 = this.f506839a;     // Catch: IOException -> L53
        if (r109 != null) goto L31;
        i r110 = i.a();     // Catch: IOException -> L53
        new IllegalStateException("context is null!");     // Catch: IOException -> L53
        r110.getClass();     // Catch: IOException -> L53
        return null;
    L31:
        InputStream r111 = r109.getAssets().open(this.f506840b + r106);     // Catch: IOException -> L53
        if (c.a.f535397a == true) goto L57;
        r102 = BitmapFactory.decodeStream(r111, null, r107);
    L51:
        b(r100, r102);
        goto L52
    L57:
        r102 = BitmapFactory.decodeStream(r111, null, r107);     // Catch: OutOfMemoryError -> L46 IllegalArgumentException -> L48
        int r112 = r101.f24778a;
        int r113 = r101.f24779b;
        f.a r114 = f.f548112a;
        if (r102 == null) goto L51;
        if (r112 <= 0) goto L51;
        if (r113 <= 0) goto L51;
        if (r102.getWidth() == r112) goto L43;
    L45:
        r102 = Bitmap.createScaledBitmap(r102, r112, r113, true);
        goto L51
    L43:
        if (r102.getHeight() != r113) goto L45;
    L48:
        int r115 = c.f535396a;
        return null;
    L46:
        int r116 = c.f535396a;
        return null;
    L52:
        return r102;
    L17:
        if (r106.indexOf("base64,") <= 0) goto L54;
        byte[] r117 = Base64.decode(r106.substring(r106.indexOf(44) + 1), 0);     // Catch: IllegalArgumentException -> L22
        Bitmap r118 = BitmapFactory.decodeByteArray(r117, 0, r117.length, r107);
        b(r100, r118);
        return r118;
    L22:
        return null;
    }

    public final void b(String r100, Bitmap r101) {
        Object r102 = f506838e;
        monitor-enter(r102);
        this.f506842d.get(r100).f24784g = r101;     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public b(Drawable.Callback r100, String r101, d r102, Map<String, h> r103) {
        this.f506840b = r101;
        if (TextUtils.isEmpty(r101) == true) goto L8;
        if (r101.charAt(r101.length() - 1) == '/') goto L8;
        this.f506840b = r101 + '/';
    L8:
        if ((r100 instanceof View) == true) goto L11;
        this.f506842d = new HashMap();
        this.f506839a = null;
        return;
    L11:
        this.f506839a = ((View) r100).getContext();
        this.f506842d = r103;
        this.f506841c = r102;
    }
}
