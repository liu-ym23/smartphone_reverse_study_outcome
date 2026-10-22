package uq1;

import android.content.Context;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b extends h70.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f551200d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DataCenter f551201e;

    public b(Context r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f551201e = r101;
        this.f551200d = a.O;
    }
}
