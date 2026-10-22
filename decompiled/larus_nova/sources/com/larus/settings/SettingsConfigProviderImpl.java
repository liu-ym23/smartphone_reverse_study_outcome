package com.larus.settings;

import android.app.Application;
import com.bytedance.news.common.settings.SettingsConfigProvider;
import com.larus.apm.api.IApm;
import com.larus.common.apphost.AppHost;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import ft9.b;
import ft9.c;
import ft9.l;
import ft9.m;
import ft9.n;
import g37.d;
import g37.f;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/larus/settings/SettingsConfigProviderImpl;", "Lcom/bytedance/news/common/settings/SettingsConfigProvider;", "<init>", "()V", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/app/Application;", "debugTeller", "Lcom/bytedance/news/common/settings/api/DebugTeller;", "getConfig", "Lcom/bytedance/news/common/settings/SettingsConfig;", "getLazyConfig", "Lcom/bytedance/news/common/settings/SettingsLazyConfig;", "Companion", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SettingsConfigProviderImpl implements SettingsConfigProvider {
    public static final a Companion = null;
    private static final String TAG = "SettingsConfigProviderImpl";
    private final Application context;
    private final h37.a debugTeller;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ Boolean a() {
        return debugTeller$lambda$0();
    }

    private static final Boolean debugTeller$lambda$0() {
        return Boolean.valueOf(AppHost.f326268a.isTestChannel());
    }

    @Override // com.bytedance.news.common.settings.SettingsConfigProvider
    public d getConfig() {
        IApm r100 = (IApm) ServiceManager.get().getService(IApm.class);
        if (r100 == null) goto L5;
        boolean r101 = r100.isMainProcess(this.context);
    L6:
        d.a r102 = new d.a();
        r102.f479841a = this.context;
        r102.f479843c = new m();
        r102.f479851k = new n();
        r102.f479847g = new l();
        r102.f479849i = r101;
        r102.f479848h = new b();
        r102.f479850j = this.debugTeller;
        return r102.a();
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.news.common.settings.SettingsConfigProvider
    public f getLazyConfig() {
        String.valueOf(AppHost.f326268a.getUpdateVersionCode());     // Catch: Exception -> L4
    L6:
        String r100 = String.valueOf(AppHost.f326268a.getUpdateVersionCode());
        f.a r101 = new f.a();
        r101.f479864a = r100;
        return new f(r101);
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "getLazyConfig");
        e.printStackTrace();
        goto L6
    }

    public SettingsConfigProviderImpl() {
        this.context = AppHost.f326268a.getApplication();
        this.debugTeller = new c();
    }
}
