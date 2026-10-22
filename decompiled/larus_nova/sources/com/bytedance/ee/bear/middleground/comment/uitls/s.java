package com.bytedance.ee.bear.middleground.comment.uitls;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.Reaction;
import com.bytedance.ee.bear.middleground.comment.export.bean.ReactionDetailUserInfo;
import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import com.larus.nova.R;
import com.ss.android.lark.reaction.widget.detailwindow.bean.DetailUserInfo;
import com.ss.android.lark.reaction.widget.detailwindow.bean.ReactionDetailViewModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, Integer> f232251a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f232252b = null;

    public static final class a {
        public a() {
        }

        public final int a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "menuId");
            return s.a(r100);
        }
    }

    static {
        HashMap<String, Integer> r100 = new HashMap();
        f232251a = r100;
        r100.put("COPY", Integer.valueOf(R.drawable.ud_icon_copy_outlined));
        r100.put("EDIT", Integer.valueOf(R.drawable.ud_icon_edit_outlined));
        r100.put("DELETE", Integer.valueOf(R.drawable.ud_icon_delete_trash_outlined));
        r100.put("RESOLVE", Integer.valueOf(R.drawable.ud_icon_yes_outlined));
        r100.put("TRANSLATE", Integer.valueOf(R.drawable.ud_icon_translate_outlined));
        r100.put("REPLY", Integer.valueOf(R.drawable.ud_icon_reply_cn_outlined));
        r100.put("COPY_LINK", Integer.valueOf(R.drawable.ud_icon_link_copy_outlined));
        r100.put("SEND_IM", Integer.valueOf(R.drawable.ud_icon_share_outlined));
        r100.put("UPDATE_VISIBILITY", Integer.valueOf(R.drawable.ud_icon_set_visibility_outlined));
        r100.put("RELATED_KNOWLEDGE", Integer.valueOf(R.drawable.ud_icon_meeting_ai_outlined));
        r100.put(OpenNetMethod.REPORT, Integer.valueOf(R.drawable.ud_icon_warn_report_outlined));
        f232252b = new a();
    }

    public static int a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "menuId");
        HashMap<String, Integer> r101 = f232251a;
        if (r101.containsKey(r100) == false) goto L5;
        Integer r102 = r101.get(r100);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Int");
        return r102.intValue();
    L5:
        return -1;
    }

    public static List b(List r110) {
        ArrayList r100 = new ArrayList();
        if (r110 == null) goto L14;
        Iterator r111 = r110.iterator();
    L6:
        if (r111.hasNext() == false) goto L14;
        Reaction r101 = (Reaction) r111.next();
        ReactionDetailViewModel r102 = new ReactionDetailViewModel();
        r102.setReactionKey(r101.getReactionKey());
        r102.setTotalCount(r101.getTotalCount());
        r102.setUserInfoList(new ArrayList());
        List<ReactionDetailUserInfo> r103 = r101.getUserList();
        if (r103 == null) goto L13;
        Iterator<T> r104 = r103.iterator();
    L11:
        if (r104.hasNext() == false) goto L13;
        ReactionDetailUserInfo r105 = (ReactionDetailUserInfo) r104.next();
        DetailUserInfo r112 = new DetailUserInfo(r105.getAvatarKey(), r105.getAvatarUrl(), r105.getUserName(), r105.getUserId(), r105.isRegistered(), r105.getDescription(), r105.getDescType(), r105.getWorkStatusDesc());
        r102.getUserInfoList().add(r112);
    L13:
        r100.add(r102);
    L14:
        return r100;
    }

    public static void c(CommentBean.CommentDetail r210, List r211, String r212, String r213) {
        Intrinsics.checkNotNullParameter(r210, "commentDetail");
        if (r211 != null) goto L5;
        List r100 = new ArrayList();
    L6:
        ArrayList r101 = new ArrayList();
        ArrayList r102 = new ArrayList();
        r210.setFull(true);
        Iterator r103 = CollectionsKt.filterNotNull(r100).iterator();
    L8:
        if (r103.hasNext() == false) goto L16;
        Reaction r104 = (Reaction) r103.next();
        q2c.c r105 = new q2c.c();
        r105.f531474a = r104.getReactionKey();
        r105.f531475b = r104.getTotalCount();
        ArrayList r106 = new ArrayList();
        ArrayList r107 = new ArrayList();
        Iterator r108 = CollectionsKt.filterNotNull(r104.getUserList()).iterator();
    L11:
        if (r108.hasNext() == false) goto L13;
        ReactionDetailUserInfo r109 = (ReactionDetailUserInfo) r108.next();
        r106.add(new q2c.d(r109.getUserId(), r109.getUserName()));
        r107.add(new DetailUserInfo(r109.getAvatarKey(), r109.getAvatarUrl(), r109.getUserName(), r109.getUserId(), r109.isRegistered(), r109.getDescription(), r109.getDescType(), r109.getWorkStatusDesc()));
        goto L11
    L13:
        r105.f531476c = r106;
        r101.add(r105);
        ReactionDetailViewModel r110 = new ReactionDetailViewModel();
        r110.setReactionKey(r104.getReactionKey());
        r110.setTotalCount(r104.getTotalCount());
        r110.setUserInfoList(r107);
        r102.add(r110);
        if (r104.getTotalCount() == r104.getUserList().size()) goto L8;
        r210.setFull(false);
        goto L8
    L16:
        r210.setReactionFlowData(r101);
        r210.setReactionDetailData(r102);
        r210.setReaction_type(r212);
        r210.setReferKey(r213);
        r210.setReaction(r211);
        return;
    L5:
        r100 = r211;
        goto L6
    }
}
