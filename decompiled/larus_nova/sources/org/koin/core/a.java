package org.koin.core;

import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import iwc.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import nwc.c;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.logger.Level;
import org.koin.core.scope.Scope;

/* JADX INFO: loaded from: classes42.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f526122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final nwc.b f526123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final jwc.a f526124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashSet<kwc.a> f526125d;

    public final void a() {
        Scope r100 = this.f526122a.d();
        if (r100.f526145b.f526156b == false) goto L20;
        nwc.a r101 = r100.f526148e;
        Collection<iwc.c<?>> r102 = r101.f521026c.values();
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L10;
        Object r105 = r104.next();
        if ((r105 instanceof d) == false) goto L6;
        r103.add(r105);
        goto L6
    L10:
        ArrayList r106 = new ArrayList();
        Iterator r107 = r103.iterator();
    L12:
        if (r107.hasNext() == false) goto L16;
        Object r108 = r107.next();
        if (((d) r108).f496311b.f526134g.f526139a == false) goto L12;
        r106.add(r108);
        goto L12
    L16:
        Iterator r109 = r106.iterator();
    L18:
        if (r109.hasNext() == false) goto L32;
        ((d) r109.next()).c(new iwc.b(r101.f521024a, r101.f521025b, null));
        goto L18
    L32:
        return;
    }

    public a() {
        this.f526122a = new c(this);
        this.f526123b = new nwc.b(this);
        this.f526124c = new jwc.a();
        this.f526125d = new HashSet();
    }

    public final void c(List<kwc.a> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, IPerformanceManager.Params.modules);
        this.f526125d.addAll(r100);
        c r102 = this.f526122a;
        List<kwc.a> r103 = r100;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, IPerformanceManager.Params.modules);
        Iterator<T> r104 = r103.iterator();
    L4:
        if (r104.hasNext() == false) goto L19;
        kwc.a r105 = (kwc.a) r104.next();
        if (r105.f506521d == false) goto L7;
        jwc.a r106 = r102.f521029a.f526124c;
        String r107 = "module '" + r105 + "' already loaded!";
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, "msg");
        r106.b(Level.ERROR, r107);
        goto L4
    L7:
        Iterator<mwc.a> r108 = r105.f506522e.iterator();
    L9:
        if (r108.hasNext() == false) goto L13;
        mwc.a r109 = r108.next();
        org.koin.core.scope.c r110 = new org.koin.core.scope.c(r109, false);
        if (r102.f521030b.get(r109.getValue()) != null) goto L9;
        r102.f521030b.put(r109.getValue(), r110);
        goto L9
    L13:
        Iterator<BeanDefinition<?>> r111 = r105.f506523f.iterator();
    L15:
        if (r111.hasNext() == false) goto L17;
        r102.b(r111.next());
        goto L15
    L17:
        r105.f506521d = true;
        goto L4
    L19:
        if (r101 == false) goto L34;
        a();
        return;
    }

    public final Scope b(String r100, mwc.d r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "scopeId");
        Intrinsics.checkNotNullParameter(r101, "qualifier");
        if (this.f526124c.c(Level.DEBUG) == false) goto L6;
        this.f526124c.a("!- create scope - id:'" + r100 + "' q:" + r101);
    L6:
        return this.f526122a.a(r100, r101, r102);
    }
}
