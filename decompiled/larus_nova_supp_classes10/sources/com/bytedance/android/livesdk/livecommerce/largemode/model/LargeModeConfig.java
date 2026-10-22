package com.bytedance.android.livesdk.livecommerce.largemode.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003JK\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/largemode/model/LargeModeConfig;", "Ljava/io/Serializable;", "configName", "", "componentName", "bigFontLevel", "bigFontScale", "data", "", "Lcom/bytedance/android/livesdk/livecommerce/largemode/model/ComponentLargeModeConfig;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getBigFontLevel", "()Ljava/lang/String;", "getBigFontScale", "getComponentName", "getConfigName", "getData", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public final class LargeModeConfig implements Serializable {

    @SerializedName("big_font_level")
    private final String bigFontLevel;

    @SerializedName("big_font_scale")
    private final String bigFontScale;

    @SerializedName("component_name")
    private final String componentName;

    @SerializedName("config_name")
    private final String configName;

    @SerializedName("data")
    private final List<ComponentLargeModeConfig> data;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LargeModeConfig copy$default(LargeModeConfig r3, String r4, String r5, String r6, String r7, List r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.configName;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.componentName;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.bigFontLevel;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.bigFontScale;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.data;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.configName;
    }

    public final String component2() {
        return this.componentName;
    }

    public final String component3() {
        return this.bigFontLevel;
    }

    public final String component4() {
        return this.bigFontScale;
    }

    public final List<ComponentLargeModeConfig> component5() {
        return this.data;
    }

    public final LargeModeConfig copy(String r8, String r9, String r10, String r11, List<ComponentLargeModeConfig> r12) {
        return new LargeModeConfig(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof LargeModeConfig) == false) goto L16;
        LargeModeConfig r4 = (LargeModeConfig) r3;
        if (Intrinsics.areEqual(this.configName, r4.configName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.componentName, r4.componentName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.bigFontLevel, r4.bigFontLevel) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bigFontScale, r4.bigFontScale) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.data, r4.data) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r0 = this.configName;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.componentName;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.bigFontLevel;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.bigFontScale;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        List<ComponentLargeModeConfig> r13 = this.data;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
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
        return "LargeModeConfig(configName=" + this.configName + ", componentName=" + this.componentName + ", bigFontLevel=" + this.bigFontLevel + ", bigFontScale=" + this.bigFontScale + ", data=" + this.data + ")";
    }

    public final String getBigFontLevel() {
        return this.bigFontLevel;
    }

    public final String getBigFontScale() {
        return this.bigFontScale;
    }

    public final String getComponentName() {
        return this.componentName;
    }

    public final String getConfigName() {
        return this.configName;
    }

    public final List<ComponentLargeModeConfig> getData() {
        return this.data;
    }

    public LargeModeConfig(String r1, String r2, String r3, String r4, List<ComponentLargeModeConfig> r5) {
        this.configName = r1;
        this.componentName = r2;
        this.bigFontLevel = r3;
        this.bigFontScale = r4;
        this.data = r5;
    }

    public /* synthetic */ LargeModeConfig(String r7, String r8, String r9, String r10, List r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 8) == 0) goto L5;
        r10 = null;
    L5:
        this(r7, r8, r9, r10, r11);
    }
}
