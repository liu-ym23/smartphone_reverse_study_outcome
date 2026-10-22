package yv4;

import android.os.Handler;
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

/* JADX INFO: loaded from: classes16.dex */
public class e extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, com.bytedance.ee.bear.browser.plugin.f<?>> f569295e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f569296f;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f569297a = null;

        static {
            int[] r100 = new int[PluginMountStrategy.values().length];
            f569297a = r100;
            r100[PluginMountStrategy.Immediate.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f569297a[PluginMountStrategy.FirstFind.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f569297a[PluginMountStrategy.FirstJSCall.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f569297a[PluginMountStrategy.LoadFinish.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public final void i() {
        j.e("LazyPluginMounter", "syncMountPluginsByLoadFinish");
        this.f569296f = true;
        if (this.f569290a == null) goto L6;
        Runnable r100 = new d(this);
        Lazy<Handler> r101 = ThreadUtil.f437211a;
        ThreadUtil.a.g(r100);
        return;
    }

    public e(PluginHost r100) {
        super(r100);
        this.f569295e = new ConcurrentHashMap();
    }

    @Override // yv4.c
    public final Map<String, i<?>> e(n.a r100) {
        Map<String, i<?>> r101 = super.e(r100);
        h(r100, r101);
        return r101;
    }

    public final void j(String r100) {
        com.bytedance.ee.bear.browser.plugin.f<?> r101 = (com.bytedance.ee.bear.browser.plugin.f) ((ConcurrentHashMap) this.f569295e).remove(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.f569291b.isPluginAttached(r101) == true) goto L9;
        j.e("LazyPluginMounter", "Mount plugin by js msg:" + r101);
        g(r101);
        return;
    }

    @Override // yv4.c
    public final void f(n.a r100, Map<String, i<?>> r101) {
        PluginMountStrategy r102 = r100.f216632d;
        if (r102 != null) goto L5;
        r102 = PluginMountStrategy.Immediate;
    L5:
        int r103 = a.f569297a[r102.ordinal()];
        if (r103 != 1) goto L8;
        d(r100.f216629a);
        return;
    L8:
        if (r103 != 2) goto L10;
        h(r100, r101);
        return;
    L10:
        if (r103 != 3) goto L12;
        h(r100, r101);
        if (r101.isEmpty() == false) goto L26;
        j.f("LazyPluginMounter", "Plugin lazy mount with FirstJSCall , but no js handler . Mount it now !" + r100.f216629a);
        d(r100.f216629a);
        return;
    L26:
        return;
    L12:
        if (r103 == 4) goto L15;
        return;
    L15:
        if (this.f569296f == false) goto L17;
        d(r100.f216629a);
        return;
    L17:
        h(r100, r101);
    }

    public final void h(n.a r100, Map<String, i<?>> r101) {
        Iterator<String> r102 = r101.keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = r102.next();
        Map<String, com.bytedance.ee.bear.browser.plugin.f<?>> r104 = this.f569295e;
        ConcurrentHashMap r105 = (ConcurrentHashMap) r104;
        r105.put(r103, r100.f216629a);
        goto L4
    }
}
