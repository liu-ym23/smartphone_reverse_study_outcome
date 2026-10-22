package com.bytedance.awemeopen.apps.framework.utils;

import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r8, String r9, String r10, String r11, Map r12) {
        Intrinsics.checkNotNullParameter(r8, "aid");
        Intrinsics.checkNotNullParameter(r9, "content");
        Intrinsics.checkNotNullParameter(r10, "wordsSource");
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put("group_id", r8);
        r3.put("words_content", r9);
        r3.put("is_douyin_sdk", CommentScene.COMMENTSCENE_NO_AWEME);
        r3.put("words_source", r10);
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        r3.put("refresh_reason", r11);
        r3.putAll(r12);
        AosEventReporter.s(AosEventReporter.a, "trending_words_click", r3, null, null, null, 28);
    }
}
