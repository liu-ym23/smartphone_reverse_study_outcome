package com.larus.bmhome.taskskill;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<RemoteControlAuthorizationMode> f314316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RemoteControlAuthorizationMode f314317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f314318c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f314316a, r101.f314316a) == true) goto L12;
        return false;
    L12:
        if (this.f314317b == r101.f314317b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f314318c, r101.f314318c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f314316a.hashCode() * 31) + this.f314317b.hashCode()) * 31) + this.f314318c.hashCode();
    }

    public final String toString() {
        return "RemoteControlAuthorizationModeState(availableModes=" + this.f314316a + ", selectedMode=" + this.f314317b + ", remotePcDeviceId=" + this.f314318c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(List<? extends RemoteControlAuthorizationMode> r100, RemoteControlAuthorizationMode r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "availableModes");
        Intrinsics.checkNotNullParameter(r101, "selectedMode");
        Intrinsics.checkNotNullParameter(r102, "remotePcDeviceId");
        this.f314316a = r100;
        this.f314317b = r101;
        this.f314318c = r102;
    }
}
