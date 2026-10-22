package zb3;

import com.bytedance.android.ec.model.response.ECCommentVideo;
import com.bytedance.android.ec.model.response.anchorv3.PromotionVideoInfo;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentNodeVO;

/* JADX INFO: loaded from: classes13.dex */
public final class f extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PromotionVideoInfo f571144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f571145d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f571146e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f571147f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ECCommentVideo f571148g;

    @Override // zb3.e
    public int getType() {
        return 1;
    }

    @Override // zb3.e
    public final Long a() {
        return Long.valueOf(this.f571145d);
    }

    @Override // zb3.e
    public final int c() {
        return this.f571147f;
    }

    @Override // zb3.e
    public final PromotionVideoInfo d() {
        return this.f571144c;
    }

    @Override // zb3.e
    public final ECCommentVideo e() {
        return this.f571148g;
    }

    @Override // zb3.e
    public final boolean f() {
        return this.f571146e;
    }

    public f(PromotionVideoInfo r100, long r101, boolean r102, int r103, ECCommentVideo r104) {
        this.f571144c = r100;
        this.f571145d = r101;
        this.f571146e = r102;
        this.f571147f = r103;
        this.f571148g = r104;
    }

    public /* synthetic */ f(PromotionVideoInfo r100, long r101, CommentNodeVO r102, boolean r103, int r104, int r105, int r106, ECCommentVideo r110, int r111) {
        if ((r111 & 2) == 0) goto L6;
        r101 = 0;
    L6:
        if ((r111 & 8) == 0) goto L8;
        boolean r107 = false;
    L10:
        if ((r111 & 16) == 0) goto L12;
        int r108 = 0;
    L14:
        if ((r111 & 256) == 0) goto L16;
        r110 = null;
    L16:
        ECCommentVideo r112 = r110;
        this(r100, r101, r107, r108, r112);
        return;
    L12:
        r108 = r104;
        goto L14
    L8:
        r107 = r103;
        goto L10
    }
}
