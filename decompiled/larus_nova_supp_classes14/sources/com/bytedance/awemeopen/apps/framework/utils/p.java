package com.bytedance.awemeopen.apps.framework.utils;

import android.util.Base64;
import com.bytedance.awemeopen.infra.base.settings.AoSettings;
import com.bytedance.awemeopen.servicesapi.setting.AoSDKSettingsService;
import java.nio.charset.Charset;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class p {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        String r3 = "";
        String r1 = ((AoSDKSettingsService) AoSettings.a.getValue()).getSettings().optString("maas_key", "");
        if (r1 == null) goto L9;
        r3 = r1;
    L9:
        Charset r2 = Charsets.UTF_8;
        if (r3.getBytes(r2).length == 16) goto L18;
        return null;
    L18:
        byte[] r6 = Base64.decode(r5, 0);     // Catch: Exception -> L15
        SecretKeySpec r4 = new SecretKeySpec(r3.getBytes(r2), "AES");     // Catch: Exception -> L15
        Cipher r7 = Cipher.getInstance("AES/ECB/PKCS5Padding");     // Catch: Exception -> L15
        r7.init(2, r4);     // Catch: Exception -> L15
        return new String(r7.doFinal(r6), r2);
    L15:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
