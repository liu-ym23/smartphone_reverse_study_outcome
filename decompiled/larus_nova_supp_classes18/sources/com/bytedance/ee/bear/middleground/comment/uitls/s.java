package com.bytedance.ee.bear.middleground.comment.uitls;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.Reaction;
import com.bytedance.ee.bear.middleground.comment.export.bean.ReactionDetailUserInfo;
import com.ss.android.lark.reaction.widget.detailwindow.bean.DetailUserInfo;
import com.ss.android.lark.reaction.widget.detailwindow.bean.ReactionDetailViewModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s {
    public static final HashMap<String, Integer> a = null;
    public static final a b = null;

    public static final class a {
        public a() {
        }

        public final int a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "menuId");
            return s.a(r2);
        }
    }

    static {
        HashMap<String, Integer> r0 = new HashMap();
        a = r0;
        r0.put("COPY", 2131254165);
        r0.put("EDIT", 2131254285);
        r0.put("DELETE", 2131254201);
        r0.put("RESOLVE", 2131256306);
        r0.put("TRANSLATE", 2131256049);
        r0.put("REPLY", 2131255541);
        r0.put("COPY_LINK", 2131255013);
        r0.put("SEND_IM", 2131255656);
        r0.put("UPDATE_VISIBILITY", 2131255646);
        r0.put("RELATED_KNOWLEDGE", 2131255092);
        r0.put("REPORT", 2131256182);
        b = new a();
    }

    public static int a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "menuId");
        HashMap<String, Integer> r0 = a;
        if (r0.containsKey(r2) == false) goto L5;
        Integer r3 = r0.get(r2);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Int");
        return r3.intValue();
    L5:
        return -1;
    }

    public static List b(List r14) {
        ArrayList r0 = new ArrayList();
        if (r14 == null) goto L14;
        Iterator r15 = r14.iterator();
    L6:
        if (r15.hasNext() == false) goto L14;
        Reaction r1 = (Reaction) r15.next();
        ReactionDetailViewModel r2 = new ReactionDetailViewModel();
        r2.setReactionKey(r1.getReactionKey());
        r2.setTotalCount(r1.getTotalCount());
        r2.setUserInfoList(new ArrayList());
        List<ReactionDetailUserInfo> r3 = r1.getUserList();
        if (r3 == null) goto L13;
        Iterator<T> r4 = r3.iterator();
    L11:
        if (r4.hasNext() == false) goto L13;
        ReactionDetailUserInfo r5 = (ReactionDetailUserInfo) r4.next();
        DetailUserInfo r13 = new DetailUserInfo(r5.getAvatarKey(), r5.getAvatarUrl(), r5.getUserName(), r5.getUserId(), r5.isRegistered(), r5.getDescription(), r5.getDescType(), r5.getWorkStatusDesc());
        r2.getUserInfoList().add(r13);
    L13:
        r0.add(r2);
    L14:
        return r0;
    }

    public static void c(CommentBean.CommentDetail r22, List r23, String r24, String r25) {
        Intrinsics.checkNotNullParameter(r22, "commentDetail");
        if (r23 != null) goto L5;
        List r1 = new ArrayList();
    L6:
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        r22.setFull(true);
        Iterator r4 = CollectionsKt.filterNotNull(r1).iterator();
    L8:
        if (r4.hasNext() == false) goto L16;
        Reaction r5 = (Reaction) r4.next();
        q2c.c r6 = new q2c.c();
        r6.a = r5.getReactionKey();
        r6.b = r5.getTotalCount();
        ArrayList r7 = new ArrayList();
        ArrayList r8 = new ArrayList();
        Iterator r9 = CollectionsKt.filterNotNull(r5.getUserList()).iterator();
    L11:
        if (r9.hasNext() == false) goto L13;
        ReactionDetailUserInfo r10 = (ReactionDetailUserInfo) r9.next();
        r7.add(new q2c.d(r10.getUserId(), r10.getUserName()));
        r8.add(new DetailUserInfo(r10.getAvatarKey(), r10.getAvatarUrl(), r10.getUserName(), r10.getUserId(), r10.isRegistered(), r10.getDescription(), r10.getDescType(), r10.getWorkStatusDesc()));
        goto L11
    L13:
        r6.c = r7;
        r2.add(r6);
        ReactionDetailViewModel r11 = new ReactionDetailViewModel();
        r11.setReactionKey(r5.getReactionKey());
        r11.setTotalCount(r5.getTotalCount());
        r11.setUserInfoList(r8);
        r3.add(r11);
        if (r5.getTotalCount() == r5.getUserList().size()) goto L8;
        r22.setFull(false);
        goto L8
    L16:
        r22.setReactionFlowData(r2);
        r22.setReactionDetailData(r3);
        r22.setReaction_type(r24);
        r22.setReferKey(r25);
        r22.setReaction(r23);
        return;
    L5:
        r1 = r23;
        goto L6
    }
}
