package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class n {
    private boolean capabilityReady;
    private boolean deviceInfoReady;
    private boolean evaluated;
    private final long generation;
    private final e key;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
        return false;
    L12:
        if (this.generation == r101.generation) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.key.hashCode() * 31;
        long r101 = this.generation;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "G2CapabilityConnection(key=" + this.key + ", generation=" + this.generation + ')';
    }

    public final boolean a() {
        return this.evaluated;
    }

    public final long b() {
        return this.generation;
    }

    public final e c() {
        return this.key;
    }

    public final Trigger e(boolean r100) {
        if (this.deviceInfoReady == false) goto L5;
        return null;
    L5:
        this.deviceInfoReady = true;
        if (this.capabilityReady == false) goto L13;
        this.evaluated = true;
        if (r100 == false) goto L10;
        Trigger r101 = Trigger.APP_FOREGROUND;
    L12:
        return r101;
    L10:
        r101 = Trigger.DEVICE_RECONNECTED;
        goto L12
    L13:
        return null;
    }

    public n(e r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.key = r100;
        this.generation = r101;
    }

    public final Trigger d(boolean r100, boolean r101) {
        boolean r102 = true;
        if (this.capabilityReady == false) goto L13;
        Trigger r103 = Trigger.CONDITION_CHANGED;
        if (r100 == true) goto L7;
    L9:
        r102 = false;
    L10:
        if (r102 == true) goto L12;
        return null;
    L12:
        return r103;
    L7:
        if (this.evaluated == false) goto L9;
    L13:
        this.capabilityReady = true;
        if (this.deviceInfoReady == false) goto L23;
        this.evaluated = true;
        if (r101 == false) goto L19;
        Trigger r104 = Trigger.APP_FOREGROUND;
    L21:
        return r104;
    L19:
        r104 = Trigger.DEVICE_RECONNECTED;
        goto L21
    L23:
        return null;
    }
}
