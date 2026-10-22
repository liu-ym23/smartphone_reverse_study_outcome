package com.bytedance.iesgurd.settings;

import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.settings.model.GlobalConfigSettings;
import com.bytedance.iesgurd.core.ReqType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements xy5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f250846a = null;

    static {
        f250846a = new a();
    }

    public a() {
    }

    @Override // xy5.b
    public final void execute() {
        GeckoLogger.d("sync global settings retry");
        GlobalConfigSettings r100 = GlobalSettingsManager.f250833a;
        ReqType r101 = GlobalSettingsManager.f250841i;
        if (r101 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        GlobalSettingsManager.c(r101, true);
    }
}
