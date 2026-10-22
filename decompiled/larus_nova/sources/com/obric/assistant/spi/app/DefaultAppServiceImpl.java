package com.obric.assistant.spi.app;

import android.app.Application;
import android.content.Context;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016¨\u0006\u0019"}, d2 = {"Lcom/obric/assistant/spi/app/DefaultAppServiceImpl;", "Lcom/obric/assistant/spi/app/IObricAppService;", "<init>", "()V", "shouldTakeOverEarlyStartup", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "onEarlyStartupFailed", "", "setAgentCommonParams", "key", "", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "", "beforeAttachBaseContext", "afterAttachBaseContext", "application", "Landroid/app/Application;", "beforeOnCreate", "afterOnCreate", "syncColdBootSettings", "onColdBootSettingsUpdated", "appSettings", "Lorg/json/JSONObject;", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultAppServiceImpl implements IObricAppService {
    public DefaultAppServiceImpl() {
    }

    @Override // com.obric.assistant.spi.app.IObricAppService
    public final void a(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "application");
    }

    @Override // com.obric.assistant.spi.app.IObricAppService
    public final void b(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "application");
    }

    @Override // com.obric.assistant.spi.app.IObricAppService
    public final void beforeAttachBaseContext(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.obric.assistant.spi.app.IObricAppService
    public final void c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.obric.assistant.spi.app.IObricAppService
    public final void d(Application r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "application");
    }

    @Override // com.obric.assistant.spi.app.IObricAppService
    public final boolean e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return false;
    }

    @Override // com.obric.assistant.spi.app.IObricAppService
    public final void f(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "application");
    }

    @Override // com.obric.assistant.spi.app.IObricAppService
    public final void g(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "application");
    }
}
