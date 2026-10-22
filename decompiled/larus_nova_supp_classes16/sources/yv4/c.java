package yv4;

import android.os.Looper;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.BasePlugin;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.n;
import com.bytedance.lark.lark_markdown_render_android.BuildConfig;
import com.ss.android.lark.officesdk.utils.di.ThreadUtil;
import com.ss.android.lark.officesdk.utils.di.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import ntb.w;
import tb5.i;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class c implements f {
    public n a;
    public final PluginHost b;
    public final Map<n.a, Map<String, i<?>>> c;
    public final Map<com.bytedance.ee.bear.browser.plugin.i, com.bytedance.ee.bear.browser.plugin.f<?>> d;

    @Override // yv4.f
    public void release() {
        j.e("DefaultPluginMounter", BuildConfig.BUILD_TYPE);
    }

    public c(PluginHost r2) {
        this.c = new HashMap();
        this.d = new ConcurrentHashMap();
        this.b = r2;
    }

    @Override // yv4.f
    public final void a(n r6) {
        this.a = r6;
        List<n.a> r7 = r6.a(true);
        j.e("DefaultPluginMounter", "mountPlugins size:" + r7.size());
        Iterator<n.a> r0 = r7.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        com.bytedance.ee.bear.browser.plugin.f r1 = r0.next().a;
        if ((r1 instanceof BasePlugin) == false) goto L4;
        ((BasePlugin) r1).setHost(this.b);
        goto L4
    L8:
        Iterator<n.a> r2 = r7.iterator();
    L10:
        if (r2.hasNext() == false) goto L15;
        n.a r3 = r2.next();
        if (((HashMap) this.c).containsKey(r3) == true) goto L10;
        ((HashMap) this.c).put(r3, e(r3));
        goto L10
    L15:
        Iterator<n.a> r4 = r7.iterator();
    L17:
        if (r4.hasNext() == false) goto L24;
        com.bytedance.ee.bear.browser.plugin.f r5 = r4.next().a;
        if ((r5 instanceof com.bytedance.ee.bear.browser.plugin.a) == false) goto L17;
        Iterator<com.bytedance.ee.bear.browser.plugin.i> r8 = ((com.bytedance.ee.bear.browser.plugin.a) r5).getAbilities().iterator();
    L22:
        if (r8.hasNext() == false) goto L17;
        com.bytedance.ee.bear.browser.plugin.i r9 = r8.next();
        this.b.registerHostAbility(r9);
        ((ConcurrentHashMap) this.d).put(r9, r5);
        goto L22
    L24:
        Iterator<n.a> r10 = r7.iterator();
    L26:
        if (r10.hasNext() == false) goto L30;
        n.a r11 = r10.next();
        if (this.b.isPluginAttached(r11.a) == true) goto L26;
        f(r11, (Map) ((HashMap) this.c).get(r11));
        goto L26
    }

    @Override // yv4.f
    public final void b(com.bytedance.ee.bear.browser.plugin.i r4) {
        com.bytedance.ee.bear.browser.plugin.f<?> r0 = (com.bytedance.ee.bear.browser.plugin.f) ((ConcurrentHashMap) this.d).remove(r4);
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.b.isPluginAttached(r0) == true) goto L9;
        j.e("DefaultPluginMounter", "Mount plugin by findAbility, ability: " + r4 + ", plugin: " + r0);
        g(r0);
        return;
    }

    @Override // yv4.f
    public final void c(com.bytedance.ee.bear.browser.plugin.f<?> r3) {
        if (this.b.isPluginAttached(r3) == true) goto L6;
        j.e("DefaultPluginMounter", "Mount plugin by findPlugin:" + r3);
        g(r3);
        return;
    }

    public final void d(com.bytedance.ee.bear.browser.plugin.f<?> r2) {
        if (this.b.isDestroyed() == false) goto L6;
        j.b("DefaultPluginMounter", "mountPlugin while plugin host destroyed !");
        return;
    L6:
        this.b.attachPlugin(r2);
    }

    public Map<String, i<?>> e(n.a r6) {
        com.bytedance.ee.bear.browser.plugin.f r7 = r6.a;
        HashMap r0 = new HashMap();
        PluginHost r1 = this.b;
        if ((r1 instanceof WebPluginHost) == true) goto L5;
    L10:
        vv4.b r2 = (vv4.b) r1.getHostAbilityOrNull(vv4.b.class);
        if (r2 != null) goto L13;
    L18:
        return r0;
    L13:
        if ((r7 instanceof a) == false) goto L18;
        ((a) r7).getBridgeHandlers(r0);
        Iterator r8 = r0.entrySet().iterator();
    L16:
        if (r8.hasNext() == false) goto L18;
        Map.Entry r3 = (Map.Entry) r8.next();
        r2.getBridge().c((String) r3.getKey(), (i) r3.getValue());
        goto L16
    L5:
        if ((r7 instanceof a) == false) goto L10;
        ((a) r7).getBridgeHandlers(r0);
        k r9 = ((WebPluginHost) this.b).getWeb();
        Iterator r4 = r0.entrySet().iterator();
    L8:
        if (r4.hasNext() == false) goto L18;
        Map.Entry r5 = (Map.Entry) r4.next();
        r9.h((String) r5.getKey(), (i) r5.getValue());
        goto L8
    }

    public final void g(final com.bytedance.ee.bear.browser.plugin.f<?> r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (this.b.isPluginAttached(r5) == true) goto L22;
        Lazy r0 = ThreadUtil.a;
        w r1 = ThreadUtil.a.c();
        if (r1 == null) goto L9;
        boolean r2 = r1.I();
    L10:
        if (r2 == false) goto L13;
        d(r5);
        return;
    L13:
        j.f("DefaultPluginMounter", "Sync wait plugin mount:" + r5);
        final CountDownLatch r3 = new CountDownLatch(1);
        ThreadUtil.a.g(new b(this, r5, r3));
        r3.await(5, TimeUnit.SECONDS);     // Catch: InterruptedException -> L16
        return;
    L16:
        e = move-exception;
        j.g("DefaultPluginMounter", "syncMountWebPluginByJSMsg wait err", e);
        return;
    L9:
        r2 = Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
        goto L10
    }

    public void f(n.a r1, Map<String, i<?>> r2) {
        d(r1.a);
    }
}
