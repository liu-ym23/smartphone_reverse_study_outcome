package com.bytedance.android.shopping.api.mall.model;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000eJJ\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\t\u0010\u000eR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/BackgroundWrapper;", "", "light", "Lcom/bytedance/android/shopping/api/mall/model/BackgroundInfo;", "dark", "extra", "", "disableDarkModeGradientSwitch", "", "isDarkMode", "(Lcom/bytedance/android/shopping/api/mall/model/BackgroundInfo;Lcom/bytedance/android/shopping/api/mall/model/BackgroundInfo;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getDark", "()Lcom/bytedance/android/shopping/api/mall/model/BackgroundInfo;", "getDisableDarkModeGradientSwitch", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getExtra", "()Ljava/lang/String;", "getLight", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcom/bytedance/android/shopping/api/mall/model/BackgroundInfo;Lcom/bytedance/android/shopping/api/mall/model/BackgroundInfo;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/bytedance/android/shopping/api/mall/model/BackgroundWrapper;", "equals", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BackgroundWrapper {

    @SerializedName("dark")
    private final BackgroundInfo dark;

    @SerializedName("disable_darkmode_gradient_switch")
    private final Boolean disableDarkModeGradientSwitch;

    @SerializedName("extra")
    private final String extra;

    @SerializedName("is_dark_mode")
    private final Boolean isDarkMode;

    @SerializedName("light")
    private final BackgroundInfo light;

    public BackgroundWrapper() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ BackgroundWrapper copy$default(BackgroundWrapper r3, BackgroundInfo r4, BackgroundInfo r5, String r6, Boolean r7, Boolean r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.light;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.dark;
    L8:
        BackgroundInfo r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.extra;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.disableDarkModeGradientSwitch;
    L14:
        Boolean r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.isDarkMode;
    L17:
        BackgroundInfo r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final BackgroundInfo component1() {
        return this.light;
    }

    public final BackgroundInfo component2() {
        return this.dark;
    }

    public final String component3() {
        return this.extra;
    }

    public final Boolean component4() {
        return this.disableDarkModeGradientSwitch;
    }

    public final Boolean component5() {
        return this.isDarkMode;
    }

    public final BackgroundWrapper copy(BackgroundInfo r8, BackgroundInfo r9, String r10, Boolean r11, Boolean r12) {
        return new BackgroundWrapper(r8, r9, r10, r11, r12);
    }

    public String toString() {
        return "BackgroundWrapper(light=" + this.light + ", dark=" + this.dark + ", extra=" + this.extra + ", disableDarkModeGradientSwitch=" + this.disableDarkModeGradientSwitch + ", isDarkMode=" + this.isDarkMode + ")";
    }

    public int hashCode() {
        return BackgroundWrapper.class.hashCode();
    }

    public final BackgroundInfo getDark() {
        return this.dark;
    }

    public final Boolean getDisableDarkModeGradientSwitch() {
        return this.disableDarkModeGradientSwitch;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final BackgroundInfo getLight() {
        return this.light;
    }

    public final Boolean isDarkMode() {
        return this.isDarkMode;
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof BackgroundWrapper) == false) goto L16;
        BackgroundWrapper r5 = (BackgroundWrapper) r4;
        if (Intrinsics.areEqual(this.light, r5.light) == true) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(this.dark, r5.dark) == true) goto L9;
        return false;
    L9:
        if (TextUtils.equals(this.extra, r5.extra) == true) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(this.disableDarkModeGradientSwitch, r5.disableDarkModeGradientSwitch) == true) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(this.isDarkMode, r5.isDarkMode) == false) goto L21;
        return true;
    L21:
        return false;
    L16:
        return false;
    }

    public BackgroundWrapper(BackgroundInfo r1, BackgroundInfo r2, String r3, Boolean r4, Boolean r5) {
        this.light = r1;
        this.dark = r2;
        this.extra = r3;
        this.disableDarkModeGradientSwitch = r4;
        this.isDarkMode = r5;
    }

    public /* synthetic */ BackgroundWrapper(BackgroundInfo r5, BackgroundInfo r6, String r7, Boolean r8, Boolean r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        BackgroundInfo r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        BackgroundInfo r1 = null;
    L11:
        if ((r10 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r10 & 8) == 0) goto L17;
        Boolean r3 = null;
    L19:
        if ((r10 & 16) == 0) goto L21;
        Boolean r13 = null;
    L22:
        this(r12, r1, r2, r3, r13);
        return;
    L21:
        r13 = r9;
        goto L22
    L17:
        r3 = r8;
        goto L19
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }
}
