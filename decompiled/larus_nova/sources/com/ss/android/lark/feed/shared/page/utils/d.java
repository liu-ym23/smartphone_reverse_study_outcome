package com.ss.android.lark.feed.shared.page.utils;

import com.ss.android.lark.feed.app.entity.UIFeedCard;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f421459a = 0;

    static {
    }

    @JvmStatic
    public static final boolean a(UIFeedCard r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (0 == r100.getOnTopRankTime()) goto L5;
        return true;
    L5:
        return false;
    }
}
