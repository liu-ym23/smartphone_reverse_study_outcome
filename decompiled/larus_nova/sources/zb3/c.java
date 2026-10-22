package zb3;

import com.bytedance.android.ec.model.response.PromotionProductCommentPhotoDTO;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentNodeVO;

/* JADX INFO: loaded from: classes13.dex */
public final class c extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PromotionProductCommentPhotoDTO f571133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f571134d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f571135e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f571136f;

    @Override // zb3.e
    public int getType() {
        return 2;
    }

    @Override // zb3.e
    public final Long a() {
        return Long.valueOf(this.f571134d);
    }

    @Override // zb3.e
    public final PromotionProductCommentPhotoDTO b() {
        return this.f571133c;
    }

    @Override // zb3.e
    public final int c() {
        return this.f571136f;
    }

    @Override // zb3.e
    public final boolean f() {
        return this.f571135e;
    }

    public c(PromotionProductCommentPhotoDTO r100, long r101, boolean r102, int r103) {
        this.f571133c = r100;
        this.f571134d = r101;
        this.f571135e = r102;
        this.f571136f = r103;
    }

    public /* synthetic */ c(PromotionProductCommentPhotoDTO r100, long r101, CommentNodeVO r102, boolean r103, int r104, int r105, int r106, int r107) {
        if ((r107 & 2) == 0) goto L6;
        r101 = 0;
    L6:
        if ((r107 & 8) == 0) goto L8;
        boolean r108 = false;
    L10:
        if ((r107 & 16) == 0) goto L12;
        int r109 = 0;
    L13:
        this(r100, r101, r108, r109);
        return;
    L12:
        r109 = r104;
        goto L13
    L8:
        r108 = r103;
        goto L10
    }
}
