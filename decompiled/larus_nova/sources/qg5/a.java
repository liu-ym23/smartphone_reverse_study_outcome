package qg5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.collaborator.askowner.AskOwnerModel$BlockMember;
import com.bytedance.ee.bear.middleground.permission.collaborator.askowner.AskOwnerModel$FailMember;
import com.bytedance.ee.bear.middleground.permission.collaborator.askowner.AskOwnerModel$ResultData;
import com.bytedance.ee.bear.middleground.permission.collaborator.askowner.AskOwnerModel$SendResult;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements NetService.c<AskOwnerModel$SendResult> {

    /* JADX INFO: renamed from: qg5.a$a, reason: collision with other inner class name */
    public static final class C7325a {
    }

    static {
    }

    public a() {
    }

    public static AskOwnerModel$SendResult a(String r110) {
        Intrinsics.checkNotNullParameter(r110, "json");
        AskOwnerModel$SendResult r100 = new AskOwnerModel$SendResult();
        JSONObject r101 = new JSONObject(r110);     // Catch: Exception -> L21
        r100.code = r101.optInt("code");     // Catch: Exception -> L21
        r100.msg = r101.optString("msg");     // Catch: Exception -> L21
        if (r100.code == 0) goto L6;
        return r100;
    L6:
        r100.data = new AskOwnerModel$ResultData(null, 0, null, 0, 15, null);     // Catch: Exception -> L21
        JSONObject r111 = JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(r101, "data"), "fail_members");     // Catch: Exception -> L21
        Iterator<String> r102 = r111.keys();     // Catch: Exception -> L21
    L8:
        if (r102.hasNext() == false) goto L13;
        String r103 = r102.next();     // Catch: Exception -> L21
        ArrayList r104 = new ArrayList();     // Catch: Exception -> L21
        JSONArray r105 = JSONObjectProtectorUtils.getJSONArray(r111, r103);     // Catch: Exception -> L21
        int r106 = r105.length();     // Catch: Exception -> L21
        int r107 = 0;
    L10:
        if (r107 >= r106) goto L12;
        AskOwnerModel$FailMember r112 = new AskOwnerModel$FailMember(r105.optJSONObject(r107).optString("owner_id"));     // Catch: Exception -> L21
        AskOwnerModel$ResultData r113 = (AskOwnerModel$ResultData) r100.data;     // Catch: Exception -> L21
        r113.setFailCount(r113.getFailCount() + 1);     // Catch: Exception -> L21
        r104.add(r112);     // Catch: Exception -> L21
        r107 = r107 + 1;     // Catch: Exception -> L21
        goto L10
    L12:
        ((AskOwnerModel$ResultData) r100.data).getFailMembers().put(r103, r104);     // Catch: Exception -> L21
        goto L8
    L13:
        JSONObject r114 = JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(r101, "data"), "block_user_map");     // Catch: Exception -> L21
        Iterator<String> r108 = r114.keys();     // Catch: Exception -> L21
    L14:
        if (r108.hasNext() == false) goto L23;
        String r109 = r108.next();     // Catch: Exception -> L21
        ArrayList r115 = new ArrayList();     // Catch: Exception -> L21
        JSONArray r116 = JSONObjectProtectorUtils.getJSONArray(r114, r109);     // Catch: Exception -> L21
        int r117 = r116.length();     // Catch: Exception -> L21
        int r118 = 0;
    L17:
        if (r118 >= r117) goto L19;
        AskOwnerModel$BlockMember r119 = new AskOwnerModel$BlockMember(r116.optString(r118));     // Catch: Exception -> L21
        AskOwnerModel$ResultData r120 = (AskOwnerModel$ResultData) r100.data;     // Catch: Exception -> L21
        r120.setBlockCount(r120.getBlockCount() + 1);     // Catch: Exception -> L21
        r115.add(r119);     // Catch: Exception -> L21
        r118 = r118 + 1;     // Catch: Exception -> L21
        goto L17
    L19:
        ((AskOwnerModel$ResultData) r100.data).getBlockMembers().put(r109, r115);     // Catch: Exception -> L21
    L23:
        return r100;
    L21:
        e = move-exception;
        tt5.a.f("AskOwnerModel.Parser", e, false);
        goto L23
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final /* bridge */ /* synthetic */ Result parse(String r100) {
        return a(r100);
    }
}
