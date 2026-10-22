package yv4;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.lazy.PluginMountStrategy;
import com.bytedance.ee.bear.browser.plugin.n;
import com.ss.android.lark.officesdk.utils.di.ThreadUtil;
import com.ss.android.lark.officesdk.utils.di.j;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import tb5.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class e extends c {
    public final Map<String, com.bytedance.ee.bear.browser.plugin.f<?>> e;
    public boolean f;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PluginMountStrategy.values().length];
            a = r0;
            r0[PluginMountStrategy.Immediate.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            a[PluginMountStrategy.FirstFind.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            a[PluginMountStrategy.FirstJSCall.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            a[PluginMountStrategy.LoadFinish.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public final void i() {
        j.e("LazyPluginMounter", "syncMountPluginsByLoadFinish");
        this.f = true;
        if (this.a == null) goto L6;
        Runnable r0 = new d(this);
        Lazy r1 = ThreadUtil.a;
        ThreadUtil.a.g(r0);
        return;
    }

    public e(PluginHost r1) {
        super(r1);
        this.e = new ConcurrentHashMap();
    }

    @Override // yv4.c
    public final Map<String, i<?>> e(n.a r2) {
        Map<String, i<?>> r0 = super.e(r2);
        h(r2, r0);
        return r0;
    }

    public final void j(String r3) {
        com.bytedance.ee.bear.browser.plugin.f<?> r4 = (com.bytedance.ee.bear.browser.plugin.f) ((ConcurrentHashMap) this.e).remove(r3);
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.b.isPluginAttached(r4) == true) goto L9;
        j.e("LazyPluginMounter", "Mount plugin by js msg:" + r4);
        g(r4);
        return;
    }

    @Override // yv4.c
    public final void f(n.a r3, Map<String, i<?>> r4) {
        PluginMountStrategy r0 = r3.d;
        if (r0 != null) goto L5;
        r0 = PluginMountStrategy.Immediate;
    L5:
        int r1 = a.a[r0.ordinal()];
        if (r1 != 1) goto L8;
        d(r3.a);
        return;
    L8:
        if (r1 != 2) goto L10;
        h(r3, r4);
        return;
    L10:
        if (r1 != 3) goto L12;
        h(r3, r4);
        if (r4.isEmpty() == false) goto L26;
        j.f("LazyPluginMounter", "Plugin lazy mount with FirstJSCall , but no js handler . Mount it now !" + r3.a);
        d(r3.a);
        return;
    L26:
        return;
    L12:
        if (r1 == 4) goto L15;
        return;
    L15:
        if (this.f == false) goto L17;
        d(r3.a);
        return;
    L17:
        h(r3, r4);
    }

    public final void h(n.a r4, Map<String, i<?>> r5) {
        Iterator<String> r6 = r5.keySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        String r0 = r6.next();
        Map<String, com.bytedance.ee.bear.browser.plugin.f<?>> r1 = this.e;
        ConcurrentHashMap r2 = (ConcurrentHashMap) r1;
        r2.put(r0, r4.a);
        goto L4
    }
}
