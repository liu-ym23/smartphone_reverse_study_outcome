package x70;

import android.view.View;
import com.bytedance.android.live.core.tetris.layout.ViewState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f562792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewState f562793b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L10;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f562792a, r101.f562792a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f562793b, r101.f562793b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        View r100 = this.f562792a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ViewState r104 = this.f562793b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ViewWrapper(view=" + this.f562792a + ", viewState=" + this.f562793b + ")";
    }

    public d(View r100, ViewState r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "viewState");
        this.f562792a = r100;
        this.f562793b = r101;
    }
}
