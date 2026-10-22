package com.bytedance.android.shopping.api.mall.common.dialog;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001d\b\u0087\b\u0018\u00002\u00020\u0001Bk\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\rJ\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003Jt\u0010 \u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0007HÖ\u0001J\t\u0010%\u001a\u00020\u0004HÖ\u0001R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017¨\u0006&"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/dialog/NativeDialogConfig;", "", "enablePageName", "", "", "disableComponent", "disablePlanId", "", "needAdaptiveParentType", "", "defaultTaskConfig", "defaultPopupConfig", "appendSchemaParams", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppendSchemaParams", "()Ljava/lang/String;", "getDefaultPopupConfig", "getDefaultTaskConfig", "getDisableComponent", "()Ljava/util/List;", "getDisablePlanId", "getEnablePageName", "getNeedAdaptiveParentType", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/dialog/NativeDialogConfig;", "equals", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NativeDialogConfig {

    @SerializedName("append_schema_params")
    private final String appendSchemaParams;

    @SerializedName("default_popup_config")
    private final String defaultPopupConfig;

    @SerializedName("default_task_config")
    private final String defaultTaskConfig;

    @SerializedName("disable_component")
    private final List<String> disableComponent;

    @SerializedName("disable_plan_id")
    private final List<Integer> disablePlanId;

    @SerializedName("enable_page_name")
    private final List<String> enablePageName;

    @SerializedName("need_adaptive_parent_type")
    private final Boolean needAdaptiveParentType;

    public NativeDialogConfig() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NativeDialogConfig copy$default(NativeDialogConfig r5, List r6, List r7, List r8, Boolean r9, String r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.enablePageName;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.disableComponent;
    L8:
        List r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.disablePlanId;
    L11:
        List r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.needAdaptiveParentType;
    L14:
        Boolean r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.defaultTaskConfig;
    L17:
        String r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.defaultPopupConfig;
    L20:
        String r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.appendSchemaParams;
    L23:
        List r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final List<String> component1() {
        return this.enablePageName;
    }

    public final List<String> component2() {
        return this.disableComponent;
    }

    public final List<Integer> component3() {
        return this.disablePlanId;
    }

    public final Boolean component4() {
        return this.needAdaptiveParentType;
    }

    public final String component5() {
        return this.defaultTaskConfig;
    }

    public final String component6() {
        return this.defaultPopupConfig;
    }

    public final String component7() {
        return this.appendSchemaParams;
    }

    public final NativeDialogConfig copy(List<String> r10, List<String> r11, List<Integer> r12, Boolean r13, String r14, String r15, String r16) {
        return new NativeDialogConfig(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof NativeDialogConfig) == false) goto L20;
        NativeDialogConfig r4 = (NativeDialogConfig) r3;
        if (Intrinsics.areEqual(this.enablePageName, r4.enablePageName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.disableComponent, r4.disableComponent) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.disablePlanId, r4.disablePlanId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.needAdaptiveParentType, r4.needAdaptiveParentType) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.defaultTaskConfig, r4.defaultTaskConfig) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.defaultPopupConfig, r4.defaultPopupConfig) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.appendSchemaParams, r4.appendSchemaParams) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        List<String> r0 = this.enablePageName;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.disableComponent;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<Integer> r7 = this.disablePlanId;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.needAdaptiveParentType;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.defaultTaskConfig;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.defaultPopupConfig;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.appendSchemaParams;
        if (r19 == null) goto L30;
        r1 = r19.hashCode();
    L30:
        return r18 + r1;
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "NativeDialogConfig(enablePageName=" + this.enablePageName + ", disableComponent=" + this.disableComponent + ", disablePlanId=" + this.disablePlanId + ", needAdaptiveParentType=" + this.needAdaptiveParentType + ", defaultTaskConfig=" + this.defaultTaskConfig + ", defaultPopupConfig=" + this.defaultPopupConfig + ", appendSchemaParams=" + this.appendSchemaParams + ")";
    }

    public final String getAppendSchemaParams() {
        return this.appendSchemaParams;
    }

    public final String getDefaultPopupConfig() {
        return this.defaultPopupConfig;
    }

    public final String getDefaultTaskConfig() {
        return this.defaultTaskConfig;
    }

    public final List<String> getDisableComponent() {
        return this.disableComponent;
    }

    public final List<Integer> getDisablePlanId() {
        return this.disablePlanId;
    }

    public final List<String> getEnablePageName() {
        return this.enablePageName;
    }

    public final Boolean getNeedAdaptiveParentType() {
        return this.needAdaptiveParentType;
    }

    public NativeDialogConfig(List<String> r1, List<String> r2, List<Integer> r3, Boolean r4, String r5, String r6, String r7) {
        this.enablePageName = r1;
        this.disableComponent = r2;
        this.disablePlanId = r3;
        this.needAdaptiveParentType = r4;
        this.defaultTaskConfig = r5;
        this.defaultPopupConfig = r6;
        this.appendSchemaParams = r7;
    }

    public /* synthetic */ NativeDialogConfig(List r7, List r8, List r9, Boolean r10, String r11, String r12, String r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L5;
        List r16 = null;
    L7:
        if ((r14 & 2) == 0) goto L9;
        List r1 = null;
    L11:
        if ((r14 & 4) == 0) goto L13;
        List r2 = null;
    L15:
        if ((r14 & 8) == 0) goto L17;
        Boolean r3 = null;
    L19:
        if ((r14 & 16) == 0) goto L21;
        String r4 = null;
    L23:
        if ((r14 & 32) == 0) goto L25;
        String r5 = null;
    L27:
        if ((r14 & 64) == 0) goto L29;
        String r17 = null;
    L30:
        this(r16, r1, r2, r3, r4, r5, r17);
        return;
    L29:
        r17 = r13;
        goto L30
    L25:
        r5 = r12;
        goto L27
    L21:
        r4 = r11;
        goto L23
    L17:
        r3 = r10;
        goto L19
    L13:
        r2 = r9;
        goto L15
    L9:
        r1 = r8;
        goto L11
    L5:
        r16 = r7;
        goto L7
    }
}
