package v08;

import android.view.ViewGroup;
import com.larksuite.component.universe_design.button.UDButton;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes24.dex */
public final class a {
    public static final void a(UDButton r100, UDButton r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "refView");
        if (r100.getLayoutParams().width >= r101.getWidth()) goto L6;
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        r102.width = RangesKt.coerceAtLeast(r100.getWidth(), r101.getWidth());
        r100.requestLayout();
        return;
    }
}
