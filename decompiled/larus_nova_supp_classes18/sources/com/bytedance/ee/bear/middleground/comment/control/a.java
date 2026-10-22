package com.bytedance.ee.bear.middleground.comment.control;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.middleground.comment.export.CommentDiffUtils;
import com.bytedance.ee.bear.middleground.comment.export.ICardAdapter;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.middleground.comment.export.bean.VisibilityBean;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class a extends CommentFunction {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.control.a$a, reason: collision with other inner class name */
    public static final class C0060a extends c0 {
        public final /* synthetic */ ICardAdapter c;
        public final /* synthetic */ CommentBean.CommentDetail d;
        public final /* synthetic */ String e;
        public final /* synthetic */ a f;
        public final /* synthetic */ int g;

        @Override // com.bytedance.ee.bear.middleground.comment.control.c0
        public final void a(View r15) {
            Intrinsics.checkNotNullParameter(r15, "view");
            super.a(r15);
            com.bytedance.ee.bear.middleground.comment.uitls.h r16 = this.a.d0;
            String r0 = this.c.getCommentId(this.d);
            String r1 = this.e;
            Pair[] r2 = new Pair[2];
            if (this.a.V == false) goto L5;
            String r3 = "discussion";
        L6:
            r2[0] = TuplesKt.to(ResourceData.KEY_TYPE, r3);
            CommentBean.Extra r4 = this.c.getData().getExtra();
            if (r4 == null) goto L9;
            String r5 = r4.getReportVisibility();
        L10:
            r2[1] = TuplesKt.to("comment_visible_range", r5);
            r16.g("edit_click", r0, r1, MapsKt.mapOf(r2));
            a r6 = this.f;
            CommentBean.CommentDetail r7 = this.d;
            RecyclerView.Adapter r8 = this.c;
            String r17 = this.e;
            int r9 = this.g;
            Map<Object, Object> r13 = r8.getBizParam();
            r6.getClass();
            Intrinsics.checkNotNullParameter(r7, "commentDetail");
            Intrinsics.checkNotNullParameter(r8, "cardAdapter");
            Intrinsics.checkNotNullParameter(r17, "replyId");
            Iterator<T> r18 = r8.getCommentDetails().iterator();
        L12:
            if (r18.hasNext() == false) goto L15;
            ((CommentBean.CommentDetail) r18.next()).setEditStatus(false);
            goto L12
        L15:
            if (r7.isWholeComment() == false) goto L17;
            r8.notifyItemChanged(r9);
        L18:
            r8.getData();
            r6.S(r7, r8, "", r7.isWholeComment(), 1, "", "", r13);
            return;
        L17:
            int r19 = CommentDiffUtils.a;
            CommentDiffUtils.b(r8, Integer.valueOf(r9));
            goto L18
        L9:
            r5 = null;
            goto L10
        L5:
            r3 = "comment";
            goto L6
        }

        public C0060a(ICardAdapter r1, CommentBean.CommentDetail r2, String r3, a r4, int r5, com.bytedance.ee.bear.middleground.comment.uitls.p r6) {
            this.c = r1;
            this.d = r2;
            this.e = r3;
            this.f = r4;
            this.g = r5;
            super(r6, "EDIT");
        }
    }

    public a(com.bytedance.ee.bear.middleground.comment.uitls.p r2, z r3, t r4) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "commentListeners");
        Intrinsics.checkNotNullParameter(r4, "dataControl");
        super(r2, r3, r4);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.CommentFunction
    public final void K(ICardAdapter r12, int r13, List<com.ss.android.lark.reaction.widget.panel.e> r14) {
        Intrinsics.checkNotNullParameter(r12, "cardAdapter");
        Intrinsics.checkNotNullParameter(r14, "menuList");
        CommentBean.CommentDetail r3 = (CommentBean.CommentDetail) ListProtector.get(r12.getCommentDetails(), r13);
        String r4 = r12.findReplyIdByPosition(r13);
        r14.add(new com.ss.android.lark.reaction.widget.panel.e(eu5.b.a.getString(2131887749), com.bytedance.ee.bear.middleground.comment.uitls.s.a("EDIT"), new C0060a(r12, r3, r4, this, r13, this.a)));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.CommentFunction, com.bytedance.ee.bear.middleground.comment.control.y
    public final void j(CommentBean.CommentDetail r10, ICardAdapter r11, String r12, int r13, String r14, String r15, Map<Object, ? extends Object> r16) {
        Intrinsics.checkNotNullParameter(r10, "commentDetail");
        Intrinsics.checkNotNullParameter(r11, "cardAdapter");
        ((RecyclerView.Adapter) r11).notifyDataSetChanged();
        r11.getData();
        S(r10, r11, r12, false, r13, r14, r15, r16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.util.ArrayList] */
    public final void S(CommentBean.CommentDetail r4, ICardAdapter r5, String r6, boolean r7, int r8, String r9, String r10, Map r11) {
        r4.setEditStatus(true);
        CommentInputRequest r1 = new CommentInputRequest();
        r1.comment_id = r5.getCommentId(r4);
        r1.type = r8;
        r1.setCommentType(r5.getData().getCommentType());
        r1.reply_id = r4.getReply_id();
        r1.local_comment_id = r4.getReplyUUID();
        r1.content = r4.getContent();
        r1.is_whole = r7;
        r1.show_voice = true;
        r1.parent_token = r10;
        r1.parent_type = r9;
        r1.quote = r6;
        com.bytedance.ee.bear.middleground.comment.uitls.p r12 = this.a;
        r1.show_insert_image = r12.E;
        r1.show_comment_image = r12.F;
        r1.doc_url = r12.j;
        r1.bizParams = r11;
        r1.isShowAreaSelectBtn = N(r5, r4);
        CommentBean.CommentDetail.ExtraEntity r13 = r4.getExtra();
        CommentBean.CommentDetail.ExtraEntity r14 = null;
        if (r13 == null) goto L15;
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r15 = r13.getImage_list();
        if (r15 == null) goto L15;
        ?? r16 = new ArrayList();
        Iterator r17 = r15.iterator();
    L8:
        if (r17.hasNext() == false) goto L16;
        CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r18 = (CommentBean.CommentDetail.ExtraEntity.CommentImageEntity) r17.next();
        if (r18 == null) goto L12;
        CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r19 = r18.copy();
    L13:
        if (r19 == null) goto L8;
        r16.add(r19);
        goto L8
    L12:
        r19 = null;
    L16:
        Collection r20 = (Collection) r16;
        if ((!r20.isEmpty()) == false) goto L19;
        r14 = new CommentBean.CommentDetail.ExtraEntity();
        r14.setImage_list(new ArrayList(r20));
    L19:
        r1.extra = r14;
        r1.visibilityBean = new VisibilityBean(r5.getCommentVisibility(r4));
        this.b.T().a.invoke(r1);
        return;
    L15:
        r16 = CollectionsKt.emptyList();
        goto L16
    }
}
