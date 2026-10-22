package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b<\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001Bµ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010B\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010G\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u00100J\u0010\u0010H\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u00100J\u0010\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0011\u0010J\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013HÆ\u0003J\u0010\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J¼\u0001\u0010L\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010MJ\u0013\u0010N\u001a\u00020\u000f2\b\u0010O\u001a\u0004\u0018\u00010PHÖ\u0003J\t\u0010Q\u001a\u00020\u0003HÖ\u0001J\t\u0010R\u001a\u00020\tHÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b \u0010\u0018\"\u0004\b!\u0010\u001aR\"\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R \u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010%\"\u0004\b)\u0010'R \u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'R \u0010\f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'R \u0010\r\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010%\"\u0004\b/\u0010'R\"\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\b\u000e\u00100\"\u0004\b1\u00102R\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\b4\u00100\"\u0004\b5\u00102R\"\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b6\u0010\u0018\"\u0004\b7\u0010\u001aR&\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b<\u0010\u0018\"\u0004\b=\u0010\u001a¨\u0006S"}, d2 = {"Lcom/larus/livetutor/api/idl/EvaluateLabel;", "Ljava/io/Serializable;", "evaluateLabelId", "", "evaluateLabelType", "Lcom/larus/livetutor/api/idl/EvaluateLabelType;", "exclusiveOptionGroup", "level", "evaluateLabelDesc", "", "evaluateLabelIcon", "inputFillingDesc", "selectOptionToastDesc", "selectedEvaluateLabelIcon", "isDescRequired", "", "noneedDesc", "evaluateLabelScore", "nextOptEvaluateLabelIds", "", "newFeedbackNodeId", "<init>", "(Ljava/lang/Integer;Lcom/larus/livetutor/api/idl/EvaluateLabelType;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;)V", "getEvaluateLabelId", "()Ljava/lang/Integer;", "setEvaluateLabelId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getEvaluateLabelType", "()Lcom/larus/livetutor/api/idl/EvaluateLabelType;", "setEvaluateLabelType", "(Lcom/larus/livetutor/api/idl/EvaluateLabelType;)V", "getExclusiveOptionGroup", "setExclusiveOptionGroup", "getLevel", "setLevel", "getEvaluateLabelDesc", "()Ljava/lang/String;", "setEvaluateLabelDesc", "(Ljava/lang/String;)V", "getEvaluateLabelIcon", "setEvaluateLabelIcon", "getInputFillingDesc", "setInputFillingDesc", "getSelectOptionToastDesc", "setSelectOptionToastDesc", "getSelectedEvaluateLabelIcon", "setSelectedEvaluateLabelIcon", "()Ljava/lang/Boolean;", "setDescRequired", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getNoneedDesc", "setNoneedDesc", "getEvaluateLabelScore", "setEvaluateLabelScore", "getNextOptEvaluateLabelIds", "()Ljava/util/List;", "setNextOptEvaluateLabelIds", "(Ljava/util/List;)V", "getNewFeedbackNodeId", "setNewFeedbackNodeId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(Ljava/lang/Integer;Lcom/larus/livetutor/api/idl/EvaluateLabelType;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;)Lcom/larus/livetutor/api/idl/EvaluateLabel;", "equals", "other", "", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EvaluateLabel implements Serializable {

    @SerializedName("evaluate_label_desc")
    private String evaluateLabelDesc;

    @SerializedName("evaluate_label_icon")
    private String evaluateLabelIcon;

    @SerializedName("evaluate_label_id")
    private Integer evaluateLabelId;

    @SerializedName("evaluate_label_score")
    private Integer evaluateLabelScore;

    @SerializedName("evaluate_label_type")
    private EvaluateLabelType evaluateLabelType;

    @SerializedName("exclusive_option_group")
    private Integer exclusiveOptionGroup;

    @SerializedName("input_filling_desc")
    private String inputFillingDesc;

    @SerializedName("is_desc_required")
    private Boolean isDescRequired;

    @SerializedName("level")
    private Integer level;

    @SerializedName("new_feedback_node_id")
    private Integer newFeedbackNodeId;

    @SerializedName("next_opt_evaluate_label_ids")
    private List<Integer> nextOptEvaluateLabelIds;

    @SerializedName("noneed_desc")
    private Boolean noneedDesc;

    @SerializedName("select_option_toast_desc")
    private String selectOptionToastDesc;

    @SerializedName("selected_evaluate_label_icon")
    private String selectedEvaluateLabelIcon;

    public EvaluateLabel() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EvaluateLabel copy$default(EvaluateLabel r110, Integer r111, EvaluateLabelType r112, Integer r113, Integer r114, String r210, String r211, String r212, String r213, String r214, Boolean r215, Boolean r216, Integer r217, List r218, Integer r219, int r310, Object r311) {
        if ((r310 & 1) == 0) goto L5;
        Integer r100 = r110.evaluateLabelId;
    L7:
        if ((r310 & 2) == 0) goto L9;
        EvaluateLabelType r101 = r110.evaluateLabelType;
    L11:
        if ((r310 & 4) == 0) goto L13;
        Integer r102 = r110.exclusiveOptionGroup;
    L15:
        if ((r310 & 8) == 0) goto L17;
        Integer r103 = r110.level;
    L19:
        if ((r310 & 16) == 0) goto L21;
        String r104 = r110.evaluateLabelDesc;
    L23:
        if ((r310 & 32) == 0) goto L25;
        String r105 = r110.evaluateLabelIcon;
    L27:
        if ((r310 & 64) == 0) goto L29;
        String r106 = r110.inputFillingDesc;
    L31:
        if ((r310 & 128) == 0) goto L33;
        String r107 = r110.selectOptionToastDesc;
    L35:
        if ((r310 & 256) == 0) goto L37;
        String r115 = r110.selectedEvaluateLabelIcon;
    L39:
        if ((r310 & 512) == 0) goto L41;
        Boolean r116 = r110.isDescRequired;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        Boolean r117 = r110.noneedDesc;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        Integer r118 = r110.evaluateLabelScore;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        List r119 = r110.nextOptEvaluateLabelIds;
    L55:
        if ((r310 & 8192) == 0) goto L57;
        Integer r108 = r110.newFeedbackNodeId;
    L59:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r115, r116, r117, r118, r119, r108);
    L57:
        r108 = r219;
        goto L59
    L53:
        r119 = r218;
        goto L55
    L49:
        r118 = r217;
        goto L51
    L45:
        r117 = r216;
        goto L47
    L41:
        r116 = r215;
        goto L43
    L37:
        r115 = r214;
        goto L39
    L33:
        r107 = r213;
        goto L35
    L29:
        r106 = r212;
        goto L31
    L25:
        r105 = r211;
        goto L27
    L21:
        r104 = r210;
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

    public final Integer component1() {
        return this.evaluateLabelId;
    }

    public final Boolean component10() {
        return this.isDescRequired;
    }

    public final Boolean component11() {
        return this.noneedDesc;
    }

    public final Integer component12() {
        return this.evaluateLabelScore;
    }

    public final List<Integer> component13() {
        return this.nextOptEvaluateLabelIds;
    }

    public final Integer component14() {
        return this.newFeedbackNodeId;
    }

    public final EvaluateLabelType component2() {
        return this.evaluateLabelType;
    }

    public final Integer component3() {
        return this.exclusiveOptionGroup;
    }

    public final Integer component4() {
        return this.level;
    }

    public final String component5() {
        return this.evaluateLabelDesc;
    }

    public final String component6() {
        return this.evaluateLabelIcon;
    }

    public final String component7() {
        return this.inputFillingDesc;
    }

    public final String component8() {
        return this.selectOptionToastDesc;
    }

    public final String component9() {
        return this.selectedEvaluateLabelIcon;
    }

    public final EvaluateLabel copy(Integer r110, EvaluateLabelType r111, Integer r112, Integer r210, String r211, String r212, String r213, String r214, String r215, Boolean r216, Boolean r217, Integer r218, List<Integer> r219, Integer r310) {
        return new EvaluateLabel(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof EvaluateLabel) == true) goto L8;
        return false;
    L8:
        EvaluateLabel r101 = (EvaluateLabel) r100;
        if (Intrinsics.areEqual(this.evaluateLabelId, r101.evaluateLabelId) == true) goto L12;
        return false;
    L12:
        if (this.evaluateLabelType == r101.evaluateLabelType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.exclusiveOptionGroup, r101.exclusiveOptionGroup) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.level, r101.level) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.evaluateLabelDesc, r101.evaluateLabelDesc) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.evaluateLabelIcon, r101.evaluateLabelIcon) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.inputFillingDesc, r101.inputFillingDesc) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.selectOptionToastDesc, r101.selectOptionToastDesc) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.selectedEvaluateLabelIcon, r101.selectedEvaluateLabelIcon) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.isDescRequired, r101.isDescRequired) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.noneedDesc, r101.noneedDesc) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.evaluateLabelScore, r101.evaluateLabelScore) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.nextOptEvaluateLabelIds, r101.nextOptEvaluateLabelIds) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.newFeedbackNodeId, r101.newFeedbackNodeId) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.evaluateLabelId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        EvaluateLabelType r104 = this.evaluateLabelType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.exclusiveOptionGroup;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.level;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.evaluateLabelDesc;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.evaluateLabelIcon;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.inputFillingDesc;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.selectOptionToastDesc;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.selectedEvaluateLabelIcon;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.isDescRequired;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Boolean r131 = this.noneedDesc;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Integer r134 = this.evaluateLabelScore;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        List<Integer> r137 = this.nextOptEvaluateLabelIds;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        Integer r140 = this.newFeedbackNodeId;
        if (r140 == null) goto L59;
        r101 = r140.hashCode();
    L59:
        return r139 + r101;
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
        return "EvaluateLabel(evaluateLabelId=" + this.evaluateLabelId + ", evaluateLabelType=" + this.evaluateLabelType + ", exclusiveOptionGroup=" + this.exclusiveOptionGroup + ", level=" + this.level + ", evaluateLabelDesc=" + this.evaluateLabelDesc + ", evaluateLabelIcon=" + this.evaluateLabelIcon + ", inputFillingDesc=" + this.inputFillingDesc + ", selectOptionToastDesc=" + this.selectOptionToastDesc + ", selectedEvaluateLabelIcon=" + this.selectedEvaluateLabelIcon + ", isDescRequired=" + this.isDescRequired + ", noneedDesc=" + this.noneedDesc + ", evaluateLabelScore=" + this.evaluateLabelScore + ", nextOptEvaluateLabelIds=" + this.nextOptEvaluateLabelIds + ", newFeedbackNodeId=" + this.newFeedbackNodeId + ')';
    }

    public final String getEvaluateLabelDesc() {
        return this.evaluateLabelDesc;
    }

    public final String getEvaluateLabelIcon() {
        return this.evaluateLabelIcon;
    }

    public final Integer getEvaluateLabelId() {
        return this.evaluateLabelId;
    }

    public final Integer getEvaluateLabelScore() {
        return this.evaluateLabelScore;
    }

    public final EvaluateLabelType getEvaluateLabelType() {
        return this.evaluateLabelType;
    }

    public final Integer getExclusiveOptionGroup() {
        return this.exclusiveOptionGroup;
    }

    public final String getInputFillingDesc() {
        return this.inputFillingDesc;
    }

    public final Integer getLevel() {
        return this.level;
    }

    public final Integer getNewFeedbackNodeId() {
        return this.newFeedbackNodeId;
    }

    public final List<Integer> getNextOptEvaluateLabelIds() {
        return this.nextOptEvaluateLabelIds;
    }

    public final Boolean getNoneedDesc() {
        return this.noneedDesc;
    }

    public final String getSelectOptionToastDesc() {
        return this.selectOptionToastDesc;
    }

    public final String getSelectedEvaluateLabelIcon() {
        return this.selectedEvaluateLabelIcon;
    }

    public final Boolean isDescRequired() {
        return this.isDescRequired;
    }

    public final void setDescRequired(Boolean r100) {
        this.isDescRequired = r100;
    }

    public final void setEvaluateLabelDesc(String r100) {
        this.evaluateLabelDesc = r100;
    }

    public final void setEvaluateLabelIcon(String r100) {
        this.evaluateLabelIcon = r100;
    }

    public final void setEvaluateLabelId(Integer r100) {
        this.evaluateLabelId = r100;
    }

    public final void setEvaluateLabelScore(Integer r100) {
        this.evaluateLabelScore = r100;
    }

    public final void setEvaluateLabelType(EvaluateLabelType r100) {
        this.evaluateLabelType = r100;
    }

    public final void setExclusiveOptionGroup(Integer r100) {
        this.exclusiveOptionGroup = r100;
    }

    public final void setInputFillingDesc(String r100) {
        this.inputFillingDesc = r100;
    }

    public final void setLevel(Integer r100) {
        this.level = r100;
    }

    public final void setNewFeedbackNodeId(Integer r100) {
        this.newFeedbackNodeId = r100;
    }

    public final void setNextOptEvaluateLabelIds(List<Integer> r100) {
        this.nextOptEvaluateLabelIds = r100;
    }

    public final void setNoneedDesc(Boolean r100) {
        this.noneedDesc = r100;
    }

    public final void setSelectOptionToastDesc(String r100) {
        this.selectOptionToastDesc = r100;
    }

    public final void setSelectedEvaluateLabelIcon(String r100) {
        this.selectedEvaluateLabelIcon = r100;
    }

    public EvaluateLabel(Integer r100, EvaluateLabelType r101, Integer r102, Integer r103, String r104, String r105, String r106, String r107, String r108, Boolean r110, Boolean r111, Integer r112, List<Integer> r113, Integer r114) {
        this.evaluateLabelId = r100;
        this.evaluateLabelType = r101;
        this.exclusiveOptionGroup = r102;
        this.level = r103;
        this.evaluateLabelDesc = r104;
        this.evaluateLabelIcon = r105;
        this.inputFillingDesc = r106;
        this.selectOptionToastDesc = r107;
        this.selectedEvaluateLabelIcon = r108;
        this.isDescRequired = r110;
        this.noneedDesc = r111;
        this.evaluateLabelScore = r112;
        this.nextOptEvaluateLabelIds = r113;
        this.newFeedbackNodeId = r114;
    }

    public /* synthetic */ EvaluateLabel(Integer r110, EvaluateLabelType r111, Integer r112, Integer r113, String r210, String r211, String r212, String r213, String r214, Boolean r215, Boolean r216, Integer r217, List r218, Integer r219, int r310, DefaultConstructorMarker r311) {
        Integer r100 = null;
        if ((r310 & 1) == 0) goto L5;
        Integer r101 = null;
    L7:
        if ((r310 & 2) == 0) goto L9;
        EvaluateLabelType r102 = null;
    L11:
        if ((r310 & 4) == 0) goto L13;
        Integer r103 = null;
    L15:
        if ((r310 & 8) == 0) goto L17;
        Integer r104 = null;
    L19:
        if ((r310 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r310 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r310 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r310 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r310 & 256) == 0) goto L37;
        String r114 = null;
    L39:
        if ((r310 & 512) == 0) goto L41;
        Boolean r115 = null;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        Boolean r116 = null;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        Integer r117 = null;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        List r118 = null;
    L55:
        if ((r310 & 8192) != 0) goto L58;
        r100 = r219;
    L58:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r114, r115, r116, r117, r118, r100);
        return;
    L53:
        r118 = r218;
        goto L55
    L49:
        r117 = r217;
        goto L51
    L45:
        r116 = r216;
        goto L47
    L41:
        r115 = r215;
        goto L43
    L37:
        r114 = r214;
        goto L39
    L33:
        r108 = r213;
        goto L35
    L29:
        r107 = r212;
        goto L31
    L25:
        r106 = r211;
        goto L27
    L21:
        r105 = r210;
        goto L23
    L17:
        r104 = r113;
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
