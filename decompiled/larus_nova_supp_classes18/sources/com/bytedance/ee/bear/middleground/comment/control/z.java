package com.bytedance.ee.bear.middleground.comment.control;

import android.graphics.Matrix;
import android.view.View;
import com.bytedance.ee.bear.middleground.comment.Comment$inputCommentFunction$1;
import com.bytedance.ee.bear.middleground.comment.export.CommentImageShowSource;
import com.bytedance.ee.bear.middleground.comment.export.MentionUserState;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.ss.android.lark.vfs.VFSPath;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface z {
    Function0<Unit> B0();

    Function1<Boolean, Unit> D0();

    Function4<String, String, Integer, Integer, Unit> E0();

    Function3<String, CommentInputRequest, Boolean, Unit> H();

    Function1<CommentInputRequest, Unit> I();

    void I0();

    Function1<String, Unit> J0();

    Function0<Pair<String, String>> N();

    Function1<String, Unit> N0();

    Function6<String, Integer, String, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity>, Integer, CommentBean, Unit> O0();

    Function0<Unit> P();

    Function3<String, String, MentionUserState, Boolean> P0();

    void Q(CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r1, VFSPath r2, String r3, String r4, CommentBean r5, CommentImageShowSource r6);

    Comment$inputCommentFunction$1 T();

    Function1<CommentInputRequest, Unit> U0();

    Function2<String, Map<String, ? extends Object>, Unit> V0();

    Function1<Integer, Unit> W();

    Function1<List<String>, Unit> Y0();

    Function1<Boolean, Unit> Z();

    List<Function2<Integer, Boolean, Unit>> a();

    Function1<String, Unit> b0();

    List<Function2<Integer, Boolean, Unit>> c();

    Function3<String, float[], Matrix, Unit> c0();

    Function1<View, Unit> d0();

    Function2<String, String, Unit> e0();

    List<Function4<String, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity>, Boolean, String, Unit>> f();

    Function1<String, Unit> f1();

    Function4<String, Integer, String, Integer, Unit> g1();

    Function1<bo4.a, Unit> i0();

    Function0<Boolean> j0();

    Function0<Unit> k0();

    Function1<Boolean, Unit> k1();

    Function1<String, Unit> l();

    Function1<String, Unit> l1();

    Function1<String, Unit> m0();

    Function1<Boolean, Unit> n();

    Function1<Boolean, Unit> n1();

    Function0<Unit> o0();

    Function2<String, String, Unit> p();

    Function1<Integer, Unit> p1();

    Function1<Integer, Unit> q1();

    Function1<String, Unit> s0();

    sa5.b s1();

    Function2<CharSequence, CommentInputRequest, Unit> v();

    Function1<String, Boolean> v0();

    Function1<String, Boolean> x();

    Function1<Boolean, Unit> z0();
}
