package dc9;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Iterator;
import java.util.List;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes29.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f467893a = 0;

    static {
    }

    public static int a() {
        Resources r100 = AppHost.f326268a.getApplication().getResources();
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).widthPixels;
    }

    public static int b(ViewGroup r100) {
        if (r100 == null) goto L4;
        int r101 = r100.getWidth();
    L5:
        int r102 = RangesKt.coerceAtLeast((r101 - ((int) (((double) a()) * 0.75d))) / 2, 0);
        FLogger.f375446a.i("PadAdapter", "msgContainerScreenSpaceInPad, space:" + r102);
        return r102;
    L4:
        r101 = a();
        goto L5
    }

    public static void c(ViewGroup r100, final List r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r102 = b(r100);
        Iterator r103 = SequencesKt.filter(ViewGroupKt.getChildren(r100), new b(r101)).iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        View r104 = (View) r103.next();
        r104.setPadding(r102, r104.getPaddingTop(), r102, r104.getPaddingBottom());
        goto L6
    }
}
