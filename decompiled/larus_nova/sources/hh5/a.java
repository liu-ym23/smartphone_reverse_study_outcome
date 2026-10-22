package hh5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.GetUserGroupResult;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.UserGroup;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements NetService.c<GetUserGroupResult> {
    public a() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) throws NetService.ParseException {
        GetUserGroupResult r101 = new GetUserGroupResult();
        JSONObject r102 = new JSONObject(r100).optJSONObject("data");     // Catch: JSONException -> L15
        if (r102 == null) goto L17;
        JSONArray r103 = r102.optJSONArray("visible_groups");     // Catch: JSONException -> L15
        if (r103 == null) goto L17;
        if (r103.length() <= 0) goto L17;
        ArrayList r104 = new ArrayList();     // Catch: JSONException -> L15
        int r105 = 0;
    L11:
        if (r105 >= r103.length()) goto L13;
        JSONObject r106 = JSONArrayProtectorUtils.getJSONObject(r103, r105);     // Catch: JSONException -> L15
        UserGroup r107 = new UserGroup();     // Catch: JSONException -> L15
        r107.f233642a = r106.optString("group_id");     // Catch: JSONException -> L15
        r107.f233643b = r106.optString("name");     // Catch: JSONException -> L15
        r107.f233644c = JSONObjectProtectorUtils.getInt(r106, "group_type");     // Catch: JSONException -> L15
        r104.add(r107);     // Catch: JSONException -> L15
        r105 = r105 + 1;     // Catch: JSONException -> L15
        goto L11
    L13:
        r101.setVisibleGroups(r104);     // Catch: JSONException -> L15
    L17:
        return r101;
    L15:
        e = move-exception;
        tt5.a.d("GetUserGroupParser", "parse()...error = " + e);
        goto L17
    }
}
