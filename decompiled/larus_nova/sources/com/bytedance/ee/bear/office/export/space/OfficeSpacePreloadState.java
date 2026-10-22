package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
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
    public static /* synthetic */ OfficeSpacePreloadState copy$default(OfficeSpacePreloadState r110, String r111, String r112, String r113, OfficeSpacePreloadScene r114, Map r115, long r116, Long r210, long r211, OfficeSpacePreloadCancelReason r212, String r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        String r100 = r110.preloadId;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r101 = r110.requestId;
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r102 = r110.requestKeyHash;
    L15:
        if ((r214 & 8) == 0) goto L17;
        OfficeSpacePreloadScene r103 = r110.scene;
    L19:
        if ((r214 & 16) == 0) goto L21;
        Map r104 = r110.levelStates;
    L23:
        if ((r214 & 32) == 0) goto L25;
        long r105 = r110.startedAtMs;
    L27:
        if ((r214 & 64) == 0) goto L29;
        Long r106 = r110.finishedAtMs;
    L31:
        if ((r214 & 128) == 0) goto L33;
        long r117 = r110.ttlDeadlineMs;
    L35:
        if ((r214 & 256) == 0) goto L37;
        OfficeSpacePreloadCancelReason r118 = r110.cancelReason;
    L39:
        if ((r214 & 512) == 0) goto L41;
        String r107 = r110.errorCode;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r117, r118, r107);
    L41:
        r107 = r213;
        goto L43
    L37:
        r118 = r212;
        goto L39
    L33:
        r117 = r211;
        goto L35
    L29:
        r106 = r210;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
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

    public final OfficeSpacePreloadState copy(String r110, String r111, String r112, OfficeSpacePreloadScene r113, Map<OfficeSpacePreloadLevel, ? extends OfficeSpacePreloadLevelState> r114, long r210, Long r211, long r212, OfficeSpacePreloadCancelReason r213, String r214) {
        Intrinsics.checkNotNullParameter(r110, "preloadId");
        Intrinsics.checkNotNullParameter(r111, "requestId");
        Intrinsics.checkNotNullParameter(r112, "requestKeyHash");
        Intrinsics.checkNotNullParameter(r113, "scene");
        Intrinsics.checkNotNullParameter(r114, "levelStates");
        return new OfficeSpacePreloadState(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OfficeSpacePreloadState) == true) goto L8;
        return false;
    L8:
        OfficeSpacePreloadState r101 = (OfficeSpacePreloadState) r100;
        if (Intrinsics.areEqual(this.preloadId, r101.preloadId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.requestId, r101.requestId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.requestKeyHash, r101.requestKeyHash) == true) goto L18;
        return false;
    L18:
        if (this.scene == r101.scene) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.levelStates, r101.levelStates) == true) goto L24;
        return false;
    L24:
        if (this.startedAtMs == r101.startedAtMs) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.finishedAtMs, r101.finishedAtMs) == true) goto L30;
        return false;
    L30:
        if (this.ttlDeadlineMs == r101.ttlDeadlineMs) goto L33;
        return false;
    L33:
        if (this.cancelReason == r101.cancelReason) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.errorCode, r101.errorCode) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((((this.preloadId.hashCode() * 31) + this.requestId.hashCode()) * 31) + this.requestKeyHash.hashCode()) * 31) + this.scene.hashCode()) * 31) + this.levelStates.hashCode()) * 31;
        long r101 = this.startedAtMs;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        Long r103 = this.finishedAtMs;
        int r104 = 0;
        if (r103 != null) goto L5;
        int r105 = 0;
    L6:
        long r106 = this.ttlDeadlineMs;
        int r107 = (((r102 + r105) * 31) + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        OfficeSpacePreloadCancelReason r108 = this.cancelReason;
        if (r108 != null) goto L9;
        int r109 = 0;
    L10:
        int r110 = (r107 + r109) * 31;
        String r111 = this.errorCode;
        if (r111 == null) goto L15;
        r104 = r111.hashCode();
    L15:
        return r110 + r104;
    L9:
        r109 = r108.hashCode();
        goto L10
    L5:
        r105 = r103.hashCode();
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
    public OfficeSpacePreloadState(String r100, String r101, String r102, OfficeSpacePreloadScene r103, Map<OfficeSpacePreloadLevel, ? extends OfficeSpacePreloadLevelState> r104, long r105, Long r106, long r110, OfficeSpacePreloadCancelReason r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "preloadId");
        Intrinsics.checkNotNullParameter(r101, "requestId");
        Intrinsics.checkNotNullParameter(r102, "requestKeyHash");
        Intrinsics.checkNotNullParameter(r103, "scene");
        Intrinsics.checkNotNullParameter(r104, "levelStates");
        this.preloadId = r100;
        this.requestId = r101;
        this.requestKeyHash = r102;
        this.scene = r103;
        this.levelStates = r104;
        this.startedAtMs = r105;
        this.finishedAtMs = r106;
        this.ttlDeadlineMs = r110;
        this.cancelReason = r111;
        this.errorCode = r112;
    }

    public /* synthetic */ OfficeSpacePreloadState(String r110, String r111, String r112, OfficeSpacePreloadScene r210, Map r211, long r212, Long r213, long r214, OfficeSpacePreloadCancelReason r215, String r216, int r217, DefaultConstructorMarker r310) {
        if ((r217 & 64) == 0) goto L5;
        Long r113 = null;
    L7:
        if ((r217 & 256) == 0) goto L9;
        OfficeSpacePreloadCancelReason r114 = null;
    L11:
        if ((r217 & 512) == 0) goto L13;
        String r115 = null;
    L14:
        this(r110, r111, r112, r210, r211, r212, r113, r214, r114, r115);
        return;
    L13:
        r115 = r216;
        goto L14
    L9:
        r114 = r215;
        goto L11
    L5:
        r113 = r213;
        goto L7
    }
}
