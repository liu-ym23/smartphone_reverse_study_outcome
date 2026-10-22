package com.ss.android.ugc.route_monitor.impl.launch_info;

import com.ss.android.ugc.route_monitor.ComponentType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f454459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ComponentType f454460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f454461c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f454459a, r101.f454459a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f454460b, r101.f454460b) == true) goto L10;
        return false;
    L10:
        if (this.f454461c == r101.f454461c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f454459a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ComponentType r104 = this.f454460b;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        long r106 = this.f454461c;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ComponentLaunchInfo(componentClassName=" + this.f454459a + ", componentType=" + this.f454460b + ", launchTimestamp=" + this.f454461c + ")";
    }

    public b(String r100, ComponentType r101, long r102) {
        this.f454459a = r100;
        this.f454460b = r101;
        this.f454461c = r102;
    }
}
