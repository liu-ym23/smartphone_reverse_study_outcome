package com.larus.dora.impl.config;

import com.larus.account.base.api.ILoginService;
import com.larus.dora.api.config.IDoraPageConfig;
import com.larus.dora.impl.util.b0;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import u39.c;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u001a\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0002J\"\u0010\u0017\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0013\u001a\u00020\fH\u0016J\"\u0010\u0018\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0019\u001a\u00020\fH\u0016J\u001a\u0010\u001a\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010\u001b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\fH\u0016J\u0018\u0010\u001c\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\fH\u0016J\u0018\u0010\u001d\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000eH\u0016J\u0018\u0010\u001f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000eH\u0016J\u0018\u0010 \u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000eH\u0016J\u0018\u0010!\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000eH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/dora/impl/config/DoraPageConfigServiceImpl;", "Lcom/larus/dora/api/config/IDoraPageConfig;", "<init>", "()V", "mConfigChangeListener", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/larus/dora/api/annotation/IPageConfigChangeListener;", "registerConfigChangeListener", "", "listener", "unRegisterConfigChangeListener", "containKey", "", "key", "", "containKeyWithUid", "removeKey", "removeKeyWithUid", "setSettingsEnable", "enable", "setSettingsEnableWithUid", "deviceScopedKey", "mac", "setSettingsEnableWithUidAndDevice", "getSettingsEnableWithUidAndDevice", "default", "removeSettingsWithUidAndDevice", "getSettingsEnable", "getSettingsEnableWithUid", "setSettingsString", "value", "setSettingsStringWithUid", "getSettingsString", "getSettingsStringWithUid", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraPageConfigServiceImpl implements IDoraPageConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet<c> f332121a;

    public DoraPageConfigServiceImpl() {
        this.f332121a = new CopyOnWriteArraySet();
    }

    public static String j(String r100) {
        String r101 = "dora_g_config_key_env_observe_local_enabled_" + ILoginService.f286097a.getAccountInfo().f531530c;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        return r101;
    L12:
        return r101 + '_' + r100;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.larus.dora.api.config.IDoraPageConfig
    public final boolean b(boolean r100) {
        Intrinsics.checkNotNullParameter("dora_g_config_key_visual_sound_enable", "key");
        b0.f338123a.getClass();
        return b0.j().getBoolean("dora_g_config_key_visual_sound_enable", r100);
    }

    @Override // com.larus.dora.api.config.IDoraPageConfig
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter("dora_g_config_key_env_observe_local_enabled", "key");
        b0.f338123a.getClass();
        b0.j().storeBoolean(j(r100), true);
    }

    @Override // com.larus.dora.api.config.IDoraPageConfig
    public final boolean g(String r100) {
        Intrinsics.checkNotNullParameter("dora_g_config_key_env_observe_local_enabled", "key");
        b0.f338123a.getClass();
        return b0.j().getBoolean(j(r100), false);
    }

    @Override // com.larus.dora.api.config.IDoraPageConfig
    public final void h(String r100) {
        Intrinsics.checkNotNullParameter("dora_g_config_key_env_observe_local_enabled", "key");
        b0.f338123a.getClass();
        b0.j().erase(j(r100));
    }

    @Override // com.larus.dora.api.config.IDoraPageConfig
    public final void i(boolean r100) {
        Intrinsics.checkNotNullParameter("dora_g_config_key_visual_sound_enable", "key");
        b0.f338123a.getClass();
        boolean r101 = b0.j().getBoolean("dora_g_config_key_visual_sound_enable", false);
        b0.j().storeBoolean("dora_g_config_key_visual_sound_enable", r100);
        if (b0.j().contains("dora_g_config_key_visual_sound_enable") == false) goto L9;
        if (r101 == r100) goto L11;
        Iterator<c> r102 = this.f332121a.iterator();
    L7:
        if (r102.hasNext() == false) goto L12;
        r102.next().a();
        goto L7
    L12:
        return;
    L11:
        return;
    }

    @Override // com.larus.dora.api.config.IDoraPageConfig
    public final void a(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        String r102 = r100 + '_' + ILoginService.f286097a.getAccountInfo().f531530c;
        b0.f338123a.getClass();
        b0.j().storeBoolean(r102, r101);
    }

    @Override // com.larus.dora.api.config.IDoraPageConfig
    public final boolean d(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        b0.f338123a.getClass();
        return b0.j().getBoolean(r100 + '_' + ILoginService.f286097a.getAccountInfo().f531530c, r101);
    }

    @Override // com.larus.dora.api.config.IDoraPageConfig
    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        String r102 = r100 + '_' + ILoginService.f286097a.getAccountInfo().f531530c;
        b0.f338123a.getClass();
        b0.j().storeString(r102, r101);
    }

    @Override // com.larus.dora.api.config.IDoraPageConfig
    public final String f(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "default");
        b0.f338123a.getClass();
        return b0.j().getString(r100 + '_' + ILoginService.f286097a.getAccountInfo().f531530c, r101);
    }
}
