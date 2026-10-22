package com.bytedance.locallife.groupon.struct.performance;

import com.google.gson.annotations.SerializedName;
import com.larus.caijing_pay.impl.config.CJHostRouterServiceImpl;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b!\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\b\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0010J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0017\u0010%\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\bHÆ\u0003J\u0017\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bHÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010(\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0090\u0001\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\b2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020\u00032\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\tHÖ\u0001R$\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R$\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0018\u0010\u0014R\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u001aR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001d\u0010\u0014R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b \u0010\u0014¨\u00061"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/performance/TtiOPtConfig;", "", "enableGrouponTabId", "", "delayDiamondEnable", "defaultDelay", "useAnnieX", "anniexBlackList", "", "", "appendParam", "", "defaultDiamondTime", "", "defaultFeedTime", "appendLocParam", "(ZLjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/Map;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;)V", "getAnniexBlackList", "()Ljava/util/List;", "getAppendLocParam", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAppendParam", "()Ljava/util/Map;", "getDefaultDelay", "getDefaultDiamondTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDefaultFeedTime", "getDelayDiamondEnable", "getEnableGrouponTabId", "()Z", "getUseAnnieX", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ZLjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/Map;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;)Lcom/bytedance/locallife/groupon/struct/performance/TtiOPtConfig;", "equals", "other", "hashCode", "", "toString", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class TtiOPtConfig {

    @SerializedName("anniex_black_list")
    private final List<List<String>> anniexBlackList;

    @SerializedName("append_loc_param")
    private final Boolean appendLocParam;

    @SerializedName("append_param")
    private final Map<String, String> appendParam;

    @SerializedName("default_delay")
    private final Boolean defaultDelay;

    @SerializedName("default_delay_diamond_time")
    private final Long defaultDiamondTime;

    @SerializedName("default_delay_feed_time")
    private final Long defaultFeedTime;

    @SerializedName("delay_diamond_enable")
    private final Boolean delayDiamondEnable;

    @SerializedName("group_on_opt")
    private final boolean enableGrouponTabId;

    @SerializedName(CJHostRouterServiceImpl.URI_KEY_USE_ANNIEX)
    private final Boolean useAnnieX;

    public TtiOPtConfig() {
        this(false, null, null, null, null, null, null, null, null, 511, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TtiOPtConfig copy$default(TtiOPtConfig r110, boolean r111, Boolean r112, Boolean r113, Boolean r114, List r115, Map r116, Long r117, Long r118, Boolean r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        boolean r100 = r110.enableGrouponTabId;
    L7:
        if ((r210 & 2) == 0) goto L9;
        Boolean r101 = r110.delayDiamondEnable;
    L11:
        if ((r210 & 4) == 0) goto L13;
        Boolean r102 = r110.defaultDelay;
    L15:
        if ((r210 & 8) == 0) goto L17;
        Boolean r103 = r110.useAnnieX;
    L19:
        if ((r210 & 16) == 0) goto L21;
        List r104 = r110.anniexBlackList;
    L23:
        if ((r210 & 32) == 0) goto L25;
        Map r105 = r110.appendParam;
    L27:
        if ((r210 & 64) == 0) goto L29;
        Long r106 = r110.defaultDiamondTime;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Long r107 = r110.defaultFeedTime;
    L35:
        if ((r210 & 256) == 0) goto L37;
        Boolean r108 = r110.appendLocParam;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
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

    public final boolean component1() {
        return this.enableGrouponTabId;
    }

    public final Boolean component2() {
        return this.delayDiamondEnable;
    }

    public final Boolean component3() {
        return this.defaultDelay;
    }

    public final Boolean component4() {
        return this.useAnnieX;
    }

    public final List<List<String>> component5() {
        return this.anniexBlackList;
    }

    public final Map<String, String> component6() {
        return this.appendParam;
    }

    public final Long component7() {
        return this.defaultDiamondTime;
    }

    public final Long component8() {
        return this.defaultFeedTime;
    }

    public final Boolean component9() {
        return this.appendLocParam;
    }

    public final TtiOPtConfig copy(boolean r110, Boolean r111, Boolean r112, Boolean r113, List<? extends List<String>> r114, Map<String, String> r115, Long r116, Long r117, Boolean r210) {
        return new TtiOPtConfig(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TtiOPtConfig) == true) goto L8;
        return false;
    L8:
        TtiOPtConfig r101 = (TtiOPtConfig) r100;
        if (this.enableGrouponTabId == r101.enableGrouponTabId) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.delayDiamondEnable, r101.delayDiamondEnable) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.defaultDelay, r101.defaultDelay) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.useAnnieX, r101.useAnnieX) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.anniexBlackList, r101.anniexBlackList) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.appendParam, r101.appendParam) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.defaultDiamondTime, r101.defaultDiamondTime) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.defaultFeedTime, r101.defaultFeedTime) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.appendLocParam, r101.appendLocParam) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        if (this.enableGrouponTabId == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        Boolean r102 = this.delayDiamondEnable;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        Boolean r106 = this.defaultDelay;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        Boolean r109 = this.useAnnieX;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        List<List<String>> r112 = this.anniexBlackList;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        Map<String, String> r115 = this.appendParam;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        Long r118 = this.defaultDiamondTime;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (r117 + r119) * 31;
        Long r121 = this.defaultFeedTime;
        if (r121 != null) goto L33;
        int r122 = 0;
    L34:
        int r123 = (r120 + r122) * 31;
        Boolean r124 = this.appendLocParam;
        if (r124 == null) goto L39;
        r103 = r124.hashCode();
    L39:
        return r123 + r103;
    L33:
        r122 = r121.hashCode();
        goto L34
    L29:
        r119 = r118.hashCode();
        goto L30
    L25:
        r116 = r115.hashCode();
        goto L26
    L21:
        r113 = r112.hashCode();
        goto L22
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "TtiOPtConfig(enableGrouponTabId=" + this.enableGrouponTabId + ", delayDiamondEnable=" + this.delayDiamondEnable + ", defaultDelay=" + this.defaultDelay + ", useAnnieX=" + this.useAnnieX + ", anniexBlackList=" + this.anniexBlackList + ", appendParam=" + this.appendParam + ", defaultDiamondTime=" + this.defaultDiamondTime + ", defaultFeedTime=" + this.defaultFeedTime + ", appendLocParam=" + this.appendLocParam + ')';
    }

    public final List<List<String>> getAnniexBlackList() {
        return this.anniexBlackList;
    }

    public final Boolean getAppendLocParam() {
        return this.appendLocParam;
    }

    public final Map<String, String> getAppendParam() {
        return this.appendParam;
    }

    public final Boolean getDefaultDelay() {
        return this.defaultDelay;
    }

    public final Long getDefaultDiamondTime() {
        return this.defaultDiamondTime;
    }

    public final Long getDefaultFeedTime() {
        return this.defaultFeedTime;
    }

    public final Boolean getDelayDiamondEnable() {
        return this.delayDiamondEnable;
    }

    public final boolean getEnableGrouponTabId() {
        return this.enableGrouponTabId;
    }

    public final Boolean getUseAnnieX() {
        return this.useAnnieX;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TtiOPtConfig(boolean r100, Boolean r101, Boolean r102, Boolean r103, List<? extends List<String>> r104, Map<String, String> r105, Long r106, Long r107, Boolean r108) {
        this.enableGrouponTabId = r100;
        this.delayDiamondEnable = r101;
        this.defaultDelay = r102;
        this.useAnnieX = r103;
        this.anniexBlackList = r104;
        this.appendParam = r105;
        this.defaultDiamondTime = r106;
        this.defaultFeedTime = r107;
        this.appendLocParam = r108;
    }

    public /* synthetic */ TtiOPtConfig(boolean r110, Boolean r111, Boolean r112, Boolean r113, List r114, Map r115, Long r116, Long r117, Boolean r118, int r210, DefaultConstructorMarker r211) {
        if ((r210 & 1) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r210 & 2) == 0) goto L9;
        Boolean r101 = Boolean.FALSE;
    L11:
        if ((r210 & 4) == 0) goto L13;
        Boolean r102 = Boolean.FALSE;
    L15:
        if ((r210 & 8) == 0) goto L17;
        Boolean r103 = Boolean.FALSE;
    L18:
        Boolean r104 = null;
        if ((r210 & 16) == 0) goto L21;
        List r105 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        Map r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        Long r107 = null;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Long r108 = null;
    L35:
        if ((r210 & 256) != 0) goto L38;
        r104 = r118;
    L38:
        this(r100, r101, r102, r103, r105, r106, r107, r108, r104);
        return;
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L18
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
