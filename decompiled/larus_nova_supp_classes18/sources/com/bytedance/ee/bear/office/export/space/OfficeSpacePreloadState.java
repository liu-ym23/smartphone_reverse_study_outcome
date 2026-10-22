package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\u0006\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\u0015\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tHÆ\u0003J\t\u0010+\u001a\u00020\rHÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010 J\t\u0010-\u001a\u00020\rHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0084\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00101J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u000207HÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016¨\u00069"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpacePreloadState;", "Ljava/io/Serializable;", "preloadId", "", "requestId", "requestKeyHash", "scene", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpacePreloadScene;", "levelStates", "", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpacePreloadLevel;", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpacePreloadLevelState;", "startedAtMs", "", "finishedAtMs", "ttlDeadlineMs", "cancelReason", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpacePreloadCancelReason;", "errorCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ee/bear/office/export/space/OfficeSpacePreloadScene;Ljava/util/Map;JLjava/lang/Long;JLcom/bytedance/ee/bear/office/export/space/OfficeSpacePreloadCancelReason;Ljava/lang/String;)V", "getPreloadId", "()Ljava/lang/String;", "getRequestId", "getRequestKeyHash", "getScene", "()Lcom/bytedance/ee/bear/office/export/space/OfficeSpacePreloadScene;", "getLevelStates", "()Ljava/util/Map;", "getStartedAtMs", "()J", "getFinishedAtMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTtlDeadlineMs", "getCancelReason", "()Lcom/bytedance/ee/bear/office/export/space/OfficeSpacePreloadCancelReason;", "getErrorCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ee/bear/office/export/space/OfficeSpacePreloadScene;Ljava/util/Map;JLjava/lang/Long;JLcom/bytedance/ee/bear/office/export/space/OfficeSpacePreloadCancelReason;Ljava/lang/String;)Lcom/bytedance/ee/bear/office/export/space/OfficeSpacePreloadState;", "equals", "", "other", "", "hashCode", "", "toString", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSpacePreloadState implements Serializable {
    private final OfficeSpacePreloadCancelReason cancelReason;
    private final String errorCode;
    private final Long finishedAtMs;
    private final Map<OfficeSpacePreloadLevel, OfficeSpacePreloadLevelState> levelStates;
    private final String preloadId;
    private final String requestId;
    private final String requestKeyHash;
    private final OfficeSpacePreloadScene scene;
    private final long startedAtMs;
    private final long ttlDeadlineMs;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfficeSpacePreloadState copy$default(OfficeSpacePreloadState r13, String r14, String r15, String r16, OfficeSpacePreloadScene r17, Map r18, long r19, Long r21, long r22, OfficeSpacePreloadCancelReason r24, String r25, int r26, Object r27) {
        if ((r26 & 1) == 0) goto L5;
        String r2 = r13.preloadId;
    L7:
        if ((r26 & 2) == 0) goto L9;
        String r3 = r13.requestId;
    L11:
        if ((r26 & 4) == 0) goto L13;
        String r4 = r13.requestKeyHash;
    L15:
        if ((r26 & 8) == 0) goto L17;
        OfficeSpacePreloadScene r5 = r13.scene;
    L19:
        if ((r26 & 16) == 0) goto L21;
        Map r6 = r13.levelStates;
    L23:
        if ((r26 & 32) == 0) goto L25;
        long r7 = r13.startedAtMs;
    L27:
        if ((r26 & 64) == 0) goto L29;
        Long r9 = r13.finishedAtMs;
    L31:
        if ((r26 & 128) == 0) goto L33;
        long r10 = r13.ttlDeadlineMs;
    L35:
        if ((r26 & 256) == 0) goto L37;
        OfficeSpacePreloadCancelReason r12 = r13.cancelReason;
    L39:
        if ((r26 & 512) == 0) goto L41;
        String r1 = r13.errorCode;
    L43:
        return r13.copy(r2, r3, r4, r5, r6, r7, r9, r10, r12, r1);
    L41:
        r1 = r25;
        goto L43
    L37:
        r12 = r24;
        goto L39
    L33:
        r10 = r22;
        goto L35
    L29:
        r9 = r21;
        goto L31
    L25:
        r7 = r19;
        goto L27
    L21:
        r6 = r18;
        goto L23
    L17:
        r5 = r17;
        goto L19
    L13:
        r4 = r16;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r2 = r14;
        goto L7
    }

    public final String component1() {
        return this.preloadId;
    }

    public final String component10() {
        return this.errorCode;
    }

    public final String component2() {
        return this.requestId;
    }

    public final String component3() {
        return this.requestKeyHash;
    }

    public final OfficeSpacePreloadScene component4() {
        return this.scene;
    }

    public final Map<OfficeSpacePreloadLevel, OfficeSpacePreloadLevelState> component5() {
        return this.levelStates;
    }

    public final long component6() {
        return this.startedAtMs;
    }

    public final Long component7() {
        return this.finishedAtMs;
    }

    public final long component8() {
        return this.ttlDeadlineMs;
    }

    public final OfficeSpacePreloadCancelReason component9() {
        return this.cancelReason;
    }

    public final OfficeSpacePreloadState copy(String r15, String r16, String r17, OfficeSpacePreloadScene r18, Map<OfficeSpacePreloadLevel, ? extends OfficeSpacePreloadLevelState> r19, long r20, Long r22, long r23, OfficeSpacePreloadCancelReason r25, String r26) {
        Intrinsics.checkNotNullParameter(r15, "preloadId");
        Intrinsics.checkNotNullParameter(r16, "requestId");
        Intrinsics.checkNotNullParameter(r17, "requestKeyHash");
        Intrinsics.checkNotNullParameter(r18, "scene");
        Intrinsics.checkNotNullParameter(r19, "levelStates");
        return new OfficeSpacePreloadState(r15, r16, r17, r18, r19, r20, r22, r23, r25, r26);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof OfficeSpacePreloadState) == true) goto L8;
        return false;
    L8:
        OfficeSpacePreloadState r9 = (OfficeSpacePreloadState) r8;
        if (Intrinsics.areEqual(this.preloadId, r9.preloadId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.requestId, r9.requestId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.requestKeyHash, r9.requestKeyHash) == true) goto L18;
        return false;
    L18:
        if (this.scene == r9.scene) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.levelStates, r9.levelStates) == true) goto L24;
        return false;
    L24:
        if (this.startedAtMs == r9.startedAtMs) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.finishedAtMs, r9.finishedAtMs) == true) goto L30;
        return false;
    L30:
        if (this.ttlDeadlineMs == r9.ttlDeadlineMs) goto L33;
        return false;
    L33:
        if (this.cancelReason == r9.cancelReason) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.errorCode, r9.errorCode) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((this.preloadId.hashCode() * 31) + this.requestId.hashCode()) * 31) + this.requestKeyHash.hashCode()) * 31) + this.scene.hashCode()) * 31) + this.levelStates.hashCode()) * 31;
        long r1 = this.startedAtMs;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        Long r3 = this.finishedAtMs;
        int r4 = 0;
        if (r3 != null) goto L5;
        int r5 = 0;
    L6:
        long r6 = this.ttlDeadlineMs;
        int r7 = (((r2 + r5) * 31) + ((int) (r6 ^ (r6 >>> 32)))) * 31;
        OfficeSpacePreloadCancelReason r8 = this.cancelReason;
        if (r8 != null) goto L9;
        int r9 = 0;
    L10:
        int r10 = (r7 + r9) * 31;
        String r11 = this.errorCode;
        if (r11 == null) goto L15;
        r4 = r11.hashCode();
    L15:
        return r10 + r4;
    L9:
        r9 = r8.hashCode();
        goto L10
    L5:
        r5 = r3.hashCode();
        goto L6
    }

    public String toString() {
        return "OfficeSpacePreloadState(preloadId=" + this.preloadId + ", requestId=" + this.requestId + ", requestKeyHash=" + this.requestKeyHash + ", scene=" + this.scene + ", levelStates=" + this.levelStates + ", startedAtMs=" + this.startedAtMs + ", finishedAtMs=" + this.finishedAtMs + ", ttlDeadlineMs=" + this.ttlDeadlineMs + ", cancelReason=" + this.cancelReason + ", errorCode=" + this.errorCode + ')';
    }

    public final OfficeSpacePreloadCancelReason getCancelReason() {
        return this.cancelReason;
    }

    public final String getErrorCode() {
        return this.errorCode;
    }

    public final Long getFinishedAtMs() {
        return this.finishedAtMs;
    }

    public final Map<OfficeSpacePreloadLevel, OfficeSpacePreloadLevelState> getLevelStates() {
        return this.levelStates;
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

    public final OfficeSpacePreloadScene getScene() {
        return this.scene;
    }

    public final long getStartedAtMs() {
        return this.startedAtMs;
    }

    public final long getTtlDeadlineMs() {
        return this.ttlDeadlineMs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OfficeSpacePreloadState(String r2, String r3, String r4, OfficeSpacePreloadScene r5, Map<OfficeSpacePreloadLevel, ? extends OfficeSpacePreloadLevelState> r6, long r7, Long r9, long r10, OfficeSpacePreloadCancelReason r12, String r13) {
        Intrinsics.checkNotNullParameter(r2, "preloadId");
        Intrinsics.checkNotNullParameter(r3, "requestId");
        Intrinsics.checkNotNullParameter(r4, "requestKeyHash");
        Intrinsics.checkNotNullParameter(r5, "scene");
        Intrinsics.checkNotNullParameter(r6, "levelStates");
        this.preloadId = r2;
        this.requestId = r3;
        this.requestKeyHash = r4;
        this.scene = r5;
        this.levelStates = r6;
        this.startedAtMs = r7;
        this.finishedAtMs = r9;
        this.ttlDeadlineMs = r10;
        this.cancelReason = r12;
        this.errorCode = r13;
    }

    public /* synthetic */ OfficeSpacePreloadState(String r17, String r18, String r19, OfficeSpacePreloadScene r20, Map r21, long r22, Long r24, long r25, OfficeSpacePreloadCancelReason r27, String r28, int r29, DefaultConstructorMarker r30) {
        if ((r29 & 64) == 0) goto L5;
        Long r11 = null;
    L7:
        if ((r29 & 256) == 0) goto L9;
        OfficeSpacePreloadCancelReason r14 = null;
    L11:
        if ((r29 & 512) == 0) goto L13;
        String r15 = null;
    L14:
        this(r17, r18, r19, r20, r21, r22, r11, r25, r14, r15);
        return;
    L13:
        r15 = r28;
        goto L14
    L9:
        r14 = r27;
        goto L11
    L5:
        r11 = r24;
        goto L7
    }
}
