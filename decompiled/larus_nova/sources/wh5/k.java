package wh5;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.permission.doc.EditionPermissionAction;
import com.bytedance.ee.bear.middleground.permission.permission.doc.EditionUserPermission;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class k implements NetService.c<EditionUserPermission> {

    public static final class a {
    }

    static {
    }

    public k() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r110) {
        JSONObject r111 = new JSONObject(r110).optJSONObject("data");     // Catch: Exception -> L4
        JSONObject r100 = r111.optJSONObject(SlcCommonAction.KEY_ACTIONS);     // Catch: Exception -> L4
        return new EditionUserPermission(r111.optBoolean("is_owner"), r111.optInt("permission_status_code"), new EditionPermissionAction(r100.optInt("operate_entity"), r100.optInt("manage_version")), null, r111.toString());
    L4:
        e = move-exception;
        tt5.a.d("DocUserPermissionParserV2", "parse: " + e);
        return new EditionUserPermission(false, 0, null, null, null, 31, null);
    }
}
