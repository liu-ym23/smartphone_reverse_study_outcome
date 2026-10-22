package com.volcengine.zeus.plugin.preinstall;

import android.app.Application;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.volcengine.zeus.Zeus;
import java.io.File;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes41.dex */
public final class b implements Function0<Resources> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PreInstallTool f462822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ File f462823b;

    @Override // kotlin.jvm.functions.Function0
    public final Resources invoke() {
        PreInstallTool r100 = this.f462822a;
        Application r101 = Zeus.getAppApplication();
        String r102 = this.f462823b.getAbsolutePath();
        r100.getClass();
        AssetManager r103 = (AssetManager) AssetManager.class.newInstance();     // Catch: Exception -> L5
        AssetManager.class.getMethod("addAssetPath", new Class[]{String.class}).invoke(r103, new Object[]{r102});     // Catch: Exception -> L5
        Resources r104 = r101.getResources();     // Catch: Exception -> L5
        return new Resources(r103, WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()), r104.getConfiguration());
    L5:
        e = move-exception;
        throw new RuntimeException("create Resources from apk failed", e);
    }

    public b(PreInstallTool r100, PolarisFileWrapper r101) {
        this.f462822a = r100;
        this.f462823b = r101;
    }
}
