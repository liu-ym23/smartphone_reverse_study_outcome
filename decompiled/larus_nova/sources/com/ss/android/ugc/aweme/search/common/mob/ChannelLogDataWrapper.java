package com.ss.android.ugc.aweme.search.common.mob;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/mob/ChannelLogDataWrapper;", "Ljava/io/Serializable;", "channelLogData", "Lcom/ss/android/ugc/aweme/search/common/mob/ChannelLogData;", "(Lcom/ss/android/ugc/aweme/search/common/mob/ChannelLogData;)V", "getChannelLogData", "()Lcom/ss/android/ugc/aweme/search/common/mob/ChannelLogData;", "setChannelLogData", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class ChannelLogDataWrapper implements Serializable {
    private ChannelLogData channelLogData;

    public static /* synthetic */ ChannelLogDataWrapper copy$default(ChannelLogDataWrapper r100, ChannelLogData r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.channelLogData;
    L6:
        return r100.copy(r101);
    }

    public final ChannelLogData component1() {
        return this.channelLogData;
    }

    public final ChannelLogDataWrapper copy(ChannelLogData r100) {
        return new ChannelLogDataWrapper(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChannelLogDataWrapper) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.channelLogData, ((ChannelLogDataWrapper) r100).channelLogData) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        ChannelLogData r100 = this.channelLogData;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "ChannelLogDataWrapper(channelLogData=" + this.channelLogData + ')';
    }

    public final ChannelLogData getChannelLogData() {
        return this.channelLogData;
    }

    public ChannelLogDataWrapper(ChannelLogData r100) {
        this.channelLogData = r100;
    }

    public final void setChannelLogData(ChannelLogData r100) {
        this.channelLogData = r100;
    }
}
