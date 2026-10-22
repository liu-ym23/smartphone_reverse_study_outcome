package com.larus.platform.model.mainbot;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/larus/platform/model/mainbot/AoSettingsConfig;", "", "enableShowEcommerceAnchor", "", "enableShowLocalLifeAnchor", "<init>", "(ZZ)V", "getEnableShowEcommerceAnchor", "()Z", "getEnableShowLocalLifeAnchor", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AoSettingsConfig {

    @SerializedName("enable_show_ecommerce_anchor")
    private final boolean enableShowEcommerceAnchor;

    @SerializedName("enable_show_locallife_anchor")
    private final boolean enableShowLocalLifeAnchor;

    public AoSettingsConfig() {
        boolean r100 = false;
        this(r100, r100, 3, null);
    }

    public static /* synthetic */ AoSettingsConfig copy$default(AoSettingsConfig r100, boolean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.enableShowEcommerceAnchor;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.enableShowLocalLifeAnchor;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.enableShowEcommerceAnchor;
    }

    public final boolean component2() {
        return this.enableShowLocalLifeAnchor;
    }

    public final AoSettingsConfig copy(boolean r100, boolean r101) {
        return new AoSettingsConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AoSettingsConfig) == true) goto L8;
        return false;
    L8:
        AoSettingsConfig r101 = (AoSettingsConfig) r100;
        if (this.enableShowEcommerceAnchor == r101.enableShowEcommerceAnchor) goto L12;
        return false;
    L12:
        if (this.enableShowLocalLifeAnchor == r101.enableShowLocalLifeAnchor) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.enableShowEcommerceAnchor == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.enableShowLocalLifeAnchor == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "AoSettingsConfig(enableShowEcommerceAnchor=" + this.enableShowEcommerceAnchor + ", enableShowLocalLifeAnchor=" + this.enableShowLocalLifeAnchor + ')';
    }

    public final boolean getEnableShowEcommerceAnchor() {
        return this.enableShowEcommerceAnchor;
    }

    public final boolean getEnableShowLocalLifeAnchor() {
        return this.enableShowLocalLifeAnchor;
    }

    public AoSettingsConfig(boolean r100, boolean r101) {
        this.enableShowEcommerceAnchor = r100;
        this.enableShowLocalLifeAnchor = r101;
    }

    public /* synthetic */ AoSettingsConfig(boolean r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = false;
    L8:
        this(r100, r101);
    }
}
