package com.bytedance.ee.bear.document.render.loader;

import com.bytedance.ee.bear.document.x2;
import iu5.d;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tt5.a;

/* JADX INFO: loaded from: classes16.dex */
public abstract class BaseDocumentLoader implements x2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f221312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<x2.b> f221313b;

    public final void k() {
        DocumentLoaderV3 r100 = (DocumentLoaderV3) this;
        a.h(r100.f221317f, "dispatchSSRLoadSuccess count=" + this.f221313b.size() + ", callbacks=" + h());
        Iterator r101 = CollectionsKt.toMutableList(this.f221313b).iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        x2.b r102 = (x2.b) r101.next();
        a.h(r100.f221317f, "dispatchSSRLoadSuccess callback=" + g(r102));
        r102.onSSRLoadSuccess();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        a.e(r100.f221317f, "dispatchSSRLoadSuccess failed, e = " + e, e, false);
        d.a(r100.f221317f, e);
        goto L4
    }

    public final String h() {
        return CollectionsKt.joinToString$default(this.f221313b, null, null, null, 0, null, new BaseDocumentLoader$debugCallbackSummary$1(this), 31, null);
    }

    public BaseDocumentLoader() {
        this.f221312a = "BaseDocumentLoader";
        this.f221313b = new LinkedHashSet();
    }

    public final void i() {
        a.h(l(), "dispatchLoadStart count=" + this.f221313b.size() + ", callbacks=" + h());
        Iterator r100 = CollectionsKt.toMutableList(this.f221313b).iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        x2.b r101 = (x2.b) r100.next();
        a.h(l(), "dispatchLoadStart callback=" + g(r101));
        r101.onLoadStart();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        a.e(l(), "dispatchLoadStart failed, e = " + e, e, false);
        d.a(l(), e);
        goto L4
    }

    public final void j() {
        a.h(l(), "dispatchLoadSuccess count=" + this.f221313b.size() + ", callbacks=" + h());
        Iterator r100 = CollectionsKt.toMutableList(this.f221313b).iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        x2.b r101 = (x2.b) r100.next();
        a.h(l(), "dispatchLoadSuccess callback=" + g(r101));
        r101.onLoadSuccess();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        a.e(l(), "dispatchLoadSuccess failed, e = " + e, e, false);
        d.a(l(), e);
        goto L4
    }

    public String l() {
        return this.f221312a;
    }

    public static String g(x2.b r100) {
        return r100.getClass().getName() + '@' + System.identityHashCode(r100);
    }

    @Override // com.bytedance.ee.bear.document.x2
    public final void S(x2.b r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f221313b.remove(r100);
        a.h(l(), "removeLoadingCallback callback=" + g(r100) + ", count=" + this.f221313b.size() + ", callbacks=" + h());
    }

    @Override // com.bytedance.ee.bear.document.x2
    public final void S3(x2.b r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f221313b.add(r100);
        a.h(l(), "addLoadingCallback callback=" + g(r100) + ", count=" + this.f221313b.size() + ", callbacks=" + h());
    }
}
