package com.bytedance.live.bizlink.impl.platform.dynamic.base;

import ch6.b;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b2\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4¨\u00065"}, d2 = {"Lcom/bytedance/live/bizlink/impl/platform/dynamic/base/MultiLinkHybMediaChangeAction;", "", "Lch6/b;", "", ReportConstant.COMMON_ACTION_TYPE, "Ljava/lang/String;", "getActionType", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "RtcSetLocalUserVisibility", "RtcUpdateToken", "RtcSendTextMessageToUser", "RtcSendRoomTextMessage", "RtcSendBinaryMessageToUser", "RtcSendRoomBinaryMessage", "RtcStartForwardStreamToOtherRooms", "RtcUpdateForwardStreamToOtherRoomsConfig", "RtcStopForwardStreamToOtherRooms", "RtcPauseForwardStreamToOtherRooms", "RtcResumeForwardStreamToOtherRooms", "MuteLocalVideo", "MuteLocalAudio", "MuteOtherVideo", "MuteOtherAudio", "MuteOtherRoomAudio", "RtcSubscribeRemoteVideoStream", "RtcSubscribeRemoteAudioStream", "RtcSubscribeAllRemoteVideoStreams", "RtcSubscribeAllRemoteAudioStreams", "RtcUpdateRtcExtInfo", "RtcJoinRtcExRoom", "RtcLeaveRtcExRoom", "RTC_SET_AUDIO_SCENARIO", "RTC_SET_AUDIO_ENCODE_CONFIG", "RtcSubscribeExRoomStream", "RtcUnSubscribeExRoomStream", "RtcSubscribeStream", "RtcUnSubscribeStream", "RtcPublishStream", "RtcUnPublishStream", "RtcUnPublishExRoomStream", "RtcPublishExRoomStream", "RtcSetSingleViewMode", "RtcSwitchStreamMixType", "LiveCoreStopPlay", "LiveCoreResumePlay", "LiveCoreStartAudioCapture", "LiveCoreStopAudioCapture", "LiveCoreStartVideoCapture", "LiveCoreStopVideoCapture", "LiveCoreSwitchVideoCaptureDevice", "LiveCoreSwitchResolution", "multi-biz-link-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MultiLinkHybMediaChangeAction extends Enum<MultiLinkHybMediaChangeAction> implements b {
    public static final a Companion = null;
    public static final MultiLinkHybMediaChangeAction LiveCoreResumePlay = null;
    public static final MultiLinkHybMediaChangeAction LiveCoreStartAudioCapture = null;
    public static final MultiLinkHybMediaChangeAction LiveCoreStartVideoCapture = null;
    public static final MultiLinkHybMediaChangeAction LiveCoreStopAudioCapture = null;
    public static final MultiLinkHybMediaChangeAction LiveCoreStopPlay = null;
    public static final MultiLinkHybMediaChangeAction LiveCoreStopVideoCapture = null;
    public static final MultiLinkHybMediaChangeAction LiveCoreSwitchResolution = null;
    public static final MultiLinkHybMediaChangeAction LiveCoreSwitchVideoCaptureDevice = null;
    public static final MultiLinkHybMediaChangeAction MuteLocalAudio = null;
    public static final MultiLinkHybMediaChangeAction MuteLocalVideo = null;
    public static final MultiLinkHybMediaChangeAction MuteOtherAudio = null;
    public static final MultiLinkHybMediaChangeAction MuteOtherRoomAudio = null;
    public static final MultiLinkHybMediaChangeAction MuteOtherVideo = null;
    public static final MultiLinkHybMediaChangeAction RTC_SET_AUDIO_ENCODE_CONFIG = null;
    public static final MultiLinkHybMediaChangeAction RTC_SET_AUDIO_SCENARIO = null;
    public static final MultiLinkHybMediaChangeAction RtcJoinRtcExRoom = null;
    public static final MultiLinkHybMediaChangeAction RtcLeaveRtcExRoom = null;
    public static final MultiLinkHybMediaChangeAction RtcPauseForwardStreamToOtherRooms = null;
    public static final MultiLinkHybMediaChangeAction RtcPublishExRoomStream = null;
    public static final MultiLinkHybMediaChangeAction RtcPublishStream = null;
    public static final MultiLinkHybMediaChangeAction RtcResumeForwardStreamToOtherRooms = null;
    public static final MultiLinkHybMediaChangeAction RtcSendBinaryMessageToUser = null;
    public static final MultiLinkHybMediaChangeAction RtcSendRoomBinaryMessage = null;
    public static final MultiLinkHybMediaChangeAction RtcSendRoomTextMessage = null;
    public static final MultiLinkHybMediaChangeAction RtcSendTextMessageToUser = null;
    public static final MultiLinkHybMediaChangeAction RtcSetLocalUserVisibility = null;
    public static final MultiLinkHybMediaChangeAction RtcSetSingleViewMode = null;
    public static final MultiLinkHybMediaChangeAction RtcStartForwardStreamToOtherRooms = null;
    public static final MultiLinkHybMediaChangeAction RtcStopForwardStreamToOtherRooms = null;
    public static final MultiLinkHybMediaChangeAction RtcSubscribeAllRemoteAudioStreams = null;
    public static final MultiLinkHybMediaChangeAction RtcSubscribeAllRemoteVideoStreams = null;
    public static final MultiLinkHybMediaChangeAction RtcSubscribeExRoomStream = null;
    public static final MultiLinkHybMediaChangeAction RtcSubscribeRemoteAudioStream = null;
    public static final MultiLinkHybMediaChangeAction RtcSubscribeRemoteVideoStream = null;
    public static final MultiLinkHybMediaChangeAction RtcSubscribeStream = null;
    public static final MultiLinkHybMediaChangeAction RtcSwitchStreamMixType = null;
    public static final MultiLinkHybMediaChangeAction RtcUnPublishExRoomStream = null;
    public static final MultiLinkHybMediaChangeAction RtcUnPublishStream = null;
    public static final MultiLinkHybMediaChangeAction RtcUnSubscribeExRoomStream = null;
    public static final MultiLinkHybMediaChangeAction RtcUnSubscribeStream = null;
    public static final MultiLinkHybMediaChangeAction RtcUpdateForwardStreamToOtherRoomsConfig = null;
    public static final MultiLinkHybMediaChangeAction RtcUpdateRtcExtInfo = null;
    public static final MultiLinkHybMediaChangeAction RtcUpdateToken = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MultiLinkHybMediaChangeAction[] f254893a = null;
    private final String actionType;

    public static final class a {
        public a() {
        }
    }

    public static MultiLinkHybMediaChangeAction valueOf(String r100) {
        return (MultiLinkHybMediaChangeAction) r27.a.a(MultiLinkHybMediaChangeAction.class, r100);
    }

    public static MultiLinkHybMediaChangeAction[] values() {
        return (MultiLinkHybMediaChangeAction[]) f254893a.clone();
    }

    static {
        MultiLinkHybMediaChangeAction r100 = new MultiLinkHybMediaChangeAction("RtcSetLocalUserVisibility", 0, "rtc_set_local_user_visibility");
        RtcSetLocalUserVisibility = r100;
        MultiLinkHybMediaChangeAction r101 = new MultiLinkHybMediaChangeAction("RtcUpdateToken", 1, "rtc_update_token");
        RtcUpdateToken = r101;
        MultiLinkHybMediaChangeAction r102 = new MultiLinkHybMediaChangeAction("RtcSendTextMessageToUser", 2, "rtc_send_txt_msg_to_user");
        RtcSendTextMessageToUser = r102;
        MultiLinkHybMediaChangeAction r103 = new MultiLinkHybMediaChangeAction("RtcSendRoomTextMessage", 3, "rtc_send_room_txt_msg");
        RtcSendRoomTextMessage = r103;
        MultiLinkHybMediaChangeAction r104 = new MultiLinkHybMediaChangeAction("RtcSendBinaryMessageToUser", 4, "rtc_send_binary_msg_to_user");
        RtcSendBinaryMessageToUser = r104;
        MultiLinkHybMediaChangeAction r105 = new MultiLinkHybMediaChangeAction("RtcSendRoomBinaryMessage", 5, "rtc_send_room_binary_msg");
        RtcSendRoomBinaryMessage = r105;
        MultiLinkHybMediaChangeAction r106 = new MultiLinkHybMediaChangeAction("RtcStartForwardStreamToOtherRooms", 6, "rtc_start_forward_stream_to_other_rooms");
        RtcStartForwardStreamToOtherRooms = r106;
        MultiLinkHybMediaChangeAction r107 = new MultiLinkHybMediaChangeAction("RtcUpdateForwardStreamToOtherRoomsConfig", 7, "rtc_update_forward_stream_to_other_rooms_config");
        RtcUpdateForwardStreamToOtherRoomsConfig = r107;
        MultiLinkHybMediaChangeAction r108 = new MultiLinkHybMediaChangeAction("RtcStopForwardStreamToOtherRooms", 8, "rtc_stop_forward_stream_to_other_rooms");
        RtcStopForwardStreamToOtherRooms = r108;
        MultiLinkHybMediaChangeAction r109 = new MultiLinkHybMediaChangeAction("RtcPauseForwardStreamToOtherRooms", 9, "rtc_pause_forward_stream_to_other_rooms");
        RtcPauseForwardStreamToOtherRooms = r109;
        MultiLinkHybMediaChangeAction r110 = new MultiLinkHybMediaChangeAction("RtcResumeForwardStreamToOtherRooms", 10, "rtc_resume_forward_stream_to_other_rooms");
        RtcResumeForwardStreamToOtherRooms = r110;
        MultiLinkHybMediaChangeAction r111 = new MultiLinkHybMediaChangeAction("MuteLocalVideo", 11, "mute_local_video");
        MuteLocalVideo = r111;
        MultiLinkHybMediaChangeAction r112 = new MultiLinkHybMediaChangeAction("MuteLocalAudio", 12, "mute_local_audio");
        MuteLocalAudio = r112;
        MultiLinkHybMediaChangeAction r113 = new MultiLinkHybMediaChangeAction("MuteOtherVideo", 13, "mute_other_video");
        MuteOtherVideo = r113;
        MultiLinkHybMediaChangeAction r114 = new MultiLinkHybMediaChangeAction("MuteOtherAudio", 14, "mute_other_audio");
        MuteOtherAudio = r114;
        MultiLinkHybMediaChangeAction r115 = new MultiLinkHybMediaChangeAction("MuteOtherRoomAudio", 15, "mute_other_room_audio");
        MuteOtherRoomAudio = r115;
        MultiLinkHybMediaChangeAction r116 = new MultiLinkHybMediaChangeAction("RtcSubscribeRemoteVideoStream", 16, "rtc_subscribe_remote_video_stream");
        RtcSubscribeRemoteVideoStream = r116;
        MultiLinkHybMediaChangeAction r117 = new MultiLinkHybMediaChangeAction("RtcSubscribeRemoteAudioStream", 17, "rtc_subscribe_remote_audio_stream");
        RtcSubscribeRemoteAudioStream = r117;
        MultiLinkHybMediaChangeAction r118 = new MultiLinkHybMediaChangeAction("RtcSubscribeAllRemoteVideoStreams", 18, "rtc_subscribe_all_remote_video_streams");
        RtcSubscribeAllRemoteVideoStreams = r118;
        MultiLinkHybMediaChangeAction r119 = new MultiLinkHybMediaChangeAction("RtcSubscribeAllRemoteAudioStreams", 19, "rtc_subscribe_all_remote_audio_streams");
        RtcSubscribeAllRemoteAudioStreams = r119;
        MultiLinkHybMediaChangeAction r120 = new MultiLinkHybMediaChangeAction("RtcUpdateRtcExtInfo", 20, "update_rtc_ext_info");
        RtcUpdateRtcExtInfo = r120;
        MultiLinkHybMediaChangeAction r121 = new MultiLinkHybMediaChangeAction("RtcJoinRtcExRoom", 21, "join_rtc_ex_room");
        RtcJoinRtcExRoom = r121;
        MultiLinkHybMediaChangeAction r122 = new MultiLinkHybMediaChangeAction("RtcLeaveRtcExRoom", 22, "leave_rtc_ex_room");
        RtcLeaveRtcExRoom = r122;
        MultiLinkHybMediaChangeAction r123 = new MultiLinkHybMediaChangeAction("RTC_SET_AUDIO_SCENARIO", 23, "rtc_set_audio_scenario");
        RTC_SET_AUDIO_SCENARIO = r123;
        MultiLinkHybMediaChangeAction r124 = new MultiLinkHybMediaChangeAction("RTC_SET_AUDIO_ENCODE_CONFIG", 24, "rtc_set_audio_encode_config");
        RTC_SET_AUDIO_ENCODE_CONFIG = r124;
        MultiLinkHybMediaChangeAction r125 = new MultiLinkHybMediaChangeAction("RtcSubscribeExRoomStream", 25, "rtc_subscribe_ex_room_stream");
        RtcSubscribeExRoomStream = r125;
        MultiLinkHybMediaChangeAction r126 = new MultiLinkHybMediaChangeAction("RtcUnSubscribeExRoomStream", 26, "rtc_unsubscribe_ex_room_stream");
        RtcUnSubscribeExRoomStream = r126;
        MultiLinkHybMediaChangeAction r127 = new MultiLinkHybMediaChangeAction("RtcSubscribeStream", 27, "rtc_subscribe_stream");
        RtcSubscribeStream = r127;
        MultiLinkHybMediaChangeAction r128 = new MultiLinkHybMediaChangeAction("RtcUnSubscribeStream", 28, "rtc_unsubscribe_stream");
        RtcUnSubscribeStream = r128;
        MultiLinkHybMediaChangeAction r129 = new MultiLinkHybMediaChangeAction("RtcPublishStream", 29, "rtc_publish_stream");
        RtcPublishStream = r129;
        MultiLinkHybMediaChangeAction r130 = new MultiLinkHybMediaChangeAction("RtcUnPublishStream", 30, "rtc_unpublish_stream");
        RtcUnPublishStream = r130;
        MultiLinkHybMediaChangeAction r131 = new MultiLinkHybMediaChangeAction("RtcUnPublishExRoomStream", 31, "un_publish_ex_room_stream");
        RtcUnPublishExRoomStream = r131;
        MultiLinkHybMediaChangeAction r132 = new MultiLinkHybMediaChangeAction("RtcPublishExRoomStream", 32, "publish_ex_room_stream");
        RtcPublishExRoomStream = r132;
        MultiLinkHybMediaChangeAction r133 = new MultiLinkHybMediaChangeAction("RtcSetSingleViewMode", 33, "rtc_set_single_view_mode");
        RtcSetSingleViewMode = r133;
        MultiLinkHybMediaChangeAction r134 = new MultiLinkHybMediaChangeAction("RtcSwitchStreamMixType", 34, "rtc_set_stream_mix_type");
        RtcSwitchStreamMixType = r134;
        MultiLinkHybMediaChangeAction r135 = new MultiLinkHybMediaChangeAction("LiveCoreStopPlay", 35, "live_core_stop_play");
        LiveCoreStopPlay = r135;
        MultiLinkHybMediaChangeAction r136 = new MultiLinkHybMediaChangeAction("LiveCoreResumePlay", 36, "live_core_resume_play");
        LiveCoreResumePlay = r136;
        MultiLinkHybMediaChangeAction r137 = new MultiLinkHybMediaChangeAction("LiveCoreStartAudioCapture", 37, "live_core_start_audio_capture");
        LiveCoreStartAudioCapture = r137;
        MultiLinkHybMediaChangeAction r138 = new MultiLinkHybMediaChangeAction("LiveCoreStopAudioCapture", 38, "live_core_stop_audio_capture");
        LiveCoreStopAudioCapture = r138;
        MultiLinkHybMediaChangeAction r139 = new MultiLinkHybMediaChangeAction("LiveCoreStartVideoCapture", 39, "live_core_start_video_capture");
        LiveCoreStartVideoCapture = r139;
        MultiLinkHybMediaChangeAction r140 = new MultiLinkHybMediaChangeAction("LiveCoreStopVideoCapture", 40, "live_core_stop_video_capture");
        LiveCoreStopVideoCapture = r140;
        MultiLinkHybMediaChangeAction r141 = new MultiLinkHybMediaChangeAction("LiveCoreSwitchVideoCaptureDevice", 41, "live_core_switch_video_capture_device");
        LiveCoreSwitchVideoCaptureDevice = r141;
        MultiLinkHybMediaChangeAction r142 = new MultiLinkHybMediaChangeAction("LiveCoreSwitchResolution", 42, "live_core_switch_resolution");
        LiveCoreSwitchResolution = r142;
        f254893a = new MultiLinkHybMediaChangeAction[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142};
        Companion = new a();
    }

    public final String getActionType() {
        return this.actionType;
    }

    public MultiLinkHybMediaChangeAction(String r100, int r101, String r102) {
        super(r100, r101);
        this.actionType = r102;
    }
}
