package com.larus.settings.protector;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/larus/settings/protector/GsonFilterNotNullConfig;", "", "enable", "", "collectionEnable", "mapEnable", "<init>", "(ZZZ)V", "getEnable", "()Z", "getCollectionEnable", "getMapEnable", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GsonFilterNotNullConfig {
    public static final a Companion = null;
    private static final GsonFilterNotNullConfig DEFAULT = null;

    @SerializedName("collection_enable")
    private final boolean collectionEnable;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("map_enable")
    private final boolean mapEnable;

    public static final class a {
        public a() {
        }
    }

    public GsonFilterNotNullConfig() {
        this(false, false, false, 7, null);
    }

    public static /* synthetic */ GsonFilterNotNullConfig copy$default(GsonFilterNotNullConfig r100, boolean r101, boolean r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.enable;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.collectionEnable;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.mapEnable;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final boolean component2() {
        return this.collectionEnable;
    }

    public final boolean component3() {
        return this.mapEnable;
    }

    public final GsonFilterNotNullConfig copy(boolean r100, boolean r101, boolean r102) {
        return new GsonFilterNotNullConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GsonFilterNotNullConfig) == true) goto L8;
        return false;
    L8:
        GsonFilterNotNullConfig r101 = (GsonFilterNotNullConfig) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (this.collectionEnable == r101.collectionEnable) goto L15;
        return false;
    L15:
        if (this.mapEnable == r101.mapEnable) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.enable == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.collectionEnable == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.mapEnable == true) goto L15;
        r100 = 1237;
    L15:
        return r104 + r100;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "GsonFilterNotNullConfig(enable=" + this.enable + ", collectionEnable=" + this.collectionEnable + ", mapEnable=" + this.mapEnable + ')';
    }

    static {
        Companion = new a();
        DEFAULT = new GsonFilterNotNullConfig(false, false, false, 7, null);
    }

    public static final /* synthetic */ GsonFilterNotNullConfig access$getDEFAULT$cp() {
        return DEFAULT;
    }

    public final boolean getCollectionEnable() {
        return this.collectionEnable;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getMapEnable() {
        return this.mapEnable;
    }

    public GsonFilterNotNullConfig(boolean r100, boolean r101, boolean r102) {
        this.enable = r100;
        this.collectionEnable = r101;
        this.mapEnable = r102;
    }

    public /* synthetic */ GsonFilterNotNullConfig(boolean r100, boolean r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = true;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = true;
    L11:
        this(r100, r101, r102);
    }
}
