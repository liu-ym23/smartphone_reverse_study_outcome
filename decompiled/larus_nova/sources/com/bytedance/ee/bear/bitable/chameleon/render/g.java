package com.bytedance.ee.bear.bitable.chameleon.render;

import com.bytedance.ee.bear.bitable.chameleon.render.fetcher.BaseAddFetcher;
import com.bytedance.ee.bear.bitable.chameleon.render.fetcher.BaseAppClientVarsFetcher;
import com.bytedance.ee.bear.bitable.chameleon.render.fetcher.BaseAppFirstScreenDataFetcher;
import com.bytedance.ee.bear.bitable.chameleon.render.fetcher.BaseAppTableSsrDataFetcher;
import com.bytedance.ee.bear.bitable.chameleon.render.fetcher.BaseRecordFetcher;
import com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3;
import com.bytedance.ee.bear.document.render.node.l;
import com.bytedance.ee.bear.document.render.node.q;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import vv4.k;

/* JADX INFO: loaded from: classes15.dex */
public final class g implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.ee.bear.bitable.chameleon.render.a<?, ?>> f209794a;

    public static final class a {
    }

    static {
    }

    public g() {
        this.f209794a = new ArrayList();
        a(new BaseRecordFetcher());
        a(new BaseAddFetcher());
        a(new jr4.b());
        a(new jr4.e());
        a(new BaseAppClientVarsFetcher());
        a(new BaseAppFirstScreenDataFetcher());
        a(new BaseAppTableSsrDataFetcher());
    }

    public final void a(com.bytedance.ee.bear.bitable.chameleon.render.a<?, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "fetcher");
        ((ArrayList) this.f209794a).add(r100);
    }

    @Override // com.bytedance.ee.bear.document.render.node.l
    public final void c(DocumentLoaderV3 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.ee.bear.document.render.node.l
    public final Object b(final DocumentLoaderV3 r110, Continuation r111) {
        List<com.bytedance.ee.bear.bitable.chameleon.render.a<?, ?>> r112 = this.f209794a;
        ArrayList r100 = new ArrayList();
        Iterator r113 = ((ArrayList) r112).iterator();
    L4:
        if (r113.hasNext() == false) goto L8;
        Object r101 = r113.next();
        if (((com.bytedance.ee.bear.bitable.chameleon.render.a) r101).b(r110) == false) goto L4;
        r100.add(r101);
        goto L4
    L8:
        tt5.a.h("BitableNetDataNode", "run: matched=" + r100.size() + ", total=" + ((ArrayList) this.f209794a).size() + ", bridges=" + CollectionsKt.joinToString$default(r100, null, null, null, 0, null, BitableNetDataNode$run$2.INSTANCE, 31, null));
        Iterator r114 = r100.iterator();
    L10:
        if (r114.hasNext() == false) goto L13;
        final com.bytedance.ee.bear.bitable.chameleon.render.a r102 = (com.bytedance.ee.bear.bitable.chameleon.render.a) r114.next();
        tt5.a.h("BitableNetDataNode", "run: bind and start, bridge=" + r102.c());
        k r103 = r110.f221315d.getWeb();
        String r104 = r102.c();
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        r103.h(r104, new b(r102, r110));
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        tt5.a.h("BitableNetDataNode", "fetch start, bridge=" + r102.c());
        r102.g(r110, new AbsBaseNetDataFetcher$start$1(r102, r110));
        goto L10
    L13:
        return new q.c();
    }
}
