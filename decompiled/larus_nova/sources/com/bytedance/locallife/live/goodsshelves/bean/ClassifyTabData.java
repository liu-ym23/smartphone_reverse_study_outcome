package com.bytedance.locallife.live.goodsshelves.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J3\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR$\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/ClassifyTabData;", "Ljava/io/Serializable;", "tabs", "", "Lcom/bytedance/locallife/live/goodsshelves/bean/Tab;", "trackingParams", "", "", "(Ljava/util/List;Ljava/util/Map;)V", "getTabs", "()Ljava/util/List;", "getTrackingParams", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class ClassifyTabData implements Serializable {
    private final List<Tab> tabs;

    @SerializedName("tracking_params")
    private final Map<String, String> trackingParams;

    /* JADX WARN: Multi-variable type inference failed */
    public ClassifyTabData() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ClassifyTabData copy$default(ClassifyTabData r100, List r101, Map r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.tabs;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.trackingParams;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<Tab> component1() {
        return this.tabs;
    }

    public final Map<String, String> component2() {
        return this.trackingParams;
    }

    public final ClassifyTabData copy(List<Tab> r100, Map<String, String> r101) {
        return new ClassifyTabData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ClassifyTabData) == true) goto L8;
        return false;
    L8:
        ClassifyTabData r101 = (ClassifyTabData) r100;
        if (Intrinsics.areEqual(this.tabs, r101.tabs) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.trackingParams, r101.trackingParams) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<Tab> r100 = this.tabs;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Map<String, String> r104 = this.trackingParams;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ClassifyTabData(tabs=" + this.tabs + ", trackingParams=" + this.trackingParams + ')';
    }

    public final List<Tab> getTabs() {
        return this.tabs;
    }

    public final Map<String, String> getTrackingParams() {
        return this.trackingParams;
    }

    public ClassifyTabData(List<Tab> r100, Map<String, String> r101) {
        this.tabs = r100;
        this.trackingParams = r101;
    }

    public /* synthetic */ ClassifyTabData(List r100, Map r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
