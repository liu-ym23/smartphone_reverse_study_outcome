package m60;

import android.content.Context;
import android.os.Build;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.PermissionChecker;
import com.ss.android.download.api.constant.BaseConstants;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleArrayMap<String, Integer> f512252a = null;

    static {
        SimpleArrayMap<String, Integer> r100 = new SimpleArrayMap(8);
        f512252a = r100;
        r100.put("com.android.voicemail.permission.ADD_VOICEMAIL", 14);
        r100.put("android.permission.BODY_SENSORS", 20);
        r100.put("android.permission.BODY_SENSORS_BACKGROUND", 33);
        r100.put("android.permission.READ_CALL_LOG", 16);
        r100.put("android.permission.READ_EXTERNAL_STORAGE", 16);
        r100.put("android.permission.USE_SIP", 9);
        r100.put("android.permission.WRITE_CALL_LOG", 16);
        r100.put("android.permission.SYSTEM_ALERT_WINDOW", 23);
        r100.put("android.permission.WRITE_SETTINGS", 23);
        r100.put(BaseConstants.PERMISSION_READ_MEDIA_IMAGES, 33);
        r100.put(BaseConstants.PERMISSION_READ_MEDIA_VIDEO, 33);
        r100.put(BaseConstants.PERMISSION_READ_MEDIA_AUDIO, 33);
        r100.put("android.permission.READ_MEDIA_VISUAL_USER_SELECTED", 34);
        r100.put("android.permission.ACCESS_MEDIA_LOCATION", 29);
    }

    public static boolean a(Context r100, String... r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        boolean r104 = true;
        if (r103 >= r102) goto L20;
        String r105 = r101[r103];
        Integer r106 = f512252a.get(r105);
        if (r106 != null) goto L8;
    L11:
        boolean r107 = true;
    L12:
        if (r107 == false) goto L19;
        if (PermissionChecker.checkSelfPermission(r100, r105) != 0) goto L16;
    L17:
        if (r104 == true) goto L19;
        return false;
    L16:
        r104 = false;
    L19:
        r103 = r103 + 1;
        goto L3
    L8:
        if (Build.VERSION.SDK_INT >= r106.intValue()) goto L11;
        r107 = false;
        goto L12
    L20:
        return true;
    }
}
