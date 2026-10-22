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

/* JADX INFO: loaded from: classes18.dex */
public final class a extends gn4.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public p f231257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f231258d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f231259e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CommentBean f231260f;

    public a() {
        this.f231259e = "";
        CommentBean r100 = new CommentBean();
        r100.setComment_list(new ArrayList());
        this.f231260f = r100;
    }

    public final void e(p r100, t r101, String r102, CommentBean r103) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "dataControl");
        Intrinsics.checkNotNullParameter(r102, "commentId");
        Intrinsics.checkNotNullParameter(r103, "commentBean");
        this.f231260f.getComment_list().clear();
        this.f231260f.getComment_list().addAll(r103.getComment_list());
        this.f231260f.setExtra(r103.getExtra());
        this.f231257c = r100;
        this.f231259e = r102;
        Iterator<T> r104 = r103.getComment_list().iterator();
        int r105 = 0;
    L4:
        if (r104.hasNext() == false) goto L12;
        Object r106 = r104.next();
        int r107 = r105 + 1;
        if (r105 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        CommentBean.CommentDetail r108 = (CommentBean.CommentDetail) r106;
        if (r105 != 0) goto L11;
        this.f231258d = r108.isEditStatus();
    L11:
        r105 = r107;
        goto L4
    }

    public final CommentInputRequest d(String r110, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r111, String r112, String r113, String r114, Integer r115) {
        Intrinsics.checkNotNullParameter(r110, "defaultText");
        CommentInputRequest r100 = new CommentInputRequest();
        p r101 = this.f231257c;
        p r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r101 = null;
    L5:
        long r103 = r101.f232239o;
        int r104 = 1;
        if (r103 != 0) goto L8;
        boolean r105 = true;
    L9:
        r100.is_whole = r105;
        p r106 = this.f231257c;
        if (r106 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r106 = null;
    L12:
        r100.doc_token = r106.f232233i;
        p r107 = this.f231257c;
        if (r107 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r107 = null;
    L15:
        r100.doc_url = r107.f232234j;
        r100.content = r110;
        CommentBean.CommentDetail.ExtraEntity r108 = new CommentBean.CommentDetail.ExtraEntity();
        if (r111 != null) goto L18;
    L20:
        boolean r109 = false;
    L21:
        if (r109 == false) goto L23;
        r108.setImage_list(new ArrayList());
        r108.getImage_list().addAll(r111);
    L23:
        CommentBean.Extra r116 = this.f231260f.getExtra();
        if (r116 == null) goto L26;
        r108.setVisibility(r116.getVisibility());
    L26:
        r100.extra = r108;
        CommentBean.Extra r117 = this.f231260f.getExtra();
        if (r117 == null) goto L29;
        int r118 = r117.getVisibility();
    L30:
        r100.visibilityBean = new VisibilityBean(r118);
        r100.comment_id = this.f231259e;
        if (r115 == null) goto L33;
    L55:
        String r119 = ((CommentBean.CommentDetail) ListProtector.get(this.f231260f.getComment_list(), 0)).getReply_id();     // Catch: Exception -> L38
        Intrinsics.checkNotNull(r119);     // Catch: Exception -> L38
    L39:
        r100.reply_id = r119;
        r100.quote = r112;
        p r120 = this.f231257c;
        if (r120 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r120 = null;
    L42:
        r100.show_insert_image = r120.E;
        p r121 = this.f231257c;
        if (r121 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L46:
        r100.show_comment_image = r102.F;
        r100.parent_token = r113;
        r100.parent_type = r114;
        if (r115 == null) goto L50;
        r104 = r115.intValue();
    L53:
        r100.type = r104;
        return r100;
    L50:
        if (this.f231258d == true) goto L53;
        r104 = 2;
        goto L53
    L45:
        r102 = r121;
    L38:
        r119 = "";
        goto L39
    L33:
        if (this.f231258d == true) goto L55;
        r119 = null;
        goto L39
    L29:
        r118 = 0;
        goto L30
    L18:
        if ((!r111.isEmpty()) != true) goto L20;
        r109 = true;
        goto L21
    L8:
        r105 = false;
        goto L9
    }
}
