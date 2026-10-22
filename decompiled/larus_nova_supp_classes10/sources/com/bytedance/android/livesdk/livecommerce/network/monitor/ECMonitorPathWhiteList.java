package com.bytedance.android.livesdk.livecommerce.network.monitor;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/network/monitor/ECMonitorPathWhiteList;", "Ljava/io/Serializable;", "()V", "paths", "", "", "getPaths", "()Ljava/util/List;", "setPaths", "(Ljava/util/List;)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMonitorPathWhiteList implements Serializable {

    @SerializedName("paths")
    private List<String> paths;

    public ECMonitorPathWhiteList() {
    }

    public final List<String> getPaths() {
        return this.paths;
    }

    public final void setPaths(List<String> r1) {
        this.paths = r1;
    }
}
