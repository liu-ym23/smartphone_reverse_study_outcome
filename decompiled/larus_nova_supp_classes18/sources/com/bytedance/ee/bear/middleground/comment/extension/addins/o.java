package com.bytedance.ee.bear.middleground.comment.extension.addins;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.middleground.comment.adapter.BaseContentViewHolder;
import com.bytedance.ee.bear.middleground.comment.export.ICardAdapter;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o implements View.OnClickListener {
    public final /* synthetic */ CommentBean.CommentDetail a;
    public final /* synthetic */ RecyclerView b;
    public final /* synthetic */ BaseContentViewHolder c;
    public final /* synthetic */ CardAdapterAddin d;

    public o(CommentBean.CommentDetail r1, RecyclerView r2, BaseContentViewHolder r3, CardAdapterAddin r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        String r0 = "";
        ICardAdapter r1 = null;
        String r2 = null;
        r2 = null;
        r2 = null;
        if (this.a.getTranslate_status() != null) goto L5;
    L47:
        this.a.setTranslate_status("loading");
        RecyclerView r8 = this.b;
        if (r8 == null) goto L52;
        RecyclerView.Adapter r9 = r8.getAdapter();
        if (r9 == null) goto L52;
        int r3 = this.c.getLayoutPosition();
        Map<String, Boolean> r4 = nf5.a.a;
        r9.notifyItemChanged(r3, nf5.a.b);
    L52:
        com.bytedance.ee.bear.middleground.comment.control.y r10 = this.d.c;
        if (r10 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("actionControl");
        r10 = null;
    L55:
        RecyclerView r5 = this.b;
        if (r5 == null) goto L58;
        RecyclerView.Adapter r6 = r5.getAdapter();
    L60:
        if ((r6 instanceof ICardAdapter) == false) goto L62;
        r1 = (ICardAdapter) r6;
    L62:
        if (r1 == null) goto L67;
        String r11 = r1.getCommentId(this.a);
        if (r11 == null) goto L67;
        r0 = r11;
    L67:
        r10.a(r0, this.a.getCommentType(), this.a.getReply_id());
        return;
    L58:
        r6 = null;
        goto L60
    L5:
        if (Intrinsics.areEqual(this.a.getTranslate_status(), "default") == true) goto L47;
        if (Intrinsics.areEqual(this.a.getTranslate_status(), "success") == false) goto L10;
    L11:
        com.bytedance.ee.bear.middleground.comment.uitls.h r12 = this.d.d().d0;
        RecyclerView r13 = this.b;
        if (r13 == null) goto L14;
        RecyclerView.Adapter r14 = r13.getAdapter();
    L16:
        if ((r14 instanceof ICardAdapter) == false) goto L18;
        ICardAdapter r15 = (ICardAdapter) r14;
    L19:
        if (r15 == null) goto L24;
        String r16 = r15.getCommentId(this.a);
        if (r16 == null) goto L24;
        r0 = r16;
    L24:
        String r17 = this.a.getReply_id();
        Pair[] r18 = new Pair[2];
        if (this.d.d().V == false) goto L27;
        String r19 = "discussion";
    L28:
        r18[0] = TuplesKt.to(ResourceData.KEY_TYPE, r19);
        RecyclerView r20 = this.b;
        if (r20 == null) goto L31;
        RecyclerView.Adapter r21 = r20.getAdapter();
    L33:
        if ((r21 instanceof ICardAdapter) == false) goto L35;
        ICardAdapter r22 = (ICardAdapter) r21;
    L36:
        if (r22 == null) goto L42;
        CommentBean r23 = r22.getData();
        if (r23 == null) goto L42;
        CommentBean.Extra r24 = r23.getExtra();
        if (r24 == null) goto L42;
        r2 = r24.getReportVisibility();
    L42:
        r18[1] = TuplesKt.to("comment_visible_range", r2);
        r12.g("show_original_click", r0, r17, MapsKt.mapOf(r18));
        Map<String, Boolean> r25 = nf5.a.a;
        Map<String, Boolean> r26 = nf5.a.a;
        r26.put(this.a.getReply_id(), Boolean.valueOf(!Intrinsics.areEqual(((LinkedHashMap) r26).get(this.a.getReply_id()), Boolean.TRUE)));
        RecyclerView r27 = this.b;
        if (r27 == null) goto L70;
        RecyclerView.Adapter r28 = r27.getAdapter();
        if (r28 == null) goto L71;
        r28.notifyItemChanged(this.c.getLayoutPosition(), nf5.a.b);
        return;
    L71:
        return;
    L70:
        return;
    L35:
        r22 = null;
        goto L36
    L31:
        r21 = null;
        goto L33
    L27:
        r19 = "comment";
        goto L28
    L18:
        r15 = null;
        goto L19
    L14:
        r14 = null;
        goto L16
    L10:
        if (Intrinsics.areEqual(this.a.getTranslate_status(), "error") == true) goto L11;
    }
}
