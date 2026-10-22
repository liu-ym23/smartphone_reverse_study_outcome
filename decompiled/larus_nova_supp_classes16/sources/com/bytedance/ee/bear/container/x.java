package com.bytedance.ee.bear.container;

import android.content.Context;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiException;
import io.reactivex.functions.Consumer;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class x<T> implements Consumer {
    public final /* synthetic */ bk5.a a;
    public final /* synthetic */ kotlinx.coroutines.i<WikiInitNode.b> b;
    public final /* synthetic */ AtomicReference<WikiInfo> c;
    public final /* synthetic */ WikiInitNode d;
    public final /* synthetic */ Ref.ObjectRef<WikiInitNode.b> e;

    public x(bk5.a r1, kotlinx.coroutines.j r2, AtomicReference r3, WikiInitNode r4, Ref.ObjectRef r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void accept(Object r6) {
        up5.b r7 = (up5.b) r6;
        if (r7.b() == true) goto L28;
        WikiInfo r8 = (WikiInfo) r7.a();
        tt5.a.h("MockWikiInitNode", this.a.getTAG() + ", got wikiInfo, fromCache=" + r8.from_cache);
        boolean r0 = false;
        Context r2 = this.a.getActivity();     // Catch: WikiException -> L18
        if (r2 != null) goto L9;
        r2 = eu5.b.a;     // Catch: WikiException -> L18
    L9:
        WikiException.validateObjInfo(r2, r8);     // Catch: WikiException -> L18
        tt5.a.h("MockWikiInitNode", this.a.getTAG() + ", valid wikiInfo, wikiToken=" + du5.b.i(r8.getWikiToken()) + ", objType=" + r8.getObjType() + ", inSpace=" + r8.getInSpace());
        WikiInfo r3 = this.c.get();
        this.d.getClass();
        if (r3 != null) goto L13;
    L15:
        if (r0 == false) goto L17;
        tt5.a.h("MockWikiInitNode", this.a.getTAG() + ", wikiInfo already loaded, skip");
        return;
    L17:
        this.c.set(r8);
        this.e.element = new WikiInitNode.b(r8, r3);
        return;
    L13:
        if (r3.getInSpace() != r8.getInSpace()) goto L15;
        r0 = true;
    L18:
        e = move-exception;
        tt5.a.e("MockWikiInitNode", this.a.getTAG() + ", invalid wikiInfo, code=" + e.getCode(), e, false);
        if (this.b.isActive() == false) goto L27;
        this.b.resumeWith(Result.constructor-impl(null));
        return;
    L27:
        return;
    }
}
