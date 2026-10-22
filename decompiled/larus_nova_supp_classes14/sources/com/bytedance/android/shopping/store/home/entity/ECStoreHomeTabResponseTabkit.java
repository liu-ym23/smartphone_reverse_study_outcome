package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR0\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R0\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R$\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ECStoreHomeTabResponseTabkit;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "Lcom/bytedance/android/shopping/store/tabkit/model/z;", "tabkitResponse", "Lcom/bytedance/android/shopping/store/tabkit/model/z;", "getTabkitResponse", "()Lcom/bytedance/android/shopping/store/tabkit/model/z;", "setTabkitResponse", "(Lcom/bytedance/android/shopping/store/tabkit/model/z;)V", "", "", "perfLogExtra", "Ljava/util/Map;", "getPerfLogExtra", "()Ljava/util/Map;", "setPerfLogExtra", "(Ljava/util/Map;)V", "logExtra", "getLogExtra", "setLogExtra", "", "chunkIndex", "Ljava/lang/Integer;", "getChunkIndex", "()Ljava/lang/Integer;", "setChunkIndex", "(Ljava/lang/Integer;)V", "", "isLastChunk", "Z", "()Z", "setLastChunk", "(Z)V", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreHomeTabResponseTabkit extends CommerceBaseResponse {

    @SerializedName("chunk_index")
    private Integer chunkIndex;

    @SerializedName("is_last_chunk")
    private boolean isLastChunk;

    @SerializedName("log_extra")
    private Map<String, String> logExtra;

    @SerializedName("perf_log_extra")
    private Map<String, String> perfLogExtra;

    @SerializedName("tabkit_response")
    private com.bytedance.android.shopping.store.tabkit.model.z tabkitResponse;

    public ECStoreHomeTabResponseTabkit() {
    }

    public final Integer getChunkIndex() {
        return this.chunkIndex;
    }

    public final Map<String, String> getLogExtra() {
        return this.logExtra;
    }

    public final Map<String, String> getPerfLogExtra() {
        return this.perfLogExtra;
    }

    public final com.bytedance.android.shopping.store.tabkit.model.z getTabkitResponse() {
        return this.tabkitResponse;
    }

    public final boolean isLastChunk() {
        return this.isLastChunk;
    }

    public final void setChunkIndex(Integer r1) {
        this.chunkIndex = r1;
    }

    public final void setLastChunk(boolean r1) {
        this.isLastChunk = r1;
    }

    public final void setLogExtra(Map<String, String> r1) {
        this.logExtra = r1;
    }

    public final void setPerfLogExtra(Map<String, String> r1) {
        this.perfLogExtra = r1;
    }

    public final void setTabkitResponse(com.bytedance.android.shopping.store.tabkit.model.z r1) {
        this.tabkitResponse = r1;
    }
}
