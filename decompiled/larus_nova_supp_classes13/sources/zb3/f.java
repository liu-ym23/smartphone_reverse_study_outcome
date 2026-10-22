package zb3;

import com.bytedance.android.ec.model.response.ECCommentVideo;
import com.bytedance.android.ec.model.response.anchorv3.PromotionVideoInfo;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentNodeVO;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f extends e {
    public final PromotionVideoInfo c;
    public final long d;
    public final boolean e;
    public final int f;
    public final ECCommentVideo g;

    @Override // zb3.e
    public int getType() {
        return 1;
    }

    @Override // zb3.e
    public final Long a() {
        return Long.valueOf(this.d);
    }

    @Override // zb3.e
    public final int c() {
        return this.f;
    }

    @Override // zb3.e
    public final PromotionVideoInfo d() {
        return this.c;
    }

    @Override // zb3.e
    public final ECCommentVideo e() {
        return this.g;
    }

    @Override // zb3.e
    public final boolean f() {
        return this.e;
    }

    public f(PromotionVideoInfo r1, long r2, boolean r4, int r5, ECCommentVideo r6) {
        this.c = r1;
        this.d = r2;
        this.e = r4;
        this.f = r5;
        this.g = r6;
    }

    public /* synthetic */ f(PromotionVideoInfo r2, long r3, CommentNodeVO r5, boolean r6, int r7, int r8, int r9, ECCommentVideo r10, int r11) {
        if ((r11 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r11 & 8) == 0) goto L8;
        boolean r12 = false;
    L10:
        if ((r11 & 16) == 0) goto L12;
        int r0 = 0;
    L14:
        if ((r11 & 256) == 0) goto L16;
        r10 = null;
    L16:
        ECCommentVideo r13 = r10;
        this(r2, r3, r12, r0, r13);
        return;
    L12:
        r0 = r7;
        goto L14
    L8:
        r12 = r6;
        goto L10
    }
}
