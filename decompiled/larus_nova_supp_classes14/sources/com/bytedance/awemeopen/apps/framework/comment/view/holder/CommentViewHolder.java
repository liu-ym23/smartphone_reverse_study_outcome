package com.bytedance.awemeopen.apps.framework.comment.view.holder;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import com.bytedance.awemeopen.apps.framework.comment.CommentPageParam;
import com.bytedance.awemeopen.apps.framework.comment.j;
import com.bytedance.awemeopen.bizmodels.utils.AwemeCheckUtilsKt;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import o14.a;
import sy3.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/view/holder/CommentViewHolder;", "Lcom/bytedance/awemeopen/apps/framework/comment/view/holder/BaseCommentViewHolder;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class CommentViewHolder extends BaseCommentViewHolder {
    @Override // com.bytedance.awemeopen.apps.framework.comment.view.holder.BaseCommentViewHolder
    public final String U3() {
        a r0 = this.m;
        if (r0 == null) goto L6;
        String r1 = r0.l();
        if (r1 == null) goto L6;
        return r1;
    L6:
        AwemeCheckUtilsKt.a("", null, 3);
        return "";
    }

    public CommentViewHolder(View r2, j r3, CommentPageParam r4, i r5) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r4, "pageParam");
        Intrinsics.checkNotNullParameter(r5, "commentViewConfig");
        super(r2, r3, r4, r5);
        Resources r6 = Resources.getSystem();
        MathKt.roundToInt(TypedValue.applyDimension(1, 32, WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics())));
    }
}
