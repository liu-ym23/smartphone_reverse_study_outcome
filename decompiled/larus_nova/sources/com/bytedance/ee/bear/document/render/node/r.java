package com.bytedance.ee.bear.document.render.node;

import com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class r implements l {

    public static final class a {
    }

    static {
    }

    public r() {
    }

    @Override // com.bytedance.ee.bear.document.render.node.l
    public final void c(DocumentLoaderV3 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.ee.bear.document.render.node.l
    public final Object b(DocumentLoaderV3 r100, Continuation r101) {
        com.bytedance.ee.bear.document.d r102 = r100.getDocumentMetadata();
        if (Intrinsics.areEqual(r102.getOriginBearUrl().f222560a, sbb.e.f541314y.getType()) == true) goto L6;
        q.f221388a.getClass();
        return new q.c();
    L6:
        o r103 = r100.f221319h;
        String r104 = r102.getBearUrl().f222561b;
        if (r104 != null) goto L9;
        r104 = "";
    L9:
        r103.a("syncBlockSourceToken", r104);
        q.f221388a.getClass();
        return new q.c();
    }
}
