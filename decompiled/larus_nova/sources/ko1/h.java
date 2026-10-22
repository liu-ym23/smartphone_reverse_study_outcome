package ko1;

import android.content.Context;
import android.view.GestureDetector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class h extends GestureDetector {
    public h(Context r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "scrollGestureListener");
        super(r100, r101);
        new GestureDetector(r100, r101);
    }
}
