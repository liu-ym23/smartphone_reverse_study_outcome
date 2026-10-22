package com.bytedance.ee.bear.doc.newresupdate.provider.interceptor;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.doc.resupdate.EChannel;
import com.bytedance.ee.bear.doc.resupdate.d0;
import com.bytedance.ee.bear.doc.resupdate.e0;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFile;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class g extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f217991b;

    @Override // com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a
    public final e0 b() {
        Context r100 = this.f217991b;
        EChannel r101 = EChannel.DOCS_CHANNEL;
        String r102 = d0.e(r100, r101.toString(), false);
        tt5.a.h("AbsResourceInterceptor", "getResource, hotfix version: " + r102);
        VFSFile r103 = d0.j(r101.toString());     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r103);     // Catch: Exception -> L5
        return c(r103, r102, r101.toString());
    L5:
        e = move-exception;
        tt5.a.e("AbsResourceInterceptor", "getResource error", e, false);
        return a();
    }

    @Override // com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a
    public final boolean d() {
        return !TextUtils.isEmpty(d0.e(this.f217991b, EChannel.DOCS_CHANNEL.toString(), false));
    }

    public g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f217991b = r100;
    }
}
