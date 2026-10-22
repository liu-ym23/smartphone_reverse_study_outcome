package ir7;

import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public final class e {
    public static Map<String, String> a() {
        gr7.a r100 = cr7.a.f465093b;
        HashMap r101 = new HashMap();
        r101.put("device_platform", "android");
        r101.put("os_name", "android");
        r101.put("seclink_version", "1.1.0");
        com.bytedance.webx.seclink.setting.a r102 = com.bytedance.webx.seclink.setting.c.d().c();
        if (r102 == null) goto L7;
        com.bytedance.webx.seclink.setting.a.C3815a r103 = r102.f272605a;
        if (r103 == null) goto L7;
        String r104 = r103.f272609b;
    L8:
        r101.put("seclink_settings_version", r104);
        if (r100 != null) goto L11;
        return r101;
    L11:
        r101.put("app_id", r100.f482366a);
        r101.put("app_version", r100.f482369d);
        TextUtils.isEmpty(r100.f482368c);
        r101.put(com.bytedance.android.ec.core.event.a.KEY_DID, r100.f482368c);
        r101.put("channel", r100.f482370e);
        r101.put(CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL, r100.f482367b);
        return r101;
    L7:
        r104 = "";
        goto L8
    }
}
