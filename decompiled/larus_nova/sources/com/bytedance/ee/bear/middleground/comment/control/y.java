package com.bytedance.ee.bear.middleground.comment.control;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.middleground.comment.export.ICardAdapter;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes18.dex */
public interface y {
    void A(String r100, int r101, boolean r102, boolean r103, boolean r104, View r105);

    void B(ICardAdapter r100, String r101, CommentBean.CommentDetail r102, View r103);

    void C(com.bytedance.ee.bear.rn.e r100);

    void D(CommentBean.CommentDetail r100, String r101);

    void E(com.bytedance.ee.bear.rn.e r100);

    void F(CommentBean.CommentDetail r100, String r101, Function0<Unit> r102);

    void G(FragmentManager r100, CommentBean.CommentDetail r101, String r102);

    com.bytedance.ee.bear.middleground.comment.cell.i H(String r100, int r101, com.bytedance.ee.bear.middleground.comment.cell.i.a r102);

    void a(String r100, int r101, String r102);

    boolean b(String r100, String r101);

    void c(String r100, String r101);

    void d(String r100);

    void e(String r100);

    void f(String r100);

    void g(List<String> r100);

    void h();

    boolean i();

    void j(CommentBean.CommentDetail r100, ICardAdapter r101, String r102, int r103, String r104, String r105, Map<Object, ? extends Object> r106);

    boolean k();

    boolean l(String r100);

    void m(float r100);

    void n(String r100, int r101, String r102);

    void o(View r100, CommentBean.CommentDetail r101, ICardAdapter r102, int r103, int r104);

    void p(com.bytedance.ee.bear.rn.d r100);

    void q();

    com.bytedance.ee.bear.middleground.comment.detail.c r();

    void s(String r100, CommentBean.CommentDetail r101, View r102);

    boolean t(String r100, List<String> r101);

    void u();

    void v(String r100, List<? extends q2c.c> r101);

    void w(CommentBean.CommentDetail r100, String r101, View r102);

    void x(View r100, CommentBean.CommentDetail r101, Function0<Unit> r102);

    void y(View r100, CommentBean.CommentDetail r101, ICardAdapter r102, int r103, List<String> r104, boolean r105);

    void z(com.bytedance.ee.bear.rn.e r100);
}
