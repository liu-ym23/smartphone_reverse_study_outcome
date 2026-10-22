package com.bytedance.locallife.pdp.img;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J,\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/locallife/pdp/img/GDImagePreloadOptions;", "Ljava/io/Serializable;", "enable", "", "imageConfigList", "", "", "(Ljava/lang/Boolean;Ljava/util/List;)V", "getEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getImageConfigList", "()Ljava/util/List;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/util/List;)Lcom/bytedance/locallife/pdp/img/GDImagePreloadOptions;", "equals", "other", "", "hashCode", "", "toString", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class GDImagePreloadOptions implements Serializable {

    @SerializedName("enable")
    private final Boolean enable;

    @SerializedName("imageConfigList")
    private final List<String> imageConfigList;

    /* JADX WARN: Multi-variable type inference failed */
    public GDImagePreloadOptions() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GDImagePreloadOptions copy$default(GDImagePreloadOptions r100, Boolean r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.enable;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.imageConfigList;
    L9:
        return r100.copy(r101, r102);
    }

    public final Boolean component1() {
        return this.enable;
    }

    public final List<String> component2() {
        return this.imageConfigList;
    }

    public final GDImagePreloadOptions copy(Boolean r100, List<String> r101) {
        return new GDImagePreloadOptions(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GDImagePreloadOptions) == true) goto L8;
        return false;
    L8:
        GDImagePreloadOptions r101 = (GDImagePreloadOptions) r100;
        if (Intrinsics.areEqual(this.enable, r101.enable) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.imageConfigList, r101.imageConfigList) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Boolean r100 = this.enable;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.imageConfigList;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "GDImagePreloadOptions(enable=" + this.enable + ", imageConfigList=" + this.imageConfigList + ')';
    }

    public final Boolean getEnable() {
        return this.enable;
    }

    public final List<String> getImageConfigList() {
        return this.imageConfigList;
    }

    public GDImagePreloadOptions(Boolean r100, List<String> r101) {
        this.enable = r100;
        this.imageConfigList = r101;
    }

    public /* synthetic */ GDImagePreloadOptions(Boolean r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
