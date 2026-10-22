package wp9;

import android.view.View;
import androidx.core.view.ViewCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f560630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f560631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f560632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f560633d;

    public final void a() {
        View r100 = this.f560630a;
        ViewCompat.offsetTopAndBottom(r100, this.f560633d - (r100.getTop() - this.f560631b));
        View r101 = this.f560630a;
        ViewCompat.offsetLeftAndRight(r101, 0 - (r101.getLeft() - this.f560632c));
    }

    public h(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f560630a = r100;
    }
}
