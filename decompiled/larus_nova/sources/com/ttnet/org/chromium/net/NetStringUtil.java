package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.text.Normalizer;
import java.util.Locale;

/* JADX INFO: loaded from: classes41.dex */
@JNINamespace("net::android")
public class NetStringUtil {
    public NetStringUtil() {
    }

    private static String toUpperCase(String r100) {
        return r100.toUpperCase(Locale.getDefault());
    L4:
        return null;
    }

    private static String convertToUnicode(ByteBuffer r100, String r101) {
        return Charset.forName(r101).newDecoder().decode(r100).toString();
    L4:
        return null;
    }

    private static String convertToUnicodeAndNormalize(ByteBuffer r100, String r101) {
        String r102 = convertToUnicode(r100, r101);
        if (r102 != null) goto L7;
        return null;
    L7:
        return Normalizer.normalize(r102, Normalizer.Form.NFC);
    }

    private static String convertToUnicodeWithSubstitutions(ByteBuffer r100, String r101) {
        CharsetDecoder r102 = Charset.forName(r101).newDecoder();     // Catch: Exception -> L4
        r102.onMalformedInput(CodingErrorAction.REPLACE);     // Catch: Exception -> L4
        r102.onUnmappableCharacter(CodingErrorAction.REPLACE);     // Catch: Exception -> L4
        r102.replaceWith("�");     // Catch: Exception -> L4
        return r102.decode(r100).toString();
    L4:
        return null;
    }
}
