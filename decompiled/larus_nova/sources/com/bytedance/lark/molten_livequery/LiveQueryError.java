package com.bytedance.lark.molten_livequery;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/lark/molten_livequery/LiveQueryError;", "Lcom/bytedance/lark/molten_livequery/UnhandledException;", "code", "Lcom/bytedance/lark/molten_livequery/LiveQueryErrorCode;", "message", "", "<init>", "(Lcom/bytedance/lark/molten_livequery/LiveQueryErrorCode;Ljava/lang/String;)V", "getCode", "()Lcom/bytedance/lark/molten_livequery/LiveQueryErrorCode;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "molten_livequery_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LiveQueryError extends UnhandledException {
    public static final a Companion = null;
    private final LiveQueryErrorCode code;
    private final String message;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ LiveQueryError copy$default(LiveQueryError r100, LiveQueryErrorCode r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.code;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.message;
    L9:
        return r100.copy(r101, r102);
    }

    public final LiveQueryErrorCode component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final LiveQueryError copy(LiveQueryErrorCode r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "message");
        return new LiveQueryError(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LiveQueryError) == true) goto L8;
        return false;
    L8:
        LiveQueryError r101 = (LiveQueryError) r100;
        if (this.code == r101.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.message, r101.message) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.code.hashCode() * 31) + this.message.hashCode();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "LiveQueryError(code=" + this.code + ", message=" + this.message + ')';
    }

    public final LiveQueryErrorCode getCode() {
        return this.code;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public LiveQueryError(LiveQueryErrorCode r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "message");
        super(r101);
        this.code = r100;
        this.message = r101;
    }
}
