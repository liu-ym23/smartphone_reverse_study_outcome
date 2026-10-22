package w29;

import com.baidu.platform.comapi.map.MapController;
import com.larus.bmhome.actionbar.model.z0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f558045a = 0;

    static {
    }

    public static int a(z0 r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Map<String, String> r101 = r100.H;
        if (r101 == null) goto L10;
        String r102 = r101.get("context_window_total_percent_tenths");
        if (r102 == null) goto L11;
        Integer r103 = StringsKt.toIntOrNull(r102);
        if (r103 != null) goto L9;
        return 0;
    L9:
        return RangesKt.coerceIn(r103.intValue(), 0, 1000);
    L11:
        return 0;
    L10:
        return 0;
    }
}
