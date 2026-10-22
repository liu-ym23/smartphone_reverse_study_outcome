package em4;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {
    public static final Activity getActivity(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    L4:
        if ((r100 instanceof ContextWrapper) == false) goto L10;
        if ((r100 instanceof Activity) == true) goto L8;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L4
    L8:
        return (Activity) r100;
    L10:
        return null;
    }
}
