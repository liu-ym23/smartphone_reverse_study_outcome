package com.bytedance.geckox;

import com.bytedance.geckox.model.Resources;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class AppSettingsManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Map<String, String> f245060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Map<String, ArrayList<String>> f245061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f245062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f245063d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, List<String>> f245064e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<String> f245065f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<String> f245066g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f245067h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f245068i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f245069j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public IGeckoAppSettings f245070k;

    public interface IGeckoAppSettings {
        boolean akDirUnify();

        a getConfig();

        List<String> getGkFSAllowExt();

        List<String> getGkFSDisallowAks();

        Map<String, List<String>> getGkFSDisallowChannels();

        Map<String, Resources> getOnDemandList();

        int getOnDemandPolicy();

        boolean ignoreLock();

        boolean isForbidRequest();

        boolean isGkFSDeleteOriginFile();

        boolean isGkFSEnable();

        boolean isGkFSParallelIOEnable();

        boolean isGkFSTraversalFileNative();

        boolean isProbeEnable();

        boolean isRegisterBySPI();

        boolean isUseEncrypt();
    }

    /* JADX INFO: loaded from: classes19.dex */
    public interface a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AppSettingsManager f245071a = null;

        static {
            f245071a = new AppSettingsManager();
        }
    }

    public final IGeckoAppSettings b() {
        if (this.f245070k != null) goto L6;
        this.f245070k = (IGeckoAppSettings) ServiceManager.get().getServiceForReal(IGeckoAppSettings.class);
    L6:
        return this.f245070k;
    }

    public AppSettingsManager() {
        this.f245062c = Boolean.TRUE;
        this.f245063d = false;
        this.f245067h = true;
        this.f245068i = false;
        this.f245069j = true;
    }

    public final boolean a() {
        IGeckoAppSettings r100 = b();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.akDirUnify() == false) goto L7;
        return true;
    }
}
