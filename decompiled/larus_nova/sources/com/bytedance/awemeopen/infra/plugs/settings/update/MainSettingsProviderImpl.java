package com.bytedance.awemeopen.infra.plugs.settings.update;

import com.bytedance.awemeopen.infra.base.task.AoPool;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ2\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/awemeopen/infra/plugs/settings/update/MainSettingsProviderImpl;", "", "()V", "clearMockSettings", "", "bdpAppId", "", "key", "isSettingMocked", "", "setMockSettings", "settings", "Lorg/json/JSONObject;", "updateSettings", "params", "", "force", "from", "ao_plugin_settings_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MainSettingsProviderImpl {
    public static final MainSettingsProviderImpl INSTANCE = null;

    static {
        INSTANCE = new MainSettingsProviderImpl();
    }

    private MainSettingsProviderImpl() {
    }

    public final void clearMockSettings(String r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "bdpAppId");
        final BdpMainSettingsUpdater r102 = BdpMainSettingsUpdater.f198890l.a(r100);
        AoPool.a(new BdpMainSettingsUpdater$clearMockSettings$1(r101, r102));
    }

    public final boolean isSettingMocked(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "bdpAppId");
        Intrinsics.checkNotNullParameter(r101, "key");
        BdpMainSettingsUpdater r102 = BdpMainSettingsUpdater.f198890l.a(r100);
        Intrinsics.checkNotNullParameter(r101, "key");
        return r102.f().containsKey(r101);
    }

    public final void setMockSettings(String r100, final String r101, final JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "bdpAppId");
        Intrinsics.checkNotNullParameter(r101, "key");
        final BdpMainSettingsUpdater r103 = BdpMainSettingsUpdater.f198890l.a(r100);
        Intrinsics.checkNotNullParameter(r101, "key");
        AoPool.a(new BdpMainSettingsUpdater$mockSettings$1(r102, r103, r101));
    }

    public final void updateSettings(String r100, final Map<String, String> r101, final boolean r102, final String r103) {
        Intrinsics.checkNotNullParameter(r100, "bdpAppId");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r103, "from");
        final BdpMainSettingsUpdater r104 = BdpMainSettingsUpdater.f198890l.a(r100);
        Intrinsics.checkNotNullParameter(r101, "queryParams");
        Intrinsics.checkNotNullParameter(r103, "from");
        AoPool.a(new BdpMainSettingsUpdater$updateSettings$1(r104, r102, r103, r101));
    }
}
