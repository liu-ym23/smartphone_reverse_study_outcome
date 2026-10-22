package com.bytedance.kmp.livesdk.gift.platform.aio.model;

import com.bytedance.android.livesdk.gift.model.e3;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kc6.a0;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR0\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/bytedance/kmp/livesdk/gift/platform/aio/model/PluginInfoModelSerializableObjectImpl;", "Lkc6/a0;", "", "pluginId", "J", "getPluginId", "()J", "setPluginId", "(J)V", "", "", "itemPotentialValueHint", "Ljava/util/Map;", "getItemPotentialValueHint", "()Ljava/util/Map;", "setItemPotentialValueHint", "(Ljava/util/Map;)V", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PluginInfoModelSerializableObjectImpl implements a0 {

    @SerializedName(e3.KEY_ITEM_POTENTIAL_VALUE_HINT)
    private Map<String, String> itemPotentialValueHint;

    @SerializedName("plugin_id")
    private long pluginId;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/kmp/livesdk/gift/platform/aio/model/PluginInfoModelSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(PluginInfoModelSerializableObjectImpl.class);
        }
    }

    public PluginInfoModelSerializableObjectImpl() {
    }

    @Override // kc6.a0
    public final Map<String, String> getItemPotentialValueHint() {
        return this.itemPotentialValueHint;
    }

    @Override // kc6.a0
    public final long getPluginId() {
        return this.pluginId;
    }
}
