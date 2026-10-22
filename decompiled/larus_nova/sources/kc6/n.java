package kc6;

import com.bytedance.kmp.livesdk.gift.platform.aio.model.GiftDIYCardModelSerializableObjectImpl;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@JsonAdapter(GiftDIYCardModelSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lkc6/n;", "Lvh7/j;", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.gift.kmp.dialog.GiftDIYCardModel")
public interface n extends vh7.j<n> {

    @JsonAdapter(GiftDIYCardModelSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "card_name")
    String getCardName();

    @FieldName(name = "config_id")
    long getConfigId();

    @FieldName(name = "config_id_str")
    String getConfigIdStr();

    @FieldName(name = "config_id#setter")
    void setConfigId(long r100);

    @FieldName(name = "config_id_str#setter")
    void setConfigIdStr(String r100);

    @FieldName(name = com.bytedance.android.livesdk.gift.model.n.KEY_PLUGINS)
    List<a0> y();
}
