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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface p1 {
    void E7(String r1);

    void Fa(CardCommentHeight r1);

    void Hg();

    void IX();

    void LM();

    void Ni(boolean r1);

    void Q6(String r1, Integer r2);

    void Qa(FocusInputBean r1);

    void RL(com.bytedance.ee.bear.middleground.comment.export.bean.a r1);

    String UT();

    void XC(String r1, String r2, String r3, String r4);

    void bG(String r1, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r2, SmartReplyDataForInsert r3);

    void eX(com.bytedance.ee.bear.middleground.comment.export.bean.a r1);

    void fj(String r1, Integer r2);

    View getRootView();

    void h5(Function0<Boolean> r1);

    void hc(ScrollCommentBean r1);

    void i8(String r1, String r2, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r3, int r4, CommentBean r5, CommentImageShowSource r6);

    boolean isShowing();

    void jN();

    q1 jV();

    void qN(boolean r1);

    void r20(View r1);

    void t2();

    void tI(String r1);

    void v2();

    void v4();

    boolean wB();

    d z7();
}
