package com.bytedance.ee.bear.middleground.comment.export;

import android.text.TextUtils;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentAction;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.util.ui.RecyclerItemsDiff;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class CommentDiffUtils {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(final ICardAdapter r1, final Integer r2) {
        if (r1 == null) goto L7;
        if (r2 == null) goto L7;
        DiffUtil.calculateDiff(new CommentDiffUtils$diffEditStatus$1(r1, r2)).dispatchUpdatesTo((RecyclerView.Adapter) r1);
        return;
    L7:
        tt5.a.k("", "diffEditStatus cardAdapter is null");
    }

    public static boolean c(ICardAdapter r4, CommentBean.CommentDetail r5) {
        if (r4.getUiState() == null) goto L23;
        if (r5 == null) goto L23;
        String r2 = null;
        if (r5.isEditStatus() != true) goto L16;
        w r0 = r4.getUiState();
        if (r0 == null) goto L11;
        String r1 = r0.a;
    L13:
        if (TextUtils.equals(r1, r5.getReply_id()) == true) goto L16;
        return true;
    L11:
        r1 = null;
    L16:
        if (r5.isEditStatus() == true) goto L23;
        w r6 = r4.getUiState();
        if (r6 == null) goto L21;
        r2 = r6.a;
    L21:
        if (TextUtils.equals(r2, r5.getReply_id()) == false) goto L23;
        return true;
    L23:
        return false;
    }

    public static void a(CardAdapter2 r16, com.bytedance.ee.bear.middleground.comment.uitls.p r17, CommentBean r18, boolean r19, boolean r20, String r21, boolean r22) {
        Intrinsics.checkNotNullParameter(r17, "config");
        Intrinsics.checkNotNullParameter(r18, "commentBean");
        Intrinsics.checkNotNullParameter(r21, "currentAnimReplyId");
        if (r16 != null) goto L5;
        return;
    L5:
        List<String> r1 = null;
        if (r22 == false) goto L18;
        CommentBean r2 = r16.getData();
        if (r2 == null) goto L12;
        CommentBean.Extra r3 = r2.getExtra();
        if (r3 == null) goto L12;
        Integer r4 = Integer.valueOf(r3.getVisibility());
    L13:
        CommentBean.Extra r5 = r18.getExtra();
        if (r5 == null) goto L16;
        Integer r6 = Integer.valueOf(r5.getVisibility());
    L17:
        boolean r13 = Intrinsics.areEqual(r4, r6);
    L19:
        CommentBean r7 = r16.getData();
        if (r7 == null) goto L22;
        Boolean r8 = Boolean.valueOf(r7.isCanPerformAction());
    L23:
        boolean r9 = !Intrinsics.areEqual(r8, Boolean.valueOf(r18.isCanPerformAction()));
        CommentBean r10 = r16.getData();
        if (r10 == null) goto L26;
        r1 = r10.getParticipantList();
    L26:
        boolean r11 = Intrinsics.areEqual(r1, r18.getParticipantList());
        CommentBean r12 = r16.getData();
        CommentAction r14 = CommentAction.QUOTE_MORE;
        if (r12.isActionBlocked(r14) != r18.isActionBlocked(r14)) goto L29;
        boolean r15 = true;
    L30:
        RecyclerItemsDiff r23 = new RecyclerItemsDiff(r16.getCommentDetails(), r18.getComment_list(), new c(r16, r17, r19, r13, r15, r21, r9, r11));
        r23.d = new b(r16, r17, r20, r21, r13, r15);
        DiffUtil.calculateDiff(r23, false).dispatchUpdatesTo(r16);
        r16.setData(r18);
        return;
    L29:
        r15 = false;
        goto L30
    L22:
        r8 = null;
        goto L23
    L16:
        r6 = null;
    L12:
        r4 = null;
        goto L13
    L18:
        r13 = true;
        goto L19
    }
}
