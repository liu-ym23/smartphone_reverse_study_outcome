package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003JA\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpacePreloadHandle;", "Ljava/io/Serializable;", "preloadId", "", "requestId", "requestKeyHash", "acceptedLevels", "", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpacePreloadLevel;", "state", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpacePreloadState;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;Lcom/bytedance/ee/bear/office/export/space/OfficeSpacePreloadState;)V", "getPreloadId", "()Ljava/lang/String;", "getRequestId", "getRequestKeyHash", "getAcceptedLevels", "()Ljava/util/Set;", "getState", "()Lcom/bytedance/ee/bear/office/export/space/OfficeSpacePreloadState;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSpacePreloadHandle implements Serializable {
    private final Set<OfficeSpacePreloadLevel> acceptedLevels;
    private final String preloadId;
    private final String requestId;
    private final String requestKeyHash;
    private final OfficeSpacePreloadState state;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfficeSpacePreloadHandle copy$default(OfficeSpacePreloadHandle r3, String r4, String r5, String r6, Set r7, OfficeSpacePreloadState r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.preloadId;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.requestId;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.requestKeyHash;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.acceptedLevels;
    L14:
        Set r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.state;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.preloadId;
    }

    public final String component2() {
        return this.requestId;
    }

    public final String component3() {
        return this.requestKeyHash;
    }

    public final Set<OfficeSpacePreloadLevel> component4() {
        return this.acceptedLevels;
    }

    public final OfficeSpacePreloadState component5() {
        return this.state;
    }

    public final OfficeSpacePreloadHandle copy(String r8, String r9, String r10, Set<? extends OfficeSpacePreloadLevel> r11, OfficeSpacePreloadState r12) {
        Intrinsics.checkNotNullParameter(r8, "preloadId");
        Intrinsics.checkNotNullParameter(r9, "requestId");
        Intrinsics.checkNotNullParameter(r10, "requestKeyHash");
        Intrinsics.checkNotNullParameter(r11, "acceptedLevels");
        Intrinsics.checkNotNullParameter(r12, "state");
        return new OfficeSpacePreloadHandle(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OfficeSpacePreloadHandle) == true) goto L8;
        return false;
    L8:
        OfficeSpacePreloadHandle r6 = (OfficeSpacePreloadHandle) r5;
        if (Intrinsics.areEqual(this.preloadId, r6.preloadId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.requestId, r6.requestId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.requestKeyHash, r6.requestKeyHash) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.acceptedLevels, r6.acceptedLevels) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.state, r6.state) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.preloadId.hashCode() * 31) + this.requestId.hashCode()) * 31) + this.requestKeyHash.hashCode()) * 31) + this.acceptedLevels.hashCode()) * 31) + this.state.hashCode();
    }

    public String toString() {
        return "OfficeSpacePreloadHandle(preloadId=" + this.preloadId + ", requestId=" + this.requestId + ", requestKeyHash=" + this.requestKeyHash + ", acceptedLevels=" + this.acceptedLevels + ", state=" + this.state + ')';
    }

    public final Set<OfficeSpacePreloadLevel> getAcceptedLevels() {
        return this.acceptedLevels;
    }

    public final String getPreloadId() {
        return this.preloadId;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final String getRequestKeyHash() {
        return this.requestKeyHash;
    }

    public final OfficeSpacePreloadState getState() {
        return this.state;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OfficeSpacePreloadHandle(String r2, String r3, String r4, Set<? extends OfficeSpacePreloadLevel> r5, OfficeSpacePreloadState r6) {
        Intrinsics.checkNotNullParameter(r2, "preloadId");
        Intrinsics.checkNotNullParameter(r3, "requestId");
        Intrinsics.checkNotNullParameter(r4, "requestKeyHash");
        Intrinsics.checkNotNullParameter(r5, "acceptedLevels");
        Intrinsics.checkNotNullParameter(r6, "state");
        this.preloadId = r2;
        this.requestId = r3;
        this.requestKeyHash = r4;
        this.acceptedLevels = r5;
        this.state = r6;
    }
}
