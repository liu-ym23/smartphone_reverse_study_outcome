package com.ss.android.lark.featuregating;

import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.ss.android.lark.featuregating.interfaces.IFeatureGatingService;
import com.ss.android.lark.log.Log;
import dagger.hilt.EntryPoints;
import dagger.hilt.dwarf.spi.DwarfSPIEntryPoint;
import idb.d;
import idb.f;
import java.util.List;
import jdb.e;

/* JADX INFO: loaded from: classes35.dex */
public class FeatureGatingModule {
    private static final String TAG = "FeatureGatingModule";
    private static volatile fdb.b sDependency;

    private static void ensureFeatureGatingInited() {
        if (sDependency == null) goto L5;
        return;
    L5:
        monitor-enter(FeatureGatingModule.class);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (sDependency != null) goto L12;
        fdb.a r100 = (fdb.a) ClaymoreServiceLoader.loadFirstOrNull(fdb.a.class);     // Catch: Throwable -> L14
        if (r100 == null) goto L11;
        Log.i(TAG, "dependencyProvider != null");     // Catch: Throwable -> L14
        sDependency = r100.getDependency();     // Catch: Throwable -> L14
        goto L12
    L11:
        Log.i(TAG, "dependencyProvider == null");     // Catch: Throwable -> L14
    L12:
        monitor-exit(FeatureGatingModule.class);     // Catch: Throwable -> L14
    }

    public static List<String> getAllFeaturesKeys() {
        ensureFeatureGatingInited();
        return d.a();
    }

    public static fdb.b getDependency() {
        ensureFeatureGatingInited();
        return sDependency;
    }

    public static IFeatureGatingService getFeatureGatingService() {
        ensureFeatureGatingInited();
        return f.a();
    }

    public static e getGlobalFeatureGatingService() {
        return (e) ((DwarfSPIEntryPoint) EntryPoints.get(getDependency().getContext(), DwarfSPIEntryPoint.class)).dwarfSPI().get(e.class);
    }

    private FeatureGatingModule() {
    }

    public static Boolean getDefault(String r100) {
        ensureFeatureGatingInited();
        return d.b(r100);
    }
}
