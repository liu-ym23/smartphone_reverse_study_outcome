package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\t\u0010\u001f\u001a\u00020\fHÆ\u0003J\t\u0010 \u001a\u00020\fHÆ\u0003JK\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpacePreloadRequest;", "Ljava/io/Serializable;", "preloadId", "", "scene", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpacePreloadScene;", "levels", "", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpacePreloadLevel;", "config", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceConfig;", "ttlMs", "", "createdAtMs", "<init>", "(Ljava/lang/String;Lcom/bytedance/ee/bear/office/export/space/OfficeSpacePreloadScene;Ljava/util/Set;Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceConfig;JJ)V", "getPreloadId", "()Ljava/lang/String;", "getScene", "()Lcom/bytedance/ee/bear/office/export/space/OfficeSpacePreloadScene;", "getLevels", "()Ljava/util/Set;", "getConfig", "()Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceConfig;", "getTtlMs", "()J", "getCreatedAtMs", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSpacePreloadRequest implements Serializable {
    private final OfficeSpaceConfig config;
    private final long createdAtMs;
    private final Set<OfficeSpacePreloadLevel> levels;
    private final String preloadId;
    private final OfficeSpacePreloadScene scene;
    private final long ttlMs;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfficeSpacePreloadRequest copy$default(OfficeSpacePreloadRequest r100, String r110, OfficeSpacePreloadScene r111, Set r112, OfficeSpaceConfig r113, long r114, long r115, int r116, Object r117) {
        if ((r116 & 1) == 0) goto L5;
        String r101 = r100.preloadId;
    L7:
        if ((r116 & 2) == 0) goto L9;
        OfficeSpacePreloadScene r102 = r100.scene;
    L11:
        if ((r116 & 4) == 0) goto L13;
        Set r103 = r100.levels;
    L15:
        if ((r116 & 8) == 0) goto L17;
        OfficeSpaceConfig r104 = r100.config;
    L19:
        if ((r116 & 16) == 0) goto L21;
        long r105 = r100.ttlMs;
    L23:
        if ((r116 & 32) == 0) goto L25;
        long r106 = r100.createdAtMs;
    L27:
        return r100.copy(r101, r102, r103, r104, r105, r106);
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
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

    public final OfficeSpacePreloadRequest copy(String r110, OfficeSpacePreloadScene r111, Set<? extends OfficeSpacePreloadLevel> r112, OfficeSpaceConfig r113, long r114, long r115) {
        Intrinsics.checkNotNullParameter(r110, "preloadId");
        Intrinsics.checkNotNullParameter(r111, "scene");
        Intrinsics.checkNotNullParameter(r112, "levels");
        Intrinsics.checkNotNullParameter(r113, "config");
        return new OfficeSpacePreloadRequest(r110, r111, r112, r113, r114, r115);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OfficeSpacePreloadRequest) == true) goto L8;
        return false;
    L8:
        OfficeSpacePreloadRequest r101 = (OfficeSpacePreloadRequest) r100;
        if (Intrinsics.areEqual(this.preloadId, r101.preloadId) == true) goto L12;
        return false;
    L12:
        if (this.scene == r101.scene) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.levels, r101.levels) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.config, r101.config) == true) goto L21;
        return false;
    L21:
        if (this.ttlMs == r101.ttlMs) goto L24;
        return false;
    L24:
        if (this.createdAtMs == r101.createdAtMs) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((this.preloadId.hashCode() * 31) + this.scene.hashCode()) * 31) + this.levels.hashCode()) * 31) + this.config.hashCode()) * 31;
        long r101 = this.ttlMs;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.createdAtMs;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
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
    public OfficeSpacePreloadRequest(String r100, OfficeSpacePreloadScene r101, Set<? extends OfficeSpacePreloadLevel> r102, OfficeSpaceConfig r103, long r104, long r105) {
        Intrinsics.checkNotNullParameter(r100, "preloadId");
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "levels");
        Intrinsics.checkNotNullParameter(r103, "config");
        this.preloadId = r100;
        this.scene = r101;
        this.levels = r102;
        this.config = r103;
        this.ttlMs = r104;
        this.createdAtMs = r105;
    }

    public /* synthetic */ OfficeSpacePreloadRequest(String r110, OfficeSpacePreloadScene r111, Set r112, OfficeSpaceConfig r113, long r114, long r115, int r210, DefaultConstructorMarker r211) {
        if ((r210 & 16) == 0) goto L5;
        long r100 = 30000;
    L7:
        if ((r210 & 32) == 0) goto L9;
        long r101 = System.currentTimeMillis();
    L10:
        this(r110, r111, r112, r113, r100, r101);
        return;
    L9:
        r101 = r115;
        goto L10
    L5:
        r100 = r114;
        goto L7
    }
}
