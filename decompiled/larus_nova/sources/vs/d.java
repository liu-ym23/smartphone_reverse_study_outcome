package vs;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import fu.h;
import java.util.ArrayList;
import xr.s;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements e {
    public d() {
    }

    public static int a(ExifInterface r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1};
        f06.b r110 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(Integer.valueOf(SpeechCode.SPEECH_VC_TASK_TYPE_NOT_MATCH));
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r104 = r103;
        int r105 = r104.length;
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L15;
        f06.a r107 = r104[r106];
        int r111 = r106;
        int r112 = r105;
        f06.a[] r113 = r104;
        f06.d r108 = r107.preInvoke(SpeechCode.SPEECH_VC_TASK_TYPE_NOT_MATCH, "android/media/ExifInterface", "getAttributeInt", r210, r101, "int", r110);     // Catch: Exception -> L22
        if (r108.f474982a == true) goto L17;
        r100.add(r107);     // Catch: Exception -> L22
    L17:
        if (r108.f474982a == false) goto L21;
        return ((Integer) r108.f474983b).intValue();
    L21:
        return r210.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
    L14:
        r106 = r111 + 1;
        r105 = r112;
        r104 = r113;
        goto L8
    L15:
        r108 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static Bitmap d(Bitmap r100) {
        int r101 = r100.getWidth();
        int r102 = r100.getHeight();
        float r103 = r101;
        if (r103 <= 2000.0f) goto L8;
        float r104 = r102;
        if (r104 <= 2000.0f) goto L9;
        float r105 = Math.max(r103 / 2000.0f, r104 / 2000.0f);
        Matrix r106 = new Matrix();
        float r107 = 1.0f / r105;
        r106.setScale(r107, r107);
        return Bitmap.createBitmap(r100, 0, 0, r101, r102, r106, true);
    L9:
        return r100;
    L8:
        return r100;
    }

    public final boolean b(String r100) {
        if (s.a(h.class) != null) goto L7;
        return false;
    L7:
        return ((h) s.a(h.class)).isDownloaded(UriProtector.parse(r100));
    }

    public final Drawable c(String r100) {
        if (s.a(h.class) == null) goto L5;
        String r101 = ((h) s.a(h.class)).getImageFilePath(r100);
    L7:
        if (StringUtils.isEmpty(r101) == true) goto L42;
        BitmapFactory.Options r102 = new BitmapFactory.Options();     // Catch: OutOfMemoryError -> L34
        r102.inJustDecodeBounds = true;     // Catch: OutOfMemoryError -> L34
        BitmapFactory.decodeFile(r101, r102);     // Catch: OutOfMemoryError -> L34
        float r103 = r102.outWidth;     // Catch: OutOfMemoryError -> L34
        if (r103 <= 2000.0f) goto L33;
        float r104 = r102.outHeight;     // Catch: OutOfMemoryError -> L34
        if (r104 <= 2000.0f) goto L33;
        float r105 = Math.min(r103 / 2000.0f, r104 / 2000.0f);     // Catch: OutOfMemoryError -> L34
        float r106 = 1.0f;
    L13:
        float r107 = 2.0f * r106;     // Catch: OutOfMemoryError -> L34
        if (r107 > r105) goto L16;
        r106 = r107;
        goto L13
    L16:
        r102.inSampleSize = (int) r106;     // Catch: OutOfMemoryError -> L34
        int r108 = 0;
        r102.inJustDecodeBounds = false;     // Catch: OutOfMemoryError -> L34
        Bitmap r109 = BitmapFactory.decodeFile(r101, r102);     // Catch: OutOfMemoryError -> L34
        int r110 = a(new ExifInterface(r101));     // Catch: Exception -> L28 OutOfMemoryError -> L34
        if (r110 != 3) goto L21;
        r108 = 180;
    L30:
        yr.b.b(3, "FrescoImageLoader", "image degree: " + r108);     // Catch: OutOfMemoryError -> L34
        return new f(r109, r108);
    L21:
        if (r110 != 6) goto L23;
        r108 = 90;
        goto L30
    L23:
        if (r110 != 8) goto L30;
        r108 = 270;
        goto L30
    L28:
        e = move-exception;
        e.printStackTrace();     // Catch: OutOfMemoryError -> L34
    L33:
        return BitmapDrawable.createFromPath(r101);
    L34:
        e = move-exception;
        e.printStackTrace();
        return null;
    L42:
        return null;
    L5:
        r101 = "";
        goto L7
    }
}
