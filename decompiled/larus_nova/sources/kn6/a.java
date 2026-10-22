package kn6;

import android.util.Base64;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.host.share.q;
import java.nio.charset.Charset;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.json.JSONObject;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes21.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final String a(String r110) {
        if (r110 != null) goto L4;
        return r110;
    L4:
        String r111 = StringsKt.replace$default(StringsKt.trimEnd(StringsKt.trimStart(r110, new char[]{Typography.quote}), new char[]{Typography.quote}), "\\", "", false, 4, null);
        new JSONObject(r111);     // Catch: Exception -> L7
        return r111;
    L7:
        e = move-exception;
        HostServiceUtilsKt.c().a(e);
        return b(r111, false);
    }

    @JvmStatic
    public static final String b(String r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "srcStr");
        q r100 = HostServiceUtilsKt.h0();
        r100.a0();
        r100.i();
        Charset r101 = Charsets.UTF_8;     // Catch: Exception -> L12
        SecretKeySpec r102 = new SecretKeySpec("".getBytes(r101), CryptoConst.ALGORITHM_AES);     // Catch: Exception -> L12
        Cipher r103 = Cipher.getInstance("AES/CBC/PKCS5Padding");     // Catch: Exception -> L12
        IvParameterSpec r104 = new IvParameterSpec("".getBytes(r101));     // Catch: Exception -> L12
        if (r111 == false) goto L6;
        int r105 = 1;
    L7:
        r103.init(r105, r102, r104);     // Catch: Exception -> L12
        if (r111 == false) goto L10;
        r110 = Base64.encodeToString(r103.doFinal(r110.getBytes(r101)), 0);     // Catch: Exception -> L12
    L15:
    L14:
        return r110;
    L10:
        r110 = StringsKt.decodeToString(r103.doFinal(Base64.decode(StringsKt.replace$default(r110, " ", Marker.ANY_NON_NULL_MARKER, false, 4, null), 0)));     // Catch: Exception -> L12
        goto L15
    L6:
        r105 = 2;
    L12:
        e = move-exception;
        HostServiceUtilsKt.c().a(e);
        goto L14
    }
}
