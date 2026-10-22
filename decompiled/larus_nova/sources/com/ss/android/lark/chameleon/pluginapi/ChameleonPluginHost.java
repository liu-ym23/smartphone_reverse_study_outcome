package com.ss.android.lark.chameleon.pluginapi;

import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.i;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.OpenConfig;
import com.ss.android.lark.chameleon.PluginProvider;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vv4.k;
import vv4.m;
import vv4.n;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010!\u001a\u00020\u000e2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\b\u0010$\u001a\u00020\bH\u0016J\b\u0010%\u001a\u00020\u0006H\u0016J\b\u0010&\u001a\u00020\u0006H\u0016J+\u0010'\u001a\u0004\u0018\u0001H(\"\n\b\u0000\u0010(*\u0004\u0018\u00010)2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u0002H(\u0018\u00010+H\u0016¢\u0006\u0002\u0010,R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006-"}, d2 = {"Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "Lcom/bytedance/ee/bear/browser/WebPluginHost;", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonContextAbility;", "chameleonWeb", "Lcom/bytedance/ee/bear/browser/Web;", "url", "", "config", "Lcom/ss/android/lark/chameleon/ChameleonConfig;", "sessionId", "serviceManager", "Lcom/bytedance/ee/bear/browser/WebServiceManager;", "afterCreate", "Lkotlin/Function0;", "", "<init>", "(Lcom/bytedance/ee/bear/browser/Web;Ljava/lang/String;Lcom/ss/android/lark/chameleon/ChameleonConfig;Ljava/lang/String;Lcom/bytedance/ee/bear/browser/WebServiceManager;Lkotlin/jvm/functions/Function0;)V", "getChameleonWeb", "()Lcom/bytedance/ee/bear/browser/Web;", "getAfterCreate", "()Lkotlin/jvm/functions/Function0;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "setFragment", "(Landroidx/fragment/app/Fragment;)V", "loader", "Lcom/ss/android/lark/chameleon/pluginapi/IChameleonLoader;", "getLoader", "()Lcom/ss/android/lark/chameleon/pluginapi/IChameleonLoader;", "setLoader", "(Lcom/ss/android/lark/chameleon/pluginapi/IChameleonLoader;)V", WidgetCostModule.TYPE_ON_CREATE, "delegate", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost$Delegate;", "getChameleonConfig", "getUrl", "getSession", "getWebService", "P", "Lcom/bytedance/ee/bear/browser/WebService;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/bytedance/ee/bear/browser/WebService;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ChameleonPluginHost extends WebPluginHost implements ChameleonContextAbility {
    private final Function0<Unit> afterCreate;
    private final k chameleonWeb;
    private final ChameleonConfig config;
    public Fragment fragment;
    public IChameleonLoader loader;
    private final n serviceManager;
    private final String sessionId;
    private final String url;

    public final Fragment getFragment() {
        Fragment r100 = this.fragment;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException(WidgetService.PARAM_FRAGMENT);
        return null;
    }

    public final IChameleonLoader getLoader() {
        IChameleonLoader r100 = this.loader;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("loader");
        return null;
    }

    public final Function0<Unit> getAfterCreate() {
        return this.afterCreate;
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.ChameleonContextAbility
    public ChameleonConfig getChameleonConfig() {
        return this.config;
    }

    public final k getChameleonWeb() {
        return this.chameleonWeb;
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.ChameleonContextAbility
    public String getSession() {
        return this.sessionId;
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.ChameleonContextAbility
    public String getUrl() {
        return this.url;
    }

    public <P extends m> P getWebService(Class<P> r100) {
        return (P) this.serviceManager.a(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost
    public void onCreate(PluginHost.a r100) {
        super.onCreate(r100);
        this.afterCreate.invoke();
    }

    public final void setFragment(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fragment = r100;
    }

    public final void setLoader(IChameleonLoader r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.loader = r100;
    }

    public ChameleonPluginHost(k r100, String r101, ChameleonConfig r102, String r103, n r104, Function0<Unit> r105) {
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, "config");
        Intrinsics.checkNotNullParameter(r103, "sessionId");
        Intrinsics.checkNotNullParameter(r104, "serviceManager");
        Intrinsics.checkNotNullParameter(r105, "afterCreate");
        super(r100);
        this.chameleonWeb = r100;
        this.url = r101;
        this.config = r102;
        this.sessionId = r103;
        this.serviceManager = r104;
        this.afterCreate = r105;
        registerHostAbility(this);
        OpenConfig r106 = r102.getOpenConfig();
        if (r106 == null) goto L12;
        PluginProvider r107 = r106.getPluginProvider();
        if (r107 == null) goto L14;
        ArrayList<i> r108 = r107.getPluginHostAbilitys();
        if (r108 == null) goto L15;
        Iterator<T> r109 = r108.iterator();
    L10:
        if (r109.hasNext() == false) goto L16;
        registerHostAbility((i) r109.next());
        goto L10
    L16:
        return;
    L15:
        return;
    L14:
        return;
    }

    public /* synthetic */ ChameleonPluginHost(k r100, String r101, ChameleonConfig r110, String r111, n r112, Function0 r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 32) == 0) goto L5;
        r113 = AnonymousClass1.INSTANCE;
    L5:
        this(r100, r101, r110, r111, r112, r113);
    }
}
