package com.bytedance.locallife.biz.collect.guide;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB/\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0002HÆ\u0003J1\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002HÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001a\u0010\n\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/bytedance/locallife/biz/collect/guide/SortRuleGuide;", "", "", "component1", "component2", "component3", "component4", "crossPoi", "xDay", "yTime", "recordClose", "copy", "", "toString", "hashCode", "other", "", "equals", "I", "getCrossPoi", "()I", "getXDay", "getYTime", "getRecordClose", "<init>", "(IIII)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3})
public final class SortRuleGuide {
    public static final a Companion = null;
    public static final int NO_RECORD_CLOSE = 1;
    public static final int RECORD_CLOSE = 0;
    public static final int RULE_GLOBAL = 0;
    public static final int RULE_POI = 1;

    @SerializedName("cross_poi")
    private final int crossPoi;

    @SerializedName("record_close")
    private final int recordClose;

    @SerializedName("x_day")
    private final int xDay;

    @SerializedName("y_time")
    private final int yTime;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public SortRuleGuide() {
        this(0, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ SortRuleGuide copy$default(SortRuleGuide r100, int r101, int r102, int r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.crossPoi;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.xDay;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.yTime;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.recordClose;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.crossPoi;
    }

    public final int component2() {
        return this.xDay;
    }

    public final int component3() {
        return this.yTime;
    }

    public final int component4() {
        return this.recordClose;
    }

    public final SortRuleGuide copy(int r100, int r101, int r102, int r103) {
        return new SortRuleGuide(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SortRuleGuide) == true) goto L8;
        return false;
    L8:
        SortRuleGuide r101 = (SortRuleGuide) r100;
        if (this.crossPoi == r101.crossPoi) goto L12;
        return false;
    L12:
        if (this.xDay == r101.xDay) goto L15;
        return false;
    L15:
        if (this.yTime == r101.yTime) goto L18;
        return false;
    L18:
        if (this.recordClose == r101.recordClose) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.crossPoi * 31) + this.xDay) * 31) + this.yTime) * 31) + this.recordClose;
    }

    public String toString() {
        return "SortRuleGuide(crossPoi=" + this.crossPoi + ", xDay=" + this.xDay + ", yTime=" + this.yTime + ", recordClose=" + this.recordClose + ')';
    }

    public final int getCrossPoi() {
        return this.crossPoi;
    }

    public final int getRecordClose() {
        return this.recordClose;
    }

    public final int getXDay() {
        return this.xDay;
    }

    public final int getYTime() {
        return this.yTime;
    }

    public SortRuleGuide(int r100, int r101, int r102, int r103) {
        this.crossPoi = r100;
        this.xDay = r101;
        this.yTime = r102;
        this.recordClose = r103;
    }

    public /* synthetic */ SortRuleGuide(int r100, int r101, int r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 0;
    L14:
        this(r100, r101, r102, r103);
    }
}
