package hy1;

import android.content.Context;
import com.bytedance.android.livesdk.gift.platform.business.h;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements h.a {
    public a() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.h.a
    public final h a(DataCenter r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new gy1.a(r100, r101);
    }
}
