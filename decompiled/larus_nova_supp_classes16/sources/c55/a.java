package c55;

import com.bytedance.ee.bear.browser.plugin.lazy.PluginMountStrategy;
import com.bytedance.ee.bear.browser.plugin.n;
import com.bytedance.ee.bear.document.loading.SmallLoadingPlugin;
import com.bytedance.ee.bear.drive.biz.docplugin.AttachmentOpenPlugin;
import com.bytedance.ee.bear.drive.biz.docplugin.ThirdPartyAttachmentOpenPlugin;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static n a() {
        AttachmentOpenPlugin r1 = new AttachmentOpenPlugin();
        PluginMountStrategy r2 = PluginMountStrategy.LoadFinish;
        return new n(new n.a[]{n.j(r1, SmallLoadingPlugin.DURATION_MAX, true, r2), n.j(new ThirdPartyAttachmentOpenPlugin(), SmallLoadingPlugin.DURATION_MAX, true, r2)});
    }
}
