package q20;

import android.content.Context;
import com.bytedance.android.live.core.utils.f2;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f531331a = 0;

    static {
    }

    public static void a(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "text");
        f2.c("据抖音要求，剪贴板为敏感权限，不允许复制。请使用发送lark替代", 0);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        f2.c("复制失败 " + e.getMessage(), 0);
    }
}
