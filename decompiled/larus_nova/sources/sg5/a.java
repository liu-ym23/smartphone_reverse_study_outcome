package sg5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.existmember.ExistMemberResult;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.existmember.Member;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements NetService.c<ExistMemberResult> {
    public a() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) throws NetService.ParseException {
        ExistMemberResult r101 = new ExistMemberResult();
        ArrayList r102 = new ArrayList();
        r101.setExistMembers(r102);
        JSONArray r103 = new JSONObject(r100).optJSONObject("data").optJSONArray("existed_collaborators");     // Catch: Exception -> L8
        int r104 = r103.length();     // Catch: Exception -> L8
        int r105 = 0;
    L4:
        if (r105 >= r104) goto L6;
        JSONObject r106 = JSONArrayProtectorUtils.getJSONObject(r103, r105);     // Catch: Exception -> L8
        r102.add(new Member(r106.optInt("collaborator_type"), r106.optString("collaborator_id")));     // Catch: Exception -> L8
        r105 = r105 + 1;     // Catch: Exception -> L8
        goto L4
    L6:
        tt5.a.h("ExistCollaboratorResultParser", "parse(): result = " + r102);     // Catch: Exception -> L8
    L10:
        return r101;
    L8:
        e = move-exception;
        tt5.a.m("ExistCollaboratorResultParser", e);
        goto L10
    }
}
