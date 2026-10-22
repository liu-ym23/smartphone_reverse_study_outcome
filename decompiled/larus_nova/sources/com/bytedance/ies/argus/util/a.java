package com.bytedance.ies.argus.util;

import com.byted.cast.linkcommon.security.SecurityUtil;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f246250a = 0;

    static {
    }

    public static byte[] a(byte[] r100, SecretKey r101) {
        Intrinsics.checkNotNullParameter(r100, "plaintext");
        Intrinsics.checkNotNullParameter(r101, "key");
        byte[] r102 = new byte[12];     // Catch: Exception -> L5
        new SecureRandom().nextBytes(r102);     // Catch: Exception -> L5
        Cipher r103 = Cipher.getInstance(SecurityUtil.ENCRYPT_GCM);     // Catch: Exception -> L5
        r103.init(1, r101, new GCMParameterSpec(128, r102));     // Catch: Exception -> L5
        return ArraysKt.plus(r102, r103.doFinal(r100));
    L5:
        e = move-exception;
        int r104 = com.bytedance.ies.argus.base.d.f245942a;
        com.bytedance.ies.argus.base.d.a("ArgusAesGcmCipher", "encrypt error: " + e);
        return null;
    }
}
