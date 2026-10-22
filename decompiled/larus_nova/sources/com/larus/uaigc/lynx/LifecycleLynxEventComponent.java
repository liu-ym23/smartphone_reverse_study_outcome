package com.larus.uaigc.lynx;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.IXBridgeEventSender;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/larus/uaigc/lynx/LifecycleLynxEventComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "<init>", "()V", "firstResume", "", "appBackGroundListener", "com/larus/uaigc/lynx/LifecycleLynxEventComponent$appBackGroundListener$1", "Lcom/larus/uaigc/lynx/LifecycleLynxEventComponent$appBackGroundListener$1;", "onResume", "", WidgetCostModule.TYPE_ON_CREATE, LiveCommonConstants.REASON_ON_DEDTROY, "onStop", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LifecycleLynxEventComponent extends BaseContentWidget {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f373483m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final a f373484n;

    public static final class a implements f09.a.b {
        public a() {
        }

        @Override // f09.a.b
        public final void onAllActivityDestroyed() {
        }

        @Override // f09.a.b
        public final void onAppBackground() {
            IXBridgeEventSender r100 = (IXBridgeEventSender) ServiceManager.get().getService(IXBridgeEventSender.class);
            if (r100 == null) goto L6;
            r100.sendEvent("appResignActive", MapsKt.emptyMap());
            return;
        }

        @Override // f09.a.b
        public final void onAppForeground() {
            IXBridgeEventSender r100 = (IXBridgeEventSender) ServiceManager.get().getService(IXBridgeEventSender.class);
            if (r100 == null) goto L6;
            r100.sendEvent("appBecomeActive", MapsKt.emptyMap());
            return;
        }
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        AppHost.f326268a.a().c(this.f373484n);
    }

    public LifecycleLynxEventComponent() {
        this.f373483m = true;
        this.f373484n = new a();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget, com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onCreate() {
        super.onCreate();
        AppHost.f326268a.a().j(this.f373484n);
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onResume() {
        IXBridgeEventSender r100 = (IXBridgeEventSender) ServiceManager.get().getService(IXBridgeEventSender.class);
        if (r100 == null) goto L6;
        r100.sendEvent("viewAppeared", MapsKt.mapOf(TuplesKt.to("isViewFirstAppeared", Boolean.valueOf(this.f373483m))));
    L6:
        if (this.f373483m == false) goto L9;
        this.f373483m = false;
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onStop() {
        IXBridgeEventSender r100 = (IXBridgeEventSender) ServiceManager.get().getService(IXBridgeEventSender.class);
        if (r100 == null) goto L6;
        r100.sendEvent("viewDisappeared", MapsKt.emptyMap());
        return;
    }
}
