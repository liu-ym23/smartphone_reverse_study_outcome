package com.larus.dora.o.impl.diary;

import com.larus.dora.api.config.IDoraPageConfig;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes27.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f338508a = 0;

    static {
    }

    public static IDoraPageConfig a() {
        return (IDoraPageConfig) ServiceManager.get().getService(IDoraPageConfig.class);
    }
}
