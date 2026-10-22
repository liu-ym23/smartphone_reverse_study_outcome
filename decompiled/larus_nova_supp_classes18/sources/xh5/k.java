package xh5;

import com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptions;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static BlockOptions c(JSONObject r14) {
        HashMap r2 = a(r14, "share_entity");
        HashMap r3 = a(r14, "manage_collaborator_entity");
        HashMap r6 = a(r14, "security");
        HashMap r9 = a(r14, "comment");
        return new BlockOptions(r2, r3, a(r14, "external_access_switch"), a(r14, "share_external_entity"), r6, null, null, r9, a(r14, "link_share_entity"), null, 608, null);
    }

    public static BlockOptionsV2 d(JSONObject r14) {
        ArrayList r2 = b(r14, "share_entity");
        ArrayList r3 = b(r14, "manage_collaborator_entity");
        ArrayList r6 = b(r14, "security");
        ArrayList r9 = b(r14, "comment");
        return new BlockOptionsV2(r2, r3, b(r14, "external_access_switch"), b(r14, "share_external_entity"), r6, null, null, r9, b(r14, "link_share_entity"), null, 608, null);
    }

    public static HashMap a(JSONObject r6, String r7) {
        HashMap r0 = new HashMap();
        JSONArray r8 = r6.optJSONArray(r7);
        if (r8 != null) goto L5;
        r8 = new JSONArray();
    L5:
        int r9 = r8.length();
        int r2 = 0;
    L6:
        if (r2 >= r9) goto L15;
        JSONObject r3 = r8.optJSONObject(r2);
        if (r3 == null) goto L10;
        int r4 = r3.optInt("value");
    L11:
        if (r3 == null) goto L13;
        int r5 = r3.optInt("block_type");
    L14:
        r0.put(Integer.valueOf(r4), Integer.valueOf(r5));
        r2 = r2 + 1;
        goto L6
    L13:
        r5 = 0;
        goto L14
    L10:
        r4 = 0;
        goto L11
    L15:
        return r0;
    }

    public static ArrayList b(JSONObject r9, String r10) {
        ArrayList r0 = new ArrayList();
        JSONArray r11 = r9.optJSONArray(r10);
        if (r11 != null) goto L5;
        r11 = new JSONArray();
    L5:
        int r12 = r11.length();
        int r2 = 0;
    L6:
        if (r2 >= r12) goto L21;
        JSONObject r3 = r11.optJSONObject(r2);
        if (r3 == null) goto L10;
        int r5 = r3.optInt("block_type");
    L11:
        if (r3 == null) goto L13;
        int r6 = r3.optInt("value");
    L14:
        if (r3 == null) goto L16;
        boolean r7 = r3.optBoolean("can_escape");
    L17:
        if (r3 == null) goto L19;
        boolean r4 = r3.optBoolean("is_escaped");
    L20:
        r0.add(new BlockOptionsV2.BlockEntity(r5, r6, r7, r4));
        r2 = r2 + 1;
        goto L6
    L19:
        r4 = false;
        goto L20
    L16:
        r7 = false;
        goto L17
    L13:
        r6 = 0;
        goto L14
    L10:
        r5 = 0;
        goto L11
    L21:
        return r0;
    }
}
