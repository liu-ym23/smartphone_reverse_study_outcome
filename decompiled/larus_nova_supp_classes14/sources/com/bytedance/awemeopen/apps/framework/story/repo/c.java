package com.bytedance.awemeopen.apps.framework.story.repo;

import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.awemeopen.domain.base.repo.ConstantsKt;
import com.bytedance.awemeopen.domain.base.repo.GsonHolder;
import com.bytedance.awemeopen.domain.base.repo.e;
import com.bytedance.awemeopen.infra.base.net.AoNet;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public static final String a = null;
    public static final String b = null;

    static {
        String r0 = ConstantsKt.a();
        a = r0 + "/aweme/open/export_sdk/user_item_list";
        b = r0 + "/aweme/open/export_sdk/item/seen";
    }

    public static e a(Long r4, String r5, long r6, long r8, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "userOpenId");
        d r1 = null;
        LinkedHashMap r2 = new LinkedHashMap();     // Catch: Throwable -> L21
        if (r10 == false) goto L6;
        String r11 = CommentScene.COMMENTSCENE_NO_AWEME;
    L7:
        r2.put("need_live", r11);     // Catch: Throwable -> L21
        if (r4 == null) goto L10;
        r4.longValue();     // Catch: Throwable -> L21
        r2.put("room_id", r4);     // Catch: Throwable -> L21
    L10:
        r2.put("user_open_id", r5);     // Catch: Throwable -> L21
        r2.put(UploadTypeInf.COUNT, Long.valueOf(r6));     // Catch: Throwable -> L21
        r2.put("cursor", Long.valueOf(r8));     // Catch: Throwable -> L21
        int r7 = com.bytedance.awemeopen.domain.base.repo.b.b;     // Catch: Throwable -> L21
        Pair r9 = AoNet.c(com.bytedance.awemeopen.domain.base.repo.b.a.a(a, r2));     // Catch: Throwable -> L21
        CharSequence r12 = (CharSequence) r9.getFirst();     // Catch: Throwable -> L21
        if (r12 != null) goto L13;
    L16:
        boolean r13 = true;
    L17:
        if (r13 == true) goto L19;
        Exception r14 = null;
        r1 = (d) GsonHolder.a().fromJson((String) r9.getFirst(), d.class);     // Catch: Throwable -> L21
    L24:
        return new e(r1, r14);
    L19:
        r14 = new Exception("fetchFeed but got empty body result, logid = " + ((String) r9.getSecond()));     // Catch: Throwable -> L21
        goto L24
    L13:
        if (r12.length() == 0) goto L16;
        r13 = false;
        goto L17
    L6:
        r11 = "0";
    L21:
        th = move-exception;
        r14 = new Exception(th);
        goto L24
    }
}
