package sg5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.existmember.ExistMemberResult;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.existmember.Member;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements NetService.c<ExistMemberResult> {
    public a() {
    }

    public final Result parse(String r9) throws NetService.ParseException {
        ExistMemberResult r1 = new ExistMemberResult();
        ArrayList r2 = new ArrayList();
        r1.setExistMembers(r2);
        JSONArray r10 = new JSONObject(r9).optJSONObject(WikiFolderPushPlugin.DATA).optJSONArray("existed_collaborators");     // Catch: Exception -> L8
        int r3 = r10.length();     // Catch: Exception -> L8
        int r4 = 0;
    L4:
        if (r4 >= r3) goto L6;
        JSONObject r5 = JSONArrayProtectorUtils.getJSONObject(r10, r4);     // Catch: Exception -> L8
        r2.add(new Member(r5.optInt("collaborator_type"), r5.optString("collaborator_id")));     // Catch: Exception -> L8
        r4 = r4 + 1;     // Catch: Exception -> L8
        goto L4
    L6:
        tt5.a.h("ExistCollaboratorResultParser", "parse(): result = " + r2);     // Catch: Exception -> L8
    L10:
        return r1;
    L8:
        e = move-exception;
        tt5.a.m("ExistCollaboratorResultParser", e);
        goto L10
    }
}
