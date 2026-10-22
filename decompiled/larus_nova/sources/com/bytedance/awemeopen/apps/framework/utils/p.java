package com.bytedance.awemeopen.apps.framework.utils;

import android.util.Base64;
import com.bytedance.awemeopen.infra.base.settings.AoSettings;
import com.bytedance.awemeopen.servicesapi.setting.AoSDKSettingsService;
import com.bytedance.crypto.utils.CryptoConst;
import java.nio.charset.Charset;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes14.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f197737a = 0;

    static {
    }

    public static String a(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        String r101 = "";
        String r102 = ((AoSDKSettingsService) AoSettings.f198802a.getValue()).getSettings().optString("maas_key", "");
        if (r102 == null) goto L9;
        r101 = r102;
    L9:
        Charset r103 = Charsets.UTF_8;
        if (r101.getBytes(r103).length == 16) goto L18;
        return null;
    L18:
        byte[] r104 = Base64.decode(r100, 0);     // Catch: Exception -> L15
        SecretKeySpec r105 = new SecretKeySpec(r101.getBytes(r103), CryptoConst.ALGORITHM_AES);     // Catch: Exception -> L15
        Cipher r106 = Cipher.getInstance("AES/ECB/PKCS5Padding");     // Catch: Exception -> L15
        r106.init(2, r105);     // Catch: Exception -> L15
        return new String(r106.doFinal(r104), r103);
    L15:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
