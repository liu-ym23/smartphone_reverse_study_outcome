package com.bytedance.bdp.service.plug.map.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/bdp/service/plug/map/model/MapSettings;", "", "useTextureMap", "", "hideMapLogo", "(ZZ)V", "getHideMapLogo", "()Z", "getUseTextureMap", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "tma-map-api_release"}, k = 1, mv = {1, 1, 18})
public final class MapSettings {
    private final boolean hideMapLogo;
    private final boolean useTextureMap;

    public MapSettings() {
        boolean r100 = false;
        this(r100, r100, 3, null);
    }

    public static /* synthetic */ MapSettings copy$default(MapSettings r100, boolean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.useTextureMap;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.hideMapLogo;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.useTextureMap;
    }

    public final boolean component2() {
        return this.hideMapLogo;
    }

    public final MapSettings copy(boolean r100, boolean r101) {
        return new MapSettings(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof MapSettings) == false) goto L10;
        MapSettings r101 = (MapSettings) r100;
        if (this.useTextureMap == r101.useTextureMap) goto L8;
        return false;
    L8:
        if (this.hideMapLogo == r101.hideMapLogo) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public int hashCode() {
        boolean r100 = this.useTextureMap;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.hideMapLogo;
        if (r104 == true) goto L10;
        r101 = r104;
    L10:
        return r103 + r101;
    }

    public String toString() {
        return "MapSettings(useTextureMap=" + this.useTextureMap + ", hideMapLogo=" + this.hideMapLogo + ")";
    }

    public final boolean getHideMapLogo() {
        return this.hideMapLogo;
    }

    public final boolean getUseTextureMap() {
        return this.useTextureMap;
    }

    public MapSettings(boolean r100, boolean r101) {
        this.useTextureMap = r100;
        this.hideMapLogo = r101;
    }

    public /* synthetic */ MapSettings(boolean r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = true;
    L8:
        this(r100, r101);
    }
}
