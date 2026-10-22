package com.story.ai.biz.comment.model;

import android.text.TextUtils;
import com.larus.platform.model.comment.CommentInfo;
import com.larus.platform.model.comment.UserInfo;
import com.larus.platform.service.AccountService;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {
    public static final CommentListItem b(CommentInfo r100, long r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "curCreatorId");
        CommentListItem r104 = new CommentListItem();
        r104.setCommentData(r100);
        List<Integer> r105 = r100.r();
        boolean r106 = false;
        if (r105 != null) goto L5;
    L7:
        boolean r107 = false;
    L8:
        r104.setPin(r107);
        UserInfo r108 = r100.h();
        String r109 = null;
        if (r108 == null) goto L11;
        String r110 = r108.c();
    L12:
        r104.setCreator(Intrinsics.areEqual(r110, r102));
        if (r104.isCreator() == true) goto L20;
        String r111 = AccountService.f365697a.getUserId();
        UserInfo r112 = r100.h();
        if (r112 == null) goto L18;
        r109 = r112.c();
    L18:
        if (Intrinsics.areEqual(r111, r109) == false) goto L20;
        r106 = true;
    L20:
        r104.setSelfComment(r106);
        long r113 = 0;
        if (r101 <= 0) goto L32;
        Long r114 = r100.g();
        if (r114 == null) goto L25;
        long r115 = r114.longValue();
    L27:
        if (r115 <= 0) goto L32;
        long r116 = 1000;
        Long r117 = r100.g();
        if (r117 == null) goto L31;
        r113 = r117.longValue();
    L31:
        Long.signum(r116);
        r113 = r101 - (r116 * r113);
        goto L32
    L25:
        r115 = 0;
    L32:
        r104.setServerTimeDelta(r113);
        r104.setCacheData(r103);
        return r104;
    L11:
        r110 = null;
        goto L12
    L5:
        if (r105.contains(1) != true) goto L7;
        r107 = true;
        goto L8
    }

    public static final ChildCommentItem a(CommentInfo r100, CommentListItem r101, long r102, String r103, boolean r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "parentComment");
        Intrinsics.checkNotNullParameter(r103, "curCreatorId");
        ChildCommentItem r104 = new ChildCommentItem();
        r104.setParentCommentItem(r101);
        r104.setReplyCommentUserInfo(r100.k());
        r104.setReplyParentComment(TextUtils.isEmpty(r100.q()));
        r104.setResident(r111);
        r104.setCommentData(r100);
        List<Integer> r105 = r100.r();
        boolean r112 = false;
        if (r105 != null) goto L5;
    L7:
        boolean r106 = false;
    L8:
        r104.setPin(r106);
        UserInfo r107 = r100.h();
        String r108 = null;
        if (r107 == null) goto L11;
        String r109 = r107.c();
    L12:
        r104.setCreator(Intrinsics.areEqual(r109, r103));
        if (r104.isCreator() == true) goto L20;
        String r113 = AccountService.f365697a.getUserId();
        UserInfo r114 = r100.h();
        if (r114 == null) goto L18;
        r108 = r114.c();
    L18:
        if (Intrinsics.areEqual(r113, r108) == false) goto L20;
        r112 = true;
    L20:
        r104.setSelfComment(r112);
        long r115 = 0;
        if (r102 <= 0) goto L32;
        Long r116 = r100.g();
        if (r116 == null) goto L25;
        long r117 = r116.longValue();
    L27:
        if (r117 <= 0) goto L32;
        long r118 = 1000;
        Long r119 = r100.g();
        if (r119 == null) goto L31;
        r115 = r119.longValue();
    L31:
        Long.signum(r118);
        r115 = r102 - (r118 * r115);
        goto L32
    L25:
        r117 = 0;
    L32:
        r104.setServerTimeDelta(r115);
        r104.setCacheData(r110);
        r104.setRealCreatorId(r103);
        return r104;
    L11:
        r109 = null;
        goto L12
    L5:
        if (r105.contains(1) != true) goto L7;
        r106 = true;
        goto L8
    }
}
