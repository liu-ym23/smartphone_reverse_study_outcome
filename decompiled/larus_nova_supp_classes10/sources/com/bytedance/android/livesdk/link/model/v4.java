package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\r\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0007\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u0015\u001a\u00020\u00118&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00168&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0007\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001b8&X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0007\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010$\u001a\u0004\u0018\u00010 8&X§\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0007\u001a\u0004\b!\u0010\"R\u001a\u0010'\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0007\u001a\u0004\b%\u0010\u000bR\u001a\u0010,\u001a\u00020(8&X§\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0007\u001a\u0004\b)\u0010*R\u001a\u0010/\u001a\u00020(8&X§\u0004¢\u0006\f\u0012\u0004\b.\u0010\u0007\u001a\u0004\b-\u0010*R\u001c\u00104\u001a\u0004\u0018\u0001008&X§\u0004¢\u0006\f\u0012\u0004\b3\u0010\u0007\u001a\u0004\b1\u00102R\u001a\u00107\u001a\u00020(8&X§\u0004¢\u0006\f\u0012\u0004\b6\u0010\u0007\u001a\u0004\b5\u0010*R\u001a\u0010<\u001a\u0002088&X§\u0004¢\u0006\f\u0012\u0004\b;\u0010\u0007\u001a\u0004\b9\u0010:R\u001c\u0010A\u001a\u0004\u0018\u00010=8&X§\u0004¢\u0006\f\u0012\u0004\b@\u0010\u0007\u001a\u0004\b>\u0010?R\u001a\u0010D\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\bC\u0010\u0007\u001a\u0004\bB\u0010\u000bR\u001a\u0010G\u001a\u00020(8&X§\u0004¢\u0006\f\u0012\u0004\bF\u0010\u0007\u001a\u0004\bE\u0010*R\u001e\u0010M\u001a\u00060Hj\u0002`I8&X§\u0004¢\u0006\f\u0012\u0004\bL\u0010\u0007\u001a\u0004\bJ\u0010KR\u001c\u0010P\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\bO\u0010\u0007\u001a\u0004\bN\u0010\u000bR\u001c\u0010S\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\bR\u0010\u0007\u001a\u0004\bQ\u0010\u000b¨\u0006T"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/v4;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/m0;", "", "getSupportMultiInvite", "()Z", "getSupportMultiInvite$annotations", "()V", "supportMultiInvite", "", "getLinkMicIdStr", "()Ljava/lang/String;", "getLinkMicIdStr$annotations", "linkMicIdStr", "getRtcExtInfo", "getRtcExtInfo$annotations", "rtcExtInfo", "", "getWaitSec", "()J", "getWaitSec$annotations", "waitSec", "Lcom/bytedance/android/livesdk/link/model/d7;", "getMultiLiveCoreInfo", "()Lcom/bytedance/android/livesdk/link/model/d7;", "getMultiLiveCoreInfo$annotations", "multiLiveCoreInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "getMultiRtcInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "getMultiRtcInfo$annotations", "multiRtcInfo", "Lcom/bytedance/android/livesdk/link/model/b7;", "getMultiChannelInfo", "()Lcom/bytedance/android/livesdk/link/model/b7;", "getMultiChannelInfo$annotations", "multiChannelInfo", "getToast", "getToast$annotations", "toast", "", "getPkCheckState", "()I", "getPkCheckState$annotations", "pkCheckState", "getSwitchPlayMode", "getSwitchPlayMode$annotations", "switchPlayMode", "Lcom/bytedance/android/livesdk/link/model/aa;", "getVoteSetting", "()Lcom/bytedance/android/livesdk/link/model/aa;", "getVoteSetting$annotations", "voteSetting", "getVendor", "getVendor$annotations", "vendor", "Lcom/bytedance/android/livesdk/link/model/bridge/k2;", "getVersionInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/k2;", "getVersionInfo$annotations", "versionInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/b2;", "getPreRtcInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/b2;", "getPreRtcInfo$annotations", "preRtcInfo", "getBattleAttachedInfo", "getBattleAttachedInfo$annotations", "battleAttachedInfo", "getBizType", "getBizType$annotations", "bizType", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomKt;", "getInviteeRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getInviteeRoom$annotations", "inviteeRoom", "getLynxData", "getLynxData$annotations", "lynxData", "getEventTrackingInfo", "getEventTrackingInfo$annotations", "eventTrackingInfo", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface v4 extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.m0>, com.bytedance.android.livesdk.link.model.bridge.m0 {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "battle_attached_info")
    String getBattleAttachedInfo();

    @FieldName(name = "biz_type")
    int getBizType();

    /* synthetic */ long getChannelId();

    @FieldName(name = "event_tracking_info")
    String getEventTrackingInfo();

    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "invitee_room")
    IRoom getInviteeRoom();

    /* synthetic */ boolean getInviteeWithAudience();

    @FieldName(name = "linkmic_id_str")
    String getLinkMicIdStr();

    @FieldName(name = "linkmic_lynx_data")
    String getLynxData();

    @FieldName(name = "multi_channel_info")
    b7 getMultiChannelInfo();

    @FieldName(name = "multi_live_core_info")
    d7 getMultiLiveCoreInfo();

    @FieldName(name = "multi_rtc_info")
    com.bytedance.android.livesdk.link.model.bridge.v1 getMultiRtcInfo();

    @FieldName(name = "anchor_pk_check")
    int getPkCheckState();

    @FieldName(name = "pre_rtc_info")
    com.bytedance.android.livesdk.link.model.bridge.b2 getPreRtcInfo();

    @FieldName(name = "rtc_ext_info")
    String getRtcExtInfo();

    /* synthetic */ long getScene();

    @FieldName(name = "support_multi_invite")
    boolean getSupportMultiInvite();

    @FieldName(name = "switch_play_mode")
    int getSwitchPlayMode();

    @FieldName(name = "toast")
    String getToast();

    @FieldName(name = "vendor")
    int getVendor();

    @FieldName(name = "invitee_version_info")
    com.bytedance.android.livesdk.link.model.bridge.k2 getVersionInfo();

    @FieldName(name = "vote_setting")
    aa getVoteSetting();

    @FieldName(name = "wait_sec")
    long getWaitSec();

    /* synthetic */ List<String> get_cannotPkAnchorIds();
}
