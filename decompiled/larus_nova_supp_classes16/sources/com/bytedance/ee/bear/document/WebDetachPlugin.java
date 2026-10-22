package com.bytedance.ee.bear.document;

import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.browser.WebFragment;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class WebDetachPlugin extends DocumentPlugin {
    private static final String TAG = "WebDetachPlugin";
    private final MutableLiveData<Boolean> isDetached;
    private final View.OnAttachStateChangeListener onWebViewReuseListener;

    public class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ WebDetachPlugin a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r1) {
        }

        public a(WebDetachPlugin r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r3) {
            com.bytedance.ee.util.ui.j.d(new e7(this), 1000);
        }
    }

    public class b extends x2.c {
        public final /* synthetic */ WebDetachPlugin a;

        @Override // com.bytedance.ee.bear.document.x2.c, com.bytedance.ee.bear.document.x2.b
        public final void onLoadSuccess() {
            WebDetachPlugin.access$000(this.a).observe(WebDetachPlugin.access$100(this.a), new f7(this));
        }

        public b(WebDetachPlugin r1) {
            this.a = r1;
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void replaceDocumentFragment() {
        tt5.a.h(TAG, "replaceDocumentFragment()...");
        WebFragment r0 = ((DocumentPluginHost) getHost()).c();
        String r2 = getDocViewModel().getOriginUrl();
        if (r0 != null) goto L5;
    L11:
        tt5.a.k(TAG, "the documentFragment or its origin url is null");
        return;
    L5:
        if (TextUtils.isEmpty(r2) == true) goto L11;
        FragmentManager r1 = r0.getFragmentManager();
        if (r1 == null) goto L13;
        BaseFragment r3 = DocumentFragment.ka0(r2, r0.getArguments());
        INVOKEVIRTUAL_com_bytedance_ee_bear_document_WebDetachPlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(r1.beginTransaction(), r0.getId(), r3).commitAllowingStateLoss();
        return;
    }

    public WebDetachPlugin() {
        this.isDetached = new MutableLiveData(Boolean.FALSE);
        this.onWebViewReuseListener = new a(this);
    }

    public static /* synthetic */ MutableLiveData access$000(WebDetachPlugin r0) {
        return r0.isDetached;
    }

    public static /* synthetic */ LifecycleOwner access$100(WebDetachPlugin r0) {
        return r0.getLifecycleOwner();
    }

    public static /* synthetic */ void access$200(WebDetachPlugin r0) {
        r0.replaceDocumentFragment();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToUIContainer(DocumentPluginHost r2, com.bytedance.ee.bear.browser.plugin.t r3) {
        tt5.a.h(TAG, "onAttachToUIContainer()...");
        x2 r4 = r2.getDocumentLoader();
        if (r4 == null) goto L5;
        r4.S3(new b(this));
    L5:
        ((DocumentPluginHost) getHost()).getWeb().getWebView().addOnAttachStateChangeListener(this.onWebViewReuseListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachFromUIContainer(DocumentPluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        tt5.a.h(TAG, "onDetachFromUIContainer()...");
        this.isDetached.removeObservers(getLifecycleOwner());
        ((DocumentPluginHost) getHost()).getWeb().getWebView().removeOnAttachStateChangeListener(this.onWebViewReuseListener);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_bytedance_ee_bear_document_WebDetachPlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(FragmentTransaction r2, int r3, Fragment r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r4, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r3) == false) goto L6;
        return r2;
    L6:
        return r2.replace(r3, r4);
    }
}
