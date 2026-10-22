package t57;

import android.app.Application;
import com.bytedance.platform.godzilla.plugin.PluginState;
import com.bytedance.platform.godzilla.plugin.StartType;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public a() {
    }

    public abstract String b();

    public void d() {
        PluginState r100 = PluginState.INITIALIZED;
    }

    public StartType e() {
        return StartType.IMMEDIATE;
    }

    public void c(Application r100) {
        PluginState r101 = PluginState.INITIALIZED;
    }
}
