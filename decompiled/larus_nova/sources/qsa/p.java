package qsa;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.ExifInterface;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;
import android.util.Base64;
import com.ss.android.bytedcert.callback.PhotoCallback;
import com.ss.android.cert.manager.utils.CertLog;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public final class p {
    public static void c(String r100, String r101) {
        ExifInterface r102 = new ExifInterface(r101);     // Catch: Exception -> L4
        Bitmap r103 = rsa.a.e(r101);     // Catch: Exception -> L4
        Map<String, osa.c> r104 = gsa.a.f482481a;     // Catch: Exception -> L4
        HashMap r105 = (HashMap) r104;     // Catch: Exception -> L4
        r105.put(r100, new osa.c(r103, r102));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static String a(Bitmap r100, int r101, int r102) {
        float r103 = 1.0f;
        if (r100.getWidth() > r100.getHeight()) goto L8;
        int r104 = r100.getHeight();
        int r105 = r100.getWidth();
        int r106 = Math.max(r104, r105);
        Math.min(r104, r105);
        if (r106 <= r101) goto L7;
        r103 = r106 / r101;
    L7:
        double r107 = ((double) r105) / 1.0d;
        double r108 = r103;
        Bitmap r109 = ThumbnailUtils.extractThumbnail(r100, (int) (r107 / r108), (int) ((((double) r104) / 1.0d) / r108));
    L9:
        CertLog.d("c", r109.getHeight() + "," + r109.getWidth());
        ByteArrayOutputStream r110 = new ByteArrayOutputStream();
        if (r102 != 0) goto L12;
        r102 = 85;
    L12:
        r109.compress(Bitmap.CompressFormat.JPEG, r102, r110);
        return "data:image/jpeg;base64," + Base64.encodeToString(r110.toByteArray(), 2);
    L8:
        float r111 = r101;
        int r112 = (int) (r100.getHeight() * ((r111 / 1.0f) / r100.getWidth()));
        Bitmap r113 = Bitmap.createBitmap(r101, r112, Bitmap.Config.ARGB_8888);
        Canvas r114 = new Canvas(r113);
        Matrix r115 = new Matrix();
        r115.setScale(r111 / r100.getWidth(), r112 / r100.getHeight());
        r114.drawBitmap(r100, r115, new Paint(6));
        r109 = r113;
        goto L9
    }

    public static String b(String r100, int r101, int r102) {
        osa.c r103 = (osa.c) ((HashMap) gsa.a.f482481a).get(r100);
        if (r103 != null) goto L7;
        return "";
    L7:
        return a(r103.f526593a, r101, r102);
    }

    public static void d(Activity r100, int r101, PhotoCallback.PickCallback r102, PhotoCallback.ResultCallBack r103) {
        if (r102 != null) goto L4;
        r100.startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI), r101);
        return;
    L4:
        r102.onPick(1, r103);
    }
}
