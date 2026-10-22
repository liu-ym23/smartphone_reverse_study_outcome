package com.larus.xbridge.custom;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class l extends bx7.c {

    public static final class a {
    }

    static {
    }

    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final String getName() {
        return "app.getSecUid";
    }

    public l() {
    }

    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final void a(dx7.b r100, ux7.d.C7943d r101, IvyBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        AccountService r103 = AccountService.f365697a;
        boolean r104 = r103.isLogin().booleanValue();
        if (r104 == false) goto L5;
        String r105 = r103.getSecUserId();
    L6:
        FLogger r106 = FLogger.f375446a;
        StringBuilder r107 = new StringBuilder("app.getSecUid isLogin=");
        r107.append(r104);
        r107.append(", source=");
        if (r104 == false) goto L9;
        String r108 = "accountServiceSecUserId";
    L10:
        r107.append(r108);
        r107.append(", uid=");
        r107.append(r105);
        r106.i("AppGetBannedUserID", r107.toString());
        Map<String, Object> r109 = new LinkedHashMap();
        r109.put("code", 1);
        LinkedHashMap r110 = new LinkedHashMap();
        Intrinsics.checkNotNull(r105);
        r110.put("uid", r105);
        Unit r111 = Unit.INSTANCE;
        r109.put("data", r110);
        r101.invoke(r109);
        return;
    L9:
        r108 = "keva_banned_user_id";
        goto L10
    L5:
        r105 = xg9.b.a().getString("banned_user_id", "");
        goto L6
    }
}
