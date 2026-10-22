package com.huawei.agconnect.config.impl;

import android.text.TextUtils;
import com.huawei.agconnect.config.IDecrypt;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Objects;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes23.dex */
public class f implements IDecrypt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SecretKey f276727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f276728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f276729c;

    public f(d r100) {
        this.f276729c = false;
        this.f276728b = r100;
    }

    private void a() {
        this.f276727a = j.a(this.f276728b);     // Catch: Throwable -> L4 InvalidKeySpecException -> L6 NoSuchAlgorithmException -> L8
    L10:
        this.f276729c = true;
        return;
    L4:
        e = move-exception;
        e.getMessage();
        this.f276727a = null;
        goto L10
    }

    @Override // com.huawei.agconnect.config.IDecrypt
    public String decrypt(String r100, String r101) {
        if (this.f276729c == true) goto L6;
        a();
    L6:
        if (this.f276727a != null) goto L8;
    L19:
        Objects.toString(this.f276727a);
        return r101;
    L8:
        if (TextUtils.isEmpty(r100) == true) goto L19;
        return new String(j.a(this.f276727a, Hex.decodeHexString(r100)), "UTF-8");
    L16:
        e = move-exception;
        e.getMessage();
        return r101;
    }
}
