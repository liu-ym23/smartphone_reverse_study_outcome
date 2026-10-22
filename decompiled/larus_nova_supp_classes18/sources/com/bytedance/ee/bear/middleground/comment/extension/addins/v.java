package com.bytedance.ee.bear.middleground.comment.extension.addins;

import com.bytedance.ee.bear.middleground.comment.export.CommentStyle;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class v extends com.bytedance.ee.bear.middleground.comment.extension.addins.b {
    public String b;

    public final class a extends ff5.a<ef5.j> {
        public final /* synthetic */ v a;

        public a(v r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r6) {
            ef5.j r7 = (ef5.j) r6;
            Intrinsics.checkNotNullParameter(r7, "event");
            this.a.getContext().e().E0().invoke(r7.c, r7.d, Integer.valueOf(r7.b), r7.f);
            v r0 = this.a;
            r0.b = r7.c;
        }
    }

    public final class b extends ff5.a<ef5.m> {
        public final /* synthetic */ v a;

        public b(v r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r6) {
            ef5.m r7 = (ef5.m) r6;
            Intrinsics.checkNotNullParameter(r7, "event");
            Integer r0 = r7.b;
            if (r0 != null) goto L5;
            this.a.b = "";
            return;
        L5:
            String r1 = ((CommentBean) ListProtector.get(r7.a, r0.intValue())).getComment_id();
            String r2 = this.a.b;
            boolean r3 = false;
            if (r2 != null) goto L8;
        L11:
            boolean r4 = true;
        L12:
            if (r4 == true) goto L19;
            if (Intrinsics.areEqual(r7.b, r7.c) == false) goto L19;
            if (Intrinsics.areEqual(this.a.b, r1) == true) goto L19;
            r3 = true;
        L19:
            if (this.a.getContext().getConfig().n == CommentStyle.HALF_SCREEN) goto L21;
            if (r3 == true) goto L21;
        L22:
            this.a.b = r1;
            return;
        L21:
            this.a.getContext().e().E0().invoke(((CommentBean) ListProtector.get(r7.a, r7.b.intValue())).getComment_id(), ((CommentBean) ListProtector.get(r7.a, r7.b.intValue())).getCommentUUID(), Integer.valueOf(((CommentBean) ListProtector.get(r7.a, r7.b.intValue())).getCommentType()), null);
            goto L22
        L8:
            if (r2.length() == 0) goto L11;
            r4 = false;
            goto L12
        }
    }

    public v() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.extension.addins.b, gf5.b
    public final void a(cf5.a r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        Intrinsics.checkNotNullParameter(r3, "host");
        this.a = r3;
        r3.b(ef5.j.class, new a(this));
        r3.b(ef5.m.class, new b(this));
    }
}
