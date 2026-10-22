package com.bytedance.ee.bear.middleground.comment.control;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.middleground.comment.export.ICardAdapter;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface y {
    void A(String r1, int r2, boolean r3, boolean r4, boolean r5, View r6);

    void B(ICardAdapter r1, String r2, CommentBean.CommentDetail r3, View r4);

    void C(com.bytedance.ee.bear.rn.e r1);

    void D(CommentBean.CommentDetail r1, String r2);

    void E(com.bytedance.ee.bear.rn.e r1);

    void F(CommentBean.CommentDetail r1, String r2, Function0<Unit> r3);

    void G(FragmentManager r1, CommentBean.CommentDetail r2, String r3);

    com.bytedance.ee.bear.middleground.comment.cell.i H(String r1, int r2, com.bytedance.ee.bear.middleground.comment.cell.i.a r3);

    void a(String r1, int r2, String r3);

    boolean b(String r1, String r2);

    void c(String r1, String r2);

    void d(String r1);

    void e(String r1);

    void f(String r1);

    void g(List<String> r1);

    void h();

    boolean i();

    void j(CommentBean.CommentDetail r1, ICardAdapter r2, String r3, int r4, String r5, String r6, Map<Object, ? extends Object> r7);

    boolean k();

    boolean l(String r1);

    void m(float r1);

    void n(String r1, int r2, String r3);

    void o(View r1, CommentBean.CommentDetail r2, ICardAdapter r3, int r4, int r5);

    void p(com.bytedance.ee.bear.rn.d r1);

    void q();

    com.bytedance.ee.bear.middleground.comment.detail.c r();

    void s(String r1, CommentBean.CommentDetail r2, View r3);

    boolean t(String r1, List<String> r2);

    void u();

    void v(String r1, List<? extends q2c.c> r2);

    void w(CommentBean.CommentDetail r1, String r2, View r3);

    void x(View r1, CommentBean.CommentDetail r2, Function0<Unit> r3);

    void y(View r1, CommentBean.CommentDetail r2, ICardAdapter r3, int r4, List<String> r5, boolean r6);

    void z(com.bytedance.ee.bear.rn.e r1);
}
