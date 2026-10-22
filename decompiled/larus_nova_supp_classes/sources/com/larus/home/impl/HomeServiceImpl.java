package com.larus.home.impl;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import android.util.EventsUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import ci8.a;
import com.bytedance.keva.Keva;
import com.bytedance.keva.KevaPreloadHolder;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.auth.c1;
import com.larus.bmhome.auth.e0;
import com.larus.bmhome.chat.ChatActivity;
import com.larus.bmhome.chat.ChatDoubleTabFragment;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.bean.PageType;
import com.larus.bmhome.chat.d4;
import com.larus.bmhome.chat.immerse.ChatImmersFragment;
import com.larus.bmhome.chat.model.repo.INotifyService;
import com.larus.common.apphost.AppHost;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.larus.home.api.main.AppIconsType;
import com.larus.home.api.main.IHomeApi;
import com.larus.home.impl.chat.multi_tab.ChatMultiTabFragment;
import com.larus.home.impl.main.side_bar.MainSideBarFragment;
import com.larus.home.impl.main.tab.MainTabFragment;
import com.larus.home.impl.main.tab.config.BottomTabConfigManager;
import com.larus.home.impl.main.tab.utils.MiddleTabUIHelper;
import com.larus.home.impl.privacy.PrivacyWebViewActivity;
import com.larus.home.impl.reddot.UpdateRedDotManager;
import com.larus.home.impl.reddot.b;
import com.larus.home.impl.reddot.c;
import com.larus.home.impl.reddot.d;
import com.larus.home.impl.state.UpdateClientStateManager;
import com.larus.home.impl.utils.NeedInterceptRouterUtils;
import com.larus.home.impl.utils.e;
import com.larus.home.impl.utils.m;
import com.larus.home.impl.view.phone.PhoneNumInteractDialog;
import com.larus.home.obric.ObricChatActivity;
import com.larus.im.bean.message.Message;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.IShortcutPlatformService;
import com.larus.platform.exp.p;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.o;
import com.larus.platform.service.z2;
import com.larus.settings.value.do;
import com.larus.settings.value.e10;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.voice.base.MainTabFragmentAction;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.provider.ContentProviderManager;
import dc9.g;
import dc9.h;
import ec9.b0;
import ec9.i;
import hc9.k;
import hc9.l;
import hq9.d1;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\u0017H\u0016J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u001eH\u0016J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u001eH\u0016J\b\u0010(\u001a\u00020\u0017H\u0016J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010*\u001a\u00020\u0017H\u0016J\u0010\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020\u0017H\u0016J\u0018\u0010/\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u00100\u001a\u00020\u0005H\u0016J\u0010\u00101\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u00102\u001a\u00020\u0017H\u0016J\b\u00103\u001a\u00020\u0017H\u0016J\b\u00104\u001a\u00020\u0017H\u0016J\b\u00105\u001a\u00020\u0017H\u0016J\u0010\u00106\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u0010H\u0016J\b\u00108\u001a\u00020\u0017H\u0016J\b\u00109\u001a\u00020\u0017H\u0016J\u0017\u0010:\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0002\u0010;J\u0014\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH\u0016J\u0014\u0010=\u001a\u0004\u0018\u00010\u00052\b\u0010>\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010?\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010@\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010>\u001a\u00020\nH\u0016J*\u0010A\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00152\u000e\u0010B\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050C2\b\u00107\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010D\u001a\u00020\u0017H\u0002J\b\u0010E\u001a\u00020\u0017H\u0002J\n\u0010F\u001a\u0004\u0018\u00010GH\u0016J\u0010\u0010H\u001a\u00020\u00172\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010I\u001a\u00020\u0010H\u0002J\u0010\u0010J\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010K\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010L\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010M\u001a\u0004\u0018\u00010\u0005H\u0002J\u0014\u0010N\u001a\u0004\u0018\u00010O2\b\u0010P\u001a\u0004\u0018\u00010QH\u0016J\u0012\u0010R\u001a\u0004\u0018\u00010O2\u0006\u0010S\u001a\u00020QH\u0016J\b\u0010T\u001a\u00020\u0010H\u0016J\b\u0010U\u001a\u00020\u0010H\u0016J\b\u0010V\u001a\u00020\u0010H\u0016J\b\u0010W\u001a\u00020\u0017H\u0016J\u0010\u0010X\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010Y\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010Z\u001a\u00020\u0010H\u0016J\u0010\u0010[\u001a\u00020\u00172\u0006\u0010\\\u001a\u00020%H\u0016J\b\u0010]\u001a\u00020\u0010H\u0016J\b\u0010^\u001a\u00020\u0005H\u0016J\u001f\u0010_\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010`\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010aJ\u0010\u0010b\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010c\u001a\u00020\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\n\u0010d\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010e\u001a\u00020\u0017H\u0002J\u0010\u0010f\u001a\u00020\u00172\u0006\u0010g\u001a\u00020\u0010H\u0016J\u0012\u0010h\u001a\u00020\u00102\b\u0010i\u001a\u0004\u0018\u00010jH\u0016J\u001a\u0010k\u001a\u00020\u00172\b\u0010i\u001a\u0004\u0018\u00010j2\u0006\u0010l\u001a\u00020mH\u0016J\u001c\u0010n\u001a\u00020\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010o\u001a\u0004\u0018\u00010pH\u0016J\u0018\u0010q\u001a\u00020\u00172\u0006\u0010r\u001a\u00020\u00052\u0006\u0010s\u001a\u00020tH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006u"}, d2 = {"Lcom/larus/home/impl/HomeServiceImpl;", "Lcom/larus/home/api/main/IHomeApi;", "<init>", "()V", "TAG", XmlPullParser.NO_NAMESPACE, "getTAG", "()Ljava/lang/String;", "appIconsActivityMap", XmlPullParser.NO_NAMESPACE, "Lcom/larus/home/api/main/AppIconsType;", "iconMap", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "launcherActivityMap", "tryUpdateLauncherActivityExecuted", XmlPullParser.NO_NAMESPACE, "packageInfo", "Landroid/content/pm/PackageInfo;", "ensurePackageInfo", "context", "Landroid/content/Context;", "setMainTabViewGenerator", XmlPullParser.NO_NAMESPACE, "getChatActivityClassName", "getObricChatActivityClassName", "preloadMainTabView", "initAppStartTime", "initAppRealInitTime", "getAppRealInitTime", XmlPullParser.NO_NAMESPACE, "()Ljava/lang/Long;", "recordAppAttachEnd", "recordAppOnCreate", "startMillis", "reportAppFeedShow", "data", "Lorg/json/JSONObject;", "asyncReportPrivacyPoliceShow", "duration", "tryReportPrivacyDialogShow", "applicationAttachBeforeSuper", "applicationAttachAfterSuper", "applicationCreateBeforeSuper", "application", "Landroid/app/Application;", "applicationCreateAfterSuper", "initSystemLoadLibraryHook", "versionName", "checkMiddleTabLottieAndDownloadIfNecessary", "initUpdateClientStateManager", "registerUpdateRedDotManagerListener", "initPadController", "initPreloadMessages", "setDecorViewLancetEnable", "enable", "initBottomTabConfig", "setIsFromLogin", "getCurrentAppIconId", "(Landroid/content/Context;)Ljava/lang/Integer;", "getAvailableIcons", "getAppIconClickEventId", "appIconsType", "findCurrentShowAppIcon", "changeAppIcon", "changeLauncherActivity", "disableList", XmlPullParser.NO_NAMESPACE, "refreshDynamicShortcut", "snapshotDynamicShortcutConfig", "getBottomTabConfigManager", "Lcom/larus/home/api/main/model/IBottomTabConfigManager;", "reportAppPrivacyPoliceDismissToLoginShow", "supportChangeAppIcon", "tryUpdateLauncherActivity", "findEnabledActivity", "isEnabled", "name", "getChatFragment", "Lcom/larus/bmhome/chat/fragment/IChatFragment;", "topActivity", "Landroid/app/Activity;", "getSelectedChatFragment", "activity", "enableSideBar", "isSideBarVisible", "isFlowNativeBotChatVisible", "clearPreloadMessage", "savePrivacyWindowShow", "savePrivacyWindowClick", "accept", "recordPrivacyPoliceShow", "jsonParams", "isPad", "getPrivacyWebViewActivityClassName", "enableLauncherIcon", "currentSelectAppIconId", "(Landroid/content/Context;Ljava/lang/Integer;)V", "disableLauncherIcon", "recoverLauncherIcon", "findIfThereIsAnotherAppIconEnabled", "disableDefaultIcon", "setHotLaunchEnabled", "enabled", "hasAddPageMineTabFragment", "fragment", "Landroidx/fragment/app/Fragment;", "mainTabOnAction", "action", "Lcom/larus/voice_setting/voice/base/MainTabFragmentAction;", "redirectNeedLoginStrictModeRouter", ContentProviderManager.PROVIDER_URI, "Landroid/net/Uri;", "openPhoneNumberPanel", "phoneNumber", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class HomeServiceImpl implements IHomeApi {
    public final String a;
    public final Map<AppIconsType, String> b;
    public final Map<Integer, Integer> c;
    public final Map<String, String> d;
    public boolean e;
    public volatile PackageInfo f;

    @Override // com.larus.home.api.main.IHomeApi
    public final void B() {
        AppInitReporter r0 = AppInitReporter.a;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L7;
        AppInitReporter.b = Long.valueOf(System.currentTimeMillis());
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void D() {
        Lazy r0 = h.a;
        Application r1 = AppHost.a.getApplication();
        Intrinsics.checkNotNullParameter(r1, "app");
        FLogger.a.d("PadController", "init...");
        r1.registerActivityLifecycleCallbacks(new g());
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void E() {
        AppInitReporter r0 = AppInitReporter.a;
        AppInitReporter.q = true;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final String F() {
        return PrivacyWebViewActivity.class.getName();
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void G() {
        AppInitReporter r0 = AppInitReporter.a;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L7;
        AppInitReporter.j = Long.valueOf(System.currentTimeMillis());
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final Long J() {
        AppInitReporter r0 = AppInitReporter.a;
        return AppInitReporter.b;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void K() {
        k.a.getClass();
    L22:
        List r0 = CollectionsKt.emptyList();
    L23:
        k.d = r0;
        if (p.b == false) goto L29;
        AppHost.a.a().j(k.k);
        return;
    L29:
        return;
    L5:
        if (((d1) k.c.getValue()).b() == true) goto L7;
        k.b.erase("preload_messages");     // Catch: Exception -> L22
        FLogger.a.i("PreloadMessagesManager", "[loadPreloadMessages], clear preload messages");     // Catch: Exception -> L22
        r0 = CollectionsKt.emptyList();     // Catch: Exception -> L22
        goto L23
    L7:
        String r1 = k.b.getString("preload_messages", XmlPullParser.NO_NAMESPACE);     // Catch: Exception -> L22
        if (r1 != null) goto L10;
    L13:
        boolean r2 = true;
    L14:
        if (r2 == false) goto L16;
        r0 = CollectionsKt.emptyList();     // Catch: Exception -> L22
        goto L23
    L16:
        List r3 = (List) HttpExtKt.f.fromJson(r1, new l().getType());     // Catch: Exception -> L22
        Intrinsics.checkNotNull(r3);     // Catch: Exception -> L22
        List r4 = r3;     // Catch: Exception -> L22
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));     // Catch: Exception -> L22
        Iterator r6 = r4.iterator();     // Catch: Exception -> L22
    L18:
        if (r6.hasNext() == false) goto L20;
        r5.add(((Message) r6.next()).getMessageId());     // Catch: Exception -> L22
        goto L18
    L20:
        FLogger.a.i("PreloadMessagesManager", "[loadPreloadMessages], caches.messageId = " + r5);     // Catch: Exception -> L22
        r0 = new ArrayList(r3);     // Catch: Exception -> L22
        goto L23
    L10:
        if (r1.length() == 0) goto L13;
        r2 = false;
        goto L14
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void N() {
        int r0 = UpdateRedDotManager.a;
        UpdateRedDotManager.b = true;
        c1 r1 = (c1) AuthModelDelegate.b.c().getValue();
        Boolean r2 = null;
        if (r1 == null) goto L5;
        e0 r3 = (e0) r1.d;
    L6:
        FLogger r4 = FLogger.a;
        StringBuilder r5 = new StringBuilder("redBadge split register listener: enableRedBadgeOpt=");
        if (r3 == null) goto L9;
        Boolean r6 = Boolean.valueOf(r3.D());
    L10:
        r5.append(r6);
        r5.append(", appIconRedBadgeClosed=");
        if (r3 == null) goto L13;
        r2 = Boolean.valueOf(r3.d());
    L13:
        r5.append(r2);
        r5.append(", isOversea=");
        AppHost.Companion r7 = AppHost.a;
        r5.append(r7.isOversea());
        r4.i("UpdateRedDotManager", r5.toString());
        r7.a().j(UpdateRedDotManager.d);
        UpdateRedDotManager.b();
        INotifyService.a.e().a().observeForever(new UpdateRedDotManager.c(new b()));
        AccountService r8 = AccountService.a;
        r8.E(new c());
        r8.H(new d());
        return;
    L9:
        r6 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final String P() {
        return ChatActivity.class.getName();
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void S() {
        gd8.l.d = new d();
        gd8.l r0 = new gd8.l();
        o37.c r1 = o37.c.e;
        r1.a(r0);
        Intrinsics.checkNotNullParameter("conv_list", "name");
        ((ArrayList) gd8.l.b).add(2131563027);
        ((Map) gd8.l.c.getValue()).put(2131563027, "conv_list");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        r1.g("main_page_tab_view", 1);     // Catch: Throwable -> L5
        Result.m49constructorimpl(r1);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.m49constructorimpl(ResultKt.createFailure(th));
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void T() {
        k r0 = k.a;
        r0.getClass();
        k.d = CollectionsKt.emptyList();
        if (p.b == true) goto L5;
        k.a();
        return;
    L5:
        Object r1 = k.e;
        monitor-enter(r1);
        k.g = null;     // Catch: Throwable -> L16
        int r3 = k.h;     // Catch: Throwable -> L16
        k.h = 0;     // Catch: Throwable -> L16
        ScheduledFuture r5 = k.i;     // Catch: Throwable -> L16
        if (r5 == null) goto L11;
        r5.cancel(false);     // Catch: Throwable -> L16
    L11:
        k.i = null;     // Catch: Throwable -> L16
        k.j = SystemClock.elapsedRealtime() + 1000;     // Catch: Throwable -> L16
        ((ScheduledExecutorService) k.f.getValue()).execute(new hc9.h(r0));     // Catch: Throwable -> L16
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r1);
        if (r3 <= 0) goto L22;
        FLogger.a.i("PreloadMessagesManager", "[clearPreloadMessages] cancel pending save requestCount=" + r3);
        return;
    L22:
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void U() {
        Lazy r0 = ec9.l.a;
        ISecPrivacyService.a.getClass();
        ISecPrivacyService r1 = ISecPrivacyService.a.a();
        if (r1 == null) goto L5;
        boolean r2 = r1.j();
    L6:
        if (r2 == true) goto L10;
        ec9.l.f(new i());
        return;
    L10:
        return;
    L5:
        r2 = false;
        goto L6
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void X() {
        BottomTabConfigManager.a.l();
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void e0() {
        UpdateClientStateManager.a r0 = UpdateClientStateManager.b;
        e10 r1 = e10.a;
        int r2 = l0.a;
        if (((Boolean) l0.a(Boolean.TRUE, new do())).booleanValue() == false) goto L11;
        AppHost.Companion r3 = AppHost.a;
        if (r3.a().isAppBackground() == false) goto L8;
        int r4 = 2;
    L9:
        UpdateClientStateManager.a(r4);
        r3.a().j(UpdateClientStateManager.b);
        return;
    L8:
        r4 = 1;
        goto L9
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void g0() {
        Lazy r0 = ec9.l.a;
        ISecPrivacyService.a.getClass();
        ISecPrivacyService r1 = ISecPrivacyService.a.a();
        if (r1 == null) goto L5;
        boolean r2 = r1.j();
    L6:
        if (r2 == true) goto L10;
        ec9.l.f(new ec9.h());
        return;
    L10:
        return;
    L5:
        r2 = false;
        goto L6
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final boolean m() {
        MainActivity r0 = AppHost.a.a().getCurrentActivity();
        if ((r0 instanceof MainActivity) == false) goto L5;
        MainActivity r1 = r0;
    L7:
        if (r1 == null) goto L21;
        Fragment r2 = r1.Q1();
        if ((r2 instanceof ChatFragment) == false) goto L11;
    L18:
        boolean r3 = true;
    L19:
        if (r3 != true) goto L21;
        boolean r4 = true;
    L22:
        if (r4 == false) goto L24;
        return true;
    L24:
        if ((r0 instanceof d4) == false) goto L26;
        return true;
    L26:
        if ((r0 instanceof a) == false) goto L28;
        return true;
    L28:
        if (com.larus.home.impl.utils.b.b(r0) != null) goto L35;
        return false;
    L35:
        return true;
    L11:
        if ((r2 instanceof ChatImmersFragment) == true) goto L18;
        if ((r2 instanceof ChatDoubleTabFragment) == true) goto L18;
        if ((r2 instanceof ChatMultiTabFragment) == true) goto L18;
        r3 = false;
    L21:
        r4 = false;
        goto L22
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final boolean n() {
        MainActivity r0 = AppHost.a.a().getCurrentActivity();
        MainSideBarFragment r2 = null;
        if ((r0 instanceof MainActivity) == false) goto L5;
        MainActivity r1 = r0;
    L7:
        if (r1 != null) goto L9;
        return false;
    L9:
        Fragment r3 = r1.S1();
        if ((r3 instanceof MainSideBarFragment) == false) goto L12;
        r2 = (MainSideBarFragment) r3;
    L12:
        if (r2 != null) goto L14;
        return false;
    L14:
        if (r2.Ga() != true) goto L18;
        return true;
    L18:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final String r() {
        return ObricChatActivity.class.getName();
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void u() {
        AppInitReporter r0 = AppInitReporter.a;
        if (AppInitReporter.c != 0) goto L6;
        AppInitReporter.c = System.currentTimeMillis();
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void y() {
        FLogger r0 = FLogger.a;
        r0.i(this.a, "recoverLauncherIcon in");
        IHomeApi r1 = (IHomeApi) ServiceManager.get().getService(IHomeApi.class);
        AppIconsType r2 = null;
        if (r1 == null) goto L5;
        Integer r3 = r1.H(AppHost.a.getApplication());
    L6:
        if (r3 != null) goto L10;
        r0.i(this.a, "currentAppIconId is null, enable the default icon");
        IHomeApi r4 = (IHomeApi) ServiceManager.get().getService(IHomeApi.class);
        if (r4 == null) goto L50;
        r4.W(AppHost.a.getApplication(), Integer.valueOf(AppIconsType.DEFAULT.getAppIconId()));
        return;
    L50:
        return;
    L10:
        AppIconsType r5 = AppIconsType.DEFAULT;
        if (r3.intValue() == r5.getAppIconId()) goto L44;
        r0.i(this.a, "launcher app icon is " + r3);
        return;
    L44:
        LinkedHashMap r6 = new LinkedHashMap();     // Catch: Exception -> L21
        r6.putAll(yo8.a.a);     // Catch: Exception -> L21
        r6.remove(r5);     // Catch: Exception -> L21
        Iterator r7 = r6.entrySet().iterator();     // Catch: Exception -> L21
    L14:
        if (r7.hasNext() == false) goto L23;
        Map.Entry r8 = (Map.Entry) r7.next();     // Catch: Exception -> L21
        AppHost.Companion r9 = AppHost.a;     // Catch: Exception -> L21
        if (f(r9.getApplication(), (String) r8.getValue()) == true) goto L19;
        if (f(r9.getApplication(), yo8.a.c.get(r8.getValue())) == false) goto L14;
    L19:
        r2 = (AppIconsType) r8.getKey();     // Catch: Exception -> L21
    L23:
        FLogger.a.i(this.a, "default icon is enabled, another icon exist? " + r2);
        if (r2 != null) goto L42;
        return;
    L42:
        AppHost.Companion r10 = AppHost.a;     // Catch: Throwable -> L28
        r10.getApplication().getPackageManager().setComponentEnabledSetting(new ComponentName(r10.getApplication(), b(r10.getApplication().getClassLoader(), yo8.a.a.get(AppIconsType.DEFAULT))), 2, 1);     // Catch: Throwable -> L28
        boolean r11 = true;
    L30:
        if (r11 == false) goto L40;
        FLogger.a.i(this.a, "disableDefaultIcon succeeded");
        return;
    L40:
        String r12 = yo8.a.a.get(AppIconsType.DEFAULT);     // Catch: Throwable -> L36
        if (r12 == null) goto L54;
        AppHost.Companion r13 = AppHost.a;     // Catch: Throwable -> L36
        r13.getApplication().getPackageManager().setComponentEnabledSetting(new ComponentName(r13.getApplication().getPackageName(), r12), 2, 1);     // Catch: Throwable -> L36
        return;
    L54:
        return;
    L36:
        th = move-exception;
        FLogger.a.e(this.a, "disableDefaultIcon error again!", th);
        return;
    L28:
        th = move-exception;
        FLogger.a.e(this.a, "disableDefaultIcon error!", th);
        r11 = false;
    L21:
        e = move-exception;
        FLogger.a.e(this.a, "findIfThereIsAnotherAppIconEnabled error!", e);
        goto L23
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void z() {
        AppInitReporter r0 = AppInitReporter.a;
        Application r1 = AppHost.a.getApplication();
        int r3 = e.a;
        String r4 = XmlPullParser.NO_NAMESPACE;
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter("app_init_data_file.txt", "fileName");
        PolarisFileWrapper r5 = new PolarisFileWrapper(r1.getFilesDir(), "app_init_data_file.txt");     // Catch: Exception -> L29
        if (r5.exists() == false) goto L32;
        PolarisFileInputStreamWrapper r2 = new PolarisFileInputStreamWrapper(r5);     // Catch: Exception -> L29
        FileChannel r6 = r2.getChannel();     // Catch: Throwable -> L24
        FileLock r7 = r6.lock(0, Long.MAX_VALUE, true);     // Catch: Throwable -> L19
        byte[] r8 = new byte[(int) r6.size()];     // Catch: Throwable -> L16
        r2.read(r8);     // Catch: Throwable -> L16
        String r9 = new String(r8, Charsets.UTF_8);     // Catch: Throwable -> L16
        r7.release();     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r6, null);     // Catch: Throwable -> L24
        CloseableKt.closeFinally(r2, null);     // Catch: Exception -> L29
        r4 = r9;
        goto L32
    L16:
        th = move-exception;
        r7.release();     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);     // Catch: Exception -> L29
        throw th;     // Catch: Exception -> L29
    L32:
        if (r4.length() != 0) goto L34;
        boolean r10 = true;
    L35:
        if (r10 == true) goto L81;
        JSONObject r11 = new JSONObject(r4);     // Catch: Exception -> L39
    L40:
        long r12 = -1;
        if (r11.has("real_app_init_time") == false) goto L43;
        long r13 = r11.optLong("real_app_init_time", -1);
    L44:
        AppInitReporter.ReportType r14 = AppInitReporter.ReportType.PRIVACY_SHOW;
        if (r11.has(r14.getScene()) == false) goto L47;
        r12 = r11.optLong(r14.getScene(), -1);
    L47:
        long r15 = r12 - r13;
        monitor-enter(r0);
    L65:
        th = move-exception;
        throw th;
    L50:
        if (AppInitReporter.n == false) goto L54;
        monitor-exit(r0);
    L63:
        e.a(AppHost.a.getApplication(), XmlPullParser.NO_NAMESPACE);
        return;
    L54:
        if (r15 > 0) goto L58;
        monitor-exit(r0);
        goto L63
    L58:
        if (r15 <= KevaPreloadHolder.FIRST_FRAME_DELAYED_TIME) goto L61;
        monitor-exit(r0);
        goto L63
    L61:
        AppInitReporter.n = true;     // Catch: Throwable -> L65
        JSONObject r16 = new JSONObject();     // Catch: Throwable -> L65
        r16.put("duration", r15);     // Catch: Throwable -> L65
        r16.put("stage", r14.getScene());     // Catch: Throwable -> L65
        o.a.reportEvent("direct_first_frame", r16);     // Catch: Throwable -> L65
        monitor-exit(r0);
        goto L63
    L43:
        r13 = -1;
    L39:
        r11 = new JSONObject();
        goto L40
    L81:
        return;
    L34:
        r10 = false;
    L29:
        e = move-exception;
        e.toString();
        goto L32
    }

    public HomeServiceImpl() {
        this.a = "HomeServiceImpl";
        this.b = yo8.a.a;
        this.c = yo8.a.b;
        this.d = yo8.a.c;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final boolean isPad() {
        return dc9.d.a();
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final boolean o() {
        return com.larus.home.impl.main.side_bar.p.d();
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final hb9.a d0() {
        return BottomTabConfigManager.a;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final Map<Integer, Integer> s() {
        return this.c;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final String A(Context r12) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Iterator<Map.Entry<AppIconsType, String>> r1 = this.b.entrySet().iterator();     // Catch: Exception -> L53
    L5:
        if (r1.hasNext() == false) goto L52;
        Map.Entry<AppIconsType, String> r2 = r1.next();     // Catch: Exception -> L53
        int r3 = AppHost.a.getApplication().getPackageManager().getComponentEnabledSetting(new ComponentName(r12, r2.getValue()));     // Catch: Exception -> L53
        if (r3 == 1) goto L9;
        int r5 = 0;
        if (r3 != 0) goto L25;
        PackageInfo r4 = d(r12);     // Catch: Exception -> L53
        if (r4 == null) goto L25;
        ActivityInfo[] r6 = r4.activities;     // Catch: Exception -> L53
        if (r6 == null) goto L25;
        int r7 = r6.length;     // Catch: Exception -> L53
        int r8 = 0;
    L17:
        if (r8 >= r7) goto L25;
        ActivityInfo r9 = r6[r8];     // Catch: Exception -> L53
        if (Intrinsics.areEqual(r9.name, r2.getValue()) == false) goto L24;
        if (r9.enabled == false) goto L24;
        return r2.getValue();
    L24:
        r8 = r8 + 1;     // Catch: Exception -> L53
    L25:
        String r10 = this.d.get(r2.getValue());     // Catch: Exception -> L53
        if (r10 == null) goto L28;
        Integer r11 = Integer.valueOf(AppHost.a.getApplication().getPackageManager().getComponentEnabledSetting(new ComponentName(r12, r10)));     // Catch: Exception -> L53
    L29:
        if (r11 != null) goto L32;
    L35:
        if (r11 == null) goto L5;
        if (r11.intValue() != 0) goto L5;
        PackageInfo r13 = d(r12);     // Catch: Exception -> L53
        if (r13 == null) goto L5;
        ActivityInfo[] r14 = r13.activities;     // Catch: Exception -> L53
        if (r14 == null) goto L5;
        int r15 = r14.length;     // Catch: Exception -> L53
    L44:
        if (r5 >= r15) goto L5;
        ActivityInfo r16 = r14[r5];     // Catch: Exception -> L53
        if (Intrinsics.areEqual(r16.name, this.d.get(r2.getValue())) == false) goto L51;
        if (r16.enabled == false) goto L51;
        return this.d.get(r2.getValue());
    L51:
        r5 = r5 + 1;
        goto L44
    L32:
        if (r11.intValue() != 1) goto L35;
        return this.d.get(r2.getValue());
    L28:
        r11 = null;
        goto L29
    L9:
        return r2.getValue();
    L52:
        return null;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void C(boolean r2) {
        boolean r0 = f.b;
        f.h = r2;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final Integer H(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        AppIconsType r3 = e(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r3.getAppIconId());
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void I(long r6) {
        AppInitReporter r0 = AppInitReporter.a;
        if (AppInitReporter.e != 0) goto L6;
        AppInitReporter.d = r6;
        AppInitReporter.e = System.currentTimeMillis();
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void L(JSONObject r7) {
        Intrinsics.checkNotNullParameter(r7, "data");
        AppInitReporter r0 = AppInitReporter.a;
        monitor-enter(r0);
        Intrinsics.checkNotNullParameter(r7, "jsonParams");     // Catch: Throwable -> L36
        if (AppInitReporter.b == null) goto L34;
        Long r1 = AppInitReporter.b;     // Catch: Throwable -> L36
        if (r1 == null) goto L9;
        long r2 = r1.longValue();     // Catch: Throwable -> L36
    L11:
        if (r2 <= 0) goto L34;
        if (AppInitReporter.r == false) goto L18;
        monitor-exit(r0);
        return;
    L18:
        if (AppInitReporter.p == false) goto L22;
        monitor-exit(r0);
        return;
    L22:
        AppInitReporter.p = true;     // Catch: Throwable -> L36
        Long r3 = AppInitReporter.b;     // Catch: Throwable -> L36
        if (r3 == null) goto L25;
        long r4 = r3.longValue();     // Catch: Throwable -> L36
    L27:
        if (r4 > 0) goto L29;
    L31:
        monitor-exit(r0);
        return;
    L29:
        if ((System.currentTimeMillis() - r4) > KevaPreloadHolder.FIRST_FRAME_DELAYED_TIME) goto L31;
        AppInitReporter.c(AppInitReporter.ReportType.PRIVACY_CLICK_TO_LOGIN_SHOW, r7);     // Catch: Throwable -> L36
        goto L31
    L25:
        r4 = 0;
        goto L27
    L9:
        r2 = -1;
    L34:
        monitor-exit(r0);
        return;
    L36:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void M(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        ec9.l.b(r2);
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void Q(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        b0.a.getClass();
        b0.d(r2);
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void R(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter("15.2.0.1", "versionName");
        int r0 = m.a;
        Intrinsics.checkNotNullParameter(r3, "base");
        Intrinsics.checkNotNullParameter("15.2.0.1", "version");
        com.bytedance.librarian.a.b(r3, "15.2.0.1", null);
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void V(boolean r1) {
        com.larus.home.impl.utils.c.e = r1;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final xe8.a a(Activity r1) {
        return com.larus.home.impl.utils.b.b(r1);
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void a0(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Keva r0 = MiddleTabUIHelper.a;
        MiddleTabUIHelper.b(r2);
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void c0(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        String r0 = A(r4);
        if (r0 == null) goto L6;
        r4.getApplicationContext().getPackageManager().setComponentEnabledSetting(new ComponentName(r4, r0), 2, 1);
        return;
    }

    public final PackageInfo d(Context r4) {
        PackageInfo r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        monitor-enter(this);
        PackageInfo r1 = this.f;     // Catch: Throwable -> L20
        if (r1 == null) goto L23;
        monitor-exit(this);
        return r1;
    L23:
        PackageInfo r5 = r4.getPackageManager().getPackageInfo(r4.getPackageName(), 1);     // Catch: Exception -> L15 Throwable -> L20
        this.f = r5;     // Catch: Exception -> L15 Throwable -> L20
        monitor-exit(this);
        return r5;
    L15:
        e = move-exception;
        FLogger.a.e(this.a, "getPackageInfo error", e);     // Catch: Throwable -> L20
        return null;
    L20:
        th = move-exception;
        throw th;
    }

    public final AppIconsType e(Context r6) {
        Iterator<Map.Entry<AppIconsType, String>> r1 = this.b.entrySet().iterator();     // Catch: Exception -> L13
    L5:
        if (r1.hasNext() == false) goto L12;
        Map.Entry<AppIconsType, String> r2 = r1.next();     // Catch: Exception -> L13
        if (f(r6, r2.getValue()) == true) goto L10;
        if (f(r6, this.d.get(r2.getValue())) == false) goto L5;
    L10:
        return r2.getKey();
    L12:
        return null;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void f0(MainActivity r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        if (Build.VERSION.SDK_INT < 29) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L10;
        FLogger.a.i(this.a, "supportChangeAppIcon=false, return");
        return;
    L10:
        if (this.e == false) goto L13;
        FLogger.a.i(this.a, "tryUpdateLauncherActivityExecuted=true, return");
        return;
    L13:
        Activity r1 = com.bytedance.sdk.account.utils.d.b();
        if ((r1 instanceof MainActivity) == false) goto L16;
    L21:
        String r2 = A(r7);
        if (r2 != null) goto L25;
        return;
    L25:
        if (this.d.values().contains(r2) == false) goto L35;
        Map<String, String> r3 = this.d;
        LinkedHashMap r4 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r5 = r3.entrySet().iterator();
    L28:
        if (r5.hasNext() == false) goto L32;
        Map.Entry<String, String> r6 = r5.next();
        if (Intrinsics.areEqual(r6.getValue(), r2) == false) goto L28;
        r4.put(r6.getKey(), r6.getValue());
        goto L28
    L32:
        String r8 = (String) CollectionsKt.firstOrNull(r4.keySet());
        if (r8 == null) goto L35;
        c(r7, CollectionsKt.listOf(r2), r8);
    L35:
        this.e = true;
        return;
    L16:
        if ((r1 instanceof SuperChatActivity) == true) goto L21;
        if ((r1 instanceof ChatActivity) == true) goto L21;
        FLogger.a.i(this.a, "topActivity is " + r1 + ", return");
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void p(JSONObject r7) {
        Intrinsics.checkNotNullParameter(r7, "data");
        AppInitReporter r0 = AppInitReporter.a;
        monitor-enter(r0);
        Intrinsics.checkNotNullParameter(r7, "jsonParams");     // Catch: Throwable -> L25
        if (AppInitReporter.m == false) goto L9;
        monitor-exit(r0);
        return;
    L9:
        if (AppInitReporter.q == false) goto L13;
        monitor-exit(r0);
        return;
    L13:
        AppInitReporter.m = true;     // Catch: Throwable -> L25
        r7.put("is_cold_launch", 1 ^ (AppInitReporter.a(MainActivity.class.getName()) ? 1 : 0));     // Catch: Throwable -> L25
        Long r1 = AppInitReporter.j;     // Catch: Throwable -> L25
        if (r1 == null) goto L16;
        long r4 = r1.longValue();     // Catch: Throwable -> L25
    L18:
        if (r4 > 0) goto L20;
    L22:
        AccountService.a.E(new a());     // Catch: Throwable -> L25
        monitor-exit(r0);
        return;
    L20:
        if ((System.currentTimeMillis() - r4) > KevaPreloadHolder.FIRST_FRAME_DELAYED_TIME) goto L22;
        AppInitReporter.c(AppInitReporter.ReportType.FEED_SHOW, r7);     // Catch: Throwable -> L25
        goto L22
    L16:
        r4 = 0;
    L25:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final String q(AppIconsType r2) {
        return yo8.a.d.get(r2);
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void t(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        ec9.l.a(r2);
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final xe8.a v(Activity r8) {
        Intrinsics.checkNotNullParameter(r8, "activity");
        Intrinsics.checkNotNullParameter(r8, "activity");
        ChatMultiTabFragment r0 = com.larus.home.impl.utils.b.b(r8);
        if (r0 != null) goto L6;
    L69:
        return null;
    L6:
        if (r0.getActivity() != r8) goto L69;
        ChatMultiTabFragment r9 = r0;
    L9:
        if (r9 == null) goto L92;
        if (r9.isAdded() == false) goto L69;
        if (r9.isHidden() == true) goto L69;
        if (r9.getView() == null) goto L69;
        boolean r2 = r9 instanceof ChatMultiTabFragment;
        if (r2 == false) goto L25;
        View r3 = r9.getView();
        if (r3 == null) goto L69;
        ViewPager2 r4 = (ViewPager2) r3.findViewById(2131392567);
        if (r4 == null) goto L69;
    L39:
        if (r4 == null) goto L68;
        RecyclerView.Adapter r5 = r4.getAdapter();
        if (r5 == null) goto L69;
        if (r4.getScrollState() != 0) goto L69;
        int r6 = r5.getItemCount();
        int r7 = r4.getCurrentItem();
        if (r7 < 0) goto L49;
        if (r7 >= r6) goto L49;
        boolean r10 = true;
    L50:
        if (r10 == false) goto L69;
        if (r2 == false) goto L57;
        if (r5.getItemId(r4.getCurrentItem()) == PageType.Chat.getType()) goto L68;
    L57:
        if ((r9 instanceof ChatDoubleTabFragment) == false) goto L64;
        if (r4.getCurrentItem() != 0) goto L69;
        if (((ChatDoubleTabFragment) r9).getChatFragment() == r0) goto L68;
    L64:
        if ((r9 instanceof ChatImmersFragment) == false) goto L68;
        if (((ChatImmersFragment) r9).Z90() == r0) goto L68;
    L49:
        r10 = false;
    L68:
        r9 = r9.getParentFragment();
        goto L9
    L25:
        if ((r9 instanceof ChatDoubleTabFragment) == false) goto L32;
        View r11 = ((ChatDoubleTabFragment) r9).getView();
        if (r11 == null) goto L69;
        r4 = (ViewPager2) r11.findViewById(2131392566);
        if (r4 != null) goto L39;
    L32:
        if ((r9 instanceof ChatImmersFragment) == false) goto L38;
        View r12 = ((ChatImmersFragment) r9).getView();
        if (r12 == null) goto L69;
        r4 = (ViewPager2) r12.findViewById(2131365524);
        if (r4 != null) goto L39;
    L38:
        r4 = null;
        goto L39
    L92:
        return r0;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void x(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "jsonParams");
        AppInitReporter r0 = AppInitReporter.a;
        AppInitReporter.b(r2);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class b(ClassLoader r2, String r3) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r4 = r2.loadClass(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r4;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r5 = r2.loadClass(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r5;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r3);
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void O(Fragment r2, MainTabFragmentAction r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        if ((r2 instanceof MainTabFragment) == false) goto L5;
        MainTabFragment r4 = (MainTabFragment) r2;
    L6:
        if (r4 == null) goto L9;
        r4.da0(r3);
        return;
    L9:
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void W(Context r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        AppIconsType.Companion.getClass();
        AppIconsType r5 = AppIconsType.a.a(r4);
        if (r5 != null) goto L6;
        r5 = AppIconsType.DEFAULT;
    L6:
        if (e(r3) != r5) goto L9;
        return;
    L9:
        if (e(r3) == null) goto L12;
        w(r3, r5);
        return;
    L12:
        String r6 = this.b.get(r5);
        if (r6 != null) goto L16;
        return;
    L16:
        if (z2.a.getAppLaunchFeedOptConfig().c == false) goto L19;
        r6 = this.d.get(r6);
    L19:
        if (r6 == null) goto L22;
        r3.getApplicationContext().getPackageManager().setComponentEnabledSetting(new ComponentName(r3, r6), 1, 1);
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void Y(Context r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        b0.a.getClass();
        b0.c(r2, r3);
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void Z(Context r1, Uri r2) {
        NeedInterceptRouterUtils.c(r1, r2);
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void b0(String r3, FragmentManager r4) {
        Intrinsics.checkNotNullParameter(r3, "phoneNumber");
        Intrinsics.checkNotNullParameter(r4, "fragmentManager");
        PhoneNumInteractDialog r0 = new PhoneNumInteractDialog();
        r0.S90(r3, null);
        String r5 = this.a;
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r5, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, r0, r1) == true) goto L11;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r0.show(r4, r5);
        return;
    }

    public final boolean f(Context r7, String r8) {
        int r0 = 0;
        if (r8 != null) goto L5;
        return false;
    L5:
        int r1 = AppHost.a.getApplication().getPackageManager().getComponentEnabledSetting(new ComponentName(r7, r8));
        if (r1 != 1) goto L8;
        boolean r3 = true;
    L9:
        if (r1 != 0) goto L22;
        PackageInfo r9 = d(r7);
        if (r9 == null) goto L22;
        ActivityInfo[] r10 = r9.activities;
        if (r10 == null) goto L22;
        int r2 = r10.length;
    L15:
        if (r0 >= r2) goto L22;
        ActivityInfo r4 = r10[r0];
        if (Intrinsics.areEqual(r4.name, r8) == false) goto L21;
        if (r4.enabled == false) goto L21;
        r3 = true;
    L21:
        r0 = r0 + 1;
    L22:
        FLogger.a.d(this.a, "isEnabled name:" + r8 + ", result:" + r3);
        return r3;
    L8:
        r3 = false;
        goto L9
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void w(Context r6, AppIconsType r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "appIconsType");
        AppIconsType r0 = e(r6);
        if (r0 != null) goto L5;
        return;
    L5:
        FLogger.a.i(this.a, "currentSelectAppIconsType:" + r0 + "---appIconsType:" + r7);
        if (r0 != r7) goto L8;
        return;
    L8:
        String r8 = this.b.get(r7);
        if (r8 != null) goto L11;
        return;
    L11:
        String r1 = this.b.get(r0);
        if (r1 != null) goto L14;
        return;
    L14:
        c(r6, CollectionsKt.listOf(new String[]{r1, this.d.get(r1)}), r8);
    }

    public final void c(Context r7, List<String> r8, String r9) {
        FLogger r0 = FLogger.a;
        String r1 = this.a;
        StringBuilder r2 = new StringBuilder("changeLauncherActivity from:");
        boolean r3 = false;
        r2.append((String) CollectionsKt.getOrNull(r8, 0));
        r2.append(", ");
        r2.append((String) CollectionsKt.getOrNull(r8, 1));
        r2.append("---to:");
        r2.append(r9);
        r0.i(r1, r2.toString());
        if (Build.VERSION.SDK_INT < 29) goto L5;
        r3 = true;
    L5:
        if (r3 == true) goto L8;
        r0.i(this.a, "supportChangeAppIcon=false, return");
        return;
    L8:
        Unit r4 = null;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L15
        IShortcutPlatformService r6 = (IShortcutPlatformService) ServiceManager.get().getService(IShortcutPlatformService.class);     // Catch: Throwable -> L15
        if (r6 == null) goto L12;
        r6.b();     // Catch: Throwable -> L15
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L13:
        Object r11 = Result.m49constructorimpl(r10);     // Catch: Throwable -> L15
    L17:
        Throwable r12 = Result.m52exceptionOrNullimpl(r11);
        if (r12 == null) goto L20;
        FLogger.a.e(this.a, "snapshot dynamic shortcut config failed", r12);
    L20:
        Iterator<T> r13 = r8.iterator();
    L22:
        if (r13.hasNext() == false) goto L26;
        String r14 = (String) r13.next();
        if (r14 == null) goto L22;
        r7.getApplicationContext().getPackageManager().setComponentEnabledSetting(new ComponentName(r7, r14), 2, 1);
        goto L22
    L26:
        r7.getApplicationContext().getPackageManager().setComponentEnabledSetting(new ComponentName(r7, r9), 1, 1);
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L32
        IShortcutPlatformService r16 = (IShortcutPlatformService) ServiceManager.get().getService(IShortcutPlatformService.class);     // Catch: Throwable -> L32
        if (r16 == null) goto L30;
        r16.e();     // Catch: Throwable -> L32
        r4 = Unit.INSTANCE;     // Catch: Throwable -> L32
    L30:
        Object r17 = Result.m49constructorimpl(r4);     // Catch: Throwable -> L32
    L34:
        Throwable r18 = Result.m52exceptionOrNullimpl(r17);
        if (r18 == null) goto L47;
        FLogger.a.e(this.a, "refresh dynamic shortcut failed", r18);
        return;
    L47:
        return;
    L32:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r17 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L34
    L12:
        r10 = null;
    L15:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r11 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L17
    }
}
