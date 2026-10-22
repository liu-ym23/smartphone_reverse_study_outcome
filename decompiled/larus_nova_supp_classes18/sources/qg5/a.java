package qg5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.collaborator.askowner.AskOwnerModel$BlockMember;
import com.bytedance.ee.bear.middleground.permission.collaborator.askowner.AskOwnerModel$FailMember;
import com.bytedance.ee.bear.middleground.permission.collaborator.askowner.AskOwnerModel$ResultData;
import com.bytedance.ee.bear.middleground.permission.collaborator.askowner.AskOwnerModel$SendResult;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements NetService.c<AskOwnerModel$SendResult> {

    /* JADX INFO: renamed from: qg5.a$a, reason: collision with other inner class name */
    public static final class C0296a {
    }

    static {
    }

    public a() {
    }

    public static AskOwnerModel$SendResult a(String r13) {
        Intrinsics.checkNotNullParameter(r13, "json");
        AskOwnerModel$SendResult r1 = new AskOwnerModel$SendResult();
        JSONObject r3 = new JSONObject(r13);     // Catch: Exception -> L21
        ((Result) r1).code = r3.optInt("code");     // Catch: Exception -> L21
        ((Result) r1).msg = r3.optString("msg");     // Catch: Exception -> L21
        if (((Result) r1).code == 0) goto L6;
        return r1;
    L6:
        ((Result) r1).data = new AskOwnerModel$ResultData(null, 0, null, 0, 15, null);     // Catch: Exception -> L21
        JSONObject r14 = JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(r3, WikiFolderPushPlugin.DATA), "fail_members");     // Catch: Exception -> L21
        Iterator<String> r4 = r14.keys();     // Catch: Exception -> L21
    L8:
        if (r4.hasNext() == false) goto L13;
        String r5 = r4.next();     // Catch: Exception -> L21
        ArrayList r6 = new ArrayList();     // Catch: Exception -> L21
        JSONArray r7 = JSONObjectProtectorUtils.getJSONArray(r14, r5);     // Catch: Exception -> L21
        int r8 = r7.length();     // Catch: Exception -> L21
        int r9 = 0;
    L10:
        if (r9 >= r8) goto L12;
        final String r10 = r7.optJSONObject(r9).optString("owner_id");     // Catch: Exception -> L21
        Serializable r11 = new AskOwnerModel$FailMember(r10);     // Catch: Exception -> L21
        AskOwnerModel$ResultData r12 = (AskOwnerModel$ResultData) ((Result) r1).data;     // Catch: Exception -> L21
        r12.setFailCount(r12.getFailCount() + 1);     // Catch: Exception -> L21
        r6.add(r11);     // Catch: Exception -> L21
        r9 = r9 + 1;     // Catch: Exception -> L21
        goto L10
    L12:
        ((AskOwnerModel$ResultData) ((Result) r1).data).getFailMembers().put(r5, r6);     // Catch: Exception -> L21
        goto L8
    L13:
        JSONObject r15 = JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(r3, WikiFolderPushPlugin.DATA), "block_user_map");     // Catch: Exception -> L21
        Iterator<String> r0 = r15.keys();     // Catch: Exception -> L21
    L14:
        if (r0.hasNext() == false) goto L23;
        String r16 = r0.next();     // Catch: Exception -> L21
        ArrayList r17 = new ArrayList();     // Catch: Exception -> L21
        JSONArray r18 = JSONObjectProtectorUtils.getJSONArray(r15, r16);     // Catch: Exception -> L21
        int r19 = r18.length();     // Catch: Exception -> L21
        int r20 = 0;
    L17:
        if (r20 >= r19) goto L19;
        final String r21 = r18.optString(r20);     // Catch: Exception -> L21
        Serializable r22 = new AskOwnerModel$BlockMember(r21);     // Catch: Exception -> L21
        AskOwnerModel$ResultData r23 = (AskOwnerModel$ResultData) ((Result) r1).data;     // Catch: Exception -> L21
        r23.setBlockCount(r23.getBlockCount() + 1);     // Catch: Exception -> L21
        r17.add(r22);     // Catch: Exception -> L21
        r20 = r20 + 1;     // Catch: Exception -> L21
        goto L17
    L19:
        ((AskOwnerModel$ResultData) ((Result) r1).data).getBlockMembers().put(r16, r17);     // Catch: Exception -> L21
    L23:
        return r1;
    L21:
        e = move-exception;
        tt5.a.f("AskOwnerModel.Parser", e, false);
        goto L23
    }

    public final /* bridge */ /* synthetic */ Result parse(String r1) {
        return a(r1);
    }
}
