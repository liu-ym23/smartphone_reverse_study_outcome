package com.bytedance.ee.bear.document.render.node;

import androidx.fragment.app.Fragment;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.document.doccomponent.config.DocComponentConfig;
import com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3;
import com.bytedance.ee.bear.domain.BearUrl;
import java.lang.ref.WeakReference;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements l {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // com.bytedance.ee.bear.document.render.node.l
    public final void c(DocumentLoaderV3 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    @Override // com.bytedance.ee.bear.document.render.node.l
    public final Object b(DocumentLoaderV3 r6, Continuation r7) {
        BearUrl r1 = r6.getDocumentMetadata().getBearUrl();     // Catch: Throwable -> L26 CancellationException -> L32
        o r2 = r6.h;     // Catch: Throwable -> L26 CancellationException -> L32
        Fragment r3 = r6.d.getFragment();     // Catch: Throwable -> L26 CancellationException -> L32
        String r4 = r1.r;     // Catch: Throwable -> L23 CancellationException -> L28
        if (r4 != null) goto L7;
    L10:
        boolean r5 = true;
    L11:
        if (r5 == true) goto L13;
        String r8 = r1.r;     // Catch: Throwable -> L23 CancellationException -> L28
    L14:
        JSONObject r9 = DocComponentConfig.getSceneConfig(r8);     // Catch: Throwable -> L23 CancellationException -> L28
        if (r3 == null) goto L17;
        JSONObject r10 = DocComponentConfig.getPatchSettingConfig(new WeakReference(r3));     // Catch: Throwable -> L23 CancellationException -> L28
    L18:
        if (r9 == null) goto L20;
        r2.a(DocComponentConfig.KEY_INJECT_WEB, r9);     // Catch: Throwable -> L23 CancellationException -> L28
    L20:
        if (r10 == null) goto L25;
        r2.a(DocComponentConfig.KEY_INJECT_WEB_PATCH, r10);     // Catch: Throwable -> L23 CancellationException -> L28
    L25:
        tt5.a.h("DocComponentRenderNode", r6.i + "inject DocComponent config");     // Catch: Throwable -> L26 CancellationException -> L32
        q.a.getClass();     // Catch: Throwable -> L26 CancellationException -> L32
        return new q.c();
    L17:
        r10 = null;
        goto L18
    L13:
        r8 = r1.q;     // Catch: Throwable -> L23 CancellationException -> L28
        goto L14
    L7:
        if (r4.length() == 0) goto L10;
        r5 = false;
    L28:
        e = move-exception;
        throw e;     // Catch: Throwable -> L26 CancellationException -> L32
    L23:
        th = move-exception;
        tt5.a.f("DocComponentConfigInjector", th, false);     // Catch: Throwable -> L26 CancellationException -> L32
    L32:
        e = move-exception;
        throw e;
    L26:
        th = move-exception;
        tt5.a.f("DocComponentRenderNode", th, false);
        q.a.getClass();
        return new q.c();
    }
}
