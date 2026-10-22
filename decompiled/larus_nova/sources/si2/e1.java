package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2PopupInfo;
import com.bytedance.android.livesdk.livecommerce.model.JumpUrl;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public final class e1 implements am3.c<ECV2PopupInfo> {
    public e1() {
    }

    public static ECV2PopupInfo a(am3.g r100) throws Exception {
        ECV2PopupInfo r101 = new ECV2PopupInfo();
        r101.urls = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L19;
        if (r103 != 1) goto L8;
        r101.title = am3.h.c(r100);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.text = am3.h.c(r100);
        goto L3
    L10:
        if (r103 != 3) goto L11;
        List<JumpUrl> r104 = r101.urls;
        JumpUrl r105 = new JumpUrl();
        long r106 = r100.c();
    L14:
        if (r100.f() == (-1)) goto L16;
        am3.h.e(r100);
        goto L14
    L16:
        r100.d(r106);
        r104.add(r105);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L19:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final ECV2PopupInfo decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
