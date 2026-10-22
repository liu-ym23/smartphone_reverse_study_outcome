package com.bytedance.ee.bear.drive.biz.preview.vc.comment;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.doc.follow.FollowModuleState;
import com.bytedance.ee.bear.drive.biz.comment.p1;
import com.bytedance.ee.bear.drive.biz.preview.vc.connector.e;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import py4.h;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<p1> f223795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f223796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C3210a f223797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h f223798d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DriveCommentState f223799e;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.preview.vc.comment.a$a, reason: collision with other inner class name */
    public class C3210a implements Function1<Boolean, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f223800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f223801b;

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Boolean r100) {
            Boolean r101 = r100;
            tt5.a.h("CCMFollow_CommentVCFollowConnector", "CommentClosedListener invoke: aBoolean=" + r101);
            this.f223800a.a(null, false);
            if (r101.booleanValue() == true) goto L6;
            this.f223801b.getClass();
        L6:
            return Unit.INSTANCE;
        }

        public C3210a(a r100, b r101) {
            this.f223801b = r100;
            this.f223800a = r101;
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f223802a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f223803b;

        public b(a r100) {
            this.f223803b = r100;
            this.f223802a = SystemClock.uptimeMillis();
        }

        public final void a(String r100, boolean r101) {
            if ((SystemClock.uptimeMillis() - this.f223802a) >= 50) goto L5;
            return;
        L5:
            this.f223802a = SystemClock.uptimeMillis();
            a r102 = this.f223803b;
            r102.getClass();
            DriveCommentState r103 = new DriveCommentState();
            WeakReference<p1> r104 = r102.f223795a;
            if (r104 != null) goto L9;
        L14:
            FollowModuleState r105 = new FollowModuleState("comment", "drive_comment_update", JSON.toJSONString(r103));
            if (this.f223803b.f223798d == null) goto L18;
            tt5.a.h("CCMFollow_CommentVCFollowConnector", "CommentStateChangeListener onStateChange: followModuleState=" + r105.toString());
            this.f223803b.f223798d.b(r105);
            return;
        L18:
            return;
        L9:
            if (r104.get() != null) goto L11;
            tt5.a.k("CCMFollow_CommentVCFollowConnector", "CommentVCFollowConnector generateDriveCommentState: mCommentWrapper is null");
            goto L14
        L11:
            if (r101 == false) goto L13;
            r103.setFocusedCommentId(r100);
        L13:
            r103.setIsCommentExpanded(r101);
            goto L14
        }
    }

    public class c implements Function1<String, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f223804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f223805b;

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(String r100) {
            String r101 = r100;
            tt5.a.h("CCMFollow_CommentVCFollowConnector", "CommentSwitchChangeListener invoke: s=" + r101);
            if (TextUtils.isEmpty(r101) == true) goto L8;
            if (r101.startsWith("DriveCommentWrapper") == true) goto L8;
            this.f223804a.a(r101, true);
            this.f223805b.getClass();
        L8:
            return Unit.INSTANCE;
        }

        public c(a r100, b r101) {
            this.f223805b = r100;
            this.f223804a = r101;
        }
    }

    @Override // py4.g
    public final void b(FollowModuleState r100) {
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void d(sy4.b r100) {
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void e(boolean r100) {
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void f(boolean r100) {
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void g() {
    }

    @Override // py4.g
    public final String getModule() {
        return "comment";
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void onDetach() {
        tt5.a.h("CCMFollow_CommentVCFollowConnector", "CommentVCFollowConnector onDetach: ");
        this.f223799e = null;
        WeakReference<p1> r100 = this.f223795a;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.get() == null) goto L22;
        C3210a r101 = this.f223797c;
        WeakReference<p1> r102 = this.f223795a;
        if (r102 != null) goto L10;
        tt5.a.k("CCMFollow_CommentVCFollowConnector", "CommentVCFollowConnector.java.removeCommentClosedChangeListener: mCommentWrapper IS NULL");
    L14:
        c r103 = this.f223796b;
        WeakReference<p1> r104 = this.f223795a;
        if (r104 != null) goto L17;
        tt5.a.k("CCMFollow_CommentVCFollowConnector", "CommentVCFollowConnector.java.removeCommentSwitchChangeListener: mCommentWrapper IS NULL");
        return;
    L17:
        p1 r105 = r104.get();
        if (r105 != null) goto L20;
        tt5.a.k("CCMFollow_CommentVCFollowConnector", "CommentVCFollowConnector removeCommentSwitchChangeListener: mCommentWrapper is null");
        return;
    L20:
        r105.N7(r103);
        return;
    L10:
        p1 r106 = r102.get();
        if (r106 != null) goto L13;
        tt5.a.k("CCMFollow_CommentVCFollowConnector", "CommentVCFollowConnector removeCommentClosedChangeListener: mCommentWrapper is null");
        goto L14
    L13:
        r106.H7(r101);
        goto L14
    }

    public a() {
        b r100 = new b(this);
        this.f223796b = new c(this, r100);
        this.f223797c = new C3210a(this, r100);
    }

    @Override // py4.g
    public final void a(h r100) {
        this.f223798d = r100;
    }

    @Override // py4.g
    public final void c(FollowModuleState r100) {
        if (r100 == null) goto L13;
        if (TextUtils.equals(r100.module, "comment") == false) goto L13;
        DriveCommentState r101 = (DriveCommentState) JSON.parseObject(r100.data, DriveCommentState.class);     // Catch: Exception -> L9
    L11:
        tt5.a.h("CCMFollow_CommentVCFollowConnector", "setState mLatestState=" + r101);
        this.f223799e = r101;
        h(r101);
        return;
    L9:
        e = move-exception;
        tt5.a.e("CCMFollow_CommentVCFollowConnector", "parseState: ", e, false);
        r101 = new DriveCommentState();
    L13:
        if (("CommentVCFollowConnector setState: state is invalid state=" + r100) != null) goto L15;
        String r102 = "null";
    L16:
        tt5.a.k("CCMFollow_CommentVCFollowConnector", r102);
        return;
    L15:
        r102 = r100.toString();
        goto L16
    }

    public final void h(DriveCommentState r100) {
        tt5.a.h("CCMFollow_CommentVCFollowConnector", "CommentVCFollowConnector doRemoteAction");
        WeakReference<p1> r101 = this.f223795a;
        if (r101 != null) goto L6;
        tt5.a.h("CCMFollow_CommentVCFollowConnector", "doRemoteAction: mCommentWrapper is null");
        return;
    L6:
        if (r100 != null) goto L9;
        tt5.a.h("CCMFollow_CommentVCFollowConnector", "doRemoteAction: state is null");
        return;
    L9:
        p1 r102 = r101.get();
        if (r102 != null) goto L14;
        tt5.a.k("CCMFollow_CommentVCFollowConnector", "CommentVCFollowConnector doRemoteAction: mCommentWrapper is null");
        return;
    L14:
        if (r102.F7() == true) goto L33;
        tt5.a.k("CCMFollow_CommentVCFollowConnector", "CommentVCFollowConnector doRemoteAction: data is null");
        return;
    L33:
    L29:
        e = move-exception;
        tt5.a.l("CCMFollow_CommentVCFollowConnector", "CommentVCFollowConnector doRemoteAction: ", e);
        return;
    L18:
        if (r100.isIsCommentExpanded() == true) goto L20;
        r102.J1();     // Catch: Exception -> L29
    L32:
        return;
    L20:
        if (r102.isShowing() == false) goto L25;
        if (TextUtils.isEmpty(r100.getFocusedCommentId()) == true) goto L25;
        tt5.a.h("CCMFollow_CommentVCFollowConnector", "doRemoteAction: switchCard");     // Catch: Exception -> L29
        r102.E7(r100.getFocusedCommentId());     // Catch: Exception -> L29
    L25:
        if (r102.isShowing() == true) goto L32;
        tt5.a.h("CCMFollow_CommentVCFollowConnector", "doRemoteAction: showComment");     // Catch: Exception -> L29
        r102.J7(r100.getFocusedCommentId());     // Catch: Exception -> L29
        goto L32
    }
}
