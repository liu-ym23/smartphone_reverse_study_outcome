package y2c;

import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import s5c.d;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f565726a = 0;

    static {
    }

    @JvmStatic
    public static final void a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "extras");
        Statistics.sendEvent("im_thread_detail_click", r100.toJson());
    }
}
