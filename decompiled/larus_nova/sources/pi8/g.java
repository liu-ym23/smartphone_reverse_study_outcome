package pi8;

import android.view.View;
import com.larus.bmhome.video.Content;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class g extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Content f529376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f529377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f529378c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f529376a, r101.f529376a) == true) goto L12;
        return false;
    L12:
        if (this.f529377b == r101.f529377b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f529378c, r101.f529378c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f529376a.hashCode() * 31) + this.f529377b) * 31) + this.f529378c.hashCode();
    }

    public final String toString() {
        return "MixedMediaCallbackData(itemData=" + this.f529376a + ", position=" + this.f529377b + ", itemView=" + this.f529378c + ')';
    }

    public g(Content r100, int r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, "itemData");
        Intrinsics.checkNotNullParameter(r102, "itemView");
        this.f529376a = r100;
        this.f529377b = r101;
        this.f529378c = r102;
    }
}
