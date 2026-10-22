package qf3;

import android.content.Context;
import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f532722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECMallFeed f532723b;

    public d(Context r100, ECMallFeed r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "mallFeed");
        this.f532722a = r100;
        this.f532723b = r101;
    }
}
