package com.ss.android.lark.integrator.im.extension;

import com.ss.android.lark.biz.im.api.extension.ImExtensionType;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.locationmessage.message.g;
import com.ss.android.lark.message.card.view.d;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import lqb.b;
import qbc.c;

/* JADX INFO: loaded from: classes36.dex */
public final class ImContextImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<Object> f427936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<rxa.a> f427937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList<gya.a<? extends Content>> f427938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<MessageType, gya.a<? extends Content>> f427939d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f427940e;

    public ImContextImpl() {
        this.f427936a = new CopyOnWriteArrayList();
        new CopyOnWriteArrayList();
        CopyOnWriteArrayList<rxa.a> r100 = new CopyOnWriteArrayList();
        r100.add(new d());
        this.f427937b = r100;
        g r101 = new g();
        com.ss.android.lark.message.card.parser.a r102 = new com.ss.android.lark.message.card.parser.a();
        c6b.a r103 = new c6b.a();
        c r104 = new c();
        CopyOnWriteArrayList<gya.a<? extends Content>> r105 = new CopyOnWriteArrayList();
        new b(com.ss.android.lark.integrator.im.message.d.f428034a);
        r105.add(r101);
        r105.add(r102);
        r105.add(r103);
        r105.add(r104);
        this.f427938c = r105;
        ConcurrentHashMap r106 = new ConcurrentHashMap();
        r106.put(MessageType.LOCATION, r101);
        r106.put(MessageType.CARD, r102);
        r106.put(MessageType.MERGE_FORWARD, r103);
        r106.put(MessageType.VOTE, r104);
        this.f427939d = r106;
        new CopyOnWriteArrayList();
        this.f427940e = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, ImContextImpl$multiSelectProviders$2.INSTANCE);
    }

    public final void a(com.ss.android.lark.vote.message.cell.c r100) {
        Intrinsics.checkNotNullParameter(r100, "factory");
        CopyOnWriteArrayList<Object> r101 = this.f427936a;
        if (r101.contains(r100) == true) goto L6;
        r101.add(r100);
        return;
    }

    public final void b(com.ss.android.lark.vote.message.cell.g r100) {
        Intrinsics.checkNotNullParameter(r100, "factory");
        CopyOnWriteArrayList<rxa.a> r101 = this.f427937b;
        if (r101.contains(r100) == true) goto L6;
        r101.add(r100);
        return;
    }

    public final void c(qxa.a<Unit, Collection<gya.a<? extends Content>>> r100) {
        Intrinsics.checkNotNullParameter(r100, "factory");
        Iterator r101 = ((Iterable) r100.a(Unit.INSTANCE)).iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        gya.a<? extends Content> r102 = (gya.a) r101.next();
        CopyOnWriteArrayList<gya.a<? extends Content>> r103 = this.f427938c;
        if (r103.contains(r102) == true) goto L9;
        r103.add(r102);
    L9:
        if (r102.a() == MessageType.UNKNOWN) goto L4;
        Map<MessageType, gya.a<? extends Content>> r104 = this.f427939d;
        ConcurrentHashMap r105 = (ConcurrentHashMap) r104;
        r105.put(r102.a(), r102);
        goto L4
    }

    public final void d(ImExtensionType r100, Collection<? extends Class<?>> r101) {
        Intrinsics.checkNotNullParameter(r100, "extensionType");
        Intrinsics.checkNotNullParameter(r101, "factoryClasses");
        Map<ImExtensionType, List<Class<?>>> r102 = com.ss.android.lark.im.base.d.f425883a;
        Intrinsics.checkNotNullParameter(r100, "extensionType");
        Intrinsics.checkNotNullParameter(r101, "factoryClasses");
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        com.ss.android.lark.im.base.d.d(r100, (Class) r103.next());
        goto L4
    }

    public final void e(ImExtensionType r100, Class<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "extensionType");
        Intrinsics.checkNotNullParameter(r101, "factoryClass");
        com.ss.android.lark.im.base.d.d(r100, r101);
    }
}
