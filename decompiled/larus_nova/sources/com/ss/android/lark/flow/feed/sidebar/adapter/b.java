package com.ss.android.lark.flow.feed.sidebar.adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.ui.StableLinearLayoutManager;
import com.ss.android.lark.feed.shared.page.r;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f423502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FeedSidebarAdapter f423503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r f423504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final StableLinearLayoutManager f423505d;

    public static final class a {
    }

    static {
    }

    public final Context getContext() {
        return this.f423502a;
    }

    public b(Context r100, RecyclerView r101, FeedSidebarAdapter r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f423502a = r100;
        this.f423503b = r102;
        this.f423505d = new StableLinearLayoutManager(r100, 0);
    }
}
