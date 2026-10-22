package com.bytedance.locallife.poi.poidetail.container.plugin.perf;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R0\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/locallife/poi/poidetail/container/plugin/perf/d;", "", "", "nodeTag", "Ljava/lang/String;", "getNodeTag", "()Ljava/lang/String;", "subType", "d", "Lcom/bytedance/locallife/poi/poidetail/container/plugin/perf/c;", "sizeChangeInfo", "Lcom/bytedance/locallife/poi/poidetail/container/plugin/perf/c;", "c", "()Lcom/bytedance/locallife/poi/poidetail/container/plugin/perf/c;", "", "isAfterFmp", "Z", "e", "()Z", "setAfterFmp", "(Z)V", "", "cardInnerDetailInfo", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "f", "(Ljava/util/Map;)V", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("card_inner_detail_info")
    private Map<String, Object> cardInnerDetailInfo;

    @SerializedName("is_after_fmp")
    private boolean isAfterFmp;

    @SerializedName("node_tag")
    private final String nodeTag;

    @SerializedName("size_change_info")
    private final c sizeChangeInfo;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE)
    private final String subType;

    public d() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.nodeTag, r101.nodeTag) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.subType, r101.subType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sizeChangeInfo, r101.sizeChangeInfo) == true) goto L18;
        return false;
    L18:
        if (this.isAfterFmp == r101.isAfterFmp) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.cardInnerDetailInfo, r101.cardInnerDetailInfo) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.nodeTag.hashCode() * 31;
        String r101 = this.subType;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.sizeChangeInfo.hashCode()) * 31;
        if (this.isAfterFmp == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r104 + r105) * 31;
        Map<String, Object> r107 = this.cardInnerDetailInfo;
        if (r107 == null) goto L15;
        r102 = r107.hashCode();
    L15:
        return r106 + r102;
    L9:
        r105 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "PoiCardSizeChangeRecord(nodeTag=" + this.nodeTag + ", subType=" + this.subType + ", sizeChangeInfo=" + this.sizeChangeInfo + ", isAfterFmp=" + this.isAfterFmp + ", cardInnerDetailInfo=" + this.cardInnerDetailInfo + ')';
    }

    public final Map<String, Object> b() {
        return this.cardInnerDetailInfo;
    }

    public final c c() {
        return this.sizeChangeInfo;
    }

    public final String d() {
        return this.subType;
    }

    public final boolean e() {
        return this.isAfterFmp;
    }

    public final void a(Long r110) {
        if (r110 == null) goto L29;
        r110.longValue();
        c r100 = this.sizeChangeInfo;
        Long r101 = r100.d();
        if (r101 == null) goto L30;
        long r102 = r101.longValue();
        Long r103 = r100.a();
        if (r103 != null) goto L8;
        return;
    L8:
        if (r103.longValue() >= r110.longValue()) goto L22;
        r100.j(Long.valueOf(r110.longValue() - r102));
        List<Long> r104 = r100.f264148d;
        ListIterator<Long> r105 = r104.listIterator(r104.size());
    L11:
        if (r105.hasPrevious() == false) goto L18;
        Long r106 = r105.previous();
        if (r106.longValue() >= r110.longValue()) goto L15;
        boolean r107 = true;
    L16:
        if (r107 == false) goto L11;
    L19:
        Long r108 = r106;
        if (r108 == null) goto L32;
        long r109 = r108.longValue();
        r100.i(Long.valueOf(r110.longValue() - r109));
        return;
    L32:
        return;
    L15:
        r107 = false;
        goto L16
    L18:
        r106 = null;
        goto L19
    L22:
        this.isAfterFmp = true;
        return;
    L30:
        return;
    }

    public final void f(Map<String, Object> r100) {
        this.cardInnerDetailInfo = r100;
    }

    public d(String r100, String r101, c r102) {
        Intrinsics.checkNotNullParameter(r100, "nodeTag");
        Intrinsics.checkNotNullParameter(r102, "sizeChangeInfo");
        this.nodeTag = r100;
        this.subType = r101;
        this.sizeChangeInfo = r102;
        this.isAfterFmp = false;
        this.cardInnerDetailInfo = null;
    }
}
