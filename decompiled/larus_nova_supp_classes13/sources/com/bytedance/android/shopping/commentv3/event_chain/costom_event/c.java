package com.bytedance.android.shopping.commentv3.event_chain.costom_event;

import android.content.Context;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentParams;
import com.bytedance.android.shopping.commentv3.action.ActionType;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends com.bytedance.android.shopping.commentv3.event_chain.a {
    public final Context d;
    public final com.bytedance.android.shopping.commentv3.data.b e;

    public c(Context r2, com.bytedance.android.shopping.commentv3.data.b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        super(ActionType.COMMENT_REPLY.getType());
        this.d = r2;
        this.e = r3;
    }

    @Override // com.bytedance.android.shopping.commentv3.event_chain.a
    public final void c(EventContext r22, fc3.a r23, fc3.c r24, Function1<? super com.bytedance.kmp.ec.yata.chain.event.b, Unit> r25) {
        Intrinsics.checkNotNullParameter(r22, "eventContext");
        Intrinsics.checkNotNullParameter(r23, "actionContext");
        Intrinsics.checkNotNullParameter(r24, "handleActionParams");
        Intrinsics.checkNotNullParameter(r25, "completion");
        Map r0 = r22.k;
        Boolean r15 = null;
        if (r0 == null) goto L5;
        Object r1 = r0.get("params");
    L7:
        if ((r1 instanceof Map) == true) goto L9;
        r1 = null;
    L9:
        Map r2 = (Map) r1;
        boolean r3 = true;
        if (r2 != null) goto L12;
    L15:
        boolean r4 = true;
    L17:
        if (r4 == false) goto L26;
        dm.a.b r5 = dm.a.a("CommentAbsCommonChainEventImpl");
        StringBuilder r6 = new StringBuilder("params invalid, ");
        if (r2 == null) goto L21;
        Boolean r7 = Boolean.valueOf(r2.isEmpty());
    L22:
        r6.append(r7);
        r5.i(r6.toString());
        int r8 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        StringBuilder r9 = new StringBuilder("params invalid, ");
        if (r2 == null) goto L25;
        r15 = Boolean.valueOf(r2.isEmpty());
    L25:
        r9.append(r15);
        com.bytedance.kmp.ec.yata.chain.event.b r10 = com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, r9.toString(), null, null, 57);
    L67:
        r25.invoke(r10);
        return;
    L21:
        r7 = null;
        goto L22
    L26:
        long r11 = nc3.a.d(r2, "comment_id");
        long r12 = nc3.a.c(r2, PdpOpenThirdParam.KEY_PRODUCT_ID, 0);
        if (r11 > 0) goto L29;
    L66:
        dm.a.a("CommentAbsCommonChainEventImpl").i("commentId or productId invalid, commentId: " + r11 + ", productId: " + r12);
        int r13 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r10 = com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "commentId or productId invalid, commentId: " + r11 + ", productId: " + r12, null, null, 57);
        goto L67
    L29:
        if (r12 <= 0) goto L66;
        boolean r14 = Intrinsics.areEqual(nc3.a.e(r2, "isAuthor", null), "1");
        long r16 = nc3.a.c(r2, "reply_count", 0);
        boolean r17 = Intrinsics.areEqual(nc3.a.e(r2, "can_reply", null), "1");
        boolean r18 = Intrinsics.areEqual(nc3.a.e(r2, "from_exposure", null), "1");
        String r19 = nc3.a.e(r2, "user_name", null);
        String r110 = "";
        if (r19 != null) goto L34;
        String r111 = "";
    L35:
        String r20 = nc3.a.e(r2, "slice_id", null);
        if (r20 == null) goto L39;
        r110 = r20;
    L39:
        if (r18 == false) goto L64;
        CommentParams r21 = this.e.a;
        if (r21 == null) goto L43;
        Long r26 = r21.getReplyCid();
    L44:
        CommentParams r27 = this.e.a;
        if (r27 == null) goto L47;
        List r28 = r27.getHighlightReplyCid();
    L48:
        if (r26 != null) goto L50;
    L65:
        int r29 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r10 = com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
        goto L67
    L50:
        if (r26.longValue() <= 0) goto L65;
        List r30 = r28;
        if (r30 != null) goto L54;
    L57:
        if (r3 == true) goto L65;
        d(r26.longValue(), r12, r14, r16, r17, r24, r111, r110, r23);
        CommentParams r31 = this.e.a;
        if (r31 == null) goto L61;
        r31.setReplyCid(null);
    L61:
        CommentParams r32 = this.e.a;
        if (r32 == null) goto L65;
        r32.setHighlightReplyCid(null);
        goto L65
    L54:
        if (r30.isEmpty() == true) goto L57;
        r3 = false;
        goto L57
    L47:
        r28 = null;
        goto L48
    L43:
        r26 = null;
        goto L44
    L64:
        d(r11, r12, r14, r16, r17, r24, r111, r110, r23);
        goto L65
    L34:
        r111 = r19;
        goto L35
    L12:
        if (r2.isEmpty() == true) goto L15;
        r4 = false;
        goto L17
    L5:
        r1 = null;
        goto L7
    }

    public final void d(final long r2, long r4, boolean r6, long r7, boolean r9, final fc3.c r10, String r11, final String r12, final fc3.a r13) {
        Function1<Long, Unit> r0 = new CommentReplyEvent$showCommentReplyPanel$replyCountObserver$1(r12, r2, r13, r10);
        int r3 = com.bytedance.android.shopping.commentv3.utils.a.a;
        Intrinsics.checkNotNullParameter(this.d, "ctx");
        Intrinsics.checkNotNullParameter(r0, "replyCountObserver");
        Intrinsics.checkNotNullParameter(r11, "userName");
    }
}
