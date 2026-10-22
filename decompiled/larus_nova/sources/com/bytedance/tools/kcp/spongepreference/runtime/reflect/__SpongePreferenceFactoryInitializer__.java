package com.bytedance.tools.kcp.spongepreference.runtime.reflect;

import com.bytedance.android.live.revenue.RevenueInitializer;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/bytedance/tools/kcp/spongepreference/runtime/reflect/__SpongePreferenceFactoryInitializer__;", "", "()V", "init", "", "revenue-integration_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class __SpongePreferenceFactoryInitializer__ {
    public static final __SpongePreferenceFactoryInitializer__ INSTANCE = null;

    private __SpongePreferenceFactoryInitializer__() {
    }

    static {
        INSTANCE = new __SpongePreferenceFactoryInitializer__();
    }

    @JvmStatic
    public static final void init() {
        RevenueInitializer.INSTANCE.ensureInitialized();
    }
}
