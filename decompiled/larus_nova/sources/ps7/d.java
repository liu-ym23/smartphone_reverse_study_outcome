package ps7;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.dtf.face.log.RecordService;
import com.dtf.face.network.APICallback;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import faceverify.w;
import fna.g;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public final class d implements SensorEventListener {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String[] f530444m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SensorManager f530445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f530446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f530447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f530448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f530449e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f530450f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f530451g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<Float> f530452h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final File f530453i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f530454j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Handler f530455k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public APICallback<String> f530456l;

    static {
        f530444m = new String[]{ExifInterface.TAG_APERTURE_VALUE, ExifInterface.TAG_CONTRAST, ExifInterface.TAG_CUSTOM_RENDERED, ExifInterface.TAG_DEFAULT_CROP_SIZE, ExifInterface.TAG_DEVICE_SETTING_DESCRIPTION, ExifInterface.TAG_DIGITAL_ZOOM_RATIO, ExifInterface.TAG_DATETIME, ExifInterface.TAG_EXIF_VERSION, ExifInterface.TAG_EXPOSURE_BIAS_VALUE, ExifInterface.TAG_EXPOSURE_INDEX, ExifInterface.TAG_EXPOSURE_MODE, ExifInterface.TAG_EXPOSURE_PROGRAM, ExifInterface.TAG_FOCAL_LENGTH, ExifInterface.TAG_FOCAL_LENGTH_IN_35MM_FILM, ExifInterface.TAG_FOCAL_PLANE_RESOLUTION_UNIT, ExifInterface.TAG_FOCAL_PLANE_X_RESOLUTION, ExifInterface.TAG_FOCAL_PLANE_Y_RESOLUTION, ExifInterface.TAG_GAIN_CONTROL, ExifInterface.TAG_MAKE, ExifInterface.TAG_METERING_MODE, ExifInterface.TAG_REFERENCE_BLACK_WHITE, ExifInterface.TAG_SATURATION, ExifInterface.TAG_SHUTTER_SPEED_VALUE, ExifInterface.TAG_SPECTRAL_SENSITIVITY, ExifInterface.TAG_WHITE_BALANCE, ExifInterface.TAG_WHITE_POINT, ExifInterface.TAG_EXPOSURE_TIME, ExifInterface.TAG_F_NUMBER, ExifInterface.TAG_ISO_SPEED_RATINGS};
    }

    public final void c() {
        if (this.f530451g <= 0) goto L5;
    L6:
        RecordService.getInstance().recordEvent(2, "sensorEx", new String[]{"zeroValueCount", String.valueOf(this.f530451g), "outOfRangeValues", Arrays.toString(((ArrayList) this.f530452h).toArray()), "maxRange", String.valueOf(this.f530450f)});
        ((ArrayList) this.f530452h).clear();
    L7:
        SensorManager r100 = this.f530445a;
        if (r100 != null) goto L10;
        return;
    L10:
        if (g.d() == true) goto L12;
        r100.unregisterListener(this);
    L13:
        this.f530445a = null;
        return;
    L12:
        r100.unregisterListener(this);
        ona.b.c(new ona.a(hashCode(), null));
        goto L13
    L5:
        if (((ArrayList) this.f530452h).size() <= 0) goto L7;
        goto L6
    }

    public d(Context r100) {
        this.f530446b = -1.0f;
        this.f530447c = -2;
        HashMap r101 = new HashMap();
        this.f530448d = r101;
        this.f530449e = false;
        this.f530450f = -1.0f;
        this.f530451g = 0;
        this.f530452h = new ArrayList();
        this.f530455k = new Handler(Looper.getMainLooper());
        this.f530456l = null;
        this.f530453i = r100.getCacheDir();
        SensorManager r102 = (SensorManager) r100.getSystemService(w.BLOB_ELEM_TYPE_SENSOR);
        this.f530445a = r102;
        Sensor r103 = r102.getDefaultSensor(5);
        if (r103 == null) goto L7;
        this.f530445a.registerListener(this, r103, 0);
        float r104 = r103.getMaximumRange();
        this.f530450f = r104;
        r101.put("MAX_RANGE", String.valueOf(r104));
        if (r104 != 0.0f) goto L8;
        RecordService.getInstance().recordEvent(2, "sensorEx", new String[]{"maxRange", String.valueOf(r104)});
    L8:
        r101.put("NO_MOON", String.valueOf(0.001f));
        r101.put("FULLMOON", String.valueOf(0.25f));
        r101.put("CLOUDY", String.valueOf(100.0f));
        r101.put("SUNRISE", String.valueOf(400.0f));
        r101.put("OVERCAST", String.valueOf(10000.0f));
        r101.put("SHADE", String.valueOf(20000.0f));
        r101.put("SUNLIGHT", String.valueOf(110000.0f));
        r101.put("SUNLIGHT_MAX", String.valueOf(120000.0f));
        return;
    L7:
        this.f530449e = true;
        r101.put("MAX_RANGE", String.valueOf(-1000000));
        this.f530446b = -1000000.0f;
        goto L8
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent r100) {
        this.f530449e = true;
        if (r100.sensor.getType() != 5) goto L13;
        float r101 = r100.values[0];
        this.f530446b = r101;
        if (r101 != 0.0f) goto L7;
        this.f530451g++;
    L7:
        float r102 = this.f530450f;
        if (r102 > 0.0f) goto L10;
        return;
    L10:
        if (r101 <= r102) goto L15;
        ((ArrayList) this.f530452h).add(Float.valueOf(r101));
        return;
    L15:
        return;
    }

    public static Float a(android.media.ExifInterface r210, String r211) {
        ArrayList r100 = new ArrayList();
        Object[] r110 = {r211};
        f06.b r111 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(100020);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r112 = r102;
        int r103 = r112.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r112[r104];
        int r113 = r104;
        int r212 = r103;
        f06.a[] r213 = r112;
        f06.d r106 = r105.preInvoke(100020, "android/media/ExifInterface", "getAttribute", r210, r110, "java.lang.String", r111);     // Catch: Exception -> L45
        if (r106.f474982a == true) goto L12;
        r100.add(r105);     // Catch: Exception -> L45
        goto L14
    L12:
        Float r107 = null;
    L17:
        if (r106.f474982a == false) goto L19;
        String r108 = (String) r106.f474983b;
    L20:
        if (r108 == null) goto L43;
        if (r108.isEmpty() == true) goto L43;
        ArrayList r109 = new ArrayList();
        Object[] r114 = {r211, Double.valueOf(Double.NaN)};
        f06.b r115 = new f06.b();
        g06.a r116 = ApiHookConfig.f245611b.get(Integer.valueOf(SpeechCode.SPEECH_TOKEN_NOT_GET_DID));
        if (r116 == null) goto L26;
        f06.a[] r117 = r116.f479473i;
    L27:
        f06.a[] r118 = r117;
        int r119 = r118.length;
        int r120 = 0;
    L29:
        if (r120 >= r119) goto L36;
        f06.a r121 = r118[r120];
        int r122 = r120;
        int r214 = r119;
        f06.a[] r215 = r118;
        f06.d r123 = r121.preInvoke(SpeechCode.SPEECH_TOKEN_NOT_GET_DID, "android/media/ExifInterface", "getAttributeDouble", r210, r114, ItemStyle.ITEM_STYLE_DOUBLE, r115);     // Catch: Exception -> L44
        if (r123.f474982a == true) goto L38;
        r109.add(r121);     // Catch: Exception -> L44
    L38:
        if (r123.f474982a == false) goto L40;
        double r124 = ((Double) r123.f474983b).doubleValue();
    L56:
        return Float.valueOf((float) r124);
    L40:
        r124 = r210.getAttributeDouble(r211, Double.NaN);
    L35:
        r120 = r122 + 1;
        r119 = r214;
        r118 = r215;
        goto L29
    L36:
        r123 = new f06.d(false, r107);
        goto L38
    L26:
        r117 = ApiHookConfig.f245613d;
    L43:
        return r107;
    L19:
        r108 = r210.getAttribute(r211);
    L14:
        r104 = r113 + 1;
        r103 = r212;
        r112 = r213;
        goto L8
    L15:
        r107 = null;
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    public static void b(Camera r210, c r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {null, null, r211};
        f06.b r110 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(100107);
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
        f06.d r107 = r106.preInvoke(100107, "android/hardware/Camera", "takePicture", r210, r101, "void", r110);     // Catch: Exception -> L21
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L21
    L17:
        if (r107.f474982a == false) goto L19;
        return;
    L19:
        r210.takePicture(null, null, r211);
        return;
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

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor r100, int r101) {
        this.f530447c = r101;
        if (((HashMap) this.f530448d).containsKey("SENSOR_INFO") == true) goto L5;
        ((HashMap) this.f530448d).put("SENSOR_INFO", r100.toString());
    L5:
        ((HashMap) this.f530448d).put("SENSOR_ACCURACY", String.valueOf(r101));
        if (r101 >= 3) goto L9;
        RecordService.getInstance().recordEvent(2, "sensorEx", new String[]{LocationMonitorConst.ACCURACY, String.valueOf(r101)});
        return;
    }
}
