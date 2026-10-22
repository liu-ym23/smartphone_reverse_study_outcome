package com.bytedance.ee.bear.middleground.comment.extension.addins;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c0 extends com.bytedance.ee.bear.middleground.comment.extension.addins.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f231435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f231436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f231437d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f231438e;

    public static final class a {
    }

    public final class b extends ff5.a<ef5.k> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c0 f231439a;

        public b(c0 r100) {
            this.f231439a = r100;
        }

        @Override // ff5.a
        public final void b(gf5.c r100) {
            Intrinsics.checkNotNullParameter((ef5.k) r100, "event");
            c0 r101 = this.f231439a;
            r101.f231436c = null;
            r101.f231437d = null;
            r101.f231438e = 0;
        }
    }

    public final class c extends ff5.a<ef5.l> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c0 f231440a;

        public c(c0 r100) {
            this.f231440a = r100;
        }

        @Override // ff5.a
        public final void b(gf5.c r100) {
            ef5.l r101 = (ef5.l) r100;
            Intrinsics.checkNotNullParameter(r101, "event");
            c0 r102 = this.f231440a;
            r102.f231436c = r101.f472480a;
            r102.f231437d = r101.f472481b;
            r102.f231438e = r101.getType();
        }
    }

    public final class d extends ff5.a<ef5.m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c0 f231441a;

        public d(c0 r100) {
            this.f231441a = r100;
        }

        @Override // ff5.a
        public final void b(gf5.c r100) {
            ef5.m r101 = (ef5.m) r100;
            Intrinsics.checkNotNullParameter(r101, "event");
            if (r101.f472484b == null) goto L96;
            boolean r102 = true;
            if (this.f231441a.getContext().a().k() == false) goto L37;
            String r103 = this.f231441a.f231435b;
            if (r103 != null) goto L10;
        L13:
            boolean r104 = true;
        L14:
            if (r104 == true) goto L37;
            List<CommentBean.CommentDetail> r105 = ((CommentBean) ListProtector.get(r101.f472483a, r101.f472484b.intValue())).getComment_list();
            if (r105 == null) goto L31;
            List<CommentBean.CommentDetail> r106 = r105;
            c0 r107 = this.f231441a;
            if ((r106 instanceof Collection) == true) goto L20;
        L22:
            Iterator<T> r108 = r106.iterator();
        L24:
            if (r108.hasNext() == false) goto L28;
            if (Intrinsics.areEqual(((CommentBean.CommentDetail) r108.next()).getReply_id(), r107.f231435b) == false) goto L24;
            boolean r109 = true;
        L29:
            if (r109 != true) goto L31;
            boolean r110 = true;
        L32:
            if (r110 == true) goto L37;
            if (Intrinsics.areEqual(((CommentBean) ListProtector.get(r101.f472483a, r101.f472484b.intValue())).getComment_id(), this.f231441a.f231435b) == true) goto L37;
            tt5.a.h("Comment#ReactionAndDialogAutoDismissAddin", "replyId " + this.f231441a.f231435b + " does not exist, so dismiss reaction panel");
            this.f231441a.getContext().a().h();
        L28:
            r109 = false;
            goto L29
        L20:
            if (r106.isEmpty() == false) goto L22;
        L31:
            r110 = false;
            goto L32
        L10:
            if (r103.length() == 0) goto L13;
            r104 = false;
        L37:
            if (this.f231441a.getContext().a().i() == false) goto L89;
            c0 r111 = this.f231441a;
            int r112 = r111.f231438e;
            if (r112 != 0) goto L41;
            return;
        L41:
            if (r112 != 2) goto L43;
            String r113 = r111.f231436c;
            if (r113 != null) goto L75;
        L78:
            if (r102 == false) goto L80;
            return;
        L80:
            if (Intrinsics.areEqual(((CommentBean) ListProtector.get(r101.f472483a, r101.f472484b.intValue())).getComment_id(), this.f231441a.f231436c) == true) goto L95;
            tt5.a.h("Comment#ReactionAndDialogAutoDismissAddin", "commentId " + this.f231441a.f231436c + " does not exist, so dismiss resolve confirm dialog");
            this.f231441a.getContext().a().q();
            return;
        L95:
            return;
        L75:
            if (r113.length() == 0) goto L78;
            r102 = false;
            goto L78
        L43:
            if (r112 != 3) goto L97;
            String r114 = r111.f231437d;
            if (r114 != null) goto L48;
        L51:
            boolean r115 = true;
        L52:
            if (r115 == true) goto L91;
            List<CommentBean.CommentDetail> r116 = ((CommentBean) ListProtector.get(r101.f472483a, r101.f472484b.intValue())).getComment_list();
            if (r116 == null) goto L69;
            List<CommentBean.CommentDetail> r117 = r116;
            c0 r118 = this.f231441a;
            if ((r117 instanceof Collection) == true) goto L58;
        L60:
            Iterator<T> r119 = r117.iterator();
        L62:
            if (r119.hasNext() == false) goto L66;
            if (Intrinsics.areEqual(((CommentBean.CommentDetail) r119.next()).getReply_id(), r118.f231437d) == false) goto L62;
            boolean r120 = true;
        L67:
            if (r120 != true) goto L69;
        L70:
            if (r102 == true) goto L92;
            tt5.a.h("Comment#ReactionAndDialogAutoDismissAddin", "replyId " + this.f231441a.f231437d + " does not exist, so dismiss delete confirm dialog");
            this.f231441a.getContext().a().q();
            return;
        L92:
            return;
        L66:
            r120 = false;
            goto L67
        L58:
            if (r117.isEmpty() == false) goto L60;
        L69:
            r102 = false;
            goto L70
        L91:
            return;
        L48:
            if (r114.length() == 0) goto L51;
            r115 = false;
            goto L52
        L97:
            return;
        L89:
            return;
        }
    }

    public final class e extends ff5.a<ef5.c0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c0 f231442a;

        public e(c0 r100) {
            this.f231442a = r100;
        }

        @Override // ff5.a
        public final void b(gf5.c r100) {
            Intrinsics.checkNotNullParameter((ef5.c0) r100, "event");
            this.f231442a.f231435b = null;
        }
    }

    public final class f extends ff5.a<ef5.e0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c0 f231443a;

        public f(c0 r100) {
            this.f231443a = r100;
        }

        @Override // ff5.a
        public final void b(gf5.c r100) {
            ef5.e0 r101 = (ef5.e0) r100;
            Intrinsics.checkNotNullParameter(r101, "event");
            c0 r102 = this.f231443a;
            r102.f231435b = r101.f472455a;
        }
    }

    static {
    }

    public c0() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.extension.addins.b, gf5.b
    public final void a(cf5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r100, "host");
        this.f231427a = r100;
        r100.b(ef5.e0.class, new f(this));
        r100.b(ef5.c0.class, new e(this));
        r100.b(ef5.l.class, new c(this));
        r100.b(ef5.k.class, new b(this));
        r100.b(ef5.m.class, new d(this));
    }
}
