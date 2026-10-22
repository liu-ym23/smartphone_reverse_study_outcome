package com.bytedance.ee.bear.middleground.comment.bitablediscuss;

import android.view.View;
import com.bytedance.ee.bear.middleground.comment.Comment;
import com.bytedance.ee.bear.middleground.comment.card.o1;
import com.bytedance.ee.bear.middleground.comment.card.p1;
import com.bytedance.ee.bear.middleground.comment.card.q1;
import com.bytedance.ee.bear.middleground.comment.control.t;
import com.bytedance.ee.bear.middleground.comment.control.y;
import com.bytedance.ee.bear.middleground.comment.control.z;
import com.bytedance.ee.bear.middleground.comment.export.CardCommentHeight;
import com.bytedance.ee.bear.middleground.comment.export.CommentImageShowSource;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.FocusInputBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.ScrollCommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyDataForInsert;
import com.bytedance.ee.bear.middleground.comment.uitls.p;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements p1, i {
    public final p a;
    public final z b;
    public final t c;
    public final y d;
    public BitableDiscussPanel e;

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void Fa(CardCommentHeight r2) {
        Intrinsics.checkNotNullParameter(r2, "height");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final /* synthetic */ void Hg() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void IX() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void LM() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void Qa(FocusInputBean r2) {
        Intrinsics.checkNotNullParameter(r2, "focusInputBean");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void RL(com.bytedance.ee.bear.middleground.comment.export.bean.a r1) {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final String UT() {
        return "";
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final /* synthetic */ void XC(String r1, String r2, String r3, String r4) {
        o1.a(r1, r2, r3, r4);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void bG(String r1, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r2, SmartReplyDataForInsert r3) {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void eX(com.bytedance.ee.bear.middleground.comment.export.bean.a r1) {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final /* synthetic */ void h5(Function0 r1) {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final /* synthetic */ void jN() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final q1 jV() {
        return null;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final /* synthetic */ void t2() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final /* synthetic */ void tI(String r1) {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final /* synthetic */ void v2() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final /* synthetic */ boolean wB() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final View getRootView() {
        BitableDiscussPanel r0 = this.e;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRootView();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final boolean isShowing() {
        BitableDiscussPanel r0 = this.e;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.x != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void v4() {
        BitableDiscussPanel r0 = this.e;
        if (r0 == null) goto L6;
        r0.v4();
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final com.bytedance.ee.bear.middleground.comment.card.d z7() {
        BitableDiscussPanel r0 = this.e;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.ha0();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void E7(String r2) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        BitableDiscussPanel r0 = this.e;
        if (r0 == null) goto L6;
        r0.E7(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void Ni(boolean r2) {
        BitableDiscussPanel r0 = this.e;
        if (r0 == null) goto L6;
        r0.Ni(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void hc(ScrollCommentBean r2) {
        Intrinsics.checkNotNullParameter(r2, "scrollCommentBean");
        BitableDiscussPanel r0 = this.e;
        if (r0 == null) goto L6;
        r0.hc(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void qN(boolean r3) {
        BitableDiscussPanel r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.x == false) goto L9;
        r0.qN(r3);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void r20(View r3) {
        Intrinsics.checkNotNullParameter(r3, "itemView");
        BitableDiscussPanel r1 = this.e;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.x == false) goto L9;
        Intrinsics.checkNotNullParameter(r3, "itemView");
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.bitablediscuss.i
    public final void zT(int r4) {
        BitableDiscussPanel r0 = this.e;
        if (r0 == null) goto L7;
        boolean r2 = true;
        if (r0.x != true) goto L7;
    L8:
        if (r2 == false) goto L12;
        if (r0 == null) goto L13;
        r0.zT(r4);
        return;
    L13:
        return;
    L12:
        return;
    L7:
        r2 = false;
        goto L8
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void Q6(String r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r3, "commentId");
        BitableDiscussPanel r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.x == false) goto L9;
        r0.Q6(r3, r4);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void fj(String r6, Integer r7) {
        Intrinsics.checkNotNullParameter(r6, "targetId");
        BitableDiscussPanel r0 = this.e;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L10;
        return;
    L10:
        if (r0 != null) goto L12;
    L14:
        r1 = false;
    L15:
        if (r1 == false) goto L19;
        if (r0 == null) goto L21;
        r0.Q6(r6, r7);
        return;
    L21:
        return;
    L19:
        this.e = null;
        BitableDiscussPanel r8 = new BitableDiscussPanel(this.a, this.b, this.c, this.d);
        this.e = r8;
        r8.fj(r6, 0);
        return;
    L12:
        if (r0.x != true) goto L14;
    L5:
        if (r0.y != true) goto L7;
        r3 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.middleground.comment.bitablediscuss.i
    public final void mq(String r5, String r6) {
        BitableDiscussPanel r0 = this.e;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L11;
        if (r0 == null) goto L12;
        r0.F = r5;
        r0.G = r6;
        return;
    L12:
        return;
    L11:
        return;
    L5:
        if (r0.x != true) goto L7;
        r1 = true;
        goto L7
    }

    @Override // com.bytedance.ee.bear.middleground.comment.bitablediscuss.i
    public final void H50(String r5, String r6, int r7) {
        BitableDiscussPanel r0 = this.e;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L11;
        if (r0 == null) goto L12;
        r0.H50(r5, r6, r7);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        if (r0.x != true) goto L7;
        r1 = true;
        goto L7
    }

    public g(p r2, Comment r3, t r4, y r5) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "commentListeners");
        Intrinsics.checkNotNullParameter(r4, "dataControl");
        Intrinsics.checkNotNullParameter(r5, "actionControl");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void i8(String r9, String r10, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r11, int r12, CommentBean r13, CommentImageShowSource r14) {
        Intrinsics.checkNotNullParameter(r9, "commentId");
        Intrinsics.checkNotNullParameter(r10, "replyId");
        Intrinsics.checkNotNullParameter(r14, "showSource");
        BitableDiscussPanel r1 = this.e;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.x == false) goto L9;
        r1.i8(r9, r10, r11, r12, r13, r14);
        return;
    }
}
