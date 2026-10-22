package il1;

import android.content.Context;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f490297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f490298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DataCenter f490299c;

    public b(Context r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "mDataCenter");
        this.f490299c = r101;
        this.f490297a = new e(r100);
        this.f490298b = new c(r100);
    }
}
