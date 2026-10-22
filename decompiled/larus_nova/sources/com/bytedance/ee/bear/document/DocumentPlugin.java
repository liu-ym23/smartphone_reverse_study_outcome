package com.bytedance.ee.bear.document;

import android.text.TextUtils;
import com.bytedance.ee.bear.browser.BaseWebPlugin;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import io.reactivex.Flowable;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public class DocumentPlugin extends BaseWebPlugin<DocumentPluginHost> implements yv4.a {
    private static final String TAG = "DocumentPlugin";

    public static /* synthetic */ Object a(Class r100, String r101) {
        return lambda$getServiceFlowable$0(r100, r101);
    }

    public void getBridgeHandlers(Map<String, tb5.i<?>> r100) {
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
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
        return getDocViewModel().getDocName().getValue();
    }

    public String getUrl() {
        DocViewModel r100 = getDocViewModel();
        if (r100 != null) goto L7;
        tt5.a.k(TAG, "getUrl: docViewModel is null");
        return "";
    L7:
        return r100.getUrl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean isVCFollow() {
        if (((e4) ((DocumentPluginHost) getHost()).getHostAbility(e4.class)).getDocumentMetadata().getOpenSource() != DocsOpenSource.f216966vc) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean shouldDisableLandscape() {
        DocViewModel r100 = getDocViewModel();
        if (r100 != null) goto L7;
        tt5.a.k(TAG, "getUrl: docViewModel is null");
        return true;
    L7:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.slides.presentation_enable") == true) goto L9;
    L11:
        boolean r101 = false;
    L13:
        if (TextUtils.equals(r100.getDocumentType(), sbb.e.f541304o.getType()) == false) goto L15;
    L20:
        return false;
    L15:
        if (TextUtils.equals(r100.getDocumentType(), sbb.e.f541300k.getType()) == true) goto L20;
        if (r101 == true) goto L20;
        return !ku5.c.k(getContext());
    L9:
        if (TextUtils.equals(r100.getDocumentType(), sbb.e.f541302m.getType()) == false) goto L11;
        r101 = true;
        goto L13
    }

    public DocumentPlugin() {
    }

    public <T> Flowable<T> getServiceFlowable(final Class<T> r100) {
        return (Flowable<T>) Flowable.just("").subscribeOn(fo5.d.b()).map(new z3(r100));
    }

    private static /* synthetic */ Object lambda$getServiceFlowable$0(Class r100, String r101) throws Exception {
        return org.koin.java.a.a(r100);
    }
}
