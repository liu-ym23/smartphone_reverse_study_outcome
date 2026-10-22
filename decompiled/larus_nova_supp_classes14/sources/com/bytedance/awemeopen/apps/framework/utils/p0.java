package com.bytedance.awemeopen.apps.framework.utils;

import android.text.TextUtils;
import com.bytedance.awemeopen.bizmodels.profile.ShowIdentifyAuthInfo;
import com.bytedance.awemeopen.bizmodels.profile.TrackerParams;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.bizmodels.profile.UserProfileShowStruct;
import com.bytedance.awemeopen.domain.base.repo.GsonHolder;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class p0 {
    public static String a(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return "";
    L5:
        if (r5.length() == 0) goto L18;
        int r0 = r5.length();
        if (r0 != 1) goto L11;
        return r5;
    L11:
        if (r0 != 2) goto L15;
        return r5.charAt(0) + "*";
    L15:
        return r5.charAt(0) + "*" + r5.charAt(r0 - 1);
    L18:
        return "";
    }

    public static q04.c b(User r10) {
        String r1 = "";
        if (r10.J() == null) goto L12;
        com.bytedance.awemeopen.bizmodels.profile.k r0 = (com.bytedance.awemeopen.bizmodels.profile.k) r10.J().get("yellow_v_identify");
        com.bytedance.awemeopen.bizmodels.profile.k r2 = (com.bytedance.awemeopen.bizmodels.profile.k) r10.J().get("OperationRoleBadge");
        if (r2 != null) goto L7;
        String r3 = "";
    L8:
        if (r0 == null) goto L11;
        r1 = r0.b();
    L11:
        String r8 = r1;
        String r9 = r3;
    L13:
        com.bytedance.awemeopen.bizmodels.profile.i r4 = r10.w();
        UserProfileShowStruct r5 = r10.K();
        if (r5 == null) goto L29;
        List r6 = r5.getIdentifyAuthInfos();
        if (r6 == null) goto L29;
        if (r6.isEmpty() == true) goto L29;
        Gson r7 = GsonHolder.a();
        Iterator r11 = r6.iterator();
    L21:
        if (r11.hasNext() == false) goto L29;
        ShowIdentifyAuthInfo r12 = (ShowIdentifyAuthInfo) r11.next();
        if (r12 == null) goto L21;
        TrackerParams r13 = (TrackerParams) GsonProtectorUtils.fromJson(r7, r12.getMobInfo(), TrackerParams.class);
        if (r13 == null) goto L21;
        if (r13.getCertType() != 14) goto L21;
        boolean r14 = true;
    L31:
        return new q04.c(r4, r14, r10.L(), r10.j(), r8, r9);
    L29:
        r14 = false;
        goto L31
    L7:
        r3 = r2.b();
        goto L8
    L12:
        r8 = "";
        r9 = r8;
        goto L13
    }

    public static boolean c(User r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.e() == null) goto L12;
        if (r3.e().a() != 1) goto L17;
        return true;
    L17:
        return false;
    L12:
        if (r3.f() > 0) goto L14;
        return false;
    L14:
        if (TextUtils.isEmpty(r3.j()) == true) goto L19;
        return true;
    L19:
        return false;
    }

    public static boolean d(User r3) {
        d14.a r0 = b14.a.a;
        int r1 = b14.a.a(y24.d.class).h3(r3.u(), r3.m());
        if (e(r3.u()) == false) goto L5;
    L11:
        return false;
    L5:
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L11;
        if (r3.S() == false) goto L11;
        return true;
    }

    public static boolean e(String r1) {
        if (r1 != null) goto L5;
        return false;
    L5:
        d14.a r0 = b14.a.a;
        com.bytedance.awemeopen.bizmodels.user.c r2 = b14.a.a(k34.b.class).getAccessToken();
        if (r2 == null) goto L8;
        String r3 = r2.b;
    L10:
        return TextUtils.equals(r3, r1);
    L8:
        r3 = null;
        goto L10
    }
}
