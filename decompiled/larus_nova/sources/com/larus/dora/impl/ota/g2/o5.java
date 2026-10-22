package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class o5 {
    private final long abilityGeneration;
    private final Boolean abilitySupported;
    private final boolean featureEnabled;
    private final UserChoice userChoice;

    public o5() {
        this(false, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o5) == true) goto L8;
        return false;
    L8:
        o5 r101 = (o5) r100;
        if (this.featureEnabled == r101.featureEnabled) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.abilitySupported, r101.abilitySupported) == true) goto L15;
        return false;
    L15:
        if (this.abilityGeneration == r101.abilityGeneration) goto L18;
        return false;
    L18:
        if (this.userChoice == r101.userChoice) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.featureEnabled == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        Boolean r102 = this.abilitySupported;
        if (r102 != null) goto L9;
        int r103 = 0;
    L10:
        int r104 = (r101 + r103) * 31;
        long r105 = this.abilityGeneration;
        return ((r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31) + this.userChoice.hashCode();
    L9:
        r103 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "SwitchState(featureEnabled=" + this.featureEnabled + ", abilitySupported=" + this.abilitySupported + ", abilityGeneration=" + this.abilityGeneration + ", userChoice=" + this.userChoice + ')';
    }

    public final boolean e() {
        if (this.featureEnabled == true) goto L5;
    L7:
        return false;
    L5:
        if (this.userChoice == UserChoice.OFF) goto L7;
        return true;
    }

    public final boolean g() {
        if (this.featureEnabled == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.abilitySupported, Boolean.TRUE) == false) goto L7;
        return true;
    }

    public final long b() {
        return this.abilityGeneration;
    }

    public final Boolean c() {
        return this.abilitySupported;
    }

    public final boolean d() {
        return this.featureEnabled;
    }

    public final UserChoice f() {
        return this.userChoice;
    }

    public /* synthetic */ o5(boolean r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        boolean r102 = true;
    L7:
        if ((r101 & 8) == 0) goto L9;
        UserChoice r103 = UserChoice.UNSET;
    L10:
        this(r102, null, 0, r103);
        return;
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = r100;
        goto L7
    }

    public o5(boolean r100, Boolean r101, long r102, UserChoice r103) {
        Intrinsics.checkNotNullParameter(r103, "userChoice");
        this.featureEnabled = r100;
        this.abilitySupported = r101;
        this.abilityGeneration = r102;
        this.userChoice = r103;
    }

    public static o5 a(o5 r100, boolean r101, Boolean r102, long r103, UserChoice r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        r101 = r100.featureEnabled;
    L5:
        boolean r104 = r101;
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.abilitySupported;
    L8:
        Boolean r105 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.abilityGeneration;
    L11:
        long r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r110 = r100.userChoice;
    L14:
        UserChoice r107 = r110;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r107, "userChoice");
        return new o5(r104, r105, r106, r107);
    }
}
