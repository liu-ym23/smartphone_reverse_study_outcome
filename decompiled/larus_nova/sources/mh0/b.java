package mh0;

import android.content.Context;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b extends lh0.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f513822e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.liveinteract.plantform.dynamicframe.c f513823f;

    public b(Context r100, DataCenter r101, com.bytedance.android.live.liveinteract.plantform.dynamicframe.b r102, com.bytedance.android.live.liveinteract.plantform.dynamicframe.c r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "feedDataCenter");
        Intrinsics.checkNotNullParameter(r102, "feedInfoProvider");
        super(r100, r101, r102);
        this.f513823f = r103;
        this.f513822e = "AudioChatStageFeedDynamicHandler";
    }
}
