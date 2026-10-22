package com.bytedance.ee.bear.document.plugin.loading;

import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.doccomponent.api.entity.contentevent.DCLoadStateChangedEvent;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.document.x2;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.bear.k;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleonv2.container.webcontainer.ChameleonSafeReuseWeb;
import z05.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OfficeLoadingFailedPlugin extends DocumentPluginV3 implements g {
    private static final String TAG = "LoadingFailedPlugin";

    public static /* synthetic */ void a(OfficeLoadingFailedPlugin r0) {
        r0.lambda$onAttachToUIContainer$0();
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void replaceDocumentFragment() {
        tt5.a.h(TAG, "replaceDocumentFragment()...");
        rz4.a r0 = (rz4.a) getHostAbilityOrNull(rz4.a.class);
        if (r0 == null) goto L6;
        r0.processContentEvent(new DCLoadStateChangedEvent(DCLoadStateChangedEvent.LoadState.LoadFailAndReplaceDocFragment));
        return;
    L6:
        ChameleonSafeReuseWeb r1 = getHost().getChameleonWeb();
        if ((r1 instanceof ChameleonSafeReuseWeb) == false) goto L9;
        r1.o((WebPluginHost) getHost());
        return;
    L9:
        tt5.a.k(TAG, "replaceDocumentFragment ignored, chameleonWeb is not reusable");
    }

    private int getDocumentType() {
        y3 r0 = getDocumentMetadata();
        if (r0 != null) goto L5;
        return -1;
    L5:
        return r0.getDocumentTypeValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private /* synthetic */ void lambda$onAttachToUIContainer$0() {
        String r0 = i.c(getDocumentMetadata().getUrl());
        if (AppInfoUtils.f().booleanValue() == false) goto L5;
        reloadDocumentFragment(r0, null);
    L6:
        reportEditionDeleteBackClick();
        return;
    L5:
        getActivity().finish();
        ((h) org.koin.java.a.a(h.class)).u5(r0);
        goto L6
    }

    private void reportEditionDeleteBackClick() {
        if (com.bytedance.ee.bear.bizwidget.officesdk.a.a() == true) goto L10;
        return;
    L10:
        ((k) org.koin.java.a.a(k.class)).d(getDocumentType());     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        tt5.a.e(TAG, "reportEditionDeleteBackClick failed", th, false);
    }

    public OfficeLoadingFailedPlugin() {
    }

    @Override // com.bytedance.ee.bear.document.plugin.loading.g
    public void onFailedRetry(int r3) {
        tt5.a.h(TAG, "onFailedRetry()... errCode = " + r3);
        if (r3 != (-55)) goto L5;
        return;
    L5:
        if (r3 == (-56)) goto L25;
        int r0 = a05.c.b.a;
        if (r3 != 100) goto L10;
    L15:
        boolean r4 = true;
    L16:
        if (r4 == false) goto L18;
        replaceDocumentFragment();
        return;
    L18:
        x2 r5 = getDocumentLoader();
        if (r5 == null) goto L24;
        r5.load();
        return;
    L24:
        return;
    L10:
        if (r3 == 601) goto L15;
        if (r3 == 501) goto L15;
        r4 = false;
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToUIContainer(ChameleonPluginHost r1, t r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r1, r2);
        OfficeLoadingPlugin r3 = (OfficeLoadingPlugin) findPlugin(OfficeLoadingPlugin.class);
        if (r3 == null) goto L8;
        r3.setOnRetryListener(this);
        if (i.b(getDocumentType()) == false) goto L9;
        r3.setOnBackSourceDocListener(new c(this));
        return;
    L9:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachFromUIContainer(ChameleonPluginHost r1, t r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r1, r2);
        OfficeLoadingPlugin r3 = (OfficeLoadingPlugin) findPlugin(OfficeLoadingPlugin.class);
        if (r3 == null) goto L6;
        r3.setOnRetryListener(null);
        return;
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }
}
