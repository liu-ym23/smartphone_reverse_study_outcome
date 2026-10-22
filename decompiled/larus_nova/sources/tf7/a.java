package tf7;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.bytedance.supervisor.token.AtomicInfoDef;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import of7.b;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f545762a = 0;

    static {
    }

    public static Sensor a(SensorManager r100, int r101, Token r102) throws SensitiveAPIException {
        Intrinsics.checkNotNullParameter(r100, "manager");
        Intrinsics.checkNotNullParameter(r102, "token");
        ArrayList r103 = new ArrayList();
        if (r101 == 65536) goto L36;
        switch(r101) {
            case 1: goto L28;
            case 2: goto L27;
            case 3: goto L26;
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L23;
            case 7: goto L22;
            case 8: goto L21;
            case 9: goto L20;
            case 10: goto L19;
            case 11: goto L18;
            case 12: goto L17;
            case 13: goto L16;
            case 14: goto L15;
            case 15: goto L14;
            case 16: goto L13;
            case 17: goto L12;
            case 18: goto L11;
            case 19: goto L10;
            case 20: goto L9;
            case 21: goto L8;
            default: goto L5;
        };
    L5:
        switch(r101) {
            case 28: goto L32;
            case 29: goto L31;
            case 30: goto L30;
            case 31: goto L29;
            default: goto L6;
        };
    L6:
        switch(r101) {
            case 34: goto L35;
            case 35: goto L34;
            case 36: goto L33;
            default: goto L7;
        };
    L7:
        String r104 = null;
    L37:
        if (r104 == null) goto L40;
        r103.add(r104);
    L40:
        rf7.a.a(r102, new b(r103, new Integer[]{Integer.valueOf(r101)}));
        return r100.getDefaultSensor(r101);
    L33:
        r104 = AtomicInfoDef.SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_HINGE_ANGLE;
        goto L37
    L34:
        r104 = AtomicInfoDef.SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_ACCELEROMETER_UNCALIBRATED;
        goto L37
    L35:
        r104 = AtomicInfoDef.SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_LOW_LATENCY_OFFBODY_DETECT;
        goto L37
    L29:
        r104 = AtomicInfoDef.SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_HEART_BEAT;
        goto L37
    L30:
        r104 = AtomicInfoDef.SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_MOTION_DETECT;
        goto L37
    L31:
        r104 = AtomicInfoDef.SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_STATIONARY_DETECT;
        goto L37
    L32:
        r104 = AtomicInfoDef.SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_POSE_6DOF;
        goto L37
    L8:
        r104 = AtomicInfoDef.SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_HEART_RATE;
        goto L37
    L9:
        r104 = AtomicInfoDef.SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_GEOMAGNETIC_ROTATION_VECTOR;
        goto L37
    L10:
        r104 = AtomicInfoDef.SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_STEP_COUNTER;
        goto L37
    L11:
        r104 = AtomicInfoDef.SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_STEP_DETECTOR;
        goto L37
    L12:
        r104 = AtomicInfoDef.SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_SIGNIFICANT_MOTION;
        goto L37
    L13:
        r104 = AtomicInfoDef.SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_GYROSCOPE_UNCALIBRATED;
        goto L37
    L14:
        r104 = AtomicInfoDef.SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_GAME_ROTATION_VECTOR;
        goto L37
    L15:
        r104 = AtomicInfoDef.SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_MAGNETIC_FIELD_UNCALIBRATED;
        goto L37
    L16:
        r104 = AtomicInfoDef.SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_AMBIENT_TEMPERATURE;
        goto L37
    L17:
        r104 = AtomicInfoDef.SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_RELATIVE_HUMIDITY;
        goto L37
    L18:
        r104 = AtomicInfoDef.SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_ROTATION_VECTOR;
        goto L37
    L19:
        r104 = AtomicInfoDef.SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_LINEAR_ACCELERATION;
        goto L37
    L20:
        r104 = AtomicInfoDef.SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_GRAVITY;
        goto L37
    L21:
        r104 = AtomicInfoDef.SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_PROXIMITY;
        goto L37
    L22:
        r104 = AtomicInfoDef.SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_TEMPERATURE;
        goto L37
    L23:
        r104 = AtomicInfoDef.SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_PRESSURE;
        goto L37
    L24:
        r104 = AtomicInfoDef.SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_LIGHT;
        goto L37
    L25:
        r104 = AtomicInfoDef.SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_GYROSCOPE;
        goto L37
    L26:
        r104 = AtomicInfoDef.SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_ORIENTATION;
        goto L37
    L27:
        r104 = AtomicInfoDef.SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_MAGNETIC_FIELD;
        goto L37
    L28:
        r104 = AtomicInfoDef.SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_ACCELEROMETER;
        goto L37
    L36:
        r104 = AtomicInfoDef.SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_DEVICE_PRIVATE_BASE;
        goto L37
    }
}
