package eq2;

import android.graphics.PointF;
import com.bytedance.android.livesdk.gift.model.o0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PointF f473478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f473479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o0 f473480c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L12;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f473478a, r101.f473478a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f473479b, r101.f473479b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f473480c, r101.f473480c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        PointF r100 = this.f473478a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.f473479b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        o0 r107 = this.f473480c;
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
        return "from:" + this.f473478a + ",toIDs:" + this.f473479b;
    }

    public e(PointF r100, List<String> r101, o0 r102) {
        Intrinsics.checkNotNullParameter(r101, "toUserIDs");
        this.f473478a = r100;
        this.f473479b = r101;
        this.f473480c = r102;
    }
}
