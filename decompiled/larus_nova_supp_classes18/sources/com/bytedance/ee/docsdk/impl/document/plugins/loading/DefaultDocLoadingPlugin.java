package com.bytedance.ee.docsdk.impl.document.plugins.loading;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.JsBridgeConstants;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.chameleon.api.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.api.ChameleonConfig;
import com.ss.android.lark.chameleon.api.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleon.api.pluginapi.ILoadingPlugin;
import com.ss.android.lark.chameleon.bridge.BridgeHandlerV2;
import com.ss.android.lark.chameleon.bridge.CallBackFunction;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.chameleon.container.webcontainer.view.ChameleonFragment;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.pluginsystem.WebFragment;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHost;
import com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0016\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0002 !B\u0005¢\u0006\u0002\u0010\u0003J \u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\rH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001a\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u000bH\u0016J\b\u0010\u001f\u001a\u00020\u000bH\u0014R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\""}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/loading/DefaultDocLoadingPlugin;", "Lcom/ss/android/lark/chameleon/api/AbsChameleonPlugin;", "Lcom/ss/android/lark/chameleon/api/pluginapi/ILoadingPlugin;", "()V", "mLoadingView", "Lcom/bytedance/ee/docsdk/impl/document/plugins/loading/LoadingLayout;", "getMLoadingView", "()Lcom/bytedance/ee/docsdk/impl/document/plugins/loading/LoadingLayout;", "mLoadingView$delegate", "Lkotlin/Lazy;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/ss/android/lark/chameleon/bridge/BridgeHandlerV2;", "getLoadingView", "Landroid/view/View;", "onAttachToUIContainer", "host", "Lcom/ss/android/lark/chameleon/api/pluginapi/ChameleonPluginHost;", "uiContainer", "Lcom/ss/android/lark/chameleon/pluginsystem/plugin/UIContainer;", "onFailedRetry", "errCode", "", "onLoadFail", "code", "e", "", "onLoadSuccess", "replaceDocumentFragment", "Companion", "HideLoadingHandler", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class DefaultDocLoadingPlugin extends AbsChameleonPlugin implements ILoadingPlugin {
    public static final Companion Companion = null;
    private static final String TAG = "DocLoadingPlugin";
    private final Lazy mLoadingView$delegate;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/loading/DefaultDocLoadingPlugin$Companion;", "", "()V", "TAG", "", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/loading/DefaultDocLoadingPlugin$HideLoadingHandler;", "Lcom/ss/android/lark/chameleon/bridge/BridgeHandlerV2;", "", "(Lcom/bytedance/ee/docsdk/impl/document/plugins/loading/DefaultDocLoadingPlugin;)V", "handle", "", WikiFolderPushPlugin.DATA, "callback", "Lcom/ss/android/lark/chameleon/bridge/CallBackFunction;", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class HideLoadingHandler implements BridgeHandlerV2<Object> {
        final /* synthetic */ DefaultDocLoadingPlugin this$0;

        public HideLoadingHandler(DefaultDocLoadingPlugin r1) {
            this.this$0 = r1;
        }

        public void handle(Object r1, CallBackFunction r2) {
            Log.i(DefaultDocLoadingPlugin.TAG, "hideLoading");
            DefaultDocLoadingPlugin.access$getMLoadingView(this.this$0).hide();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void a(DefaultDocLoadingPlugin r0, int r1) {
        onAttachToUIContainer$lambda$0(r0, r1);
    }

    public static /* synthetic */ void b(DefaultDocLoadingPlugin r0) {
        onAttachToUIContainer$lambda$1(r0);
    }

    private final LoadingLayout getMLoadingView() {
        return (LoadingLayout) this.mLoadingView$delegate.getValue();
    }

    public void onLoadSuccess() {
        Log.i(TAG, "Load document success");
    }

    public void replaceDocumentFragment() {
        Log.i(TAG, "replaceDocumentFragment()...");
        WebFragment r0 = getHost().getFragment();
        String r2 = getHost().getUrl();
        if (r0 != null) goto L5;
    L11:
        Log.w(TAG, "the documentFragment or its origin url is null");
        return;
    L5:
        if (TextUtils.isEmpty(r2) == true) goto L11;
        FragmentManager r1 = r0.getFragmentManager();
        if (r1 == null) goto L13;
        ChameleonConfig r3 = getHost().getChameleonConfig();
        String r4 = ChameleonOpenTracker.INSTANCE.newSessionTracker(r3);
        ChameleonContainerUtils r5 = ChameleonContainerUtils.INSTANCE;
        r5.setBizConfig(r4, r3, r5.getBizPlugins(getHost().getSession()));
        Fragment r6 = ChameleonFragment.Companion.newInstance(getContext(), r2, r4, r0.getArguments());
        INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_document_plugins_loading_DefaultDocLoadingPlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(r1.beginTransaction(), r0.getId(), r6).commitAllowingStateLoss();
        return;
    }

    public DefaultDocLoadingPlugin() {
        this.mLoadingView$delegate = LazyKt.lazy(new DefaultDocLoadingPlugin$mLoadingView$2(this));
    }

    public View getLoadingView() {
        return getMLoadingView();
    }

    public static final /* synthetic */ Context access$getContext(DefaultDocLoadingPlugin r0) {
        return r0.getContext();
    }

    public static final /* synthetic */ LoadingLayout access$getMLoadingView(DefaultDocLoadingPlugin r0) {
        return r0.getMLoadingView();
    }

    private static final void onAttachToUIContainer$lambda$1(DefaultDocLoadingPlugin r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Log.e(TAG, "onBackSourceDoc");
        r2.getActivity().finish();
    }

    private final void onFailedRetry(int r3) {
        Log.e(TAG, "onFailedRetry()... errCode = " + r3);
        if (r3 != (-56)) goto L5;
        return;
    L5:
        if (r3 != (-55)) goto L7;
        return;
    L7:
        if (r3 != 100) goto L9;
    L13:
        replaceDocumentFragment();
        return;
    L9:
        if (r3 == 501) goto L13;
        if (r3 == 601) goto L13;
        getHost().getLoader().reload();
    }

    public void getBridgeHandlers(Map<String, BridgeHandlerV2<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super.getBridgeHandlers(r3);
        r3.put(JsBridgeConstants.BIZ_UTIL_HIDELOADING, new HideLoadingHandler(this));
    }

    private static final void onAttachToUIContainer$lambda$0(DefaultDocLoadingPlugin r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Log.e(TAG, "Retry load document, errorCode: " + r3);
        r2.onFailedRetry(r3);
    }

    public void onAttachToUIContainer(ChameleonPluginHost r2, UIContainer r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "uiContainer");
        super/*com.ss.android.lark.chameleon.pluginsystem.plugin.BasePlugin*/.onAttachToUIContainer(r2, r3);
        getMLoadingView().setOnRetryListener(new a(this));
        getMLoadingView().setOnBackSourceDocListener(new b(this));
    }

    public void onLoadFail(int r4, Throwable r5) {
        StringBuilder r0 = new StringBuilder("Load document failed, code: ");
        r0.append(r4);
        r0.append(", err: ");
        String r1 = null;
        if (r5 == null) goto L5;
        String r2 = r5.getMessage();
    L6:
        r0.append(r2);
        Log.e(TAG, r0.toString());
        LoadingLayout r3 = getMLoadingView();
        if (r5 == null) goto L9;
        r1 = r5.getMessage();
    L9:
        r3.fail(r4, r1);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, UIContainer r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_document_plugins_loading_DefaultDocLoadingPlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(FragmentTransaction r2, int r3, Fragment r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r4, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r3) == false) goto L6;
        return r2;
    L6:
        return r2.replace(r3, r4);
    }
}
