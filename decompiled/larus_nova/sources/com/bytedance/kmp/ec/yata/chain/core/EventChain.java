package com.bytedance.kmp.ec.yata.chain.core;

import com.bytedance.kmp.ec.yata.chain.trigger.ChainCenter;
import com.bytedance.kmp.ec.yata.chain.trigger.ChainListenerManager;
import com.bytedance.kmp.ec.yata.chain.trigger.f;
import com.bytedance.kmp.ec.yata.common.error.YataErrorManager;
import com.bytedance.kmp.ec.yata.common.init.c;
import com.bytedance.kmp.ec.yata.common.utils.YataConcurrentHashMap;
import com.bytedance.kmp.ec.yata.common.utils.b;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class EventChain implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f251255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f251256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, t96.a> f251257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f251258d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f251259e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f251260f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f251261g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ChainListenerManager f251262h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ChainCenter f251263i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final YataConcurrentHashMap<String, Object> f251264j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public f f251265k;

    public final YataErrorManager d() {
        return this.f251255a.c();
    }

    public final y96.a e() {
        return (y96.a) this.f251259e.getValue();
    }

    public final x96.a f() {
        return (x96.a) this.f251258d.getValue();
    }

    public final void b() {
        f().destroy();
        Iterator r100 = ((LinkedHashMap) this.f251257c).entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((t96.a) ((Map.Entry) r100.next()).getValue()).onDestroy();
        goto L4
    L6:
        ((com.bytedance.kmp.ec.yata.common.utils.a) this.f251260f.getValue()).b();
        this.f251261g = true;
    }

    @Override // com.bytedance.kmp.ec.yata.common.utils.b
    @Deprecated(message = "SDK内部API")
    public final boolean a() {
        return this.f251261g;
    }

    @Deprecated(message = "临时开放的接口，使用前先咨询SDK")
    public final t96.a c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return (t96.a) ((LinkedHashMap) this.f251257c).get(r100);
    }

    public final void g(t96.a r100) {
        Intrinsics.checkNotNullParameter(r100, "eventImpl");
        this.f251257c.put(r100.f545098a, r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EventChain(String r100, a r101, c r102) {
        Intrinsics.checkNotNullParameter(r100, "bizCode");
        Intrinsics.checkNotNullParameter(r101, "serviceProvider");
        Intrinsics.checkNotNullParameter(r102, "switchConfig");
        this.f251255a = r101;
        this.f251256b = r102;
        LinkedHashMap r103 = new LinkedHashMap();
        this.f251257c = r103;
        this.f251258d = LazyKt.lazy(EventChain$threadExecutor$2.INSTANCE);
        this.f251259e = LazyKt.lazy(new EventChain$exprAbility$2(this));
        this.f251260f = LazyKt.lazy(EventChain$mainHandler$2.INSTANCE);
        this.f251262h = new ChainListenerManager(this);
        this.f251263i = new ChainCenter(this);
        this.f251264j = new YataConcurrentHashMap(null, 1, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(this, "<set-?>");
        r101.f251266a = this;
        if (r101.c() != null) goto L5;
        int r104 = s96.b.f541119a;
        Intrinsics.checkNotNullParameter(this, "eventChain");
        r101.h(new YataErrorManager(r100, new s96.a(this)));
    L5:
        Function0<Unit> r105 = new EventChain$initFunctions$1(this);
        if (r103.get("saveLocal") != null) goto L8;
        r105.invoke();
    L8:
        Function0<Unit> r106 = new EventChain$initFunctions$2(this);
        if (r103.get("toast") != null) goto L11;
        r106.invoke();
    L11:
        Function0<Unit> r107 = new EventChain$initFunctions$3(this);
        if (r103.get("openSchema") != null) goto L14;
        r107.invoke();
    L14:
        Function0<Unit> r108 = new EventChain$initFunctions$4(this);
        if (r103.get(com.bytedance.android.ec.core.event.a.KEY_TRACKER) != null) goto L18;
        r108.invoke();
        return;
    }
}
