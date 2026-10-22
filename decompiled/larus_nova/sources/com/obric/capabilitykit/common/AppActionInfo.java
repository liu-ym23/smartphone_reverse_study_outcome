package com.obric.capabilitykit.common;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/obric/capabilitykit/common/AppActionInfo;", "", "packageName", "", "appName", "action", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getAppName", "getPackageName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AppActionInfo {
    private final String action;
    private final String appName;
    private final String packageName;

    public AppActionInfo(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "packageName");
        Intrinsics.checkNotNullParameter(r101, "appName");
        Intrinsics.checkNotNullParameter(r102, "action");
        this.packageName = r100;
        this.appName = r101;
        this.action = r102;
    }

    public static /* synthetic */ AppActionInfo copy$default(AppActionInfo r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.packageName;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.appName;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.action;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.packageName;
    }

    public final String component2() {
        return this.appName;
    }

    public final String component3() {
        return this.action;
    }

    public final AppActionInfo copy(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "packageName");
        Intrinsics.checkNotNullParameter(r101, "appName");
        Intrinsics.checkNotNullParameter(r102, "action");
        return new AppActionInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AppActionInfo) == true) goto L8;
        return false;
    L8:
        AppActionInfo r101 = (AppActionInfo) r100;
        if (Intrinsics.areEqual(this.packageName, r101.packageName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appName, r101.appName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getAction() {
        return this.action;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        return (((this.packageName.hashCode() * 31) + this.appName.hashCode()) * 31) + this.action.hashCode();
    }

    public String toString() {
        return "AppActionInfo(packageName=" + this.packageName + ", appName=" + this.appName + ", action=" + this.action + ')';
    }
}
