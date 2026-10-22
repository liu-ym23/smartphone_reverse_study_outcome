package s20;

import com.bytedance.android.live.browser.di.H5Module_ProvideH5ServiceFactory;
import com.bytedance.android.live.browser.di.H5Module_ProvideInternalServiceFactory;
import com.bytedance.android.live.browser.di.H5Module_ProvideWebDialogFragmentFactory;
import com.bytedance.android.live.browser.di.HybridBaseModule_ProvideGsonFactory;
import com.bytedance.android.live.browser.di.JsBridgeModule_ProvideJsBridgeInternalServiceFactory;
import com.bytedance.android.live.browser.di.JsBridgeModule_ProvideJsBridgeServiceFactory;
import com.bytedance.android.live.browser.di.JsBridgeModule_ProvideLocalPrefetchConfigFactory;
import com.bytedance.android.live.browser.di.JsBridgeModule_ProvidePrefetchConfigFactory;
import com.bytedance.android.live.browser.di.JsBridgeModule_ProvideStateObservingServiceFactory;
import com.bytedance.android.live.browser.di.JsBridgeModule_ProvideStateObservingServiceInterfaceFactory;
import com.bytedance.android.live.browser.di.JsBridgeModule_ProvideWebPrefetchProcessorFactory;
import com.bytedance.android.live.browser.jsbridge.JsBridgeService;
import com.bytedance.android.live.browser.jsbridge.i;
import com.bytedance.android.live.browser.jsbridge.state.StateObservingService;
import com.bytedance.android.live.browser.q;
import com.bytedance.android.live.browser.u;
import com.bytedance.android.live.browser.v;
import com.bytedance.android.live.browser.w;
import com.bytedance.android.live.lynx.di.LiveLynxModule_ProvideLynxServiceFactory;
import com.google.gson.Gson;
import dagger.internal.DoubleCheck;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f540208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f540209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Provider<com.bytedance.android.live.browser.jsbridge.h> f540210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Provider<JsBridgeService> f540211d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Provider<v> f540212e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Provider<q> f540213f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Provider<u> f540214g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Provider<w> f540215h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Provider<Gson> f540216i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Provider<StateObservingService> f540217j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Provider<i> f540218k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public H5Module_ProvideWebDialogFragmentFactory f540219l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Provider<com.bytedance.android.live.browser.jsbridge.g> f540220m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Provider<com.bytedance.android.live.browser.jsbridge.g> f540221n;

    public final a a() {
        return new a(this.f540209b);
    }

    public b(c r100, f r101, ml0.a r102, d r103) {
        this.f540209b = this;
        this.f540208a = r101;
        this.f540210c = DoubleCheck.provider(JsBridgeModule_ProvideWebPrefetchProcessorFactory.create(r101));
        Provider<JsBridgeService> r104 = DoubleCheck.provider(JsBridgeModule_ProvideJsBridgeInternalServiceFactory.create(r101));
        this.f540211d = r104;
        this.f540212e = DoubleCheck.provider(JsBridgeModule_ProvideJsBridgeServiceFactory.create(r101, r104));
        Provider<q> r105 = DoubleCheck.provider(H5Module_ProvideInternalServiceFactory.create(r100));
        this.f540213f = r105;
        this.f540214g = DoubleCheck.provider(H5Module_ProvideH5ServiceFactory.create(r100, r105));
        this.f540215h = DoubleCheck.provider(LiveLynxModule_ProvideLynxServiceFactory.create(r102));
        Provider<Gson> r106 = DoubleCheck.provider(HybridBaseModule_ProvideGsonFactory.create(r103));
        this.f540216i = r106;
        Provider<StateObservingService> r107 = DoubleCheck.provider(JsBridgeModule_ProvideStateObservingServiceFactory.create(r101, r106));
        this.f540217j = r107;
        this.f540218k = DoubleCheck.provider(JsBridgeModule_ProvideStateObservingServiceInterfaceFactory.create(r101, r107));
        this.f540219l = H5Module_ProvideWebDialogFragmentFactory.create(r100);
        this.f540220m = DoubleCheck.provider(JsBridgeModule_ProvidePrefetchConfigFactory.create(r101));
        this.f540221n = DoubleCheck.provider(JsBridgeModule_ProvideLocalPrefetchConfigFactory.create(r101));
    }
}
