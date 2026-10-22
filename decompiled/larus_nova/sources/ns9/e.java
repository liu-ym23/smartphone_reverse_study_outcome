package ns9;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.larus.reach.api.ReachClickTarget;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReachClickTarget f520368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f520369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<b> f520370c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f520368a == r101.f520368a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f520369b, r101.f520369b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f520370c, r101.f520370c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f520368a.hashCode() * 31;
        d r101 = this.f520369b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f520370c.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ReachClickEvent(target=" + this.f520368a + ", button=" + this.f520369b + ", actions=" + this.f520370c + ')';
    }

    public e(ReachClickTarget r100, d r101, List<b> r102) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r102, SlcCommonAction.KEY_ACTIONS);
        this.f520368a = r100;
        this.f520369b = r101;
        this.f520370c = r102;
    }

    public /* synthetic */ e(ReachClickTarget r100, d r101, List r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = CollectionsKt.emptyList();
    L8:
        this(r100, r101, r102);
    }
}
