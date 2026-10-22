package com.obric.assistant.settings;

import android.util.EventsUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H¦@¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0006H¦@¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH&J\u001a\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u000eH&J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u001b\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010\u0004J\u000e\u0010\u001d\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/obric/assistant/settings/IObricAutoGuiSettingsApi;", XmlPullParser.NO_NAMESPACE, "getAutoActionAppBlacklistFromCloudAndOs", "Lcom/obric/assistant/settings/AutoActionAppDataSource;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppSoftBlacklistFromCloud", XmlPullParser.NO_NAMESPACE, "Lcom/obric/assistant/settings/ObricAppBlacklistItem;", "getAutoActionAppFilterPolicyForRecommendation", "Lcom/obric/assistant/settings/AutoActionAppFilterPolicy;", "getAutoActionAppBlacklistFromOs", "getAutoActionAvailableAppPermissionFromUser", "Lcom/obric/assistant/settings/AutoActionBlacklistByUserItem;", "onlyReturnWhiteList", XmlPullParser.NO_NAMESPACE, "isClientOnly", "(ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAutoActionAppBlacklistFromUser", "setAppState", XmlPullParser.NO_NAMESPACE, "packageName", XmlPullParser.NO_NAMESPACE, "isEnable", "getAppState", "defVal", "onAppUninstalled", "onAppInstalled", "getAutoActionMergedBlacklistForSystemSettings", "Lcom/obric/assistant/settings/SystemSettingsAppListResult;", "getAutoActionA16UserAvailableApps", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public interface IObricAutoGuiSettingsApi {
    Object a(boolean r1, boolean r2, Continuation<? super List<e>> r3);

    Object b(Continuation<? super d> r1);

    Object c(Continuation<? super h1> r1);

    void d(String r1);

    boolean e(String r1, boolean r2);

    Object f(Continuation<? super h1> r1);

    void g(String r1);

    void h(String r1, boolean r2);

    Object i(Continuation<? super c> r1);

    Object j(Continuation<? super List<e>> r1);
}
