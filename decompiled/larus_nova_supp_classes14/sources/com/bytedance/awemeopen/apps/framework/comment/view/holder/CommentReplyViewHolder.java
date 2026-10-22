package com.bytedance.awemeopen.apps.framework.comment.view.holder;

import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import com.bytedance.awemeopen.apps.framework.comment.CommentPageParam;
import com.bytedance.awemeopen.apps.framework.comment.j;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import o14.a;
import sy3.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/view/holder/CommentReplyViewHolder;", "Lcom/bytedance/awemeopen/apps/framework/comment/view/holder/BaseCommentViewHolder;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class CommentReplyViewHolder extends BaseCommentViewHolder {
    @Override // com.bytedance.awemeopen.apps.framework.comment.view.holder.BaseCommentViewHolder
    public final String U3() {
        a r0 = this.m;
        Intrinsics.checkNotNull(r0);
        String r1 = r0.l();
        if (r1 != null) goto L5;
    L9:
        a r2 = this.m;
        Intrinsics.checkNotNull(r2);
        r2.w(r1);
        a r3 = this.m;
        Intrinsics.checkNotNull(r3);
        Intrinsics.checkNotNullParameter(r3, "<this>");
        String r4 = r3.l();
        if (r4 != null) goto L12;
        r4 = "";
    L12:
        StringBuilder r5 = new StringBuilder(r4);
        if (TextUtils.isEmpty(r3.k()) == false) goto L15;
    L21:
        boolean r6 = false;
    L22:
        if (r6 == false) goto L25;
        r5.insert(0, y54.a.a().getString(2131894165, new Object[]{r3.k()}));
    L25:
        return r5.toString();
    L15:
        if (TextUtils.isEmpty(r3.j()) == true) goto L21;
        if (TextUtils.equals(r3.j(), "0") == true) goto L21;
        if (r3.a() != null) goto L21;
        r6 = true;
        goto L22
    L5:
        if (StringsKt.endsWith$default(r1, "[图片表情]", false, 2, null) == false) goto L9;
        a r7 = this.m;
        Intrinsics.checkNotNull(r7);
        if (r7.e() == null) goto L9;
        r1 = r1.substring(0, r1.length() - 6);
        goto L9
    }

    public CommentReplyViewHolder(View r2, j r3, CommentPageParam r4, i r5) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r4, "pageParam");
        Intrinsics.checkNotNullParameter(r5, "commentViewConfig");
        super(r2, r3, r4, r5);
        Resources r6 = Resources.getSystem();
        MathKt.roundToInt(TypedValue.applyDimension(1, 18, WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics())));
        if (Build.VERSION.SDK_INT < 23) goto L6;
        this.i.setBreakStrategy(0);
        return;
    }
}
