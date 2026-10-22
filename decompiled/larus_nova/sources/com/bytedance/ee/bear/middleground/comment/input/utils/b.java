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

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f232006a = 0;

    static {
    }

    public b() {
    }

    public static CommentInputRequest a(CommentBean r100, p r101, int r102, CommentBean.CommentDetail r110, String r111, Map r112, SmartReplyDataForInsert r113, String r114, int r115) {
        if ((r115 & 8) == 0) goto L6;
        r110 = null;
    L6:
        if ((r115 & 16) == 0) goto L9;
        r111 = null;
    L9:
        if ((r115 & 32) == 0) goto L12;
        r112 = null;
    L12:
        if ((r115 & 128) == 0) goto L15;
        r113 = null;
    L15:
        if ((r115 & 256) == 0) goto L17;
        r114 = null;
    L17:
        Intrinsics.checkNotNullParameter(r100, "commentBean");
        Intrinsics.checkNotNullParameter(r101, "config");
        CommentInputRequest r103 = new CommentInputRequest();
        r103.comment_id = r100.getComment_id();
        r103.setCommentType(r100.getCommentType());
        boolean r104 = true;
        if (r100.getIs_whole() != 1) goto L20;
        boolean r105 = true;
    L21:
        r103.is_whole = r105;
        r103.show_comment_image = r101.F;
        r103.show_insert_image = r101.E;
        r103.doc_url = r101.f232234j;
        r103.keyboard_pop = true;
        r103.show_voice = true;
        r103.type = r102;
        r103.quote = r100.getQuote();
        r103.setCommentType(r100.getCommentType());
        if (r110 == null) goto L35;
        r103.reply_id = r110.getReply_id();
        r103.local_comment_id = r110.getReplyUUID();
        CommentBean.CommentDetail.ExtraEntity r106 = r110.getExtra();
        if (r106 == null) goto L30;
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r107 = r106.getImage_list();
        if (r107 == null) goto L30;
        if ((!r107.isEmpty()) != true) goto L30;
        boolean r108 = true;
    L31:
        if (r108 == false) goto L33;
        CommentBean.CommentDetail.ExtraEntity r109 = new CommentBean.CommentDetail.ExtraEntity();
        r109.setImage_list(new ArrayList());
        r109.getImage_list().addAll(r110.getExtra().getImage_list());
    L34:
        r103.extra = r109;
        goto L35
    L33:
        r109 = null;
    L30:
        r108 = false;
    L35:
        r103.canUseBlankContent = true;
        r103.directional_reply_id = null;
        if (r111 != null) goto L40;
        if (r110 == null) goto L39;
        r111 = r110.getContent();
        goto L40
    L39:
        r111 = null;
    L40:
        r103.content = r111;
        r103.bizParams = r112;
        CommentBean.Extra r116 = r100.getExtra();
        if (r116 == null) goto L43;
        int r117 = r116.getVisibility();
    L44:
        r103.visibilityBean = new VisibilityBean(r117);
        r103.smartReplyDataForInsert = r113;
        if (r103.isEdit() == false) goto L75;
        Intrinsics.checkNotNullParameter(r100, "commentBean");
        Intrinsics.checkNotNullParameter(r101, "config");
        if (r110 == null) goto L72;
        com.bytedance.ee.bear.appsetting.c r118 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        boolean r119 = r118.h("ccm.doc.image_region_comment_add");
        boolean r120 = r118.h("ccm.doc.sent_image_comment_region_add");
        if (r119 == false) goto L72;
        if (r120 == false) goto L72;
        if (r101.f232235k.f541317b != sbb.e.f541304o.f541317b) goto L72;
        if (r110.isFirstReply() == false) goto L72;
        CommentBean.Extra r121 = r100.getExtra();
        if (r121 != null) goto L59;
    L61:
        boolean r122 = false;
    L62:
        if (r122 == false) goto L72;
        String r123 = r100.getUserId();
        Intrinsics.checkNotNullParameter(r101, "config");
        r101.f232232h.getClass();
        if (TextUtils.equals(r123, com.bytedance.ee.bear.middleground.comment.p.a()) == true) goto L69;
        r101.f232232h.getClass();
        if (TextUtils.equals(r123, null) == true) goto L69;
        boolean r124 = false;
    L70:
        if (r124 == false) goto L72;
    L73:
        r103.isShowAreaSelectBtn = r104;
    L69:
        r124 = true;
        goto L70
    L59:
        if (r121.getSource() != 3) goto L61;
        r122 = true;
    L72:
        r104 = false;
    L75:
        if (TextUtils.isEmpty(r114) == true) goto L77;
        r103.from = r114;
    L77:
        return r103;
    L43:
        r117 = 0;
        goto L44
    L20:
        r105 = false;
        goto L21
    }
}
