package com.bytedance.ee.bear.middleground.like.export;

import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class a {
    public static boolean b(LikeUserList r100) {
        if (r100 != null) goto L5;
    L20:
        tt5.a.d("LikeUtils", "likeUserList is null");
        return false;
    L5:
        if (r100.getIds() == null) goto L20;
        if (r100.getLikes() == null) goto L20;
        if (r100.getUsers() == null) goto L20;
        if (r100.getIds().size() == r100.getUsers().size()) goto L14;
    L18:
        tt5.a.d("LikeUtils", "likeUserList size is not correct");
        return false;
    L14:
        if (r100.getIds().size() != r100.getLikes().size()) goto L18;
        return true;
    }

    public static String a(LikeUserList r100, int r101) {
        String r102 = (String) ListProtector.get(r100.getIds(), r101);
        LikesBean r103 = r100.getLikes().get(r102);
        if (r103 == null) goto L8;
        String r104 = r103.getUser_id();
        UsersBean r105 = r100.getUsers().get(r104);
        if (r105 != null) goto L7;
        return "";
    L7:
        return r105.getAvatar_url();
    L8:
        return "";
    }
}
