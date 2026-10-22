package j19;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.GenericDraweeView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class c {
    public static final GenericDraweeView b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof GenericDraweeView) == false) goto L7;
        return (GenericDraweeView) r100;
    L7:
        if ((r100 instanceof ViewGroup) == false) goto L15;
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r101.getChildCount();
    L9:
        r102 = r102 - 1;
        if ((-1) >= r102) goto L15;
        GenericDraweeView r103 = b(r101.getChildAt(r102));
        if (r103 == null) goto L9;
        return r103;
    L15:
        return null;
    }

    public static final int c(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        float r101 = r100.floatValue();
        Resources r102 = Resources.getSystem();
        return (int) TypedValue.applyDimension(1, r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
    }

    public static final void d(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setVisibility(8);
    }

    public static final void f(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setVisibility(0);
    }

    public static final void e(l19.i r100, l19.a r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "transitionParams");
        r100.setDragTransitionEnabled(r101.isDragTransitionEnabled());
        r100.setMaxDragTransitionFactor(r101.getMaxDragTransitionFactor());
        r100.setTransitionAnimationDuration(r101.getTransitionAnimationDuration());
        r100.setSingleTagDismissEnabled(r101.isSingleTagDismissEnabled());
        r100.setEnterTransitionStartRect(r101.getEnterTransitionStartRect());
        r100.setRestoreTransitionProvider(r101.getRestoreTransitionProvider());
        r100.setDismissAnimationType(r101.getDismissAnimationType());
        r100.setPos(r101.getPos());
    }

    public static View a(RecyclerView r100, OrientationHelper r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        View r103 = null;
        if (r101 == null) goto L23;
        RecyclerView.LayoutManager r104 = r100.getLayoutManager();
        if (r104 == null) goto L23;
        int r105 = r104.getChildCount();
        if (r105 == 0) goto L23;
        if (r104.getClipToPadding() == false) goto L13;
        int r106 = r101.getStartAfterPadding() + (r101.getTotalSpace() / 2);
    L14:
        int r107 = Integer.MAX_VALUE;
        int r108 = 0;
    L15:
        if (r108 >= r105) goto L23;
        View r109 = r104.getChildAt(r108);
        if (r109 == null) goto L19;
        r104.getPosition(r109);
    L19:
        int r110 = Math.abs((r101.getDecoratedStart(r109) + (r101.getDecoratedMeasurement(r109) / 2)) - r106);
        if (r110 >= r107) goto L22;
        r103 = r109;
        r107 = r110;
    L22:
        r108 = r108 + 1;
        goto L15
    L13:
        r106 = r101.getEnd() / 2;
    L23:
        return r103;
    }
}
