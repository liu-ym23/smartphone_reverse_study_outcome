package r6c;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f536390a;

    public final Context getContext() {
        return this.f536390a;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f536390a = r100;
    }
}
