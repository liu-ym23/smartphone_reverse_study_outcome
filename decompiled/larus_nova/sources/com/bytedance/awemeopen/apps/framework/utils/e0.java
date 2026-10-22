package com.bytedance.awemeopen.apps.framework.utils;

import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f197694a = 0;

    static {
    }

    public static void a(String r100, String r101, String r110, String r111, Map r112) {
        Intrinsics.checkNotNullParameter(r100, "aid");
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r110, "wordsSource");
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("group_id", r100);
        r102.put("words_content", r101);
        r102.put("is_douyin_sdk", "1");
        r102.put("words_source", r110);
        if (r111 != null) goto L5;
        r111 = "";
    L5:
        r102.put("refresh_reason", r111);
        r102.putAll(r112);
        AosEventReporter.s(AosEventReporter.f194596a, "trending_words_click", r102, null, null, null, 28);
    }
}
