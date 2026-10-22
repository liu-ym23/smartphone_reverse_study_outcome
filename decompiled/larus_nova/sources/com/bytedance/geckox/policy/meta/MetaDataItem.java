package com.bytedance.geckox.policy.meta;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/geckox/policy/meta/MetaDataItem;", "Ljava/io/Serializable;", "lastReadTimeStamp", "", "allowUpdate", "", "(JZ)V", "getAllowUpdate", "()Z", "setAllowUpdate", "(Z)V", "getLastReadTimeStamp", "()J", "setLastReadTimeStamp", "(J)V", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
public final class MetaDataItem implements Serializable {
    private boolean allowUpdate;
    private long lastReadTimeStamp;

    public final boolean getAllowUpdate() {
        return this.allowUpdate;
    }

    public final long getLastReadTimeStamp() {
        return this.lastReadTimeStamp;
    }

    public final void setAllowUpdate(boolean r100) {
        this.allowUpdate = r100;
    }

    public final void setLastReadTimeStamp(long r100) {
        this.lastReadTimeStamp = r100;
    }

    public MetaDataItem(long r100, boolean r101) {
        this.lastReadTimeStamp = r100;
        this.allowUpdate = r101;
    }

    public /* synthetic */ MetaDataItem(long r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = true;
    L5:
        this(r100, r101);
    }
}
