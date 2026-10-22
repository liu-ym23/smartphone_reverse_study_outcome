package rsa;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import com.ss.android.cert.manager.constants.ErrorConstant;
import com.ss.android.cert.manager.utils.CertLog;
import com.ss.android.cert.manager.utils.event.EventLogUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes34.dex */
public final class a {
    public static Bitmap e(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L21;
        BitmapFactory.Options r101 = new BitmapFactory.Options();
        r101.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r100, r101);
        if (r101.outHeight != (-1)) goto L7;
    L22:
        ExifInterface r102 = new ExifInterface(r100);     // Catch: Exception -> L19
        r101.outWidth = b(r102, androidx.exifinterface.media.ExifInterface.TAG_IMAGE_WIDTH);     // Catch: Exception -> L19
        r101.outHeight = b(r102, androidx.exifinterface.media.ExifInterface.TAG_IMAGE_LENGTH);     // Catch: Exception -> L19
    L9:
        CertLog.d("decodeBitmapFromFile", r101.outHeight + "," + r101.outWidth);
        float r103 = (float) 1280;
        float r104 = (float) 720;
        float r105 = Math.min(r103, r104);
        float r106 = Math.max(r103, r104);
        float r107 = Math.max(r101.outHeight, r101.outWidth);
        float r108 = Math.min(r101.outHeight, r101.outWidth);
        int r109 = 1;
    L11:
        if (r107 <= r106) goto L15;
        if (r108 <= r105) goto L15;
        r107 = r107 / 2.0f;
        r108 = r108 / 2.0f;
        r109 = r109 * 2;
    L15:
        r101.inSampleSize = r109;
        r101.inJustDecodeBounds = false;
        r101.inPurgeable = true;
        CertLog.d("decodeBitmapFromFile: ", r101.inSampleSize + "");
        Bitmap r110 = BitmapFactory.decodeFile(r100, r101);
        if (r110 == null) goto L18;
        CertLog.d("decodeBitmapFromFile: ", r110.getHeight() + "," + r110.getWidth());
    L18:
        return r110;
    L19:
        e = move-exception;
        e.printStackTrace();
        EventLogUtils.onExceptionEvent(e, ErrorConstant.checkClientException(e));
        goto L21
    L7:
        if (r101.outWidth != (-1)) goto L9;
    L21:
        return null;
    }

    public static Bitmap a(Context r100, Bitmap r101) {
        if (r101 != null) goto L5;
        return null;
    L5:
        Bitmap r102 = Bitmap.createBitmap(r101);
        RenderScript r103 = RenderScript.create(r100);
        Allocation r104 = Allocation.createFromBitmap(r103, r101);
        Allocation r105 = Allocation.createTyped(r103, r104.getType());
        ScriptIntrinsicBlur r106 = ScriptIntrinsicBlur.create(r103, Element.U8_4(r103));
        r106.setRadius(25.0f);
        r106.setInput(r104);
        r106.forEach(r105);
        r105.copyTo(r102);
        return r102;
    }

    public static int b(ExifInterface r210, String r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r211, 1};
        f06.b r110 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(Integer.valueOf(SpeechCode.SPEECH_VC_TASK_TYPE_NOT_MATCH));
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r111 = r103;
        int r104 = r111.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r111[r105];
        int r112 = r105;
        int r113 = r104;
        f06.a[] r114 = r111;
        f06.d r107 = r106.preInvoke(SpeechCode.SPEECH_VC_TASK_TYPE_NOT_MATCH, "android/media/ExifInterface", "getAttributeInt", r210, r101, "int", r110);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r210.getAttributeInt(r211, 1);
    L14:
        r105 = r112 + 1;
        r104 = r113;
        r111 = r114;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static Bitmap d(Bitmap r100, float r101, float r102) {
        int r103 = r100.getWidth();
        int r104 = (int) (r103 * r101);
        int r105 = (r103 / 2) - (r104 / 2);
        int r106 = 0;
        if (r105 > 0) goto L6;
        r105 = 0;
    L6:
        if ((r105 + r104) <= r103) goto L8;
        r105 = 0;
    L9:
        int r107 = r100.getHeight();
        int r108 = (int) (r107 * r102);
        int r109 = (r107 / 2) - (r108 / 2);
        if (r109 > 0) goto L13;
        r109 = 0;
    L13:
        if ((r109 + r108) > r107) goto L17;
        r107 = r108;
        r106 = r109;
    L17:
        return Bitmap.createBitmap(r100, r105, r106, r103, r107);
    L8:
        r103 = r104;
        goto L9
    }

    public static int g(int r100, int r101, int r102, int r103) {
        return (int) Math.sqrt(Math.pow(r100 - r102, 2.0d) + Math.pow(r101 - r103, 2.0d));
    }

    public static Point c(int r100, int r101, int r102, int r103, int r104, int r105) {
        if (r102 <= r100) goto L7;
        if (r103 <= r101) goto L7;
        double r106 = r105;
        double r107 = r104;
        r102 = (int) (((double) r102) - (Math.cos(Math.toRadians(r107)) * r106));
        double r108 = r103;
        double r109 = Math.sin(Math.toRadians(r107));
    L5:
        double r110 = r108 - (r106 * r109);
    L6:
        r103 = (int) r110;
    L31:
        return new Point(r102, r103);
    L7:
        if (r102 <= r100) goto L11;
        if (r103 >= r101) goto L11;
        double r111 = r105;
        double r112 = r104;
        r102 = (int) (((double) r102) - (Math.cos(Math.toRadians(r112)) * r111));
        double r113 = r103;
        double r114 = Math.sin(Math.toRadians(r112));
    L10:
        r110 = r113 + (r111 * r114);
    L11:
        if (r102 >= r100) goto L14;
        if (r103 <= r101) goto L14;
        r106 = r105;
        double r115 = r104;
        r102 = (int) (((double) r102) + (Math.cos(Math.toRadians(r115)) * r106));
        r108 = r103;
        r109 = Math.sin(Math.toRadians(r115));
    L14:
        if (r102 >= r100) goto L17;
        if (r103 >= r101) goto L17;
        r111 = r105;
        double r116 = r104;
        r102 = (int) (((double) r102) + (Math.cos(Math.toRadians(r116)) * r111));
        r113 = r103;
        r114 = Math.sin(Math.toRadians(r116));
    L17:
        if (r102 != r100) goto L20;
        if (r103 <= r101) goto L20;
        r108 = r103;
        r106 = r105;
        r109 = Math.sin(Math.toRadians(r104));
    L20:
        if (r102 != r100) goto L23;
        if (r103 >= r101) goto L23;
        r113 = r103;
        r111 = r105;
        r114 = Math.sin(Math.toRadians(r104));
    L23:
        if (r102 <= r100) goto L27;
        if (r103 != r101) goto L27;
        double r117 = ((double) r102) - (((double) r105) * Math.cos(Math.toRadians(r104)));
    L26:
        r102 = (int) r117;
    L27:
        if (r102 >= r100) goto L31;
        if (r103 != r101) goto L31;
        r117 = ((double) r102) + (((double) r105) * Math.cos(Math.toRadians(r104)));
        goto L26
    }

    public static Bitmap f(Bitmap r210, int r211, int r212, float r213, int r214, int r215, int r216, int r217, Point r218) {
        if ((0 + r211) <= r210.getWidth()) goto L5;
        int r100 = r210.getWidth() - 0;
    L7:
        if ((0 + r212) <= r210.getHeight()) goto L9;
        int r110 = r210.getHeight() - 0;
    L10:
        Matrix r111 = new Matrix();
        float[] r112 = new float[2];
        float r113 = r214;
        float r114 = r215;
        r111.setRotate(r213, r113, r114);
        r111.mapPoints(r112, new float[]{r218.x, r218.y});
        Bitmap r101 = Bitmap.createBitmap(r210, 0, 0, r100, r110, r111, true);
        int r102 = (int) Math.toDegrees(Math.atan(Math.abs(r114 - r112[1]) / Math.abs(r113 - r112[0])));
        int r103 = g(r214, r215, (int) r112[0], (int) r112[1]);
        int r104 = r101.getWidth() / 2;
        int r105 = r101.getHeight() / 2;
        r112[0] = (int) (r112[0] * ((r101.getWidth() + 0.0f) / r100));
        float r106 = (int) (r112[1] * ((r101.getHeight() + 0.0f) / r110));
        r112[1] = r106;
        int r107 = c((int) r112[0], (int) r106, r104, r105, r102, r103).x - 50;
        int r108 = c((int) r112[0], (int) r112[1], r104, r105, r102, r103).y - 50;
        int r109 = r216 + 100;
        int r115 = r217 + 100;
        Paint r116 = new Paint(1);
        r116.setStyle(Paint.Style.FILL);
        Bitmap r117 = Bitmap.createBitmap(r109, r115, Bitmap.Config.ARGB_8888);
        new Canvas(r117).drawBitmap(r101, new Rect(r107, r108, r107 + r109, r108 + r115), new Rect(0, 0, r109, r115), r116);
        return r117;
    L9:
        r110 = r212;
        goto L10
    L5:
        r100 = r211;
        goto L7
    }
}
