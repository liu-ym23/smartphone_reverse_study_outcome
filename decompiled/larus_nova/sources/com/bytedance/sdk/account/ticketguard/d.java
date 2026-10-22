package com.bytedance.sdk.account.ticketguard;

import com.bytedance.sdk.account.impl.z;
import com.bytedance.sdk.account.utils.m;
import com.ss.android.account.k;
import java.util.Arrays;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static JSONObject f269441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f269442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f269443c = null;

    static {
        f269443c = new m(new HashSet(Arrays.asList(new String[]{"/passport/device/trust_users/", "/passport/device/one_login/"})), null, true);
    }

    public static void a() {
        wqa.f r100 = k.f406318b;
        if (r100 == null) goto L8;
        JSONObject r101 = ((z) z.a(r100.getApplicationContext())).getAccountSettingsConfig();
        if (r101 == null) goto L8;
        JSONObject r102 = r101.optJSONObject("sec_user_id_guard_config");
    L10:
        if (f269441a == r102) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L19;
        f269441a = r102;
        if (r102 == null) goto L17;
        f269442b = r102.optBoolean("enable_sec_user_id_guard", false);
        f269443c.c(f269441a.optJSONArray("sec_user_id_guard_paths"));
        return;
    L17:
        f269442b = false;
        f269443c.c(null);
        return;
    L19:
        return;
    L12:
        r103 = false;
    L8:
        r102 = null;
        goto L10
    }
}
