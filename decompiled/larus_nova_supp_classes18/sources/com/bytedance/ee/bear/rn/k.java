package com.bytedance.ee.bear.rn;

import com.bytedance.ee.bear.middleground.comment.Comment;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface k {

    public interface a {
        void e(String r1);
    }

    void a();

    void b(sbb.e r1);

    void c(String r1);

    Flowable<String> d(String r1, String r2);

    Flowable<String> e(String r1, String r2, int r3);

    Flowable<String> f(String r1, String r2);

    Flowable<String> g(String r1, String r2);

    void y(Comment.g r1, boolean r2);
}
