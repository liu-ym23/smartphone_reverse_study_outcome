package com.bytedance.ee.bear.rn;

import com.bytedance.ee.bear.drive.biz.comment.f1;
import com.bytedance.ee.bear.middleground.comment.export.commentsdk.bean.CommentMetadata;
import io.reactivex.Flowable;
import uf5.p0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface g {

    public interface a {
        void a(String r1);
    }

    Flowable<String> B(e r1);

    void a();

    void b(sbb.e r1);

    void c(String r1);

    Flowable<String> d(String r1);

    Flowable<String> e(String r1);

    void f(p0 r1);

    Flowable<String> g(e r1);

    Flowable<String> h(boolean r1, String r2);

    Flowable<String> i(String r1, String r2);

    Flowable<String> j(d r1);

    void k();

    Flowable<String> l(String r1, String r2);

    void m(String r1, boolean r2);

    Flowable<String> n();

    void o(com.bytedance.ee.bear.middleground.comment.control.v r1);

    void p();

    void q(f1 r1);

    Flowable<String> r(boolean r1);

    void s(String r1);

    void v(CommentMetadata[] r1);

    void x(String r1);
}
