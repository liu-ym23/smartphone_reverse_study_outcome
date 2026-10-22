package com.bytedance.locallife.biz.btm.bcm;

import com.bytedance.crash.dumper.Scraps;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u0015\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003JA\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/locallife/biz/btm/bcm/BcmNode;", "Ljava/io/Serializable;", "btm", "", "page", "", Scraps.INNER_UNIT, "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "getBtm", "()Ljava/lang/String;", "getPage", "()Ljava/util/Map;", "getUnit", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class BcmNode implements Serializable {
    private final String btm;
    private final Map<String, String> page;
    private final Map<String, String> unit;

    public BcmNode() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BcmNode copy$default(BcmNode r100, String r101, Map r102, Map r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.btm;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.page;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.unit;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.btm;
    }

    public final Map<String, String> component2() {
        return this.page;
    }

    public final Map<String, String> component3() {
        return this.unit;
    }

    public final BcmNode copy(String r100, Map<String, String> r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r101, "page");
        Intrinsics.checkNotNullParameter(r102, Scraps.INNER_UNIT);
        return new BcmNode(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BcmNode) == true) goto L8;
        return false;
    L8:
        BcmNode r101 = (BcmNode) r100;
        if (Intrinsics.areEqual(this.btm, r101.btm) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.page, r101.page) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.unit, r101.unit) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.btm;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((r101 * 31) + this.page.hashCode()) * 31) + this.unit.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public String toString() {
        return "BcmNode(btm=" + this.btm + ", page=" + this.page + ", unit=" + this.unit + ')';
    }

    public final String getBtm() {
        return this.btm;
    }

    public final Map<String, String> getPage() {
        return this.page;
    }

    public final Map<String, String> getUnit() {
        return this.unit;
    }

    public BcmNode(String r100, Map<String, String> r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r101, "page");
        Intrinsics.checkNotNullParameter(r102, Scraps.INNER_UNIT);
        this.btm = r100;
        this.page = r101;
        this.unit = r102;
    }

    public /* synthetic */ BcmNode(String r100, Map r101, Map r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = new LinkedHashMap();
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = new LinkedHashMap();
    L11:
        this(r100, r101, r102);
    }
}
