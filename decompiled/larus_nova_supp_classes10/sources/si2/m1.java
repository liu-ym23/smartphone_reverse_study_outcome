package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2UpdatedCommentaryVideoInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m1 implements am3.c<ECV2UpdatedCommentaryVideoInfo> {
    public m1() {
    }

    public static ECV2UpdatedCommentaryVideoInfo a(am3.g r5) throws Exception {
        ECV2UpdatedCommentaryVideoInfo r0 = new ECV2UpdatedCommentaryVideoInfo();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L9;
        if (r3 != 1) goto L7;
        r0.action = (int) r5.j();
        goto L3
    L7:
        am3.h.e(r5);
        goto L3
    L9:
        r5.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
