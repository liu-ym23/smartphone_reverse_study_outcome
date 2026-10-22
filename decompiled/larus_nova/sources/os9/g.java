package os9;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.common_ui.venus.ShapeLinearLayout;
import com.larus.nova.R;
import com.larus.reach.api.ReachButtonStyle;
import com.larus.reach.api.ReachButtonType;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<a> f526560a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f526561a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f526562b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f526561a == r101.f526561a) goto L12;
            return false;
        L12:
            if (this.f526562b == r101.f526562b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f526561a * 31) + this.f526562b;
        }

        public final String toString() {
            return "ActionSlot(containerId=" + this.f526561a + ", textId=" + this.f526562b + ')';
        }

        public a(int r100, int r101) {
            this.f526561a = r100;
            this.f526562b = r101;
        }
    }

    public static final class b {
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f526563a = null;

        static {
            int[] r100 = new int[ReachButtonType.values().length];
            r100[ReachButtonType.NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ReachButtonType.CLOSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f526563a = r100;
        }
    }

    public g() {
    }

    static {
        f526560a = CollectionsKt.listOf(new a[]{new a(R.id.reach_banner_secondary_button, R.id.reach_banner_secondary_button_text), new a(R.id.reach_banner_primary_button, R.id.reach_banner_primary_button_text)});
    }

    public static int b(int r100, View r101) {
        Resources r102 = r101.getResources();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f);
    }

    public static void a(ShapeLinearLayout r100, TextView r101, ReachButtonStyle r102) {
        if (r102 != ReachButtonStyle.PRIMARY) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        int r104 = ContextCompat.getColor(r100.getContext(), v19.c.b(R.attr.larus_primary_transparent_1, r100.getContext(), R.color.larus_primary_transparent_1));
    L9:
        Context r105 = r100.getContext();
        if (r103 == false) goto L12;
        int r106 = R.attr.larus_primary_50;
    L13:
        Context r107 = r100.getContext();
        if (r103 == false) goto L16;
        int r108 = R.color.larus_primary_50;
    L17:
        int r109 = ContextCompat.getColor(r105, v19.c.b(r106, r107, r108));
        int r110 = ShapeLinearLayout.M;
        if (r104 == 0) goto L20;
        r100.f327901b = r104;
    L20:
        r100.requestLayout();
        if (r101 == null) goto L24;
        r101.setTextColor(r109);
        return;
    L24:
        return;
    L16:
        r108 = R.color.larus_neutral_100;
        goto L17
    L12:
        r106 = R.attr.larus_neutral_100;
        goto L13
    L8:
        r104 = ContextCompat.getColor(r100.getContext(), R.color.larus_reach_plain_button_background);
        goto L9
    L5:
        r103 = false;
        goto L6
    }
}
