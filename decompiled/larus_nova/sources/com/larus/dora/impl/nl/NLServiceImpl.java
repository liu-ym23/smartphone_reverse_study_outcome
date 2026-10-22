package com.larus.dora.impl.nl;

import androidx.collection.ArrayMap;
import com.bytedance.keva.Keva;
import com.larus.dora.api.INLService;
import com.larus.push.impl.NotificationReceiverManager;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class NLServiceImpl implements INLService, t39.r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f336234c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<t39.r> f336235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Keva f336236b;

    /* JADX INFO: loaded from: classes27.dex */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ArrayMap<String, Integer> f336237a = null;

        static {
            f336237a = new ArrayMap();
        }
    }

    static {
        f336234c = Arrays.asList(new String[]{"com.tencent.mm", "com.ss.android.lark", "com.larksuite.suite", "com.ss.android.ugc.aweme", "com.xingin.xhs", "tv.danmaku.bili", "com.sdu.didi.psnger", "com.taobao.taobao", "com.sankuai.meituan"});
    }

    public final Keva f() {
        if (this.f336236b != null) goto L20;
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L6:
        if (this.f336236b == null) goto L21;
    L14:
        monitor-exit(this);     // Catch: Throwable -> L16
        goto L20
    L21:
        this.f336236b = Keva.getRepo("_nl");     // Catch: Throwable -> L12
        Iterator<String> r100 = f336234c.iterator();     // Catch: Throwable -> L12
    L9:
        if (r100.hasNext() == false) goto L14;
        String r101 = r100.next();     // Catch: Throwable -> L12
        a.f336237a.put(r101, Integer.valueOf(this.f336236b.getInt(r101, 2)));     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        g49.d.c("NLServiceImpl", "nlSettingsKey keva", th);     // Catch: Throwable -> L16
    L20:
        return this.f336236b;
    }

    @Override // com.larus.dora.api.INLService
    public final void init() {
        AtomicBoolean r100 = n.f336286a;
        pk4.m.a(new m());
    }

    public NLServiceImpl() {
        this.f336235a = new CopyOnWriteArraySet();
        this.f336236b = null;
    }

    @Override // t39.r
    public final void a(c49.a r100) {
        Iterator r101 = ((CopyOnWriteArraySet) this.f336235a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((t39.r) r101.next()).a(r100);
        goto L4
    }

    @Override // t39.r
    public final void b(c49.a r100) {
        g49.d.d("NLServiceImpl", "onNotifyRemove, cur: " + ((CopyOnWriteArraySet) this.f336235a).size() + ", msg: " + r100.toString());
        Iterator r101 = ((CopyOnWriteArraySet) this.f336235a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((t39.r) r101.next()).b(r100);
        goto L4
    }

    @Override // com.larus.dora.api.INLService
    public final void c(NotificationReceiverManager.a r100) {
        ((CopyOnWriteArraySet) this.f336235a).add(r100);
        g49.d.d("NLServiceImpl", "registerNLCallback, cur: " + ((CopyOnWriteArraySet) this.f336235a).size() + ", " + r100);
    }

    @Override // t39.r
    public final void d(c49.a r100) {
        g49.d.d("NLServiceImpl", "[NotificationTracer] onNotify, cur: " + ((CopyOnWriteArraySet) this.f336235a).size() + ", msg: " + r100.toString());
        Iterator r101 = ((CopyOnWriteArraySet) this.f336235a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((t39.r) r101.next()).d(r100);
        goto L4
    }

    @Override // t39.r
    public final void e(int r100) {
        Iterator r101 = ((CopyOnWriteArraySet) this.f336235a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((t39.r) r101.next()).e(r100);
        goto L4
    }

    public final void g(int r100) {
        IObricDoraService r101 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L9:
        if (r102 == false) goto L14;
        if (f() == null) goto L14;
        f().storeInt("nl_state", 2);
    L14:
        if (f() == null) goto L17;
        f().storeInt("nl_state", r100);
        return;
    L17:
        return;
    L5:
        if (r101.n() == false) goto L7;
        r102 = true;
        goto L9
    }
}
