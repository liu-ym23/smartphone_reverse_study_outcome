package kc6;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.kmp.livesdk.gift.platform.aio.model.DialogIconSerializableObjectImpl;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@JsonAdapter(DialogIconSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lkc6/i;", "Lvh7/j;", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.gift.kmp.dialog.DialogIcon")
public interface i extends vh7.j<i> {

    @JsonAdapter(DialogIconSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID)
    long getGiftId();

    @FieldName(name = "selected_gift_icon#setter")
    void h6(f0 r100);

    @FieldName(name = "gift_type#setter")
    void i1(int r100);

    @FieldName(name = "prop_info#setter")
    void l1(d0 r100);

    @FieldName(name = "is_prop#setter")
    void n5(boolean r100);

    @FieldName(name = "asset_ids#setter")
    void setAssetIds(List<Long> r100);

    @FieldName(name = "diamond_count#setter")
    void setDiamondCount(int r100);

    @FieldName(name = "group_info#setter")
    void setGiftGroupList(List<? extends com.bytedance.android.livesdk.gift.model.h0> r100);

    @FieldName(name = "gift_id#setter")
    void setGiftId(long r100);

    @FieldName(name = "primary_effect_id#setter")
    void setPrimaryEffectId(long r100);

    @FieldName(name = "selected_dynamic_effect#setter")
    void setSelectedDynamicEffect(long r100);

    @FieldName(name = "default_gift_icon#setter")
    void x5(h r100);

    @FieldName(name = "banner_scheme_url#setter")
    void z0(String r100);
}
