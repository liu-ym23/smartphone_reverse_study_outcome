package com.ss.android.lark.coremd.impl.parse;

import com.ss.android.lark.coremd.base.parse.v;
import com.ss.android.lark.coremd.base.parse.y;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class e implements com.ss.android.lark.coremd.base.parse.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakHashMap<a, Unit> f419883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<y, CharSequence> f419884b;

    public interface a {
        void a(Object r100, boolean r101);

        void b(y r100, CharSequence r101);

        void c(s r100, v r101, ProxyClickSpanInner$Companion$proxyNodeClickInner$1$proxySpan$1.a r102, int r103);
    }

    public e() {
        this.f419883a = new WeakHashMap();
        this.f419884b = new LinkedHashMap();
    }

    public final void b(a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f419883a.put(r100, Unit.INSTANCE);
        Iterator r101 = ((LinkedHashMap) this.f419884b).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry r102 = (Map.Entry) r101.next();
        r100.b((y) r102.getKey(), (CharSequence) r102.getValue());
        goto L4
    L6:
        ((LinkedHashMap) this.f419884b).clear();
    }

    @Override // com.ss.android.lark.coremd.base.parse.m
    public final void a(Object r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "span");
        Iterator r102 = CollectionsKt.toList(this.f419883a.keySet()).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((a) r102.next()).a(r100, r101);
        goto L4
    }
}
