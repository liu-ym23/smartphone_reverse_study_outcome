package com.bytedance.ee.bear.document.render.node;

import com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class r implements l {

    public static final class a {
    }

    static {
    }

    public r() {
    }

    @Override // com.bytedance.ee.bear.document.render.node.l
    public final void c(DocumentLoaderV3 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    @Override // com.bytedance.ee.bear.document.render.node.l
    public final Object b(DocumentLoaderV3 r3, Continuation r4) {
        com.bytedance.ee.bear.document.d r5 = r3.getDocumentMetadata();
        if (Intrinsics.areEqual(r5.getOriginBearUrl().a, sbb.e.y.getType()) == true) goto L6;
        q.a.getClass();
        return new q.c();
    L6:
        o r6 = r3.h;
        String r7 = r5.getBearUrl().b;
        if (r7 != null) goto L9;
        r7 = "";
    L9:
        r6.a("syncBlockSourceToken", r7);
        q.a.getClass();
        return new q.c();
    }
}
