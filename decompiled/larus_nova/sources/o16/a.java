package o16;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f521705a = 0;

    static {
    }

    public static Activity a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    L4:
        if ((r100 instanceof Activity) == true) goto L6;
        if ((r100 instanceof ContextWrapper) == false) goto L10;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L4
    L10:
        return null;
    L6:
        return (Activity) r100;
    }
}
