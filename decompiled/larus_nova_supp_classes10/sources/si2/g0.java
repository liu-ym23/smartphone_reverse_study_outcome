package si2;

import com.bytedance.android.livesdk.livecommerce.model.AtmosphereData;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g0 implements am3.c<AtmosphereData> {
    public g0() {
    }

    public static AtmosphereData a(am3.g r5) throws Exception {
        AtmosphereData r0 = new AtmosphereData();
        r0.bgColors = new ArrayList();
        r0.borderColors = new ArrayList();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L17;
        switch(r3) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L7;
            default: goto L6;
        };
    L7:
        r0.leftIcon = r1.a(r5);
        goto L3
    L8:
        r0.bgImg = r1.a(r5);
        goto L3
    L9:
        r0.topImg = am3.h.c(r5);
        goto L3
    L10:
        r0.borderColors.add(am3.h.c(r5));
        goto L3
    L11:
        r0.bgColors.add(am3.h.c(r5));
        goto L3
    L12:
        r0.leftMargin = r5.j();
        goto L3
    L13:
        r0.borderColor = am3.h.c(r5);
        goto L3
    L14:
        r0.bgColor = am3.h.c(r5);
        goto L3
    L15:
        r0.num = am3.h.c(r5);
        goto L3
    L16:
        r0.img = am3.h.c(r5);
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
