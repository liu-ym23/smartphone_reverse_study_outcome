package com.bytedance.ee.bear.document.entersuite;

import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.rn.f;
import f15.b;
import f15.c;
import fo5.d;
import io.reactivex.Flowable;
import java.util.ArrayList;
import org.koin.java.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class EnterSuitePlugin extends DocumentPlugin {
    private static final String TAG = "EnterSuitePlugin";

    public static /* synthetic */ void c(Throwable r0) {
        lambda$onDetachFromUIContainer$3(r0);
    }

    public static /* synthetic */ void d(EnterSuitePlugin r0, String r1) {
        r0.lambda$onAttachToUIContainer$0(r1);
    }

    public static /* synthetic */ void e(EnterSuitePlugin r0, String r1) {
        r0.lambda$onDetachFromUIContainer$2(r1);
    }

    public static /* synthetic */ void f(Throwable r0) {
        lambda$onAttachToUIContainer$1(r0);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public EnterSuitePlugin() {
    }

    private /* synthetic */ void lambda$onAttachToUIContainer$0(String r4) throws Exception {
        DocViewModel r5 = getDocViewModel();
        if (r5 == null) goto L6;
        ArrayList r0 = new ArrayList();
        r0.add(new OfflineDoc(r5.getToken(), r5.getDocumentTypeValue()));
        ((f) a.a(f.class)).a(r0);
        return;
    }

    private static void lambda$onAttachToUIContainer$1(Throwable r2) throws Exception {
        tt5.a.f(TAG, r2, false);
    }

    private /* synthetic */ void lambda$onDetachFromUIContainer$2(String r4) throws Exception {
        DocViewModel r5 = getDocViewModel();
        if (r5 == null) goto L6;
        ArrayList r0 = new ArrayList();
        r0.add(new OfflineDoc(r5.getToken(), r5.getDocumentTypeValue()));
        ((f) a.a(f.class)).d(r0);
        return;
    }

    private static void lambda$onDetachFromUIContainer$3(Throwable r2) throws Exception {
        tt5.a.f(TAG, r2, false);
    }

    public void onAttachToUIContainer(DocumentPluginHost r2, t r3) {
        super.onAttachToUIContainer(r2, r3);
        Flowable.just("").observeOn(d.a()).subscribe(new f15.a(this), new b());
    }

    public void onDetachFromUIContainer(DocumentPluginHost r2, t r3) {
        super.onDetachFromUIContainer(r2, r3);
        Flowable.just("").observeOn(d.a()).subscribe(new c(this), new f15.d());
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
}
