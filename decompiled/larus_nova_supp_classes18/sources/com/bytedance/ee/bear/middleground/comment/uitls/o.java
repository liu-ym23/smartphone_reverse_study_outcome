package com.bytedance.ee.bear.middleground.comment.uitls;

import com.bytedance.ee.bear.middleground.comment.export.bean.DataEntity;
import com.bytedance.ee.bear.middleground.comment.export.bean.ReviewException;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o {

    public static final class a<T, R> implements Function {
        public final /* synthetic */ Function1<String, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super String, Unit> r1) {
            this.a = r1;
        }

        public final Object apply(Object r5) {
            String r6 = (String) r5;
            Intrinsics.checkNotNullParameter(r6, "it");
            DataEntity.Entity.BodyEntity r0 = n.b(r6);
            if (r0 == null) goto L16;
            String r2 = null;
            if (r0.getCode() != 0) goto L18;
            Function1<String, Unit> r1 = this.a;     // Catch: Throwable -> L14
            if (r1 == null) goto L16;
            DataEntity.Entity.BodyEntity.Extra r3 = r0.getExtra();     // Catch: Throwable -> L14
            if (r3 == null) goto L12;
            r2 = r3.getNotNotifyUsers();     // Catch: Throwable -> L14
        L12:
            r1.invoke(r2);     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            th.printStackTrace();
            goto L16
        L18:
            if (((com.bytedance.ee.bear.review.a) org.koin.java.a.c(com.bytedance.ee.bear.review.a.class, null, null, 6)).b(r0.getCode()) == false) goto L22;
            throw new ReviewException();
        L22:
            throw new Throwable(r6);
        L16:
            return r6;
        }
    }

    public static final Flowable<String> a(Flowable<String> r1, Function1<? super String, Unit> r2) {
        if (r1 == null) goto L8;
        Flowable r3 = r1.map(new a(r2));
        if (r3 == null) goto L8;
        Flowable r4 = r3.subscribeOn(fo5.d.a());
        if (r4 == null) goto L8;
        return r4.observeOn(fo5.d.d());
    L8:
        return null;
    }
}
