package com.larus.platform.model.chat;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/larus/platform/model/chat/MessageListOptConfig;", "", "asyncAiSdkInit", "", "savePreloadMsgOpt", "savePreloadMsgIntervalMs", "", "mergeMessageListUpdates", "loadMoreOnEmptyFirstPage", "<init>", "(ZZJZZ)V", "getAsyncAiSdkInit", "()Z", "getSavePreloadMsgOpt", "getSavePreloadMsgIntervalMs", "()J", "getMergeMessageListUpdates", "getLoadMoreOnEmptyFirstPage", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d0 {

    @SerializedName("async_ai_sdk_init")
    private final boolean asyncAiSdkInit;

    @SerializedName("load_more_on_empty_first_page")
    private final boolean loadMoreOnEmptyFirstPage;

    @SerializedName("merge_message_list_updates")
    private final boolean mergeMessageListUpdates;

    @SerializedName("save_preload_msg_interval_ms")
    private final long savePreloadMsgIntervalMs;

    @SerializedName("save_preload_msg_opt")
    private final boolean savePreloadMsgOpt;

    public d0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d0) == true) goto L8;
        return false;
    L8:
        d0 r101 = (d0) r100;
        if (this.asyncAiSdkInit == r101.asyncAiSdkInit) goto L12;
        return false;
    L12:
        if (this.savePreloadMsgOpt == r101.savePreloadMsgOpt) goto L15;
        return false;
    L15:
        if (this.savePreloadMsgIntervalMs == r101.savePreloadMsgIntervalMs) goto L18;
        return false;
    L18:
        if (this.mergeMessageListUpdates == r101.mergeMessageListUpdates) goto L21;
        return false;
    L21:
        if (this.loadMoreOnEmptyFirstPage == r101.loadMoreOnEmptyFirstPage) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.asyncAiSdkInit == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.savePreloadMsgOpt == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        long r105 = this.savePreloadMsgIntervalMs;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        if (this.mergeMessageListUpdates == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        if (this.loadMoreOnEmptyFirstPage == true) goto L19;
        r100 = 1237;
    L19:
        return r108 + r100;
    L13:
        r107 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "MessageListOptConfig(asyncAiSdkInit=" + this.asyncAiSdkInit + ", savePreloadMsgOpt=" + this.savePreloadMsgOpt + ", savePreloadMsgIntervalMs=" + this.savePreloadMsgIntervalMs + ", mergeMessageListUpdates=" + this.mergeMessageListUpdates + ", loadMoreOnEmptyFirstPage=" + this.loadMoreOnEmptyFirstPage + ')';
    }

    public final boolean a() {
        return this.asyncAiSdkInit;
    }

    public final boolean b() {
        return this.loadMoreOnEmptyFirstPage;
    }

    public final boolean c() {
        return this.mergeMessageListUpdates;
    }

    public final long d() {
        return this.savePreloadMsgIntervalMs;
    }

    public final boolean e() {
        return this.savePreloadMsgOpt;
    }

    public d0(int r100) {
        this.asyncAiSdkInit = false;
        this.savePreloadMsgOpt = false;
        this.savePreloadMsgIntervalMs = 500;
        this.mergeMessageListUpdates = false;
        this.loadMoreOnEmptyFirstPage = false;
    }
}
