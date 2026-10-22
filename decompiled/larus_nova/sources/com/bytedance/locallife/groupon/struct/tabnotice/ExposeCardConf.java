package com.bytedance.locallife.groupon.struct.tabnotice;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/tabnotice/ExposeCardConf;", "", "exposeCardType", "", "exposeCardTypeNum", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getExposeCardType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getExposeCardTypeNum", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/locallife/groupon/struct/tabnotice/ExposeCardConf;", "equals", "", "other", "hashCode", "toString", "", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class ExposeCardConf {

    @SerializedName("expose_card_type")
    private final Integer exposeCardType;

    @SerializedName("expose_card_num")
    private final Integer exposeCardTypeNum;

    /* JADX WARN: Multi-variable type inference failed */
    public ExposeCardConf() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ExposeCardConf copy$default(ExposeCardConf r100, Integer r101, Integer r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.exposeCardType;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.exposeCardTypeNum;
    L9:
        return r100.copy(r101, r102);
    }

    public final Integer component1() {
        return this.exposeCardType;
    }

    public final Integer component2() {
        return this.exposeCardTypeNum;
    }

    public final ExposeCardConf copy(Integer r100, Integer r101) {
        return new ExposeCardConf(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ExposeCardConf) == true) goto L8;
        return false;
    L8:
        ExposeCardConf r101 = (ExposeCardConf) r100;
        if (Intrinsics.areEqual(this.exposeCardType, r101.exposeCardType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.exposeCardTypeNum, r101.exposeCardTypeNum) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.exposeCardType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.exposeCardTypeNum;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ExposeCardConf(exposeCardType=" + this.exposeCardType + ", exposeCardTypeNum=" + this.exposeCardTypeNum + ')';
    }

    public final Integer getExposeCardType() {
        return this.exposeCardType;
    }

    public final Integer getExposeCardTypeNum() {
        return this.exposeCardTypeNum;
    }

    public ExposeCardConf(Integer r100, Integer r101) {
        this.exposeCardType = r100;
        this.exposeCardTypeNum = r101;
    }

    public /* synthetic */ ExposeCardConf(Integer r100, Integer r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
