package yg5;

import com.byted.cast.common.CommonOptionConstants;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink.InviteMemberSendLinkData;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f567499a = 0;

    public static final class a {
        public static InviteMemberSendLinkData a(String r110, ArrayList r111) {
            Intrinsics.checkNotNullParameter(r110, "json");
            InviteMemberSendLinkData r100 = new InviteMemberSendLinkData(0, 0, null, null, null, null, null, null, null, 511, null);
            JSONObject r101 = new JSONObject(r110);     // Catch: Exception -> L14
            JSONObject r112 = r101.optJSONObject("block_user_map");     // Catch: Exception -> L14
            JSONObject r102 = r101.optJSONObject("user_map");     // Catch: Exception -> L14
            if (r112 == null) goto L7;
            if (r102 == null) goto L7;
            r100.setNotNotifyUsers(com.bytedance.ee.bear.middleground.permission.collaborator.invite.a.d(10015, r112, r102));     // Catch: Exception -> L14
            r100.setBlockUsers(com.bytedance.ee.bear.middleground.permission.collaborator.invite.a.d(10021, r112, r102));     // Catch: Exception -> L14
            r100.setBlockedUsers(com.bytedance.ee.bear.middleground.permission.collaborator.invite.a.d(10022, r112, r102));     // Catch: Exception -> L14
            r100.setPrivacyUsers(com.bytedance.ee.bear.middleground.permission.collaborator.invite.a.d(10023, r112, r102));     // Catch: Exception -> L14
            r100.setInviteFailedUsers(com.bytedance.ee.bear.middleground.permission.collaborator.invite.a.d(10024, r112, r102));     // Catch: Exception -> L14
            r100.setLimitUsers(com.bytedance.ee.bear.middleground.permission.collaborator.invite.a.d(CommonOptionConstants.OPTION_SET_SINK_DATA_LISTENER_AUDIO, r112, r102));     // Catch: Exception -> L14
        L7:
            r100.setAskOwnerLimitNum(r101.optInt("limit_num", 20));     // Catch: Exception -> L14
            JSONObject r113 = r101.optJSONObject("fail_members");     // Catch: Exception -> L14
            if (r113 == null) goto L13;
            if (r111 == null) goto L13;
            if ((!r111.isEmpty()) == false) goto L13;
            r100.setOwnerNotInGroups(com.bytedance.ee.bear.middleground.permission.collaborator.invite.a.a(r113, r111));     // Catch: Exception -> L14
        L13:
            return r100;
        L14:
            e = move-exception;
            tt5.a.d("InviteMemberSendLinkErrorParser", "parse()...error = " + e);
            return r100;
        }
    }

    static {
    }
}
