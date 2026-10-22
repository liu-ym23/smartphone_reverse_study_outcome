package is4;

import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.jsapi.SettingsBitableConfig;
import com.ss.android.lark.appsetting.api.SettingManager;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public final class a {
    static {
    }

    public static boolean b() {
        SettingsBitableConfig r100 = (SettingsBitableConfig) SettingManager.getInstance().get(SettingsBitableConfig.class);
        if (r100 == null) goto L9;
        Map<String, Boolean> r101 = r100.a();
        if (r101 == null) goto L9;
        Boolean r102 = r101.get("preUploadEnable");
        if (r102 == null) goto L9;
        return r102.booleanValue();
    L9:
        return false;
    }

    public static String a(String r100) {
        if (b() == true) goto L5;
        return "bitable_file";
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L9;
        if (r100 == null) goto L9;
        return r100;
    L9:
        return "bitable_file";
    }
}
