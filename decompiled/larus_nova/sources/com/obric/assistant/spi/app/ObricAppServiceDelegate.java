package com.obric.assistant.spi.app;

import android.app.Application;
import android.content.Context;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u001b\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\u0011\u0010\u0010\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0001J\u0019\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0096\u0001J\u0011\u0010\u0016\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001¨\u0006\u0019"}, d2 = {"Lcom/obric/assistant/spi/app/ObricAppServiceDelegate;", "Lcom/obric/assistant/spi/app/IObricAppService;", "<init>", "()V", "afterAttachBaseContext", "", "application", "Landroid/app/Application;", "afterOnCreate", "beforeAttachBaseContext", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "beforeOnCreate", "onColdBootSettingsUpdated", "appSettings", "Lorg/json/JSONObject;", "onEarlyStartupFailed", "setAgentCommonParams", "key", "", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "", "shouldTakeOverEarlyStartup", "", "syncColdBootSettings", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAppServiceDelegate implements IObricAppService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricAppServiceDelegate f392824b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricAppService f392825a;

    static {
        f392824b = new ObricAppServiceDelegate();
    }

    @Override // com.obric.assistant.spi.app.IObricAppService
    public final void a(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "application");
        this.f392825a.a(r100);
    }

    @Override // com.obric.assistant.spi.app.IObricAppService
    public final void b(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "application");
        this.f392825a.b(r100);
    }

    @Override // com.obric.assistant.spi.app.IObricAppService
    public final void beforeAttachBaseContext(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f392825a.beforeAttachBaseContext(r100);
    }

    @Override // com.obric.assistant.spi.app.IObricAppService
    public final void c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f392825a.c(r100);
    }

    @Override // com.obric.assistant.spi.app.IObricAppService
    public final void d(Application r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "application");
        this.f392825a.d(r100, r101);
    }

    @Override // com.obric.assistant.spi.app.IObricAppService
    public final boolean e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f392825a.e(r100);
    }

    @Override // com.obric.assistant.spi.app.IObricAppService
    public final void f(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "application");
        this.f392825a.f(r100);
    }

    @Override // com.obric.assistant.spi.app.IObricAppService
    public final void g(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "application");
        this.f392825a.g(r100);
    }

    private ObricAppServiceDelegate() {
        IObricAppService r100 = (IObricAppService) ServiceManager.get().getService(IObricAppService.class);
        if (r100 != null) goto L5;
        r100 = new DefaultAppServiceImpl();
    L5:
        this.f392825a = r100;
    }
}
