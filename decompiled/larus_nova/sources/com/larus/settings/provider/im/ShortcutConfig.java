package com.larus.settings.provider.im;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/settings/provider/im/ShortcutConfig;", "", "isOpenPinShortcut", "", "isOpenDynamicShortcut", "<init>", "(ZZ)V", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShortcutConfig {

    @SerializedName("long_press_dynamic_shortcut")
    private final boolean isOpenDynamicShortcut;

    @SerializedName("is_open_pin_shortcut")
    private final boolean isOpenPinShortcut;

    public ShortcutConfig() {
        boolean r100 = false;
        this(r100, r100, 3, null);
    }

    public static /* synthetic */ ShortcutConfig copy$default(ShortcutConfig r100, boolean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.isOpenPinShortcut;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.isOpenDynamicShortcut;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.isOpenPinShortcut;
    }

    public final boolean component2() {
        return this.isOpenDynamicShortcut;
    }

    public final ShortcutConfig copy(boolean r100, boolean r101) {
        return new ShortcutConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ShortcutConfig) == true) goto L8;
        return false;
    L8:
        ShortcutConfig r101 = (ShortcutConfig) r100;
        if (this.isOpenPinShortcut == r101.isOpenPinShortcut) goto L12;
        return false;
    L12:
        if (this.isOpenDynamicShortcut == r101.isOpenDynamicShortcut) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.isOpenPinShortcut == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.isOpenDynamicShortcut == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "ShortcutConfig(isOpenPinShortcut=" + this.isOpenPinShortcut + ", isOpenDynamicShortcut=" + this.isOpenDynamicShortcut + ')';
    }

    public final boolean isOpenDynamicShortcut() {
        return this.isOpenDynamicShortcut;
    }

    public final boolean isOpenPinShortcut() {
        return this.isOpenPinShortcut;
    }

    public ShortcutConfig(boolean r100, boolean r101) {
        this.isOpenPinShortcut = r100;
        this.isOpenDynamicShortcut = r101;
    }

    public /* synthetic */ ShortcutConfig(boolean r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = false;
    L8:
        this(r100, r101);
    }
}
