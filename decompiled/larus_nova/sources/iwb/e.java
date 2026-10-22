package iwb;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes37.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f496298a;

    public final int a() {
        return RangesKt.coerceAtLeast(this.f496298a.getWidth() - this.f496298a.getFloatView$officesdk_minutes_base_ui_release().getWidth(), 0);
    }

    public final int b() {
        a r100 = this.f496298a;
        int r101 = r100.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r101 <= 0) goto L5;
        int r102 = r100.getResources().getDimensionPixelSize(r101);
    L7:
        if (this.f496298a.getHeight() > 0) goto L9;
        return r102;
    L9:
        return RangesKt.coerceAtLeast(((int) (this.f496298a.getHeight() * 0.5f)) - r102, r102);
    L5:
        r102 = 0;
        goto L7
    }

    public final int d() {
        int r100 = -this.f496298a.getFloatView$officesdk_minutes_base_ui_release().getWidth();
        a r101 = this.f496298a;
        return (r100 + r101.f496265g) + r101.f496266h;
    }

    public final int e() {
        int r100 = this.f496298a.getWidth();
        a r101 = this.f496298a;
        return (r100 - r101.f496265g) - r101.f496266h;
    }

    public e(a r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        this.f496298a = r100;
    }

    public final int c(int r100) {
        a r101 = this.f496298a;
        int r102 = r101.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r102 <= 0) goto L5;
        int r103 = r101.getResources().getDimensionPixelSize(r102);
    L6:
        int r104 = RangesKt.coerceAtLeast(this.f496298a.getHeight() - this.f496298a.getFloatView$officesdk_minutes_base_ui_release().getHeight(), r103);
        return RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r100, r103), r104);
    L5:
        r103 = 0;
        goto L6
    }
}
