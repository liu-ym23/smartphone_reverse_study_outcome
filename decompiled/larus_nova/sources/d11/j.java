package d11;

import com.bytedance.android.live.revenuelink.connect.params.ServerInviteParamsSerializableObjectImpl;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(ServerInviteParamsSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Ld11/j;", "Lvh7/j;", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.api.linkmic.InviteParams")
public interface j extends vh7.j<j> {

    @JsonAdapter(ServerInviteParamsSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "invite_type#setter")
    void A7(long r100);

    @FieldName(name = "resolution_height#setter")
    void B(long r100);

    @FieldName(name = "resolution_width#setter")
    void E(long r100);

    @FieldName(name = "bitrate_kbps#setter")
    void F(long r100);

    @FieldName(name = "invitee_followed_user_open_ids#setter")
    void G4(String r100);

    @FieldName(name = "multi_pk_mode#setter")
    void J(int r100);

    @FieldName(name = "resolution_width")
    long K();

    @FieldName(name = "invitee_followed_user_open_ids")
    String Q6();

    @FieldName(name = "battle_config_setting#setter")
    void d8(String r100);

    @FieldName(name = "match_sub_type#setter")
    void d9(int r100);

    @FieldName(name = "activity_name#setter")
    void e1(String r100);

    @FieldName(name = "to_room_id#setter")
    void f(long r100);

    @FieldName(name = "sec_to_user_id#setter")
    void g(String r100);

    @FieldName(name = "activity_name")
    String getActivityName();

    @FieldName(name = "battle_attached_info")
    String getBattleAttachedInfo();

    @FieldName(name = "battle_config_setting")
    String getBattleConfigSetting();

    @FieldName(name = "biz_type")
    int getBizType();

    @FieldName(name = "channel_id")
    long getChannelId();

    @FieldName(name = "client_attached_info")
    String getClientAttachedInfo();

    @FieldName(name = "duration")
    long getDuration();

    @FieldName(name = "invite_source")
    int getInviteSource();

    @FieldName(name = "invite_status")
    int getInviteStatus();

    @FieldName(name = "invite_type")
    long getInviteType();

    @FieldName(name = ILiveRoomPlayFragmentConstant.EXTRA_LOG_MATCH_TYPE)
    String getMatchType();

    @FieldName(name = "multi_pk_mode")
    int getMultiPkMode();

    @FieldName(name = "room_id")
    long getRoomId();

    @FieldName(name = "scene")
    long getScene();

    @FieldName(name = "theme")
    String getTheme();

    @FieldName(name = "to_open_id")
    String getToOpenId();

    @FieldName(name = "to_room_id")
    long getToRoomId();

    @FieldName(name = "client_attached_info#setter")
    void h(String r100);

    @FieldName(name = "bitrate_kbps")
    long j();

    @FieldName(name = "invite_source#setter")
    void k3(int r100);

    @FieldName(name = "sec_to_user_id")
    String l();

    @FieldName(name = "invitee_scene#setter")
    void m7(long r100);

    @FieldName(name = "open_game_app_id#setter")
    void n(String r100);

    @FieldName(name = "match_sub_type")
    int p1();

    @FieldName(name = "invite_status#setter")
    void p9(int r100);

    @FieldName(name = "open_game_app_id")
    String s();

    @FieldName(name = "match_type#setter")
    void s8(String r100);

    @FieldName(name = "battle_attached_info#setter")
    void setBattleAttachedInfo(String r100);

    @FieldName(name = "biz_type#setter")
    void setBizType(int r100);

    @FieldName(name = "channel_id#setter")
    void setChannelId(long r100);

    @FieldName(name = "duration#setter")
    void setDuration(long r100);

    @FieldName(name = "room_id#setter")
    void setRoomId(long r100);

    @FieldName(name = "scene#setter")
    void setScene(long r100);

    @FieldName(name = "theme#setter")
    void setTheme(String r100);

    @FieldName(name = "to_open_id#setter")
    void setToOpenId(String r100);

    @FieldName(name = "to_user_id#setter")
    void setToUserId(long r100);

    @FieldName(name = "resolution_height")
    long x();

    @FieldName(name = "invitee_scene")
    long y5();
}
