package com.bytedance.sdk.open.aweme.base;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.account.platform.api.ITwitterService;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import com.bytedance.sdk.open.tt.b;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public final class InviteCardObject {
    public static int DirectInvitation = 1;
    public static int NormalInvitation = 0;
    public static final int ROOM_STATE_END = 99;
    public static final int ROOM_STATE_FULL = 10;
    public static final int ROOM_STATE_TEAMING = 1;
    private static final String TAG = "InviteCardObject";
    private static final List<Integer> VALID_STATE = null;

    @SerializedName("app_id")
    public int appId;

    @SerializedName("cover_img")
    public String coverImg;

    @SerializedName("download_schema")
    public String downloadSchema;

    @SerializedName("download_title_hint")
    public String downloadTitleHint;

    @SerializedName("extra")
    public String extra;

    @SerializedName(EventConstants.ExtraJson.GAME_NAME)
    public String gameName;

    @SerializedName("im_card_data")
    public String imCardData;

    @SerializedName("invite_type")
    public int inviteType;

    @SerializedName("invitee_open_id")
    public String inviteeOpenId;

    @SerializedName("link_id")
    public String linkId;

    @SerializedName("room_cur_num")
    public int roomCurNum;

    @SerializedName("room_id")
    public String roomId;

    @SerializedName("room_info")
    public String roomInfo;

    @SerializedName("room_state")
    public int roomState;

    @SerializedName("room_total_num")
    public int roomTotalNum;

    @SerializedName(IPerformanceManager.Params.room_type)
    public String roomType;

    @SerializedName("schema")
    public String schema;

    @SerializedName("share_version")
    public int shareVersion;

    @SerializedName("title_hint")
    public String titleHint;

    @SerializedName(ITwitterService.ResponseConstants.USER_NAME)
    public String userName;

    @SerializedName("user_open_id")
    public String userOpenId;

    @SerializedName("user_rank")
    public String userRank;

    @SerializedName("user_tag")
    public String userTag;

    static {
        VALID_STATE = Arrays.asList(new Integer[]{99, 10, 1});
    }

    public InviteCardObject() {
        this.inviteType = NormalInvitation;
        this.shareVersion = 1;
    }

    public static InviteCardObject unserialize(Bundle r100) {
        String r101 = r100.getString(b.a.f269782f, "");
        if (r101 != null) goto L10;
        return null;
    L10:
        return (InviteCardObject) new Gson().fromJson(r101, InviteCardObject.class);
    L7:
        e = move-exception;
        LogUtils.w(TAG, new Object[]{"", e});
        return null;
    }

    public final boolean checkArgs() {
        String r100 = this.imCardData;
        if (r100 != null) goto L5;
    L24:
        LogUtils.w(TAG, new Object[]{"imCardData is invalid"});
        return false;
    L5:
        if (r100.isEmpty() == true) goto L24;
        int r101 = this.inviteType;
        if (r101 == DirectInvitation) goto L14;
        if (r101 == NormalInvitation) goto L14;
        LogUtils.w(TAG, new Object[]{"inviteType is invalid"});
        return false;
    L14:
        if (TextUtils.isEmpty(this.userOpenId) == false) goto L18;
        LogUtils.d(TAG, new Object[]{"open_id is empty"});
        return false;
    L18:
        if (this.inviteType == DirectInvitation) goto L20;
    L23:
        return true;
    L20:
        if (TextUtils.isEmpty(this.inviteeOpenId) == false) goto L23;
        LogUtils.d(TAG, new Object[]{"The direct invitation requires the open_id of the invitee"});
        return false;
    }

    public final void serialize(Bundle r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.putSerializable(b.a.f269782f, GsonProtectorUtils.toJson(new Gson(), this));
    }
}
