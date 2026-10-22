package com.bytedance.gamecenter.base.order;

import android.content.Context;
import com.bytedance.gamecenter.base.r;
import com.bytedance.gamecenter.base.w;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f245041a;

    public static Context a() {
        if (w.e() == true) goto L5;
    L8:
        boolean r100 = r.f245056a;
        Intrinsics.checkNotNullParameter("GameCP_ContextOpt", "tag");
        return GlobalInfo.getContext();
    L5:
        if (f245041a == null) goto L8;
        boolean r101 = r.f245056a;
        Intrinsics.checkNotNullParameter("GameCP_ContextOpt", "tag");
        Context r102 = f245041a;
        Intrinsics.checkNotNull(r102);
        return r102;
    }

    static {
    }
}
