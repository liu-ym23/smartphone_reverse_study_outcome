package ll8;

import android.content.Context;
import com.larus.bmhome.chat.standarduikit.browsercontrol.view.BrowserControlView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f509707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f509708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BrowserControlView f509709c;

    public final Context getContext() {
        return this.f509707a;
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f509707a = r100;
        this.f509708b = LazyKt.lazy(new a());
    }
}
