package com.ss.android.lark.feed.shared.data.appconfig;

import com.ss.android.lark.biz.im.api.FeedCard;
import kotlin.Lazy;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final boolean a(FeedCard.Type r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Lazy r101 = FeedClearBadgeConfig.f421136a;
        Boolean r102 = ((FeedClearBadgeConfigValue) FeedClearBadgeConfig.f421136a.getValue()).getFeedEntitySwitchMap().get(String.valueOf(r100.getNumber()));
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.booleanValue();
    }
}
