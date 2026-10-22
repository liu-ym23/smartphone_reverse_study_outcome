package com.larus.canvas.service.bean;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.ss.android.cert.manager.constants.EventConstant;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BÍ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010#\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010%\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010'\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0011HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010*\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010+\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u0017\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017HÆ\u0003JÔ\u0001\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017HÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020\u0006HÖ\u0001J\t\u00104\u001a\u00020\nHÖ\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0014\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0012\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0012\u0010\f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/larus/canvas/service/bean/CanvasInfo;", "Ljava/io/Serializable;", "canvasId", "", "canvasSubId", "canvasType", "", "canvasStatus", "errCode", "errMsg", "", "effectMode", "replySubId", "taskType", WiseOpenHianalyticsData.UNION_COSTTIME, "Lcom/larus/canvas/service/bean/CostTime;", EventConstant.Key.RETAIN_PROMPT, "", "parentId", "canvasMaxCount", "aiBeautify", "Lcom/larus/canvas/service/bean/AIBeautify;", "ext", "", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/canvas/service/bean/CostTime;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Integer;Lcom/larus/canvas/service/bean/AIBeautify;Ljava/util/Map;)V", "Ljava/lang/Long;", "Ljava/lang/Integer;", "component1", "()Ljava/lang/Long;", "component2", "component3", "()Ljava/lang/Integer;", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/canvas/service/bean/CostTime;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Integer;Lcom/larus/canvas/service/bean/AIBeautify;Ljava/util/Map;)Lcom/larus/canvas/service/bean/CanvasInfo;", "equals", "", "other", "", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CanvasInfo implements Serializable {

    @SerializedName("ai_beautify")
    public final AIBeautify aiBeautify;

    @SerializedName("canvas_id")
    public final Long canvasId;

    @SerializedName("canvas_max_count")
    public final Integer canvasMaxCount;

    @SerializedName("canvas_status")
    public final Integer canvasStatus;

    @SerializedName("canvas_sub_id")
    public final Long canvasSubId;

    @SerializedName("canvas_type")
    public final Integer canvasType;

    @SerializedName(HiAnalyticsConstant.BI_KEY_COST_TIME)
    public final CostTime costTime;

    @SerializedName("effect_mode")
    public final Integer effectMode;

    @SerializedName("error_code")
    public final Long errCode;

    @SerializedName("error_msg")
    public final String errMsg;

    @SerializedName("ext")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    public final Map<String, String> ext;

    @SerializedName("parent_id")
    public final Long parentId;

    @SerializedName(EventConstant.Key.RETAIN_PROMPT)
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    public final List<String> prompt;

    @SerializedName("reply_sub_id")
    public final String replySubId;

    @SerializedName(AiProactiveTaskViewModel.PARAM_TASK_TYPE)
    public final Integer taskType;

    public CanvasInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CanvasInfo copy$default(CanvasInfo r110, Long r111, Long r112, Integer r113, Integer r210, Long r211, String r212, Integer r213, String r214, Integer r215, CostTime r216, List r217, Long r218, Integer r219, AIBeautify r310, Map r311, int r312, Object r313) {
        if ((r312 & 1) == 0) goto L5;
        Long r100 = r110.canvasId;
    L7:
        if ((r312 & 2) == 0) goto L9;
        Long r101 = r110.canvasSubId;
    L11:
        if ((r312 & 4) == 0) goto L13;
        Integer r102 = r110.canvasType;
    L15:
        if ((r312 & 8) == 0) goto L17;
        Integer r103 = r110.canvasStatus;
    L19:
        if ((r312 & 16) == 0) goto L21;
        Long r104 = r110.errCode;
    L23:
        if ((r312 & 32) == 0) goto L25;
        String r105 = r110.errMsg;
    L27:
        if ((r312 & 64) == 0) goto L29;
        Integer r106 = r110.effectMode;
    L31:
        if ((r312 & 128) == 0) goto L33;
        String r107 = r110.replySubId;
    L35:
        if ((r312 & 256) == 0) goto L37;
        Integer r114 = r110.taskType;
    L39:
        if ((r312 & 512) == 0) goto L41;
        CostTime r115 = r110.costTime;
    L43:
        if ((r312 & 1024) == 0) goto L45;
        List r116 = r110.prompt;
    L47:
        if ((r312 & 2048) == 0) goto L49;
        Long r117 = r110.parentId;
    L51:
        if ((r312 & 4096) == 0) goto L53;
        Integer r118 = r110.canvasMaxCount;
    L55:
        if ((r312 & 8192) == 0) goto L57;
        AIBeautify r119 = r110.aiBeautify;
    L59:
        if ((r312 & 16384) == 0) goto L61;
        Map r108 = r110.ext;
    L63:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r114, r115, r116, r117, r118, r119, r108);
    L61:
        r108 = r311;
        goto L63
    L57:
        r119 = r310;
        goto L59
    L53:
        r118 = r219;
        goto L55
    L49:
        r117 = r218;
        goto L51
    L45:
        r116 = r217;
        goto L47
    L41:
        r115 = r216;
        goto L43
    L37:
        r114 = r215;
        goto L39
    L33:
        r107 = r214;
        goto L35
    L29:
        r106 = r213;
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

    public final Long component1() {
        return this.canvasId;
    }

    public final CostTime component10() {
        return this.costTime;
    }

    public final List<String> component11() {
        return this.prompt;
    }

    public final Long component12() {
        return this.parentId;
    }

    public final Integer component13() {
        return this.canvasMaxCount;
    }

    public final AIBeautify component14() {
        return this.aiBeautify;
    }

    public final Map<String, String> component15() {
        return this.ext;
    }

    public final Long component2() {
        return this.canvasSubId;
    }

    public final Integer component3() {
        return this.canvasType;
    }

    public final Integer component4() {
        return this.canvasStatus;
    }

    public final Long component5() {
        return this.errCode;
    }

    public final String component6() {
        return this.errMsg;
    }

    public final Integer component7() {
        return this.effectMode;
    }

    public final String component8() {
        return this.replySubId;
    }

    public final Integer component9() {
        return this.taskType;
    }

    public final CanvasInfo copy(Long r110, Long r111, @CanvasType Integer r210, @CanvasStatus Integer r211, Long r212, String r213, @EffectMode Integer r214, String r215, Integer r216, CostTime r217, List<String> r218, Long r219, Integer r310, AIBeautify r311, Map<String, String> r312) {
        return new CanvasInfo(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CanvasInfo) == true) goto L8;
        return false;
    L8:
        CanvasInfo r101 = (CanvasInfo) r100;
        if (Intrinsics.areEqual(this.canvasId, r101.canvasId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.canvasSubId, r101.canvasSubId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.canvasType, r101.canvasType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.canvasStatus, r101.canvasStatus) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.errCode, r101.errCode) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.errMsg, r101.errMsg) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.effectMode, r101.effectMode) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.replySubId, r101.replySubId) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.taskType, r101.taskType) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.costTime, r101.costTime) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.prompt, r101.prompt) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.parentId, r101.parentId) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.canvasMaxCount, r101.canvasMaxCount) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.aiBeautify, r101.aiBeautify) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public int hashCode() {
        Long r100 = this.canvasId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.canvasSubId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.canvasType;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.canvasStatus;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.errCode;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.errMsg;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.effectMode;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.replySubId;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.taskType;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        CostTime r128 = this.costTime;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        List<String> r131 = this.prompt;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Long r134 = this.parentId;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        Integer r137 = this.canvasMaxCount;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        AIBeautify r140 = this.aiBeautify;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        Map<String, String> r143 = this.ext;
        if (r143 == null) goto L63;
        r101 = r143.hashCode();
    L63:
        return r142 + r101;
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
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
        return "CanvasInfo(canvasId=" + this.canvasId + ", canvasSubId=" + this.canvasSubId + ", canvasType=" + this.canvasType + ", canvasStatus=" + this.canvasStatus + ", errCode=" + this.errCode + ", errMsg=" + this.errMsg + ", effectMode=" + this.effectMode + ", replySubId=" + this.replySubId + ", taskType=" + this.taskType + ", costTime=" + this.costTime + ", prompt=" + this.prompt + ", parentId=" + this.parentId + ", canvasMaxCount=" + this.canvasMaxCount + ", aiBeautify=" + this.aiBeautify + ", ext=" + this.ext + ')';
    }

    public CanvasInfo(Long r100, Long r101, @CanvasType Integer r102, @CanvasStatus Integer r103, Long r104, String r105, @EffectMode Integer r106, String r107, Integer r108, CostTime r110, List<String> r111, Long r112, Integer r113, AIBeautify r114, Map<String, String> r115) {
        this.canvasId = r100;
        this.canvasSubId = r101;
        this.canvasType = r102;
        this.canvasStatus = r103;
        this.errCode = r104;
        this.errMsg = r105;
        this.effectMode = r106;
        this.replySubId = r107;
        this.taskType = r108;
        this.costTime = r110;
        this.prompt = r111;
        this.parentId = r112;
        this.canvasMaxCount = r113;
        this.aiBeautify = r114;
        this.ext = r115;
    }

    public /* synthetic */ CanvasInfo(Long r110, Long r111, Integer r112, Integer r210, Long r211, String r212, Integer r213, String r214, Integer r215, CostTime r216, List r217, Long r218, Integer r219, AIBeautify r310, Map r311, int r312, DefaultConstructorMarker r313) {
        Map r100 = null;
        if ((r312 & 1) == 0) goto L5;
        Long r101 = null;
    L7:
        if ((r312 & 2) == 0) goto L9;
        Long r102 = null;
    L11:
        if ((r312 & 4) == 0) goto L13;
        Integer r103 = null;
    L15:
        if ((r312 & 8) == 0) goto L17;
        Integer r104 = null;
    L19:
        if ((r312 & 16) == 0) goto L21;
        Long r105 = null;
    L23:
        if ((r312 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r312 & 64) == 0) goto L29;
        Integer r107 = null;
    L31:
        if ((r312 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r312 & 256) == 0) goto L37;
        Integer r113 = null;
    L39:
        if ((r312 & 512) == 0) goto L41;
        CostTime r114 = null;
    L43:
        if ((r312 & 1024) == 0) goto L45;
        List r115 = null;
    L47:
        if ((r312 & 2048) == 0) goto L49;
        Long r116 = null;
    L51:
        if ((r312 & 4096) == 0) goto L53;
        Integer r117 = null;
    L55:
        if ((r312 & 8192) == 0) goto L57;
        AIBeautify r118 = null;
    L59:
        if ((r312 & 16384) != 0) goto L62;
        r100 = r311;
    L62:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r113, r114, r115, r116, r117, r118, r100);
        return;
    L57:
        r118 = r310;
        goto L59
    L53:
        r117 = r219;
        goto L55
    L49:
        r116 = r218;
        goto L51
    L45:
        r115 = r217;
        goto L47
    L41:
        r114 = r216;
        goto L43
    L37:
        r113 = r215;
        goto L39
    L33:
        r108 = r214;
        goto L35
    L29:
        r107 = r213;
        goto L31
    L25:
        r106 = r212;
        goto L27
    L21:
        r105 = r211;
        goto L23
    L17:
        r104 = r210;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
