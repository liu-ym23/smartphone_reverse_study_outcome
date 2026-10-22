package com.bytedance.ee.bear.middleground.comment.control;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyDataForInsert;
import com.bytedance.ee.bear.middleground.comment.export.bean.VisibilityBean;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public interface a0 {
    void A(String r100, int r101, String r102, String r103);

    void a(String r100, int r101, String r102);

    void b(String r100, String r101);

    void c(String r100, String r101);

    void d(String r100);

    void e(String r100, String r101, int r102, String r103, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r104, String r105, boolean r106, SmartReplyDataForInsert r107);

    void f(String r100);

    void g(String r100, int r101);

    void h(String r100, String r101);

    void i(String r100, String r101);

    void j(String r100, int r101, String r102, String r103);

    void k(String r100, String r101, int r102, int r103, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r104);

    void l(String r100, String r101, int r102, String r103, String r104);

    void m(String r100, VisibilityBean r101, String r102);

    void n(String r100, int r101, VisibilityBean r102, String r103, boolean r104, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r105, boolean r106);

    void o(String r100, String r101, SmartReplyDataForInsert r102);

    void p(String r100, int r101, String r102);

    void q(String r100, String r101, String r102, int r103, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r104, boolean r105, boolean r106);

    void r(String r100, int r101);

    void s(String r100, int r101, String r102);

    void u(String r100, String r101, int r102, String r103, String r104);
}
