package com.bytedance.android.shopping.store.home.view;

import com.bytedance.android.shopping.store.home.entity.ToolType;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentPublishScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f {
    public static final String a(ToolType r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$toEventValue");
        int r2 = e.a[r1.ordinal()];
        if (r2 != 1) goto L5;
        return "service";
    L5:
        if (r2 != 2) goto L7;
        return "share";
    L7:
        if (r2 != 3) goto L9;
        return "cart";
    L9:
        if (r2 != 4) goto L11;
        return "order";
    L11:
        if (r2 == 5) goto L13;
        return CommentPublishScene.UNKNOWN;
    L13:
        return "coupon_entrance";
    }
}
