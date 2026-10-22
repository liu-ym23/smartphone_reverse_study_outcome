package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceEnterContext;", "Ljava/io/Serializable;", "enterTraceId", "", "clickStartMs", "", "enterMethod", "preloadRequestKeyHash", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getEnterTraceId", "()Ljava/lang/String;", "getClickStartMs", "()J", "getEnterMethod", "getPreloadRequestKeyHash", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSpaceEnterContext implements Serializable {
    private final long clickStartMs;
    private final String enterMethod;
    private final String enterTraceId;
    private final String preloadRequestKeyHash;

    public OfficeSpaceEnterContext() {
        this(null, 0, null, null, 15, null);
    }

    public static /* synthetic */ OfficeSpaceEnterContext copy$default(OfficeSpaceEnterContext r100, String r101, long r102, String r103, String r104, int r105, Object r110) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.enterTraceId;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r102 = r100.clickStartMs;
    L8:
        long r106 = r102;
        if ((r105 & 4) == 0) goto L11;
        r103 = r100.enterMethod;
    L11:
        String r111 = r103;
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.preloadRequestKeyHash;
    L14:
        String r107 = r101;
        return r100.copy(r107, r106, r111, r104);
    }

    public final String component1() {
        return this.enterTraceId;
    }

    public final long component2() {
        return this.clickStartMs;
    }

    public final String component3() {
        return this.enterMethod;
    }

    public final String component4() {
        return this.preloadRequestKeyHash;
    }

    public final OfficeSpaceEnterContext copy(String r100, long r101, String r110, String r111) {
        return new OfficeSpaceEnterContext(r100, r101, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OfficeSpaceEnterContext) == true) goto L8;
        return false;
    L8:
        OfficeSpaceEnterContext r101 = (OfficeSpaceEnterContext) r100;
        if (Intrinsics.areEqual(this.enterTraceId, r101.enterTraceId) == true) goto L12;
        return false;
    L12:
        if (this.clickStartMs == r101.clickStartMs) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.enterMethod, r101.enterMethod) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.preloadRequestKeyHash, r101.preloadRequestKeyHash) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.enterTraceId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        long r103 = this.clickStartMs;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        String r105 = this.enterMethod;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.preloadRequestKeyHash;
        if (r108 == null) goto L15;
        r101 = r108.hashCode();
    L15:
        return r107 + r101;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OfficeSpaceEnterContext(enterTraceId=" + this.enterTraceId + ", clickStartMs=" + this.clickStartMs + ", enterMethod=" + this.enterMethod + ", preloadRequestKeyHash=" + this.preloadRequestKeyHash + ')';
    }

    public final long getClickStartMs() {
        return this.clickStartMs;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getEnterTraceId() {
        return this.enterTraceId;
    }

    public final String getPreloadRequestKeyHash() {
        return this.preloadRequestKeyHash;
    }

    public OfficeSpaceEnterContext(String r100, long r101, String r102, String r103) {
        this.enterTraceId = r100;
        this.clickStartMs = r101;
        this.enterMethod = r102;
        this.preloadRequestKeyHash = r103;
    }

    public /* synthetic */ OfficeSpaceEnterContext(String r100, long r101, String r102, String r103, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        long r104 = r101;
        if ((r110 & 4) == 0) goto L12;
        String r105 = null;
    L14:
        if ((r110 & 8) == 0) goto L16;
        String r113 = null;
    L17:
        this(r112, r104, r105, r113);
        return;
    L16:
        r113 = r103;
        goto L17
    L12:
        r105 = r102;
        goto L14
    L5:
        r112 = r100;
        goto L7
    }
}
