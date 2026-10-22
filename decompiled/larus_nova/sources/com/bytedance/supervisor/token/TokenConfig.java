package com.bytedance.supervisor.token;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u00020\f8\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/supervisor/token/TokenConfig;", "Ljava/io/Serializable;", "()V", "atomicInfoList", "", "", "getAtomicInfoList", "()Ljava/util/List;", LocationMonitorConst.IDENTIFIER, "getIdentifier", "()Ljava/lang/String;", "status", "", "getStatus$annotations", "getStatus", "()I", "token_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TokenConfig implements Serializable {

    @SerializedName("psda_atomicinfo")
    private final List<String> atomicInfoList;

    @SerializedName(LocationMonitorConst.IDENTIFIER)
    private final String identifier;

    @SerializedName("status")
    private final int status;

    public static /* synthetic */ void getStatus$annotations() {
    }

    public TokenConfig() {
        this.identifier = "";
        this.atomicInfoList = CollectionsKt.emptyList();
    }

    public final List<String> getAtomicInfoList() {
        return this.atomicInfoList;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final int getStatus() {
        return this.status;
    }
}
