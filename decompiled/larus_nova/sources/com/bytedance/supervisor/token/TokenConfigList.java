package com.bytedance.supervisor.token;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/supervisor/token/TokenConfigList;", "Ljava/io/Serializable;", "()V", "configList", "", "Lcom/bytedance/supervisor/token/TokenConfig;", "getConfigList", "()Ljava/util/List;", "token_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TokenConfigList implements Serializable {

    @SerializedName("token_config")
    private final List<TokenConfig> configList;

    public TokenConfigList() {
        this.configList = CollectionsKt.emptyList();
    }

    public final List<TokenConfig> getConfigList() {
        return this.configList;
    }
}
