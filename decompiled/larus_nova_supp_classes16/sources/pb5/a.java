package pb5;

import com.bytedance.ee.bear.basesdk.config.d;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.n;
import com.bytedance.ee.bear.document.loading.DocLoadingPlugin;
import com.bytedance.ee.bear.document.loading.LoadingFailedPlugin;
import com.bytedance.ee.bear.wikiv2.browser.plugin.l;
import com.ss.android.lark.utils.y0;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends d implements l {
    public a() {
    }

    public final n b(PluginHost r3, String r4) {
        tt5.a.h("WikiContentPluginsProviderImplV2", "getWikiContentPlugins:" + r4);
        n r5 = d.c(r3, r4);
        r5.l(LoadingFailedPlugin.class);
        if (y0.a(e.i.getType(), r4) == true) goto L5;
        r5.l(DocLoadingPlugin.class);
    L5:
        return r5;
    }
}
