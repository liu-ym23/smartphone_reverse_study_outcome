package com.obric.matrix.platform.sdk.ones.account;

import android.os.Bundle;
import com.huawei.hms.support.feature.result.CommonConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class b {
    public static final void a(a r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "bundle");
        r100.f396908a = r101.getBoolean("loginState", false);
        r100.f396909b = r101.getInt("logoutScene", 0);
        String r102 = r101.getString("secUserId", "");
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r100.f396910c = r102;
        String r103 = r101.getString("userId", "");
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r100.f396911d = r103;
        r100.f396912e = r101.getInt("odinUserType", 0);
        String r104 = r101.getString("token", "");
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r100.f396913f = r104;
        String r105 = r101.getString("innerSsoToken", "");
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r100.f396914g = r105;
        String r106 = r101.getString("avatarUrl", "");
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r100.f396915h = r106;
        r100.f396916i = r101.getInt(CommonConstant.KEY_COUNTRY_CODE, 86);
        String r107 = r101.getString("userName", "");
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r100.f396917j = r107;
        String r108 = r101.getString("screenName", "");
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r100.f396918k = r108;
        String r109 = r101.getString("userEmail", "");
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
        r100.f396919l = r109;
        String r110 = r101.getString("userMobile", "");
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        r100.f396920m = r110;
        r100.f396921n = r101.getBoolean("hasPassword", false);
        r100.f396922o = r101.getInt("userGender", 0);
        r100.f396923p = r101.getBoolean("isNewUser", false);
        String r111 = r101.getString("userSession", "");
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r100.f396924q = r111;
        r100.f396925r = r101.getLong("loginUtcTime", 0);
        String r112 = r101.getString("loginPhoneNumber", "");
        Intrinsics.checkNotNullParameter(r112, "<set-?>");
        r100.f396926s = r112;
    }
}
