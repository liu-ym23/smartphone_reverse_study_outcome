package com.bytedance.ee.bear.document.render.node;

import android.os.Bundle;
import com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h implements l {

    public static final class a {
    }

    static {
    }

    public h() {
    }

    @Override // com.bytedance.ee.bear.document.render.node.l
    public final void c(DocumentLoaderV3 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    @Override // com.bytedance.ee.bear.document.render.node.l
    public final Object b(DocumentLoaderV3 r3, Continuation r4) {
        Bundle r5 = r3.d.getFragment().getArguments();
        if (r5 == null) goto L9;
        String r6 = r5.getString("offline_create_markdown");
        if (r6 == null) goto L9;
        r3.h.a("markdown", r6);
        tt5.a.h("OfflineCreateNode", "markdown size: " + r6.length());
        r3.S3(new i(r3));
        q.a.getClass();
        return new q.c();
    L9:
        q.a.getClass();
        return new q.c();
    }
}
