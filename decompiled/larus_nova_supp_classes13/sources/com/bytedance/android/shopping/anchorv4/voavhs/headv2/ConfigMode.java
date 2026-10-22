package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JP\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013¨\u0006%"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ConfigMode;", "Ljava/io/Serializable;", "hideFullMode", "", "hideHalfMode", "clientScale", "fontScale", "fontScaleMaxRatio", "", "disableLoad", "(Ljava/lang/Boolean;Ljava/lang/Boolean;ZZLjava/lang/Float;Z)V", "getClientScale", "()Z", "getDisableLoad", "getFontScale", "getFontScaleMaxRatio", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getHideFullMode", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getHideHalfMode", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;ZZLjava/lang/Float;Z)Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ConfigMode;", "equals", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ConfigMode implements Serializable {

    @SerializedName("client_scale")
    private final boolean clientScale;

    @SerializedName("disable_load")
    private final boolean disableLoad;

    @SerializedName("font_scale")
    private final boolean fontScale;

    @SerializedName("font_scale_max_ratio")
    private final Float fontScaleMaxRatio;

    @SerializedName("hide_full_mode")
    private final Boolean hideFullMode;

    @SerializedName("hide_half_mode")
    private final Boolean hideHalfMode;

    public ConfigMode() {
        this(null, null, false, false, null, false, 63, null);
    }

    public static /* synthetic */ ConfigMode copy$default(ConfigMode r4, Boolean r5, Boolean r6, boolean r7, boolean r8, Float r9, boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.hideFullMode;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.hideHalfMode;
    L8:
        Boolean r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.clientScale;
    L11:
        boolean r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.fontScale;
    L14:
        boolean r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.fontScaleMaxRatio;
    L17:
        Float r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.disableLoad;
    L20:
        Boolean r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final Boolean component1() {
        return this.hideFullMode;
    }

    public final Boolean component2() {
        return this.hideHalfMode;
    }

    public final boolean component3() {
        return this.clientScale;
    }

    public final boolean component4() {
        return this.fontScale;
    }

    public final Float component5() {
        return this.fontScaleMaxRatio;
    }

    public final boolean component6() {
        return this.disableLoad;
    }

    public final ConfigMode copy(Boolean r9, Boolean r10, boolean r11, boolean r12, Float r13, boolean r14) {
        return new ConfigMode(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ConfigMode) == false) goto L18;
        ConfigMode r4 = (ConfigMode) r3;
        if (Intrinsics.areEqual(this.hideFullMode, r4.hideFullMode) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.hideHalfMode, r4.hideHalfMode) == true) goto L10;
        return false;
    L10:
        if (this.clientScale == r4.clientScale) goto L12;
        return false;
    L12:
        if (this.fontScale == r4.fontScale) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.fontScaleMaxRatio, r4.fontScaleMaxRatio) == true) goto L16;
        return false;
    L16:
        if (this.disableLoad == r4.disableLoad) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        Boolean r0 = this.hideFullMode;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.hideHalfMode;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.clientScale;
        ?? r8 = 1;
        ?? r9 = r7;
        if (r7 == false) goto L13;
        r9 = 1;
    L13:
        int r10 = (r6 + r9) * 31;
        boolean r11 = this.fontScale;
        ?? r12 = r11;
        if (r11 == false) goto L16;
        r12 = 1;
    L16:
        int r13 = (r10 + r12) * 31;
        Float r14 = this.fontScaleMaxRatio;
        if (r14 == null) goto L19;
        r1 = r14.hashCode();
    L19:
        int r15 = (r13 + r1) * 31;
        boolean r16 = this.disableLoad;
        if (r16 == true) goto L24;
        r8 = r16;
    L24:
        return r15 + r8;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "ConfigMode(hideFullMode=" + this.hideFullMode + ", hideHalfMode=" + this.hideHalfMode + ", clientScale=" + this.clientScale + ", fontScale=" + this.fontScale + ", fontScaleMaxRatio=" + this.fontScaleMaxRatio + ", disableLoad=" + this.disableLoad + ")";
    }

    public final boolean getClientScale() {
        return this.clientScale;
    }

    public final boolean getDisableLoad() {
        return this.disableLoad;
    }

    public final boolean getFontScale() {
        return this.fontScale;
    }

    public final Float getFontScaleMaxRatio() {
        return this.fontScaleMaxRatio;
    }

    public final Boolean getHideFullMode() {
        return this.hideFullMode;
    }

    public final Boolean getHideHalfMode() {
        return this.hideHalfMode;
    }

    public ConfigMode(Boolean r1, Boolean r2, boolean r3, boolean r4, Float r5, boolean r6) {
        this.hideFullMode = r1;
        this.hideHalfMode = r2;
        this.clientScale = r3;
        this.fontScale = r4;
        this.fontScaleMaxRatio = r5;
        this.disableLoad = r6;
    }

    public /* synthetic */ ConfigMode(Boolean r5, Boolean r6, boolean r7, boolean r8, Float r9, boolean r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = Boolean.FALSE;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = Boolean.FALSE;
    L8:
        Boolean r13 = r6;
        boolean r0 = false;
        if ((r11 & 4) == 0) goto L11;
        boolean r1 = false;
    L13:
        if ((r11 & 8) == 0) goto L15;
        boolean r2 = false;
    L17:
        if ((r11 & 16) == 0) goto L19;
        r9 = null;
    L19:
        Float r3 = r9;
        if ((r11 & 32) != 0) goto L23;
        r0 = r10;
    L23:
        this(r5, r13, r1, r2, r3, r0);
        return;
    L15:
        r2 = r8;
        goto L17
    L11:
        r1 = r7;
        goto L13
    }
}
