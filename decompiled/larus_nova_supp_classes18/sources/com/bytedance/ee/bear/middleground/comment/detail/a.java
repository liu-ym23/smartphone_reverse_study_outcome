package com.bytedance.ee.bear.middleground.comment.detail;

import com.bytedance.ee.bear.middleground.comment.control.t;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.middleground.comment.export.bean.VisibilityBean;
import com.bytedance.ee.bear.middleground.comment.uitls.p;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends gn4.a {
    public p c;
    public boolean d;
    public String e;
    public final CommentBean f;

    public a() {
        this.e = "";
        CommentBean r0 = new CommentBean();
        r0.setComment_list(new ArrayList());
        this.f = r0;
    }

    public final void e(p r2, t r3, String r4, CommentBean r5) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "dataControl");
        Intrinsics.checkNotNullParameter(r4, "commentId");
        Intrinsics.checkNotNullParameter(r5, "commentBean");
        this.f.getComment_list().clear();
        this.f.getComment_list().addAll(r5.getComment_list());
        this.f.setExtra(r5.getExtra());
        this.c = r2;
        this.e = r4;
        Iterator<T> r6 = r5.getComment_list().iterator();
        int r7 = 0;
    L4:
        if (r6.hasNext() == false) goto L12;
        Object r8 = r6.next();
        int r9 = r7 + 1;
        if (r7 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        CommentBean.CommentDetail r10 = (CommentBean.CommentDetail) r8;
        if (r7 != 0) goto L11;
        this.d = r10.isEditStatus();
    L11:
        r7 = r9;
        goto L4
    }

    public final CommentInputRequest d(String r13, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r14, String r15, String r16, String r17, Integer r18) {
        Intrinsics.checkNotNullParameter(r13, "defaultText");
        CommentInputRequest r2 = new CommentInputRequest();
        p r3 = this.c;
        p r5 = null;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r3 = null;
    L5:
        long r6 = r3.o;
        int r4 = 1;
        if (r6 != 0) goto L8;
        boolean r7 = true;
    L9:
        r2.is_whole = r7;
        p r8 = this.c;
        if (r8 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r8 = null;
    L12:
        r2.doc_token = r8.i;
        p r9 = this.c;
        if (r9 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r9 = null;
    L15:
        r2.doc_url = r9.j;
        r2.content = r13;
        CommentBean.CommentDetail.ExtraEntity r1 = new CommentBean.CommentDetail.ExtraEntity();
        if (r14 != null) goto L18;
    L20:
        boolean r10 = false;
    L21:
        if (r10 == false) goto L23;
        r1.setImage_list(new ArrayList());
        r1.getImage_list().addAll(r14);
    L23:
        CommentBean.Extra r11 = this.f.getExtra();
        if (r11 == null) goto L26;
        r1.setVisibility(r11.getVisibility());
    L26:
        r2.extra = r1;
        CommentBean.Extra r12 = this.f.getExtra();
        if (r12 == null) goto L29;
        int r19 = r12.getVisibility();
    L30:
        r2.visibilityBean = new VisibilityBean(r19);
        r2.comment_id = this.e;
        if (r18 == null) goto L33;
    L55:
        String r20 = ((CommentBean.CommentDetail) ListProtector.get(this.f.getComment_list(), 0)).getReply_id();     // Catch: Exception -> L38
        Intrinsics.checkNotNull(r20);     // Catch: Exception -> L38
    L39:
        r2.reply_id = r20;
        r2.quote = r15;
        p r21 = this.c;
        if (r21 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r21 = null;
    L42:
        r2.show_insert_image = r21.E;
        p r22 = this.c;
        if (r22 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L46:
        r2.show_comment_image = r5.F;
        r2.parent_token = r16;
        r2.parent_type = r17;
        if (r18 == null) goto L50;
        r4 = r18.intValue();
    L53:
        r2.type = r4;
        return r2;
    L50:
        if (this.d == true) goto L53;
        r4 = 2;
        goto L53
    L45:
        r5 = r22;
    L38:
        r20 = "";
        goto L39
    L33:
        if (this.d == true) goto L55;
        r20 = null;
        goto L39
    L29:
        r19 = 0;
        goto L30
    L18:
        if ((!r14.isEmpty()) != true) goto L20;
        r10 = true;
        goto L21
    L8:
        r7 = false;
        goto L9
    }
}
