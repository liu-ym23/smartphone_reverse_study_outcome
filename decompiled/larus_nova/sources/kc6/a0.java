package kc6;

import com.bytedance.android.livesdk.gift.model.e3;
import com.bytedance.kmp.livesdk.gift.platform.aio.model.PluginInfoModelSerializableObjectImpl;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@JsonAdapter(PluginInfoModelSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lkc6/a0;", "Lvh7/j;", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.gift.kmp.dialog.PluginInfoModel")
public interface a0 extends vh7.j<a0> {

    @JsonAdapter(PluginInfoModelSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = e3.KEY_ITEM_POTENTIAL_VALUE_HINT)
    Map<String, String> getItemPotentialValueHint();

    @FieldName(name = "plugin_id")
    long getPluginId();
}
