package com.bytedance.ee.bear.middleground.comment.extension.addins;

import android.text.TextUtils;
import com.bytedance.ee.bear.middleground.comment.export.CommentStyle;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j0 extends com.bytedance.ee.bear.middleground.comment.extension.addins.b {
    public boolean b;
    public String c;

    public final class a extends ff5.a<ef5.h> {
        public final /* synthetic */ j0 a;

        public a(j0 r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r3) {
            ef5.h r4 = (ef5.h) r3;
            Intrinsics.checkNotNullParameter(r4, "event");
            j0 r0 = this.a;
            r0.b = true;
            r0.c = r4.a;
        }
    }

    public static final class b {
    }

    public final class c extends ff5.a<ef5.x> {
        public final /* synthetic */ j0 a;

        public c(j0 r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r7) {
            ef5.x r8 = (ef5.x) r7;
            Intrinsics.checkNotNullParameter(r8, "event");
            if (TextUtils.equals(this.a.c, r8.b.getComment_id()) == true) goto L6;
            tt5.a.h("Comment#ScrollToEndAfterSendAddin", "commentId not match");
            return;
        L6:
            if (this.a.b == false) goto L30;
            List<CommentBean.CommentDetail> r0 = r8.b.getComment_list();
            if (r0 != null) goto L12;
            return;
        L12:
            if ((!r8.c.isEmpty()) == true) goto L14;
        L16:
            boolean r1 = false;
        L18:
            if (this.a.getContext().getConfig().n == CommentStyle.HALF_SCREEN) goto L20;
            int r4 = CollectionsKt.getLastIndex(r0) - 1;
        L21:
            if (r1 == false) goto L27;
            j0 r2 = this.a;
            if (r2.b == false) goto L27;
            if (r2.getContext().a().l(((CommentBean.CommentDetail) ListProtector.get(r0, r4)).getUser_id()) == false) goto L27;
            r8.a.postDelayed(new k0(r8, r4), 200);
        L27:
            this.a.b = false;
            return;
        L20:
            r4 = CollectionsKt.getLastIndex(r0);
            goto L21
        L14:
            if (r8.c.size() >= r0.size()) goto L16;
            r1 = true;
            goto L18
        }
    }

    static {
    }

    public j0() {
        this.c = "";
    }

    @Override // com.bytedance.ee.bear.middleground.comment.extension.addins.b, gf5.b
    public final void a(cf5.a r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        Intrinsics.checkNotNullParameter(r3, "host");
        this.a = r3;
        r3.b(ef5.h.class, new a(this));
        r3.b(ef5.x.class, new c(this));
    }
}
