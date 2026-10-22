package com.ss.android.lark.chameleon.pluginsystem.plugin;

import java.util.Objects;

/* JADX INFO: loaded from: classes35.dex */
public final class DeviceInfo {
    public int statusBarHeight;
    public int titleBarHeight;
    public float titleBarLayoutVisiblePercent;
    public boolean titleBarVisible;
    public float titleBarVisiblePercent;

    public DeviceInfo() {
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.statusBarHeight), Integer.valueOf(this.titleBarHeight), Float.valueOf(this.titleBarVisiblePercent)});
    }

    public String toString() {
        return "DeviceInfo{statusBarHeight=" + this.statusBarHeight + ", titleBarHeight=" + this.titleBarHeight + ", titleBarVisiblePercent=" + this.titleBarVisiblePercent + ", titleBarLayoutVisiblePercent=" + this.titleBarLayoutVisiblePercent + '}';
    }

    public DeviceInfo(DeviceInfo r100) {
        this.statusBarHeight = r100.statusBarHeight;
        this.titleBarHeight = r100.titleBarHeight;
        this.titleBarVisiblePercent = r100.titleBarVisiblePercent;
        this.titleBarLayoutVisiblePercent = r100.titleBarLayoutVisiblePercent;
        this.titleBarVisible = r100.titleBarVisible;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L21:
        return false;
    L8:
        if (DeviceInfo.class != r100.getClass()) goto L21;
        DeviceInfo r101 = (DeviceInfo) r100;
        if (this.statusBarHeight == r101.statusBarHeight) goto L13;
    L19:
        return false;
    L13:
        if (this.titleBarHeight != r101.titleBarHeight) goto L19;
        if (this.titleBarVisible != r101.titleBarVisible) goto L19;
        if (Float.compare(r101.titleBarVisiblePercent, this.titleBarVisiblePercent) != 0) goto L19;
        return true;
    }
}
