package p65;

import android.os.SystemClock;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.doc.follow.FollowModuleState;
import com.bytedance.ee.bear.drive.biz.comment.p1;
import com.bytedance.ee.bear.drive.biz.preview.vc.model.CommentImagePreview;
import kotlin.jvm.internal.Intrinsics;
import py4.h;
import sy4.e;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements p65.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p1 f527910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f527911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C7155a f527912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f527913d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f527914e;

    /* JADX INFO: renamed from: p65.a$a, reason: collision with other inner class name */
    public final class C7155a implements p1.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f527915a;

        public C7155a(a r100) {
            this.f527915a = r100;
        }

        @Override // com.bytedance.ee.bear.drive.biz.comment.p1.a
        public final void a(String r100, String r101, int r110) {
            if (this.f527915a.f527914e == false) goto L6;
            tt5.a.d("CommentImagePreview", "CommentImageListener-onChanged, isFollowing, skipped, commentId: " + r100 + ", replyId: " + r101 + ", imageIndex: " + r110);
            return;
        L6:
            CommentImagePreview r102 = new CommentImagePreview();
            r102.setCommentId(r100);
            r102.setReplyId(r101);
            r102.setImageIndex(r110);
            a r103 = this.f527915a;
            h r104 = r103.f527911b;
            if (r104 != null) goto L9;
            tt5.a.d("CommentImagePreview", "sendCommentImagePreview, delegate is null, commentImagePreview: " + r102);
            return;
        L9:
            Long r111 = Long.valueOf(SystemClock.elapsedRealtime());
            if ((r111.longValue() - r103.f527913d) < 50) goto L12;
            boolean r105 = true;
        L13:
            if (r105 == true) goto L16;
            r111 = null;
        L16:
            if (r111 == null) goto L18;
            long r106 = r111.longValue();
            tt5.a.h("CommentImagePreview", "sendCommentImagePreview, commentImagePreview: " + r102);
            r103.f527913d = r106;
            r104.b(new FollowModuleState("DocComment", "CommentImagePreview", JSON.toJSONString(r102)));
            return;
        L18:
            tt5.a.d("CommentImagePreview", "sendCommentImagePreview, send too fast, skipped, commentImagePreview: " + r102);
            return;
        L12:
            r105 = false;
            goto L13
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // p65.b
    public final void onDetach() {
        tt5.a.h("CommentImagePreview", "onAttach");
        p1 r100 = this.f527910a;
        if (r100 != null) goto L5;
        tt5.a.d("CommentImagePreview", "stopCommentImagePreviewObserver, commentWrapper is null");
    L9:
        this.f527910a = null;
        this.f527911b = null;
        return;
    L5:
        C7155a r101 = this.f527912c;
        if (r101 == null) goto L8;
        r100.O7(r101);
    L8:
        this.f527912c = null;
        goto L9
    }

    public a() {
    }

    @Override // p65.b
    public final void a(sy4.b r100) {
        if (r100 == null) goto L14;
        e r101 = null;
        if ((r100 instanceof e) == true) goto L7;
        r100 = null;
    L7:
        if (r100 != null) goto L9;
        return;
    L9:
        if ((r100 instanceof e) == false) goto L11;
        r101 = (e) r100;
    L11:
        if (r101 == null) goto L16;
        this.f527914e = r101.f543884b;
        return;
    L16:
        return;
    }

    @Override // p65.b
    public final void b(p1 r100) {
        Intrinsics.checkNotNullParameter(r100, "commentWrapper");
        tt5.a.h("CommentImagePreview", "onAttach, commentWrapper: " + r100);
        this.f527910a = r100;
        if (r100 != null) goto L5;
        tt5.a.d("CommentImagePreview", "startCommentImagePreviewObserver, commentWrapper is null");
        return;
    L5:
        C7155a r101 = this.f527912c;
        if (r101 != null) goto L8;
        r101 = new C7155a(this);
        this.f527912c = r101;
    L8:
        r100.K7(r101);
    }

    @Override // p65.b
    public final void c(h r100) {
        tt5.a.h("CommentImagePreview", "onRegister, delegate: " + r100);
        this.f527911b = r100;
    }

    @Override // p65.b
    public final void onReceive(String r100) {
        if (r100 != null) goto L6;
        tt5.a.h("CommentImagePreview", "onReceive, jsonData is null");
        return;
    L6:
        boolean r101 = false;
        Object r102 = JSON.parseObject(r100, CommentImagePreview.class);     // Catch: Exception -> L44
        Intrinsics.checkNotNull(r102);     // Catch: Exception -> L44
        CommentImagePreview r103 = (CommentImagePreview) r102;     // Catch: Exception -> L44
        tt5.a.h("CommentImagePreview", "onReceive, commentImagePreview: " + r103);
        p1 r104 = this.f527910a;
        if (r104 != null) goto L11;
        tt5.a.d("CommentImagePreview", "handleCommentImagePreview, commentWrapper is null, commentImagePreview: " + r103);
        return;
    L11:
        tt5.a.h("CommentImagePreview", "handleCommentImagePreview, commentImagePreview: " + r103);
        String r105 = r103.getCommentId();
        if (r105 != null) goto L14;
    L17:
        boolean r106 = true;
    L18:
        if (r106 == true) goto L29;
        String r107 = r103.getReplyId();
        if (r107 != null) goto L22;
    L25:
        boolean r108 = true;
    L26:
        if (r108 == true) goto L29;
        boolean r109 = false;
    L30:
        CommentImagePreview r110 = null;
        if (r109 == false) goto L34;
        r103 = null;
    L34:
        if (r103 != null) goto L36;
    L42:
        r104.I7();
        return;
    L36:
        if (r103.getImageIndex() < 0) goto L38;
        r101 = true;
    L38:
        if (r101 == false) goto L40;
        r110 = r103;
    L40:
        if (r110 == null) goto L42;
        r104.L7(r110.getCommentId(), r110.getReplyId(), r110.getImageIndex());
        return;
    L22:
        if (r107.length() == 0) goto L25;
        r108 = false;
    L29:
        r109 = true;
        goto L30
    L14:
        if (r105.length() == 0) goto L17;
        r106 = false;
    L44:
        e = move-exception;
        tt5.a.e("CommentImagePreview", "onReceive, parse data failed, error: ", e, false);
    }
}
