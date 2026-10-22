package com.obric.assistant.settings;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f391998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<r> f391999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<b> f392000c;

    public c() {
        this(null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f391998a, r101.f391998a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f391999b, r101.f391999b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f392000c, r101.f392000c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        List<b> r100 = this.f391998a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<r> r104 = this.f391999b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<b> r107 = this.f392000c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AutoActionAppDataSource(sortedAvailableAppList=" + this.f391998a + ", appBlacklistFromCloud=" + this.f391999b + ", sortedAvailableAppBlacklist=" + this.f392000c + ')';
    }

    public c(List<b> r100, List<r> r101, List<b> r102) {
        this.f391998a = r100;
        this.f391999b = r101;
        this.f392000c = r102;
    }
}
