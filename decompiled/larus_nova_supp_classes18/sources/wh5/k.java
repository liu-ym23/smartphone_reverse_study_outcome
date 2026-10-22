package wh5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.permission.doc.EditionPermissionAction;
import com.bytedance.ee.bear.middleground.permission.permission.doc.EditionUserPermission;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k implements NetService.c<EditionUserPermission> {

    public static final class a {
    }

    static {
    }

    public k() {
    }

    public final Result parse(String r10) {
        JSONObject r11 = new JSONObject(r10).optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: Exception -> L4
        JSONObject r0 = r11.optJSONObject("actions");     // Catch: Exception -> L4
        return new EditionUserPermission(r11.optBoolean("is_owner"), r11.optInt("permission_status_code"), new EditionPermissionAction(r0.optInt("operate_entity"), r0.optInt("manage_version")), null, r11.toString());
    L4:
        e = move-exception;
        tt5.a.d("DocUserPermissionParserV2", "parse: " + e);
        return new EditionUserPermission(false, 0, null, null, null, 31, null);
    }
}
