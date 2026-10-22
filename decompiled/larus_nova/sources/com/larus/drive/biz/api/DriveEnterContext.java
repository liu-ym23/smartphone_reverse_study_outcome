package com.larus.drive.biz.api;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/larus/drive/biz/api/DriveEnterContext;", "Ljava/io/Serializable;", "enterFrom", "", "enterTraceId", "clickStartMs", "", "preloadRequestKeyHash", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getEnterFrom", "()Ljava/lang/String;", "getEnterTraceId", "getClickStartMs", "()J", "getPreloadRequestKeyHash", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveEnterContext implements Serializable {
    private final long clickStartMs;
    private final String enterFrom;
    private final String enterTraceId;
    private final String preloadRequestKeyHash;

    public static /* synthetic */ DriveEnterContext copy$default(DriveEnterContext r100, String r101, String r102, long r103, String r104, int r105, Object r110) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.enterFrom;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r102 = r100.enterTraceId;
    L8:
        String r111 = r102;
        if ((r105 & 4) == 0) goto L11;
        r103 = r100.clickStartMs;
    L11:
        long r106 = r103;
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.preloadRequestKeyHash;
    L14:
        String r107 = r101;
        return r100.copy(r107, r111, r106, r104);
    }

    public final String component1() {
        return this.enterFrom;
    }

    public final String component2() {
        return this.enterTraceId;
    }

    public final long component3() {
        return this.clickStartMs;
    }

    public final String component4() {
        return this.preloadRequestKeyHash;
    }

    public final DriveEnterContext copy(String r100, String r101, long r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        Intrinsics.checkNotNullParameter(r101, "enterTraceId");
        return new DriveEnterContext(r100, r101, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DriveEnterContext) == true) goto L8;
        return false;
    L8:
        DriveEnterContext r101 = (DriveEnterContext) r100;
        if (Intrinsics.areEqual(this.enterFrom, r101.enterFrom) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enterTraceId, r101.enterTraceId) == true) goto L15;
        return false;
    L15:
        if (this.clickStartMs == r101.clickStartMs) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.preloadRequestKeyHash, r101.preloadRequestKeyHash) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.enterFrom.hashCode() * 31) + this.enterTraceId.hashCode()) * 31;
        long r101 = this.clickStartMs;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        String r103 = this.preloadRequestKeyHash;
        if (r103 != null) goto L5;
        int r104 = 0;
    L7:
        return r102 + r104;
    L5:
        r104 = r103.hashCode();
        goto L7
    }

    public String toString() {
        return "DriveEnterContext(enterFrom=" + this.enterFrom + ", enterTraceId=" + this.enterTraceId + ", clickStartMs=" + this.clickStartMs + ", preloadRequestKeyHash=" + this.preloadRequestKeyHash + ')';
    }

    public final long getClickStartMs() {
        return this.clickStartMs;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEnterTraceId() {
        return this.enterTraceId;
    }

    public final String getPreloadRequestKeyHash() {
        return this.preloadRequestKeyHash;
    }

    public DriveEnterContext(String r100, String r101, long r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        Intrinsics.checkNotNullParameter(r101, "enterTraceId");
        this.enterFrom = r100;
        this.enterTraceId = r101;
        this.clickStartMs = r102;
        this.preloadRequestKeyHash = r103;
    }

    public /* synthetic */ DriveEnterContext(String r100, String r101, long r102, String r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 8) == 0) goto L5;
        r110 = null;
    L5:
        this(r100, r101, r102, r110);
    }
}
