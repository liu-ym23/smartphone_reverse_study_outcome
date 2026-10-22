package com.bytedance.ee.bear.document.render.preload;

import com.bytedance.ee.bear.document.render.node.f;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements i<BridgeReadyModel> {
    public final /* synthetic */ WebViewLoadStateWebService a;

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public c(WebViewLoadStateWebService r1) {
        this.a = r1;
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r5, m r6) {
        BridgeReadyModel r7 = (BridgeReadyModel) r5;
        tt5.a.h(this.a.a, "==openDocs==preload== notifyJsReady... data is " + r7);
        if (r7 == null) goto L24;
        WebViewLoadStateWebService r8 = this.a;
        r8.c.remove(r7.getType());
        d25.d.m(r7.getData(), r7.getType());
        String r9 = r7.getType();
        Intrinsics.checkNotNull(r9);
        if (r9.length() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L30;
        ((f) r8.h.getValue()).j(r9, r8.g);
        Intrinsics.checkNotNullParameter(r9, "type");
        if (r8.e.add(r9) == false) goto L12;
        tt5.a.h(r8.a, "==openDocs==preload== Type '" + r9 + "' is ready");
    L12:
        String r1 = r8.a;
        StringBuilder r2 = new StringBuilder("==openDocs==preload== continuations.size = ");
        List r3 = (List) ((LinkedHashMap) r8.f).get(r9);
        if (r3 == null) goto L15;
        Integer r4 = Integer.valueOf(r3.size());
    L16:
        r2.append(r4);
        tt5.a.h(r1, r2.toString());
        List<kotlinx.coroutines.i<Unit>> r10 = r8.f.remove(r9);
        if (r10 == null) goto L31;
        Iterator<T> r11 = r10.iterator();
    L20:
        if (r11.hasNext() == false) goto L32;
        kotlinx.coroutines.i r12 = (kotlinx.coroutines.i) r11.next();
        tt5.a.h(r8.a, "==openDocs==render== notifyJsReady, continuation = " + r12.hashCode() + ", isActive = " + r12.isActive());
        if (r12.isActive() == false) goto L20;
        Result.Companion r13 = Result.Companion;
        r12.resumeWith(Result.constructor-impl(Unit.INSTANCE));
        goto L20
    L32:
        return;
    L31:
        return;
    L15:
        r4 = null;
        goto L16
    L30:
        return;
    L7:
        r0 = false;
        goto L8
    }
}
