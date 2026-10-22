package com.larus.ivykit;

import com.bytedance.geckox.AppSettingsManager;
import com.bytedance.geckox.model.Resources;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\b\u0010\u0016\u001a\u00020\u000fH\u0016J\u001a\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00180\u0004H\u0016J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0016J\b\u0010\u001c\u001a\u00020\u000fH\u0016J\b\u0010\u001d\u001a\u00020\u000fH\u0016J\b\u0010\u001e\u001a\u00020\u000fH\u0016R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/ivykit/GeckoOnDemandAppSettings;", "Lcom/bytedance/geckox/AppSettingsManager$IGeckoAppSettings;", "delegate", "resources", "", "", "Lcom/bytedance/geckox/model/Resources;", "<init>", "(Lcom/bytedance/geckox/AppSettingsManager$IGeckoAppSettings;Ljava/util/Map;)V", "getDelegate$ivykit_mainlandRelease", "()Lcom/bytedance/geckox/AppSettingsManager$IGeckoAppSettings;", "getOnDemandPolicy", "", "getOnDemandList", "isUseEncrypt", "", "getConfig", "Lcom/bytedance/geckox/AppSettingsManager$IClientIntelligenceConfig;", "isProbeEnable", "isGkFSEnable", "isGkFSDeleteOriginFile", "isGkFSTraversalFileNative", "isGkFSParallelIOEnable", "getGkFSDisallowChannels", "", "getGkFSDisallowAks", "getGkFSAllowExt", "isRegisterBySPI", "isForbidRequest", "ignoreLock", "akDirUnify", "ivykit_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GeckoOnDemandAppSettings implements AppSettingsManager.IGeckoAppSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppSettingsManager.IGeckoAppSettings f351612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Resources> f351613b;

    @Override // com.bytedance.geckox.AppSettingsManager.IGeckoAppSettings
    public final int getOnDemandPolicy() {
        return 1;
    }

    @Override // com.bytedance.geckox.AppSettingsManager.IGeckoAppSettings
    public final boolean akDirUnify() {
        AppSettingsManager.IGeckoAppSettings r100 = this.f351612a;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.akDirUnify();
    }

    @Override // com.bytedance.geckox.AppSettingsManager.IGeckoAppSettings
    public final AppSettingsManager.a getConfig() {
        AppSettingsManager.IGeckoAppSettings r100 = this.f351612a;
        if (r100 == null) goto L7;
        r100.getConfig();
        return null;
    L7:
        return null;
    }

    @Override // com.bytedance.geckox.AppSettingsManager.IGeckoAppSettings
    public final List<String> getGkFSAllowExt() {
        AppSettingsManager.IGeckoAppSettings r100 = this.f351612a;
        if (r100 == null) goto L5;
        List<String> r101 = r100.getGkFSAllowExt();
    L6:
        if (r101 == null) goto L8;
        return r101;
    L8:
        return CollectionsKt.emptyList();
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.geckox.AppSettingsManager.IGeckoAppSettings
    public final List<String> getGkFSDisallowAks() {
        AppSettingsManager.IGeckoAppSettings r100 = this.f351612a;
        if (r100 == null) goto L5;
        List<String> r101 = r100.getGkFSDisallowAks();
    L6:
        if (r101 == null) goto L8;
        return r101;
    L8:
        return CollectionsKt.emptyList();
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.geckox.AppSettingsManager.IGeckoAppSettings
    public final Map<String, List<String>> getGkFSDisallowChannels() {
        AppSettingsManager.IGeckoAppSettings r100 = this.f351612a;
        if (r100 == null) goto L5;
        Map<String, List<String>> r101 = r100.getGkFSDisallowChannels();
    L6:
        if (r101 == null) goto L8;
        return r101;
    L8:
        return MapsKt.emptyMap();
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.geckox.AppSettingsManager.IGeckoAppSettings
    public final boolean ignoreLock() {
        AppSettingsManager.IGeckoAppSettings r100 = this.f351612a;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.ignoreLock();
    }

    @Override // com.bytedance.geckox.AppSettingsManager.IGeckoAppSettings
    public final boolean isForbidRequest() {
        AppSettingsManager.IGeckoAppSettings r100 = this.f351612a;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isForbidRequest();
    }

    @Override // com.bytedance.geckox.AppSettingsManager.IGeckoAppSettings
    public final boolean isGkFSDeleteOriginFile() {
        AppSettingsManager.IGeckoAppSettings r100 = this.f351612a;
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.isGkFSDeleteOriginFile();
    }

    @Override // com.bytedance.geckox.AppSettingsManager.IGeckoAppSettings
    public final boolean isGkFSEnable() {
        AppSettingsManager.IGeckoAppSettings r100 = this.f351612a;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isGkFSEnable();
    }

    @Override // com.bytedance.geckox.AppSettingsManager.IGeckoAppSettings
    public final boolean isGkFSParallelIOEnable() {
        AppSettingsManager.IGeckoAppSettings r100 = this.f351612a;
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.isGkFSParallelIOEnable();
    }

    @Override // com.bytedance.geckox.AppSettingsManager.IGeckoAppSettings
    public final boolean isGkFSTraversalFileNative() {
        AppSettingsManager.IGeckoAppSettings r100 = this.f351612a;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isGkFSTraversalFileNative();
    }

    @Override // com.bytedance.geckox.AppSettingsManager.IGeckoAppSettings
    public final boolean isProbeEnable() {
        AppSettingsManager.IGeckoAppSettings r100 = this.f351612a;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isProbeEnable();
    }

    @Override // com.bytedance.geckox.AppSettingsManager.IGeckoAppSettings
    public final boolean isRegisterBySPI() {
        AppSettingsManager.IGeckoAppSettings r100 = this.f351612a;
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.isRegisterBySPI();
    }

    @Override // com.bytedance.geckox.AppSettingsManager.IGeckoAppSettings
    public final boolean isUseEncrypt() {
        AppSettingsManager.IGeckoAppSettings r100 = this.f351612a;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isUseEncrypt();
    }

    @Override // com.bytedance.geckox.AppSettingsManager.IGeckoAppSettings
    public final Map<String, Resources> getOnDemandList() {
        return this.f351613b;
    }

    public GeckoOnDemandAppSettings(AppSettingsManager.IGeckoAppSettings r100, Map<String, Resources> r101) {
        Intrinsics.checkNotNullParameter(r101, "resources");
        this.f351612a = r100;
        this.f351613b = r101;
    }
}
