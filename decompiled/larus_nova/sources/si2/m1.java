package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2UpdatedCommentaryVideoInfo;

/* JADX INFO: loaded from: classes10.dex */
public final class m1 implements am3.c<ECV2UpdatedCommentaryVideoInfo> {
    public m1() {
    }

    public static ECV2UpdatedCommentaryVideoInfo a(am3.g r100) throws Exception {
        ECV2UpdatedCommentaryVideoInfo r101 = new ECV2UpdatedCommentaryVideoInfo();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L9;
        if (r103 != 1) goto L7;
        r101.action = (int) r100.j();
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final ECV2UpdatedCommentaryVideoInfo decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
