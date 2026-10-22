package com.bytedance.ug.sdk.luckycat.impl.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\fR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ug/sdk/luckycat/impl/model/c;", "", "", "", "path", "Ljava/util/List;", "getPath", "()Ljava/util/List;", "", "enablePrefetch", "Ljava/lang/Boolean;", "getEnablePrefetch", "()Ljava/lang/Boolean;", "enablePreload", "getEnablePreload", "enableCodeCache", "getEnableCodeCache", "enableOptimization", "getEnableOptimization", "enableAnimation", "getEnableAnimation", "enableSound", "getEnableSound", "luckycat_container_release"}, k = 1, mv = {1, 4, 0})
public final class c {

    @SerializedName("enable_animation")
    private final Boolean enableAnimation;

    @SerializedName("enable_code_cache")
    private final Boolean enableCodeCache;

    @SerializedName("enable_optimization")
    private final Boolean enableOptimization;

    @SerializedName("enable_prefetch")
    private final Boolean enablePrefetch;

    @SerializedName("enable_preload")
    private final Boolean enablePreload;

    @SerializedName("enable_sound")
    private final Boolean enableSound;

    @SerializedName("path")
    private final List<String> path;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L20;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.path, r101.path) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.enablePrefetch, r101.enablePrefetch) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.enablePreload, r101.enablePreload) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enableCodeCache, r101.enableCodeCache) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.enableOptimization, r101.enableOptimization) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.enableAnimation, r101.enableAnimation) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.enableSound, r101.enableSound) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        List<String> r100 = this.path;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.enablePrefetch;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.enablePreload;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.enableCodeCache;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.enableOptimization;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.enableAnimation;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.enableSound;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ContainerOptimizationAbRule(path=" + this.path + ", enablePrefetch=" + this.enablePrefetch + ", enablePreload=" + this.enablePreload + ", enableCodeCache=" + this.enableCodeCache + ", enableOptimization=" + this.enableOptimization + ", enableAnimation=" + this.enableAnimation + ", enableSound=" + this.enableSound + ")";
    }

    public c() {
        Boolean r100 = Boolean.TRUE;
        this.path = null;
        this.enablePrefetch = r100;
        this.enablePreload = r100;
        this.enableCodeCache = r100;
        this.enableOptimization = r100;
        this.enableAnimation = r100;
        this.enableSound = r100;
    }
}
