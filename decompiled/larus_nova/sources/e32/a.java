package e32;

import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeDimension;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeScene;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DegradeScene f470901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DegradeSceneLevel f470902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DegradeDimension f470903c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f470901a, r101.f470901a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f470902b, r101.f470902b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f470903c, r101.f470903c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        DegradeScene r100 = this.f470901a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        DegradeSceneLevel r104 = this.f470902b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        DegradeDimension r107 = this.f470903c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DegradeRequest(degradeScene=" + this.f470901a + ", degradeLevel=" + this.f470902b + ", degradeDimension=" + this.f470903c + ")";
    }

    public a(DegradeScene r100, DegradeSceneLevel r101, DegradeDimension r102) {
        Intrinsics.checkNotNullParameter(r100, "degradeScene");
        Intrinsics.checkNotNullParameter(r101, "degradeLevel");
        Intrinsics.checkNotNullParameter(r102, "degradeDimension");
        this.f470901a = r100;
        this.f470902b = r101;
        this.f470903c = r102;
    }
}
