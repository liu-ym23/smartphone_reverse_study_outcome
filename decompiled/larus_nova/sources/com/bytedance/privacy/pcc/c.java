package com.bytedance.privacy.pcc;

import android.content.Context;
import android.os.Bundle;
import java.security.cert.Certificate;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f266698a = null;

    public c() {
    }

    static {
        f266698a = c.class.getSimpleName();
    }

    public static byte[] b(Context r100, byte[] r101) throws Exception {
        j67.a.c r102 = j67.a.b().n(r100, r101, new Bundle());
        byte[] r103 = r102.f497530c;
        int r104 = r102.f497528a;
        j67.a.c();
        if (r104 != 0) goto L9;
        if (r103 == null) goto L9;
        if (r103.length == 0) goto L9;
        return r103;
    L9:
        throw new Exception("sign failed: ret=" + r102.f497528a);
    }

    public static String a(Context r100, String r101, String r102, String r103) throws Exception {
        int r104 = j67.a.b().deleteKey(r100, "pcc_sign_key", new Bundle());
        j67.a.c();
        String r105 = f266698a;
        if (r104 != 0) goto L5;
        k67.b.a(r105, "deleteSignKey: alias=pcc_sign_key");
    L6:
        Bundle r106 = new Bundle();
        j67.a.b().o();
        j67.a.b().keyAlgorithmEcc();
        r106.putInt("key_algorithm", 2);
        j67.a.b().i();
        r106.putInt("key_length", 256);
        j67.a.b().u();
        j67.a.b().purposeAttestKey();
        j67.a.b().k();
        r106.putInt("key_purpose", 68);
        int r107 = j67.a.b().generateKeyPair(r100, "pcc_sign_key", r106);
        j67.a.c();
        if (r107 != 0) goto L21;
        Bundle r108 = new Bundle();
        j67.a.b().f();
        r108.putString("challenge", r101);
        j67.a.b().c();
        r108.putString("attest_rpdid", r102);
        j67.a.b().a();
        r108.putString("attest_rpuid", r103);
        j67.a.b().q();
        r108.putBoolean("device_health_status_required", true);
        j67.a.c r109 = j67.a.b().keyAttestation(r100, "pcc_sign_key", r108);
        int r110 = r109.f497528a;
        j67.a.c();
        if (r110 != 0) goto L19;
        List<Certificate> r111 = r109.f497529b;
        if (r111 == null) goto L17;
        if (r111.isEmpty() == true) goto L17;
        return k67.a.a(r111, Math.min(r111.size(), 3));
    L17:
        throw new Exception("cert chain is empty");
    L19:
        throw new Exception("keyAttestation failed: ret=" + r109.f497528a);
    L21:
        throw new Exception("generateKeyPair failed: ret=" + r107);
    L5:
        k67.b.c(r105, "deleteSignKey: ret=" + r104 + " alias=pcc_sign_key");
        goto L6
    }
}
