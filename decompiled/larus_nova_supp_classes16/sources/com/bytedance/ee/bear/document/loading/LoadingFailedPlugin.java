package com.bytedance.ee.bear.document.loading;

import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.browser.WebFragment;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentFragment;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.s1;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.k;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import z05.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class LoadingFailedPlugin extends DocumentPlugin implements LoadingLayout.c {
    private static final String TAG = "LoadingFailedPlugin";

    public static /* synthetic */ void c(LoadingFailedPlugin r0) {
        r0.lambda$onAttachToUIContainer$0();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void replaceDocumentFragment() {
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
        INVOKEVIRTUAL_com_bytedance_ee_bear_document_loading_LoadingFailedPlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(r1.beginTransaction(), r0.getId(), r3).commitAllowingStateLoss();
        return;
    }

    private int getDocumentType() {
        if (getDocViewModel() != null) goto L5;
        return -1;
    L5:
        if (getDocViewModel().getWikiInfo() == null) goto L9;
        return getDocViewModel().getWikiInfo().getObjType();
    L9:
        return getDocViewModel().getDocumentTypeValue();
    }

    private /* synthetic */ void lambda$onAttachToUIContainer$0() {
        getActivity().finish();
        String r0 = i.c(getDocViewModel().getUrl());
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).u5(r0);
        ((k) org.koin.java.a.a(k.class)).d(getDocumentType());
    }

    public LoadingFailedPlugin() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.document.loading.LoadingLayout.c
    public void onFailedRetry(int r3) {
        tt5.a.h(TAG, "onFailedRetry()... errCode = " + r3);
        if (r3 != (-55)) goto L5;
        return;
    L5:
        if (r3 == (-56)) goto L19;
        int r0 = s1.b.a;
        if (r3 != 100) goto L10;
    L15:
        replaceDocumentFragment();
        return;
    L10:
        if (r3 == 601) goto L15;
        if (r3 == 501) goto L15;
        ((DocumentPluginHost) getHost()).getDocumentLoader().load();
        return;
    }

    public void onAttachToUIContainer(DocumentPluginHost r1, t r2) {
        super.onAttachToUIContainer(r1, r2);
        DocLoadingPlugin r3 = (DocLoadingPlugin) findPlugin(DocLoadingPlugin.class);
        if (r3 == null) goto L8;
        r3.setOnRetryListener(this);
        if (i.b(getDocumentType()) == false) goto L9;
        r3.setOnBackSourceDocListener(new e(this));
        return;
    L9:
        return;
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        DocLoadingPlugin r3 = (DocLoadingPlugin) findPlugin(DocLoadingPlugin.class);
        if (r3 == null) goto L6;
        r3.setOnRetryListener(null);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_bytedance_ee_bear_document_loading_LoadingFailedPlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(FragmentTransaction r2, int r3, Fragment r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r4, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r3) == false) goto L6;
        return r2;
    L6:
        return r2.replace(r3, r4);
    }
}
