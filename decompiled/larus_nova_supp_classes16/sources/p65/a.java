package p65;

import android.os.SystemClock;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.doc.follow.FollowModuleState;
import com.bytedance.ee.bear.drive.biz.comment.p1;
import com.bytedance.ee.bear.drive.biz.preview.vc.model.CommentImagePreview;
import kotlin.jvm.internal.Intrinsics;
import py4.h;
import sy4.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements p65.b {
    public p1 a;
    public h b;
    public C0271a c;
    public long d;
    public boolean e;

    /* JADX INFO: renamed from: p65.a$a, reason: collision with other inner class name */
    public final class C0271a implements p1.a {
        public final /* synthetic */ a a;

        public C0271a(a r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.drive.biz.comment.p1.a
        public final void a(String r8, String r9, int r10) {
            if (this.a.e == false) goto L6;
            tt5.a.d("CommentImagePreview", "CommentImageListener-onChanged, isFollowing, skipped, commentId: " + r8 + ", replyId: " + r9 + ", imageIndex: " + r10);
            return;
        L6:
            CommentImagePreview r0 = new CommentImagePreview();
            r0.setCommentId(r8);
            r0.setReplyId(r9);
            r0.setImageIndex(r10);
            a r11 = this.a;
            h r12 = r11.b;
            if (r12 != null) goto L9;
            tt5.a.d("CommentImagePreview", "sendCommentImagePreview, delegate is null, commentImagePreview: " + r0);
            return;
        L9:
            Long r13 = Long.valueOf(SystemClock.elapsedRealtime());
            if ((r13.longValue() - r11.d) < 50) goto L12;
            boolean r2 = true;
        L13:
            if (r2 == true) goto L16;
            r13 = null;
        L16:
            if (r13 == null) goto L18;
            long r3 = r13.longValue();
            tt5.a.h("CommentImagePreview", "sendCommentImagePreview, commentImagePreview: " + r0);
            r11.d = r3;
            r12.b(new FollowModuleState("DocComment", "CommentImagePreview", JSON.toJSONString(r0)));
            return;
        L18:
            tt5.a.d("CommentImagePreview", "sendCommentImagePreview, send too fast, skipped, commentImagePreview: " + r0);
            return;
        L12:
            r2 = false;
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
        p1 r1 = this.a;
        if (r1 != null) goto L5;
        tt5.a.d("CommentImagePreview", "stopCommentImagePreviewObserver, commentWrapper is null");
    L9:
        this.a = null;
        this.b = null;
        return;
    L5:
        C0271a r0 = this.c;
        if (r0 == null) goto L8;
        r1.O7(r0);
    L8:
        this.c = null;
        goto L9
    }

    public a() {
    }

    @Override // p65.b
    public final void a(sy4.b r3) {
        if (r3 == null) goto L14;
        e r1 = null;
        if ((r3 instanceof e) == true) goto L7;
        r3 = null;
    L7:
        if (r3 != null) goto L9;
        return;
    L9:
        if ((r3 instanceof e) == false) goto L11;
        r1 = (e) r3;
    L11:
        if (r1 == null) goto L16;
        this.e = r1.b;
        return;
    L16:
        return;
    }

    @Override // p65.b
    public final void b(p1 r3) {
        Intrinsics.checkNotNullParameter(r3, "commentWrapper");
        tt5.a.h("CommentImagePreview", "onAttach, commentWrapper: " + r3);
        this.a = r3;
        if (r3 != null) goto L5;
        tt5.a.d("CommentImagePreview", "startCommentImagePreviewObserver, commentWrapper is null");
        return;
    L5:
        C0271a r0 = this.c;
        if (r0 != null) goto L8;
        r0 = new C0271a(this);
        this.c = r0;
    L8:
        r3.K7(r0);
    }

    @Override // p65.b
    public final void c(h r3) {
        tt5.a.h("CommentImagePreview", "onRegister, delegate: " + r3);
        this.b = r3;
    }

    @Override // p65.b
    public final void onReceive(String r6) {
        if (r6 != null) goto L6;
        tt5.a.h("CommentImagePreview", "onReceive, jsonData is null");
        return;
    L6:
        boolean r1 = false;
        Object r7 = JSON.parseObject(r6, CommentImagePreview.class);     // Catch: Exception -> L44
        Intrinsics.checkNotNull(r7);     // Catch: Exception -> L44
        CommentImagePreview r8 = (CommentImagePreview) r7;     // Catch: Exception -> L44
        tt5.a.h("CommentImagePreview", "onReceive, commentImagePreview: " + r8);
        p1 r2 = this.a;
        if (r2 != null) goto L11;
        tt5.a.d("CommentImagePreview", "handleCommentImagePreview, commentWrapper is null, commentImagePreview: " + r8);
        return;
    L11:
        tt5.a.h("CommentImagePreview", "handleCommentImagePreview, commentImagePreview: " + r8);
        String r0 = r8.getCommentId();
        if (r0 != null) goto L14;
    L17:
        boolean r3 = true;
    L18:
        if (r3 == true) goto L29;
        String r4 = r8.getReplyId();
        if (r4 != null) goto L22;
    L25:
        boolean r5 = true;
    L26:
        if (r5 == true) goto L29;
        boolean r9 = false;
    L30:
        CommentImagePreview r10 = null;
        if (r9 == false) goto L34;
        r8 = null;
    L34:
        if (r8 != null) goto L36;
    L42:
        r2.I7();
        return;
    L36:
        if (r8.getImageIndex() < 0) goto L38;
        r1 = true;
    L38:
        if (r1 == false) goto L40;
        r10 = r8;
    L40:
        if (r10 == null) goto L42;
        r2.L7(r10.getCommentId(), r10.getReplyId(), r10.getImageIndex());
        return;
    L22:
        if (r4.length() == 0) goto L25;
        r5 = false;
    L29:
        r9 = true;
        goto L30
    L14:
        if (r0.length() == 0) goto L17;
        r3 = false;
    L44:
        e = move-exception;
        tt5.a.e("CommentImagePreview", "onReceive, parse data failed, error: ", e, false);
    }
}
