package com.bytedance.ee.bear.middleground.comment.extension.addins;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c0 extends com.bytedance.ee.bear.middleground.comment.extension.addins.b {
    public String b;
    public String c;
    public String d;
    public int e;

    public static final class a {
    }

    public final class b extends ff5.a<ef5.k> {
        public final /* synthetic */ c0 a;

        public b(c0 r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r2) {
            Intrinsics.checkNotNullParameter((ef5.k) r2, "event");
            c0 r3 = this.a;
            r3.c = null;
            r3.d = null;
            r3.e = 0;
        }
    }

    public final class c extends ff5.a<ef5.l> {
        public final /* synthetic */ c0 a;

        public c(c0 r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r3) {
            ef5.l r4 = (ef5.l) r3;
            Intrinsics.checkNotNullParameter(r4, "event");
            c0 r0 = this.a;
            r0.c = r4.a;
            r0.d = r4.b;
            r0.e = r4.getType();
        }
    }

    public final class d extends ff5.a<ef5.m> {
        public final /* synthetic */ c0 a;

        public d(c0 r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r9) {
            ef5.m r10 = (ef5.m) r9;
            Intrinsics.checkNotNullParameter(r10, "event");
            if (r10.b == null) goto L96;
            boolean r1 = true;
            if (this.a.getContext().a().k() == false) goto L37;
            String r0 = this.a.b;
            if (r0 != null) goto L10;
        L13:
            boolean r2 = true;
        L14:
            if (r2 == true) goto L37;
            List<CommentBean.CommentDetail> r3 = ((CommentBean) ListProtector.get(r10.a, r10.b.intValue())).getComment_list();
            if (r3 == null) goto L31;
            List<CommentBean.CommentDetail> r4 = r3;
            c0 r5 = this.a;
            if ((r4 instanceof Collection) == true) goto L20;
        L22:
            Iterator<T> r6 = r4.iterator();
        L24:
            if (r6.hasNext() == false) goto L28;
            if (Intrinsics.areEqual(((CommentBean.CommentDetail) r6.next()).getReply_id(), r5.b) == false) goto L24;
            boolean r7 = true;
        L29:
            if (r7 != true) goto L31;
            boolean r8 = true;
        L32:
            if (r8 == true) goto L37;
            if (Intrinsics.areEqual(((CommentBean) ListProtector.get(r10.a, r10.b.intValue())).getComment_id(), this.a.b) == true) goto L37;
            tt5.a.h("Comment#ReactionAndDialogAutoDismissAddin", "replyId " + this.a.b + " does not exist, so dismiss reaction panel");
            this.a.getContext().a().h();
        L28:
            r7 = false;
            goto L29
        L20:
            if (r4.isEmpty() == false) goto L22;
        L31:
            r8 = false;
            goto L32
        L10:
            if (r0.length() == 0) goto L13;
            r2 = false;
        L37:
            if (this.a.getContext().a().i() == false) goto L89;
            c0 r11 = this.a;
            int r12 = r11.e;
            if (r12 != 0) goto L41;
            return;
        L41:
            if (r12 != 2) goto L43;
            String r13 = r11.c;
            if (r13 != null) goto L75;
        L78:
            if (r1 == false) goto L80;
            return;
        L80:
            if (Intrinsics.areEqual(((CommentBean) ListProtector.get(r10.a, r10.b.intValue())).getComment_id(), this.a.c) == true) goto L95;
            tt5.a.h("Comment#ReactionAndDialogAutoDismissAddin", "commentId " + this.a.c + " does not exist, so dismiss resolve confirm dialog");
            this.a.getContext().a().q();
            return;
        L95:
            return;
        L75:
            if (r13.length() == 0) goto L78;
            r1 = false;
            goto L78
        L43:
            if (r12 != 3) goto L97;
            String r14 = r11.d;
            if (r14 != null) goto L48;
        L51:
            boolean r15 = true;
        L52:
            if (r15 == true) goto L91;
            List<CommentBean.CommentDetail> r16 = ((CommentBean) ListProtector.get(r10.a, r10.b.intValue())).getComment_list();
            if (r16 == null) goto L69;
            List<CommentBean.CommentDetail> r17 = r16;
            c0 r18 = this.a;
            if ((r17 instanceof Collection) == true) goto L58;
        L60:
            Iterator<T> r19 = r17.iterator();
        L62:
            if (r19.hasNext() == false) goto L66;
            if (Intrinsics.areEqual(((CommentBean.CommentDetail) r19.next()).getReply_id(), r18.d) == false) goto L62;
            boolean r20 = true;
        L67:
            if (r20 != true) goto L69;
        L70:
            if (r1 == true) goto L92;
            tt5.a.h("Comment#ReactionAndDialogAutoDismissAddin", "replyId " + this.a.d + " does not exist, so dismiss delete confirm dialog");
            this.a.getContext().a().q();
            return;
        L92:
            return;
        L66:
            r20 = false;
            goto L67
        L58:
            if (r17.isEmpty() == false) goto L60;
        L69:
            r1 = false;
            goto L70
        L91:
            return;
        L48:
            if (r14.length() == 0) goto L51;
            r15 = false;
            goto L52
        L97:
            return;
        L89:
            return;
        }
    }

    public final class e extends ff5.a<ef5.c0> {
        public final /* synthetic */ c0 a;

        public e(c0 r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r2) {
            Intrinsics.checkNotNullParameter((ef5.c0) r2, "event");
            this.a.b = null;
        }
    }

    public final class f extends ff5.a<ef5.e0> {
        public final /* synthetic */ c0 a;

        public f(c0 r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r2) {
            ef5.e0 r3 = (ef5.e0) r2;
            Intrinsics.checkNotNullParameter(r3, "event");
            c0 r0 = this.a;
            r0.b = r3.a;
        }
    }

    static {
    }

    public c0() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.extension.addins.b, gf5.b
    public final void a(cf5.a r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        Intrinsics.checkNotNullParameter(r3, "host");
        this.a = r3;
        r3.b(ef5.e0.class, new f(this));
        r3.b(ef5.c0.class, new e(this));
        r3.b(ef5.l.class, new c(this));
        r3.b(ef5.k.class, new b(this));
        r3.b(ef5.m.class, new d(this));
    }
}
