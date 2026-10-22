package com.bytedance.caijing.sdk.infra.base.encrypt;

import android.util.Base64;
import com.bytedance.caijing.sdk.infra.base.account.CJAccount;
import com.bytedance.caijing.sdk.infra.base.api.sec.CJSecService;
import com.bytedance.caijing.sdk.infra.base.api.sec.EncryptVendor;
import com.bytedance.caijing.sdk.infra.base.env.CJEnv;
import com.bytedance.caijing.sdk.infra.utils.e;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import we4.b;
import xc4.f;

/* JADX INFO: loaded from: classes15.dex */
public final class CJEncrypt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f202287a = null;

    static {
        f202287a = LazyKt.lazy(CJEncrypt$secService$2.INSTANCE);
    }

    public static b b() {
        f r100 = CJAccount.a();     // Catch: Throwable -> L21
        if (r100 != null) goto L7;
        int r101 = b.f559394d;     // Catch: Throwable -> L21
        return b.a.a(-100, "get uid fail", "");
    L7:
        String r102 = r100.f563208a;     // Catch: Throwable -> L21
        boolean r103 = false;
        if (r102.length() != 0) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == false) goto L14;
        r102 = r100.f563210c;     // Catch: Throwable -> L21
    L14:
        if (r102.length() != 0) goto L16;
        r103 = true;
    L16:
        if (r103 == false) goto L19;
        int r105 = b.f559394d;     // Catch: Throwable -> L21
        return b.a.a(-101, "uid empty", "");
    L19:
        String r106 = r102 + CJEnv.c() + CJEnv.e();     // Catch: Throwable -> L21
        int r107 = b.f559394d;     // Catch: Throwable -> L21
        return b.a.b(e.a(r106));
    L10:
        r104 = false;
    L21:
        int r108 = b.f559394d;
        return b.a.a(-1, "getPin fail", "");
    }

    public static b a(byte[] r100, String r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "pubKey");
        Intrinsics.checkNotNullParameter(r103, "triggerScene");
        byte[] r104 = Base64.decode(r101, 2);     // Catch: Throwable -> L13
        if (r102 == 20) goto L12;
        if (r102 == 30) goto L10;
        int r105 = b.f559394d;     // Catch: Throwable -> L13
        return b.a.a(-1, "version not support", "".getBytes(Charsets.UTF_8));
    L10:
        return ((CJSecService) f202287a.getValue()).messageEncrypt(r104, r100, EncryptVendor.CCIT);
    L12:
        return ((CJSecService) f202287a.getValue()).messageEncrypt(r104, r100, EncryptVendor.ISEC);
    L13:
        th = move-exception;
        int r106 = b.f559394d;
        return b.a.a(-1, "encrypt fail:" + th.getMessage(), "".getBytes(Charsets.UTF_8));
    }
}
