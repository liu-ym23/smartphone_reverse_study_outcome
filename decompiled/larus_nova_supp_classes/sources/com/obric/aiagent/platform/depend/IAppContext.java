package com.obric.aiagent.platform.depend;

import android.app.Application;
import android.content.Context;
import android.util.EventsUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\bg\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0007H&J\b\u0010\u0011\u001a\u00020\nH&J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016¨\u0006\u001c"}, d2 = {"Lcom/obric/aiagent/platform/depend/IAppContext;", XmlPullParser.NO_NAMESPACE, "getApplication", "Landroid/app/Application;", "getContext", "Landroid/content/Context;", "getAppId", XmlPullParser.NO_NAMESPACE, "getOldAiagentAppId", "getMsSdkLicense", XmlPullParser.NO_NAMESPACE, "getAppName", "getAppStringName", "getPackageName", "isDebug", XmlPullParser.NO_NAMESPACE, "getVersionCode", "getVersionName", "getManifestVersionCode", "getManifestVersionName", "getUpdateVersionCode", "getCurrentTimeMillis", XmlPullParser.NO_NAMESPACE, "getBuildChannel", "isTestChannel", "isDebugChannel", "isReleaseChannel", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public interface IAppContext {
    public static final Companion a = null;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u000bH\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\b\u0010\u001a\u001a\u00020\u000bH\u0016J\b\u0010\u001b\u001a\u00020\u000eH\u0016J\b\u0010\u001c\u001a\u00020\u000bH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u000eH\u0016J\b\u0010 \u001a\u00020\u0017H\u0016J\b\u0010!\u001a\u00020\u0017H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006#"}, d2 = {"Lcom/obric/aiagent/platform/depend/IAppContext$Companion;", "Lcom/obric/aiagent/platform/depend/IAppContext;", "<init>", "()V", "cachedImpl", "impl", "getImpl", "()Lcom/obric/aiagent/platform/depend/IAppContext;", "impl$delegate", "Lkotlin/Lazy;", "getAppId", XmlPullParser.NO_NAMESPACE, "getOldAiagentAppId", "getMsSdkLicense", XmlPullParser.NO_NAMESPACE, "getApplication", "Landroid/app/Application;", "getContext", "Landroid/content/Context;", "getAppName", "getAppStringName", "getPackageName", "isDebug", XmlPullParser.NO_NAMESPACE, "getVersionCode", "getVersionName", "getManifestVersionCode", "getManifestVersionName", "getUpdateVersionCode", "getCurrentTimeMillis", XmlPullParser.NO_NAMESPACE, "getBuildChannel", "isTestChannel", "isDebugChannel", "isReleaseChannel", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
    public static final class Companion implements IAppContext {
        public static final /* synthetic */ Companion b = null;
        public static final Lazy<IAppContext> c = null;

        private Companion() {
        }

        static {
            b = new Companion();
            c = LazyKt.lazy(new s9a.a());
        }

        public static IAppContext a() {
            return c.getValue();
        }

        @Override // com.obric.aiagent.platform.depend.IAppContext
        public final String getAppName() {
            IAppContext r0 = a();
            if (r0 == null) goto L5;
            String r1 = r0.getAppName();
        L6:
            if (r1 != null) goto L9;
            return XmlPullParser.NO_NAMESPACE;
        L9:
            return r1;
        L5:
            r1 = null;
            goto L6
        }

        @Override // com.obric.aiagent.platform.depend.IAppContext
        public final Application getApplication() {
            IAppContext r0 = a();
            if (r0 == null) goto L8;
            Application r1 = r0.getApplication();
            if (r1 == null) goto L8;
            return r1;
        L8:
            throw new RuntimeException("IAppContext not initialized");
        }

        @Override // com.obric.aiagent.platform.depend.IAppContext
        public Context getContext() {
            IAppContext r0 = a();
            if (r0 == null) goto L7;
            Context r1 = r0.getContext();
            if (r1 == null) goto L7;
            return r1;
        L7:
            return getApplication();
        }

        @Override // com.obric.aiagent.platform.depend.IAppContext
        public final String getPackageName() {
            IAppContext r0 = a();
            if (r0 == null) goto L7;
            String r1 = r0.getPackageName();
            if (r1 == null) goto L7;
            return r1;
        L7:
            return getApplication().getPackageName();
        }

        @Override // com.obric.aiagent.platform.depend.IAppContext
        public final int getVersionCode() {
            IAppContext r0 = a();
            if (r0 == null) goto L6;
            return r0.getVersionCode();
        L6:
            return getApplication().getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
        }

        @Override // com.obric.aiagent.platform.depend.IAppContext
        public final String getVersionName() {
            IAppContext r0 = a();
            if (r0 == null) goto L6;
            String r1 = r0.getVersionName();
            if (r1 == null) goto L6;
            return r1;
        L6:
            String r2 = getApplication().getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            if (r2 != null) goto L11;
            return XmlPullParser.NO_NAMESPACE;
        L11:
            return r2;
        }

        @Override // com.obric.aiagent.platform.depend.IAppContext
        public final boolean isDebugChannel() {
            IAppContext r0 = a();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.isDebugChannel();
        }

        @Override // com.obric.aiagent.platform.depend.IAppContext
        public final boolean isTestChannel() {
            IAppContext r0 = a();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.isTestChannel();
        }
    }

    static {
        a = Companion.b;
    }

    String getAppName();

    Application getApplication();

    Context getContext();

    String getPackageName();

    int getVersionCode();

    String getVersionName();

    boolean isDebugChannel();

    boolean isTestChannel();
}
