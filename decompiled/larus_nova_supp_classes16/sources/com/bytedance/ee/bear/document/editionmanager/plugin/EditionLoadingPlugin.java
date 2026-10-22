package com.bytedance.ee.bear.document.editionmanager.plugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.browser.WebFragment;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.d4;
import com.bytedance.ee.bear.document.editionmanager.EditionViewModel;
import com.bytedance.ee.bear.document.z5;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.k;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import e15.f;
import e15.g;
import org.koin.java.a;
import r35.d;
import s45.p;
import sbb.e;
import w05.b;
import w05.i;
import z05.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class EditionLoadingPlugin extends DocumentPluginV2 implements d4 {
    private static final String TAG = "EditionLoadingPlugin";
    private h interceptor;
    private EditionViewModel mViewModel;

    public static /* synthetic */ void a(EditionLoadingPlugin r0, Boolean r1) {
        r0.lambda$onAttachToHost$0(r1);
    }

    public static /* synthetic */ void c(i r0, String r1, int r2, DocPermission r3) {
        lambda$requestEditionPermission$1(r0, r1, r2, r3);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.document.d4
    public boolean isEditionDoc() {
        if (getDocViewModel() != null) goto L5;
        return false;
    L5:
        return getDocViewModel().isEditionDoc();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin
    public void removeFragment() {
        super.removeFragment();
        TitleBar r0 = getTitleBar();
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(getDocViewModel().getOpenSource().name(), DocsOpenSource.base_instruction_docx.name()) == true) goto L9;
        r0.getTitleBarLayout().setVisibility(0);
        return;
    }

    public EditionLoadingPlugin() {
    }

    public EditionViewModel getViewModel() {
        return this.mViewModel;
    }

    private void clearEditionDocumentIfNeed(PluginHost r3) {
        if (((DocumentPluginHost) r3).a().isEditionDoc() == false) goto L6;
        DocViewModel r4 = (DocViewModel) getDocumentMetadata();
        ((k) a.a(k.class)).l(r4.getToken(), r4.getEditionId());
        return;
    }

    private void initEditionDocumentIfNeed(PluginHost r7) {
        if (((DocumentPluginHost) r7).a().isEditionDoc() == false) goto L6;
        k r0 = (k) a.a(k.class);
        DocViewModel r8 = (DocViewModel) getDocumentMetadata();
        r0.g(r8.getUrl(), r8.getEditionToken(), r8.getEditionId(), r8.getEditionName(), r8.getToken());
        return;
    }

    private /* synthetic */ void lambda$onAttachToHost$0(Boolean r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.booleanValue() == true) goto L8;
        removeFragment();
        return;
    }

    private void requestEditionPermission(PluginHost r6) {
        final String r7 = ((DocumentPluginHost) r6).a().getEditionToken();
        if (TextUtils.isEmpty(r7) == false) goto L5;
        return;
    L5:
        if (getDocViewModel() == null) goto L9;
        final int r0 = getDocViewModel().getDocumentTypeValue();
        final i r1 = ((b) getHost().getHostAbility(b.class)).getDocumentInfoProvider();
        r1.e(r7, r0);
        r1.c().observe(getLifecycleOwner(), new g(r1, r7, r0));
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r5) {
        super.onAttachToHost(r5);
        r5.registerHostAbility(this);
        initEditionDocumentIfNeed(r5);
        this.interceptor = new h(r5);
        ((com.bytedance.ee.bear.route.h) a.a(com.bytedance.ee.bear.route.h.class)).pc(this.interceptor, d.class, h.class);
        EditionViewModel r0 = (EditionViewModel) q.c(r5, EditionViewModel.class, null);
        this.mViewModel = r0;
        r0.setSourceToken(((DocumentPluginHost) getHost()).getDocumentMetadata().getToken());
        this.mViewModel.getLoadingActive().observe(getLifecycleOwner(), new f(this));
        requestEditionPermission(r5);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromHost(PluginHost r3) {
        super.onDetachFromHost(r3);
        ((com.bytedance.ee.bear.route.h) a.a(com.bytedance.ee.bear.route.h.class)).s5(this.interceptor);
        clearEditionDocumentIfNeed(r3);
    }

    public void replaceDocumentFragment(String r5) {
        tt5.a.h(TAG, "replaceDocumentFragment()...");
        WebFragment r0 = ((DocumentPluginHost) getHost()).c();
        if (r0 != null) goto L5;
    L19:
        tt5.a.k(TAG, "the documentFragment or its origin url is null");
        return;
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L19;
        if (r0.getFragmentManager() == null) goto L21;
        Bundle r1 = r0.getArguments();
        BearUrl r2 = p.a().Z(r5);
        if (r1 != null) goto L12;
    L14:
        z5 r3 = (z5) getHost().getHostAbilityOrNull(z5.class);
        if (r3 == null) goto L17;
        r3.reloadDocumentFragment(r5, null);
        return;
    L17:
        tt5.a.h(TAG, "reloadAbility is null");
        return;
    L12:
        if (e.e(r2.a) == e.n) goto L14;
        r1.remove("wiki_info");
        goto L14
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromUIContainer(PluginHost r2, t r3) {
        super.onDetachFromUIContainer(r2, r3);
        this.mViewModel.updateLoadingActive(false);
        r2.unregisterHostAbility(this);
    }

    private static /* synthetic */ void lambda$requestEditionPermission$1(i r0, String r1, int r2, DocPermission r3) {
        r0.e(r1, r2);
    }
}
