package com.larus.dora.impl.dynamic;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.pitaya.api.PTYSocketStateCallback;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/larus/dora/impl/dynamic/ConnectedGroupModel;", "Lcom/larus/dora/impl/dynamic/entity/ICardProtocol;", "<init>", "()V", WsConstants.KEY_CONNECTION, "Lcom/larus/dora/impl/dynamic/ConnectedGroup;", "getConnection", "()Lcom/larus/dora/impl/dynamic/ConnectedGroup;", "disconnection", "Lcom/larus/dora/impl/dynamic/DisConnectedGroup;", "getDisconnection", "()Lcom/larus/dora/impl/dynamic/DisConnectedGroup;", "shouldVisible", "", PTYSocketStateCallback.CONNECTED, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class g implements d59.j {

    @SerializedName(WsConstants.KEY_CONNECTION)
    private final f connection;

    @SerializedName("disconnection")
    private final k disconnection;

    public g() {
    }

    @Override // d59.j
    public final boolean a(boolean r100) {
        return true;
    }

    public final f b() {
        return this.connection;
    }

    public final k c() {
        return this.disconnection;
    }
}
