package com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.adapter;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B-\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/widgets/floatwindow/pannel/adapter/ScrollingLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ScrollingLinearLayoutManager extends LinearLayoutManager {
    public boolean a;

    public final boolean canScrollHorizontally() {
        if (this.a == true) goto L5;
    L7:
        return false;
    L5:
        if (super.canScrollHorizontally() == false) goto L7;
        return true;
    }

    public final boolean canScrollVertically() {
        if (this.a == true) goto L5;
    L7:
        return false;
    L5:
        if (super.canScrollVertically() == false) goto L7;
        return true;
    }

    public ScrollingLinearLayoutManager(Context r2) {
        super(r2, 0, false);
        this.a = true;
    }

    public ScrollingLinearLayoutManager(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        this.a = true;
    }
}
