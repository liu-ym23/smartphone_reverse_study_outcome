package com.bytedance.ee.bear.middleground.comment.input.utils;

import android.text.TextUtils;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyDataForInsert;
import com.bytedance.ee.bear.middleground.comment.export.bean.VisibilityBean;
import com.bytedance.ee.bear.middleground.comment.uitls.p;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public b() {
    }

    public static CommentInputRequest a(CommentBean r7, p r8, int r9, CommentBean.CommentDetail r10, String r11, Map r12, SmartReplyDataForInsert r13, String r14, int r15) {
        if ((r15 & 8) == 0) goto L6;
        r10 = null;
    L6:
        if ((r15 & 16) == 0) goto L9;
        r11 = null;
    L9:
        if ((r15 & 32) == 0) goto L12;
        r12 = null;
    L12:
        if ((r15 & 128) == 0) goto L15;
        r13 = null;
    L15:
        if ((r15 & 256) == 0) goto L17;
        r14 = null;
    L17:
        Intrinsics.checkNotNullParameter(r7, "commentBean");
        Intrinsics.checkNotNullParameter(r8, "config");
        CommentInputRequest r2 = new CommentInputRequest();
        r2.comment_id = r7.getComment_id();
        r2.setCommentType(r7.getCommentType());
        boolean r4 = true;
        if (r7.getIs_whole() != 1) goto L20;
        boolean r3 = true;
    L21:
        r2.is_whole = r3;
        r2.show_comment_image = r8.F;
        r2.show_insert_image = r8.E;
        r2.doc_url = r8.j;
        r2.keyboard_pop = true;
        r2.show_voice = true;
        r2.type = r9;
        r2.quote = r7.getQuote();
        r2.setCommentType(r7.getCommentType());
        if (r10 == null) goto L35;
        r2.reply_id = r10.getReply_id();
        r2.local_comment_id = r10.getReplyUUID();
        CommentBean.CommentDetail.ExtraEntity r16 = r10.getExtra();
        if (r16 == null) goto L30;
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r17 = r16.getImage_list();
        if (r17 == null) goto L30;
        if ((!r17.isEmpty()) != true) goto L30;
        boolean r18 = true;
    L31:
        if (r18 == false) goto L33;
        CommentBean.CommentDetail.ExtraEntity r19 = new CommentBean.CommentDetail.ExtraEntity();
        r19.setImage_list(new ArrayList());
        r19.getImage_list().addAll(r10.getExtra().getImage_list());
    L34:
        r2.extra = r19;
        goto L35
    L33:
        r19 = null;
    L30:
        r18 = false;
    L35:
        r2.canUseBlankContent = true;
        r2.directional_reply_id = null;
        if (r11 != null) goto L40;
        if (r10 == null) goto L39;
        r11 = r10.getContent();
        goto L40
    L39:
        r11 = null;
    L40:
        r2.content = r11;
        r2.bizParams = r12;
        CommentBean.Extra r110 = r7.getExtra();
        if (r110 == null) goto L43;
        int r111 = r110.getVisibility();
    L44:
        r2.visibilityBean = new VisibilityBean(r111);
        r2.smartReplyDataForInsert = r13;
        if (r2.isEdit() == false) goto L75;
        Intrinsics.checkNotNullParameter(r7, "commentBean");
        Intrinsics.checkNotNullParameter(r8, "config");
        if (r10 == null) goto L72;
        com.bytedance.ee.bear.appsetting.c r20 = com.bytedance.ee.bear.appsetting.c.a.a;
        boolean r112 = r20.h("ccm.doc.image_region_comment_add");
        boolean r21 = r20.h("ccm.doc.sent_image_comment_region_add");
        if (r112 == false) goto L72;
        if (r21 == false) goto L72;
        if (r8.k.b != sbb.e.o.b) goto L72;
        if (r10.isFirstReply() == false) goto L72;
        CommentBean.Extra r22 = r7.getExtra();
        if (r22 != null) goto L59;
    L61:
        boolean r23 = false;
    L62:
        if (r23 == false) goto L72;
        String r24 = r7.getUserId();
        Intrinsics.checkNotNullParameter(r8, "config");
        r8.h.getClass();
        if (TextUtils.equals(r24, com.bytedance.ee.bear.middleground.comment.p.a()) == true) goto L69;
        r8.h.getClass();
        if (TextUtils.equals(r24, null) == true) goto L69;
        boolean r25 = false;
    L70:
        if (r25 == false) goto L72;
    L73:
        r2.isShowAreaSelectBtn = r4;
    L69:
        r25 = true;
        goto L70
    L59:
        if (r22.getSource() != 3) goto L61;
        r23 = true;
    L72:
        r4 = false;
    L75:
        if (TextUtils.isEmpty(r14) == true) goto L77;
        r2.from = r14;
    L77:
        return r2;
    L43:
        r111 = 0;
        goto L44
    L20:
        r3 = false;
        goto L21
    }
}
