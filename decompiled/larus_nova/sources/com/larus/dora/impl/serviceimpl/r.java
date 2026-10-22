package com.larus.dora.impl.serviceimpl;

import com.larus.dora.api.config.IDoraPageConfig;
import com.larus.dora.impl.device.settings.lab.env.DoraEnvObserveManager;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class r {

    public static final class a {
    }

    static {
    }

    public r() {
    }

    public final boolean b() {
        IDoraPageConfig r100 = (IDoraPageConfig) o49.b.f522007b.a().f522009a.getValue();
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.d("dora_g_config_key_env_observe_enable", false);
    }

    public final boolean c() {
        DoraEnvObserveManager.f334593a.getClass();
        return DoraEnvObserveManager.c();
    }

    public final void a(u39.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        DoraEnvObserveManager.f334593a.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((CopyOnWriteArraySet) DoraEnvObserveManager.f334594b.getValue()).add(r100);
    }

    public final void d(u39.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        DoraEnvObserveManager.f334593a.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((CopyOnWriteArraySet) DoraEnvObserveManager.f334594b.getValue()).remove(r100);
    }

    public final int e(int r100) {
        int r101 = yj4.g.f568093a;
        yj4.f.a.f568092a.getClass();
        return yj4.h.C2.i(1, 4, new byte[]{24, 1, (byte) r100});
    }
}
