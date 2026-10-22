package com.bytedance.ee.bear.document;

import android.text.TextUtils;
import com.bytedance.ee.bear.browser.BaseWebPlugin;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import io.reactivex.Flowable;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocumentPlugin extends BaseWebPlugin<DocumentPluginHost> implements yv4.a {
    private static final String TAG = "DocumentPlugin";

    public static /* synthetic */ Object a(Class r0, String r1) {
        return lambda$getServiceFlowable$0(r0, r1);
    }

    public void getBridgeHandlers(Map<String, tb5.i<?>> r1) {
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DocViewModel getDocViewModel() {
        return ((DocumentPluginHost) getHost()).a();
    }

    public String getDocumentTitle() {
        if (getDocViewModel() != null) goto L5;
        return null;
    L5:
        if (getDocViewModel().getDocName() != null) goto L7;
        return null;
    L7:
        return (String) getDocViewModel().getDocName().getValue();
    }

    public String getUrl() {
        DocViewModel r0 = getDocViewModel();
        if (r0 != null) goto L7;
        tt5.a.k(TAG, "getUrl: docViewModel is null");
        return "";
    L7:
        return r0.getUrl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean isVCFollow() {
        if (((e4) ((DocumentPluginHost) getHost()).getHostAbility(e4.class)).getDocumentMetadata().getOpenSource() != DocsOpenSource.vc) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean shouldDisableLandscape() {
        DocViewModel r0 = getDocViewModel();
        if (r0 != null) goto L7;
        tt5.a.k(TAG, "getUrl: docViewModel is null");
        return true;
    L7:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.slides.presentation_enable") == true) goto L9;
    L11:
        boolean r2 = false;
    L13:
        if (TextUtils.equals(r0.getDocumentType(), sbb.e.o.getType()) == false) goto L15;
    L20:
        return false;
    L15:
        if (TextUtils.equals(r0.getDocumentType(), sbb.e.k.getType()) == true) goto L20;
        if (r2 == true) goto L20;
        return !ku5.c.k(getContext());
    L9:
        if (TextUtils.equals(r0.getDocumentType(), sbb.e.m.getType()) == false) goto L11;
        r2 = true;
        goto L13
    }

    public DocumentPlugin() {
    }

    public <T> Flowable<T> getServiceFlowable(final Class<T> r3) {
        return Flowable.just("").subscribeOn(fo5.d.b()).map(new z3(r3));
    }

    private static /* synthetic */ Object lambda$getServiceFlowable$0(Class r0, String r1) throws Exception {
        return org.koin.java.a.a(r0);
    }
}
