package com.huawei.agconnect.config.impl;

import android.content.Context;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.huawei.agconnect.config.AesDecrypt;
import com.huawei.agconnect.config.IDecrypt;
import faceverify.q;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class h implements AesDecrypt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f276733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f276734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private IDecrypt f276735c;

    public h(Context r100, String r101) {
        this.f276733a = r100;
        this.f276734b = r101;
    }

    @Override // com.huawei.agconnect.config.AesDecrypt
    public String decrypt(String r100, String r101) {
        if (this.f276735c != null) goto L6;
        this.f276735c = decryptComponent();
    L6:
        if (this.f276735c != null) goto L9;
        this.f276735c = new g(this.f276733a, this.f276734b).decryptComponent();
    L9:
        return this.f276735c.decrypt(l.a(this.f276733a, this.f276734b, "agc_plugin_", r100), r101);
    }

    @Override // com.huawei.agconnect.config.AesDecrypt
    public IDecrypt decryptComponent() {
        String r100 = l.a(this.f276733a, this.f276734b, "agc_plugin_", "crypto_component");
        if (r100 == null) goto L16;
        JSONObject r101 = new JSONObject(new String(Hex.decodeHexString(r100), XML.CHARSET_UTF8));     // Catch: IllegalArgumentException -> L6 Throwable -> L8 UnsupportedEncodingException -> L10
        String r102 = JSONObjectProtectorUtils.getString(r101, "rx");     // Catch: IllegalArgumentException -> L6 Throwable -> L8 UnsupportedEncodingException -> L10
        String r103 = JSONObjectProtectorUtils.getString(r101, "ry");     // Catch: IllegalArgumentException -> L6 Throwable -> L8 UnsupportedEncodingException -> L10
        String r104 = JSONObjectProtectorUtils.getString(r101, "rz");     // Catch: IllegalArgumentException -> L6 Throwable -> L8 UnsupportedEncodingException -> L10
        String r105 = JSONObjectProtectorUtils.getString(r101, "salt");     // Catch: IllegalArgumentException -> L6 Throwable -> L8 UnsupportedEncodingException -> L10
        int r106 = JSONObjectProtectorUtils.getInt(r101, "iterationCount");     // Catch: IllegalArgumentException -> L6 Throwable -> L8 UnsupportedEncodingException -> L10
        return new f(new d(r102, r103, r104, r105, JSONObjectProtectorUtils.getString(r101, q.KEY_ALGORITHM_CONFIG), r106));
    L8:
        e = move-exception;
        e.getMessage();
        return null;
    L16:
        return null;
    }
}
