package com.bytedance.ee.bear.middleground.comment.export;

import com.bytedance.ee.bear.drive.biz.comment.DriveCommentWrapper$7;
import com.bytedance.ee.bear.drive.biz.comment.e1;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBottomPopupData;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.middleground.comment.export.bean.FocusInputBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.ScrollCommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyDataForInsert;
import com.bytedance.ee.bear.middleground.comment.export.bean.SyncReactionResultJsData;
import com.bytedance.ee.bear.middleground.permission.collaborator.askowner.AskOwnerModel$SendResult;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes18.dex */
public interface h {
    void A();

    void A0(Function1<? super Boolean, Unit> r100);

    int B();

    void C(boolean r100);

    void C0(Function2<? super String, ? super Map<String, ? extends Object>, Unit> r100);

    void D(Function1<? super Boolean, Unit> r100);

    void E(CommentInputRequest r100, ze5.c r101);

    void F(List<CommentBean> r100);

    i F0();

    void Fa(CardCommentHeight r100);

    void G(Function0<Unit> r100);

    void G0(tb5.m r100);

    void H0(Function1<? super String, Unit> r100);

    void J();

    CommentBean K(String r100);

    void K0(String r100, Integer r101);

    void L(Function1<? super String, Unit> r100);

    void L0(Function2<? super String, ? super Action, Unit> r100);

    void M(Function1<? super String, Boolean> r100);

    boolean O(boolean r100);

    void Q0(boolean r100, boolean r101);

    void Q6(String r100, Integer r101);

    void Qa(FocusInputBean r100);

    void R(Function1<? super String, Boolean> r100);

    void R0(SmartReplyDataForInsert r100);

    void S(CommentInputRequest r100);

    void T0(com.bytedance.ee.bear.middleground.comment.export.bean.a r100);

    void U(Function1<? super CommentInputRequest, Unit> r100);

    CommentBean V(String r100);

    void W0(Function1<? super String, Unit> r100);

    void X(Function1<? super String, Unit> r100);

    void X0(String r100, String r101, Boolean r102);

    void Y(Function2<? super CharSequence, ? super CommentInputRequest, Unit> r100);

    boolean Z0(Disposable r100);

    List<Function2<Integer, Boolean, Unit>> a();

    void a0(SyncReactionResultJsData r100);

    boolean a1();

    p b();

    void b1(Function4<? super String, ? super String, ? super Integer, ? super Integer, Unit> r100);

    List<Function2<Integer, Boolean, Unit>> c();

    void c1(Function1<? super String, Unit> r100);

    void d(List<CommentBean> r100);

    Function1<String, Unit> d1();

    void destroy(boolean r100);

    void detach();

    void e(String r100);

    void e1(Function0<Boolean> r100);

    List<Function4<String, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity>, Boolean, String, Unit>> f();

    void f0();

    void g(String r100, DriveCommentWrapper$7 r101);

    void g0(Function2<? super String, ? super String, Unit> r100);

    Function2<String, Action, Unit> getFilterData();

    void h();

    void h0(boolean r100);

    void h1(Function1<? super String, Unit> r100);

    void h5(Function0<Boolean> r100);

    boolean i();

    void i1(com.bytedance.ee.bear.middleground.comment.export.bean.a r100);

    void i8(String r100, String r101, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r102, int r103, CommentBean r104, CommentImageShowSource r105);

    void j(List<String> r100);

    void j1(Function3<? super String, ? super CommentInputRequest, ? super Boolean, Unit> r100);

    void k(String r100, boolean r101, ArrayList<String> r102);

    Function1<String, Unit> l();

    void l0(boolean r100, boolean r101);

    void m(List r100, e1 r101);

    void m1(String r100);

    CommentStyle n0();

    void o(String r100);

    void o1(Function1<? super Boolean, Unit> r100);

    j p0();

    Function1<ScrollCommentBean, Unit> q();

    void q0(Function1<? super Boolean, Unit> r100);

    Flowable<String> r();

    void r0(Function0<Unit> r100);

    void r1(Function3<? super String, ? super String, ? super MentionUserState, Boolean> r100);

    void s(sbb.e r100);

    void t(Function1<? super Integer, Unit> r100);

    void t0(Function1<? super Boolean, Unit> r100);

    void t1(Function1<? super CommentInputRequest, Unit> r100);

    void t2();

    void u(boolean r100);

    m u0();

    void u1(Function1<? super Boolean, Unit> r100);

    void v2();

    void v4();

    Flowable<AskOwnerModel$SendResult> w(List<String> r100);

    s w0();

    Function2<CommentBottomPopupData, bf5.b, Unit> x0();

    void y(Function1<? super Boolean, Unit> r100);

    void y0(Function1<? super Integer, Unit> r100);

    void z(Function4<? super String, ? super Integer, ? super String, ? super Integer, Unit> r100);
}
