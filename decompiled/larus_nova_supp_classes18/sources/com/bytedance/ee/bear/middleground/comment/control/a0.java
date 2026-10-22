package com.bytedance.ee.bear.middleground.comment.control;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyDataForInsert;
import com.bytedance.ee.bear.middleground.comment.export.bean.VisibilityBean;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface a0 {
    void A(String r1, int r2, String r3, String r4);

    void a(String r1, int r2, String r3);

    void b(String r1, String r2);

    void c(String r1, String r2);

    void d(String r1);

    void e(String r1, String r2, int r3, String r4, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r5, String r6, boolean r7, SmartReplyDataForInsert r8);

    void f(String r1);

    void g(String r1, int r2);

    void h(String r1, String r2);

    void i(String r1, String r2);

    void j(String r1, int r2, String r3, String r4);

    void k(String r1, String r2, int r3, int r4, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r5);

    void l(String r1, String r2, int r3, String r4, String r5);

    void m(String r1, VisibilityBean r2, String r3);

    void n(String r1, int r2, VisibilityBean r3, String r4, boolean r5, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r6, boolean r7);

    void o(String r1, String r2, SmartReplyDataForInsert r3);

    void p(String r1, int r2, String r3);

    void q(String r1, String r2, String r3, int r4, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r5, boolean r6, boolean r7);

    void r(String r1, int r2);

    void s(String r1, int r2, String r3);

    void u(String r1, String r2, int r3, String r4, String r5);
}
