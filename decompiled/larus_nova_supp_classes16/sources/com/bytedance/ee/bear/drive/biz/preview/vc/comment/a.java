package com.bytedance.ee.bear.drive.biz.preview.vc.comment;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.doc.follow.FollowModuleState;
import com.bytedance.ee.bear.document.offline.file.upload.FileUploadModel;
import com.bytedance.ee.bear.drive.biz.comment.p1;
import com.bytedance.ee.bear.drive.biz.preview.vc.connector.e;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import py4.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements e {
    public WeakReference<p1> a;
    public final c b;
    public final C0154a c;
    public h d;
    public DriveCommentState e;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.preview.vc.comment.a$a, reason: collision with other inner class name */
    public class C0154a implements Function1<Boolean, Unit> {
        public final b a;
        public final /* synthetic */ a b;

        public final Object invoke(Object r4) {
            Boolean r5 = (Boolean) r4;
            tt5.a.h("CCMFollow_CommentVCFollowConnector", "CommentClosedListener invoke: aBoolean=" + r5);
            this.a.a(null, false);
            if (r5.booleanValue() == true) goto L6;
            this.b.getClass();
        L6:
            return Unit.INSTANCE;
        }

        public C0154a(a r1, b r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class b {
        public long a;
        public final /* synthetic */ a b;

        public b(a r3) {
            this.b = r3;
            this.a = SystemClock.uptimeMillis();
        }

        public final void a(String r6, boolean r7) {
            if ((SystemClock.uptimeMillis() - this.a) >= 50) goto L5;
            return;
        L5:
            this.a = SystemClock.uptimeMillis();
            a r0 = this.b;
            r0.getClass();
            DriveCommentState r1 = new DriveCommentState();
            WeakReference<p1> r2 = r0.a;
            if (r2 != null) goto L9;
        L14:
            FollowModuleState r8 = new FollowModuleState(FileUploadModel.FROM_COMMENT, "drive_comment_update", JSON.toJSONString(r1));
            if (this.b.d == null) goto L18;
            tt5.a.h("CCMFollow_CommentVCFollowConnector", "CommentStateChangeListener onStateChange: followModuleState=" + r8.toString());
            this.b.d.b(r8);
            return;
        L18:
            return;
        L9:
            if (r2.get() != null) goto L11;
            tt5.a.k("CCMFollow_CommentVCFollowConnector", "CommentVCFollowConnector generateDriveCommentState: mCommentWrapper is null");
            goto L14
        L11:
            if (r7 == false) goto L13;
            r1.setFocusedCommentId(r6);
        L13:
            r1.setIsCommentExpanded(r7);
            goto L14
        }
    }

    public class c implements Function1<String, Unit> {
        public final b a;
        public final /* synthetic */ a b;

        public final Object invoke(Object r3) {
            String r4 = (String) r3;
            tt5.a.h("CCMFollow_CommentVCFollowConnector", "CommentSwitchChangeListener invoke: s=" + r4);
            if (TextUtils.isEmpty(r4) == true) goto L8;
            if (r4.startsWith("DriveCommentWrapper") == true) goto L8;
            this.a.a(r4, true);
            this.b.getClass();
        L8:
            return Unit.INSTANCE;
        }

        public c(a r1, b r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    @Override // py4.g
    public final void b(FollowModuleState r1) {
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void d(sy4.b r1) {
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void e(boolean r1) {
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void f(boolean r1) {
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void g() {
    }

    @Override // py4.g
    public final String getModule() {
        return FileUploadModel.FROM_COMMENT;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void onDetach() {
        tt5.a.h("CCMFollow_CommentVCFollowConnector", "CommentVCFollowConnector onDetach: ");
        this.e = null;
        WeakReference<p1> r1 = this.a;
        if (r1 != null) goto L6;
        return;
    L6:
        if (r1.get() == null) goto L22;
        C0154a r2 = this.c;
        WeakReference<p1> r3 = this.a;
        if (r3 != null) goto L10;
        tt5.a.k("CCMFollow_CommentVCFollowConnector", "CommentVCFollowConnector.java.removeCommentClosedChangeListener: mCommentWrapper IS NULL");
    L14:
        c r4 = this.b;
        WeakReference<p1> r5 = this.a;
        if (r5 != null) goto L17;
        tt5.a.k("CCMFollow_CommentVCFollowConnector", "CommentVCFollowConnector.java.removeCommentSwitchChangeListener: mCommentWrapper IS NULL");
        return;
    L17:
        p1 r6 = r5.get();
        if (r6 != null) goto L20;
        tt5.a.k("CCMFollow_CommentVCFollowConnector", "CommentVCFollowConnector removeCommentSwitchChangeListener: mCommentWrapper is null");
        return;
    L20:
        r6.N7(r4);
        return;
    L10:
        p1 r7 = r3.get();
        if (r7 != null) goto L13;
        tt5.a.k("CCMFollow_CommentVCFollowConnector", "CommentVCFollowConnector removeCommentClosedChangeListener: mCommentWrapper is null");
        goto L14
    L13:
        r7.H7(r2);
        goto L14
    }

    public a() {
        b r0 = new b(this);
        this.b = new c(this, r0);
        this.c = new C0154a(this, r0);
    }

    @Override // py4.g
    public final void a(h r1) {
        this.d = r1;
    }

    @Override // py4.g
    public final void c(FollowModuleState r4) {
        if (r4 == null) goto L13;
        if (TextUtils.equals(r4.module, FileUploadModel.FROM_COMMENT) == false) goto L13;
        DriveCommentState r5 = (DriveCommentState) JSON.parseObject(r4.data, DriveCommentState.class);     // Catch: Exception -> L9
    L11:
        tt5.a.h("CCMFollow_CommentVCFollowConnector", "setState mLatestState=" + r5);
        this.e = r5;
        h(r5);
        return;
    L9:
        e = move-exception;
        tt5.a.e("CCMFollow_CommentVCFollowConnector", "parseState: ", e, false);
        r5 = new DriveCommentState();
    L13:
        if (("CommentVCFollowConnector setState: state is invalid state=" + r4) != null) goto L15;
        String r6 = "null";
    L16:
        tt5.a.k("CCMFollow_CommentVCFollowConnector", r6);
        return;
    L15:
        r6 = r4.toString();
        goto L16
    }

    public final void h(DriveCommentState r4) {
        tt5.a.h("CCMFollow_CommentVCFollowConnector", "CommentVCFollowConnector doRemoteAction");
        WeakReference<p1> r1 = this.a;
        if (r1 != null) goto L6;
        tt5.a.h("CCMFollow_CommentVCFollowConnector", "doRemoteAction: mCommentWrapper is null");
        return;
    L6:
        if (r4 != null) goto L9;
        tt5.a.h("CCMFollow_CommentVCFollowConnector", "doRemoteAction: state is null");
        return;
    L9:
        p1 r2 = r1.get();
        if (r2 != null) goto L14;
        tt5.a.k("CCMFollow_CommentVCFollowConnector", "CommentVCFollowConnector doRemoteAction: mCommentWrapper is null");
        return;
    L14:
        if (r2.F7() == true) goto L33;
        tt5.a.k("CCMFollow_CommentVCFollowConnector", "CommentVCFollowConnector doRemoteAction: data is null");
        return;
    L33:
    L29:
        e = move-exception;
        tt5.a.l("CCMFollow_CommentVCFollowConnector", "CommentVCFollowConnector doRemoteAction: ", e);
        return;
    L18:
        if (r4.isIsCommentExpanded() == true) goto L20;
        r2.J1();     // Catch: Exception -> L29
    L32:
        return;
    L20:
        if (r2.isShowing() == false) goto L25;
        if (TextUtils.isEmpty(r4.getFocusedCommentId()) == true) goto L25;
        tt5.a.h("CCMFollow_CommentVCFollowConnector", "doRemoteAction: switchCard");     // Catch: Exception -> L29
        r2.E7(r4.getFocusedCommentId());     // Catch: Exception -> L29
    L25:
        if (r2.isShowing() == true) goto L32;
        tt5.a.h("CCMFollow_CommentVCFollowConnector", "doRemoteAction: showComment");     // Catch: Exception -> L29
        r2.J7(r4.getFocusedCommentId());     // Catch: Exception -> L29
        goto L32
    }
}
