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

/* JADX INFO: loaded from: classes16.dex */
public class LoadingFailedPlugin extends DocumentPlugin implements LoadingLayout.c {
    private static final String TAG = "LoadingFailedPlugin";

    public static /* synthetic */ void c(LoadingFailedPlugin r100) {
        r100.lambda$onAttachToUIContainer$0();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void replaceDocumentFragment() {
        tt5.a.h(TAG, "replaceDocumentFragment()...");
        WebFragment r100 = ((DocumentPluginHost) getHost()).c();
        String r101 = getDocViewModel().getOriginUrl();
        if (r100 != null) goto L5;
    L11:
        tt5.a.k(TAG, "the documentFragment or its origin url is null");
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L11;
        FragmentManager r102 = r100.getFragmentManager();
        if (r102 == null) goto L13;
        BaseFragment r103 = DocumentFragment.ka0(r101, r100.getArguments());
        INVOKEVIRTUAL_com_bytedance_ee_bear_document_loading_LoadingFailedPlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(r102.beginTransaction(), r100.getId(), r103).commitAllowingStateLoss();
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
        String r100 = i.c(getDocViewModel().getUrl());
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).u5(r100);
        ((k) org.koin.java.a.a(k.class)).d(getDocumentType());
    }

    public LoadingFailedPlugin() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.document.loading.LoadingLayout.c
    public void onFailedRetry(int r100) {
        tt5.a.h(TAG, "onFailedRetry()... errCode = " + r100);
        if (r100 != (-55)) goto L5;
        return;
    L5:
        if (r100 == (-56)) goto L19;
        int r101 = s1.b.f221496a;
        if (r100 != 100) goto L10;
    L15:
        replaceDocumentFragment();
        return;
    L10:
        if (r100 == 601) goto L15;
        if (r100 == 501) goto L15;
        ((DocumentPluginHost) getHost()).getDocumentLoader().load();
        return;
    }

    public void onAttachToUIContainer(DocumentPluginHost r100, t r101) {
        super.onAttachToUIContainer(r100, r101);
        DocLoadingPlugin r102 = (DocLoadingPlugin) findPlugin(DocLoadingPlugin.class);
        if (r102 == null) goto L8;
        r102.setOnRetryListener(this);
        if (i.b(getDocumentType()) == false) goto L9;
        r102.setOnBackSourceDocListener(new e(this));
        return;
    L9:
        return;
    }

    public void onDetachFromUIContainer(DocumentPluginHost r100, t r101) {
        super.onDetachFromUIContainer(r100, r101);
        DocLoadingPlugin r102 = (DocLoadingPlugin) findPlugin(DocLoadingPlugin.class);
        if (r102 == null) goto L6;
        r102.setOnRetryListener(null);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r100, t r101) {
        onAttachToUIContainer((DocumentPluginHost) r100, r101);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r100, t r101) {
        onDetachFromUIContainer((DocumentPluginHost) r100, r101);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r100, t r101) {
        onDetachFromUIContainer((DocumentPluginHost) r100, r101);
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_bytedance_ee_bear_document_loading_LoadingFailedPlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(FragmentTransaction r100, int r101, Fragment r102) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r100, r102, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r101) == false) goto L6;
        return r100;
    L6:
        return r100.replace(r101, r102);
    }
}
