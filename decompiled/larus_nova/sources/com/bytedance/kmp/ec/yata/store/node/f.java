package com.bytedance.kmp.ec.yata.store.node;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.kmp.ec.yata.common.biz.YataStoreWrapper;
import com.bytedance.kmp.ec.yata.common.protocol.data.k;
import com.bytedance.kmp.ec.yata.common.protocol.data.l;
import com.bytedance.kmp.ec.yata.common.protocol.data.p;
import com.bytedance.kmp.ec.yata.store.core.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public class f extends c implements ba6.d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f251792e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<b> f251793f;

    @Override // ba6.d
    public int b() {
        com.bytedance.kmp.ec.yata.common.protocol.data.b r100 = this.f251782b.f251789c;
        if (r100 == null) goto L5;
        List<String> r101 = r100.getType();
    L6:
        if (r101 != null) goto L10;
        return 0;
    L10:
        return r101.hashCode();
    L5:
        r101 = null;
        goto L6
    }

    @Override // ba6.d
    @Deprecated(message = "SDK内部API")
    public final void f() {
        this.f251783c.f251752a.w(getKey());
    }

    @Override // ba6.d
    public final com.bytedance.kmp.ec.yata.common.protocol.data.b getContainer() {
        return this.f251782b.f251789c;
    }

    public f t() {
        String r100 = this.f251781a;
        e r101 = this.f251782b;
        String r102 = r101.f251787a;
        p r103 = r101.f251788b;
        com.bytedance.kmp.ec.yata.common.protocol.data.b r104 = r101.f251789c;
        List<String> r105 = r101.f251790d;
        Map<String, Object> r106 = r101.f251791e;
        Intrinsics.checkNotNullParameter(r102, "key");
        Intrinsics.checkNotNullParameter(r105, "nodeChildrenKey");
        return new f(r100, new e(r102, r103, r104, r105, r106), this.f251783c);
    }

    @Override // com.bytedance.kmp.ec.yata.store.node.b
    public final List<b> getChildren() {
        return this.f251793f;
    }

    @Override // com.bytedance.kmp.ec.yata.store.node.b
    public final b getParent() {
        return this.f251792e;
    }

    @Override // com.bytedance.kmp.ec.yata.store.node.b
    public final void g(b r100) {
        this.f251792e = r100;
    }

    @Override // ba6.d
    public boolean o(ba6.d r100) {
        Intrinsics.checkNotNullParameter(r100, "newItem");
        this.f251783c.f251752a.f251341b.getClass();
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f251782b.f251789c, r101.f251782b.f251789c) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.f251782b.f251788b, r101.f251782b.f251788b) == false) goto L7;
        return true;
    }

    @Override // ba6.d
    public final boolean j(aa6.a r100, String r101) {
        k r102 = r();
        if (r102 == null) goto L26;
        YataStoreWrapper r103 = this.f251783c.f251752a;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        Intrinsics.checkNotNullParameter(r103, "storeWrapper");
        if (r100 == null) goto L22;
        Map<String, Object> r104 = r102.c();
        if (r104 == null) goto L12;
        Map<String, Object> r105 = com.bytedance.kmp.ec.yata.common.utils.d.h(r104, GXTemplateKey.GAIAX_ANIMATION);
        if (r105 == null) goto L12;
        Map<String, Object> r106 = com.bytedance.kmp.ec.yata.common.utils.d.h(r105, "changing");
    L14:
        if (l.a(r100, r101, r106) == false) goto L17;
        boolean r107 = true;
    L23:
        if (r107 != true) goto L27;
        return true;
    L27:
        return false;
    L17:
        if (com.bytedance.kmp.ec.yata.common.init.b.b() == false) goto L22;
        String r108 = r102.h();
        if (r108 != null) goto L21;
        r108 = "";
    L21:
        r103.getClass();
        Intrinsics.checkNotNullParameter(r108, "nodeName");
        com.bytedance.kmp.ec.yata.common.init.b.b();
    L12:
        r106 = null;
    L22:
        r107 = false;
        goto L23
    L26:
        return false;
    }

    @Override // ba6.d
    public final boolean k(aa6.a r100, String r101) {
        k r102 = r();
        if (r102 == null) goto L26;
        YataStoreWrapper r103 = this.f251783c.f251752a;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        Intrinsics.checkNotNullParameter(r103, "storeWrapper");
        if (r100 == null) goto L22;
        Map<String, Object> r104 = r102.c();
        if (r104 == null) goto L12;
        Map<String, Object> r105 = com.bytedance.kmp.ec.yata.common.utils.d.h(r104, GXTemplateKey.GAIAX_ANIMATION);
        if (r105 == null) goto L12;
        Map<String, Object> r106 = com.bytedance.kmp.ec.yata.common.utils.d.h(r105, "appearing");
    L14:
        if (l.a(r100, r101, r106) == false) goto L17;
        boolean r107 = true;
    L23:
        if (r107 != true) goto L27;
        return true;
    L27:
        return false;
    L17:
        if (com.bytedance.kmp.ec.yata.common.init.b.b() == false) goto L22;
        String r108 = r102.h();
        if (r108 != null) goto L21;
        r108 = "";
    L21:
        r103.getClass();
        Intrinsics.checkNotNullParameter(r108, "nodeName");
        com.bytedance.kmp.ec.yata.common.init.b.b();
    L12:
        r106 = null;
    L22:
        r107 = false;
        goto L23
    L26:
        return false;
    }

    @Override // ba6.d
    public final boolean l(aa6.a r100, String r101) {
        k r102 = r();
        if (r102 == null) goto L26;
        YataStoreWrapper r103 = this.f251783c.f251752a;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        Intrinsics.checkNotNullParameter(r103, "storeWrapper");
        if (r100 == null) goto L22;
        Map<String, Object> r104 = r102.c();
        if (r104 == null) goto L12;
        Map<String, Object> r105 = com.bytedance.kmp.ec.yata.common.utils.d.h(r104, GXTemplateKey.GAIAX_ANIMATION);
        if (r105 == null) goto L12;
        Map<String, Object> r106 = com.bytedance.kmp.ec.yata.common.utils.d.h(r105, "disappearing");
    L14:
        if (l.a(r100, r101, r106) == false) goto L17;
        boolean r107 = true;
    L23:
        if (r107 != true) goto L27;
        return true;
    L27:
        return false;
    L17:
        if (com.bytedance.kmp.ec.yata.common.init.b.b() == false) goto L22;
        String r108 = r102.h();
        if (r108 != null) goto L21;
        r108 = "";
    L21:
        r103.getClass();
        Intrinsics.checkNotNullParameter(r108, "nodeName");
        com.bytedance.kmp.ec.yata.common.init.b.b();
    L12:
        r106 = null;
    L22:
        r107 = false;
        goto L23
    L26:
        return false;
    }

    public f(String r100, e r101, m r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "nodeInfo");
        Intrinsics.checkNotNullParameter(r102, "storeContext");
        super(r100, r101, r102);
        this.f251793f = new ArrayList();
    }
}
