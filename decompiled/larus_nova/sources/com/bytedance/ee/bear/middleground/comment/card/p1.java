package com.bytedance.ee.bear.middleground.comment.card;

import android.view.View;
import com.bytedance.ee.bear.middleground.comment.export.CardCommentHeight;
import com.bytedance.ee.bear.middleground.comment.export.CommentImageShowSource;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.FocusInputBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.ScrollCommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyDataForInsert;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes18.dex */
public interface p1 {
    void E7(String r100);

    void Fa(CardCommentHeight r100);

    void Hg();

    void IX();

    void LM();

    void Ni(boolean r100);

    void Q6(String r100, Integer r101);

    void Qa(FocusInputBean r100);

    void RL(com.bytedance.ee.bear.middleground.comment.export.bean.a r100);

    String UT();

    void XC(String r100, String r101, String r102, String r103);

    void bG(String r100, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r101, SmartReplyDataForInsert r102);

    void eX(com.bytedance.ee.bear.middleground.comment.export.bean.a r100);

    void fj(String r100, Integer r101);

    View getRootView();

    void h5(Function0<Boolean> r100);

    void hc(ScrollCommentBean r100);

    void i8(String r100, String r101, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r102, int r103, CommentBean r104, CommentImageShowSource r105);

    boolean isShowing();

    void jN();

    q1 jV();

    void qN(boolean r100);

    void r20(View r100);

    void t2();

    void tI(String r100);

    void v2();

    void v4();

    boolean wB();

    d z7();
}
