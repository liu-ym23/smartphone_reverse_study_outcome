package u69;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.lisitem.OCardListItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b {
    public static final void a(OCardListItem r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        FrameLayout r102 = r100.getCardContainer();
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if ((r103 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r103;
    L6:
        if (r104 != null) goto L8;
    L12:
        if (r101 == null) goto L15;
        r101.intValue();
        Resources r105 = r100.getResources();
        int r106 = (int) ((WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()).density * r101.intValue()) + 0.5f);
        LinearLayout r107 = r100.getTitleContainer();
        r107.setPaddingRelative(r106, r107.getPaddingTop(), r106, r107.getPaddingBottom());
        return;
    L15:
        return;
    L8:
        if (r104.getMarginStart() == 0) goto L10;
    L11:
        r104.setMarginStart(0);
        r104.setMarginEnd(0);
        r102.setLayoutParams(r104);
        goto L12
    L10:
        if (r104.getMarginEnd() == 0) goto L12;
    L5:
        r104 = null;
        goto L6
    }
}
