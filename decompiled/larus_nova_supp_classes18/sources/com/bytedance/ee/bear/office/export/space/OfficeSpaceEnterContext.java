package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceEnterContext;", "Ljava/io/Serializable;", "enterTraceId", "", "clickStartMs", "", "enterMethod", "preloadRequestKeyHash", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getEnterTraceId", "()Ljava/lang/String;", "getClickStartMs", "()J", "getEnterMethod", "getPreloadRequestKeyHash", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSpaceEnterContext implements Serializable {
    private final long clickStartMs;
    private final String enterMethod;
    private final String enterTraceId;
    private final String preloadRequestKeyHash;

    public OfficeSpaceEnterContext() {
        this(null, 0, null, null, 15, null);
    }

    public static /* synthetic */ OfficeSpaceEnterContext copy$default(OfficeSpaceEnterContext r3, String r4, long r5, String r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.enterTraceId;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.clickStartMs;
    L8:
        long r0 = r5;
        if ((r9 & 4) == 0) goto L11;
        r7 = r3.enterMethod;
    L11:
        String r11 = r7;
        if ((r9 & 8) == 0) goto L14;
        r8 = r3.preloadRequestKeyHash;
    L14:
        String r6 = r4;
        return r3.copy(r6, r0, r11, r8);
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

    public final OfficeSpaceEnterContext copy(String r8, long r9, String r11, String r12) {
        return new OfficeSpaceEnterContext(r8, r9, r11, r12);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof OfficeSpaceEnterContext) == true) goto L8;
        return false;
    L8:
        OfficeSpaceEnterContext r9 = (OfficeSpaceEnterContext) r8;
        if (Intrinsics.areEqual(this.enterTraceId, r9.enterTraceId) == true) goto L12;
        return false;
    L12:
        if (this.clickStartMs == r9.clickStartMs) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.enterMethod, r9.enterMethod) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.preloadRequestKeyHash, r9.preloadRequestKeyHash) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.enterTraceId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        long r3 = this.clickStartMs;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        String r5 = this.enterMethod;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.preloadRequestKeyHash;
        if (r8 == null) goto L15;
        r1 = r8.hashCode();
    L15:
        return r7 + r1;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
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

    public OfficeSpaceEnterContext(String r1, long r2, String r4, String r5) {
        this.enterTraceId = r1;
        this.clickStartMs = r2;
        this.enterMethod = r4;
        this.preloadRequestKeyHash = r5;
    }

    public /* synthetic */ OfficeSpaceEnterContext(String r5, long r6, String r8, String r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        String r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        r6 = 0;
    L9:
        long r1 = r6;
        if ((r10 & 4) == 0) goto L12;
        String r3 = null;
    L14:
        if ((r10 & 8) == 0) goto L16;
        String r13 = null;
    L17:
        this(r12, r1, r3, r13);
        return;
    L16:
        r13 = r9;
        goto L17
    L12:
        r3 = r8;
        goto L14
    L5:
        r12 = r5;
        goto L7
    }
}
