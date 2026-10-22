package com.bytedance.ies.argus.aspect.helper;

import android.util.Base64;
import com.alipay.sdk.m.n.d;
import com.baidu.mapauto.auth.util.RSAUtil;
import com.bytedance.ies.argus.bean.DigestAlgorithm;
import com.bytedance.ies.argus.bean.EncryptAlgorithm;
import com.bytedance.ies.argus.bean.TASMVerifyType;
import com.bytedance.ies.argus.bean.v;
import com.bytedance.ies.argus.bean.w;
import com.bytedance.ies.argus.bean.y;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f245887a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f245888a = null;

        static {
            int[] r100 = new int[TASMVerifyType.values().length];
            r100[TASMVerifyType.SIGN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f245888a = r100;
        }
    }

    static {
    }

    public static long a(byte[] r100, int r101, int r102) {
        if (r101 >= 0) goto L4;
        r101 = r101 + r100.length;
    L4:
        int r103 = r101 + r102;
        if (r103 > r100.length) goto L7;
        if (r102 < 0) goto L7;
    L8:
        int r104 = r103 - r101;
        long r105 = 0;
        int r106 = 0;
    L9:
        if (r106 >= r104) goto L11;
        r105 = r105 | ((((long) r100[r101 + r106]) & 255) << (r106 * 8));
        r106 = r106 + 1;
        goto L9
    L11:
        return r105;
    L7:
        r103 = r100.length;
        goto L8
    }

    public static boolean b(y r100, byte[] r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "tasm");
        Intrinsics.checkNotNullParameter(r101, "file");
        Intrinsics.checkNotNullParameter(r102, "publicKey");
        List<w> r103 = r100.f246069e;
        if (r103 == null) goto L26;
        List<w> r104 = r103;
        if ((r104 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r105 = r104.iterator();
    L11:
        if (r105.hasNext() == false) goto L28;
        w r106 = (w) r105.next();
        DigestAlgorithm r107 = DigestAlgorithm.SHA256;
        v r108 = r106.f246057a;
        if (r107 == r108.f246056b) goto L15;
    L17:
        boolean r109 = false;
    L18:
        if (r109 == false) goto L11;
        return true;
    L15:
        if (EncryptAlgorithm.RSA != r108.f246055a) goto L17;
        Signature r110 = Signature.getInstance(RSAUtil.SIGNATURE_ALGORITHM);
        r110.initVerify(KeyFactory.getInstance(d.f25615a).generatePublic(new X509EncodedKeySpec(Base64.decode(r102, 0))));
        r110.update(r101, 4, (r101.length - r100.f246066b) - 4);
        r109 = r110.verify(r106.f246058b);
        goto L18
    L28:
        return false;
    L7:
        if (r104.isEmpty() == false) goto L9;
        return false;
    L26:
        return false;
    }
}
