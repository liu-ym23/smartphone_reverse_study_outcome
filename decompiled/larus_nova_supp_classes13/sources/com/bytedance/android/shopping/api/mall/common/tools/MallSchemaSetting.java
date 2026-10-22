package com.bytedance.android.shopping.api.mall.common.tools;

import com.bytedance.android.ec.hybrid.data.entity.MallLynxSchemaConfig;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/tools/MallSchemaSetting;", "Ljava/io/Serializable;", "()V", "cardConfig", "", "Lcom/bytedance/android/ec/hybrid/data/entity/MallLynxSchemaConfig;", "getCardConfig", "()Ljava/util/List;", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MallSchemaSetting implements Serializable {

    @SerializedName("card_config")
    private final List<MallLynxSchemaConfig> cardConfig;

    public MallSchemaSetting() {
    }

    public final List<MallLynxSchemaConfig> getCardConfig() {
        return this.cardConfig;
    }
}
