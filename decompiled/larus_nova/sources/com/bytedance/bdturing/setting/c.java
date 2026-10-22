package com.bytedance.bdturing.setting;

import com.byted.cast.linkcommon.security.SecurityUtil;
import com.bytedance.crypto.utils.CryptoConst;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    public interface a {
        void a(int r100, String r101, long r102);
    }

    public static String a(byte[] r100, byte[] r101, InputStream r102) {
        if (r100 == null) goto L15;
        if (r101 == null) goto L15;
        SecretKeySpec r103 = new SecretKeySpec(r100, CryptoConst.ALGORITHM_AES);
        GCMParameterSpec r104 = new GCMParameterSpec(128, new IvParameterSpec(r101).getIV());
        Cipher r105 = Cipher.getInstance(SecurityUtil.ENCRYPT_GCM);
        r105.init(2, r103, r104);
        GZIPInputStream r106 = new GZIPInputStream(new ByteArrayInputStream(r105.doFinal(ByteStreamsKt.readBytes(r102))));
        String r107 = TextStreamsKt.readText(new InputStreamReader(r106));     // Catch: Throwable -> L9
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L9
        CloseableKt.closeFinally(r106, null);
        return r107;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        CloseableKt.closeFinally(r106, th);
        throw th;
    L15:
        return TextStreamsKt.readText(new InputStreamReader(r102));
    }
}
