package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2HotAtmosphere;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes10.dex */
public final class a1 implements am3.c<ECV2HotAtmosphere> {
    public a1() {
    }

    public static ECV2HotAtmosphere a(am3.g r100) throws Exception {
        ECV2HotAtmosphere r101 = new ECV2HotAtmosphere();
        r101.bgColors = new ArrayList();
        r101.borderColors = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L17;
        switch(r103) {
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
        r101.topImg = am3.h.c(r100);
        goto L3
    L8:
        r101.borderColors.add(am3.h.c(r100));
        goto L3
    L9:
        r101.bgColors.add(am3.h.c(r100));
        goto L3
    L10:
        r101.uiType = (int) r100.j();
        goto L3
    L11:
        r101.leftMargin = (int) r100.j();
        goto L3
    L12:
        r101.borderColor = am3.h.c(r100);
        goto L3
    L13:
        r101.bgColor = am3.h.c(r100);
        goto L3
    L14:
        r101.num = am3.h.c(r100);
        goto L3
    L15:
        r101.type = (int) r100.j();
        goto L3
    L16:
        r101.img = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final ECV2HotAtmosphere decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
