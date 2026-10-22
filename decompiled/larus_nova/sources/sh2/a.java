package sh2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f541937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f541938b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (this.f541937a == r101.f541937a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f541938b, r101.f541938b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f541937a * 31;
        Integer r101 = this.f541938b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "IntroPopMessageContext(msgType=" + this.f541937a + ", openPriceTriggerType=" + this.f541938b + ")";
    }

    public a(int r100, Integer r101) {
        this.f541937a = r100;
        this.f541938b = r101;
    }
}
