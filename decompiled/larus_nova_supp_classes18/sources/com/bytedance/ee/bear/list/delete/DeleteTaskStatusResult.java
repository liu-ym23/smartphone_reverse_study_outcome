package com.bytedance.ee.bear.list.delete;

import com.bytedance.ee.util.io.NonProguard;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R&\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00140\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/list/delete/DeleteTaskStatusResult;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "isFinish", "", "()Z", "setFinish", "(Z)V", "isFail", "setFail", "failData", "", "", "", "getFailData", "()Ljava/util/Map;", "setFailData", "(Ljava/util/Map;)V", "failedTokenToCode", "", "getFailedTokenToCode", "setFailedTokenToCode", "contentmanager-list-export-min_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeleteTaskStatusResult implements NonProguard {
    private Map<String, ? extends Object> failData;
    private Map<String, Integer> failedTokenToCode;
    private boolean isFail;
    private boolean isFinish;

    public DeleteTaskStatusResult() {
        this.failedTokenToCode = MapsKt.emptyMap();
    }

    public final Map<String, Object> getFailData() {
        return this.failData;
    }

    public final Map<String, Integer> getFailedTokenToCode() {
        return this.failedTokenToCode;
    }

    public final boolean isFail() {
        return this.isFail;
    }

    public final boolean isFinish() {
        return this.isFinish;
    }

    public final void setFail(boolean r1) {
        this.isFail = r1;
    }

    public final void setFailData(Map<String, ? extends Object> r1) {
        this.failData = r1;
    }

    public final void setFailedTokenToCode(Map<String, Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.failedTokenToCode = r2;
    }

    public final void setFinish(boolean r1) {
        this.isFinish = r1;
    }
}
