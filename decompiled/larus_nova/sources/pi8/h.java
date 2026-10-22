package pi8;

import android.view.View;
import com.larus.bmhome.chat.search.MoreInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class h extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MoreInfo f529379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f529380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f529381c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f529379a, r101.f529379a) == true) goto L12;
        return false;
    L12:
        if (this.f529380b == r101.f529380b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f529381c, r101.f529381c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f529379a.hashCode() * 31) + this.f529380b) * 31) + this.f529381c.hashCode();
    }

    public final String toString() {
        return "MoreHolderCallbackData(itemData=" + this.f529379a + ", position=" + this.f529380b + ", itemView=" + this.f529381c + ')';
    }

    public h(MoreInfo r100, int r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, "itemData");
        Intrinsics.checkNotNullParameter(r102, "itemView");
        this.f529379a = r100;
        this.f529380b = r101;
        this.f529381c = r102;
    }
}
