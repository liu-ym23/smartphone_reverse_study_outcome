package lhb;

import android.content.Context;
import com.ss.android.lark.flow.feed.status.FlowBackgroundPageStatusView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements cfb.a {
    public a() {
    }

    @Override // cfb.a
    public final FlowBackgroundPageStatusView create(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new FlowBackgroundPageStatusView(r100, null, 0);
    }
}
