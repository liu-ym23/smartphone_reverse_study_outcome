package t57;

import com.bytedance.platform.godzilla.GodzillaCore;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.PluginState;
import com.bytedance.platform.godzilla.plugin.StartType;
import p57.g;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends a implements g {
    public abstract void f();

    @Override // t57.a
    public void d() {
        PluginState r100 = PluginState.INITIALIZED;
        f();
        GodzillaCore.INSTANCE.addUncaughtExceptionConsumer(this);
        Logger.a(b(), "start called.");
    }

    public c() {
    }

    @Override // t57.a
    public final StartType e() {
        return StartType.REGISTER_EXCEPTION;
    }
}
