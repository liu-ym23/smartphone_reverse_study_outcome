package com.bytedance.ee.bear.doc.newresupdate.provider.interceptor;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.doc.resupdate.EChannel;
import com.bytedance.ee.bear.doc.resupdate.d0;
import com.bytedance.ee.bear.doc.resupdate.e0;
import com.ss.android.lark.vfs.VFSFile;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g extends a {
    public final Context b;

    @Override // com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a
    public final e0 b() {
        Context r0 = this.b;
        EChannel r1 = EChannel.DOCS_CHANNEL;
        String r2 = d0.e(r0, r1.toString(), false);
        tt5.a.h("AbsResourceInterceptor", "getResource, hotfix version: " + r2);
        VFSFile r3 = d0.j(r1.toString());     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r3);     // Catch: Exception -> L5
        return c(r3, r2, r1.toString());
    L5:
        e = move-exception;
        tt5.a.e("AbsResourceInterceptor", "getResource error", e, false);
        return a();
    }

    @Override // com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a
    public final boolean d() {
        return !TextUtils.isEmpty(d0.e(this.b, EChannel.DOCS_CHANNEL.toString(), false));
    }

    public g(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.b = r2;
    }
}
