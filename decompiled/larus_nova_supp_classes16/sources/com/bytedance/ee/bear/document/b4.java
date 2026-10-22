package com.bytedance.ee.bear.document;

import com.bytedance.ee.bear.document.render.node.RenderSSRNode;
import com.bytedance.ee.bear.document.render.node.perf.PerfReportRenderNode;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b4 {
    public static final Map<sbb.e, v4> a = null;
    public static final Map<com.bytedance.ee.bear.document.render.node.n, com.bytedance.ee.bear.document.render.node.m> b = null;

    public static final class a implements com.bytedance.ee.bear.document.render.node.m {
        public a() {
        }

        @Override // com.bytedance.ee.bear.document.render.node.m
        public final com.bytedance.ee.bear.document.render.node.l a() {
            return new com.bytedance.ee.bear.document.render.node.d();
        }
    }

    public static final class b implements com.bytedance.ee.bear.document.render.node.m {
        public b() {
        }

        @Override // com.bytedance.ee.bear.document.render.node.m
        public final com.bytedance.ee.bear.document.render.node.l a() {
            return new com.bytedance.ee.bear.document.render.node.h();
        }
    }

    public static final class c implements com.bytedance.ee.bear.document.render.node.m {
        public c() {
        }

        @Override // com.bytedance.ee.bear.document.render.node.m
        public final com.bytedance.ee.bear.document.render.node.l a() {
            return new com.bytedance.ee.bear.document.render.node.j();
        }
    }

    public static final class d implements com.bytedance.ee.bear.document.render.node.m {
        public d() {
        }

        @Override // com.bytedance.ee.bear.document.render.node.m
        public final com.bytedance.ee.bear.document.render.node.l a() {
            return new com.bytedance.ee.bear.document.render.node.s();
        }
    }

    public static final class e implements com.bytedance.ee.bear.document.render.node.m {
        public e() {
        }

        @Override // com.bytedance.ee.bear.document.render.node.m
        public final com.bytedance.ee.bear.document.render.node.l a() {
            return new RenderSSRNode();
        }
    }

    public static final class f implements com.bytedance.ee.bear.document.render.node.m {
        public f() {
        }

        @Override // com.bytedance.ee.bear.document.render.node.m
        public final com.bytedance.ee.bear.document.render.node.l a() {
            return new PerfReportRenderNode();
        }
    }

    public static final class g implements com.bytedance.ee.bear.document.render.node.m {
        public g() {
        }

        @Override // com.bytedance.ee.bear.document.render.node.m
        public final com.bytedance.ee.bear.document.render.node.l a() {
            return new com.bytedance.ee.bear.document.render.node.b();
        }
    }

    static {
        a = new LinkedHashMap();
        LinkedHashMap r0 = new LinkedHashMap();
        b = r0;
        r0.put(com.bytedance.ee.bear.document.render.node.n.g.b, new a());
        r0.put(com.bytedance.ee.bear.document.render.node.n.h.b, new b());
        r0.put(com.bytedance.ee.bear.document.render.node.n.j.b, new c());
        r0.put(com.bytedance.ee.bear.document.render.node.n.m.b, new d());
        r0.put(com.bytedance.ee.bear.document.render.node.n.k.b, new e());
        r0.put(com.bytedance.ee.bear.document.render.node.n.i.b, new f());
        r0.put(com.bytedance.ee.bear.document.render.node.n.e.b, new g());
    }

    public static v4 a(sbb.e r4) {
        Intrinsics.checkNotNullParameter(r4, "documentType");
        v4 r0 = (v4) ((LinkedHashMap) a).get(r4);
        if (r0 != null) goto L5;
        iu5.d.a("DocumentSdk", new Throwable("getDocumentOpenStrategy documentType:" + r4 + " not found"));
    L5:
        if (r0 == null) goto L7;
        return r0;
    L7:
        return new s();
    }

    public static void b(sbb.e r1, v4 r2) {
        Intrinsics.checkNotNullParameter(r1, "documentType");
        Intrinsics.checkNotNullParameter(r2, "strategy");
        a.put(r1, r2);
    }

    public static void c(com.bytedance.ee.bear.document.render.node.n r1, com.bytedance.ee.bear.document.render.node.m r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, "creator");
        b.put(r1, r2);
    }
}
