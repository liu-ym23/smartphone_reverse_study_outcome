package z49;

import com.bytedance.dora.device.DoraDevice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {
    public static final DoraDevice a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        DoraDevice r101 = r100.f570038a;
        if (r101 != null) goto L13;
        r101 = new DoraDevice();
        r101.name = r100.e();
        r101.f204389mac = r100.c();
        r101.f204390sn = r100.h();
        r101.model = r100.d();
        r101.softVersion = r100.i();
        Integer r102 = r100.f();
        if (r102 == null) goto L7;
        int r103 = r102.intValue();
    L8:
        r101.productId = r103;
        Integer r104 = r100.g();
        if (r104 == null) goto L11;
        int r105 = r104.intValue();
    L12:
        r101.sku = r105;
        r101.caseSoftVersion = r100.b();
        goto L13
    L11:
        r105 = 0;
        goto L12
    L7:
        r103 = 1;
    L13:
        return r101;
    }
}
