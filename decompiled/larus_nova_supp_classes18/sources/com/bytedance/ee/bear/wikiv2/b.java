package com.bytedance.ee.bear.wikiv2;

import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$DataSource;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiException;
import io.reactivex.functions.Consumer;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ WikiFragment a;
    public final /* synthetic */ BearUrl b;
    public final /* synthetic */ ce5.a c;

    public b(WikiFragment r1, BearUrl r2, ce5.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r9) {
        up5.b r10 = (up5.b) r9;
        if (r10.b() == true) goto L63;
        final WikiInfo r11 = (WikiInfo) r10.a();
        if (r11.from_cache == false) goto L7;
        String r0 = "cache";
    L8:
        tt5.a.h("WikiFragment", "Got wikiInfo. From: ".concat(r0));
        WikiException.validateObjInfo(this.a.getContext(), r11);     // Catch: WikiException -> L60
        tt5.a.h("WikiFragment", "Valid wikiInfo. wikiToken: " + du5.b.i(r11.getWikiToken()) + ", objType: " + r11.getObjType() + ", inSpace: " + r11.getInSpace());
        WikiInfo r1 = this.a.k.get();
        boolean r2 = true;
        if (r1 != null) goto L13;
    L15:
        boolean r3 = false;
    L16:
        if (r3 == false) goto L18;
        tt5.a.h("WikiFragment", "Already loaded, return. ");
        return;
    L18:
        Object r4 = null;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L21
        Object r6 = Result.constructor-impl((bn4.a) org.koin.java.a.c(bn4.a.class, null, null, 6));     // Catch: Throwable -> L21
    L24:
        if (Result.isFailure-impl(r6) == false) goto L26;
        r6 = null;
    L26:
        bn4.a r7 = (bn4.a) r6;
        if (r7 != null) goto L29;
    L31:
        r2 = false;
    L32:
        tt5.a.h("WikiFragment", "load: wiki app mode native enabled=" + r2);
        if (r2 == false) goto L56;
        final WikiFragment r8 = this.a;
        BearUrl r12 = this.b;
        final ce5.a r13 = this.c;
        Function1<BearUrl, Unit> r14 = new WikiFragment$load$1$1(r8, r11, r13);
        r8.getClass();
        if (r11.getInSpace() == true) goto L38;
        tt5.a.h("WikiFragment", "resolveLoadUrl: not in space, use origin url");
        r14.invoke(r12);
        return;
    L38:
        if (r11.getObjType() == 8) goto L68;
        tt5.a.h("WikiFragment", "resolveLoadUrl: in space, non-bitable type=" + r11.getObjType());
        r14.invoke(WikiFragment.X90(r12, r11));
        return;
    L68:
        Object r15 = Result.constructor-impl((bn4.a) org.koin.java.a.c(bn4.a.class, null, null, 6));     // Catch: Throwable -> L42
    L45:
        if (Result.isFailure-impl(r15) == true) goto L48;
        r4 = r15;
    L48:
        bn4.a r16 = (bn4.a) r4;
        if (r16 != null) goto L51;
        tt5.a.h("WikiFragment", "resolveLoadUrl: bitable service unavailable, fallback to genObjUrl");
        r14.invoke(WikiFragment.X90(r12, r11));
        return;
    L51:
        Boolean r17 = r16.d(r11.getObjToken());
        if (r17 == null) goto L54;
        tt5.a.h("WikiFragment", "resolveLoadUrl: bitable cache hit, isApp=" + r17);
        r14.invoke(WikiFragment.X90(r12, r11));
        return;
    L54:
        tt5.a.h("WikiFragment", "resolveLoadUrl: bitable cache miss, async check start");
        r16.o(r11.getObjToken(), new g(r8, r11, r14, r12));
        return;
    L42:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L45
    L56:
        if (r11.getInSpace() == false) goto L58;
        WikiFragment r19 = this.a;
        BearUrl r20 = this.b;
        r19.getClass();
        BearUrl r21 = WikiFragment.X90(r20, r11);
    L59:
        WikiFragment.V90(this.a, r21, r11, this.c);
        return;
    L58:
        r21 = this.b;
        goto L59
    L29:
        if (r7.m() != true) goto L31;
    L21:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L13:
        if (r1.getInSpace() != r11.getInSpace()) goto L15;
        r3 = true;
    L60:
        e = move-exception;
        tt5.a.d("WikiFragment", "Invalid wikiInfo, dispatchLoadFail. code=" + e.getCode());
        throw e;
    L7:
        r0 = DocFeed$Value$DataSource.NETWORK;
        goto L8
    }
}
