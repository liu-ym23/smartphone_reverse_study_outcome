package com.bytedance.ee.bear.rn;

import com.bytedance.ee.bear.drive.biz.comment.f1;
import com.bytedance.ee.bear.middleground.comment.export.commentsdk.bean.CommentMetadata;
import io.reactivex.Flowable;
import uf5.p0;

/* JADX INFO: loaded from: classes18.dex */
public interface g {

    public interface a {
        void a(String r100);
    }

    Flowable<String> B(e r100);

    void a();

    void b(sbb.e r100);

    void c(String r100);

    Flowable<String> d(String r100);

    Flowable<String> e(String r100);

    void f(p0 r100);

    Flowable<String> g(e r100);

    Flowable<String> h(boolean r100, String r101);

    Flowable<String> i(String r100, String r101);

    Flowable<String> j(d r100);

    void k();

    Flowable<String> l(String r100, String r101);

    void m(String r100, boolean r101);

    Flowable<String> n();

    void o(com.bytedance.ee.bear.middleground.comment.control.v r100);

    void p();

    void q(f1 r100);

    Flowable<String> r(boolean r100);

    void s(String r100);

    void v(CommentMetadata[] r100);

    void x(String r100);
}
