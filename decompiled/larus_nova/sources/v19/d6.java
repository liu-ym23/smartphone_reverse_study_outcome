package v19;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class d6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView.OnScrollListener f552456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View.OnLayoutChangeListener f552457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f552458c;

    public d6() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d6) == true) goto L8;
        return false;
    L8:
        d6 r101 = (d6) r100;
        if (Intrinsics.areEqual(this.f552456a, r101.f552456a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f552457b, r101.f552457b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f552458c, r101.f552458c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        RecyclerView.OnScrollListener r100 = this.f552456a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        View.OnLayoutChangeListener r104 = this.f552457b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        ViewTreeObserver.OnGlobalLayoutListener r107 = this.f552458c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "OnItemCompletelyShowCallBackWrapper(onScrollerListener=" + this.f552456a + ", listener=" + this.f552457b + ", globalListener=" + this.f552458c + ')';
    }

    public d6(int r100) {
        this.f552456a = null;
        this.f552457b = null;
        this.f552458c = null;
    }
}
