package com.ss.android.lark.flow.feed.utils;

import android.content.Context;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.feed.shared.page.constant.FeedConstants$FeedErrorCode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f423630a = 0;

    static {
    }

    public static void a(Context r100, FeedCard.Type r101, String r102, Integer r103) {
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "id");
        b.d("PendingDeleteFeedErrorHandler", "handle pending delete feed, type=" + r101 + ", id=" + r102 + ", errCode=" + r103);
        int r104 = FeedConstants$FeedErrorCode.ERROR_OPERATION_TO_PENDING_DELETE_FEED.getErrorCode();
        Integer r105 = Integer.valueOf(R.drawable.icon_flow_toast_warning);
        if (r103 != null) goto L6;
    L7:
        int r106 = FeedConstants$FeedErrorCode.ERROR_OPERATION_TO_PENDING_DELETE_FEED_SERVER_CODE.getErrorCode();
        if (r103 != null) goto L11;
    L12:
        if (r103 != null) goto L15;
    L17:
        c.a(r100, R.string.LarkIM_Common_NetworkErrorRetry_Toast, r105);
        return;
    L15:
        if (r103.intValue() != 4007) goto L17;
    L18:
        c.a(r100, R.string.LarkIM_Feed_ChatNoExist_Toast, r105);
        return;
    L11:
        if (r103.intValue() == r106) goto L18;
    L6:
        if (r103.intValue() == r104) goto L18;
        goto L7
    }
}
