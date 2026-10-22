package ic9;

import android.os.Build;
import com.obric.aiagent.sharedstate.StateKey;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class d {
    public static final Map<String, String> a() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put(StateKey.KEY_DOUBAO_UPDATE_VERSION_CODE, "15020070");
        r100.put("doubao_os_version", Build.VERSION.RELEASE);
        r100.put("doubao_device_type", Build.MODEL);
        r100.put("doubao_device_brand", Build.BRAND);
        r100.put("doubao_device_platform", "android");
        return r100;
    }
}
