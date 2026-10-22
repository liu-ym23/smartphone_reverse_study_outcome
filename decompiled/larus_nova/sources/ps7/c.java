package ps7;

import android.hardware.Camera;
import android.media.ExifInterface;
import android.os.Build;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.dtf.face.log.RecordService;
import com.dtf.face.network.APICallback;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes22.dex */
public final class c implements Camera.PictureCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f530443a;

    public c(d r100) {
        this.f530443a = r100;
    }

    public static String a(ExifInterface r110, String r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(100020);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(100020, "android/media/ExifInterface", "getAttribute", r110, r101, "java.lang.String", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (String) r107.f474983b;
    L21:
        return r110.getAttribute(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    @Override // android.hardware.Camera.PictureCallback
    public final void onPictureTaken(byte[] r110, Camera r111) {
        this.f530443a.f530455k.removeCallbacks(null);     // Catch: Throwable -> L59 Exception -> L61
        if (this.f530443a.f530456l != null) goto L16;
        r111.startPreview();     // Catch: Throwable -> L59 Exception -> L61
        RecordService.getInstance().recordEvent(2, "onPictureTaken", new String[]{"errMsg", "photoExifCallbackIsNull"});     // Catch: Throwable -> L59 Exception -> L61
        d r112 = this.f530443a;
        APICallback<String> r100 = r112.f530456l;
        if (r100 == null) goto L87;
        r100.onSuccess(r112.f530454j);
    L87:
        r111.startPreview();     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        this.f530443a.f530456l.onError("", Log.getStackTraceString(th), "stopPreviewError");
        this.f530443a.f530456l = null;
        return;
    L16:
        PolarisFileWrapper r101 = new PolarisFileWrapper(this.f530443a.f530453i, "probe.jpg");     // Catch: Throwable -> L59 Exception -> L61
        PolarisFileOutputStreamWrapper r102 = new PolarisFileOutputStreamWrapper(r101);     // Catch: Throwable -> L59 Exception -> L61
        r102.write(r110);     // Catch: Throwable -> L59 Exception -> L61
        r102.close();     // Catch: Throwable -> L59 Exception -> L61
        ExifInterface r113 = new ExifInterface(r101.getAbsolutePath());     // Catch: Throwable -> L59 Exception -> L61
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L59 Exception -> L61
        r103.put2("iso-speed", d.a(r113, androidx.exifinterface.media.ExifInterface.TAG_ISO_SPEED_RATINGS));     // Catch: Throwable -> L59 Exception -> L61
        r103.put2("exposure-time", d.a(r113, androidx.exifinterface.media.ExifInterface.TAG_EXPOSURE_TIME));     // Catch: Throwable -> L59 Exception -> L61
        r103.put2("f-number", d.a(r113, androidx.exifinterface.media.ExifInterface.TAG_F_NUMBER));     // Catch: Throwable -> L59 Exception -> L61
        r103.put2("brightness-value", d.a(r113, androidx.exifinterface.media.ExifInterface.TAG_BRIGHTNESS_VALUE));     // Catch: Throwable -> L59 Exception -> L61
        r103.put2("horizontal-view-angle", Float.valueOf(r111.getParameters().getHorizontalViewAngle()));     // Catch: Throwable -> L59 Exception -> L61
        r103.put2("vertical-view-angle", Float.valueOf(r111.getParameters().getVerticalViewAngle()));     // Catch: Throwable -> L59 Exception -> L61
        r103.put2(com.heytap.mcssdk.constant.b.C, "2.3.43");     // Catch: Throwable -> L59 Exception -> L61
        Object r104 = JSON.toJSONString(this.f530443a.f530448d);     // Catch: Throwable -> L33
    L34:
        r103.put2("light-sensor-config", r104);     // Catch: Throwable -> L59 Exception -> L61
        r103.put2("device-name", Build.MODEL);     // Catch: Throwable -> L59 Exception -> L61
        r103.put2("data-source", "antfincloud-production-android-2");     // Catch: Throwable -> L59 Exception -> L61
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L59 Exception -> L61
        String[] r106 = d.f530444m;     // Catch: Throwable -> L59 Exception -> L61
        int r107 = r106.length;     // Catch: Throwable -> L59 Exception -> L61
        int r108 = 0;
    L37:
        if (r108 >= r107) goto L45;
        String r114 = r106[r108];     // Catch: Throwable -> L59 Exception -> L61
        String r115 = a(r113, r114);     // Catch: Throwable -> L59 Exception -> L61
        if (r115 == null) goto L43;
        if (r115.isEmpty() == true) goto L43;
        r105.put2(r114, r115);     // Catch: Throwable -> L59 Exception -> L61
    L43:
        r108 = r108 + 1;     // Catch: Throwable -> L59 Exception -> L61
        goto L37
    L45:
        if (r105.containsKey(androidx.exifinterface.media.ExifInterface.TAG_DATETIME) == false) goto L48;
    L49:
        r103.put2("extra-exif", r105);     // Catch: Throwable -> L59 Exception -> L61
        d r116 = this.f530443a;     // Catch: Throwable -> L59 Exception -> L61
        r116.f530454j = r103.toJSONString();     // Catch: Throwable -> L59 Exception -> L61
        if (r101.exists() == true) goto L52;
    L54:
        d r117 = this.f530443a;
        APICallback<String> r109 = r117.f530456l;
        if (r109 == null) goto L57;
        r109.onSuccess(r117.f530454j);
    L57:
        r111.startPreview();     // Catch: Throwable -> L70
        return;
    L52:
        if (r101.isFile() == false) goto L54;
        r101.delete();     // Catch: Throwable -> L59 Exception -> L61
        goto L54
    L48:
        r105.put2(androidx.exifinterface.media.ExifInterface.TAG_DATETIME, new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.US).format(new Date()));     // Catch: Throwable -> L59 Exception -> L61
    L33:
        r104 = "";
    L61:
        e = move-exception;
        APICallback<String> r118 = this.f530443a.f530456l;     // Catch: Throwable -> L59
        if (r118 == null) goto L65;
        r118.onError(null, RecordService.getStackTraceString(e), null);     // Catch: Throwable -> L59
    L65:
        d r119 = this.f530443a;
        APICallback<String> r120 = r119.f530456l;
        if (r120 == null) goto L68;
        r120.onSuccess(r119.f530454j);
    L68:
        r111.startPreview();     // Catch: Throwable -> L70
        return;
    L59:
        th = move-exception;
        d r121 = this.f530443a;
        APICallback<String> r122 = r121.f530456l;
        if (r122 == null) goto L84;
        r122.onSuccess(r121.f530454j);
    L84:
        r111.startPreview();     // Catch: Throwable -> L78
    L80:
        throw th;
    L78:
        th = move-exception;
        this.f530443a.f530456l.onError("", Log.getStackTraceString(th), "stopPreviewError");
        this.f530443a.f530456l = null;
    L70:
        th = move-exception;
        this.f530443a.f530456l.onError("", Log.getStackTraceString(th), "stopPreviewError");
        this.f530443a.f530456l = null;
    }
}
