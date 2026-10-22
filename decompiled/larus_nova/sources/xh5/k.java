package xh5;

import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptions;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f563884a = 0;

    static {
    }

    public static BlockOptions c(JSONObject r110) {
        HashMap r100 = a(r110, "share_entity");
        HashMap r101 = a(r110, "manage_collaborator_entity");
        HashMap r102 = a(r110, AppConstants.API_HOST_SI_PREFIX);
        HashMap r103 = a(r110, "comment");
        return new BlockOptions(r100, r101, a(r110, "external_access_switch"), a(r110, "share_external_entity"), r102, null, null, r103, a(r110, "link_share_entity"), null, 608, null);
    }

    public static BlockOptionsV2 d(JSONObject r110) {
        ArrayList r100 = b(r110, "share_entity");
        ArrayList r101 = b(r110, "manage_collaborator_entity");
        ArrayList r102 = b(r110, AppConstants.API_HOST_SI_PREFIX);
        ArrayList r103 = b(r110, "comment");
        return new BlockOptionsV2(r100, r101, b(r110, "external_access_switch"), b(r110, "share_external_entity"), r102, null, null, r103, b(r110, "link_share_entity"), null, 608, null);
    }

    public static HashMap a(JSONObject r100, String r101) {
        HashMap r102 = new HashMap();
        JSONArray r103 = r100.optJSONArray(r101);
        if (r103 != null) goto L5;
        r103 = new JSONArray();
    L5:
        int r104 = r103.length();
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L15;
        JSONObject r106 = r103.optJSONObject(r105);
        if (r106 == null) goto L10;
        int r107 = r106.optInt("value");
    L11:
        if (r106 == null) goto L13;
        int r108 = r106.optInt("block_type");
    L14:
        r102.put(Integer.valueOf(r107), Integer.valueOf(r108));
        r105 = r105 + 1;
        goto L6
    L13:
        r108 = 0;
        goto L14
    L10:
        r107 = 0;
        goto L11
    L15:
        return r102;
    }

    public static ArrayList b(JSONObject r100, String r110) {
        ArrayList r101 = new ArrayList();
        JSONArray r102 = r100.optJSONArray(r110);
        if (r102 != null) goto L5;
        r102 = new JSONArray();
    L5:
        int r111 = r102.length();
        int r103 = 0;
    L6:
        if (r103 >= r111) goto L21;
        JSONObject r104 = r102.optJSONObject(r103);
        if (r104 == null) goto L10;
        int r105 = r104.optInt("block_type");
    L11:
        if (r104 == null) goto L13;
        int r106 = r104.optInt("value");
    L14:
        if (r104 == null) goto L16;
        boolean r107 = r104.optBoolean("can_escape");
    L17:
        if (r104 == null) goto L19;
        boolean r108 = r104.optBoolean("is_escaped");
    L20:
        r101.add(new BlockOptionsV2.BlockEntity(r105, r106, r107, r108));
        r103 = r103 + 1;
        goto L6
    L19:
        r108 = false;
        goto L20
    L16:
        r107 = false;
        goto L17
    L13:
        r106 = 0;
        goto L14
    L10:
        r105 = 0;
        goto L11
    L21:
        return r101;
    }
}
