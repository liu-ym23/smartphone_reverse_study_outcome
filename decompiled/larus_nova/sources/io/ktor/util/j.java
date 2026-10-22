package io.ktor.util;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes41.dex */
public final class j {
    public static final String a() {
        String r100 = (String) kotlinx.coroutines.channels.g.b(NonceKt.f491941b.mo10964tryReceivePtdJZtk());
        if (r100 != null) goto L7;
        NonceKt.f491942c.start();
        return (String) BuildersKt.runBlocking$default(null, new CryptoKt__CryptoJvmKt$generateNonceBlocking$1(null), 1, null);
    L7:
        return r100;
    }

    public static final String b(byte[] r100) {
        char[] r101 = k.f491961a;
        Intrinsics.checkNotNullParameter(r100, HTTP.CONTENT_RANGE_BYTES);
        char[] r102 = new char[r100.length * 2];
        char[] r103 = k.f491961a;
        int r104 = r100.length;
        int r105 = 0;
        int r106 = 0;
    L3:
        if (r105 >= r104) goto L6;
        int r107 = r100[r105] & UByte.MAX_VALUE;
        int r108 = r106 + 1;
        r102[r106] = r103[r107 >> 4];
        r106 = r108 + 1;
        r102[r108] = r103[r107 & 15];
        r105 = r105 + 1;
        goto L3
    L6:
        return StringsKt.concatToString(r102);
    }
}
