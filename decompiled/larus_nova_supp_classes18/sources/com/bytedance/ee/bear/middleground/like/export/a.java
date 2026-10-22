package com.bytedance.ee.bear.middleground.like.export;

import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static boolean b(LikeUserList r4) {
        if (r4 != null) goto L5;
    L20:
        tt5.a.d("LikeUtils", "likeUserList is null");
        return false;
    L5:
        if (r4.getIds() == null) goto L20;
        if (r4.getLikes() == null) goto L20;
        if (r4.getUsers() == null) goto L20;
        if (r4.getIds().size() == r4.getUsers().size()) goto L14;
    L18:
        tt5.a.d("LikeUtils", "likeUserList size is not correct");
        return false;
    L14:
        if (r4.getIds().size() != r4.getLikes().size()) goto L18;
        return true;
    }

    public static String a(LikeUserList r1, int r2) {
        String r3 = (String) ListProtector.get(r1.getIds(), r2);
        LikesBean r4 = r1.getLikes().get(r3);
        if (r4 == null) goto L8;
        String r5 = r4.getUser_id();
        UsersBean r6 = r1.getUsers().get(r5);
        if (r6 != null) goto L7;
        return "";
    L7:
        return r6.getAvatar_url();
    L8:
        return "";
    }
}
