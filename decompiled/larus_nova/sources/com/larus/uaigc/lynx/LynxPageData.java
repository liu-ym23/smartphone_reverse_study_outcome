package com.larus.uaigc.lynx;

import com.larus.uaigc.lynx.pocket.RoundInfo;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B¯\u0001\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0006HÆ\u0003J\t\u0010+\u001a\u00020\bHÆ\u0003J\t\u0010,\u001a\u00020\bHÆ\u0003J\u0017\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003HÆ\u0003J\u0017\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003HÆ\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003J\t\u00100\u001a\u00020\u0004HÆ\u0003J\t\u00101\u001a\u00020\u0004HÆ\u0003J\t\u00102\u001a\u00020\u0004HÆ\u0003J\t\u00103\u001a\u00020\u0004HÆ\u0003J\t\u00104\u001a\u00020\u0004HÆ\u0003J\t\u00105\u001a\u00020\u0006HÆ\u0003J»\u0001\u00106\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u0006HÆ\u0001J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020\u0006HÖ\u0001J\t\u0010;\u001a\u00020\u0004HÖ\u0001R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u001f\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u001f\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0010\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0011\u0010\u0012\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010#R\u0011\u0010\u0014\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001a¨\u0006<"}, d2 = {"Lcom/larus/uaigc/lynx/LynxPageData;", "", "pocketPageData", "", "", "inputTopToBottomHeight", "", "clickActionBarTimeMs", "", "schemaHandleTimeMs", "traceInfo", "scatterMap", "roundList", "", "Lcom/larus/uaigc/lynx/pocket/RoundInfo;", "cacheInvalid", "inputBoxShowSetting", "showLoadingButton", "hasUsedNewYearAvatar", "sourceSchema", "userHasLottery", "<init>", "(Ljava/util/Map;IJJLjava/util/Map;Ljava/util/Map;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getPocketPageData", "()Ljava/util/Map;", "getInputTopToBottomHeight", "()I", "getClickActionBarTimeMs", "()J", "getSchemaHandleTimeMs", "getTraceInfo", "getScatterMap", "getRoundList", "()Ljava/util/List;", "getCacheInvalid", "()Ljava/lang/String;", "getInputBoxShowSetting", "getShowLoadingButton", "getHasUsedNewYearAvatar", "getSourceSchema", "getUserHasLottery", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxPageData {
    private final String cacheInvalid;
    private final long clickActionBarTimeMs;
    private final String hasUsedNewYearAvatar;
    private final String inputBoxShowSetting;
    private final int inputTopToBottomHeight;
    private final Map<String, Object> pocketPageData;
    private final List<RoundInfo> roundList;
    private final Map<String, Object> scatterMap;
    private final long schemaHandleTimeMs;
    private final String showLoadingButton;
    private final String sourceSchema;
    private final Map<String, Object> traceInfo;
    private final int userHasLottery;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LynxPageData copy$default(LynxPageData r110, Map r111, int r112, long r113, long r210, Map r211, Map r212, List r213, String r214, String r215, String r216, String r217, String r310, int r311, int r312, Object r313) {
        if ((r312 & 1) == 0) goto L5;
        Map r100 = r110.pocketPageData;
    L7:
        if ((r312 & 2) == 0) goto L9;
        int r101 = r110.inputTopToBottomHeight;
    L11:
        if ((r312 & 4) == 0) goto L13;
        long r102 = r110.clickActionBarTimeMs;
    L15:
        if ((r312 & 8) == 0) goto L17;
        long r103 = r110.schemaHandleTimeMs;
    L19:
        if ((r312 & 16) == 0) goto L21;
        Map r104 = r110.traceInfo;
    L23:
        if ((r312 & 32) == 0) goto L25;
        Map r105 = r110.scatterMap;
    L27:
        if ((r312 & 64) == 0) goto L29;
        List r114 = r110.roundList;
    L31:
        if ((r312 & 128) == 0) goto L33;
        String r115 = r110.cacheInvalid;
    L35:
        if ((r312 & 256) == 0) goto L37;
        String r116 = r110.inputBoxShowSetting;
    L39:
        if ((r312 & 512) == 0) goto L41;
        String r117 = r110.showLoadingButton;
    L43:
        if ((r312 & 1024) == 0) goto L45;
        String r118 = r110.hasUsedNewYearAvatar;
    L47:
        if ((r312 & 2048) == 0) goto L49;
        String r119 = r110.sourceSchema;
    L51:
        if ((r312 & 4096) == 0) goto L53;
        int r106 = r110.userHasLottery;
    L55:
        return r110.copy(r100, r101, r102, r103, r104, r105, r114, r115, r116, r117, r118, r119, r106);
    L53:
        r106 = r311;
        goto L55
    L49:
        r119 = r310;
        goto L51
    L45:
        r118 = r217;
        goto L47
    L41:
        r117 = r216;
        goto L43
    L37:
        r116 = r215;
        goto L39
    L33:
        r115 = r214;
        goto L35
    L29:
        r114 = r213;
        goto L31
    L25:
        r105 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
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

    public final Map<String, Object> component1() {
        return this.pocketPageData;
    }

    public final String component10() {
        return this.showLoadingButton;
    }

    public final String component11() {
        return this.hasUsedNewYearAvatar;
    }

    public final String component12() {
        return this.sourceSchema;
    }

    public final int component13() {
        return this.userHasLottery;
    }

    public final int component2() {
        return this.inputTopToBottomHeight;
    }

    public final long component3() {
        return this.clickActionBarTimeMs;
    }

    public final long component4() {
        return this.schemaHandleTimeMs;
    }

    public final Map<String, Object> component5() {
        return this.traceInfo;
    }

    public final Map<String, Object> component6() {
        return this.scatterMap;
    }

    public final List<RoundInfo> component7() {
        return this.roundList;
    }

    public final String component8() {
        return this.cacheInvalid;
    }

    public final String component9() {
        return this.inputBoxShowSetting;
    }

    public final LynxPageData copy(Map<String, ? extends Object> r110, int r111, long r210, long r211, Map<String, ? extends Object> r212, Map<String, ? extends Object> r213, List<RoundInfo> r214, String r215, String r216, String r217, String r310, String r311, int r312) {
        Intrinsics.checkNotNullParameter(r110, "pocketPageData");
        Intrinsics.checkNotNullParameter(r212, "traceInfo");
        Intrinsics.checkNotNullParameter(r213, "scatterMap");
        Intrinsics.checkNotNullParameter(r214, "roundList");
        Intrinsics.checkNotNullParameter(r215, "cacheInvalid");
        Intrinsics.checkNotNullParameter(r216, "inputBoxShowSetting");
        Intrinsics.checkNotNullParameter(r217, "showLoadingButton");
        Intrinsics.checkNotNullParameter(r310, "hasUsedNewYearAvatar");
        Intrinsics.checkNotNullParameter(r311, "sourceSchema");
        return new LynxPageData(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r310, r311, r312);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LynxPageData) == true) goto L8;
        return false;
    L8:
        LynxPageData r101 = (LynxPageData) r100;
        if (Intrinsics.areEqual(this.pocketPageData, r101.pocketPageData) == true) goto L12;
        return false;
    L12:
        if (this.inputTopToBottomHeight == r101.inputTopToBottomHeight) goto L15;
        return false;
    L15:
        if (this.clickActionBarTimeMs == r101.clickActionBarTimeMs) goto L18;
        return false;
    L18:
        if (this.schemaHandleTimeMs == r101.schemaHandleTimeMs) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.traceInfo, r101.traceInfo) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.scatterMap, r101.scatterMap) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.roundList, r101.roundList) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.cacheInvalid, r101.cacheInvalid) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.inputBoxShowSetting, r101.inputBoxShowSetting) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.showLoadingButton, r101.showLoadingButton) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.hasUsedNewYearAvatar, r101.hasUsedNewYearAvatar) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.sourceSchema, r101.sourceSchema) == true) goto L45;
        return false;
    L45:
        if (this.userHasLottery == r101.userHasLottery) goto L47;
        return false;
    L47:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.pocketPageData.hashCode() * 31) + this.inputTopToBottomHeight) * 31;
        long r101 = this.clickActionBarTimeMs;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.schemaHandleTimeMs;
        return ((((((((((((((((((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.traceInfo.hashCode()) * 31) + this.scatterMap.hashCode()) * 31) + this.roundList.hashCode()) * 31) + this.cacheInvalid.hashCode()) * 31) + this.inputBoxShowSetting.hashCode()) * 31) + this.showLoadingButton.hashCode()) * 31) + this.hasUsedNewYearAvatar.hashCode()) * 31) + this.sourceSchema.hashCode()) * 31) + this.userHasLottery;
    }

    public String toString() {
        return "LynxPageData(pocketPageData=" + this.pocketPageData + ", inputTopToBottomHeight=" + this.inputTopToBottomHeight + ", clickActionBarTimeMs=" + this.clickActionBarTimeMs + ", schemaHandleTimeMs=" + this.schemaHandleTimeMs + ", traceInfo=" + this.traceInfo + ", scatterMap=" + this.scatterMap + ", roundList=" + this.roundList + ", cacheInvalid=" + this.cacheInvalid + ", inputBoxShowSetting=" + this.inputBoxShowSetting + ", showLoadingButton=" + this.showLoadingButton + ", hasUsedNewYearAvatar=" + this.hasUsedNewYearAvatar + ", sourceSchema=" + this.sourceSchema + ", userHasLottery=" + this.userHasLottery + ')';
    }

    public final String getCacheInvalid() {
        return this.cacheInvalid;
    }

    public final long getClickActionBarTimeMs() {
        return this.clickActionBarTimeMs;
    }

    public final String getHasUsedNewYearAvatar() {
        return this.hasUsedNewYearAvatar;
    }

    public final String getInputBoxShowSetting() {
        return this.inputBoxShowSetting;
    }

    public final int getInputTopToBottomHeight() {
        return this.inputTopToBottomHeight;
    }

    public final Map<String, Object> getPocketPageData() {
        return this.pocketPageData;
    }

    public final List<RoundInfo> getRoundList() {
        return this.roundList;
    }

    public final Map<String, Object> getScatterMap() {
        return this.scatterMap;
    }

    public final long getSchemaHandleTimeMs() {
        return this.schemaHandleTimeMs;
    }

    public final String getShowLoadingButton() {
        return this.showLoadingButton;
    }

    public final String getSourceSchema() {
        return this.sourceSchema;
    }

    public final Map<String, Object> getTraceInfo() {
        return this.traceInfo;
    }

    public final int getUserHasLottery() {
        return this.userHasLottery;
    }

    public LynxPageData(Map<String, ? extends Object> r110, int r111, long r112, long r113, Map<String, ? extends Object> r114, Map<String, ? extends Object> r210, List<RoundInfo> r211, String r212, String r213, String r214, String r215, String r216, int r217) {
        Intrinsics.checkNotNullParameter(r110, "pocketPageData");
        Intrinsics.checkNotNullParameter(r114, "traceInfo");
        Intrinsics.checkNotNullParameter(r210, "scatterMap");
        Intrinsics.checkNotNullParameter(r211, "roundList");
        Intrinsics.checkNotNullParameter(r212, "cacheInvalid");
        Intrinsics.checkNotNullParameter(r213, "inputBoxShowSetting");
        Intrinsics.checkNotNullParameter(r214, "showLoadingButton");
        Intrinsics.checkNotNullParameter(r215, "hasUsedNewYearAvatar");
        Intrinsics.checkNotNullParameter(r216, "sourceSchema");
        this.pocketPageData = r110;
        this.inputTopToBottomHeight = r111;
        this.clickActionBarTimeMs = r112;
        this.schemaHandleTimeMs = r113;
        this.traceInfo = r114;
        this.scatterMap = r210;
        this.roundList = r211;
        this.cacheInvalid = r212;
        this.inputBoxShowSetting = r213;
        this.showLoadingButton = r214;
        this.hasUsedNewYearAvatar = r215;
        this.sourceSchema = r216;
        this.userHasLottery = r217;
    }

    public /* synthetic */ LynxPageData(Map r110, int r210, long r211, long r212, Map r213, Map r214, List r215, String r216, String r217, String r310, String r311, String r312, int r313, int r314, DefaultConstructorMarker r315) {
        if ((r314 & 1) == 0) goto L5;
        Map r100 = MapsKt.emptyMap();
    L7:
        if ((r314 & 2) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r314 & 4) == 0) goto L13;
        long r102 = 0;
    L15:
        if ((r314 & 8) == 0) goto L17;
        long r103 = 0;
    L19:
        if ((r314 & 16) == 0) goto L21;
        Map r104 = MapsKt.emptyMap();
    L23:
        if ((r314 & 32) == 0) goto L25;
        Map r111 = MapsKt.emptyMap();
    L27:
        if ((r314 & 64) == 0) goto L29;
        List r112 = CollectionsKt.emptyList();
    L31:
        if ((r314 & 4096) == 0) goto L33;
        int r113 = 0;
    L34:
        this(r100, r101, r102, r103, r104, r111, r112, r216, r217, r310, r311, r312, r113);
        return;
    L33:
        r113 = r313;
        goto L34
    L29:
        r112 = r215;
        goto L31
    L25:
        r111 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
