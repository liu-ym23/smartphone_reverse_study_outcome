package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2PopupInfo;
import com.bytedance.android.livesdk.livecommerce.model.JumpUrl;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e1 implements am3.c<ECV2PopupInfo> {
    public e1() {
    }

    public static ECV2PopupInfo a(am3.g r9) throws Exception {
        ECV2PopupInfo r0 = new ECV2PopupInfo();
        r0.urls = new ArrayList();
        long r1 = r9.c();
    L3:
        int r3 = r9.f();
        if (r3 == (-1)) goto L19;
        if (r3 != 1) goto L8;
        r0.title = am3.h.c(r9);
        goto L3
    L8:
        if (r3 != 2) goto L10;
        r0.text = am3.h.c(r9);
        goto L3
    L10:
        if (r3 != 3) goto L11;
        List<JumpUrl> r4 = r0.urls;
        JumpUrl r5 = new JumpUrl();
        long r6 = r9.c();
    L14:
        if (r9.f() == (-1)) goto L16;
        am3.h.e(r9);
        goto L14
    L16:
        r9.d(r6);
        r4.add(r5);
        goto L3
    L11:
        am3.h.e(r9);
        goto L3
    L19:
        r9.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
