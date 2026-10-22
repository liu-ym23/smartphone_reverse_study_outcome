package mh0;

import android.content.Context;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class j extends lh0.a {

    public static final class a {
    }

    static {
    }

    public j(Context r100, DataCenter r101, com.bytedance.android.live.liveinteract.plantform.dynamicframe.b r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "feedDataCenter");
        Intrinsics.checkNotNullParameter(r102, "feedInfoProvider");
        super(r100, r101, r102);
    }
}
