package com.ss.android.lark.feed.shared.page.utils;

import com.bytedance.lark.pb.feed.v1.ThreadData;

/* JADX INFO: loaded from: classes35.dex */
public final /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f421458a = null;

    static {
        int[] r100 = new int[ThreadData.EntityType.values().length];
        r100[ThreadData.EntityType.THREAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L11:
        r100[ThreadData.EntityType.TOPIC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L15:
        r100[ThreadData.EntityType.MSG_THREAD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L6:
        f421458a = r100;
    }
}
