package zb3;

import com.bytedance.android.ec.model.response.PromotionProductCommentPhotoDTO;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentNodeVO;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends e {
    public final PromotionProductCommentPhotoDTO c;
    public final long d;
    public final boolean e;
    public final int f;

    @Override // zb3.e
    public int getType() {
        return 2;
    }

    @Override // zb3.e
    public final Long a() {
        return Long.valueOf(this.d);
    }

    @Override // zb3.e
    public final PromotionProductCommentPhotoDTO b() {
        return this.c;
    }

    @Override // zb3.e
    public final int c() {
        return this.f;
    }

    @Override // zb3.e
    public final boolean f() {
        return this.e;
    }

    public c(PromotionProductCommentPhotoDTO r1, long r2, boolean r4, int r5) {
        this.c = r1;
        this.d = r2;
        this.e = r4;
        this.f = r5;
    }

    public /* synthetic */ c(PromotionProductCommentPhotoDTO r1, long r2, CommentNodeVO r4, boolean r5, int r6, int r7, int r8, int r9) {
        if ((r9 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r9 & 8) == 0) goto L8;
        boolean r10 = false;
    L10:
        if ((r9 & 16) == 0) goto L12;
        int r11 = 0;
    L13:
        this(r1, r2, r10, r11);
        return;
    L12:
        r11 = r6;
        goto L13
    L8:
        r10 = r5;
        goto L10
    }
}
