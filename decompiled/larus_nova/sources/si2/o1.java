package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2UpdatedGroupInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes10.dex */
public final class o1 implements am3.c<ECV2UpdatedGroupInfo> {
    public o1() {
    }

    public static ECV2UpdatedGroupInfo a(am3.g r100) throws Exception {
        ECV2UpdatedGroupInfo r101 = new ECV2UpdatedGroupInfo();
        r101.avatarList = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L18;
        if (r103 != 1) goto L8;
        r101.avatarList.add(am3.h.c(r100));
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.joined = (int) r100.j();
        goto L3
    L10:
        if (r103 != 3) goto L12;
        r101.groupSize = (int) r100.j();
        goto L3
    L12:
        if (r103 != 4) goto L13;
        r101.persent = (int) r100.j();
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final ECV2UpdatedGroupInfo decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
