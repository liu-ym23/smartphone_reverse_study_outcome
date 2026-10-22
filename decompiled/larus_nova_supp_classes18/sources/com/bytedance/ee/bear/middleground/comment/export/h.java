package com.bytedance.ee.bear.middleground.comment.export;

import com.bytedance.ee.bear.drive.biz.comment.DriveCommentWrapper;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface h {
    void A();

    void A0(Function1<? super Boolean, Unit> r1);

    int B();

    void C(boolean r1);

    void C0(Function2<? super String, ? super Map<String, ? extends Object>, Unit> r1);

    void D(Function1<? super Boolean, Unit> r1);

    void E(CommentInputRequest r1, ze5.c r2);

    void F(List<CommentBean> r1);

    i F0();

    void Fa(CardCommentHeight r1);

    void G(Function0<Unit> r1);

    void G0(tb5.m r1);

    void H0(Function1<? super String, Unit> r1);

    void J();

    CommentBean K(String r1);

    void K0(String r1, Integer r2);

    void L(Function1<? super String, Unit> r1);

    void L0(Function2<? super String, ? super Action, Unit> r1);

    void M(Function1<? super String, Boolean> r1);

    boolean O(boolean r1);

    void Q0(boolean r1, boolean r2);

    void Q6(String r1, Integer r2);

    void Qa(FocusInputBean r1);

    void R(Function1<? super String, Boolean> r1);

    void R0(SmartReplyDataForInsert r1);

    void S(CommentInputRequest r1);

    void T0(com.bytedance.ee.bear.middleground.comment.export.bean.a r1);

    void U(Function1<? super CommentInputRequest, Unit> r1);

    CommentBean V(String r1);

    void W0(Function1<? super String, Unit> r1);

    void X(Function1<? super String, Unit> r1);

    void X0(String r1, String r2, Boolean r3);

    void Y(Function2<? super CharSequence, ? super CommentInputRequest, Unit> r1);

    boolean Z0(Disposable r1);

    List<Function2<Integer, Boolean, Unit>> a();

    void a0(SyncReactionResultJsData r1);

    boolean a1();

    p b();

    void b1(Function4<? super String, ? super String, ? super Integer, ? super Integer, Unit> r1);

    List<Function2<Integer, Boolean, Unit>> c();

    void c1(Function1<? super String, Unit> r1);

    void d(List<CommentBean> r1);

    Function1<String, Unit> d1();

    void destroy(boolean r1);

    void detach();

    void e(String r1);

    void e1(Function0<Boolean> r1);

    List<Function4<String, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity>, Boolean, String, Unit>> f();

    void f0();

    void g(String r1, DriveCommentWrapper.7 r2);

    void g0(Function2<? super String, ? super String, Unit> r1);

    Function2<String, Action, Unit> getFilterData();

    void h();

    void h0(boolean r1);

    void h1(Function1<? super String, Unit> r1);

    void h5(Function0<Boolean> r1);

    boolean i();

    void i1(com.bytedance.ee.bear.middleground.comment.export.bean.a r1);

    void i8(String r1, String r2, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r3, int r4, CommentBean r5, CommentImageShowSource r6);

    void j(List<String> r1);

    void j1(Function3<? super String, ? super CommentInputRequest, ? super Boolean, Unit> r1);

    void k(String r1, boolean r2, ArrayList<String> r3);

    Function1<String, Unit> l();

    void l0(boolean r1, boolean r2);

    void m(List r1, e1 r2);

    void m1(String r1);

    CommentStyle n0();

    void o(String r1);

    void o1(Function1<? super Boolean, Unit> r1);

    j p0();

    Function1<ScrollCommentBean, Unit> q();

    void q0(Function1<? super Boolean, Unit> r1);

    Flowable<String> r();

    void r0(Function0<Unit> r1);

    void r1(Function3<? super String, ? super String, ? super MentionUserState, Boolean> r1);

    void s(sbb.e r1);

    void t(Function1<? super Integer, Unit> r1);

    void t0(Function1<? super Boolean, Unit> r1);

    void t1(Function1<? super CommentInputRequest, Unit> r1);

    void t2();

    void u(boolean r1);

    m u0();

    void u1(Function1<? super Boolean, Unit> r1);

    void v2();

    void v4();

    Flowable<AskOwnerModel$SendResult> w(List<String> r1);

    s w0();

    Function2<CommentBottomPopupData, bf5.b, Unit> x0();

    void y(Function1<? super Boolean, Unit> r1);

    void y0(Function1<? super Integer, Unit> r1);

    void z(Function4<? super String, ? super Integer, ? super String, ? super Integer, Unit> r1);
}
