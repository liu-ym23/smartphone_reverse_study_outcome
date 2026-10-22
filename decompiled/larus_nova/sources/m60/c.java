package m60;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.ActivityCompat;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.bpea.cert.token.TokenCert;
import com.larus.nova.R;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jc1.k;

/* JADX INFO: loaded from: classes45.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Integer> f512253a = null;

    static {
        HashMap r100 = new HashMap();
        f512253a = r100;
        Integer r101 = Integer.valueOf(R.string.ttlive_permissions_calendar);
        r100.put("android.permission.READ_CALENDAR", r101);
        r100.put("android.permission.WRITE_CALENDAR", r101);
        r100.put("android.permission.CAMERA", Integer.valueOf(R.string.ttlive_permissions_camera));
        Integer r102 = Integer.valueOf(R.string.ttlive_permissions_location);
        r100.put("android.permission.ACCESS_COARSE_LOCATION", r102);
        r100.put("android.permission.ACCESS_FINE_LOCATION", r102);
        r100.put("android.permission.RECORD_AUDIO", Integer.valueOf(R.string.ttlive_permissions_record_audio));
        r100.put("android.permission.READ_PHONE_STATE", Integer.valueOf(R.string.ttlive_permissions_read_phone_status));
        Integer r103 = Integer.valueOf(R.string.ttlive_permissions_call);
        r100.put("android.permission.CALL_PHONE", r103);
        Integer r104 = Integer.valueOf(R.string.ttlive_permissions_call_log);
        r100.put("android.permission.READ_CALL_LOG", r104);
        r100.put("android.permission.WRITE_CALL_LOG", r104);
        r100.put("com.android.voicemail.permission.ADD_VOICEMAIL", r103);
        r100.put("android.permission.USE_SIP", r103);
        r100.put("android.permission.PROCESS_OUTGOING_CALLS", r103);
        Integer r105 = Integer.valueOf(R.string.ttlive_permissions_sensors);
        r100.put("android.permission.BODY_SENSORS", r105);
        int r106 = Build.VERSION.SDK_INT;
        if (r106 < 33) goto L5;
        r100.put("android.permission.BODY_SENSORS_BACKGROUND", r105);
    L5:
        r100.put("android.permission.SEND_SMS", Integer.valueOf(R.string.ttlive_permissions_sms));
        r100.put("android.permission.RECEIVE_SMS", Integer.valueOf(R.string.ttlive_permissions_sms));
        r100.put("android.permission.READ_SMS", Integer.valueOf(R.string.ttlive_permissions_sms));
        r100.put("android.permission.RECEIVE_WAP_PUSH", Integer.valueOf(R.string.ttlive_permissions_sms));
        r100.put("android.permission.RECEIVE_MMS", Integer.valueOf(R.string.ttlive_permissions_sms));
        r100.put("android.permission.READ_EXTERNAL_STORAGE", Integer.valueOf(R.string.ttlive_permissions_external_storage));
        if (r106 < 33) goto L9;
        r100.put(BaseConstants.PERMISSION_READ_MEDIA_IMAGES, Integer.valueOf(R.string.ttlive_permissions_external_storage));
        r100.put(BaseConstants.PERMISSION_READ_MEDIA_VIDEO, Integer.valueOf(R.string.ttlive_permissions_external_storage));
        r100.put(BaseConstants.PERMISSION_READ_MEDIA_AUDIO, Integer.valueOf(R.string.ttlive_permissions_external_storage));
    L9:
        if (r106 < 34) goto L11;
        r100.put("android.permission.READ_MEDIA_VISUAL_USER_SELECTED", Integer.valueOf(R.string.ttlive_permissions_external_storage));
    L11:
        r100.put("android.permission.BLUETOOTH_CONNECT", Integer.valueOf(R.string.ttlive_permissions_bluetooth_connect));
    }

    public static String[] a(Activity r100, String... r101) {
        ArrayList r102 = new ArrayList();
        int r103 = r101.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L9;
        String r105 = r101[r104];
        if (d(r100, new String[]{r105}) == true) goto L7;
        r102.add(r105);
    L7:
        r104 = r104 + 1;
        goto L3
    L9:
        return (String[]) r102.toArray(new String[r102.size()]);
    }

    public static boolean b(Context r100, TokenCert r101) {
        if (LiveInfraSettingKeys.LIVE_EZPERMISSION_QUERY.getValue().booleanValue() == false) goto L9;
        if (jc1.a.c() == true) goto L9;
        return ((IMiddlewareHostAction) k.f(IMiddlewareHostAction.class)).isGranted(r100, new String[]{"android.permission.RECORD_AUDIO"});
    L9:
        if (Build.VERSION.SDK_INT < 23) goto L15;
        Map<String, p60.c> r102 = p60.e.f527862b;
        if (p60.e.a.f527864a.b() == true) goto L15;
        return b.a(r100, new String[]{"android.permission.RECORD_AUDIO"});
    L15:
        return n60.a.b(r101);
    }

    public static boolean c(Context r100, List<String> r101) {
        if (r101 != null) goto L6;
        return true;
    L6:
        return d(r100, (String[]) r101.toArray(new String[r101.size()]));
    }

    public static boolean d(Context r100, String... r101) {
        if (r101 != null) goto L6;
        return true;
    L6:
        if (LiveInfraSettingKeys.LIVE_EZPERMISSION_QUERY.getValue().booleanValue() == false) goto L12;
        if (jc1.a.c() == true) goto L12;
        return ((IMiddlewareHostAction) k.f(IMiddlewareHostAction.class)).isGranted(r100, r101);
    L12:
        if (Build.VERSION.SDK_INT < 23) goto L18;
        Map<String, p60.c> r102 = p60.e.f527862b;
        if (p60.e.a.f527864a.b() == true) goto L18;
        return b.a(r100, r101);
    L18:
        return n60.e.a.f518098a.b(r100, r101);
    }

    public static boolean e(Activity r100, String... r101) {
        if (r101 != null) goto L5;
        return false;
    L5:
        SimpleArrayMap<String, Integer> r102 = b.f512252a;
        int r103 = r101.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L14;
        if (ActivityCompat.shouldShowRequestPermissionRationale(r100, r101[r104]) == true) goto L9;
        r104 = r104 + 1;
        goto L6
    L9:
        return true;
    L14:
        return false;
    }

    public static boolean f(Activity r100, String[] r101, int[] r102) {
        if (r102.length != 0) goto L5;
        return false;
    L5:
        int r103 = r102.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L11;
        if (r102[r104] != 0) goto L9;
        r104 = r104 + 1;
        goto L6
    L9:
        return false;
    L11:
        Map<String, p60.c> r105 = p60.e.f527862b;
        if (p60.e.a.f527864a.b() == true) goto L14;
        return true;
    L14:
        return d(r100, r101);
    }
}
