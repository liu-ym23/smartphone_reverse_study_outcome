package com.huawei.agconnect.config.impl;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.huawei.agconnect.config.ConfigReader;
import com.huawei.agconnect.config.IDecrypt;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes23.dex */
public class e implements IDecrypt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConfigReader f276724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SecretKey f276725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f276726c;

    public e(ConfigReader r100) {
        this.f276726c = false;
        this.f276724a = r100;
    }

    private void a() {
        this.f276725b = j.a(new d(this.f276724a.getString("/code/code1", null), this.f276724a.getString("/code/code2", null), this.f276724a.getString("/code/code3", null), this.f276724a.getString("/code/code4", null), "PBKDF2WithHmacSHA1", 10000));     // Catch: Throwable -> L5
    L6:
        this.f276726c = true;
        return;
    L5:
        this.f276725b = null;
        goto L6
    }

    public static boolean a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L7:
        return false;
    L5:
        if (Pattern.matches("^\\[!([A-Fa-f0-9]*)]", r100) == false) goto L7;
        return true;
    }

    private String b(String r100) {
        Matcher r101 = PatternProtector.compile("^\\[!([A-Fa-f0-9]*)]").matcher(r100);     // Catch: Throwable -> L8
        if (r101.find() == false) goto L7;
        return r101.group(1);
    L7:
        return "";
    }

    @Override // com.huawei.agconnect.config.IDecrypt
    public String decrypt(String r100, String r101) {
        if (this.f276726c == true) goto L6;
        a();
    L6:
        if (this.f276725b != null) goto L9;
        return r101;
    L9:
        if (a(r100) == true) goto L14;
    L12:
        return r101;
    L14:
        return new String(j.a(this.f276725b, Hex.decodeHexString(b(r100))), "UTF-8");
    }
}
