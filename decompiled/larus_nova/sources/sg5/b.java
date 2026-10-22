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
public final class b implements NetService.c<ExistMemberResult> {
    public b() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r110) throws NetService.ParseException {
        ExistMemberResult r100 = new ExistMemberResult();
        ArrayList r101 = new ArrayList();
        r100.setExistMembers(r101);
        JSONArray r111 = new JSONObject(r110).optJSONObject("data").optJSONArray("existed_members");     // Catch: Exception -> L8
        int r102 = r111.length();     // Catch: Exception -> L8
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L6;
        JSONObject r104 = JSONArrayProtectorUtils.getJSONObject(r111, r103);     // Catch: Exception -> L8
        Member r105 = new Member(r104.optInt("member_type"), r104.optString("member_id"));     // Catch: Exception -> L8
        r105.setPerm(r104.optInt("perm"));     // Catch: Exception -> L8
        r101.add(r105);     // Catch: Exception -> L8
        r103 = r103 + 1;     // Catch: Exception -> L8
        goto L4
    L6:
        tt5.a.h("ExistMemberResultParser", "parse(): result = " + r101);     // Catch: Exception -> L8
    L10:
        return r100;
    L8:
        e = move-exception;
        tt5.a.m("ExistMemberResultParser", e);
        goto L10
    }
}
