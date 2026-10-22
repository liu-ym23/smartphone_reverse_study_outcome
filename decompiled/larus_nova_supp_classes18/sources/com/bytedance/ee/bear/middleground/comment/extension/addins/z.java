package com.bytedance.ee.bear.middleground.comment.extension.addins;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.document.comment.CommentPlugin;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class z implements CommonRecyclerView.b {
    public final /* synthetic */ af5.b a;
    public final /* synthetic */ x b;
    public final /* synthetic */ ef5.z c;

    public final void a(double r11) {
        if (this.a.a() != null) goto L5;
        return;
    L5:
        CommentPlugin.g r0 = this.b.getContext().getConfig().R;
        int r1 = 1;
        if (r0 != null) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == true) goto L13;
    L15:
        RecyclerView.Adapter r2 = this.c.a.getAdapter();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2");
        int r4 = ((CardAdapter2) r2).getCardPos();
        com.bytedance.ee.bear.middleground.comment.card.d r5 = this.b.getContext().z7();
        Integer r6 = null;
        if (r5 == null) goto L18;
        CommentBean r7 = r5.e(Integer.valueOf(r4));
    L19:
        if (r7 == null) goto L21;
        r6 = Integer.valueOf(r7.getCommentType());
    L21:
        if (r6 != null) goto L24;
    L26:
        if (r6 != null) goto L29;
    L47:
        r1 = 0;
    L48:
        int r8 = r1;
        int r9 = 0;
    L49:
        com.bytedance.ee.bear.middleground.comment.performance.c r10 = this.a.a();
        if (r10 == null) goto L60;
        x r12 = this.b;
        float r13 = r12.d;
        com.bytedance.ee.bear.middleground.comment.card.d r14 = r12.getContext().z7();
        if (r14 == null) goto L54;
        String r15 = r14.f(Integer.valueOf(r4));
    L55:
        r10.a(r11, r13, r15, r8, r9);
        return;
    L54:
        r15 = "";
        goto L55
    L60:
        return;
    L29:
        if (r6.intValue() != 0) goto L47;
        Iterator<T> r16 = r7.getComment_list().iterator();
        int r17 = 0;
    L32:
        if (r16.hasNext() == false) goto L41;
        CommentBean.CommentDetail.ExtraEntity r18 = ((CommentBean.CommentDetail) r16.next()).getExtra();
        if (r18 == null) goto L38;
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r19 = r18.getImage_list();
        if (r19 == null) goto L38;
        int r20 = r19.size();
    L39:
        r17 = r17 + r20;
    L38:
        r20 = 0;
        goto L39
    L41:
        if (r7.getComment_list().size() > 3) goto L43;
    L45:
        int r21 = r7.getComment_list().size();
    L46:
        r8 = r21;
        r9 = r17;
        goto L49
    L43:
        if (((CommentBean.CommentDetail) ListProtector.get(r7.getComment_list(), 0)).getReplyType() != (-2)) goto L45;
        r21 = r7.getComment_list().size() - 3;
        goto L46
    L24:
        if (r6.intValue() != 1) goto L26;
    L18:
        r7 = null;
        goto L19
    L13:
        if (r0.a() == false) goto L15;
        return;
    L8:
        if (r0.c() != true) goto L10;
        r3 = true;
        goto L11
    }

    public z(af5.b r1, x r2, ef5.z r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
