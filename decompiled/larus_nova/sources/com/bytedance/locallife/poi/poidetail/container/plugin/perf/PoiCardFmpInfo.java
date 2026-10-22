package com.bytedance.locallife.poi.poidetail.container.plugin.perf;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b'\u0010\u0015J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\t\u001a\u00020\bHÖ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004R$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0010\u001a\u0004\b\u0013\u0010\u0004\"\u0004\b\u0014\u0010\u0015R$\u0010\u001c\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001e\u0010\u0004\"\u0004\b\u001f\u0010\u0015R$\u0010#\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u0017\u001a\u0004\b!\u0010\u0019\"\u0004\b\"\u0010\u001bR$\u0010$\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0010\u001a\u0004\b%\u0010\u0004\"\u0004\b&\u0010\u0015¨\u0006("}, d2 = {"Lcom/bytedance/locallife/poi/poidetail/container/plugin/perf/PoiCardFmpInfo;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/Long;", "viewCreateTs", "copy", "(Ljava/lang/Long;)Lcom/bytedance/locallife/poi/poidetail/container/plugin/perf/PoiCardFmpInfo;", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/Long;", "getViewCreateTs", "sizeStableTs", "getSizeStableTs", "setSizeStableTs", "(Ljava/lang/Long;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/lang/Boolean;", "getSizeStableStatus", "()Ljava/lang/Boolean;", "setSizeStableStatus", "(Ljava/lang/Boolean;)V", "sizeStableStatus", "positionStableTs", "getPositionStableTs", "setPositionStableTs", "b", "getPositionStableStatus", "setPositionStableStatus", "positionStableStatus", "gap", "getGap", "setGap", "<init>", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiCardFmpInfo implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Boolean f264107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient Boolean f264108b;

    @SerializedName("gap")
    private Long gap;

    @SerializedName("position_stable_ts")
    private Long positionStableTs;

    @SerializedName("size_stable_ts")
    private Long sizeStableTs;

    @SerializedName("view_create_ts")
    private final Long viewCreateTs;

    /* JADX WARN: Multi-variable type inference failed */
    public PoiCardFmpInfo() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PoiCardFmpInfo copy$default(PoiCardFmpInfo r100, Long r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.viewCreateTs;
    L6:
        return r100.copy(r101);
    }

    public final Long component1() {
        return this.viewCreateTs;
    }

    public final PoiCardFmpInfo copy(Long r100) {
        return new PoiCardFmpInfo(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiCardFmpInfo) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.viewCreateTs, ((PoiCardFmpInfo) r100).viewCreateTs) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        Long r100 = this.viewCreateTs;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "PoiCardFmpInfo(viewCreateTs=" + this.viewCreateTs + ')';
    }

    public final Long getGap() {
        return this.gap;
    }

    public final Boolean getPositionStableStatus() {
        return this.f264108b;
    }

    public final Long getPositionStableTs() {
        return this.positionStableTs;
    }

    public final Boolean getSizeStableStatus() {
        return this.f264107a;
    }

    public final Long getSizeStableTs() {
        return this.sizeStableTs;
    }

    public final Long getViewCreateTs() {
        return this.viewCreateTs;
    }

    public PoiCardFmpInfo(Long r100) {
        this.viewCreateTs = r100;
    }

    public final void setGap(Long r100) {
        this.gap = r100;
    }

    public final void setPositionStableStatus(Boolean r100) {
        this.f264108b = r100;
    }

    public final void setPositionStableTs(Long r100) {
        this.positionStableTs = r100;
    }

    public final void setSizeStableStatus(Boolean r100) {
        this.f264107a = r100;
    }

    public final void setSizeStableTs(Long r100) {
        this.sizeStableTs = r100;
    }

    public /* synthetic */ PoiCardFmpInfo(Long r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
