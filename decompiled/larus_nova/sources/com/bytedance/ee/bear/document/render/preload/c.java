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

/* JADX INFO: loaded from: classes16.dex */
public final class c implements i<BridgeReadyModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebViewLoadStateWebService f221408a;

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public c(WebViewLoadStateWebService r100) {
        this.f221408a = r100;
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r100, m r101) {
        BridgeReadyModel r102 = (BridgeReadyModel) r100;
        tt5.a.h(this.f221408a.f221392a, "==openDocs==preload== notifyJsReady... data is " + r102);
        if (r102 == null) goto L24;
        WebViewLoadStateWebService r103 = this.f221408a;
        r103.f221394c.remove(r102.getType());
        d25.d.m(r102.getData(), r102.getType());
        String r104 = r102.getType();
        Intrinsics.checkNotNull(r104);
        if (r104.length() <= 0) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == false) goto L30;
        ((f) r103.f221399h.getValue()).j(r104, r103.f221398g);
        Intrinsics.checkNotNullParameter(r104, "type");
        if (r103.f221396e.add(r104) == false) goto L12;
        tt5.a.h(r103.f221392a, "==openDocs==preload== Type '" + r104 + "' is ready");
    L12:
        String r106 = r103.f221392a;
        StringBuilder r107 = new StringBuilder("==openDocs==preload== continuations.size = ");
        List r108 = (List) ((LinkedHashMap) r103.f221397f).get(r104);
        if (r108 == null) goto L15;
        Integer r109 = Integer.valueOf(r108.size());
    L16:
        r107.append(r109);
        tt5.a.h(r106, r107.toString());
        List<kotlinx.coroutines.i<Unit>> r110 = r103.f221397f.remove(r104);
        if (r110 == null) goto L31;
        Iterator<T> r111 = r110.iterator();
    L20:
        if (r111.hasNext() == false) goto L32;
        kotlinx.coroutines.i r112 = (kotlinx.coroutines.i) r111.next();
        tt5.a.h(r103.f221392a, "==openDocs==render== notifyJsReady, continuation = " + r112.hashCode() + ", isActive = " + r112.isActive());
        if (r112.isActive() == false) goto L20;
        Result.Companion r113 = Result.Companion;
        r112.resumeWith(Result.m9449constructorimpl(Unit.INSTANCE));
        goto L20
    L32:
        return;
    L31:
        return;
    L15:
        r109 = null;
        goto L16
    L30:
        return;
    L7:
        r105 = false;
        goto L8
    }
}
