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
public final class b implements NetService.c<ExistMemberResult> {
    public b() {
    }

    public final Result parse(String r10) throws NetService.ParseException {
        ExistMemberResult r1 = new ExistMemberResult();
        ArrayList r2 = new ArrayList();
        r1.setExistMembers(r2);
        JSONArray r11 = new JSONObject(r10).optJSONObject(WikiFolderPushPlugin.DATA).optJSONArray("existed_members");     // Catch: Exception -> L8
        int r3 = r11.length();     // Catch: Exception -> L8
        int r4 = 0;
    L4:
        if (r4 >= r3) goto L6;
        JSONObject r5 = JSONArrayProtectorUtils.getJSONObject(r11, r4);     // Catch: Exception -> L8
        Member r8 = new Member(r5.optInt("member_type"), r5.optString("member_id"));     // Catch: Exception -> L8
        r8.setPerm(r5.optInt("perm"));     // Catch: Exception -> L8
        r2.add(r8);     // Catch: Exception -> L8
        r4 = r4 + 1;     // Catch: Exception -> L8
        goto L4
    L6:
        tt5.a.h("ExistMemberResultParser", "parse(): result = " + r2);     // Catch: Exception -> L8
    L10:
        return r1;
    L8:
        e = move-exception;
        tt5.a.m("ExistMemberResultParser", e);
        goto L10
    }
}
