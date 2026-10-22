package com.ss.android.lark.contact.base.entity.bean;

import com.bytedance.lark.pb.im.v2.GetContactTokenResponse;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.utils.m;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.passport.signinsdk_api.account.Tenant;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import java.io.Serializable;
import yzb.b;

/* JADX INFO: loaded from: classes35.dex */
public class InvitationInfo implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ContactAvatarSourceStrategy f418874a = null;
    public boolean canSearchWithToken;
    public String invMsg;
    public String invUrl;
    public String qrUrl;
    public String teamCode;
    public String teamName;
    public String uniqueId;
    public String userAvatarKey;
    public String userName;

    static {
        f418874a = ContactAvatarSourceStrategy.FOREGROUND_USER;
    }

    public String getInAppShareContent() {
        return getInviteMsg();
    }

    public String getShareTitle() {
        return UIHelper.getString(R.string.Lark_UserGrowth_InvitePeopleContactsShareLinkTitle);
    }

    public String getInviteMsg() {
        return this.invMsg;
    }

    public InvitationInfo(ContactAvatarSourceStrategy r100) {
        b r101 = (b) LarkContext.spiByDwarf(b.class);
        Chatter r102 = ImSdkService.d().ue(r101.d());
        this.userName = m.b(r102, ChatterNameDisplayRule.NAME, false);
        User r103 = r101.getForegroundUser();
        if (r103 != null) goto L5;
        return;
    L5:
        if (r100 != ContactAvatarSourceStrategy.LOGIN_CHATTER) goto L10;
        if (r102 == null) goto L10;
        if (r102.getAvatarKey() == null) goto L10;
        String r104 = r102.getAvatarKey();
    L11:
        this.userAvatarKey = r104;
        Tenant r105 = r103.tenant;
        if (r105 == null) goto L16;
        this.teamName = r105.name;
        return;
    L16:
        return;
    L10:
        r104 = r103.avatarKey;
        goto L11
    }

    public static InvitationInfo parseFromPb(GetContactTokenResponse.ContactTokenResponse r100) {
        return parseFromPb(r100, f418874a);
    }

    public static InvitationInfo parseFromPb(GetContactTokenResponse.ContactTokenResponse r100, ContactAvatarSourceStrategy r101) {
        InvitationInfo r102 = new InvitationInfo(r101);
        String r103 = r100.invite_url;
        r102.invUrl = r103;
        r102.qrUrl = r103;
        r102.canSearchWithToken = r100.can_search_with_token.booleanValue();
        r102.invMsg = r100.invite_msg;
        r102.uniqueId = r100.unique_id;
        return r102;
    }
}
