package com.bytedance.ee.bear.bitable.pro;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.BlockSimpleInfo;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.Gson;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class BitableProPlugin extends DocumentPlugin implements com.bytedance.ee.bear.document.bitable.g, com.bytedance.ee.bear.document.orientation.p {
    private static final String GET_PRO_UPDATE_EFFECT_DATA = "window.lark.biz.bitable.getProUpdateEffectData";
    private static final String GET_PRO_UPDATE_STATUS = "window.lark.biz.bitable.getProUpdateStatus";
    private static final String TAG = "BitableProPlugin";
    private static final String UPGRADE_BASE = "window.lark.biz.bitable.upgradeBase";
    private static final String UPGRADE_BASE_COMPLETED = "biz.bitable.upgradeBaseCompleted";
    private static final String UPGRADE_SSC = "window.lark.biz.bitable.upgradeSSC";
    private static final String UPGRADE_SSC_RESULT = "biz.bitable.sscUpgradeNotify";
    private BitableProViewModel bitableProViewModel;

    public static class ProUpgradeData implements NonProguard {

        @JSONField(name = "code")
        public int code;

        public ProUpgradeData() {
        }
    }

    public class a implements BitableProViewModel.c {
        public final /* synthetic */ BitableProPlugin a;

        public a(BitableProPlugin r1) {
            this.a = r1;
        }
    }

    public class b implements tb5.i<ProUpgradeData> {
        public final /* synthetic */ BitableProPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(BitableProPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r4, tb5.m r5) {
            ProUpgradeData r6 = (ProUpgradeData) r4;
            if (r6 != null) goto L6;
            tt5.a.d(BitableProPlugin.TAG, "BitableProUpgradeHandler data is null");
            return;
        L6:
            if (BitableProPlugin.access$100(this.a).getIsPro().getValue() == null) goto L14;
            boolean r0 = ((Boolean) BitableProPlugin.access$100(this.a).getIsPro().getValue()).booleanValue();
            int r7 = r6.code;
            tt5.a.b(BitableProPlugin.TAG, "upgrade pro " + r7 + "current is pro " + r0);
            if (r7 != 0) goto L10;
            BitableProPlugin.access$100(this.a).updateIsPro(!r0);
            BitableProPlugin.access$100(this.a).updateProSuccess(true);
            return;
        L10:
            if (r7 != 1) goto L16;
            BitableProPlugin.access$100(this.a).updateProSuccess(false);
            return;
        L16:
            return;
        }
    }

    public class c implements tb5.i<String> {
        public final /* synthetic */ BitableProPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(BitableProPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, tb5.m r4) {
            String r5 = (String) r3;
            tt5.a.h(BitableProPlugin.TAG, "upgrade ssc result: " + r5);
        L7:
            e = move-exception;
            tt5.a.e(BitableProPlugin.TAG, "upgrade ssc err", e, false);
            return;
        L4:
            if (new JSONObject(r5).optBoolean("success", false) == false) goto L12;
            BitableProPlugin.access$100(this.a).getUpdateStatus().setValue(PermissionUpdateStatus.Updated);     // Catch: JSONException -> L7
            return;
        }
    }

    public static /* synthetic */ void c(ObservableEmitter r0, String r1) {
        lambda$getProUpdateEffectData$3(r0, r1);
    }

    public static /* synthetic */ void d(ObservableEmitter r0, String r1) {
        lambda$getProUpdateStatus$1(r0, r1);
    }

    public static /* synthetic */ void e(BitableProPlugin r0, ObservableEmitter r1) {
        r0.lambda$getProUpdateStatus$2(r1);
    }

    public static /* synthetic */ void f(BitableProPlugin r0, ObservableEmitter r1) {
        r0.lambda$getProUpdateEffectData$4(r1);
    }

    public static /* synthetic */ void g(BitableProPlugin r0, Boolean r1) {
        r0.lambda$onAttachToHost$0(r1);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.document.orientation.p
    public boolean shouldDisableLandscape() {
        return true;
    }

    private Observable<PermissionUpdateStatus> getProUpdateStatus() {
        return Observable.create(new x(this));
    }

    public Observable<PermEffectFieldData> getProUpdateEffectData() {
        return Observable.create(new b0(this));
    }

    private com.bytedance.ee.bear.browser.plugin.s getTransactionParams() {
        return com.bytedance.ee.bear.browser.plugin.s.a(2130772290, 2130772289, 2130772288, 2130772293);
    }

    public void upgradeSSC() {
        getWeb().execJS(UPGRADE_SSC);
    }

    public BitableProPlugin() {
    }

    public static /* synthetic */ Observable access$000(BitableProPlugin r0) {
        return r0.getProUpdateStatus();
    }

    public static /* synthetic */ BitableProViewModel access$100(BitableProPlugin r0) {
        return r0.bitableProViewModel;
    }

    private void addAnalyticCommonParams(String r4) {
        com.bytedance.ee.bear.contract.d r0 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        r0.h("bitableFormPermCommonParams");
        r0.j("bitableFormPermCommonParams", "bitable_id", du5.b.g(r4));
        r0.j("bitableFormPermCommonParams", "bitable_type", "bitable_app");
        r0.j("bitableFormPermCommonParams", "is_full_screen", "true");
    }

    private /* synthetic */ void lambda$getProUpdateEffectData$4(final ObservableEmitter r4) throws Exception {
        getWeb().a(GET_PRO_UPDATE_EFFECT_DATA, new com.alibaba.fastjson.JSONObject(), new a0(r4));
    }

    private /* synthetic */ void lambda$getProUpdateStatus$2(final ObservableEmitter r4) throws Exception {
        getWeb().a(GET_PRO_UPDATE_STATUS, new com.alibaba.fastjson.JSONObject(), new y(r4));
    }

    private /* synthetic */ void lambda$onAttachToHost$0(Boolean r3) {
        BaseUnspecifiedOrientationPlugin r0 = (BaseUnspecifiedOrientationPlugin) findPlugin(BaseUnspecifiedOrientationPlugin.class);
        if (r0 != null) goto L5;
        return;
    L5:
        if (Boolean.TRUE.equals(r3) == false) goto L7;
        r0.onOrientationSupportPanelShowing(this);
        return;
    L7:
        r0.onOrientationSupportPanelDismiss(this);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        r3.put(UPGRADE_BASE_COMPLETED, new b(this));
        r3.put(UPGRADE_SSC_RESULT, new c(this));
    }

    public void onAttachToHost(DocumentPluginHost r3) {
        super.onAttachToHost(r3);
        r3.registerHostAbility(this);
        BitableProViewModel r4 = (BitableProViewModel) viewModel(BitableProViewModel.class);
        this.bitableProViewModel = r4;
        r4.setDelegate(new a(this));
        this.bitableProViewModel.disableLandscape().observe(getLifecycleOwner(), new z(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    private static /* synthetic */ void lambda$getProUpdateEffectData$3(ObservableEmitter r2, String r3) {
        PermEffectFieldData r4 = (PermEffectFieldData) new Gson().fromJson(r3, PermEffectFieldData.class);     // Catch: Exception -> L8
        if (r4 == null) goto L5;
        r2.onNext(r4);     // Catch: Exception -> L8
    L6:
        r2.onComplete();     // Catch: Exception -> L8
        return;
    L5:
        r2.onError(new Throwable("effect data is null"));     // Catch: Exception -> L8
    L8:
        e = move-exception;
        r2.onError(e);
    }

    private static void lambda$getProUpdateStatus$1(ObservableEmitter r8, String r9) {
        JSONObject r2 = new JSONObject(r9);     // Catch: JSONException -> L9
        PermissionUpdateStatus.a r3 = PermissionUpdateStatus.Companion;     // Catch: JSONException -> L9
        String r4 = r2.optString("status", "");     // Catch: JSONException -> L9
        r3.getClass();     // Catch: JSONException -> L9
        PermissionUpdateStatus[] r5 = PermissionUpdateStatus.values();     // Catch: JSONException -> L9
        int r6 = r5.length;     // Catch: JSONException -> L9
        int r7 = 0;
    L4:
        if (r7 >= r6) goto L11;
        PermissionUpdateStatus r10 = r5[r7];     // Catch: JSONException -> L9
        if (TextUtils.equals(r10.getValue(), r4) == true) goto L12;
        r7 = r7 + 1;     // Catch: JSONException -> L9
    L12:
        if (r10 == null) goto L14;
        r8.onNext(r10);     // Catch: JSONException -> L9
    L17:
        r8.onComplete();
        return;
    L14:
        tt5.a.d(TAG, "getProUpdateStatus is null " + r9);     // Catch: JSONException -> L9
        r8.onError(new Throwable("status is null"));     // Catch: JSONException -> L9
        goto L17
    L11:
        r10 = null;
    L9:
        e = move-exception;
        tt5.a.e(TAG, "getProUpdateStatus", e, false);
        r8.onError(e);
        goto L17
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        super.onDetachFromUIContainer(r1, r2);
        getUIContainer().d(this);
    }

    public void sendProUpgrade(boolean r4, String r5) {
        com.alibaba.fastjson.JSONObject r0 = new com.alibaba.fastjson.JSONObject();
        r0.put("needSendCS", Boolean.TRUE);
        r0.put("checked", Boolean.valueOf(r4));
        if (TextUtils.isEmpty(r5) == true) goto L5;
        r0.put("roleName", r5);
    L5:
        getWeb().j(UPGRADE_BASE, r0);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    private void ensureFragment(String r4, String r5, boolean r6, ArrayList<BlockSimpleInfo> r7, ArrayList<BlockSimpleInfo> r8) {
        com.bytedance.ee.bear.browser.plugin.t r0 = getUIContainer();
        if (r0.l(this) == null) goto L5;
        return;
    L5:
        Bundle r1 = new Bundle();
        r1.putString("extra_token", r4);
        r1.putString("extra_owner_id", r5);
        r1.putSerializable("extra_table_list", r7);
        r1.putSerializable("extra_block_list", r8);
        r1.putBoolean("extra_open_default_role", r6);
        r0.e(this, instantiateFragment(BitableProFragment.class, r1), getTransactionParams());
        this.bitableProViewModel.updateLandscape(true);
    }

    @Override // com.bytedance.ee.bear.document.bitable.g
    public void showBitableProFragment(String r7, String r8, boolean r9, com.bytedance.ee.bear.document.bitable.c r10, ArrayList<BlockSimpleInfo> r11, ArrayList<BlockSimpleInfo> r12) {
        if (isUIContainerAttached() == true) goto L5;
        return;
    L5:
        int r0 = com.bytedance.ee.bear.bitable.c.a;
        int r1 = com.bytedance.ee.bear.bitable.n.a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.mobile.advperm_lynx_enable") == false) goto L9;
        getWeb().execJS("window.lark.biz.bitable.showAdvPermPanel");
        return;
    L9:
        this.bitableProViewModel.setProInfo(r10);
        c0 r13 = new c0(r7, r11, r12);
        this.bitableProViewModel.setRepository(r13);
        addAnalyticCommonParams(r7);
        ensureFragment(r7, r8, r9, r11, r12);
    }
}
