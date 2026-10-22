package com.bytedance.ee.bear.middleground.comment.export;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.ErrorBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.Reaction;
import com.bytedance.ee.util.ui.RecyclerItemsDiff;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements RecyclerItemsDiff.b<CommentBean.CommentDetail> {
    public final /* synthetic */ ICardAdapter a;
    public final /* synthetic */ i b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ String f;
    public final /* synthetic */ boolean g;
    public final /* synthetic */ boolean h;

    public final boolean areContentsTheSame(Object r12, Object r13) {
        CommentBean.CommentDetail r14 = (CommentBean.CommentDetail) r12;
        CommentBean.CommentDetail r15 = (CommentBean.CommentDetail) r13;
        int r0 = CommentDiffUtils.a;
        ICardAdapter r1 = this.a;
        i r2 = this.b;
        boolean r3 = this.c;
        boolean r4 = this.d;
        boolean r5 = this.e;
        String r6 = this.f;
        boolean r7 = this.g;
        boolean r8 = this.h;
        if (r3 == false) goto L6;
        return false;
    L6:
        if (r15 != null) goto L8;
    L10:
        boolean r9 = false;
    L11:
        List<Reaction> r10 = null;
        if (r9 == false) goto L29;
        if (r4 == false) goto L81;
        if (r5 == false) goto L82;
        if (r7 == true) goto L83;
        if (r14 == null) goto L20;
        ErrorBean r11 = r14.getError();
        if (r11 == null) goto L20;
        Integer r16 = Integer.valueOf(r11.code);
    L21:
        if (r15 == null) goto L25;
        ErrorBean r17 = r15.getError();
        if (r17 == null) goto L25;
        Integer r18 = Integer.valueOf(r17.code);
    L27:
        if (Intrinsics.areEqual(r16, r18) == true) goto L29;
        return false;
    L25:
        r18 = null;
    L20:
        r16 = null;
        goto L21
    L83:
        return false;
    L82:
        return false;
    L81:
        return false;
    L29:
        if (r8 == true) goto L32;
        return false;
    L32:
        if (CommentDiffUtils.c(r1, r15) == true) goto L91;
        w r19 = r1.getUiState();
        if (r19 != null) goto L37;
    L39:
        boolean r20 = false;
    L40:
        if (r20 == true) goto L48;
        if (r15 != null) goto L43;
    L45:
        boolean r21 = false;
    L46:
        if (r21 == false) goto L48;
        return false;
    L43:
        if (r15.getCommentType() != 2) goto L45;
        r21 = true;
    L48:
        w r22 = r1.getUiState();
        if (r22 != null) goto L51;
    L53:
        boolean r23 = false;
    L54:
        if (r23 == false) goto L84;
        w r24 = r1.getUiState();
        if (r24 != null) goto L58;
    L60:
        boolean r25 = false;
    L61:
        if (r25 == false) goto L93;
        if (r14 == null) goto L65;
        boolean r110 = r14.equals(r15);
    L66:
        if (r110 == false) goto L85;
        if (r15 == null) goto L71;
        String r111 = r15.getReply_id();
        if (r111 == null) goto L71;
        boolean r112 = r111.equals(r6);
    L72:
        if (r112 == true) goto L86;
        if (r15 == null) goto L75;
        List<Reaction> r113 = r15.getOriginalReaction();
    L76:
        if (r15 == null) goto L78;
        r10 = r15.getReaction();
    L78:
        if (r113 != r10) goto L87;
        return true;
    L87:
        return false;
    L75:
        r113 = null;
        goto L76
    L86:
        return false;
    L71:
        r112 = false;
        goto L72
    L85:
        return false;
    L65:
        r110 = false;
        goto L66
    L93:
        return false;
    L58:
        if (r24.e != r2.c().a()) goto L60;
        r25 = true;
        goto L61
    L84:
        return false;
    L51:
        if (r22.d != r2.c().getComment()) goto L53;
        r23 = true;
        goto L54
    L37:
        if (r19.c != r2.c().f()) goto L39;
        r20 = true;
        goto L40
    L91:
        return false;
    L8:
        if (r15.getReplyType() != (-1)) goto L10;
        r9 = true;
        goto L11
    }

    public final boolean areItemsTheSame(Object r5, Object r6) {
        CommentBean.CommentDetail r7 = (CommentBean.CommentDetail) r5;
        CommentBean.CommentDetail r8 = (CommentBean.CommentDetail) r6;
        int r0 = CommentDiffUtils.a;
        String r1 = null;
        if (r7 == null) goto L10;
        String r2 = r7.getReply_id();
        if (r2 == null) goto L10;
        if (r8 == null) goto L8;
        String r3 = r8.getReply_id();
    L9:
        boolean r4 = r2.equals(r3);
    L11:
        if (r4 == true) goto L20;
        if (r7 == null) goto L18;
        String r9 = r7.getCompatibleReplyIdBeforeSend();
        if (r9 == null) goto L18;
        if (r8 == null) goto L17;
        r1 = r8.getCompatibleReplyIdBeforeSend();
    L17:
        boolean r10 = r9.equals(r1);
    L19:
        if (r10 == true) goto L20;
        return false;
    L18:
        r10 = false;
    L20:
        return true;
    L8:
        r3 = null;
    L10:
        r4 = false;
        goto L11
    }

    public c(CardAdapter2 r1, com.bytedance.ee.bear.middleground.comment.uitls.p r2, boolean r3, boolean r4, boolean r5, String r6, boolean r7, boolean r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }
}
