package ik4;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Set;
import pk4.c;
import pk4.j;
import pk4.n;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static byte[] b() {
        return n.u(new byte[]{1, 0, 2, 0, 3, 0, 5, 0, 8, 0, 15, 0, 11, 0, 12, 0, HTTP.CR, 0, 4, 8}, n.m(System.currentTimeMillis()));
    }

    public static byte[] d() {
        return new byte[]{1, 0, 2, 0, 3, 0, 4, 0, 5, 0, 6, 0, 7, 0, 8, 0};
    }

    public static String a(DoraDevice r100) {
        if (r100 != null) goto L4;
    L6:
        int r101 = 0;
        if (r100 == null) goto L23;
        int r102 = r100.productId;
        boolean r103 = true;
        if (r102 == ProductNameType.DORA_LITE.getId()) goto L13;
        if (r102 == 0) goto L13;
        boolean r104 = false;
    L14:
        if (r104 == false) goto L23;
        String r105 = r100.softVersion;
        if (r105 == null) goto L23;
        String r106 = r105.trim();
        if ("1.4.0.437".equals(r106) == true) goto L25;
        if ("1.4.0.447".equals(r106) == false) goto L23;
    L25:
        if (r103 == false) goto L45;
        Set r107 = Collections.singleton("natural_wakup");
        String[] r108 = "vuiAbilityShift,natural_wakup".split(",");
        StringBuilder r109 = new StringBuilder();
        int r110 = r108.length;
    L27:
        if (r101 >= r110) goto L39;
        String r111 = r108[r101].trim();
        if (r111.length() == 0) goto L37;
        if (r107.contains(r111) == true) goto L37;
        if (r109.length() <= 0) goto L36;
        r109.append(",");
    L36:
        r109.append(r111);
    L37:
        r101 = r101 + 1;
        goto L27
    L39:
        return r109.toString();
    L45:
        return "vuiAbilityShift,natural_wakup";
    L13:
        r104 = true;
    L23:
        r103 = false;
        goto L25
    L4:
        if (ProductNameType.isDoraGSeriesProduct(r100.productId) == false) goto L6;
        return "videoCfg,natural_wakup";
    }

    public static byte[] c(DoraDevice r100) {
        byte[] r101 = n.u(new byte[]{1, 0, 2, 0, 3, 0, 4, 0, 5, 0, 6, 0, 7, 0, 8, 0, 9, 0, 10, 0, 11, 0, 12, 0, HTTP.CR, 1, 0, 16, 0, 17, 0, 14, 4}, n.l(c.a.f529617a.f()));
        String r102 = a(r100);
        if (r100 != null) goto L5;
    L7:
        j.d("DeviceManagementService", "req device info : " + r102);
    L8:
        byte[] r103 = n.u(r102.getBytes(StandardCharsets.UTF_8), new byte[]{0});
        return n.u(n.u(r101, n.u(new byte[]{18, (byte) r103.length}, r103)), new byte[]{19, 0, 20, 0, 21, 0, 22, 0});
    L5:
        if (ProductNameType.isDoraGSeriesProduct(r100.productId) == false) goto L7;
        j.c("DeviceManagementService", "req [G] device info : " + r102, new Exception("for stack trace"));
        goto L8
    }
}
