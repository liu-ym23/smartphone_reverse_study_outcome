package com.ss.android.ugc.aweme.feed.model;

import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;
import com.squareup.wire.ProtoAdapter;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\b\u0010\f\u001a\u0004\u0018\u00010\tJ\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006J\u001c\u0010\u000e\u001a\u00020\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\u0010\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\tR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/ss/android/ugc/aweme/feed/model/LogPbBean;", "Ljava/io/Serializable;", "()V", "imprId", "", "logExtra", "", "", "stabExtra", "Lcom/ss/android/ugc/aweme/feed/model/StabExtraStruct;", "getExtra", "getImprId", "getStabExtra", "logPbToMap", "setExtra", "", "extra", "setImprId", "setStabExtra", "Companion", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public class LogPbBean implements Serializable {
    public static final ProtoAdapter<LogPbBean> ADAPTER = null;
    public static final Companion Companion = null;

    @SerializedName("impr_id")
    public String imprId;

    @SerializedName("log_extra")
    public Map<String, Object> logExtra;

    @SerializedName("stab_extra")
    public StabExtraStruct stabExtra;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/aweme/feed/model/LogPbBean$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/ss/android/ugc/aweme/feed/model/LogPbBean;", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        Companion = new Companion(0);
        ADAPTER = new ProtobufLogPbStructV2Adapter();
    }

    public final Map<String, Object> logPbToMap() {
        LinkedTreeMap r100 = new LinkedTreeMap();
        r100.put("impr_id", this.imprId);
        r100.put("log_extra", this.logExtra);
        return r100;
    }

    public LogPbBean() {
    }

    public final Map<String, Object> getExtra() {
        return this.logExtra;
    }

    public final String getImprId() {
        return this.imprId;
    }

    public final StabExtraStruct getStabExtra() {
        return this.stabExtra;
    }

    public final void setExtra(Map<String, Object> r100) {
        this.logExtra = r100;
    }

    public final void setImprId(String r100) {
        this.imprId = r100;
    }

    public final void setStabExtra(StabExtraStruct r100) {
        this.stabExtra = r100;
    }
}
