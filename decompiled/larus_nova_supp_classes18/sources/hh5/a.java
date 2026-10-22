package hh5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.GetUserGroupResult;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.UserGroup;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements NetService.c<GetUserGroupResult> {
    public a() {
    }

    public final Result parse(String r7) throws NetService.ParseException {
        GetUserGroupResult r0 = new GetUserGroupResult();
        JSONObject r8 = new JSONObject(r7).optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: JSONException -> L15
        if (r8 == null) goto L17;
        JSONArray r9 = r8.optJSONArray("visible_groups");     // Catch: JSONException -> L15
        if (r9 == null) goto L17;
        if (r9.length() <= 0) goto L17;
        ArrayList r1 = new ArrayList();     // Catch: JSONException -> L15
        int r2 = 0;
    L11:
        if (r2 >= r9.length()) goto L13;
        JSONObject r3 = JSONArrayProtectorUtils.getJSONObject(r9, r2);     // Catch: JSONException -> L15
        UserGroup r4 = new UserGroup();     // Catch: JSONException -> L15
        r4.a = r3.optString("group_id");     // Catch: JSONException -> L15
        r4.b = r3.optString("name");     // Catch: JSONException -> L15
        r4.c = JSONObjectProtectorUtils.getInt(r3, "group_type");     // Catch: JSONException -> L15
        r1.add(r4);     // Catch: JSONException -> L15
        r2 = r2 + 1;     // Catch: JSONException -> L15
        goto L11
    L13:
        r0.setVisibleGroups(r1);     // Catch: JSONException -> L15
    L17:
        return r0;
    L15:
        e = move-exception;
        tt5.a.d("GetUserGroupParser", "parse()...error = " + e);
        goto L17
    }
}
