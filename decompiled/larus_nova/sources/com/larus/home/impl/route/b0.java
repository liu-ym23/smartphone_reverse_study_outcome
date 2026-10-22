package com.larus.home.impl.route;

import android.content.Context;
import android.net.Uri;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larksuite.framework.apiplugin.common.OpenPlatform$Requests$OnActivityResult;
import com.larus.applog.api.IApplog;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class b0 implements q97.a {
    public b0() {
    }

    @Override // q97.a
    public final boolean b(com.bytedance.router.c r100) {
        return true;
    }

    @Override // q97.a
    public final boolean a(Context r100, com.bytedance.router.c r101) {
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("rd_open_route -> ");
        int r104 = u0.f346102a;
        String r105 = null;
        if (r101 == null) goto L7;
        Uri r106 = r101.f267530d;
        if (r106 == null) goto L7;
        String r107 = r106.toString();
    L8:
        r103.append(u0.a(r107));
        r102.d("CommonTrackRouter", r103.toString());
        IApplog.Companion r108 = IApplog.f287053a;
        JSONObject r109 = new JSONObject();
        if (r101 == null) goto L13;
        Uri r110 = r101.f267530d;
        if (r110 == null) goto L13;
        String r111 = r110.toString();
    L14:
        r109.put(RemoteMessageConst.Notification.INTENT_URI, u0.a(r111));
        if (r101 == null) goto L19;
        Uri r112 = r101.f267537k;
        if (r112 == null) goto L19;
        r105 = r112.toString();
    L19:
        r109.put(OpenPlatform$Requests$OnActivityResult.INTENT_DATA, r105);
        Unit r113 = Unit.INSTANCE;
        r108.reportEvent("rd_open_route", r109);
        return false;
    L13:
        r111 = null;
    L7:
        r107 = null;
        goto L8
    }
}
