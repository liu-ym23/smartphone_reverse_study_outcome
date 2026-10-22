package si2;

import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.livesdk.livecommerce.model.ECV2HotAtmosphere;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a1 implements am3.c<ECV2HotAtmosphere> {
    public a1() {
    }

    public static ECV2HotAtmosphere a(am3.g r5) throws Exception {
        ECV2HotAtmosphere r0 = new ECV2HotAtmosphere();
        ((ECHotAtmosphere) r0).bgColors = new ArrayList();
        ((ECHotAtmosphere) r0).borderColors = new ArrayList();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L17;
        switch(r3) {
            case 1: goto L16;
            case 2: goto L6;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            case 11: goto L7;
            default: goto L6;
        };
    L7:
        ((ECHotAtmosphere) r0).topImg = am3.h.c(r5);
        goto L3
    L8:
        ((ECHotAtmosphere) r0).borderColors.add(am3.h.c(r5));
        goto L3
    L9:
        ((ECHotAtmosphere) r0).bgColors.add(am3.h.c(r5));
        goto L3
    L10:
        ((ECHotAtmosphere) r0).uiType = (int) r5.j();
        goto L3
    L11:
        ((ECHotAtmosphere) r0).leftMargin = (int) r5.j();
        goto L3
    L12:
        ((ECHotAtmosphere) r0).borderColor = am3.h.c(r5);
        goto L3
    L13:
        ((ECHotAtmosphere) r0).bgColor = am3.h.c(r5);
        goto L3
    L14:
        ((ECHotAtmosphere) r0).num = am3.h.c(r5);
        goto L3
    L15:
        ((ECHotAtmosphere) r0).type = (int) r5.j();
        goto L3
    L16:
        ((ECHotAtmosphere) r0).img = am3.h.c(r5);
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L17:
        r5.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
