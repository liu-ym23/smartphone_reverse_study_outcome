package com.bytedance.kmp.ec.yata.store.node;

import com.bytedance.kmp.ec.yata.common.protocol.data.k;
import com.bytedance.kmp.ec.yata.common.protocol.data.p;
import com.bytedance.kmp.ec.yata.common.protocol.data.q;
import com.bytedance.kmp.ec.yata.store.core.m;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class c implements b, ba6.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f251781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f251782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f251783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f251784d;

    @Override // ba6.c
    public final String getNodeName() {
        p r100 = this.f251782b.f251788b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return q.c(r100);
    }

    @Override // ba6.c
    public final String getPosition() {
        p r100 = this.f251782b.f251788b;
        if (r100 == null) goto L11;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        k r101 = r100.g();
        if (r101 == null) goto L12;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        String r102 = r101.j();
        if (r102 != null) goto L10;
        r102 = ContainerPosition.BODY;
    L10:
        return r102;
    L12:
        return null;
    L11:
        return null;
    }

    @Override // ba6.c
    public final boolean m() {
        p r100 = this.f251782b.f251788b;
        if (r100 == null) goto L7;
        Map<String, List<com.bytedance.kmp.ec.yata.common.protocol.data.g>> r101 = r100.e();
        if (r101 == null) goto L7;
        List<com.bytedance.kmp.ec.yata.common.protocol.data.g> r102 = r101.get("AutoExposure");
    L8:
        List<com.bytedance.kmp.ec.yata.common.protocol.data.g> r103 = r102;
        if (r103 != null) goto L11;
    L14:
        boolean r104 = true;
    L16:
        return !r104;
    L11:
        if (r103.isEmpty() == true) goto L14;
        r104 = false;
    L7:
        r102 = null;
        goto L8
    }

    public final k r() {
        p r100 = this.f251782b.f251788b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.g();
    }

    public final Map<String, Object> s() {
        p r100 = this.f251782b.f251788b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.h();
    }

    @Override // ba6.c
    public final String a() {
        return getKey();
    }

    @Override // ba6.c
    @Deprecated(message = "废弃", replaceWith = @ReplaceWith(expression = "getNodeKey()", imports = {}))
    public final String d() {
        return getKey();
    }

    @Override // ba6.c
    public Map<String, Object> e() {
        Map<String, Object> r100 = s();
        Map<String, Object> r101 = this.f251782b.f251791e;
        if (r100 != null) goto L7;
        if (r101 != null) goto L7;
        return MapsKt.emptyMap();
    L7:
        HashMap r102 = new HashMap();
        if (r100 == null) goto L10;
        r102.putAll(r100);
    L10:
        if (r101 == null) goto L12;
        r102.put("global", r101);
    L12:
        return r102;
    }

    @Override // com.bytedance.kmp.ec.yata.store.node.b
    public String getKey() {
        return this.f251781a;
    }

    @Override // com.bytedance.kmp.ec.yata.store.node.b
    public final void h(Function1<? super b, Unit> r100) {
        b.a.d(this, r100);
    }

    @Override // com.bytedance.kmp.ec.yata.store.node.b
    public final void n(Function1<? super b, Unit> r100) {
        b.a.c(this, r100);
    }

    @Override // ba6.c
    @Deprecated(message = "SDK内部API")
    public final void p(Function1<? super Map<String, Object>, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        p r101 = this.f251782b.f251788b;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.h() != null) goto L8;
        r101.j(new LinkedHashMap());
    L8:
        Map<String, Object> r102 = r101.h();
        if (r102 != null) goto L11;
        r102 = new LinkedHashMap();
    L11:
        r100.invoke(r102);
    }

    @Override // com.bytedance.kmp.ec.yata.store.node.b
    public final void q(Function1<? super b, Unit> r100) {
        b.a.b(this, r100);
    }

    public c(String r100, e r101, m r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "nodeInfo");
        Intrinsics.checkNotNullParameter(r102, "storeContext");
        this.f251781a = r100;
        this.f251782b = r101;
        this.f251783c = r102;
        this.f251784d = "";
    }
}
