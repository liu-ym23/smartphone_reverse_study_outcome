package com.bytedance.ee.bear.document.offline.base;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.WebFragment;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfoPlugin;
import com.bytedance.ee.bear.document.rnsync.DocRnImpl;
import com.bytedance.ee.bear.document.z4;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.rn.j;
import com.bytedance.mt.protector.impl.UriProtector;
import h25.d;
import h25.m;
import h25.n;
import tb5.i;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocumentOfflineSyncPlugin extends DocumentPlugin implements n {
    private static final String TAG = "DocumentOfflineSyncPlugin";

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DocumentOfflineSyncPlugin() {
    }

    @Override // h25.n
    public void handleSyncedDoc(OfflineDoc r5) {
        DocViewModel r0 = getDocViewModel();
        a.h(TAG, "handleSyncedDoc offlineDoc: " + r5 + "  docViewModel: " + r0);
        if (TextUtils.equals(r5.getFakeToken(), r0.getToken()) == true) goto L6;
        a.k(TAG, "Not same doc,ignored !");
        return;
    L6:
        handleSyncedDocV2(r5, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleSyncedDocV2(OfflineDoc r6, DocViewModel r7) {
        String r0 = r7.getUrl();
        String r1 = UriProtector.parse(r0).getLastPathSegment();
        if (r1 == null) goto L5;
        r0 = r0.replace(r1, r6.getObj_token());
    L5:
        String r2 = r7.getOriginUrl();
        String r3 = UriProtector.parse(r2).getLastPathSegment();
        if (r1 == null) goto L8;
        r2 = r2.replace(r3, r6.getOriginToken());
    L8:
        WebFragment r4 = ((DocumentPluginHost) getHost()).c();
        Bundle r5 = r4.getArguments();
        if (r5 == null) goto L11;
        r5.putString("url", r2);
    L11:
        FragmentActivity r8 = r4.getActivity();
        if (r8 != null) goto L14;
    L16:
        r7.setNewCreateUrl(r0, r2);
        DocumentInfoPlugin r9 = (DocumentInfoPlugin) findPlugin(DocumentInfoPlugin.class);
        if (r9 == null) goto L19;
        r9.requestDocumentInfo();
    L19:
        notifySyncFrontV2(r6, r7.getBearUrl(), r2);
        return;
    L14:
        if (r8.getIntent() == null) goto L16;
        r8.getIntent().putExtra("url", r2);
        goto L16
    }

    public void onAttachToUIContainer(DocumentPluginHost r3, t r4) {
        super.onAttachToUIContainer(r3, r4);
        m r5 = new m("Web");
        d r0 = new d("Web");
        i r6 = new h25.a(((DocumentPluginHost) getHost()).a());
        r5.b = this;
        r0.b = this;
        bindBridgeHandler("biz.notify.syncDocInfo", r5);
        bindBridgeHandler("biz.util.modifyOfflineDocInfo", r0);
        bindBridgeHandler("biz.util.checkSyncState", r6);
        dx4.a r7 = ((j) org.koin.java.a.a(j.class)).g();
        if ((r7 instanceof DocRnImpl) == false) goto L5;
        ((DocRnImpl) r7).setOfflineSyncListener(this);
        return;
    L5:
        a.k(TAG, "IRn state err:" + r7);
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        dx4.a r3 = ((j) org.koin.java.a.a(j.class)).g();
        if ((r3 instanceof DocRnImpl) == false) goto L6;
        ((DocRnImpl) r3).removeOfflineSyncListener(this);
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

    /* JADX WARN: Multi-variable type inference failed */
    private void notifySyncFrontV2(OfflineDoc r4, BearUrl r5, String r6) {
        if ((((DocumentPluginHost) getHost()).getWeb() instanceof z4) == false) goto L13;
        JSONObject r0 = new JSONObject();
        r0.put("objToken", r4.getObj_token());
        r0.put("fakeToken", r4.getFakeToken());
        if (r4.getWikiInfo() == null) goto L7;
        boolean r1 = true;
    L8:
        r0.put("isWiki", Boolean.valueOf(r1));
        if (r4.getWikiInfo() == null) goto L11;
        r0.put("wikiToken", r4.getWikiInfo().getWiki_token());
    L11:
        execJS("javascript:window.lark.biz.handleOfflineCreateSuccess", r0);
        ((z4) ((DocumentPluginHost) getHost()).getWeb()).t(r5, r6);
        return;
    L7:
        r1 = false;
        goto L8
    }
}
