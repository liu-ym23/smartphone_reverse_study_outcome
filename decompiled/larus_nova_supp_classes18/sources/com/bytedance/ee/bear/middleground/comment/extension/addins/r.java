package com.bytedance.ee.bear.middleground.comment.extension.addins;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.middleground.comment.input.AsideInputComment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r extends com.bytedance.ee.bear.middleground.comment.extension.addins.b {
    public kf5.b b;

    public final class a extends ff5.a<ef5.d> {
        public final /* synthetic */ r a;

        public a(r r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r4) {
            Intrinsics.checkNotNullParameter((ef5.d) r4, "event");
            tt5.a.h("Comment#InputAutoDismissPlugin", "onCommentDismiss");
            kf5.b r5 = this.a.b;
            if (r5 == null) goto L7;
            boolean r2 = true;
            if (r5.isShowing() != true) goto L7;
        L8:
            if (r2 == false) goto L13;
            tt5.a.h("Comment#InputAutoDismissPlugin", "comment dismiss, so dismiss input");
            this.a.getContext().e().T().c.invoke();
            kf5.b r6 = this.a.b;
            if (r6 == null) goto L14;
            kf5.a.a(r6, false, false, 3);
            return;
        L14:
            return;
        L13:
            return;
        L7:
            r2 = false;
            goto L8
        }
    }

    public static final class b {
    }

    public final class c extends ff5.a<ef5.m> {
        public final /* synthetic */ r a;

        public c(r r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r7) {
            ef5.m r8 = (ef5.m) r7;
            Intrinsics.checkNotNullParameter(r8, "event");
            kf5.b r0 = this.a.b;
            boolean r1 = true;
            if (r0 != null) goto L5;
        L7:
            boolean r2 = false;
        L8:
            if (r2 == false) goto L73;
            kf5.b r3 = this.a.b;
            if ((r3 instanceof AsideInputComment) == false) goto L12;
            return;
        L12:
            if (r8.b == null) goto L76;
            Intrinsics.checkNotNull(r3);
            CommentInputRequest r4 = r3.i();
            String r5 = r4.comment_id;
            if (r5 != null) goto L17;
        L19:
            boolean r6 = false;
        L20:
            if (r6 == false) goto L35;
            List<CommentBean> r9 = r8.a;
            if ((r9 instanceof Collection) == true) goto L24;
        L26:
            Iterator<T> r10 = r9.iterator();
        L28:
            if (r10.hasNext() == false) goto L32;
            if (Intrinsics.areEqual(((CommentBean) r10.next()).getComment_id(), r4.comment_id) == false) goto L28;
            boolean r11 = true;
        L33:
            if (r11 == true) goto L35;
            boolean r12 = true;
        L36:
            String r13 = r4.reply_id;
            if (r13 != null) goto L39;
        L41:
            boolean r14 = false;
        L42:
            if (r14 == false) goto L62;
            List<CommentBean.CommentDetail> r15 = ((CommentBean) ListProtector.get(r8.a, r8.b.intValue())).getComment_list();
            if (r15 == null) goto L59;
            List<CommentBean.CommentDetail> r16 = r15;
            if ((r16 instanceof Collection) == true) goto L48;
        L50:
            Iterator<T> r17 = r16.iterator();
        L52:
            if (r17.hasNext() == false) goto L56;
            if (Intrinsics.areEqual(((CommentBean.CommentDetail) r17.next()).getReply_id(), r4.reply_id) == false) goto L52;
            boolean r18 = true;
        L57:
            if (r18 != true) goto L59;
            boolean r19 = true;
        L60:
            if (r19 == true) goto L62;
        L63:
            if (r12 == true) goto L65;
            if (r1 == true) goto L65;
            return;
        L65:
            tt5.a.h("Comment#InputAutoDismissPlugin", "reply or edit target does not exist, so dismiss input");
            this.a.getContext().e().T().c.invoke();
            kf5.b r20 = this.a.b;
            Intrinsics.checkNotNull(r20);
            kf5.a.a(r20, false, false, 3);
            return;
        L56:
            r18 = false;
            goto L57
        L48:
            if (r16.isEmpty() == false) goto L50;
        L59:
            r19 = false;
        L62:
            r1 = false;
            goto L63
        L39:
            if ((!StringsKt.isBlank(r13)) != true) goto L41;
            r14 = true;
        L32:
            r11 = false;
            goto L33
        L24:
            if (r9.isEmpty() == false) goto L26;
        L35:
            r12 = false;
            goto L36
        L17:
            if ((!StringsKt.isBlank(r5)) != true) goto L19;
            r6 = true;
            goto L20
        L76:
            return;
        L73:
            return;
        L5:
            if (r0.isShowing() != true) goto L7;
            r2 = true;
            goto L8
        }
    }

    public final class d extends ff5.a<ef5.n> {
        public final /* synthetic */ r a;

        public d(r r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r4) {
            ef5.n r5 = (ef5.n) r4;
            Intrinsics.checkNotNullParameter(r5, "event");
            tt5.a.h("Comment#InputAutoDismissPlugin", "onFollowStateChange, isReply = " + r5.a);
            if (r5.a == false) goto L18;
            kf5.b r6 = this.a.b;
            if ((r6 instanceof AsideInputComment) == false) goto L8;
            return;
        L8:
            if (r6 == null) goto L12;
            boolean r2 = true;
            if (r6.isShowing() != true) goto L12;
        L13:
            if (r2 == false) goto L19;
            tt5.a.h("Comment#InputAutoDismissPlugin", "switch to follow state, so dismiss input");
            this.a.getContext().e().T().c.invoke();
            kf5.b r7 = this.a.b;
            if (r7 == null) goto L20;
            kf5.a.a(r7, false, false, 3);
            return;
        L20:
            return;
        L19:
            return;
        L12:
            r2 = false;
            goto L13
        }
    }

    public final class e extends ff5.a<ef5.q> {
        public final /* synthetic */ r a;

        public e(r r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r3) {
            ef5.q r4 = (ef5.q) r3;
            Intrinsics.checkNotNullParameter(r4, "event");
            kf5.b r0 = this.a.b;
            if (r0 != null) goto L5;
        L7:
            this.a.b = null;
            return;
        L5:
            if (Intrinsics.areEqual(r0, r4.d) == true) goto L7;
            tt5.a.k("Comment#InputAutoDismissPlugin", "not same input! last show: " + this.a.b + ", dismissed: " + r4.d);
            goto L7
        }
    }

    public final class f extends ff5.a<ef5.t> {
        public final /* synthetic */ r a;

        public f(r r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r2) {
            ef5.t r3 = (ef5.t) r2;
            Intrinsics.checkNotNullParameter(r3, "event");
            r r0 = this.a;
            r0.b = r3.a;
        }
    }

    static {
    }

    public r() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.extension.addins.b, gf5.b
    public final void a(cf5.a r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        Intrinsics.checkNotNullParameter(r3, "host");
        this.a = r3;
        r3.b(ef5.t.class, new f(this));
        r3.b(ef5.q.class, new e(this));
        r3.b(ef5.m.class, new c(this));
        r3.b(ef5.n.class, new d(this));
        r3.b(ef5.d.class, new a(this));
    }
}
