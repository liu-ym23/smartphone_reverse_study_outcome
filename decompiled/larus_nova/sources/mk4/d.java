package mk4;

import com.bytedance.dora.device.DoraDevice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pk4.j;

/* JADX INFO: loaded from: classes15.dex */
public final class d {
    public static List<DoraDevice> a(List<DoraDevice> r100) {
        ArrayList r101 = new ArrayList();
        if (r100 != null) goto L5;
    L19:
        return r101;
    L5:
        if (r100.isEmpty() == true) goto L19;
        Iterator<DoraDevice> r102 = r100.iterator();
    L9:
        if (r102.hasNext() == false) goto L19;
        DoraDevice r103 = r102.next();
        int r104 = r103.productId;
        Iterator r105 = r101.iterator();
    L12:
        if (r105.hasNext() == false) goto L16;
        if (((DoraDevice) r105.next()).productId != r104) goto L12;
        boolean r106 = true;
    L17:
        if (r106 == true) goto L9;
        r101.add(r103);
        goto L9
    L16:
        r106 = false;
        goto L17
    }

    public static List<DoraDevice> b(List<?> r100) {
        ArrayList r101 = new ArrayList();
        if (r100 != null) goto L5;
    L17:
        return r101;
    L5:
        if (r100.isEmpty() == true) goto L17;
        Iterator<?> r102 = r100.iterator();
    L9:
        if (r102.hasNext() == false) goto L17;
        Object r103 = r102.next();
        if (r103 == null) goto L9;
        if ((r103 instanceof DoraDevice) == true) goto L15;
        j.f("DoraDeviceTrack", "Ignore invalid track device: " + r103);
        goto L9
    L15:
        r101.add((DoraDevice) r103);
        goto L9
    }
}
