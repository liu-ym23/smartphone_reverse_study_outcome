package com.bytedance.locallife.groupon.api.toptools.model;

import com.bytedance.locallife.common.utils.d;
import com.bytedance.locallife.groupon.struct.bubble.model.ElementGuideBubbleStruct;
import com.bytedance.locallife.groupon.struct.bubble.model.GrouponRedDotStruct;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b%\b\u0087\b\u0018\u0000 I2\u00020\u0001:\u0001JB\u0093\u0001\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0011\u0012\u0018\b\u0002\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bG\u0010HJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0019\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0013HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u009c\u0001\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00112\u0018\b\u0002\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00132\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b!\u0010\"J\t\u0010#\u001a\u00020\u0004HÖ\u0001J\t\u0010$\u001a\u00020\u0006HÖ\u0001J\u0013\u0010'\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010(\u001a\u0004\b)\u0010*R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010+\u001a\u0004\b,\u0010\bR\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010-\u001a\u0004\b.\u0010/R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u00100\u001a\u0004\b1\u00102R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010(\u001a\u0004\b3\u0010*R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u00104\u001a\u0004\b5\u00106R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u00107\u001a\u0004\b8\u00109R*\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010:\u001a\u0004\b;\u0010<R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010(\u001a\u0004\b=\u0010*R\u001c\u0010 \u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010(\u001a\u0004\b>\u0010*R\u0018\u0010?\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\"\u0010A\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006K"}, d2 = {"Lcom/bytedance/locallife/groupon/api/toptools/model/EntranceStruct;", "", "Lcom/bytedance/locallife/groupon/api/toptools/model/RefreshData;", "getFreshDataStruct", "", "component1", "", "component2", "()Ljava/lang/Integer;", "", "Lcom/bytedance/locallife/groupon/api/toptools/model/EntranceConfig;", "component3", "Lcom/bytedance/locallife/groupon/api/toptools/model/ActionConfig;", "component4", "component5", "Lcom/bytedance/locallife/groupon/struct/bubble/model/GrouponRedDotStruct;", "component6", "Lcom/bytedance/locallife/groupon/struct/bubble/model/ElementGuideBubbleStruct;", "component7", "", "component8", "component9", "component10", "title", "titleWeight", "entranceConfigList", "action", "showName", "redDot", "bubble", "trackParams", "refreshDataStr", "btmDCode", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Lcom/bytedance/locallife/groupon/api/toptools/model/ActionConfig;Ljava/lang/String;Lcom/bytedance/locallife/groupon/struct/bubble/model/GrouponRedDotStruct;Lcom/bytedance/locallife/groupon/struct/bubble/model/ElementGuideBubbleStruct;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/locallife/groupon/api/toptools/model/EntranceStruct;", "toString", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Ljava/lang/Integer;", "getTitleWeight", "Ljava/util/List;", "getEntranceConfigList", "()Ljava/util/List;", "Lcom/bytedance/locallife/groupon/api/toptools/model/ActionConfig;", "getAction", "()Lcom/bytedance/locallife/groupon/api/toptools/model/ActionConfig;", "getShowName", "Lcom/bytedance/locallife/groupon/struct/bubble/model/GrouponRedDotStruct;", "getRedDot", "()Lcom/bytedance/locallife/groupon/struct/bubble/model/GrouponRedDotStruct;", "Lcom/bytedance/locallife/groupon/struct/bubble/model/ElementGuideBubbleStruct;", "getBubble", "()Lcom/bytedance/locallife/groupon/struct/bubble/model/ElementGuideBubbleStruct;", "Ljava/util/Map;", "getTrackParams", "()Ljava/util/Map;", "getRefreshDataStr", "getBtmDCode", "refreshData", "Lcom/bytedance/locallife/groupon/api/toptools/model/RefreshData;", "index", "I", "getIndex", "()I", "setIndex", "(I)V", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Lcom/bytedance/locallife/groupon/api/toptools/model/ActionConfig;Ljava/lang/String;Lcom/bytedance/locallife/groupon/struct/bubble/model/GrouponRedDotStruct;Lcom/bytedance/locallife/groupon/struct/bubble/model/ElementGuideBubbleStruct;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class EntranceStruct {
    public static final String COLLECTION_ENTRY = "collection_entry";
    public static final a Companion = null;
    public static final String ORDER_ENTRY = "order_entry";

    @SerializedName("action")
    private final ActionConfig action;

    @SerializedName("btm_d_code")
    private final String btmDCode;

    @SerializedName("bubble")
    private final ElementGuideBubbleStruct bubble;

    @SerializedName("entrance_config")
    private final List<EntranceConfig> entranceConfigList;
    private int index;

    @SerializedName("red_dot")
    private final GrouponRedDotStruct redDot;
    private RefreshData refreshData;

    @SerializedName("refresh_data")
    private final String refreshDataStr;

    @SerializedName("show_name")
    private final String showName;

    @SerializedName("title")
    private final String title;

    @SerializedName("title_weight")
    private final Integer titleWeight;

    @SerializedName("track_params")
    private final Map<String, Object> trackParams;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public EntranceStruct() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EntranceStruct copy$default(EntranceStruct r110, String r111, Integer r112, List r113, ActionConfig r114, String r115, GrouponRedDotStruct r116, ElementGuideBubbleStruct r117, Map r118, String r210, String r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.title;
    L7:
        if ((r212 & 2) == 0) goto L9;
        Integer r101 = r110.titleWeight;
    L11:
        if ((r212 & 4) == 0) goto L13;
        List r102 = r110.entranceConfigList;
    L15:
        if ((r212 & 8) == 0) goto L17;
        ActionConfig r103 = r110.action;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r104 = r110.showName;
    L23:
        if ((r212 & 32) == 0) goto L25;
        GrouponRedDotStruct r105 = r110.redDot;
    L27:
        if ((r212 & 64) == 0) goto L29;
        ElementGuideBubbleStruct r106 = r110.bubble;
    L31:
        if ((r212 & 128) == 0) goto L33;
        Map r107 = r110.trackParams;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r119 = r110.refreshDataStr;
    L39:
        if ((r212 & 512) == 0) goto L41;
        String r108 = r110.btmDCode;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
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

    public final String component1() {
        return this.title;
    }

    public final String component10() {
        return this.btmDCode;
    }

    public final Integer component2() {
        return this.titleWeight;
    }

    public final List<EntranceConfig> component3() {
        return this.entranceConfigList;
    }

    public final ActionConfig component4() {
        return this.action;
    }

    public final String component5() {
        return this.showName;
    }

    public final GrouponRedDotStruct component6() {
        return this.redDot;
    }

    public final ElementGuideBubbleStruct component7() {
        return this.bubble;
    }

    public final Map<String, Object> component8() {
        return this.trackParams;
    }

    public final String component9() {
        return this.refreshDataStr;
    }

    public final EntranceStruct copy(String r110, Integer r111, List<EntranceConfig> r112, ActionConfig r113, String r114, GrouponRedDotStruct r115, ElementGuideBubbleStruct r116, Map<String, ? extends Object> r210, String r211, String r212) {
        return new EntranceStruct(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof EntranceStruct) == true) goto L8;
        return false;
    L8:
        EntranceStruct r101 = (EntranceStruct) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.titleWeight, r101.titleWeight) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.entranceConfigList, r101.entranceConfigList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.showName, r101.showName) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.redDot, r101.redDot) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.bubble, r101.bubble) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.trackParams, r101.trackParams) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.refreshDataStr, r101.refreshDataStr) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.btmDCode, r101.btmDCode) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        String r100 = this.title;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.titleWeight;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<EntranceConfig> r107 = this.entranceConfigList;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        ActionConfig r110 = this.action;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.showName;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        GrouponRedDotStruct r116 = this.redDot;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        ElementGuideBubbleStruct r119 = this.bubble;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Map<String, Object> r122 = this.trackParams;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.refreshDataStr;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.btmDCode;
        if (r128 == null) goto L43;
        r101 = r128.hashCode();
    L43:
        return r127 + r101;
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "EntranceStruct(title=" + this.title + ", titleWeight=" + this.titleWeight + ", entranceConfigList=" + this.entranceConfigList + ", action=" + this.action + ", showName=" + this.showName + ", redDot=" + this.redDot + ", bubble=" + this.bubble + ", trackParams=" + this.trackParams + ", refreshDataStr=" + this.refreshDataStr + ", btmDCode=" + this.btmDCode + ')';
    }

    public final RefreshData getFreshDataStruct() {
        RefreshData r100 = this.refreshData;
        if (r100 == null) goto L10;
        return r100;
    L10:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        RefreshData r102 = (RefreshData) d.a(this.refreshDataStr, RefreshData.class);     // Catch: Throwable -> L7
        this.refreshData = r102;     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return null;
    }

    public final ActionConfig getAction() {
        return this.action;
    }

    public final String getBtmDCode() {
        return this.btmDCode;
    }

    public final ElementGuideBubbleStruct getBubble() {
        return this.bubble;
    }

    public final List<EntranceConfig> getEntranceConfigList() {
        return this.entranceConfigList;
    }

    public final int getIndex() {
        return this.index;
    }

    public final GrouponRedDotStruct getRedDot() {
        return this.redDot;
    }

    public final String getRefreshDataStr() {
        return this.refreshDataStr;
    }

    public final String getShowName() {
        return this.showName;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Integer getTitleWeight() {
        return this.titleWeight;
    }

    public final Map<String, Object> getTrackParams() {
        return this.trackParams;
    }

    public final void setIndex(int r100) {
        this.index = r100;
    }

    public EntranceStruct(String r100, Integer r101, List<EntranceConfig> r102, ActionConfig r103, String r104, GrouponRedDotStruct r105, ElementGuideBubbleStruct r106, Map<String, ? extends Object> r107, String r108, String r110) {
        this.title = r100;
        this.titleWeight = r101;
        this.entranceConfigList = r102;
        this.action = r103;
        this.showName = r104;
        this.redDot = r105;
        this.bubble = r106;
        this.trackParams = r107;
        this.refreshDataStr = r108;
        this.btmDCode = r110;
        this.index = -1;
    }

    public /* synthetic */ EntranceStruct(String r110, Integer r111, List r112, ActionConfig r113, String r114, GrouponRedDotStruct r115, ElementGuideBubbleStruct r116, Map r117, String r210, String r211, int r212, DefaultConstructorMarker r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r212 & 2) == 0) goto L9;
        Integer r101 = 400;
    L11:
        if ((r212 & 4) == 0) goto L13;
        List r102 = CollectionsKt.emptyList();
    L14:
        String r103 = null;
        if ((r212 & 8) == 0) goto L17;
        ActionConfig r104 = null;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r212 & 32) == 0) goto L25;
        GrouponRedDotStruct r106 = null;
    L27:
        if ((r212 & 64) == 0) goto L29;
        ElementGuideBubbleStruct r107 = null;
    L31:
        if ((r212 & 128) == 0) goto L33;
        Map r108 = null;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r118 = null;
    L39:
        if ((r212 & 512) != 0) goto L42;
        r103 = r211;
    L42:
        this(r100, r101, r102, r104, r105, r106, r107, r108, r118, r103);
        return;
    L37:
        r118 = r210;
        goto L39
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
        r104 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L14
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
