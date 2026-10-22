package com.bytedance.locallife.live.goodsshelves.manager;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/manager/LiveLocalLifeApiException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "statusCode", "", com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG, "", "(ILjava/lang/String;)V", "getStatusCode", "()I", "getStatusMsg", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class LiveLocalLifeApiException extends RuntimeException {
    private final int statusCode;
    private final String statusMsg;

    public static /* synthetic */ LiveLocalLifeApiException copy$default(LiveLocalLifeApiException r100, int r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.statusCode;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.statusMsg;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.statusCode;
    }

    public final String component2() {
        return this.statusMsg;
    }

    public final LiveLocalLifeApiException copy(int r100, String r101) {
        return new LiveLocalLifeApiException(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LiveLocalLifeApiException) == true) goto L8;
        return false;
    L8:
        LiveLocalLifeApiException r101 = (LiveLocalLifeApiException) r100;
        if (this.statusCode == r101.statusCode) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.statusMsg, r101.statusMsg) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.statusCode * 31;
        String r101 = this.statusMsg;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "LiveLocalLifeApiException(statusCode=" + this.statusCode + ", statusMsg=" + this.statusMsg + ')';
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final String getStatusMsg() {
        return this.statusMsg;
    }

    public LiveLocalLifeApiException(int r100, String r101) {
        this.statusCode = r100;
        this.statusMsg = r101;
    }

    public /* synthetic */ LiveLocalLifeApiException(int r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        this(r100, r101);
    }
}
