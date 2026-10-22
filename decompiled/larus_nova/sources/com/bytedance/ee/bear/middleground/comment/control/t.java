package com.bytedance.ee.bear.middleground.comment.control;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.middleground.comment.Comment;
import com.bytedance.ee.bear.middleground.comment.export.Action;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import io.reactivex.Flowable;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes18.dex */
public interface t extends com.bytedance.ee.bear.middleground.comment.export.p {
    Flowable<String> A(String r100, int r101, String r102, String r103);

    Flowable<String> B(com.bytedance.ee.bear.rn.e r100);

    Flowable<String> C(com.bytedance.ee.bear.rn.e r100);

    Flowable<String> D(com.bytedance.ee.bear.rn.a r100);

    Flowable<String> F(int r100, String r101, String r102);

    Flowable<String> G(com.bytedance.ee.bear.rn.d r100);

    MutableLiveData<List<CommentBean>> I();

    void J(List<CommentBean> r100);

    void K();

    void L(List<CommentBean> r100);

    Flowable<String> M(com.bytedance.ee.bear.rn.e r100);

    CommentBean N(String r100);

    CommentBean O(String r100);

    void Q(Function1<? super String, Unit> r100);

    Flowable R(String r100, int r101, String r102);

    @Override // com.bytedance.ee.bear.middleground.comment.export.p
    Flowable<String> a(String r100, int r101, String r102);

    boolean b(String r100, String r101);

    Flowable<String> c(String r100, String r101);

    Flowable<String> d(String r100);

    Flowable<String> f(String r100);

    Flowable<String> g(com.bytedance.ee.bear.rn.e r100);

    Flowable<String> getComment();

    Flowable<String> h(String r100, String r101);

    Flowable<String> i(String r100, String r101);

    Flowable<String> j(String r100, int r101, String r102, String r103);

    Flowable<String> k(String r100, String r101, int r102, int r103, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r104);

    Flowable<String> l(String r100, String r101, int r102, String r103, String r104);

    Flowable<String> n(String r100, int r101, String r102);

    void o(String r100);

    Flowable<String> p(com.bytedance.ee.bear.rn.d r100);

    Flowable r(String r100, int r101);

    void s(sbb.e r100);

    @Override // com.bytedance.ee.bear.middleground.comment.export.p
    Flowable<String> t(String r100, int r101, String r102);

    Flowable<String> u(String r100, String r101, int r102, String r103, String r104);

    @Override // com.bytedance.ee.bear.middleground.comment.export.p
    void w(String r100, Action r101);

    void y(Comment.g r100, boolean r101);

    Flowable<String> z(com.bytedance.ee.bear.rn.e r100);
}
