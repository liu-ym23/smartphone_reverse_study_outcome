package q59;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.util.Map;

/* JADX INFO: loaded from: classes27.dex */
public final class b {
    public static final a b(Map<String, ? extends Object> r100) {
        String r101 = a(r100, "priority_broadcast_switch");
        String r102 = a(r100, "notification_frequence");
        String r103 = a(r100, "notification_social_private_chat_mode");
        String r104 = a(r100, "notification_social_group_chat_mode");
        String r105 = a(r100, "notification_social_special_chat_mode");
        if (r100 == null) goto L11;
        Object r106 = r100.get("notification_social_special_chat_list");
        if (r106 == null) goto L11;
        if ((r106 instanceof String) == false) goto L10;
        String r107 = (String) r106;
    L12:
        if (r100 == null) goto L21;
        Object r108 = r100.get("notification_service_config_list");
        if (r108 == null) goto L21;
        if ((r108 instanceof String) == false) goto L19;
        String r109 = (String) r108;
    L20:
        String r110 = r109;
    L23:
        return new a(r101, r102, r103, r104, r105, r107, r110);
    L19:
        r109 = GsonProtectorUtils.toJson(new Gson(), r108);
    L21:
        r110 = null;
        goto L23
    L10:
        r107 = GsonProtectorUtils.toJson(new Gson(), r106);
    L11:
        r107 = null;
        goto L12
    }

    public static final String a(Map<String, ? extends Object> r100, String r101) {
        if (r100 == null) goto L8;
        Object r102 = r100.get(r101);
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.toString();
    L8:
        return null;
    }
}
