package com.bytedance.ee.bear.middleground.comment.cell;

import com.bytedance.ee.bear.middleground.comment.export.Action;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j {

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.control.t a;

        public b(com.bytedance.ee.bear.middleground.comment.control.t r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            String r4 = (String) r3;
            com.bytedance.ee.bear.middleground.comment.control.t r0 = this.a;
            Intrinsics.checkNotNull(r4);
            r0.w(r4, Action.RESOLVE);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.control.t a;

        public c(com.bytedance.ee.bear.middleground.comment.control.t r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            tt5.a.f("Comment#ResolveCell", r4, false);
            com.bytedance.ee.bear.middleground.comment.control.t r0 = this.a;
            String r5 = r4.getMessage();
            if (r5 != null) goto L5;
            r5 = "{}";
        L5:
            r0.w(r5, Action.RESOLVE);
        }
    }

    static {
    }

    public j() {
    }

    public static void a(com.bytedance.ee.bear.middleground.comment.control.t r0, String r1, int r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r0, "dataControl");
        Intrinsics.checkNotNullParameter(r1, "commentId");
        Flowable<String> r4 = com.bytedance.ee.bear.middleground.comment.uitls.o.a(r0.r(r1, r2), null);
        if (r4 == null) goto L6;
        r4.subscribe(new b(r0), new c(r0));
        return;
    }
}
