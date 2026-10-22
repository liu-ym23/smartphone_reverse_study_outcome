package si2;

import com.bytedance.android.livesdk.livecommerce.model.JumpUrl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class w1 implements am3.c<JumpUrl> {
    public w1() {
    }

    public final Object decode(am3.g r6) throws Exception {
        JumpUrl r0 = new JumpUrl();
        long r1 = r6.c();
    L4:
        if (r6.f() == (-1)) goto L6;
        am3.h.e(r6);
        goto L4
    L6:
        r6.d(r1);
        return r0;
    }
}
