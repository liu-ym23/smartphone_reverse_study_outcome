package mh0;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class h extends lh0.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedHashMap<String, com.bytedance.android.live.liveinteract.plantform.dynamicframe.o> f513830e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewGroup f513831f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ih0.b f513832g;

    @Override // lh0.a
    public final void d() {
        super.d();
        Iterator<com.bytedance.android.live.liveinteract.plantform.dynamicframe.o> r100 = this.f513830e.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().a("root_widget_destory");
        goto L4
    L6:
        this.f513830e.clear();
    }

    public h(Context r100, DataCenter r101, com.bytedance.android.live.liveinteract.plantform.dynamicframe.b r102, ViewGroup r103, ih0.b r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "feedDataCenter");
        Intrinsics.checkNotNullParameter(r102, "feedInfoProvider");
        Intrinsics.checkNotNullParameter(r103, "mLinkRootView");
        Intrinsics.checkNotNullParameter(r104, "service");
        super(r100, r101, r102);
        this.f513831f = r103;
        this.f513832g = r104;
        this.f513830e = new LinkedHashMap();
    }
}
