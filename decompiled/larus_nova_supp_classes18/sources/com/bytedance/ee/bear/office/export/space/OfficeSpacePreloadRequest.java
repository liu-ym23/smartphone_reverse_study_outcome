package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\t\u0010\u001f\u001a\u00020\fHÆ\u0003J\t\u0010 \u001a\u00020\fHÆ\u0003JK\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpacePreloadRequest;", "Ljava/io/Serializable;", "preloadId", "", "scene", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpacePreloadScene;", "levels", "", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpacePreloadLevel;", "config", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceConfig;", "ttlMs", "", "createdAtMs", "<init>", "(Ljava/lang/String;Lcom/bytedance/ee/bear/office/export/space/OfficeSpacePreloadScene;Ljava/util/Set;Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceConfig;JJ)V", "getPreloadId", "()Ljava/lang/String;", "getScene", "()Lcom/bytedance/ee/bear/office/export/space/OfficeSpacePreloadScene;", "getLevels", "()Ljava/util/Set;", "getConfig", "()Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceConfig;", "getTtlMs", "()J", "getCreatedAtMs", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSpacePreloadRequest implements Serializable {
    private final OfficeSpaceConfig config;
    private final long createdAtMs;
    private final Set<OfficeSpacePreloadLevel> levels;
    private final String preloadId;
    private final OfficeSpacePreloadScene scene;
    private final long ttlMs;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfficeSpacePreloadRequest copy$default(OfficeSpacePreloadRequest r9, String r10, OfficeSpacePreloadScene r11, Set r12, OfficeSpaceConfig r13, long r14, long r16, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r1 = r9.preloadId;
    L7:
        if ((r18 & 2) == 0) goto L9;
        OfficeSpacePreloadScene r2 = r9.scene;
    L11:
        if ((r18 & 4) == 0) goto L13;
        Set r3 = r9.levels;
    L15:
        if ((r18 & 8) == 0) goto L17;
        OfficeSpaceConfig r4 = r9.config;
    L19:
        if ((r18 & 16) == 0) goto L21;
        long r5 = r9.ttlMs;
    L23:
        if ((r18 & 32) == 0) goto L25;
        long r7 = r9.createdAtMs;
    L27:
        return r9.copy(r1, r2, r3, r4, r5, r7);
    L25:
        r7 = r16;
        goto L27
    L21:
        r5 = r14;
        goto L23
    L17:
        r4 = r13;
        goto L19
    L13:
        r3 = r12;
        goto L15
    L9:
        r2 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }

    public final String component1() {
        return this.preloadId;
    }

    public final OfficeSpacePreloadScene component2() {
        return this.scene;
    }

    public final Set<OfficeSpacePreloadLevel> component3() {
        return this.levels;
    }

    public final OfficeSpaceConfig component4() {
        return this.config;
    }

    public final long component5() {
        return this.ttlMs;
    }

    public final long component6() {
        return this.createdAtMs;
    }

    public final OfficeSpacePreloadRequest copy(String r11, OfficeSpacePreloadScene r12, Set<? extends OfficeSpacePreloadLevel> r13, OfficeSpaceConfig r14, long r15, long r17) {
        Intrinsics.checkNotNullParameter(r11, "preloadId");
        Intrinsics.checkNotNullParameter(r12, "scene");
        Intrinsics.checkNotNullParameter(r13, "levels");
        Intrinsics.checkNotNullParameter(r14, "config");
        return new OfficeSpacePreloadRequest(r11, r12, r13, r14, r15, r17);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof OfficeSpacePreloadRequest) == true) goto L8;
        return false;
    L8:
        OfficeSpacePreloadRequest r9 = (OfficeSpacePreloadRequest) r8;
        if (Intrinsics.areEqual(this.preloadId, r9.preloadId) == true) goto L12;
        return false;
    L12:
        if (this.scene == r9.scene) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.levels, r9.levels) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.config, r9.config) == true) goto L21;
        return false;
    L21:
        if (this.ttlMs == r9.ttlMs) goto L24;
        return false;
    L24:
        if (this.createdAtMs == r9.createdAtMs) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((this.preloadId.hashCode() * 31) + this.scene.hashCode()) * 31) + this.levels.hashCode()) * 31) + this.config.hashCode()) * 31;
        long r1 = this.ttlMs;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.createdAtMs;
        return r2 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public String toString() {
        return "OfficeSpacePreloadRequest(preloadId=" + this.preloadId + ", scene=" + this.scene + ", levels=" + this.levels + ", config=" + this.config + ", ttlMs=" + this.ttlMs + ", createdAtMs=" + this.createdAtMs + ')';
    }

    public final OfficeSpaceConfig getConfig() {
        return this.config;
    }

    public final long getCreatedAtMs() {
        return this.createdAtMs;
    }

    public final Set<OfficeSpacePreloadLevel> getLevels() {
        return this.levels;
    }

    public final String getPreloadId() {
        return this.preloadId;
    }

    public final OfficeSpacePreloadScene getScene() {
        return this.scene;
    }

    public final long getTtlMs() {
        return this.ttlMs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OfficeSpacePreloadRequest(String r2, OfficeSpacePreloadScene r3, Set<? extends OfficeSpacePreloadLevel> r4, OfficeSpaceConfig r5, long r6, long r8) {
        Intrinsics.checkNotNullParameter(r2, "preloadId");
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, "levels");
        Intrinsics.checkNotNullParameter(r5, "config");
        this.preloadId = r2;
        this.scene = r3;
        this.levels = r4;
        this.config = r5;
        this.ttlMs = r6;
        this.createdAtMs = r8;
    }

    public /* synthetic */ OfficeSpacePreloadRequest(String r12, OfficeSpacePreloadScene r13, Set r14, OfficeSpaceConfig r15, long r16, long r18, int r20, DefaultConstructorMarker r21) {
        if ((r20 & 16) == 0) goto L5;
        long r7 = 30000;
    L7:
        if ((r20 & 32) == 0) goto L9;
        long r9 = System.currentTimeMillis();
    L10:
        this(r12, r13, r14, r15, r7, r9);
        return;
    L9:
        r9 = r18;
        goto L10
    L5:
        r7 = r16;
        goto L7
    }
}
