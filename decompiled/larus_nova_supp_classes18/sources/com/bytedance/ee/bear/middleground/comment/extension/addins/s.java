package com.bytedance.ee.bear.middleground.comment.extension.addins;

import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s extends com.bytedance.ee.bear.middleground.comment.extension.addins.b {

    public static final class a {
    }

    public final class b extends ff5.a<ef5.o> {
        public final /* synthetic */ s a;

        public b(s r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r5) {
            ef5.o r6 = (ef5.o) r5;
            Intrinsics.checkNotNullParameter(r6, "event");
            if (ForsetiHelper.h() == false) goto L5;
            r6.a.a("InputCommentClickMentionAddin");
        L5:
            this.a.getContext().a().b(r6.c, r6.d);
            this.a.getContext().e().P0().invoke(r6.c, r6.d, r6.e);
            Ref.ObjectRef r0 = new Ref.ObjectRef();
            AppLifecycle.a.a.b(new t(this, r0, r6));
        }
    }

    public static final class c extends ff5.a<ef5.y> {
        public c() {
        }

        @Override // ff5.a
        public final void b(gf5.c r2) {
            ef5.y r3 = (ef5.y) r2;
            Intrinsics.checkNotNullParameter(r3, "event");
            if (r3.b != 0) goto L6;
            u r0 = new u(r3);
            rcb.e.a.post(r0);
            return;
        }
    }

    static {
    }

    public s() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.extension.addins.b, gf5.b
    public final void a(cf5.a r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        Intrinsics.checkNotNullParameter(r3, "host");
        this.a = r3;
        r3.b(ef5.o.class, new b(this));
        if (ForsetiHelper.h() == false) goto L6;
        r3.b(ef5.y.class, new c());
        return;
    }
}
