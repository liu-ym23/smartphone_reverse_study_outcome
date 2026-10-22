package com.obric.assistant.spi.app;

import android.app.Application;
import android.content.Context;
import android.util.EventsUtils;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u001b\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\u0011\u0010\u0010\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0001J\u0019\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0096\u0001J\u0011\u0010\u0016\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001¨\u0006\u0019"}, d2 = {"Lcom/obric/assistant/spi/app/ObricAppServiceDelegate;", "Lcom/obric/assistant/spi/app/IObricAppService;", "<init>", "()V", "afterAttachBaseContext", XmlPullParser.NO_NAMESPACE, "application", "Landroid/app/Application;", "afterOnCreate", "beforeAttachBaseContext", "context", "Landroid/content/Context;", "beforeOnCreate", "onColdBootSettingsUpdated", "appSettings", "Lorg/json/JSONObject;", "onEarlyStartupFailed", "setAgentCommonParams", "key", XmlPullParser.NO_NAMESPACE, "obj", XmlPullParser.NO_NAMESPACE, "shouldTakeOverEarlyStartup", XmlPullParser.NO_NAMESPACE, "syncColdBootSettings", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class ObricAppServiceDelegate implements IObricAppService {
    public static final ObricAppServiceDelegate b = null;
    public final /* synthetic */ IObricAppService a;

    static {
        b = new ObricAppServiceDelegate();
    }

    @Override // com.obric.assistant.spi.app.IObricAppService
    public final void a(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        this.a.a(r2);
    }

    @Override // com.obric.assistant.spi.app.IObricAppService
    public final void b(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        this.a.b(r2);
    }

    @Override // com.obric.assistant.spi.app.IObricAppService
    public final void beforeAttachBaseContext(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a.beforeAttachBaseContext(r2);
    }

    @Override // com.obric.assistant.spi.app.IObricAppService
    public final void c(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a.c(r2);
    }

    @Override // com.obric.assistant.spi.app.IObricAppService
    public final void d(Application r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "application");
        this.a.d(r2, r3);
    }

    @Override // com.obric.assistant.spi.app.IObricAppService
    public final boolean e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return this.a.e(r2);
    }

    @Override // com.obric.assistant.spi.app.IObricAppService
    public final void f(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        this.a.f(r2);
    }

    @Override // com.obric.assistant.spi.app.IObricAppService
    public final void g(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        this.a.g(r2);
    }

    private ObricAppServiceDelegate() {
        DefaultAppServiceImpl r0 = (IObricAppService) ServiceManager.get().getService(IObricAppService.class);
        if (r0 != null) goto L5;
        r0 = new DefaultAppServiceImpl();
    L5:
        this.a = r0;
    }
}
