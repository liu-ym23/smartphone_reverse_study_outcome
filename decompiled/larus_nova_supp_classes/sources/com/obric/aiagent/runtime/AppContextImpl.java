package com.obric.aiagent.runtime;

import android.app.Application;
import android.content.Context;
import android.util.EventsUtils;
import com.larus.common.apphost.AppHost;
import com.obric.aiagent.platform.depend.IAppContext;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016¨\u0006\u0017"}, d2 = {"Lcom/obric/aiagent/runtime/AppContextImpl;", "Lcom/obric/aiagent/platform/depend/IAppContext;", "<init>", "()V", "getApplication", "Landroid/app/Application;", "getAppName", XmlPullParser.NO_NAMESPACE, "getAppStringName", "getPackageName", "isDebug", XmlPullParser.NO_NAMESPACE, "getVersionCode", XmlPullParser.NO_NAMESPACE, "getVersionName", "getManifestVersionCode", "getManifestVersionName", "getUpdateVersionCode", "getCurrentTimeMillis", XmlPullParser.NO_NAMESPACE, "getBuildChannel", "isTestChannel", "isDebugChannel", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class AppContextImpl implements IAppContext {
    public AppContextImpl() {
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public final String getAppName() {
        return AppHost.a.getAppName();
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public final Application getApplication() {
        return AppHost.a.getApplication();
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public final String getPackageName() {
        return AppHost.a.getApplication().getPackageName();
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public final int getVersionCode() {
        return AppHost.a.getVersionCode();
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public final String getVersionName() {
        return AppHost.a.getVersionName();
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public final boolean isDebugChannel() {
        return AppHost.a.isDebugChannel();
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public final boolean isTestChannel() {
        return AppHost.a.isTestChannel();
    }

    @Override // com.obric.aiagent.platform.depend.IAppContext
    public Context getContext() {
        return IAppContext.a.getContext(this);
    }
}
