package com.bytedance.sdk.account.monitor;

import android.content.Context;
import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.platform.base.AuthorizeMonitorUtil;
import com.bytedance.sdk.account.utils.g;
import com.bytedance.sdk.account.utils.n;
import com.ss.android.account.k;
import com.ss.android.token.h0;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import org.json.JSONObject;
import wqa.f;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\nH\u0016J\u001e\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n2\u0006\u0010\r\u001a\u00020\bH\u0016J\u001e\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n2\u0006\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\u001a\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016¨\u0006\u0013"}, d2 = {"Lcom/bytedance/sdk/account/monitor/AccountSdkMonitorServiceImpl;", "Lcom/bytedance/sdk/account/monitor/IAccountSdkMonitorService;", "()V", "ensureNotReachHere", "", "tr", "", "message", "", "data", "", "getMonitorCommonParams", "", "event", "getOverrideCommonParams", "isDebug", "onEvent", "params", "Lorg/json/JSONObject;", "account-sdk-core_release"}, k = 1, mv = {1, 1, 15})
public final class AccountSdkMonitorServiceImpl implements IAccountSdkMonitorService {
    public AccountSdkMonitorServiceImpl() {
    }

    @Override // com.bytedance.sdk.account.monitor.IAccountSdkMonitorService
    public boolean isDebug() {
        return false;
    }

    @Override // com.bytedance.sdk.account.monitor.IAccountSdkMonitorService
    public Map<String, Object> getMonitorCommonParams(String r100) {
        String r101 = oc7.a.f522709b;
        LinkedHashMap r102 = new LinkedHashMap();
        int r103 = 0;
        Pair[] r104 = {TuplesKt.to(AuthorizeMonitorUtil.Param.PASSPORT_SDK_VERSION, 60592), TuplesKt.to("passport_sdk_version", 60592)};
    L3:
        if (r103 >= 2) goto L5;
        Pair r105 = r104[r103];
        r102.put(r105.component1(), r105.component2());
        r103 = r103 + 1;
        goto L3
    L5:
        f r106 = k.f406318b;
        if (r106 == null) goto L8;
        Context r107 = r106.getApplicationContext();
    L9:
        String r108 = "";
        if (r107 == null) goto L18;
        String r109 = h0.f449749a;
        if (StringUtils.isEmpty(r109) == true) goto L16;
        r108 = r109;
        goto L18
    L16:
        if (h0.f449750b == true) goto L18;
        h0.f449750b = true;
        r108 = h0.b(r107);
    L18:
        r102.put("process_name", r108);
        if (n.a(r101) == false) goto L21;
        r102.put(BindCardPayConfirmConstants.Key.TRACE_ID, r101);
    L21:
        return r102;
    L8:
        r107 = null;
        goto L9
    }

    @Override // com.bytedance.sdk.account.monitor.IAccountSdkMonitorService
    public Map<String, Object> getOverrideCommonParams(String r100) {
        return MapsKt.mapOf(TuplesKt.to("params_for_special", "uc_login"));
    }

    @Override // com.bytedance.sdk.account.monitor.IAccountSdkMonitorService, zb7.a
    public boolean onEvent(String r100, JSONObject r101) {
        f r102 = k.f406318b;
        if (r102 == null) goto L7;
        g r103 = r102.getMonitor();
        if (r103 == null) goto L7;
        r103.onEvent(r100, r101);
        Unit r104 = Unit.INSTANCE;
    L8:
        if (r104 == null) goto L10;
        return true;
    L10:
        return false;
    L7:
        r104 = null;
        goto L8
    }

    @Override // com.bytedance.sdk.account.monitor.IAccountSdkMonitorService
    public boolean ensureNotReachHere(Throwable r100, String r101, Map<String, String> r102) {
        k.b r103 = k.f406317a;
        return false;
    }
}
