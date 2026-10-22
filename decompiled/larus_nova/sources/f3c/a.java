package f3c;

import android.os.Build;
import android.text.TextUtils;
import c3c.f;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public final class a {
    public static Map<String, String> a() {
        HashMap r100 = new HashMap();
        r100.put("device_model", Build.MODEL);
        r100.put("device_manufacturer", Build.MANUFACTURER);
        f.a().getPassportDependency().getClass();
        r100.put("platform", "android");
        String r101 = f.a().getTTWebviewDependency().a();
        if (TextUtils.isEmpty(r101) == true) goto L5;
        r100.put("webviewContainer", r101);
    L5:
        String r102 = LarkAppContext.inst().buildConfig().getAlchemyProjectId();
        if (TextUtils.isEmpty(r102) == true) goto L8;
        r100.put("alchemy_project_id", r102);
    L8:
        return r100;
    }
}
