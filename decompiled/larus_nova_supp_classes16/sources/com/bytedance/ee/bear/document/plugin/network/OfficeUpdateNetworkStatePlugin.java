package com.bytedance.ee.bear.document.plugin.network;

import android.webkit.WebView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u0006\u0010\u0012\u001a\u00020\u000bJ\u001c\u0010\u0013\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/document/plugin/network/OfficeUpdateNetworkStatePlugin;", "Lcom/bytedance/ee/bear/document/base/DocumentPluginV3;", "<init>", "()V", "lastNotifiedNetworkState", "Lcom/bytedance/ee/bear/contract/ConnectionService$NetworkState;", "networkStateObserver", "Landroidx/lifecycle/Observer;", "mNetworkStateLiveData", "Landroidx/lifecycle/LiveData;", "onAttachToUIContainer", "", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "notifyNetworkState", "networkState", "observerNetworkState", "onDetachFromUIContainer", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeUpdateNetworkStatePlugin extends DocumentPluginV3 {
    public static final a Companion = null;
    private static final String TAG = "UpdateNetworkStatePlugin";
    private ConnectionService.NetworkState lastNotifiedNetworkState;
    private LiveData<ConnectionService.NetworkState> mNetworkStateLiveData;
    private Observer<ConnectionService.NetworkState> networkStateObserver;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ OfficeUpdateNetworkStatePlugin a;

        public b(OfficeUpdateNetworkStatePlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            ConnectionService.NetworkState r3 = (ConnectionService.NetworkState) r2;
            Intrinsics.checkNotNullParameter(r3, "networkState");
            OfficeUpdateNetworkStatePlugin.access$notifyNetworkState(this.a, r3);
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public final void observerNetworkState() {
        if (this.mNetworkStateLiveData != null) goto L5;
        this.mNetworkStateLiveData = j.a.a.a();
    L5:
        LiveData<ConnectionService.NetworkState> r0 = this.mNetworkStateLiveData;
        if (r0 == null) goto L9;
        r0.observeForever(this.networkStateObserver);
        return;
    }

    public OfficeUpdateNetworkStatePlugin() {
        this.networkStateObserver = new b(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void notifyNetworkState(ConnectionService.NetworkState r6) {
        ChameleonPluginHost r0 = getHost();
        if (r0 == null) goto L7;
        k r1 = r0.getWeb();
        if (r1 == null) goto L7;
        WebView r2 = r1.getWebView();
    L9:
        if (r2 != null) goto L13;
        tt5.a.h(TAG, "webview is null");
        return;
    L13:
        if (Intrinsics.areEqual(this.lastNotifiedNetworkState, r6) == false) goto L16;
        tt5.a.h(TAG, "skip duplicate networkState:" + r6);
        return;
    L16:
        tt5.a.h(TAG, "updateNetworkState:" + r6);
        JSONObject r3 = new JSONObject();
        r3.put("type", Integer.valueOf(r6.getType()));
        r3.put("connected", Boolean.valueOf(r6.a()));
        ap5.a.a(r2, "javascript:window.native.setNetworkState", r3, null);
        this.lastNotifiedNetworkState = r6;
        return;
    L7:
        r2 = null;
        goto L9
    }

    public static final /* synthetic */ void access$notifyNetworkState(OfficeUpdateNetworkStatePlugin r0, ConnectionService.NetworkState r1) {
        r0.notifyNetworkState(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToUIContainer(ChameleonPluginHost r1, t r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r1, r2);
        notifyNetworkState(j.a.a.getNetworkState());
        observerNetworkState();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachFromUIContainer(ChameleonPluginHost r1, t r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r1, r2);
        LiveData<ConnectionService.NetworkState> r3 = this.mNetworkStateLiveData;
        if (r3 == null) goto L5;
        r3.removeObserver(this.networkStateObserver);
    L5:
        this.lastNotifiedNetworkState = null;
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }
}
