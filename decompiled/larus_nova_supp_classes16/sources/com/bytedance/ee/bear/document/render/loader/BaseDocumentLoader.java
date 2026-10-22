package com.bytedance.ee.bear.document.render.loader;

import com.bytedance.ee.bear.document.x2;
import iu5.d;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class BaseDocumentLoader implements x2 {
    public final String a;
    public final Set<x2.b> b;

    public final void k() {
        DocumentLoaderV3 r0 = (DocumentLoaderV3) this;
        a.h(r0.f, "dispatchSSRLoadSuccess count=" + this.b.size() + ", callbacks=" + h());
        Iterator r1 = CollectionsKt.toMutableList(this.b).iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        x2.b r2 = (x2.b) r1.next();
        a.h(r0.f, "dispatchSSRLoadSuccess callback=" + g(r2));
        r2.onSSRLoadSuccess();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        a.e(r0.f, "dispatchSSRLoadSuccess failed, e = " + e, e, false);
        d.a(r0.f, e);
        goto L4
    }

    public final String h() {
        return CollectionsKt.joinToString$default(this.b, null, null, null, 0, null, new BaseDocumentLoader$debugCallbackSummary$1(this), 31, null);
    }

    public BaseDocumentLoader() {
        this.a = "BaseDocumentLoader";
        this.b = new LinkedHashSet();
    }

    public final void i() {
        a.h(l(), "dispatchLoadStart count=" + this.b.size() + ", callbacks=" + h());
        Iterator r0 = CollectionsKt.toMutableList(this.b).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        x2.b r1 = (x2.b) r0.next();
        a.h(l(), "dispatchLoadStart callback=" + g(r1));
        r1.onLoadStart();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        a.e(l(), "dispatchLoadStart failed, e = " + e, e, false);
        d.a(l(), e);
        goto L4
    }

    public final void j() {
        a.h(l(), "dispatchLoadSuccess count=" + this.b.size() + ", callbacks=" + h());
        Iterator r0 = CollectionsKt.toMutableList(this.b).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        x2.b r1 = (x2.b) r0.next();
        a.h(l(), "dispatchLoadSuccess callback=" + g(r1));
        r1.onLoadSuccess();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        a.e(l(), "dispatchLoadSuccess failed, e = " + e, e, false);
        d.a(l(), e);
        goto L4
    }

    public String l() {
        return this.a;
    }

    public static String g(x2.b r2) {
        return r2.getClass().getName() + '@' + System.identityHashCode(r2);
    }

    @Override // com.bytedance.ee.bear.document.x2
    public final void S(x2.b r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.b.remove(r4);
        a.h(l(), "removeLoadingCallback callback=" + g(r4) + ", count=" + this.b.size() + ", callbacks=" + h());
    }

    @Override // com.bytedance.ee.bear.document.x2
    public final void S3(x2.b r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.b.add(r4);
        a.h(l(), "addLoadingCallback callback=" + g(r4) + ", count=" + this.b.size() + ", callbacks=" + h());
    }
}
