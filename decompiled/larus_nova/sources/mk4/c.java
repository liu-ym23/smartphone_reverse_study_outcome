package mk4;

import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pk4.j;

/* JADX INFO: loaded from: classes15.dex */
public final class c {
    public static List a(List r100) {
        ArrayList r101 = (ArrayList) d.a(r100);
        ArrayList r102 = new ArrayList(r101.size());
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L25;
        DoraDevice r104 = (DoraDevice) r103.next();
        int r105 = r104.vendorId;
        int r106 = r104.productId;
        if (r105 != 4096) goto L9;
        String r107 = "dora_hw";
    L23:
        if (r107 == null) goto L4;
        r102.add(r107);
        goto L4
    L9:
        if (r106 == ProductNameType.DORA_LITE.f204375id) goto L22;
        if (r106 == 0) goto L22;
        if (r106 != ProductNameType.DORA_E.f204375id) goto L16;
        r107 = "dora_e";
        goto L23
    L16:
        if (ProductNameType.isDoraGSeriesProduct(r106) == false) goto L19;
        r107 = "dora_g";
        goto L23
    L19:
        if (r106 != ProductNameType.DORA_LORY_B.f204375id) goto L21;
        r107 = "lory_b";
        goto L23
    L21:
        j.f("DoraDeviceTrack", "Resolve track device identifier failed, vendorId=" + r105 + ", productId=" + r106);
        r107 = null;
    L22:
        r107 = "dora_d";
        goto L23
    L25:
        return r102;
    }
}
