package sh9;

import com.byted.cast.common.auth.AuthConstants;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f542083a = 0;

    static {
    }

    public static JSONObject a(Map r100, wh8.a r101) {
        JSONObject r102 = new JSONObject();
        String r103 = (String) r100.get("group_by");
        if (r103 != null) goto L5;
        r103 = "none";
    L5:
        r102.put("group_by", r103);
        String r104 = (String) r100.get(com.bytedance.android.ec.core.event.a.KEY_SORD_TYPE);
        if (r104 != null) goto L8;
        r104 = "update_time";
    L8:
        r102.put(com.bytedance.android.ec.core.event.a.KEY_SORD_TYPE, r104);
        String r105 = "-";
        r102.put("group_id", "-");
        wc9.e r106 = r101.f559708a;
        if (r106 == null) goto L22;
        String r107 = r106.I;
        if (r107 == null) goto L22;
        if (r107.length() <= 0) goto L15;
        boolean r108 = true;
    L16:
        if (r108 == true) goto L19;
        r107 = null;
    L19:
        if (r107 == null) goto L22;
        r105 = r107;
        goto L22
    L15:
        r108 = false;
    L22:
        r102.put(AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, r105);
        return r102;
    }
}
