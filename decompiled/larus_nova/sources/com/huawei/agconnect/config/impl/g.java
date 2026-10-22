package com.huawei.agconnect.config.impl;

import android.content.Context;
import com.huawei.agconnect.config.AesDecrypt;
import com.huawei.agconnect.config.IDecrypt;

/* JADX INFO: loaded from: classes23.dex */
public class g implements AesDecrypt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f276730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f276731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private IDecrypt f276732c;

    public g(Context r100, String r101) {
        this.f276730a = r100;
        this.f276731b = r101;
    }

    @Override // com.huawei.agconnect.config.AesDecrypt
    public String decrypt(String r100, String r101) {
        if (this.f276732c != null) goto L6;
        this.f276732c = decryptComponent();
    L6:
        return this.f276732c.decrypt(l.a(this.f276730a, this.f276731b, "agc_", r100), r101);
    }

    @Override // com.huawei.agconnect.config.AesDecrypt
    public IDecrypt decryptComponent() {
        return new f(new d(l.a(this.f276730a, this.f276731b, "agc_", "/AD91D45E3E72DB6989DDCB13287E75061FABCB933D886E6C6ABEF0939B577138"), l.a(this.f276730a, this.f276731b, "agc_", "/B314B3BF013DF5AC4134E880AF3D2B7C9FFBE8F0305EAC1C898145E2BCF1F21C"), l.a(this.f276730a, this.f276731b, "agc_", "/C767BD8FDF53E53D059BE95B09E2A71056F5F180AECC62836B287ACA5793421B"), l.a(this.f276730a, this.f276731b, "agc_", "/DCB3E6D4C2CF80F30D89CDBC412C964DA8381BB84668769391FBCC3E329AD0FD"), "PBKDF2WithHmacSHA1", 5000));
    }
}
