package o7;

import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;

/* JADX INFO: loaded from: classes43.dex */
public final class e {
    static {
    }

    public static boolean a() {
        if (com.bytedance.android.annie.ng.g.f39675g == true) goto L5;
    L9:
        return false;
    L5:
        if (com.bytedance.android.annie.ng.g.b().f39657a.f522322a == false) goto L9;
        if (AnnieConfigSettingKeys.JSB_ENABLE_PERMISSION_CHECK.a().booleanValue() == true) goto L9;
        return true;
    }
}
