package com.bytedance.kmp.ec.yata.store.core;

import com.bytedance.kmp.ec.yata.common.biz.YataStoreWrapper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a implements com.bytedance.kmp.ec.yata.store.core.b {

    /* JADX INFO: renamed from: com.bytedance.kmp.ec.yata.store.core.a$a, reason: collision with other inner class name */
    public static final class C3594a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final YataStoreWrapper f251727c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final com.bytedance.kmp.ec.yata.store.node.c f251728d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final l f251729e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Map<String, Object> f251730f;

        public final void e(String r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            this.f251730f.put(r100, r101);
        }

        public C3594a(YataStoreWrapper r100, com.bytedance.kmp.ec.yata.store.node.c r101, l r102, aa6.a r103) {
            Intrinsics.checkNotNullParameter(r100, "storeWrapper");
            super(r101, r103);
            this.f251727c = r100;
            this.f251728d = r101;
            this.f251729e = r102;
            this.f251730f = new LinkedHashMap();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.kmp.ec.yata.store.node.c f251731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final aa6.a f251732b;

        public final Map<String, Object> a() {
            com.bytedance.kmp.ec.yata.store.node.c r100 = this.f251731a;
            if (r100 == null) goto L9;
            com.bytedance.kmp.ec.yata.store.node.e r101 = r100.f251782b;
            if (r101 == null) goto L9;
            com.bytedance.kmp.ec.yata.common.protocol.data.p r102 = r101.f251788b;
            if (r102 == null) goto L9;
            return com.bytedance.kmp.ec.yata.common.protocol.data.q.a(r102);
        L9:
            return null;
        }

        public final String b() {
            com.bytedance.kmp.ec.yata.store.node.c r100 = this.f251731a;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.getKey();
        }

        public final String c() {
            com.bytedance.kmp.ec.yata.store.node.c r100 = this.f251731a;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.getNodeName();
        }

        public final Map<String, Object> d() {
            com.bytedance.kmp.ec.yata.store.node.c r100 = this.f251731a;
            if (r100 == null) goto L9;
            com.bytedance.kmp.ec.yata.store.node.e r101 = r100.f251782b;
            if (r101 == null) goto L9;
            com.bytedance.kmp.ec.yata.common.protocol.data.p r102 = r101.f251788b;
            if (r102 == null) goto L9;
            return r102.h();
        L9:
            return null;
        }

        public b(com.bytedance.kmp.ec.yata.store.node.c r100, aa6.a r101) {
            this.f251731a = r100;
            this.f251732b = r101;
        }
    }

    public void b(C3594a r100) {
        Intrinsics.checkNotNullParameter(r100, "modifier");
    }

    public void c(C3594a r100) {
        Intrinsics.checkNotNullParameter(r100, "modifier");
    }

    public void d() {
    }

    public void e() {
    }

    public a() {
    }

    @Override // com.bytedance.kmp.ec.yata.store.core.b
    public final void a(l r100, aa6.a r101, YataStoreWrapper r110, List<? extends com.bytedance.kmp.ec.yata.store.node.c> r111) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r110, "storeWrapper");
        e();
        if (r111 == null) goto L48;
        Iterator<T> r112 = r111.iterator();
    L6:
        if (r112.hasNext() == false) goto L48;
        C3594a r102 = new C3594a(r110, (com.bytedance.kmp.ec.yata.store.node.c) r112.next(), r100, r101);
        b(r102);
        com.bytedance.kmp.ec.yata.store.node.c r103 = r102.f251728d;
        boolean r104 = false;
        if (r103 == null) goto L33;
        com.bytedance.kmp.ec.yata.store.node.e r105 = r103.f251782b;
        if (r105 == null) goto L33;
        com.bytedance.kmp.ec.yata.common.protocol.data.p r106 = r105.f251788b;
        if (r106 == null) goto L33;
        Map<String, Object> r107 = com.bytedance.kmp.ec.yata.common.protocol.data.q.a(r106);
        if (r107 == null) goto L33;
        Map<String, Object> r108 = r102.f251730f;
        if (r108 != null) goto L18;
    L21:
        boolean r109 = true;
    L22:
        if (r109 == true) goto L30;
        Iterator r113 = ((LinkedHashMap) r108).entrySet().iterator();
    L26:
        if (r113.hasNext() == false) goto L30;
        Map.Entry r114 = (Map.Entry) r113.next();
        if (Intrinsics.areEqual(r107.get(r114.getKey()), r114.getValue()) == true) goto L26;
        boolean r115 = true;
    L31:
        if (r115 != true) goto L33;
        r104 = true;
    L30:
        r115 = false;
        goto L31
    L18:
        if (r108.isEmpty() == true) goto L21;
        r109 = false;
    L33:
        if (r104 == false) goto L47;
        com.bytedance.kmp.ec.yata.store.node.e r116 = r102.f251728d.f251782b;
        com.bytedance.kmp.ec.yata.common.protocol.data.p r117 = r116.f251788b;
        if (r117 == null) goto L37;
        com.bytedance.kmp.ec.yata.common.protocol.data.p r118 = r117.c(2);
    L38:
        r116.f251788b = r118;
        com.bytedance.kmp.ec.yata.common.protocol.data.p r119 = r102.f251728d.f251782b.f251788b;
        if (r119 == null) goto L41;
        com.bytedance.kmp.ec.yata.common.protocol.data.q.d(r119, r102.f251730f);
    L41:
        l r120 = r102.f251729e;
        if (r120 == null) goto L46;
        aa6.b r121 = r120.a();
        if (r121 == null) goto L46;
        r121.s(r102.b(), r102.f251728d.f251782b.f251788b);
    L46:
        ((LinkedHashMap) r102.f251730f).clear();
        r102.f251727c.f251342c.getNodeDataChangedSet().add(r102.f251728d.getKey());
        goto L47
    L37:
        r118 = null;
    L47:
        c(r102);
    L48:
        d();
    }
}
