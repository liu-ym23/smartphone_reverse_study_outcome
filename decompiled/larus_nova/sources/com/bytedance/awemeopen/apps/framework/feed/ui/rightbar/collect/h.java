package com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.collect;

import android.content.Context;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f196697a = 0;

    static {
    }

    public static void a(Context r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        switch(r101) {
            case 100: goto L8;
            case 101: goto L7;
            case 102: goto L6;
            case 103: goto L5;
            default: goto L16;
        };
    L5:
        zx3.a.b(r100, R.string.aos_production_friend).d();
        return;
    L6:
        zx3.a.b(r100, R.string.aos_production_private).d();
        return;
    L7:
        zx3.a.b(r100, R.string.aos_network_unavailable).d();
        return;
    L8:
        if (r102 == false) goto L10;
        zx3.a.b(r100, R.string.aos_cancel_collect_failed).d();
        return;
    L10:
        zx3.a.b(r100, R.string.aos_collect_failed).d();
        return;
    }
}
