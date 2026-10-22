package ul8;

import android.content.Context;
import com.larus.bmhome.chat.standarduikit.localfileblock.viewmodel.h;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f550613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f550614b;

    public b(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f550613a = LazyKt.lazy(new a(r100));
        this.f550614b = new h();
    }
}
