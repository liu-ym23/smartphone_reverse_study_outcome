package vz1;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.model.TabChangeSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f557695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f557696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TabChangeSource f557697c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L12;
        j r101 = (j) r100;
        if (this.f557695a == r101.f557695a) goto L8;
        return false;
    L8:
        if (this.f557696b == r101.f557696b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f557697c, r101.f557697c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r100 = ((this.f557695a * 31) + this.f557696b) * 31;
        TabChangeSource r101 = this.f557697c;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "TabDataModel(tabIndex=" + this.f557695a + ", tabType=" + this.f557696b + ", changeSource=" + this.f557697c + ")";
    }

    public final int a() {
        return this.f557695a;
    }

    public final int b() {
        return this.f557696b;
    }

    public j(int r100, int r101, TabChangeSource r102) {
        Intrinsics.checkNotNullParameter(r102, "changeSource");
        this.f557695a = r100;
        this.f557696b = r101;
        this.f557697c = r102;
    }
}
