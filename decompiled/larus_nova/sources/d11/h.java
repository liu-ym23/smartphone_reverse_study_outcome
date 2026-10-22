package d11;

import com.bytedance.android.live.revenuelink.connect.params.ServerApplyParamsSerializableObjectImpl;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(ServerApplyParamsSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Ld11/h;", "Lvh7/j;", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.api.linkmic.ApplyParams")
public interface h extends vh7.j<h> {

    @JsonAdapter(ServerApplyParamsSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "apply_type#setter")
    void X3(long r100);

    @FieldName(name = "to_room_id#setter")
    void f(long r100);

    @FieldName(name = "sec_to_user_id#setter")
    void g(String r100);

    @FieldName(name = ILiveRoomPlayFragmentConstant.LINK_MIC_APPLY_TYPE)
    long getApplyType();

    @FieldName(name = "channel_id")
    long getChannelId();

    @FieldName(name = "client_attached_info")
    String getClientAttachedInfo();

    @FieldName(name = "room_id")
    long getRoomId();

    @FieldName(name = "scene")
    long getScene();

    @FieldName(name = "to_open_id")
    String getToOpenId();

    @FieldName(name = "to_room_id")
    long getToRoomId();

    @FieldName(name = "client_attached_info#setter")
    void h(String r100);

    @FieldName(name = "sec_to_user_id")
    String l();

    @FieldName(name = "channel_id#setter")
    void setChannelId(long r100);

    @FieldName(name = "room_id#setter")
    void setRoomId(long r100);

    @FieldName(name = "scene#setter")
    void setScene(long r100);

    @FieldName(name = "to_open_id#setter")
    void setToOpenId(String r100);
}
