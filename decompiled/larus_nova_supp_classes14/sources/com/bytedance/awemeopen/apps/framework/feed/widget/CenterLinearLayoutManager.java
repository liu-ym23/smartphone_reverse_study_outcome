package com.bytedance.awemeopen.apps.framework.feed.widget;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/widget/CenterLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class CenterLinearLayoutManager extends LinearLayoutManager {

    public static final class a extends LinearSmoothScroller {
        public a(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(r2);
        }

        public final int calculateDtToFit(int r1, int r2, int r3, int r4, int r5) {
            return (r3 + ((r4 - r3) / 2)) - (r1 + ((r2 - r1) / 2));
        }
    }

    public final void smoothScrollToPosition(RecyclerView r2, RecyclerView.State r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        Intrinsics.checkNotNullParameter(r3, "state");
        a r5 = new a(r2.getContext());
        r5.setTargetPosition(r4);
        startSmoothScroll(r5);
    }
}
