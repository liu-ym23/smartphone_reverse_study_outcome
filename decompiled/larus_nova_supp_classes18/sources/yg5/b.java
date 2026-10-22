package yg5;

import com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink.InviteMemberSendLinkData;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static InviteMemberSendLinkData a(String r13, ArrayList r14) {
            Intrinsics.checkNotNullParameter(r13, "json");
            InviteMemberSendLinkData r0 = new InviteMemberSendLinkData(0, 0, null, null, null, null, null, null, null, 511, null);
            JSONObject r1 = new JSONObject(r13);     // Catch: Exception -> L14
            JSONObject r15 = r1.optJSONObject("block_user_map");     // Catch: Exception -> L14
            JSONObject r2 = r1.optJSONObject("user_map");     // Catch: Exception -> L14
            if (r15 == null) goto L7;
            if (r2 == null) goto L7;
            r0.setNotNotifyUsers(com.bytedance.ee.bear.middleground.permission.collaborator.invite.a.d(10015, r15, r2));     // Catch: Exception -> L14
            r0.setBlockUsers(com.bytedance.ee.bear.middleground.permission.collaborator.invite.a.d(10021, r15, r2));     // Catch: Exception -> L14
            r0.setBlockedUsers(com.bytedance.ee.bear.middleground.permission.collaborator.invite.a.d(10022, r15, r2));     // Catch: Exception -> L14
            r0.setPrivacyUsers(com.bytedance.ee.bear.middleground.permission.collaborator.invite.a.d(10023, r15, r2));     // Catch: Exception -> L14
            r0.setInviteFailedUsers(com.bytedance.ee.bear.middleground.permission.collaborator.invite.a.d(10024, r15, r2));     // Catch: Exception -> L14
            r0.setLimitUsers(com.bytedance.ee.bear.middleground.permission.collaborator.invite.a.d(10025, r15, r2));     // Catch: Exception -> L14
        L7:
            r0.setAskOwnerLimitNum(r1.optInt("limit_num", 20));     // Catch: Exception -> L14
            JSONObject r16 = r1.optJSONObject("fail_members");     // Catch: Exception -> L14
            if (r16 == null) goto L13;
            if (r14 == null) goto L13;
            if ((!r14.isEmpty()) == false) goto L13;
            r0.setOwnerNotInGroups(com.bytedance.ee.bear.middleground.permission.collaborator.invite.a.a(r16, r14));     // Catch: Exception -> L14
        L13:
            return r0;
        L14:
            e = move-exception;
            tt5.a.d("InviteMemberSendLinkErrorParser", "parse()...error = " + e);
            return r0;
        }
    }

    static {
    }
}
