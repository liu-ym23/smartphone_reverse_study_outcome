package com.obric.assistant.spi.app;

import android.app.Application;
import android.content.Context;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0001H&J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH&J\u001a\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/spi/app/IObricAppService;", "", "shouldTakeOverEarlyStartup", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "onEarlyStartupFailed", "", "setAgentCommonParams", "key", "", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "beforeAttachBaseContext", "afterAttachBaseContext", "application", "Landroid/app/Application;", "beforeOnCreate", "afterOnCreate", "syncColdBootSettings", "onColdBootSettingsUpdated", "appSettings", "Lorg/json/JSONObject;", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricAppService {
    void a(Application r100);

    void b(Application r100);

    void beforeAttachBaseContext(Context r100);

    void c(Context r100);

    void d(Application r100, JSONObject r101);

    boolean e(Context r100);

    void f(Application r100);

    void g(Application r100);
}
