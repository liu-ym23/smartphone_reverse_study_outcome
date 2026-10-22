package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003JE\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/obric/assistant/ComplexTaskSettingsConfig;", "", "defaultComplexTaskMode", "", "defaultComplexTaskLlmModel", "complexTaskModeList", "", "Lcom/obric/assistant/ComplexTaskSettingsCommonItem;", "complexTaskLlmModelList", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getDefaultComplexTaskMode", "()Ljava/lang/String;", "getDefaultComplexTaskLlmModel", "getComplexTaskModeList", "()Ljava/util/List;", "getComplexTaskLlmModelList", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ComplexTaskSettingsConfig {

    @SerializedName("complex_task_llm_model_list")
    private final List<ComplexTaskSettingsCommonItem> complexTaskLlmModelList;

    @SerializedName("complex_task_mode_list")
    private final List<ComplexTaskSettingsCommonItem> complexTaskModeList;

    @SerializedName("default_complex_task_llm_model")
    private final String defaultComplexTaskLlmModel;

    @SerializedName("default_complex_task_mode")
    private final String defaultComplexTaskMode;

    public ComplexTaskSettingsConfig() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ComplexTaskSettingsConfig copy$default(ComplexTaskSettingsConfig r100, String r101, String r102, List r103, List r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.defaultComplexTaskMode;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.defaultComplexTaskLlmModel;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.complexTaskModeList;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.complexTaskLlmModelList;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.defaultComplexTaskMode;
    }

    public final String component2() {
        return this.defaultComplexTaskLlmModel;
    }

    public final List<ComplexTaskSettingsCommonItem> component3() {
        return this.complexTaskModeList;
    }

    public final List<ComplexTaskSettingsCommonItem> component4() {
        return this.complexTaskLlmModelList;
    }

    public final ComplexTaskSettingsConfig copy(String r100, String r101, List<ComplexTaskSettingsCommonItem> r102, List<ComplexTaskSettingsCommonItem> r103) {
        return new ComplexTaskSettingsConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ComplexTaskSettingsConfig) == true) goto L8;
        return false;
    L8:
        ComplexTaskSettingsConfig r101 = (ComplexTaskSettingsConfig) r100;
        if (Intrinsics.areEqual(this.defaultComplexTaskMode, r101.defaultComplexTaskMode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.defaultComplexTaskLlmModel, r101.defaultComplexTaskLlmModel) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.complexTaskModeList, r101.complexTaskModeList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.complexTaskLlmModelList, r101.complexTaskLlmModelList) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.defaultComplexTaskMode;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.defaultComplexTaskLlmModel;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<ComplexTaskSettingsCommonItem> r107 = this.complexTaskModeList;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<ComplexTaskSettingsCommonItem> r110 = this.complexTaskLlmModelList;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "ComplexTaskSettingsConfig(defaultComplexTaskMode=" + this.defaultComplexTaskMode + ", defaultComplexTaskLlmModel=" + this.defaultComplexTaskLlmModel + ", complexTaskModeList=" + this.complexTaskModeList + ", complexTaskLlmModelList=" + this.complexTaskLlmModelList + ')';
    }

    public final List<ComplexTaskSettingsCommonItem> getComplexTaskLlmModelList() {
        return this.complexTaskLlmModelList;
    }

    public final List<ComplexTaskSettingsCommonItem> getComplexTaskModeList() {
        return this.complexTaskModeList;
    }

    public final String getDefaultComplexTaskLlmModel() {
        return this.defaultComplexTaskLlmModel;
    }

    public final String getDefaultComplexTaskMode() {
        return this.defaultComplexTaskMode;
    }

    public ComplexTaskSettingsConfig(String r100, String r101, List<ComplexTaskSettingsCommonItem> r102, List<ComplexTaskSettingsCommonItem> r103) {
        this.defaultComplexTaskMode = r100;
        this.defaultComplexTaskLlmModel = r101;
        this.complexTaskModeList = r102;
        this.complexTaskLlmModelList = r103;
    }

    public /* synthetic */ ComplexTaskSettingsConfig(String r100, String r101, List r102, List r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
