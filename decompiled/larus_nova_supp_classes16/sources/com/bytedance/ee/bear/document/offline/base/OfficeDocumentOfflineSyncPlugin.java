package com.bytedance.ee.bear.document.offline.base;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.ability.OfflineSyncCollabStatus;
import com.bytedance.ee.bear.document.ability.OfflineSyncCollabStatusParams;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.document.documentinfo.IDocumentInfoPlugin;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.utils.LarkContext;
import h25.d;
import h25.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import nw4.b;
import tb5.m;
import vz4.h;
import vz4.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OfficeDocumentOfflineSyncPlugin extends DocumentPluginV3 implements n, com.bytedance.ee.bear.browser.plugin.a, h {
    private static final String TAG = "OfficeDocumentOfflineSyncPlugin";
    private final List<i> offlineSyncCollabStatusListeners;

    public final class a implements tb5.i<OfflineSyncCollabStatusParams> {
        public final /* synthetic */ OfficeDocumentOfflineSyncPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(OfficeDocumentOfflineSyncPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, m r4) {
            OfflineSyncCollabStatusParams r5 = (OfflineSyncCollabStatusParams) r3;
            if (r5 != null) goto L5;
            tt5.a.k(OfficeDocumentOfflineSyncPlugin.TAG, "SyncCollabStatusHandler skipped, empty data");
            return;
        L5:
            OfflineSyncCollabStatus r0 = r5.getStatus();
            String r1 = r5.getPageToken();
            if (r0 != null) goto L8;
        L9:
            tt5.a.k(OfficeDocumentOfflineSyncPlugin.TAG, "SyncCollabStatusHandler received empty field");
        L10:
            OfficeDocumentOfflineSyncPlugin.access$100(this.a, r5);
            return;
        L8:
            if (TextUtils.isEmpty(r1) == false) goto L10;
            goto L9
        }
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.browser.plugin.a
    public List<com.bytedance.ee.bear.browser.plugin.i> getAbilities() {
        ArrayList r0 = new ArrayList();
        r0.add(this);
        return r0;
    }

    public OfficeDocumentOfflineSyncPlugin() {
        this.offlineSyncCollabStatusListeners = new CopyOnWriteArrayList();
    }

    private void dispatchSyncCollabStatus(OfflineSyncCollabStatusParams r4) {
        if (this.offlineSyncCollabStatusListeners.isEmpty() == false) goto L6;
        tt5.a.h(TAG, "dispatchSyncCollabStatus skipped, no listener");
        return;
    L6:
        tt5.a.h(TAG, "dispatchSyncCollabStatus, status=" + r4.getStatus());
        Iterator<i> r0 = this.offlineSyncCollabStatusListeners.iterator();
    L8:
        if (r0.hasNext() == false) goto L10;
        r0.next().onSyncCollabStatus(r4);
        goto L8
    }

    @Override // vz4.h
    public void addOfflineSyncCollabStatusListener(i r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (this.offlineSyncCollabStatusListeners.contains(r2) == true) goto L9;
        this.offlineSyncCollabStatusListeners.add(r2);
        return;
    }

    @Override // h25.n
    public void handleSyncedDoc(OfflineDoc r5) {
        DocViewModel r0 = getDocViewModel();
        tt5.a.h(TAG, "handleSyncedDoc offlineDoc: " + r5 + "  docViewModel: " + r0);
        if (r5 == null) goto L12;
        if (r0 == null) goto L12;
        if (TextUtils.equals(r5.getFakeToken(), r0.getToken()) == true) goto L10;
        tt5.a.k(TAG, "Not same doc, ignored!");
        return;
    L10:
        handleSyncedDocV2(r5, r0);
        return;
    L12:
        tt5.a.k(TAG, "handleSyncedDoc skipped, nullable input");
    }

    @Override // vz4.h
    public void removeOfflineSyncCollabStatusListener(i r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.offlineSyncCollabStatusListeners.remove(r2);
    }

    public static /* synthetic */ void access$100(OfficeDocumentOfflineSyncPlugin r0, OfflineSyncCollabStatusParams r1) {
        r0.dispatchSyncCollabStatus(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleSyncedDocV2(OfflineDoc r5, DocViewModel r6) {
        String r0 = r6.getUrl();
        String r1 = UriProtector.parse(r0).getLastPathSegment();
        if (r1 == null) goto L5;
        r0 = r0.replace(r1, r5.getObj_token());
    L5:
        String r2 = r6.getOriginUrl();
        String r3 = UriProtector.parse(r2).getLastPathSegment();
        if (r1 == null) goto L8;
        r2 = r2.replace(r3, r5.getOriginToken());
    L8:
        Fragment r4 = getHost().getHostFragment();
        if (r4 == null) goto L13;
        Bundle r7 = r4.getArguments();
        if (r7 == null) goto L13;
        r7.putString("url", r2);
    L13:
        r6.setNewCreateUrl(r0, r2);
        IDocumentInfoPlugin r8 = (IDocumentInfoPlugin) findPlugin(IDocumentInfoPlugin.class);
        if (r8 == null) goto L16;
        r8.requestDocumentInfo();
    L16:
        notifySyncFrontV2(r5, r6.getBearUrl());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void notifySyncFrontV2(OfflineDoc r5, BearUrl r6) {
        JSONObject r0 = new JSONObject();
        r0.put("objToken", r5.getObj_token());
        r0.put("fakeToken", r5.getFakeToken());
        if (r5.getWikiInfo() == null) goto L5;
        boolean r1 = true;
    L6:
        r0.put("isWiki", Boolean.valueOf(r1));
        if (r1 == false) goto L9;
        r0.put("wikiToken", r5.getWikiInfo().getWiki_token());
    L9:
        execJS("javascript:window.lark.biz.handleOfflineCreateSuccess", r0);
        ChameleonPluginHost r7 = getHost();
        if (r7 == null) goto L16;
        if (r6 == null) goto L17;
        o45.a r8 = (o45.a) r7.getWebService(o45.a.class);
        if (r8 == null) goto L18;
        r8.a = r6;
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L5:
        r1 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToUIContainer(ChameleonPluginHost r6, t r7) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r6, r7);
        h25.m r8 = new h25.m("Web");
        d r1 = new d("Web");
        h25.a r0 = new h25.a(getDocViewModel());
        a r2 = new a(this);
        r8.b = this;
        r1.b = this;
        r6.getWeb().h("biz.notify.syncDocInfo", r8);
        r6.getWeb().h("biz.util.modifyOfflineDocInfo", r1);
        r6.getWeb().h("biz.notify.syncCollabStatus", r2);
        r6.getWeb().h("biz.util.checkSyncState", r0);
        ((b) LarkContext.spiByDwarf(b.class)).h(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachFromUIContainer(ChameleonPluginHost r1, t r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r1, r2);
        ((b) LarkContext.spiByDwarf(b.class)).j(this);
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }
}
