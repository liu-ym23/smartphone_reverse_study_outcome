package com.bytedance.locallife.biz.btm.bcm;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J1\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\"\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/locallife/biz/btm/bcm/BcmStandTrackModel;", "Ljava/io/Serializable;", "bcmParam", "", "Lcom/bytedance/locallife/biz/btm/bcm/BcmNode;", "btmGeneralParam", "", "", "(Ljava/util/List;Ljava/util/Map;)V", "getBcmParam", "()Ljava/util/List;", "getBtmGeneralParam", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class BcmStandTrackModel implements Serializable {

    @SerializedName("bcm_param")
    private final List<BcmNode> bcmParam;

    @SerializedName("btm_general_param")
    private final Map<String, String> btmGeneralParam;

    /* JADX WARN: Multi-variable type inference failed */
    public BcmStandTrackModel() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BcmStandTrackModel copy$default(BcmStandTrackModel r100, List r101, Map r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.bcmParam;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.btmGeneralParam;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<BcmNode> component1() {
        return this.bcmParam;
    }

    public final Map<String, String> component2() {
        return this.btmGeneralParam;
    }

    public final BcmStandTrackModel copy(List<BcmNode> r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r101, "btmGeneralParam");
        return new BcmStandTrackModel(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BcmStandTrackModel) == true) goto L8;
        return false;
    L8:
        BcmStandTrackModel r101 = (BcmStandTrackModel) r100;
        if (Intrinsics.areEqual(this.bcmParam, r101.bcmParam) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.btmGeneralParam, r101.btmGeneralParam) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<BcmNode> r100 = this.bcmParam;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.btmGeneralParam.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public String toString() {
        return "BcmStandTrackModel(bcmParam=" + this.bcmParam + ", btmGeneralParam=" + this.btmGeneralParam + ')';
    }

    public final List<BcmNode> getBcmParam() {
        return this.bcmParam;
    }

    public final Map<String, String> getBtmGeneralParam() {
        return this.btmGeneralParam;
    }

    public BcmStandTrackModel(List<BcmNode> r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r101, "btmGeneralParam");
        this.bcmParam = r100;
        this.btmGeneralParam = r101;
    }

    public /* synthetic */ BcmStandTrackModel(List r100, Map r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = CollectionsKt.emptyList();
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = new LinkedHashMap();
    L8:
        this(r100, r101);
    }
}
