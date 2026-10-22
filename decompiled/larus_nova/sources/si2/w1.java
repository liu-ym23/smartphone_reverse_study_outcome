package si2;

import com.bytedance.android.livesdk.livecommerce.model.JumpUrl;

/* JADX INFO: loaded from: classes10.dex */
public final class w1 implements am3.c<JumpUrl> {
    public w1() {
    }

    @Override // am3.c
    public final JumpUrl decode(am3.g r100) throws Exception {
        JumpUrl r101 = new JumpUrl();
        long r102 = r100.c();
    L4:
        if (r100.f() == (-1)) goto L6;
        am3.h.e(r100);
        goto L4
    L6:
        r100.d(r102);
        return r101;
    }
}
