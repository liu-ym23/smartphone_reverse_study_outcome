package ppc;

import android.app.Activity;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f530251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f530252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f530253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ForwardV3ViewModel f530254d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f530251a, r101.f530251a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f530252b, r101.f530252b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f530253c, r101.f530253c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f530254d, r101.f530254d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f530251a.hashCode() * 31) + this.f530252b.hashCode()) * 31) + this.f530253c.hashCode()) * 31) + this.f530254d.hashCode();
    }

    public final String toString() {
        return "DoubaoForwardPreviewContext(activity=" + this.f530251a + ", fragment=" + this.f530252b + ", parent=" + this.f530253c + ", viewModel=" + this.f530254d + ')';
    }

    public final Activity getActivity() {
        return this.f530251a;
    }

    public g(FragmentActivity r100, Fragment r101, FrameLayout r102, ForwardV3ViewModel r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "viewModel");
        this.f530251a = r100;
        this.f530252b = r101;
        this.f530253c = r102;
        this.f530254d = r103;
    }
}
