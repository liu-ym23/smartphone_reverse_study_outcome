package com.bytedance.ee.bear.document.synced.block.references;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.document.synced.block.references.main.SyncedSourceReferencesMainFragment;
import tb5.m;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements SyncedSourceReferencesMainFragment.a {
    public final /* synthetic */ OfficeSyncedSourceReferencesPlugin a;
    public final /* synthetic */ m b;

    @Override // com.bytedance.ee.bear.document.synced.block.references.main.SyncedSourceReferencesMainFragment.a
    public final void o1() {
        tt5.a.h("SyncedSourceReferencesPlugin", "onMoreClick");
        JSONObject r0 = new JSONObject();
        r0.put("moreId", "syncedBlockReferencesMore");
        k r1 = this.a.getWeb();
        if (r1 == null) goto L6;
        r1.j("lark.biz.util.onSubMoreMenuClick", r0);
        return;
    }

    @Override // com.bytedance.ee.bear.document.synced.block.references.main.SyncedSourceReferencesMainFragment.a
    public final void onClose() {
        tt5.a.h("SyncedSourceReferencesPlugin", "onClose");
        OfficeSyncedSourceReferencesPlugin.access$dismissPickerIfNeed(this.a);
        JSONObject r0 = new JSONObject();
        r0.put("closed", Boolean.TRUE);
        m r1 = this.b;
        if (r1 == null) goto L6;
        r1.b(r0);
        return;
    }

    @Override // com.bytedance.ee.bear.document.synced.block.references.main.SyncedSourceReferencesMainFragment.a
    public final void onCreate() {
        BaseUnspecifiedOrientationPlugin r0 = (BaseUnspecifiedOrientationPlugin) OfficeSyncedSourceReferencesPlugin.access$findPlugin(this.a, BaseUnspecifiedOrientationPlugin.class);
        if (r0 == null) goto L6;
        r0.onOrientationSupportPanelShowing(this.a);
        return;
    }

    @Override // com.bytedance.ee.bear.document.synced.block.references.main.SyncedSourceReferencesMainFragment.a
    public final void onDestory() {
        BaseUnspecifiedOrientationPlugin r0 = (BaseUnspecifiedOrientationPlugin) OfficeSyncedSourceReferencesPlugin.access$findPlugin(this.a, BaseUnspecifiedOrientationPlugin.class);
        if (r0 == null) goto L6;
        r0.onOrientationSupportPanelDismiss(this.a);
        return;
    }

    public a(OfficeSyncedSourceReferencesPlugin r1, m r2) {
        this.a = r1;
        this.b = r2;
    }
}
