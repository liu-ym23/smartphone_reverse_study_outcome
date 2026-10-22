package com.bytedance.upc;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.timon.upc.upc_adapter_impl.UpcLifecycleServiceImpl;
import com.bytedance.upc.common.ICommonBusinessService;
import com.bytedance.upc.common.monitor.UpcMonitor;
import com.bytedance.upc.common.settings.UpcOnlineSettings;
import com.bytedance.upc.common.storage.SpStorage;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class UpcImpl implements IUpc, IPrivacy, IDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f272396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f272397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f272398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f272399d;

    @Override // com.bytedance.upc.IPrivacy
    public final boolean clearPrivacyStatus(boolean r100) {
        return true;
    }

    @Override // com.bytedance.upc.IUpc
    public final boolean open(String r100) {
        return false;
    }

    public UpcImpl() {
        this.f272398c = new AtomicBoolean(false);
        this.f272399d = new AtomicBoolean(false);
    }

    @Override // com.bytedance.upc.IPrivacy
    public final void addPrivacyStatusChangeListener(d r100) {
        e r101 = ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getConfiguration().f272402c;
        if (r101 == null) goto L6;
        r101.a();
        return;
    }

    @Override // com.bytedance.upc.IDialog
    public final void disMissDialog(String r100) {
        k r101 = ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getConfiguration().f272405f;
        if (r101 == null) goto L6;
        r101.b();
        return;
    }

    @Override // com.bytedance.upc.IUpc
    public final boolean load(String r100) {
        a r101 = this.f272397b;
        if (r101 == null) goto L7;
        c r102 = r101.f272401b;
        if (r102 == null) goto L7;
        return r102.load();
    L7:
        return false;
    }

    @Override // com.bytedance.upc.IPrivacy
    public final void removePrivacyStatusChangeListener(d r100) {
        a r101 = ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getConfiguration();
        if (r101 == null) goto L8;
        e r102 = r101.f272402c;
        if (r102 == null) goto L9;
        r102.b();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.upc.IUpc
    public final void updateSettings(String r110) {
        Lazy r100 = UpcOnlineSettings.f272468a;
        JSONObject r101 = new JSONObject(r110);     // Catch: Throwable -> L11
        JSONObject r111 = r101.optJSONObject("data").optJSONObject("settings").optJSONObject("sdk_key_UpcSDK");     // Catch: Throwable -> L11
        if (r111 == null) goto L6;
        long r102 = r111.optLong("upc_privacy_req_frequency");     // Catch: Throwable -> L11
        Lazy r103 = UpcOnlineSettings.f272468a;     // Catch: Throwable -> L11
        ((SpStorage) r103.getValue()).getClass();     // Catch: Throwable -> L11
        SpStorage.a("upc_privacy_req_frequency", r102);     // Catch: Throwable -> L11
        long r104 = r111.optLong("upc_request_permission_frequency");     // Catch: Throwable -> L11
        ((SpStorage) r103.getValue()).getClass();     // Catch: Throwable -> L11
        SpStorage.a("upc_request_permission_frequency", r104);     // Catch: Throwable -> L11
    L6:
        JSONObject r105 = r101.optJSONObject("data").optJSONObject("settings").optJSONObject("upc_helios_settings");     // Catch: Throwable -> L11
        if (r105 == null) goto L9;
        UpcOnlineSettings.a(r105.toString());     // Catch: Throwable -> L11
    L9:
        Objects.toString(r111);     // Catch: Throwable -> L11
        Objects.toString(r105);     // Catch: Throwable -> L11
        boolean r112 = ip7.b.f495310a;     // Catch: Throwable -> L11
        return;
    }

    @Override // com.bytedance.upc.IPrivacy
    public final String getPrivacyStatus(String r100, String r101) {
        e r102 = ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getConfiguration().f272402c;
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.c();
    }

    @Override // com.bytedance.upc.IUpc
    public final void init(final Context r100, final a r101) {
        if (this.f272398c.get() == false) goto L5;
        return;
    L5:
        Lazy r102 = UpcMonitor.f272464a;
        Function0<Unit> r103 = new AnonymousClass1(this, r100, r101);
        long r104 = System.currentTimeMillis();     // Catch: Throwable -> L10
        r103.invoke();     // Catch: Throwable -> L10
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L10
        Lazy r106 = UpcMonitor.f272464a;     // Catch: Throwable -> L10
        r105.put("aid", ((a) r106.getValue()).f272400a);     // Catch: Throwable -> L10
        r105.put(ChameleonOpenTracker.ParamKey.COST, System.currentTimeMillis() - r104);     // Catch: Throwable -> L10
        UpcLifecycleServiceImpl.a r107 = ((a) r106.getValue()).f272408i;     // Catch: Throwable -> L10
        if (r107 == null) goto L12;
        r107.a(r105);     // Catch: Throwable -> L10
    L12:
        this.f272398c.set(true);
        return;
    L10:
        th = move-exception;
        ip7.b.a(th);
        goto L12
    }

    @Override // com.bytedance.upc.IPrivacy
    public final boolean setPrivacyStatus(String r100, String r101) {
        e r102 = ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getConfiguration().f272402c;
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.d();
    }

    @Override // com.bytedance.upc.IUpc
    public final void start(String r100, String r101) {
        if (this.f272398c.get() == true) goto L6;
        return;
    L6:
        if (this.f272399d.get() == false) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r100) == false) goto L11;
        return;
    L11:
        this.f272399d.set(true);
    }

    @Override // com.bytedance.upc.IDialog
    public final void tryCheckPrivacy(Activity r100, Map<String, Object> r101) {
        k r102 = ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getConfiguration().f272405f;
        if (r102 == null) goto L6;
        r102.c();
        return;
    }

    @Override // com.bytedance.upc.IDialog
    public final boolean showDialog(String r100, Activity r101, j r102) {
        k r103 = ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getConfiguration().f272405f;
        if (r103 != null) goto L7;
        return false;
    L7:
        return r103.a();
    }
}
