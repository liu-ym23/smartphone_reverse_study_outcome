package o84;

import com.bytedance.kmp.crypto.AlgorithmId;
import com.bytedance.kmp.crypto.PaddingModeRsa;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import p96.c;
import q96.d;
import q96.e;
import q96.f;
import q96.h;
import q96.j;
import q96.k;
import q96.l;
import q96.n;
import q96.o;
import q96.p;
import q96.q;
import q96.r;
import q96.s;
import q96.t;
import r96.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public b() {
    }

    public final String a(String r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "data");
        Intrinsics.checkNotNullParameter(r10, "publicKeyBase64");
        c r0 = c.a;
        q.a r1 = q.a;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r1, "algorithm");
        if (Intrinsics.areEqual(r1, q96.a.a) == false) goto L6;
        q96.c r2 = new q96.c();
    L29:
        q r3 = (q) r2;
        r3.c(PaddingModeRsa.PKCS1Padding);
        int r4 = com.bytedance.bdnavigationsdk.utils.c.a;
        Intrinsics.checkNotNullParameter(r10, "input");
        String r11 = StringsKt.decodeToString(Base64.decode$default(Base64.Default, r10, 0, 0, 6, null));
        Intrinsics.checkNotNullParameter(r11, "pemString");
        byte[] r12 = android.util.Base64.decode(StringsKt.trim(new Regex("[\\s\\n\\r]+").replace(new Regex("-----END [A-Z ]+-----").replace(new Regex("-----BEGIN [A-Z ]+-----").replace(r11, ""), ""), "")).toString(), 2);
        p96.b r5 = r3.b();
        Intrinsics.checkNotNull(r12);
        g r13 = r5.a(r12);
        byte[] r14 = StringsKt.encodeToByteArray(r9);
        ArrayList r6 = new ArrayList();
        int r7 = 0;
    L31:
        if (r7 >= r14.length) goto L33;
        int r8 = Math.min(245, r14.length - r7) + r7;
        r6.add(r3.a(ArraysKt.copyOfRange(r14, r7, r8), r13));
        r7 = r8;
        goto L31
    L33:
        Iterator r15 = r6.iterator();
        if (r15.hasNext() == false) goto L42;
        Object r16 = r15.next();
    L37:
        if (r15.hasNext() == false) goto L40;
        r16 = ArraysKt.plus((byte[]) r16, (byte[]) r15.next());
        goto L37
    L40:
        return new String(android.util.Base64.encode((byte[]) r16, 2), Charsets.UTF_8);
    L42:
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    L6:
        if (Intrinsics.areEqual(r1, q96.b.a) == false) goto L9;
        r2 = new d();
        goto L29
    L9:
        if (Intrinsics.areEqual(r1, p.a) == false) goto L12;
        r2 = new q96.g();
        goto L29
    L12:
        if (Intrinsics.areEqual(r1, s.a) == false) goto L15;
        r2 = new k();
        goto L29
    L15:
        if (Intrinsics.areEqual(r1, t.a) == false) goto L18;
        r2 = new l();
        goto L29
    L18:
        if (Intrinsics.areEqual(r1, r1) == false) goto L21;
        r2 = new h();
        goto L29
    L21:
        if (Intrinsics.areEqual(r1, r.a) == false) goto L24;
        r2 = new j();
        goto L29
    L24:
        if (Intrinsics.areEqual(r1, n.a) == false) goto L27;
        r2 = new e();
        goto L29
    L27:
        if (Intrinsics.areEqual(r1, o.a) == false) goto L44;
        r2 = new f();
        goto L29
    L44:
        throw new RuntimeException("[crypto] Unsupported algorithm: " + ((AlgorithmId) r1).a);
    }
}
