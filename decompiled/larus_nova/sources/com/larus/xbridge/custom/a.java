package com.larus.xbridge.custom;

import android.os.Bundle;
import com.bytedance.sdk.account.platform.api.IDouYin2Service;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import com.bytedance.sdk.account.platform.base.Request;
import com.bytedance.sdk.open.douyin.DouYinOpenConfig;
import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class a extends bx7.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f379685c = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f379686b;

    /* JADX INFO: renamed from: com.larus.xbridge.custom.a$a, reason: collision with other inner class name */
    public static final class C4538a {
    }

    static {
    }

    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final String getName() {
        return "account.thirdPartyAuth";
    }

    public a() {
    }

    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final void a(dx7.b r100, ux7.d.C7943d r101, IvyBridgePlatformType r110) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r110, "type");
        if (Intrinsics.areEqual(cx7.a.d(r100, "platform", ""), "douyin") == false) goto L18;
        DouYinOpenConfig r102 = com.bytedance.sdk.open.douyin.a.getConfig();
        Boolean r103 = null;
        if (r102 == null) goto L7;
        String r104 = r102.clientKey;
    L9:
        if (Intrinsics.areEqual(r104, "aw730v27vx2bu2qw") == true) goto L11;
        com.bytedance.sdk.open.douyin.a.init(new DouYinOpenConfig("aw730v27vx2bu2qw"));
    L11:
        HashSet r105 = new HashSet();
        r105.add("user_info");
        HashSet r106 = new HashSet();
        r106.add("mobile");
        r106.add("flow_audio.luna.preference");
        Bundle r107 = new Bundle();
        r107.putString("comment_id", "@9VxThaOEDp4mJyWjdYosV87812DVAcS+B6lNlTaaE20indzEX5V+l7R1aGbk3MWd");
        Request r108 = new Request.Builder().setScopes(r105).setOptionalScopes1(r106).setState("dy_authorize").setCallerLocalEntry("com.larus.nova.douyinapi.DouYinEntryActivity").setExtra(r107).setAuthType(0).build();
        this.f379686b = new b(r101);
        IDouYin2Service r109 = (IDouYin2Service) AuthorizeFramework.getService(IDouYin2Service.class);
        if (r109 == null) goto L15;
        r103 = Boolean.valueOf(r109.authorize(com.bytedance.sdk.account.utils.d.b(), r108, this.f379686b));
    L15:
        if (Intrinsics.areEqual(r103, Boolean.TRUE) == true) goto L19;
        Map<String, Object> r111 = new LinkedHashMap();
        r111.put("code", 0);
        LinkedHashMap r112 = new LinkedHashMap();
        r112.put("code", "");
        r112.put("platform", "douyin");
        r112.put("platformAppId", "8943");
        r112.put("errorCode", -1);
        Unit r113 = Unit.INSTANCE;
        r111.put("data", r112);
        r101.invoke(r111);
        return;
    L19:
        return;
    L7:
        r104 = null;
        goto L9
    }
}
