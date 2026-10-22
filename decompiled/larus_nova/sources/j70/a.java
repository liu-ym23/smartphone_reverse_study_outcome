package j70;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import h70.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public abstract class a<T extends h70.b> extends h<T> implements b {
    @Override // j70.b
    public final void n(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    public a() {
    }
}
