package mh0;

import android.content.Context;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class i extends lh0.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ih0.b f513833e;

    public static final class a {
    }

    static {
    }

    public i(Context r100, DataCenter r101, com.bytedance.android.live.liveinteract.plantform.dynamicframe.b r102, ih0.b r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "feedDataCenter");
        Intrinsics.checkNotNullParameter(r102, "feedInfoProvider");
        Intrinsics.checkNotNullParameter(r103, "service");
        super(r100, r101, r102);
        this.f513833e = r103;
    }
}
