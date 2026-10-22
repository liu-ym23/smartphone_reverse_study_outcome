package com.bytedance.live.artist.render;

import com.bytedance.live.artist.core.EntityManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes45.dex */
public final class RenderEntity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, nf6.a> f254826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<e> f254827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f254828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f254829d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f254830e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f254831f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f254832g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public EntityState f254833h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public mf6.a f254834i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.live.artist.core.b f254835j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a f254836k;

    public final void c() {
        d(RenderEntity$destroy$1.INSTANCE);
        ((ArrayList) this.f254827b).clear();
        ((HashMap) this.f254826a).clear();
        f r100 = this.f254828c;
        r100.f254852a = 0.0f;
        r100.f254853b = 0.0f;
        b r101 = this.f254829d;
        r101.f254847a = 0.0f;
        r101.f254848b = 0.0f;
        g(EntityState.Destroyed);
    }

    public final void b(nf6.a r100) {
        a(r100.getClass(), r100);
    }

    public final void d(Function1<? super e, Unit> r100) {
        Iterator r101 = ((ArrayList) this.f254827b).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.invoke(r101.next());
        goto L4
    }

    public final <T extends nf6.a> T e(Class<T> r100) {
        Object r101 = ((HashMap) this.f254826a).get(r100);
        if ((r101 instanceof nf6.a) == true) goto L6;
        r101 = null;
    L6:
        return (T) r101;
    }

    public final void g(EntityState r100) {
        this.f254833h = r100;
        this.f254836k.a(this, r100);
    }

    public RenderEntity(com.bytedance.live.artist.core.b r100, EntityManager r101) {
        this.f254835j = r100;
        this.f254836k = r101;
        this.f254826a = new HashMap();
        this.f254827b = new ArrayList();
        this.f254828c = new f();
        this.f254829d = new b();
        this.f254830e = new b();
        this.f254831f = 1;
        this.f254833h = EntityState.Init;
    }

    public static void f(RenderEntity r100, Function1 r101) {
        if (r100.f254833h != EntityState.Rendering) goto L9;
        Iterator r102 = ((ArrayList) r100.f254827b).iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        e r103 = (e) r102.next();
        Unit r104 = (Unit) r101.invoke(r103);
        r103.f();
        goto L7
    L11:
        return;
    }

    public final void a(Class<?> r100, nf6.a r101) {
        ((HashMap) this.f254826a).put(r100, r101);
    }
}
