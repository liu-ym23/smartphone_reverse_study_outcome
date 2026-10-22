package com.bytedance.locallife.biz.fmp;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006HÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006HÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u0012J~\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00062\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00062\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\u000f2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\t\u0010,\u001a\u00020\u000bHÖ\u0001R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006-"}, d2 = {"Lcom/bytedance/locallife/biz/fmp/MobDiffResult;", "Ljava/io/Serializable;", "screenWidth", "", "screenHeight", "changeList", "", "Lcom/bytedance/locallife/biz/fmp/MobDiffItem;", "timeGap", "", "changeNodeList", "", "firstShowNodeList", "nonFirstShowNodeList", "allNodeFirstShow", "", "(IILjava/util/List;JLjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;)V", "getAllNodeFirstShow", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getChangeList", "()Ljava/util/List;", "getChangeNodeList", "getFirstShowNodeList", "getNonFirstShowNodeList", "getScreenHeight", "()I", "getScreenWidth", "getTimeGap", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(IILjava/util/List;JLjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;)Lcom/bytedance/locallife/biz/fmp/MobDiffResult;", "equals", "other", "", "hashCode", "toString", "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class MobDiffResult implements Serializable {

    @SerializedName("allNodeFirstShow")
    private final Boolean allNodeFirstShow;

    @SerializedName("changeList")
    private final List<MobDiffItem> changeList;

    @SerializedName("changeNodeList")
    private final List<String> changeNodeList;

    @SerializedName("firstShowNodeList")
    private final List<String> firstShowNodeList;

    @SerializedName("nonFirstShowNodeList")
    private final List<String> nonFirstShowNodeList;

    @SerializedName("screenHeight")
    private final int screenHeight;

    @SerializedName("screenWidth")
    private final int screenWidth;

    @SerializedName("timeGap")
    private final long timeGap;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MobDiffResult copy$default(MobDiffResult r110, int r111, int r112, List r113, long r114, List r115, List r116, List r117, Boolean r118, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        int r100 = r110.screenWidth;
    L7:
        if ((r210 & 2) == 0) goto L9;
        int r101 = r110.screenHeight;
    L11:
        if ((r210 & 4) == 0) goto L13;
        List r102 = r110.changeList;
    L15:
        if ((r210 & 8) == 0) goto L17;
        long r103 = r110.timeGap;
    L19:
        if ((r210 & 16) == 0) goto L21;
        List r104 = r110.changeNodeList;
    L23:
        if ((r210 & 32) == 0) goto L25;
        List r105 = r110.firstShowNodeList;
    L27:
        if ((r210 & 64) == 0) goto L29;
        List r106 = r110.nonFirstShowNodeList;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Boolean r107 = r110.allNodeFirstShow;
    L35:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107);
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final int component1() {
        return this.screenWidth;
    }

    public final int component2() {
        return this.screenHeight;
    }

    public final List<MobDiffItem> component3() {
        return this.changeList;
    }

    public final long component4() {
        return this.timeGap;
    }

    public final List<String> component5() {
        return this.changeNodeList;
    }

    public final List<String> component6() {
        return this.firstShowNodeList;
    }

    public final List<String> component7() {
        return this.nonFirstShowNodeList;
    }

    public final Boolean component8() {
        return this.allNodeFirstShow;
    }

    public final MobDiffResult copy(int r110, int r111, List<MobDiffItem> r112, long r113, List<String> r114, List<String> r115, List<String> r116, Boolean r210) {
        Intrinsics.checkNotNullParameter(r112, "changeList");
        return new MobDiffResult(r110, r111, r112, r113, r114, r115, r116, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MobDiffResult) == true) goto L8;
        return false;
    L8:
        MobDiffResult r101 = (MobDiffResult) r100;
        if (this.screenWidth == r101.screenWidth) goto L12;
        return false;
    L12:
        if (this.screenHeight == r101.screenHeight) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.changeList, r101.changeList) == true) goto L18;
        return false;
    L18:
        if (this.timeGap == r101.timeGap) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.changeNodeList, r101.changeNodeList) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.firstShowNodeList, r101.firstShowNodeList) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.nonFirstShowNodeList, r101.nonFirstShowNodeList) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.allNodeFirstShow, r101.allNodeFirstShow) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.screenWidth * 31) + this.screenHeight) * 31) + this.changeList.hashCode()) * 31;
        long r101 = this.timeGap;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        List<String> r103 = this.changeNodeList;
        int r104 = 0;
        if (r103 != null) goto L5;
        int r105 = 0;
    L6:
        int r106 = (r102 + r105) * 31;
        List<String> r107 = this.firstShowNodeList;
        if (r107 != null) goto L9;
        int r108 = 0;
    L10:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.nonFirstShowNodeList;
        if (r110 != null) goto L13;
        int r111 = 0;
    L14:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.allNodeFirstShow;
        if (r113 == null) goto L19;
        r104 = r113.hashCode();
    L19:
        return r112 + r104;
    L13:
        r111 = r110.hashCode();
        goto L14
    L9:
        r108 = r107.hashCode();
        goto L10
    L5:
        r105 = r103.hashCode();
        goto L6
    }

    public String toString() {
        return "MobDiffResult(screenWidth=" + this.screenWidth + ", screenHeight=" + this.screenHeight + ", changeList=" + this.changeList + ", timeGap=" + this.timeGap + ", changeNodeList=" + this.changeNodeList + ", firstShowNodeList=" + this.firstShowNodeList + ", nonFirstShowNodeList=" + this.nonFirstShowNodeList + ", allNodeFirstShow=" + this.allNodeFirstShow + ')';
    }

    public final Boolean getAllNodeFirstShow() {
        return this.allNodeFirstShow;
    }

    public final List<MobDiffItem> getChangeList() {
        return this.changeList;
    }

    public final List<String> getChangeNodeList() {
        return this.changeNodeList;
    }

    public final List<String> getFirstShowNodeList() {
        return this.firstShowNodeList;
    }

    public final List<String> getNonFirstShowNodeList() {
        return this.nonFirstShowNodeList;
    }

    public final int getScreenHeight() {
        return this.screenHeight;
    }

    public final int getScreenWidth() {
        return this.screenWidth;
    }

    public final long getTimeGap() {
        return this.timeGap;
    }

    public MobDiffResult(int r100, int r101, List<MobDiffItem> r102, long r103, List<String> r104, List<String> r105, List<String> r106, Boolean r110) {
        Intrinsics.checkNotNullParameter(r102, "changeList");
        this.screenWidth = r100;
        this.screenHeight = r101;
        this.changeList = r102;
        this.timeGap = r103;
        this.changeNodeList = r104;
        this.firstShowNodeList = r105;
        this.nonFirstShowNodeList = r106;
        this.allNodeFirstShow = r110;
    }

    public /* synthetic */ MobDiffResult(int r110, int r111, List r112, long r113, List r114, List r210, List r211, Boolean r212, int r213, DefaultConstructorMarker r214) {
        if ((r213 & 32) == 0) goto L5;
        List r115 = null;
    L7:
        if ((r213 & 64) == 0) goto L9;
        List r116 = null;
    L11:
        if ((r213 & 128) == 0) goto L13;
        Boolean r117 = null;
    L14:
        this(r110, r111, r112, r113, r114, r115, r116, r117);
        return;
    L13:
        r117 = r212;
        goto L14
    L9:
        r116 = r211;
        goto L11
    L5:
        r115 = r210;
        goto L7
    }
}
