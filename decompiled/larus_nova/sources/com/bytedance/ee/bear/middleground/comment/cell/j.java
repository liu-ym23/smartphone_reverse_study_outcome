package com.bytedance.ee.bear.middleground.comment.cell;

import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.ee.bear.middleground.comment.export.Action;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class j {

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.control.t f231064a;

        public b(com.bytedance.ee.bear.middleground.comment.control.t r100) {
            this.f231064a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            String r101 = (String) r100;
            com.bytedance.ee.bear.middleground.comment.control.t r102 = this.f231064a;
            Intrinsics.checkNotNull(r101);
            r102.w(r101, Action.RESOLVE);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.control.t f231065a;

        public c(com.bytedance.ee.bear.middleground.comment.control.t r100) {
            this.f231065a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            tt5.a.f("Comment#ResolveCell", r101, false);
            com.bytedance.ee.bear.middleground.comment.control.t r102 = this.f231065a;
            String r103 = r101.getMessage();
            if (r103 != null) goto L5;
            r103 = SliceInitService.DEFAULT_SWITCH;
        L5:
            r102.w(r103, Action.RESOLVE);
        }
    }

    static {
    }

    public j() {
    }

    public static void a(com.bytedance.ee.bear.middleground.comment.control.t r100, String r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "dataControl");
        Intrinsics.checkNotNullParameter(r101, "commentId");
        Flowable<String> r104 = com.bytedance.ee.bear.middleground.comment.uitls.o.a(r100.r(r101, r102), null);
        if (r104 == null) goto L6;
        r104.subscribe(new b(r100), new c(r100));
        return;
    }
}
