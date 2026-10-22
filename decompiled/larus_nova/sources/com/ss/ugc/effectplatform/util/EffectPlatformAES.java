package com.ss.ugc.effectplatform.util;

import android.util.Log;
import bytekn.foundation.encryption.Padding;
import bytekn.foundation.io.file.ContentEncoding;
import bytekn.foundation.logger.Logger;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.android.ugc.effectmanager.MobConstants;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class EffectPlatformAES {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f458008a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a0.b<klc.a> f458009b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f458010c = null;

    public EffectPlatformAES() {
    }

    static {
        int r100 = n.f458044a;
        f458008a = "760.0.0.269-alpha.24";
        f458009b = new a0.b(null);
        f458010c = LazyKt.lazy(EffectPlatformAES$defaultCryptKey$2.INSTANCE);
    }

    public static String a(String r100, byte[] r110) {
        if (r100 == null) goto L20;
        String r101 = "";
        if (StringsKt.isBlank(r100) == false) goto L6;
        return "";
    L6:
        RuntimeException r102 = new RuntimeException();
        bytekn.foundation.encryption.a.C0382a r103 = bytekn.foundation.encryption.a.f21767r;     // Catch: Exception -> L9
        byte[] r104 = d0.a.a(r100);     // Catch: Exception -> L9
        Padding r105 = Padding.PKCS7Padding;     // Catch: Exception -> L9
        r103.getClass();     // Catch: Exception -> L9
        return CommonUtilExKt.a(bytekn.foundation.encryption.a.C0382a.a(r104, r110, r110, r105), ContentEncoding.Utf8);
    L9:
        e = move-exception;
        Logger r106 = Logger.INSTANCE;
        StringBuilder r107 = new StringBuilder("decrypt failed!, content: ");
        r107.append(r100);
        r107.append(", platformVersion: ");
        String r108 = f458008a;
        r107.append(r108);
        r106.e("EffectPlatformAES", r107.toString(), e);
        int r109 = n.f458044a;
        boolean r111 = Intrinsics.areEqual(r108, "760.0.0.269-alpha.24");
        klc.a r112 = f458009b.f1239a;
        if (r112 == null) goto L20;
        String r113 = e.getMessage();
        String r114 = Log.getStackTraceString(r102);
        int r115 = !Arrays.equals((byte[]) f458010c.getValue(), r110) ? 1 : 0;
        Pair[] r116 = new Pair[6];
        r116[0] = TuplesKt.to("content", r100);
        if (r113 != null) goto L16;
        r113 = "";
    L16:
        r116[1] = TuplesKt.to("error_msg", r113);
        r116[2] = TuplesKt.to("stack_trace", r114);
        r116[3] = TuplesKt.to(MobConstants.PLATFORM_TYPE, Integer.valueOf(r111 ? 1 : 0));
        if (r108 == null) goto L19;
        r101 = r108;
    L19:
        r116[4] = TuplesKt.to(EffectConfiguration.KEY_PLATFORM_SDK_VERSION, r101);
        r116[5] = TuplesKt.to("is_third_party_business", Integer.valueOf(r115));
        r112.monitorStatusRate("effectplatform_decrypt_fail", 1, MapsKt.mutableMapOf(r116));
    L20:
        return null;
    }
}
