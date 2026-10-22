package h43;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import nj.d;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f483774a = 0;

    public static d b() {
        return com.bytedance.android.ec.sdk.helper.d.f48119b.getPadSplitService();
    }

    static {
    }

    public static boolean a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        d r101 = b();
        if (r101 == null) goto L7;
        r101.l();
        return false;
    L7:
        return false;
    }
}
