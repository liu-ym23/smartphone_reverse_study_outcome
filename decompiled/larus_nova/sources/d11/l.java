package d11;

import com.bytedance.android.live.revenuelink.connect.params.ServerReplyParamsSerializableObjectImpl;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(ServerReplyParamsSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Ld11/l;", "Lvh7/j;", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.api.linkmic.ReplyParams")
public interface l extends vh7.j<l> {

    @JsonAdapter(ServerReplyParamsSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "resolution_height#setter")
    void B(long r100);

    @FieldName(name = "resolution_width#setter")
    void E(long r100);

    @FieldName(name = "bitrate_kbps#setter")
    void F(long r100);

    @FieldName(name = "reply_status#setter")
    void F8(long r100);

    @FieldName(name = "multi_pk_mode#setter")
    void J(int r100);

    @FieldName(name = "resolution_width")
    long K();

    @FieldName(name = "sec_invite_user_id")
    String N8();

    @FieldName(name = "invite_open_id#setter")
    void R7(String r100);

    @FieldName(name = "invite_open_id")
    String V5();

    @FieldName(name = "biz_type")
    int getBizType();

    @FieldName(name = "channel_id")
    long getChannelId();

    @FieldName(name = "client_attached_info")
    String getClientAttachedInfo();

    @FieldName(name = ILiveRoomPlayFragmentConstant.EXTRA_LOG_MATCH_TYPE)
    long getMatchType();

    @FieldName(name = "multi_pk_mode")
    int getMultiPkMode();

    @FieldName(name = "reply_status")
    long getReplyStatus();

    @FieldName(name = "room_id")
    long getRoomId();

    @FieldName(name = "scene")
    long getScene();

    @FieldName(name = "switch_play_mode")
    int getSwitchPlayMode();

    @FieldName(name = "client_attached_info#setter")
    void h(String r100);

    @FieldName(name = "bitrate_kbps")
    long j();

    @FieldName(name = "sec_invite_user_id#setter")
    void k7(String r100);

    @FieldName(name = "open_game_app_id#setter")
    void n(String r100);

    @FieldName(name = "switch_play_mode#setter")
    void p4(int r100);

    @FieldName(name = "open_game_app_id")
    String s();

    @FieldName(name = "biz_type#setter")
    void setBizType(int r100);

    @FieldName(name = "channel_id#setter")
    void setChannelId(long r100);

    @FieldName(name = "match_type#setter")
    void setMatchType(long r100);

    @FieldName(name = "room_id#setter")
    void setRoomId(long r100);

    @FieldName(name = "scene#setter")
    void setScene(long r100);

    @FieldName(name = "resolution_height")
    long x();
}
