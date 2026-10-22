package j4c;

import android.content.Context;
import android.view.ViewGroup;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f497421a;

    public k(Context r100, ViewGroup r101) {
        y r102 = new y();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "parent");
        Intrinsics.checkNotNullParameter(r102, "viewDelegate");
        r101.setPadding(0, 0, a0.a(16.0f, r100), 0);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "parent");
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "parent");
        r102.f497431a.a(r100, r101);
        this.f497421a = r101;
    }
}
