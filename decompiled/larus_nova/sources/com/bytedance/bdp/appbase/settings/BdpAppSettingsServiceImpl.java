package com.bytedance.bdp.appbase.settings;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdp.appbase.network.BdpFromSource;
import com.bytedance.bdp.appbase.network.BdpNetRequest;
import com.bytedance.bdp.appbase.network.BdpNetResponse;
import com.bytedance.bdp.appbase.network.BdpNetworkManager;
import com.bytedance.bdp.appbase.network.BdpRequestType;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.sdk.open.douyin.settings.f;
import gb4.c;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/bdp/appbase/settings/BdpAppSettingsServiceImpl;", "Lcom/bytedance/bdp/appbase/settings/BdpAppSettingsService;", "<init>", "()V", "bdp-infrastructure_release"}, k = 1, mv = {1, 4, 0})
public final class BdpAppSettingsServiceImpl implements BdpAppSettingsService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f201002a;

    public BdpAppSettingsServiceImpl() {
        this.f201002a = "BdpAppSettingsServiceImpl";
    }

    @Override // com.bytedance.bdp.appbase.settings.BdpAppSettingsService
    public final b d0(Context r310, SettingsRequest r410) {
        g94.b.d(this.f201002a, new Object[]{"Start request settings: " + r410});
        String r110 = r410.toUrl();
        BdpFromSource r111 = BdpFromSource.settings;
        ArrayList r100 = new ArrayList();
        BdpRequestType r101 = BdpRequestType.OK;
        Boolean r311 = Boolean.FALSE;
        HashMap r312 = new HashMap();
        BdpNetResponse r102 = BdpNetworkManager.Companion.with(r310).newCall(new BdpNetRequest(r110, "GET", r111, false, true, false, false, true, false, new c(r100), null, null, null, true, BdpRequestType.HOST, null, 60000, 60000, 60000, true, null, false, Boolean.valueOf(r410.getDyeTagType()), r311, r312)).execute();
        b r103 = new b();
        r103.f201011a = r102.getCode();
        r103.f201012b = r102.getMessage();
        String r104 = r102.stringBody();     // Catch: Exception -> L7
        JSONObject r105 = new JSONObject(r104);     // Catch: Exception -> L7
        g94.b.d(this.f201002a, new Object[]{"Settings are: " + r104});     // Catch: Exception -> L7
        boolean r106 = TextUtils.equals("success", JSONObjectProtectorUtils.getString(r105, "message"));     // Catch: Exception -> L7
        r103.f201013c = r106;     // Catch: Exception -> L7
        if (r106 == false) goto L9;
        r103.f201016f = JSONObjectProtectorUtils.getString(JSONObjectProtectorUtils.getJSONObject(r105, "data"), "ctx_infos");     // Catch: Exception -> L7
        r103.f201015e = JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(r105, "data"), f.f269710g);     // Catch: Exception -> L7
        r103.f201017g = JSONObjectProtectorUtils.getJSONObject(r105, "data").optLong("settings_time", 0);     // Catch: Exception -> L7
        r103.f201014d = JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(r105, "data"), "settings");     // Catch: Exception -> L7
    L9:
        return r103;
    L7:
        e = move-exception;
        g94.b.b(this.f201002a, new Object[]{"Some keys may not found in settings response JSON.", e});
        goto L9
    }
}
