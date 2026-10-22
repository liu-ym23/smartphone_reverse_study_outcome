package com.bytedance.ee.bear.middleground.comment.control;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.middleground.comment.Comment;
import com.bytedance.ee.bear.middleground.comment.export.Action;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import io.reactivex.Flowable;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface t extends com.bytedance.ee.bear.middleground.comment.export.p {
    Flowable<String> A(String r1, int r2, String r3, String r4);

    Flowable<String> B(com.bytedance.ee.bear.rn.e r1);

    Flowable<String> C(com.bytedance.ee.bear.rn.e r1);

    Flowable<String> D(com.bytedance.ee.bear.rn.a r1);

    Flowable<String> F(int r1, String r2, String r3);

    Flowable<String> G(com.bytedance.ee.bear.rn.d r1);

    MutableLiveData<List<CommentBean>> I();

    void J(List<CommentBean> r1);

    void K();

    void L(List<CommentBean> r1);

    Flowable<String> M(com.bytedance.ee.bear.rn.e r1);

    CommentBean N(String r1);

    CommentBean O(String r1);

    void Q(Function1<? super String, Unit> r1);

    Flowable R(String r1, int r2, String r3);

    @Override // com.bytedance.ee.bear.middleground.comment.export.p
    Flowable<String> a(String r1, int r2, String r3);

    boolean b(String r1, String r2);

    Flowable<String> c(String r1, String r2);

    Flowable<String> d(String r1);

    Flowable<String> f(String r1);

    Flowable<String> g(com.bytedance.ee.bear.rn.e r1);

    Flowable<String> getComment();

    Flowable<String> h(String r1, String r2);

    Flowable<String> i(String r1, String r2);

    Flowable<String> j(String r1, int r2, String r3, String r4);

    Flowable<String> k(String r1, String r2, int r3, int r4, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r5);

    Flowable<String> l(String r1, String r2, int r3, String r4, String r5);

    Flowable<String> n(String r1, int r2, String r3);

    void o(String r1);

    Flowable<String> p(com.bytedance.ee.bear.rn.d r1);

    Flowable r(String r1, int r2);

    void s(sbb.e r1);

    @Override // com.bytedance.ee.bear.middleground.comment.export.p
    Flowable<String> t(String r1, int r2, String r3);

    Flowable<String> u(String r1, String r2, int r3, String r4, String r5);

    @Override // com.bytedance.ee.bear.middleground.comment.export.p
    void w(String r1, Action r2);

    void y(Comment.g r1, boolean r2);

    Flowable<String> z(com.bytedance.ee.bear.rn.e r1);
}
