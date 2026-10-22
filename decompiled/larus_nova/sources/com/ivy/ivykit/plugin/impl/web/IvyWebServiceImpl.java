package com.ivy.ivykit.plugin.impl.web;

import android.content.Context;
import android.graphics.Bitmap;
import com.ivy.ivykit.api.plugin.IIvyWebService;
import com.ss.android.lark.utils.statistics.PerfLog;
import ix7.g;
import ix7.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ivy/ivykit/plugin/impl/web/IvyWebServiceImpl;", "Lcom/ivy/ivykit/api/plugin/IIvyWebService;", "<init>", "()V", "ivy_plugin_impl_bullet_release"}, k = 1, mv = {1, 7, 1})
public final class IvyWebServiceImpl implements IIvyWebService {
    @Override // com.ivy.ivykit.api.plugin.IIvyWebService
    public final void c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    public IvyWebServiceImpl() {
    }

    @Override // com.ivy.ivykit.api.plugin.IIvyWebService
    public final kx7.c b(String r100, lx7.a r101, Context r102) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, "webViewClient");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((r101 instanceof f) == true) goto L6;
        r101 = null;
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        return new PluginWebView(r100, (f) r101, r102);
    }

    @Override // com.ivy.ivykit.api.plugin.IIvyWebService
    public final lx7.a a(String r110, String r111, ix7.e r112, ix7.d r113, ix7.f r114, h r115, g r116, Bitmap r117) {
        Intrinsics.checkNotNullParameter(r110, "bizId");
        Intrinsics.checkNotNullParameter(r111, "schema");
        return new f(r110, r111, r112, r113, r114, r115, r116, r117);
    }
}
