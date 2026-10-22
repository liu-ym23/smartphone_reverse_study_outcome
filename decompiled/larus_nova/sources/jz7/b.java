package jz7;

import android.content.Context;
import com.bytedance.ee.lark.plugin_annotation.bean.PluginEnv;
import com.larksuite.component.openplatform.plugins.container.DefaultContainerPlugin;

/* JADX INFO: loaded from: classes24.dex */
public final class b extends a {
    public b(Context r100) {
        super(r100);
        PluginEnv r101 = PluginEnv.APP_ENV;
        this.f507012a.b(new DefaultContainerPlugin(this));
    }
}
