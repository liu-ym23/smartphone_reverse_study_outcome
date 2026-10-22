package com.bytedance.locallife.adapter.impl.router;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.locallife.adapter.impl.page.poi.LifePoiActivity;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class a extends fo6.a {
    @Override // fo6.d
    public final boolean a(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return false;
    }

    public a(xu6.d r100) {
        super(r100);
    }

    @Override // fo6.a, fo6.d
    public final void b(Context r100, Uri r101, Intent r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        Intrinsics.checkNotNullParameter(r102, "intent");
        super.b(r100, r101, r102);
        com.bytedance.locallife.biz.common.utils.c.b("TAGGG", "DitoVirtualRefreshInterceptor open(" + r101 + ')');
        r100.startActivity(new Intent(r100, LifePoiActivity.class));
    }
}
