package com.bytedance.geckox.policy.meta;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/geckox/policy/meta/MetaDataItemNew;", "Ljava/io/Serializable;", "", "lastReadTimeStamp", "J", "getLastReadTimeStamp", "()J", "setLastReadTimeStamp", "(J)V", "", "allowUpdate", "Z", "getAllowUpdate", "()Z", "setAllowUpdate", "(Z)V", "lastCleanTimeStamp", "getLastCleanTimeStamp", "setLastCleanTimeStamp", "<init>", "(JZJ)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final class MetaDataItemNew implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 2;
    private boolean allowUpdate;
    private long lastCleanTimeStamp;
    private long lastReadTimeStamp;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final boolean getAllowUpdate() {
        return this.allowUpdate;
    }

    public final long getLastCleanTimeStamp() {
        return this.lastCleanTimeStamp;
    }

    public final long getLastReadTimeStamp() {
        return this.lastReadTimeStamp;
    }

    public final void setAllowUpdate(boolean r100) {
        this.allowUpdate = r100;
    }

    public final void setLastCleanTimeStamp(long r100) {
        this.lastCleanTimeStamp = r100;
    }

    public final void setLastReadTimeStamp(long r100) {
        this.lastReadTimeStamp = r100;
    }

    public MetaDataItemNew(long r100, boolean r101, long r102) {
        this.lastReadTimeStamp = r100;
        this.allowUpdate = r101;
        this.lastCleanTimeStamp = r102;
    }

    public /* synthetic */ MetaDataItemNew(long r100, boolean r101, long r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 2) == 0) goto L5;
        boolean r102 = true;
    L7:
        if ((r111 & 4) == 0) goto L9;
        r110 = 0;
    L9:
        this(r100, r102, r110);
        return;
    L5:
        r102 = r101;
        goto L7
    }
}
