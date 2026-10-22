package ru;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;
import com.bytedance.android.gamecp.common.setting.LiveInfraSettingKeys;
import com.bytedance.android.gamecp.common.utils.u;
import com.larus.nova.R;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Integer> f539221a = null;

    static {
        HashMap r100 = new HashMap();
        f539221a = r100;
        Integer r101 = Integer.valueOf(R.string.gamecp_permissions_calendar);
        r100.put("android.permission.READ_CALENDAR", r101);
        r100.put("android.permission.WRITE_CALENDAR", r101);
        r100.put("android.permission.CAMERA", Integer.valueOf(R.string.gamecp_permissions_camera));
        Integer r102 = Integer.valueOf(R.string.gamecp_permissions_location);
        r100.put("android.permission.ACCESS_COARSE_LOCATION", r102);
        r100.put("android.permission.ACCESS_FINE_LOCATION", r102);
        r100.put("android.permission.RECORD_AUDIO", Integer.valueOf(R.string.gamecp_permissions_record_audio));
        r100.put("android.permission.READ_PHONE_STATE", Integer.valueOf(R.string.gamecp_permissions_read_phone_status));
        Integer r103 = Integer.valueOf(R.string.gamecp_permissions_call);
        r100.put("android.permission.CALL_PHONE", r103);
        Integer r104 = Integer.valueOf(R.string.gamecp_permissions_call_log);
        r100.put("android.permission.READ_CALL_LOG", r104);
        r100.put("android.permission.WRITE_CALL_LOG", r104);
        r100.put("com.android.voicemail.permission.ADD_VOICEMAIL", r103);
        r100.put("android.permission.USE_SIP", r103);
        r100.put("android.permission.PROCESS_OUTGOING_CALLS", r103);
        Integer r105 = Integer.valueOf(R.string.gamecp_permissions_sensors);
        r100.put("android.permission.BODY_SENSORS", r105);
        int r106 = Build.VERSION.SDK_INT;
        if (r106 < 33) goto L6;
        r100.put("android.permission.BODY_SENSORS_BACKGROUND", r105);
        r100.put(BaseConstants.PERMISSION_READ_MEDIA_IMAGES, Integer.valueOf(R.string.gamecp_permissions_read_image));
        r100.put(BaseConstants.PERMISSION_READ_MEDIA_VIDEO, Integer.valueOf(R.string.gamecp_permissions_read_video));
        r100.put(BaseConstants.PERMISSION_READ_MEDIA_AUDIO, Integer.valueOf(R.string.gamecp_permissions_read_audio));
    L6:
        if (r106 < 34) goto L8;
        r100.put("android.permission.READ_MEDIA_VISUAL_USER_SELECTED", Integer.valueOf(R.string.gamecp_permissions_media));
    L8:
        r100.put("android.permission.SEND_SMS", Integer.valueOf(R.string.gamecp_permissions_sms));
        r100.put("android.permission.RECEIVE_SMS", Integer.valueOf(R.string.gamecp_permissions_sms));
        r100.put("android.permission.READ_SMS", Integer.valueOf(R.string.gamecp_permissions_sms));
        r100.put("android.permission.RECEIVE_WAP_PUSH", Integer.valueOf(R.string.gamecp_permissions_sms));
        r100.put("android.permission.RECEIVE_MMS", Integer.valueOf(R.string.gamecp_permissions_sms));
        r100.put("android.permission.READ_EXTERNAL_STORAGE", Integer.valueOf(R.string.gamecp_permissions_external_storage));
        r100.put("android.permission.WRITE_EXTERNAL_STORAGE", Integer.valueOf(R.string.gamecp_permissions_external_storage));
    }

    public static String a(Context r100, String... r101) {
        ArrayList r102 = new ArrayList();
        int r103 = r101.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L10;
        String r105 = r101[r104];
        Map<String, Integer> r106 = f539221a;
        if (((HashMap) r106).containsKey(r105) == false) goto L9;
        Integer r107 = (Integer) ((HashMap) r106).get(r105);
        if (r102.contains(r107) == true) goto L9;
        r102.add(r107);
    L9:
        r104 = r104 + 1;
        goto L3
    L10:
        StringBuilder r108 = new StringBuilder();
        Iterator r109 = r102.iterator();
    L12:
        if (r109.hasNext() == false) goto L18;
        Integer r110 = (Integer) r109.next();
        if (r108.length() <= 0) goto L16;
        r108.append(", ");
    L16:
        r108.append(r100.getString(r110.intValue()));
        goto L12
    L18:
        return r108.toString();
    }

    public static String[] b(Activity r100, String... r101) {
        ArrayList r102 = new ArrayList();
        int r103 = r101.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L9;
        String r105 = r101[r104];
        if (c(r100, new String[]{r105}) == true) goto L7;
        r102.add(r105);
    L7:
        r104 = r104 + 1;
        goto L3
    L9:
        return (String[]) r102.toArray(new String[r102.size()]);
    }

    public static boolean c(Context r100, String... r101) {
        if (r101 != null) goto L6;
        return true;
    L6:
        if (LiveInfraSettingKeys.LIVE_EZPERMISSION_QUERY.getValue().booleanValue() == false) goto L20;
        Application r102 = u.f57306a;
        if (r102 == null) goto L15;
        String r103 = r102.getPackageName();
        if (TextUtils.isEmpty(r103) == true) goto L15;
        if (r103.startsWith("com.bytedance.android.gamecp") == false) goto L15;
        boolean r104 = true;
    L16:
        if (r104 == true) goto L20;
        return com.bytedance.android.gamecp.host_api.a.b().getHostAction().isGranted(r100, r101);
    L15:
        r104 = false;
    L20:
        if (Build.VERSION.SDK_INT < 23) goto L42;
        Map<String, vu.c> r105 = vu.e.f557316b;
        if (vu.e.a.f557318a.b() == true) goto L42;
        SimpleArrayMap<String, Integer> r106 = b.f539220a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
        int r107 = r101.length;
        int r108 = 0;
    L24:
        if (r108 >= r107) goto L57;
        String r109 = r101[r108];
        SimpleArrayMap<String, Integer> r110 = b.f539220a;
        Intrinsics.checkNotNull(r110);
        Integer r111 = r110.get(r109);
        if (r111 != null) goto L28;
    L31:
        boolean r112 = true;
    L32:
        if (r112 == false) goto L40;
        if (PermissionChecker.checkSelfPermission(r100, r109) != 0) goto L37;
        boolean r113 = true;
    L38:
        if (r113 == true) goto L40;
        return false;
    L37:
        r113 = false;
    L40:
        r108 = r108 + 1;
        goto L24
    L28:
        if (Build.VERSION.SDK_INT >= r111.intValue()) goto L31;
        r112 = false;
        goto L32
    L57:
        return true;
    L42:
        su.e r114 = su.e.a.f543582a;
        r114.getClass();
        int r115 = r101.length;
        int r116 = 0;
    L43:
        if (r116 >= r115) goto L58;
        if (r114.a(r100, r101[r116]) == false) goto L46;
        r116 = r116 + 1;
        goto L43
    L46:
        return false;
    L58:
        return true;
    }

    public static boolean d(Activity r100, String... r101) {
        if (r101 != null) goto L5;
        return false;
    L5:
        SimpleArrayMap<String, Integer> r102 = b.f539220a;
        Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
        int r103 = r101.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L14;
        String r105 = r101[r104];
        Intrinsics.checkNotNull(r100);
        Intrinsics.checkNotNull(r105);
        if (ActivityCompat.shouldShowRequestPermissionRationale(r100, r105) == true) goto L9;
        r104 = r104 + 1;
        goto L6
    L9:
        return true;
    L14:
        return false;
    }
}
