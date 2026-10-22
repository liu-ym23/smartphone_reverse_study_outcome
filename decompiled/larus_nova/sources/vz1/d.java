package vz1;

import com.bytedance.android.livesdk.gift.model.e3;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f557648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<e3> f557649b;

    public d() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L10;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f557648a, r101.f557648a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f557649b, r101.f557649b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f557648a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<e3> r104 = this.f557649b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DIYShowIconInfo(cardName=" + this.f557648a + ", plugins=" + this.f557649b + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(String r100, List<? extends e3> r101) {
        this.f557648a = r100;
        this.f557649b = r101;
    }
}
