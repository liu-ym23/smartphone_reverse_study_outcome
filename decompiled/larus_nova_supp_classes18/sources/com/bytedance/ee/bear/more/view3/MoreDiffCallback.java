package com.bytedance.ee.bear.more.view3;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.ee.bear.more.protocol3.i;
import com.bytedance.ee.bear.more.protocol3.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/more/view3/MoreDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "olds", "Lcom/bytedance/ee/bear/more/protocol3/MoreUIList;", "news", "<init>", "(Lcom/bytedance/ee/bear/more/protocol3/MoreUIList;Lcom/bytedance/ee/bear/more/protocol3/MoreUIList;)V", "getOlds", "()Lcom/bytedance/ee/bear/more/protocol3/MoreUIList;", "getNews", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "getChangePayload", "", "Companion", "features-more_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MoreDiffCallback extends DiffUtil.Callback {
    public final i a;
    public final i b;

    public static final class a {
    }

    static {
    }

    public final int getNewListSize() {
        return this.b.a.size();
    }

    public final int getOldListSize() {
        return this.a.a.size();
    }

    public MoreDiffCallback(i r2, i r3) {
        Intrinsics.checkNotNullParameter(r2, "olds");
        Intrinsics.checkNotNullParameter(r3, "news");
        this.a = r2;
        this.b = r3;
    }

    public final boolean areContentsTheSame(int r3, int r4) {
        k r5 = this.a.a(r3);
        k r6 = this.b.a(r4);
        if (Intrinsics.areEqual(r5.getClass(), r6.getClass()) == true) goto L5;
        return false;
    L5:
        if (r5 != r6) goto L7;
    L8:
        return true;
    L7:
        if (r5.f(r6) == true) goto L8;
        return false;
    }

    public final boolean areItemsTheSame(int r2, int r3) {
        return Intrinsics.areEqual(this.a.a(r2).a, this.b.a(r3).a);
    }

    public final Object getChangePayload(int r1, int r2) {
        return 0;
    }
}
