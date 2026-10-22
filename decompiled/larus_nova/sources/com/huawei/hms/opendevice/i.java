package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.aaid.encrypt.PushEncrypter;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.support.log.HMSLog;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public class i extends PushPreferences {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f277537c = "i";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f277538b;

    public void a() {
        Map<String, ?> r100 = getAll();
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        if (r100.keySet().isEmpty() == true) goto L25;
        Iterator<String> r101 = r100.keySet().iterator();
    L9:
        if (r101.hasNext() == false) goto L26;
        String r102 = r101.next();
        if ("push_kit_auto_init_enabled".equals(r102) == true) goto L9;
        if ("_proxy_init".equals(r102) == true) goto L9;
        removeKey(r102);
        goto L9
    L26:
        return;
    }

    private i(Context r100) {
        super(r100, "push_client_self_info");
        this.f277538b = r100;
    }

    public String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return "";
    L10:
        return PushEncrypter.decrypter(this.f277538b, getString(r100));
    L7:
        e = move-exception;
        HMSLog.e(f277537c, "getSecureData" + e.getMessage());
        return "";
    }

    public String b(String r100) {
    L8:
        e = move-exception;
        HMSLog.e(f277537c, "getSecureData" + e.getMessage());
        return "";
    L3:
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return a("token_info_v2");
    L7:
        return a(r100);
    }

    public boolean c(String r100) {
    L8:
        e = move-exception;
        HMSLog.e(f277537c, "removeToken" + e.getMessage());
        return false;
    L3:
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return removeKey("token_info_v2");
    L7:
        return removeKey(r100);
    }

    public static i a(Context r100) {
        return new i(r100);
    }

    public boolean a(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return false;
    L10:
        return saveString(r100, PushEncrypter.encrypter(this.f277538b, r101));
    L7:
        e = move-exception;
        HMSLog.e(f277537c, "saveSecureData" + e.getMessage());
        return false;
    }

    public boolean b(String r100, String r101) {
    L8:
        e = move-exception;
        HMSLog.e(f277537c, "saveSecureData" + e.getMessage());
        return false;
    L3:
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return a("token_info_v2", r101);
    L7:
        return a(r100, r101);
    }
}
