package com.obric.assistant.spi.app;

import android.app.Application;
import android.content.Context;
import android.util.EventsUtils;
import kotlin.Metadata;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0001H&J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH&J\u001a\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/spi/app/IObricAppService;", XmlPullParser.NO_NAMESPACE, "shouldTakeOverEarlyStartup", XmlPullParser.NO_NAMESPACE, "context", "Landroid/content/Context;", "onEarlyStartupFailed", XmlPullParser.NO_NAMESPACE, "setAgentCommonParams", "key", XmlPullParser.NO_NAMESPACE, "obj", "beforeAttachBaseContext", "afterAttachBaseContext", "application", "Landroid/app/Application;", "beforeOnCreate", "afterOnCreate", "syncColdBootSettings", "onColdBootSettingsUpdated", "appSettings", "Lorg/json/JSONObject;", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public interface IObricAppService {
    void a(Application r1);

    void b(Application r1);

    void beforeAttachBaseContext(Context r1);

    void c(Context r1);

    void d(Application r1, JSONObject r2);

    boolean e(Context r1);

    void f(Application r1);

    void g(Application r1);
}
