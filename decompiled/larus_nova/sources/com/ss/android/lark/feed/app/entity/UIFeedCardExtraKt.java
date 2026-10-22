package com.ss.android.lark.feed.app.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"FRONT", "", "BEHIND", "EQUALS", "NOT_ON_TOP", "", "isOnTop", "", "Lcom/ss/android/lark/feed/app/entity/UIFeedCard;", "feed-export_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class UIFeedCardExtraKt {
    public static final int BEHIND = 1;
    public static final int EQUALS = 0;
    public static final int FRONT = -1;
    public static final long NOT_ON_TOP = 0;

    public static final boolean isOnTop(UIFeedCard r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (0 == r100.getOnTopRankTime()) goto L5;
        return true;
    L5:
        return false;
    }
}
